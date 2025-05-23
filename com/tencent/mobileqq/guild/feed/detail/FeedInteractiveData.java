package com.tencent.mobileqq.guild.feed.detail;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0011\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/detail/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "preferStatus", "b", "preferCount", "commentCount", "d", "shareCount", "<init>", "(IIII)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.feed.detail.b, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class FeedInteractiveData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int preferStatus;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int preferCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int commentCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int shareCount;

    public FeedInteractiveData() {
        this(0, 0, 0, 0, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getCommentCount() {
        return this.commentCount;
    }

    /* renamed from: b, reason: from getter */
    public final int getPreferCount() {
        return this.preferCount;
    }

    /* renamed from: c, reason: from getter */
    public final int getPreferStatus() {
        return this.preferStatus;
    }

    /* renamed from: d, reason: from getter */
    public final int getShareCount() {
        return this.shareCount;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedInteractiveData)) {
            return false;
        }
        FeedInteractiveData feedInteractiveData = (FeedInteractiveData) other;
        if (this.preferStatus == feedInteractiveData.preferStatus && this.preferCount == feedInteractiveData.preferCount && this.commentCount == feedInteractiveData.commentCount && this.shareCount == feedInteractiveData.shareCount) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.preferStatus * 31) + this.preferCount) * 31) + this.commentCount) * 31) + this.shareCount;
    }

    @NotNull
    public String toString() {
        return "FeedInteractiveData(preferStatus=" + this.preferStatus + ", preferCount=" + this.preferCount + ", commentCount=" + this.commentCount + ", shareCount=" + this.shareCount + ")";
    }

    public FeedInteractiveData(int i3, int i16, int i17, int i18) {
        this.preferStatus = i3;
        this.preferCount = i16;
        this.commentCount = i17;
        this.shareCount = i18;
    }

    public /* synthetic */ FeedInteractiveData(int i3, int i16, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? 0 : i3, (i19 & 2) != 0 ? 0 : i16, (i19 & 4) != 0 ? 0 : i17, (i19 & 8) != 0 ? 0 : i18);
    }
}
