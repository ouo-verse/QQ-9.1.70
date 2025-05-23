package com.tencent.mobileqq.qui;

import android.annotation.SuppressLint;
import com.tencent.biz.richframework.arthook.api.RFWHook;
import com.tencent.biz.richframework.arthook.api.RFWHookConfig;
import com.tencent.biz.richframework.arthook.api.callback.MethodHook;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Member;
import mqq.app.MobileQQ;
import ud0.e;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qui.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public class C8446a extends MethodHook {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f276859a;

        C8446a(String str) {
            this.f276859a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }
    }

    public static boolean a() {
        return e.a("qui_immservie_hook_open", false);
    }

    private static void b(String str, Member member) {
        RFWHook.hook(member, new C8446a(str));
    }

    public static void c() {
        boolean z16 = true;
        if (MobileQQ.sProcessId != 1 || !e()) {
            return;
        }
        RFWHookConfig.debug = true;
        if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isPublicVersion() && !((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
            z16 = false;
        }
        RFWHookConfig.debuggable = z16;
        d();
    }

    @SuppressLint({"PrivateApi"})
    private static void d() {
        try {
            Class<?> cls = Class.forName("com.android.internal.policy.PhoneWindow");
            Class<?> cls2 = Integer.TYPE;
            b("setStatusBarColor", cls.getDeclaredMethod("setStatusBarColor", cls2));
            b("setNavigationBarColor", Class.forName("com.android.internal.policy.PhoneWindow").getDeclaredMethod("setNavigationBarColor", cls2));
            b("setSystemUiVisibility", Class.forName("android.view.View").getDeclaredMethod("setSystemUiVisibility", cls2));
        } catch (Throwable th5) {
            QLog.e("QUIHooker", 1, th5, new Object[0]);
        }
    }

    private static boolean e() {
        if (com.tencent.mobileqq.immersive.a.m() && ((!((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isPublicVersion() || ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion()) && a())) {
            return true;
        }
        return false;
    }
}
