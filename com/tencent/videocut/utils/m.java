package com.tencent.videocut.utils;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J0\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002J(\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0004\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/videocut/utils/m;", "", "Landroid/graphics/Matrix;", "matrix", "", HippyTKDListViewAdapter.X, "y", "Landroid/graphics/PointF;", "a", "curPoint", "pointLT", "pointRT", "pointLB", "pointRB", "", "c", "Landroid/graphics/RectF;", "rectF", "roteAngle", "b", "<init>", "()V", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f384255a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9412);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f384255a = new m();
        }
    }

    m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    private final PointF a(Matrix matrix, float x16, float y16) {
        float[] fArr = {x16, y16};
        matrix.mapPoints(fArr);
        return new PointF(fArr[0], fArr[1]);
    }

    private final boolean c(PointF curPoint, PointF pointLT, PointF pointRT, PointF pointLB, PointF pointRB) {
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
            if (f16 != f17) {
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

    public final boolean b(float x16, float y16, @Nullable RectF rectF, float roteAngle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, this, Float.valueOf(x16), Float.valueOf(y16), rectF, Float.valueOf(roteAngle))).booleanValue();
        }
        if (rectF == null || rectF.isEmpty()) {
            return false;
        }
        if (roteAngle != 0.0f) {
            Matrix matrix = new Matrix();
            matrix.setRotate(roteAngle, rectF.centerX(), rectF.centerY());
            return c(new PointF(x16, y16), a(matrix, rectF.left, rectF.top), a(matrix, rectF.right, rectF.top), a(matrix, rectF.left, rectF.bottom), a(matrix, rectF.right, rectF.bottom));
        }
        return rectF.contains(x16, y16);
    }
}
