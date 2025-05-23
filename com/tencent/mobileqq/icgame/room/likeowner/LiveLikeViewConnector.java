package com.tencent.mobileqq.icgame.room.likeowner;

import android.text.TextUtils;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.EnterRoomSuccessEvent;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.ExitRoomEvent;
import com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector;
import com.tencent.mobileqq.icgame.framework.component.e;
import g32.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/likeowner/LiveLikeViewConnector;", "Lcom/tencent/mobileqq/icgame/base/room/service/connector/RoomConnector;", "", "Li32/a;", "c", "", "o", "Lf32/b;", "connectorContext", "<init>", "(Lf32/b;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LiveLikeViewConnector extends RoomConnector {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/icgame/room/likeowner/LiveLikeViewConnector$a", "Lcom/tencent/mobileqq/icgame/room/likeowner/a;", "", "value", "", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements com.tencent.mobileqq.icgame.room.likeowner.a {
        a() {
        }

        @Override // com.tencent.mobileqq.icgame.room.likeowner.a
        public void a(boolean value) {
            c cVar = (c) com.tencent.mobileqq.icgame.base.room.b.c(LiveLikeViewConnector.this, c.class);
            if (cVar != null) {
                cVar.w(value);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveLikeViewConnector(@NotNull f32.b connectorContext) {
        super(connectorContext);
        Intrinsics.checkNotNullParameter(connectorContext, "connectorContext");
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector, com.tencent.mobileqq.icgame.framework.connector.a, com.tencent.mobileqq.icgame.framework.connector.b
    @NotNull
    public List<i32.a<?>> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new i32.a(com.tencent.mobileqq.icgame.room.likeowner.a.class, new a()));
        return arrayList;
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void o() {
        final com.tencent.mobileqq.icgame.base.room.c cVar;
        final com.tencent.mobileqq.icgame.base.room.c cVar2;
        super.o();
        com.tencent.mobileqq.icgame.framework.component.d a16 = com.tencent.mobileqq.icgame.base.room.b.a(this, tv0.a.class);
        final com.tencent.mobileqq.icgame.base.room.c cVar3 = null;
        if (a16 == null) {
            cVar = null;
        } else {
            cVar = new com.tencent.mobileqq.icgame.base.room.c(this, a16, c.class, "");
        }
        if (cVar != null) {
            f.a(cVar.b(), new g32.d(com.tencent.icgame.game.liveroom.impl.room.roomconfig.b.class, new Function1<com.tencent.icgame.game.liveroom.impl.room.roomconfig.b, Unit>() { // from class: com.tencent.mobileqq.icgame.room.likeowner.LiveLikeViewConnector$onInitEventConnector$$inlined$connect$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.icgame.game.liveroom.impl.room.roomconfig.b bVar) {
                    invoke(bVar);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull com.tencent.icgame.game.liveroom.impl.room.roomconfig.b it) {
                    e e16;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (TextUtils.isEmpty(com.tencent.mobileqq.icgame.base.room.c.this.getToKey())) {
                        com.tencent.mobileqq.icgame.framework.connector.b conn = com.tencent.mobileqq.icgame.base.room.c.this.getConn();
                        Class c16 = com.tencent.mobileqq.icgame.base.room.c.this.c();
                        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.ISingleComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.c(conn, c16);
                    } else {
                        com.tencent.mobileqq.icgame.framework.connector.b conn2 = com.tencent.mobileqq.icgame.base.room.c.this.getConn();
                        Class c17 = com.tencent.mobileqq.icgame.base.room.c.this.c();
                        Intrinsics.checkNotNull(c17, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.IMultiComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.e(conn2, c17, com.tencent.mobileqq.icgame.base.room.c.this.getToKey());
                    }
                    if (e16 != null) {
                        ((c) e16).t(it);
                    }
                }
            }));
        }
        com.tencent.mobileqq.icgame.framework.component.d a17 = com.tencent.mobileqq.icgame.base.room.b.a(this, com.tencent.mobileqq.icgame.room.component.a.class);
        if (a17 == null) {
            cVar2 = null;
        } else {
            cVar2 = new com.tencent.mobileqq.icgame.base.room.c(this, a17, c.class, "");
        }
        if (cVar2 != null) {
            f.a(cVar2.b(), new g32.d(EnterRoomSuccessEvent.class, new Function1<EnterRoomSuccessEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.likeowner.LiveLikeViewConnector$onInitEventConnector$$inlined$connect$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(EnterRoomSuccessEvent enterRoomSuccessEvent) {
                    invoke(enterRoomSuccessEvent);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull EnterRoomSuccessEvent it) {
                    e e16;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (TextUtils.isEmpty(com.tencent.mobileqq.icgame.base.room.c.this.getToKey())) {
                        com.tencent.mobileqq.icgame.framework.connector.b conn = com.tencent.mobileqq.icgame.base.room.c.this.getConn();
                        Class c16 = com.tencent.mobileqq.icgame.base.room.c.this.c();
                        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.ISingleComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.c(conn, c16);
                    } else {
                        com.tencent.mobileqq.icgame.framework.connector.b conn2 = com.tencent.mobileqq.icgame.base.room.c.this.getConn();
                        Class c17 = com.tencent.mobileqq.icgame.base.room.c.this.c();
                        Intrinsics.checkNotNull(c17, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.IMultiComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.e(conn2, c17, com.tencent.mobileqq.icgame.base.room.c.this.getToKey());
                    }
                    if (e16 != null) {
                        ((c) e16).u();
                    }
                }
            }));
        }
        com.tencent.mobileqq.icgame.framework.component.d a18 = com.tencent.mobileqq.icgame.base.room.b.a(this, com.tencent.mobileqq.icgame.room.component.a.class);
        if (a18 != null) {
            cVar3 = new com.tencent.mobileqq.icgame.base.room.c(this, a18, c.class, "");
        }
        if (cVar3 != null) {
            f.a(cVar3.b(), new g32.d(ExitRoomEvent.class, new Function1<ExitRoomEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.likeowner.LiveLikeViewConnector$onInitEventConnector$$inlined$connect$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ExitRoomEvent exitRoomEvent) {
                    invoke(exitRoomEvent);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull ExitRoomEvent it) {
                    e e16;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (TextUtils.isEmpty(com.tencent.mobileqq.icgame.base.room.c.this.getToKey())) {
                        com.tencent.mobileqq.icgame.framework.connector.b conn = com.tencent.mobileqq.icgame.base.room.c.this.getConn();
                        Class c16 = com.tencent.mobileqq.icgame.base.room.c.this.c();
                        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.ISingleComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.c(conn, c16);
                    } else {
                        com.tencent.mobileqq.icgame.framework.connector.b conn2 = com.tencent.mobileqq.icgame.base.room.c.this.getConn();
                        Class c17 = com.tencent.mobileqq.icgame.base.room.c.this.c();
                        Intrinsics.checkNotNull(c17, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.IMultiComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.e(conn2, c17, com.tencent.mobileqq.icgame.base.room.c.this.getToKey());
                    }
                    if (e16 != null) {
                        ((c) e16).v();
                    }
                }
            }));
        }
    }
}
