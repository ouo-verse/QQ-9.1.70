package com.tencent.open.agent.auth.api.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.auth.model.h;
import com.tencent.open.agent.auth.presenter.k;
import com.tencent.open.agent.auth.util.AppAuthLimitHelper;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.g;
import com.tencent.open.agent.util.t;
import com.tencent.open.model.AccountManage;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import hp3.e;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONException;

/* loaded from: classes22.dex */
public class OpenAuthPageOperationHelper {

    /* renamed from: a, reason: collision with root package name */
    private Activity f340086a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.open.agent.auth.model.c f340087b;

    /* renamed from: c, reason: collision with root package name */
    private QQProgressDialog f340088c;

    /* renamed from: d, reason: collision with root package name */
    private int f340089d;

    /* renamed from: e, reason: collision with root package name */
    private long f340090e;

    /* renamed from: f, reason: collision with root package name */
    private long f340091f;

    /* renamed from: g, reason: collision with root package name */
    private String f340092g;

    /* renamed from: h, reason: collision with root package name */
    private long f340093h;

    /* renamed from: i, reason: collision with root package name */
    private long f340094i;

    /* renamed from: j, reason: collision with root package name */
    private long f340095j;

    /* renamed from: k, reason: collision with root package name */
    private long f340096k;

    /* renamed from: l, reason: collision with root package name */
    private String f340097l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f340098m;

    /* renamed from: n, reason: collision with root package name */
    private String f340099n;

