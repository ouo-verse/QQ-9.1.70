package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class InviteInfo {
    public String fromUid;
    public int inviteType;
    public long relationId;

    public InviteInfo() {
        this.fromUid = "";
    }

    public String getFromUid() {
        return this.fromUid;
    }

    public int getInviteType() {
        return this.inviteType;
    }

    public long getRelationId() {
        return this.relationId;
    }

    public String toString() {
        return "InviteInfo{relationId=" + this.relationId + ",inviteType=" + this.inviteType + ",fromUid=" + this.fromUid + ",}";
    }

    public InviteInfo(long j3, int i3, String str) {
        this.relationId = j3;
        this.inviteType = i3;
        this.fromUid = str;
    }
}
