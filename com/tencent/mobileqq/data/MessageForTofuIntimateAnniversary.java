package com.tencent.mobileqq.data;

import android.graphics.Color;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForTofuIntimateAnniversary extends ChatMessage {
    public String bgUrl;
    public long bindTime;
    public long frdUin;
    public int inimateType;
    public int level;
    public int txtColor;
    public int years;

    public MessageForTofuIntimateAnniversary() {
        this.msgtype = -7009;
        this.mNeedTimeStamp = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        try {
            JSONObject jSONObject = new JSONObject(this.f203106msg);
            this.inimateType = jSONObject.optInt("key_type", -1);
            this.frdUin = jSONObject.optLong("key_frd_uin", 0L);
            this.bindTime = jSONObject.optLong("key_bind_time", 0L);
            this.years = jSONObject.optInt("key_anniversary_years", 0);
            this.level = jSONObject.optInt("key_inimate_level", 0);
            this.bgUrl = jSONObject.optString("key_bg_url", "");
            this.txtColor = Color.parseColor(jSONObject.optString("key_txt_clr", "#000"));
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