    /* renamed from: o, reason: collision with root package name */
    private fp3.a f340100o = new fp3.a() { // from class: com.tencent.open.agent.auth.api.impl.OpenAuthPageOperationHelper.2
        @Override // fp3.a
        public void a(final boolean z16, final int i3, final fp3.b bVar) {
            t.b("OpenAuthPageOperationHelper", "-->onDoAuthorize isSuccess=", Boolean.valueOf(z16), ", code=", Integer.valueOf(i3));
            if (OpenAuthPageOperationHelper.this.f340086a == null) {
                t.e("OpenAuthPageOperationHelper", "onDoAuthorize activity is null");
            } else {
                OpenAuthPageOperationHelper.this.f340086a.runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.auth.api.impl.OpenAuthPageOperationHelper.2.1

                    /* renamed from: com.tencent.open.agent.auth.api.impl.OpenAuthPageOperationHelper$2$1$a */
                    /* loaded from: classes22.dex */
                    class a implements DialogInterface.OnClickListener {
                        a() {
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            dialogInterface.dismiss();
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        String str;
                        boolean z17;
                        if (z16 && bVar != null) {
                            OpenAuthPageOperationHelper.this.P(true);
                            OpenAuthPageOperationHelper.this.T(bVar.f400231e.get(), OpenAuthPageOperationHelper.this.I());
                            OpenAuthPageOperationHelper.this.S(bVar.f400231e.get(), bVar.f400233g.get());
                            try {
                                long elapsedRealtime = SystemClock.elapsedRealtime() - OpenAuthPageOperationHelper.this.f340093h;
                                fp3.b bVar2 = bVar;
                                long j3 = OpenAuthPageOperationHelper.this.f340095j;
                                long j16 = OpenAuthPageOperationHelper.this.f340094i;
                                if (OpenAuthPageOperationHelper.this.f340091f != 0) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                OpenAuthPageOperationHelper.this.Q(bVar.f400227a.get(), g.L(bVar2, j3, j16, elapsedRealtime, z17).toString(), null, null);
                            } catch (JSONException e16) {
                                t.d("OpenAuthPageOperationHelper", "catch JSONException", e16);
                            }
                        } else {
                            int i16 = i3;
                            if (i16 == 110509) {
                                t.b("OpenAuthPageOperationHelper", "onDoAuthorize mAuthRetryCountBy110509=" + OpenAuthPageOperationHelper.this.f340089d);
                                fp3.b bVar3 = bVar;
                                if (bVar3 == null) {
                                    str = "";
                                } else {
                                    str = bVar3.f400228b.get();
                                }
                                if (OpenAuthPageOperationHelper.this.f340089d >= 2) {
                                    OpenAuthPageOperationHelper.this.G(str);
                                } else {
                                    OpenAuthPageOperationHelper.this.f340089d++;
                                    OpenAuthPageOperationHelper.this.O(3, str);
                                }
                                OpenAuthPageOperationHelper.this.P(false);
                            } else if (i16 == 110537) {
                                t.b("OpenAuthPageOperationHelper", "onDoAuthorize 110537");
                                AuthUIUtil.l(OpenAuthPageOperationHelper.this.f340086a, HardCodeUtil.qqStr(R.string.f213575qk), false);
                                OpenAuthPageOperationHelper.this.F();
                            } else if (i16 == 100044) {
                                com.tencent.open.agent.util.d.w(hp3.b.e().b(OpenAuthPageOperationHelper.this.I()).f341678a, OpenAuthPageOperationHelper.this.I(), OpenAuthPageOperationHelper.this.f340086a.getIntent().getStringExtra("packagename"), OpenAuthPageOperationHelper.this.f340086a.getIntent().getStringExtra("packagesign"));
                                AuthUIUtil.f(OpenAuthPageOperationHelper.this.f340086a, g.p(bVar, OpenAuthPageOperationHelper.this.f340086a.getResources(), i3), new a());
                            } else {
                                AppAuthLimitHelper.b(i16, OpenAuthPageOperationHelper.this.H(), bVar);
                                AuthUIUtil.l(OpenAuthPageOperationHelper.this.f340086a, g.p(bVar, OpenAuthPageOperationHelper.this.f340086a.getResources(), i3), false);
                                OpenAuthPageOperationHelper.this.P(false);
                            }
                        }
                        OpenAuthPageOperationHelper.this.C();
                    }
                });
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class b implements AccountManage.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f340108a;

        b(String str) {
            this.f340108a = str;
        }

        @Override // com.tencent.open.model.AccountManage.h
        public void a(String str, Bundle bundle) {
            t.e("OpenAuthPageOperationHelper", "refreshTicket onFail");
            if (!OpenAuthPageOperationHelper.this.J()) {
                OpenAuthPageOperationHelper.this.G(this.f340108a);
            } else {
                t.b("OpenAuthPageOperationHelper", "refreshTicket onFail Activity Finishing");
            }
        }

        @Override // com.tencent.open.model.AccountManage.h
        public void b(com.tencent.open.model.a aVar) {
            t.b("OpenAuthPageOperationHelper", "refreshTicket success info.uin=" + g.C(aVar.f341678a));
            if (OpenAuthPageOperationHelper.this.J()) {
                t.b("OpenAuthPageOperationHelper", "refreshTicket success Activity Finishing");
            } else {
                hp3.b.e().q(OpenAuthPageOperationHelper.this.I(), aVar);
                OpenAuthPageOperationHelper.this.E();
            }
        }
    }

    public OpenAuthPageOperationHelper(@NonNull Activity activity) {
        this.f340086a = activity;
        this.f340087b = new h(activity);
        N(activity.getIntent());
    }

    private boolean B() {
        if (!NetworkUtil.isNetworkAvailable(MobileQQ.sMobileQQ)) {
            AuthUIUtil.f(this.f340086a, HardCodeUtil.qqStr(R.string.f171155cp4), new a());
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        this.f340086a.runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.auth.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                OpenAuthPageOperationHelper.this.K();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        com.tencent.open.model.a b16 = hp3.b.e().b(I());
        com.tencent.open.agent.util.d.g("KEY_LOGIN_STAGE_2_NEW_TOTAL", b16, com.tencent.open.agent.util.d.a(String.valueOf(this.f340090e)), true);
        com.tencent.open.agent.util.d.f("KEY_LOGIN_STAGE_2_2_NEW_TOTAL", b16);
        com.tencent.open.agent.util.d.B("KEY_LOGIN_STAGE_3_TOTAL");
        R();
        ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.open.agent.auth.api.impl.OpenAuthPageOperationHelper.1
            @Override // java.lang.Runnable
            public void run() {
                String valueOf;
                String str;
                List<e> g16 = hp3.b.e().g(OpenAuthPageOperationHelper.this.I());
                int i3 = 1;
                if (g16 == null) {
                    t.b("OpenAuthPageOperationHelper", "getAuthApiListResponse == null");
                    return;
                }
                ArrayList arrayList = new ArrayList(g16);
                if (OpenAuthPageOperationHelper.this.f340098m) {
                    i3 = 2;
                }
                int i16 = i3;
                com.tencent.open.agent.util.d.B("KEY_AUTHORIZE_REQUEST");
                if (0 == OpenAuthPageOperationHelper.this.f340091f) {
                    valueOf = "";
                } else {
                    valueOf = String.valueOf(OpenAuthPageOperationHelper.this.f340091f);
                }
                new k().f(OpenAuthPageOperationHelper.this.f340098m, OpenAuthPageOperationHelper.this.H(), valueOf, OpenAuthPageOperationHelper.this.f340092g, arrayList, OpenAuthPageOperationHelper.this.f340096k, OpenAuthPageOperationHelper.this.f340100o, OpenAuthPageOperationHelper.this.f340097l);
                if (OpenAuthPageOperationHelper.this.f340096k == 0) {
                    str = "0X800A117";
                } else {
                    str = "0X800A116";
                }
                g.P(null, str, 0, i16, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        AuthUIUtil.l(this.f340086a, HardCodeUtil.qqStr(R.string.f213565qj), false);
        if (J()) {
            t.b("OpenAuthPageOperationHelper", "finishAndToLogin but Activity isFinishing");
            return;
        }
        t.b("OpenAuthPageOperationHelper", "finishAndToLogin");
        Intent intent = new Intent();
        intent.putExtra("key_need_login", 1);
        this.f340086a.setResult(103, intent);
        this.f340086a.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(String str) {
        if (J()) {
            t.b("OpenAuthPageOperationHelper", "finishAndToLogin but Activity isFinishing");
            return;
        }
        t.b("OpenAuthPageOperationHelper", "finishAndToLogin from 110509");
        if (TextUtils.isEmpty(str)) {
            str = HardCodeUtil.qqStr(R.string.f213565qj);
        }
        AuthUIUtil.g(this.f340086a, HardCodeUtil.qqStr(R.string.f197714kr), str, new DialogInterface.OnClickListener() { // from class: com.tencent.open.agent.auth.api.impl.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                OpenAuthPageOperationHelper.this.L(dialogInterface, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String H() {
        return String.valueOf(this.f340090e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String I() {
        long j3 = this.f340091f;
        if (j3 == 0) {
            j3 = this.f340090e;
        }
        return String.valueOf(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J() {
        Activity activity = this.f340086a;
        if (activity != null && !activity.isFinishing()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K() {
        AuthUIUtil.c(this.f340086a, this.f340088c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(DialogInterface dialogInterface, int i3) {
        Intent intent = new Intent();
        intent.putExtra("key_need_login", 1);
        intent.putExtra("key_need_show_uin", true);
        this.f340086a.setResult(103, intent);
        this.f340086a.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M() {
        this.f340088c = AuthUIUtil.k(this.f340086a, null, R.layout.b17);
    }

    private void N(Intent intent) {
        this.f340097l = intent.getStringExtra("pkg_name");
        this.f340098m = intent.getBooleanExtra("is_from_qr_login", false);
        this.f340096k = intent.getLongExtra("vid", 0L);
        this.f340090e = intent.getLongExtra("appId", 0L);
        this.f340091f = intent.getLongExtra("key_proxy_appid", 0L);
        this.f340092g = com.tencent.open.agent.util.c.o(intent.getStringExtra("key_proxy_token"));
        this.f340095j = intent.getLongExtra("login_cost", 0L);
        this.f340094i = intent.getLongExtra("authListCostTime", 0L);
        this.f340093h = intent.getLongExtra("authStartTime", SystemClock.elapsedRealtime());
        this.f340099n = intent.getStringExtra("appName");
        t.b("OpenAuthPageOperationHelper", "parseIntent mAppId=", Long.valueOf(this.f340090e), ", mProxyAppId=", Long.valueOf(this.f340091f), ", mIsFromQrLogin=", Boolean.valueOf(this.f340098m), "mVid", Long.valueOf(this.f340096k));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(int i3, String str) {
        AccountManage.g().j(hp3.b.e().b(I()).f341678a, I(), i3, new b(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(boolean z16) {
        String str;
        String str2;
        com.tencent.open.model.a b16 = hp3.b.e().b(I());
        com.tencent.open.agent.util.d.h("KEY_AUTHORIZE_REQUEST", b16, z16);
        if (b16 != null && (str = b16.f341678a) != null) {
            if (z16) {
                str2 = "0X800B65E";
            } else {
                str2 = "0X800B65F";
            }
            com.tencent.open.agent.util.d.s(str, str2);
        }
        if (z16) {
            g.S(this.f340096k, I(), com.tencent.open.agent.util.c.k(this.f340086a, "sdkv"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(int i3, String str, String str2, String str3) {
        String str4;
        com.tencent.open.model.a b16 = hp3.b.e().b(I());
        com.tencent.open.agent.util.d.n(i3, b16, String.valueOf(this.f340090e));
        String I = I();
        if (b16 == null) {
            str4 = "";
        } else {
            str4 = b16.f341678a;
        }
        com.tencent.open.agent.util.d.t(i3, I, str4);
        Intent intent = new Intent();
        intent.putExtra("key_cancel_auth", 0);
        intent.putExtra("key_error_code", i3);
        intent.putExtra("key_error_msg", str2);
        intent.putExtra("key_error_detail", str3);
        intent.putExtra("key_response", str);
        t.b("OpenAuthPageOperationHelper", "OpenVirtual.setSdkResult, error: ", Integer.valueOf(i3), ", msg:", str2, ", detail:", str3);
        this.f340086a.setResult(103, intent);
        this.f340086a.finish();
        C();
    }

    private void R() {
        t.b("OpenAuthPageOperationHelper", UIJsPlugin.EVENT_SHOW_LOADING);
        this.f340086a.runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.auth.api.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                OpenAuthPageOperationHelper.this.M();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(String str, String str2) {
        this.f340087b.c(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(String str, String str2) {
        com.tencent.open.model.a b16 = hp3.b.e().b(str2);
        if (b16 != null) {
            this.f340087b.a(str, str2, b16.f341678a);
        }
    }

    public void D() {
        t.b("OpenAuthPageOperationHelper", "doAuth");
        if (B()) {
            this.f340089d = 0;
            E();
        }
    }
}
