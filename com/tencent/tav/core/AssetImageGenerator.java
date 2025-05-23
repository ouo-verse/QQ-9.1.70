package com.tencent.tav.core;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.Filter;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AssetImageGenerator {
    public static boolean UN_CATCH_EGL_ERROR = false;
    private final String TAG;
    private ApertureMode apertureMode;
    private boolean appliesPreferredTrackTransform;
    protected Asset asset;
    protected AssetExtension assetExtension;
    private boolean forceUseFbo;

    @NonNull
    private final ImageGeneratorThread generatorThread;
    private long generatorThreadId;

    @Nullable
    private CGSize maximumSize;
    private ByteBuffer outBitmapReaderBuffer;
    private String outSavePath;
    private OutputBitmapFactory outputBitmapFactory;
    private RenderContext renderContext;

    @Nullable
    private RenderContextParams renderContextParams;
    private VideoCompositing videoCompositing;
    private VideoComposition videoComposition;
    private VideoCompositionDecoderTrack videoCompositionDecoderTrack;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.tav.core.AssetImageGenerator$1, reason: invalid class name */
    /* loaded from: classes26.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$tav$core$AssetImageGenerator$ApertureMode;

        static {
            int[] iArr = new int[ApertureMode.values().length];
            $SwitchMap$com$tencent$tav$core$AssetImageGenerator$ApertureMode = iArr;
            try {
                iArr[ApertureMode.aspectFit.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$tav$core$AssetImageGenerator$ApertureMode[ApertureMode.aspectFill.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$tav$core$AssetImageGenerator$ApertureMode[ApertureMode.scaleToFit.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public enum ApertureMode {
        aspectFit,
        aspectFill,
        scaleToFit
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public enum AssetImageGeneratorResult {
        AssetImageGeneratorSucceeded,
        AssetImageGeneratorFailed,
        AssetImageGeneratorCancelled
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class DefaultBitmapFactory implements OutputBitmapFactory {
        DefaultBitmapFactory() {
        }

        @Override // com.tencent.tav.core.AssetImageGenerator.OutputBitmapFactory
        @NonNull
        public Bitmap getOutputBitmap(int i3, int i16) {
            return Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        }

        /* synthetic */ DefaultBitmapFactory(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface ImageGeneratorListener {
        void onCompletion(@NonNull CMTime cMTime, @Nullable Bitmap bitmap, @Nullable CMTime cMTime2, @NonNull AssetImageGeneratorResult assetImageGeneratorResult);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OutputBitmapFactory {
        @NonNull
        Bitmap getOutputBitmap(int i3, int i16);
    }

    public AssetImageGenerator(Asset asset) {
        this(asset, new AssetExtension(AssetExtension.SCENE_THUMBNAIL));
    }

    @Nullable
    private Bitmap bitmapFromFBO(@NonNull RenderContext renderContext, CMSampleBuffer cMSampleBuffer) {
        Matrix matrix;
        TextureInfo textureInfo = cMSampleBuffer.getTextureInfo();
        if (textureInfo == null) {
            Logger.e(this.TAG, "bitmapFromFBO: sampleBuffer.getTextureInfo() is null");
            return null;
        }
        Bitmap readBitmapFromTexture = readBitmapFromTexture(renderContext, textureInfo);
        Matrix matrix2 = getMatrix(this.maximumSize, new CGSize(textureInfo.width, textureInfo.height));
        Matrix matrix3 = new Matrix();
        matrix3.postScale(1.0f, -1.0f);
        matrix3.postTranslate(0.0f, readBitmapFromTexture.getHeight());
        if (matrix2 != null) {
            matrix2.postConcat(matrix3);
            matrix = matrix2;
        } else {
            matrix = matrix3;
        }
        CGSize cGSize = this.maximumSize;
        if (cGSize == null) {
            cGSize = new CGSize(textureInfo.width, textureInfo.height);
        }
        return Bitmap.createBitmap(readBitmapFromTexture, 0, 0, (int) cGSize.width, (int) cGSize.height, matrix, true);
    }

    @Nullable
    private Bitmap doGenerator(CMTime cMTime) {
        RenderContext initRenderContext = initRenderContext();
        CMSampleBuffer cmSampleBuffer = getCmSampleBuffer(cMTime, initRenderContext);
        if (!this.forceUseFbo && initRenderContext.isPBufferEnable()) {
            Logger.d(this.TAG, "doGenerator() from pBuffer: requestedTime = [" + cMTime + "]");
            return readBitmap(renderToMaximumSizeBox(initRenderContext, cmSampleBuffer));
        }
        Logger.d(this.TAG, "doGenerator() from fbo: requestedTime = [" + cMTime + "]");
        return bitmapFromFBO(initRenderContext, cmSampleBuffer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRelease() {
        Logger.d(this.TAG, "doRelease: start, thread = " + Thread.currentThread().getName());
        VideoCompositionDecoderTrack videoCompositionDecoderTrack = this.videoCompositionDecoderTrack;
        if (videoCompositionDecoderTrack != null) {
            videoCompositionDecoderTrack.release();
            this.videoCompositionDecoderTrack = null;
        }
        VideoCompositing videoCompositing = this.videoCompositing;
        if (videoCompositing != null) {
            videoCompositing.release();
            this.videoCompositing = null;
        }
        RenderContext renderContext = this.renderContext;
        if (renderContext != null) {
            renderContext.release();
            this.renderContext = null;
        }
        this.videoComposition = null;
        Logger.d(this.TAG, "doRelease: end, thread = " + Thread.currentThread().getName());
    }

    private CMSampleBuffer getCmSampleBuffer(CMTime cMTime, RenderContext renderContext) {
        VideoCompositing customVideoCompositor;
        if (this.videoCompositionDecoderTrack == null) {
            this.videoCompositionDecoderTrack = new VideoCompositionDecoderTrack(this.asset, this.assetExtension, 1);
            for (AssetTrack assetTrack : this.asset.getTracks()) {
                if (assetTrack.getMediaType() == 1) {
                    this.videoCompositionDecoderTrack.addTrack(assetTrack);
                }
            }
            this.videoCompositionDecoderTrack.setVideoComposition(this.videoComposition);
            VideoComposition videoComposition = this.videoComposition;
            if (videoComposition == null) {
                customVideoCompositor = null;
            } else {
                customVideoCompositor = videoComposition.getCustomVideoCompositor();
            }
            this.videoCompositing = customVideoCompositor;
            this.videoCompositionDecoderTrack.setVideoCompositing(customVideoCompositor);
            this.videoCompositionDecoderTrack.start(renderContext);
        }
        this.videoCompositionDecoderTrack.seekTo(cMTime, false, true);
        return this.videoCompositionDecoderTrack.readSample(cMTime);
    }

    @Nullable
    private Matrix getMatrix(CGSize cGSize, CGSize cGSize2) {
        if (cGSize == null || cGSize2 == null || this.apertureMode == null) {
            return null;
        }
        CGRect cGRect = new CGRect(new PointF(), cGSize2);
        CGRect cGRect2 = new CGRect(new PointF(), cGSize);
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$tav$core$AssetImageGenerator$ApertureMode[this.apertureMode.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return null;
                }
                return CGMathFunctions.transformByScaleFitRect(cGRect, cGRect2);
            }
            return CGMathFunctions.transformBySourceRectFill(cGRect, cGRect2);
        }
        return CGMathFunctions.transformBySourceRectFit(cGRect, cGRect2);
    }

    @NonNull
    private RenderContext initRenderContext() {
        this.generatorThreadId = Thread.currentThread().getId();
        if (this.renderContext == null) {
            CGSize cGSize = this.maximumSize;
            if (cGSize == null) {
                cGSize = this.asset.getNaturalSize();
            }
            RenderContext renderContext = new RenderContext((int) cGSize.width, (int) cGSize.height, UN_CATCH_EGL_ERROR);
            this.renderContext = renderContext;
            renderContext.setParams(this.renderContextParams);
        }
        this.renderContext.makeCurrent();
        return this.renderContext;
    }

    @NonNull
    private Bitmap readBitmap(CGSize cGSize) {
        if (this.outputBitmapFactory == null) {
            this.outputBitmapFactory = new DefaultBitmapFactory(null);
        }
        Bitmap outputBitmap = this.outputBitmapFactory.getOutputBitmap((int) cGSize.width, (int) cGSize.height);
        if (outputBitmap.getConfig() != Bitmap.Config.ARGB_8888 && outputBitmap.getConfig() != Bitmap.Config.ARGB_4444) {
            Log.e(this.TAG, "readBitmap: bitmap \u683c\u5f0f\u9519\u8bef\uff1a\u6682\u65f6\u53ea\u652f\u6301ARGB_8888\u3001ARGB_4444\u683c\u5f0f");
            return outputBitmap;
        }
        int width = outputBitmap.getWidth() * outputBitmap.getHeight() * 4;
        ByteBuffer byteBuffer = this.outBitmapReaderBuffer;
        if (byteBuffer == null || byteBuffer.capacity() < width) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(width);
            this.outBitmapReaderBuffer = allocateDirect;
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            this.outBitmapReaderBuffer.rewind();
            this.outBitmapReaderBuffer.clear();
        }
        GLES20.glReadPixels(0, 0, outputBitmap.getWidth(), outputBitmap.getHeight(), 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.outBitmapReaderBuffer);
        this.outBitmapReaderBuffer.rewind();
        outputBitmap.copyPixelsFromBuffer(this.outBitmapReaderBuffer);
        this.outBitmapReaderBuffer.clear();
        return outputBitmap;
    }

    @NonNull
    private Bitmap readBitmapFromTexture(@NonNull RenderContext renderContext, TextureInfo textureInfo) {
        renderContext.makeCurrent();
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, textureInfo.textureID, 0);
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

    @NonNull
    private CGSize renderToMaximumSizeBox(RenderContext renderContext, CMSampleBuffer cMSampleBuffer) {
        TextureInfo textureInfo = cMSampleBuffer.getTextureInfo();
        CGSize cGSize = this.maximumSize;
        if (cGSize == null) {
            cGSize = new CGSize(textureInfo.width, textureInfo.height);
        }
        if (textureInfo != null) {
            Filter filter = new Filter();
            filter.setRendererWidth((int) cGSize.width);
            filter.setRendererHeight((int) cGSize.height);
            Matrix matrix = getMatrix(this.maximumSize, new CGSize(textureInfo.width, textureInfo.height));
            renderContext.makeCurrent();
            Matrix matrix2 = new Matrix();
            matrix2.setValues(new float[]{1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f});
            filter.applyFilter(textureInfo, matrix, matrix2);
            renderContext.setPresentationTime(cMSampleBuffer.getTime().getTimeUs());
            renderContext.swapBuffers();
        }
        return cGSize;
    }

    public Bitmap copyCGImageAtTimeAndActualTime(CMTime cMTime, CMTime cMTime2) throws Exception {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return doGenerator(cMTime);
        }
        throw new Exception("cannot process in the main thread");
    }

    public void generateCGImagesAsynchronouslyForTimes(List<CMTime> list, ImageGeneratorListener imageGeneratorListener) {
        this.generatorThread.setRequestedTimes(list);
        this.generatorThread.setGeneratorListener(imageGeneratorListener);
        this.generatorThread.generatorCover();
    }

    public AssetExtension getAssetExtension() {
        return this.assetExtension;
    }

    @Nullable
    public RenderContextParams getRenderContextParams() {
        return this.renderContextParams;
    }

    public void release() {
        release(false);
    }

    public void setApertureMode(ApertureMode apertureMode) {
        this.apertureMode = apertureMode;
    }

    public void setAppliesPreferredTrackTransform(boolean z16) {
        this.appliesPreferredTrackTransform = z16;
    }

    public void setForceUseFbo(boolean z16) {
        this.forceUseFbo = z16;
    }

    public void setMaximumSize(CGSize cGSize) {
        this.maximumSize = cGSize;
    }

    public void setOutSavePath(String str) {
        this.outSavePath = str;
    }

    public void setOutputBitmapFactory(OutputBitmapFactory outputBitmapFactory) {
        this.outputBitmapFactory = outputBitmapFactory;
    }

    public void setRenderContextParams(@Nullable RenderContextParams renderContextParams) {
        this.renderContextParams = renderContextParams;
        RenderContext renderContext = this.renderContext;
        if (renderContext != null) {
            renderContext.setParams(renderContextParams);
        }
    }

    public void setVideoComposition(VideoComposition videoComposition) {
        this.videoComposition = videoComposition;
    }

    public AssetImageGenerator(Asset asset, AssetExtension assetExtension) {
        String str = "AssetImageGenerator@" + Integer.toHexString(hashCode());
        this.TAG = str;
        this.generatorThreadId = -1L;
        this.forceUseFbo = false;
        Logger.i(str, "AssetImageGenerator() called with: asset = [" + asset + "], assetExtension = [" + assetExtension + "]");
        this.asset = asset;
        this.assetExtension = assetExtension;
        this.apertureMode = ApertureMode.aspectFit;
        ImageGeneratorThread imageGeneratorThread = new ImageGeneratorThread("image_generator");
        this.generatorThread = imageGeneratorThread;
        imageGeneratorThread.start();
        imageGeneratorThread.initHandler();
    }

    public void release(boolean z16) {
        if (Thread.currentThread().getId() != this.generatorThreadId) {
            this.generatorThread.release(z16);
            this.videoComposition = null;
        } else {
            doRelease();
            this.generatorThread.quit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class ImageGeneratorThread extends BaseHandlerThread implements Handler.Callback {
        private static final int MSG_CREATE_RENDERCONTEXT = 3;
        private static final int MSG_GENERATOR_COVER = 1;
        private static final int MSG_RELEASE = 2;
        private ImageGeneratorListener generatorListener;
        private Handler handler;
        private List<CMTime> requestedTimes;

        public ImageGeneratorThread(String str) {
            super(str);
        }

        private void generatorCover(CMTime cMTime) {
            Bitmap bitmap;
            try {
                bitmap = AssetImageGenerator.this.copyCGImageAtTimeAndActualTime(cMTime, null);
            } catch (Exception e16) {
                Logger.e(AssetImageGenerator.this.TAG, "handleMessage: ", e16);
                bitmap = null;
            }
            ImageGeneratorListener imageGeneratorListener = this.generatorListener;
            if (imageGeneratorListener == null) {
                Logger.e(AssetImageGenerator.this.TAG, "generatorCover: generatorListener is null!");
            } else {
                imageGeneratorListener.onCompletion(cMTime, bitmap, null, bitmap != null ? AssetImageGeneratorResult.AssetImageGeneratorSucceeded : AssetImageGeneratorResult.AssetImageGeneratorFailed);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void initHandler() {
            this.handler = new Handler(getLooper(), this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void release(boolean z16) {
            if (z16) {
                this.handler.removeCallbacksAndMessages(null);
            }
            Message obtain = Message.obtain();
            obtain.what = 2;
            this.handler.sendMessage(obtain);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2) {
                    this.handler.removeCallbacksAndMessages(null);
                    AssetImageGenerator.this.doRelease();
                    quit();
                    return false;
                }
                return false;
            }
            generatorCover((CMTime) message.obj);
            return false;
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
        }

        public void setGeneratorListener(ImageGeneratorListener imageGeneratorListener) {
            this.generatorListener = imageGeneratorListener;
        }

        public void setRequestedTimes(List<CMTime> list) {
            this.requestedTimes = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void generatorCover() {
            Logger.i(AssetImageGenerator.this.TAG, "generatorCover() called, times = " + this.requestedTimes);
            for (CMTime cMTime : this.requestedTimes) {
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = cMTime;
                this.handler.sendMessage(obtain);
            }
        }
    }
}
