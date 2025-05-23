package com.tencent.mobileqq.wink.utils;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0014\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b7\u00108J0\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J(\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\nJ\u001e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJF\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nJ\u001a\u0010\u001f\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002J\u001a\u0010 \u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002J\u001a\u0010!\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002J\u000e\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020\rJ\u000e\u0010%\u001a\u00020#2\u0006\u0010\"\u001a\u00020\rJ\u000e\u0010'\u001a\u00020\r2\u0006\u0010&\u001a\u00020#J\u000e\u0010)\u001a\u00020#2\u0006\u0010(\u001a\u00020#J\u0016\u0010,\u001a\u00020\b2\u0006\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020\u0002J\u001e\u0010-\u001a\u00020\n2\u0006\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020#J\u0018\u0010/\u001a\u0004\u0018\u00010\u00022\u0006\u0010*\u001a\u00020#2\u0006\u00100\u001a\u00020\u0002J*\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0002032\u0006\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u0002J\u0016\u00106\u001a\u00020\n2\u0006\u00104\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u0002\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/u;", "", "Landroid/graphics/PointF;", "curPoint", "pointLT", "pointRT", "pointLB", "pointRB", "", "o", "", HippyTKDListViewAdapter.X, "y", "Landroid/graphics/RectF;", "rectF", "roteAngle", "l", "Landroid/graphics/Matrix;", "matrix", "j", "linePointX1", "linePointY1", "linePointX2", "linePointY2", "_rectangleLeftTopX", "_rectangleLeftTopY", "_rectangleRightBottomX", "_rectangleRightBottomY", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "pointOne", "pointTwo", "g", tl.h.F, "i", "r", "", "f", "e", HippyControllerProps.ARRAY, "p", "corners", "k", "rectCorners", "point", DomainData.DOMAIN_NAME, "a", "b", "c", "target", "lineA", "lineB", "Lkotlin/Pair;", "pointA", "pointB", "d", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final u f326728a = new u();

    u() {
    }

    private final boolean o(PointF curPoint, PointF pointLT, PointF pointRT, PointF pointLB, PointF pointRB) {
        boolean z16;
        float coerceAtMost;
        float coerceAtLeast;
        PointF[] pointFArr = {pointLT, pointLB, pointRB, pointRT};
        int i3 = 0;
        int i16 = 0;
        while (i3 < 4) {
            PointF pointF = pointFArr[i3];
            i3++;
            PointF pointF2 = pointFArr[i3 % 4];
            float f16 = pointF.y;
            float f17 = pointF2.y;
            if (f16 == f17) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                float f18 = curPoint.y;
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(f16, f17);
                if (f18 >= coerceAtMost) {
                    float f19 = curPoint.y;
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(pointF.y, pointF2.y);
                    if (f19 <= coerceAtLeast) {
                        double d16 = curPoint.y - pointF.y;
                        float f26 = pointF2.x;
                        if (((d16 * (f26 - r8)) / (pointF2.y - r11)) + pointF.x > curPoint.x) {
                            i16++;
                        }
                    }
                }
            }
        }
        if (i16 % 2 != 1) {
            return false;
        }
        return true;
    }

    public final float a(@NotNull float[] a16, @NotNull float[] b16, @NotNull float[] c16) {
        Intrinsics.checkNotNullParameter(a16, "a");
        Intrinsics.checkNotNullParameter(b16, "b");
        Intrinsics.checkNotNullParameter(c16, "c");
        if (a16.length == 2 && b16.length == 2 && c16.length == 2) {
            float[] fArr = {b16[0] - a16[0], b16[1] - a16[1]};
            return (fArr[0] * (c16[1] - a16[1])) - (fArr[1] * (c16[0] - a16[0]));
        }
        return 0.0f;
    }

    @NotNull
    public final Pair<Boolean, PointF> b(@NotNull PointF lineA, @NotNull PointF lineB, @NotNull PointF target) {
        boolean z16;
        Intrinsics.checkNotNullParameter(lineA, "lineA");
        Intrinsics.checkNotNullParameter(lineB, "lineB");
        Intrinsics.checkNotNullParameter(target, "target");
        float f16 = lineA.x;
        float f17 = lineB.x;
        boolean z17 = false;
        if (f16 == f17) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (target.y < Math.min(lineA.y, lineB.y)) {
                return new Pair<>(Boolean.FALSE, new PointF(lineA.x, Math.min(lineA.y, lineB.y)));
            }
            if (target.y > Math.max(lineA.y, lineB.y)) {
                return new Pair<>(Boolean.FALSE, new PointF(lineA.x, Math.max(lineA.y, lineB.y)));
            }
            return new Pair<>(Boolean.TRUE, new PointF(lineA.x, target.y));
        }
        float f18 = lineA.y;
        float f19 = lineB.y;
        if (f18 == f19) {
            z17 = true;
        }
        if (z17) {
            if (target.x < Math.min(f16, f17)) {
                return new Pair<>(Boolean.FALSE, new PointF(Math.min(lineA.x, lineB.x), lineA.y));
            }
            if (target.x > Math.max(lineA.x, lineB.x)) {
                return new Pair<>(Boolean.FALSE, new PointF(Math.max(lineA.x, lineB.x), lineA.y));
            }
            return new Pair<>(Boolean.TRUE, new PointF(target.x, lineA.y));
        }
        float f26 = (f19 - f18) / (f17 - f16);
        double d16 = f26;
        double d17 = 2;
        float pow = (((((float) Math.pow(d16, d17)) * lineA.x) + ((target.y - lineA.y) * f26)) + target.x) / (((float) Math.pow(d16, d17)) + 1);
        float f27 = lineA.x;
        float f28 = (f26 * (pow - f27)) + lineA.y;
        if (pow >= Math.min(f27, lineB.x) && pow <= Math.max(lineA.x, lineB.x)) {
            return new Pair<>(Boolean.TRUE, new PointF(pow, f28));
        }
        if (d(lineA, new PointF(pow, f28)) > d(lineB, new PointF(pow, f28))) {
            return new Pair<>(Boolean.FALSE, new PointF(lineA.x, lineA.y));
        }
        return new Pair<>(Boolean.FALSE, new PointF(lineB.x, lineB.y));
    }

    @Nullable
    public final PointF c(@NotNull float[] rectCorners, @NotNull PointF target) {
        Intrinsics.checkNotNullParameter(rectCorners, "rectCorners");
        Intrinsics.checkNotNullParameter(target, "target");
        if (rectCorners.length != 8) {
            return null;
        }
        PointF pointF = new PointF(rectCorners[0], rectCorners[1]);
        PointF pointF2 = new PointF(rectCorners[2], rectCorners[3]);
        PointF pointF3 = new PointF(rectCorners[4], rectCorners[5]);
        PointF pointF4 = new PointF(rectCorners[6], rectCorners[7]);
        Pair<Boolean, PointF> b16 = b(pointF, pointF2, target);
        Pair<Boolean, PointF> b17 = b(pointF2, pointF3, target);
        Pair<Boolean, PointF> b18 = b(pointF3, pointF4, target);
        Pair<Boolean, PointF> b19 = b(pointF4, pointF, target);
        PointF second = b16.getSecond();
        float d16 = d(b16.getSecond(), target);
        if (d16 > d(b17.getSecond(), target)) {
            d16 = d(b17.getSecond(), target);
            second = b17.getSecond();
        }
        if (d16 > d(b18.getSecond(), target)) {
            d16 = d(b18.getSecond(), target);
            second = b18.getSecond();
        }
        if (d16 > d(b19.getSecond(), target)) {
            d(b19.getSecond(), target);
            return b19.getSecond();
        }
        return second;
    }

    public final float d(@NotNull PointF pointA, @NotNull PointF pointB) {
        Intrinsics.checkNotNullParameter(pointA, "pointA");
        Intrinsics.checkNotNullParameter(pointB, "pointB");
        double d16 = 2;
        return (float) Math.sqrt(((float) Math.pow(pointA.x - pointB.x, d16)) + ((float) Math.pow(pointA.y - pointB.y, d16)));
    }

    @NotNull
    public final float[] e(@NotNull RectF r16) {
        Intrinsics.checkNotNullParameter(r16, "r");
        return new float[]{r16.centerX(), r16.centerY()};
    }

    @NotNull
    public final float[] f(@NotNull RectF r16) {
        Intrinsics.checkNotNullParameter(r16, "r");
        float f16 = r16.left;
        float f17 = r16.top;
        float f18 = r16.right;
        float f19 = r16.bottom;
        return new float[]{f16, f17, f18, f17, f18, f19, f16, f19};
    }

    public final float g(@Nullable PointF pointOne, @Nullable PointF pointTwo) {
        if (pointOne != null && pointTwo != null) {
            float f16 = pointOne.x - pointTwo.x;
            double d16 = pointOne.y - pointTwo.y;
            return (float) Math.sqrt((f16 * f16) + (d16 * d16));
        }
        return 0.0f;
    }

    public final float h(@Nullable PointF pointOne, @Nullable PointF pointTwo) {
        if (pointOne != null && pointTwo != null) {
            return pointOne.x - pointTwo.x;
        }
        return 0.0f;
    }

    public final float i(@Nullable PointF pointOne, @Nullable PointF pointTwo) {
        if (pointOne != null && pointTwo != null) {
            return pointOne.y - pointTwo.y;
        }
        return 0.0f;
    }

    @NotNull
    public final PointF j(@NotNull Matrix matrix, float x16, float y16) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        float[] fArr = {x16, y16};
        matrix.mapPoints(fArr);
        return new PointF(fArr[0], fArr[1]);
    }

    @NotNull
    public final float[] k(@NotNull float[] corners) {
        Intrinsics.checkNotNullParameter(corners, "corners");
        return new float[]{(float) Math.sqrt(Math.pow(corners[0] - corners[2], 2.0d) + Math.pow(corners[1] - corners[3], 2.0d)), (float) Math.sqrt(Math.pow(corners[2] - corners[4], 2.0d) + Math.pow(corners[3] - corners[5], 2.0d))};
    }

    public final boolean l(float x16, float y16, @Nullable RectF rectF, float roteAngle) {
        boolean z16 = false;
        if (rectF == null || rectF.isEmpty()) {
            return false;
        }
        if (roteAngle == 0.0f) {
            z16 = true;
        }
        if (!z16) {
            Matrix matrix = new Matrix();
            matrix.setRotate(roteAngle, rectF.centerX(), rectF.centerY());
            return o(new PointF(x16, y16), j(matrix, rectF.left, rectF.top), j(matrix, rectF.right, rectF.top), j(matrix, rectF.left, rectF.bottom), j(matrix, rectF.right, rectF.bottom));
        }
        return rectF.contains(x16, y16);
    }

    public final boolean m(float linePointX1, float linePointY1, float linePointX2, float linePointY2, float _rectangleLeftTopX, float _rectangleLeftTopY, float _rectangleRightBottomX, float _rectangleRightBottomY) {
        float f16;
        float f17;
        float f18;
        float f19;
        float f26 = linePointY1 - linePointY2;
        float f27 = linePointX2 - linePointX1;
        float f28 = f26 * _rectangleLeftTopX;
        float f29 = f27 * _rectangleLeftTopY;
        float f36 = f28 + f29;
        float f37 = f26 * _rectangleRightBottomX;
        float f38 = f27 * _rectangleRightBottomY;
        float f39 = f37 + f38;
        float f46 = f28 + f38;
        float f47 = f37 + f29;
        float f48 = (linePointX1 * linePointY2) - (linePointX2 * linePointY1);
        float f49 = f36 + f48;
        if ((f49 < 0.0f || f39 + f48 > 0.0f) && (f49 > 0.0f || f39 + f48 < 0.0f)) {
            float f56 = f46 + f48;
            if ((f56 < 0.0f || f47 + f48 > 0.0f) && (f56 > 0.0f || f47 + f48 < 0.0f)) {
                return false;
            }
        }
        if (_rectangleLeftTopX > _rectangleRightBottomX) {
            f17 = _rectangleLeftTopX;
            f16 = _rectangleRightBottomX;
        } else {
            f16 = _rectangleLeftTopX;
            f17 = _rectangleRightBottomX;
        }
        if (_rectangleLeftTopY < _rectangleRightBottomY) {
            f19 = _rectangleLeftTopY;
            f18 = _rectangleRightBottomY;
        } else {
            f18 = _rectangleLeftTopY;
            f19 = _rectangleRightBottomY;
        }
        if (linePointX1 < f16 && linePointX2 < f16) {
            return false;
        }
        if (linePointX1 > f17 && linePointX2 > f17) {
            return false;
        }
        if (linePointY1 > f18 && linePointY2 > f18) {
            return false;
        }
        if (linePointY1 < f19 && linePointY2 < f19) {
            return false;
        }
        return true;
    }

    public final boolean n(@NotNull float[] rectCorners, @NotNull PointF point) {
        Intrinsics.checkNotNullParameter(rectCorners, "rectCorners");
        Intrinsics.checkNotNullParameter(point, "point");
        if (rectCorners.length != 8) {
            return false;
        }
        int i3 = 0;
        while (i3 < 4) {
            u uVar = f326728a;
            int i16 = i3 * 2;
            int i17 = i16 + 1;
            int i18 = i3 + 1;
            int i19 = i18 * 2;
            int i26 = i19 % 8;
            int i27 = (i19 + 1) % 8;
            int i28 = (i3 + 2) * 2;
            if (uVar.a(new float[]{rectCorners[i16], rectCorners[i17]}, new float[]{point.x, point.y}, new float[]{rectCorners[i26], rectCorners[i27]}) * uVar.a(new float[]{rectCorners[i16], rectCorners[i17]}, new float[]{rectCorners[i28 % 8], rectCorners[(i28 + 1) % 8]}, new float[]{rectCorners[i26], rectCorners[i27]}) < 0.0f) {
                return false;
            }
            i3 = i18;
        }
        return true;
    }

    @NotNull
    public final RectF p(@NotNull float[] array) {
        int roundToInt;
        int roundToInt2;
        Intrinsics.checkNotNullParameter(array, "array");
        RectF rectF = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        for (int i3 = 1; i3 < array.length; i3 += 2) {
            float f16 = 10;
            roundToInt = MathKt__MathJVMKt.roundToInt(array[i3 - 1] * f16);
            float f17 = roundToInt / 10.0f;
            roundToInt2 = MathKt__MathJVMKt.roundToInt(array[i3] * f16);
            float f18 = roundToInt2 / 10.0f;
            float f19 = rectF.left;
            if (f17 < f19) {
                f19 = f17;
            }
            rectF.left = f19;
            float f26 = rectF.top;
            if (f18 < f26) {
                f26 = f18;
            }
            rectF.top = f26;
            float f27 = rectF.right;
            if (f17 <= f27) {
                f17 = f27;
            }
            rectF.right = f17;
            float f28 = rectF.bottom;
            if (f18 <= f28) {
                f18 = f28;
            }
            rectF.bottom = f18;
        }
        rectF.sort();
        return rectF;
    }
}
