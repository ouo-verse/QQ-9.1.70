package com.tencent.state.map;

import android.view.View;
import androidx.collection.LruCache;
import com.tencent.state.square.SquareBaseKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u000b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u00030\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\u00162\u000e\u0010\u0017\u001a\n\u0012\u0002\b\u00030\u0018j\u0002`\u0019J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0010J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0002\b\u00030\u0003j\u0002`\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/state/map/MapRecycler;", "", "square", "Lcom/tencent/state/map/BaseMapView;", "Lcom/tencent/state/map/MapView;", "adapter", "Lcom/tencent/state/map/MapAdapter;", "locator", "Lcom/tencent/state/map/IMapLocator;", "(Lcom/tencent/state/map/BaseMapView;Lcom/tencent/state/map/MapAdapter;Lcom/tencent/state/map/IMapLocator;)V", "cachedViews", "com/tencent/state/map/MapRecycler$cachedViews$1", "Lcom/tencent/state/map/MapRecycler$cachedViews$1;", "recyclePool", "Lcom/tencent/state/map/RecycledViewPool;", "getViewForIndex", "Landroid/view/View;", "index", "", "data", "Lcom/tencent/state/map/MapItem;", "recycleView", "", "holder", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "view", "toString", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class MapRecycler {
    private static final int MAX_CACHE_SIZE = 3;
    private static final String TAG = "Square_SquareRecycler";
    private final MapAdapter adapter;
    private final MapRecycler$cachedViews$1 cachedViews;
    private final IMapLocator locator;

    /* renamed from: recyclePool, reason: from kotlin metadata and from toString */
    private final RecycledViewPool pool;
    private final BaseMapView<?> square;

    /* JADX WARN: Type inference failed for: r2v1, types: [com.tencent.state.map.MapRecycler$cachedViews$1] */
    public MapRecycler(BaseMapView<?> square, MapAdapter adapter, IMapLocator locator) {
        Intrinsics.checkNotNullParameter(square, "square");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(locator, "locator");
        this.square = square;
        this.adapter = adapter;
        this.locator = locator;
        final int i3 = 3;
        this.cachedViews = new LruCache<Integer, MapViewHolder<?>>(i3) { // from class: com.tencent.state.map.MapRecycler$cachedViews$1
            @Override // androidx.collection.LruCache
            public /* bridge */ /* synthetic */ void entryRemoved(boolean z16, Integer num, MapViewHolder<?> mapViewHolder, MapViewHolder<?> mapViewHolder2) {
                entryRemoved(z16, num.intValue(), mapViewHolder, mapViewHolder2);
            }

            protected void entryRemoved(boolean evicted, int key, MapViewHolder<?> oldValue, MapViewHolder<?> newValue) {
                RecycledViewPool recycledViewPool;
                Intrinsics.checkNotNullParameter(oldValue, "oldValue");
                if (evicted) {
                    recycledViewPool = MapRecycler.this.pool;
                    recycledViewPool.addRecycleView(oldValue.getViewType(), oldValue);
                }
            }
        };
        this.pool = new RecycledViewPool();
    }

    public final View getViewForIndex(int index) {
        int itemViewType = this.adapter.getItemViewType(index);
        MapViewHolder<?> mapViewHolder = get(Integer.valueOf(index));
        if (mapViewHolder != null) {
            remove(Integer.valueOf(index));
            if (mapViewHolder.getLastViewTypeForCache() != itemViewType) {
                SquareBaseKt.getSquareLog().d(TAG, "getViewForIndex, from first cache but type not match!");
                mapViewHolder = null;
            }
        }
        if (mapViewHolder == null) {
            mapViewHolder = this.pool.getRecycledView(itemViewType);
        }
        if (mapViewHolder == null) {
            mapViewHolder = this.adapter.onCreateViewHolder(this.square, itemViewType);
        }
        this.adapter.onBindViewHolder(mapViewHolder, index);
        mapViewHolder.setLayoutParams(this.locator.getItemPosition(index));
        View view = mapViewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        return view;
    }

    public final void recycleView(int index, View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        MapViewHolder<?> mapViewHolder = MapViewKt.getMapViewHolder(view);
        if (mapViewHolder != null) {
            MapViewHolder<?> mapViewHolder2 = get(Integer.valueOf(index));
            put(Integer.valueOf(index), mapViewHolder);
            if (mapViewHolder2 != null) {
                SquareBaseKt.getSquareLog().i(TAG, "recycle view: cacheViews has same index: " + index);
                this.pool.addRecycleView(mapViewHolder2.getViewType(), mapViewHolder2);
            }
        }
    }

    public String toString() {
        return "SquareRecycler: cachedViews=" + size() + ", pool=" + this.pool;
    }

    public final void recycleView(MapViewHolder<?> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.pool.addRecycleView(holder.getViewType(), holder);
    }

    public final View getViewForIndex(int index, MapItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        int type = data.getType();
        MapViewHolder<?> recycledView = this.pool.getRecycledView(type);
        if (recycledView == null) {
            recycledView = this.adapter.onCreateViewHolder(this.square, type);
        }
        recycledView.bind(data, index);
        recycledView.setLayoutParams(this.locator.getItemPosition(index));
        View view = recycledView.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        return view;
    }
}
