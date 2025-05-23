package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProUnreadCnt {
    public int cnt;
    public int type;

    public GProUnreadCnt() {
    }

    public int getCnt() {
        return this.cnt;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProUnreadCnt{type=" + this.type + ",cnt=" + this.cnt + ",}";
    }

    public GProUnreadCnt(int i3, int i16) {
        this.type = i3;
        this.cnt = i16;
    }
}
