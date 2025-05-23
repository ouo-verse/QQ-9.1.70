package com.tencent.mobileqq.app.identity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae$AuthTips;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae$RspBody;

/* compiled from: P */
/* loaded from: classes11.dex */
public class AccountIdentityManager extends com.tencent.mobileqq.app.identity.a {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private static volatile AccountIdentityManager f195715h;

    /* renamed from: a, reason: collision with root package name */
    private int f195716a;

    /* renamed from: b, reason: collision with root package name */
    protected AtomicBoolean f195717b;

    /* renamed from: c, reason: collision with root package name */
    private QQCustomDialog f195718c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f195719d;

    /* renamed from: e, reason: collision with root package name */
    boolean f195720e;

    /* renamed from: f, reason: collision with root package name */
    private f f195721f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.mobileqq.app.identity.f f195722g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a extends com.tencent.mobileqq.observer.c {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppRuntime f195729d;

        a(AppRuntime appRuntime) {
            this.f195729d = appRuntime;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountIdentityManager.this, (Object) appRuntime);
            }
        }

        @Override // com.tencent.mobileqq.observer.c
        public void getAccountIdentitySuccess(cmd0x9ae$RspBody cmd0x9ae_rspbody) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cmd0x9ae_rspbody);
            } else {
                AccountIdentityManager.this.f195717b.set(false);
                AccountIdentityManager.this.r(this.f195729d, cmd0x9ae_rspbody, this);
            }
        }

        @Override // com.tencent.mobileqq.observer.c
        public void onFailedResponse(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2);
            } else {
                AccountIdentityManager.this.f195717b.set(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f195731d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f195732e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AppRuntime f195733f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f195734h;

        b(boolean z16, Activity activity, AppRuntime appRuntime, int i3) {
            this.f195731d = z16;
            this.f195732e = activity;
            this.f195733f = appRuntime;
            this.f195734h = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AccountIdentityManager.this, Boolean.valueOf(z16), activity, appRuntime, Integer.valueOf(i3));
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (AccountIdentityManager.this.f195718c != null) {
                    AccountIdentityManager.this.f195718c.dismiss();
                }
                if (this.f195731d) {
                    ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).logout(this.f195732e, false);
                }
                if (AccountIdentityManager.this.f195722g != null) {
                    AccountIdentityManager.this.f195722g.cancel(3);
                }
                if (this.f195731d) {
                    str = "0X800C53E";
                } else {
                    str = "0X800B273";
                }
                String str2 = str;
                ReportController.o(this.f195733f, "dc00898", "", "", str2, str2, this.f195734h, 0, "", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f195736d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f195737e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f195738f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ AppRuntime f195739h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f195740i;

        c(String str, Activity activity, boolean z16, AppRuntime appRuntime, int i3) {
            this.f195736d = str;
            this.f195737e = activity;
            this.f195738f = z16;
            this.f195739h = appRuntime;
            this.f195740i = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AccountIdentityManager.this, str, activity, Boolean.valueOf(z16), appRuntime, Integer.valueOf(i3));
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Intent intent = new Intent();
                intent.putExtra("url", this.f195736d);
                RouteUtils.startActivity(this.f195737e, intent, RouterConstants.UI_ROUTE_BROWSER);
                if (AccountIdentityManager.this.f195721f == null) {
                    AccountIdentityManager.this.f195721f = new f(null);
                    this.f195737e.registerReceiver(AccountIdentityManager.this.f195721f, new IntentFilter("com.tencent.mobileqq.InvitationWebViewPlugin.accountIdentityNotify"));
                }
                if (this.f195738f) {
                    str = "0X800C53D";
                } else {
                    str = "0X800B274";
                }
                String str2 = str;
                ReportController.o(this.f195739h, "dc00898", "", "", str2, str2, this.f195740i, 0, "", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class d implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f195742d;

        d(Activity activity) {
            this.f195742d = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountIdentityManager.this, (Object) activity);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                QLog.d("AccountIdentityManager", 1, "dialog dismiss");
                AccountIdentityManager.this.t(this.f195742d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class e implements DialogInterface.OnCancelListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f195744d;

        e(Activity activity) {
            this.f195744d = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountIdentityManager.this, (Object) activity);
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                QLog.d("AccountIdentityManager", 1, "dialog cancel");
                AccountIdentityManager.this.t(this.f195744d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
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
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            AccountIdentityManager.p().s(waitAppRuntime);
            ReportController.o(waitAppRuntime, "dc00898", "", "", "0X800B278", "0X800B278", AccountIdentityManager.f195715h.f195716a, 0, "", "", "", "");
            try {
                context.unregisterReceiver(this);
            } catch (Exception e16) {
                QLog.d("AccountIdentityManager", 1, "unregisterReceiver error : ", e16.getMessage());
            }
        }

        /* synthetic */ f(a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        }
    }

    public AccountIdentityManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f195717b = new AtomicBoolean(false);
        this.f195719d = false;
        this.f195720e = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("account_identify_manager_need_check_again", true);
        this.f195722g = null;
    }

    private void o(Activity activity) {
        if (g.b(this.f195718c)) {
            if (g.a(this.f195718c, activity)) {
                this.f195719d = true;
                this.f195718c.dismiss();
            } else {
                s(MobileQQ.sMobileQQ.waitAppRuntime(null));
            }
        }
    }

    public static AccountIdentityManager p() {
        if (f195715h == null) {
            synchronized (AccountIdentityManager.class) {
                if (f195715h == null) {
                    f195715h = new AccountIdentityManager();
                }
            }
        }
        return f195715h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(AppRuntime appRuntime, cmd0x9ae$RspBody cmd0x9ae_rspbody, com.tencent.mobileqq.observer.c cVar) {
        boolean z16 = cmd0x9ae_rspbody.bool_has_been_authenticated.get();
        boolean z17 = cmd0x9ae_rspbody.bool_need_auth_tips.get();
        cmd0x9ae$AuthTips cmd0x9ae_authtips = cmd0x9ae_rspbody.msg_auth_tips.get();
        String str = cmd0x9ae_authtips.string_lbutton.get();
        String str2 = cmd0x9ae_authtips.string_rbutton.get();
        String str3 = cmd0x9ae_authtips.string_tips_action.get();
        String str4 = cmd0x9ae_authtips.string_tips_action_url.get();
        String str5 = cmd0x9ae_authtips.string_tips_context.get();
        String str6 = cmd0x9ae_authtips.string_tips_title.get();
        String stringUtf8 = cmd0x9ae_rspbody.bytes_jwt.get().toStringUtf8();
        int i3 = cmd0x9ae_rspbody.uint32_scene.get();
        String account = appRuntime.getAccount();
        if (QLog.isDevelopLevel()) {
            QLog.d("AccountIdentityManager", 2, "success, isAuthenticated : ", Boolean.valueOf(z16), " needAuth : ", Boolean.valueOf(z17), " leftText : ", str, " rightText : ", str2, " tipsAction : ", str3, " url : ", str4, " content : ", str5, " title : ", str6, " jwt : ", stringUtf8);
        }
        if (TextUtils.isEmpty(stringUtf8)) {
            QLog.e("AccountIdentityManager", 1, "error : jwt is empty");
            cVar.onFailedResponse("OidbSvc.0x9ae_13", -1, null);
            return;
        }
        String h16 = g.h(stringUtf8);
        if (h16 == null) {
            QLog.e("AccountIdentityManager", 1, "error : jwt parse error");
            cVar.onFailedResponse("OidbSvc.0x9ae_13", -1, null);
            return;
        }
        com.tencent.mobileqq.utils.p.g(BaseApplication.getContext(), account, true, "account_identity_time", stringUtf8);
        com.tencent.mobileqq.utils.p.g(BaseApplication.getContext(), account, true, "identityAuthenticated", Boolean.valueOf(z16));
        u(BaseApplication.getContext(), account, str6, str5, str, str2, str4, stringUtf8, z16);
        if (z16) {
            if (g.b(this.f195718c)) {
                this.f195718c.dismiss();
            }
            com.tencent.mobileqq.app.identity.f fVar = this.f195722g;
            if (fVar != null) {
                fVar.onSuccess();
                return;
            }
            return;
        }
        com.tencent.mobileqq.app.identity.f fVar2 = this.f195722g;
        if (fVar2 != null) {
            fVar2.onFail();
        }
        if (g.b(this.f195718c)) {
            QLog.d("AccountIdentityManager", 1, "refreshAuthorityState showDialog, but dialog is showing");
        } else {
            ThreadManager.getUIHandler().post(new Runnable(str, str2, str4, str5, str6, h16, appRuntime, i3) { // from class: com.tencent.mobileqq.app.identity.AccountIdentityManager.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ AppRuntime C;
                final /* synthetic */ int D;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f195723d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f195724e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f195725f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ String f195726h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ String f195727i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ String f195728m;

                {
                    this.f195723d = str;
                    this.f195724e = str2;
                    this.f195725f = str4;
                    this.f195726h = str5;
                    this.f195727i = str6;
                    this.f195728m = h16;
                    this.C = appRuntime;
                    this.D = i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, AccountIdentityManager.this, str, str2, str4, str5, str6, h16, appRuntime, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        if (g.b(AccountIdentityManager.this.f195718c)) {
                            QLog.d("AccountIdentityManager", 1, "refreshAuthorityState showDialog, but dialog is showing");
                            return;
                        }
                        AccountIdentityManager.this.n(this.f195723d, this.f195724e, this.f195725f, this.f195726h, this.f195727i, this.f195728m, this.C, this.D);
                        AccountIdentityManager.this.f195716a = this.D;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Context context) {
        this.f195718c = null;
        f fVar = this.f195721f;
        if (fVar != null) {
            try {
                context.unregisterReceiver(fVar);
            } catch (Exception e16) {
                QLog.d("AccountIdentityManager", 1, "DismissListener unregisterReceiver error : ", e16.getMessage());
            }
            this.f195721f = null;
        }
        if (this.f195722g != null) {
            this.f195722g = null;
        }
    }

    public void j(AppRuntime appRuntime, int i3, com.tencent.mobileqq.identification.a aVar, com.tencent.mobileqq.app.identity.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, appRuntime, Integer.valueOf(i3), aVar, fVar);
            return;
        }
        QLog.i("AccountIdentityManager", 2, "checkAccountIdentity businessId = " + i3);
        if (aVar != null && !aVar.isFollowIdentityProcess()) {
            if (fVar != null) {
                fVar.cancel(4);
            }
            QLog.i("AccountIdentityManager", 2, "checkAccountIdentity cancel by STRATEGY");
            return;
        }
        String account = appRuntime.getAccount();
        if (l(account)) {
            if (fVar != null) {
                fVar.cancel(0);
            }
            QLog.i("AccountIdentityManager", 2, "checkAccountIdentity cancel by AUTHENTICATED");
            return;
        }
        int intValue = ((Integer) com.tencent.mobileqq.utils.p.a(BaseApplication.getContext(), account, "identityShowCount", 0)).intValue();
        if (q(intValue, ((Integer) com.tencent.mobileqq.utils.p.a(BaseApplication.getContext(), account, "identitymaxlimit", 0)).intValue())) {
            if (fVar != null) {
                fVar.cancel(1);
            }
            QLog.i("AccountIdentityManager", 1, "checkAccountIdentity cancel by EXCEEDED");
            return;
        }
        String str = "identityShowBusinessCount" + i3;
        String str2 = "identitybusiness" + i3;
        int intValue2 = ((Integer) com.tencent.mobileqq.utils.p.a(BaseApplication.getContext(), account, str, 0)).intValue();
        if (q(intValue2, ((Integer) com.tencent.mobileqq.utils.p.a(BaseApplication.getContext(), account, str2, 0)).intValue())) {
            if (fVar != null) {
                fVar.cancel(2);
            }
            QLog.i("AccountIdentityManager", 1, "checkAccountIdentity cancel by LIMITATIONS");
            return;
        }
        String str3 = (String) com.tencent.mobileqq.utils.p.a(BaseApplication.getContext(), account, "identityTitle", "");
        String str4 = (String) com.tencent.mobileqq.utils.p.a(BaseApplication.getContext(), account, "identityContent", "");
        String str5 = (String) com.tencent.mobileqq.utils.p.a(BaseApplication.getContext(), account, "identityLeft", "");
        String str6 = (String) com.tencent.mobileqq.utils.p.a(BaseApplication.getContext(), account, "identityRight", "");
        String str7 = (String) com.tencent.mobileqq.utils.p.a(BaseApplication.getContext(), account, "identityUrl", "");
        String h16 = g.h((String) com.tencent.mobileqq.utils.p.a(BaseApplication.getContext(), account, "identityJwt", ""));
        this.f195722g = fVar;
        n(str5, str6, str7, str4, str3, h16, appRuntime, i3);
        this.f195716a = i3;
        com.tencent.mobileqq.utils.p.g(BaseApplication.getContext(), account, true, "identityShowCount", Integer.valueOf(intValue + 1));
        com.tencent.mobileqq.utils.p.g(BaseApplication.getContext(), account, true, str, Integer.valueOf(intValue2 + 1));
    }

    public void k(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime);
            return;
        }
        QLog.d("AccountIdentityManager", 4, "checkAccountIdentityState start");
        if (appRuntime != null && appRuntime.isLogin()) {
            if (g.b(this.f195718c)) {
                QLog.d("AccountIdentityManager", 1, "checkAccountIdentityState, dialog is showing");
                return;
            }
            if (g.d((String) com.tencent.mobileqq.utils.p.b(BaseApplication.getContext(), appRuntime.getAccount(), "account_identity_time", ""), NetConnInfoCenter.getServerTime())) {
                if (QLog.isColorLevel()) {
                    QLog.d("AccountIdentityManager", 1, "checkAccountIdentityState, is not time");
                    return;
                }
                return;
            }
            s(appRuntime);
            return;
        }
        QLog.d("AccountIdentityManager", 1, "checkAccountIdentityState, appInterface is null or is not login");
    }

    protected boolean l(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str)).booleanValue();
        }
        return ((Boolean) com.tencent.mobileqq.utils.p.a(BaseApplication.getContext(), str, "identityAuthenticated", Boolean.TRUE)).booleanValue();
    }

    public void m(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else if (TextUtils.isEmpty(str)) {
            QLog.e("AccountIdentityManager", 1, "clearAccountIdentityStatus uin is empty");
        } else {
            com.tencent.mobileqq.utils.p.g(BaseApplication.getContext(), str, true, "account_identity_time", "");
        }
    }

    public void n(String str, String str2, String str3, String str4, String str5, String str6, AppRuntime appRuntime, int i3) {
        String str7;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, str2, str3, str4, str5, str6, appRuntime, Integer.valueOf(i3));
            return;
        }
        QLog.i("AccountIdentityManager", 1, "createDialog");
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null && !topActivity.isFinishing()) {
            QQCustomDialog qQCustomDialog = this.f195718c;
            if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
                this.f195718c.dismiss();
            }
            boolean g16 = g.g(str6);
            QQCustomDialog e16 = g.e(topActivity, str, str2, str4, str5, !g16, new b(g16, topActivity, appRuntime, i3), new c(str3, topActivity, g16, appRuntime, i3));
            this.f195718c = e16;
            e16.setOnDismissListener(new d(topActivity));
            this.f195718c.setOnCancelListener(new e(topActivity));
            this.f195718c.show();
            if (g16) {
                str7 = "0X800C53C";
            } else {
                str7 = "0X800B272";
            }
            String str8 = str7;
            ReportController.o(appRuntime, "dc00898", "", "", str8, str8, i3, 0, "", "", "", "");
            return;
        }
        QLog.e("AccountIdentityManager", 1, "create dialog, but activity is finishing");
    }

    @Override // com.tencent.mobileqq.app.identity.a, com.tencent.mobileqq.app.identity.c
    public void onActivityDestroy(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        } else {
            QLog.d("AccountIdentityManager", 1, "onActivityDestroy");
            o(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.identity.a, com.tencent.mobileqq.app.identity.c
    public void onActivityResume(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        QLog.d("AccountIdentityManager", 1, "onActivityResume");
        if (!this.f195720e || MobileQQ.sProcessId != 1 || !this.f195719d) {
            return;
        }
        QLog.d("AccountIdentityManager", 1, "onActivityResume checkAgain");
        this.f195719d = false;
        if (g.b(this.f195718c)) {
            this.f195718c.dismiss();
            this.f195718c = null;
        }
        k(MobileQQ.sMobileQQ.peekAppRuntime());
    }

    @Override // com.tencent.mobileqq.app.identity.a, com.tencent.mobileqq.app.identity.c
    public void onForegroundSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.i("AccountIdentityManager", 4, "onForegroundSwitch: " + MobileQQ.sProcessId);
        if (MobileQQ.sProcessId == 1) {
            k(MobileQQ.sMobileQQ.peekAppRuntime());
        }
    }

    @Override // com.tencent.mobileqq.app.identity.a, com.tencent.mobileqq.app.identity.c
    public void onPreloadEveryLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            k(MobileQQ.sMobileQQ.peekAppRuntime());
        }
    }

    protected boolean q(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        if (i3 >= i16) {
            return true;
        }
        return false;
    }

    public synchronized void s(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime);
            return;
        }
        if (MobileQQ.sProcessId != 1) {
            QLog.e("AccountIdentityManager", 1, "refreshAuthorityState only run in main process");
            return;
        }
        if (appRuntime != null && appRuntime.isLogin()) {
            if (this.f195717b.get()) {
                QLog.d("AccountIdentityManager", 1, "refreshAuthorityState, is requesting");
                return;
            }
            QLog.d("AccountIdentityManager", 1, "refreshAuthorityState");
            this.f195717b.set(true);
            LoginVerifyServlet.c(appRuntime, new a(appRuntime));
            return;
        }
        QLog.d("AccountIdentityManager", 1, "refreshAuthorityState, appInterface is null or is not login");
    }

    protected void u(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, context, str, str2, str3, str4, str5, str6, str7, Boolean.valueOf(z16));
            return;
        }
        com.tencent.mobileqq.utils.p.g(context, str, true, "identityTitle", str2);
        com.tencent.mobileqq.utils.p.g(context, str, true, "identityContent", str3);
        com.tencent.mobileqq.utils.p.g(context, str, true, "identityLeft", str4);
        com.tencent.mobileqq.utils.p.g(context, str, true, "identityRight", str5);
        com.tencent.mobileqq.utils.p.g(context, str, true, "identityUrl", str6);
        com.tencent.mobileqq.utils.p.g(context, str, true, "identityJwt", str7);
        com.tencent.mobileqq.utils.p.g(context, str, true, "identityAuthenticated", Boolean.valueOf(z16));
    }
}
