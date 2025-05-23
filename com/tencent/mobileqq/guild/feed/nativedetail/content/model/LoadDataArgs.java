package com.tencent.mobileqq.guild.feed.nativedetail.content.model;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.oskplayer.proxy.VideoProxy;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u0012\b\b\u0002\u0010 \u001a\u00020\u001c\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010+\u001a\u00020\u0002\u0012\b\b\u0002\u0010,\u001a\u00020\u0002\u0012\u000e\b\u0002\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020-\u0012\b\b\u0002\u00102\u001a\u00020\u001c\u0012\b\b\u0002\u00104\u001a\u00020\u0004\u0012\b\b\u0002\u00109\u001a\u00020\u0007\u00a2\u0006\u0004\b:\u0010;J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u000bR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\u000bR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\u000bR\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010 \u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001fR\u0019\u0010&\u001a\u0004\u0018\u00010!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010)\u001a\u0004\u0018\u00010!8\u0006\u00a2\u0006\f\n\u0004\b'\u0010#\u001a\u0004\b(\u0010%R\u0017\u0010+\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b*\u0010\n\u001a\u0004\b\"\u0010\u000bR\u0017\u0010,\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b$\u0010\n\u001a\u0004\b*\u0010\u000bR\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020-8\u0006\u00a2\u0006\f\n\u0004\b(\u0010.\u001a\u0004\b'\u0010/R\u0017\u00102\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001e\u001a\u0004\b1\u0010\u001fR\u0017\u00104\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b1\u0010\u0016\u001a\u0004\b3\u0010\u0018R\"\u00109\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u00105\u001a\u0004\b\u0012\u00106\"\u0004\b7\u00108\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/w;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "callSource", "b", "d", "feedId", "c", "e", "guildId", "channelId", "I", "l", "()I", "o", "(I)V", "rankingType", "", "f", "J", "()J", "lastModifiedTime", "Ljava/io/Serializable;", "g", "Ljava/io/Serializable;", "j", "()Ljava/io/Serializable;", "originRecommendFeedData", tl.h.F, "k", "originStFeedData", "i", "needInsertCommentID", "needInsertReplyID", "", "Ljava/util/List;", "()Ljava/util/List;", "needInsertCommentIDS", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "startTime", "getBusinessType", "businessType", "Z", "()Z", "setEnableCache", "(Z)V", VideoProxy.PARAM_ENABLE_CACHE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/io/Serializable;Ljava/io/Serializable;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JIZ)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.content.model.w, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class LoadDataArgs {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String callSource;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String feedId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int rankingType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final long lastModifiedTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Serializable originRecommendFeedData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Serializable originStFeedData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String needInsertCommentID;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String needInsertReplyID;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<String> needInsertCommentIDS;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private final long startTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private final int businessType;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean enableCache;

    public LoadDataArgs(@NotNull String callSource, @NotNull String feedId, @NotNull String guildId, @NotNull String channelId, int i3, long j3, @Nullable Serializable serializable, @Nullable Serializable serializable2, @NotNull String needInsertCommentID, @NotNull String needInsertReplyID, @NotNull List<String> needInsertCommentIDS, long j16, int i16, boolean z16) {
        Intrinsics.checkNotNullParameter(callSource, "callSource");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(needInsertCommentID, "needInsertCommentID");
        Intrinsics.checkNotNullParameter(needInsertReplyID, "needInsertReplyID");
        Intrinsics.checkNotNullParameter(needInsertCommentIDS, "needInsertCommentIDS");
        this.callSource = callSource;
        this.feedId = feedId;
        this.guildId = guildId;
        this.channelId = channelId;
        this.rankingType = i3;
        this.lastModifiedTime = j3;
        this.originRecommendFeedData = serializable;
        this.originStFeedData = serializable2;
        this.needInsertCommentID = needInsertCommentID;
        this.needInsertReplyID = needInsertReplyID;
        this.needInsertCommentIDS = needInsertCommentIDS;
        this.startTime = j16;
        this.businessType = i16;
        this.enableCache = z16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getCallSource() {
        return this.callSource;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getEnableCache() {
        return this.enableCache;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoadDataArgs)) {
            return false;
        }
        LoadDataArgs loadDataArgs = (LoadDataArgs) other;
        if (Intrinsics.areEqual(this.callSource, loadDataArgs.callSource) && Intrinsics.areEqual(this.feedId, loadDataArgs.feedId) && Intrinsics.areEqual(this.guildId, loadDataArgs.guildId) && Intrinsics.areEqual(this.channelId, loadDataArgs.channelId) && this.rankingType == loadDataArgs.rankingType && this.lastModifiedTime == loadDataArgs.lastModifiedTime && Intrinsics.areEqual(this.originRecommendFeedData, loadDataArgs.originRecommendFeedData) && Intrinsics.areEqual(this.originStFeedData, loadDataArgs.originStFeedData) && Intrinsics.areEqual(this.needInsertCommentID, loadDataArgs.needInsertCommentID) && Intrinsics.areEqual(this.needInsertReplyID, loadDataArgs.needInsertReplyID) && Intrinsics.areEqual(this.needInsertCommentIDS, loadDataArgs.needInsertCommentIDS) && this.startTime == loadDataArgs.startTime && this.businessType == loadDataArgs.businessType && this.enableCache == loadDataArgs.enableCache) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final long getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getNeedInsertCommentID() {
        return this.needInsertCommentID;
    }

    @NotNull
    public final List<String> h() {
        return this.needInsertCommentIDS;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((((this.callSource.hashCode() * 31) + this.feedId.hashCode()) * 31) + this.guildId.hashCode()) * 31) + this.channelId.hashCode()) * 31) + this.rankingType) * 31) + androidx.fragment.app.a.a(this.lastModifiedTime)) * 31;
        Serializable serializable = this.originRecommendFeedData;
        int i3 = 0;
        if (serializable == null) {
            hashCode = 0;
        } else {
            hashCode = serializable.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        Serializable serializable2 = this.originStFeedData;
        if (serializable2 != null) {
            i3 = serializable2.hashCode();
        }
        int hashCode3 = (((((((((((i16 + i3) * 31) + this.needInsertCommentID.hashCode()) * 31) + this.needInsertReplyID.hashCode()) * 31) + this.needInsertCommentIDS.hashCode()) * 31) + androidx.fragment.app.a.a(this.startTime)) * 31) + this.businessType) * 31;
        boolean z16 = this.enableCache;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        return hashCode3 + i17;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getNeedInsertReplyID() {
        return this.needInsertReplyID;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final Serializable getOriginRecommendFeedData() {
        return this.originRecommendFeedData;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final Serializable getOriginStFeedData() {
        return this.originStFeedData;
    }

    /* renamed from: l, reason: from getter */
    public final int getRankingType() {
        return this.rankingType;
    }

    /* renamed from: m, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    public final void n(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.callSource = str;
    }

    public final void o(int i3) {
        this.rankingType = i3;
    }

    @NotNull
    public String toString() {
        return "LoadDataArgs(callSource=" + this.callSource + ", feedId=" + this.feedId + ", guildId=" + this.guildId + ", channelId=" + this.channelId + ", rankingType=" + this.rankingType + ", lastModifiedTime=" + this.lastModifiedTime + ", originRecommendFeedData=" + this.originRecommendFeedData + ", originStFeedData=" + this.originStFeedData + ", needInsertCommentID=" + this.needInsertCommentID + ", needInsertReplyID=" + this.needInsertReplyID + ", needInsertCommentIDS=" + this.needInsertCommentIDS + ", startTime=" + this.startTime + ", businessType=" + this.businessType + ", enableCache=" + this.enableCache + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ LoadDataArgs(String str, String str2, String str3, String str4, int i3, long j3, Serializable serializable, Serializable serializable2, String str5, String str6, List list, long j16, int i16, boolean z16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, r8, r9, r11, r12, r13, r14, r15, (i17 & 2048) != 0 ? -1L : j16, (i17 & 4096) != 0 ? 0 : i16, (i17 & 8192) != 0 ? true : z16);
        List list2;
        List emptyList;
        int i18 = (i17 & 16) != 0 ? 0 : i3;
        long j17 = (i17 & 32) != 0 ? 0L : j3;
        Serializable serializable3 = (i17 & 64) != 0 ? null : serializable;
        Serializable serializable4 = (i17 & 128) != 0 ? null : serializable2;
        String str7 = (i17 & 256) != 0 ? "" : str5;
        String str8 = (i17 & 512) != 0 ? "" : str6;
        if ((i17 & 1024) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list2 = emptyList;
        } else {
            list2 = list;
        }
    }
}
