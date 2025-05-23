package com.tencent.open.agent.auth.presenter;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.open.agent.auth.presenter.BaseAuthorityPresenter;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.o;
import com.tencent.open.agent.util.p;
import com.tencent.open.agent.util.t;
import com.tencent.open.agent.util.u;
import com.tencent.open.model.AccountManage;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.protofile.sdkauthorize.SdkAuthorize$AuthorizeResponse;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.WtloginManager;
import org.json.JSONException;

/* loaded from: classes22.dex */
public abstract class BaseAuthorityPresenter {
    protected Bundle A;
    protected final ep3.c B;
    protected final Activity C;
    protected final Intent D;
    protected final com.tencent.open.agent.auth.model.c E;

    /* renamed from: b, reason: collision with root package name */
    protected long f340167b;

    /* renamed from: c, reason: collision with root package name */
    protected long f340168c;

    /* renamed from: d, reason: collision with root package name */
    protected long f340169d;

    /* renamed from: e, reason: collision with root package name */
    protected long f340170e;

    /* renamed from: f, reason: collision with root package name */
    protected long f340171f;

    /* renamed from: g, reason: collision with root package name */
    protected long f340172g;

    /* renamed from: i, reason: collision with root package name */
    protected int f340174i;

    /* renamed from: j, reason: collision with root package name */
    protected String f340175j;

    /* renamed from: k, reason: collision with root package name */
    protected boolean f340176k;

    /* renamed from: l, reason: collision with root package name */
    protected boolean f340177l;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f340178m;

    /* renamed from: n, reason: collision with root package name */
    protected boolean f340179n;

    /* renamed from: o, reason: collision with root package name */
    protected boolean f340180o;

    /* renamed from: p, reason: collision with root package name */
    protected boolean f340181p;

    /* renamed from: q, reason: collision with root package name */
    protected boolean f340182q;

    /* renamed from: r, reason: collision with root package name */
    protected boolean f340183r;

    /* renamed from: u, reason: collision with root package name */
    protected String f340186u;

    /* renamed from: v, reason: collision with root package name */
    protected String f340187v;

    /* renamed from: w, reason: collision with root package name */
    protected String f340188w;

    /* renamed from: x, reason: collision with root package name */
    protected String f340189x;

    /* renamed from: y, reason: collision with root package name */
    protected com.tencent.open.model.a f340190y;

    /* renamed from: z, reason: collision with root package name */
    protected List<String> f340191z;

    /* renamed from: a, reason: collision with root package name */
    protected Handler f340166a = new Handler(Looper.getMainLooper());

    /* renamed from: h, reason: collision with root package name */
    protected boolean f340173h = true;

    /* renamed from: s, reason: collision with root package name */
    protected int f340184s = -1;

    /* renamed from: t, reason: collision with root package name */
    protected int f340185t = 0;

