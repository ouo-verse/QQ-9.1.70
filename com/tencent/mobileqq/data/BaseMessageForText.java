package com.tencent.mobileqq.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class BaseMessageForText extends RecommendCommonMessage implements com.tencent.mobileqq.reminder.db.b {
    @Override // com.tencent.mobileqq.reminder.db.b
    public final int getExtLong() {
        return this.extLong;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    @Nullable
    public final String getExtStr() {
        return this.extStr;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    @Nullable
    public final String getFrienduin() {
        return this.frienduin;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final boolean getIsread() {
        return this.isread;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final int getIstroop() {
        return this.istroop;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    @Nullable
    public final JSONObject getMExJsonObject() {
        return this.mExJsonObject;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    @Nullable
    public String getMsg() {
        return this.f203106msg;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    @Nullable
    public final byte[] getMsgData() {
        return this.msgData;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final int getMsgtype() {
        return this.msgtype;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    @NonNull
    public final String getSelfuin() {
        return this.selfuin;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    @Nullable
    public final String getSenderuin() {
        return this.senderuin;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final long getUniseq() {
        return this.uniseq;
    }

    public final void setExtLong(int i3) {
        this.extLong = i3;
    }

    public final void setExtStr(@Nullable String str) {
        this.extStr = str;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final void setFrienduin(@Nullable String str) {
        this.frienduin = str;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final void setIsread(boolean z16) {
        this.isread = z16;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final void setIstroop(int i3) {
        this.istroop = i3;
    }

    public final void setMExJsonObject(@Nullable JSONObject jSONObject) {
        this.mExJsonObject = jSONObject;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final void setMsg(@Nullable String str) {
        this.f203106msg = str;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final void setMsgData(@Nullable byte[] bArr) {
        this.msgData = bArr;
    }

    public final void setMsgtype(int i3) {
        this.msgtype = i3;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final void setSelfuin(@NonNull String str) {
        this.selfuin = str;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final void setSenderuin(@Nullable String str) {
        this.senderuin = str;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final void setTime(long j3) {
        this.time = j3;
    }

    public final void setUniseq(long j3) {
        this.uniseq = j3;
    }
}
