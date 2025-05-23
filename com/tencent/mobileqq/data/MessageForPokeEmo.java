package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.AppConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class MessageForPokeEmo extends ChatMessage {
    public static final int POP_EMO_BUSSINESS_TYPE = 13;
    public String emoCompat;
    public String emoString;
    public int pokeemoId;
    public int pokeemoPressCount;
    public String summary;
    public boolean isNeedPlayed = false;
    public int emoIndex = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        if (this.msgData != null) {
            try {
                JSONObject jSONObject = new JSONObject(new String(this.msgData));
                this.pokeemoId = jSONObject.getInt("pokeemoId");
                this.pokeemoPressCount = jSONObject.getInt("pokeemoPressCount");
                this.summary = jSONObject.getString("summary");
                this.f203106msg = jSONObject.getString("msg");
                if (jSONObject.has(AppConstants.Key.COLUMN_IS_READ)) {
                    this.isread = jSONObject.getBoolean(AppConstants.Key.COLUMN_IS_READ);
                }
                if (jSONObject.has("emoIndex") && this.pokeemoId == 13) {
                    this.emoIndex = jSONObject.getInt("emoIndex");
                    this.emoString = jSONObject.getString("emoString");
                    this.emoCompat = jSONObject.getString("emoCompat");
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    public void initMsg() {
        if (this.pokeemoId == 13 && this.emoIndex >= 0) {
            this.f203106msg = String.format("[%s]x%d", this.emoCompat, Integer.valueOf(this.pokeemoPressCount));
        } else {
            this.f203106msg = String.format("[%s]x%d", this.summary, Integer.valueOf(this.pokeemoPressCount));
        }
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public boolean isSupportReply() {
        return true;
    }

    @Override // com.tencent.mobileqq.data.MessageRecord
    public boolean needVipBubble() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        parse();
    }

    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pokeemoId", this.pokeemoId);
            jSONObject.put("pokeemoPressCount", this.pokeemoPressCount);
            jSONObject.put("summary", this.summary);
            jSONObject.put("msg", this.f203106msg);
            jSONObject.put(AppConstants.Key.COLUMN_IS_READ, this.isread);
            int i3 = this.emoIndex;
            if (i3 >= 0 && this.pokeemoId == 13) {
                jSONObject.put("emoIndex", i3);
                String str = this.emoString;
                String str2 = "";
                if (str == null) {
                    str = "";
                }
                jSONObject.put("emoString", str);
                String str3 = this.emoCompat;
                if (str3 != null) {
                    str2 = str3;
                }
                jSONObject.put("emoCompat", str2);
            }
            this.msgData = jSONObject.toString().getBytes();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void setIsNeedPlayed(boolean z16) {
        this.isNeedPlayed = z16;
    }
}
