package com.tencent.state.square.components.fragment;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.data.BuildingBubble;
import com.tencent.state.square.data.SquareEntranceItem;
import com.tencent.state.square.databinding.VasSquareEntranceBubbleBinding;
import com.tencent.state.square.holder.SquareCommonEntranceViewHolder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J$\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J*\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0002J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J*\u0010\u0016\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u00030\u0017j\u0002`\u00182\u0006\u0010\u0019\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\u001aH\u0016J2\u0010\u0016\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u00030\u0017j\u0002`\u00182\u0006\u0010\u0019\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J<\u0010\u001b\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u00030\u0017j\u0002`\u00182\u0006\u0010\u0019\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareCommonEntranceComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "()V", "bindCommonEntranceBubbleReport", "", "vh", "Lcom/tencent/state/square/holder/SquareCommonEntranceViewHolder;", "data", "Lcom/tencent/state/square/data/SquareEntranceItem;", "getBubbleReportParams", "", "", "", "bubble", "Lcom/tencent/state/square/data/BuildingBubble;", "initCommonEntranceReport", "onCommonEntranceItemClick", "viewId", "", "extra", "onCommonEntranceReport", "event", "onItemBind", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "index", "Lcom/tencent/state/map/MapItem;", "onItemClicked", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareCommonEntranceComponent extends SquareBaseComponent {
    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> getBubbleReportParams(SquareEntranceItem data, BuildingBubble bubble) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SquareReportConst.Key.KEY_ZPLAN_BUILDING_ID, Integer.valueOf(data.getEntranceId()));
        if (bubble.getBubbleType() == 2) {
            linkedHashMap.put("zplan_building_bubble_gongneng_type", Integer.valueOf(bubble.getReportType()));
        }
        if (bubble.getBubbleType() == 1) {
            linkedHashMap.put("zplan_tianshu_ad_id", Integer.valueOf(bubble.getReportType()));
        }
        return linkedHashMap;
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.map.IMapViewListener
    public void onItemBind(MapViewHolder<?> vh5, int index, MapItem data) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        if (vh5 instanceof SquareCommonEntranceViewHolder) {
            SquareCommonEntranceViewHolder squareCommonEntranceViewHolder = (SquareCommonEntranceViewHolder) vh5;
            if (!(data instanceof SquareEntranceItem)) {
                data = null;
            }
            SquareEntranceItem squareEntranceItem = (SquareEntranceItem) data;
            if (squareEntranceItem != null) {
                initCommonEntranceReport(squareCommonEntranceViewHolder, squareEntranceItem);
            }
        }
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.map.IMapViewListener
    public void onItemClicked(MapViewHolder<?> vh5, int index, MapItem data, int viewId, Object extra) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        if (vh5 instanceof SquareCommonEntranceViewHolder) {
            SquareCommonEntranceViewHolder squareCommonEntranceViewHolder = (SquareCommonEntranceViewHolder) vh5;
            if (!(data instanceof SquareEntranceItem)) {
                data = null;
            }
            SquareEntranceItem squareEntranceItem = (SquareEntranceItem) data;
            if (squareEntranceItem != null) {
                onCommonEntranceItemClick(squareCommonEntranceViewHolder, squareEntranceItem, viewId, extra);
            }
        }
    }

    private final void initCommonEntranceReport(final SquareCommonEntranceViewHolder vh5, SquareEntranceItem data) {
        Map<String, Object> mutableMapOf;
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_BUILDING_ID, Integer.valueOf(data.getEntranceId()));
        pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_BUILDING_AREA, Integer.valueOf(data.getLocation().getArea()));
        pairArr[2] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_BUILDING_RANK, Integer.valueOf(data.getLocation().getRank()));
        pairArr[3] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_IS_AUXILIARY_AREA, Integer.valueOf(data.getAnchorEntry().size() > 0 ? 1 : 0));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        if (data.getEntranceType() == 10) {
            mutableMapOf.put(SquareReportConst.Key.KEY_ZPLAN_BUILDING_STYLE, Integer.valueOf(data.getStyleId()));
        }
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        FrameLayout mContainer = vh5.getBinding().getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "vh.binding.root");
        squareReporter.setElementInfo(mContainer, SquareReportConst.ElementId.ELEMENT_ID_ZPLAN_SQUARE_BUILDING, mutableMapOf, false, false);
        vh5.getBinding().getMContainer().postDelayed(new Runnable() { // from class: com.tencent.state.square.components.fragment.SquareCommonEntranceComponent$initCommonEntranceReport$1
            @Override // java.lang.Runnable
            public final void run() {
                IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
                FrameLayout mContainer2 = SquareCommonEntranceViewHolder.this.getBinding().getMContainer();
                Intrinsics.checkNotNullExpressionValue(mContainer2, "vh.binding.root");
                squareReporter2.reportEvent("imp", mContainer2, new LinkedHashMap());
            }
        }, 500L);
        bindCommonEntranceBubbleReport(vh5, data);
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.map.IMapViewListener
    public void onItemBind(MapViewHolder<?> vh5, int index, MapItem data, int event) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        if (vh5 instanceof SquareCommonEntranceViewHolder) {
            SquareCommonEntranceViewHolder squareCommonEntranceViewHolder = (SquareCommonEntranceViewHolder) vh5;
            if (!(data instanceof SquareEntranceItem)) {
                data = null;
            }
            SquareEntranceItem squareEntranceItem = (SquareEntranceItem) data;
            if (squareEntranceItem != null) {
                onCommonEntranceReport(squareCommonEntranceViewHolder, squareEntranceItem, event);
            }
        }
    }

    private final void bindCommonEntranceBubbleReport(final SquareCommonEntranceViewHolder vh5, final SquareEntranceItem data) {
        final BuildingBubble extraBubble;
        Map<String, Object> mutableMapOf;
        Object firstOrNull;
        String str;
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        List<BuildingBubble> bubbles = data.getBubbles();
        if (bubbles != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) bubbles);
            final BuildingBubble buildingBubble = (BuildingBubble) firstOrNull;
            if (buildingBubble != null) {
                int bubbleType = buildingBubble.getBubbleType();
                if (bubbleType == 1) {
                    str = "em_zplan_square_building_bubble_yunying";
                } else if (bubbleType != 2) {
                    str = "";
                } else {
                    str = "em_zplan_square_building_bubble_gongneng";
                }
                String str2 = str;
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                VasSquareEntranceBubbleBinding vasSquareEntranceBubbleBinding = vh5.getBinding().entranceBubble;
                Intrinsics.checkNotNullExpressionValue(vasSquareEntranceBubbleBinding, "vh.binding.entranceBubble");
                LinearLayout mContainer = vasSquareEntranceBubbleBinding.getMContainer();
                Intrinsics.checkNotNullExpressionValue(mContainer, "vh.binding.entranceBubble.root");
                squareReporter.setElementInfo(mContainer, str2, new LinkedHashMap(), false, false);
                vh5.itemView.postDelayed(new Runnable() { // from class: com.tencent.state.square.components.fragment.SquareCommonEntranceComponent$bindCommonEntranceBubbleReport$$inlined$let$lambda$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Map<String, Object> bubbleReportParams;
                        IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
                        VasSquareEntranceBubbleBinding vasSquareEntranceBubbleBinding2 = vh5.getBinding().entranceBubble;
                        Intrinsics.checkNotNullExpressionValue(vasSquareEntranceBubbleBinding2, "vh.binding.entranceBubble");
                        LinearLayout mContainer2 = vasSquareEntranceBubbleBinding2.getMContainer();
                        Intrinsics.checkNotNullExpressionValue(mContainer2, "vh.binding.entranceBubble.root");
                        bubbleReportParams = this.getBubbleReportParams(data, BuildingBubble.this);
                        squareReporter2.reportEvent("imp", mContainer2, bubbleReportParams);
                    }
                }, 500L);
                booleanRef.element = true;
            }
        }
        if (booleanRef.element || (extraBubble = data.getExtraBubble()) == null) {
            return;
        }
        IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
        VasSquareEntranceBubbleBinding vasSquareEntranceBubbleBinding2 = vh5.getBinding().entranceBubble;
        Intrinsics.checkNotNullExpressionValue(vasSquareEntranceBubbleBinding2, "vh.binding.entranceBubble");
        LinearLayout mContainer2 = vasSquareEntranceBubbleBinding2.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer2, "vh.binding.entranceBubble.root");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_LIB_BUBBLE_TYPE, Integer.valueOf(extraBubble.getLibBubbleType())));
        squareReporter2.setElementInfo(mContainer2, "em_zplan_square_building_bubble_yunying", mutableMapOf, false, false);
        vh5.itemView.postDelayed(new Runnable() { // from class: com.tencent.state.square.components.fragment.SquareCommonEntranceComponent$bindCommonEntranceBubbleReport$$inlined$let$lambda$2
            @Override // java.lang.Runnable
            public final void run() {
                Map<String, Object> bubbleReportParams;
                IReporter squareReporter3 = SquareBaseKt.getSquareReporter();
                VasSquareEntranceBubbleBinding vasSquareEntranceBubbleBinding3 = vh5.getBinding().entranceBubble;
                Intrinsics.checkNotNullExpressionValue(vasSquareEntranceBubbleBinding3, "vh.binding.entranceBubble");
                LinearLayout mContainer3 = vasSquareEntranceBubbleBinding3.getMContainer();
                Intrinsics.checkNotNullExpressionValue(mContainer3, "vh.binding.entranceBubble.root");
                bubbleReportParams = this.getBubbleReportParams(data, BuildingBubble.this);
                squareReporter3.reportEvent("imp", mContainer3, bubbleReportParams);
            }
        }, 500L);
        booleanRef.element = true;
    }

    private final void onCommonEntranceItemClick(SquareCommonEntranceViewHolder vh5, SquareEntranceItem data, int viewId, Object extra) {
        List<BuildingBubble> bubbles;
        Object firstOrNull;
        if (viewId != 10) {
            if (viewId != 12) {
                return;
            }
            if (!(extra instanceof BuildingBubble)) {
                extra = null;
            }
            BuildingBubble buildingBubble = (BuildingBubble) extra;
            if (buildingBubble != null) {
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                VasSquareEntranceBubbleBinding vasSquareEntranceBubbleBinding = vh5.getBinding().entranceBubble;
                Intrinsics.checkNotNullExpressionValue(vasSquareEntranceBubbleBinding, "vh.binding.entranceBubble");
                LinearLayout mContainer = vasSquareEntranceBubbleBinding.getMContainer();
                Intrinsics.checkNotNullExpressionValue(mContainer, "vh.binding.entranceBubble.root");
                squareReporter.reportEvent("clck", mContainer, getBubbleReportParams(data, buildingBubble));
                bindCommonEntranceBubbleReport(vh5, data);
                return;
            }
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!(extra instanceof BuildingBubble)) {
            extra = null;
        }
        BuildingBubble buildingBubble2 = (BuildingBubble) extra;
        if (buildingBubble2 != null && buildingBubble2.getLibBubbleType() > 0) {
            linkedHashMap.put(SquareReportConst.Key.KEY_LIB_BUBBLE_TYPE, Integer.valueOf(buildingBubble2.getLibBubbleType()));
        }
        IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
        FrameLayout mContainer2 = vh5.getBinding().getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer2, "vh.binding.root");
        squareReporter2.reportEvent("clck", mContainer2, linkedHashMap);
        if (data.getEntranceType() != 3 || (bubbles = data.getBubbles()) == null) {
            return;
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) bubbles);
        BuildingBubble buildingBubble3 = (BuildingBubble) firstOrNull;
        if (buildingBubble3 == null || buildingBubble3.getBubbleType() != 2) {
            return;
        }
        bindCommonEntranceBubbleReport(vh5, data);
    }

    private final void onCommonEntranceReport(SquareCommonEntranceViewHolder vh5, SquareEntranceItem data, int event) {
        if (event != 17) {
            return;
        }
        bindCommonEntranceBubbleReport(vh5, data);
    }
}
