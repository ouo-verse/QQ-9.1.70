package kn1;

import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0016JI\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bH\u00c6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\n\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR%\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010 \u001a\u0004\b\u0019\u0010!\u00a8\u0006$"}, d2 = {"Lkn1/b;", "", "", "toString", "", "isNewFeed", "mainTaskId", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildTaskProgressState;", "taskState", "", "extra", "a", "", "hashCode", "other", "equals", "Z", "g", "()Z", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "c", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "e", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildTaskProgressState;", "f", "()Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildTaskProgressState;", "Ljava/util/Map;", "()Ljava/util/Map;", "<init>", "(ZLjava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildTaskProgressState;Ljava/util/Map;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: kn1.b, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class FeedPublishStateV2 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isNewFeed;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String taskId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GProStFeed stFeed;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GuildTaskProgressState taskState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Object> extra;

    public FeedPublishStateV2(boolean z16, @NotNull String mainTaskId, @NotNull GProStFeed stFeed, @NotNull GuildTaskProgressState taskState, @NotNull Map<String, ? extends Object> extra) {
        Intrinsics.checkNotNullParameter(mainTaskId, "mainTaskId");
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        Intrinsics.checkNotNullParameter(taskState, "taskState");
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.isNewFeed = z16;
        this.taskId = mainTaskId;
        this.stFeed = stFeed;
        this.taskState = taskState;
        this.extra = extra;
    }

    public static /* synthetic */ FeedPublishStateV2 b(FeedPublishStateV2 feedPublishStateV2, boolean z16, String str, GProStFeed gProStFeed, GuildTaskProgressState guildTaskProgressState, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = feedPublishStateV2.isNewFeed;
        }
        if ((i3 & 2) != 0) {
            str = feedPublishStateV2.taskId;
        }
        String str2 = str;
        if ((i3 & 4) != 0) {
            gProStFeed = feedPublishStateV2.stFeed;
        }
        GProStFeed gProStFeed2 = gProStFeed;
        if ((i3 & 8) != 0) {
            guildTaskProgressState = feedPublishStateV2.taskState;
        }
        GuildTaskProgressState guildTaskProgressState2 = guildTaskProgressState;
        if ((i3 & 16) != 0) {
            map = feedPublishStateV2.extra;
        }
        return feedPublishStateV2.a(z16, str2, gProStFeed2, guildTaskProgressState2, map);
    }

    @NotNull
    public final FeedPublishStateV2 a(boolean isNewFeed, @NotNull String mainTaskId, @NotNull GProStFeed stFeed, @NotNull GuildTaskProgressState taskState, @NotNull Map<String, ? extends Object> extra) {
        Intrinsics.checkNotNullParameter(mainTaskId, "mainTaskId");
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        Intrinsics.checkNotNullParameter(taskState, "taskState");
        Intrinsics.checkNotNullParameter(extra, "extra");
        return new FeedPublishStateV2(isNewFeed, mainTaskId, stFeed, taskState, extra);
    }

    @NotNull
    public final Map<String, Object> c() {
        return this.extra;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final GProStFeed getStFeed() {
        return this.stFeed;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedPublishStateV2)) {
            return false;
        }
        FeedPublishStateV2 feedPublishStateV2 = (FeedPublishStateV2) other;
        if (this.isNewFeed == feedPublishStateV2.isNewFeed && Intrinsics.areEqual(this.taskId, feedPublishStateV2.taskId) && Intrinsics.areEqual(this.stFeed, feedPublishStateV2.stFeed) && Intrinsics.areEqual(this.taskState, feedPublishStateV2.taskState) && Intrinsics.areEqual(this.extra, feedPublishStateV2.extra)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final GuildTaskProgressState getTaskState() {
        return this.taskState;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsNewFeed() {
        return this.isNewFeed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        boolean z16 = this.isNewFeed;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((((((r06 * 31) + this.taskId.hashCode()) * 31) + this.stFeed.hashCode()) * 31) + this.taskState.hashCode()) * 31) + this.extra.hashCode();
    }

    @NotNull
    public String toString() {
        return "FeedPublishStateV2(taskId='" + this.taskId + "', stFeed=" + com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.l(this.stFeed) + ", taskState=" + this.taskState + ")";
    }

    public /* synthetic */ FeedPublishStateV2(boolean z16, String str, GProStFeed gProStFeed, GuildTaskProgressState guildTaskProgressState, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, str, gProStFeed, guildTaskProgressState, (i3 & 16) != 0 ? new LinkedHashMap() : map);
    }
}
