package com.tencent.timi.game.liveroom.impl.room.medal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0001\tJ&\u0010\t\u001a\u00020\b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0010\u0010\u0007\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/c;", "I", "T", "", "Lcom/tencent/timi/game/liveroom/impl/room/medal/g;", "renderData", "Lcom/tencent/timi/game/liveroom/impl/room/medal/c$a;", "callback", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface c<I, T> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003J#\u0010\b\u001a\u00020\u00072\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0006\u001a\u00028\u0003H&\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/c$a;", "I", "T", "", "Lcom/tencent/timi/game/liveroom/impl/room/medal/g;", "data", "renderResult", "", "a", "(Lcom/tencent/timi/game/liveroom/impl/room/medal/g;Ljava/lang/Object;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface a<I, T> {
        void a(@NotNull g<?> data, T renderResult);
    }

    void a(@NotNull g<?> renderData, @NotNull a<?, T> callback);
}
