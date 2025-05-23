package com.tencent.tav.quick.export;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.decoder.Filter;
import com.tencent.tav.decoder.IVideoDecoder;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.TexturePool;
import com.tencent.tav.decoder.VideoDecoder;
import com.tencent.tav.decoder.factory.AVDecoderFactory;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import com.tencent.tav.decoder.muxer.MediaMuxerFactory;
import com.tencent.tav.quick.export.muxer.QuickMuxer;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/* compiled from: P */
/* loaded from: classes26.dex */
public class SegmentExport {
    public static final int SEGMENT_DECODE_END = 0;
    public static final int SEGMENT_DECODE_FAILED_ERROR = -3;
    public static final int SEGMENT_DECODE_INIT_ERROR = -1;
    public static final int SEGMENT_ENCODE_ERROR = -6;
    public static final int SEGMENT_ENCODE_INIT_ERROR = -4;
    public static final int SEGMENT_GET_VIDEO_FRAME_ERROR = -5;
    public static final int SEGMENT_PUT_VIDEO_FRAME_ERROR = -2;
    public static final int VIDEO_FRAME_QUEUE_SIZE = 3;
    private Asset mAsset;
    private ExportConfig mExportConfig;
    private String mInputPath;
    private String mOutputPath;
    private SegmentExportListener mSegmentExportListener;
    private final String TAG = QuickExporter.TAG + "_SegmentExport@" + Integer.toHexString(hashCode());
    private volatile boolean mDecodeEnd = false;
    private volatile boolean mEncodeEnd = false;
    private VideoDecodeThread mDecodeThread = null;
    private VideoEncodeThread mEncodeThread = null;
    private CMTimeRange mDecodeVideoRange = null;
    private TexturePool mTexturePool = new TexturePool();
    private MediaFormat mEncodeMediaFormat = null;
    private Object mMediaFormatLock = new Object();
    private OESTextureConverter oesTextureConverter = null;
    private RenderContext mEGLContext = null;
    private Object mGlCtxLock = new Object();
    private MediaMuxerFactory.MediaMuxerCreator mediaMuxerCreator = null;
    private IMediaMuxer segmentMuxer = null;
    private Object segmentMuxerLock = new Object();
    private BlockingQueue<VideoFrame> mVideoFrameQueue = new LinkedBlockingDeque(3);

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface SegmentExportListener {
        void onFirstFrameDecode(long j3);

        void onSegmentExportEnd();

        void onSegmentExportError(long j3);

        void onSegmentExportProgress(float f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class VideoDecodeThread {
        private String mInputFile;
        private SegmentExport mSegExport;
        private IVideoDecoder mVideoDecoder;
        private CMTimeRange mVideoTimeRange;
        private String TAG = QuickExporter.TAG + "_VideoDecodeThread@" + Integer.toHexString(hashCode());
        private long mFrameDuration = 33333;
        private RenderContext mDecodeGLContext = null;
        private CMSampleState mLastSampleState = new CMSampleState();
        private Object sampleStateLock = new Object();
        private BlockingQueue<CMSampleState> sampleStateQueue = new LinkedBlockingDeque(100);
        private volatile boolean mIsSegmentDecodeFailed = false;
        private Surface mOutputSurface = null;
        private boolean mIsFirstFrame = true;
        private int mOesTexture = 0;
        private SurfaceTexture mSurfaceTexture = null;
        private HandlerThread mDecoderThread = null;
        private Handler mHandler = null;
        private Thread mCurrentThread = null;

        public VideoDecodeThread(SegmentExport segmentExport, String str, CMTimeRange cMTimeRange) {
            this.mInputFile = "";
            this.mSegExport = segmentExport;
            this.mInputFile = str;
            this.mVideoTimeRange = cMTimeRange;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CMSampleBuffer createSampleBuffer(CMSampleState cMSampleState, TextureInfo textureInfo, boolean z16) {
            return new CMSampleBuffer(cMSampleState, textureInfo, z16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void decode() {
            if (!init()) {
                Logger.e(this.TAG, "Decode init failed");
                innerRelease();
                SegmentExport.this.mSegmentExportListener.onSegmentExportError(-1L);
            } else if (this.mVideoDecoder != null && this.mDecodeGLContext != null) {
                if (SegmentExport.this.oesTextureConverter == null) {
                    SegmentExport.this.oesTextureConverter = new OESTextureConverter();
                }
                this.mVideoDecoder.seekTo(this.mVideoTimeRange.getStart());
                this.mSurfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.tencent.tav.quick.export.SegmentExport.VideoDecodeThread.3
                    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                        CMTime add;
                        try {
                            if (SegmentExport.this.mDecodeEnd) {
                                Logger.i(VideoDecodeThread.this.TAG, "Decode onFrameAvailable end");
                                return;
                            }
                            surfaceTexture.updateTexImage();
                            if (VideoDecodeThread.this.mIsFirstFrame) {
                                SegmentExport.this.mSegmentExportListener.onFirstFrameDecode(VideoDecodeThread.this.mLastSampleState.getTime().getTimeUs());
                                VideoDecodeThread.this.mIsFirstFrame = false;
                            }
                            TextureInfo popTexture = SegmentExport.this.mTexturePool.popTexture(GLSLRender.GL_TEXTURE_2D, VideoDecodeThread.this.mDecodeGLContext.width(), VideoDecodeThread.this.mDecodeGLContext.height());
                            float[] fArr = new float[16];
                            surfaceTexture.getTransformMatrix(fArr);
                            SegmentExport.this.oesTextureConverter.setSTMatrix(fArr);
                            SegmentExport.this.oesTextureConverter.draw(VideoDecodeThread.this.mOesTexture, popTexture.textureID, popTexture.width, popTexture.height);
                            VideoDecodeThread videoDecodeThread = VideoDecodeThread.this;
                            CMSampleBuffer createSampleBuffer = videoDecodeThread.createSampleBuffer(videoDecodeThread.mLastSampleState, popTexture, VideoDecodeThread.this.mLastSampleState.isNewFrame());
                            long glFenceSync = GLES30.glFenceSync(37143, 0);
                            GLES20.glFlush();
                            SegmentExport.this.mVideoFrameQueue.put(new VideoFrame(createSampleBuffer, glFenceSync));
                            if (VideoDecodeThread.this.mLastSampleState.getStateCode() == -4) {
                                add = VideoDecodeThread.this.mLastSampleState.getTime();
                            } else {
                                add = VideoDecodeThread.this.mLastSampleState.getTime().add(VideoDecodeThread.this.mFrameDuration);
                            }
                            VideoDecodeThread videoDecodeThread2 = VideoDecodeThread.this;
                            videoDecodeThread2.mLastSampleState = videoDecodeThread2.mVideoDecoder.readSample(add);
                            long stateCode = VideoDecodeThread.this.mLastSampleState.getStateCode();
                            if (stateCode < 0) {
                                Logger.i(VideoDecodeThread.this.TAG, "decode state code is " + stateCode);
                                if (stateCode == -1) {
                                    SegmentExport.this.mDecodeEnd = true;
                                } else if (stateCode != -4) {
                                    SegmentExport.this.mSegmentExportListener.onSegmentExportError(-3L);
                                    VideoDecodeThread.this.mIsSegmentDecodeFailed = true;
                                    SegmentExport.this.mDecodeEnd = true;
                                }
                            }
                            if (VideoDecodeThread.this.mLastSampleState.getTime().bigThan(VideoDecodeThread.this.mVideoTimeRange.getEnd())) {
                                Logger.i(VideoDecodeThread.this.TAG, "last sample time big than range end");
                                SegmentExport.this.mDecodeEnd = true;
                            }
                            if (SegmentExport.this.mDecodeEnd) {
                                Logger.d(VideoDecodeThread.this.TAG, "decode end");
                                SegmentExport.this.mVideoFrameQueue.put(new VideoFrame(null, 0L));
                            }
                        } catch (Exception e16) {
                            Logger.e(VideoDecodeThread.this.TAG, "onFrameAvailable exception " + e16.getMessage() + ", it " + Thread.currentThread().isInterrupted());
                            VideoDecodeThread.this.innerRelease();
                            SegmentExport.this.mSegmentExportListener.onSegmentExportError(-3L);
                        }
                    }
                });
                this.mLastSampleState = this.mVideoDecoder.readSample(this.mVideoTimeRange.getStart());
            }
        }

        private boolean init() {
            boolean z16;
            RenderContext renderContext = new RenderContext((int) SegmentExport.this.mExportConfig.getOutputSize().width, (int) SegmentExport.this.mExportConfig.getOutputSize().height, (Surface) null, (EGLContext) null);
            this.mDecodeGLContext = renderContext;
            this.mSegExport.setEGLContext(renderContext);
            this.mOesTexture = RenderContext.createTexture(36197);
            this.mSurfaceTexture = new SurfaceTexture(this.mOesTexture);
            if (SegmentExport.this.mAsset.getNaturalSize() != null) {
                this.mOutputSurface = new Surface(this.mSurfaceTexture);
            }
            try {
                this.mVideoDecoder = AVDecoderFactory.getInstance().createVideoDecoder(newDecoderParams(SegmentExport.this.mAsset, this.mOutputSurface));
                Logger.d(this.TAG, "video time range start " + this.mVideoTimeRange.getStart().getTimeUs() + ", end " + this.mVideoTimeRange.getEnd().getTimeUs());
                z16 = true;
                this.mVideoDecoder.start(null, new CMTime(-1L, 1));
                this.mFrameDuration = ((VideoDecoder) this.mVideoDecoder).getFrameDurationUs();
            } catch (Exception e16) {
                Logger.e(this.TAG, "Create video decoder failed ", e16);
                z16 = false;
            }
            this.mCurrentThread = Thread.currentThread();
            return z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void innerRelease() {
            Logger.e(this.TAG, "decode innerRelease");
            if (SegmentExport.this.oesTextureConverter != null) {
                SegmentExport.this.oesTextureConverter.release();
                SegmentExport.this.oesTextureConverter = null;
            }
            SegmentExport.this.releaseFrameQueue();
            int i3 = this.mOesTexture;
            if (i3 > 0) {
                GLES20.glDeleteTextures(1, new int[]{i3}, 0);
                this.mOesTexture = 0;
            }
            if (SegmentExport.this.mTexturePool != null) {
                SegmentExport.this.mTexturePool.release();
                SegmentExport.this.mTexturePool = null;
            }
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.mSurfaceTexture = null;
            }
            Surface surface = this.mOutputSurface;
            if (surface != null) {
                surface.release();
                this.mOutputSurface = null;
            }
            IVideoDecoder iVideoDecoder = this.mVideoDecoder;
            if (iVideoDecoder != null) {
                iVideoDecoder.release(true);
                this.mVideoDecoder = null;
            }
            RenderContext renderContext = this.mDecodeGLContext;
            if (renderContext != null) {
                renderContext.release();
                this.mDecodeGLContext = null;
            }
        }

        private IVideoDecoder.Params newDecoderParams(Asset asset, Surface surface) {
            IVideoDecoder.Params params = new IVideoDecoder.Params();
            params.sourceType = 1;
            params.filePath = SegmentExport.this.mInputPath;
            params.outputSize = SegmentExport.this.mAsset.getNaturalSize();
            params.outputSurface = surface;
            params.extraInfo = asset.getExtraInfo();
            RenderContext renderContext = this.mDecodeGLContext;
            if (renderContext != null) {
                params.videoTexture = renderContext.videoTextureForSurface(surface);
            }
            return params;
        }

        public void release() {
            if (this.mCurrentThread != null && !SegmentExport.this.mDecodeEnd) {
                this.mCurrentThread.interrupt();
            }
            SegmentExport.this.mDecodeEnd = true;
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.tencent.tav.quick.export.SegmentExport.VideoDecodeThread.2
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoDecodeThread.this.innerRelease();
                    }
                });
            }
            HandlerThread handlerThread = this.mDecoderThread;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
            this.mHandler = null;
        }

        public void start() {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("decode-ht");
            this.mDecoderThread = baseHandlerThread;
            baseHandlerThread.start();
            this.mDecoderThread.setPriority(10);
            Handler handler = new Handler(this.mDecoderThread.getLooper());
            this.mHandler = handler;
            handler.post(new Runnable() { // from class: com.tencent.tav.quick.export.SegmentExport.VideoDecodeThread.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        VideoDecodeThread.this.decode();
                    } catch (Exception e16) {
                        Logger.e(VideoDecodeThread.this.TAG, "Segment video decoded error ", e16);
                        SegmentExport.this.mSegmentExportListener.onSegmentExportError(-3L);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class VideoEncodeThread {
        private RenderContext mEncodeGLContext;
        private HandlerThread mEncodeThread;
        private EncoderWriter mEncoderWriter;
        private ExportConfig mExportConfig;
        private Filter mFilter;
        private Handler mHandler;
        private String mOutputPath;
        private SegmentExport mSegExport;
        private String TAG = QuickExporter.TAG + "_VideoEncodeThread@" + Integer.toHexString(hashCode());
        private boolean mIsFirstFrame = true;
        private Thread mCurrentThread = null;

        public VideoEncodeThread(SegmentExport segmentExport, String str, ExportConfig exportConfig) {
            this.mSegExport = segmentExport;
            this.mOutputPath = str;
            this.mExportConfig = exportConfig;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void encode() {
            if (!init()) {
                innerRelease();
                SegmentExport.this.mSegmentExportListener.onSegmentExportError(-4L);
                return;
            }
            while (!SegmentExport.this.mEncodeEnd) {
                try {
                    VideoFrame videoFrame = (VideoFrame) SegmentExport.this.mVideoFrameQueue.take();
                    if (videoFrame.getSampleBuffer() == null && videoFrame.getFence() == 0) {
                        Logger.i(this.TAG, "segment encode finish");
                        this.mEncoderWriter.stop();
                        SegmentExport.this.mSegmentExportListener.onSegmentExportEnd();
                        return;
                    }
                    GLES30.glWaitSync(videoFrame.getFence(), 0, -1L);
                    CMSampleBuffer sampleBuffer = videoFrame.getSampleBuffer();
                    TextureInfo textureInfo = videoFrame.getSampleBuffer().getTextureInfo();
                    this.mFilter.setRendererWidth(this.mEncodeGLContext.width());
                    this.mFilter.setRendererHeight(this.mEncodeGLContext.height());
                    this.mFilter.setRenderForScreen(true);
                    RenderContext renderContext = this.mEncodeGLContext;
                    renderContext.updateViewport(0, 0, renderContext.width(), this.mEncodeGLContext.height());
                    this.mFilter.applyFilter(textureInfo, null, null);
                    long timeUs = sampleBuffer.getTime().getTimeUs();
                    this.mEncodeGLContext.setPresentationTime(timeUs);
                    this.mEncodeGLContext.swapBuffers();
                    this.mEncoderWriter.writeVideoSample(sampleBuffer, textureInfo);
                    if (SegmentExport.this.mSegmentExportListener != null) {
                        SegmentExport.this.mSegmentExportListener.onSegmentExportProgress((((float) (timeUs - SegmentExport.this.mDecodeVideoRange.getStart().getTimeUs())) * 1.0f) / ((float) SegmentExport.this.mDecodeVideoRange.getDurationUs()));
                    }
                    if (this.mIsFirstFrame && this.mEncoderWriter.getVideoEncodeFormat() != null && (!(SegmentExport.this.segmentMuxer instanceof QuickMuxer) || SegmentExport.this.segmentMuxer.isMuxerStarted())) {
                        SegmentExport.this.setEncodeMediaFormat(this.mEncoderWriter.getVideoEncodeFormat());
                        this.mIsFirstFrame = true;
                    }
                    GLES30.glDeleteSync(videoFrame.getFence());
                    if (SegmentExport.this.mTexturePool != null) {
                        SegmentExport.this.mTexturePool.pushTexture(textureInfo);
                    } else {
                        textureInfo.release();
                    }
                } catch (InterruptedException e16) {
                    SegmentExport.this.mSegmentExportListener.onSegmentExportError(-5L);
                    Logger.e(this.TAG, "take video frame failed ", e16);
                    return;
                }
            }
        }

        private boolean init() {
            boolean z16;
            try {
                EncoderWriter encoderWriter = new EncoderWriter(this.mOutputPath, null, SegmentExport.this.mediaMuxerCreator);
                this.mEncoderWriter = encoderWriter;
                encoderWriter.setEncodeOption(this.mExportConfig);
                this.mEncoderWriter.startVideoEncoder();
                EncoderWriter encoderWriter2 = this.mEncoderWriter;
                this.mEncodeGLContext = encoderWriter2.createRenderContext(encoderWriter2.getOutWidth(), this.mEncoderWriter.getOutHeight(), this.mSegExport.getEGLContext().eglContext());
                SegmentExport.this.setSegmentMuxer(this.mEncoderWriter.getMuxer());
                if (SegmentExport.this.segmentMuxer instanceof QuickMuxer) {
                    ((QuickMuxer) SegmentExport.this.segmentMuxer).setInputVideoPath(SegmentExport.this.mInputPath);
                }
                this.mFilter = new Filter();
                z16 = true;
            } catch (Exception e16) {
                Logger.e(this.TAG, "encoder init failed ", e16);
                z16 = false;
            }
            this.mCurrentThread = Thread.currentThread();
            return z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void innerRelease() {
            Filter filter = this.mFilter;
            if (filter != null) {
                filter.release();
            }
            EncoderWriter encoderWriter = this.mEncoderWriter;
            if (encoderWriter != null) {
                encoderWriter.release();
            }
            RenderContext renderContext = this.mEncodeGLContext;
            if (renderContext != null) {
                renderContext.release();
                this.mEncodeGLContext = null;
            }
        }

        public void release() {
            if (this.mCurrentThread != null && !SegmentExport.this.mEncodeEnd) {
                this.mCurrentThread.interrupt();
            }
            SegmentExport.this.mEncodeEnd = true;
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.tencent.tav.quick.export.SegmentExport.VideoEncodeThread.2
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoEncodeThread.this.innerRelease();
                    }
                });
            }
            HandlerThread handlerThread = this.mEncodeThread;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
            this.mHandler = null;
        }

        public void start() {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("encode-ht");
            this.mEncodeThread = baseHandlerThread;
            baseHandlerThread.start();
            Handler handler = new Handler(this.mEncodeThread.getLooper());
            this.mHandler = handler;
            handler.post(new Runnable() { // from class: com.tencent.tav.quick.export.SegmentExport.VideoEncodeThread.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        VideoEncodeThread.this.encode();
                    } catch (Exception e16) {
                        Logger.e(VideoEncodeThread.this.TAG, "Segment video encode error ", e16);
                        SegmentExport.this.mSegmentExportListener.onSegmentExportError(-6L);
                    }
                }
            });
        }
    }

    public SegmentExport(String str, String str2, Asset asset, ExportConfig exportConfig) {
        this.mInputPath = str;
        this.mOutputPath = str2;
        this.mAsset = asset;
        this.mExportConfig = exportConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RenderContext getEGLContext() throws InterruptedException {
        RenderContext renderContext;
        synchronized (this.mGlCtxLock) {
            while (true) {
                renderContext = this.mEGLContext;
                if (renderContext == null) {
                    LockMethodProxy.wait(this.mGlCtxLock);
                }
            }
        }
        return renderContext;
    }

    private Bitmap readBitmapFromTexture(TextureInfo textureInfo) {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, textureInfo.textureType, textureInfo.textureID, 0);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(textureInfo.width * textureInfo.height * 4);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        allocateDirect.rewind();
        GLES20.glReadPixels(0, 0, textureInfo.width, textureInfo.height, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocateDirect);
        Bitmap createBitmap = Bitmap.createBitmap(textureInfo.width, textureInfo.height, Bitmap.Config.ARGB_8888);
        allocateDirect.rewind();
        createBitmap.copyPixelsFromBuffer(allocateDirect);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseFrameQueue() {
        if (this.mVideoFrameQueue != null) {
            Logger.e(this.TAG, "releaseFrameQueue mVideoFrameQueue size " + this.mVideoFrameQueue.size());
            try {
                if (!this.mVideoFrameQueue.isEmpty()) {
                    ArrayList<VideoFrame> arrayList = new ArrayList();
                    this.mVideoFrameQueue.drainTo(arrayList);
                    for (VideoFrame videoFrame : arrayList) {
                        if (videoFrame != null && videoFrame.getSampleBuffer() != null) {
                            videoFrame.getSampleBuffer().getTextureInfo().release();
                            Logger.e(this.TAG, "releaseFrameQueue release texinfo");
                        }
                    }
                }
                this.mVideoFrameQueue.put(new VideoFrame(null, 0L));
            } catch (InterruptedException e16) {
                Logger.e(this.TAG, "Send end frame to encode thread error ", e16);
            }
        }
    }

    private void saveBitmap(Bitmap bitmap, String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str + ".jpg"));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEGLContext(RenderContext renderContext) {
        synchronized (this.mGlCtxLock) {
            this.mEGLContext = renderContext;
            this.mGlCtxLock.notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEncodeMediaFormat(MediaFormat mediaFormat) {
        synchronized (this.mMediaFormatLock) {
            this.mEncodeMediaFormat = mediaFormat;
            this.mMediaFormatLock.notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSegmentMuxer(IMediaMuxer iMediaMuxer) {
        synchronized (this.segmentMuxerLock) {
            this.segmentMuxer = iMediaMuxer;
        }
    }

    public MediaFormat getEncodeMediaFormat() {
        MediaFormat mediaFormat;
        try {
            synchronized (this.mMediaFormatLock) {
                while (true) {
                    mediaFormat = this.mEncodeMediaFormat;
                    if (mediaFormat == null) {
                        LockMethodProxy.wait(this.mMediaFormatLock);
                    }
                }
            }
            return mediaFormat;
        } catch (InterruptedException unused) {
            return null;
        }
    }

    public IMediaMuxer getSegmentMuxer() {
        IMediaMuxer iMediaMuxer;
        synchronized (this.segmentMuxerLock) {
            iMediaMuxer = this.segmentMuxer;
        }
        return iMediaMuxer;
    }

    public void release() {
        VideoDecodeThread videoDecodeThread = this.mDecodeThread;
        if (videoDecodeThread != null) {
            videoDecodeThread.release();
        }
        VideoEncodeThread videoEncodeThread = this.mEncodeThread;
        if (videoEncodeThread != null) {
            videoEncodeThread.release();
        }
    }

    public void setMediaMuxerCreator(MediaMuxerFactory.MediaMuxerCreator mediaMuxerCreator) {
        this.mediaMuxerCreator = mediaMuxerCreator;
    }

    public void setSegmentExportListener(SegmentExportListener segmentExportListener) {
        this.mSegmentExportListener = segmentExportListener;
    }

    public void startExport(CMTimeRange cMTimeRange) {
        this.mDecodeVideoRange = cMTimeRange;
        this.mDecodeThread = new VideoDecodeThread(this, this.mInputPath, cMTimeRange);
        this.mEncodeThread = new VideoEncodeThread(this, this.mOutputPath, this.mExportConfig);
        this.mDecodeThread.start();
        this.mEncodeThread.start();
    }
}
