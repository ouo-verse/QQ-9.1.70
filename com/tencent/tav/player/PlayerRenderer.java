package com.tencent.tav.player;

import android.graphics.Bitmap;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.tav.Utils;
import com.tencent.tav.core.CGMathFunctions;
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
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class PlayerRenderer {
    private static final String TAG = "PlayerRenderer";
    private Filter filter;

    @Nullable
    private CGRect glViewportRect;
    private VideoComposition.RenderLayoutMode layoutMode;

    @Nullable
    private Surface mDisplayTarget;

    @Nullable
    private OnReadSnapShootListener onReadSnapShootListener;
    private RenderContext renderContext;
    private RenderContextParams renderContextParams;

    @Nullable
    private CGSize renderSize;
    private CGSize surfaceSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.tav.player.PlayerRenderer$1, reason: invalid class name */
    /* loaded from: classes26.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$tav$core$composition$VideoComposition$RenderLayoutMode;

        static {
            int[] iArr = new int[VideoComposition.RenderLayoutMode.values().length];
            $SwitchMap$com$tencent$tav$core$composition$VideoComposition$RenderLayoutMode = iArr;
            try {
                iArr[VideoComposition.RenderLayoutMode.aspectFit.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$tav$core$composition$VideoComposition$RenderLayoutMode[VideoComposition.RenderLayoutMode.aspectFill.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void applyViewport() {
        CGRect cGRect;
        RenderContext renderContext = this.renderContext;
        if (renderContext != null && (cGRect = this.glViewportRect) != null) {
            renderContext.updateViewport(cGRect);
        }
    }

    private void checkCopyPixelBuffer(CMTime cMTime) {
        if (this.onReadSnapShootListener != null) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.renderContext.width() * this.renderContext.height() * 4);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            allocateDirect.rewind();
            GLES20.glReadPixels(0, 0, this.renderContext.width(), this.renderContext.height(), 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocateDirect);
            Bitmap createBitmap = Bitmap.createBitmap(this.renderContext.width(), this.renderContext.height(), Bitmap.Config.ARGB_4444);
            allocateDirect.rewind();
            createBitmap.copyPixelsFromBuffer(allocateDirect);
            this.onReadSnapShootListener.onSuccess(Utils.flipYBitmap(createBitmap), cMTime);
            this.onReadSnapShootListener = null;
        }
    }

    private void checkCopyPixelBufferByTexture(TextureInfo textureInfo, CMTime cMTime) {
        Bitmap bitmap;
        if (this.onReadSnapShootListener != null) {
            try {
                bitmap = tryCopyPixel(textureInfo);
            } catch (Exception e16) {
                Logger.e(TAG, "checkCopyPixelBufferByTexture: ", e16);
                bitmap = null;
            }
            this.onReadSnapShootListener.onSuccess(bitmap, cMTime);
            this.onReadSnapShootListener = null;
        }
    }

    private void initViewportByLayoutMode(CGSize cGSize) {
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$tav$core$composition$VideoComposition$RenderLayoutMode[this.layoutMode.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                this.glViewportRect = CGMathFunctions.initGLViewportDefault(this.surfaceSize, cGSize);
                return;
            } else {
                this.glViewportRect = CGMathFunctions.initGLViewportFill(this.surfaceSize, cGSize);
                return;
            }
        }
        this.glViewportRect = CGMathFunctions.initGLViewportFit(this.surfaceSize, cGSize);
    }

    private Bitmap tryCopyPixel(TextureInfo textureInfo) throws Exception {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(textureInfo.width * textureInfo.height * 4);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        allocateDirect.rewind();
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, textureInfo.textureType, textureInfo.textureID, 0);
        GLES20.glReadPixels(0, 0, textureInfo.width, textureInfo.height, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocateDirect);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        RenderContext.checkEglActionSuccess("CopyPixel", true);
        Bitmap createBitmap = Bitmap.createBitmap(textureInfo.width, textureInfo.height, Bitmap.Config.ARGB_4444);
        allocateDirect.rewind();
        createBitmap.copyPixelsFromBuffer(allocateDirect);
        return Utils.flipYBitmap(createBitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bindSurface(PlayerLayer playerLayer) {
        this.mDisplayTarget = playerLayer.surface;
        setSurfaceSize(new CGSize(playerLayer.surfaceWidth, playerLayer.surfaceHeight));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public CGRect getGlViewportRect() {
        return this.glViewportRect;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RenderContext getRenderContext() {
        return this.renderContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RenderContextParams getRenderContextParams() {
        return this.renderContextParams;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initRenderContext() {
        EGLContext eGLContext;
        if (this.renderContext == null && this.mDisplayTarget != null) {
            RenderContextParams renderContextParams = this.renderContextParams;
            if (renderContextParams != null && (renderContextParams.getParam("share_context") instanceof EGLContext)) {
                eGLContext = (EGLContext) this.renderContextParams.getParam("share_context");
            } else {
                eGLContext = null;
            }
            CGSize cGSize = this.surfaceSize;
            RenderContext renderContext = new RenderContext((int) cGSize.width, (int) cGSize.height, this.mDisplayTarget, eGLContext);
            this.renderContext = renderContext;
            renderContext.setParams(this.renderContextParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initRenderSize(VideoComposition videoComposition) {
        CGSize cGSize;
        if (videoComposition != null) {
            this.renderSize = videoComposition.getRenderSize();
            this.layoutMode = videoComposition.getRenderLayoutMode();
        }
        RenderContext renderContext = this.renderContext;
        if (renderContext != null && (cGSize = this.renderSize) != null) {
            renderContext.setHeight((int) cGSize.height);
            this.renderContext.setWidth((int) this.renderSize.width);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initViewport(Handler handler, boolean z16) {
        CGSize cGSize = this.renderSize;
        if (cGSize == null) {
            cGSize = this.surfaceSize;
        }
        if (this.layoutMode == null) {
            this.glViewportRect = CGMathFunctions.initGLViewportDefault(this.surfaceSize, cGSize);
        } else {
            initViewportByLayoutMode(cGSize);
        }
        applyViewport();
        if (z16) {
            this.renderContext.swapBuffers();
        }
        handler.obtainMessage(3, this.glViewportRect).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void makeCurrent() {
        this.renderContext.makeCurrent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void releaseFilter() {
        Filter filter = this.filter;
        if (filter != null) {
            filter.release();
            this.filter = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void releaseRenderContext() {
        this.renderContext.release();
        this.renderContext = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void renderSampleBuffer(CMSampleBuffer cMSampleBuffer, int i3, OnGetTavExtraListener onGetTavExtraListener) {
        Logger.v(TAG, "renderSampleBuffer() called with: sampleBuffer = [" + cMSampleBuffer + "]");
        if (cMSampleBuffer.getTextureInfo() != null) {
            if (this.filter == null) {
                Filter filter = new Filter();
                this.filter = filter;
                filter.setRendererWidth(this.renderContext.width());
                this.filter.setRendererHeight(this.renderContext.height());
            }
            this.renderContext.makeCurrent();
            TextureInfo textureInfo = cMSampleBuffer.getTextureInfo();
            checkCopyPixelBufferByTexture(textureInfo, cMSampleBuffer.getTime());
            if (onGetTavExtraListener != null) {
                onGetTavExtraListener.getTextureInfo(textureInfo);
                return;
            }
            applyViewport();
            this.filter.setBgColor(i3);
            this.filter.applyFilter(textureInfo, null, textureInfo.getTextureMatrix());
            this.renderContext.setPresentationTime(cMSampleBuffer.getTime().getTimeUs());
            this.renderContext.swapBuffers();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnReadSnapShootListener(@Nullable OnReadSnapShootListener onReadSnapShootListener) {
        this.onReadSnapShootListener = onReadSnapShootListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRenderContextParams(RenderContextParams renderContextParams) {
        this.renderContextParams = renderContextParams;
        RenderContext renderContext = this.renderContext;
        if (renderContext != null) {
            renderContext.setParams(renderContextParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSurfaceSize(CGSize cGSize) {
        this.surfaceSize = cGSize;
    }
}
