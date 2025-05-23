package com.tencent.mobileqq.guild.discoveryv2.parts.tabs;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationTab;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J1\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003H\u00c6\u0001J\t\u0010\u000e\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001aR\u0014\u0010\n\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001bR\u0014\u0010\u000b\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001bR\u0014\u0010\f\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001b\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/NavigationTab;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProNavigationTab;", "Landroid/os/Parcelable;", "", "getTabType", "getSubType", "", "getName", "getTabId", "name", "tabType", QCircleLpReportDc010001.KEY_SUBTYPE, "tabId", "copy", "toString", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "Ljava/lang/String;", "I", "<init>", "(Ljava/lang/String;III)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class NavigationTab implements IGProNavigationTab, Parcelable {

    @NotNull
    public static final Parcelable.Creator<NavigationTab> CREATOR = new a();

    @NotNull
    private final String name;
    private final int subType;
    private final int tabId;
    private final int tabType;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a implements Parcelable.Creator<NavigationTab> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final NavigationTab createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new NavigationTab(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final NavigationTab[] newArray(int i3) {
            return new NavigationTab[i3];
        }
    }

    public NavigationTab(@NotNull String name, int i3, int i16, int i17) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.tabType = i3;
        this.subType = i16;
        this.tabId = i17;
    }

    public static /* synthetic */ NavigationTab copy$default(NavigationTab navigationTab, String str, int i3, int i16, int i17, int i18, Object obj) {
        if ((i18 & 1) != 0) {
            str = navigationTab.name;
        }
        if ((i18 & 2) != 0) {
            i3 = navigationTab.tabType;
        }
        if ((i18 & 4) != 0) {
            i16 = navigationTab.subType;
        }
        if ((i18 & 8) != 0) {
            i17 = navigationTab.tabId;
        }
        return navigationTab.copy(str, i3, i16, i17);
    }

    @NotNull
    public final NavigationTab copy(@NotNull String name, int tabType, int subType, int tabId) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new NavigationTab(name, tabType, subType, tabId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NavigationTab)) {
            return false;
        }
        NavigationTab navigationTab = (NavigationTab) other;
        if (Intrinsics.areEqual(this.name, navigationTab.name) && this.tabType == navigationTab.tabType && this.subType == navigationTab.subType && this.tabId == navigationTab.tabId) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationTab
    @NotNull
    public String getName() {
        return this.name;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationTab
    public int getSubType() {
        return this.subType;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationTab
    public int getTabId() {
        return this.tabId;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationTab
    public int getTabType() {
        return this.tabType;
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.tabType) * 31) + this.subType) * 31) + this.tabId;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationTab
    @NotNull
    public String toString() {
        return "NavigationTab(name=" + this.name + ", tabType=" + this.tabType + ", subType=" + this.subType + ", tabId=" + this.tabId + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.name);
        parcel.writeInt(this.tabType);
        parcel.writeInt(this.subType);
        parcel.writeInt(this.tabId);
    }
}
