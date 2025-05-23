package com.tencent.open.agent.auth.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.open.agent.auth.model.NewAuthDataSourceImpl;
import com.tencent.open.agent.auth.util.AppAuthLimitHelper;
import com.tencent.open.agent.report.OpenAuthTelemetryProxy;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.util.k;
import com.tencent.open.agent.util.t;
import com.tencent.protofile.sdkauthorize.SdkAuthorize$AuthorizeResponse;
import com.tencent.qconn.protofile.appType$LoginSig;
import com.tencent.qphone.base.BaseConstants;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes22.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, Integer> f340321a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.open.agent.auth.model.d f340322b = new NewAuthDataSourceImpl();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements k.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.open.model.a f340323a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bundle f340324b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f340325c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f340326d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f340327e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f340328f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ List f340329g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f340330h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f340331i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ long f340332j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ fp3.a f340333k;

        /* compiled from: P */
        /* renamed from: com.tencent.open.agent.auth.presenter.k$a$a, reason: collision with other inner class name */
        /* loaded from: classes22.dex */
        class C9268a implements com.tencent.open.appcommon.d {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f340335d;

            C9268a(String str) {
                this.f340335d = str;
            }

            @Override // mqq.observer.BusinessObserver
            public void onReceive(int i3, boolean z16, Bundle bundle) {
                long currentTimeMillis = System.currentTimeMillis() - a.this.f340332j;
                String string = bundle.getString("ssoAccount");
                int i16 = bundle.getInt("code");
                t.b("SSOSdkAuthApiPresenter", "doAuthorize onReceive ssoAccount=", com.tencent.open.agent.util.g.C(string), ", isSuccess=", Boolean.valueOf(z16), ", timeCost=", Long.valueOf(currentTimeMillis), ", cmd=", this.f340335d, ", code=", Integer.valueOf(i16));
                if (!a.this.f340323a.f341678a.equals(string)) {
                    a aVar = a.this;
                    k.this.h(i16, aVar.f340326d, aVar.f340325c, aVar.f340327e, aVar.f340328f, aVar.f340329g, aVar.f340330h, aVar.f340333k, aVar.f340331i);
                } else if (z16) {
                    a aVar2 = a.this;
                    k.this.j(bundle, currentTimeMillis, i16, aVar2.f340326d, this.f340335d, aVar2.f340323a, aVar2.f340333k);
                    OpenAuthTelemetryProxy.e(true);
                } else {
                    a aVar3 = a.this;
                    k.this.i(i16, aVar3.f340326d, aVar3.f340325c, aVar3.f340327e, aVar3.f340328f, aVar3.f340329g, aVar3.f340330h, aVar3.f340333k, aVar3.f340331i, aVar3.f340323a);
                }
            }
        }

        a(com.tencent.open.model.a aVar, Bundle bundle, boolean z16, String str, String str2, String str3, List list, long j3, String str4, long j16, fp3.a aVar2) {
            this.f340323a = aVar;
            this.f340324b = bundle;
            this.f340325c = z16;
            this.f340326d = str;
            this.f340327e = str2;
            this.f340328f = str3;
            this.f340329g = list;
            this.f340330h = j3;
            this.f340331i = str4;
            this.f340332j = j16;
            this.f340333k = aVar2;
        }

        @Override // com.tencent.open.agent.util.k.a
        public void a(Pair<String, appType$LoginSig> pair) {
            String first = pair.getFirst();
            Object[] objArr = {pair.getFirst(), pair.getSecond()};
            t.b("SSOSdkAuthApiPresenter", "OpenVirtual.doAuthorize.send | cmd: " + first, " | uin : *" + com.tencent.open.agent.util.g.C(this.f340323a.f341678a));
            k.this.f340322b.e(this.f340324b, this.f340323a, this.f340325c, this.f340326d, this.f340327e, this.f340328f, this.f340329g, this.f340330h, this.f340331i, objArr, new C9268a(first));
        }
    }

    private Bundle e(Bundle bundle) {
        Bundle bundle2 = new Bundle(bundle);
        bundle2.putString("openapi", "");
        bundle2.putBoolean("doAuthorize", true);
        bundle2.putString("need_pay", "1");
        bundle2.putString("appid_for_getting_config", com.tencent.open.agent.util.c.i(bundle2, CommonConstant.ReqAccessTokenParam.CLIENT_ID));
        return bundle2;
    }

    private void g(boolean z16, String str, String str2, String str3, List<hp3.e> list, long j3, fp3.a aVar, String str4, com.tencent.open.model.a aVar2, Bundle bundle) {
        AppAuthLimitHelper.c(str);
        Bundle e16 = e(bundle);
        com.tencent.open.agent.util.g.z(MobileQQ.sMobileQQ.waitAppRuntime(null), aVar2.f341678a, "ConnAuthSvr.sdk_auth_api", BaseConstants.CMD_CONNAUTHSVR_GETAUTHAPI, new a(aVar2, e16, z16, str, str2, str3, list, j3, str4, System.currentTimeMillis(), aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i3, String str, boolean z16, String str2, String str3, List<hp3.e> list, long j3, fp3.a aVar, String str4) {
        int intValue;
        Integer num = this.f340321a.get(str);
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        if (i3 == 1002 && intValue < 1) {
            t.b("SSOSdkAuthApiPresenter", "OpenVirtual.doAuthorize retry");
            this.f340321a.put(str, Integer.valueOf(intValue + 1));
            f(z16, str, str2, str3, list, j3, aVar, str4);
        } else if (aVar != null) {
            this.f340321a.put(str, 0);
            aVar.a(false, i3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i3, String str, boolean z16, String str2, String str3, List<hp3.e> list, long j3, fp3.a aVar, String str4, com.tencent.open.model.a aVar2) {
        int intValue;
        Integer num = this.f340321a.get(str);
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        if (i3 == 1002 && intValue < 1) {
            t.b("SSOSdkAuthApiPresenter", "OpenVirtual.doAuthorize retry");
            this.f340321a.put(str, Integer.valueOf(intValue + 1));
            f(z16, str, str2, str3, list, j3, aVar, str4);
            return;
        }
        this.f340321a.put(str, 0);
        aVar.a(false, i3, null);
        com.tencent.open.agent.util.d.o("agent_authority", hp3.b.e().d(str), 0L, 0L, i3, aVar2.f341678a, "");
        com.tencent.open.agent.util.d.r(1, "LOGIN_AUTH", aVar2.f341678a, str, 3002, "");
        ReportCenter.f().q(aVar2.f341678a, "", str, "1", "6", "3002", false, true);
        t.b("SSOSdkAuthApiPresenter", "doAuthorize onReceive failed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v7, types: [boolean] */
    public void j(Bundle bundle, long j3, int i3, String str, String str2, com.tencent.open.model.a aVar, fp3.a aVar2) {
        ?? r16;
        int i16;
        boolean z16;
        this.f340321a.put(str, 0);
        try {
            r16 = BaseConstants.CMD_CONNAUTHSVR_GETAUTHAPI.equals(str2);
            byte[] x16 = com.tencent.open.agent.util.g.x(bundle, r16, aVar);
            try {
                if (x16 == null) {
                    aVar2.a(false, i3, null);
                    return;
                }
                SdkAuthorize$AuthorizeResponse mergeFrom = new SdkAuthorize$AuthorizeResponse().mergeFrom(x16);
                int i17 = mergeFrom.ret.get();
                try {
                    t.f("SSOSdkAuthApiPresenter", "onSdkAuthApiSuccess code= " + i17);
                    if (i17 == 0) {
                        try {
                            com.tencent.open.agent.auth.model.b.c(str, aVar.f341678a, mergeFrom.expires_in.get(), x16);
                            aVar2.a(true, i17, fp3.b.a(mergeFrom));
                        } catch (Exception e16) {
                            e = e16;
                            z16 = false;
                            i16 = i17;
                            aVar2.a(z16, i16, null);
                            t.d("SSOSdkAuthApiPresenter", "onSdkAuthApiSuccess Exception", e);
                        }
                    } else {
                        aVar2.a(false, i17, fp3.b.a(mergeFrom));
                    }
                    long length = mergeFrom.toByteArray().length;
                    i16 = i17;
                    try {
                        com.tencent.open.agent.util.d.v(bundle, j3, i17, 13, str2, str, aVar.f341678a);
                        com.tencent.open.agent.util.d.o("agent_authority", hp3.b.e().d(str), x16.length, length, 0, aVar.f341678a, "ret: " + i16);
                        com.tencent.open.agent.util.d.r(0, "LOGIN_AUTH", aVar.f341678a, str, i16, null);
                    } catch (Exception e17) {
                        e = e17;
                        z16 = false;
                        aVar2.a(z16, i16, null);
                        t.d("SSOSdkAuthApiPresenter", "onSdkAuthApiSuccess Exception", e);
                    }
                } catch (Exception e18) {
                    e = e18;
                    i16 = i17;
                }
            } catch (Exception e19) {
                e = e19;
                i16 = r16;
                z16 = false;
                aVar2.a(z16, i16, null);
                t.d("SSOSdkAuthApiPresenter", "onSdkAuthApiSuccess Exception", e);
            }
        } catch (Exception e26) {
            e = e26;
            r16 = i3;
        }
    }

    public void f(boolean z16, String str, String str2, String str3, List<hp3.e> list, long j3, fp3.a aVar, String str4) {
        String str5;
        t.b("SSOSdkAuthApiPresenter", "doAuthorize");
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (TextUtils.isEmpty(str2)) {
            str5 = str;
        } else {
            str5 = str2;
        }
        com.tencent.open.model.a b16 = hp3.b.e().b(str5);
        Bundle f16 = hp3.b.e().f(str5);
        if (waitAppRuntime != null && f16 != null && b16 != null) {
            if (!TextUtils.isEmpty(str2)) {
                new fp3.e().a(this.f340322b, z16, str, str2, str3, list, j3, aVar, str4, b16, f16);
                return;
            } else {
                g(z16, str, str2, str3, list, j3, aVar, str4, b16, f16);
                return;
            }
        }
        t.e("SSOSdkAuthApiPresenter", "OpenVirtual.doAuthorize return for param is null.");
        aVar.a(false, -1, null);
    }
}
