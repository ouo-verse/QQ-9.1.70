package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class MessageForPLNews extends ChatMessage {
    public static final String TAG = "MessageForPLNews";
    public int bgColor;
    public String cover;
    public long personalityTagId;
    public String text;

    /* renamed from: ts, reason: collision with root package name */
    public long f203101ts;

    public MessageForPLNews() {
        this.msgtype = MessageRecord.MSG_TYPE_PL_NEWS;
        this.mNeedTimeStamp = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        try {
            JSONObject jSONObject = new JSONObject(this.f203106msg);
            this.personalityTagId = jSONObject.optInt("personalityTagId", -1);
            this.text = jSONObject.optString("text");
            this.bgColor = jSONObject.optInt("bgColor");
            this.cover = jSONObject.optString("cover");
            this.f203101ts = jSONObject.optLong("ts");
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "doParse", e16);
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, "doParse:" + this.f203106msg);
        }
        this.isread = true;
    }

    public boolean isKoiOrPKTag() {
        if (!com.tencent.relation.common.config.toggle.c.f364708u.g(false)) {
            return false;
        }
        long j3 = this.personalityTagId;
        if (j3 < 1000 || j3 > 1015) {
            return false;
        }
        return true;
    }

    public boolean msgEquals(MessageForPLNews messageForPLNews) {
        if (messageForPLNews.uniseq == this.uniseq) {
            return true;
        }
        return false;
    }
}
