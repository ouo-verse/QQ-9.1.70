package com.tencent.mobileqq.sharepanel.util;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/util/b;", "", "Landroid/view/Window;", "window", "", "d", "Landroid/view/View;", "contentView", "a", "Landroid/app/Dialog;", "dialog", "b", "Landroid/content/Context;", "context", "", "c", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f287600a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42871);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f287600a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull View contentView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) contentView);
            return;
        }
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        int i3 = contentView.getContext().getResources().getDisplayMetrics().widthPixels;
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(contentView.getContext());
        int dip2px = ViewUtils.dip2px(500.0f);
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        if (i3 > dip2px) {
            ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = dip2px;
                layoutParams.height = -1;
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                }
                if (marginLayoutParams != null) {
                    marginLayoutParams.topMargin = statusBarHeight;
                }
                contentView.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = contentView.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = -1;
            layoutParams2.height = -1;
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            }
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = statusBarHeight;
            }
            contentView.setLayoutParams(layoutParams2);
        }
    }

    public final void b(@NotNull Dialog dialog) {
        boolean equals;
        Window window;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dialog);
            return;
        }
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        equals = StringsKt__StringsJVMKt.equals("HUAWEI", Build.MANUFACTURER, false);
        if (equals) {
            Context context = dialog.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "dialog.context");
            if (c(context) && (window = dialog.getWindow()) != null) {
                window.clearFlags(67108864);
                window.getDecorView().setSystemUiVisibility(5894);
            }
        }
    }

    public final boolean c(@NotNull Context context) {
        boolean z16;
        Configuration configuration;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        if (resources != null && (configuration = resources.getConfiguration()) != null && configuration.orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && context.getResources().getDisplayMetrics().widthPixels > ViewUtils.dip2px(500.0f)) {
            return true;
        }
        return false;
    }

    public final void d(@NotNull Window window) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) window);
            return;
        }
        Intrinsics.checkNotNullParameter(window, "window");
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (attributes != null) {
            attributes.gravity = 80;
            attributes.width = -1;
            attributes.height = -1;
            window.setAttributes(attributes);
        }
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e("SharePanelDialogFragmentUtil", 1, "clearCoverForStatus fail:", e16);
        }
    }
}
