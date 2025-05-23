package com.tencent.qcircle.weseevideo.model.effect;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.ads.data.AdParam;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.tavcut.view.TAVCutImageViewKt;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.tav.coremedia.CGSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 02\u00020\u0001:\u00010B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\"H\u0002J\u001e\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u0013J\u001e\u0010'\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u0013J\u001e\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020\"J\u0006\u0010.\u001a\u00020\"J\u0016\u0010/\u001a\u00020\"2\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u00061"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/effect/GestureModel;", "", "()V", "corners", "", "Landroid/graphics/PointF;", "currentCenter", "getCurrentCenter", "()Landroid/graphics/PointF;", "setCurrentCenter", "(Landroid/graphics/PointF;)V", "gMatrix", "Landroid/graphics/Matrix;", "getGMatrix", "()Landroid/graphics/Matrix;", "originCenter", "getOriginCenter", "setOriginCenter", CanvasView.ACTION_ROTATE, "", "getRotate", "()F", "setRotate", "(F)V", "scale", "getScale", "setScale", AdParam.SCREENSIZE, "Lcom/tencent/tav/coremedia/CGSize;", "getScreenSize", "()Lcom/tencent/tav/coremedia/CGSize;", "setScreenSize", "(Lcom/tencent/tav/coremedia/CGSize;)V", "clearCorners", "", "postRotate", "degree", "focusX", "focusY", "postScale", "postTranslate", "dx", "dy", "rectF", "Landroid/graphics/RectF;", "reset", "resetCurrentCenter", "setCorner", "Companion", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class GestureModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static float MAX_SCALE = 2.0f;
    private static float MIN_SCALE = 0.25f;
    private List<? extends PointF> corners;

    @Nullable
    private PointF currentCenter;

    @Nullable
    private PointF originCenter;
    private float rotate;

    @Nullable
    private CGSize screenSize;
    private float scale = 1.0f;

    @NotNull
    private final Matrix gMatrix = new Matrix();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/effect/GestureModel$Companion;", "", "()V", "MAX_SCALE", "", "getMAX_SCALE", "()F", "setMAX_SCALE", "(F)V", "MIN_SCALE", "getMIN_SCALE", "setMIN_SCALE", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public static final class Companion {
        Companion() {
        }

        public final float getMAX_SCALE() {
            return GestureModel.MAX_SCALE;
        }

        public final float getMIN_SCALE() {
            return GestureModel.MIN_SCALE;
        }

        public final void setMAX_SCALE(float f16) {
            GestureModel.MAX_SCALE = f16;
        }

        public final void setMIN_SCALE(float f16) {
            GestureModel.MIN_SCALE = f16;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void clearCorners() {
        this.corners = null;
    }

    @Nullable
    public final PointF getCurrentCenter() {
        return this.currentCenter;
    }

    @NotNull
    public final Matrix getGMatrix() {
        return this.gMatrix;
    }

    @Nullable
    public final PointF getOriginCenter() {
        return this.originCenter;
    }

    public final float getRotate() {
        return this.rotate;
    }

    public final float getScale() {
        return this.scale;
    }

    @Nullable
    public final CGSize getScreenSize() {
        return this.screenSize;
    }

    public final void postRotate(float degree, float focusX, float focusY) {
        this.rotate += degree;
        this.gMatrix.postRotate(degree, focusX, focusY);
        resetCurrentCenter();
    }

    public final void postScale(float scale, float focusX, float focusY) {
        float f16 = this.scale;
        float f17 = scale * f16;
        float f18 = MAX_SCALE;
        if (f17 > f18) {
            scale = f18 / f16;
        }
        float f19 = scale * f16;
        float f26 = MIN_SCALE;
        if (f19 < f26) {
            scale = f26 / f16;
        }
        this.scale = f16 * scale;
        this.gMatrix.postScale(scale, scale, focusX, focusY);
        resetCurrentCenter();
    }

    public final void postTranslate(float dx5, float dy5, @NotNull RectF rectF) {
        float f16;
        float f17;
        Intrinsics.checkParameterIsNotNull(rectF, "rectF");
        PointF pointF = this.currentCenter;
        if (pointF != null) {
            float f18 = pointF.x;
            float f19 = f18 + dx5;
            float f26 = rectF.left;
            if (f19 < f26) {
                f16 = f26 - f18;
            } else {
                f16 = dx5;
            }
            float f27 = dx5 + f18;
            float f28 = rectF.right;
            if (f27 > f28) {
                dx5 = f28 - f18;
            } else {
                dx5 = f16;
            }
            float f29 = pointF.y;
            float f36 = f29 + dy5;
            float f37 = rectF.top;
            if (f36 < f37) {
                f17 = f37 - f29;
            } else {
                f17 = dy5;
            }
            float f38 = dy5 + f29;
            float f39 = rectF.bottom;
            if (f38 > f39) {
                dy5 = f39 - f29;
            } else {
                dy5 = f17;
            }
        }
        Logger.e("GestureModel", "x = " + dx5);
        Logger.e("GestureModel", "y = " + dy5);
        this.gMatrix.postTranslate(dx5, dy5);
        resetCurrentCenter();
    }

    public final void reset() {
        this.gMatrix.reset();
        this.rotate = 0.0f;
        this.scale = 1.0f;
        this.originCenter = null;
        this.currentCenter = null;
        clearCorners();
    }

    public final void resetCurrentCenter() {
        float f16;
        PointF pointF = this.originCenter;
        if (pointF != null) {
            float[] fArr = new float[2];
            for (int i3 = 0; i3 < 2; i3++) {
                if (i3 == 0) {
                    f16 = pointF.x;
                } else {
                    f16 = pointF.y;
                }
                fArr[i3] = f16;
            }
            this.gMatrix.mapPoints(fArr);
            if (this.currentCenter == null) {
                this.currentCenter = new PointF();
                Unit unit = Unit.INSTANCE;
            }
            PointF pointF2 = this.currentCenter;
            if (pointF2 != null) {
                pointF2.x = fArr[0];
                pointF2.y = fArr[1];
            }
        }
    }

    public final void setCorner(@Nullable List<? extends PointF> corners) {
        if (corners != null && this.corners == null && corners.size() >= 4) {
            this.corners = corners;
            float f16 = 0.0f;
            int i3 = -1;
            for (int i16 = 1; i16 <= 3; i16++) {
                float calcDistance = TAVCutImageViewKt.calcDistance(corners.get(0), corners.get(i16));
                if (calcDistance > f16) {
                    i3 = i16;
                    f16 = calcDistance;
                }
            }
            float f17 = 2;
            this.originCenter = new PointF((corners.get(0).x + corners.get(i3).x) / f17, (corners.get(0).y + corners.get(i3).y) / f17);
        }
    }

    public final void setCurrentCenter(@Nullable PointF pointF) {
        this.currentCenter = pointF;
    }

    public final void setOriginCenter(@Nullable PointF pointF) {
        this.originCenter = pointF;
    }

    public final void setRotate(float f16) {
        this.rotate = f16;
    }

    public final void setScale(float f16) {
        this.scale = f16;
    }

    public final void setScreenSize(@Nullable CGSize cGSize) {
        this.screenSize = cGSize;
    }
}
