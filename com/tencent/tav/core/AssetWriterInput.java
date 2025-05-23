package com.tencent.tav.core;

import android.graphics.Matrix;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.tav.asset.MetadataItem;
import com.tencent.tav.core.AssetWriter;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.decoder.Filter;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AssetWriterInput {
    private static final String TAG = "AssetWriterInput";
    private AssetWriter assetWriter;
    private final ExportConfig exportConfig;
    private Handler handler;
    private HandlerThread handlerThread;
    private int mediaType;
    private List<MetadataItem> metadata;
    public WriterProgressListener progressListener;
    private boolean readyForMoreMediaData;
    private StatusListener statusListener;
    private Matrix transform;
    EncoderWriter writer;
    private Handler writerHandler;
    private HandlerThread writerThread;
    final Filter matrixFilter = new Filter();
    private boolean started = false;
    private boolean stop = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface StatusListener {
        void statusChanged(AssetWriterInput assetWriterInput, AssetWriter.AssetWriterStatus assetWriterStatus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class WriterAudioRunnable implements Runnable {
        private final boolean isEndBuffer;
        private final CMSampleBuffer sampleBuffer;

        @Override // java.lang.Runnable
        @RequiresApi(api = 18)
        public void run() {
            AssetWriterInput.this.doWriteAudio(this.sampleBuffer, this.isEndBuffer);
        }

        WriterAudioRunnable(CMSampleBuffer cMSampleBuffer, boolean z16) {
            this.sampleBuffer = cMSampleBuffer;
            this.isEndBuffer = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface WriterProgressListener {
        void onError(@NonNull ExportErrorStatus exportErrorStatus);

        void onProgressChanged(AssetWriterInput assetWriterInput, long j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class WriterVideoRunnable implements Runnable {
        private final TextureInfo outputTexture;
        private final CMSampleBuffer sampleBuffer;

        @Override // java.lang.Runnable
        @RequiresApi(api = 18)
        public void run() {
            AssetWriterInput.this.doWriteVideo(this.sampleBuffer, this.outputTexture);
        }

        WriterVideoRunnable(CMSampleBuffer cMSampleBuffer, TextureInfo textureInfo) {
            this.sampleBuffer = cMSampleBuffer;
            this.outputTexture = textureInfo;
        }
    }

    public AssetWriterInput(int i3, ExportConfig exportConfig) {
        this.mediaType = i3;
        this.exportConfig = exportConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 18)
    public void doWriteAudio(CMSampleBuffer cMSampleBuffer, boolean z16) {
        ExportErrorStatus exportErrorStatus;
        Logger.i(TAG, "doWriteAudio time:" + cMSampleBuffer.getTime());
        if (this.handler == null) {
            return;
        }
        long j3 = -1;
        try {
            if (z16) {
                this.writer.endWriteAudioSample();
            } else {
                this.writer.inputAudioSample(cMSampleBuffer.getTime().getTimeUs(), cMSampleBuffer.getSampleByteBuffer());
                j3 = this.writer.getAudioPresentationTimeUs();
            }
        } catch (Throwable th5) {
            if (th5 instanceof ExportRuntimeException) {
                exportErrorStatus = th5.getErrorStatus();
            } else {
                exportErrorStatus = new ExportErrorStatus(-122, th5);
            }
            WriterProgressListener writerProgressListener = this.progressListener;
            if (writerProgressListener != null) {
                writerProgressListener.onError(exportErrorStatus);
                return;
            }
        }
        WriterProgressListener writerProgressListener2 = this.progressListener;
        if (writerProgressListener2 != null) {
            writerProgressListener2.onProgressChanged(this, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 18)
    public void doWriteVideo(CMSampleBuffer cMSampleBuffer, TextureInfo textureInfo) {
        ExportErrorStatus exportErrorStatus;
        Logger.i(TAG, "doWriteVideo time:" + cMSampleBuffer.getTime());
        if (this.handler == null) {
            return;
        }
        try {
            this.writer.writeVideoSample(cMSampleBuffer, textureInfo);
            if (cMSampleBuffer.getState().stateMatchingTo(-1)) {
                this.writer.endWriteVideoSample(cMSampleBuffer, textureInfo);
            }
        } catch (Throwable th5) {
            if (th5 instanceof ExportRuntimeException) {
                exportErrorStatus = th5.getErrorStatus();
            } else {
                exportErrorStatus = new ExportErrorStatus(ExportErrorStatus.WRITE_VIDEO_SAMPLE, th5);
            }
            WriterProgressListener writerProgressListener = this.progressListener;
            if (writerProgressListener != null) {
                writerProgressListener.onError(exportErrorStatus);
                return;
            }
        }
        WriterProgressListener writerProgressListener2 = this.progressListener;
        if (writerProgressListener2 != null) {
            writerProgressListener2.onProgressChanged(this, this.writer.getVideoPresentationTimeUs());
        }
    }

    @Nullable
    private Matrix getStMatrix(TextureInfo textureInfo) {
        Matrix textureMatrix = textureInfo.getTextureMatrix();
        Matrix frameMatrix = this.writer.getVideoEncoder().getFrameMatrix();
        if (frameMatrix != null && textureMatrix != null) {
            textureMatrix.postConcat(frameMatrix);
        }
        if (textureMatrix == null) {
            return frameMatrix;
        }
        return textureMatrix;
    }

    private void onStartError(Exception exc, int i3) {
        int i16;
        ExportErrorStatus exportErrorStatus;
        if (exc instanceof ExportRuntimeException) {
            exportErrorStatus = ((ExportRuntimeException) exc).getErrorStatus();
        } else {
            if (i3 == 1) {
                i16 = -101;
            } else {
                i16 = -102;
            }
            exportErrorStatus = new ExportErrorStatus(i16, exc);
        }
        WriterProgressListener writerProgressListener = this.progressListener;
        if (writerProgressListener != null) {
            writerProgressListener.onError(exportErrorStatus);
        }
    }

    @RequiresApi(api = 18)
    private TextureInfo renderSampleBuffer(CMSampleBuffer cMSampleBuffer) {
        int width;
        int height;
        TextureInfo textureInfo = cMSampleBuffer.getTextureInfo();
        if (textureInfo != null) {
            RenderContext renderContext = this.assetWriter.renderContext();
            if (this.writer.isVideoEncodeNeedVideoRenderOutputTexture()) {
                this.matrixFilter.setRendererWidth(renderContext.width());
                this.matrixFilter.setRendererHeight(renderContext.height());
                this.matrixFilter.setRenderForScreen(false);
                renderContext.updateViewport(0, 0, renderContext.width(), renderContext.height());
            } else {
                if (this.exportConfig.getOutputRotate() % 2 != 0) {
                    width = renderContext.height();
                    height = renderContext.width();
                } else {
                    width = renderContext.width();
                    height = renderContext.height();
                }
                this.matrixFilter.setRendererWidth(width);
                this.matrixFilter.setRendererHeight(height);
                this.matrixFilter.setRenderForScreen(true);
                renderContext.updateViewport(0, 0, width, height);
                Matrix rotationMatrix = DecoderUtils.getRotationMatrix(this.exportConfig.getOutputRotate(), textureInfo.width, textureInfo.height);
                if (this.transform == null) {
                    this.transform = new Matrix();
                }
                this.transform.postConcat(rotationMatrix);
            }
            return this.matrixFilter.applyFilter(textureInfo, this.transform, getStMatrix(textureInfo));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addStatusListener(StatusListener statusListener) {
        this.statusListener = statusListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExportErrorStatus appendAudioSampleBuffer(CMSampleBuffer cMSampleBuffer) {
        boolean smallThan = cMSampleBuffer.getTime().smallThan(CMTime.CMTimeZero);
        if (!smallThan) {
            ByteBuffer allocate = ByteBuffer.allocate(cMSampleBuffer.getSampleByteBuffer().limit());
            allocate.order(cMSampleBuffer.getSampleByteBuffer().order());
            allocate.put(cMSampleBuffer.getSampleByteBuffer());
            allocate.flip();
            cMSampleBuffer = new CMSampleBuffer(cMSampleBuffer.getTime().sub(this.assetWriter.startTime), allocate);
        }
        Logger.i(TAG, "appendAudioSampleBuffer:" + cMSampleBuffer.getTime());
        this.writerHandler.post(new WriterAudioRunnable(cMSampleBuffer, smallThan));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(7:13|14|(4:15|16|(1:18)|20)|21|22|(1:24)|25) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0093, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0094, code lost:
    
        r3 = new com.tencent.tav.core.ExportErrorStatus(-113, r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0073 A[Catch: Exception -> 0x0093, TryCatch #2 {Exception -> 0x0093, blocks: (B:22:0x005b, B:24:0x0073, B:25:0x0080), top: B:21:0x005b }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00a6  */
    @RequiresApi(api = 18)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ExportErrorStatus appendVideoSampleBuffer(CMSampleBuffer cMSampleBuffer) {
        TextureInfo textureInfo;
        ExportErrorStatus exportErrorStatus;
        Logger.d(TAG, "appendVideoSampleBuffer, time:" + cMSampleBuffer.getTime());
        try {
            this.assetWriter.renderContext().makeCurrent();
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glClear(16640);
            if (cMSampleBuffer.getTime().getTimeUs() >= 0) {
                try {
                    textureInfo = renderSampleBuffer(cMSampleBuffer);
                } catch (Exception e16) {
                    e = e16;
                    textureInfo = null;
                }
                try {
                    if (this.writer.isVideoEncodeNeedVideoRenderOutputTexture()) {
                        GLES20.glFinish();
                    }
                    exportErrorStatus = null;
                } catch (Exception e17) {
                    e = e17;
                    exportErrorStatus = new ExportErrorStatus(-112, e);
                    long timeUs = cMSampleBuffer.getTime().sub(this.assetWriter.startTime).getTimeUs();
                    if (this.writer.isVideoEncodeNeedVideoRenderOutputTexture()) {
                    }
                    this.assetWriter.renderContext().setPresentationTime(timeUs);
                    this.assetWriter.renderContext().swapBuffers();
                    if (!this.writer.isVideoEncodeNeedVideoRenderOutputTexture()) {
                    }
                    this.writerHandler.post(new WriterVideoRunnable(cMSampleBuffer, textureInfo));
                    return exportErrorStatus;
                }
                long timeUs2 = cMSampleBuffer.getTime().sub(this.assetWriter.startTime).getTimeUs();
                if (this.writer.isVideoEncodeNeedVideoRenderOutputTexture()) {
                    this.assetWriter.encoderWriter().getVideoEncoder().onOutputTextureUpdate(textureInfo, timeUs2);
                }
                this.assetWriter.renderContext().setPresentationTime(timeUs2);
                this.assetWriter.renderContext().swapBuffers();
            } else {
                textureInfo = null;
                exportErrorStatus = null;
            }
            if (!this.writer.isVideoEncodeNeedVideoRenderOutputTexture()) {
                this.writerHandler.removeCallbacksAndMessages(null);
            }
            this.writerHandler.post(new WriterVideoRunnable(cMSampleBuffer, textureInfo));
            return exportErrorStatus;
        } catch (Exception e18) {
            return new ExportErrorStatus(-111, e18);
        }
    }

    public synchronized void close() {
        HandlerThread handlerThread = this.handlerThread;
        if (handlerThread != null) {
            this.readyForMoreMediaData = false;
            handlerThread.quit();
            this.handlerThread = null;
            this.handler = null;
        }
        if (this.writerThread != null) {
            this.writerHandler.removeCallbacks(null);
            this.writerThread.quit();
            this.writerThread = null;
            this.writerHandler = null;
        }
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public List<MetadataItem> getMetadata() {
        return this.metadata;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initConfig(AssetWriter assetWriter) {
        this.assetWriter = assetWriter;
        this.writer = assetWriter.encoderWriter();
    }

    public boolean isReadyForMoreMediaData() {
        if (this.readyForMoreMediaData) {
            if (this.mediaType == 1) {
                if (this.writer.videoTrackWritable()) {
                    return true;
                }
            } else if (this.writer.audioTrackWritable()) {
                return true;
            }
        }
        return false;
    }

    public void markAsFinished() {
        this.writerHandler.post(new Runnable() { // from class: com.tencent.tav.core.AssetWriterInput.2
            @Override // java.lang.Runnable
            @RequiresApi(api = 18)
            public void run() {
                if (AssetWriterInput.this.mediaType == 1) {
                    try {
                        AssetWriterInput.this.writer.endWriteVideoSample(null, null);
                    } catch (Throwable th5) {
                        WriterProgressListener writerProgressListener = AssetWriterInput.this.progressListener;
                        if (writerProgressListener != null) {
                            writerProgressListener.onError(new ExportErrorStatus(ExportErrorStatus.END_WRITE_VIDEO_SAMPLE, th5));
                            return;
                        }
                    }
                    AssetWriterInput assetWriterInput = AssetWriterInput.this;
                    WriterProgressListener writerProgressListener2 = assetWriterInput.progressListener;
                    if (writerProgressListener2 != null) {
                        writerProgressListener2.onProgressChanged(assetWriterInput, -1L);
                        return;
                    }
                    return;
                }
                try {
                    AssetWriterInput.this.writer.endWriteAudioSample();
                } catch (Throwable th6) {
                    WriterProgressListener writerProgressListener3 = AssetWriterInput.this.progressListener;
                    if (writerProgressListener3 != null) {
                        writerProgressListener3.onError(new ExportErrorStatus(ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, th6));
                        return;
                    }
                }
                AssetWriterInput assetWriterInput2 = AssetWriterInput.this;
                WriterProgressListener writerProgressListener4 = assetWriterInput2.progressListener;
                if (writerProgressListener4 != null) {
                    writerProgressListener4.onProgressChanged(assetWriterInput2, -1L);
                }
            }
        });
    }

    public synchronized void requestMediaDataWhenReadyOnQueue(HandlerThread handlerThread, final Runnable runnable) {
        if (this.handler != null) {
            Log.e(TAG, "\u6b63\u5728\u5904\u7406\u4e0a\u4e00\u6b21\u7684request\u8bf7\u6c42\uff0c\u65e0\u6cd5\u91cd\u590d\u53d1\u8d77");
            return;
        }
        if (this.assetWriter == null) {
            Logger.e(TAG, "\u8fd8\u6ca1\u6709\u4e0eAssetWriter\u5173\u8054\uff0c\u65e0\u6cd5\u53d1\u8d77request\u8bf7\u6c42");
            return;
        }
        this.handlerThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.handler = handler;
        handler.post(new Runnable() { // from class: com.tencent.tav.core.AssetWriterInput.1
            @Override // java.lang.Runnable
            @RequiresApi(api = 18)
            public void run() {
                Runnable runnable2;
                if (AssetWriterInput.this.start() && (runnable2 = runnable) != null) {
                    runnable2.run();
                }
            }
        });
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("writerThread-" + this.mediaType + "@" + Integer.toHexString(hashCode()));
        this.writerThread = baseHandlerThread;
        baseHandlerThread.start();
        this.writerHandler = new Handler(this.writerThread.getLooper());
    }

    public void setMetadata(List<MetadataItem> list) {
        this.metadata = list;
    }

    public void setTransform(Matrix matrix) {
        this.transform = matrix;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setWriterProgressListener(WriterProgressListener writerProgressListener) {
        this.progressListener = writerProgressListener;
    }

    @RequiresApi(api = 18)
    boolean start() {
        if (this.started) {
            return true;
        }
        try {
            if (this.mediaType == 1) {
                this.writer.startVideoEncoder();
                this.writer.setVideoSampleRenderContext(this.assetWriter.renderContext());
            } else {
                this.writer.startAudioEncoder();
            }
            this.readyForMoreMediaData = true;
            this.started = true;
        } catch (Exception e16) {
            Logger.e(TAG, "start: ", e16);
            onStartError(e16, this.mediaType);
        }
        return this.started;
    }

    void stop() {
        this.stop = true;
        this.readyForMoreMediaData = false;
    }
}
