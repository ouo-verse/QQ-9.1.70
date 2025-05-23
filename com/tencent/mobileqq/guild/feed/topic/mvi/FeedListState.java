package com.tencent.mobileqq.guild.feed.topic.mvi;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0010\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b(\u0010)JO\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0012\b\u0002\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\b2\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR!\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001eR\u0017\u0010\n\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b\u001f\u0010\u001bR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0019\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010'\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/mvi/a;", "Lcom/tencent/mobileqq/guild/feed/mvi/b;", "Lri1/a;", "success", "", "loadingMore", "Lcom/tencent/mobileqq/guild/feed/topic/h;", "Lvn1/b;", "Lcom/tencent/mobileqq/guild/feed/topic/TopicFeedList;", "feedList", "finish", "", "scrollPos", "needInsertAnimator", "a", "", "toString", "hashCode", "", "other", "equals", "Lri1/a;", tl.h.F, "()Lri1/a;", "b", "Z", "e", "()Z", "c", "Lcom/tencent/mobileqq/guild/feed/topic/h;", "()Lcom/tencent/mobileqq/guild/feed/topic/h;", "d", "I", "g", "()I", "j", "(I)V", "f", "i", "(Z)V", "<init>", "(Lri1/a;ZLcom/tencent/mobileqq/guild/feed/topic/h;ZIZ)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.feed.topic.mvi.a, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class FeedListState implements com.tencent.mobileqq.guild.feed.mvi.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ri1.a success;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean loadingMore;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.topic.h<vn1.b> feedList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean finish;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int scrollPos;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean needInsertAnimator;

    public FeedListState(@NotNull ri1.a success, boolean z16, @NotNull com.tencent.mobileqq.guild.feed.topic.h<vn1.b> feedList, boolean z17, int i3, boolean z18) {
        Intrinsics.checkNotNullParameter(success, "success");
        Intrinsics.checkNotNullParameter(feedList, "feedList");
        this.success = success;
        this.loadingMore = z16;
        this.feedList = feedList;
        this.finish = z17;
        this.scrollPos = i3;
        this.needInsertAnimator = z18;
    }

    public static /* synthetic */ FeedListState b(FeedListState feedListState, ri1.a aVar, boolean z16, com.tencent.mobileqq.guild.feed.topic.h hVar, boolean z17, int i3, boolean z18, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            aVar = feedListState.success;
        }
        if ((i16 & 2) != 0) {
            z16 = feedListState.loadingMore;
        }
        boolean z19 = z16;
        if ((i16 & 4) != 0) {
            hVar = feedListState.feedList;
        }
        com.tencent.mobileqq.guild.feed.topic.h hVar2 = hVar;
        if ((i16 & 8) != 0) {
            z17 = feedListState.finish;
        }
        boolean z26 = z17;
        if ((i16 & 16) != 0) {
            i3 = feedListState.scrollPos;
        }
        int i17 = i3;
        if ((i16 & 32) != 0) {
            z18 = feedListState.needInsertAnimator;
        }
        return feedListState.a(aVar, z19, hVar2, z26, i17, z18);
    }

    @NotNull
    public final FeedListState a(@NotNull ri1.a success, boolean loadingMore, @NotNull com.tencent.mobileqq.guild.feed.topic.h<vn1.b> feedList, boolean finish, int scrollPos, boolean needInsertAnimator) {
        Intrinsics.checkNotNullParameter(success, "success");
        Intrinsics.checkNotNullParameter(feedList, "feedList");
        return new FeedListState(success, loadingMore, feedList, finish, scrollPos, needInsertAnimator);
    }

    @NotNull
    public final com.tencent.mobileqq.guild.feed.topic.h<vn1.b> c() {
        return this.feedList;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getFinish() {
        return this.finish;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getLoadingMore() {
        return this.loadingMore;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedListState)) {
            return false;
        }
        FeedListState feedListState = (FeedListState) other;
        if (Intrinsics.areEqual(this.success, feedListState.success) && this.loadingMore == feedListState.loadingMore && Intrinsics.areEqual(this.feedList, feedListState.feedList) && this.finish == feedListState.finish && this.scrollPos == feedListState.scrollPos && this.needInsertAnimator == feedListState.needInsertAnimator) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getNeedInsertAnimator() {
        return this.needInsertAnimator;
    }

    /* renamed from: g, reason: from getter */
    public final int getScrollPos() {
        return this.scrollPos;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final ri1.a getSuccess() {
        return this.success;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.success.hashCode() * 31;
        boolean z16 = this.loadingMore;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int hashCode2 = (((hashCode + i16) * 31) + this.feedList.hashCode()) * 31;
        boolean z17 = this.finish;
        int i17 = z17;
        if (z17 != 0) {
            i17 = 1;
        }
        int i18 = (((hashCode2 + i17) * 31) + this.scrollPos) * 31;
        boolean z18 = this.needInsertAnimator;
        if (!z18) {
            i3 = z18 ? 1 : 0;
        }
        return i18 + i3;
    }

    public final void i(boolean z16) {
        this.needInsertAnimator = z16;
    }

    public final void j(int i3) {
        this.scrollPos = i3;
    }

    @NotNull
    public String toString() {
        return "FeedListState(success=" + this.success + ", loadingMore=" + this.loadingMore + ", feedList=" + this.feedList + ", finish=" + this.finish + ", scrollPos=" + this.scrollPos + ", needInsertAnimator=" + this.needInsertAnimator + ")";
    }

    public /* synthetic */ FeedListState(ri1.a aVar, boolean z16, com.tencent.mobileqq.guild.feed.topic.h hVar, boolean z17, int i3, boolean z18, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, z16, hVar, (i16 & 8) != 0 ? false : z17, (i16 & 16) != 0 ? -1 : i3, (i16 & 32) != 0 ? false : z18);
    }
}