    /* loaded from: classes22.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            BaseAuthorityPresenter.this.X(110405, "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class b implements u {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f340203a;

        b(String str) {
            this.f340203a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(boolean z16, String str) {
            if (z16) {
                BaseAuthorityPresenter.this.c0(str);
                return;
            }
            com.tencent.open.agent.util.d.B("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
            BaseAuthorityPresenter.this.T(str, 1);
            com.tencent.open.agent.util.g.V(str);
        }

        @Override // com.tencent.open.agent.util.u
        public void onResult(final boolean z16, String str) {
            Handler handler = BaseAuthorityPresenter.this.f340166a;
            final String str2 = this.f340203a;
            handler.post(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.a
                @Override // java.lang.Runnable
                public final void run() {
                    BaseAuthorityPresenter.b.this.b(z16, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class c extends com.tencent.mobileqq.loginregister.servlet.f {
        c() {
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.f
        public void a(String str, int i3, int i16, Bundle bundle) {
            String string = bundle.getString("error");
            int i17 = bundle.getInt("code");
            t.b("BaseAuthorityPresenter", "onFailed uin=", com.tencent.open.agent.util.g.C(str), ", ret=", Integer.valueOf(i16), ", error=", string + ", code=", Integer.valueOf(i17));
            BaseAuthorityPresenter baseAuthorityPresenter = BaseAuthorityPresenter.this;
            if (baseAuthorityPresenter.f340173h) {
                baseAuthorityPresenter.L(str, i16, string, i17);
                BaseAuthorityPresenter.this.K(str, i16, i17);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.f
        public void c(String str, byte[] bArr, int i3, Bundle bundle) {
            t.b("BaseAuthorityPresenter", "onGetTicketNoPasswd uin=" + com.tencent.open.agent.util.g.C(str));
            BaseAuthorityPresenter baseAuthorityPresenter = BaseAuthorityPresenter.this;
            if (!baseAuthorityPresenter.f340173h) {
                return;
            }
            BaseAuthorityPresenter.this.f340190y = com.tencent.open.agent.util.b.a(baseAuthorityPresenter.A(), str, bArr, i3, bundle);
            BaseAuthorityPresenter baseAuthorityPresenter2 = BaseAuthorityPresenter.this;
            baseAuthorityPresenter2.e0(baseAuthorityPresenter2.f340190y.f341678a);
            BaseAuthorityPresenter.this.N(str, bArr, bundle);
            BaseAuthorityPresenter.this.M(str, i3, bundle);
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.f
        public void d(String str, int i3, Bundle bundle) {
            t.b("BaseAuthorityPresenter", "onUserCancel uin=" + com.tencent.open.agent.util.g.C(str));
            BaseAuthorityPresenter baseAuthorityPresenter = BaseAuthorityPresenter.this;
            if (!baseAuthorityPresenter.f340173h) {
                return;
            }
            baseAuthorityPresenter.f340174i = 0;
            baseAuthorityPresenter.f340169d = SystemClock.elapsedRealtime();
            com.tencent.open.agent.util.d.j("KEY_DELEGATE_GET_TICKET_NO_PASSWD", str, false);
            com.tencent.open.agent.util.d.i("KEY_LOGIN_STAGE_1_TOTAL", str, BaseAuthorityPresenter.this.f340167b, com.tencent.open.agent.util.d.a(BaseAuthorityPresenter.this.f340186u), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class d implements u {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f340206a;

        d(String str) {
            this.f340206a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(boolean z16, String str) {
            if (z16) {
                BaseAuthorityPresenter.this.c0(str);
                return;
            }
            com.tencent.open.agent.util.d.B("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
            BaseAuthorityPresenter.this.T(str, 1);
            BaseAuthorityPresenter.this.Z(str);
        }

        @Override // com.tencent.open.agent.util.u
        public void onResult(final boolean z16, String str) {
            t.f("BaseAuthorityPresenter", "checkIfNeedLoginWithPasswd onResult. needLogin: " + z16 + ", errMsg: " + str);
            Handler handler = BaseAuthorityPresenter.this.f340166a;
            final String str2 = this.f340206a;
            handler.post(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.b
                @Override // java.lang.Runnable
                public final void run() {
                    BaseAuthorityPresenter.d.this.b(z16, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class e implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f340208d;

        e(Runnable runnable) {
            this.f340208d = runnable;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            BaseAuthorityPresenter.this.f340166a.postDelayed(this.f340208d, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            BaseAuthorityPresenter.this.X(110405, "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseAuthorityPresenter(ep3.c cVar, com.tencent.open.agent.auth.model.c cVar2) {
        this.B = cVar;
        this.E = cVar2;
        Activity activity = (Activity) cVar.fe(3);
        this.C = activity;
        this.D = activity.getIntent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(String str) {
        t.b("BaseAuthorityPresenter", "loginSSO send | cmd: g_t_n_p | uin :*" + com.tencent.open.agent.util.g.C(str));
        this.B.showProgressDialog(R.string.f171154cp2);
        if (TextUtils.isEmpty(str)) {
            r(str);
            this.f340176k = true;
            U("wtl_notlogged", "0");
            return;
        }
        com.tencent.open.agent.util.g.f(str, new d(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(String str, int i3, int i16) {
        int i17;
        this.f340182q = true;
        if (i3 != -1000 && i3 != 154) {
            c0(str);
            return;
        }
        if (i16 == 1002 && (i17 = this.f340174i) < 2) {
            this.f340174i = i17 + 1;
            this.f340169d = SystemClock.elapsedRealtime();
            F(str);
        } else {
            this.f340169d = SystemClock.elapsedRealtime();
            B(3003, R.string.f171155cp4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(String str, int i3, String str2, int i16) {
        com.tencent.open.agent.util.d.o("agent_login", this.f340168c, 0L, 0L, i16, str, "ret: " + i3 + " | error: " + str2);
        com.tencent.open.agent.util.d.r(1, "LOGIN_GETTICKT", str, z(), i16, str2);
        com.tencent.open.agent.util.d.z(str, z(), "1", "" + i16, false);
        com.tencent.open.agent.util.d.z(str, z(), "6", "" + i16, false);
        com.tencent.open.agent.util.d.j("KEY_DELEGATE_GET_TICKET_NO_PASSWD", str, false);
        com.tencent.open.agent.util.d.i("KEY_LOGIN_STAGE_1_TOTAL", str, this.f340167b, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(String str, byte[] bArr, Bundle bundle) {
        com.tencent.open.agent.util.d.f("KEY_DELEGATE_GET_TICKET_NO_PASSWD", this.f340190y);
        com.tencent.open.agent.util.d.i("KEY_LOGIN_STAGE_1_TOTAL", this.f340189x, this.f340167b, null, true);
        if (!bundle.getBoolean("fake_callback")) {
            t.b("BaseAuthorityPresenter", "onRefreshTicketSuccess fake callback");
            long currentTimeMillis = System.currentTimeMillis() - this.f340172g;
            int i3 = bundle.getInt("code");
            com.tencent.open.agent.util.d.q(currentTimeMillis, i3, z(), str);
            com.tencent.open.agent.util.d.o("agent_login", this.f340172g, str.length(), bArr.length, 0, str, null);
            com.tencent.open.agent.util.d.r(0, "LOGIN_GETTICKT", str, z(), i3, null);
            com.tencent.open.agent.util.d.z(str, z(), "1", "0", false);
        }
    }

    private void Q(int i3, String str, String str2) {
        W(i3, str);
        byte[] b16 = com.tencent.open.agent.auth.model.b.b(z(), this.f340190y.f341678a);
        if (b16 != null && b16.length != 0) {
            try {
                S(fp3.b.a(new SdkAuthorize$AuthorizeResponse().mergeFrom(b16)));
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                t.d("BaseAuthorityPresenter", "InvalidProtocolBufferMicroException", e16);
                w(i3, str, str2);
                return;
            }
        }
        w(i3, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(String str, int i3) {
        t.b("BaseAuthorityPresenter", "refreshTicket uin=" + com.tencent.open.agent.util.g.C(str));
        this.f340172g = System.currentTimeMillis();
        this.f340173h = true;
        AccountManage.g().e(str, new c(), z(), i3);
    }

    private void V(int i3, String str, String str2, com.tencent.open.model.a aVar, String str3) {
        String str4;
        String str5;
        com.tencent.open.agent.util.d.n(i3, aVar, this.f340186u);
        if (i3 == 0) {
            com.tencent.open.agent.util.d.s(str3, "0X800B65E");
            str4 = "0";
            com.tencent.open.agent.util.d.z(str3, z(), "6", "0", false);
        } else {
            com.tencent.open.agent.util.d.s(str3, "0X800B65F");
            com.tencent.open.agent.util.d.l(this.C, i3, str, str3, z(), str2);
            str4 = "1";
        }
        com.tencent.open.agent.util.d.t(i3, z(), str3);
        if (com.tencent.open.agent.util.c.m(this.D)) {
            com.tencent.open.agent.util.d.z(str3, z(), "9", str4, true);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str5 = peekAppRuntime.getAccount();
        } else {
            str5 = "";
        }
        if (!TextUtils.isEmpty(str5) && !str5.equals(str3)) {
            com.tencent.open.agent.util.d.z(str3, z(), "10", str4, true);
        }
    }

    private void r(String str) {
        String str2;
        t.b("BaseAuthorityPresenter", "changeAccountActivity uin=", com.tencent.open.agent.util.g.C(str));
        Intent intent = new Intent();
        List<String> list = this.f340191z;
        if (list != null && list.size() > 1) {
            intent.putExtra(AppConstants.Key.KEY_THIRD_APPID, z());
            intent.putExtra("param_uin", str);
            str2 = RouterConstants.UI_ROUTER_SWITCH_ACCOUNT;
        } else {
            intent.putExtra("appid", z());
            intent.putExtra(QCircleSchemeAttr.Detail.IS_FIRST_LOGIN, true);
            intent.putExtra("is_open_sdk_add_account", true);
            intent.putExtra("loginFragmentType", 5);
            intent.putExtra("key_login_page_entrance", 4);
            intent.putExtra("key_login_page_title", BaseApplication.getContext().getString(R.string.f9p));
            str2 = RouterConstants.UI_ROUTER_LOGIN;
        }
        intent.putExtra("key_req_src", 1);
        intent.putExtra("param_qr_code_url", this.D.getStringExtra("param_qr_code_url"));
        intent.putExtra("packagename", this.D.getStringExtra("packagename"));
        intent.putExtra("oauth_app_name", com.tencent.open.agent.util.c.i(this.A, "oauth_app_name"));
        RouteUtils.startActivityForResult(this.C, intent, str2, 1);
    }

    protected final WtloginManager A() {
        return (WtloginManager) MobileQQ.sMobileQQ.peekAppRuntime().getManager(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(int i3, int i16) {
        C(i3, MobileQQ.sMobileQQ.getResources().getString(i16));
    }

    protected void C(final int i3, final String str) {
        this.f340166a.post(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.BaseAuthorityPresenter.8
            @Override // java.lang.Runnable
            public void run() {
                BaseAuthorityPresenter.this.B.dismissProgressDialog();
                BaseAuthorityPresenter.this.B.H7(true);
                BaseAuthorityPresenter baseAuthorityPresenter = BaseAuthorityPresenter.this;
                baseAuthorityPresenter.f340179n = true;
                com.tencent.open.agent.util.d.k(baseAuthorityPresenter.C, i3, str, baseAuthorityPresenter.f340189x, baseAuthorityPresenter.z());
                com.tencent.open.agent.util.d.s(BaseAuthorityPresenter.this.f340189x, "0X800B65F");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(Bundle bundle) {
        this.A = bundle;
        this.f340186u = com.tencent.open.agent.util.c.i(bundle, CommonConstant.ReqAccessTokenParam.CLIENT_ID);
        this.f340187v = com.tencent.open.agent.util.c.i(bundle, "key_proxy_appid");
        this.f340188w = com.tencent.open.agent.util.c.o(com.tencent.open.agent.util.c.i(bundle, "key_proxy_token"));
        this.f340175j = com.tencent.open.agent.util.c.i(bundle, "sdkv");
        this.f340181p = com.tencent.open.agent.util.c.a(bundle, "key_login_by_qr_scan", false);
        this.f340183r = com.tencent.open.agent.util.c.b(this.D, "internal_authority", false);
        this.f340180o = com.tencent.open.agent.util.c.m(this.D);
        this.f340167b = System.currentTimeMillis();
        ArrayList<String> j3 = up3.b.j();
        this.f340191z = j3;
        e0(com.tencent.open.agent.util.g.w(j3, this.D));
        t.b("BaseAuthorityPresenter", "init internal=", Boolean.valueOf(this.f340183r), ", fromSdk=", Boolean.valueOf(this.f340180o), ", appId=", this.f340186u, ", fromQr=", Boolean.valueOf(this.f340181p), ", proxyAppId=", this.f340187v, ", proxyToken=", this.f340188w);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean E() {
        if (!p.l(MobileQQ.sMobileQQ)) {
            t.b("BaseAuthorityPresenter", "jumpToPWDUnlock false");
            return false;
        }
        t.b("BaseAuthorityPresenter", "jumpToPWDUnlock true");
        com.tencent.open.agent.util.g.I(this.C);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(final String str) {
        t.b("BaseAuthorityPresenter", "login uin=", com.tencent.open.agent.util.g.C(str));
        this.f340168c = SystemClock.elapsedRealtime();
        this.B.H7(true);
        if (!NetworkUtil.isNetworkAvailable(this.C)) {
            this.B.ld(0L);
        } else if (!MobileQQ.sMobileQQ.peekAppRuntime().isLogin()) {
            G(str);
        } else {
            com.tencent.open.agent.util.g.f(str, new u() { // from class: com.tencent.open.agent.auth.presenter.BaseAuthorityPresenter.3
                @Override // com.tencent.open.agent.util.u
                public void onResult(final boolean z16, String str2) {
                    BaseAuthorityPresenter.this.f340166a.post(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.BaseAuthorityPresenter.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Object obj = BaseAuthorityPresenter.this.B;
                            if ((obj instanceof Fragment) && ((Fragment) obj).getActivity() == null) {
                                t.e("BaseAuthorityPresenter", "context is null");
                                return;
                            }
                            if (z16) {
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                BaseAuthorityPresenter.this.G(str);
                                return;
                            }
                            t.b("BaseAuthorityPresenter", "checkIfNeedLoginWithPasswd onResult send | cmd: g_t_n_p | uin : *" + com.tencent.open.agent.util.g.C(str));
                            com.tencent.open.agent.util.d.B("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
                            AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                            BaseAuthorityPresenter.this.T(str, 1);
                            BaseAuthorityPresenter.this.B.showProgressDialog(R.string.cow);
                            AnonymousClass3 anonymousClass33 = AnonymousClass3.this;
                            BaseAuthorityPresenter.this.Z(str);
                        }
                    });
                }
            });
        }
    }

    protected void H(String str, int i3) {
        t.b("BaseAuthorityPresenter", "onAuthFailed ret=", Integer.valueOf(i3), ", uin=", com.tencent.open.agent.util.g.C(this.f340190y.f341678a));
        String x16 = x(i3, str);
        switch (i3) {
            case 100044:
                w(i3, str, x16);
                C(i3, x16);
                return;
            case 110405:
                AuthUIUtil.f(this.C, x16, new f());
                C(i3, x16);
                return;
            case 110509:
                O();
                return;
            case 110537:
                AuthUIUtil.j(this.C, R.string.f213575qk);
                a0(this.f340189x);
                C(i3, x16);
                return;
            case 1105030:
                Q(i3, str, x16);
                return;
            default:
                C(i3, x16);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I(fp3.b bVar) {
        String str;
        boolean z16;
        String str2;
        String str3;
        this.E.a(bVar.f400231e.get(), z(), this.f340190y.f341678a);
        this.E.c(bVar.f400231e.get(), bVar.f400233g.get());
        if (this.f340176k) {
            if (this.f340177l) {
                str3 = "wtl_lognback";
            } else {
                str3 = "wtl_lognauthorizenback";
            }
            U(str3, this.f340190y.f341678a);
        } else {
            if (this.f340177l) {
                str = "wtl_loggednunauthorizedback";
            } else {
                str = "wtl_loggednauthorizedback";
            }
            U(str, this.f340190y.f341678a);
        }
        com.tencent.open.agent.util.d.c(this.C, z(), this.f340189x, this.f340171f, this.f340176k, this.f340177l);
        if (this.f340181p) {
            com.tencent.open.agent.util.d.n(bVar.f400227a.get(), this.f340190y, this.f340186u);
            p.d(this.A);
            if (bVar.f400227a.get() == 0) {
                str2 = "0X800B65E";
            } else {
                str2 = "0X800B65F";
            }
            com.tencent.open.agent.util.d.s(this.f340189x, str2);
            return;
        }
        try {
            long j3 = this.f340169d - this.f340168c;
            long j16 = this.f340170e;
            long j17 = this.f340171f;
            if (!TextUtils.isEmpty(this.f340187v)) {
                z16 = true;
            } else {
                z16 = false;
            }
            X(bVar.f400227a.get(), com.tencent.open.agent.util.g.L(bVar, j3, j16, j17, z16).toString(), null, null);
        } catch (JSONException e16) {
            t.a("BaseAuthorityPresenter", "JSONException", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(boolean z16) {
        String str;
        String str2;
        t.b("BaseAuthorityPresenter", "onGetApiListSuccess authorized=", Boolean.valueOf(z16));
        this.f340177l = z16;
        if (z16) {
            str = "wtl_loggednunauthorized";
        } else {
            str = "wtl_loggednauthorized";
        }
        U(str, this.f340190y.f341678a);
        long currentTimeMillis = System.currentTimeMillis() - this.f340167b;
        if (z16) {
            str2 = WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_AUTH;
        } else {
            str2 = "uauth";
        }
        t("connect_sso_pageview", currentTimeMillis, "logged", str2);
    }

    protected abstract void M(String str, int i3, Bundle bundle);

    protected void O() {
        if (this.f340184s < 1) {
            this.f340184s = 1;
            com.tencent.open.agent.util.d.B("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
            T(this.f340189x, 3);
        } else {
            t.b("BaseAuthorityPresenter", "showLoginActivity AUTHORIZE_DONE 110509");
            AuthUIUtil.j(this.C, R.string.f213565qj);
            c0(this.f340189x);
            com.tencent.open.agent.util.d.s(this.f340189x, "0X800B65F");
        }
    }

    protected void P() {
        if (this.f340184s < 0) {
            this.f340184s = 0;
            com.tencent.open.agent.util.d.B("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
            T(this.f340189x, 3);
        } else {
            t.b("BaseAuthorityPresenter", "showLoginActivity GET_API_LIST_DONE 110509");
            AuthUIUtil.j(this.C, R.string.f213565qj);
            c0(this.f340189x);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void R(String str, int i3) {
        com.tencent.open.agent.util.d.z(this.f340190y.f341678a, z(), "6", "" + i3, false);
        String x16 = x(i3, str);
        switch (i3) {
            case 100044:
                com.tencent.open.agent.util.d.w(this.f340190y.f341678a, z(), this.A.getString("packagename"), this.A.getString("packagesign"));
                w(i3, str, x16);
                C(i3, x16);
                return;
            case 110405:
                AuthUIUtil.f(this.C, x16, new a());
                C(i3, x16);
                return;
            case 110509:
                P();
                return;
            case 110513:
                X(110513, "", "", "");
                return;
            case 110537:
                t.b("BaseAuthorityPresenter", "PRE_AUTH_110537 110537");
                AuthUIUtil.j(this.C, R.string.f213575qk);
                com.tencent.open.b.c(this.f340189x);
                a0(this.f340189x);
                return;
            default:
                w(i3, str, x16);
                C(i3, x16);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void S(fp3.b bVar) {
        int i3 = bVar.f400227a.get();
        t.b("BaseAuthorityPresenter", "parseAuthorizeResponse ret=", Integer.valueOf(i3));
        if (i3 == 0) {
            I(bVar);
        } else {
            H(bVar.f400228b.get(), i3);
        }
    }

    protected void U(String str, String str2) {
        com.tencent.open.agent.util.d.x(MobileQQ.sMobileQQ.peekAppRuntime(), str, z() + "|" + str2 + "|" + this.f340175j);
    }

    protected void W(int i3, String str) {
        com.tencent.open.agent.util.d.k(this.C, i3, str, this.f340189x, z());
        com.tencent.open.agent.util.d.s(this.f340189x, "0X800B65F");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void X(int i3, String str, String str2, String str3) {
        int i16;
        t.b("BaseAuthorityPresenter", "setSdkResult, error=", Integer.valueOf(i3), ", mCurrentAccount=", com.tencent.open.agent.util.g.C(this.f340189x));
        if (i3 != 110405 && i3 != 110513) {
            i16 = i3;
        } else {
            i16 = 0;
        }
        Intent intent = new Intent();
        intent.putExtra("key_error_code", i16);
        intent.putExtra("key_error_msg", str2);
        intent.putExtra("key_error_detail", str3);
        intent.putExtra("key_response", str);
        this.C.setResult(-1, intent);
        this.C.finish();
        V(i16, str2, str3, this.f340190y, this.f340189x);
    }

    protected void Y(final Bitmap bitmap) {
        this.f340166a.post(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.BaseAuthorityPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                BaseAuthorityPresenter.this.f340178m = true;
                t.f("BaseAuthorityPresenter", "get app icon done");
                BaseAuthorityPresenter.this.B.p0("", bitmap);
            }
        });
    }

    protected abstract void Z(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public void a0(String str) {
        b0(str, null);
    }

    public void b() {
        t.b("BaseAuthorityPresenter", "onDeleteAccount");
        Intent intent = new Intent();
        intent.putExtra("key_req_src", 1);
        intent.putExtra(QCircleSchemeAttr.Detail.IS_FIRST_LOGIN, true);
        intent.putExtra("param_qr_code_url", this.D.getStringExtra("param_qr_code_url"));
        intent.putExtra("packagename", this.D.getStringExtra("packagename"));
        intent.putExtra("oauth_app_name", com.tencent.open.agent.util.c.i(this.A, "oauth_app_name"));
        intent.putExtra("appid", z());
        intent.putExtra("is_open_sdk_add_account", true);
        intent.putExtra("loginFragmentType", 5);
        intent.putExtra("key_login_page_entrance", 4);
        intent.putExtra("key_login_page_title", BaseApplication.getContext().getString(R.string.f9p));
        e0(null);
        RouteUtils.startActivityForResult(this.C, intent, RouterConstants.UI_ROUTER_LOGIN, 1);
    }

    protected void b0(String str, Bundle bundle) {
        t.b("BaseAuthorityPresenter", "showLoginActivity, uin=" + com.tencent.open.agent.util.g.C(str));
        Intent intent = new Intent();
        intent.putExtra("appid", z());
        intent.putExtra("param_qr_code_url", this.D.getStringExtra("param_qr_code_url"));
        intent.putExtra("packagename", this.D.getStringExtra("packagename"));
        intent.putExtra("oauth_app_name", com.tencent.open.agent.util.c.i(this.A, "oauth_app_name"));
        intent.putExtra("param_uin", str);
        intent.putExtra("is_open_sdk_add_account", true);
        intent.putExtra("loginFragmentType", 5);
        intent.putExtra("key_login_page_entrance", 4);
        intent.putExtra("key_login_page_title", BaseApplication.getContext().getString(R.string.f9p));
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        RouteUtils.startActivityForResult(this.C, intent, RouterConstants.UI_ROUTER_LOGIN, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c0(String str) {
        Bundle bundle;
        if (str != null) {
            bundle = new Bundle();
            bundle.putString("uin", str);
        } else {
            bundle = null;
        }
        b0(str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d0(Intent intent) {
        String str;
        com.tencent.open.model.a aVar = new com.tencent.open.model.a();
        aVar.f341678a = intent.getStringExtra("last_account");
        aVar.f341679b = intent.getByteArrayExtra("st_temp");
        aVar.f341680c = intent.getByteArrayExtra("st_temp_key");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("updateAccount, uin = *");
        sb5.append(com.tencent.open.agent.util.g.C(aVar.f341678a));
        String str2 = "";
        if (aVar.f341679b != null) {
            str = "";
        } else {
            str = ", st is null";
        }
        sb5.append(str);
        if (aVar.f341680c == null) {
            str2 = ", stkey is null";
        }
        sb5.append(str2);
        t.f("BaseAuthorityPresenter", sb5.toString());
        if (aVar.f341678a != null) {
            this.f340190y = aVar;
        }
    }

    public void doOnPause() {
        t.b("BaseAuthorityPresenter", "doOnPause");
        this.f340167b = 0L;
    }

    public void doOnResume() {
        t.b("BaseAuthorityPresenter", "doOnResume");
        if (this.f340167b == 0) {
            this.f340167b = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e0(String str) {
        t.f("BaseAuthorityPresenter", "updateCurrentAccount: " + MsfSdkUtils.getShortUin(this.f340189x) + " -> " + MsfSdkUtils.getShortUin(str));
        this.f340189x = str;
    }

    public void f(int i3, Intent intent) {
        String stringExtra;
        if (i3 == -1) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (intent == null) {
                stringExtra = peekAppRuntime.getAccount();
            } else {
                stringExtra = intent.getStringExtra("uin");
            }
            e0(stringExtra);
            s();
            return;
        }
        k();
    }

    public void j() {
        boolean z16;
        if (this.f340185t == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f340179n = z16;
    }

    public void k() {
        String str;
        String str2;
        this.C.setResult(0);
        this.C.finish();
        if (this.f340176k) {
            str = "notlogged";
        } else {
            str = "logged";
        }
        String str3 = str;
        if (this.f340177l) {
            str2 = WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_AUTH;
        } else {
            str2 = "uauth";
        }
        t("connect_sso_backto3rd", 0L, str3, str2);
    }

    public void l() {
        t.b("BaseAuthorityPresenter", "onAddAccount");
        a0(this.f340189x);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s() {
        boolean k3 = up3.b.k();
        t.b("BaseAuthorityPresenter", "checkAccountOnFirst haveEverLogin: " + k3);
        if (k3) {
            F(this.f340189x);
        } else {
            r(this.f340189x);
            t("connect_sso_pageview", System.currentTimeMillis() - this.f340167b, "notlogged", "uauth");
        }
    }

    protected void t(String str, long j3, String str2, String str3) {
        com.tencent.open.agent.util.d.b(this.C, z(), this.f340189x, str, j3, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean u(String str, boolean z16) {
        t.b("BaseAuthorityPresenter", "changeAccountLogin newUin=", com.tencent.open.agent.util.g.C(str), ", canAutoLogin=", Boolean.valueOf(z16));
        if (!NetworkUtil.isNetworkAvailable(this.C)) {
            this.B.ld(0L);
            return false;
        }
        com.tencent.open.agent.util.g.f(str, new b(str));
        this.f340180o = z16;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(final hp3.d dVar) {
        if (dVar == null) {
            return;
        }
        t.f("BaseAuthorityPresenter", "fetchAppIcon imgUrl is " + dVar);
        ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.BaseAuthorityPresenter.2
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.open.agent.util.d.B("KEY_GET_APP_ICON");
                Bitmap q16 = com.tencent.open.agent.util.g.q(dVar.f405817a.get());
                com.tencent.open.agent.util.d.f("KEY_GET_APP_ICON", BaseAuthorityPresenter.this.f340190y);
                if (q16 == null) {
                    return;
                }
                OpenSdkVirtualUtil.p(MobileQQ.sMobileQQ, BaseAuthorityPresenter.this.z(), q16);
                BaseAuthorityPresenter.this.Y(q16);
            }
        });
    }

    protected void w(final int i3, final String str, String str2) {
        AuthUIUtil.f(this.C, str2, new e(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.BaseAuthorityPresenter.6
            @Override // java.lang.Runnable
            public void run() {
                BaseAuthorityPresenter.this.X(i3, com.tencent.open.agent.util.g.X("ret", Integer.valueOf(i3), "msg", str), null, null);
            }
        }));
    }

    protected String x(int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            return String.format(this.C.getString(R.string.cot), Integer.valueOf(i3));
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int y(List<hp3.d> list) {
        int size = list.size();
        int i3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < size; i17++) {
            int a16 = o.a(list.get(i17).f405818b.get());
            if (a16 < 100) {
                if (a16 > i3) {
                    i16 = i17;
                    i3 = a16;
                }
            } else {
                return i17;
            }
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String z() {
        if (TextUtils.isEmpty(this.f340187v)) {
            return this.f340186u;
        }
        return this.f340187v;
    }
}
