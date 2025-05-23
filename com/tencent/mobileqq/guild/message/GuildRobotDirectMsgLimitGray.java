package com.tencent.mobileqq.guild.message;

import com.tencent.mobileqq.data.ChatMessage;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildRobotDirectMsgLimitGray extends ChatMessage {
    private String guildId;
    private String robotName;
    private String robotTid;
    private String robotUin;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        if (this.msgData != null) {
            try {
                JSONObject jSONObject = new JSONObject(new String(this.msgData));
                this.guildId = jSONObject.optString("guildId");
                this.robotTid = jSONObject.optString("robotTid");
                this.robotUin = jSONObject.optString("robotUin");
                this.robotName = jSONObject.optString("robotName");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    public String getGuildId() {
        return this.guildId;
    }

    public String getRobotName() {
        return this.robotName;
    }

    public String getRobotTid() {
        return this.robotTid;
    }

    public String getRobotUin() {
        return this.robotUin;
    }

    public void init(String str, String str2, String str3, String str4) {
        this.robotTid = str2;
        this.guildId = str;
        this.robotUin = str3;
        this.robotName = str4;
        prewrite();
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
            jSONObject.put("robotTid", this.robotTid);
            jSONObject.put("guildId", this.guildId);
            jSONObject.put("robotUin", this.robotUin);
            jSONObject.put("robotName", this.robotName);
            this.msgData = jSONObject.toString().getBytes();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
