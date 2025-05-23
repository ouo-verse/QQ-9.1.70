package com.tencent.state.square.components.fragment;

import com.tencent.rapier.b;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.data.SquareEntranceItem;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import st4.a;
import st4.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/state/square/components/fragment/SquareBuildingComponent$queryTopBubble$1", "Lcom/tencent/rapier/b;", "Lst4/g;", "", "errorCode", "", "errorMessage", "", "onFailure", "response", "onSuccess", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareBuildingComponent$queryTopBubble$1 implements b<g> {
    final /* synthetic */ List $buildingIds;
    final /* synthetic */ List $buildings;
    final /* synthetic */ SquareBuildingComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SquareBuildingComponent$queryTopBubble$1(SquareBuildingComponent squareBuildingComponent, List list, List list2) {
        this.this$0 = squareBuildingComponent;
        this.$buildingIds = list;
        this.$buildings = list2;
    }

    @Override // com.tencent.rapier.b
    public void onFailure(int errorCode, String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "Square_SquareBuildingComponent", "queryTopBubble onFailure errorCode:" + errorCode + ", errorMessage:" + errorMessage, null, 4, null);
    }

    @Override // com.tencent.rapier.b
    public void onSuccess(g response) {
        int[] intArray;
        a[] aVarArr;
        Object firstOrNull;
        st4.b bVar;
        Object obj;
        Intrinsics.checkNotNullParameter(response, "response");
        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "Square_SquareBuildingComponent", "queryTopBubble onSuccess buildingId:" + response.f434753a, null, 4, null);
        SquareBuildingComponent squareBuildingComponent = this.this$0;
        intArray = CollectionsKt___CollectionsKt.toIntArray(this.$buildingIds);
        squareBuildingComponent.queryBubbles(intArray);
        st4.b bVar2 = response.f434753a;
        if (bVar2 == null || (aVarArr = bVar2.f434745b) == null) {
            return;
        }
        firstOrNull = ArraysKt___ArraysKt.firstOrNull(aVarArr);
        a aVar = (a) firstOrNull;
        if (aVar == null || (bVar = response.f434753a) == null) {
            return;
        }
        int i3 = bVar.f434744a;
        this.this$0.tipsBubbleBuildingId = Integer.valueOf(i3);
        this.this$0.tipsBubbleId = aVar.f434736b;
        List list = this.$buildings;
        ListIterator listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            } else {
                obj = listIterator.previous();
                if (((SquareEntranceItem) obj).getEntranceId() == i3) {
                    break;
                }
            }
        }
        SquareEntranceItem squareEntranceItem = (SquareEntranceItem) obj;
        if (squareEntranceItem == null) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "Square_SquareBuildingComponent", "queryTopBubble success buildingId:" + i3 + ", but findBuilding null, break", null, 4, null);
            return;
        }
        SquareBaseKt.getSquareThread().postOnUi(new SquareBuildingComponent$queryTopBubble$1$onSuccess$1(this, squareEntranceItem, aVar, i3));
    }
}
