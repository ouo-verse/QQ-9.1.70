package com.tencent.timi.game.liveroom.impl.room.medal;

import com.tencent.timi.game.liveroom.impl.room.medal.data.QQLiveMedalServiceImpl;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/QQLiveMedalServiceSupplier;", "", "Lcom/tencent/timi/game/liveroom/impl/room/medal/d;", "a", "b", "Lkotlin/Lazy;", "()Lcom/tencent/timi/game/liveroom/impl/room/medal/d;", "_medalService", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class QQLiveMedalServiceSupplier {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QQLiveMedalServiceSupplier f377955a = new QQLiveMedalServiceSupplier();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy _medalService;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQLiveMedalServiceImpl>() { // from class: com.tencent.timi.game.liveroom.impl.room.medal.QQLiveMedalServiceSupplier$_medalService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QQLiveMedalServiceImpl invoke() {
                return new QQLiveMedalServiceImpl();
            }
        });
        _medalService = lazy;
    }

    QQLiveMedalServiceSupplier() {
    }

    private final d b() {
        return (d) _medalService.getValue();
    }

    @NotNull
    public final d a() {
        return b();
    }
}
