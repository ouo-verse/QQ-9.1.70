package com.tencent.open.agent.strategy;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.business.OpenSdkConfProcessor;
import com.tencent.mobileqq.config.business.OpenSdkSwitchProcessor;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.open.agent.PublicFragmentActivityForOpenSDK;
import com.tencent.open.agent.auth.presenter.j;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.t;
import com.tencent.open.model.AccountManage;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.qqconnect.wtlogin.AbstractOpenSdkAppInterface;
import java.util.HashMap;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MainService;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SSOLoginAction extends com.tencent.open.agent.strategy.c {

    /* renamed from: b, reason: collision with root package name */
    private Activity f340539b;

    /* renamed from: c, reason: collision with root package name */
    private Runnable f340540c;

    /* renamed from: d, reason: collision with root package name */
    private BroadcastReceiver f340541d;

    /* renamed from: e, reason: collision with root package name */
    private BroadcastReceiver f340542e;

    /* renamed from: f, reason: collision with root package name */
    private Intent f340543f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f340544g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f340545h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f340555a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f340556b;

        a(Bundle bundle, String str) {
            this.f340555a = bundle;
            this.f340556b = str;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                t.b("SSOLoginAction", "registerExpiredReceiver onReceive null == intent");
                return;
            }
            String stringExtra = intent.getStringExtra(MainService.SERVICE_CMD);
            t.b("SSOLoginAction", "registerExpiredReceiver onReceive serviceCmd=", stringExtra);
            if (MainService.CMD_PRE_AUTH.equals(stringExtra)) {
                SSOLoginAction.this.W();
                SSOLoginAction.this.P(this.f340555a, this.f340556b, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements AccountManage.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f340558a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f340559b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f340560c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f340561d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f340562e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f340563f;

        b(Bundle bundle, String str, long j3, String str2, String str3, int i3) {
            this.f340558a = bundle;
            this.f340559b = str;
            this.f340560c = j3;
            this.f340561d = str2;
            this.f340562e = str3;
            this.f340563f = i3;
        }

        @Override // com.tencent.open.model.AccountManage.h
        public void a(String str, Bundle bundle) {
            com.tencent.open.agent.util.d.j("KEY_DELEGATE_GET_TICKET_NO_PASSWD", "", false);
            SSOLoginAction.this.I(str, this.f340558a, this.f340559b);
        }

        @Override // com.tencent.open.model.AccountManage.h
        public void b(com.tencent.open.model.a aVar) {
            t.b("SSOLoginAction", "getTicketNoPasswd onSuccess:", Long.valueOf(System.currentTimeMillis() - this.f340560c));
            com.tencent.open.agent.util.d.f("KEY_DELEGATE_GET_TICKET_NO_PASSWD", aVar);
            SSOLoginAction.this.J(aVar, this.f340559b, this.f340561d, this.f340562e, this.f340558a, this.f340563f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements j.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f340565a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f340566b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f340567c;

        c(Bundle bundle, String str, int i3) {
            this.f340565a = bundle;
            this.f340566b = str;
            this.f340567c = i3;
        }

        @Override // com.tencent.open.agent.auth.presenter.j.b
        public void onFail(int i3, String str) {
            t.b("SSOLoginAction", "preAuth onFail errorCode=", Integer.valueOf(i3), ", msg=", str);
            SSOLoginAction.this.W();
            SSOLoginAction.this.H(i3, str, this.f340565a, this.f340566b, this.f340567c);
        }

        @Override // com.tencent.open.agent.auth.presenter.j.b
        public void onSuccess() {
            t.b("SSOLoginAction", "preAuth onSuccess");
            SSOLoginAction.this.W();
            SSOLoginAction.this.P(this.f340565a, this.f340566b, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f340569d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f340570e;

        d(int i3, String str) {
            this.f340569d = i3;
            this.f340570e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            SSOLoginAction.this.y(this.f340569d, this.f340570e, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class e implements AccountManage.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f340572a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f340573b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f340574c;

        e(Bundle bundle, String str, String str2) {
            this.f340572a = bundle;
            this.f340573b = str;
            this.f340574c = str2;
        }

        @Override // com.tencent.open.model.AccountManage.h
        public void a(String str, Bundle bundle) {
            com.tencent.open.agent.util.d.j("KEY_DELEGATE_GET_TICKET_NO_PASSWD", "", false);
            SSOLoginAction.this.Q(this.f340572a, this.f340573b, false, true);
            com.tencent.open.agent.util.d.s(this.f340574c, "0X800B65D");
        }

        @Override // com.tencent.open.model.AccountManage.h
        public void b(com.tencent.open.model.a aVar) {
            com.tencent.open.agent.util.d.f("KEY_DELEGATE_GET_TICKET_NO_PASSWD", aVar);
            hp3.b.e().q(this.f340573b, aVar);
            SSOLoginAction.this.P(this.f340572a, this.f340573b, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class f extends BroadcastReceiver {
        f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            t.b("SSOLoginAction", "onReceive, intent.getAction : ", intent.getAction());
            SSOLoginAction.this.Y();
            if (!"action_login_sucess".equals(intent.getAction())) {
                return;
            }
            if (intent.getBooleanExtra("param_is_qr_code_login", false)) {
                SSOLoginAction.this.b0().h(3, intent);
                BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "open_sdk_qipc_module", "action_on_qr_code_login_success", new Bundle());
                return;
            }
            String l3 = com.tencent.open.agent.util.c.l(intent, "login_success_uin");
            if (!TextUtils.isEmpty(l3)) {
                SSOLoginAction.this.f340543f.putExtra("login_success_uin", l3);
            }
            boolean booleanExtra = SSOLoginAction.this.f340543f.getBooleanExtra("intent_router", false);
            SSOLoginAction sSOLoginAction = SSOLoginAction.this;
            sSOLoginAction.S(booleanExtra, sSOLoginAction.f340543f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class g implements com.tencent.qqconnect.wtlogin.b {
        g() {
        }

        @Override // com.tencent.qqconnect.wtlogin.b
        public void a(int i3, Object obj) {
            if (i3 == 4) {
                SSOLoginAction.this.W();
                SSOLoginAction.this.Y();
            }
        }
    }

    public SSOLoginAction(String str) {
        super(str);
        this.f340544g = false;
        this.f340545h = true;
    }

    private void A() {
        Activity activity = this.f340539b;
        if (!(activity instanceof AppActivity)) {
            return;
        }
        IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) ((AppActivity) activity).getAppRuntime().getRuntimeService(IFeatureRuntimeService.class, "all");
        this.f340544g = iFeatureRuntimeService.isFeatureSwitchEnable("opensdk_login_page_new_ui_864284743");
        this.f340545h = iFeatureRuntimeService.isFeatureSwitchEnable("opensdk_proxy_login_check_should_use_new_ui", true);
        t.f("SSOLoginAction", "checkFeatureSwitchStatus isProxyLoginCheckShouldUseNewUI: " + this.f340545h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(Bundle bundle, String str, String str2) {
        t.b("SSOLoginAction", "doRouterForImBlock");
        String string = bundle.getString("key_proxy_appid");
        if (TextUtils.isEmpty(string)) {
            string = str;
        }
        com.tencent.open.agent.util.d.B("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
        AccountManage.g().j(str2, string, 1, new e(bundle, str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Bundle bundle, String str, int i3) {
        String str2;
        t.b("SSOLoginAction", "doVirtualAuth");
        String w3 = com.tencent.open.agent.util.g.w(up3.b.j(), this.f340539b.getIntent());
        if (TextUtils.isEmpty(w3)) {
            t.b("SSOLoginAction", "doVirtualAuth currentUin is null");
            P(bundle, str, false);
            return;
        }
        String string = bundle.getString("key_proxy_appid");
        if (TextUtils.isEmpty(string)) {
            str2 = str;
        } else {
            str2 = string;
        }
        String o16 = com.tencent.open.agent.util.c.o(bundle.getString("key_proxy_token"));
        t.b("SSOLoginAction", "doVirtualAuth proxyToken: " + o16);
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.open.agent.util.d.B("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
        AccountManage.g().j(w3, str2, i3, new b(bundle, str, currentTimeMillis, string, o16, i3));
    }

    private String D(Bundle bundle, String str) {
        String B = com.tencent.open.agent.util.g.B(this.f340539b);
        t.b("SSOLoginAction", "getCallingPkgName pkgName=", B);
        if (!TextUtils.isEmpty(B)) {
            if (a0(bundle, B)) {
                t.f("SSOLoginAction", "getCallingPkgName fib check");
            } else {
                return B;
            }
        }
        if (!OpenSdkConfProcessor.a()) {
            t.b("SSOLoginAction", "getCallingPkgName do not use third transform name");
            return B;
        }
        String string = bundle.getString("ppsts");
        if (TextUtils.isEmpty(string)) {
            t.b("SSOLoginAction", "getCallingPkgName ppsts is empty");
            return B;
        }
        String g16 = com.tencent.open.agent.util.m.g(bundle);
        String e16 = com.tencent.open.agent.util.m.e(string, g16);
        t.b("SSOLoginAction", "getCallingPkgName can not get calling package name, use decryptPkgName=", e16);
        String w3 = com.tencent.open.agent.util.g.w(up3.b.j(), this.f340539b.getIntent());
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("appId", str);
        hashMap.put("ppsts", string);
        hashMap.put(WidgetCacheLunarData.SHA, g16);
        StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(w3, "use_third_pkg_name", !TextUtils.isEmpty(e16), 0L, 0L, hashMap, "", false);
        return e16;
    }

    private String[] E(Bundle bundle, String str) {
        String[] f16;
        String D = D(bundle, str);
        if (TextUtils.isEmpty(D)) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("appId", str);
            StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(com.tencent.open.agent.util.g.w(up3.b.j(), this.f340539b.getIntent()), "login_pkg_name_empty", true, 0L, 0L, hashMap, "", false);
            com.tencent.open.agent.util.d.r(1, "LOGIN_CHECK_AGENT", null, str, 0, "AgentActivity callingPkgName is null");
            return new String[]{"", ""};
        }
        if (Z(bundle, this.f340539b)) {
            String i3 = com.tencent.open.agent.util.c.i(bundle, "packagesign");
            if (!TextUtils.isEmpty(i3) && (f16 = com.tencent.open.agent.util.b.f(D, i3)) != null && f16.length == 2) {
                t.f("SSOLoginAction", "getSignAndTime fib: " + D);
                bundle.putString("packagename", D);
                bundle.putString("packagesign", i3);
                bundle.putString("sign", f16[0]);
                bundle.putString("time", f16[1]);
                com.tencent.open.agent.util.d.r(0, "LOGIN_CHECK_AGENT", null, str, 0, null);
                return f16;
            }
        }
        String[] k3 = OpenSdkVirtualUtil.k(D);
        bundle.putString("packagename", D);
        bundle.putString("packagesign", k3[0]);
        bundle.putString("sign", k3[1]);
        bundle.putString("time", k3[2]);
        com.tencent.open.agent.util.d.r(0, "LOGIN_CHECK_AGENT", null, str, 0, null);
        return new String[]{k3[1], k3[2]};
    }

    private void F(Bundle bundle, String str, Intent intent, boolean z16) {
        t.b("SSOLoginAction", "toMainLogin qq is not login, first login it");
        this.f340543f = intent;
        intent.putExtra("authority_start_qq_login", true);
        this.f340543f.putExtra("intent_router", z16);
        Intent intent2 = new Intent();
        intent2.putExtra("authority_start_qq_login", true);
        intent2.putExtra("appid", str);
        intent2.putExtra("oauth_app_name", com.tencent.open.agent.util.c.i(bundle, "oauth_app_name"));
        intent2.putExtra("param_qr_code_url", z(bundle, str, "main"));
        intent2.putExtra("packagename", D(bundle, str));
        intent2.setFlags(268435456);
        intent2.addFlags(32768);
        intent2.addFlags(8388608);
        com.tencent.open.agent.util.b.i(intent2, bundle, str);
        N();
        RouteUtils.startActivity(this.f340539b, intent2, RouterConstants.UI_ROUTER_LOGIN);
    }

    private void G(Bundle bundle, String str, int i3) {
        if (i3 == 1) {
            C(bundle, str, 3);
        } else {
            Q(bundle, str, true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(int i3, String str, Bundle bundle, String str2, int i16) {
        t.e("SSOLoginAction", "onPreAuthFailed errorCode: " + i3 + ", msg: " + str);
        switch (i3) {
            case -10005:
            case 110537:
                Q(bundle, str2, false, true);
                return;
            case 1002:
                break;
            case 2001:
                Q(bundle, str2, false, true);
                return;
            case 110509:
                G(bundle, str2, i16);
                return;
            case 110513:
                y(0, "", "");
                return;
            case 110530:
                this.f340544g = false;
                break;
            default:
                R(i3, str);
                return;
        }
        P(bundle, str2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(String str, Bundle bundle, String str2) {
        t.b("SSOLoginAction", "getTicketNoPasswd onFail");
        if (!TextUtils.isEmpty(str) && str.equals(up3.b.i())) {
            Q(bundle, str2, false, true);
            com.tencent.open.agent.util.d.s(str, "0X800B65D");
        } else {
            P(bundle, str2, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(com.tencent.open.model.a aVar, String str, String str2, String str3, Bundle bundle, int i3) {
        hp3.b.e().q(str, aVar);
        K(aVar, str, str2, str3, bundle, i3);
    }

    private void K(com.tencent.open.model.a aVar, String str, String str2, String str3, Bundle bundle, int i3) {
        L(bundle, str);
        com.tencent.open.agent.auth.presenter.j jVar = new com.tencent.open.agent.auth.presenter.j();
        String D = D(bundle, str);
        t.f("SSOLoginAction", "preAuth package= " + D);
        jVar.i(D, str, str2, str3, bundle, aVar, new c(bundle, str, i3), 0);
    }

    private void L(final Bundle bundle, final String str) {
        this.f340539b.runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.strategy.SSOLoginAction.8
            @Override // java.lang.Runnable
            public void run() {
                t.b("SSOLoginAction", "registerExpiredCallback");
                SSOLoginAction.this.x(bundle, str);
                SSOLoginAction.this.M(bundle, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(Bundle bundle, String str) {
        t.b("SSOLoginAction", "registerExpiredReceiver mExpiredReceiver=", this.f340542e);
        if (this.f340542e != null) {
            return;
        }
        a aVar = new a(bundle, str);
        this.f340542e = aVar;
        this.f340539b.registerReceiver(aVar, new IntentFilter(NewIntent.ACTION_ACCOUNT_EXPIRED));
    }

    private void N() {
        t.b("SSOLoginAction", "registerLoginReceiver mLoginReceiver=", this.f340541d);
        if (this.f340541d != null) {
            return;
        }
        f fVar = new f();
        this.f340541d = fVar;
        try {
            this.f340539b.registerReceiver(fVar, new IntentFilter("action_login_sucess"));
        } catch (Throwable th5) {
            t.d("SSOLoginAction", "registerLoginReceiver error", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        if (this.f340540c != null) {
            t.b("SSOLoginAction", "removeExpiredRunnable");
            ThreadManager.getUIHandler().removeCallbacks(this.f340540c);
            this.f340540c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(Bundle bundle, String str, boolean z16) {
        Q(bundle, str, z16, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(Bundle bundle, String str, boolean z16, boolean z17) {
        t.b("SSOLoginAction", "routerToAuthActivity isForceToLogin=", Boolean.valueOf(z17), ", isNew=", Boolean.valueOf(z16), ", shouldUseNewUI=", Boolean.valueOf(this.f340544g));
        boolean z18 = !z16;
        if (this.f340545h) {
            if (!z16 && !this.f340544g) {
                z18 = true;
            } else {
                z18 = false;
            }
        }
        t.b("SSOLoginAction", "routerToAuthActivity check isOldUi? ", Boolean.valueOf(z18), ", routeToLoginWhenProxy= ", Boolean.valueOf(this.f340545h));
        if (z18 && !TextUtils.isEmpty(com.tencent.open.agent.util.c.i(bundle, "key_proxy_appid"))) {
            t.b("SSOLoginAction", "routerToAuthActivity to old login, not support");
            y(-10000, "error", "not support proxy login");
            return;
        }
        w();
        Intent intent = new Intent();
        intent.putExtra("key_action", this.f340578a);
        intent.putExtra("key_params", bundle);
        intent.putExtra("param_qr_code_url", z(bundle, str, "add"));
        intent.putExtra("packagename", D(bundle, str));
        if (U(z17)) {
            F(bundle, str, intent, z16);
        } else {
            S(z16, intent);
        }
    }

    private void R(int i3, String str) {
        String format;
        if (i3 == -1) {
            format = this.f340539b.getResources().getString(R.string.f171155cp4);
        } else if (TextUtils.isEmpty(str)) {
            format = String.format(this.f340539b.getResources().getString(R.string.cot), Integer.valueOf(i3));
        } else {
            format = String.format(this.f340539b.getResources().getString(R.string.e0_), str, Integer.valueOf(i3));
        }
        AuthUIUtil.i(format, this.f340539b, new d(i3, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(boolean z16, Intent intent) {
        try {
            t.b("SSOLoginAction", "go to auth UI");
            if (!z16 && !this.f340544g) {
                intent.setComponent(new ComponentName(this.f340539b, (Class<?>) AuthorityActivity.class));
                this.f340539b.startActivityForResult(intent, 0);
            }
            intent.putExtra("public_fragment_window_feature", 1);
            QPublicFragmentActivity.b.e(this.f340539b, intent, PublicFragmentActivityForOpenSDK.class, OpenAuthorityFragment.class, 0);
        } catch (ActivityNotFoundException e16) {
            t.d("SSOLoginAction", "start Auth ActivityNotFoundException ", e16);
            e(this.f340539b, -6);
        }
    }

    private boolean T(final Bundle bundle, final String str) {
        final String w3 = com.tencent.open.agent.util.g.w(up3.b.j(), this.f340539b.getIntent());
        if (TextUtils.isEmpty(w3) || !w3.equals(up3.b.i())) {
            return false;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.agent.strategy.SSOLoginAction.2
            @Override // java.lang.Runnable
            public void run() {
                SSOLoginAction.this.B(bundle, str, w3);
            }
        }, 128, null, false);
        return true;
    }

    private boolean U(boolean z16) {
        if (z16) {
            return true;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            t.e("SSOLoginAction", "toMainLogin, appRuntime = null");
        } else {
            if (peekAppRuntime.isLogin()) {
                return false;
            }
            t.b("SSOLoginAction", "Not login.");
        }
        return TextUtils.isEmpty(up3.b.i());
    }

    private boolean V(final Bundle bundle, final String str) {
        if (!OpenSdkSwitchProcessor.a(467).a().f202525a) {
            if ("101483258".equals(str) || "101842799".equals(str)) {
                this.f340544g = false;
            }
            return false;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.agent.strategy.SSOLoginAction.1
            @Override // java.lang.Runnable
            public void run() {
                SSOLoginAction.this.C(bundle, str, 1);
            }
        }, 128, null, false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        this.f340539b.runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.strategy.SSOLoginAction.10
            @Override // java.lang.Runnable
            public void run() {
                t.b("SSOLoginAction", "unregisterExpiredCallback");
                SSOLoginAction.this.X();
                SSOLoginAction.this.O();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        t.b("SSOLoginAction", "unregisterExpiredReceiver mExpiredReceiver=", this.f340542e);
        BroadcastReceiver broadcastReceiver = this.f340542e;
        if (broadcastReceiver == null) {
            return;
        }
        try {
            this.f340539b.unregisterReceiver(broadcastReceiver);
        } catch (Exception e16) {
            t.d("SSOLoginAction", "unregisterExpiredReceiver", e16);
        }
        this.f340542e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        t.e("SSOLoginAction", "unregisterLoginReceiver=", this.f340541d);
        BroadcastReceiver broadcastReceiver = this.f340541d;
        if (broadcastReceiver == null) {
            return;
        }
        try {
            this.f340539b.unregisterReceiver(broadcastReceiver);
        } catch (Exception e16) {
            t.d("SSOLoginAction", "unRegisterLoginReceiver", e16);
        }
        this.f340542e = null;
    }

    private boolean Z(Bundle bundle, Activity activity) {
        return a0(bundle, com.tencent.open.agent.util.g.B(activity));
    }

    private boolean a0(Bundle bundle, String str) {
        if ("emu".equals(com.tencent.open.agent.util.c.i(bundle, "bif")) && TextUtils.equals(str, MobileQQ.PACKAGE_NAME)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AbstractOpenSdkAppInterface b0() {
        return (AbstractOpenSdkAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    private void w() {
        b0().f(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(final Bundle bundle, final String str) {
        t.b("SSOLoginAction", "addExpiredRunnable mExpiredRunnable=", this.f340540c);
        if (this.f340540c != null) {
            return;
        }
        this.f340540c = new Runnable() { // from class: com.tencent.open.agent.strategy.SSOLoginAction.11
            @Override // java.lang.Runnable
            public void run() {
                t.b("SSOLoginAction", "addExpiredRunnable run expired");
                SSOLoginAction.this.W();
                SSOLoginAction.this.P(bundle, str, false);
            }
        };
        ThreadManager.getUIHandler().postDelayed(this.f340540c, 20000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i3, String str, String str2) {
        if (this.f340539b.isFinishing()) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("key_error_code", i3);
        intent.putExtra("key_error_msg", str);
        intent.putExtra("key_error_detail", str2);
        intent.putExtra("key_response", "");
        this.f340539b.setResult(-1, intent);
        this.f340539b.finish();
    }

    private String z(Bundle bundle, String str, String str2) {
        return com.tencent.open.agent.util.g.e(bundle, E(bundle, str), str2);
    }

    @Override // com.tencent.open.agent.strategy.c, com.tencent.open.agent.strategy.g
    public /* bridge */ /* synthetic */ void a(Activity activity) {
        super.a(activity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.open.agent.strategy.c
    public boolean b(Activity activity, Bundle bundle) {
        if (super.b(activity, bundle)) {
            return true;
        }
        com.tencent.open.agent.util.d.r(1, "LOGIN_CHECK_AGENT", null, null, 0, "AgentActivity bundle is null");
        return false;
    }

    @Override // com.tencent.open.agent.strategy.c
    public void d(Activity activity, Bundle bundle) {
        if (activity == null) {
            t.e("SSOLoginAction", "doAction, activity is null");
            return;
        }
        this.f340539b = activity;
        A();
        String string = bundle.getString(CommonConstant.ReqAccessTokenParam.CLIENT_ID);
        t.b("SSOLoginAction", "ssoLogin appId=", string, ", sdkv=", com.tencent.open.agent.util.c.i(bundle, "sdkv"));
        com.tencent.open.agent.util.d.z(b0().getCurrentAccountUin(), string, "8", "0", true);
        if (V(bundle, string) || T(bundle, string)) {
            return;
        }
        P(bundle, string, false);
    }
}
