package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class EmojiZPlan {
    public int actionId;
    public String actionName;
    public int actionType;
    public String bytesReserveInfo;
    public long peerUid;
    public int playerNumber;

    public EmojiZPlan() {
        this.actionName = "";
        this.bytesReserveInfo = "";
    }

    public int getActionId() {
        return this.actionId;
    }

    public String getActionName() {
        return this.actionName;
    }

    public int getActionType() {
        return this.actionType;
    }

    public String getBytesReserveInfo() {
        return this.bytesReserveInfo;
    }

    public long getPeerUid() {
        return this.peerUid;
    }

    public int getPlayerNumber() {
        return this.playerNumber;
    }

    public String toString() {
        return "EmojiZPlan{actionId=" + this.actionId + ",actionName=" + this.actionName + ",actionType=" + this.actionType + ",playerNumber=" + this.playerNumber + ",peerUid=" + this.peerUid + ",bytesReserveInfo=" + this.bytesReserveInfo + ",}";
    }

    public EmojiZPlan(int i3, String str, int i16, int i17, long j3, String str2) {
        this.actionId = i3;
        this.actionName = str;
        this.actionType = i16;
        this.playerNumber = i17;
        this.peerUid = j3;
        this.bytesReserveInfo = str2;
    }
}
