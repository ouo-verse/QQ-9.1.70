package com.tencent.biz.qui.quisecnavbar;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.biz.qui.quicommon.AccessibilityUtil;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.mobileqq.R;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.qui.quiblurview.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a*\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0006\u0010\u000e\u001a\u00020\f\u001a\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f\u00a8\u0006\u0012"}, d2 = {"Landroid/content/Context;", "context", "", "b", "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "blurView", "Landroid/view/View;", "bgView", "clearColor", "", "c", "resId", "", "e", "d", "Landroid/widget/TextView;", "view", "a", "QUISecNavBar_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class e {
    public static final void a(@NotNull TextView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        AccessibilityUtil.a(view, view.getText(), Button.class.getName());
    }

    public static final int b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return RFWImmersiveUtils.getStatusBarHeight(context) + f.g();
    }

    public static final void c(@NotNull QQBlurViewWrapper blurView, @Nullable View view, int i3, @NotNull Context context) {
        boolean z16;
        Intrinsics.checkNotNullParameter(blurView, "blurView");
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 24) {
            z16 = true;
        } else {
            z16 = false;
        }
        f.a aVar = new f.a(z16, 64.0f, view, i3, new ColorDrawable(context.getColor(R.color.qui_common_bg_nav_aio)), Integer.valueOf(R.drawable.qui_bg_nav_secondary));
        aVar.o(true);
        Unit unit = Unit.INSTANCE;
        blurView.a(aVar);
    }

    public static final boolean d() {
        Object a16 = ud0.c.a(td0.f.class);
        Intrinsics.checkNotNullExpressionValue(a16, "QUIDelegate.getDelegate(\u2026BlurDelegate::class.java)");
        return ((td0.f) a16).isDefaultTheme();
    }

    public static final boolean e(int i3, @NotNull Context context) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(context, "context");
        if (i3 == 0) {
            return false;
        }
        String resName = context.getResources().getResourceEntryName(i3);
        Intrinsics.checkNotNullExpressionValue(resName, "resName");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(resName, "qui_", false, 2, null);
        if (startsWith$default) {
            return true;
        }
        ud0.d.b("QUISecNavBar", ud0.d.f438811e, "wrong resource, the resource must use token. resName: " + resName);
        return false;
    }
}
