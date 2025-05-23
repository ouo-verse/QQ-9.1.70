package com.tencent.icgame.game.liveroom.impl.room.roomconfig;

import com.tencent.mobileqq.icgame.framework.eventbroadcaster.annotation.ComponentEvent;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@ComponentEvent(eventList = {c.class})
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/roomconfig/RoomConfigComponent;", "Lcom/tencent/mobileqq/icgame/framework/component/b;", "", "c", "k", "i", "Lh22/a;", "qqLiveRoomService", "Lh22/a;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/icgame/game/liveroom/impl/room/roomconfig/a;", "e", "Lkotlin/Lazy;", "b", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "configChangeList", "Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class RoomConfigComponent extends com.tencent.mobileqq.icgame.framework.component.b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy configChangeList;

    @InjectService(key = h22.a.class)
    private h22.a qqLiveRoomService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomConfigComponent(@NotNull f32.a componentContext) {
        super(componentContext);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CopyOnWriteArrayList<a>>() { // from class: com.tencent.icgame.game.liveroom.impl.room.roomconfig.RoomConfigComponent$configChangeList$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CopyOnWriteArrayList<a> invoke() {
                return new CopyOnWriteArrayList<>();
            }
        });
        this.configChangeList = lazy;
    }

    private final CopyOnWriteArrayList<a> b() {
        return (CopyOnWriteArrayList) this.configChangeList.getValue();
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
        c();
        b().clear();
    }

    private final void c() {
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void k() {
    }
}
