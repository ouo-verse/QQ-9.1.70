package com.tencent.mobileqq.icgame.room.followguide;

import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.EnterRoomSuccessEvent;
import com.tencent.mobileqq.icgame.base.room.d;
import com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector;
import com.tencent.mobileqq.icgame.base.room.service.lifecycle.ActivityLifecycle;
import com.tencent.mobileqq.icgame.framework.component.e;
import com.tencent.mobileqq.icgame.framework.component.h;
import com.tencent.mobileqq.icgame.room.component.a;
import f32.b;
import g32.f;
import g32.g;
import i22.ActivityLifecycleEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/followguide/FollowGuideConnector;", "Lcom/tencent/mobileqq/icgame/base/room/service/connector/RoomConnector;", "", "o", "Lf32/b;", "connectorContext", "<init>", "(Lf32/b;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class FollowGuideConnector extends RoomConnector {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FollowGuideConnector(@NotNull b connectorContext) {
        super(connectorContext);
        Intrinsics.checkNotNullParameter(connectorContext, "connectorContext");
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void o() {
        final d dVar;
        h hVar;
        super.o();
        com.tencent.mobileqq.icgame.framework.component.d a16 = com.tencent.mobileqq.icgame.base.room.b.a(this, a.class);
        if (a16 != null) {
            f.a(a16, new g32.d(EnterRoomSuccessEvent.class, new Function1<EnterRoomSuccessEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.followguide.FollowGuideConnector$onInitEventConnector$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(EnterRoomSuccessEvent enterRoomSuccessEvent) {
                    invoke2(enterRoomSuccessEvent);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull EnterRoomSuccessEvent it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    com.tencent.icgame.game.liveroom.impl.room.followguide.b bVar = (com.tencent.icgame.game.liveroom.impl.room.followguide.b) com.tencent.mobileqq.icgame.base.room.b.c(FollowGuideConnector.this, com.tencent.icgame.game.liveroom.impl.room.followguide.b.class);
                    if (bVar != null) {
                        bVar.b();
                    }
                }
            }));
        }
        g c16 = getConnectorContext().c();
        com.tencent.mobileqq.icgame.framework.component.d a17 = com.tencent.mobileqq.icgame.base.room.b.a(this, com.tencent.icgame.game.liveroom.impl.room.followguide.b.class);
        final d dVar2 = null;
        if (a17 != null && (hVar = (h) a17.a()) != null) {
            dVar = new d(c16, hVar);
        } else {
            dVar = null;
        }
        if (dVar != null) {
            f.a(dVar.getRegister(), new g32.d(ActivityLifecycleEvent.class, new Function1<ActivityLifecycleEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.followguide.FollowGuideConnector$onInitEventConnector$$inlined$activityDestroy$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ActivityLifecycleEvent activityLifecycleEvent) {
                    invoke(activityLifecycleEvent);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull ActivityLifecycleEvent it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    e b16 = d.this.b();
                    if (it.getLifecycle() == ActivityLifecycle.ON_DESTROY) {
                        ((com.tencent.icgame.game.liveroom.impl.room.followguide.b) b16).c();
                    }
                }
            }));
            dVar2 = dVar;
        }
        if (dVar2 != null) {
            f.a(dVar2.getRegister(), new g32.d(i22.g.class, new Function1<i22.g, Unit>() { // from class: com.tencent.mobileqq.icgame.room.followguide.FollowGuideConnector$onInitEventConnector$$inlined$pageOut$1
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
                    ((com.tencent.icgame.game.liveroom.impl.room.followguide.b) d.this.b()).c();
                }
            }));
        }
    }
}
