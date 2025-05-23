package com.tencent.state.map;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.state.square.data.Resource;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&J\n\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H&J\u001a\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0010H&J\"\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0010H&\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/state/map/IMapViewUpdater;", "Lcom/tencent/state/map/IMapComponent;", "appendItem", "", "mapItem", "Lcom/tencent/state/map/MapItem;", "appendItemList", "list", "", "resetMeActions", "Lcom/tencent/state/map/MapPlayableItem;", "updateAvatarDressKey", "dressKey", "", "updateAvatarGender", "isMale", "", "updateItem", "index", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "updateMeResource", "resource", "Lcom/tencent/state/square/data/Resource;", "isUpdateUi", "updateTargetResource", "uin", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public interface IMapViewUpdater extends IMapComponent {
    void appendItem(MapItem mapItem);

    void appendItemList(List<? extends MapItem> list);

    MapPlayableItem resetMeActions();

    void updateAvatarDressKey(String dressKey);

    void updateAvatarGender(boolean isMale);

    void updateItem(int index);

    void updateItem(int index, MapItem item);

    void updateMeResource(Resource resource, boolean isUpdateUi);

    void updateTargetResource(String uin, Resource resource, boolean isUpdateUi);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void updateMeResource$default(IMapViewUpdater iMapViewUpdater, Resource resource, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = true;
                }
                iMapViewUpdater.updateMeResource(resource, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateMeResource");
        }

        public static /* synthetic */ void updateTargetResource$default(IMapViewUpdater iMapViewUpdater, String str, Resource resource, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    z16 = false;
                }
                iMapViewUpdater.updateTargetResource(str, resource, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateTargetResource");
        }
    }
}
