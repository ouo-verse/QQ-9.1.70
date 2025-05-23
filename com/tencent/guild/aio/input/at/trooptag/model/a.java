package com.tencent.guild.aio.input.at.trooptag.model;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import cp0.HashTagChannelData;
import cp0.HashTagGroupData;
import cp0.HashTagGroupType;
import cp0.HashTagTroopData;
import cp0.HashTagTroopInActiveData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b)\u0010*J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\tJ\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nJ\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0017J\u000e\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\tJ\u0014\u0010\u001e\u001a\u00020\f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u001cR \u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010 R$\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00100\"j\b\u0012\u0004\u0012\u00020\u0010`#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010$R \u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010 R$\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/guild/aio/input/at/trooptag/model/a;", "", "Lcp0/g;", VipFunCallConstants.KEY_GROUP, "Lcp0/f;", "c", "", "includeInactiveItemList", "Ljava/util/ArrayList;", "Lcp0/a;", "Lkotlin/collections/ArrayList;", "g", "", "i", "data", "j", "Lip0/b;", "changedListener", "a", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemBackgroundType;", "d", "e", "Lcp0/j;", "b", "k", "l", "f", "", "newDataList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "collapseMap", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "dataChangedListenerSet", "expandInActiveItemMap", "Ljava/util/ArrayList;", "groupDataList", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<HashTagGroupType, Boolean> collapseMap = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashSet<ip0.b> dataChangedListenerSet = new HashSet<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<HashTagGroupType, Boolean> expandInActiveItemMap = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<cp0.a> groupDataList = new ArrayList<>();

    private final HashTagGroupData c(HashTagGroupType group) {
        Object firstOrNull;
        boolean z16;
        ArrayList<cp0.a> arrayList = this.groupDataList;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            cp0.a aVar = (cp0.a) obj;
            if ((aVar instanceof HashTagGroupData) && Intrinsics.areEqual(((HashTagGroupData) aVar).getGroupName(), group.getGroupName())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList2.add(obj);
            }
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList2);
        if (firstOrNull instanceof HashTagGroupData) {
            return (HashTagGroupData) firstOrNull;
        }
        return null;
    }

    private final ArrayList<cp0.a> g(HashTagGroupType group, boolean includeInactiveItemList) {
        Object lastOrNull;
        HashTagTroopInActiveData hashTagTroopInActiveData;
        HashTagGroupData c16 = c(group);
        if (c16 == null) {
            return new ArrayList<>();
        }
        ArrayList<cp0.a> arrayList = new ArrayList<>();
        arrayList.addAll(c16.e());
        if (includeInactiveItemList) {
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) c16.e());
            if (lastOrNull instanceof HashTagTroopInActiveData) {
                hashTagTroopInActiveData = (HashTagTroopInActiveData) lastOrNull;
            } else {
                hashTagTroopInActiveData = null;
            }
            if (hashTagTroopInActiveData != null) {
                arrayList.addAll(hashTagTroopInActiveData.d());
            }
        }
        return arrayList;
    }

    static /* synthetic */ ArrayList h(a aVar, HashTagGroupType hashTagGroupType, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        return aVar.g(hashTagGroupType, z16);
    }

    private final void i() {
        Iterator<ip0.b> it = this.dataChangedListenerSet.iterator();
        while (it.hasNext()) {
            it.next().i();
        }
    }

    private final void j(cp0.a data) {
        Iterator<ip0.b> it = this.dataChangedListenerSet.iterator();
        while (it.hasNext()) {
            it.next().U(data);
        }
    }

    public final void a(@NotNull ip0.b changedListener) {
        Intrinsics.checkNotNullParameter(changedListener, "changedListener");
        this.dataChangedListenerSet.add(changedListener);
    }

    public final void b(@NotNull HashTagTroopInActiveData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.groupDataList.addAll(this.groupDataList.indexOf(data) + 1, data.d());
        this.groupDataList.remove(data);
        i();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005e, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r7.getGroupName(), r0.getGroupName()) != false) goto L29;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final QUIListItemBackgroundType d(@NotNull cp0.a item) {
        HashTagTroopData hashTagTroopData;
        HashTagChannelData hashTagChannelData;
        HashTagGroupType hashTagGroupType;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(item, "item");
        HashTagGroupData hashTagGroupData = null;
        if (item instanceof HashTagTroopData) {
            hashTagTroopData = (HashTagTroopData) item;
        } else {
            hashTagTroopData = null;
        }
        if (item instanceof HashTagChannelData) {
            hashTagChannelData = (HashTagChannelData) item;
        } else {
            hashTagChannelData = null;
        }
        QUIListItemBackgroundType qUIListItemBackgroundType = QUIListItemBackgroundType.NoneRound;
        if (hashTagTroopData == null || (hashTagGroupType = hashTagTroopData.getHashTagGroupType()) == null) {
            if (hashTagChannelData != null) {
                hashTagGroupType = hashTagChannelData.getHashTagGroupType();
            } else {
                hashTagGroupType = null;
            }
        }
        if (hashTagGroupType != null) {
            ArrayList<cp0.a> arrayList = this.groupDataList;
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = arrayList.iterator();
            while (true) {
                boolean z16 = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                cp0.a aVar = (cp0.a) next;
                if (aVar instanceof HashTagGroupData) {
                    HashTagGroupData hashTagGroupData2 = (HashTagGroupData) aVar;
                    if (!hashTagGroupData2.getIsCollapse()) {
                    }
                }
                z16 = false;
                if (z16) {
                    arrayList2.add(next);
                }
            }
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList2);
            if (firstOrNull instanceof HashTagGroupData) {
                hashTagGroupData = (HashTagGroupData) firstOrNull;
            }
            if (hashTagGroupData != null && hashTagGroupData.e().indexOf(item) == hashTagGroupData.e().size() - 1) {
                return QUIListItemBackgroundType.BottomRound;
            }
            return qUIListItemBackgroundType;
        }
        return qUIListItemBackgroundType;
    }

    @NotNull
    public final ArrayList<cp0.a> e() {
        return this.groupDataList;
    }

    @NotNull
    public final QUIListItemBackgroundType f(@NotNull cp0.a item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item instanceof HashTagTroopInActiveData) {
            return QUIListItemBackgroundType.BottomRound;
        }
        if (item instanceof HashTagGroupData) {
            if (((HashTagGroupData) item).getIsCollapse()) {
                return QUIListItemBackgroundType.AllRound;
            }
            return QUIListItemBackgroundType.TopRound;
        }
        if (item instanceof HashTagTroopData) {
            return d(item);
        }
        if (item instanceof HashTagChannelData) {
            return d(item);
        }
        return QUIListItemBackgroundType.NoneRound;
    }

    public final void k(@NotNull cp0.a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        j(data);
    }

    public final void l(@NotNull HashTagGroupType group) {
        Intrinsics.checkNotNullParameter(group, "group");
        HashTagGroupData c16 = c(group);
        if (c16 == null) {
            return;
        }
        if (!c16.getIsCollapse()) {
            this.groupDataList.removeAll(h(this, group, false, 2, null));
        } else {
            this.groupDataList.addAll(this.groupDataList.indexOf(c16) + 1, c16.e());
        }
        int indexOf = this.groupDataList.indexOf(c16);
        this.groupDataList.remove(c16);
        HashTagGroupData d16 = c16.d();
        d16.l(!c16.getIsCollapse());
        this.groupDataList.add(indexOf, d16);
        i();
    }

    public final void m(@NotNull List<? extends cp0.a> newDataList) {
        Intrinsics.checkNotNullParameter(newDataList, "newDataList");
        this.groupDataList.clear();
        this.groupDataList.addAll(newDataList);
        i();
    }
}
