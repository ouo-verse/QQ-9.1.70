package com.tencent.state.map;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.state.map.IMapDataIndexer;
import com.tencent.state.square.media.SquarePlayerPool;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\b&\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030\u0002j\u0002`\u00030\u00012\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\"\u0010\u000f\u001a\u00020\u00102\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00100\u0012J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\tH&J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\u0018\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J \u0010\u001c\u001a\u00020\u00102\u000e\u0010\u001d\u001a\n\u0012\u0002\b\u00030\u0002j\u0002`\u00032\u0006\u0010\u0016\u001a\u00020\tH\u0017J.\u0010\u001c\u001a\u00020\u00102\u000e\u0010\u001d\u001a\n\u0012\u0002\b\u00030\u0002j\u0002`\u00032\u0006\u0010\u0018\u001a\u00020\t2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J\u0006\u0010!\u001a\u00020\u0010J\u0018\u0010\"\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0013H&R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@DX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006$"}, d2 = {"Lcom/tencent/state/map/MapAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "Lcom/tencent/state/map/IMapDataIndexer;", "()V", "controller", "Lcom/tencent/state/map/MapItemController;", "<set-?>", "", "meIndex", "getMeIndex", "()I", "setMeIndex", "(I)V", "forEachItemData", "", "block", "Lkotlin/Function2;", "Lcom/tencent/state/map/MapItem;", "getController", "getItemData", "index", "getItemViewType", "position", "initialize", "insetItemData", "mapItem", "onBindViewHolder", "holder", "payloads", "", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "setItemData", "data", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public abstract class MapAdapter extends RecyclerView.Adapter<MapViewHolder<?>> implements IMapDataIndexer {
    private MapItemController controller;
    private int meIndex = -1;

    public final void forEachItemData(Function2<? super Integer, ? super MapItem, Unit> block) {
        IntRange until;
        Intrinsics.checkNotNullParameter(block, "block");
        until = RangesKt___RangesKt.until(0, getItemCount());
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            block.invoke(Integer.valueOf(nextInt), getItemData(nextInt));
        }
    }

    public final MapItemController getController() {
        return this.controller;
    }

    public abstract MapItem getItemData(int index);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        MapItem itemData = getItemData(position);
        if (itemData != null) {
            return itemData.getType();
        }
        return super.getItemViewType(position);
    }

    public final int getMeIndex() {
        return this.meIndex;
    }

    @Override // com.tencent.state.map.IMapDataIndexer
    public int indexOf(MapItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return IMapDataIndexer.DefaultImpls.indexOf(this, data);
    }

    @Override // com.tencent.state.map.IMapDataIndexer
    public int indexOfUnitType(String uin, int i3) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return IMapDataIndexer.DefaultImpls.indexOfUnitType(this, uin, i3);
    }

    public void initialize(MapItemController controller) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.controller = controller;
    }

    public void insetItemData(int position, MapItem mapItem) {
        Intrinsics.checkNotNullParameter(mapItem, "mapItem");
    }

    public final void onDestroy() {
        SquarePlayerPool playerPool;
        MapItemController mapItemController = this.controller;
        if (mapItemController == null || (playerPool = mapItemController.getPlayerPool()) == null) {
            return;
        }
        playerPool.destroy();
    }

    public abstract void setItemData(int index, MapItem data);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setMeIndex(int i3) {
        this.meIndex = i3;
    }

    @Override // com.tencent.state.map.IMapDataIndexer
    public int indexOf(String uin, int i3) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return IMapDataIndexer.DefaultImpls.indexOf(this, uin, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(MapViewHolder<?> mapViewHolder, int i3, List list) {
        onBindViewHolder2(mapViewHolder, i3, (List<Object>) list);
    }

    @Override // com.tencent.state.map.IMapDataIndexer
    public int indexOf(String uin, int i3, int i16) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return IMapDataIndexer.DefaultImpls.indexOf(this, uin, i3, i16);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MapViewHolder<?> holder, int index) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MapItem itemData = getItemData(index);
        if (itemData == null) {
            View view = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            view.setVisibility(4);
        } else {
            holder.setMapAdapter(this);
            holder.bind(itemData, index);
        }
    }

    /* renamed from: onBindViewHolder, reason: avoid collision after fix types in other method */
    public void onBindViewHolder2(MapViewHolder<?> holder, int position, List<Object> payloads) {
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) payloads);
        if (!(firstOrNull instanceof Integer)) {
            firstOrNull = null;
        }
        Integer num = (Integer) firstOrNull;
        if (num != null) {
            int intValue = num.intValue();
            MapItem itemData = getItemData(position);
            if (itemData != null) {
                holder.bind(itemData, position, intValue);
            }
        }
    }
}
