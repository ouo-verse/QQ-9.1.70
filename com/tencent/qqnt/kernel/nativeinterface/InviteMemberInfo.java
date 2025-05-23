package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class InviteMemberInfo {
    public long groupCode;
    public String uid = "";
    public String nick = "";

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getNick() {
        return this.nick;
    }

    public String getUid() {
        return this.uid;
    }

    public String toString() {
        return "InviteMemberInfo{uid=" + this.uid + ",nick=" + this.nick + ",groupCode=" + this.groupCode + ",}";
    }
}
