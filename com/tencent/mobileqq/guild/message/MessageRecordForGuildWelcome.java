package com.tencent.mobileqq.guild.message;

import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes14.dex */
public class MessageRecordForGuildWelcome extends ChatMessage implements st1.j {
    public int channelType;
    public String channelUin;
    public String guildUin;
    public String showMsg = HardCodeUtil.qqStr(R.string.f142280iy);
    public int textChannelSubtypeId;
    public int welcomeType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        if (this.msgData != null) {
            try {
                JSONObject jSONObject = new JSONObject(new String(this.msgData));
                this.welcomeType = jSONObject.optInt("welcomeType");
                this.channelType = jSONObject.optInt("channelType");
                this.textChannelSubtypeId = jSONObject.optInt("textChannelSubtypeId");
                this.channelUin = jSONObject.optString("channelUin");
                this.guildUin = jSONObject.optString("guildUin");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        this.f203106msg = this.showMsg;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public String getChannelUin() {
        return this.channelUin;
    }

    public String getGuildUin() {
        return this.guildUin;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        return this.showMsg;
    }

    public int getTextChannelSubtypeId() {
        return this.textChannelSubtypeId;
    }

    public CharSequence getTitle(AppRuntime appRuntime) {
        String string;
        int welcomeType = getWelcomeType();
        if (welcomeType != 1 && welcomeType != 2 && welcomeType != 3 && welcomeType != 4) {
            return "";
        }
        IGProChannelInfo channelInfo = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getChannelInfo(getChannelUin());
        if (channelInfo != null) {
            string = channelInfo.getChannelName();
        } else {
            string = appRuntime.getApplicationContext().getString(R.string.f142300j0);
        }
        String string2 = appRuntime.getApplicationContext().getString(R.string.f158531pv);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) string2).append((CharSequence) " ").append((CharSequence) string);
        spannableStringBuilder.setSpan(new StyleSpan(1), 0, spannableStringBuilder.length(), 18);
        return spannableStringBuilder;
    }

    public int getWelcomeType() {
        return this.welcomeType;
    }

    public void init(int i3, int i16, int i17, String str, String str2) {
        this.welcomeType = i3;
        this.channelType = i16;
        this.textChannelSubtypeId = i17;
        this.channelUin = str;
        this.guildUin = str2;
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
            jSONObject.put("welcomeType", this.welcomeType);
            jSONObject.put("channelType", this.channelType);
            jSONObject.put("textChannelSubtypeId", this.textChannelSubtypeId);
            jSONObject.put("channelUin", this.channelUin);
            jSONObject.put("guildUin", this.guildUin);
            this.msgData = jSONObject.toString().getBytes();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
