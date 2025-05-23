package com.tencent.state.square.layout;

import com.tencent.state.map.IMapComponent;
import com.tencent.state.map.MapItem;
import com.tencent.state.square.friendsetting.PlaceInfo;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0005H&J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\rH&J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0005H'J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u0012H&J$\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\u0016\u0010\u0015\u001a\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&J\u001a\u0010\u001b\u001a\u00020\u00032\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\rH&\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/state/square/layout/IDynamicLayoutComponent;", "Lcom/tencent/state/map/IMapComponent;", "debugPrint", "", "logMsg", "", "doAvatarCloseToMe", "Lcom/tencent/state/square/friendsetting/PlaceInfo;", "uin", "findMoveToIndex", "", "index", "findMoveToIndexList", "", "Lcom/tencent/state/square/layout/MoveRequest;", "indexList", "getCloseToMePlace", "hide", "", "itemType", "skipAnim", "move", "srcIndex", "dstIndex", "srcData", "Lcom/tencent/state/map/MapItem;", "requests", "setFixedIndexList", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IDynamicLayoutComponent extends IMapComponent {
    void debugPrint(String logMsg);

    PlaceInfo doAvatarCloseToMe(String uin);

    int findMoveToIndex(int index);

    int findMoveToIndex(String uin);

    List<MoveRequest> findMoveToIndexList(List<Integer> indexList);

    PlaceInfo getCloseToMePlace(String uin);

    @Deprecated(message = "use hide(uin, itemType) instead")
    boolean hide(String uin);

    boolean hide(String uin, int itemType, boolean skipAnim);

    void move(int srcIndex, int dstIndex, MapItem srcData);

    void move(List<MoveRequest> requests);

    void setFixedIndexList(List<Integer> indexList);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ boolean hide$default(IDynamicLayoutComponent iDynamicLayoutComponent, String str, int i3, boolean z16, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 4) != 0) {
                    z16 = false;
                }
                return iDynamicLayoutComponent.hide(str, i3, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hide");
        }

        public static /* synthetic */ void move$default(IDynamicLayoutComponent iDynamicLayoutComponent, int i3, int i16, MapItem mapItem, int i17, Object obj) {
            if (obj == null) {
                if ((i17 & 4) != 0) {
                    mapItem = null;
                }
                iDynamicLayoutComponent.move(i3, i16, mapItem);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: move");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void setFixedIndexList$default(IDynamicLayoutComponent iDynamicLayoutComponent, List list, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    list = null;
                }
                iDynamicLayoutComponent.setFixedIndexList(list);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFixedIndexList");
        }
    }
}
