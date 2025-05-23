package com.tencent.state.square.layout;

import com.tencent.state.map.MapItem;
import com.tencent.state.square.friendsetting.PlaceInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0006H\u0016J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\"\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0016\u0010\u0016\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0018\u0010\u001c\u001a\u00020\u00042\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000eH\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/state/square/layout/EmptyDynamicLayoutComponent;", "Lcom/tencent/state/square/layout/IDynamicLayoutComponent;", "()V", "debugPrint", "", "logMsg", "", "doAvatarCloseToMe", "Lcom/tencent/state/square/friendsetting/PlaceInfo;", "uin", "findMoveToIndex", "", "index", "findMoveToIndexList", "", "Lcom/tencent/state/square/layout/MoveRequest;", "indexList", "getCloseToMePlace", "hide", "", "itemType", "skipAnim", "move", "srcIndex", "dstIndex", "srcData", "Lcom/tencent/state/map/MapItem;", "requests", "setFixedIndexList", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class EmptyDynamicLayoutComponent implements IDynamicLayoutComponent {
    @Override // com.tencent.state.square.layout.IDynamicLayoutComponent
    public void debugPrint(String logMsg) {
        Intrinsics.checkNotNullParameter(logMsg, "logMsg");
    }

    @Override // com.tencent.state.square.layout.IDynamicLayoutComponent
    public PlaceInfo doAvatarCloseToMe(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return null;
    }

    @Override // com.tencent.state.square.layout.IDynamicLayoutComponent
    public int findMoveToIndex(int index) {
        return -1;
    }

    @Override // com.tencent.state.square.layout.IDynamicLayoutComponent
    public List<MoveRequest> findMoveToIndexList(List<Integer> indexList) {
        List<MoveRequest> emptyList;
        Intrinsics.checkNotNullParameter(indexList, "indexList");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    @Override // com.tencent.state.square.layout.IDynamicLayoutComponent
    public PlaceInfo getCloseToMePlace(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return null;
    }

    @Override // com.tencent.state.square.layout.IDynamicLayoutComponent
    public boolean hide(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return false;
    }

    @Override // com.tencent.state.square.layout.IDynamicLayoutComponent
    public void move(int srcIndex, int dstIndex, MapItem srcData) {
    }

    @Override // com.tencent.state.square.layout.IDynamicLayoutComponent
    public int findMoveToIndex(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return -1;
    }

    @Override // com.tencent.state.square.layout.IDynamicLayoutComponent
    public boolean hide(String uin, int itemType, boolean skipAnim) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return false;
    }

    @Override // com.tencent.state.square.layout.IDynamicLayoutComponent
    public void move(List<MoveRequest> requests) {
        Intrinsics.checkNotNullParameter(requests, "requests");
    }

    @Override // com.tencent.state.square.layout.IDynamicLayoutComponent
    public void setFixedIndexList(List<Integer> indexList) {
    }
}
