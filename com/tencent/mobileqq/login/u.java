package com.tencent.mobileqq.login;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.login.LoginReportConstants;
import com.tencent.mobileqq.login.api.ILoginReporter;
import com.tencent.mobileqq.login.api.IUidService;
import com.tencent.mobileqq.login.api.impl.UidServiceImpl;
import com.tencent.mobileqq.login.restart.LoginProcessRestartMonitor;
import com.tencent.mobileqq.login.restart.Scene;
import com.tencent.mobileqq.login.u;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LoadingUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.AutoLoginUtil;
import mqq.app.Constants;
import mqq.app.Foreground;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class u {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static WeakReference<Dialog> f242652a;

    /* renamed from: b, reason: collision with root package name */
    private static final List<b> f242653b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f242654c;

    /* renamed from: d, reason: collision with root package name */
    private static final Handler f242655d;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Dialog dialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 == 1) {
                Activity topActivity = Foreground.getTopActivity();
                if (topActivity != null && !topActivity.isFinishing() && !topActivity.isDestroyed()) {
                    Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(topActivity, (String) message.obj, true);
                    if (showLoadingDialog != null) {
                        try {
                            showLoadingDialog.show();
                        } catch (Exception e16) {
                            QLog.e("DirectLoginHelper", 1, "show dialog error:", e16);
                        }
                    }
                    u.f242652a = new WeakReference(showLoadingDialog);
                    return;
                }
                return;
            }
            if (i3 == 2) {
                if (u.f242652a != null) {
                    dialog = (Dialog) u.f242652a.get();
                } else {
                    dialog = null;
                }
                if (dialog != null && dialog.isShowing()) {
                    try {
                        dialog.dismiss();
                    } catch (Exception e17) {
                        QLog.e("DirectLoginHelper", 1, "dismiss dialog error:", e17);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b implements IAccountCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final String f242656d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f242657e;

        /* renamed from: f, reason: collision with root package name */
        private final boolean f242658f;

        /* renamed from: h, reason: collision with root package name */
        private final e72.a f242659h;

        public b(String str, boolean z16, boolean z17, e72.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17), aVar);
                return;
            }
            this.f242656d = str;
            this.f242657e = z16;
            this.f242658f = z17;
            this.f242659h = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            u.f242653b.remove(this);
            if (!this.f242658f && !this.f242657e) {
                ((ILoginReporter) QRoute.api(ILoginReporter.class)).reportLoginFinish(false, "");
            }
            e72.a aVar = this.f242659h;
            if (aVar != null) {
                aVar.b();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            u.f242653b.remove(this);
            if (!this.f242658f) {
                if (!this.f242657e) {
                    ((ILoginReporter) QRoute.api(ILoginReporter.class)).reportLoginFinish(true, "");
                }
                ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).setLoginType(this.f242656d, (byte) 0);
            }
            e72.a aVar = this.f242659h;
            if (aVar != null) {
                aVar.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            MobileQQ.sMobileQQ.unregisterAccountCallback(this);
        }

        private void g() {
            u.f242655d.post(new Runnable() { // from class: com.tencent.mobileqq.login.x
                @Override // java.lang.Runnable
                public final void run() {
                    u.b.this.f();
                }
            });
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChangeFailed(AppRuntime appRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
                return;
            }
            QLog.i("DirectLoginHelper", 1, "onAccountChangeFailed");
            if (this.f242658f) {
                u.s();
            }
            g();
            u.H(new Runnable() { // from class: com.tencent.mobileqq.login.w
                @Override // java.lang.Runnable
                public final void run() {
                    u.b.this.d();
                }
            });
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChanged(AppRuntime appRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
                return;
            }
            QLog.i("DirectLoginHelper", 1, "onAccountChanged");
            if (this.f242658f) {
                u.s();
            }
            g();
            if (!TextUtils.isEmpty(appRuntime.getCurrentUin())) {
                AutoLoginUtil.setAutoLogin(appRuntime.getCurrentUin(), true);
            }
            u.H(new Runnable() { // from class: com.tencent.mobileqq.login.v
                @Override // java.lang.Runnable
                public final void run() {
                    u.b.this.e();
                }
            });
        }

        @Override // mqq.app.IAccountCallback
        public void onLogout(Constants.LogoutReason logoutReason) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) logoutReason);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32442);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f242652a = null;
        f242653b = new CopyOnWriteArrayList();
        f242654c = false;
        f242655d = new a(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void A(final String str, boolean z16, final boolean z17, final e72.a aVar, int i3) {
        boolean z18;
        QLog.i("DirectLoginHelper", 1, "tryDirectLogin uin=" + StringUtil.getSimpleUinForPrint(str) + ", isNestedLogin=" + z16 + ", isSwitchAccount=" + z17);
        final SimpleAccount r16 = r(str);
        if (r16 == null) {
            QLog.i("DirectLoginHelper", 1, "tryDirectLogin simpleAccount is null");
            H(new Runnable() { // from class: com.tencent.mobileqq.login.n
                @Override // java.lang.Runnable
                public final void run() {
                    u.x(e72.a.this);
                }
            });
            return;
        }
        if (z17 && r16.isLogined() && com.tencent.mobileqq.login.restart.c.d(Scene.SWITCH_ACCOUNT)) {
            z18 = true;
        } else {
            z18 = false;
        }
        f242654c = z18;
        if (z17 && !z18) {
            I();
        }
        if (r16.isLogined() && !z16 && !z17) {
            ((ILoginReporter) QRoute.api(ILoginReporter.class)).reportLoginStart(i3, 8, str);
        }
        final b bVar = new b(str, z16, z17, aVar);
        final IUidService iUidService = (IUidService) QRoute.api(IUidService.class);
        String uid = iUidService.getUid(str);
        if (!r16.isLogined()) {
            C(r16, z17, bVar);
        } else {
            if (!UidServiceImpl.INSTANCE.a(str, uid)) {
                C(r16, z17, bVar);
                return;
            }
            QLog.i("DirectLoginHelper", 1, "request uid");
            E(str);
            iUidService.requestUid(str, 20000, new e72.c() { // from class: com.tencent.mobileqq.login.o
                @Override // e72.c
                public final void a() {
                    u.z(IUidService.this, str, z17, aVar, r16, bVar);
                }
            });
        }
    }

    private static void B(String str) {
        ArrayList<SimpleAccount> arrayList;
        long currentTimeMillis = System.currentTimeMillis();
        MobileQQ.sMobileQQ.setProperty(str + Constants.Key._logintime, String.valueOf(currentTimeMillis));
        List<SimpleAccount> allAccounts = MobileQQ.sMobileQQ.getAllAccounts();
        if (allAccounts != null) {
            arrayList = new ArrayList(allAccounts);
        } else {
            arrayList = null;
        }
        if (arrayList != null && arrayList.size() > 0) {
            for (SimpleAccount simpleAccount : arrayList) {
                if (str == null || !str.equals(simpleAccount.getUin())) {
                    MobileQQ mobileQQ = MobileQQ.sMobileQQ;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(simpleAccount.getUin());
                    Constants.Key key = Constants.Key._logintime;
                    sb5.append(key);
                    if (com.tencent.mobileqq.utils.bv.b(mobileQQ.getProperty(sb5.toString()), 0L) >= currentTimeMillis) {
                        currentTimeMillis--;
                        MobileQQ.sMobileQQ.setProperty(simpleAccount.getUin() + key, String.valueOf(currentTimeMillis));
                        QLog.d("DirectLoginHelper", 1, "modify account timestamp " + simpleAccount.getUin() + " " + currentTimeMillis);
                    }
                }
            }
        }
    }

    private static void C(@NonNull final SimpleAccount simpleAccount, boolean z16, @NonNull final b bVar) {
        QLog.i("DirectLoginHelper", 1, "realDirectLogin isSwitchAccount=" + z16);
        if (z16) {
            LoginProcessRestartMonitor.E(Scene.SWITCH_ACCOUNT, simpleAccount.getUin(), f242654c);
            if (f242654c) {
                G(new Runnable() { // from class: com.tencent.mobileqq.login.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        u.K(SimpleAccount.this, bVar);
                    }
                });
                return;
            }
        }
        D(simpleAccount, z16, bVar);
    }

    private static void D(@NonNull final SimpleAccount simpleAccount, final boolean z16, @NonNull final b bVar) {
        H(new Runnable() { // from class: com.tencent.mobileqq.login.r
            @Override // java.lang.Runnable
            public final void run() {
                u.u(u.b.this, z16, simpleAccount);
            }
        });
    }

    private static void E(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("login_uin", str);
        hashMap.put(MsfConstants.ATTRIBUTE_LOGIN_TYPE, "2");
        QQBeaconReport.report(q(), UidServiceImpl.EVENT_NT_NO_UID, hashMap);
    }

    private static void F(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("login_uin", str);
        hashMap.put(MsfConstants.ATTRIBUTE_LOGIN_TYPE, "2");
        QQBeaconReport.report(q(), UidServiceImpl.EVENT_NT_REQ_UID_FAIL, hashMap);
    }

    private static void G(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (M()) {
                ThreadManagerV2.newFreeThread(runnable, "Login_SwitchAccount", 5).start();
                return;
            } else {
                ThreadManagerV2.excute(runnable, 16, null, true);
                return;
            }
        }
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void H(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            f242655d.post(runnable);
        }
    }

    private static void I() {
        String string = BaseApplication.getContext().getString(R.string.f200914te);
        Handler handler = f242655d;
        handler.removeMessages(1);
        handler.sendMessageDelayed(handler.obtainMessage(1, string), 500L);
    }

    public static void J(String str, e72.a aVar) {
        L(str, 0, false, true, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void K(@NonNull final SimpleAccount simpleAccount, @NonNull final b bVar) {
        QLog.i("DirectLoginHelper", 1, "switchAccountAndRestartProcess uin:" + StringUtil.getSimpleUinForPrint(simpleAccount.getUin()));
        MobileQQ.sMobileQQ.peekAppRuntime().logoutByRestartProcess();
        B(simpleAccount.getUin());
        if (!TextUtils.isEmpty(simpleAccount.getUin())) {
            AutoLoginUtil.setAutoLogin(simpleAccount.getUin(), true);
        }
        H(new Runnable() { // from class: com.tencent.mobileqq.login.s
            @Override // java.lang.Runnable
            public final void run() {
                u.w(SimpleAccount.this, bVar);
            }
        });
    }

    private static void L(final String str, @LoginReportConstants.LoginScene final int i3, final boolean z16, final boolean z17, final e72.a aVar) {
        QLog.d("DirectLoginHelper", 1, "start direct login uin=" + StringUtil.getSimpleUinForPrint(str));
        G(new Runnable() { // from class: com.tencent.mobileqq.login.m
            @Override // java.lang.Runnable
            public final void run() {
                u.A(str, z16, z17, aVar, i3);
            }
        });
    }

    private static boolean M() {
        return !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("switch_account_free_thread_disable", false);
    }

    public static boolean o(String str) {
        SimpleAccount r16 = r(str);
        if (r16 != null && r16.isLogined()) {
            return true;
        }
        return false;
    }

    public static void p(String str, @LoginReportConstants.LoginScene int i3, boolean z16, e72.a aVar) {
        L(str, i3, z16, false, aVar);
    }

    private static String q() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return peekAppRuntime.getCurrentUin();
        }
        return "";
    }

    private static SimpleAccount r(String str) {
        List<SimpleAccount> allAccounts;
        if (!TextUtils.isEmpty(str) && (allAccounts = MobileQQ.sMobileQQ.getAllAccounts()) != null) {
            for (SimpleAccount simpleAccount : allAccounts) {
                if (simpleAccount != null && TextUtils.equals(str, simpleAccount.getUin())) {
                    return simpleAccount;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s() {
        Handler handler = f242655d;
        handler.removeMessages(1);
        handler.sendEmptyMessage(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u(b bVar, boolean z16, SimpleAccount simpleAccount) {
        f242653b.add(bVar);
        MobileQQ.sMobileQQ.registerAccountCallback(bVar);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (z16) {
            peekAppRuntime.switchAccount(simpleAccount, null);
        } else {
            peekAppRuntime.login(simpleAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit v(SimpleAccount simpleAccount, b bVar, Boolean bool) {
        if (!bool.booleanValue()) {
            QLog.e("DirectLoginHelper", 1, "restart main process fail");
            D(simpleAccount, true, bVar);
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(final SimpleAccount simpleAccount, final b bVar) {
        com.tencent.mobileqq.login.restart.k.f(Foreground.getTopActivity(), BaseApplication.getContext().getString(R.string.f200914te), new Function1() { // from class: com.tencent.mobileqq.login.t
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit v3;
                v3 = u.v(SimpleAccount.this, bVar, (Boolean) obj);
                return v3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x(e72.a aVar) {
        if (aVar != null) {
            aVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y(e72.a aVar) {
        QQToast.makeText(BaseApplication.getContext(), 1, BaseApplication.getContext().getString(R.string.f200874ta), 0).show();
        if (aVar != null) {
            aVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(IUidService iUidService, String str, boolean z16, final e72.a aVar, SimpleAccount simpleAccount, b bVar) {
        if (TextUtils.isEmpty(iUidService.getUid(str))) {
            QLog.e("DirectLoginHelper", 1, "request uid fail");
            F(str);
            MsfSdkUtils.updateSimpleAccountNotCreate(str, false);
            MobileQQ.sMobileQQ.refreAccountList();
            if (z16) {
                s();
            }
            H(new Runnable() { // from class: com.tencent.mobileqq.login.q
                @Override // java.lang.Runnable
                public final void run() {
                    u.y(e72.a.this);
                }
            });
            return;
        }
        C(simpleAccount, z16, bVar);
    }
}
