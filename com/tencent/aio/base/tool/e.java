package com.tencent.aio.base.tool;

import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016JA\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u000f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0007J\u001c\u0010\u0010\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0007J-\u0010\u0013\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/aio/base/tool/e;", "", "Landroid/view/View;", HippyNestedScrollComponent.PRIORITY_PARENT, "child", "", "touchX", "touchY", "Landroid/graphics/PointF;", "outLocalPoint", "", "d", "(Landroid/view/View;Landroid/view/View;Ljava/lang/Float;Ljava/lang/Float;Landroid/graphics/PointF;)Z", "targetView", "touchPoint", "a", "b", "", "direction", "c", "(Landroid/view/View;Ljava/lang/Integer;Landroid/graphics/PointF;)Z", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f69223a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31749);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f69223a = new e();
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final boolean a(@Nullable View targetView, @Nullable PointF touchPoint) {
        return f69223a.c(targetView, 1, touchPoint);
    }

    @JvmStatic
    public static final boolean b(@Nullable View targetView, @Nullable PointF touchPoint) {
        return f69223a.c(targetView, -1, touchPoint);
    }

    private final boolean c(View targetView, Integer direction, PointF touchPoint) {
        if (targetView == null || direction == null) {
            return false;
        }
        if (targetView.canScrollVertically(direction.intValue()) && targetView.getVisibility() == 0) {
            return false;
        }
        if ((targetView instanceof ViewGroup) && touchPoint != null) {
            ViewGroup viewGroup = (ViewGroup) targetView;
            PointF pointF = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (d(targetView, childAt, Float.valueOf(touchPoint.x), Float.valueOf(touchPoint.y), pointF)) {
                    touchPoint.offset(pointF.x, pointF.y);
                    boolean c16 = c(childAt, direction, touchPoint);
                    touchPoint.offset(-pointF.x, -pointF.y);
                    return c16;
                }
            }
            return true;
        }
        return true;
    }

    @JvmStatic
    public static final boolean d(@Nullable View parent, @Nullable View child, @Nullable Float touchX, @Nullable Float touchY, @Nullable PointF outLocalPoint) {
        boolean z16;
        if (parent == null || child == null || touchX == null || touchY == null || outLocalPoint == null || child.getVisibility() != 0) {
            return false;
        }
        float floatValue = r1[1] + ((touchY.floatValue() + parent.getScrollY()) - child.getTop());
        float[] fArr = {fArr[0] + ((touchX.floatValue() + parent.getScrollX()) - child.getLeft()), floatValue};
        float f16 = fArr[0];
        float f17 = 0;
        if (f16 >= f17 && floatValue >= f17 && f16 < child.getWidth() && fArr[1] < child.getHeight()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            outLocalPoint.set(fArr[0] - touchX.floatValue(), fArr[1] - touchY.floatValue());
        }
        return z16;
    }
}
