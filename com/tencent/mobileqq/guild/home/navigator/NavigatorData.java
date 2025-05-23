package com.tencent.mobileqq.guild.home.navigator;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\t\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0013\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u001a\u0010\fR\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001c\u0010\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/home/navigator/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "d", "()I", "itemType", "", "b", "J", "()J", "categoryId", "c", "categoryType", "Ljava/lang/String;", "()Ljava/lang/String;", "iconName", "e", "navigationIconUrl", "f", "navigationJumpType", "g", "navigationJumpUrl", "<init>", "(IJILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.home.navigator.d, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class NavigatorData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int itemType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long categoryId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int categoryType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String iconName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String navigationIconUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int navigationJumpType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String navigationJumpUrl;

    public NavigatorData(int i3, long j3, int i16, @NotNull String iconName, @NotNull String navigationIconUrl, int i17, @NotNull String navigationJumpUrl) {
        Intrinsics.checkNotNullParameter(iconName, "iconName");
        Intrinsics.checkNotNullParameter(navigationIconUrl, "navigationIconUrl");
        Intrinsics.checkNotNullParameter(navigationJumpUrl, "navigationJumpUrl");
        this.itemType = i3;
        this.categoryId = j3;
        this.categoryType = i16;
        this.iconName = iconName;
        this.navigationIconUrl = navigationIconUrl;
        this.navigationJumpType = i17;
        this.navigationJumpUrl = navigationJumpUrl;
    }

    /* renamed from: a, reason: from getter */
    public final long getCategoryId() {
        return this.categoryId;
    }

    /* renamed from: b, reason: from getter */
    public final int getCategoryType() {
        return this.categoryType;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getIconName() {
        return this.iconName;
    }

    /* renamed from: d, reason: from getter */
    public final int getItemType() {
        return this.itemType;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getNavigationIconUrl() {
        return this.navigationIconUrl;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NavigatorData)) {
            return false;
        }
        NavigatorData navigatorData = (NavigatorData) other;
        if (this.itemType == navigatorData.itemType && this.categoryId == navigatorData.categoryId && this.categoryType == navigatorData.categoryType && Intrinsics.areEqual(this.iconName, navigatorData.iconName) && Intrinsics.areEqual(this.navigationIconUrl, navigatorData.navigationIconUrl) && this.navigationJumpType == navigatorData.navigationJumpType && Intrinsics.areEqual(this.navigationJumpUrl, navigatorData.navigationJumpUrl)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getNavigationJumpType() {
        return this.navigationJumpType;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getNavigationJumpUrl() {
        return this.navigationJumpUrl;
    }

    public int hashCode() {
        return (((((((((((this.itemType * 31) + androidx.fragment.app.a.a(this.categoryId)) * 31) + this.categoryType) * 31) + this.iconName.hashCode()) * 31) + this.navigationIconUrl.hashCode()) * 31) + this.navigationJumpType) * 31) + this.navigationJumpUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "NavigatorData(itemType=" + this.itemType + ", categoryId=" + this.categoryId + ", categoryType=" + this.categoryType + ", iconName=" + this.iconName + ", navigationIconUrl=" + this.navigationIconUrl + ", navigationJumpType=" + this.navigationJumpType + ", navigationJumpUrl=" + this.navigationJumpUrl + ")";
    }

    public /* synthetic */ NavigatorData(int i3, long j3, int i16, String str, String str2, int i17, String str3, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i18 & 2) != 0 ? 0L : j3, (i18 & 4) != 0 ? 0 : i16, (i18 & 8) != 0 ? "" : str, (i18 & 16) != 0 ? "" : str2, (i18 & 32) == 0 ? i17 : 0, (i18 & 64) == 0 ? str3 : "");
    }
}
