package com.tencent.mobileqq.icgame.room.top;

import android.text.TextUtils;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.EnterRoomSuccessEvent;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.ExitRoomEvent;
import com.tencent.mobileqq.icgame.base.baseroom.roomstate.RoomStateComponent;
import com.tencent.mobileqq.icgame.base.room.c;
import com.tencent.mobileqq.icgame.framework.component.d;
import com.tencent.mobileqq.icgame.framework.component.e;
import g32.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import y32.ConfigurationChangeEvent;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/top/QQLiveTopAreaConnector;", "Lcom/tencent/mobileqq/icgame/room/top/TopAreaConnector;", "", "Li32/a;", "c", "", "a", "Lf32/b;", "cc", "<init>", "(Lf32/b;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class QQLiveTopAreaConnector extends TopAreaConnector {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/icgame/room/top/QQLiveTopAreaConnector$a", "Lcom/tencent/mobileqq/icgame/room/top/a;", "", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements com.tencent.mobileqq.icgame.room.top.a {
        a() {
        }

        @Override // com.tencent.mobileqq.icgame.room.top.a
        public boolean a() {
            com.tencent.mobileqq.icgame.room.component.a aVar = (com.tencent.mobileqq.icgame.room.component.a) com.tencent.mobileqq.icgame.base.room.b.c(QQLiveTopAreaConnector.this, com.tencent.mobileqq.icgame.room.component.a.class);
            if (aVar != null) {
                return aVar.handleBackPressed();
            }
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveTopAreaConnector(@NotNull f32.b cc5) {
        super(cc5);
        Intrinsics.checkNotNullParameter(cc5, "cc");
    }

    @Override // com.tencent.mobileqq.icgame.room.top.TopAreaConnector, com.tencent.mobileqq.icgame.framework.connector.a, com.tencent.mobileqq.icgame.framework.connector.b
    public void a() {
        final c cVar;
        super.a();
        d a16 = com.tencent.mobileqq.icgame.base.room.b.a(this, com.tencent.mobileqq.icgame.room.component.a.class);
        final c cVar2 = null;
        if (a16 == null) {
            cVar = null;
        } else {
            cVar = new c(this, a16, TopAreaComponent.class, "");
        }
        if (cVar == null) {
            cVar = null;
        } else {
            f.a(cVar.b(), new g32.d(EnterRoomSuccessEvent.class, new Function1<EnterRoomSuccessEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.top.QQLiveTopAreaConnector$initEventConnector$$inlined$connect$1
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
                    if (TextUtils.isEmpty(c.this.getToKey())) {
                        com.tencent.mobileqq.icgame.framework.connector.b conn = c.this.getConn();
                        Class c16 = c.this.c();
                        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.ISingleComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.c(conn, c16);
                    } else {
                        com.tencent.mobileqq.icgame.framework.connector.b conn2 = c.this.getConn();
                        Class c17 = c.this.c();
                        Intrinsics.checkNotNull(c17, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.IMultiComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.e(conn2, c17, c.this.getToKey());
                    }
                    if (e16 != null) {
                        ((TopAreaComponent) e16).x();
                    }
                }
            }));
        }
        if (cVar == null) {
            cVar = null;
        } else {
            f.a(cVar.b(), new g32.d(ExitRoomEvent.class, new Function1<ExitRoomEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.top.QQLiveTopAreaConnector$initEventConnector$$inlined$connect$2
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
                    if (TextUtils.isEmpty(c.this.getToKey())) {
                        com.tencent.mobileqq.icgame.framework.connector.b conn = c.this.getConn();
                        Class c16 = c.this.c();
                        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.ISingleComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.c(conn, c16);
                    } else {
                        com.tencent.mobileqq.icgame.framework.connector.b conn2 = c.this.getConn();
                        Class c17 = c.this.c();
                        Intrinsics.checkNotNull(c17, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.IMultiComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.e(conn2, c17, c.this.getToKey());
                    }
                    if (e16 != null) {
                        ((TopAreaComponent) e16).y();
                    }
                }
            }));
        }
        if (cVar == null) {
            cVar = null;
        } else {
            f.a(cVar.b(), new g32.d(ov0.b.class, new Function1<ov0.b, Unit>() { // from class: com.tencent.mobileqq.icgame.room.top.QQLiveTopAreaConnector$initEventConnector$$inlined$connect$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ov0.b bVar) {
                    invoke(bVar);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull ov0.b it) {
                    e e16;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (TextUtils.isEmpty(c.this.getToKey())) {
                        com.tencent.mobileqq.icgame.framework.connector.b conn = c.this.getConn();
                        Class c16 = c.this.c();
                        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.ISingleComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.c(conn, c16);
                    } else {
                        com.tencent.mobileqq.icgame.framework.connector.b conn2 = c.this.getConn();
                        Class c17 = c.this.c();
                        Intrinsics.checkNotNull(c17, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.IMultiComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.e(conn2, c17, c.this.getToKey());
                    }
                    if (e16 != null) {
                        ((TopAreaComponent) e16).y();
                    }
                }
            }));
        }
        if (cVar != null) {
            f.a(cVar.b(), new g32.d(ConfigurationChangeEvent.class, new Function1<ConfigurationChangeEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.top.QQLiveTopAreaConnector$initEventConnector$$inlined$connect$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ConfigurationChangeEvent configurationChangeEvent) {
                    invoke(configurationChangeEvent);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull ConfigurationChangeEvent it) {
                    e e16;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (TextUtils.isEmpty(c.this.getToKey())) {
                        com.tencent.mobileqq.icgame.framework.connector.b conn = c.this.getConn();
                        Class c16 = c.this.c();
                        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.ISingleComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.c(conn, c16);
                    } else {
                        com.tencent.mobileqq.icgame.framework.connector.b conn2 = c.this.getConn();
                        Class c17 = c.this.c();
                        Intrinsics.checkNotNull(c17, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.IMultiComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.e(conn2, c17, c.this.getToKey());
                    }
                    if (e16 != null) {
                        ((TopAreaComponent) e16).G(it.getNewConfig().orientation == 2);
                    }
                }
            }));
        }
        d a17 = com.tencent.mobileqq.icgame.base.room.b.a(this, RoomStateComponent.class);
        if (a17 != null) {
            cVar2 = new c(this, a17, TopAreaComponent.class, "");
        }
        if (cVar2 != null) {
            f.a(cVar2.b(), new g32.d(com.tencent.mobileqq.icgame.base.baseroom.roomstate.a.class, new Function1<com.tencent.mobileqq.icgame.base.baseroom.roomstate.a, Unit>() { // from class: com.tencent.mobileqq.icgame.room.top.QQLiveTopAreaConnector$initEventConnector$$inlined$connect$5
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.icgame.base.baseroom.roomstate.a aVar) {
                    invoke(aVar);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull com.tencent.mobileqq.icgame.base.baseroom.roomstate.a it) {
                    e e16;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (TextUtils.isEmpty(c.this.getToKey())) {
                        com.tencent.mobileqq.icgame.framework.connector.b conn = c.this.getConn();
                        Class c16 = c.this.c();
                        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.ISingleComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.c(conn, c16);
                    } else {
                        com.tencent.mobileqq.icgame.framework.connector.b conn2 = c.this.getConn();
                        Class c17 = c.this.c();
                        Intrinsics.checkNotNull(c17, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.IMultiComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.e(conn2, c17, c.this.getToKey());
                    }
                    if (e16 != null) {
                        ((TopAreaComponent) e16).y();
                    }
                }
            }));
        }
    }

    @Override // com.tencent.mobileqq.icgame.room.top.TopAreaConnector, com.tencent.mobileqq.icgame.framework.connector.a, com.tencent.mobileqq.icgame.framework.connector.b
    @NotNull
    public List<i32.a<?>> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new i32.a(com.tencent.mobileqq.icgame.room.top.a.class, new a()));
        return arrayList;
    }
}
