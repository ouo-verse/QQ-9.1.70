package com.tencent.robot.adelie.homepage.mine.part;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/robot/adelie/homepage/mine/part/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/robot/adelie/homepage/mine/part/h;", "banner", "Ljava/util/List;", "a", "()Ljava/util/List;", "createCenterBkgUrlDay", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "createCenterBkgUrlNight", "e", "createCenterBkgRoundUrlDay", "b", "createCenterBkgRoundUrlNight", "c", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.adelie.homepage.mine.part.g, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class CreateCenterBanner {

    @SerializedName("banner")
    @NotNull
    private final List<CreateCenterBannerItem> banner;

    @SerializedName("createCenterBkgRoundUrlDay")
    @NotNull
    private final String createCenterBkgRoundUrlDay;

    @SerializedName("createCenterBkgRoundUrlNight")
    @NotNull
    private final String createCenterBkgRoundUrlNight;

    @SerializedName("createCenterBkgUrlDay")
    @NotNull
    private final String createCenterBkgUrlDay;

    @SerializedName("createCenterBkgUrlNight")
    @NotNull
    private final String createCenterBkgUrlNight;

    public CreateCenterBanner() {
        this(null, null, null, null, null, 31, null);
    }

    @NotNull
    public final List<CreateCenterBannerItem> a() {
        return this.banner;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getCreateCenterBkgRoundUrlDay() {
        return this.createCenterBkgRoundUrlDay;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getCreateCenterBkgRoundUrlNight() {
        return this.createCenterBkgRoundUrlNight;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getCreateCenterBkgUrlDay() {
        return this.createCenterBkgUrlDay;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getCreateCenterBkgUrlNight() {
        return this.createCenterBkgUrlNight;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateCenterBanner)) {
            return false;
        }
        CreateCenterBanner createCenterBanner = (CreateCenterBanner) other;
        if (Intrinsics.areEqual(this.banner, createCenterBanner.banner) && Intrinsics.areEqual(this.createCenterBkgUrlDay, createCenterBanner.createCenterBkgUrlDay) && Intrinsics.areEqual(this.createCenterBkgUrlNight, createCenterBanner.createCenterBkgUrlNight) && Intrinsics.areEqual(this.createCenterBkgRoundUrlDay, createCenterBanner.createCenterBkgRoundUrlDay) && Intrinsics.areEqual(this.createCenterBkgRoundUrlNight, createCenterBanner.createCenterBkgRoundUrlNight)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.banner.hashCode() * 31) + this.createCenterBkgUrlDay.hashCode()) * 31) + this.createCenterBkgUrlNight.hashCode()) * 31) + this.createCenterBkgRoundUrlDay.hashCode()) * 31) + this.createCenterBkgRoundUrlNight.hashCode();
    }

    @NotNull
    public String toString() {
        return "CreateCenterBanner(banner=" + this.banner + ", createCenterBkgUrlDay=" + this.createCenterBkgUrlDay + ", createCenterBkgUrlNight=" + this.createCenterBkgUrlNight + ", createCenterBkgRoundUrlDay=" + this.createCenterBkgRoundUrlDay + ", createCenterBkgRoundUrlNight=" + this.createCenterBkgRoundUrlNight + ")";
    }

    public CreateCenterBanner(@NotNull List<CreateCenterBannerItem> banner, @NotNull String createCenterBkgUrlDay, @NotNull String createCenterBkgUrlNight, @NotNull String createCenterBkgRoundUrlDay, @NotNull String createCenterBkgRoundUrlNight) {
        Intrinsics.checkNotNullParameter(banner, "banner");
        Intrinsics.checkNotNullParameter(createCenterBkgUrlDay, "createCenterBkgUrlDay");
        Intrinsics.checkNotNullParameter(createCenterBkgUrlNight, "createCenterBkgUrlNight");
        Intrinsics.checkNotNullParameter(createCenterBkgRoundUrlDay, "createCenterBkgRoundUrlDay");
        Intrinsics.checkNotNullParameter(createCenterBkgRoundUrlNight, "createCenterBkgRoundUrlNight");
        this.banner = banner;
        this.createCenterBkgUrlDay = createCenterBkgUrlDay;
        this.createCenterBkgUrlNight = createCenterBkgUrlNight;
        this.createCenterBkgRoundUrlDay = createCenterBkgRoundUrlDay;
        this.createCenterBkgRoundUrlNight = createCenterBkgRoundUrlNight;
    }

    public /* synthetic */ CreateCenterBanner(List list, String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 2) != 0 ? "https://bot-resource-1251316161.file.myqcloud.com/media/create_center_card_day_1.png" : str, (i3 & 4) != 0 ? "https://bot-resource-1251316161.file.myqcloud.com/media/create_center_card_night_1.png" : str2, (i3 & 8) != 0 ? "https://bot-resource-1251316161.file.myqcloud.com/media/create_center_card_day_round.png" : str3, (i3 & 16) != 0 ? "https://bot-resource-1251316161.file.myqcloud.com/media/create_center_card_night_round.png" : str4);
    }
}
