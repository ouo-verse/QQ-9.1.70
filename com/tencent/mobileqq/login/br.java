package com.tencent.mobileqq.login;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.request.Ticket;

/* compiled from: P */
/* loaded from: classes15.dex */
public class br {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static long f242026a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f242027d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AppRuntime f242028e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f242029f;

        a(Activity activity, AppRuntime appRuntime, String str, f72.b bVar) {
            this.f242027d = activity;
            this.f242028e = appRuntime;
            this.f242029f = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, br.this, activity, appRuntime, str, bVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                br.this.e(this.f242027d, this.f242028e.getCurrentUin(), "cancel", this.f242029f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f242031d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AppRuntime f242032e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f242033f;

        b(f72.b bVar, Activity activity, AppRuntime appRuntime, String str) {
            this.f242031d = activity;
            this.f242032e = appRuntime;
            this.f242033f = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, br.this, bVar, activity, appRuntime, str);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            br.this.e(this.f242031d, this.f242032e.getCurrentUin(), "logout", this.f242033f);
            br.this.f(this.f242032e);
            br.this.b(this.f242031d, this.f242032e);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72781);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f242026a = 0L;
        }
    }

    public br() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(Activity activity, AppRuntime appRuntime, String str, String str2, String str3, f72.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, appRuntime, str, str2, str3, bVar);
            return;
        }
        if (activity != null && appRuntime != null) {
            if (!((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("Wtlogin_CleanTicket_864285725")) {
                QLog.i("TicketChecker", 1, "checkA1Error switch no enable");
                return;
            }
            long c16 = c(appRuntime);
            if (Math.abs(System.currentTimeMillis() - c16) < 10080000) {
                QLog.i("TicketChecker", 1, "checkA1Error lastTime=" + c16);
                return;
            }
            if (d(activity, appRuntime)) {
                g(activity, appRuntime, str, str2, str3, bVar);
                return;
            }
            return;
        }
        QLog.i("TicketChecker", 1, "checkA1Error activity == null || app == null");
    }

    protected void b(Activity activity, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity, (Object) appRuntime);
            return;
        }
        boolean z16 = false;
        appRuntime.updateSubAccountLogin(appRuntime.getCurrentAccountUin(), false);
        appRuntime.getApplication().refreAccountList();
        appRuntime.logout(true);
        try {
            Intent addFlags = new Intent().addFlags(67108864);
            addFlags.putExtra("logout_intent", true);
            RouteUtils.startActivity(activity, addFlags, RouterConstants.UI_ROUTER_LOGIN);
            activity.finish();
        } catch (Exception e16) {
            QLog.i("TicketChecker", 1, "forceLogout", e16);
        }
        Manager manager = appRuntime.getManager(1);
        if (manager != null) {
            WtloginManager wtloginManager = (WtloginManager) manager;
            String account = appRuntime.getAccount();
            wtloginManager.clearUserFastLoginData(account, 16L);
            wtloginManager.clearUserFastLoginData(account, BaseConstants.OPEN_SDK_BUFLAG_B1);
            wtloginManager.refreshMemorySig();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("forceLogout manage = ");
        if (manager == null) {
            z16 = true;
        }
        sb5.append(z16);
        QLog.i("TicketChecker", 1, sb5.toString());
    }

    protected long c(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime)).longValue();
        }
        long j3 = f242026a;
        if (j3 > 0) {
            return j3;
        }
        if (appRuntime != null) {
            try {
                MMKVOptionEntity from = QMMKV.from(appRuntime.getApplicationContext(), "common_mmkv_configurations");
                String account = appRuntime.getAccount();
                if (account == null) {
                    account = "noLogin";
                }
                if (!from.decodeBool("sp_key_ticket_checker_logout_has_migrate_to_mmkv", false)) {
                    f242026a = appRuntime.getPreferences().getLong("sp_key_ticket_checker_logout", 0L);
                    from.encodeLong("sp_key_ticket_checker_logout_" + account, f242026a);
                    from.encodeBool("sp_key_ticket_checker_logout_has_migrate_to_mmkv", true);
                } else {
                    f242026a = from.decodeLong("sp_key_ticket_checker_logout_" + account, 0L);
                }
            } catch (Exception e16) {
                QLog.i("TicketChecker", 1, "getLastLogoutTime", e16);
            }
        }
        return f242026a;
    }

    protected boolean d(Context context, AppRuntime appRuntime) {
        boolean z16;
        int i3;
        Ticket d2Ticket;
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) appRuntime)).booleanValue();
        }
        if (context != null && appRuntime != null) {
            if (!appRuntime.isLogin()) {
                QLog.i("TicketChecker", 1, "isA1EmptyButD2NoEmpty is no Login ");
                return false;
            }
            String currentAccountUin = appRuntime.getCurrentAccountUin();
            if (TextUtils.isEmpty(currentAccountUin)) {
                QLog.i("TicketChecker", 1, "isA1EmptyButD2NoEmpty uin isEmpty");
                return false;
            }
            WtloginManager wtloginManager = (WtloginManager) appRuntime.getManager(1);
            if (wtloginManager != null) {
                z16 = wtloginManager.isUserHaveA1(currentAccountUin, 16L);
            } else {
                z16 = true;
            }
            TicketManager ticketManager = (TicketManager) appRuntime.getManager(2);
            if (ticketManager != null && (d2Ticket = ticketManager.getD2Ticket(currentAccountUin)) != null && (bArr = d2Ticket._sig) != null) {
                i3 = bArr.length;
            } else {
                i3 = 0;
            }
            QLog.i("TicketChecker", 1, "isA1EmptyButD2NoEmpty isUserHaveA1=" + z16 + ",d2TicketLength=" + i3);
            if (z16 || i3 <= 0) {
                return false;
            }
            return true;
        }
        QLog.i("TicketChecker", 1, "isA1EmptyButD2NoEmpty context == null || app == null");
        return false;
    }

    protected void e(Context context, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, context, str, str2, str3);
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("sub_type", "a1_empty_d2_no_empty");
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("action", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("bizType", str3);
        }
        hashMap.put("user_id", str);
        StatisticCollector.getInstance(context).collectPerformance(str, "wtlogin_clean_ticket", true, 0L, 0L, hashMap, "");
    }

    protected void f(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime);
            return;
        }
        f242026a = System.currentTimeMillis();
        if (appRuntime != null) {
            try {
                MMKVOptionEntity from = QMMKV.from(appRuntime.getApplicationContext(), "common_mmkv_configurations");
                String account = appRuntime.getAccount();
                if (account == null) {
                    account = "noLogin";
                }
                from.encodeLong("sp_key_ticket_checker_logout_" + account, f242026a);
                from.encodeBool("sp_key_ticket_checker_logout_has_migrate_to_mmkv", true);
            } catch (Exception e16) {
                QLog.i("TicketChecker", 1, "saveLastLogoutTime", e16);
            }
        }
    }

    public void g(Activity activity, AppRuntime appRuntime, String str, String str2, String str3, f72.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, activity, appRuntime, str, str2, str3, bVar);
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230);
        createCustomDialog.setTitle(str);
        createCustomDialog.setMessage(str2);
        createCustomDialog.setNegativeButton(HardCodeUtil.qqStr(R.string.cancel), new a(activity, appRuntime, str3, bVar));
        createCustomDialog.setPositiveButton(HardCodeUtil.qqStr(R.string.yv8), new b(bVar, activity, appRuntime, str3));
        createCustomDialog.show();
        e(activity, appRuntime.getCurrentUin(), "dialog_show", str3);
        QLog.i("TicketChecker", 1, "showLogoutDialog bizType=" + str3);
    }
}
