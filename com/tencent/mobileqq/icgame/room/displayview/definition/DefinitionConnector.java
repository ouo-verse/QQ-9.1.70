package com.tencent.mobileqq.icgame.room.displayview.definition;

import android.text.TextUtils;
import com.tencent.icgame.game.liveroom.impl.room.definition.DefinitionController;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.EnterRoomSuccessEvent;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.ExitRoomSuccessEvent;
import com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector;
import com.tencent.mobileqq.icgame.framework.component.d;
import com.tencent.mobileqq.icgame.framework.component.e;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import g32.f;
import i22.g;
import i22.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\rH\u0014J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u000fH\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/displayview/definition/DefinitionConnector;", "Lcom/tencent/mobileqq/icgame/base/room/service/connector/RoomConnector;", "Lcom/tencent/mobileqq/icgame/framework/component/d;", "Ltv0/a;", "E", "", "Li32/a;", "c", "", "o", "Li22/h;", "event", "w", "Li22/e;", ReportConstant.COSTREPORT_PREFIX, "Li22/g;", "u", "Lf32/b;", "connectorContext", "<init>", "(Lf32/b;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class DefinitionConnector extends RoomConnector {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/icgame/room/displayview/definition/DefinitionConnector$a", "Lcom/tencent/mobileqq/icgame/room/displayview/definition/c;", "", "c", "Lcom/tencent/icgame/game/liveroom/impl/room/definition/DefinitionController$c;", "listener", "b", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements c {
        a() {
        }

        @Override // com.tencent.mobileqq.icgame.room.displayview.definition.c
        public void a(@NotNull DefinitionController.c listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            b bVar = (b) com.tencent.mobileqq.icgame.base.room.b.d(DefinitionConnector.this.getConnectorContext(), b.class);
            if (bVar != null) {
                bVar.w(listener);
            }
        }

        @Override // com.tencent.mobileqq.icgame.room.displayview.definition.c
        public void b(@NotNull DefinitionController.c listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            b bVar = (b) com.tencent.mobileqq.icgame.base.room.b.d(DefinitionConnector.this.getConnectorContext(), b.class);
            if (bVar != null) {
                bVar.n(listener);
            }
        }

        @Override // com.tencent.mobileqq.icgame.room.displayview.definition.c
        public void c() {
            b bVar = (b) com.tencent.mobileqq.icgame.base.room.b.d(DefinitionConnector.this.getConnectorContext(), b.class);
            if (bVar != null) {
                bVar.x();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefinitionConnector(@NotNull f32.b connectorContext) {
        super(connectorContext);
        Intrinsics.checkNotNullParameter(connectorContext, "connectorContext");
    }

    private final d<tv0.a> E() {
        return getConnectorContext().a(tv0.a.class);
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector, com.tencent.mobileqq.icgame.framework.connector.a, com.tencent.mobileqq.icgame.framework.connector.b
    @NotNull
    public List<i32.a<?>> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new i32.a(c.class, new a()));
        return arrayList;
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void o() {
        final com.tencent.mobileqq.icgame.base.room.c cVar;
        d<tv0.a> E = E();
        if (E != null) {
            f.a(E, new g32.d(uv0.b.class, new Function1<uv0.b, Unit>() { // from class: com.tencent.mobileqq.icgame.room.displayview.definition.DefinitionConnector$onInitEventConnector$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(uv0.b bVar) {
                    invoke2(bVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull uv0.b it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    b bVar = (b) com.tencent.mobileqq.icgame.base.room.b.d(DefinitionConnector.this.getConnectorContext(), b.class);
                    if (bVar != null) {
                        bVar.x();
                    }
                }
            }));
        }
        d a16 = com.tencent.mobileqq.icgame.base.room.b.a(this, com.tencent.mobileqq.icgame.room.component.a.class);
        final com.tencent.mobileqq.icgame.base.room.c cVar2 = null;
        if (a16 == null) {
            cVar = null;
        } else {
            cVar = new com.tencent.mobileqq.icgame.base.room.c(this, a16, b.class, "");
        }
        if (cVar != null) {
            f.a(cVar.b(), new g32.d(EnterRoomSuccessEvent.class, new Function1<EnterRoomSuccessEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.displayview.definition.DefinitionConnector$onInitEventConnector$$inlined$connect$1
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
                        ((b) e16).r(it.getRoomId());
                    }
                }
            }));
        }
        d a17 = com.tencent.mobileqq.icgame.base.room.b.a(this, com.tencent.mobileqq.icgame.room.component.a.class);
        if (a17 != null) {
            cVar2 = new com.tencent.mobileqq.icgame.base.room.c(this, a17, b.class, "");
        }
        if (cVar2 != null) {
            f.a(cVar2.b(), new g32.d(ExitRoomSuccessEvent.class, new Function1<ExitRoomSuccessEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.displayview.definition.DefinitionConnector$onInitEventConnector$$inlined$connect$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ExitRoomSuccessEvent exitRoomSuccessEvent) {
                    invoke(exitRoomSuccessEvent);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull ExitRoomSuccessEvent it) {
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
                        ((b) e16).s();
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void s(@NotNull i22.e event) {
        Intrinsics.checkNotNullParameter(event, "event");
        b bVar = (b) com.tencent.mobileqq.icgame.base.room.b.d(getConnectorContext(), b.class);
        if (bVar != null) {
            bVar.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void u(@NotNull g event) {
        Intrinsics.checkNotNullParameter(event, "event");
        b bVar = (b) com.tencent.mobileqq.icgame.base.room.b.d(getConnectorContext(), b.class);
        if (bVar != null) {
            bVar.u();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void w(@NotNull h event) {
        Intrinsics.checkNotNullParameter(event, "event");
        b bVar = (b) com.tencent.mobileqq.icgame.base.room.b.d(getConnectorContext(), b.class);
        if (bVar != null) {
            bVar.v();
        }
    }
}
