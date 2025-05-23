package com.tencent.ttpic.openapi.recorder;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.view.RendererUtils;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes27.dex */
public class ActVideoDecoder {
    private static final String TAG = "ActVideoDecoder";
    private static final int TIMEOUT_MS = 2500;
    private static final int TIMEOUT_US = 10000;
    private ByteBuffer[] inputBuffers;
    private volatile boolean isDecoding;
    private MediaCodec mDecoder;
    private Surface mDecoderSurface;
    private int mDstTex;
    private long mDuration;
    private MediaExtractor mExtractor;
    private String mFilename;
    private boolean mFrameAvailable;
    private Handler mHandler;
    private boolean mHasNewFrame;
    private int mHeight;
    private final Object mInitLock;
    private boolean mInited;
    private int mRotation;
    private SurfaceTexture mSurfaceTexture;
    private int mTempTex;
    private int mWidth;
    private long mLastFrameIndex = -1;
    private long mCurFrameIndex = -1;
    private boolean isEOS = false;
    private MediaCodec.BufferInfo info = new MediaCodec.BufferInfo();
    private SurfaceTextureFilter mSurfaceTexFilter = new SurfaceTextureFilter();
    private final float[] mTransformMatrix = new float[16];
    private Frame mFrame = new Frame();
    private final Object mUpdateFrameLock = new Object();

