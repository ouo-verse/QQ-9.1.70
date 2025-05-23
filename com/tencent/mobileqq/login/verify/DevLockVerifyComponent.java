package com.tencent.mobileqq.login.verify;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.login.api.ILoginReporter;
import com.tencent.mobileqq.login.verify.b;
import com.tencent.mobileqq.login.verify.t;
import com.tencent.mobileqq.loginregister.LoginVerifyReasonHelper;
import com.tencent.mobileqq.loginregister.sms.SmsVerifyComponent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.as;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class DevLockVerifyComponent {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Handler f242661a;

    /* renamed from: b, reason: collision with root package name */
    private long f242662b;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes15.dex */
    public @interface DevLockType {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a extends SmsVerifyComponent.e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f242663a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f242664b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f242665c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f242666d;

        a(long j3, String str, int i3, c cVar) {
            this.f242663a = j3;
            this.f242664b = str;
            this.f242665c = i3;
            this.f242666d = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DevLockVerifyComponent.this, Long.valueOf(j3), str, Integer.valueOf(i3), cVar);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.sms.SmsVerifyComponent.f
        public void a(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
                return;
            }
            QLog.i("DevLockVerifyComponent", 1, "smsVerify onCancel ");
            DevLockVerifyComponent.x("0X800C281", this.f242664b, DevLockVerifyComponent.i(this.f242665c), 2, String.valueOf(System.currentTimeMillis() - this.f242663a), "", "", "");
            DevLockVerifyComponent.this.u(this.f242666d, this.f242665c, this.f242664b);
        }

        @Override // com.tencent.mobileqq.loginregister.sms.SmsVerifyComponent.f
        public void b(Bundle bundle) {
            Bundle bundle2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
                return;
            }
            QLog.i("DevLockVerifyComponent", 1, "smsVerify onSuccess");
            DevLockVerifyComponent.x("0X800C281", this.f242664b, DevLockVerifyComponent.i(this.f242665c), 0, String.valueOf(System.currentTimeMillis() - this.f242663a), "", "", "");
            boolean z16 = false;
            if (bundle != null) {
                bundle2 = bundle.getBundle("devlock_verify_login_bundle");
                z16 = bundle.getBoolean("devlock_verify_is_login", false);
            } else {
                bundle2 = null;
            }
            DevLockVerifyComponent.this.v(this.f242666d, this.f242665c, this.f242664b, z16, bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements t.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f242668a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f242669b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f242670c;

        b(c cVar, int i3, String str) {
            this.f242668a = cVar;
            this.f242669b = i3;
            this.f242670c = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DevLockVerifyComponent.this, cVar, Integer.valueOf(i3), str);
            }
        }

        @Override // com.tencent.mobileqq.login.verify.t.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                QLog.d("DevLockVerifyComponent", 1, "WebAuxiliaryVerify onVerifyCancel");
                DevLockVerifyComponent.this.u(this.f242668a, this.f242669b, this.f242670c);
            }
        }

        @Override // com.tencent.mobileqq.login.verify.t.b
        public void b(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
            } else {
                QLog.d("DevLockVerifyComponent", 1, "WebAuxiliaryVerify onVerifySuccess");
                DevLockVerifyComponent.this.v(this.f242668a, this.f242669b, this.f242670c, z16, bundle);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface c {
        void a();

        void b(boolean z16, Bundle bundle);
    }

    public DevLockVerifyComponent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f242661a = new Handler(Looper.getMainLooper());
            this.f242662b = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void t(int i3, String str, String str2, Bundle bundle, DevlockInfo devlockInfo, c cVar) {
        String str3;
        boolean z16 = true;
        QLog.d("DevLockVerifyComponent", 1, "startWebAuxiliaryVerify loginType=" + i3);
        if (devlockInfo != null && !TextUtils.isEmpty(devlockInfo.OtherDevLockVerifyUrl)) {
            String h16 = h(j(devlockInfo), str2);
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                str3 = bundle.getString("mainaccount");
            } else {
                str3 = null;
            }
            if (str3 == null || str3.equals(str)) {
                z16 = false;
            }
            if (z16) {
                bundle2.putString("subAccountUin", str);
                bundle2.putBoolean("isSubaccount", z16);
                bundle2.putBoolean("avoidLoginWeb", z16);
            }
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            if (QLog.isColorLevel()) {
                QLog.d("DevLockVerifyComponent", 2, "other_verify, mainAccount=" + str3 + " uin=" + str + " isSubaccount=" + z16);
            }
            t.e(QBaseActivity.sTopActivity, h16, bundle2, i3, str, false, new b(cVar, i3, str));
            return;
        }
        QLog.e("DevLockVerifyComponent", 1, "startWebAuxiliaryVerify, devlockInfo or OtherDevLockVerifyUrl is null");
        cVar.a();
    }

    public static String h(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return URLUtil.addParameter(URLUtil.addParameter(str, "from", "2"), "wx_account", str2);
        }
        return str;
    }

    public static int i(int i3) {
        if (i3 != 4) {
            if (i3 != 5) {
                if (i3 == 6) {
                    return 4;
                }
                if (i3 == 7) {
                    return 5;
                }
                return 1;
            }
            return 3;
        }
        return 2;
    }

    public static String j(DevlockInfo devlockInfo) {
        String str = devlockInfo.OtherDevLockVerifyUrl;
        String str2 = devlockInfo.Mobile;
        if (!TextUtils.isEmpty(str2) && str2.length() >= 3) {
            return URLUtil.addParameter(URLUtil.addParameter(str, "pp", str2.substring(0, 3)), "tp", str2.substring(str2.length() - 2));
        }
        QLog.i("DevLockVerifyComponent", 1, "addParamForUrl, but mobile is empty");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void s(int i3, String str, Bundle bundle, DevlockInfo devlockInfo, c cVar) {
        QLog.i("DevLockVerifyComponent", 1, "goToSmsVerifyPage loginType=" + i3);
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            if (devlockInfo == null) {
                QLog.e("DevLockVerifyComponent", 1, "goToSmsVerifyPage devlockInfo is null");
                u(cVar, i3, str);
                return;
            }
            x("0X800C3C8", str, i(i3), 0, "", "", "", "");
            Intent intent = new Intent();
            intent.putExtra("uin", str);
            intent.putExtra("account_login_type", i3);
            intent.putExtra("mobile_type", 0);
            intent.putExtra(AuthDevOpenUgActivity.KEY_DEVLOCK_INFO, devlockInfo);
            intent.putExtra(AuthDevOpenUgActivity.KEY_IS_FROM_LOGIN, true);
            if (bundle != null) {
                intent.putExtra("mainaccount", bundle.getString("mainaccount"));
                intent.putExtra("from_where", bundle.getString("from_where"));
                intent.putExtra("pass_through_param", bundle);
            }
            SmsVerifyComponent.e(3, devlockInfo.Mobile, devlockInfo.CountryCode, intent.getExtras(), new a(System.currentTimeMillis(), str, i3, cVar));
            return;
        }
        QLog.i("DevLockVerifyComponent", 1, "goToSmsVerifyPage activity is null or isFinishing");
        u(cVar, i3, str);
    }

    private boolean m() {
        if (!NetworkUtil.isMobileNetWork(BaseApplication.getContext())) {
            if (!n()) {
                return false;
            }
            return l();
        }
        return true;
    }

    private boolean n() {
        ConnectivityManager connectivityManager = (ConnectivityManager) BaseApplication.getContext().getSystemService("connectivity");
        try {
            Method method = connectivityManager.getClass().getMethod("getMobileDataEnabled", new Class[0]);
            method.setAccessible(true);
            return ((Boolean) method.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception e16) {
            QLog.e("DevLockVerifyComponent", 1, "getMobileDataEnabled error : ", e16.getMessage());
            return true;
        }
    }

    public static boolean o(int i3) {
        if (i3 != 160 && i3 != 239 && i3 != 224) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(int i3, c cVar, int i16, String str, Bundle bundle, Bundle bundle2, DevlockInfo devlockInfo) {
        if (i3 == 0) {
            v(cVar, i16, str, false, bundle);
        } else {
            s(i16, str, bundle2, devlockInfo, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(long j3, final String str, final int i3, final c cVar, final Bundle bundle, final DevlockInfo devlockInfo, final int i16, final Bundle bundle2) {
        int i17 = 1;
        QLog.i("DevLockVerifyComponent", 1, "gateway verify ret = " + i16);
        String valueOf = String.valueOf(System.currentTimeMillis() - j3);
        int i18 = i(i3);
        if (i16 == 0) {
            i17 = 0;
        }
        x("0X800C280", str, i18, i17, valueOf, String.valueOf(i16), "", "");
        y(new Runnable() { // from class: com.tencent.mobileqq.login.verify.g
            @Override // java.lang.Runnable
            public final void run() {
                DevLockVerifyComponent.this.p(i16, cVar, i3, str, bundle2, bundle, devlockInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(c cVar, int i3, String str) {
        x("0X800C283", str, i(i3), 2, String.valueOf(System.currentTimeMillis() - this.f242662b), "", "", "");
        ((ILoginReporter) QRoute.api(ILoginReporter.class)).reportLoginDevLockVerifyEnd(false);
        if (cVar != null) {
            cVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(c cVar, int i3, String str, boolean z16, Bundle bundle) {
        x("0X800C283", str, i(i3), 0, String.valueOf(System.currentTimeMillis() - this.f242662b), "", "", "");
        ((ILoginReporter) QRoute.api(ILoginReporter.class)).reportLoginDevLockVerifyEnd(true);
        if (cVar != null) {
            cVar.b(z16, bundle);
        }
    }

    private void w(int i3, DevlockInfo devlockInfo) {
        if (devlockInfo == null) {
            return;
        }
        if (i3 == 1 || i3 == 2 || i3 == 6 || i3 == 7) {
            LoginVerifyReasonHelper.c(devlockInfo, 7, 1, null, 0L);
        }
    }

    public static void x(String str, String str2, int i3, int i16, String str3, String str4, String str5, String str6) {
        as.b("devlock_verify_component", str, str2, i3, i16, false, str3, str4, str5, str6);
    }

    private void y(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.f242661a.post(runnable);
        }
    }

    private void z(final int i3, final DevlockInfo devlockInfo, final String str, final Bundle bundle, final c cVar) {
        QLog.d("DevLockVerifyComponent", 1, "startGatewayVerify");
        final long currentTimeMillis = System.currentTimeMillis();
        x("0X800C3C7", str, i(i3), 0, "", "", "", "");
        new com.tencent.mobileqq.login.verify.b(i3, devlockInfo, str, bundle, new b.InterfaceC7991b() { // from class: com.tencent.mobileqq.login.verify.f
            @Override // com.tencent.mobileqq.login.verify.b.InterfaceC7991b
            public final void a(int i16, Bundle bundle2) {
                DevLockVerifyComponent.this.q(currentTimeMillis, str, i3, cVar, bundle, devlockInfo, i16, bundle2);
            }
        }).h();
    }

    public void A(final int i3, final DevlockInfo devlockInfo, String str, final String str2, int i16, final Bundle bundle, final c cVar) {
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), devlockInfo, str, str2, Integer.valueOf(i16), bundle, cVar);
            return;
        }
        QLog.i("DevLockVerifyComponent", 1, "startVerify loginType = " + i3);
        if (str != null) {
            str3 = str;
        } else {
            str3 = "";
        }
        this.f242662b = System.currentTimeMillis();
        x("0X800C27F", str3, i(i3), 0, "", "", "", "");
        ((ILoginReporter) QRoute.api(ILoginReporter.class)).reportLoginDevLockVerify(devlockInfo);
        if (devlockInfo != null && !TextUtils.isEmpty(devlockInfo.Mobile)) {
            z16 = true;
        }
        if (i3 != 4 && i3 != 5 && z16) {
            if (i16 == 239 && m()) {
                w(i3, devlockInfo);
                z(i3, devlockInfo, str3, bundle, cVar);
                return;
            } else if (i16 != 239 && i16 != 160) {
                final String str4 = str3;
                y(new Runnable() { // from class: com.tencent.mobileqq.login.verify.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        DevLockVerifyComponent.this.t(i3, str4, str2, bundle, devlockInfo, cVar);
                    }
                });
                return;
            } else {
                w(i3, devlockInfo);
                final String str5 = str3;
                y(new Runnable() { // from class: com.tencent.mobileqq.login.verify.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        DevLockVerifyComponent.this.s(i3, str5, bundle, devlockInfo, cVar);
                    }
                });
                return;
            }
        }
        final String str6 = str3;
        y(new Runnable() { // from class: com.tencent.mobileqq.login.verify.c
            @Override // java.lang.Runnable
            public final void run() {
                DevLockVerifyComponent.this.r(i3, str6, str2, bundle, devlockInfo, cVar);
            }
        });
    }

    public boolean l() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        int simState = ((TelephonyManager) BaseApplication.getContext().getSystemService("phone")).getSimState();
        if (simState != 0 && simState != 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("DevLockVerifyComponent", 1, "hasSimCard result : ", Boolean.valueOf(z16));
        return z16;
    }
}
