package com.tencent.mobileqq.perf.memory.leak;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.perf.process.config.MainProcConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/leak/d;", "", "Landroid/app/Activity;", "targetActivity", "", "c", "", "msg", "d", "", "a", "b", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f257770a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30400);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f257770a = new d();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean a() {
        boolean equals;
        boolean equals2;
        boolean equals3;
        String str = Build.MANUFACTURER;
        equals = StringsKt__StringsJVMKt.equals("realMe", str, true);
        if (!equals) {
            equals2 = StringsKt__StringsJVMKt.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_ONEPLUS, str, true);
            if (!equals2) {
                equals3 = StringsKt__StringsJVMKt.equals("OPPO", str, true);
                if (equals3) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return true;
    }

    @SuppressLint({"PrivateApi"})
    private final void c(Activity targetActivity) {
        String str;
        g gVar;
        View view;
        Activity activity;
        View view2;
        boolean z16;
        Activity activity2;
        boolean z17;
        Context context;
        Context context2;
        Object systemService = targetActivity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (systemService == null) {
            QLog.w("InputMethodManagerLeak", 1, "fixInner, imm is null");
            return;
        }
        String[] strArr = {"mCurRootView", "mServedView", "mNextServedView", "mLastSrvView"};
        for (int i3 = 0; i3 < 4; i3++) {
            String str2 = strArr[i3];
            try {
                gVar = g.f257775a;
                str = str2;
            } catch (Throwable th5) {
                th = th5;
                str = str2;
            }
            try {
                Field f16 = g.f(gVar, systemService, str2, false, 4, null);
                h hVar = h.f257780a;
                Object d16 = hVar.d(systemService, f16);
                if (d16 == null) {
                    d("fix " + str + ", value is null");
                } else {
                    if (d16 instanceof View) {
                        view = (View) d16;
                        d("fix " + str + ", target is view");
                    } else if (Intrinsics.areEqual(d16.getClass().getName(), "android.view.ViewRootImpl")) {
                        Object d17 = hVar.d(d16, g.f(gVar, d16, "mView", false, 4, null));
                        if (d17 instanceof View) {
                            view = (View) d17;
                        } else {
                            view = null;
                        }
                        d("fix " + str + ", target is viewRootImpl, targetView:" + view);
                    } else {
                        d("fix " + str + ", unknown value, " + d16);
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("fix ");
                    sb5.append(str);
                    sb5.append(", inputView context:");
                    if (view != null && (context2 = view.getContext()) != null) {
                        activity = hVar.a(context2);
                    } else {
                        activity = null;
                    }
                    sb5.append(activity);
                    sb5.append(", rootView:");
                    if (view != null) {
                        view2 = view.getRootView();
                    } else {
                        view2 = null;
                    }
                    sb5.append(view2);
                    d(sb5.toString());
                    d("fix " + str + ", activity context:" + targetActivity + ", rootView:" + targetActivity.getWindow().getDecorView().getRootView());
                    if (view != null && targetActivity.getWindow() != null && targetActivity.getWindow().getDecorView().getRootView() == view.getRootView()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (view != null && (context = view.getContext()) != null) {
                        activity2 = hVar.a(context);
                    } else {
                        activity2 = null;
                    }
                    if (activity2 == targetActivity) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z16 || z17) {
                        hVar.i(systemService, f16, null);
                        d("fix " + str + ", success");
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                com.tencent.mobileqq.perf.memory.util.b.b(com.tencent.mobileqq.perf.memory.util.b.f257791a, "InputMethodManagerLeak", "fix " + str + ", failed, " + th.getMessage(), false, null, 12, null);
            }
        }
        d("fixInner completed, " + systemService.getClass().getSimpleName());
    }

    private final void d(String msg2) {
        boolean z16;
        if (AppSetting.isPublicVersion() && !AppSetting.isGrayVersion()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (com.tencent.mobileqq.perf.process.util.b.f257946a.o() && Build.VERSION.SDK_INT == 33 && z16) {
            QLog.d("InputMethodManagerLeak", 1, msg2);
        }
    }

    public final void b(@NotNull Activity targetActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) targetActivity);
            return;
        }
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        int i3 = Build.VERSION.SDK_INT;
        if ((i3 == 33 && a()) || i3 >= 35) {
            return;
        }
        if (i3 < 28 || MainProcConfig.INSTANCE.e().l()) {
            c(targetActivity);
        }
    }
}
