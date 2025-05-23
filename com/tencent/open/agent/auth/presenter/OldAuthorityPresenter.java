package com.tencent.open.agent.auth.presenter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginStatus;
import com.tencent.open.agent.util.o;
import com.tencent.open.agent.util.p;
import com.tencent.open.agent.util.t;
import com.tencent.open.base.http.AvatarUpdateService;
import com.tencent.open.base.http.d;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.protofile.getappinfo.GetAppInfoProto$GetAppinfoResponse;
import com.tencent.protofile.sdkauthorize.SdkAuthorize$AuthorizeResponse;
import com.tencent.protofile.sdkauthorize.SdkAuthorize$GetAuthApiListResponse;
import com.tencent.qphone.base.BaseConstants;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

/* loaded from: classes22.dex */
public class OldAuthorityPresenter extends BaseAuthorityPresenter implements ep3.f {
    private int F;
    private int G;
    private long H;
    private fp3.b I;
    private final com.tencent.open.agent.auth.model.e J;
    private final ep3.g K;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class a implements com.tencent.open.appcommon.d {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f340235d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f340236e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f340237f;

        a(long j3, boolean z16, String str) {
            this.f340235d = j3;
            this.f340236e = z16;
            this.f340237f = str;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            t.b("OldAuthorityPresenter", "queryAuthList success=", Boolean.valueOf(z16));
            OldAuthorityPresenter.this.K.p2();
            OldAuthorityPresenter.this.y0(z16, bundle, this.f340235d, this.f340236e, this.f340237f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class b implements com.tencent.open.appcommon.d {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f340239d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f340240e;

        b(String str, long j3) {
            this.f340239d = str;
            this.f340240e = j3;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            t.f("OldAuthorityPresenter", "getAppInfo observer onReceive isSuccess = " + z16);
            com.tencent.open.agent.util.d.h("KEY_GET_APP_INFO_REQUEST", OldAuthorityPresenter.this.f340190y, z16);
            OldAuthorityPresenter.this.K.p2();
            if (!OldAuthorityPresenter.this.f340190y.f341678a.equals(bundle.getString("ssoAccount"))) {
                t.e("OldAuthorityPresenter", "mAccount.uin != ssoAccount");
            } else if (z16) {
                OldAuthorityPresenter.this.x0(bundle, this.f340239d, System.currentTimeMillis() - this.f340240e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class c implements com.tencent.open.appcommon.d {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f340242d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f340243e;

        c(String str, List list) {
            this.f340242d = str;
            this.f340243e = list;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            String string = bundle.getString("ssoAccount");
            int i16 = bundle.getInt("code");
            OldAuthorityPresenter.this.f340171f = SystemClock.elapsedRealtime() - OldAuthorityPresenter.this.H;
            t.b("OldAuthorityPresenter", "doAuthorize-onReceive", ", ssoAccount=", com.tencent.open.agent.util.g.C(string), ", uin=", com.tencent.open.agent.util.g.C(OldAuthorityPresenter.this.f340190y.f341678a), ", code=", Integer.valueOf(i16), ", isSuccess=", Boolean.valueOf(z16), ", cmd=", this.f340242d, ", cost=", Long.valueOf(OldAuthorityPresenter.this.f340171f), ", mDoAuthorizeRetryCount=", Integer.valueOf(OldAuthorityPresenter.this.G));
            if (!OldAuthorityPresenter.this.f340190y.f341678a.equals(string)) {
                if (i16 != 1002 || OldAuthorityPresenter.this.G >= 1) {
                    OldAuthorityPresenter.this.G = 0;
                    return;
                }
                OldAuthorityPresenter.this.G++;
                OldAuthorityPresenter.this.u0(this.f340243e, bundle);
                return;
            }
            OldAuthorityPresenter.this.K.H7(true);
            OldAuthorityPresenter.this.K.p2();
            if (z16) {
                OldAuthorityPresenter.this.C0(bundle, this.f340242d);
            } else {
                OldAuthorityPresenter.this.B0(i16, this.f340243e);
            }
        }
    }

    public OldAuthorityPresenter(ep3.g gVar, com.tencent.open.agent.auth.model.e eVar, com.tencent.open.agent.auth.model.c cVar) {
        super(gVar, cVar);
        this.K = gVar;
        this.J = eVar;
    }

    private void A0(Bundle bundle, boolean z16, String str, long j3) {
        this.F = 0;
        try {
            byte[] x16 = com.tencent.open.agent.util.g.x(bundle, z16, this.f340190y);
            if (x16 == null) {
                return;
            }
            final SdkAuthorize$GetAuthApiListResponse sdkAuthorize$GetAuthApiListResponse = new SdkAuthorize$GetAuthApiListResponse();
            sdkAuthorize$GetAuthApiListResponse.mergeFrom(x16);
            this.f340166a.post(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.OldAuthorityPresenter.2
                @Override // java.lang.Runnable
                public void run() {
                    OldAuthorityPresenter.this.G0(sdkAuthorize$GetAuthApiListResponse);
                }
            });
            int i3 = sdkAuthorize$GetAuthApiListResponse.ret.get();
            com.tencent.open.agent.util.d.v(bundle, this.f340170e, i3, 11, str, this.f340186u, this.f340189x);
            com.tencent.open.agent.util.d.o("agent_query_authority", j3, x16.length, sdkAuthorize$GetAuthApiListResponse.toByteArray().length, 0, this.f340190y.f341678a, "ret: " + i3);
            com.tencent.open.agent.util.d.r(0, "LOGIN_GETAUTHLIST_AGENT", this.f340190y.f341678a, this.f340186u, i3, null);
            com.tencent.open.agent.util.d.z(this.f340190y.f341678a, this.f340186u, "2", "0", false);
            I0("KEY_GET_AUTH_API_LIST_REQUEST", this.F, true);
            com.tencent.open.agent.util.d.u(System.currentTimeMillis() - this.f340167b, 14, this.f340186u, this.f340189x);
        } catch (Exception e16) {
            t.d("OldAuthorityPresenter", "Exception", e16);
            B(3001, R.string.cov);
            I0("KEY_GET_AUTH_API_LIST_REQUEST", this.F, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(int i3, List<hp3.e> list) {
        int i16;
        if (i3 == 1002 && (i16 = this.G) < 1) {
            this.G = i16 + 1;
            t0(list);
            return;
        }
        this.G = 0;
        B(3002, R.string.f171155cp4);
        I0("KEY_AUTHORIZE_REQUEST", this.G, false);
        String string = MobileQQ.sMobileQQ.getResources().getString(R.string.f171155cp4);
        com.tencent.open.agent.util.d.o("agent_authority", this.H, 0L, 0L, i3, this.f340190y.f341678a, string);
        com.tencent.open.agent.util.d.r(1, "LOGIN_AUTH", this.f340190y.f341678a, this.f340186u, 3002, string);
        com.tencent.open.agent.util.d.z(this.f340190y.f341678a, this.f340186u, "6", "3002", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(Bundle bundle, String str) {
        this.G = 0;
        try {
            byte[] x16 = com.tencent.open.agent.util.g.x(bundle, BaseConstants.CMD_CONNAUTHSVR_GETAUTHAPI.equals(str), this.f340190y);
            if (x16 == null) {
                t.e("OldAuthorityPresenter", "onSdkAuthApiSuccess null == data");
                return;
            }
            final SdkAuthorize$AuthorizeResponse mergeFrom = new SdkAuthorize$AuthorizeResponse().mergeFrom(x16);
            this.f340166a.post(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.OldAuthorityPresenter.7
                @Override // java.lang.Runnable
                public void run() {
                    OldAuthorityPresenter.this.S(fp3.b.a(mergeFrom));
                }
            });
            if (mergeFrom.ret.get() == 0) {
                com.tencent.open.agent.auth.model.b.c(this.f340186u, this.f340190y.f341678a, mergeFrom.expires_in.get(), x16);
            }
            int i3 = mergeFrom.ret.get();
            com.tencent.open.agent.util.d.v(bundle, this.f340171f, i3, 13, str, this.f340186u, this.f340189x);
            com.tencent.open.agent.util.d.o("agent_authority", this.H, x16.length, mergeFrom.toByteArray().length, 0, this.f340190y.f341678a, "ret: " + i3);
            com.tencent.open.agent.util.d.r(0, "LOGIN_AUTH", this.f340190y.f341678a, this.f340186u, i3, null);
            I0("KEY_AUTHORIZE_REQUEST", this.G, true);
        } catch (Exception e16) {
            t.d("OldAuthorityPresenter", "Exception", e16);
            B(3002, R.string.f171155cp4);
            I0("KEY_AUTHORIZE_REQUEST", this.G, false);
        }
    }

    private void D0(SdkAuthorize$GetAuthApiListResponse sdkAuthorize$GetAuthApiListResponse) {
        this.f340179n = false;
        if (this.K.X5(sdkAuthorize$GetAuthApiListResponse, this.f340186u)) {
            t.b("OldAuthorityPresenter", "parseAuthListResultSuccess authorized");
            J(true);
            v0(fp3.b.a(sdkAuthorize$GetAuthApiListResponse.auth_response.get()));
        } else {
            t.b("OldAuthorityPresenter", "parseAuthListResultSuccess not authorized");
            J(false);
        }
        this.K.H7(true);
        this.K.dismissProgressDialog();
        w0();
    }

    private boolean E0(Bundle bundle) {
        if (this.f340183r) {
            com.tencent.open.agent.util.b.d(bundle);
            s();
            return false;
        }
        if (!"action_login".equals(com.tencent.open.agent.util.c.l(this.D, "key_action"))) {
            return false;
        }
        if (E()) {
            this.f340180o = false;
            return true;
        }
        s();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(GetAppInfoProto$GetAppinfoResponse getAppInfoProto$GetAppinfoResponse) {
        t.b("OldAuthorityPresenter", "parseGetAppInfoResponse mHasAppIcon=", Boolean.valueOf(this.f340178m));
        if (!TextUtils.isEmpty(getAppInfoProto$GetAppinfoResponse.appName.get())) {
            String str = getAppInfoProto$GetAppinfoResponse.appName.get();
            this.K.p0(str, null);
            t.b("OldAuthorityPresenter", "parseGetAppInfoResponse appName=", str);
        }
        if (this.f340178m) {
            return;
        }
        List<hp3.d> m3 = com.tencent.open.agent.util.b.m(getAppInfoProto$GetAppinfoResponse.iconsURL);
        if (m3.isEmpty()) {
            t.b("OldAuthorityPresenter", "parseGetAppInfoResponse iconsURL none");
        } else {
            v(m3.get(y(m3)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(SdkAuthorize$GetAuthApiListResponse sdkAuthorize$GetAuthApiListResponse) {
        int i3 = sdkAuthorize$GetAuthApiListResponse.ret.get();
        t.b("OldAuthorityPresenter", "parseGetAuthListResult ret=", Integer.valueOf(i3));
        if (i3 == 0) {
            D0(sdkAuthorize$GetAuthApiListResponse);
        } else {
            R(sdkAuthorize$GetAuthApiListResponse.f342210msg.get(), i3);
        }
    }

    private void H0() {
        byte[] bArr;
        if (this.f340190y == null) {
            t.b("OldAuthorityPresenter", "queryAuthList mAccount == null");
            this.K.ld(30000L);
            return;
        }
        Object[] y16 = com.tencent.open.agent.util.g.y(MobileQQ.sMobileQQ.peekAppRuntime(), this.f340190y.f341678a, "ConnAuthSvr.get_auth_api_list", BaseConstants.CMD_CONNAUTHSVR_GETAUTHAPILIST);
        String str = (String) y16[0];
        boolean equals = BaseConstants.CMD_CONNAUTHSVR_GETAUTHAPILIST.equals(str);
        if (!MobileQQ.sMobileQQ.isLoginByNT() && equals && ((bArr = this.f340190y.f341679b) == null || bArr.length == 0)) {
            t.b("OldAuthorityPresenter", "queryAuthList useEmp && (mAccount.st == null || mAccount.st.length == 0)");
            B(3000, R.string.cov);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        t.b("OldAuthorityPresenter", "queryAuthList cmd=", str, ", uin=", com.tencent.open.agent.util.g.C(this.f340190y.f341678a));
        this.f340185t = 0;
        this.K.ld(30000L);
        this.J.a(this.A, this.f340190y, y16, new a(elapsedRealtime, equals, str));
    }

    private void I0(String str, int i3, boolean z16) {
        HashMap hashMap = new HashMap();
        hashMap.put("PARAM_RETRY_COUNT", Integer.toString(i3));
        com.tencent.open.agent.util.d.g(str, this.f340190y, hashMap, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        t.b("OldAuthorityPresenter", "showUserInfo uin=" + com.tencent.open.agent.util.g.C(this.f340190y.f341678a));
        String c16 = com.tencent.mobileqq.login.account.b.c(this.f340190y.f341678a);
        ep3.g gVar = this.K;
        String str = this.f340190y.f341678a;
        if (TextUtils.isEmpty(c16)) {
            c16 = this.f340190y.f341678a;
        }
        gVar.G1(str, c16, null);
        AvatarUpdateService.a().c(this.C, this.f340190y.f341678a, z(), new d.a() { // from class: com.tencent.open.agent.auth.presenter.OldAuthorityPresenter.9
            @Override // com.tencent.open.base.http.d.a
            public void r1(String str2, final Bitmap bitmap) {
                t.b("OldAuthorityPresenter", "onTaskCompleted identifier=", com.tencent.open.agent.util.g.C(str2), ", bitmap=", bitmap);
                if (bitmap != null && str2.equals(OldAuthorityPresenter.this.f340190y.f341678a)) {
                    OldAuthorityPresenter.this.C.runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.OldAuthorityPresenter.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            OldAuthorityPresenter.this.K.G1(OldAuthorityPresenter.this.f340190y.f341678a, "", bitmap);
                        }
                    });
                }
            }
        });
    }

    private void K0(String str, final String str2) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.OldAuthorityPresenter.8
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                try {
                    bitmap = BitmapFactory.decodeResource(OldAuthorityPresenter.this.C.getResources(), R.drawable.f160830com);
                } catch (Throwable th5) {
                    t.d("OldAuthorityPresenter", "useDefaultIcon", th5);
                    bitmap = null;
                }
                if (bitmap == null) {
                    return;
                }
                final Bitmap s16 = com.tencent.open.agent.util.g.s(OldAuthorityPresenter.this.C, bitmap, 63, 63);
                bitmap.recycle();
                OldAuthorityPresenter.this.f340166a.post(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.OldAuthorityPresenter.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ep3.g gVar = OldAuthorityPresenter.this.K;
                        AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                        gVar.G1(OldAuthorityPresenter.this.f340189x, str2, s16);
                    }
                });
            }
        }, 16, null, true);
    }

    private void t0(List<hp3.e> list) {
        this.G = 0;
        this.H = SystemClock.elapsedRealtime();
        Bundle bundle = new Bundle(this.A);
        bundle.putString("openapi", "");
        bundle.putBoolean("doAuthorize", true);
        bundle.putString("need_pay", "1");
        bundle.putString("appid_for_getting_config", bundle.getString(CommonConstant.ReqAccessTokenParam.CLIENT_ID));
        this.K.showProgressDialog(R.string.f171154cp2);
        if (this.A.getBoolean("key_login_by_qr_scan", false)) {
            t.f("OldAuthorityPresenter", "doAuthorize confirmQRLogin");
            p.d(this.A);
        } else {
            this.f340185t = 1;
            this.K.ld(30000L);
            com.tencent.open.agent.util.d.B("KEY_AUTHORIZE_REQUEST");
            u0(list, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(List<hp3.e> list, Bundle bundle) {
        Object[] y16 = com.tencent.open.agent.util.g.y(MobileQQ.sMobileQQ.peekAppRuntime(), this.f340190y.f341678a, "ConnAuthSvr.sdk_auth_api", BaseConstants.CMD_CONNAUTHSVR_GETAUTHAPI);
        String str = (String) y16[0];
        t.b("OldAuthorityPresenter", "doAuthorize cmd=", str, ", uin=", com.tencent.open.agent.util.g.C(this.f340190y.f341678a));
        this.J.b(list, bundle, this.f340190y, y16, new c(str, list));
    }

    private void v0(fp3.b bVar) {
        this.I = bVar;
        if (!this.f340180o) {
            return;
        }
        this.f340166a.post(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.OldAuthorityPresenter.3
            @Override // java.lang.Runnable
            public void run() {
                OldAuthorityPresenter oldAuthorityPresenter = OldAuthorityPresenter.this;
                oldAuthorityPresenter.S(oldAuthorityPresenter.I);
            }
        });
    }

    private void w0() {
        Object[] y16 = com.tencent.open.agent.util.g.y(MobileQQ.sMobileQQ.peekAppRuntime(), this.f340190y.f341678a, "ConnAuthSvr.get_app_info", BaseConstants.CMD_CONNAUTHSVR_GETAPPINFO);
        String str = (String) y16[0];
        t.b("OldAuthorityPresenter", "getAppInfo cmd=", str);
        com.tencent.open.agent.util.d.B("KEY_GET_APP_INFO_REQUEST");
        this.f340185t = 2;
        this.K.ld(30000L);
        this.J.c(this.A, this.f340190y, y16, new b(str, System.currentTimeMillis()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(Bundle bundle, String str, long j3) {
        try {
            byte[] x16 = com.tencent.open.agent.util.g.x(bundle, BaseConstants.CMD_CONNAUTHSVR_GETAPPINFO.equals(str), this.f340190y);
            if (x16 == null) {
                return;
            }
            final GetAppInfoProto$GetAppinfoResponse getAppInfoProto$GetAppinfoResponse = new GetAppInfoProto$GetAppinfoResponse();
            getAppInfoProto$GetAppinfoResponse.mergeFrom(x16);
            if (!getAppInfoProto$GetAppinfoResponse.has()) {
                return;
            }
            int i3 = getAppInfoProto$GetAppinfoResponse.ret.get();
            com.tencent.open.agent.util.d.v(bundle, j3, i3, 12, str, this.f340186u, this.f340189x);
            if (i3 != 0) {
                return;
            }
            this.f340166a.post(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.OldAuthorityPresenter.5
                @Override // java.lang.Runnable
                public void run() {
                    OldAuthorityPresenter.this.F0(getAppInfoProto$GetAppinfoResponse);
                }
            });
        } catch (Exception e16) {
            t.d("OldAuthorityPresenter", "getAppInfo", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(boolean z16, Bundle bundle, long j3, boolean z17, String str) {
        this.f340170e = SystemClock.elapsedRealtime() - j3;
        String string = bundle.getString("ssoAccount");
        if (!this.f340190y.f341678a.equals(string)) {
            t.b("OldAuthorityPresenter", "onGetAuthApiBack account changed, ssoAccount=", string);
            return;
        }
        if (!this.f340180o) {
            this.K.H7(true);
        }
        if (z16) {
            A0(bundle, z17, str, j3);
        } else {
            z0(bundle.getInt("code"), j3);
        }
    }

    private void z0(int i3, long j3) {
        int i16;
        this.I = null;
        if (i3 == 1002 && (i16 = this.F) < 2) {
            this.F = i16 + 1;
            H0();
            return;
        }
        B(3001, R.string.cov);
        I0("KEY_GET_AUTH_API_LIST_REQUEST", this.F, false);
        String string = MobileQQ.sMobileQQ.getResources().getString(R.string.cov);
        com.tencent.open.agent.util.d.o("agent_query_authority", j3, 0L, 0L, i3, this.f340190y.f341678a, string);
        com.tencent.open.agent.util.d.r(1, "LOGIN_GETAUTHLIST_AGENT", this.f340190y.f341678a, this.f340186u, i3, string);
        com.tencent.open.agent.util.d.z(this.f340190y.f341678a, this.f340186u, "2", String.valueOf(i3), false);
        com.tencent.open.agent.util.d.z(this.f340190y.f341678a, this.f340186u, "6", String.valueOf(i3), false);
    }

    @Override // com.tencent.open.agent.auth.presenter.BaseAuthorityPresenter
    protected void M(String str, int i3, Bundle bundle) {
        if (!bundle.getBoolean("fake_callback") && i3 == 64) {
            up3.b.o(str, System.currentTimeMillis());
        }
        this.f340174i = 0;
        this.f340182q = false;
        this.f340169d = SystemClock.elapsedRealtime();
        this.K.H7(true);
        if (!this.f340183r) {
            this.f340166a.post(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.OldAuthorityPresenter.10
                @Override // java.lang.Runnable
                public void run() {
                    OldAuthorityPresenter.this.J0();
                }
            });
        }
        if (this.f340184s == 1) {
            t0((List) this.K.fe(4));
        } else {
            H0();
        }
    }

    @Override // com.tencent.open.agent.auth.presenter.BaseAuthorityPresenter
    protected void Z(String str) {
        t.e("OldAuthorityPresenter", "showLocalInfo currentAccount=", com.tencent.open.agent.util.g.C(str));
        if (!this.f340183r && !TextUtils.isEmpty(str)) {
            String a16 = com.tencent.mobileqq.login.account.b.a(str);
            if (!TextUtils.isEmpty(a16) && !a16.equals("0")) {
                String c16 = com.tencent.mobileqq.login.account.b.c(a16);
                if (TextUtils.isEmpty(c16)) {
                    c16 = a16;
                }
                this.f340189x = a16;
                Bitmap i3 = OpenSdkVirtualUtil.i(a16, 58, true);
                if (i3 != null) {
                    Bitmap s16 = com.tencent.open.agent.util.g.s(this.C, i3, 63, 63);
                    i3.recycle();
                    this.K.G1(this.f340189x, c16, s16);
                    return;
                }
                K0(a16, c16);
                return;
            }
            t.e("OldAuthorityPresenter", "showLocalInfo uin=", a16);
        }
    }

    @Override // ep3.f, ep3.b
    public void a(int i3, Intent intent) {
        com.tencent.open.model.a aVar;
        this.f340169d = SystemClock.elapsedRealtime();
        if (i3 == 0) {
            if (TextUtils.isEmpty(this.f340189x)) {
                k();
                return;
            }
            return;
        }
        if (-1 == i3) {
            this.I = null;
            d0(intent);
            if (0 != o.c(this.f340186u)) {
                w0();
            }
            String stringExtra = intent.getStringExtra("last_account");
            this.f340189x = stringExtra;
            this.f340189x = com.tencent.mobileqq.login.account.b.a(stringExtra);
            this.K.q2(this.f340186u);
            Z(this.f340189x);
            this.f340166a.post(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.OldAuthorityPresenter.11
                @Override // java.lang.Runnable
                public void run() {
                    OldAuthorityPresenter.this.J0();
                }
            });
            if (intent.getBooleanExtra(QAdLoginDefine$LoginStatus.IS_LOGIN, false)) {
                this.E.b(this.f340189x);
                com.tencent.open.agent.util.g.V(this.f340189x);
            }
            Bundle d16 = com.tencent.open.agent.util.c.d(intent, "ssobundle");
            if (d16 != null) {
                byte[] byteArray = d16.getByteArray("st_temp");
                byte[] byteArray2 = d16.getByteArray("st_temp_key");
                if (byteArray != null && byteArray2 != null) {
                    com.tencent.open.model.a aVar2 = this.f340190y;
                    if (aVar2 != null) {
                        aVar2.f341679b = byteArray;
                    }
                    if (aVar2 != null) {
                        aVar2.f341680c = byteArray2;
                    }
                }
            }
            this.f340180o = true;
            this.K.H7(false);
            if (intent.getBooleanExtra("fromLoginPhoneNum", false) && (aVar = this.f340190y) != null && aVar.f341680c == null) {
                F(this.f340189x);
                return;
            }
            this.f340182q = false;
            hp3.b.e().a(this.f340189x);
            H0();
        }
    }

    @Override // ep3.f
    public void c() {
        t.b("OldAuthorityPresenter", "onLoginBtnClick mGetTicketFailed=", Boolean.valueOf(this.f340182q));
        if (!this.f340179n && !this.f340182q && this.f340190y != null) {
            this.K.H7(false);
            if (this.f340185t == 0) {
                this.K.showProgressDialog(R.string.cow);
                H0();
                return;
            }
            com.tencent.open.agent.util.d.f("KEY_LOGIN_STAGE_2_OLD_TOTAL", this.f340190y);
            com.tencent.open.agent.util.d.B("KEY_LOGIN_STAGE_3_TOTAL");
            if (this.I != null) {
                t.b("OldAuthorityPresenter", "ClickAuthButton: ");
                this.f340166a.post(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.OldAuthorityPresenter.12
                    @Override // java.lang.Runnable
                    public void run() {
                        OldAuthorityPresenter oldAuthorityPresenter = OldAuthorityPresenter.this;
                        oldAuthorityPresenter.S(oldAuthorityPresenter.I);
                        OldAuthorityPresenter.this.I = null;
                    }
                });
            } else {
                t.b("OldAuthorityPresenter", "ClickAuthButton -- doAuthorize(): ");
                t0((List) this.K.fe(4));
            }
            com.tencent.open.agent.util.d.z(this.f340189x, this.f340186u, "2", "0", false);
            com.tencent.open.agent.util.g.O("0X800BA82");
            return;
        }
        F(this.f340189x);
    }

    @Override // ep3.b
    public void d(String str, boolean z16) {
        if (u(str, z16)) {
            this.I = null;
        }
    }

    @Override // ep3.f
    public boolean onCreate(Bundle bundle) {
        t.b("OldAuthorityPresenter", "onCreate");
        if (bundle == null) {
            t.b("OldAuthorityPresenter", "Params are null, finish activity");
            X(-5, "params is null", "params is null", "params is null");
            return true;
        }
        D(bundle);
        com.tencent.open.agent.util.d.B("KEY_LOGIN_STAGE_2_OLD_TOTAL");
        com.tencent.open.agent.util.d.s(this.f340189x, "0X800B65C");
        com.tencent.open.agent.util.d.z(this.f340189x, this.f340186u, "1", "0", false);
        com.tencent.open.agent.util.g.O("0X800BA81");
        return E0(bundle);
    }
}
