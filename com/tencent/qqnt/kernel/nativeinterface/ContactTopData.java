package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ContactTopData {
    public int chatType;
    public long groupCode;
    public String uid;
    public long uin;

    public ContactTopData() {
        this.uid = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getUid() {
        return this.uid;
    }

    public long getUin() {
        return this.uin;
    }

    public void setChatType(int i3) {
        this.chatType = i3;
    }

    public void setGroupCode(long j3) {
        this.groupCode = j3;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUin(long j3) {
        this.uin = j3;
    }

    public String toString() {
        return "ContactTopData{chatType=" + this.chatType + ",uin=" + this.uin + ",uid=" + this.uid + ",groupCode=" + this.groupCode + ",}";
    }

    public ContactTopData(int i3, long j3, String str, long j16) {
        this.chatType = i3;
        this.uin = j3;
        this.uid = str;
        this.groupCode = j16;
    }
}
