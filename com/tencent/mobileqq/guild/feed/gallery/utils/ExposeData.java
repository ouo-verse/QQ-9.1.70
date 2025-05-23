package com.tencent.mobileqq.guild.feed.gallery.utils;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/utils/ExposeData;", "", "feedId", "", "busiReport", "(Ljava/lang/String;Ljava/lang/String;)V", "getBusiReport", "()Ljava/lang/String;", "setBusiReport", "(Ljava/lang/String;)V", "getFeedId", "setFeedId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final /* data */ class ExposeData {

    @SerializedName("busiReport")
    @NotNull
    private String busiReport;

    @SerializedName("feedId")
    @NotNull
    private String feedId;

    public ExposeData(@NotNull String feedId, @NotNull String busiReport) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(busiReport, "busiReport");
        this.feedId = feedId;
        this.busiReport = busiReport;
    }

    public static /* synthetic */ ExposeData copy$default(ExposeData exposeData, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = exposeData.feedId;
        }
        if ((i3 & 2) != 0) {
            str2 = exposeData.busiReport;
        }
        return exposeData.copy(str, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getBusiReport() {
        return this.busiReport;
    }

    @NotNull
    public final ExposeData copy(@NotNull String feedId, @NotNull String busiReport) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(busiReport, "busiReport");
        return new ExposeData(feedId, busiReport);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExposeData)) {
            return false;
        }
        ExposeData exposeData = (ExposeData) other;
        if (Intrinsics.areEqual(this.feedId, exposeData.feedId) && Intrinsics.areEqual(this.busiReport, exposeData.busiReport)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getBusiReport() {
        return this.busiReport;
    }

    @NotNull
    public final String getFeedId() {
        return this.feedId;
    }

    public int hashCode() {
        return (this.feedId.hashCode() * 31) + this.busiReport.hashCode();
    }

    public final void setBusiReport(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.busiReport = str;
    }

    public final void setFeedId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.feedId = str;
    }

    @NotNull
    public String toString() {
        return "ExposeData(feedId=" + this.feedId + ", busiReport=" + this.busiReport + ")";
    }
}
