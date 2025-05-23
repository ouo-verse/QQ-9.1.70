package com.tencent.state.square;

import android.content.Context;
import android.util.Size;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.state.SquareDebug;
import com.tencent.state.map.IMapLocator;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapItemKt;
import com.tencent.state.service.IVasBatchGroupInfoService;
import com.tencent.state.service.VasStatusSquareService;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.api.SquareMessageRecord;
import com.tencent.state.square.chatland.data.ChatLandAvatarItem;
import com.tencent.state.square.data.SquareAvatarExtra;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.data.SquareAvatarItemKt;
import com.tencent.state.square.data.SquareTroopItem;
import com.tencent.state.square.friendsetting.PlaceInfo;
import com.tencent.state.square.layout.IDynamicLayoutComponent;
import com.tencent.state.square.layout.MoveRequest;
import com.tencent.state.square.layout.MoveSource;
import com.tencent.state.square.layout.OnMoveCallback;
import com.tencent.state.square.layout.SquareDynamicLayoutComponent;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import ht4.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 :2\u00020\u0001:\u0001:B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\"\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u0007H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u0014H\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\b2\u0006\u0010!\u001a\u00020\u000fH\u0016J\u001c\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100#2\u0006\u0010$\u001a\u00020\u000fH\u0002J$\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020&0*H\u0002J.\u0010,\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010-\u001a\u00020.2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020&0*H\u0002J\u001c\u00100\u001a\u00020\u000f2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002020*H\u0016J\u0018\u00103\u001a\u00020&2\u0006\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\bH\u0016J\u0010\u00106\u001a\u00020&2\u0006\u0010\u001c\u001a\u00020\bH\u0002J\u0018\u00107\u001a\u00020&2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\bH\u0016J\u0010\u00108\u001a\u00020&2\u0006\u0010-\u001a\u000209H\u0016R \u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2 = {"Lcom/tencent/state/square/SquareAreaRankAdapter;", "Lcom/tencent/state/square/SquareBaseAdapter;", "context", "Landroid/content/Context;", "locator", "Lcom/tencent/state/map/IMapLocator;", "data", "", "Lcom/tencent/state/map/MapItem;", "callback", "Lcom/tencent/state/square/layout/OnMoveCallback;", "(Landroid/content/Context;Lcom/tencent/state/map/IMapLocator;Ljava/util/List;Lcom/tencent/state/square/layout/OnMoveCallback;)V", "areaList", "Landroid/util/SparseArray;", "Ljava/util/TreeMap;", "", "Lcom/tencent/state/square/ItemStruct;", "dataList", "Ljava/util/LinkedList;", "layoutManager", "Lcom/tencent/state/square/layout/IDynamicLayoutComponent;", "doAirborneLanding", "", "Lcom/tencent/state/square/MoveItem;", "Lcom/tencent/state/square/MoveResult;", VideoTemplateParser.ITEM_LIST, "doAvatarSetTop", "Lcom/tencent/state/square/friendsetting/PlaceInfo;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "unReadMsgCount", "getDynamicLayoutComponent", "getItemCount", "getItemData", "index", "getRankList", "", GdtGetUserInfoHandler.KEY_AREA, "getTroopInfo", "", "uin", "", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/state/square/data/SquareTroopItem;", "getUserInfo", "message", "Lcom/tencent/state/square/api/SquareMessageRecord;", "Lcom/tencent/state/square/data/SquareAvatarItem;", "indexOf", "block", "", "insetItemData", "position", "mapItem", "onUpdateSquareItem", "setItemData", "updateUnreadMessage", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareAreaRankAdapter extends SquareBaseAdapter {
    private static final boolean AUTO_ADD_WHEN_AVATAR_NOT_IN_SQUARE = false;
    private static final String TAG = "SquareAreaRankAdapter";
    private final SparseArray<TreeMap<Integer, ItemStruct>> areaList;
    private final LinkedList<ItemStruct> dataList;
    private final IDynamicLayoutComponent layoutManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareAreaRankAdapter(Context context, IMapLocator locator, List<? extends MapItem> data, OnMoveCallback onMoveCallback) {
        super(context, locator);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(locator, "locator");
        Intrinsics.checkNotNullParameter(data, "data");
        this.dataList = new LinkedList<>();
        this.areaList = new SparseArray<>();
        int i3 = 0;
        for (Object obj : data) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            MapItem mapItem = (MapItem) obj;
            int area = mapItem.getLocation().getArea();
            int rank = mapItem.getLocation().getRank();
            ItemStruct itemStruct = new ItemStruct(i3, mapItem);
            this.dataList.add(i3, itemStruct);
            getRankList(area).put(Integer.valueOf(rank), itemStruct);
            i3 = i16;
        }
        setMeIndex(indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.SquareAreaRankAdapter.2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(MapItem mapItem2) {
                return Boolean.valueOf(invoke2(mapItem2));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(MapItem it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return (it instanceof SquareAvatarItem) && ((SquareAvatarItem) it).isMe();
            }
        }));
        this.layoutManager = new SquareDynamicLayoutComponent(this.dataList, this.areaList, locator, onMoveCallback);
    }

    private final Map<Integer, ItemStruct> getRankList(int area) {
        TreeMap<Integer, ItemStruct> treeMap = this.areaList.get(area);
        if (treeMap != null) {
            return treeMap;
        }
        TreeMap<Integer, ItemStruct> treeMap2 = new TreeMap<>();
        this.areaList.put(area, treeMap2);
        return treeMap2;
    }

    private final void getTroopInfo(String uin, Function1<? super SquareTroopItem, Unit> onSuccess) {
        Long longOrNull;
        long[] longArray;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(uin);
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            IVasBatchGroupInfoService iVasBatchGroupInfoService = (IVasBatchGroupInfoService) Square.INSTANCE.getConfig().getRapier().b(IVasBatchGroupInfoService.class);
            a aVar = new a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(longValue));
            longArray = CollectionsKt___CollectionsKt.toLongArray(arrayList);
            aVar.f406258a = longArray;
            Unit unit = Unit.INSTANCE;
            iVasBatchGroupInfoService.getGroupInfo(aVar).a(new SquareAreaRankAdapter$getTroopInfo$1(onSuccess));
        }
    }

    private final void getUserInfo(String uin, SquareMessageRecord message, Function1<? super SquareAvatarItem, Unit> onSuccess) {
        Size size = new Size(getLocator().getMapWidth(), getLocator().getMapHeight());
        SquareBaseKt.getSquareLog().i(TAG, "getUserInfo uin = " + uin);
        VasStatusSquareService.getUserInfo$default(VasStatusSquareService.INSTANCE, uin, null, message, size, new SquareAreaRankAdapter$getUserInfo$1(uin, onSuccess), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onUpdateSquareItem(MapItem item) {
        int indexOf = indexOf(item);
        if (indexOf >= 0) {
            item.setLocation(MapItemKt.relocation(getLocator().getItemLocation(this.dataList.get(indexOf).getIndex()), new Size(item.getLocation().getWidth(), item.getLocation().getHeight())));
            getLocator().setItemLocation(indexOf, item);
            setItemData(indexOf, item);
            notifyItemChanged(indexOf);
        }
    }

    @Override // com.tencent.state.square.SquareBaseAdapter
    public Map<MoveItem, MoveResult> doAirborneLanding(List<MoveItem> itemList) {
        int collectionSizeOrDefault;
        Object orNull;
        MoveType moveType;
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        this.layoutManager.debugPrint("[addRoles] doAirborneLanding_start");
        HashMap hashMap = new HashMap();
        ArrayList<MoveItem> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = itemList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            final MoveItem moveItem = (MoveItem) it.next();
            int indexOf = indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.SquareAreaRankAdapter$doAirborneLanding$1$index$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(MapItem mapItem) {
                    return Boolean.valueOf(invoke2(mapItem));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(MapItem it5) {
                    Intrinsics.checkNotNullParameter(it5, "it");
                    return Intrinsics.areEqual(MoveItem.this.getUin(), it5.getUin()) && MoveItem.this.getUnitType() == it5.getUnitType() && !(it5 instanceof ChatLandAvatarItem);
                }
            });
            if (indexOf >= 0) {
                arrayList2.add(Integer.valueOf(indexOf));
                if (arrayList2.size() == 1) {
                    MapItem itemData = getItemData(indexOf);
                    if (!(itemData instanceof SquareAvatarItem)) {
                        itemData = null;
                    }
                    SquareAvatarItem squareAvatarItem = (SquareAvatarItem) itemData;
                    if (squareAvatarItem != null) {
                        squareAvatarItem.getExtra().setNeedRingPagAnim(true);
                        notifyItemChanged(indexOf, 9);
                    }
                    MapItem itemData2 = getItemData(indexOf);
                    SquareTroopItem squareTroopItem = (SquareTroopItem) (itemData2 instanceof SquareTroopItem ? itemData2 : null);
                    if (squareTroopItem != null) {
                        squareTroopItem.getExtra().setNeedRingAnim(true);
                        notifyItemChanged(indexOf, 10);
                    }
                }
                hashMap.put(moveItem, new MoveResult(MoveType.AlreadyInSquare, new PlaceInfo(0, 0, 0, 7, null)));
            } else {
                arrayList.add(moveItem);
            }
        }
        this.layoutManager.setFixedIndexList(arrayList2);
        IDynamicLayoutComponent iDynamicLayoutComponent = this.layoutManager;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        for (MoveItem moveItem2 : arrayList) {
            arrayList3.add(-1);
        }
        List<MoveRequest> findMoveToIndexList = iDynamicLayoutComponent.findMoveToIndexList(arrayList3);
        int i3 = 0;
        for (Object obj : findMoveToIndexList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            MoveRequest moveRequest = (MoveRequest) obj;
            orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, i3);
            MoveItem moveItem3 = (MoveItem) orNull;
            if (moveItem3 != null) {
                Location itemLocation = getLocator().getItemLocation(moveRequest.getDstIndex());
                MoveSource src = moveRequest.getSrc();
                MapItem moveData = moveItem3.getMoveData();
                if (moveData == null) {
                    moveData = SquareAvatarItemKt.getDefaultSquareItem(moveItem3.getUin(), moveItem3.getUnitType(), itemLocation);
                    if (moveData instanceof SquareAvatarItem) {
                        ((SquareAvatarItem) moveData).getExtra().setNeedRingPagAnim(true);
                    }
                    Unit unit = Unit.INSTANCE;
                }
                src.setData(moveData);
                PlaceInfo placeInfo = new PlaceInfo(itemLocation.getArea(), itemLocation.getRank(), moveRequest.getDstIndex());
                if (moveRequest.getDstIndex() > -1) {
                    moveType = MoveType.AddToSquare;
                } else {
                    moveType = MoveType.NoPlace;
                }
                hashMap.put(moveItem3, new MoveResult(moveType, placeInfo));
            }
            i3 = i16;
        }
        SquareDebug.INSTANCE.printMoveRequestInfo("[addRoles] doAirborneLanding_findIndex", findMoveToIndexList);
        this.layoutManager.move(findMoveToIndexList);
        this.layoutManager.setFixedIndexList(null);
        for (Map.Entry entry : hashMap.entrySet()) {
            if (((MoveResult) entry.getValue()).getType() != MoveType.NoPlace) {
                MoveItem moveItem4 = (MoveItem) entry.getKey();
                if (moveItem4.getMoveData() != null) {
                    onUpdateSquareItem(moveItem4.getMoveData());
                } else if (moveItem4.getUnitType() != 0 && moveItem4.getUnitType() != 2) {
                    getTroopInfo(moveItem4.getUin(), new Function1<SquareTroopItem, Unit>() { // from class: com.tencent.state.square.SquareAreaRankAdapter$doAirborneLanding$$inlined$forEach$lambda$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SquareTroopItem squareTroopItem2) {
                            invoke2(squareTroopItem2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SquareTroopItem result) {
                            Intrinsics.checkNotNullParameter(result, "result");
                            SquareAreaRankAdapter.this.onUpdateSquareItem(result);
                        }
                    });
                } else {
                    getUserInfo$default(this, moveItem4.getUin(), null, new Function1<SquareAvatarItem, Unit>() { // from class: com.tencent.state.square.SquareAreaRankAdapter$doAirborneLanding$$inlined$forEach$lambda$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SquareAvatarItem squareAvatarItem2) {
                            invoke2(squareAvatarItem2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SquareAvatarItem result) {
                            Intrinsics.checkNotNullParameter(result, "result");
                            SquareAreaRankAdapter.this.onUpdateSquareItem(result);
                        }
                    }, 2, null);
                }
            }
        }
        this.layoutManager.debugPrint("[addRoles] doAirborneLanding_end");
        return hashMap;
    }

    @Override // com.tencent.state.square.SquareBaseAdapter
    public PlaceInfo doAvatarSetTop(MoveItem item, final int unReadMsgCount) {
        Object obj;
        Intrinsics.checkNotNullParameter(item, "item");
        Iterator<T> it = this.dataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((ItemStruct) obj).getData().getUin(), item.getUin())) {
                break;
            }
        }
        ItemStruct itemStruct = (ItemStruct) obj;
        int index = itemStruct != null ? itemStruct.getIndex() : -1;
        int findMoveToIndex = this.layoutManager.findMoveToIndex(index);
        if (index >= 0) {
            IDynamicLayoutComponent.DefaultImpls.move$default(this.layoutManager, index, findMoveToIndex, null, 4, null);
        } else {
            MapItem defaultSquareItem = SquareAvatarItemKt.getDefaultSquareItem(item.getUin(), item.getUnitType(), getLocator().getItemLocation(findMoveToIndex));
            if (defaultSquareItem instanceof SquareAvatarItem) {
                ((SquareAvatarItem) defaultSquareItem).getExtra().updateUnReadCount(unReadMsgCount);
            }
            this.layoutManager.move(index, findMoveToIndex, defaultSquareItem);
            if (item.getUnitType() != 0 && item.getUnitType() != 2) {
                getTroopInfo(item.getUin(), new Function1<SquareTroopItem, Unit>() { // from class: com.tencent.state.square.SquareAreaRankAdapter$doAvatarSetTop$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SquareTroopItem squareTroopItem) {
                        invoke2(squareTroopItem);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SquareTroopItem result) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        SquareAreaRankAdapter.this.onUpdateSquareItem(result);
                    }
                });
            } else {
                getUserInfo$default(this, item.getUin(), null, new Function1<SquareAvatarItem, Unit>() { // from class: com.tencent.state.square.SquareAreaRankAdapter$doAvatarSetTop$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SquareAvatarItem squareAvatarItem) {
                        invoke2(squareAvatarItem);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SquareAvatarItem result) {
                        SquareAvatarExtra extra;
                        Intrinsics.checkNotNullParameter(result, "result");
                        int indexOf = SquareAreaRankAdapter.this.indexOf(result);
                        if (indexOf >= 0) {
                            MapItem itemData = SquareAreaRankAdapter.this.getItemData(indexOf);
                            if (!(itemData instanceof SquareAvatarItem)) {
                                itemData = null;
                            }
                            SquareAvatarItem squareAvatarItem = (SquareAvatarItem) itemData;
                            if (squareAvatarItem != null && (extra = squareAvatarItem.getExtra()) != null && extra.getIsFixed()) {
                                result.getExtra().setFixed(true);
                            }
                            result.getExtra().updateUnReadCount(unReadMsgCount);
                            SquareAreaRankAdapter.this.onUpdateSquareItem(result);
                        }
                    }
                }, 2, null);
            }
        }
        Location itemLocation = getLocator().getItemLocation(findMoveToIndex);
        return new PlaceInfo(itemLocation.getArea(), itemLocation.getRank(), 0, 4, null);
    }

    @Override // com.tencent.state.square.SquareBaseAdapter
    /* renamed from: getDynamicLayoutComponent, reason: from getter */
    public IDynamicLayoutComponent getLayoutManager() {
        return this.layoutManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    @Override // com.tencent.state.map.MapAdapter
    public MapItem getItemData(int index) {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.dataList, index);
        ItemStruct itemStruct = (ItemStruct) orNull;
        if (itemStruct != null) {
            return itemStruct.getData();
        }
        return null;
    }

    @Override // com.tencent.state.map.IMapDataIndexer
    public int indexOf(Function1<? super MapItem, Boolean> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int i3 = -1;
        int i16 = 0;
        for (Object obj : this.dataList) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (block.invoke(((ItemStruct) obj).getData()).booleanValue()) {
                i3 = i16;
            }
            i16 = i17;
        }
        return i3;
    }

    @Override // com.tencent.state.map.MapAdapter
    public void insetItemData(int position, MapItem mapItem) {
        Intrinsics.checkNotNullParameter(mapItem, "mapItem");
        ItemStruct itemStruct = new ItemStruct(position, mapItem);
        this.dataList.add(position, itemStruct);
        TreeMap<Integer, ItemStruct> treeMap = this.areaList.get(itemStruct.getArea());
        if (treeMap == null) {
            SparseArray<TreeMap<Integer, ItemStruct>> sparseArray = this.areaList;
            int area = itemStruct.getArea();
            TreeMap<Integer, ItemStruct> treeMap2 = new TreeMap<>();
            treeMap2.put(Integer.valueOf(itemStruct.getRank()), itemStruct);
            Unit unit = Unit.INSTANCE;
            sparseArray.put(area, treeMap2);
            return;
        }
        treeMap.put(Integer.valueOf(itemStruct.getRank()), itemStruct);
    }

    @Override // com.tencent.state.map.MapAdapter
    public void setItemData(int index, MapItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ItemStruct itemStruct = new ItemStruct(index, data);
        this.dataList.set(index, itemStruct);
        TreeMap<Integer, ItemStruct> treeMap = this.areaList.get(itemStruct.getArea());
        if (treeMap != null) {
            treeMap.put(Integer.valueOf(itemStruct.getRank()), itemStruct);
        }
    }

    @Override // com.tencent.state.square.SquareBaseAdapter
    public void updateUnreadMessage(SquareBaseMessageRecord message) {
        Object obj;
        SquareAvatarExtra extra;
        Intrinsics.checkNotNullParameter(message, "message");
        Iterator<T> it = this.dataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((ItemStruct) obj).getData().getUin(), message.getUin())) {
                    break;
                }
            }
        }
        ItemStruct itemStruct = (ItemStruct) obj;
        int index = itemStruct != null ? itemStruct.getIndex() : -1;
        boolean z16 = false;
        if (index > 0) {
            MapItem itemData = getItemData(index);
            SquareAvatarItem squareAvatarItem = (SquareAvatarItem) (itemData instanceof SquareAvatarItem ? itemData : null);
            if (((squareAvatarItem == null || (extra = squareAvatarItem.getExtra()) == null) ? 0 : extra.unReadCount()) > message.getUnreadCount()) {
                z16 = true;
            }
        }
        super.updateUnreadMessage(message);
        if (z16 || message.getUnreadCount() <= 0) {
            return;
        }
        int findMoveToIndex = this.layoutManager.findMoveToIndex(index);
        if (index >= 0) {
            IDynamicLayoutComponent.DefaultImpls.move$default(this.layoutManager, index, findMoveToIndex, null, 4, null);
        }
    }

    static /* synthetic */ void getUserInfo$default(SquareAreaRankAdapter squareAreaRankAdapter, String str, SquareMessageRecord squareMessageRecord, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            squareMessageRecord = new SquareMessageRecord(str, null, 2, null);
        }
        squareAreaRankAdapter.getUserInfo(str, squareMessageRecord, function1);
    }
}
