package com.tencent.open.agent.auth.model;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.agent.util.o;
import com.tencent.open.agent.util.t;
import com.tencent.open.appcommon.OpensdkServlet;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.protofile.getappinfo.GetAppInfoProto$GetAppinfoRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize$AuthorizeRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize$GetAuthApiListRequest;
import com.tencent.qconn.protofile.appType$LoginSig;
import com.tencent.qphone.base.BaseConstants;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes22.dex */
public class i implements e {

    /* renamed from: a, reason: collision with root package name */
    private static String f340164a = "OldAuthorityDataSourceImpl";

    @Override // com.tencent.open.agent.auth.model.e
    public void a(Bundle bundle, com.tencent.open.model.a aVar, Object[] objArr, com.tencent.open.appcommon.d dVar) {
        SdkAuthorize$GetAuthApiListRequest sdkAuthorize$GetAuthApiListRequest = new SdkAuthorize$GetAuthApiListRequest();
        sdkAuthorize$GetAuthApiListRequest.client_id.set(o.c(bundle.getString(CommonConstant.ReqAccessTokenParam.CLIENT_ID)));
        PBStringField pBStringField = sdkAuthorize$GetAuthApiListRequest.f342208os;
        String str = Build.VERSION.RELEASE;
        if (str == null) {
            str = "";
        }
        pBStringField.set(str);
        sdkAuthorize$GetAuthApiListRequest.qqv.set(com.tencent.open.adapter.a.f().n());
        sdkAuthorize$GetAuthApiListRequest.app_type.set(1);
        sdkAuthorize$GetAuthApiListRequest.f342209pf.set(com.tencent.open.agent.util.c.j(bundle, AdParam.PF, ""));
        sdkAuthorize$GetAuthApiListRequest.scope.set(com.tencent.open.agent.util.c.j(bundle, "scope", ""));
        if (bundle.getBoolean("key_login_by_qr_scan", false)) {
            sdkAuthorize$GetAuthApiListRequest.referer.set(4);
        }
        String string = bundle.getString("sdkv");
        PBStringField pBStringField2 = sdkAuthorize$GetAuthApiListRequest.sdkv;
        if (TextUtils.isEmpty(string)) {
            string = "1.5.9";
        }
        pBStringField2.set(string);
        String string2 = bundle.getString("sdkp");
        PBStringField pBStringField3 = sdkAuthorize$GetAuthApiListRequest.sdkp;
        if (TextUtils.isEmpty(string2)) {
            string2 = "android";
        }
        pBStringField3.set(string2);
        String string3 = bundle.getString("sign");
        if (!TextUtils.isEmpty(string3)) {
            sdkAuthorize$GetAuthApiListRequest.sign.set(string3);
            String string4 = bundle.getString("time");
            if (!TextUtils.isEmpty(string4)) {
                sdkAuthorize$GetAuthApiListRequest.time.set(o.c(string4));
            }
        }
        sdkAuthorize$GetAuthApiListRequest.need_pay.set(1);
        String h16 = com.tencent.open.agent.util.c.h(bundle);
        if (!TextUtils.isEmpty(h16)) {
            sdkAuthorize$GetAuthApiListRequest.appUniqueIdentifier.set(h16);
        }
        com.tencent.open.agent.util.g.U(sdkAuthorize$GetAuthApiListRequest.url_encoded_data);
        Object obj = objArr[1];
        if (obj instanceof appType$LoginSig) {
            sdkAuthorize$GetAuthApiListRequest.login_sig.set((appType$LoginSig) obj);
        }
        String str2 = (String) objArr[0];
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, OpensdkServlet.class);
        newIntent.setWithouLogin(true);
        newIntent.putExtra("uin", aVar.f341678a);
        newIntent.putExtra("data", com.tencent.open.agent.util.g.W(sdkAuthorize$GetAuthApiListRequest, BaseConstants.CMD_CONNAUTHSVR_GETAUTHAPILIST.equals(str2), aVar));
        newIntent.putExtra("cmd", str2);
        newIntent.setObserver(dVar);
        MobileQQ.sMobileQQ.peekAppRuntime().startServlet(newIntent);
    }

    @Override // com.tencent.open.agent.auth.model.e
    public void b(List<hp3.e> list, Bundle bundle, com.tencent.open.model.a aVar, Object[] objArr, com.tencent.open.appcommon.d dVar) {
        SdkAuthorize$AuthorizeRequest sdkAuthorize$AuthorizeRequest = new SdkAuthorize$AuthorizeRequest();
        sdkAuthorize$AuthorizeRequest.client_id.set(o.c(bundle.getString(CommonConstant.ReqAccessTokenParam.CLIENT_ID)));
        sdkAuthorize$AuthorizeRequest.need_pay.set(1);
        for (hp3.e eVar : list) {
            if (eVar.f405819a > 0) {
                sdkAuthorize$AuthorizeRequest.openapi.add(Integer.valueOf(eVar.f405824f));
            }
        }
        PBStringField pBStringField = sdkAuthorize$AuthorizeRequest.f342204os;
        String str = Build.VERSION.RELEASE;
        if (str == null) {
            str = "";
        }
        pBStringField.set(str);
        sdkAuthorize$AuthorizeRequest.app_type.set(1);
        sdkAuthorize$AuthorizeRequest.qqv.set(com.tencent.open.adapter.a.f().n());
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
        String h16 = com.tencent.open.agent.util.c.h(bundle);
        if (!TextUtils.isEmpty(h16)) {
            sdkAuthorize$AuthorizeRequest.appUniqueIdentifier.set(h16);
        } else {
            t.b(f340164a, "doAuthorize.appUniqueIdentifier is null");
        }
        String string3 = bundle.getString("sign");
        if (!TextUtils.isEmpty(string3)) {
            sdkAuthorize$AuthorizeRequest.sign.set(string3);
            String string4 = bundle.getString("time");
            if (!TextUtils.isEmpty(string4)) {
                sdkAuthorize$AuthorizeRequest.time.set(o.c(string4));
            }
        } else {
            String[] k3 = OpenSdkVirtualUtil.k(h16);
            String str2 = k3[1];
            String str3 = k3[2];
            t.b(f340164a, "doAuthorize.getAuthorizeSign again");
            if (TextUtils.isEmpty(str2)) {
                t.b(f340164a, "doAuthorize.getAuthorizeSign sign is null");
            } else {
                sdkAuthorize$AuthorizeRequest.sign.set(str2);
                if (!TextUtils.isEmpty(str3)) {
                    sdkAuthorize$AuthorizeRequest.time.set(o.c(str3));
                }
            }
        }
        String g16 = com.tencent.open.agent.util.b.g(bundle);
        if (!TextUtils.isEmpty(g16)) {
            sdkAuthorize$AuthorizeRequest.passData.set(g16);
        }
        Object obj = objArr[1];
        if (obj instanceof appType$LoginSig) {
            sdkAuthorize$AuthorizeRequest.login_sig.set((appType$LoginSig) obj);
        }
        com.tencent.open.agent.util.g.U(sdkAuthorize$AuthorizeRequest.url_encoded_data);
        String str4 = (String) objArr[0];
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, OpensdkServlet.class);
        newIntent.setWithouLogin(true);
        newIntent.putExtra("uin", aVar.f341678a);
        newIntent.putExtra("data", com.tencent.open.agent.util.g.W(sdkAuthorize$AuthorizeRequest, BaseConstants.CMD_CONNAUTHSVR_GETAUTHAPI.equals(str4), aVar));
        newIntent.putExtra("cmd", str4);
        OpenSdkVirtualUtil.g(newIntent);
        newIntent.setObserver(dVar);
        MobileQQ.sMobileQQ.peekAppRuntime().startServlet(newIntent);
    }

    @Override // com.tencent.open.agent.auth.model.e
    public void c(Bundle bundle, com.tencent.open.model.a aVar, Object[] objArr, com.tencent.open.appcommon.d dVar) {
        long c16 = o.c(com.tencent.open.agent.util.c.i(bundle, CommonConstant.ReqAccessTokenParam.CLIENT_ID));
        GetAppInfoProto$GetAppinfoRequest getAppInfoProto$GetAppinfoRequest = new GetAppInfoProto$GetAppinfoRequest();
        getAppInfoProto$GetAppinfoRequest.client_id.set(c16);
        getAppInfoProto$GetAppinfoRequest.sdkp.set(com.tencent.open.agent.util.c.j(bundle, "sdkp", "android"));
        PBStringField pBStringField = getAppInfoProto$GetAppinfoRequest.f342196os;
        String str = Build.VERSION.RELEASE;
        if (str == null) {
            str = "";
        }
        pBStringField.set(str);
        getAppInfoProto$GetAppinfoRequest.qqv.set(com.tencent.open.adapter.a.f().n());
        getAppInfoProto$GetAppinfoRequest.app_type.set(1);
        getAppInfoProto$GetAppinfoRequest.setHasFlag(true);
        getAppInfoProto$GetAppinfoRequest.need_ads.set(1);
        String h16 = com.tencent.open.agent.util.c.h(bundle);
        if (!TextUtils.isEmpty(h16)) {
            getAppInfoProto$GetAppinfoRequest.appUniqueIdentifier.set(h16);
        }
        getAppInfoProto$GetAppinfoRequest.referer.set(1);
        Object obj = objArr[1];
        if (obj instanceof appType$LoginSig) {
            getAppInfoProto$GetAppinfoRequest.login_sig.set((appType$LoginSig) obj);
        }
        String str2 = (String) objArr[0];
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, OpensdkServlet.class);
        newIntent.setWithouLogin(true);
        newIntent.putExtra("uin", aVar.f341678a);
        newIntent.putExtra("data", com.tencent.open.agent.util.g.W(getAppInfoProto$GetAppinfoRequest, BaseConstants.CMD_CONNAUTHSVR_GETAPPINFO.equals(str2), aVar));
        newIntent.putExtra("cmd", str2);
        newIntent.setObserver(dVar);
        MobileQQ.sMobileQQ.peekAppRuntime().startServlet(newIntent);
    }
}
