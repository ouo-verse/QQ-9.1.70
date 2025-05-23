package com.tencent.mobileqq.vasgift.api.impl.service;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqgift.verify.QQGiftPanelVerifyBroadcastReceiver;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.vas.ar;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import oh2.c;

/* compiled from: P */
/* loaded from: classes20.dex */
public class g implements oh2.c {

    /* renamed from: a, reason: collision with root package name */
    private nh2.c f311481a;

    /* renamed from: f, reason: collision with root package name */
    private QQGiftPanelVerifyBroadcastReceiver f311486f;

    /* renamed from: b, reason: collision with root package name */
    private int f311482b = -1;

    /* renamed from: c, reason: collision with root package name */
    private int f311483c = -1;

    /* renamed from: d, reason: collision with root package name */
    private String f311484d = null;

    /* renamed from: e, reason: collision with root package name */
    private String f311485e = null;

    /* renamed from: g, reason: collision with root package name */
    private boolean f311487g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f311488h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f311489i = ar.b("anzaihuang", "2024-07-17", "vas_wallet_identify_dialog_switch").isEnable(true);

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends com.tencent.mobileqq.qqgift.sso.c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c.a f311490d;

        a(c.a aVar) {
            this.f311490d = aVar;
        }

        @Override // com.tencent.mobileqq.qqgift.sso.c
        public void a(int i3, boolean z16, com.tencent.mobileqq.qqgift.sso.d dVar) {
            QLog.i("QQGiftWalletIdentifyModuleImpl", 1, "checkIdentityStatus onReceive type:" + i3 + ",isSuccess:" + z16 + ",data:" + dVar);
            if (dVar == null) {
                this.f311490d.a(false, -3, "\u51fa\u9519\u4e86\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
                return;
            }
            int a16 = dVar.a();
            if (z16) {
                g.this.t0(dVar);
                if (!TextUtils.isEmpty(g.this.f311484d)) {
                    a16 = -11153;
                }
            }
            if (a16 == 0) {
                this.f311490d.a(true, a16, "");
                return;
            }
            if (a16 == -11153) {
                this.f311490d.a(false, a16, "\u672a\u5b9e\u540d\u8ba4\u8bc1");
                return;
            }
            if (a16 == -11154) {
                this.f311490d.a(false, a16, "\u672a\u6ee118\u5468\u5c81\u4ed8\u8d39\u529f\u80fd\u6682\u4e0d\u53ef\u7528");
                return;
            }
            this.f311490d.a(false, a16, "checkIdentityStatus got wrong, errorCode:" + a16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b extends com.tencent.mobileqq.qqgift.sso.c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f311492d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f311493e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ c.a f311494f;

        b(boolean z16, Activity activity, c.a aVar) {
            this.f311492d = z16;
            this.f311493e = activity;
            this.f311494f = aVar;
        }

        @Override // com.tencent.mobileqq.qqgift.sso.c
        public void a(int i3, boolean z16, com.tencent.mobileqq.qqgift.sso.d dVar) {
            g.this.n0(z16, this.f311492d, dVar, this.f311493e, this.f311494f);
        }
    }

    private String g0() {
        if (TextUtils.isEmpty(this.f311485e)) {
            return "\u6839\u636e\u76f8\u5173\u6cd5\u5f8b\u6cd5\u89c4\uff0c\u8fdb\u884c\u5145\u503c\u4e0e\u8d60\u9001\u793c\u7269\u524d\u9700\u586b\u5199\u771f\u5b9e\u59d3\u540d\u548c\u8eab\u4efd\u8bc1\u8fdb\u884c\u5b9e\u540d\u8ba4\u8bc1";
        }
        return this.f311485e;
    }

    private void h0(Activity activity, String str, @NonNull c.a aVar) {
        if (aVar == null) {
            return;
        }
        if (activity == null) {
            aVar.a(false, -3, "activity is null");
            return;
        }
        nh2.c cVar = this.f311481a;
        if (cVar != null && !cVar.isDestroyed()) {
            com.tencent.mobileqq.qqgift.sdk.config.a sDKConfig = cVar.getSDKConfig();
            if (sDKConfig == null) {
                aVar.a(false, -3, "sdkConfig is null");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                aVar.a(false, -3, "url is empty");
                return;
            }
            String valueOf = String.valueOf(sDKConfig.f264972a);
            long currentTimeMillis = System.currentTimeMillis();
            if (p0(activity, valueOf, currentTimeMillis, aVar)) {
                o0(activity, valueOf, currentTimeMillis, str);
                return;
            }
            return;
        }
        aVar.a(false, -3, "sdk not ready");
    }

    private boolean i0(String str) {
        if (!TextUtils.isEmpty(str) && (str.startsWith("http:") || str.startsWith("https:"))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(String str, c.a aVar) {
        Activity activity = QBaseActivity.sTopActivity;
        if (activity == null) {
            activity = Foreground.getTopActivity();
        }
        s0(activity, str, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(String str, long j3, Activity activity, c.a aVar, String str2, long j16, int i3) {
        if (this.f311487g) {
            QLog.e("QQGiftWalletIdentifyModuleImpl", 1, "receive result, but destroy");
            return;
        }
        if (TextUtils.equals(str, str2) && j16 == j3) {
            if (i3 == 100) {
                this.f311488h = true;
                u0();
                r0();
                f0(activity, aVar);
                return;
            }
            return;
        }
        QLog.e("QQGiftWalletIdentifyModuleImpl", 1, "receive result, but not target");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(String str, c.a aVar, DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        Activity activity = QBaseActivity.sTopActivity;
        if (activity == null) {
            activity = Foreground.getTopActivity();
        }
        if (activity != null) {
            h0(activity, str, aVar);
        } else {
            QLog.e("QQGiftWalletIdentifyModuleImpl", 1, "showDialog click verify get activity is null!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m0(c.a aVar, DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        aVar.a(false, -2, "\u53d6\u6d88\u8ba4\u8bc1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(boolean z16, boolean z17, com.tencent.mobileqq.qqgift.sso.d dVar, Activity activity, @NonNull c.a aVar) {
        Object valueOf;
        int i3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onReceiveMqqAuthReq, sceneId:");
        sb5.append(this.f311482b);
        sb5.append(", status:");
        sb5.append(this.f311483c);
        sb5.append(", isSuccess:");
        sb5.append(z16);
        sb5.append(", errorCode:");
        if (dVar == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(dVar.a());
        }
        sb5.append(valueOf);
        QLog.e("QQGiftWalletIdentifyModuleImpl", 1, sb5.toString());
        if (dVar == null) {
            aVar.a(false, -3, "\u51fa\u9519\u4e86\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
            return;
        }
        int a16 = dVar.a();
        this.f311483c = a16;
        if (z16) {
            t0(dVar);
            if (TextUtils.isEmpty(this.f311484d)) {
                i3 = this.f311483c;
            } else {
                i3 = -11153;
            }
            this.f311483c = i3;
            if (i3 == 0) {
                aVar.a(true, i3, "");
                return;
            }
            if (i3 == -11153) {
                if (z17) {
                    n(activity, this.f311484d, aVar);
                    return;
                } else {
                    aVar.a(false, i3, "\u672a\u5b9e\u540d\u8ba4\u8bc1");
                    return;
                }
            }
            if (i3 == -11154) {
                aVar.a(false, i3, "\u672a\u6210\u5e74\u6682\u4e0d\u652f\u6301\u6253\u8d4f");
                return;
            }
            aVar.a(false, i3, "realNameAuthStatus got wrong, realNameAuthStatus:" + this.f311483c);
            return;
        }
        aVar.a(false, a16, "realNameAuthStatus got wrong, realNameAuthStatus:" + this.f311483c);
    }

    private void o0(@NonNull Activity activity, @NonNull String str, long j3, @NonNull String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("fragmentStyle", 8);
        bundle.putString("extra_key_app_id", str);
        bundle.putLong("extra_key_req_flag", j3);
        com.tencent.qqlive.common.webview.a.g(activity, str2, bundle, QQBrowserActivity.class, new int[]{536870912, 67108864}, null, str);
    }

    private boolean p0(final Activity activity, final String str, final long j3, @NonNull final c.a aVar) {
        if (this.f311486f != null) {
            u0();
        }
        this.f311486f = new QQGiftPanelVerifyBroadcastReceiver(new QQGiftPanelVerifyBroadcastReceiver.a() { // from class: com.tencent.mobileqq.vasgift.api.impl.service.f
            @Override // com.tencent.mobileqq.qqgift.verify.QQGiftPanelVerifyBroadcastReceiver.a
            public final void a(String str2, long j16, int i3) {
                g.this.k0(str, j3, activity, aVar, str2, j16, i3);
            }
        });
        try {
            MobileQQ.sMobileQQ.registerReceiver(this.f311486f, new IntentFilter("action_gift_panel_verify"));
            return true;
        } catch (Throwable th5) {
            QLog.e("QQGiftWalletIdentifyModuleImpl", 1, "registerReceiver error, ", th5);
            aVar.a(false, -3, "register receiver error");
            return false;
        }
    }

    private void q0(Activity activity, boolean z16, @NonNull c.a aVar) {
        QLog.e("QQGiftWalletIdentifyModuleImpl", 1, "requestRealNameAuth, sceneId:" + this.f311482b + ", status:" + this.f311483c);
        er4.a aVar2 = new er4.a();
        aVar2.f397072a = 100;
        ((com.tencent.mobileqq.qqgift.sso.a) this.f311481a.getExtModule("sso_module")).T("trpc.qlive.qlive_real_name_auth_svr.QliveRealNameAuthSvr", "GetMQQAuth", MessageNano.toByteArray(aVar2), 101, new b(z16, activity, aVar));
    }

    private void r0() {
        this.f311484d = null;
        this.f311485e = null;
        this.f311483c = -1;
    }

    private void s0(Activity activity, final String str, @NonNull final c.a aVar) {
        if (activity != null && !activity.isFinishing()) {
            if (this.f311488h) {
                this.f311488h = false;
                QLog.i("QQGiftWalletIdentifyModuleImpl", 1, "isWebFragmentDestroy, activity: " + activity);
                aVar.a(false, -2, "\u53d6\u6d88\u8ba4\u8bc1");
                return;
            }
            DialogUtil.createCustomDialog(activity, 230, (String) null, g0(), "\u53d6\u6d88", "\u53bb\u8ba4\u8bc1", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vasgift.api.impl.service.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    g.this.l0(str, aVar, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vasgift.api.impl.service.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    g.m0(c.a.this, dialogInterface, i3);
                }
            }).show();
            return;
        }
        QLog.e("QQGiftWalletIdentifyModuleImpl", 1, "[showDialog] activitiy is null or is finishing, activity: " + activity);
        aVar.a(false, -3, "\u51fa\u9519\u4e86\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(com.tencent.mobileqq.qqgift.sso.d dVar) {
        String str = null;
        if (dVar.b() != null) {
            try {
                er4.b c16 = er4.b.c(dVar.b());
                str = c16.f397073a;
                this.f311485e = c16.f397074b;
            } catch (Throwable th5) {
                QLog.e("QQGiftWalletIdentifyModuleImpl", 1, "tryGetVerifyUrl error, ", th5);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQGiftWalletIdentifyModuleImpl", 1, "tryGetVerifyUrl: " + str);
        }
        if (i0(str)) {
            this.f311484d = str;
        }
    }

    private void u0() {
        QQGiftPanelVerifyBroadcastReceiver qQGiftPanelVerifyBroadcastReceiver = this.f311486f;
        if (qQGiftPanelVerifyBroadcastReceiver == null) {
            return;
        }
        try {
            MobileQQ.sMobileQQ.unregisterReceiver(qQGiftPanelVerifyBroadcastReceiver);
        } catch (Throwable th5) {
            QLog.e("QQGiftWalletIdentifyModuleImpl", 1, "unregister receiver error, ", th5);
        }
        this.f311486f = null;
    }

    @Override // oh2.c
    public void C(c.a aVar) {
        QLog.i("QQGiftWalletIdentifyModuleImpl", 1, "checkIdentityStatus");
        nh2.c cVar = this.f311481a;
        if (cVar != null && !cVar.isDestroyed()) {
            er4.a aVar2 = new er4.a();
            aVar2.f397072a = 100;
            ((com.tencent.mobileqq.qqgift.sso.a) this.f311481a.getExtModule("sso_module")).G("trpc.qlive.qlive_real_name_auth_svr.QliveRealNameAuthSvr", "GetMQQAuth", MessageNano.toByteArray(aVar2), 101, new a(aVar));
        } else {
            QLog.e("QQGiftWalletIdentifyModuleImpl", 1, "[checkIdentityStatus] giftSdk\u53ef\u80fd\u8fd8\u6ca1\u521d\u59cb\u5316, giftSDK:" + this.f311481a);
            aVar.a(false, -3, "sdk not ready");
        }
    }

    @Override // nh2.a
    public void N(nh2.c cVar) {
        this.f311481a = cVar;
        if (cVar != null && cVar.getSDKConfig() != null) {
            this.f311482b = cVar.getSDKConfig().f264972a;
        }
        this.f311483c = -1;
    }

    @Override // nh2.a
    public void destroy() {
        r0();
        u0();
        this.f311487g = true;
    }

    public void f0(Activity activity, @NonNull c.a aVar) {
        m(activity, true, aVar);
    }

    @Override // oh2.c
    public String getVerifyUrl() {
        return this.f311484d;
    }

    @Override // oh2.c
    public void m(Activity activity, boolean z16, @NonNull c.a aVar) {
        QLog.e("QQGiftWalletIdentifyModuleImpl", 1, "checkAndDoIdentify, sceneId:" + this.f311482b + ", status:" + this.f311483c);
        int i3 = this.f311483c;
        if (i3 == -1) {
            q0(activity, z16, aVar);
            return;
        }
        if (i3 == 0) {
            aVar.a(true, i3, "");
            return;
        }
        if (i3 == -11153) {
            if (z16) {
                n(activity, this.f311484d, aVar);
                return;
            } else {
                aVar.a(false, i3, "\u672a\u5b9e\u540d\u8ba4\u8bc1");
                return;
            }
        }
        if (i3 == -11154) {
            aVar.a(false, i3, "\u672a\u6210\u5e74\u6682\u4e0d\u652f\u6301\u6253\u8d4f");
            return;
        }
        aVar.a(false, i3, "realNameAuthStatus got wrong, realNameAuthStatus:" + this.f311483c);
    }

    @Override // oh2.c
    public void n(Activity activity, final String str, @NonNull final c.a aVar) {
        if (!i0(str)) {
            aVar.a(false, -11153, "\u672a\u5b9e\u540d\u8ba4\u8bc1");
            return;
        }
        nh2.c cVar = this.f311481a;
        if (cVar != null && !cVar.isDestroyed()) {
            try {
                if (this.f311489i) {
                    Activity activity2 = QBaseActivity.sTopActivity;
                    if (activity2 == null) {
                        activity2 = Foreground.getTopActivity();
                    }
                    s0(activity2, str, aVar);
                    return;
                }
                if (activity != null && activity.isFinishing()) {
                    ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vasgift.api.impl.service.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            g.this.j0(str, aVar);
                        }
                    }, 500L);
                    return;
                } else {
                    s0(activity, str, aVar);
                    return;
                }
            } catch (Exception e16) {
                aVar.a(false, -3, "\u5f39\u7a97\u5f02\u5e38");
                QLog.d("QQGiftWalletIdentifyModuleImpl", 1, "showDialog throw e:" + e16.getMessage());
                return;
            }
        }
        QLog.e("QQGiftWalletIdentifyModuleImpl", 1, "[doIdentify] giftSdk\u53ef\u80fd\u8fd8\u6ca1\u521d\u59cb\u5316, giftSDK:" + this.f311481a);
        aVar.a(false, -3, "\u51fa\u9519\u4e86\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
    }
}
