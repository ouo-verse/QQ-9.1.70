package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class NearbyProUnreadInfo {
    public long unreadCnt;

    public NearbyProUnreadInfo() {
    }

    public long getUnreadCnt() {
        return this.unreadCnt;
    }

    public String toString() {
        return "NearbyProUnreadInfo{unreadCnt=" + this.unreadCnt + ",}";
    }

    public NearbyProUnreadInfo(long j3) {
        this.unreadCnt = j3;
    }
}
