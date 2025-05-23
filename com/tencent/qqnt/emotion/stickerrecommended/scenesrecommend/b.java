package com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.stickerrecommended.x;
import cooperation.qzone.remote.ServiceConst;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes24.dex */
public class b extends x {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    public String f356628j;

    /* renamed from: k, reason: collision with root package name */
    public String f356629k;

    /* renamed from: l, reason: collision with root package name */
    public String f356630l;

    /* renamed from: m, reason: collision with root package name */
    public String f356631m;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.x
    public JSONObject a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uin", this.f356628j);
            jSONObject2.put("touin", this.f356629k);
            jSONObject2.put("appid", this.f356663a);
            jSONObject2.put("scene", this.f356630l);
            jSONObject2.put("expose_md5s", this.f356664b);
            jSONObject2.put("expose_urls", this.f356665c);
            jSONObject2.put("click_md5", this.f356666d);
            jSONObject2.put("click_url", this.f356667e);
            jSONObject2.put("aio_type", this.f356631m);
            jSONObject2.put("mobile_type", this.f356668f);
            jSONObject2.put("passthough", this.f356669g);
            jSONObject2.put(ServiceConst.PARA_SESSION_ID, this.f356670h);
            jSONObject.put("dcId", this.f356671i);
            jSONObject.put("data", jSONObject2);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("ScenesRecReportData", 2, "convert error:" + e16);
            }
        }
        return jSONObject;
    }
}
