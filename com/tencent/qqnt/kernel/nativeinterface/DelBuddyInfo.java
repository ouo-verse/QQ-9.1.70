package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DelBuddyInfo {
    public String friendUid;
    public boolean tempBlock;
    public boolean tempBothDel;

    public DelBuddyInfo() {
        this.friendUid = "";
    }

    public String getFriendUid() {
        return this.friendUid;
    }

    public boolean getTempBlock() {
        return this.tempBlock;
    }

    public boolean getTempBothDel() {
        return this.tempBothDel;
    }

    public DelBuddyInfo(String str, boolean z16, boolean z17) {
        this.friendUid = str;
        this.tempBlock = z16;
        this.tempBothDel = z17;
    }
}
