package com.tencent.mobileqq.app.identity;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae$AuthTips;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae$RspBody;

/* loaded from: classes11.dex */
public class AccountPhoneUnityManager extends com.tencent.mobileqq.app.identity.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Dialog f195753a;

    /* renamed from: b, reason: collision with root package name */
    private BroadcastReceiver f195754b;

    /* renamed from: c, reason: collision with root package name */
    private long f195755c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends com.tencent.mobileqq.observer.c {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppRuntime f195763d;

        a(AppRuntime appRuntime) {
            this.f195763d = appRuntime;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountPhoneUnityManager.this, (Object) appRuntime);
            }
        }

        @Override // com.tencent.mobileqq.observer.c
        public void getPhoneUnitySuccess(cmd0x9ae$RspBody cmd0x9ae_rspbody) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cmd0x9ae_rspbody);
            } else {
                AccountPhoneUnityManager.this.k(this.f195763d, cmd0x9ae_rspbody);
            }
        }

        @Override // com.tencent.mobileqq.observer.c
        public void onFailedResponse(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2);
            } else {
                QLog.e("AccountPhoneUnityManager", 1, "onFailedResponse code : ", Integer.valueOf(i3), " message : ", str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f195765d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f195766e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AppRuntime f195767f;

        b(boolean z16, Activity activity, AppRuntime appRuntime) {
            this.f195765d = z16;
            this.f195766e = activity;
            this.f195767f = appRuntime;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AccountPhoneUnityManager.this, Boolean.valueOf(z16), activity, appRuntime);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                AccountPhoneUnityManager.this.f195753a.dismiss();
                if (this.f195765d) {
                    ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).logout(this.f195766e, false);
                } else {
                    BannerManager.l().O(com.tencent.mobileqq.banner.d.f200250c, 2, null);
                    ReportController.o(this.f195767f, "dc00898", "", "", "0X800B3E5", "0X800B3E5", 0, 0, "", "", "", "");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f195769d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f195770e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AppRuntime f195771f;

        c(Activity activity, boolean z16, AppRuntime appRuntime) {
            this.f195769d = activity;
            this.f195770e = z16;
            this.f195771f = appRuntime;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AccountPhoneUnityManager.this, activity, Boolean.valueOf(z16), appRuntime);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (System.currentTimeMillis() - AccountPhoneUnityManager.this.f195755c >= 1000) {
                AccountPhoneUnityManager.this.f195755c = System.currentTimeMillis();
                QRoute.startUri(this.f195769d, RouterConstants.UI_ROUTER_PHONE_INFO);
                if (this.f195770e) {
                    str = "0X800B3E7";
                } else {
                    str = "0X800B3E4";
                }
                String str2 = str;
                ReportController.o(this.f195771f, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class d implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountPhoneUnityManager.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AccountPhoneUnityManager.this.f195753a = null;
                QLog.d("AccountPhoneUnityManager", 1, "dialog dismiss");
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class e implements DialogInterface.OnCancelListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountPhoneUnityManager.this);
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AccountPhoneUnityManager.this.f195753a = null;
                QLog.d("AccountPhoneUnityManager", 1, "dialog cancel");
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class f extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            QLog.d("AccountPhoneUnityManager", 1, "onReceive broadcast");
            ReportController.o(MobileQQ.sMobileQQ.waitAppRuntime(null), "dc00898", "", "", "0X800B3EB", "0X800B3EB", 0, 0, "", "", "", "");
            com.tencent.mobileqq.app.identity.c a16 = AccountLifeCycleClient.b().a(AccountPhoneUnityManager.class);
            if (a16 instanceof AccountPhoneUnityManager) {
                AccountPhoneUnityManager accountPhoneUnityManager = (AccountPhoneUnityManager) a16;
                accountPhoneUnityManager.m();
                accountPhoneUnityManager.s(context);
            }
        }

        /* synthetic */ f(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) anonymousClass1);
        }
    }

    public AccountPhoneUnityManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean h() {
        return new k().a(QBaseActivity.sTopActivity);
    }

    private void l() {
        if (MobileQQ.sProcessId != 1) {
            QLog.d("AccountPhoneUnityManager", 1, "refresh only run in main process");
            return;
        }
        AppRuntime f16 = f();
        if (f16 == null) {
            QLog.d("AccountPhoneUnityManager", 1, "refresh, app is null");
            return;
        }
        ThreadManager.getUIHandler().postDelayed(new Runnable(f16) { // from class: com.tencent.mobileqq.app.identity.AccountPhoneUnityManager.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AppRuntime f195756d;

            {
                this.f195756d = f16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountPhoneUnityManager.this, (Object) f16);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    AccountPhoneUnityManager.this.q(this.f195756d);
                }
            }
        }, 800L);
        if (g.b(this.f195753a)) {
            if (h()) {
                QLog.d("AccountPhoneUnityManager", 1, "current top activity : ", QBaseActivity.sTopActivity.getActivityName(), " is in white list");
                return;
            }
            boolean a16 = g.a(this.f195753a, QBaseActivity.sTopActivity);
            QLog.d("AccountPhoneUnityManager", 1, "dialog is showing, dialog is top activity[", Boolean.valueOf(a16), "]");
            if (!a16) {
                this.f195753a.dismiss();
                m();
                return;
            }
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.identity.AccountPhoneUnityManager.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountPhoneUnityManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (AccountPhoneUnityManager.this.i()) {
                    AccountPhoneUnityManager.this.m();
                }
            }
        }, 16, null, false);
    }

    private void o(boolean z16) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool("phone_unity_banner_tips_need_show" + MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), z16);
    }

    private void p(String str) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeString("phone_unity_banner_tips" + MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void s(Context context) {
        if (context == null) {
            QLog.d("AccountPhoneUnityManager", 1, "unregisterReceiver, context is null, use application");
            context = BaseApplication.getContext();
        }
        if (this.f195754b != null) {
            try {
                QLog.d("AccountPhoneUnityManager", 1, "unregisterReceiver");
                context.unregisterReceiver(this.f195754b);
            } catch (Exception e16) {
                QLog.d("AccountPhoneUnityManager", 1, "unregisterReceiver error : ", e16.getMessage());
            }
            this.f195754b = null;
        }
    }

    AppRuntime f() {
        if (MobileQQ.sProcessId != 1) {
            QLog.d("AccountPhoneUnityManager", 1, "getAppInterface only run in main process");
            return null;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && peekAppRuntime.isLogin()) {
            return peekAppRuntime;
        }
        QLog.e("AccountPhoneUnityManager", 1, "getAppInterface, but not login");
        return null;
    }

    synchronized void g() {
        QLog.d("AccountPhoneUnityManager", 1, "hideBanner");
        BannerManager.l().O(com.tencent.mobileqq.banner.d.f200250c, 0, null);
        p("");
        o(false);
    }

    boolean i() {
        AppRuntime f16 = f();
        if (f16 == null) {
            return false;
        }
        boolean d16 = g.d((String) com.tencent.mobileqq.utils.p.b(BaseApplication.getContext(), f16.getAccount(), "phone_unity_jwt", ""), NetConnInfoCenter.getServerTime());
        if (d16) {
            QLog.d("AccountPhoneUnityManager", 1, "dont need refresh, not time");
        }
        return !d16;
    }

    synchronized boolean j() {
        AppRuntime f16 = f();
        if (f16 == null) {
            return false;
        }
        String account = f16.getAccount();
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool("phone_unity_banner_tips_need_show" + account, false);
    }

    void k(AppRuntime appRuntime, cmd0x9ae$RspBody cmd0x9ae_rspbody) {
        boolean z16 = cmd0x9ae_rspbody.bool_need_auth_tips.get();
        cmd0x9ae$AuthTips cmd0x9ae_authtips = cmd0x9ae_rspbody.msg_auth_tips.get();
        String str = cmd0x9ae_authtips.string_lbutton.get();
        String str2 = cmd0x9ae_authtips.string_rbutton.get();
        String str3 = cmd0x9ae_authtips.string_tips_action.get();
        String str4 = cmd0x9ae_authtips.string_tips_action_url.get();
        String str5 = cmd0x9ae_authtips.string_tips_context.get();
        String str6 = cmd0x9ae_authtips.string_tips_title.get();
        String stringUtf8 = cmd0x9ae_rspbody.bytes_jwt.get().toStringUtf8();
        String str7 = cmd0x9ae_rspbody.msg_small_tips.string_tips_context.get();
        boolean z17 = false;
        if (QLog.isColorLevel()) {
            QLog.d("AccountPhoneUnityManager", 2, "success, needAuth : ", Boolean.valueOf(z16), " leftText : ", str, " rightText : ", str2, " tipsAction : ", str3, " url : ", str4, " content : ", str5, " title : ", str6, " jwt : ", stringUtf8, "tips : ", str7);
        }
        if (TextUtils.isEmpty(stringUtf8)) {
            QLog.e("AccountPhoneUnityManager", 1, "error : jwt is empty");
            return;
        }
        String h16 = g.h(stringUtf8);
        if (TextUtils.isEmpty(h16)) {
            QLog.e("AccountPhoneUnityManager", 1, "error : jwt parse error");
            return;
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null) {
            QLog.e("AccountPhoneUnityManager", 1, "onPhoneUnityDataResp, but activity is null");
            return;
        }
        com.tencent.mobileqq.utils.p.g(qBaseActivity, appRuntime.getAccount(), true, "phone_unity_jwt", stringUtf8);
        boolean b16 = g.b(this.f195753a);
        if (!z16) {
            QLog.d("AccountPhoneUnityManager", 1, "need auth false, isShowing : ", Boolean.valueOf(b16));
            if (b16) {
                this.f195753a.dismiss();
            }
            g();
            return;
        }
        if (b16) {
            if (g.a(this.f195753a, qBaseActivity) || h()) {
                z17 = true;
            }
            if (z17) {
                QLog.d("AccountPhoneUnityManager", 1, "dialog is invalid");
                return;
            }
            this.f195753a.dismiss();
        }
        p(str7);
        o(true);
        ThreadManager.getUIHandler().postDelayed(new Runnable(h16, str, str2, str5, str6, appRuntime, qBaseActivity) { // from class: com.tencent.mobileqq.app.identity.AccountPhoneUnityManager.4
            static IPatchRedirector $redirector_;
            final /* synthetic */ Activity C;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f195757d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f195758e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f195759f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f195760h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ String f195761i;

            /* renamed from: m, reason: collision with root package name */
            final /* synthetic */ AppRuntime f195762m;

            {
                this.f195757d = h16;
                this.f195758e = str;
                this.f195759f = str2;
                this.f195760h = str5;
                this.f195761i = str6;
                this.f195762m = appRuntime;
                this.C = qBaseActivity;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, AccountPhoneUnityManager.this, h16, str, str2, str5, str6, appRuntime, qBaseActivity);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    AccountPhoneUnityManager.this.r(this.f195757d, this.f195758e, this.f195759f, this.f195760h, this.f195761i, this.f195762m, this.C);
                }
            }
        }, 700L);
    }

    void m() {
        if (MobileQQ.sProcessId != 1) {
            QLog.d("AccountPhoneUnityManager", 1, "refreshPhoneUnityData only run in main process");
            return;
        }
        AppRuntime f16 = f();
        if (f16 == null) {
            return;
        }
        LoginVerifyServlet.m(f16, new a(f16));
    }

    synchronized void n(Context context) {
        if (context == null) {
            QLog.d("AccountPhoneUnityManager", 1, "registerReceiver, context is null");
            return;
        }
        if (this.f195754b == null) {
            QLog.d("AccountPhoneUnityManager", 1, "registerReceiver");
            IntentFilter intentFilter = new IntentFilter("com.tencent.mobileqq.InvitationWebViewPlugin.accountIdentityNotify");
            f fVar = new f(null);
            this.f195754b = fVar;
            context.registerReceiver(fVar, intentFilter);
        }
    }

    @Override // com.tencent.mobileqq.app.identity.a, com.tencent.mobileqq.app.identity.c
    public void onAccountLoginOrSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AccountPhoneUnityManager", 2, "onAccountLoginOrSwitch");
        }
        l();
    }

    @Override // com.tencent.mobileqq.app.identity.a, com.tencent.mobileqq.app.identity.c
    public void onActivityDestroy(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        if (g.b(this.f195753a) && !new k().a(activity)) {
            boolean a16 = g.a(this.f195753a, activity);
            this.f195753a.dismiss();
            if (QLog.isColorLevel()) {
                QLog.d("AccountPhoneUnityManager", 2, "dialog is showing, current activity is dialog context [", Boolean.valueOf(a16), "] activity : ", activity.getClass().getSimpleName());
            }
            if (!a16 && QBaseActivity.sTopActivity != null) {
                m();
            }
        }
    }

    @Override // com.tencent.mobileqq.app.identity.a, com.tencent.mobileqq.app.identity.c
    public void onForegroundSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AccountPhoneUnityManager", 2, "onForegroundSwitch");
        }
        l();
    }

    synchronized void q(AppRuntime appRuntime) {
        if (!j()) {
            if (QLog.isColorLevel()) {
                QLog.d("AccountPhoneUnityManager", 1, "not need show banner");
            }
        } else {
            QLog.d("AccountPhoneUnityManager", 1, "show banner");
            BannerManager.l().O(com.tencent.mobileqq.banner.d.f200250c, 2, null);
            n(QBaseActivity.sTopActivity);
        }
    }

    synchronized void r(String str, String str2, String str3, String str4, String str5, AppRuntime appRuntime, Activity activity) {
        String str6;
        if (g.b(this.f195753a)) {
            QLog.d("AccountPhoneUnityManager", 1, "dialog is showing");
            return;
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            boolean g16 = g.g(str);
            QQCustomDialog e16 = g.e(qBaseActivity, str2, str3, str4, str5, false, new b(g16, qBaseActivity, appRuntime), new c(activity, g16, appRuntime));
            this.f195753a = e16;
            e16.show();
            this.f195753a.setOnDismissListener(new d());
            this.f195753a.setOnCancelListener(new e());
            if (g16) {
                str6 = "0X800B3E6";
            } else {
                str6 = "0X800B3E3";
            }
            String str7 = str6;
            n(qBaseActivity);
            ReportController.o(appRuntime, "dc00898", "", "", str7, str7, 0, 0, "", "", "", "");
            return;
        }
        QLog.e("AccountPhoneUnityManager", 1, "create dialog, but activity is finishing or null");
    }

    @Override // com.tencent.mobileqq.app.identity.a, com.tencent.mobileqq.app.identity.c
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            s(QBaseActivity.sTopActivity);
        }
    }
}
