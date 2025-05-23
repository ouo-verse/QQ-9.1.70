package com.tencent.mobileqq.zplan.minihome;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/x;", "", "", "toString", "", "hashCode", "other", "", "equals", "awardBackgroundPicUrl", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "awardPicUrl", "b", "awardText", "c", "okButtonText", "e", "okButtonJumpScheme", "d", "reportData", "f", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.minihome.x, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class GiftRewardDesc {

    @SerializedName("awardBackgroundPicUrl")
    @NotNull
    private final String awardBackgroundPicUrl;

    @SerializedName("awardPicUrl")
    @NotNull
    private final String awardPicUrl;

    @SerializedName("awardText")
    @NotNull
    private final String awardText;

    @SerializedName("okButtonJumpScheme")
    @NotNull
    private final String okButtonJumpScheme;

    @SerializedName("okButtonText")
    @NotNull
    private final String okButtonText;

    @SerializedName("reportData")
    @NotNull
    private final String reportData;

    public GiftRewardDesc() {
        this(null, null, null, null, null, null, 63, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAwardBackgroundPicUrl() {
        return this.awardBackgroundPicUrl;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getAwardPicUrl() {
        return this.awardPicUrl;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getAwardText() {
        return this.awardText;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getOkButtonJumpScheme() {
        return this.okButtonJumpScheme;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getOkButtonText() {
        return this.okButtonText;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GiftRewardDesc)) {
            return false;
        }
        GiftRewardDesc giftRewardDesc = (GiftRewardDesc) other;
        if (Intrinsics.areEqual(this.awardBackgroundPicUrl, giftRewardDesc.awardBackgroundPicUrl) && Intrinsics.areEqual(this.awardPicUrl, giftRewardDesc.awardPicUrl) && Intrinsics.areEqual(this.awardText, giftRewardDesc.awardText) && Intrinsics.areEqual(this.okButtonText, giftRewardDesc.okButtonText) && Intrinsics.areEqual(this.okButtonJumpScheme, giftRewardDesc.okButtonJumpScheme) && Intrinsics.areEqual(this.reportData, giftRewardDesc.reportData)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getReportData() {
        return this.reportData;
    }

    public int hashCode() {
        return (((((((((this.awardBackgroundPicUrl.hashCode() * 31) + this.awardPicUrl.hashCode()) * 31) + this.awardText.hashCode()) * 31) + this.okButtonText.hashCode()) * 31) + this.okButtonJumpScheme.hashCode()) * 31) + this.reportData.hashCode();
    }

    @NotNull
    public String toString() {
        return "GiftRewardDesc(awardBackgroundPicUrl=" + this.awardBackgroundPicUrl + ", awardPicUrl=" + this.awardPicUrl + ", awardText=" + this.awardText + ", okButtonText=" + this.okButtonText + ", okButtonJumpScheme=" + this.okButtonJumpScheme + ", reportData=" + this.reportData + ')';
    }

    public GiftRewardDesc(@NotNull String awardBackgroundPicUrl, @NotNull String awardPicUrl, @NotNull String awardText, @NotNull String okButtonText, @NotNull String okButtonJumpScheme, @NotNull String reportData) {
        Intrinsics.checkNotNullParameter(awardBackgroundPicUrl, "awardBackgroundPicUrl");
        Intrinsics.checkNotNullParameter(awardPicUrl, "awardPicUrl");
        Intrinsics.checkNotNullParameter(awardText, "awardText");
        Intrinsics.checkNotNullParameter(okButtonText, "okButtonText");
        Intrinsics.checkNotNullParameter(okButtonJumpScheme, "okButtonJumpScheme");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        this.awardBackgroundPicUrl = awardBackgroundPicUrl;
        this.awardPicUrl = awardPicUrl;
        this.awardText = awardText;
        this.okButtonText = okButtonText;
        this.okButtonJumpScheme = okButtonJumpScheme;
        this.reportData = reportData;
    }

    public /* synthetic */ GiftRewardDesc(String str, String str2, String str3, String str4, String str5, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? "" : str6);
    }
}
