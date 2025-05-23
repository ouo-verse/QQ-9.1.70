package com.tencent.mobileqq.icgame.room.message.component;

import android.text.TextUtils;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.EnterRoomSuccessEvent;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.ExitRoomEvent;
import com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector;
import com.tencent.mobileqq.icgame.framework.component.e;
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
import org.jetbrains.annotations.Nullable;
import y32.ConfigurationChangeEvent;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\nH\u0014\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/message/component/LiveMessageLayoutConnector;", "Lcom/tencent/mobileqq/icgame/base/room/service/connector/RoomConnector;", "", "Li32/a;", "c", "", "o", "Li22/h;", "event", "w", "Li22/g;", "u", "Lf32/b;", "connectorContext", "<init>", "(Lf32/b;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LiveMessageLayoutConnector extends RoomConnector {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/icgame/room/message/component/LiveMessageLayoutConnector$a", "Lcom/tencent/mobileqq/icgame/room/message/component/a;", "Lz42/b;", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements com.tencent.mobileqq.icgame.room.message.component.a {
        a() {
        }

        @Override // com.tencent.mobileqq.icgame.room.message.component.a
        @Nullable
        public z42.b a() {
            LiveMessageLayoutComponent liveMessageLayoutComponent = (LiveMessageLayoutComponent) com.tencent.mobileqq.icgame.base.room.b.c(LiveMessageLayoutConnector.this, LiveMessageLayoutComponent.class);
            if (liveMessageLayoutComponent != null) {
                return liveMessageLayoutComponent.F();
            }
            return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveMessageLayoutConnector(@NotNull f32.b connectorContext) {
        super(connectorContext);
        Intrinsics.checkNotNullParameter(connectorContext, "connectorContext");
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector, com.tencent.mobileqq.icgame.framework.connector.a, com.tencent.mobileqq.icgame.framework.connector.b
    @NotNull
    public List<i32.a<?>> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new i32.a(com.tencent.mobileqq.icgame.room.message.component.a.class, new a()));
        return arrayList;
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void o() {
        final com.tencent.mobileqq.icgame.base.room.c cVar;
        final com.tencent.mobileqq.icgame.base.room.c cVar2;
        final com.tencent.mobileqq.icgame.base.room.c cVar3;
        super.o();
        com.tencent.mobileqq.icgame.framework.component.d a16 = com.tencent.mobileqq.icgame.base.room.b.a(this, com.tencent.mobileqq.icgame.room.component.a.class);
        final com.tencent.mobileqq.icgame.base.room.c cVar4 = null;
        if (a16 == null) {
            cVar = null;
        } else {
            cVar = new com.tencent.mobileqq.icgame.base.room.c(this, a16, LiveMessageLayoutComponent.class, "");
        }
        if (cVar != null) {
            f.a(cVar.b(), new g32.d(EnterRoomSuccessEvent.class, new Function1<EnterRoomSuccessEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.message.component.LiveMessageLayoutConnector$onInitEventConnector$$inlined$connect$1
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
                        ((LiveMessageLayoutComponent) e16).B();
                    }
                }
            }));
        }
        com.tencent.mobileqq.icgame.framework.component.d a17 = com.tencent.mobileqq.icgame.base.room.b.a(this, com.tencent.mobileqq.icgame.room.component.a.class);
        if (a17 == null) {
            cVar2 = null;
        } else {
            cVar2 = new com.tencent.mobileqq.icgame.base.room.c(this, a17, LiveMessageLayoutComponent.class, "");
        }
        if (cVar2 != null) {
            f.a(cVar2.b(), new g32.d(ExitRoomEvent.class, new Function1<ExitRoomEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.message.component.LiveMessageLayoutConnector$onInitEventConnector$$inlined$connect$2
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
                        ((LiveMessageLayoutComponent) e16).C();
                    }
                }
            }));
        }
        com.tencent.mobileqq.icgame.framework.component.d a18 = com.tencent.mobileqq.icgame.base.room.b.a(this, com.tencent.mobileqq.icgame.room.component.a.class);
        if (a18 == null) {
            cVar3 = null;
        } else {
            cVar3 = new com.tencent.mobileqq.icgame.base.room.c(this, a18, LiveMessageLayoutComponent.class, "");
        }
        if (cVar3 != null) {
            f.a(cVar3.b(), new g32.d(ConfigurationChangeEvent.class, new Function1<ConfigurationChangeEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.message.component.LiveMessageLayoutConnector$onInitEventConnector$$inlined$connect$3
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
                        ((LiveMessageLayoutComponent) e16).G(it.getNewConfig());
                    }
                }
            }));
        }
        com.tencent.mobileqq.icgame.framework.component.d a19 = com.tencent.mobileqq.icgame.base.room.b.a(this, com.tencent.mobileqq.icgame.room.input.component.b.class);
        if (a19 != null) {
            cVar4 = new com.tencent.mobileqq.icgame.base.room.c(this, a19, LiveMessageLayoutComponent.class, "");
        }
        if (cVar4 != null) {
            f.a(cVar4.b(), new g32.d(com.tencent.mobileqq.icgame.room.input.component.c.class, new Function1<com.tencent.mobileqq.icgame.room.input.component.c, Unit>() { // from class: com.tencent.mobileqq.icgame.room.message.component.LiveMessageLayoutConnector$onInitEventConnector$$inlined$connect$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.icgame.room.input.component.c cVar5) {
                    invoke(cVar5);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull com.tencent.mobileqq.icgame.room.input.component.c it) {
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
                        ((LiveMessageLayoutComponent) e16).H(it);
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void u(@NotNull g event) {
        Intrinsics.checkNotNullParameter(event, "event");
        LiveMessageLayoutComponent liveMessageLayoutComponent = (LiveMessageLayoutComponent) com.tencent.mobileqq.icgame.base.room.b.c(this, LiveMessageLayoutComponent.class);
        if (liveMessageLayoutComponent != null) {
            liveMessageLayoutComponent.I(event.getIsPageClose());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void w(@NotNull h event) {
        Intrinsics.checkNotNullParameter(event, "event");
        LiveMessageLayoutComponent liveMessageLayoutComponent = (LiveMessageLayoutComponent) com.tencent.mobileqq.icgame.base.room.b.c(this, LiveMessageLayoutComponent.class);
        if (liveMessageLayoutComponent != null) {
            liveMessageLayoutComponent.J();
        }
    }
}
