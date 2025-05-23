package com.tencent.mobileqq.icgame.base.baseroom.roomstate;

import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.EnterExitRoomComponent;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.EnterRoomSuccessEvent;
import com.tencent.mobileqq.icgame.framework.component.h;
import g32.f;
import g32.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/icgame/base/baseroom/roomstate/RoomStateConnector;", "Lcom/tencent/mobileqq/icgame/framework/connector/a;", "", "a", "Lf32/b;", "cc", "<init>", "(Lf32/b;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class RoomStateConnector extends com.tencent.mobileqq.icgame.framework.connector.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomStateConnector(@NotNull f32.b cc5) {
        super(cc5);
        Intrinsics.checkNotNullParameter(cc5, "cc");
    }

    @Override // com.tencent.mobileqq.icgame.framework.connector.a, com.tencent.mobileqq.icgame.framework.connector.b
    public void a() {
        com.tencent.mobileqq.icgame.framework.component.d a16;
        h hVar;
        final com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.c cVar;
        h hVar2;
        com.tencent.mobileqq.icgame.framework.component.d a17 = com.tencent.mobileqq.icgame.base.room.b.a(this, EnterExitRoomComponent.class);
        final com.tencent.mobileqq.icgame.base.room.d dVar = null;
        if (a17 == null || (a16 = com.tencent.mobileqq.icgame.base.room.b.a(this, RoomStateComponent.class)) == null || (hVar = (h) a16.a()) == null) {
            cVar = null;
        } else {
            cVar = new com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.c(a17, hVar);
        }
        if (cVar == null) {
            cVar = null;
        } else {
            f.a(cVar.a(), new g32.d(EnterRoomSuccessEvent.class, new Function1<EnterRoomSuccessEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.base.baseroom.roomstate.RoomStateConnector$initEventConnector$$inlined$enterRoomSuc$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(EnterRoomSuccessEvent enterRoomSuccessEvent) {
                    invoke(enterRoomSuccessEvent);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull EnterRoomSuccessEvent it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ((RoomStateComponent) com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.c.this.b()).n();
                }
            }));
        }
        if (cVar != null) {
            f.a(cVar.a(), new g32.d(com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.a.class, new Function1<com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.a, Unit>() { // from class: com.tencent.mobileqq.icgame.base.baseroom.roomstate.RoomStateConnector$initEventConnector$$inlined$closeRoom$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.a aVar) {
                    invoke(aVar);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.a it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ((RoomStateComponent) com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.c.this.b()).o();
                }
            }));
        }
        g c16 = getConnectorContext().c();
        com.tencent.mobileqq.icgame.framework.component.d a18 = com.tencent.mobileqq.icgame.base.room.b.a(this, RoomStateComponent.class);
        if (a18 != null && (hVar2 = (h) a18.a()) != null) {
            dVar = new com.tencent.mobileqq.icgame.base.room.d(c16, hVar2);
        }
        if (dVar != null) {
            f.a(dVar.getRegister(), new g32.d(i22.g.class, new Function1<i22.g, Unit>() { // from class: com.tencent.mobileqq.icgame.base.baseroom.roomstate.RoomStateConnector$initEventConnector$$inlined$pageOut$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(i22.g gVar) {
                    invoke(gVar);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull i22.g it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ((RoomStateComponent) com.tencent.mobileqq.icgame.base.room.d.this.b()).o();
                }
            }));
        }
    }
}
