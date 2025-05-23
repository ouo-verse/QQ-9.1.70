package com.tencent.mobileqq.icgame.room.displayview.horizontal;

import android.text.TextUtils;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.EnterRoomSuccessEvent;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.ExitRoomEvent;
import com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector;
import com.tencent.mobileqq.icgame.framework.page.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import i22.OrientationChangedEvent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ov0.ConfigUpdateEvent;
import rv0.ShowControllerUIEvent;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\fH\u0014J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000eH\u0014J\b\u0010\u0010\u001a\u00020\u0007H\u0014J\b\u0010\u0011\u001a\u00020\u0007H\u0014J\b\u0010\u0012\u001a\u00020\u0007H\u0014J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0013H\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001a\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/HorizontalCtrlConnector;", "Lcom/tencent/mobileqq/icgame/base/room/service/connector/RoomConnector;", "Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/o;", "I", "", "Li32/a;", "c", "", "o", "Li22/h;", "event", "w", "Li22/e;", ReportConstant.COSTREPORT_PREFIX, "Li22/g;", "u", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "r", "Li22/d;", "p", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "b", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "log", "", "Z", "inited", "Lf32/b;", "connectorContext", "<init>", "(Lf32/b;)V", "d", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class HorizontalCtrlConnector extends RoomConnector {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi log;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean inited;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/icgame/room/displayview/horizontal/HorizontalCtrlConnector$b", "Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/p;", "", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements p {
        b() {
        }

        @Override // com.tencent.mobileqq.icgame.room.displayview.horizontal.p
        public boolean a() {
            o I = HorizontalCtrlConnector.this.I();
            if (I != null) {
                return I.P();
            }
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalCtrlConnector(@NotNull f32.b connectorContext) {
        super(connectorContext);
        Intrinsics.checkNotNullParameter(connectorContext, "connectorContext");
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.log = (IAegisLogApi) api;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final o I() {
        com.tencent.mobileqq.icgame.framework.component.d a16 = getConnectorContext().a(o.class);
        if (a16 != null) {
            return (o) a16.a();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector, com.tencent.mobileqq.icgame.framework.connector.a, com.tencent.mobileqq.icgame.framework.connector.b
    @NotNull
    public List<i32.a<?>> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new i32.a(p.class, new b()));
        return arrayList;
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void o() {
        final com.tencent.mobileqq.icgame.base.room.c cVar;
        final com.tencent.mobileqq.icgame.base.room.c cVar2;
        final com.tencent.mobileqq.icgame.base.room.c cVar3;
        final com.tencent.mobileqq.icgame.base.room.c cVar4;
        final com.tencent.mobileqq.icgame.base.room.c cVar5;
        com.tencent.mobileqq.icgame.framework.component.d a16 = getConnectorContext().a(com.tencent.mobileqq.icgame.room.displayview.component.d.class);
        if (a16 != null) {
            g32.f.a(a16, new g32.d(d42.g.class, new Function1<d42.g, Unit>() { // from class: com.tencent.mobileqq.icgame.room.displayview.horizontal.HorizontalCtrlConnector$onInitEventConnector$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(d42.g gVar) {
                    invoke2(gVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull d42.g it) {
                    IAegisLogApi iAegisLogApi;
                    boolean z16;
                    boolean z17;
                    Intrinsics.checkNotNullParameter(it, "it");
                    iAegisLogApi = HorizontalCtrlConnector.this.log;
                    z16 = HorizontalCtrlConnector.this.inited;
                    iAegisLogApi.i("ICGameHorizontalCtrlConnector", "OrientationChange, inited " + z16);
                    z17 = HorizontalCtrlConnector.this.inited;
                    if (z17 || it.getHeight() > it.getWidth()) {
                        return;
                    }
                    HorizontalCtrlConnector.this.inited = true;
                    a.C7924a.a(HorizontalCtrlConnector.this.getConnectorContext().getPage(), o.class, n42.a.class, null, 4, null);
                    o I = HorizontalCtrlConnector.this.I();
                    if (I != null) {
                        I.c0(it);
                    }
                    o I2 = HorizontalCtrlConnector.this.I();
                    if (I2 != null) {
                        I2.i0();
                    }
                }
            }));
        }
        com.tencent.mobileqq.icgame.framework.component.d a17 = com.tencent.mobileqq.icgame.base.room.b.a(this, com.tencent.mobileqq.icgame.room.displayview.component.d.class);
        final com.tencent.mobileqq.icgame.base.room.c cVar6 = null;
        if (a17 == null) {
            cVar = null;
        } else {
            cVar = new com.tencent.mobileqq.icgame.base.room.c(this, a17, o.class, "");
        }
        if (cVar != null) {
            g32.f.a(cVar.b(), new g32.d(d42.g.class, new Function1<d42.g, Unit>() { // from class: com.tencent.mobileqq.icgame.room.displayview.horizontal.HorizontalCtrlConnector$onInitEventConnector$$inlined$connect$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(d42.g gVar) {
                    invoke(gVar);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull d42.g it) {
                    com.tencent.mobileqq.icgame.framework.component.e e16;
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
                        ((o) e16).c0(it);
                    }
                }
            }));
        }
        com.tencent.mobileqq.icgame.framework.component.d a18 = com.tencent.mobileqq.icgame.base.room.b.a(this, com.tencent.mobileqq.icgame.room.component.a.class);
        if (a18 == null) {
            cVar2 = null;
        } else {
            cVar2 = new com.tencent.mobileqq.icgame.base.room.c(this, a18, o.class, "");
        }
        if (cVar2 != null) {
            g32.f.a(cVar2.b(), new g32.d(EnterRoomSuccessEvent.class, new Function1<EnterRoomSuccessEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.displayview.horizontal.HorizontalCtrlConnector$onInitEventConnector$$inlined$connect$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(EnterRoomSuccessEvent enterRoomSuccessEvent) {
                    invoke(enterRoomSuccessEvent);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull EnterRoomSuccessEvent it) {
                    com.tencent.mobileqq.icgame.framework.component.e e16;
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
                        ((o) e16).V();
                    }
                }
            }));
        }
        com.tencent.mobileqq.icgame.framework.component.d a19 = com.tencent.mobileqq.icgame.base.room.b.a(this, com.tencent.mobileqq.icgame.room.component.a.class);
        if (a19 == null) {
            cVar3 = null;
        } else {
            cVar3 = new com.tencent.mobileqq.icgame.base.room.c(this, a19, o.class, "");
        }
        if (cVar3 != null) {
            g32.f.a(cVar3.b(), new g32.d(ExitRoomEvent.class, new Function1<ExitRoomEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.displayview.horizontal.HorizontalCtrlConnector$onInitEventConnector$$inlined$connect$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ExitRoomEvent exitRoomEvent) {
                    invoke(exitRoomEvent);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull ExitRoomEvent it) {
                    com.tencent.mobileqq.icgame.framework.component.e e16;
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
                        ((o) e16).W();
                    }
                }
            }));
        }
        com.tencent.mobileqq.icgame.framework.component.d a26 = com.tencent.mobileqq.icgame.base.room.b.a(this, com.tencent.mobileqq.icgame.room.component.a.class);
        if (a26 == null) {
            cVar4 = null;
        } else {
            cVar4 = new com.tencent.mobileqq.icgame.base.room.c(this, a26, o.class, "");
        }
        if (cVar4 != null) {
            g32.f.a(cVar4.b(), new g32.d(ConfigUpdateEvent.class, new Function1<ConfigUpdateEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.displayview.horizontal.HorizontalCtrlConnector$onInitEventConnector$$inlined$connect$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ConfigUpdateEvent configUpdateEvent) {
                    invoke(configUpdateEvent);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull ConfigUpdateEvent it) {
                    com.tencent.mobileqq.icgame.framework.component.e e16;
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
                        ((o) e16).U();
                    }
                }
            }));
        }
        com.tencent.mobileqq.icgame.framework.component.d a27 = com.tencent.mobileqq.icgame.base.room.b.a(this, com.tencent.mobileqq.icgame.room.displayview.component.d.class);
        if (a27 == null) {
            cVar5 = null;
        } else {
            cVar5 = new com.tencent.mobileqq.icgame.base.room.c(this, a27, o.class, "");
        }
        if (cVar5 != null) {
            g32.f.a(cVar5.b(), new g32.d(d42.a.class, new Function1<d42.a, Unit>() { // from class: com.tencent.mobileqq.icgame.room.displayview.horizontal.HorizontalCtrlConnector$onInitEventConnector$$inlined$connect$5
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(d42.a aVar) {
                    invoke(aVar);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull d42.a it) {
                    com.tencent.mobileqq.icgame.framework.component.e e16;
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
                        ((o) e16).X();
                    }
                }
            }));
        }
        com.tencent.mobileqq.icgame.framework.component.d a28 = com.tencent.mobileqq.icgame.base.room.b.a(this, tv0.a.class);
        if (a28 != null) {
            cVar6 = new com.tencent.mobileqq.icgame.base.room.c(this, a28, o.class, "");
        }
        if (cVar6 != null) {
            g32.f.a(cVar6.b(), new g32.d(ShowControllerUIEvent.class, new Function1<ShowControllerUIEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.displayview.horizontal.HorizontalCtrlConnector$onInitEventConnector$$inlined$connect$6
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ShowControllerUIEvent showControllerUIEvent) {
                    invoke(showControllerUIEvent);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull ShowControllerUIEvent it) {
                    com.tencent.mobileqq.icgame.framework.component.e e16;
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
                        ((o) e16).j0(it.getShow());
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void p(@NotNull OrientationChangedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        o I = I();
        if (I != null) {
            I.Y(event.getIsLandscape());
        }
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    protected void r() {
        o I = I();
        if (I != null) {
            I.R();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void s(@NotNull i22.e event) {
        Intrinsics.checkNotNullParameter(event, "event");
        o I = I();
        if (I != null) {
            I.Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void u(@NotNull i22.g event) {
        Intrinsics.checkNotNullParameter(event, "event");
        o I = I();
        if (I != null) {
            I.a0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void w(@NotNull i22.h event) {
        Intrinsics.checkNotNullParameter(event, "event");
        o I = I();
        if (I != null) {
            I.b0();
        }
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    protected void y() {
        o I = I();
        if (I != null) {
            I.S();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void z() {
        o I = I();
        if (I != null) {
            I.T();
        }
    }
}