    public ActVideoDecoder(String str, int i3) {
        Object obj = new Object();
        this.mInitLock = obj;
        this.mFilename = str;
        this.mDstTex = i3;
        this.mTempTex = RendererUtils.createTexture();
        this.mSurfaceTexFilter.apply();
        this.mSurfaceTexFilter.setRotationAndFlip(0, 0, 1);
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(ActVideoDecoder.class.getSimpleName(), 10);
        baseHandlerThread.start();
        Handler handler = new Handler(baseHandlerThread.getLooper());
        this.mHandler = handler;
        handler.post(new Runnable() { // from class: com.tencent.ttpic.openapi.recorder.ActVideoDecoder.1
            @Override // java.lang.Runnable
            public void run() {
                ActVideoDecoder.this.mSurfaceTexture = new SurfaceTexture(ActVideoDecoder.this.mTempTex);
                ActVideoDecoder.this.mSurfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.tencent.ttpic.openapi.recorder.ActVideoDecoder.1.1
                    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                        synchronized (ActVideoDecoder.this.mUpdateFrameLock) {
                            if (!ActVideoDecoder.this.mFrameAvailable) {
                                ActVideoDecoder.this.mFrameAvailable = true;
                                ActVideoDecoder.this.mUpdateFrameLock.notifyAll();
                            } else {
                                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
                            }
                        }
                    }
                });
                synchronized (ActVideoDecoder.this.mInitLock) {
                    ActVideoDecoder.this.mInitLock.notifyAll();
                    ActVideoDecoder.this.mInited = true;
                }
            }
        });
        synchronized (obj) {
            while (!this.mInited) {
                try {
                    LockMethodProxy.wait(this.mInitLock);
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
            }
        }
        this.mDecoderSurface = new Surface(this.mSurfaceTexture);
        MediaExtractor mediaExtractor = new MediaExtractor();
        this.mExtractor = mediaExtractor;
        try {
            setExtractorDataSource(mediaExtractor, this.mFilename);
            prepare();
        } catch (IOException e17) {
            e17.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int decodeNext() {
        int dequeueInputBuffer;
        if (this.mDecoder == null) {
            if (!AEOpenRenderConfig.DEBUG) {
                return -1;
            }
            throw new RuntimeException("ActVideoDecoder init fail!");
        }
        int i3 = 0;
        while (true) {
            if (!Thread.interrupted()) {
                BenchUtil.benchStart("[decodeNext] dequeueInputBuffer");
                if (!this.isEOS && (dequeueInputBuffer = this.mDecoder.dequeueInputBuffer(10000L)) >= 0) {
                    int readSampleData = this.mExtractor.readSampleData(this.inputBuffers[dequeueInputBuffer], 0);
                    if (readSampleData < 0) {
                        LogUtils.d(TAG, "extractor read sample to EOS");
                        this.mDecoder.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                        this.isEOS = true;
                    } else {
                        this.mDecoder.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, this.mExtractor.getSampleTime(), 0);
                        this.mExtractor.advance();
                    }
                }
                BenchUtil.benchEnd("[decodeNext] dequeueInputBuffer");
                BenchUtil.benchStart("[decodeNext] wait");
                int dequeueOutputBuffer = this.mDecoder.dequeueOutputBuffer(this.info, 10000L);
                BenchUtil.benchEnd("[decodeNext] wait");
                if ((this.info.flags & 4) != 0) {
                    break;
                }
                if (dequeueOutputBuffer != -3 && dequeueOutputBuffer != -2) {
                    if (dequeueOutputBuffer != -1) {
                        long j3 = this.mCurFrameIndex + 1;
                        this.mCurFrameIndex = j3;
                        if (j3 == this.mLastFrameIndex) {
                            this.mHasNewFrame = true;
                            this.mDecoder.releaseOutputBuffer(dequeueOutputBuffer, true);
                            break;
                        }
                        this.mDecoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                    } else {
                        i3++;
                        if (i3 > 10) {
                            LogUtils.e(TAG, "dequeueOutputBuffer timed out! eos = " + this.isEOS);
                            return -1;
                        }
                    }
                }
            } else {
                break;
            }
        }
        return 0;
    }

    private void prepare() throws IOException {
        int i3 = 0;
        while (true) {
            if (i3 >= this.mExtractor.getTrackCount()) {
                break;
            }
            MediaFormat trackFormat = this.mExtractor.getTrackFormat(i3);
            String string = trackFormat.getString("mime");
            if (string.startsWith("video/")) {
                this.mExtractor.selectTrack(i3);
                String str = TAG;
                LogUtils.d(str, "extractor video track selected");
                this.mWidth = trackFormat.getInteger("width");
                int integer = trackFormat.getInteger("height");
                this.mHeight = integer;
                int i16 = this.mRotation;
                if (i16 == 90 || i16 == 270) {
                    int i17 = this.mWidth;
                    this.mWidth = integer;
                    this.mHeight = i17;
                }
                this.mDuration = trackFormat.getLong("durationUs") / 1000;
                LogUtils.d(str, "width = " + this.mWidth + ", height = " + this.mHeight + ", mDuration = " + this.mDuration);
                this.mDecoder = MediaCodec.createDecoderByType(string);
                trackFormat.setInteger("max-input-size", 0);
                this.mDecoder.configure(trackFormat, this.mDecoderSurface, (MediaCrypto) null, 0);
            } else {
                i3++;
            }
        }
        MediaCodec mediaCodec = this.mDecoder;
        if (mediaCodec == null) {
            LogUtils.e(TAG, "Can't find video info!");
            return;
        }
        try {
            mediaCodec.start();
            this.inputBuffers = this.mDecoder.getInputBuffers();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        this.isEOS = false;
    }

    private static void setExtractorDataSource(MediaExtractor mediaExtractor, String str) throws IOException {
        if (str.startsWith("assets://")) {
            AssetFileDescriptor openFd = AEModule.getContext().getAssets().openFd(str.substring(9));
            mediaExtractor.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            openFd.close();
            return;
        }
        mediaExtractor.setDataSource(str);
    }

    public void decodeFrame(long j3) {
        if (this.mDecoderSurface != null) {
            if (j3 <= this.mLastFrameIndex) {
                return;
            }
            this.mLastFrameIndex = j3;
            try {
                StringBuilder sb5 = new StringBuilder();
                String str = TAG;
                sb5.append(str);
                sb5.append("[decodeNext]");
                BenchUtil.benchStart(sb5.toString());
                decodeNext();
                BenchUtil.benchEnd(str + "[decodeNext]");
                return;
            } catch (Exception e16) {
                LogUtils.e(TAG, "decodeNext error: ", e16, new Object[0]);
                return;
            }
        }
        throw new RuntimeException("You haven't set surfaceTexture?!");
    }

    public void decodeFrameAsync(long j3) {
        if (this.mDecoderSurface != null) {
            if (!this.isDecoding && j3 > this.mLastFrameIndex) {
                this.isDecoding = true;
                this.mLastFrameIndex = j3;
                this.mHandler.post(new Runnable() { // from class: com.tencent.ttpic.openapi.recorder.ActVideoDecoder.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            BenchUtil.benchStart(ActVideoDecoder.TAG + "[decodeNext]");
                            ActVideoDecoder.this.decodeNext();
                            BenchUtil.benchEnd(ActVideoDecoder.TAG + "[decodeNext]");
                        } catch (Exception e16) {
                            LogUtils.e(ActVideoDecoder.TAG, "decodeNext error: ", e16, new Object[0]);
                            if (AEOpenRenderConfig.DEBUG) {
                                throw e16;
                            }
                        }
                        ActVideoDecoder.this.isDecoding = false;
                    }
                });
                return;
            }
            return;
        }
        throw new RuntimeException("You haven't set surfaceTexture?!");
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Frame getFrame() {
        return this.mFrame;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isLive() {
        if (this.mDecoder != null) {
            return true;
        }
        return false;
    }

    public void release() {
        RendererUtils.clearTexture(this.mTempTex);
        this.mSurfaceTexFilter.clearGLSLSelf();
        this.mFrame.clear();
        Surface surface = this.mDecoderSurface;
        if (surface != null) {
            surface.release();
        }
        MediaExtractor mediaExtractor = this.mExtractor;
        if (mediaExtractor != null) {
            mediaExtractor.release();
        }
        MediaCodec mediaCodec = this.mDecoder;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
                this.mDecoder.release();
                LogUtils.i(TAG, "mDecoder stop and release");
                this.mDecoder = null;
            } catch (Exception unused) {
                this.mDecoder = null;
            }
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler.post(new Runnable() { // from class: com.tencent.ttpic.openapi.recorder.ActVideoDecoder.4
                @Override // java.lang.Runnable
                public void run() {
                    if (ActVideoDecoder.this.mSurfaceTexture != null) {
                        ActVideoDecoder.this.mSurfaceTexture.release();
                    }
                    ActVideoDecoder.this.mHandler.getLooper().quit();
                    ActVideoDecoder.this.mHandler = null;
                }
            });
        }
    }

    public void reset() {
        try {
            MediaExtractor mediaExtractor = this.mExtractor;
            if (mediaExtractor != null) {
                mediaExtractor.seekTo(0L, 0);
            }
            MediaCodec mediaCodec = this.mDecoder;
            if (mediaCodec != null) {
                mediaCodec.flush();
            }
        } catch (Exception e16) {
            if (!TextUtils.isEmpty(e16.getMessage())) {
                LogUtils.d(TAG, e16.getMessage());
            }
        }
        this.isEOS = false;
        this.mCurFrameIndex = -1L;
        this.mLastFrameIndex = -1L;
    }

    public void resetAsync() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.ttpic.openapi.recorder.ActVideoDecoder.3
                @Override // java.lang.Runnable
                public void run() {
                    if (ActVideoDecoder.this.mExtractor != null) {
                        ActVideoDecoder.this.mExtractor.seekTo(0L, 0);
                    }
                    if (ActVideoDecoder.this.mDecoder != null) {
                        ActVideoDecoder.this.mDecoder.flush();
                    }
                    ActVideoDecoder.this.isEOS = false;
                    ActVideoDecoder.this.mCurFrameIndex = -1L;
                    ActVideoDecoder.this.mLastFrameIndex = -1L;
                }
            });
        }
    }

    public void setRotation(int i3) {
        this.mRotation = i3;
        if (i3 == 90 || i3 == 270) {
            int i16 = this.mWidth;
            this.mWidth = this.mHeight;
            this.mHeight = i16;
        }
    }

    public boolean updateFrame() {
        boolean z16 = this.mHasNewFrame;
        if (z16) {
            BenchUtil.benchStart(TAG + "[updateFrame] wait");
            synchronized (this.mUpdateFrameLock) {
                while (!this.mFrameAvailable) {
                    try {
                        this.mUpdateFrameLock.wait(2500L);
                        if (!this.mFrameAvailable) {
                            LogUtils.e(TAG, "frame wait timed out");
                            return false;
                        }
                    } catch (InterruptedException e16) {
                        throw new RuntimeException(e16);
                    }
                }
                this.mFrameAvailable = false;
                StringBuilder sb5 = new StringBuilder();
                String str = TAG;
                sb5.append(str);
                sb5.append("[updateFrame] wait");
                BenchUtil.benchEnd(sb5.toString());
                BenchUtil.benchStart(str + "[updateFrame] render");
                try {
                    this.mSurfaceTexture.updateTexImage();
                } catch (Exception unused) {
                }
                this.mSurfaceTexture.getTransformMatrix(this.mTransformMatrix);
                this.mSurfaceTexFilter.updateMatrix(this.mTransformMatrix);
                this.mSurfaceTexFilter.RenderProcess(this.mTempTex, getWidth(), getHeight(), this.mDstTex, 0.0d, this.mFrame);
                this.mHasNewFrame = false;
                BenchUtil.benchEnd(TAG + "[updateFrame] render");
            }
        }
        return z16;
    }
}
