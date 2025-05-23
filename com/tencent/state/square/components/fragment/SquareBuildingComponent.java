package com.tencent.state.square.components.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import com.tencent.rapier.a;
import com.tencent.state.library.calendar.CalendarGuideManager;
import com.tencent.state.map.MapData;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.service.ISquareBubbleService;
import com.tencent.state.service.VasSquareBuildingBubbleService;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareMapViewModel;
import com.tencent.state.square.data.BuildingBubble;
import com.tencent.state.square.data.SquareEntranceItem;
import com.tencent.state.square.databinding.VasSquareFragmentSquareBinding;
import com.tencent.state.utils.VMUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import st4.f;
import st4.g;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 22\u00020\u0001:\u00012B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J,\u0010\u0018\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\"\u0010\u001d\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J<\u0010\u001f\u001a\u00020\u00122\u000e\u0010 \u001a\n\u0012\u0002\b\u00030!j\u0002`\"2\u0006\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020\u00122\u0006\u0010$\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020-H\u0002J\u0016\u0010.\u001a\u00020\u00122\f\u0010/\u001a\b\u0012\u0004\u0012\u00020%00H\u0002J\u0016\u00101\u001a\u00020\u00122\f\u0010/\u001a\b\u0012\u0004\u0012\u00020%00H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareBuildingComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareFragmentSquareBinding;", "enable", "", "firstViewDidAppear", "service", "Lcom/tencent/state/service/ISquareBubbleService;", "tipsBubbleBuildingId", "", "Ljava/lang/Integer;", "tipsBubbleId", "", "vm", "Lcom/tencent/state/square/SquareMapViewModel;", "consumedTipsBubble", "", "onFragmentResumed", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "onFragmentViewCreated", "v", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onFragmentVisibilityChanged", "isVisible", "onItemClicked", "vh", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "index", "data", "Lcom/tencent/state/map/MapItem;", "viewId", "extra", "", "onMapDataReceived", "Lcom/tencent/state/map/MapData;", "queryBubbles", "buildingArray", "", "queryExtraBubbles", "dataList", "", "queryTopBubble", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareBuildingComponent extends SquareBaseComponent {
    private static final String TAG = "Square_SquareBuildingComponent";
    private VasSquareFragmentSquareBinding binding;
    private boolean enable = true;
    private boolean firstViewDidAppear = true;
    private ISquareBubbleService service;
    private Integer tipsBubbleBuildingId;
    private String tipsBubbleId;
    private SquareMapViewModel vm;

    /* JADX INFO: Access modifiers changed from: private */
    public final void consumedTipsBubble() {
        LinearLayout linearLayout;
        VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding = this.binding;
        if (vasSquareFragmentSquareBinding != null && (linearLayout = vasSquareFragmentSquareBinding.topTipsBubble) != null) {
            linearLayout.setVisibility(8);
        }
        this.tipsBubbleBuildingId = null;
        this.tipsBubbleId = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void queryBubbles(int[] buildingArray) {
        VasSquareBuildingBubbleService.INSTANCE.getBuildingBubbles(buildingArray, new SquareBuildingComponent$queryBubbles$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void queryExtraBubbles(List<? extends MapItem> dataList) {
        SquareEntranceItem squareEntranceItem = null;
        for (MapItem mapItem : dataList) {
            if (!(mapItem instanceof SquareEntranceItem)) {
                mapItem = null;
            }
            SquareEntranceItem squareEntranceItem2 = (SquareEntranceItem) mapItem;
            if (squareEntranceItem2 != null && squareEntranceItem2.getEntranceType() == 2) {
                squareEntranceItem = squareEntranceItem2;
            }
        }
        CalendarGuideManager.INSTANCE.getCalendarGuideForBuilding(squareEntranceItem, new SquareBuildingComponent$queryExtraBubbles$2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void queryTopBubble(List<? extends MapItem> dataList) {
        int collectionSizeOrDefault;
        a<g> aVar;
        int[] intArray;
        ArrayList arrayList = new ArrayList();
        for (Object obj : dataList) {
            if (obj instanceof SquareEntranceItem) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(((SquareEntranceItem) it.next()).getEntranceId()));
        }
        ISquareBubbleService iSquareBubbleService = this.service;
        if (iSquareBubbleService != null) {
            f fVar = new f();
            intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList2);
            fVar.f434752a = intArray;
            Unit unit = Unit.INSTANCE;
            aVar = iSquareBubbleService.getSquareTopBubbleReq(fVar);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.a(new SquareBuildingComponent$queryTopBubble$1(this, arrayList2, arrayList));
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentResumed(FragmentManager fm5, Fragment f16) {
        SquareMapViewModel squareMapViewModel;
        LiveData<MapData> data;
        MapData value;
        Intrinsics.checkNotNullParameter(f16, "f");
        super.onFragmentResumed(fm5, f16);
        if (!this.firstViewDidAppear && (squareMapViewModel = this.vm) != null && (data = squareMapViewModel.getData()) != null && (value = data.getValue()) != null) {
            queryExtraBubbles(value.getDataList());
        }
        this.firstViewDidAppear = false;
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        VasSquareFragmentSquareBinding bind = VasSquareFragmentSquareBinding.bind(v3);
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        LinearLayout linearLayout = bind.topTipsBubble;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "it.topTipsBubble");
        squareReporter.setElementInfo(linearLayout, "em_zplan_square_top_bubble", new LinkedHashMap(), false, false);
        Unit unit = Unit.INSTANCE;
        this.binding = bind;
        this.service = (ISquareBubbleService) Square.INSTANCE.getConfig().getRapier().b(ISquareBubbleService.class);
        this.vm = (SquareMapViewModel) VMUtils.INSTANCE.safelyGet(f16, SquareMapViewModel.class);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentVisibilityChanged(FragmentManager fm5, Fragment f16, boolean isVisible) {
        LinearLayout linearLayout;
        String str;
        Intrinsics.checkNotNullParameter(f16, "f");
        this.enable = isVisible;
        VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding = this.binding;
        if (vasSquareFragmentSquareBinding == null || (linearLayout = vasSquareFragmentSquareBinding.topTipsBubble) == null) {
            return;
        }
        linearLayout.setVisibility((!isVisible || (str = this.tipsBubbleId) == null || str == null) ? 8 : 0);
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.map.IMapViewListener
    public void onItemClicked(MapViewHolder<?> vh5, int index, MapItem data, int viewId, Object extra) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        if (data instanceof SquareEntranceItem) {
            if (viewId == 10) {
                int entranceId = ((SquareEntranceItem) data).getEntranceId();
                Integer num = this.tipsBubbleBuildingId;
                if (num != null && entranceId == num.intValue()) {
                    consumedTipsBubble();
                    return;
                }
            }
            if (viewId == 12 && (extra instanceof BuildingBubble)) {
                BuildingBubble buildingBubble = (BuildingBubble) extra;
                boolean areEqual = Intrinsics.areEqual(buildingBubble.getBubbleId(), this.tipsBubbleId);
                boolean z16 = buildingBubble.getBubbleType() == 1;
                if (areEqual && z16) {
                    int entranceId2 = ((SquareEntranceItem) data).getEntranceId();
                    Integer num2 = this.tipsBubbleBuildingId;
                    if (num2 != null && entranceId2 == num2.intValue()) {
                        consumedTipsBubble();
                    }
                }
            }
        }
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.square.components.fragment.ISquareEventListener
    public void onMapDataReceived(MapData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        final List<MapItem> dataList = data.getDataList();
        if (dataList.isEmpty() || data.getFromCache()) {
            return;
        }
        SquareBaseKt.getSquareThread().postOnSubThread(new Function0<Unit>() { // from class: com.tencent.state.square.components.fragment.SquareBuildingComponent$onMapDataReceived$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SquareBuildingComponent.this.queryTopBubble(dataList);
                SquareBuildingComponent.this.queryExtraBubbles(dataList);
            }
        });
    }
}
