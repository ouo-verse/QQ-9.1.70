package jl1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Ljl1/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "feedId", "b", "I", "()I", "c", "(I)V", "type", "<init>", "(Ljava/lang/String;I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: jl1.e, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class CommentRankingTypeData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String feedId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int type;

    public CommentRankingTypeData(@NotNull String feedId, int i3) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        this.feedId = feedId;
        this.type = i3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    /* renamed from: b, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public final void c(int i3) {
        this.type = i3;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommentRankingTypeData)) {
            return false;
        }
        CommentRankingTypeData commentRankingTypeData = (CommentRankingTypeData) other;
        if (Intrinsics.areEqual(this.feedId, commentRankingTypeData.feedId) && this.type == commentRankingTypeData.type) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.feedId.hashCode() * 31) + this.type;
    }

    @NotNull
    public String toString() {
        return "CommentRankingTypeData(feedId=" + this.feedId + ", type=" + this.type + ")";
    }
}
