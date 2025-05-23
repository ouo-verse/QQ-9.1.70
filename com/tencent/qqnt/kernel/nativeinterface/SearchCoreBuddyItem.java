package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchCoreBuddyItem {
    public String nick;
    public String remark;
    public String uid = "";
    public long uin;

    public String getNick() {
        return this.nick;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getUid() {
        return this.uid;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "SearchCoreBuddyItem{uid=" + this.uid + ",uin=" + this.uin + ",nick=" + this.nick + ",remark=" + this.remark + ",}";
    }
}
