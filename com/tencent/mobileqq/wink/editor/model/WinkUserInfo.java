package com.tencent.mobileqq.wink.editor.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0017\u0010\fR\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0019\u0010\fR\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u001c\u0010\fR\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u0010!\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b \u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/model/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "nickName", "b", "getLogoRemotePath", "logoRemotePath", "c", "g", "logoLocalPath", "d", "j", "settlementTimeLabel", "e", "gender", "f", "locationLabel", "describeLabel", h.F, "constellationLabel", "monthLabel", "dayLabel", "k", "ageLabel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.editor.model.c, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class WinkUserInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String nickName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String logoRemotePath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String logoLocalPath;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String settlementTimeLabel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String gender;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String locationLabel;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String describeLabel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String constellationLabel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String monthLabel;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String dayLabel;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String ageLabel;

    public WinkUserInfo(@NotNull String nickName, @NotNull String logoRemotePath, @NotNull String logoLocalPath, @NotNull String settlementTimeLabel, @NotNull String gender, @NotNull String locationLabel, @NotNull String describeLabel, @NotNull String constellationLabel, @NotNull String monthLabel, @NotNull String dayLabel, @NotNull String ageLabel) {
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(logoRemotePath, "logoRemotePath");
        Intrinsics.checkNotNullParameter(logoLocalPath, "logoLocalPath");
        Intrinsics.checkNotNullParameter(settlementTimeLabel, "settlementTimeLabel");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(locationLabel, "locationLabel");
        Intrinsics.checkNotNullParameter(describeLabel, "describeLabel");
        Intrinsics.checkNotNullParameter(constellationLabel, "constellationLabel");
        Intrinsics.checkNotNullParameter(monthLabel, "monthLabel");
        Intrinsics.checkNotNullParameter(dayLabel, "dayLabel");
        Intrinsics.checkNotNullParameter(ageLabel, "ageLabel");
        this.nickName = nickName;
        this.logoRemotePath = logoRemotePath;
        this.logoLocalPath = logoLocalPath;
        this.settlementTimeLabel = settlementTimeLabel;
        this.gender = gender;
        this.locationLabel = locationLabel;
        this.describeLabel = describeLabel;
        this.constellationLabel = constellationLabel;
        this.monthLabel = monthLabel;
        this.dayLabel = dayLabel;
        this.ageLabel = ageLabel;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAgeLabel() {
        return this.ageLabel;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getConstellationLabel() {
        return this.constellationLabel;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getDayLabel() {
        return this.dayLabel;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getDescribeLabel() {
        return this.describeLabel;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getGender() {
        return this.gender;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkUserInfo)) {
            return false;
        }
        WinkUserInfo winkUserInfo = (WinkUserInfo) other;
        if (Intrinsics.areEqual(this.nickName, winkUserInfo.nickName) && Intrinsics.areEqual(this.logoRemotePath, winkUserInfo.logoRemotePath) && Intrinsics.areEqual(this.logoLocalPath, winkUserInfo.logoLocalPath) && Intrinsics.areEqual(this.settlementTimeLabel, winkUserInfo.settlementTimeLabel) && Intrinsics.areEqual(this.gender, winkUserInfo.gender) && Intrinsics.areEqual(this.locationLabel, winkUserInfo.locationLabel) && Intrinsics.areEqual(this.describeLabel, winkUserInfo.describeLabel) && Intrinsics.areEqual(this.constellationLabel, winkUserInfo.constellationLabel) && Intrinsics.areEqual(this.monthLabel, winkUserInfo.monthLabel) && Intrinsics.areEqual(this.dayLabel, winkUserInfo.dayLabel) && Intrinsics.areEqual(this.ageLabel, winkUserInfo.ageLabel)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getLocationLabel() {
        return this.locationLabel;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getLogoLocalPath() {
        return this.logoLocalPath;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getMonthLabel() {
        return this.monthLabel;
    }

    public int hashCode() {
        return (((((((((((((((((((this.nickName.hashCode() * 31) + this.logoRemotePath.hashCode()) * 31) + this.logoLocalPath.hashCode()) * 31) + this.settlementTimeLabel.hashCode()) * 31) + this.gender.hashCode()) * 31) + this.locationLabel.hashCode()) * 31) + this.describeLabel.hashCode()) * 31) + this.constellationLabel.hashCode()) * 31) + this.monthLabel.hashCode()) * 31) + this.dayLabel.hashCode()) * 31) + this.ageLabel.hashCode();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getSettlementTimeLabel() {
        return this.settlementTimeLabel;
    }

    @NotNull
    public String toString() {
        return "WinkUserInfo(nickName=" + this.nickName + ", logoRemotePath=" + this.logoRemotePath + ", logoLocalPath=" + this.logoLocalPath + ", settlementTimeLabel=" + this.settlementTimeLabel + ", gender=" + this.gender + ", locationLabel=" + this.locationLabel + ", describeLabel=" + this.describeLabel + ", constellationLabel=" + this.constellationLabel + ", monthLabel=" + this.monthLabel + ", dayLabel=" + this.dayLabel + ", ageLabel=" + this.ageLabel + ")";
    }
}
