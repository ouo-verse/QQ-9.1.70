package com.tencent.mobileqq.guild.message;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.ChatMessage;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes14.dex */
public class MessageRecordForBlackRobotGray extends ChatMessage {
    private String channelId;
    private String guildId;
    private boolean isBlackRobot;
    private String robotTid;
    private String selfTid;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        if (this.msgData != null) {
            try {
                JSONObject jSONObject = new JSONObject(new String(this.msgData));
                this.selfTid = jSONObject.optString("selfTid");
                this.robotTid = jSONObject.optString("robotTid");
                this.channelId = jSONObject.optString("channelId");
                this.guildId = jSONObject.optString("guildId");
                this.isBlackRobot = jSONObject.optBoolean("isBlackRobot");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public String getRobotTid() {
        return this.robotTid;
    }

    public String getSelfTid() {
        return this.selfTid;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        return HardCodeUtil.qqStr(R.string.f140790ex);
    }

    public void initBlackRobotGray(String str, String str2, String str3, String str4) {
        this.selfTid = str;
        this.robotTid = str2;
        this.channelId = str3;
        this.guildId = str4;
        prewrite();
    }

    public boolean isBlackRobot() {
        return this.isBlackRobot;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        parse();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("selfTid", this.selfTid);
            jSONObject.put("robotTid", this.robotTid);
            jSONObject.put("channelId", this.channelId);
            jSONObject.put("guildId", this.guildId);
            jSONObject.put("isBlackRobot", this.isBlackRobot);
            this.msgData = jSONObject.toString().getBytes();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void setBlackRobot(boolean z16) {
        this.isBlackRobot = z16;
    }
}
