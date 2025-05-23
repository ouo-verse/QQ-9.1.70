package com.tencent.open.agent.auth.model;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.thirdsig.api.IOpenSigInjectService;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.report.SSOSendReporter;
import com.tencent.open.agent.util.o;
import com.tencent.open.agent.util.t;
import com.tencent.open.appcommon.OpensdkServlet;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.protofile.sdkauthorize.SdkAuthorize$AuthorizeRequest;
import com.tencent.qconn.protofile.GetPromotePage$GetLoginPromotePageReq;
import com.tencent.qconn.protofile.OpenSdkRecCommon$AppReqInfo;
import com.tencent.qconn.protofile.OpenSdkRecCommon$LoginSourceInfo;
import com.tencent.qconn.protofile.OpenSdkRecCommon$ProxyRequest;
import com.tencent.qconn.protofile.OpenSdkRecCommon$Session;
import com.tencent.qconn.protofile.OpenSdkRecCommon$UserTraitInfo;
import com.tencent.qconn.protofile.OpenSdkRecCommon$VersionInfo;
import com.tencent.qconn.protofile.SubmitPromotePage$SubmitPromotePageReq;
import com.tencent.qconn.protofile.SubmitPromotePage$SubmitResultItem;
import com.tencent.qconn.protofile.appType$LoginSig;
import com.tencent.qconn.protofile.auth$AuthRequest;
import com.tencent.qconn.protofile.preAuth$PreAuthRequest;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import eq3.CommonReqParams;
import java.util.HashMap;
import java.util.List;
import mqq.app.MainService;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class NewAuthDataSourceImpl implements d {

    /* renamed from: a, reason: collision with root package name */
    private static String f340113a = "NewAuthDataSourceImpl";

    /* compiled from: P */
    /* renamed from: com.tencent.open.agent.auth.model.NewAuthDataSourceImpl$3, reason: invalid class name */
    /* loaded from: classes22.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f340119d;
        final /* synthetic */ NewAuthDataSourceImpl this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (com.tencent.open.agent.util.g.G(this.f340119d)) {
                QQToast.makeText(MobileQQ.sMobileQQ, "\u4f7f\u7528\u4e92\u8054SSO\u65b0\u901a\u9053", 1).show();
            } else {
                QQToast.makeText(MobileQQ.sMobileQQ, "\u4f7f\u7528\u7a7aKey\u52a0\u5bc6\u65e7\u901a\u9053", 1).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements com.tencent.mobileqq.thirdsig.api.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ NewIntent f340120a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.open.model.a f340121b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.open.appcommon.d f340122c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f340123d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ byte[] f340124e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f340125f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f340126g;

        a(NewIntent newIntent, com.tencent.open.model.a aVar, com.tencent.open.appcommon.d dVar, String str, byte[] bArr, boolean z16, String str2) {
            this.f340120a = newIntent;
            this.f340121b = aVar;
            this.f340122c = dVar;
            this.f340123d = str;
            this.f340124e = bArr;
            this.f340125f = z16;
            this.f340126g = str2;
        }

        @Override // com.tencent.mobileqq.thirdsig.api.a
        public void onFail(int i3, @NonNull String str) {
            t.e(NewAuthDataSourceImpl.f340113a, "commitOpenTicketToMsf onFail retCode: " + i3 + " errMsg: " + str);
            if (this.f340121b.a()) {
                NewAuthDataSourceImpl newAuthDataSourceImpl = NewAuthDataSourceImpl.this;
                com.tencent.open.model.a aVar = this.f340121b;
                newAuthDataSourceImpl.p(aVar, this.f340122c, this.f340123d, OpenSdkVirtualUtil.f(this.f340124e, aVar), this.f340125f, true);
            } else {
                t.e(NewAuthDataSourceImpl.f340113a, "commitOpenTicketToMsf onFail. st not valid");
                SSOSendReporter.c(this.f340121b.f341678a, this.f340123d, true, false, -1, "st not valid");
                Bundle bundle = new Bundle();
                bundle.putInt("code", 110509);
                this.f340122c.onReceive(-1, false, bundle);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("isSuccess", "false");
            hashMap.put("errCode", String.valueOf(i3));
            hashMap.put("errMsg", str);
            hashMap.put(AlbumCacheData.LOGINUIN, MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin());
            hashMap.put("cmd", this.f340126g);
            QQBeaconReport.report(this.f340121b.f341678a, "open_sdk_sso_commit_ticket_error", hashMap);
        }

        @Override // com.tencent.mobileqq.thirdsig.api.a
        public void onSuccess() {
            t.b(NewAuthDataSourceImpl.f340113a, "useNewRoad commitOpenTicketToMsf onSuccess");
            this.f340120a.putExtra("use_open_sdk_ticket", true);
            MobileQQ.sMobileQQ.peekAppRuntime().startServlet(this.f340120a);
        }
    }

    private OpenSdkRecCommon$AppReqInfo i(CommonReqParams commonReqParams) {
        OpenSdkRecCommon$AppReqInfo openSdkRecCommon$AppReqInfo = new OpenSdkRecCommon$AppReqInfo();
        openSdkRecCommon$AppReqInfo.appid.set(o.c(commonReqParams.getHostAppId()));
        openSdkRecCommon$AppReqInfo.sdkp.set(com.tencent.open.agent.util.c.j(commonReqParams.getBundle(), "sdkp", "android"));
        openSdkRecCommon$AppReqInfo.qq_app_type.set(1);
        String pkgName = commonReqParams.getPkgName();
        if (!TextUtils.isEmpty(pkgName)) {
            openSdkRecCommon$AppReqInfo.appUniqueIdentifier.set(pkgName);
            String[] k3 = OpenSdkVirtualUtil.k(pkgName);
            t.b(f340113a, "getAppReqInfo sign=", k3[1], ", timestr=", k3[2]);
            if (!TextUtils.isEmpty(k3[1])) {
                openSdkRecCommon$AppReqInfo.sign.set(k3[1]);
                if (!TextUtils.isEmpty(k3[2])) {
                    openSdkRecCommon$AppReqInfo.md5time.set(o.c(k3[2]));
                }
            }
        } else {
            t.b(f340113a, "getAppReqInfo pkgName is empty");
        }
        return openSdkRecCommon$AppReqInfo;
    }

    private OpenSdkRecCommon$ProxyRequest j(CommonReqParams commonReqParams) {
        String proxyAppId = commonReqParams.getProxyAppId();
        if (!TextUtils.isEmpty(proxyAppId)) {
            OpenSdkRecCommon$ProxyRequest openSdkRecCommon$ProxyRequest = new OpenSdkRecCommon$ProxyRequest();
            OpenSdkRecCommon$ProxyRequest openSdkRecCommon$ProxyRequest2 = new OpenSdkRecCommon$ProxyRequest();
            openSdkRecCommon$ProxyRequest2.appid.set(o.c(proxyAppId));
            String proxyToken = commonReqParams.getProxyToken();
            if (proxyToken != null && !proxyToken.isEmpty()) {
                openSdkRecCommon$ProxyRequest2.token.set(ByteStringMicro.copyFromUtf8(proxyToken));
            }
            openSdkRecCommon$ProxyRequest.set(openSdkRecCommon$ProxyRequest2);
            return openSdkRecCommon$ProxyRequest;
        }
        return null;
    }

    @NonNull
    private OpenSdkRecCommon$Session k(String str) {
        OpenSdkRecCommon$Session openSdkRecCommon$Session = new OpenSdkRecCommon$Session();
        openSdkRecCommon$Session.state.set(str);
        return openSdkRecCommon$Session;
    }

    private OpenSdkRecCommon$LoginSourceInfo l(Bundle bundle) {
        int i3;
        OpenSdkRecCommon$LoginSourceInfo openSdkRecCommon$LoginSourceInfo = new OpenSdkRecCommon$LoginSourceInfo();
        boolean a16 = com.tencent.open.agent.util.c.a(bundle, "key_login_by_qr_scan", false);
        PBEnumField pBEnumField = openSdkRecCommon$LoginSourceInfo.referer;
        if (a16) {
            i3 = 4;
        } else {
            i3 = 1;
        }
        pBEnumField.set(i3);
        return openSdkRecCommon$LoginSourceInfo;
    }

    private OpenSdkRecCommon$VersionInfo m(Bundle bundle) {
        OpenSdkRecCommon$VersionInfo openSdkRecCommon$VersionInfo = new OpenSdkRecCommon$VersionInfo();
        openSdkRecCommon$VersionInfo.setHasFlag(true);
        openSdkRecCommon$VersionInfo.sdkv.set(com.tencent.open.agent.util.c.j(bundle, "sdkv", "1.5.9"));
        openSdkRecCommon$VersionInfo.qqv.set(com.tencent.open.adapter.a.f().n());
        PBStringField pBStringField = openSdkRecCommon$VersionInfo.f342465os;
        String str = Build.VERSION.RELEASE;
        if (str == null) {
            str = "";
        }
        pBStringField.set(str);
        return openSdkRecCommon$VersionInfo;
    }

    private boolean n() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool("switch_open_sdk_sso", false);
    }

    private void o(String str) {
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(com.tencent.open.model.a aVar, com.tencent.open.appcommon.d dVar, String str, byte[] bArr, boolean z16, boolean z17) {
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, OpensdkServlet.class);
        newIntent.putExtra("uin", aVar.f341678a);
        newIntent.putExtra("data", bArr);
        newIntent.putExtra("cmd", str);
        newIntent.putExtra("timeout", 15000L);
        newIntent.putExtra("key_support_retry", z16);
        newIntent.putExtra("is_oidb_sso_downgrade", z17);
        newIntent.setObserver(dVar);
        newIntent.setWithouLogin(true);
        MobileQQ.sMobileQQ.peekAppRuntime().startServlet(newIntent);
    }

    private void q(com.tencent.open.model.a aVar, com.tencent.open.appcommon.d dVar, String str, String str2, byte[] bArr, boolean z16) {
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, OpensdkServlet.class);
        newIntent.putExtra("uin", aVar.f341678a);
        newIntent.putExtra("data", bArr);
        newIntent.putExtra("cmd", str);
        newIntent.putExtra("timeout", 15000L);
        newIntent.putExtra("key_support_retry", z16);
        newIntent.setObserver(dVar);
        newIntent.setWithouLogin(true);
        QLog.d(f340113a, 1, "startServlet request by sso for open sdk");
        ((IOpenSigInjectService) QRoute.api(IOpenSigInjectService.class)).commitOpenTicketToMsf(Long.parseLong(aVar.f341678a), new a(newIntent, aVar, dVar, str2, bArr, z16, str));
    }

    @Override // com.tencent.open.agent.auth.model.d
    public void a(CommonReqParams commonReqParams, Object[] objArr, String str, List<SubmitPromotePage$SubmitResultItem> list, ByteStringMicro byteStringMicro, com.tencent.open.appcommon.d dVar) {
        SubmitPromotePage$SubmitPromotePageReq submitPromotePage$SubmitPromotePageReq = new SubmitPromotePage$SubmitPromotePageReq();
        Bundle bundle = commonReqParams.getBundle();
        com.tencent.open.model.a account = commonReqParams.getAccount();
        if (account == null) {
            t.e(f340113a, "submitPromotePage account is null");
            return;
        }
        submitPromotePage$SubmitPromotePageReq.app.set(i(commonReqParams));
        Object obj = objArr[1];
        if (obj instanceof appType$LoginSig) {
            submitPromotePage$SubmitPromotePageReq.login_sig.set((appType$LoginSig) obj);
        }
        submitPromotePage$SubmitPromotePageReq.version.set(m(bundle));
        submitPromotePage$SubmitPromotePageReq.source.set(l(bundle));
        OpenSdkRecCommon$ProxyRequest j3 = j(commonReqParams);
        if (j3 != null) {
            submitPromotePage$SubmitPromotePageReq.proxy_req.set(j3);
        }
        submitPromotePage$SubmitPromotePageReq.session.set(k(str));
        submitPromotePage$SubmitPromotePageReq.signature.set(byteStringMicro);
        submitPromotePage$SubmitPromotePageReq.submit_result.set(list);
        Object obj2 = objArr[0];
        String str2 = (String) obj2;
        if ("QQConnectLogin.submit_promote_page_emp".equals(obj2) && com.tencent.open.agent.util.g.G("QQConnectLogin.submit_promote_page_emp")) {
            QLog.d(f340113a, 1, "getPromotePage use new road");
            q(account, dVar, "QQConnectLogin.submit_promote_page", "QQConnectLogin.submit_promote_page_emp", submitPromotePage$SubmitPromotePageReq.toByteArray(), false);
        } else {
            p(account, dVar, str2, com.tencent.open.agent.util.g.W(submitPromotePage$SubmitPromotePageReq, "QQConnectLogin.submit_promote_page_emp".equals(str2), account), false, false);
        }
    }

    @Override // com.tencent.open.agent.auth.model.d
    public void b(final long j3, final String str, final com.tencent.open.model.a aVar, final boolean z16, final fp3.d dVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.agent.auth.model.NewAuthDataSourceImpl.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("uint64_vuid", j3);
                } catch (JSONException e16) {
                    t.d(NewAuthDataSourceImpl.f340113a, "deleteVirtual.e:", e16);
                }
                OpenSdkVirtualUtil.e("oidb_0xd18_1", str, aVar.f341678a, jSONObject.toString(), dVar, z16);
            }
        }, 128, null, true);
    }

    @Override // com.tencent.open.agent.auth.model.d
    public void c(String str, String str2, String str3, String str4, Bundle bundle, com.tencent.open.model.a aVar, Object[] objArr, com.tencent.open.appcommon.d dVar) {
        o(objArr[0].toString());
        preAuth$PreAuthRequest preauth_preauthrequest = new preAuth$PreAuthRequest();
        preauth_preauthrequest.appid.set(o.c(str2));
        preauth_preauthrequest.sdkp.set(com.tencent.open.agent.util.c.j(bundle, "sdkp", "android"));
        preauth_preauthrequest.sdkv.set(com.tencent.open.agent.util.c.j(bundle, "sdkv", "1.5.9"));
        preauth_preauthrequest.qqv.set(com.tencent.open.adapter.a.f().n());
        PBStringField pBStringField = preauth_preauthrequest.f342475os;
        String str5 = Build.VERSION.RELEASE;
        if (str5 == null) {
            str5 = "";
        }
        pBStringField.set(str5);
        preauth_preauthrequest.scope.set(com.tencent.open.agent.util.c.j(bundle, "scope", "all"));
        preauth_preauthrequest.app_type.set(1);
        preauth_preauthrequest.url_encoded_data.set("support_110509=1&need_new_authorized_union_text=1");
        int i3 = 4;
        if (!TextUtils.isEmpty(str)) {
            preauth_preauthrequest.appUniqueIdentifier.set(str);
            String[] k3 = OpenSdkVirtualUtil.k(str);
            t.b(f340113a, "preAuthWithRetry.getAuthorizeSign sign=", k3[1], ", timestr=", k3[2]);
            if (!TextUtils.isEmpty(k3[1])) {
                preauth_preauthrequest.sign.set(k3[1]);
                if (!TextUtils.isEmpty(k3[2])) {
                    preauth_preauthrequest.md5time.set(o.c(k3[2]));
                }
            }
        }
        boolean a16 = com.tencent.open.agent.util.c.a(bundle, "key_login_by_qr_scan", false);
        PBEnumField pBEnumField = preauth_preauthrequest.referer;
        if (!a16) {
            i3 = 1;
        }
        pBEnumField.set(i3);
        if (!TextUtils.isEmpty(str3)) {
            OpenSdkRecCommon$ProxyRequest openSdkRecCommon$ProxyRequest = new OpenSdkRecCommon$ProxyRequest();
            openSdkRecCommon$ProxyRequest.appid.set(o.c(str3));
            if (str4 != null && !str4.isEmpty()) {
                openSdkRecCommon$ProxyRequest.token.set(ByteStringMicro.copyFromUtf8(str4));
            }
            preauth_preauthrequest.proxy_req.set(openSdkRecCommon$ProxyRequest);
        }
        Object obj = objArr[1];
        if (obj instanceof appType$LoginSig) {
            preauth_preauthrequest.login_sig.set((appType$LoginSig) obj);
        }
        if ("QQConnectLogin.pre_auth_emp".equals(objArr[0]) && com.tencent.open.agent.util.g.G("QQConnectLogin.pre_auth_emp")) {
            q(aVar, dVar, MainService.CMD_PRE_AUTH, "QQConnectLogin.pre_auth_emp", preauth_preauthrequest.toByteArray(), true);
        } else {
            String str6 = (String) objArr[0];
            p(aVar, dVar, str6, com.tencent.open.agent.util.g.W(preauth_preauthrequest, "QQConnectLogin.pre_auth_emp".equals(str6), aVar), true, false);
        }
    }

    @Override // com.tencent.open.agent.auth.model.d
    public void d(Bundle bundle, com.tencent.open.model.a aVar, boolean z16, String str, String str2, String str3, List<hp3.e> list, long j3, String str4, String str5, Object[] objArr, com.tencent.open.appcommon.d dVar) {
        auth$AuthRequest auth_authrequest = new auth$AuthRequest();
        auth_authrequest.appid.set(o.c(str));
        auth_authrequest.need_paytoken.set(1);
        if (list != null && list.size() > 0) {
            for (hp3.e eVar : list) {
                if (eVar.f405825g) {
                    auth_authrequest.openapi.add(Integer.valueOf(eVar.f405824f));
                    t.b(f340113a, "doAuthorize Permission.id=", Integer.valueOf(eVar.f405824f));
                }
            }
        }
        PBStringField pBStringField = auth_authrequest.f342467os;
        String str6 = Build.VERSION.RELEASE;
        if (str6 == null) {
            str6 = "";
        }
        pBStringField.set(str6);
        auth_authrequest.qqv.set(com.tencent.open.adapter.a.f().n());
        auth_authrequest.app_type.set(1);
        auth_authrequest.f342468pf.set(com.tencent.open.agent.util.c.j(bundle, AdParam.PF, "openmobile_android"));
        String string = bundle.getString("sdkp");
        PBStringField pBStringField2 = auth_authrequest.sdkp;
        if (TextUtils.isEmpty(string)) {
            string = "android";
        }
        pBStringField2.set(string);
        String string2 = bundle.getString("sdkv");
        PBStringField pBStringField3 = auth_authrequest.sdkv;
        if (TextUtils.isEmpty(string2)) {
            string2 = "1.5.9";
        }
        pBStringField3.set(string2);
        auth_authrequest.response_type.set(0);
        String i3 = com.tencent.open.agent.util.c.i(bundle, "sign");
        if (!TextUtils.isEmpty(i3)) {
            auth_authrequest.sign.set(i3);
            String i16 = com.tencent.open.agent.util.c.i(bundle, "time");
            if (!TextUtils.isEmpty(i16)) {
                auth_authrequest.md5time.set(o.c(i16));
            }
        } else {
            String[] k3 = OpenSdkVirtualUtil.k(str4);
            String str7 = k3[1];
            String str8 = k3[2];
            t.b(f340113a, "OpenVirtual.doAuthorize.getAuthorizeSign again");
            if (TextUtils.isEmpty(str7)) {
                t.b(f340113a, "OpenVirtual.doAuthorize.getAuthorizeSign sign is null");
            } else {
                auth_authrequest.sign.set(str7);
                if (!TextUtils.isEmpty(str8)) {
                    auth_authrequest.md5time.set(o.c(str8));
                }
            }
        }
        String g16 = com.tencent.open.agent.util.b.g(bundle);
        if (!TextUtils.isEmpty(g16)) {
            auth_authrequest.pass_data.set(g16);
        }
        if (z16) {
            auth_authrequest.referer.set(4);
        }
        auth_authrequest.vid.set(j3);
        OpenSdkRecCommon$ProxyRequest openSdkRecCommon$ProxyRequest = new OpenSdkRecCommon$ProxyRequest();
        openSdkRecCommon$ProxyRequest.appid.set(o.c(str2));
        if (str3 != null && !str3.isEmpty()) {
            openSdkRecCommon$ProxyRequest.token.set(ByteStringMicro.copyFromUtf8(str3));
        }
        auth_authrequest.proxy_auth_req.set(openSdkRecCommon$ProxyRequest);
        if (!TextUtils.isEmpty(str4)) {
            auth_authrequest.app_unique_identifier.set(str4);
        } else {
            t.b(f340113a, "OpenVirtual.doAuthorize.appUniqueIdentifier is null");
        }
        auth_authrequest.state.set(str5);
        Object obj = objArr[1];
        if (obj instanceof appType$LoginSig) {
            auth_authrequest.login_sig.set((appType$LoginSig) obj);
        }
        String str9 = (String) objArr[0];
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, OpensdkServlet.class);
        newIntent.setWithouLogin(true);
        newIntent.putExtra("uin", aVar.f341678a);
        newIntent.putExtra("data", com.tencent.open.agent.util.g.W(auth_authrequest, "QQConnectLogin.auth_emp".equals(str9), aVar));
        newIntent.putExtra("cmd", str9);
        newIntent.setObserver(dVar);
        if ("QQConnectLogin.auth_emp".equals(str9) && com.tencent.open.agent.util.g.G(str9)) {
            q(aVar, dVar, "QQConnectLogin.auth", "QQConnectLogin.auth_emp", auth_authrequest.toByteArray(), false);
        } else {
            MobileQQ.sMobileQQ.waitAppRuntime(null).startServlet(newIntent);
        }
    }

    @Override // com.tencent.open.agent.auth.model.d
    public void e(Bundle bundle, com.tencent.open.model.a aVar, boolean z16, String str, String str2, String str3, List<hp3.e> list, long j3, String str4, Object[] objArr, com.tencent.open.appcommon.d dVar) {
        SdkAuthorize$AuthorizeRequest sdkAuthorize$AuthorizeRequest = new SdkAuthorize$AuthorizeRequest();
        sdkAuthorize$AuthorizeRequest.client_id.set(o.c(str));
        sdkAuthorize$AuthorizeRequest.need_pay.set(1);
        if (list != null && list.size() > 0) {
            for (hp3.e eVar : list) {
                if (eVar.f405825g || eVar.f405819a == 1) {
                    sdkAuthorize$AuthorizeRequest.openapi.add(Integer.valueOf(eVar.f405824f));
                    t.b(f340113a, "doAuthorize Permission.id=", Integer.valueOf(eVar.f405824f));
                }
            }
        }
        PBStringField pBStringField = sdkAuthorize$AuthorizeRequest.f342204os;
        String str5 = Build.VERSION.RELEASE;
        if (str5 == null) {
            str5 = "";
        }
        pBStringField.set(str5);
        sdkAuthorize$AuthorizeRequest.qqv.set(com.tencent.open.adapter.a.f().n());
        sdkAuthorize$AuthorizeRequest.app_type.set(1);
        sdkAuthorize$AuthorizeRequest.f342205pf.set(com.tencent.open.agent.util.c.j(bundle, AdParam.PF, "openmobile_android"));
        String string = bundle.getString("sdkp");
        PBStringField pBStringField2 = sdkAuthorize$AuthorizeRequest.sdkp;
        if (TextUtils.isEmpty(string)) {
            string = "android";
        }
        pBStringField2.set(string);
        String string2 = bundle.getString("sdkv");
        PBStringField pBStringField3 = sdkAuthorize$AuthorizeRequest.sdkv;
        if (TextUtils.isEmpty(string2)) {
            string2 = "1.5.9";
        }
        pBStringField3.set(string2);
        sdkAuthorize$AuthorizeRequest.response_type.set("token");
        String i3 = com.tencent.open.agent.util.c.i(bundle, "sign");
        if (!TextUtils.isEmpty(i3)) {
            sdkAuthorize$AuthorizeRequest.sign.set(i3);
            String i16 = com.tencent.open.agent.util.c.i(bundle, "time");
            if (!TextUtils.isEmpty(i16)) {
                sdkAuthorize$AuthorizeRequest.time.set(o.c(i16));
            }
        } else {
            String[] k3 = OpenSdkVirtualUtil.k(str4);
            String str6 = k3[1];
            String str7 = k3[2];
            t.b(f340113a, "OpenVirtual.doAuthorize.getAuthorizeSign again");
            if (TextUtils.isEmpty(str6)) {
                t.b(f340113a, "OpenVirtual.doAuthorize.getAuthorizeSign sign is null");
            } else {
                sdkAuthorize$AuthorizeRequest.sign.set(str6);
                if (!TextUtils.isEmpty(str7)) {
                    sdkAuthorize$AuthorizeRequest.time.set(o.c(str7));
                }
            }
        }
        String g16 = com.tencent.open.agent.util.b.g(bundle);
        if (!TextUtils.isEmpty(g16)) {
            sdkAuthorize$AuthorizeRequest.passData.set(g16);
        }
        if (z16) {
            sdkAuthorize$AuthorizeRequest.referer.set(4);
        }
        sdkAuthorize$AuthorizeRequest.vID.set(j3);
        com.tencent.open.agent.util.g.U(sdkAuthorize$AuthorizeRequest.url_encoded_data);
        if (!TextUtils.isEmpty(str4)) {
            sdkAuthorize$AuthorizeRequest.appUniqueIdentifier.set(str4);
        } else {
            t.b(f340113a, "OpenVirtual.doAuthorize.appUniqueIdentifier is null");
        }
        Object obj = objArr[1];
        if (obj instanceof appType$LoginSig) {
            sdkAuthorize$AuthorizeRequest.login_sig.set((appType$LoginSig) obj);
        }
        String str8 = (String) objArr[0];
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, OpensdkServlet.class);
        newIntent.setWithouLogin(true);
        newIntent.putExtra("uin", aVar.f341678a);
        newIntent.putExtra("data", com.tencent.open.agent.util.g.W(sdkAuthorize$AuthorizeRequest, BaseConstants.CMD_CONNAUTHSVR_GETAUTHAPI.equals(str8), aVar));
        newIntent.putExtra("cmd", str8);
        OpenSdkVirtualUtil.g(newIntent);
        newIntent.setObserver(dVar);
        if (BaseConstants.CMD_CONNAUTHSVR_GETAUTHAPI.equals(str8) && com.tencent.open.agent.util.g.G(str8)) {
            q(aVar, dVar, "ConnAuthSvr.sdk_auth_api", BaseConstants.CMD_CONNAUTHSVR_GETAUTHAPI, sdkAuthorize$AuthorizeRequest.toByteArray(), false);
        } else {
            MobileQQ.sMobileQQ.waitAppRuntime(null).startServlet(newIntent);
        }
    }

    @Override // com.tencent.open.agent.auth.model.d
    public void f(CommonReqParams commonReqParams, Object[] objArr, String str, boolean z16, com.tencent.open.appcommon.d dVar) {
        GetPromotePage$GetLoginPromotePageReq getPromotePage$GetLoginPromotePageReq = new GetPromotePage$GetLoginPromotePageReq();
        Bundle bundle = commonReqParams.getBundle();
        com.tencent.open.model.a account = commonReqParams.getAccount();
        if (account == null) {
            t.e(f340113a, "getPromotePage account is null");
            return;
        }
        OpenSdkRecCommon$UserTraitInfo openSdkRecCommon$UserTraitInfo = new OpenSdkRecCommon$UserTraitInfo();
        openSdkRecCommon$UserTraitInfo.is_teenager_mode.set(z16);
        getPromotePage$GetLoginPromotePageReq.user_trait.set(openSdkRecCommon$UserTraitInfo);
        getPromotePage$GetLoginPromotePageReq.app.set(i(commonReqParams));
        Object obj = objArr[1];
        if (obj instanceof appType$LoginSig) {
            getPromotePage$GetLoginPromotePageReq.login_sig.set((appType$LoginSig) obj);
        }
        getPromotePage$GetLoginPromotePageReq.version.set(m(bundle));
        getPromotePage$GetLoginPromotePageReq.source.set(l(bundle));
        OpenSdkRecCommon$ProxyRequest j3 = j(commonReqParams);
        if (j3 != null) {
            getPromotePage$GetLoginPromotePageReq.proxy_req.set(j3);
        }
        getPromotePage$GetLoginPromotePageReq.session.set(k(str));
        if ("QQConnectLogin.get_promote_page_emp".equals(objArr[0]) && com.tencent.open.agent.util.g.G("QQConnectLogin.get_promote_page_emp")) {
            QLog.d(f340113a, 1, "getPromotePage use new road");
            q(account, dVar, "QQConnectLogin.get_promote_page", "QQConnectLogin.get_promote_page_emp", getPromotePage$GetLoginPromotePageReq.toByteArray(), false);
        } else {
            String str2 = (String) objArr[0];
            p(account, dVar, str2, com.tencent.open.agent.util.g.W(getPromotePage$GetLoginPromotePageReq, "QQConnectLogin.get_promote_page_emp".equals(str2), account), false, false);
        }
    }
}
