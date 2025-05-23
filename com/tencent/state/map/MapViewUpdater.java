package com.tencent.state.map;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.data.Resource;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 (2\u00020\u0001:\u0001(B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0016\u0010\u0013\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0015H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012H\u0016J\u0018\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001dH\u0016J \u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001dH\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006)"}, d2 = {"Lcom/tencent/state/map/MapViewUpdater;", "Lcom/tencent/state/map/IMapViewUpdater;", "mapAdapter", "Lcom/tencent/state/map/MapAdapter;", "rpm", "Lcom/tencent/state/map/IMapPlayManager;", "locator", "Lcom/tencent/state/map/IMapLocator;", "(Lcom/tencent/state/map/MapAdapter;Lcom/tencent/state/map/IMapPlayManager;Lcom/tencent/state/map/IMapLocator;)V", "getLocator", "()Lcom/tencent/state/map/IMapLocator;", "getMapAdapter", "()Lcom/tencent/state/map/MapAdapter;", "getRpm", "()Lcom/tencent/state/map/IMapPlayManager;", "appendItem", "", "mapItem", "Lcom/tencent/state/map/MapItem;", "appendItemList", "list", "", "resetMeActions", "Lcom/tencent/state/map/MapPlayableItem;", "updateAvatarDressKey", "dressKey", "", "updateAvatarGender", "isMale", "", "updateItem", "index", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "updateMeResource", "resource", "Lcom/tencent/state/square/data/Resource;", "isUpdateUi", "updateTargetResource", "uin", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public class MapViewUpdater implements IMapViewUpdater {
    private static final String TAG = "MapViewUpdater";
    private final IMapLocator locator;
    private final MapAdapter mapAdapter;
    private final IMapPlayManager rpm;

    public MapViewUpdater(MapAdapter mapAdapter, IMapPlayManager iMapPlayManager, IMapLocator iMapLocator) {
        this.mapAdapter = mapAdapter;
        this.rpm = iMapPlayManager;
        this.locator = iMapLocator;
    }

    @Override // com.tencent.state.map.IMapViewUpdater
    public void appendItem(MapItem mapItem) {
        Intrinsics.checkNotNullParameter(mapItem, "mapItem");
        MapAdapter mapAdapter = this.mapAdapter;
        if (mapAdapter != null) {
            int num_backgournd_icon = mapAdapter.getNUM_BACKGOURND_ICON();
            IMapLocator iMapLocator = this.locator;
            if (iMapLocator != null) {
                iMapLocator.addItemLocation(num_backgournd_icon, mapItem);
            }
            mapAdapter.insetItemData(num_backgournd_icon, mapItem);
            mapAdapter.notifyItemInserted(num_backgournd_icon);
        }
    }

    @Override // com.tencent.state.map.IMapViewUpdater
    public void appendItemList(List<? extends MapItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        MapAdapter mapAdapter = this.mapAdapter;
        if (mapAdapter != null) {
            int num_backgournd_icon = mapAdapter.getNUM_BACKGOURND_ICON();
            int i3 = 0;
            for (Object obj : list) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                MapItem mapItem = (MapItem) obj;
                int i17 = i3 + num_backgournd_icon;
                IMapLocator iMapLocator = this.locator;
                if (iMapLocator != null) {
                    iMapLocator.addItemLocation(i17, mapItem);
                }
                mapAdapter.insetItemData(i17, mapItem);
                i3 = i16;
            }
            mapAdapter.notifyItemRangeInserted(num_backgournd_icon, list.size());
        }
    }

    protected final IMapLocator getLocator() {
        return this.locator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MapAdapter getMapAdapter() {
        return this.mapAdapter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final IMapPlayManager getRpm() {
        return this.rpm;
    }

    @Override // com.tencent.state.map.IMapViewUpdater
    public MapPlayableItem resetMeActions() {
        final MapAdapter mapAdapter = this.mapAdapter;
        if (mapAdapter == null) {
            return null;
        }
        mapAdapter.forEachItemData(new Function2<Integer, MapItem, Unit>() { // from class: com.tencent.state.map.MapViewUpdater$resetMeActions$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, MapItem mapItem) {
                invoke(num.intValue(), mapItem);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, MapItem mapItem) {
                if (!(mapItem instanceof MapPlayableItem)) {
                    mapItem = null;
                }
                MapPlayableItem mapPlayableItem = (MapPlayableItem) mapItem;
                if (mapPlayableItem == null || !mapPlayableItem.isMe() || i3 == MapAdapter.this.getMeIndex()) {
                    return;
                }
                mapPlayableItem.resetDefault();
                SquareBaseKt.getSquareLog().d("MapViewUpdater", "resetMeActions");
            }
        });
        MapItem itemData = mapAdapter.getItemData(mapAdapter.getMeIndex());
        if (!(itemData instanceof MapPlayableItem)) {
            itemData = null;
        }
        MapPlayableItem mapPlayableItem = (MapPlayableItem) itemData;
        if (mapPlayableItem == null) {
            return null;
        }
        mapPlayableItem.resetDefault();
        return mapPlayableItem;
    }

    @Override // com.tencent.state.map.IMapViewUpdater
    public void updateAvatarDressKey(final String dressKey) {
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        MapAdapter mapAdapter = this.mapAdapter;
        if (mapAdapter != null) {
            mapAdapter.forEachItemData(new Function2<Integer, MapItem, Unit>() { // from class: com.tencent.state.map.MapViewUpdater$updateAvatarDressKey$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, MapItem mapItem) {
                    invoke(num.intValue(), mapItem);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, MapItem mapItem) {
                    if (!(mapItem instanceof MapPlayableItem)) {
                        mapItem = null;
                    }
                    MapPlayableItem mapPlayableItem = (MapPlayableItem) mapItem;
                    if (mapPlayableItem == null || !mapPlayableItem.isMe()) {
                        return;
                    }
                    mapPlayableItem.updateDressKey(dressKey);
                }
            });
        }
    }

    @Override // com.tencent.state.map.IMapViewUpdater
    public void updateAvatarGender(final boolean isMale) {
        MapAdapter mapAdapter = this.mapAdapter;
        if (mapAdapter != null) {
            mapAdapter.forEachItemData(new Function2<Integer, MapItem, Unit>() { // from class: com.tencent.state.map.MapViewUpdater$updateAvatarGender$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, MapItem mapItem) {
                    invoke(num.intValue(), mapItem);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, MapItem mapItem) {
                    if (!(mapItem instanceof MapPlayableItem)) {
                        mapItem = null;
                    }
                    MapPlayableItem mapPlayableItem = (MapPlayableItem) mapItem;
                    if (mapPlayableItem == null || !mapPlayableItem.isMe()) {
                        return;
                    }
                    mapPlayableItem.updateGender(isMale);
                }
            });
        }
    }

    @Override // com.tencent.state.map.IMapViewUpdater
    public void updateItem(int index, MapItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        MapAdapter mapAdapter = this.mapAdapter;
        if (mapAdapter != null) {
            IMapLocator iMapLocator = this.locator;
            if (iMapLocator != null) {
                iMapLocator.setItemLocation(index, item);
            }
            SquareBaseKt.getSquareLog().i(TAG, "updateItem: index=" + index + ", item=" + item);
            mapAdapter.setItemData(index, item);
            mapAdapter.notifyItemChanged(index);
        }
    }

    @Override // com.tencent.state.map.IMapViewUpdater
    public void updateMeResource(final Resource resource, final boolean isUpdateUi) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        MapAdapter mapAdapter = this.mapAdapter;
        if (mapAdapter != null) {
            mapAdapter.forEachItemData(new Function2<Integer, MapItem, Unit>() { // from class: com.tencent.state.map.MapViewUpdater$updateMeResource$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, MapItem mapItem) {
                    invoke(num.intValue(), mapItem);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, MapItem mapItem) {
                    IMapPlayManager rpm;
                    if (!(mapItem instanceof MapPlayableItem)) {
                        mapItem = null;
                    }
                    MapPlayableItem mapPlayableItem = (MapPlayableItem) mapItem;
                    if (mapPlayableItem == null || !mapPlayableItem.isMe()) {
                        return;
                    }
                    mapPlayableItem.updateResource(resource);
                    if (!isUpdateUi || (rpm = MapViewUpdater.this.getRpm()) == null) {
                        return;
                    }
                    rpm.pauseAndEnsurePlay(i3);
                }
            });
        }
    }

    @Override // com.tencent.state.map.IMapViewUpdater
    public void updateTargetResource(final String uin, final Resource resource, final boolean isUpdateUi) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(resource, "resource");
        MapAdapter mapAdapter = this.mapAdapter;
        if (mapAdapter != null) {
            mapAdapter.forEachItemData(new Function2<Integer, MapItem, Unit>() { // from class: com.tencent.state.map.MapViewUpdater$updateTargetResource$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, MapItem mapItem) {
                    invoke(num.intValue(), mapItem);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, MapItem mapItem) {
                    IMapPlayManager rpm;
                    if (!(mapItem instanceof MapPlayableItem)) {
                        mapItem = null;
                    }
                    MapPlayableItem mapPlayableItem = (MapPlayableItem) mapItem;
                    if (mapPlayableItem == null || (!Intrinsics.areEqual(mapPlayableItem.getUin(), uin))) {
                        return;
                    }
                    mapPlayableItem.updateResource(resource);
                    if (!isUpdateUi || (rpm = MapViewUpdater.this.getRpm()) == null) {
                        return;
                    }
                    rpm.pauseAndEnsurePlay(i3);
                }
            });
        }
    }

    public /* synthetic */ MapViewUpdater(MapAdapter mapAdapter, IMapPlayManager iMapPlayManager, IMapLocator iMapLocator, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(mapAdapter, iMapPlayManager, (i3 & 4) != 0 ? null : iMapLocator);
    }

    @Override // com.tencent.state.map.IMapViewUpdater
    public void updateItem(int index) {
        MapAdapter mapAdapter = this.mapAdapter;
        if (mapAdapter != null) {
            mapAdapter.notifyItemChanged(index);
        }
    }
}
