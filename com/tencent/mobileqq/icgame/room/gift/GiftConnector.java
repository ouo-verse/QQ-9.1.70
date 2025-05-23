package com.tencent.mobileqq.icgame.room.gift;

import android.text.TextUtils;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.EnterRoomSuccessEvent;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.ExitRoomEvent;
import com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector;
import com.tencent.mobileqq.icgame.framework.component.d;
import com.tencent.mobileqq.icgame.framework.component.e;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import g32.f;
import i22.g;
import i22.h;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import y32.ConfigurationChangeEvent;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0007H\u0014J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\tH\u0014J\b\u0010\u000b\u001a\u00020\u0002H\u0014\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/gift/GiftConnector;", "Lcom/tencent/mobileqq/icgame/base/room/service/connector/RoomConnector;", "", "o", "Li22/h;", "event", "w", "Li22/e;", ReportConstant.COSTREPORT_PREFIX, "Li22/g;", "u", "r", "Lf32/b;", "connectorContext", "<init>", "(Lf32/b;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class GiftConnector extends RoomConnector {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftConnector(@NotNull f32.b connectorContext) {
        super(connectorContext);
        Intrinsics.checkNotNullParameter(connectorContext, "connectorContext");
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void o() {
        final com.tencent.mobileqq.icgame.base.room.c cVar;
        final com.tencent.mobileqq.icgame.base.room.c cVar2;
        final com.tencent.mobileqq.icgame.base.room.c cVar3;
        d a16 = com.tencent.mobileqq.icgame.base.room.b.a(this, com.tencent.mobileqq.icgame.room.component.a.class);
        final com.tencent.mobileqq.icgame.base.room.c cVar4 = null;
        if (a16 == null) {
            cVar = null;
        } else {
            cVar = new com.tencent.mobileqq.icgame.base.room.c(this, a16, GiftComponent.class, "");
        }
        if (cVar != null) {
            f.a(cVar.b(), new g32.d(EnterRoomSuccessEvent.class, new Function1<EnterRoomSuccessEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.gift.GiftConnector$onInitEventConnector$$inlined$connect$1
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
                        ((GiftComponent) e16).B();
                    }
                }
            }));
        }
        d a17 = com.tencent.mobileqq.icgame.base.room.b.a(this, com.tencent.mobileqq.icgame.room.component.a.class);
        if (a17 == null) {
            cVar2 = null;
        } else {
            cVar2 = new com.tencent.mobileqq.icgame.base.room.c(this, a17, GiftComponent.class, "");
        }
        if (cVar2 != null) {
            f.a(cVar2.b(), new g32.d(ExitRoomEvent.class, new Function1<ExitRoomEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.gift.GiftConnector$onInitEventConnector$$inlined$connect$2
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
                        ((GiftComponent) e16).C();
                    }
                }
            }));
        }
        d a18 = com.tencent.mobileqq.icgame.base.room.b.a(this, com.tencent.mobileqq.icgame.room.component.a.class);
        if (a18 == null) {
            cVar3 = null;
        } else {
            cVar3 = new com.tencent.mobileqq.icgame.base.room.c(this, a18, GiftComponent.class, "");
        }
        if (cVar3 != null) {
            f.a(cVar3.b(), new g32.d(ConfigurationChangeEvent.class, new Function1<ConfigurationChangeEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.gift.GiftConnector$onInitEventConnector$$inlined$connect$3
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
                        ((GiftComponent) e16).A(it.getNewConfig());
                    }
                }
            }));
        }
        d a19 = com.tencent.mobileqq.icgame.base.room.b.a(this, com.tencent.mobileqq.icgame.room.input.component.b.class);
        if (a19 != null) {
            cVar4 = new com.tencent.mobileqq.icgame.base.room.c(this, a19, GiftComponent.class, "");
        }
        if (cVar4 != null) {
            f.a(cVar4.b(), new g32.d(com.tencent.mobileqq.icgame.room.input.component.c.class, new Function1<com.tencent.mobileqq.icgame.room.input.component.c, Unit>() { // from class: com.tencent.mobileqq.icgame.room.gift.GiftConnector$onInitEventConnector$$inlined$connect$4
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
                        ((GiftComponent) e16).D(it.getState());
                    }
                }
            }));
        }
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    protected void r() {
        GiftComponent giftComponent = (GiftComponent) com.tencent.mobileqq.icgame.base.room.b.c(this, GiftComponent.class);
        if (giftComponent != null) {
            giftComponent.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void s(@NotNull i22.e event) {
        Intrinsics.checkNotNullParameter(event, "event");
        GiftComponent giftComponent = (GiftComponent) com.tencent.mobileqq.icgame.base.room.b.c(this, GiftComponent.class);
        if (giftComponent != null) {
            giftComponent.E();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void u(@NotNull g event) {
        Intrinsics.checkNotNullParameter(event, "event");
        GiftComponent giftComponent = (GiftComponent) com.tencent.mobileqq.icgame.base.room.b.c(this, GiftComponent.class);
        if (giftComponent != null) {
            giftComponent.F(event);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void w(@NotNull h event) {
        Intrinsics.checkNotNullParameter(event, "event");
        GiftComponent giftComponent = (GiftComponent) com.tencent.mobileqq.icgame.base.room.b.c(this, GiftComponent.class);
        if (giftComponent != null) {
            giftComponent.G(event);
        }
    }
}
