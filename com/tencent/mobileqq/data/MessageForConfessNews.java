package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForConfessNews extends ChatMessage {
    public static final String TAG = "MessageForConfessNews";
    public long confessTime;
    public int nBGType;
    public int nBizType;
    public int nConfessNum;
    public int nConfessorSex;
    public int nGetConfessSex;
    public int nRecNickType;
    public int nTopicId;
    public String strConfessorDesc;
    public String strConfessorNick;
    public String strConfessorUin;
    public String strGroupUin;
    public String strRecNick;
    public String strRecUin;

    public MessageForConfessNews() {
        this.msgtype = MessageRecord.MSG_TYPE_CONFESS_NEWS;
        this.mNeedTimeStamp = false;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        try {
            JSONObject jSONObject = new JSONObject(this.f203106msg);
            this.nTopicId = jSONObject.optInt("nTopicId");
            this.nBGType = jSONObject.optInt("nBGType");
            this.nConfessorSex = jSONObject.optInt("nConfessorSex");
            this.strRecUin = jSONObject.optString("strRecUin");
            this.strRecNick = jSONObject.optString("strRecNick");
            this.strConfessorUin = jSONObject.optString("strConfessorUin");
            this.strConfessorDesc = jSONObject.optString("strConfessorDesc");
            this.strConfessorNick = jSONObject.optString("strConfessorNick");
            this.confessTime = jSONObject.optLong("confessTime");
            this.strGroupUin = jSONObject.optString("strGroupUin");
            this.nRecNickType = jSONObject.optInt("nRecNickType");
            if (jSONObject.has("nConfessNum")) {
                this.nConfessNum = jSONObject.optInt("nConfessNum");
            }
            if (jSONObject.has("nBizType")) {
                this.nBizType = jSONObject.optInt("nBizType");
            }
            if (jSONObject.has("nGetConfessSex")) {
                this.nGetConfessSex = jSONObject.optInt("nGetConfessSex");
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "doParse", e16);
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, String.format(Locale.getDefault(), "doParse: %s", this.f203106msg));
        }
        int i3 = this.istroop;
        if (i3 == 1033 || i3 == 0 || i3 == 1) {
            this.isread = true;
        }
    }
}
