package com.tencent.mobileqq.guild.discoveryv2.parts.tabs;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationTab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/TabsSnapshot;", "", "", "a", "", "tabType", "", "value", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProNavigationTab;", "tabList", "e", "d", "Lcom/tencent/mobileqq/guild/base/a;", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "b", "Lcom/tencent/mobileqq/guild/base/a;", "()Lcom/tencent/mobileqq/guild/base/a;", "mmkv", "", "c", "()Ljava/lang/String;", "uin", "<init>", "()V", "NavigationTabData", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TabsSnapshot {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TabsSnapshot f217705a = new TabsSnapshot();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.guild.base.a<MMKVOptionEntityV2> mmkv = new TabsSnapshot$special$$inlined$newAccountAwareServiceHolder$default$1(null, null);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Parcelize
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0083\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/TabsSnapshot$NavigationTabData;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/NavigationTab;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "tabList", "<init>", "(Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class NavigationTabData implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<NavigationTabData> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<NavigationTab> tabList;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes13.dex */
        public static final class a implements Parcelable.Creator<NavigationTabData> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final NavigationTabData createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i3 = 0; i3 != readInt; i3++) {
                    arrayList.add(NavigationTab.CREATOR.createFromParcel(parcel));
                }
                return new NavigationTabData(arrayList);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final NavigationTabData[] newArray(int i3) {
                return new NavigationTabData[i3];
            }
        }

        public NavigationTabData(@NotNull List<NavigationTab> tabList) {
            Intrinsics.checkNotNullParameter(tabList, "tabList");
            this.tabList = tabList;
        }

        @NotNull
        public final List<NavigationTab> a() {
            return this.tabList;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof NavigationTabData) && Intrinsics.areEqual(this.tabList, ((NavigationTabData) other).tabList)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.tabList.hashCode();
        }

        @NotNull
        public String toString() {
            return "NavigationTabData(tabList=" + this.tabList + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            List<NavigationTab> list = this.tabList;
            parcel.writeInt(list.size());
            Iterator<NavigationTab> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(parcel, flags);
            }
        }
    }

    TabsSnapshot() {
    }

    private final String c() {
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        if (currentUin == null) {
            return "";
        }
        return currentUin;
    }

    public final void a() {
        Logger.f235387a.d().i("TabsSnapshot", 1, "clear mmkv");
        mmkv.getValue().clearAll();
    }

    @NotNull
    public final com.tencent.mobileqq.guild.base.a<MMKVOptionEntityV2> b() {
        return mmkv;
    }

    @Nullable
    public final List<IGProNavigationTab> d() {
        List<NavigationTab> list;
        String c16 = c();
        long currentTimeMillis = System.currentTimeMillis();
        Integer num = null;
        NavigationTabData navigationTabData = (NavigationTabData) mmkv.getValue().getParcelable(c16 + "_NavigationTabData", NavigationTabData.class, null);
        if (navigationTabData != null) {
            list = navigationTabData.a();
        } else {
            list = null;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        Logger.a d16 = Logger.f235387a.d();
        if (list != null) {
            num = Integer.valueOf(list.size());
        }
        d16.i("TabsSnapshot", 1, "loadTabsSnapshot: size=" + num + " cost=" + currentTimeMillis2);
        return list;
    }

    public final void e(int tabType, @Nullable byte[] value, @NotNull List<? extends IGProNavigationTab> tabList) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(tabList, "tabList");
        if (tabList.isEmpty()) {
            Logger.f235387a.d().i("TabsSnapshot", 1, "saveTabsSnapshot: tabType=" + tabType + ", tabList is empty");
            return;
        }
        String c16 = c();
        Logger.f235387a.d().i("TabsSnapshot", 1, "saveTabsSnapshot: tabType=" + tabType + " size:" + tabList.size());
        MMKVOptionEntityV2 value2 = mmkv.getValue();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(c16);
        sb5.append("_NavigationTabData");
        String sb6 = sb5.toString();
        List<? extends IGProNavigationTab> list = tabList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (IGProNavigationTab iGProNavigationTab : list) {
            String name = iGProNavigationTab.getName();
            Intrinsics.checkNotNullExpressionValue(name, "it.name");
            arrayList.add(new NavigationTab(name, iGProNavigationTab.getTabType(), iGProNavigationTab.getSubType(), iGProNavigationTab.getTabId()));
        }
        value2.putParcelable(sb6, new NavigationTabData(arrayList));
    }
}
