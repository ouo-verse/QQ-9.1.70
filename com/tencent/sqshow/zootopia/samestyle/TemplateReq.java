package com.tencent.sqshow.zootopia.samestyle;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0017\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "f", "()J", "tabId", "b", "I", "()I", "pageIndex", "c", "perPageNum", "d", "playerNum", "e", "contentType", "sortType", "<init>", "(JIIIII)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.samestyle.e, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class TemplateReq {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long tabId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int pageIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int perPageNum;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int playerNum;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int contentType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int sortType;

    public TemplateReq() {
        this(0L, 0, 0, 0, 0, 0, 63, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getContentType() {
        return this.contentType;
    }

    /* renamed from: b, reason: from getter */
    public final int getPageIndex() {
        return this.pageIndex;
    }

    /* renamed from: c, reason: from getter */
    public final int getPerPageNum() {
        return this.perPageNum;
    }

    /* renamed from: d, reason: from getter */
    public final int getPlayerNum() {
        return this.playerNum;
    }

    /* renamed from: e, reason: from getter */
    public final int getSortType() {
        return this.sortType;
    }

    /* renamed from: f, reason: from getter */
    public final long getTabId() {
        return this.tabId;
    }

    public int hashCode() {
        return (((((((((com.tencent.mobileqq.vas.banner.c.a(this.tabId) * 31) + this.pageIndex) * 31) + this.perPageNum) * 31) + this.playerNum) * 31) + this.contentType) * 31) + this.sortType;
    }

    public String toString() {
        return "TemplateReq(tabId=" + this.tabId + ", pageIndex=" + this.pageIndex + ", perPageNum=" + this.perPageNum + ", playerNum=" + this.playerNum + ", contentType=" + this.contentType + ", sortType=" + this.sortType + ")";
    }

    public TemplateReq(long j3, int i3, int i16, int i17, int i18, int i19) {
        this.tabId = j3;
        this.pageIndex = i3;
        this.perPageNum = i16;
        this.playerNum = i17;
        this.contentType = i18;
        this.sortType = i19;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TemplateReq)) {
            return false;
        }
        TemplateReq templateReq = (TemplateReq) other;
        return this.tabId == templateReq.tabId && this.pageIndex == templateReq.pageIndex && this.perPageNum == templateReq.perPageNum && this.playerNum == templateReq.playerNum && this.contentType == templateReq.contentType && this.sortType == templateReq.sortType;
    }

    public /* synthetic */ TemplateReq(long j3, int i3, int i16, int i17, int i18, int i19, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this((i26 & 1) != 0 ? 0L : j3, (i26 & 2) != 0 ? 1 : i3, (i26 & 4) != 0 ? 50 : i16, (i26 & 8) != 0 ? 0 : i17, (i26 & 16) != 0 ? 2 : i18, (i26 & 32) == 0 ? i19 : 0);
    }
}
