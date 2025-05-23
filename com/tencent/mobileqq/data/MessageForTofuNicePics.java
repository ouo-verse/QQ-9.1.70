package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class MessageForTofuNicePics extends ChatMessage {
    public int countInc;
    public long frdUin;
    public long upTime;
    public String url1;
    public String url2;

    public MessageForTofuNicePics() {
        this.msgtype = -7011;
        this.mNeedTimeStamp = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        try {
            JSONObject jSONObject = new JSONObject(this.f203106msg);
            this.upTime = jSONObject.optInt("key_nice_pics_ts");
            this.countInc = jSONObject.optInt("key_nice_pics_count", 0);
            this.url1 = jSONObject.optString("key_nice_pics_url_1", "");
            this.url2 = jSONObject.optString("key_nice_pics_url_2", "");
            this.frdUin = jSONObject.optLong("key_frd_uin", 0L);
        } catch (JSONException e16) {
            QLog.d("MessageForTofuInimateAnniversary", 1, "doParse", e16);
        } catch (Exception e17) {
            QLog.d("MessageForTofuInimateAnniversary", 1, "doParse", e17);
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("MessageForTofuInimateAnniversary", 4, "doParse:" + this.f203106msg);
        }
        this.isread = true;
    }
}
