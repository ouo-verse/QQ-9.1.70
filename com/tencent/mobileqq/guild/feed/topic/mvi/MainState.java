package com.tencent.mobileqq.guild.feed.topic.mvi;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b \u0010!JO\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\nH\u00c6\u0001J\t\u0010\r\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/mvi/d;", "Lcom/tencent/mobileqq/guild/feed/mvi/b;", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "topicName", "guildId", "channelSign", "pageView", "totalFeedNum", "", "publishBtnShow", "a", "toString", "hashCode", "", "other", "equals", "I", "f", "()I", "b", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "c", "d", "e", tl.h.F, "Z", "getPublishBtnShow", "()Z", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.feed.topic.mvi.d, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class MainState implements com.tencent.mobileqq.guild.feed.mvi.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int statusCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String topicName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelSign;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String pageView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String totalFeedNum;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean publishBtnShow;

    public MainState(int i3, @NotNull String topicName, @NotNull String guildId, @NotNull String channelSign, @NotNull String pageView, @NotNull String totalFeedNum, boolean z16) {
        Intrinsics.checkNotNullParameter(topicName, "topicName");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelSign, "channelSign");
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        Intrinsics.checkNotNullParameter(totalFeedNum, "totalFeedNum");
        this.statusCode = i3;
        this.topicName = topicName;
        this.guildId = guildId;
        this.channelSign = channelSign;
        this.pageView = pageView;
        this.totalFeedNum = totalFeedNum;
        this.publishBtnShow = z16;
    }

    public static /* synthetic */ MainState b(MainState mainState, int i3, String str, String str2, String str3, String str4, String str5, boolean z16, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = mainState.statusCode;
        }
        if ((i16 & 2) != 0) {
            str = mainState.topicName;
        }
        String str6 = str;
        if ((i16 & 4) != 0) {
            str2 = mainState.guildId;
        }
        String str7 = str2;
        if ((i16 & 8) != 0) {
            str3 = mainState.channelSign;
        }
        String str8 = str3;
        if ((i16 & 16) != 0) {
            str4 = mainState.pageView;
        }
        String str9 = str4;
        if ((i16 & 32) != 0) {
            str5 = mainState.totalFeedNum;
        }
        String str10 = str5;
        if ((i16 & 64) != 0) {
            z16 = mainState.publishBtnShow;
        }
        return mainState.a(i3, str6, str7, str8, str9, str10, z16);
    }

    @NotNull
    public final MainState a(int statusCode, @NotNull String topicName, @NotNull String guildId, @NotNull String channelSign, @NotNull String pageView, @NotNull String totalFeedNum, boolean publishBtnShow) {
        Intrinsics.checkNotNullParameter(topicName, "topicName");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelSign, "channelSign");
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        Intrinsics.checkNotNullParameter(totalFeedNum, "totalFeedNum");
        return new MainState(statusCode, topicName, guildId, channelSign, pageView, totalFeedNum, publishBtnShow);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getChannelSign() {
        return this.channelSign;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getPageView() {
        return this.pageView;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MainState)) {
            return false;
        }
        MainState mainState = (MainState) other;
        if (this.statusCode == mainState.statusCode && Intrinsics.areEqual(this.topicName, mainState.topicName) && Intrinsics.areEqual(this.guildId, mainState.guildId) && Intrinsics.areEqual(this.channelSign, mainState.channelSign) && Intrinsics.areEqual(this.pageView, mainState.pageView) && Intrinsics.areEqual(this.totalFeedNum, mainState.totalFeedNum) && this.publishBtnShow == mainState.publishBtnShow) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getStatusCode() {
        return this.statusCode;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getTopicName() {
        return this.topicName;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getTotalFeedNum() {
        return this.totalFeedNum;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((this.statusCode * 31) + this.topicName.hashCode()) * 31) + this.guildId.hashCode()) * 31) + this.channelSign.hashCode()) * 31) + this.pageView.hashCode()) * 31) + this.totalFeedNum.hashCode()) * 31;
        boolean z16 = this.publishBtnShow;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "MainState(statusCode=" + this.statusCode + ", topicName=" + this.topicName + ", guildId=" + this.guildId + ", channelSign=" + this.channelSign + ", pageView=" + this.pageView + ", totalFeedNum=" + this.totalFeedNum + ", publishBtnShow=" + this.publishBtnShow + ")";
    }
}
