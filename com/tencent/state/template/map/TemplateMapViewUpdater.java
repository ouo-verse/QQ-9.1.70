package com.tencent.state.template.map;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.state.common.tag.CommonTagInfo;
import com.tencent.state.map.IMapPlayManager;
import com.tencent.state.map.MapAdapter;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewUpdater;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.Table;
import com.tencent.state.template.data.User;
import com.tencent.state.template.item.TemplateAvatarItem;
import com.tencent.state.template.item.TemplateTableItem;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\"\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0014H\u0016\u00a8\u0006%"}, d2 = {"Lcom/tencent/state/template/map/TemplateMapViewUpdater;", "Lcom/tencent/state/map/MapViewUpdater;", "Lcom/tencent/state/template/map/ITemplateViewUpdater;", "adapter", "Lcom/tencent/state/map/MapAdapter;", "rpm", "Lcom/tencent/state/map/IMapPlayManager;", "(Lcom/tencent/state/map/MapAdapter;Lcom/tencent/state/map/IMapPlayManager;)V", "createAvatarItem", "Lcom/tencent/state/template/item/TemplateAvatarItem;", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "createTableItem", "Lcom/tencent/state/template/item/TemplateTableItem;", "table", "Lcom/tencent/state/template/data/Table;", "findNeighbor", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/state/map/MapItem;", "findTableIndex", "", "tableId", "", "sitDown", "", "standUp", "uin", "updateDeskMateTag", "", "tag", "Lcom/tencent/state/common/tag/CommonTagInfo;", "updateItem", "index", "updateNeighborTable", "updateUserLikeCount", MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT, "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class TemplateMapViewUpdater extends MapViewUpdater implements ITemplateViewUpdater {
    private static final String TAG = "TemplateMapViewUpdater";

    private final Table findNeighbor(MapItem item) {
        Table table;
        if (item instanceof TemplateAvatarItem) {
            SitDownInfo sitDown = ((TemplateAvatarItem) item).getUser().getSitDown();
            if (sitDown == null || (table = sitDown.getTable()) == null) {
                return null;
            }
            return table.getNeighbor();
        }
        if (item instanceof TemplateTableItem) {
            return ((TemplateTableItem) item).getTable().getNeighbor();
        }
        return null;
    }

    private final int findTableIndex(final long tableId) {
        MapAdapter mapAdapter = getMapAdapter();
        if (mapAdapter != null) {
            return mapAdapter.indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.template.map.TemplateMapViewUpdater$findTableIndex$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(MapItem mapItem) {
                    return Boolean.valueOf(invoke2(mapItem));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(MapItem it) {
                    SitDownInfo sitDown;
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((it instanceof TemplateAvatarItem) && (sitDown = ((TemplateAvatarItem) it).getUser().getSitDown()) != null && sitDown.getTableId() == tableId) || ((it instanceof TemplateTableItem) && ((TemplateTableItem) it).getTable().getId() == tableId);
                }
            });
        }
        return -1;
    }

    private final void updateNeighborTable(MapItem item) {
        int findTableIndex;
        Table findNeighbor = findNeighbor(item);
        if (findNeighbor == null || (findTableIndex = findTableIndex(findNeighbor.getId())) < 0) {
            return;
        }
        updateItem(findTableIndex);
    }

    public abstract TemplateAvatarItem createAvatarItem(User user);

    public abstract TemplateTableItem createTableItem(Table table);

    @Override // com.tencent.state.template.map.ITemplateViewUpdater
    public void sitDown(long tableId, User user) {
        Intrinsics.checkNotNullParameter(user, "user");
        MapAdapter mapAdapter = getMapAdapter();
        if (mapAdapter != null) {
            SquareBaseKt.getSquareLog().i(TAG, "sitDown: tableId=" + tableId + ", user=" + user.getInfo());
            int findTableIndex = findTableIndex(tableId);
            if (findTableIndex > -1) {
                MapItem itemData = mapAdapter.getItemData(findTableIndex);
                if (!(itemData instanceof TemplateTableItem)) {
                    itemData = null;
                }
                TemplateTableItem templateTableItem = (TemplateTableItem) itemData;
                if (templateTableItem != null) {
                    SitDownInfo sitDown = user.getSitDown();
                    if (sitDown != null) {
                        sitDown.setTable(templateTableItem.getTable());
                    }
                    templateTableItem.getTable().setUser(user);
                    updateItem(findTableIndex, createAvatarItem(user));
                    return;
                }
                return;
            }
            SquareBaseKt.getSquareLog().w(TAG, "sitDown failed: index=" + findTableIndex);
        }
    }

    @Override // com.tencent.state.template.map.ITemplateViewUpdater
    public void standUp(long tableId, long uin) {
        Table table;
        MapAdapter mapAdapter = getMapAdapter();
        if (mapAdapter != null) {
            SquareBaseKt.getSquareLog().i(TAG, "standUp: tableId=" + tableId + ", uin=" + uin);
            int findTableIndex = findTableIndex(tableId);
            if (findTableIndex > -1) {
                MapItem itemData = mapAdapter.getItemData(findTableIndex);
                if (!(itemData instanceof TemplateAvatarItem)) {
                    itemData = null;
                }
                TemplateAvatarItem templateAvatarItem = (TemplateAvatarItem) itemData;
                if (templateAvatarItem != null) {
                    if (templateAvatarItem.getUser().getInfo().getUin() == uin) {
                        SitDownInfo sitDown = templateAvatarItem.getUser().getSitDown();
                        if (sitDown == null || (table = sitDown.getTable()) == null) {
                            return;
                        }
                        table.setUser(null);
                        updateItem(findTableIndex, createTableItem(table));
                        return;
                    }
                    SquareBaseKt.getSquareLog().w(TAG, "standUp failed: uin=" + uin + ", currentTableUin=" + templateAvatarItem.getUser().getInfo().getUin());
                    return;
                }
                return;
            }
            SquareBaseKt.getSquareLog().w(TAG, "standUp failed: index=" + findTableIndex);
        }
    }

    @Override // com.tencent.state.template.map.ITemplateViewUpdater
    public void updateDeskMateTag(final String uin, CommonTagInfo tag) {
        int indexOf;
        SitDownInfo sitDown;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(tag, "tag");
        MapAdapter mapAdapter = getMapAdapter();
        if (mapAdapter == null || (indexOf = mapAdapter.indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.template.map.TemplateMapViewUpdater$updateDeskMateTag$index$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(MapItem mapItem) {
                return Boolean.valueOf(invoke2(mapItem));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(MapItem it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return (it instanceof TemplateAvatarItem) && Intrinsics.areEqual(((TemplateAvatarItem) it).getUser().getUin(), uin);
            }
        })) < 0) {
            return;
        }
        MapItem itemData = mapAdapter.getItemData(indexOf);
        if (!(itemData instanceof TemplateAvatarItem)) {
            itemData = null;
        }
        TemplateAvatarItem templateAvatarItem = (TemplateAvatarItem) itemData;
        if (templateAvatarItem != null) {
            User user = templateAvatarItem.getUser();
            if (user != null && (sitDown = user.getSitDown()) != null) {
                sitDown.setSubTag(tag);
            }
            updateItem(indexOf, templateAvatarItem);
        }
    }

    @Override // com.tencent.state.map.MapViewUpdater, com.tencent.state.map.IMapViewUpdater
    public void updateItem(int index, MapItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        super.updateItem(index, item);
        updateNeighborTable(item);
    }

    @Override // com.tencent.state.template.map.ITemplateViewUpdater
    public void updateUserLikeCount(long uin, int likeCount) {
        SitDownInfo sitDown;
        MapAdapter mapAdapter = getMapAdapter();
        if (mapAdapter != null) {
            MapItem itemData = mapAdapter.getItemData(mapAdapter.indexOf(String.valueOf(uin), 1));
            if (!(itemData instanceof TemplateAvatarItem)) {
                itemData = null;
            }
            TemplateAvatarItem templateAvatarItem = (TemplateAvatarItem) itemData;
            if (templateAvatarItem == null || (sitDown = templateAvatarItem.getUser().getSitDown()) == null) {
                return;
            }
            sitDown.setLikeNum(likeCount);
        }
    }

    public TemplateMapViewUpdater(MapAdapter mapAdapter, IMapPlayManager iMapPlayManager) {
        super(mapAdapter, iMapPlayManager, null, 4, null);
    }
}
