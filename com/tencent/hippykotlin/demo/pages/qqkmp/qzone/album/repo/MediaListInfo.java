package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.repo;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/repo/MediaListInfo;", "", "()V", "mediasIndex", "", "getMediasIndex", "()I", "setMediasIndex", "(I)V", "nextAttachInfo", "", "getNextAttachInfo", "()Ljava/lang/String;", "setNextAttachInfo", "(Ljava/lang/String;)V", "nextHasMore", "", "getNextHasMore", "()Z", "setNextHasMore", "(Z)V", "prevAttachInfo", "getPrevAttachInfo", "setPrevAttachInfo", "prevHasMore", "getPrevHasMore", "setPrevHasMore", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public class MediaListInfo {
    public static final int $stable = 8;
    private int mediasIndex;
    private boolean nextHasMore;
    private boolean prevHasMore;
    private String prevAttachInfo = "";
    private String nextAttachInfo = "";

    public final int getMediasIndex() {
        return this.mediasIndex;
    }

    public final String getNextAttachInfo() {
        return this.nextAttachInfo;
    }

    public final boolean getNextHasMore() {
        return this.nextHasMore;
    }

    public final String getPrevAttachInfo() {
        return this.prevAttachInfo;
    }

    public final boolean getPrevHasMore() {
        return this.prevHasMore;
    }

    public final void setMediasIndex(int i3) {
        this.mediasIndex = i3;
    }

    public final void setNextAttachInfo(String str) {
        this.nextAttachInfo = str;
    }

    public final void setNextHasMore(boolean z16) {
        this.nextHasMore = z16;
    }

    public final void setPrevAttachInfo(String str) {
        this.prevAttachInfo = str;
    }

    public final void setPrevHasMore(boolean z16) {
        this.prevHasMore = z16;
    }
}
