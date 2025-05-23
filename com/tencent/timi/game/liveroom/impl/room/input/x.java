package com.tencent.timi.game.liveroom.impl.room.input;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/input/x;", "", "", "roomId", "Lcom/tencent/timi/game/liveroom/impl/room/input/p;", "a", "barrageDataCache", "", "b", "", "Ljava/util/Map;", "roomIdToBarrageDataCache", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final x f377844a = new x();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Long, BarrageDataCache> roomIdToBarrageDataCache = new LinkedHashMap();

    x() {
    }

    @Nullable
    public final BarrageDataCache a(long roomId) {
        return roomIdToBarrageDataCache.get(Long.valueOf(roomId));
    }

    public final void b(long roomId, @NotNull BarrageDataCache barrageDataCache) {
        Intrinsics.checkNotNullParameter(barrageDataCache, "barrageDataCache");
        roomIdToBarrageDataCache.put(Long.valueOf(roomId), barrageDataCache);
    }
}
