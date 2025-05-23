package com.tencent.mobileqq.guild.setting.group;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindingGroup;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\u001c\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\u001c\u0012\b\b\u0002\u0010(\u001a\u00020\u0006\u0012\b\b\u0002\u0010)\u001a\u00020\u0006\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\rJ\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u000f\u001a\u00020\u0006J\t\u0010\u0014\u001a\u00020\u0013H\u00d6\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001fR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b!\u0010\u001fR\"\u0010(\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010#\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/OneBindableGroupSettingData;", "", "", "toString", "", "groupCode", "", "a", "", tl.h.F, "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBindingGroup;", "bindGroupInfo", "k", "Lcom/tencent/mobileqq/guild/setting/group/ItemPositionType;", "c", "isBindLimited", "", "Lcom/tencent/mobileqq/guild/setting/group/a;", "f", "", "hashCode", "other", "equals", "Lcom/tencent/mobileqq/guild/setting/group/GroupType;", "Lcom/tencent/mobileqq/guild/setting/group/GroupType;", "d", "()Lcom/tencent/mobileqq/guild/setting/group/GroupType;", NotifyMsgApiImpl.KEY_GROUP_TYPE, "", "b", "Ljava/util/List;", "()Ljava/util/List;", "activeGroups", "e", "inactiveGroups", "Z", "g", "()Z", "i", "(Z)V", "isCollapse", "isShowInactiveGroups", "j", "<init>", "(Lcom/tencent/mobileqq/guild/setting/group/GroupType;Ljava/util/List;Ljava/util/List;ZZ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class OneBindableGroupSettingData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GroupType groupType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<IGProBindingGroup> activeGroups;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<IGProBindingGroup> inactiveGroups;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isCollapse;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isShowInactiveGroups;

    public OneBindableGroupSettingData(@NotNull GroupType groupType, @NotNull List<IGProBindingGroup> activeGroups, @NotNull List<IGProBindingGroup> inactiveGroups, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(groupType, "groupType");
        Intrinsics.checkNotNullParameter(activeGroups, "activeGroups");
        Intrinsics.checkNotNullParameter(inactiveGroups, "inactiveGroups");
        this.groupType = groupType;
        this.activeGroups = activeGroups;
        this.inactiveGroups = inactiveGroups;
        this.isCollapse = z16;
        this.isShowInactiveGroups = z17;
    }

    public final boolean a(long groupCode) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        List<IGProBindingGroup> list = this.activeGroups;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((IGProBindingGroup) it.next()).getGroupCode() == groupCode) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                    break;
                }
            }
        }
        z17 = false;
        if (z17) {
            return true;
        }
        List<IGProBindingGroup> list2 = this.inactiveGroups;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it5 = list2.iterator();
            while (it5.hasNext()) {
                if (((IGProBindingGroup) it5.next()).getGroupCode() == groupCode) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    z19 = true;
                    break;
                }
            }
        }
        z19 = false;
        if (z19) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<IGProBindingGroup> b() {
        return this.activeGroups;
    }

    @NotNull
    public final ItemPositionType c() {
        if (this.isCollapse) {
            return ItemPositionType.Single;
        }
        if (this.activeGroups.isEmpty() && this.inactiveGroups.isEmpty()) {
            return ItemPositionType.Single;
        }
        return ItemPositionType.Top;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final GroupType getGroupType() {
        return this.groupType;
    }

    @NotNull
    public final List<IGProBindingGroup> e() {
        return this.inactiveGroups;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OneBindableGroupSettingData)) {
            return false;
        }
        OneBindableGroupSettingData oneBindableGroupSettingData = (OneBindableGroupSettingData) other;
        if (this.groupType == oneBindableGroupSettingData.groupType && Intrinsics.areEqual(this.activeGroups, oneBindableGroupSettingData.activeGroups) && Intrinsics.areEqual(this.inactiveGroups, oneBindableGroupSettingData.inactiveGroups) && this.isCollapse == oneBindableGroupSettingData.isCollapse && this.isShowInactiveGroups == oneBindableGroupSettingData.isShowInactiveGroups) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<a> f(boolean isBindLimited) {
        int i3;
        ItemPositionType itemPositionType;
        ItemPositionType itemPositionType2;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BindGroupGroupData(this.isCollapse, this.groupType, c(), 0, 8, null));
        if (this.isCollapse) {
            return arrayList;
        }
        List<IGProBindingGroup> list = this.activeGroups;
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            IGProBindingGroup iGProBindingGroup = (IGProBindingGroup) next;
            if ((iGProBindingGroup.getGroupFlag() & 128) > 0 || (iGProBindingGroup.getGroupFlag() & 2) > 0) {
                i3 = 1;
            }
            if (i3 == 0) {
                arrayList2.add(next);
            }
        }
        List<IGProBindingGroup> list2 = this.inactiveGroups;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : list2) {
            IGProBindingGroup iGProBindingGroup2 = (IGProBindingGroup) obj;
            if ((iGProBindingGroup2.getGroupFlag() & 128) <= 0 && (iGProBindingGroup2.getGroupFlag() & 2) <= 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                arrayList3.add(obj);
            }
        }
        int i16 = 0;
        for (Object obj2 : arrayList2) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            IGProBindingGroup iGProBindingGroup3 = (IGProBindingGroup) obj2;
            if (i16 == arrayList2.size() - 1 && arrayList3.isEmpty()) {
                itemPositionType2 = ItemPositionType.Bottom;
            } else {
                itemPositionType2 = ItemPositionType.Middle;
            }
            arrayList.add(new GroupChatData(iGProBindingGroup3.getGroupCode(), false, iGProBindingGroup3, false, isBindLimited, 0, itemPositionType2, 40, null));
            i16 = i17;
        }
        if ((!arrayList3.isEmpty()) && !this.isShowInactiveGroups) {
            arrayList.add(new BindGroupShowMoreData(this.groupType, arrayList3.size(), 0, 4, null));
        } else {
            for (Object obj3 : arrayList3) {
                int i18 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                IGProBindingGroup iGProBindingGroup4 = (IGProBindingGroup) obj3;
                if (i3 == arrayList3.size() - 1) {
                    itemPositionType = ItemPositionType.Bottom;
                } else {
                    itemPositionType = ItemPositionType.Middle;
                }
                arrayList.add(new GroupChatData(iGProBindingGroup4.getGroupCode(), false, iGProBindingGroup4, false, isBindLimited, 0, itemPositionType, 40, null));
                i3 = i18;
            }
        }
        return arrayList;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsCollapse() {
        return this.isCollapse;
    }

    public final void h(final long groupCode) {
        CollectionsKt__MutableCollectionsKt.removeAll((List) this.activeGroups, (Function1) new Function1<IGProBindingGroup, Boolean>() { // from class: com.tencent.mobileqq.guild.setting.group.OneBindableGroupSettingData$removeGroup$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull IGProBindingGroup it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.getGroupCode() == groupCode);
            }
        });
        CollectionsKt__MutableCollectionsKt.removeAll((List) this.inactiveGroups, (Function1) new Function1<IGProBindingGroup, Boolean>() { // from class: com.tencent.mobileqq.guild.setting.group.OneBindableGroupSettingData$removeGroup$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull IGProBindingGroup it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.getGroupCode() == groupCode);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.groupType.hashCode() * 31) + this.activeGroups.hashCode()) * 31) + this.inactiveGroups.hashCode()) * 31;
        boolean z16 = this.isCollapse;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode + i16) * 31;
        boolean z17 = this.isShowInactiveGroups;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i17 + i3;
    }

    public final void i(boolean z16) {
        this.isCollapse = z16;
    }

    public final void j(boolean z16) {
        this.isShowInactiveGroups = z16;
    }

    public final boolean k(@NotNull IGProBindingGroup bindGroupInfo) {
        int i3;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(bindGroupInfo, "bindGroupInfo");
        Iterator<IGProBindingGroup> it = this.activeGroups.iterator();
        int i16 = 0;
        while (true) {
            i3 = -1;
            if (it.hasNext()) {
                if (it.next().getGroupCode() == bindGroupInfo.getGroupCode()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    break;
                }
                i16++;
            } else {
                i16 = -1;
                break;
            }
        }
        if (i16 > 0) {
            this.activeGroups.set(i16, bindGroupInfo);
            return !this.isCollapse;
        }
        Iterator<IGProBindingGroup> it5 = this.inactiveGroups.iterator();
        int i17 = 0;
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            if (it5.next().getGroupCode() == bindGroupInfo.getGroupCode()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i3 = i17;
                break;
            }
            i17++;
        }
        if (i3 <= 0) {
            return false;
        }
        this.inactiveGroups.set(i3, bindGroupInfo);
        if (this.isCollapse || !this.isShowInactiveGroups) {
            return false;
        }
        return true;
    }

    @NotNull
    public String toString() {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        String groupName = this.groupType.getGroupName();
        boolean z16 = this.isCollapse;
        boolean z17 = this.isShowInactiveGroups;
        List<IGProBindingGroup> list = this.activeGroups;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (IGProBindingGroup iGProBindingGroup : list) {
            arrayList.add(iGProBindingGroup.getGroupCode() + "-" + iGProBindingGroup.getGroupFlag());
        }
        List<IGProBindingGroup> list2 = this.inactiveGroups;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        for (IGProBindingGroup iGProBindingGroup2 : list2) {
            arrayList2.add(iGProBindingGroup2.getGroupCode() + "-" + iGProBindingGroup2.getGroupFlag());
        }
        return "OneBindableGroupSettingData(groupType=" + groupName + ", isCollapse=" + z16 + ", isShowInactiveGroups=" + z17 + "activeGroups=" + arrayList + ", inactiveGroups=" + arrayList2 + ")";
    }
}
