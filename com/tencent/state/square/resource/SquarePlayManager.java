package com.tencent.state.square.resource;

import com.tencent.state.map.IMapItemViewManager;
import com.tencent.state.map.MapPlayManager;
import com.tencent.state.map.MapPlayableItem;
import com.tencent.state.map.MapPlayableViewHolder;
import com.tencent.state.square.data.SquareAvatarItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0014\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/square/resource/SquarePlayManager;", "Lcom/tencent/state/map/MapPlayManager;", "vm", "Lcom/tencent/state/map/IMapItemViewManager;", "(Lcom/tencent/state/map/IMapItemViewManager;)V", "canPausePlay", "", "index", "", "ensurePlay", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquarePlayManager extends MapPlayManager {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquarePlayManager(IMapItemViewManager vm5) {
        super(vm5);
        Intrinsics.checkNotNullParameter(vm5, "vm");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.state.map.MapPlayManager
    protected boolean canPausePlay(int index) {
        if (super.canPausePlay(index)) {
            MapPlayableViewHolder<?> viewHolder = getViewHolder(index);
            MapPlayableItem mapPlayableItem = viewHolder != null ? (MapPlayableItem) viewHolder.getData() : null;
            SquareAvatarItem squareAvatarItem = (SquareAvatarItem) (mapPlayableItem instanceof SquareAvatarItem ? mapPlayableItem : null);
            if (squareAvatarItem != null && !SquareResourceManagerKt.hasUnreadMessage(squareAvatarItem)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.state.map.MapPlayManager
    protected void ensurePlay() {
        ensureMePlay();
        MapPlayManager.ensureAvatarPlay$default(this, 0, new Function1<Integer, Boolean>() { // from class: com.tencent.state.square.resource.SquarePlayManager$ensurePlay$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                return Boolean.valueOf(invoke(num.intValue()));
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final boolean invoke(int i3) {
                MapPlayableViewHolder viewHolder;
                viewHolder = SquarePlayManager.this.getViewHolder(i3);
                MapPlayableItem mapPlayableItem = viewHolder != null ? (MapPlayableItem) viewHolder.getData() : null;
                return (mapPlayableItem instanceof SquareAvatarItem) && SquareResourceManagerKt.hasUnreadMessage((SquareAvatarItem) mapPlayableItem);
            }
        }, 1, null);
        super.ensurePlay();
    }
}
