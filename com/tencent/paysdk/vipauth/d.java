package com.tencent.paysdk.vipauth;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.paysdk.network.RequestWrapper;
import com.tencent.paysdk.network.VipAuthRequestUtil;
import com.tencent.paysdk.vipauth.requestdata.BaseRequestData;
import com.tencent.paysdk.vipauth.requestdata.LiveAuthRequestData;
import com.tencent.paysdk.vipauth.responsedata.VideoPreAuthResponse;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import cooperation.qzone.remote.ServiceConst;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d extends VideoPreAuthInternal {
    static IPatchRedirector $redirector_;

    public d(@NonNull @NotNull com.tencent.paysdk.api.c cVar) {
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
            com.tencent.paysdk.log.c.b("LiveVideoPreAuthInternal", str);
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
        LiveAuthRequestData liveAuthRequestData = new LiveAuthRequestData();
        this.f342110b.b(liveAuthRequestData);
        liveAuthRequestData.setPid(this.f342111c.c().c().d());
        liveAuthRequestData.setChid(this.f342111c.c().c().a());
        liveAuthRequestData.setPlayerPlatform(com.tencent.paysdk.a.l().getAppInfo().a());
        liveAuthRequestData.setAppVersion(com.tencent.paysdk.a.l().getAppInfo().g());
        requestWrapper.d(liveAuthRequestData);
        requestWrapper.e(RequestWrapper.RequestType.POST);
        requestWrapper.f(VipAuthRequestUtil.f342036b);
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
        hashMap.put("url", VipAuthRequestUtil.f342036b);
        hashMap.put(QCircleWeakNetReporter.KEY_COST, Long.valueOf(j3));
        hashMap.put("code", Integer.valueOf(i3));
        hashMap.put("pid", this.f342111c.c().c().d());
        hashMap.put("chid", this.f342111c.c().c().a());
        return hashMap;
    }

    @Override // com.tencent.paysdk.vipauth.VideoPreAuthInternal, com.tencent.paysdk.network.c
    public void onFailed(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        com.tencent.paysdk.log.c.a("LiveVideoPreAuthInternal", "Video auth failed:\n" + this.f342110b.toString());
        super.onFailed(i3);
    }
}
