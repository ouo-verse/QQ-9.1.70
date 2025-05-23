package com.tencent.mobileqq.login.verify;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.login.verify.t;
import com.tencent.mobileqq.loginregister.utils.WebViewBridge;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.as;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class t {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static long f242742a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements WebViewBridge.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f242743a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f242744b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f242745c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f242746d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f242747e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f242748f;

        a(boolean z16, boolean z17, String str, int i3, boolean z18, b bVar) {
            this.f242743a = z16;
            this.f242744b = z17;
            this.f242745c = str;
            this.f242746d = i3;
            this.f242747e = z18;
            this.f242748f = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17), str, Integer.valueOf(i3), Boolean.valueOf(z18), bVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(Bundle bundle, String str) {
            bundle.putString("uin", str);
            g(true, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(final String str, final Bundle bundle) {
            t.c(str);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.verify.s
                @Override // java.lang.Runnable
                public final void run() {
                    t.a.this.e(bundle, str);
                }
            });
        }

        private void g(boolean z16, Bundle bundle) {
            as.b("devlock_verify_component", "0X800C282", this.f242745c, DevLockVerifyComponent.i(this.f242746d), 0, this.f242747e, String.valueOf(System.currentTimeMillis() - t.f242742a), "", "", "");
            b bVar = this.f242748f;
            if (bVar != null) {
                bVar.b(z16, bundle);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.utils.WebViewBridge.c
        public void a(int i3, String str, final Bundle bundle) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, bundle);
                return;
            }
            QLog.d("WebAuxiliaryVerify", 1, "WebViewBridge onReceiveEvent event = " + str + ", data = " + bundle);
            if (!TextUtils.equals(str, "com.tencent.mobileqq.webAuxiliaryVerifySuccess")) {
                return;
            }
            WebViewBridge.f().n(i3);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (bundle != null && bundle.getBoolean("key_login_verify_by_face", false)) {
                com.tencent.mobileqq.login.verify.a.a().b(peekAppRuntime, "0X800A31A");
                com.tencent.mobileqq.login.verify.a.a().b(peekAppRuntime, "0X800AD2C");
            }
            if (bundle != null && bundle.getBoolean("key_login_verify_by_mask", false)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (MobileQQ.sMobileQQ.isLoginByNT()) {
                    g(false, bundle);
                    return;
                }
                final String string = bundle.getString("last_account", "");
                if (TextUtils.isEmpty(string)) {
                    g(false, null);
                    return;
                } else if (!this.f242743a && !this.f242744b) {
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.login.verify.r
                        @Override // java.lang.Runnable
                        public final void run() {
                            t.a.this.f(string, bundle);
                        }
                    }, 64, null, false);
                    return;
                } else {
                    bundle.putString("uin", string);
                    g(true, bundle);
                    return;
                }
            }
            g(false, bundle);
        }

        @Override // com.tencent.mobileqq.loginregister.utils.WebViewBridge.c
        public void b(int i3, int i16, int i17, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), bundle);
                return;
            }
            QLog.d("WebAuxiliaryVerify", 1, "WebViewBridge onActivityResult resultCode = " + i17 + ", data = " + bundle);
            if (i17 == 0) {
                WebViewBridge.f().n(i3);
                as.b("devlock_verify_component", "0X800C282", this.f242745c, DevLockVerifyComponent.i(this.f242746d), 2, this.f242747e, String.valueOf(System.currentTimeMillis() - t.f242742a), "", "", "");
                b bVar = this.f242748f;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface b {
        void a();

        void b(boolean z16, Bundle bundle);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41242);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f242742a = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str) {
        SimpleAccount simpleAccount;
        String str2;
        List<SimpleAccount> loginedAccountList = MsfSdkUtils.getLoginedAccountList();
        if (loginedAccountList != null) {
            Iterator<SimpleAccount> it = loginedAccountList.iterator();
            while (it.hasNext()) {
                simpleAccount = it.next();
                if (str.equals(simpleAccount.getUin())) {
                    break;
                }
            }
        }
        simpleAccount = null;
        SimpleAccount simpleAccount2 = simpleAccount;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("create app runtime after login, simpleAccount is ");
        if (simpleAccount2 != null) {
            str2 = "not null";
        } else {
            str2 = "null";
        }
        sb5.append(str2);
        QLog.d("WebAuxiliaryVerify", 1, sb5.toString());
        if (simpleAccount2 != null) {
            MobileQQ.sMobileQQ.createNewRuntime(simpleAccount2, true, true, 4, null);
        }
    }

    private static WebViewBridge.d d(boolean z16, boolean z17, int i3, String str, boolean z18, b bVar) {
        return WebViewBridge.f().l(new a(z17, z16, str, i3, z18, bVar));
    }

    public static void e(FragmentActivity fragmentActivity, String str, Bundle bundle, int i3, String str2, boolean z16, b bVar) {
        String h16 = z.h(str);
        f242742a = System.currentTimeMillis();
        as.b("devlock_verify_component", "0X800C3C9", str2, DevLockVerifyComponent.i(i3), 0, z16, "", "", "", "");
        bundle.putString("url", h16);
        bundle.putBoolean("portraitOnly", true);
        bundle.putBoolean("hide_operation_bar", true);
        bundle.putBoolean("hide_more_button", true);
        bundle.putLong("business", 16384L);
        bundle.putLong("startOpenPageTime", System.currentTimeMillis());
        bundle.putBoolean(((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).isShowAdKey(), false);
        d(bundle.getBoolean("isSubaccount", false), BaseConstants.SSO_ACCOUNT_ACTION.equals(bundle.getString("from_where")), i3, str2, z16, bVar).a(fragmentActivity, h16, bundle, 100);
    }
}
