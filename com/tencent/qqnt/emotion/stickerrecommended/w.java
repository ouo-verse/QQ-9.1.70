package com.tencent.qqnt.emotion.stickerrecommended;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.ServiceConst;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes24.dex */
public class w extends x {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    public String f356659j;

    /* renamed from: k, reason: collision with root package name */
    public String f356660k;

    /* renamed from: l, reason: collision with root package name */
    public String f356661l;

    /* renamed from: m, reason: collision with root package name */
    public String f356662m;

    public w() {
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
            jSONObject2.put("user_id", this.f356659j);
            jSONObject2.put("keyword", this.f356660k);
            jSONObject2.put("appid", this.f356663a);
            jSONObject2.put("expose_md5s", this.f356664b);
            jSONObject2.put("expose_urls", this.f356665c);
            jSONObject2.put("click_md5", this.f356666d);
            jSONObject2.put("click_url", this.f356667e);
            jSONObject2.put("aio_type", this.f356661l);
            jSONObject2.put("mobile_type", this.f356668f);
            jSONObject2.put("to_user_id", this.f356662m);
            jSONObject2.put("passthough", this.f356669g);
            jSONObject2.put(ServiceConst.PARA_SESSION_ID, this.f356670h);
            jSONObject.put("dcId", this.f356671i);
            jSONObject.put("data", jSONObject2);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("StickerRecReportData", 2, "convert error:" + e16);
            }
        }
        return jSONObject;
    }
}
