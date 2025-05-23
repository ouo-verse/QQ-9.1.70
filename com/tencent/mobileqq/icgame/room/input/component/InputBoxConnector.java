package com.tencent.mobileqq.icgame.room.input.component;

import android.text.TextUtils;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.EnterRoomSuccessEvent;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.ExitRoomEvent;
import com.tencent.mobileqq.icgame.base.room.d;
import com.tencent.mobileqq.icgame.framework.component.e;
import com.tencent.mobileqq.icgame.framework.component.h;
import com.tencent.mobileqq.icgame.room.touchdelegate.TouchDelegateComponent;
import g32.f;
import g32.g;
import i22.OrientationChangedEvent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/input/component/InputBoxConnector;", "Lcom/tencent/mobileqq/icgame/framework/connector/a;", "", "Li32/a;", "c", "", "a", "Lf32/b;", "connectorContext", "<init>", "(Lf32/b;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class InputBoxConnector extends com.tencent.mobileqq.icgame.framework.connector.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/icgame/room/input/component/InputBoxConnector$a", "Lcom/tencent/mobileqq/icgame/room/input/component/a;", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements com.tencent.mobileqq.icgame.room.input.component.a {
        a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputBoxConnector(@NotNull f32.b connectorContext) {
        super(connectorContext);
        Intrinsics.checkNotNullParameter(connectorContext, "connectorContext");
    }

    @Override // com.tencent.mobileqq.icgame.framework.connector.a, com.tencent.mobileqq.icgame.framework.connector.b
    public void a() {
        final d dVar;
        final com.tencent.mobileqq.icgame.base.room.c cVar;
        final com.tencent.mobileqq.icgame.base.room.c cVar2;
        final com.tencent.mobileqq.icgame.base.room.c cVar3;
        h hVar;
        g c16 = getConnectorContext().c();
        com.tencent.mobileqq.icgame.framework.component.d a16 = com.tencent.mobileqq.icgame.base.room.b.a(this, b.class);
        final com.tencent.mobileqq.icgame.base.room.c cVar4 = null;
        if (a16 != null && (hVar = (h) a16.a()) != null) {
            dVar = new d(c16, hVar);
        } else {
            dVar = null;
        }
        if (dVar != null) {
            f.a(dVar.getRegister(), new g32.d(i22.h.class, new Function1<i22.h, Unit>() { // from class: com.tencent.mobileqq.icgame.room.input.component.InputBoxConnector$initEventConnector$$inlined$pagePreload$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(i22.h hVar2) {
                    invoke(hVar2);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull i22.h it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ((b) d.this.b()).z();
                }
            }));
        } else {
            dVar = null;
        }
        if (dVar != null) {
            f.a(dVar.getRegister(), new g32.d(i22.g.class, new Function1<i22.g, Unit>() { // from class: com.tencent.mobileqq.icgame.room.input.component.InputBoxConnector$initEventConnector$$inlined$pageOut$1
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
                    ((b) d.this.b()).u();
                }
            }));
        } else {
            dVar = null;
        }
        if (dVar != null) {
            f.a(dVar.getRegister(), new g32.d(OrientationChangedEvent.class, new Function1<OrientationChangedEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.input.component.InputBoxConnector$initEventConnector$$inlined$orientationChange$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(OrientationChangedEvent orientationChangedEvent) {
                    invoke(orientationChangedEvent);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull OrientationChangedEvent it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ((b) d.this.b()).y(it.getIsLandscape());
                }
            }));
        }
        com.tencent.mobileqq.icgame.framework.component.d a17 = com.tencent.mobileqq.icgame.base.room.b.a(this, com.tencent.mobileqq.icgame.room.component.a.class);
        if (a17 == null) {
            cVar = null;
        } else {
            cVar = new com.tencent.mobileqq.icgame.base.room.c(this, a17, b.class, "");
        }
        if (cVar != null) {
            f.a(cVar.b(), new g32.d(EnterRoomSuccessEvent.class, new Function1<EnterRoomSuccessEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.input.component.InputBoxConnector$initEventConnector$$inlined$connect$1
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
                        Class c17 = com.tencent.mobileqq.icgame.base.room.c.this.c();
                        Intrinsics.checkNotNull(c17, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.ISingleComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.c(conn, c17);
                    } else {
                        com.tencent.mobileqq.icgame.framework.connector.b conn2 = com.tencent.mobileqq.icgame.base.room.c.this.getConn();
                        Class c18 = com.tencent.mobileqq.icgame.base.room.c.this.c();
                        Intrinsics.checkNotNull(c18, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.IMultiComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.e(conn2, c18, com.tencent.mobileqq.icgame.base.room.c.this.getToKey());
                    }
                    if (e16 != null) {
                        ((b) e16).t();
                    }
                }
            }));
        }
        com.tencent.mobileqq.icgame.framework.component.d a18 = com.tencent.mobileqq.icgame.base.room.b.a(this, com.tencent.mobileqq.icgame.room.component.a.class);
        if (a18 == null) {
            cVar2 = null;
        } else {
            cVar2 = new com.tencent.mobileqq.icgame.base.room.c(this, a18, b.class, "");
        }
        if (cVar2 != null) {
            f.a(cVar2.b(), new g32.d(ExitRoomEvent.class, new Function1<ExitRoomEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.input.component.InputBoxConnector$initEventConnector$$inlined$connect$2
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
                        Class c17 = com.tencent.mobileqq.icgame.base.room.c.this.c();
                        Intrinsics.checkNotNull(c17, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.ISingleComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.c(conn, c17);
                    } else {
                        com.tencent.mobileqq.icgame.framework.connector.b conn2 = com.tencent.mobileqq.icgame.base.room.c.this.getConn();
                        Class c18 = com.tencent.mobileqq.icgame.base.room.c.this.c();
                        Intrinsics.checkNotNull(c18, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.IMultiComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.e(conn2, c18, com.tencent.mobileqq.icgame.base.room.c.this.getToKey());
                    }
                    if (e16 != null) {
                        ((b) e16).u();
                    }
                }
            }));
        }
        com.tencent.mobileqq.icgame.framework.component.d a19 = com.tencent.mobileqq.icgame.base.room.b.a(this, tv0.a.class);
        if (a19 == null) {
            cVar3 = null;
        } else {
            cVar3 = new com.tencent.mobileqq.icgame.base.room.c(this, a19, b.class, "");
        }
        if (cVar3 != null) {
            f.a(cVar3.b(), new g32.d(uv0.d.class, new Function1<uv0.d, Unit>() { // from class: com.tencent.mobileqq.icgame.room.input.component.InputBoxConnector$initEventConnector$$inlined$connect$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(uv0.d dVar2) {
                    invoke(dVar2);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull uv0.d it) {
                    e e16;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (TextUtils.isEmpty(com.tencent.mobileqq.icgame.base.room.c.this.getToKey())) {
                        com.tencent.mobileqq.icgame.framework.connector.b conn = com.tencent.mobileqq.icgame.base.room.c.this.getConn();
                        Class c17 = com.tencent.mobileqq.icgame.base.room.c.this.c();
                        Intrinsics.checkNotNull(c17, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.ISingleComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.c(conn, c17);
                    } else {
                        com.tencent.mobileqq.icgame.framework.connector.b conn2 = com.tencent.mobileqq.icgame.base.room.c.this.getConn();
                        Class c18 = com.tencent.mobileqq.icgame.base.room.c.this.c();
                        Intrinsics.checkNotNull(c18, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.IMultiComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.e(conn2, c18, com.tencent.mobileqq.icgame.base.room.c.this.getToKey());
                    }
                    if (e16 != null) {
                        ((b) e16).x();
                    }
                }
            }));
        }
        com.tencent.mobileqq.icgame.framework.component.d a26 = com.tencent.mobileqq.icgame.base.room.b.a(this, TouchDelegateComponent.class);
        if (a26 != null) {
            cVar4 = new com.tencent.mobileqq.icgame.base.room.c(this, a26, b.class, "");
        }
        if (cVar4 != null) {
            f.a(cVar4.b(), new g32.d(com.tencent.mobileqq.icgame.room.touchdelegate.b.class, new Function1<com.tencent.mobileqq.icgame.room.touchdelegate.b, Unit>() { // from class: com.tencent.mobileqq.icgame.room.input.component.InputBoxConnector$initEventConnector$$inlined$connect$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.icgame.room.touchdelegate.b bVar) {
                    invoke(bVar);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull com.tencent.mobileqq.icgame.room.touchdelegate.b it) {
                    e e16;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (TextUtils.isEmpty(com.tencent.mobileqq.icgame.base.room.c.this.getToKey())) {
                        com.tencent.mobileqq.icgame.framework.connector.b conn = com.tencent.mobileqq.icgame.base.room.c.this.getConn();
                        Class c17 = com.tencent.mobileqq.icgame.base.room.c.this.c();
                        Intrinsics.checkNotNull(c17, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.ISingleComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.c(conn, c17);
                    } else {
                        com.tencent.mobileqq.icgame.framework.connector.b conn2 = com.tencent.mobileqq.icgame.base.room.c.this.getConn();
                        Class c18 = com.tencent.mobileqq.icgame.base.room.c.this.c();
                        Intrinsics.checkNotNull(c18, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.IMultiComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.e(conn2, c18, com.tencent.mobileqq.icgame.base.room.c.this.getToKey());
                    }
                    if (e16 != null) {
                        ((b) e16).w();
                    }
                }
            }));
        }
    }

    @Override // com.tencent.mobileqq.icgame.framework.connector.a, com.tencent.mobileqq.icgame.framework.connector.b
    @NotNull
    public List<i32.a<?>> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new i32.a(com.tencent.mobileqq.icgame.room.input.component.a.class, new a()));
        return arrayList;
    }
}
