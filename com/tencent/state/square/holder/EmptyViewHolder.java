package com.tencent.state.square.holder;

import android.content.Context;
import android.view.View;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.square.data.SquareEmptyData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0014J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\fH\u0014\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/state/square/holder/EmptyViewHolder;", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/square/data/SquareEmptyData;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "doBind", "", "data", "index", "", "onFirstScreenCompleted", "Lcom/tencent/state/map/MapItem;", "transform", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class EmptyViewHolder extends MapViewHolder<SquareEmptyData> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyViewHolder(Context context) {
        super(new View(context));
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapViewHolder
    public void doBind(SquareEmptyData data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.state.map.MapViewHolder
    public void onFirstScreenCompleted(MapItem data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapViewHolder
    public SquareEmptyData transform(MapItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof SquareEmptyData)) {
            data = null;
        }
        return (SquareEmptyData) data;
    }
}
