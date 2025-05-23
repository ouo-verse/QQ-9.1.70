package com.tencent.state.square.layout;

import android.util.Size;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.state.SquareDebug;
import com.tencent.state.VasExtensionsKt;
import com.tencent.state.map.IMapLocator;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapItemKt;
import com.tencent.state.square.ItemStruct;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.data.SquareAvatarExtra;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.data.SquareEmptyData;
import com.tencent.state.square.friendsetting.CloseToMeMoveInfo;
import com.tencent.state.square.friendsetting.PlaceInfo;
import com.tencent.state.square.layout.IDynamicLayoutComponent;
import com.tencent.state.square.layout.SquareDynamicLayoutComponent;
import com.tencent.state.square.resource.SquareResourceManagerKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\b\u0004\u0018\u0000 N2\u00020\u0001:\u0002MNB?\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00070\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000fH\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J\u0016\u0010\u001f\u001a\u00020\u00132\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u001e\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010!2\u0006\u0010\"\u001a\u00020\bH\u0002J\u0010\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0016J\u001e\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0002J\u0010\u0010#\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u000f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0016J\u0012\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\u001e\u001a\u00020\u001bH\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH\u0002J \u0010,\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f2\u0006\u0010-\u001a\u00020\b2\b\b\u0002\u0010.\u001a\u00020\u0017H\u0002J0\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\b2\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J8\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f2\u0006\u00104\u001a\u00020\b2\u0006\u00105\u001a\u0002062\f\u00107\u001a\b\u0012\u0004\u0012\u0002080\u000f2\n\b\u0002\u00100\u001a\u0004\u0018\u000101H\u0002J\u001e\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f2\u0006\u00104\u001a\u00020\b2\u0006\u00102\u001a\u00020\bH\u0002J\"\u00109\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000f0\u00072\u0006\u0010:\u001a\u00020\bH\u0002J\u0010\u0010;\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J \u0010;\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u0017H\u0016J\u001e\u0010=\u001a\u00020\b2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\b0\u000f2\u0006\u0010?\u001a\u00020\bH\u0002J\u0010\u0010@\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010A\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010B\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J$\u0010C\u001a\u00020\u00132\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00150\u0003H\u0002J\"\u0010E\u001a\u00020\u00132\u0006\u00104\u001a\u00020\b2\u0006\u00102\u001a\u00020\b2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0016\u0010E\u001a\u00020\u00132\f\u0010F\u001a\b\u0012\u0004\u0012\u00020&0\u000fH\u0016J\u0018\u0010G\u001a\u00020\u00132\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fH\u0016J8\u0010H\u001a\u00020\u00132\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040K2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH\u0002R \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006O"}, d2 = {"Lcom/tencent/state/square/layout/SquareDynamicLayoutComponent;", "Lcom/tencent/state/square/layout/IDynamicLayoutComponent;", "dataList", "", "Lcom/tencent/state/square/ItemStruct;", "areaList", "Landroid/util/SparseArray;", "Ljava/util/TreeMap;", "", "locator", "Lcom/tencent/state/map/IMapLocator;", "callback", "Lcom/tencent/state/square/layout/OnMoveCallback;", "(Ljava/util/List;Landroid/util/SparseArray;Lcom/tencent/state/map/IMapLocator;Lcom/tencent/state/square/layout/OnMoveCallback;)V", "fixedIndexList", "", "maxRank", "minRank", "adjustDataList", "", "cmdList", "Lcom/tencent/state/square/layout/MoveCommand;", "canReplace", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "debugPrint", "logMsg", "", "doAvatarCloseToMe", "Lcom/tencent/state/square/friendsetting/PlaceInfo;", "uin", "ensureValidDataList", "findFirstAreaUsefulIndex", "Lkotlin/Pair;", "index", "findMoveToIndex", "excludes", "findMoveToIndexList", "Lcom/tencent/state/square/layout/MoveRequest;", "indexList", "getCloseToMeMoveInfo", "Lcom/tencent/state/square/friendsetting/CloseToMeMoveInfo;", "getCloseToMePlace", "getFirstRankDats", "getHideCommands", "hideIndex", "skipAnim", "getMoveCommands", "srcData", "Lcom/tencent/state/map/MapItem;", "dstIndex", "allEmptyItems", "srcIndex", "dst", "Lcom/tencent/state/map/Location;", "areaRanks", "Lcom/tencent/state/square/layout/SquareDynamicLayoutComponent$AreaRank;", "getQuerySequence", GdtGetUserInfoHandler.KEY_AREA, "hide", "itemType", "indexOfEarliestUnreadMessage", "areas", "rank", "isAreaFirst", "isEmptyLocation", "isFixedLocation", "joinCommands", "commands", "move", "requests", "setFixedIndexList", "updateDataList", "removeCmdList", "needMoveMap", "", "addItemList", "AreaRank", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareDynamicLayoutComponent implements IDynamicLayoutComponent {
    private static final String TAG = "SquareLayoutManager";
    private final SparseArray<TreeMap<Integer, ItemStruct>> areaList;
    private final OnMoveCallback callback;
    private final List<ItemStruct> dataList;
    private List<Integer> fixedIndexList;
    private final IMapLocator locator;
    private int maxRank;
    private int minRank;
    private static final AreaRank emptyAreaRank = new AreaRank(-1, -1);

    public SquareDynamicLayoutComponent(List<ItemStruct> dataList, SparseArray<TreeMap<Integer, ItemStruct>> areaList, IMapLocator locator, OnMoveCallback onMoveCallback) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(areaList, "areaList");
        Intrinsics.checkNotNullParameter(locator, "locator");
        this.dataList = dataList;
        this.areaList = areaList;
        this.locator = locator;
        this.callback = onMoveCallback;
        this.minRank = Integer.MAX_VALUE;
        this.maxRank = Integer.MIN_VALUE;
        Iterator<T> it = dataList.iterator();
        while (it.hasNext()) {
            int rank = ((ItemStruct) it.next()).getRank();
            if (rank > this.maxRank) {
                this.maxRank = rank;
            }
            int i3 = this.minRank;
            if (1 <= rank && i3 > rank) {
                this.minRank = rank;
            }
        }
        SquareBaseKt.getSquareLog().d(TAG, "[addRoles] minRank:" + this.minRank + ", maxRank:" + this.maxRank);
    }

    private final boolean canReplace(ItemStruct item) {
        MapItem data = item.getData();
        if (isFixedLocation(item)) {
            return false;
        }
        if (data instanceof SquareAvatarItem) {
            return !SquareResourceManagerKt.hasUnreadMessage((SquareAvatarItem) data);
        }
        return true;
    }

    private final void ensureValidDataList(List<ItemStruct> dataList) {
        Iterator<ItemStruct> it = dataList.iterator();
        int i3 = -1;
        ItemStruct itemStruct = null;
        while (it.hasNext()) {
            ItemStruct next = it.next();
            if (next.getIndex() == i3) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "ensureValidDataList: find same index in dataList, index=" + i3 + "\nremove: " + next + " \nreserve: " + itemStruct, null, 4, null);
                it.remove();
            } else {
                i3++;
                itemStruct = next;
            }
        }
    }

    private final Pair<Integer, Integer> findFirstAreaUsefulIndex(int index) {
        Location itemLocation = this.locator.getItemLocation(index);
        if (itemLocation.getRank() == 1) {
            SquareBaseKt.getSquareLog().i(TAG, "findFirstAreaUsefulIndex cur is inFirstRank");
            return null;
        }
        int i3 = -1;
        int i16 = Integer.MAX_VALUE;
        int i17 = 0;
        int i18 = -1;
        for (Object obj : getFirstRankDats()) {
            int i19 = i17 + 1;
            if (i17 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ItemStruct itemStruct = (ItemStruct) obj;
            if (!itemStruct.getData().getIsFixed()) {
                if (itemStruct.getArea() == itemLocation.getArea()) {
                    return new Pair<>(Integer.valueOf(itemStruct.getIndex()), Integer.valueOf(itemStruct.getArea()));
                }
                int area = itemStruct.getArea() - itemLocation.getArea();
                if (i16 == Integer.MAX_VALUE || ((area > 0 && i16 < 0) || ((area > 0 && i16 > 0 && area < i16) || (area < 0 && i16 < 0 && area < i16)))) {
                    i3 = itemStruct.getIndex();
                    i18 = itemStruct.getArea();
                    i16 = area;
                }
            }
            i17 = i19;
        }
        return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i18));
    }

    private final CloseToMeMoveInfo getCloseToMeMoveInfo(String uin) {
        Object obj;
        Iterator<T> it = this.dataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((ItemStruct) obj).getData().getUin(), uin)) {
                break;
            }
        }
        ItemStruct itemStruct = (ItemStruct) obj;
        if (itemStruct == null) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "getCloseToMeMoveInfo but data is null", null, 4, null);
            return null;
        }
        Pair<Integer, Integer> findFirstAreaUsefulIndex = findFirstAreaUsefulIndex(itemStruct.getIndex());
        if (findFirstAreaUsefulIndex != null && findFirstAreaUsefulIndex.getFirst().intValue() >= 0) {
            return new CloseToMeMoveInfo(itemStruct.getIndex(), findFirstAreaUsefulIndex.getFirst().intValue(), new PlaceInfo(findFirstAreaUsefulIndex.getSecond().intValue(), 1, 0, 4, null));
        }
        SquareBaseKt.getSquareLog().i(TAG, "getCloseToMeMoveInfo but no useful index");
        return null;
    }

    private final List<ItemStruct> getFirstRankDats() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = VasExtensionsKt.getKeys(this.areaList).iterator();
        while (it.hasNext()) {
            ItemStruct itemStruct = this.areaList.get(((Number) it.next()).intValue()).get(1);
            if (itemStruct != null) {
                arrayList.add(itemStruct);
            }
        }
        return arrayList;
    }

    private final List<MoveCommand> getHideCommands(int hideIndex, boolean skipAnim) {
        ItemStruct itemStruct;
        Location itemLocation = this.locator.getItemLocation(hideIndex);
        TreeMap<Integer, ItemStruct> treeMap = this.areaList.get(itemLocation.getArea());
        Intrinsics.checkNotNullExpressionValue(treeMap, "areaList.get(hideItem.area)");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Integer, ItemStruct> entry : treeMap.entrySet()) {
            if (entry.getValue().getRank() > itemLocation.getRank()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList<AreaRank> arrayList = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(new AreaRank(itemLocation.getArea(), ((ItemStruct) ((Map.Entry) it.next()).getValue()).getRank()));
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new MoveCommand(hideIndex, -1, null, skipAnim, 4, null));
        while (true) {
            int i3 = hideIndex;
            for (AreaRank areaRank : arrayList) {
                TreeMap<Integer, ItemStruct> treeMap2 = this.areaList.get(areaRank.getArea());
                itemStruct = treeMap2 != null ? treeMap2.get(Integer.valueOf(areaRank.getRank())) : null;
                if (itemStruct == null || isFixedLocation(itemStruct)) {
                }
            }
            arrayList2.add(new MoveCommand(-1, i3, new SquareEmptyData(this.locator.getItemLocation(i3)), skipAnim));
            return arrayList2;
            arrayList2.add(new MoveCommand(itemStruct.getIndex(), i3, null, skipAnim, 4, null));
            hideIndex = itemStruct.getIndex();
        }
    }

    private final List<MoveCommand> getMoveCommands(MapItem srcData, int dstIndex, List<ItemStruct> allEmptyItems) {
        boolean any;
        Object next;
        ItemStruct itemStruct;
        Collection plus;
        List<AreaRank> plus2;
        Object next2;
        Location itemLocation = this.locator.getItemLocation(dstIndex);
        TreeMap<Integer, ItemStruct> dstArea = this.areaList.get(itemLocation.getArea());
        Integer dstMaxRank = dstArea.lastKey();
        List<ItemStruct> list = allEmptyItems;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next3 = it.next();
            if (((ItemStruct) next3).getArea() == itemLocation.getArea()) {
                arrayList.add(next3);
            }
        }
        any = CollectionsKt___CollectionsKt.any(arrayList);
        if (any) {
            Iterator it5 = arrayList.iterator();
            if (it5.hasNext()) {
                next2 = it5.next();
                if (it5.hasNext()) {
                    int rank = ((ItemStruct) next2).getRank();
                    do {
                        Object next4 = it5.next();
                        int rank2 = ((ItemStruct) next4).getRank();
                        if (rank > rank2) {
                            next2 = next4;
                            rank = rank2;
                        }
                    } while (it5.hasNext());
                }
            } else {
                next2 = null;
            }
            itemStruct = (ItemStruct) next2;
        } else {
            Iterator<T> it6 = list.iterator();
            if (it6.hasNext()) {
                next = it6.next();
                if (it6.hasNext()) {
                    int rank3 = ((ItemStruct) next).getRank();
                    do {
                        Object next5 = it6.next();
                        int rank4 = ((ItemStruct) next5).getRank();
                        if (rank3 > rank4) {
                            next = next5;
                            rank3 = rank4;
                        }
                    } while (it6.hasNext());
                }
            } else {
                next = null;
            }
            itemStruct = (ItemStruct) next;
        }
        AreaRank areaRank = itemStruct != null ? new AreaRank(itemStruct.getArea(), itemStruct.getRank()) : null;
        if (areaRank == null) {
            Intrinsics.checkNotNullExpressionValue(dstArea, "dstArea");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Integer, ItemStruct> entry : dstArea.entrySet()) {
                int rank5 = itemLocation.getRank();
                Intrinsics.checkNotNullExpressionValue(dstMaxRank, "dstMaxRank");
                int intValue = dstMaxRank.intValue();
                int intValue2 = entry.getKey().intValue();
                if (rank5 <= intValue2 && intValue >= intValue2) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            plus = new ArrayList(linkedHashMap.size());
            Iterator it7 = linkedHashMap.entrySet().iterator();
            while (it7.hasNext()) {
                plus.add(new AreaRank(itemLocation.getArea(), ((Number) ((Map.Entry) it7.next()).getKey()).intValue()));
            }
        } else {
            allEmptyItems.remove(itemStruct);
            if (areaRank.getArea() == itemLocation.getArea()) {
                Intrinsics.checkNotNullExpressionValue(dstArea, "dstArea");
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry<Integer, ItemStruct> entry2 : dstArea.entrySet()) {
                    int rank6 = itemLocation.getRank();
                    int rank7 = areaRank.getRank();
                    int intValue3 = entry2.getKey().intValue();
                    if (rank6 <= intValue3 && rank7 >= intValue3) {
                        linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                    }
                }
                plus = new ArrayList(linkedHashMap2.size());
                Iterator it8 = linkedHashMap2.entrySet().iterator();
                while (it8.hasNext()) {
                    plus.add(new AreaRank(itemLocation.getArea(), ((Number) ((Map.Entry) it8.next()).getKey()).intValue()));
                }
            } else {
                Intrinsics.checkNotNullExpressionValue(dstArea, "dstArea");
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (Map.Entry<Integer, ItemStruct> entry3 : dstArea.entrySet()) {
                    int rank8 = itemLocation.getRank();
                    Intrinsics.checkNotNullExpressionValue(dstMaxRank, "dstMaxRank");
                    int intValue4 = dstMaxRank.intValue();
                    int intValue5 = entry3.getKey().intValue();
                    if (rank8 <= intValue5 && intValue4 >= intValue5) {
                        linkedHashMap3.put(entry3.getKey(), entry3.getValue());
                    }
                }
                ArrayList arrayList2 = new ArrayList(linkedHashMap3.size());
                Iterator it9 = linkedHashMap3.entrySet().iterator();
                while (it9.hasNext()) {
                    arrayList2.add(new AreaRank(itemLocation.getArea(), ((Number) ((Map.Entry) it9.next()).getKey()).intValue()));
                }
                plus = CollectionsKt___CollectionsKt.plus((Collection<? extends AreaRank>) ((Collection<? extends Object>) arrayList2), areaRank);
            }
        }
        plus2 = CollectionsKt___CollectionsKt.plus((Collection<? extends AreaRank>) ((Collection<? extends Object>) plus), emptyAreaRank);
        return getMoveCommands(-1, itemLocation, plus2, srcData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ List getMoveCommands$default(SquareDynamicLayoutComponent squareDynamicLayoutComponent, MapItem mapItem, int i3, List list, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            List<ItemStruct> list2 = squareDynamicLayoutComponent.dataList;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list2) {
                if (squareDynamicLayoutComponent.isEmptyLocation((ItemStruct) obj2)) {
                    arrayList.add(obj2);
                }
            }
            list = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        }
        return squareDynamicLayoutComponent.getMoveCommands(mapItem, i3, list);
    }

    private final TreeMap<Integer, List<Integer>> getQuerySequence(int area) {
        List sorted;
        IntRange indices;
        List slice;
        IntRange until;
        List slice2;
        List plus;
        sorted = CollectionsKt___CollectionsKt.sorted(VasExtensionsKt.getKeys(this.areaList));
        int indexOf = sorted.indexOf(Integer.valueOf(area));
        if (indexOf == -1) {
            indexOf = 0;
        }
        indices = CollectionsKt__CollectionsKt.getIndices(sorted);
        slice = CollectionsKt___CollectionsKt.slice(sorted, new IntRange(indexOf, indices.getLast()));
        until = RangesKt___RangesKt.until(0, indexOf);
        slice2 = CollectionsKt___CollectionsKt.slice(sorted, until);
        plus = CollectionsKt___CollectionsKt.plus((Collection) slice, (Iterable) slice2);
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        int i3 = this.minRank;
        int i16 = this.maxRank;
        if (i3 <= i16) {
            while (true) {
                Integer valueOf = Integer.valueOf(i3);
                ArrayList arrayList = new ArrayList();
                for (Object obj : plus) {
                    if (this.areaList.get(((Number) obj).intValue()).containsKey(Integer.valueOf(i3))) {
                        arrayList.add(obj);
                    }
                }
                treeMap.put(valueOf, arrayList);
                if (i3 == i16) {
                    break;
                }
                i3++;
            }
        }
        return treeMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006b, code lost:
    
        if (com.tencent.state.square.resource.SquareResourceManagerKt.hasUnreadMessage(r3) == true) goto L23;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0071 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0040 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int indexOfEarliestUnreadMessage(List<Integer> areas, int rank) {
        ItemStruct itemStruct;
        SquareAvatarExtra extra;
        SquareAvatarExtra extra2;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        Iterator it = areas.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TreeMap<Integer, ItemStruct> treeMap = this.areaList.get(((Number) it.next()).intValue());
            itemStruct = treeMap != null ? treeMap.get(Integer.valueOf(rank)) : null;
            if (itemStruct != null) {
                arrayList.add(itemStruct);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            ItemStruct it5 = (ItemStruct) obj;
            MapItem data = it5.getData();
            if (!(data instanceof SquareAvatarItem)) {
                data = null;
            }
            SquareAvatarItem squareAvatarItem = (SquareAvatarItem) data;
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            if (!isFixedLocation(it5)) {
                z16 = true;
                if (squareAvatarItem != null) {
                }
                if (!z16) {
                    arrayList2.add(obj);
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        Iterator it6 = arrayList2.iterator();
        if (it6.hasNext()) {
            ?? next = it6.next();
            if (it6.hasNext()) {
                MapItem data2 = ((ItemStruct) next).getData();
                if (!(data2 instanceof SquareAvatarItem)) {
                    data2 = null;
                }
                SquareAvatarItem squareAvatarItem2 = (SquareAvatarItem) data2;
                long unReadTimestamp = (squareAvatarItem2 == null || (extra2 = squareAvatarItem2.getExtra()) == null) ? 0L : extra2.unReadTimestamp();
                do {
                    Object next2 = it6.next();
                    MapItem data3 = ((ItemStruct) next2).getData();
                    if (!(data3 instanceof SquareAvatarItem)) {
                        data3 = null;
                    }
                    SquareAvatarItem squareAvatarItem3 = (SquareAvatarItem) data3;
                    long unReadTimestamp2 = (squareAvatarItem3 == null || (extra = squareAvatarItem3.getExtra()) == null) ? 0L : extra.unReadTimestamp();
                    next = next;
                    if (unReadTimestamp > unReadTimestamp2) {
                        next = next2;
                        unReadTimestamp = unReadTimestamp2;
                    }
                } while (it6.hasNext());
            }
            itemStruct = next;
        }
        ItemStruct itemStruct2 = itemStruct;
        if (itemStruct2 != null) {
            return itemStruct2.getIndex();
        }
        return -1;
    }

    private final boolean isAreaFirst(ItemStruct item) {
        TreeMap<Integer, ItemStruct> treeMap = this.areaList.get(item.getArea());
        Integer firstKey = treeMap != null ? treeMap.firstKey() : null;
        return firstKey != null && firstKey.intValue() == item.getRank();
    }

    private final boolean isEmptyLocation(ItemStruct item) {
        return item.getData() instanceof SquareEmptyData;
    }

    private final boolean isFixedLocation(ItemStruct item) {
        if (!item.getData().getIsFixed()) {
            List<Integer> list = this.fixedIndexList;
            if (!(list != null ? list.contains(Integer.valueOf(item.getIndex())) : false)) {
                return false;
            }
        }
        return true;
    }

    private final void joinCommands(List<MoveCommand> commands, List<MoveCommand> joinCommands) {
        Object obj;
        if (joinCommands.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(joinCommands, new Comparator<T>() { // from class: com.tencent.state.square.layout.SquareDynamicLayoutComponent$joinCommands$$inlined$sortByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t16, T t17) {
                    int compareValues;
                    compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((MoveCommand) t17).getFrom()), Integer.valueOf(((MoveCommand) t16).getFrom()));
                    return compareValues;
                }
            });
        }
        Iterator<MoveCommand> it = joinCommands.iterator();
        while (it.hasNext()) {
            MoveCommand next = it.next();
            Iterator<T> it5 = commands.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it5.next();
                    if (((MoveCommand) obj).getTo() == next.getFrom() && next.getFrom() >= 0) {
                        break;
                    }
                }
            }
            MoveCommand moveCommand = (MoveCommand) obj;
            if (moveCommand != null) {
                moveCommand.setTo(next.getTo());
                it.remove();
            }
        }
        commands.addAll(joinCommands);
    }

    private final void updateDataList(List<MoveCommand> removeCmdList, Map<Integer, ItemStruct> needMoveMap, List<ItemStruct> addItemList) {
        List<ItemStruct> mutableList;
        SquareDebug squareDebug = SquareDebug.INSTANCE;
        squareDebug.printMoveCommandInfo("[addRoles] updateDataList, remove", removeCmdList);
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) addItemList);
        squareDebug.printItemStructInfo("[addRoles] updateDataList, add", mutableList);
        squareDebug.printItemStructInfoMap("[addRoles] updateDataList, move", needMoveMap);
        TreeMap treeMap = new TreeMap();
        for (final MoveCommand moveCommand : removeCmdList) {
            CollectionsKt__MutableCollectionsKt.removeAll((List) this.dataList, (Function1) new Function1<ItemStruct, Boolean>() { // from class: com.tencent.state.square.layout.SquareDynamicLayoutComponent$updateDataList$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(ItemStruct itemStruct) {
                    return Boolean.valueOf(invoke2(itemStruct));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(ItemStruct it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getIndex() == MoveCommand.this.getFrom();
                }
            });
        }
        for (Map.Entry<Integer, ItemStruct> entry : needMoveMap.entrySet()) {
            entry.getValue().setIndex(entry.getKey().intValue());
            treeMap.put(entry.getKey(), entry.getValue());
        }
        for (ItemStruct itemStruct : addItemList) {
            this.dataList.add(itemStruct);
            treeMap.put(Integer.valueOf(itemStruct.getIndex()), itemStruct);
        }
        for (ItemStruct itemStruct2 : this.dataList) {
            if (!treeMap.containsKey(Integer.valueOf(itemStruct2.getIndex()))) {
                treeMap.put(Integer.valueOf(itemStruct2.getIndex()), itemStruct2);
            }
        }
        this.dataList.clear();
        List<ItemStruct> list = this.dataList;
        Collection<? extends ItemStruct> values = treeMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "newDataList.values");
        list.addAll(values);
        CollectionsKt__MutableCollectionsJVMKt.sortWith(this.dataList, new Comparator<ItemStruct>() { // from class: com.tencent.state.square.layout.SquareDynamicLayoutComponent$updateDataList$5
            @Override // java.util.Comparator
            public final int compare(ItemStruct itemStruct3, ItemStruct itemStruct4) {
                return itemStruct3.getIndex() - itemStruct4.getIndex();
            }
        });
        VasExtensionsKt.forEach(this.areaList, new Function2<Integer, TreeMap<Integer, ItemStruct>, Unit>() { // from class: com.tencent.state.square.layout.SquareDynamicLayoutComponent$updateDataList$6
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, TreeMap<Integer, ItemStruct> treeMap2) {
                invoke(num.intValue(), treeMap2);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, TreeMap<Integer, ItemStruct> map) {
                Intrinsics.checkNotNullParameter(map, "map");
                map.clear();
            }
        });
        for (ItemStruct itemStruct3 : this.dataList) {
            TreeMap<Integer, ItemStruct> treeMap2 = this.areaList.get(itemStruct3.getArea());
            if (treeMap2 != null) {
                treeMap2.put(Integer.valueOf(itemStruct3.getRank()), itemStruct3);
            }
        }
    }

    @Override // com.tencent.state.square.layout.IDynamicLayoutComponent
    public void debugPrint(String logMsg) {
        Intrinsics.checkNotNullParameter(logMsg, "logMsg");
        SquareDebug squareDebug = SquareDebug.INSTANCE;
        squareDebug.printItemStructInfo(logMsg + ", dataList", this.dataList);
        squareDebug.printAreaInfo(logMsg + ", areaList", this.areaList);
    }

    @Override // com.tencent.state.square.layout.IDynamicLayoutComponent
    public PlaceInfo doAvatarCloseToMe(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        CloseToMeMoveInfo closeToMeMoveInfo = getCloseToMeMoveInfo(uin);
        if (closeToMeMoveInfo == null) {
            return null;
        }
        IDynamicLayoutComponent.DefaultImpls.move$default(this, closeToMeMoveInfo.getFromIndex(), closeToMeMoveInfo.getToIndex(), null, 4, null);
        return closeToMeMoveInfo.getToPlaceInfo();
    }

    @Override // com.tencent.state.square.layout.IDynamicLayoutComponent
    public int findMoveToIndex(String uin) {
        Object obj;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Iterator<T> it = this.dataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((ItemStruct) obj).getData().getUin(), uin)) {
                break;
            }
        }
        ItemStruct itemStruct = (ItemStruct) obj;
        return findMoveToIndex(itemStruct != null ? itemStruct.getIndex() : -1);
    }

    @Override // com.tencent.state.square.layout.IDynamicLayoutComponent
    public List<MoveRequest> findMoveToIndexList(List<Integer> indexList) {
        Intrinsics.checkNotNullParameter(indexList, "indexList");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = indexList.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            int findMoveToIndex = findMoveToIndex(intValue, arrayList);
            arrayList2.add(new MoveRequest(new MoveSource(intValue, null, 2, null), findMoveToIndex));
            arrayList.add(Integer.valueOf(findMoveToIndex));
        }
        return arrayList2;
    }

    @Override // com.tencent.state.square.layout.IDynamicLayoutComponent
    public PlaceInfo getCloseToMePlace(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        CloseToMeMoveInfo closeToMeMoveInfo = getCloseToMeMoveInfo(uin);
        if (closeToMeMoveInfo != null) {
            return closeToMeMoveInfo.getToPlaceInfo();
        }
        return null;
    }

    @Override // com.tencent.state.square.layout.IDynamicLayoutComponent
    public boolean hide(String uin) {
        Object obj;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Iterator<T> it = this.dataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((ItemStruct) obj).getData().getUin(), uin)) {
                break;
            }
        }
        ItemStruct itemStruct = (ItemStruct) obj;
        int index = itemStruct != null ? itemStruct.getIndex() : -1;
        if (index < 0) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "hide " + uin + " but index is " + index, null, 4, null);
            return false;
        }
        List<MoveCommand> hideCommands$default = getHideCommands$default(this, index, false, 2, null);
        OnMoveCallback onMoveCallback = this.callback;
        if (onMoveCallback != null) {
            onMoveCallback.onMove(hideCommands$default);
        }
        adjustDataList(hideCommands$default);
        return true;
    }

    @Override // com.tencent.state.square.layout.IDynamicLayoutComponent
    public void move(int srcIndex, int dstIndex, MapItem srcData) {
        if (srcIndex == dstIndex) {
            return;
        }
        List<MoveCommand> moveCommands$default = srcIndex < 0 ? getMoveCommands$default(this, srcData, dstIndex, null, 4, null) : getMoveCommands(srcIndex, dstIndex);
        OnMoveCallback onMoveCallback = this.callback;
        if (onMoveCallback != null) {
            onMoveCallback.onMove(moveCommands$default);
        }
        adjustDataList(moveCommands$default);
    }

    @Override // com.tencent.state.square.layout.IDynamicLayoutComponent
    public void setFixedIndexList(List<Integer> indexList) {
        this.fixedIndexList = indexList;
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001J\u0006\u0010\u0010\u001a\u00020\rJ\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/square/layout/SquareDynamicLayoutComponent$AreaRank;", "", GdtGetUserInfoHandler.KEY_AREA, "", "rank", "(II)V", "getArea", "()I", "getRank", "component1", "component2", "copy", "equals", "", "other", "hashCode", "isInvalid", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final /* data */ class AreaRank {
        private final int area;
        private final int rank;

        public AreaRank(int i3, int i16) {
            this.area = i3;
            this.rank = i16;
        }

        /* renamed from: component1, reason: from getter */
        public final int getArea() {
            return this.area;
        }

        /* renamed from: component2, reason: from getter */
        public final int getRank() {
            return this.rank;
        }

        public final AreaRank copy(int area, int rank) {
            return new AreaRank(area, rank);
        }

        public final int getArea() {
            return this.area;
        }

        public final int getRank() {
            return this.rank;
        }

        public int hashCode() {
            return (this.area * 31) + this.rank;
        }

        public final boolean isInvalid() {
            return this.area < 0 || this.rank < 0;
        }

        public String toString() {
            return "AreaRank(area=" + this.area + ", rank=" + this.rank + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AreaRank)) {
                return false;
            }
            AreaRank areaRank = (AreaRank) other;
            return this.area == areaRank.area && this.rank == areaRank.rank;
        }

        public static /* synthetic */ AreaRank copy$default(AreaRank areaRank, int i3, int i16, int i17, Object obj) {
            if ((i17 & 1) != 0) {
                i3 = areaRank.area;
            }
            if ((i17 & 2) != 0) {
                i16 = areaRank.rank;
            }
            return areaRank.copy(i3, i16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void adjustDataList(List<MoveCommand> cmdList) {
        List<MoveCommand> sortedWith;
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(cmdList, new Comparator<T>() { // from class: com.tencent.state.square.layout.SquareDynamicLayoutComponent$adjustDataList$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((MoveCommand) t17).getFrom()), Integer.valueOf(((MoveCommand) t16).getFrom()));
                return compareValues;
            }
        });
        SquareDebug.INSTANCE.printMoveCommandInfo("[addRoles] adjustDataList", cmdList);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (MoveCommand moveCommand : sortedWith) {
            if (moveCommand.getFrom() >= 0 || moveCommand.getTo() >= 0) {
                ItemStruct itemStruct = null;
                if (moveCommand.getFrom() < 0) {
                    MapItem fromData = moveCommand.getFromData();
                    if (fromData != null) {
                        itemStruct = new ItemStruct(moveCommand.getTo(), fromData);
                    }
                } else {
                    Iterator<T> it = this.dataList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (((ItemStruct) next).getIndex() == moveCommand.getFrom()) {
                            itemStruct = next;
                            break;
                        }
                    }
                    itemStruct = itemStruct;
                }
                if (itemStruct != null) {
                    if (moveCommand.getTo() >= 0) {
                        itemStruct.getData().setLocation(MapItemKt.relocation(this.locator.getItemLocation(moveCommand.getTo()), new Size(itemStruct.getData().getLocation().getWidth(), itemStruct.getData().getLocation().getHeight())));
                        this.locator.setItemLocation(moveCommand.getTo(), itemStruct.getData());
                        if (moveCommand.getFrom() >= 0) {
                            linkedHashMap.put(Integer.valueOf(moveCommand.getTo()), itemStruct);
                        }
                    }
                    if (moveCommand.getFrom() < 0) {
                        arrayList2.add(itemStruct);
                    }
                    if (moveCommand.getTo() < 0) {
                        arrayList.add(moveCommand);
                    }
                }
            }
        }
        updateDataList(arrayList, linkedHashMap, arrayList2);
        ensureValidDataList(this.dataList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int findMoveToIndex(int index, List<Integer> excludes) {
        ItemStruct itemStruct;
        Object obj;
        ItemStruct itemStruct2;
        Iterator<T> it = this.dataList.iterator();
        while (true) {
            itemStruct = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            ItemStruct itemStruct3 = (ItemStruct) obj;
            if (itemStruct3.getArea() > -1 && (itemStruct3.getData() instanceof SquareEmptyData)) {
                break;
            }
        }
        boolean z16 = obj == null;
        boolean z17 = index == -1;
        if (z16 && z17) {
            SquareBaseKt.getSquareLog().i(TAG, "[addRoles] findMoveToIndex: " + index + ", noSpace.");
            return -1;
        }
        if (index != -1) {
            Iterator<T> it5 = this.dataList.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next = it5.next();
                if (((ItemStruct) next).getIndex() == index) {
                    itemStruct = next;
                    break;
                }
            }
            itemStruct = itemStruct;
        }
        if (itemStruct != null && (isAreaFirst(itemStruct) || isFixedLocation(itemStruct))) {
            SquareBaseKt.getSquareLog().i(TAG, "[addRoles] findMoveToIndex: " + index + ", already in the nearest.");
            return index;
        }
        if (itemStruct == null && VasExtensionsKt.getKeys(this.areaList).isEmpty()) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "[addRoles] findMoveToIndex: " + index + " but keys is empty", null, 4, null);
            return index;
        }
        Set<Map.Entry<Integer, List<Integer>>> entrySet = getQuerySequence(itemStruct != null ? itemStruct.getArea() : 0).entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "getQuerySequence(startArea).entries");
        Iterator<T> it6 = entrySet.iterator();
        while (it6.hasNext()) {
            Map.Entry entry = (Map.Entry) it6.next();
            Object key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "it.key");
            int intValue = ((Number) key).intValue();
            Object value = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "it.value");
            List<Integer> list = (List) value;
            if (index >= 0) {
                if (intValue >= (itemStruct != null ? itemStruct.getRank() : 0)) {
                    return index;
                }
            }
            Iterator<Integer> it7 = list.iterator();
            while (it7.hasNext()) {
                TreeMap<Integer, ItemStruct> treeMap = this.areaList.get(it7.next().intValue());
                if (treeMap != null && (itemStruct2 = treeMap.get(Integer.valueOf(intValue))) != null) {
                    Intrinsics.checkNotNullExpressionValue(itemStruct2, "areaList.get(area)?.get(rank) ?: continue");
                    if (canReplace(itemStruct2) && !excludes.contains(Integer.valueOf(itemStruct2.getIndex()))) {
                        return itemStruct2.getIndex();
                    }
                }
            }
            int indexOfEarliestUnreadMessage = indexOfEarliestUnreadMessage(list, intValue);
            if (indexOfEarliestUnreadMessage >= 0 && !excludes.contains(Integer.valueOf(indexOfEarliestUnreadMessage))) {
                return indexOfEarliestUnreadMessage;
            }
        }
        return index;
    }

    /* JADX WARN: Incorrect condition in loop: B:55:0x0137 */
    @Override // com.tencent.state.square.layout.IDynamicLayoutComponent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void move(List<MoveRequest> requests) {
        final List<ItemStruct> mutableList;
        Object first;
        List<MoveRequest> sortedWith;
        boolean any;
        List mutableList2;
        Intrinsics.checkNotNullParameter(requests, "requests");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = requests.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            MoveRequest moveRequest = (MoveRequest) next;
            if (moveRequest.getSrc().getIndex() == -1 && moveRequest.getDstIndex() != -1 && moveRequest.getDstIndex() < this.dataList.size()) {
                arrayList.add(next);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : arrayList) {
            Integer valueOf = Integer.valueOf(this.dataList.get(((MoveRequest) obj).getDstIndex()).getArea());
            Object obj2 = linkedHashMap.get(valueOf);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(valueOf, obj2);
            }
            ((List) obj2).add(obj);
        }
        final ArrayList arrayList2 = new ArrayList();
        List<ItemStruct> list = this.dataList;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : list) {
            if (isEmptyLocation((ItemStruct) obj3)) {
                arrayList3.add(obj3);
            }
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList3);
        for (List list2 : linkedHashMap.values()) {
            if (!list2.isEmpty()) {
                if (list2.size() == 1) {
                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list2);
                    MoveRequest moveRequest2 = (MoveRequest) first;
                    arrayList2.addAll(getMoveCommands(moveRequest2.getSrc().getData(), moveRequest2.getDstIndex(), mutableList));
                } else {
                    LinkedList linkedList = new LinkedList();
                    sortedWith = CollectionsKt___CollectionsKt.sortedWith(list2, new Comparator<T>() { // from class: com.tencent.state.square.layout.SquareDynamicLayoutComponent$move$$inlined$forEach$lambda$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t16, T t17) {
                            List list3;
                            List list4;
                            int compareValues;
                            list3 = SquareDynamicLayoutComponent.this.dataList;
                            Integer valueOf2 = Integer.valueOf(((ItemStruct) list3.get(((MoveRequest) t16).getDstIndex())).getRank());
                            list4 = SquareDynamicLayoutComponent.this.dataList;
                            compareValues = ComparisonsKt__ComparisonsKt.compareValues(valueOf2, Integer.valueOf(((ItemStruct) list4.get(((MoveRequest) t17).getDstIndex())).getRank()));
                            return compareValues;
                        }
                    });
                    for (MoveRequest moveRequest3 : sortedWith) {
                        mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) getMoveCommands(moveRequest3.getSrc().getData(), moveRequest3.getDstIndex(), mutableList));
                        linkedList.offer(mutableList2);
                    }
                    List<MoveCommand> commands = (List) linkedList.removeFirst();
                    while (any) {
                        List<MoveCommand> joinCommands = (List) linkedList.removeFirst();
                        Intrinsics.checkNotNullExpressionValue(commands, "commands");
                        Intrinsics.checkNotNullExpressionValue(joinCommands, "joinCommands");
                        joinCommands(commands, joinCommands);
                    }
                    Intrinsics.checkNotNullExpressionValue(commands, "commands");
                    arrayList2.addAll(commands);
                }
            }
        }
        OnMoveCallback onMoveCallback = this.callback;
        if (onMoveCallback != null) {
            onMoveCallback.onMove(arrayList2);
        }
        adjustDataList(arrayList2);
    }

    static /* synthetic */ List getMoveCommands$default(SquareDynamicLayoutComponent squareDynamicLayoutComponent, int i3, Location location, List list, MapItem mapItem, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            mapItem = null;
        }
        return squareDynamicLayoutComponent.getMoveCommands(i3, location, list, mapItem);
    }

    static /* synthetic */ List getHideCommands$default(SquareDynamicLayoutComponent squareDynamicLayoutComponent, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = false;
        }
        return squareDynamicLayoutComponent.getHideCommands(i3, z16);
    }

    @Override // com.tencent.state.square.layout.IDynamicLayoutComponent
    public boolean hide(String uin, int itemType, boolean skipAnim) {
        Object obj;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Iterator<T> it = this.dataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            ItemStruct itemStruct = (ItemStruct) obj;
            if (Intrinsics.areEqual(itemStruct.getData().getUin(), uin) && itemStruct.getData().getType() == itemType) {
                break;
            }
        }
        ItemStruct itemStruct2 = (ItemStruct) obj;
        int index = itemStruct2 != null ? itemStruct2.getIndex() : -1;
        if (index < 0) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "hide " + uin + " (" + itemType + ") but index is " + index, null, 4, null);
            return false;
        }
        List<MoveCommand> hideCommands = getHideCommands(index, skipAnim);
        OnMoveCallback onMoveCallback = this.callback;
        if (onMoveCallback != null) {
            onMoveCallback.onMove(hideCommands);
        }
        adjustDataList(hideCommands);
        return true;
    }

    @Override // com.tencent.state.square.layout.IDynamicLayoutComponent
    public int findMoveToIndex(int index) {
        List<Integer> listOf;
        Object firstOrNull;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(index));
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) findMoveToIndexList(listOf));
        MoveRequest moveRequest = (MoveRequest) firstOrNull;
        if (moveRequest != null) {
            return moveRequest.getDstIndex();
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x01cf, code lost:
    
        if (r0 != null) goto L63;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<MoveCommand> getMoveCommands(int srcIndex, int dstIndex) {
        Collection emptyList;
        List emptyList2;
        List plus;
        List emptyList3;
        List<MoveCommand> emptyList4;
        Location itemLocation = this.locator.getItemLocation(srcIndex);
        Location itemLocation2 = this.locator.getItemLocation(dstIndex);
        if (itemLocation.getArea() == itemLocation2.getArea()) {
            if (itemLocation.getRank() == itemLocation2.getRank()) {
                emptyList4 = CollectionsKt__CollectionsKt.emptyList();
                return emptyList4;
            }
            int min = Math.min(itemLocation.getRank(), itemLocation2.getRank());
            int max = Math.max(itemLocation.getRank(), itemLocation2.getRank());
            TreeMap<Integer, ItemStruct> treeMap = this.areaList.get(itemLocation.getArea());
            if (treeMap == null) {
                emptyList3 = CollectionsKt__CollectionsKt.emptyList();
            } else {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<Integer, ItemStruct> entry : treeMap.entrySet()) {
                    int intValue = entry.getKey().intValue();
                    if (min <= intValue && max >= intValue) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                emptyList3 = new ArrayList(linkedHashMap.size());
                Iterator it = linkedHashMap.entrySet().iterator();
                while (it.hasNext()) {
                    emptyList3.add(new AreaRank(itemLocation.getArea(), ((Number) ((Map.Entry) it.next()).getKey()).intValue()));
                }
            }
            return getMoveCommands$default(this, srcIndex, itemLocation2, emptyList3, null, 8, null);
        }
        TreeMap<Integer, ItemStruct> treeMap2 = this.areaList.get(itemLocation2.getArea());
        if (treeMap2 == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry<Integer, ItemStruct> entry2 : treeMap2.entrySet()) {
                if (entry2.getKey().intValue() >= itemLocation2.getRank()) {
                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                }
            }
            emptyList = new ArrayList(linkedHashMap2.size());
            Iterator it5 = linkedHashMap2.entrySet().iterator();
            while (it5.hasNext()) {
                emptyList.add(new AreaRank(itemLocation2.getArea(), ((Number) ((Map.Entry) it5.next()).getKey()).intValue()));
            }
        }
        TreeMap<Integer, ItemStruct> treeMap3 = this.areaList.get(itemLocation.getArea());
        if (treeMap3 != null) {
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry<Integer, ItemStruct> entry3 : treeMap3.entrySet()) {
                if (entry3.getKey().intValue() >= itemLocation.getRank()) {
                    linkedHashMap3.put(entry3.getKey(), entry3.getValue());
                }
            }
            ArrayList arrayList = new ArrayList(linkedHashMap3.size());
            Iterator it6 = linkedHashMap3.entrySet().iterator();
            while (it6.hasNext()) {
                arrayList.add(new AreaRank(itemLocation.getArea(), ((Number) ((Map.Entry) it6.next()).getKey()).intValue()));
            }
            emptyList2 = CollectionsKt___CollectionsKt.sortedWith(arrayList, new Comparator<T>() { // from class: com.tencent.state.square.layout.SquareDynamicLayoutComponent$getMoveCommands$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t16, T t17) {
                    int compareValues;
                    compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((SquareDynamicLayoutComponent.AreaRank) t17).getRank()), Integer.valueOf(((SquareDynamicLayoutComponent.AreaRank) t16).getRank()));
                    return compareValues;
                }
            });
        }
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        plus = CollectionsKt___CollectionsKt.plus(emptyList, (Iterable) emptyList2);
        return getMoveCommands$default(this, srcIndex, itemLocation2, plus, null, 8, null);
    }

    private final List<MoveCommand> getMoveCommands(int srcIndex, Location dst, List<AreaRank> areaRanks, MapItem srcData) {
        ItemStruct itemStruct;
        ArrayList arrayList = new ArrayList();
        ItemStruct itemStruct2 = null;
        for (AreaRank areaRank : areaRanks) {
            if (!areaRank.isInvalid()) {
                TreeMap<Integer, ItemStruct> treeMap = this.areaList.get(areaRank.getArea());
                if (treeMap != null && (itemStruct = treeMap.get(Integer.valueOf(areaRank.getRank()))) != null) {
                    Intrinsics.checkNotNullExpressionValue(itemStruct, "areaList.get(p.area)?.get(p.rank) ?: continue");
                    if (itemStruct.getIndex() == srcIndex || !isFixedLocation(itemStruct)) {
                        if (itemStruct.getArea() == dst.getArea() && itemStruct.getRank() == dst.getRank()) {
                            arrayList.add(new MoveCommand(srcIndex, itemStruct.getIndex(), srcData, false, 8, null));
                        } else if (itemStruct2 != null) {
                            arrayList.add(new MoveCommand(itemStruct2.getIndex(), itemStruct.getIndex(), null, false, 12, null));
                        }
                        itemStruct2 = itemStruct;
                    }
                }
            } else if (itemStruct2 != null) {
                arrayList.add(new MoveCommand(itemStruct2.getIndex(), -1, null, false, 12, null));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            MoveCommand moveCommand = (MoveCommand) obj;
            if (!(moveCommand.getFrom() < 0 && moveCommand.getTo() < 0)) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }
}
