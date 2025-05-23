package com.tencent.qcircle.weseevideo.composition.image;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Surface;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.qcircle.weseevideo.composition.TAVAutomaticTransRenderContext;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tav.core.CGMathFunctions;
import com.tencent.tav.core.VideoCompositionDecoderTrack;
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
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AssetImageGenerator {
    private final String TAG;
    private ApertureMode apertureMode;
    private boolean appliesPreferredTrackTransform;
    protected Asset asset;
    protected AssetExtension assetExtension;
    private EGLContext eglContext;
    private ImageGeneratorThread generatorThread;
    private long generatorThreadId;

    @Nullable
    private CGSize maximumSize;
    private Bitmap outBitmap;
    private ByteBuffer outBitmapReaderBuffer;
    private String outSavePath;
    private RenderContext renderContext;

    @Nullable
    private RenderContextParams renderContextParams;
    private Runnable runnable;
    private TAVAutomaticTransRenderContext transRenderContext;
    private VideoCompositing videoCompositing;
    private VideoComposition videoComposition;
    private VideoCompositionDecoderTrack videoCompositionDecoderTrack;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.qcircle.weseevideo.composition.image.AssetImageGenerator$2, reason: invalid class name */
    /* loaded from: classes22.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$qcircle$weseevideo$composition$image$AssetImageGenerator$ApertureMode;

        static {
            int[] iArr = new int[ApertureMode.values().length];
            $SwitchMap$com$tencent$qcircle$weseevideo$composition$image$AssetImageGenerator$ApertureMode = iArr;
            try {
                iArr[ApertureMode.aspectFit.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$qcircle$weseevideo$composition$image$AssetImageGenerator$ApertureMode[ApertureMode.aspectFill.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$qcircle$weseevideo$composition$image$AssetImageGenerator$ApertureMode[ApertureMode.scaleToFit.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public enum ApertureMode {
        aspectFit,
        aspectFill,
        scaleToFit
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public enum AssetImageGeneratorResult {
        AssetImageGeneratorSucceeded,
        AssetImageGeneratorFailed,
        AssetImageGeneratorCancelled
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface ImageGeneratorListener {
        void onCompletion(@NonNull CMTime cMTime, @Nullable Bitmap bitmap, @Nullable List<PointF> list, @Nullable CMTime cMTime2, @NonNull AssetImageGeneratorResult assetImageGeneratorResult);
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class ImageGeneratorThread extends BaseHandlerThread implements Handler.Callback {
        private Handler handler;

        public ImageGeneratorThread(String str) {
            super(str);
        }

        public Handler getHandler() {
            return this.handler;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            return true;
        }

        public void initHandler() {
            this.handler = new Handler(getLooper(), this);
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
        }
    }

    public AssetImageGenerator(Asset asset) {
        this(asset, new AssetExtension(AssetExtension.SCENE_THUMBNAIL));
    }

    @Nullable
    private Bitmap bitmapFromFBO(@NonNull RenderContext renderContext, CMSampleBuffer cMSampleBuffer) {
        Matrix matrix;
        TextureInfo textureInfo = cMSampleBuffer.getTextureInfo();
        Bitmap bitmap = null;
        if (textureInfo == null) {
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
        try {
            try {
                bitmap = Bitmap.createBitmap(readBitmapFromTexture, 0, 0, (int) cGSize.width, (int) cGSize.height, matrix, true);
            } catch (OutOfMemoryError e16) {
                Logger.e(this.TAG, e16.getMessage());
            }
            return bitmap;
        } finally {
            readBitmapFromTexture.recycle();
        }
    }

    @Nullable
    private Bitmap doGenerator(CMTime cMTime, RenderContext renderContext) {
        RenderContext initRenderContext = initRenderContext(renderContext);
        this.renderContext = initRenderContext;
        return bitmapFromFBO(this.renderContext, getCmSampleBuffer(cMTime, initRenderContext));
    }

    private void doRelease() {
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
        ByteBuffer byteBuffer = this.outBitmapReaderBuffer;
        if (byteBuffer != null) {
            byteBuffer.clear();
            this.outBitmapReaderBuffer = null;
        }
        BitmapUtils.recycle(this.outBitmap);
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
        int i3 = AnonymousClass2.$SwitchMap$com$tencent$qcircle$weseevideo$composition$image$AssetImageGenerator$ApertureMode[this.apertureMode.ordinal()];
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
    private RenderContext initRenderContext(RenderContext renderContext) {
        CGSize cGSize = this.maximumSize;
        if (cGSize == null) {
            cGSize = this.asset.getNaturalSize();
        }
        RenderContext renderContext2 = this.renderContext;
        if (renderContext2 == null) {
            if (renderContext == null) {
                this.renderContext = new RenderContext((int) cGSize.width, (int) cGSize.height, (Surface) null, this.eglContext);
            } else {
                this.renderContext = renderContext;
                renderContext.setWidth((int) cGSize.width);
                this.renderContext.setHeight((int) cGSize.height);
            }
            this.renderContext.setParams(this.renderContextParams);
        } else {
            renderContext2.setWidth((int) cGSize.width);
            this.renderContext.setHeight((int) cGSize.height);
        }
        this.renderContext.makeCurrent();
        return this.renderContext;
    }

    @NonNull
    private Bitmap readBitmap(CGSize cGSize) {
        int i3 = ((int) cGSize.width) * ((int) cGSize.height) * 4;
        Bitmap bitmap = this.outBitmap;
        if (bitmap == null || bitmap.getByteCount() != i3) {
            BitmapUtils.recycle(this.outBitmap);
            this.outBitmap = Bitmap.createBitmap((int) cGSize.width, (int) cGSize.height, Bitmap.Config.ARGB_8888);
        }
        ByteBuffer byteBuffer = this.outBitmapReaderBuffer;
        if (byteBuffer == null || byteBuffer.capacity() < i3) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i3);
            this.outBitmapReaderBuffer = allocateDirect;
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            this.outBitmapReaderBuffer.rewind();
            this.outBitmapReaderBuffer.clear();
        }
        GLES20.glReadPixels(0, 0, this.outBitmap.getWidth(), this.outBitmap.getHeight(), 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.outBitmapReaderBuffer);
        this.outBitmapReaderBuffer.rewind();
        this.outBitmap.copyPixelsFromBuffer(this.outBitmapReaderBuffer);
        this.outBitmapReaderBuffer.clear();
        return this.outBitmap;
    }

    @NotNull
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

    private void removeGenerateMessage() {
        ImageGeneratorThread imageGeneratorThread = this.generatorThread;
        if (imageGeneratorThread != null && imageGeneratorThread.getHandler() != null) {
            this.generatorThread.getHandler().removeCallbacks(this.runnable);
        }
    }

    @NonNull
    private CGSize renderToMaximumSizeBox(RenderContext renderContext, CMSampleBuffer cMSampleBuffer) {
        TextureInfo textureInfo = cMSampleBuffer.getTextureInfo();
        CGSize cGSize = this.maximumSize;
        if (cGSize == null) {
            cGSize = new CGSize(textureInfo.width, textureInfo.height);
        }
        renderContext.updateViewport(new CGRect(new PointF(0.0f, 0.0f), cGSize));
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

    public Bitmap copyCGImageAtTimeAndActualTime(CMTime cMTime, CMTime cMTime2, RenderContext renderContext) throws Exception {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return doGenerator(cMTime, renderContext);
        }
        throw new Exception("cannot process in the main thread");
    }

    public void generateCGImagesAsynchronouslyForTimes(final List<CMTime> list, final ImageGeneratorListener imageGeneratorListener, EGLContext eGLContext, ImageGeneratorThread imageGeneratorThread, final RenderContext renderContext) {
        this.generatorThread = imageGeneratorThread;
        this.eglContext = eGLContext;
        this.runnable = new Runnable() { // from class: com.tencent.qcircle.weseevideo.composition.image.AssetImageGenerator.1
            @Override // java.lang.Runnable
            public void run() {
                AssetImageGeneratorResult assetImageGeneratorResult;
                for (CMTime cMTime : list) {
                    Bitmap bitmap = null;
                    try {
                        bitmap = AssetImageGenerator.this.copyCGImageAtTimeAndActualTime(cMTime, null, renderContext);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        Logger.e(AssetImageGenerator.this.TAG, "generate bitmap failed", e16);
                    }
                    Bitmap bitmap2 = bitmap;
                    if (imageGeneratorListener != null) {
                        ArrayList arrayList = new ArrayList();
                        if (AssetImageGenerator.this.transRenderContext != null) {
                            arrayList = new ArrayList(AssetImageGenerator.this.transRenderContext.getImgInScrPoints());
                        }
                        ArrayList arrayList2 = arrayList;
                        ImageGeneratorListener imageGeneratorListener2 = imageGeneratorListener;
                        if (bitmap2 != null) {
                            assetImageGeneratorResult = AssetImageGeneratorResult.AssetImageGeneratorSucceeded;
                        } else {
                            assetImageGeneratorResult = AssetImageGeneratorResult.AssetImageGeneratorFailed;
                        }
                        imageGeneratorListener2.onCompletion(cMTime, bitmap2, arrayList2, null, assetImageGeneratorResult);
                    }
                }
            }
        };
        removeGenerateMessage();
        ImageGeneratorThread imageGeneratorThread2 = this.generatorThread;
        if (imageGeneratorThread2 != null && imageGeneratorThread2.getHandler() != null) {
            this.generatorThread.getHandler().post(this.runnable);
        }
    }

    public AssetExtension getAssetExtension() {
        return this.assetExtension;
    }

    @Nullable
    public RenderContextParams getRenderContextParams() {
        return this.renderContextParams;
    }

    public void release() {
        removeGenerateMessage();
        doRelease();
        this.videoComposition = null;
        this.generatorThread = null;
        this.eglContext = null;
    }

    public void setApertureMode(ApertureMode apertureMode) {
        this.apertureMode = apertureMode;
    }

    public void setAppliesPreferredTrackTransform(boolean z16) {
        this.appliesPreferredTrackTransform = z16;
    }

    public void setMaximumSize(CGSize cGSize) {
        this.maximumSize = cGSize;
    }

    public void setOutSavePath(String str) {
        this.outSavePath = str;
    }

    public void setRenderContextParams(@Nullable RenderContextParams renderContextParams) {
        this.renderContextParams = renderContextParams;
        RenderContext renderContext = this.renderContext;
        if (renderContext != null) {
            renderContext.setParams(renderContextParams);
        }
    }

    public void setTansRenderContext(TAVAutomaticTransRenderContext tAVAutomaticTransRenderContext) {
        this.transRenderContext = tAVAutomaticTransRenderContext;
    }

    public void setVideoComposition(VideoComposition videoComposition) {
        this.videoComposition = videoComposition;
    }

    public void updateAsset(Asset asset, CGSize cGSize) {
        this.maximumSize = cGSize;
        VideoCompositing videoCompositing = null;
        initRenderContext(null);
        this.videoCompositionDecoderTrack = new VideoCompositionDecoderTrack(asset, this.assetExtension, 1);
        for (AssetTrack assetTrack : asset.getTracks()) {
            if (assetTrack.getMediaType() == 1) {
                this.videoCompositionDecoderTrack.addTrack(assetTrack);
            }
        }
        this.videoCompositionDecoderTrack.setVideoComposition(this.videoComposition);
        VideoComposition videoComposition = this.videoComposition;
        if (videoComposition != null) {
            videoCompositing = videoComposition.getCustomVideoCompositor();
        }
        this.videoCompositing = videoCompositing;
        this.videoCompositionDecoderTrack.setVideoCompositing(videoCompositing);
        this.videoCompositionDecoderTrack.start(this.renderContext);
    }

    public AssetImageGenerator(Asset asset, AssetExtension assetExtension) {
        this.TAG = "AssetImageGenerator@" + Integer.toHexString(hashCode());
        this.generatorThreadId = -1L;
        this.asset = asset;
        this.assetExtension = assetExtension;
        this.apertureMode = ApertureMode.aspectFit;
    }
}
