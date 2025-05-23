package com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend;

import com.tencent.mobileqq.activity.aio.stickerrecommended.p;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.ServiceConst;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends p {

    /* renamed from: j, reason: collision with root package name */
    public String f179980j;

    /* renamed from: k, reason: collision with root package name */
    public String f179981k;

    /* renamed from: l, reason: collision with root package name */
    public String f179982l;

    /* renamed from: m, reason: collision with root package name */
    public String f179983m;

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.p
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uin", this.f179980j);
            jSONObject2.put("touin", this.f179981k);
            jSONObject2.put("appid", this.f179965a);
            jSONObject2.put("scene", this.f179982l);
            jSONObject2.put("expose_md5s", this.f179966b);
            jSONObject2.put("expose_urls", this.f179967c);
            jSONObject2.put("click_md5", this.f179968d);
            jSONObject2.put("click_url", this.f179969e);
            jSONObject2.put("aio_type", this.f179983m);
            jSONObject2.put("mobile_type", this.f179970f);
            jSONObject2.put("passthough", this.f179971g);
            jSONObject2.put(ServiceConst.PARA_SESSION_ID, this.f179972h);
            jSONObject.put("dcId", this.f179973i);
            jSONObject.put("data", jSONObject2);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("ScenesRecReportData", 2, "convert error:" + e16);
            }
        }
        return jSONObject;
    }
}
