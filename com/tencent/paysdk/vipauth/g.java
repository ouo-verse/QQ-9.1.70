package com.tencent.paysdk.vipauth;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.paysdk.network.RequestWrapper;
import com.tencent.paysdk.network.VipAuthRequestUtil;
import com.tencent.paysdk.vipauth.requestdata.BaseRequestData;
import com.tencent.paysdk.vipauth.requestdata.VodAuthRequestData;
import com.tencent.paysdk.vipauth.responsedata.VideoPreAuthResponse;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import cooperation.qzone.remote.ServiceConst;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class g extends VideoPreAuthInternal {
    static IPatchRedirector $redirector_;

    public g(@NonNull com.tencent.paysdk.api.c cVar) {
        super(cVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
        }
    }

    @Override // com.tencent.paysdk.vipauth.VideoPreAuthInternal, com.tencent.paysdk.network.c
    public void a(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
        } else {
            com.tencent.paysdk.log.c.b("VodVideoPreAuthInternal", str);
            super.a(i3, str);
        }
    }

    @Override // com.tencent.paysdk.vipauth.VideoPreAuthInternal
    public void c(a<BaseRequestData, VideoPreAuthResponse> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        super.c(aVar);
        RequestWrapper requestWrapper = new RequestWrapper();
        VodAuthRequestData vodAuthRequestData = new VodAuthRequestData();
        this.f342110b.b(vodAuthRequestData);
        vodAuthRequestData.setVid(this.f342111c.c().c().n());
        vodAuthRequestData.setCid(this.f342111c.c().c().b());
        vodAuthRequestData.setLid(this.f342111c.c().c().c());
        vodAuthRequestData.setPlayerPlatform(com.tencent.paysdk.a.l().getAppInfo().a());
        vodAuthRequestData.setAppVersion(com.tencent.paysdk.a.l().getAppInfo().g());
        requestWrapper.d(vodAuthRequestData);
        requestWrapper.e(RequestWrapper.RequestType.POST);
        requestWrapper.f(VipAuthRequestUtil.f342035a);
        VipAuthRequestUtil.INSTANCE.d(requestWrapper, this);
    }

    @Override // com.tencent.paysdk.vipauth.VideoPreAuthInternal
    protected Map<String, Object> d(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Long.valueOf(j3));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("module", "\u4ed8\u8d39\u9274\u6743");
        hashMap.put(ServiceConst.PARA_SESSION_ID, this.f342113e);
        hashMap.put("url", VipAuthRequestUtil.f342035a);
        hashMap.put(QCircleWeakNetReporter.KEY_COST, Long.valueOf(j3));
        hashMap.put("code", Integer.valueOf(i3));
        hashMap.put("vid", this.f342111c.c().c().n());
        hashMap.put("cid", this.f342111c.c().c().b());
        return hashMap;
    }

    @Override // com.tencent.paysdk.vipauth.VideoPreAuthInternal, com.tencent.paysdk.network.c
    public void onFailed(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        com.tencent.paysdk.log.c.a("VodVideoPreAuthInternal", "Video auth failed:\n" + this.f342110b.toString());
        super.onFailed(i3);
    }
}
