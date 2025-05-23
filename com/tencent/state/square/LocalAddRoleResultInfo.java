package com.tencent.state.square;

import com.tencent.state.SquareDebug;
import com.tencent.state.service.PatchAddToSquareItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR!\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/state/square/LocalAddRoleResultInfo;", "", "sourceList", "", "Lcom/tencent/state/square/MoveItem;", "localResultMap", "", "Lcom/tencent/state/square/MoveResult;", "(Ljava/util/List;Ljava/util/Map;)V", "alreadyInCount", "", "getAlreadyInCount", "()I", "setAlreadyInCount", "(I)V", "getLocalResultMap", "()Ljava/util/Map;", "newAddCount", "getNewAddCount", "setNewAddCount", "noPlaceCount", "getNoPlaceCount", "setNoPlaceCount", "serverReqList", "Ljava/util/ArrayList;", "Lcom/tencent/state/service/PatchAddToSquareItem;", "Lkotlin/collections/ArrayList;", "getServerReqList", "()Ljava/util/ArrayList;", "getSourceList", "()Ljava/util/List;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class LocalAddRoleResultInfo {
    private int alreadyInCount;
    private final Map<MoveItem, MoveResult> localResultMap;
    private int newAddCount;
    private int noPlaceCount;
    private final ArrayList<PatchAddToSquareItem> serverReqList;
    private final List<MoveItem> sourceList;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MoveType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[MoveType.NoPlace.ordinal()] = 1;
            iArr[MoveType.AlreadyInSquare.ordinal()] = 2;
        }
    }

    public LocalAddRoleResultInfo(List<MoveItem> sourceList, Map<MoveItem, MoveResult> localResultMap) {
        Intrinsics.checkNotNullParameter(sourceList, "sourceList");
        Intrinsics.checkNotNullParameter(localResultMap, "localResultMap");
        this.sourceList = sourceList;
        this.localResultMap = localResultMap;
        this.serverReqList = new ArrayList<>();
        for (Map.Entry<MoveItem, MoveResult> entry : localResultMap.entrySet()) {
            int i3 = WhenMappings.$EnumSwitchMapping$0[entry.getValue().getType().ordinal()];
            if (i3 == 1) {
                this.noPlaceCount++;
            } else if (i3 != 2) {
                this.newAddCount++;
                this.serverReqList.add(new PatchAddToSquareItem(entry.getKey().getUin(), entry.getKey().getUnitType(), entry.getValue().getMoveTo().getArea(), entry.getValue().getMoveTo().getRank()));
            } else {
                this.alreadyInCount++;
            }
        }
        SquareDebug.INSTANCE.printMoveResultInfo("[addRoles] localAddRoleResultInfo", this.localResultMap);
    }

    public final int getAlreadyInCount() {
        return this.alreadyInCount;
    }

    public final Map<MoveItem, MoveResult> getLocalResultMap() {
        return this.localResultMap;
    }

    public final int getNewAddCount() {
        return this.newAddCount;
    }

    public final int getNoPlaceCount() {
        return this.noPlaceCount;
    }

    public final ArrayList<PatchAddToSquareItem> getServerReqList() {
        return this.serverReqList;
    }

    public final List<MoveItem> getSourceList() {
        return this.sourceList;
    }

    public final void setAlreadyInCount(int i3) {
        this.alreadyInCount = i3;
    }

    public final void setNewAddCount(int i3) {
        this.newAddCount = i3;
    }

    public final void setNoPlaceCount(int i3) {
        this.noPlaceCount = i3;
    }
}
