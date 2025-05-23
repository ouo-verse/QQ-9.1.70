package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MediaListInfo {
    public int mediasIndex;
    public String nextAttachInfo;
    public boolean nextHasMore;
    public String prevAttachInfo;
    public boolean prevHasMore;

    public MediaListInfo() {
        this.prevAttachInfo = "";
        this.nextAttachInfo = "";
    }

    public int getMediasIndex() {
        return this.mediasIndex;
    }

    public String getNextAttachInfo() {
        return this.nextAttachInfo;
    }

    public boolean getNextHasMore() {
        return this.nextHasMore;
    }

    public String getPrevAttachInfo() {
        return this.prevAttachInfo;
    }

    public boolean getPrevHasMore() {
        return this.prevHasMore;
    }

    public MediaListInfo(String str, String str2, boolean z16, boolean z17, int i3) {
        this.prevAttachInfo = str;
        this.nextAttachInfo = str2;
        this.prevHasMore = z16;
        this.nextHasMore = z17;
        this.mediasIndex = i3;
    }
}
