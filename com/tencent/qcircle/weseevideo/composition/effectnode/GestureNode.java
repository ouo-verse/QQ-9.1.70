package com.tencent.qcircle.weseevideo.composition.effectnode;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qcircle.weseevideo.model.effect.GestureModel;
import com.tencent.tav.core.CGMathFunctions;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.Filter;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qcircle/weseevideo/composition/effectnode/GestureNode;", "Lcom/tencent/tavkit/composition/video/TAVVideoEffect;", "()V", "gestureModel", "Lcom/tencent/qcircle/weseevideo/model/effect/GestureModel;", "getGestureModel", "()Lcom/tencent/qcircle/weseevideo/model/effect/GestureModel;", "setGestureModel", "(Lcom/tencent/qcircle/weseevideo/model/effect/GestureModel;)V", "mEffectId", "", "renderSize", "Lcom/tencent/tav/coremedia/CGSize;", "getRenderSize", "()Lcom/tencent/tav/coremedia/CGSize;", "setRenderSize", "(Lcom/tencent/tav/coremedia/CGSize;)V", "createFilter", "Lcom/tencent/tavkit/composition/video/TAVVideoEffect$Filter;", "effectId", "GestureFilter", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class GestureNode implements TAVVideoEffect {

    @Nullable
    private CGSize renderSize;
    private final String mEffectId = "GestureNode" + Integer.toHexString(hashCode());

    @NotNull
    private GestureModel gestureModel = new GestureModel();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qcircle/weseevideo/composition/effectnode/GestureNode$GestureFilter;", "Lcom/tencent/tavkit/composition/video/TAVVideoEffect$Filter;", "(Lcom/tencent/qcircle/weseevideo/composition/effectnode/GestureNode;)V", "matrixFilter", "Lcom/tencent/tav/decoder/Filter;", "srcTextureInfo", "Lcom/tencent/tav/coremedia/TextureInfo;", "apply", "Lcom/tencent/tavkit/ciimage/CIImage;", QQWinkConstants.TAB_EFFECT, "Lcom/tencent/tavkit/composition/video/TAVVideoEffect;", "sourceImage", "renderInfo", "Lcom/tencent/tavkit/composition/video/RenderInfo;", "getRect2DisplayMatrix", "Landroid/graphics/Matrix;", "sourceSize", "Lcom/tencent/tav/coremedia/CGSize;", "targetSize", "readInputCIImage", "", "release", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public final class GestureFilter implements TAVVideoEffect.Filter {
        private final Filter matrixFilter;
        private TextureInfo srcTextureInfo;

        public GestureFilter() {
            Filter filter = new Filter();
            filter.setRenderForScreen(false);
            this.matrixFilter = filter;
        }

        private final Matrix getRect2DisplayMatrix(CGSize sourceSize, CGSize targetSize) {
            Matrix transformBySourceRectFit = CGMathFunctions.transformBySourceRectFit(new CGRect(new PointF(), sourceSize), new CGRect(new PointF(), targetSize));
            Intrinsics.checkExpressionValueIsNotNull(transformBySourceRectFit, "CGMathFunctions.transfor\u2026t(sourceRect, targetRect)");
            return transformBySourceRectFit;
        }

        private final void readInputCIImage(CIImage sourceImage, RenderInfo renderInfo) {
            CIContext ciContext = renderInfo.getCiContext();
            Intrinsics.checkExpressionValueIsNotNull(ciContext, "renderInfo.ciContext");
            int i3 = (int) sourceImage.getSize().width;
            int i16 = (int) sourceImage.getSize().height;
            if (this.srcTextureInfo == null) {
                this.srcTextureInfo = CIContext.newTextureInfo(i3, i16);
            }
            TextureInfo textureInfo = this.srcTextureInfo;
            if (textureInfo == null || textureInfo.width != i3 || textureInfo == null || textureInfo.height != i16) {
                if (textureInfo != null) {
                    textureInfo.release();
                }
                this.srcTextureInfo = CIContext.newTextureInfo(i3, i16);
            }
            ciContext.convertImageToTexture(sourceImage, this.srcTextureInfo);
        }

        @Override // com.tencent.tavkit.composition.video.TAVVideoEffect.Filter
        @NotNull
        public CIImage apply(@NotNull TAVVideoEffect effect, @NotNull CIImage sourceImage, @NotNull RenderInfo renderInfo) {
            Intrinsics.checkParameterIsNotNull(effect, "effect");
            Intrinsics.checkParameterIsNotNull(sourceImage, "sourceImage");
            Intrinsics.checkParameterIsNotNull(renderInfo, "renderInfo");
            sourceImage.applyFlip(false, true);
            readInputCIImage(sourceImage, renderInfo);
            CGSize screenSize = GestureNode.this.getGestureModel().getScreenSize();
            if (screenSize == null) {
                screenSize = new CGSize(sourceImage.getSize().width, sourceImage.getSize().height);
            }
            CGSize size = sourceImage.getSize();
            Intrinsics.checkExpressionValueIsNotNull(size, "sourceImage.size");
            Matrix rect2DisplayMatrix = getRect2DisplayMatrix(size, screenSize);
            Matrix matrix = new Matrix();
            rect2DisplayMatrix.invert(matrix);
            rect2DisplayMatrix.postConcat(GestureNode.this.getGestureModel().getGMatrix());
            new Matrix(rect2DisplayMatrix);
            rect2DisplayMatrix.postConcat(matrix);
            this.matrixFilter.setRendererWidth((int) sourceImage.getSize().width);
            this.matrixFilter.setRendererHeight((int) sourceImage.getSize().height);
            CIImage cIImage = new CIImage(this.matrixFilter.applyFilter(this.srcTextureInfo, rect2DisplayMatrix, new Matrix()));
            cIImage.applyFlip(false, true);
            return cIImage;
        }

        @Override // com.tencent.tavkit.composition.video.Releasable
        public void release() {
            this.matrixFilter.release();
            TextureInfo textureInfo = this.srcTextureInfo;
            if (textureInfo != null) {
                textureInfo.release();
            }
        }
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoEffect
    @NotNull
    public TAVVideoEffect.Filter createFilter() {
        return new GestureFilter();
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoEffect
    @NotNull
    /* renamed from: effectId, reason: from getter */
    public String getMEffectId() {
        return this.mEffectId;
    }

    @NotNull
    public final GestureModel getGestureModel() {
        return this.gestureModel;
    }

    @Nullable
    public final CGSize getRenderSize() {
        return this.renderSize;
    }

    public final void setGestureModel(@NotNull GestureModel gestureModel) {
        Intrinsics.checkParameterIsNotNull(gestureModel, "<set-?>");
        this.gestureModel = gestureModel;
    }

    public final void setRenderSize(@Nullable CGSize cGSize) {
        this.renderSize = cGSize;
    }
}
