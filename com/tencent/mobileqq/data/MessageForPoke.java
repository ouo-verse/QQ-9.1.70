package com.tencent.mobileqq.data;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class MessageForPoke extends ChatMessage {
    public static final int INTERACT_TYPE_APPROVE = 3;
    public static final int INTERACT_TYPE_GIVING_HEART = 2;
    public static final int INTERACT_TYPE_GREAT_MOVE = 6;
    public static final int INTERACT_TYPE_HEART_BREAK = 4;
    public static final int INTERACT_TYPE_HI_TOGETHER = 5;
    public static final int INTERACT_TYPE_POKE = 1;
    public static final int INTERACT_TYPE_POKE_OLD = 0;
    public static final int INTERACT_TYPE_VAS_POKE = 126;
    public static final int POKE_FLAG_BREAKING_ICE_FRD_NEW = 8;
    public static final int POKE_FLAG_BREAKING_ICE_FRD_OLD = 16;

    @Deprecated
    public static final int POKE_FLAG_BREAKING_ICE_POKE = 1;

    @Deprecated
    public static final int POKE_FLAG_BREAKING_ICE_POKE_ACK = 2;
    public String minVersion;
    public String name;
    public boolean isPlayed = false;
    public boolean hasQuickBackShowed = false;
    public int interactType = 0;
    public int doubleHitState = 0;
    public Drawable.ConstantState mBubbleBgState = null;
    public CustomFrameAnimationDrawable.a mFrameState = new CustomFrameAnimationDrawable.a();
    public int subId = -1;
    public int strength = 0;
    public int flag = 0;
    public int state = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        if (this.msgData != null) {
            try {
                JSONObject jSONObject = new JSONObject(new String(this.msgData));
                this.interactType = jSONObject.getInt("interactType");
                this.isPlayed = jSONObject.getBoolean("isPlayed");
                this.f203106msg = jSONObject.getString("msg");
                this.doubleHitState = jSONObject.getInt("doubltHit");
                this.subId = jSONObject.getInt("subId");
                this.name = jSONObject.getString("name");
                this.minVersion = jSONObject.getString("minVersion");
                this.strength = jSONObject.getInt("strength");
                this.flag = jSONObject.optInt("flag", 0);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    public void initMsg() {
        int i3 = this.interactType;
        if (i3 != 126) {
            switch (i3) {
                case 1:
                    this.f203106msg = HardCodeUtil.qqStr(R.string.o2_);
                    return;
                case 2:
                    this.f203106msg = HardCodeUtil.qqStr(R.string.o1p);
                    return;
                case 3:
                    this.f203106msg = HardCodeUtil.qqStr(R.string.o1q);
                    return;
                case 4:
                    this.f203106msg = HardCodeUtil.qqStr(R.string.o1d);
                    return;
                case 5:
                    this.f203106msg = "[666]";
                    return;
                case 6:
                    this.f203106msg = HardCodeUtil.qqStr(R.string.o1s);
                    return;
                default:
                    this.f203106msg = HardCodeUtil.qqStr(R.string.o2e);
                    return;
            }
        }
        this.f203106msg = "[" + this.name + "]";
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("interactType", this.interactType);
            jSONObject.put("isPlayed", this.isPlayed);
            jSONObject.put("msg", this.f203106msg);
            jSONObject.put("doubltHit", this.doubleHitState);
            jSONObject.put("subId", this.subId);
            jSONObject.put("name", this.name);
            jSONObject.put("minVersion", this.minVersion);
            jSONObject.put("strength", this.strength);
            jSONObject.put("flag", this.flag);
            this.msgData = jSONObject.toString().getBytes();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void setPlayed(QQAppInterface qQAppInterface) {
        if (!this.isPlayed) {
            this.isPlayed = true;
            prewrite();
            qQAppInterface.getMessageFacade().Y0(this.frienduin, this.istroop, this.uniseq, this.msgData);
        }
    }
}
