package com.tencent.mobileqq.guild.message;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.message.directmessage.model.data.DirectMessageNode;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes14.dex */
public class MessageRecordForDirectMessageWelcome extends ChatMessage implements st1.i {
    private String channelId;
    private String guildId;
    private int guildTotal;
    private JSONArray guildUrls;
    private String robotName;
    private String robotTid;
    private String selfTid;
    private final String showMsg = HardCodeUtil.qqStr(R.string.f142280iy);

    private JSONArray convert(ArrayList<String> arrayList) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(it.next());
        }
        return jSONArray;
    }

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
                this.guildUrls = jSONObject.optJSONArray("guildUrls");
                this.guildTotal = jSONObject.optInt("guildTotal");
                this.robotName = jSONObject.optString("robotName");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        this.f203106msg = this.showMsg;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public int getCommonGuildCount() {
        return this.guildTotal;
    }

    public JSONArray getCommonGuildUrls() {
        return this.guildUrls;
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

    public String getSelfTid() {
        return this.selfTid;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        return this.showMsg;
    }

    public String getTips(AppRuntime appRuntime) {
        if (TextUtils.isEmpty(this.robotName)) {
            DirectMessageNode C = DirectMessageNodeRepository.C(getChannelId());
            if (C != null) {
                this.robotName = C.getSource().getNickName();
            } else {
                this.robotName = appRuntime.getApplicationContext().getString(R.string.f139460bb);
            }
        }
        return String.format(appRuntime.getApplicationContext().getString(R.string.f153651co), this.robotName);
    }

    public void initWelcome(String str, String str2, String str3, String str4, ArrayList<String> arrayList, int i3) {
        this.selfTid = str;
        this.robotTid = str2;
        this.channelId = str3;
        this.guildId = str4;
        this.guildUrls = convert(arrayList);
        this.guildTotal = i3;
        this.robotName = "";
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
            jSONObject.put("robotTid", this.robotTid);
            jSONObject.put("channelId", this.channelId);
            jSONObject.put("guildId", this.guildId);
            jSONObject.put("guildUrls", this.guildUrls);
            jSONObject.put("guildTotal", this.guildTotal);
            jSONObject.put("robotName", this.robotName);
            this.msgData = jSONObject.toString().getBytes();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void setRobotName(String str) {
        this.robotName = str;
    }
}
