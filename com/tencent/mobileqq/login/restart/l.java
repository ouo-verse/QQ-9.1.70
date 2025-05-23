package com.tencent.mobileqq.login.restart;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.UiThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002J\"\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u0007J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/login/restart/l;", "", "Landroid/view/ViewGroup;", "Ljava/lang/Class;", "childClass", "", "b", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "tipText", "withAnim", "", "c", "a", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f242636a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23574);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f242636a = new l();
        }
    }

    l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean b(ViewGroup viewGroup, Class<?> cls) {
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (Intrinsics.areEqual(viewGroup.getChildAt(i3).getClass(), cls)) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ void d(l lVar, Activity activity, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        lVar.c(activity, str, z16);
    }

    @UiThread
    public final void a(@NotNull Activity activity) {
        View view;
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!activity.isFinishing() && !activity.isDestroyed()) {
            Window window = activity.getWindow();
            RestartLoadingView restartLoadingView = null;
            if (window != null) {
                view = window.getDecorView();
            } else {
                view = null;
            }
            if (view instanceof ViewGroup) {
                viewGroup = (ViewGroup) view;
            } else {
                viewGroup = null;
            }
            if (viewGroup == null) {
                return;
            }
            int childCount = viewGroup.getChildCount();
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                View childAt = viewGroup.getChildAt(i3);
                if (childAt instanceof RestartLoadingView) {
                    restartLoadingView = (RestartLoadingView) childAt;
                    break;
                }
                i3++;
            }
            if (restartLoadingView != null) {
                restartLoadingView.e(true);
            }
        }
    }

    @UiThread
    public final void c(@NotNull Activity activity, @NotNull String tipText, boolean withAnim) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, tipText, Boolean.valueOf(withAnim));
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(tipText, "tipText");
        if (!activity.isFinishing() && !activity.isDestroyed()) {
            Window window = activity.getWindow();
            ViewGroup viewGroup = null;
            if (window != null) {
                view = window.getDecorView();
            } else {
                view = null;
            }
            if (view instanceof ViewGroup) {
                viewGroup = (ViewGroup) view;
            }
            if (viewGroup == null) {
                return;
            }
            if (b(viewGroup, RestartLoadingView.class)) {
                QLog.i("MainProcessRestartLoading", 1, "decorView already has RestartLoadingView");
                return;
            }
            RestartLoadingView restartLoadingView = new RestartLoadingView(activity, null, 0, 6, null);
            viewGroup.addView(restartLoadingView, new ViewGroup.LayoutParams(-1, -1));
            restartLoadingView.h(tipText, false, withAnim);
        }
    }
}
