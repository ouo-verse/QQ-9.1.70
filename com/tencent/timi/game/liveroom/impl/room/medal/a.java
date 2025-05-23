package com.tencent.timi.game.liveroom.impl.room.medal;

import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.liveroom.impl.room.medal.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b&\u0018\u0000 \t*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J$\u0010\t\u001a\u00020\b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0010\u0010\u0007\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u0006J\u001b\u0010\n\u001a\u00028\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H&\u00a2\u0006\u0004\b\n\u0010\u000bJ5\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00028\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0010\u0010\u0007\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u0006H&\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u00028\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H&\u00a2\u0006\u0004\b\u000f\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/a;", "I", "T", "Lcom/tencent/timi/game/liveroom/impl/room/medal/c;", "Lcom/tencent/timi/game/liveroom/impl/room/medal/g;", "renderData", "Lcom/tencent/timi/game/liveroom/impl/room/medal/c$a;", "callback", "", "a", "c", "(Lcom/tencent/timi/game/liveroom/impl/room/medal/g;)Ljava/lang/Object;", "data", "d", "(Ljava/lang/Object;Lcom/tencent/timi/game/liveroom/impl/room/medal/g;Lcom/tencent/timi/game/liveroom/impl/room/medal/c$a;)V", "b", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class a<I, T> implements c<I, T> {
    @Override // com.tencent.timi.game.liveroom.impl.room.medal.c
    public final void a(@NotNull g<?> renderData, @NotNull c.a<?, T> callback) {
        Intrinsics.checkNotNullParameter(renderData, "renderData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            d(c(renderData), renderData, callback);
        } catch (ClassCastException e16) {
            QLog.i("BaseMsgInfoRender", 1, "render exception:" + e16);
            callback.a(renderData, b(renderData));
        }
    }

    public abstract T b(@NotNull g<?> renderData);

    public abstract I c(@NotNull g<?> renderData);

    public abstract void d(I data, @NotNull g<?> renderData, @NotNull c.a<?, T> callback);
}
