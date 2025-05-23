package com.tencent.state.map;

import android.util.SparseArray;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0002\b\u00030\u0006j\u0002`\u0007J\u001e\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030\u0006j\u0002`\u00070\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001a\u0010\u000e\u001a\u000e\u0012\u0002\b\u0003\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016R\"\u0010\u0003\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030\u0006j\u0002`\u00070\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/map/RecycledViewPool;", "", "()V", "pools", "Landroid/util/SparseArray;", "Ljava/util/LinkedList;", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "addRecycleView", "", "viewType", "", "holder", "getPool", "getRecycledView", "toString", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class RecycledViewPool {
    private static final int MAX_POOL_SIZE = 40;
    private static final String TAG = "Square_RecycledViewPool";
    private final SparseArray<LinkedList<MapViewHolder<?>>> pools = new SparseArray<>();

    private final LinkedList<MapViewHolder<?>> getPool(int viewType) {
        if (this.pools.get(viewType) == null) {
            this.pools.put(viewType, new LinkedList<>());
        }
        LinkedList<MapViewHolder<?>> linkedList = this.pools.get(viewType);
        Intrinsics.checkNotNullExpressionValue(linkedList, "pools[viewType]");
        return linkedList;
    }

    public final void addRecycleView(int viewType, MapViewHolder<?> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onRecycled();
        LinkedList<MapViewHolder<?>> pool = getPool(viewType);
        if (pool.size() < 40) {
            pool.offer(holder);
        }
    }

    public final MapViewHolder<?> getRecycledView(int viewType) {
        return getPool(viewType).poll();
    }

    public String toString() {
        return "RecycledViewPool(pool count: " + this.pools.size() + ", first pool size: " + getPool(1).size() + ')';
    }
}
