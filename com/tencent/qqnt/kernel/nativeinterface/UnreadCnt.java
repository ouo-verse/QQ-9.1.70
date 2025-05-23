package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UnreadCnt {
    public int cnt;
    public int type;

    public UnreadCnt() {
    }

    public int getCnt() {
        return this.cnt;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "UnreadCnt{type=" + this.type + ",cnt=" + this.cnt + ",}";
    }

    public UnreadCnt(int i3, int i16) {
        this.type = i3;
        this.cnt = i16;
    }
}
