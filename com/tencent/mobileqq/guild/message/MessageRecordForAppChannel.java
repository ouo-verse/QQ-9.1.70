package com.tencent.mobileqq.guild.message;

import android.text.TextUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes14.dex */
public class MessageRecordForAppChannel extends ChatMessage {
    private static final String KEY_EXPIRE_TIME_MS = "expireTimeMs";
    public static final String KEY_GUILD_APP_CHANNEL_NOTIFY = "guild_app_channel_notify";
    private static final String KEY_GUILD_SCHEDULE_APP_CHANNEL = "guild_scheduler_app_channel";
    private static final String KEY_MSG = "msg";
    private static final String KEY_SCHEMA = "schema";
    private static final String KEY_SCHEMA_TYPE = "schemaType";
    private static final String KEY_SUMMARY = "summary";
    private static final String TAG = "MessageRecordForAppChannel";
    public long expireTimeMs;
    public boolean isStrongNotify;
    public String schema;
    public int schemaType;
    public String summary;

    public MessageRecordForAppChannel() {
        this.msgtype = MessageRecord.MSG_TYPE_GUILD_APP_CHANNEL;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        try {
            String extInfoFromExtStr = getExtInfoFromExtStr(KEY_GUILD_SCHEDULE_APP_CHANNEL);
            if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                JSONObject jSONObject = new JSONObject(extInfoFromExtStr);
                if (TextUtils.isEmpty(this.f203106msg)) {
                    this.f203106msg = jSONObject.getString("msg");
                }
                this.expireTimeMs = jSONObject.getLong(KEY_EXPIRE_TIME_MS);
                this.summary = jSONObject.getString("summary");
                if (this.expireTimeMs > NetConnInfoCenter.getServerTimeMillis()) {
                    this.schema = jSONObject.getString("schema");
                    this.schemaType = jSONObject.getInt(KEY_SCHEMA_TYPE);
                    this.isStrongNotify = "1".equals(getExtInfoFromExtStr(KEY_GUILD_APP_CHANNEL_NOTIFY));
                }
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 1, "msg:" + this.f203106msg + ".summary:" + this.summary + ",expireTimeMs:" + this.expireTimeMs + ",schema:" + this.schema + ",isStrongNotify:" + this.isStrongNotify);
                }
            }
        } catch (Exception e16) {
            QLog.i(TAG, 1, "exception\uff1a" + e16.toString());
            e16.printStackTrace();
        }
    }

    public void saveData() {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("msg", this.f203106msg);
            jSONObject.put("summary", this.summary);
            jSONObject.put(KEY_EXPIRE_TIME_MS, this.expireTimeMs);
            jSONObject.put("schema", this.schema);
            jSONObject.put(KEY_SCHEMA_TYPE, this.schemaType);
            saveExtInfoToExtStr(KEY_GUILD_SCHEDULE_APP_CHANNEL, jSONObject.toString());
            if (this.isStrongNotify) {
                str = "1";
            } else {
                str = "0";
            }
            saveExtInfoToExtStr(KEY_GUILD_APP_CHANNEL_NOTIFY, str);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "MessageRecordForAppChannel save:" + jSONObject.toString());
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public MessageRecordForAppChannel(MsgRecord msgRecord) {
        parse();
    }
}
