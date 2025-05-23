package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForMedalNews extends ChatMessage {
    public static final String TAG = "MessageForMedalNews";
    public String desc;
    public String icon;

    /* renamed from: id, reason: collision with root package name */
    public int f203090id;
    public int level;
    public int myLevel;
    public String name;
    public long seq;

    /* renamed from: ts, reason: collision with root package name */
    public long f203091ts;

    public MessageForMedalNews() {
        this.msgtype = MessageRecord.MSG_TYPE_MEDAL_NEWS;
        this.mNeedTimeStamp = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        try {
            JSONObject jSONObject = new JSONObject(this.f203106msg);
            this.name = jSONObject.optString("name");
            this.desc = jSONObject.optString("desc");
            this.level = jSONObject.optInt("level");
            this.icon = jSONObject.optString("icon");
            this.f203091ts = jSONObject.optLong("ts");
            this.seq = jSONObject.optLong("seq");
            this.myLevel = jSONObject.optInt("myLevel");
            this.f203090id = jSONObject.optInt("id");
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

    public boolean msgEquals(MessageForMedalNews messageForMedalNews) {
        if (messageForMedalNews.uniseq == this.uniseq) {
            return true;
        }
        return false;
    }
}
