package com.tencent.state.square.components.fragment;

import android.widget.LinearLayout;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.databinding.VasSquareItemAvatarBinding;
import com.tencent.state.square.flower.FlowerLayoutView;
import com.tencent.state.square.holder.AvatarViewHolder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0011H\u0002J*\u0010\u0013\u001a\u00020\u00102\u000e\u0010\u0014\u001a\n\u0012\u0002\b\u00030\u0005j\u0002`\u00062\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J<\u0010\u0017\u001a\u00020\u00102\u000e\u0010\u0014\u001a\n\u0012\u0002\b\u00030\u0005j\u0002`\u00062\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0018\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\fH\u0016R\"\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\n\u0012\u0002\b\u00030\u0005j\u0002`\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareFlowerReportComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareItemAvatarBinding;", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "getBinding", "(Lcom/tencent/state/map/MapViewHolder;)Lcom/tencent/state/square/databinding/VasSquareItemAvatarBinding;", "getFlowerReportParams", "", "", "", "data", "Lcom/tencent/state/map/MapItem;", "initFlowerElement", "", "Lcom/tencent/state/square/data/SquareAvatarItem;", "initFlowerViewElement", "onItemBind", "vh", "index", "", "onItemClicked", "viewId", "extra", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareFlowerReportComponent extends SquareBaseComponent {
    private final VasSquareItemAvatarBinding getBinding(MapViewHolder<?> mapViewHolder) {
        if (!(mapViewHolder instanceof AvatarViewHolder)) {
            mapViewHolder = null;
        }
        AvatarViewHolder avatarViewHolder = (AvatarViewHolder) mapViewHolder;
        if (avatarViewHolder != null) {
            return avatarViewHolder.getBinding();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> getFlowerReportParams(MapItem data) {
        Map<String, Object> mutableMapOf;
        if (!(data instanceof SquareAvatarItem)) {
            data = null;
        }
        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) data;
        if (squareAvatarItem != null) {
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_zhutai_ketai", Integer.valueOf(!squareAvatarItem.isMe() ? 1 : 0)), TuplesKt.to("zplan_square_flower_num", Integer.valueOf(squareAvatarItem.getExtra().getFlowerCount())));
            return mutableMapOf;
        }
        return new LinkedHashMap();
    }

    private final void initFlowerElement(final VasSquareItemAvatarBinding binding, final SquareAvatarItem data) {
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        LinearLayout linearLayout = binding.flowerLabel;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.flowerLabel");
        squareReporter.setElementInfo(linearLayout, "em_zplan_flower_num_entrance", getFlowerReportParams(data), false, false);
        SquareBaseKt.getSquareThread().postOnUiDelayed(500L, new Function0<Unit>() { // from class: com.tencent.state.square.components.fragment.SquareFlowerReportComponent$initFlowerElement$1
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
                Map<String, Object> flowerReportParams;
                IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
                LinearLayout linearLayout2 = binding.flowerLabel;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.flowerLabel");
                flowerReportParams = SquareFlowerReportComponent.this.getFlowerReportParams(data);
                squareReporter2.reportEvent("imp", linearLayout2, flowerReportParams);
            }
        });
    }

    private final void initFlowerViewElement(final VasSquareItemAvatarBinding binding, final SquareAvatarItem data) {
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        FlowerLayoutView flowerLayoutView = binding.flowerView;
        Intrinsics.checkNotNullExpressionValue(flowerLayoutView, "binding.flowerView");
        squareReporter.setElementInfo(flowerLayoutView, "em_zplan_flower_num_show", getFlowerReportParams(data), false, false);
        if (data.getExtra().getFlowerCount() > 0) {
            SquareBaseKt.getSquareThread().postOnUiDelayed(500L, new Function0<Unit>() { // from class: com.tencent.state.square.components.fragment.SquareFlowerReportComponent$initFlowerViewElement$1
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
                    Map<String, Object> flowerReportParams;
                    IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
                    FlowerLayoutView flowerLayoutView2 = binding.flowerView;
                    Intrinsics.checkNotNullExpressionValue(flowerLayoutView2, "binding.flowerView");
                    flowerReportParams = SquareFlowerReportComponent.this.getFlowerReportParams(data);
                    squareReporter2.reportEvent("imp", flowerLayoutView2, flowerReportParams);
                }
            });
        }
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.map.IMapViewListener
    public void onItemBind(MapViewHolder<?> vh5, int index, MapItem data) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        VasSquareItemAvatarBinding binding = getBinding(vh5);
        if (binding == null || !(data instanceof SquareAvatarItem)) {
            return;
        }
        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) data;
        initFlowerElement(binding, squareAvatarItem);
        initFlowerViewElement(binding, squareAvatarItem);
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.map.IMapViewListener
    public void onItemClicked(MapViewHolder<?> vh5, int index, MapItem data, int viewId, Object extra) {
        VasSquareItemAvatarBinding binding;
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(vh5, "vh");
        if (viewId != 14 || (binding = getBinding(vh5)) == null || (linearLayout = binding.flowerLabel) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(linearLayout, "vh.binding?.flowerLabel ?: return");
        SquareBaseKt.getSquareReporter().reportEvent("clck", linearLayout, getFlowerReportParams(data));
    }
}
