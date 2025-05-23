package com.tencent.mobileqq.guild.message;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.ChatMessage;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildMsgNotifySettingGray extends ChatMessage {
    private String channelId;
    private String guildId;
    private String selfTid;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        if (this.msgData != null) {
            try {
                JSONObject jSONObject = new JSONObject(new String(this.msgData));
                this.selfTid = jSONObject.optString("selfTid");
                this.channelId = jSONObject.optString("channelId");
                this.guildId = jSONObject.optString("guildId");
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

    @Override // com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        return HardCodeUtil.qqStr(R.string.f15048154) + HardCodeUtil.qqStr(R.string.f15049155);
    }

    public void init(String str, String str2, String str3) {
        this.selfTid = str;
        this.channelId = str2;
        this.guildId = str3;
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
            jSONObject.put("selfTid", this.selfTid);
            jSONObject.put("channelId", this.channelId);
            jSONObject.put("guildId", this.guildId);
            this.msgData = jSONObject.toString().getBytes();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
