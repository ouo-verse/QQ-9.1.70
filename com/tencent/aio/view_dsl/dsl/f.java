package com.tencent.aio.view_dsl.dsl;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b*\"(\u0010\u0007\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\"(\u0010\n\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\u0004\"\u0004\b\t\u0010\u0006\"(\u0010\r\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000b\u0010\u0004\"\u0004\b\f\u0010\u0006\"(\u0010\u0010\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u0004\"\u0004\b\u000f\u0010\u0006\"(\u0010\u0013\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\u0006\"(\u0010\u0016\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0014\u0010\u0004\"\u0004\b\u0015\u0010\u0006\"(\u0010\u0019\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0017\u0010\u0004\"\u0004\b\u0018\u0010\u0006\"(\u0010\u001f\u001a\u00020\u001a*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001a8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\"(\u0010\"\u001a\u00020\u001a*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001a8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001e\"(\u0010%\u001a\u00020\u001a*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001a8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001e\"(\u0010(\u001a\u00020\u001a*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001a8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001e\"(\u0010+\u001a\u00020\u001a*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001a8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001e\"(\u0010.\u001a\u00020\u001a*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001a8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010\u001e\"(\u00101\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b/\u0010\u0004\"\u0004\b0\u0010\u0006\"(\u00104\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b2\u0010\u0004\"\u0004\b3\u0010\u0006\"(\u00107\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b5\u0010\u0004\"\u0004\b6\u0010\u0006\"(\u0010:\u001a\u00020\u001a*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001a8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b8\u0010\u001c\"\u0004\b9\u0010\u001e\"(\u0010=\u001a\u00020\u001a*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001a8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b;\u0010\u001c\"\u0004\b<\u0010\u001e\"(\u0010@\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b>\u0010\u0004\"\u0004\b?\u0010\u0006\"(\u0010C\u001a\u00020\u001a*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001a8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bA\u0010\u001c\"\u0004\bB\u0010\u001e\u00a8\u0006D"}, d2 = {"Landroid/view/View;", "", "value", "getLayout_toLeftOf", "(Landroid/view/View;)I", "r", "(Landroid/view/View;I)V", "layout_toLeftOf", "getLayout_toRightOf", ReportConstant.COSTREPORT_PREFIX, "layout_toRightOf", "getLayout_above", "a", "layout_above", "getLayout_below", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "layout_below", "getLayout_alignLeft", "b", "layout_alignLeft", "getLayout_alignTop", "k", "layout_alignTop", "getLayout_alignRight", "i", "layout_alignRight", "", "getLayout_alignParentLeft", "(Landroid/view/View;)Z", "e", "(Landroid/view/View;Z)V", "layout_alignParentLeft", "getLayout_alignParentTop", h.F, "layout_alignParentTop", "getLayout_alignParentRight", "f", "layout_alignParentRight", "getLayout_alignParentBottom", "c", "layout_alignParentBottom", "getLayout_centerHorizontal", DomainData.DOMAIN_NAME, "layout_centerHorizontal", "getLayout_centerVertical", "o", "layout_centerVertical", "getLayout_toStartOf", "t", "layout_toStartOf", "getLayout_toEndOf", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "layout_toEndOf", "getLayout_alignStart", "j", "layout_alignStart", "getLayout_alignParentStart", "g", "layout_alignParentStart", "getLayout_alignParentEnd", "d", "layout_alignParentEnd", "getLayout_gravity", "p", LayoutAttrDefine.Gravity.Layout_Gravity, "getLayout_alignWithParentIfMissing", "l", "layout_alignWithParentIfMissing", "core_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class f {
    public static final void a(@NotNull View layout_above, int i3) {
        Intrinsics.checkNotNullParameter(layout_above, "$this$layout_above");
        ViewGroup.LayoutParams layoutParams = layout_above.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.addRule(2, i3);
        }
    }

    public static final void b(@NotNull View layout_alignLeft, int i3) {
        Intrinsics.checkNotNullParameter(layout_alignLeft, "$this$layout_alignLeft");
        ViewGroup.LayoutParams layoutParams = layout_alignLeft.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.addRule(5, i3);
        }
    }

    public static final void c(@NotNull View layout_alignParentBottom, boolean z16) {
        Intrinsics.checkNotNullParameter(layout_alignParentBottom, "$this$layout_alignParentBottom");
        ViewGroup.LayoutParams layoutParams = layout_alignParentBottom.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.addRule(12, z16 ? 1 : 0);
        }
    }

    public static final void d(@NotNull View layout_alignParentEnd, boolean z16) {
        Intrinsics.checkNotNullParameter(layout_alignParentEnd, "$this$layout_alignParentEnd");
        ViewGroup.LayoutParams layoutParams = layout_alignParentEnd.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.addRule(21, z16 ? 1 : 0);
        }
    }

    public static final void e(@NotNull View layout_alignParentLeft, boolean z16) {
        Intrinsics.checkNotNullParameter(layout_alignParentLeft, "$this$layout_alignParentLeft");
        ViewGroup.LayoutParams layoutParams = layout_alignParentLeft.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.addRule(9, z16 ? 1 : 0);
        }
    }

    public static final void f(@NotNull View layout_alignParentRight, boolean z16) {
        Intrinsics.checkNotNullParameter(layout_alignParentRight, "$this$layout_alignParentRight");
        ViewGroup.LayoutParams layoutParams = layout_alignParentRight.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.addRule(11, z16 ? 1 : 0);
        }
    }

    public static final void g(@NotNull View layout_alignParentStart, boolean z16) {
        Intrinsics.checkNotNullParameter(layout_alignParentStart, "$this$layout_alignParentStart");
        ViewGroup.LayoutParams layoutParams = layout_alignParentStart.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.addRule(20, z16 ? 1 : 0);
        }
    }

    public static final void h(@NotNull View layout_alignParentTop, boolean z16) {
        Intrinsics.checkNotNullParameter(layout_alignParentTop, "$this$layout_alignParentTop");
        ViewGroup.LayoutParams layoutParams = layout_alignParentTop.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.addRule(10, z16 ? 1 : 0);
        }
    }

    public static final void i(@NotNull View layout_alignRight, int i3) {
        Intrinsics.checkNotNullParameter(layout_alignRight, "$this$layout_alignRight");
        ViewGroup.LayoutParams layoutParams = layout_alignRight.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.addRule(7, i3);
        }
    }

    public static final void j(@NotNull View layout_alignStart, int i3) {
        Intrinsics.checkNotNullParameter(layout_alignStart, "$this$layout_alignStart");
        ViewGroup.LayoutParams layoutParams = layout_alignStart.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.addRule(18, i3);
        }
    }

    public static final void k(@NotNull View layout_alignTop, int i3) {
        Intrinsics.checkNotNullParameter(layout_alignTop, "$this$layout_alignTop");
        ViewGroup.LayoutParams layoutParams = layout_alignTop.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.addRule(6, i3);
        }
    }

    public static final void l(@NotNull View layout_alignWithParentIfMissing, boolean z16) {
        Intrinsics.checkNotNullParameter(layout_alignWithParentIfMissing, "$this$layout_alignWithParentIfMissing");
        ViewGroup.LayoutParams layoutParams = layout_alignWithParentIfMissing.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.alignWithParent = z16;
        }
    }

    public static final void m(@NotNull View layout_below, int i3) {
        Intrinsics.checkNotNullParameter(layout_below, "$this$layout_below");
        ViewGroup.LayoutParams layoutParams = layout_below.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.addRule(3, i3);
        }
    }

    public static final void n(@NotNull View layout_centerHorizontal, boolean z16) {
        Intrinsics.checkNotNullParameter(layout_centerHorizontal, "$this$layout_centerHorizontal");
        ViewGroup.LayoutParams layoutParams = layout_centerHorizontal.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.addRule(14, z16 ? 1 : 0);
        }
    }

    public static final void o(@NotNull View layout_centerVertical, boolean z16) {
        Intrinsics.checkNotNullParameter(layout_centerVertical, "$this$layout_centerVertical");
        ViewGroup.LayoutParams layoutParams = layout_centerVertical.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.addRule(15, z16 ? 1 : 0);
        }
    }

    public static final void p(@NotNull View layout_gravity, int i3) {
        Intrinsics.checkNotNullParameter(layout_gravity, "$this$layout_gravity");
        ViewGroup.LayoutParams layoutParams = layout_gravity.getLayoutParams();
        if (layoutParams instanceof GridLayout.LayoutParams) {
            ((GridLayout.LayoutParams) layoutParams).setGravity(i3);
            return;
        }
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).gravity = i3;
            return;
        }
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i3;
            return;
        }
        Log.d("LayoutDSL", "layout_gravity but type not match: " + layoutParams);
    }

    public static final void q(@NotNull View layout_toEndOf, int i3) {
        Intrinsics.checkNotNullParameter(layout_toEndOf, "$this$layout_toEndOf");
        ViewGroup.LayoutParams layoutParams = layout_toEndOf.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.addRule(17, i3);
        }
    }

    public static final void r(@NotNull View layout_toLeftOf, int i3) {
        Intrinsics.checkNotNullParameter(layout_toLeftOf, "$this$layout_toLeftOf");
        ViewGroup.LayoutParams layoutParams = layout_toLeftOf.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.addRule(0, i3);
        }
    }

    public static final void s(@NotNull View layout_toRightOf, int i3) {
        Intrinsics.checkNotNullParameter(layout_toRightOf, "$this$layout_toRightOf");
        ViewGroup.LayoutParams layoutParams = layout_toRightOf.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.addRule(1, i3);
        }
    }

    public static final void t(@NotNull View layout_toStartOf, int i3) {
        Intrinsics.checkNotNullParameter(layout_toStartOf, "$this$layout_toStartOf");
        ViewGroup.LayoutParams layoutParams = layout_toStartOf.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.addRule(16, i3);
        }
    }
}
