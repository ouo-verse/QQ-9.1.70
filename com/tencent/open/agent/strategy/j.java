package com.tencent.open.agent.strategy;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.open.agent.QuickLoginAuthorityActivity;
import com.tencent.open.agent.util.t;
import com.tencent.open.util.OpenSdkProcessSwitchAccountHelper;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes22.dex */
class j extends c {

    /* renamed from: b, reason: collision with root package name */
    private Activity f340583b;

    /* renamed from: c, reason: collision with root package name */
    private Intent f340584c;

    /* renamed from: d, reason: collision with root package name */
    private BroadcastReceiver f340585d;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            t.b("QuickLoginAction", "onReceive action=", intent.getAction());
            j.this.f340583b.unregisterReceiver(this);
            if ("action_login_sucess".equals(intent.getAction())) {
                j.this.j(intent);
                j.this.k(intent);
            }
        }
    }

    public j(String str) {
        super(str);
        this.f340585d = new a();
    }

    private void i(Intent intent, Activity activity, Bundle bundle) {
        t.b("QuickLoginAction", "qq is not login, first login it");
        this.f340583b = activity;
        this.f340584c = intent;
        intent.putExtra("authority_start_qq_login", true);
        this.f340584c.putExtra("key_action", this.f340578a);
        this.f340584c.putExtra("key_params", bundle);
        Intent intent2 = new Intent();
        intent2.putExtra("authority_start_qq_login", true);
        if (!"action_ptlogin_login".equals(this.f340578a)) {
            intent2.setFlags(268435456);
            intent2.addFlags(32768);
        }
        com.tencent.open.agent.util.b.i(intent2, bundle, bundle.getString(CommonConstant.ReqAccessTokenParam.CLIENT_ID));
        activity.registerReceiver(this.f340585d, new IntentFilter("action_login_sucess"));
        RouteUtils.startActivity(activity, intent2, RouterConstants.UI_ROUTER_LOGIN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Intent intent) {
        String l3 = com.tencent.open.agent.util.c.l(intent, "login_success_uin");
        if (!TextUtils.isEmpty(l3)) {
            this.f340584c.putExtra("login_success_uin", l3);
        }
        this.f340583b.startActivityForResult(this.f340584c, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Intent intent) {
        if (OpenSdkProcessSwitchAccountHelper.b()) {
            return;
        }
        if (l().isLogin()) {
            t.f("QuickLoginAction", "syncLogin isLogin");
            return;
        }
        if (intent.getBooleanExtra("forbid_quick_login_after", false)) {
            t.f("QuickLoginAction", "syncLogin FORBID_QUICK_LOGIN_AFTER");
            return;
        }
        String account = l().getAccount();
        t.f("QuickLoginAction", "syncLogin not login, to login uin= " + account);
        if (TextUtils.isEmpty(account)) {
            return;
        }
        List<SimpleAccount> allAccounts = l().getApplication().getAllAccounts();
        if (allAccounts != null && !allAccounts.isEmpty()) {
            for (SimpleAccount simpleAccount : allAccounts) {
                if (account.equals(simpleAccount.getUin())) {
                    l().login(simpleAccount);
                    return;
                }
            }
            return;
        }
        t.f("QuickLoginAction", "syncLogin list == null || list.isEmpty()");
    }

    private AppRuntime l() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    @Override // com.tencent.open.agent.strategy.c
    public void d(Activity activity, Bundle bundle) {
        Intent intent = new Intent(activity, (Class<?>) QuickLoginAuthorityActivity.class);
        bundle.putString("packagename", com.tencent.open.agent.util.g.B(activity));
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null && !waitAppRuntime.isLogin()) {
            i(intent, activity, bundle);
        } else {
            c(intent, activity, bundle);
        }
    }
}
