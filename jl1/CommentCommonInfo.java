package jl1;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0014\u0010\u000eR\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0017\u0010\u000eR\"\u0010\u001d\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u0016\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Ljl1/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "e", "()I", "setTotalReplyCount", "(I)V", "totalReplyCount", "b", "c", "setLocalReplyListCount", "localReplyListCount", "f", "expandReplyListCount", "d", "g", "itemGroupPosition", "Z", "()Z", "setNextPageReply", "(Z)V", "nextPageReply", "<init>", "(IIIIZ)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: jl1.a, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class CommentCommonInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int totalReplyCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int localReplyListCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int expandReplyListCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int itemGroupPosition;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean nextPageReply;

    public CommentCommonInfo(int i3, int i16, int i17, int i18, boolean z16) {
        this.totalReplyCount = i3;
        this.localReplyListCount = i16;
        this.expandReplyListCount = i17;
        this.itemGroupPosition = i18;
        this.nextPageReply = z16;
    }

    /* renamed from: a, reason: from getter */
    public final int getExpandReplyListCount() {
        return this.expandReplyListCount;
    }

    /* renamed from: b, reason: from getter */
    public final int getItemGroupPosition() {
        return this.itemGroupPosition;
    }

    /* renamed from: c, reason: from getter */
    public final int getLocalReplyListCount() {
        return this.localReplyListCount;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getNextPageReply() {
        return this.nextPageReply;
    }

    /* renamed from: e, reason: from getter */
    public final int getTotalReplyCount() {
        return this.totalReplyCount;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommentCommonInfo)) {
            return false;
        }
        CommentCommonInfo commentCommonInfo = (CommentCommonInfo) other;
        if (this.totalReplyCount == commentCommonInfo.totalReplyCount && this.localReplyListCount == commentCommonInfo.localReplyListCount && this.expandReplyListCount == commentCommonInfo.expandReplyListCount && this.itemGroupPosition == commentCommonInfo.itemGroupPosition && this.nextPageReply == commentCommonInfo.nextPageReply) {
            return true;
        }
        return false;
    }

    public final void f(int i3) {
        this.expandReplyListCount = i3;
    }

    public final void g(int i3) {
        this.itemGroupPosition = i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = ((((((this.totalReplyCount * 31) + this.localReplyListCount) * 31) + this.expandReplyListCount) * 31) + this.itemGroupPosition) * 31;
        boolean z16 = this.nextPageReply;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return i3 + i16;
    }

    @NotNull
    public String toString() {
        return "CommentCommonInfo(totalReplyCount=" + this.totalReplyCount + ", localReplyListCount=" + this.localReplyListCount + ", expandReplyListCount=" + this.expandReplyListCount + ", itemGroupPosition=" + this.itemGroupPosition + ", nextPageReply=" + this.nextPageReply + ")";
    }
}
