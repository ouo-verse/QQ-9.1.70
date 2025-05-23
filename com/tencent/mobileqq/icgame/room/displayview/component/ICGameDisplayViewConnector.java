package com.tencent.mobileqq.icgame.room.displayview.component;

import a42.DispatchTouchEvent;
import android.text.TextUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.game.liveroom.impl.room.audience.component.audiofocus.AudioFocusComponent;
import com.tencent.icgame.game.liveroom.impl.room.audience.component.audiofocus.FocusChangeEvent;
import com.tencent.icgame.game.liveroom.impl.room.audience.preload.ExitRoomAndPreloadSucEvent;
import com.tencent.icgame.game.liveroom.impl.room.audience.preload.PreloadRoomComponent;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.EnterRoomSuccessEvent;
import com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector;
import com.tencent.mobileqq.icgame.framework.component.e;
import com.tencent.mobileqq.icgame.room.top.TopAreaComponent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import g32.f;
import i22.OrientationChangedEvent;
import i22.g;
import i22.h;
import i22.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\fH\u0014J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000eH\u0014J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0010H\u0014J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0012H\u0014J\b\u0010\u0014\u001a\u00020\u0007H\u0014J\b\u0010\u0015\u001a\u00020\u0007H\u0014J\b\u0010\u0016\u001a\u00020\u0007H\u0014J\b\u0010\u0017\u001a\u00020\u0007H\u0014J\b\u0010\u0018\u001a\u00020\u0007H\u0014J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0019H\u0014\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/displayview/component/ICGameDisplayViewConnector;", "Lcom/tencent/mobileqq/icgame/base/room/service/connector/RoomConnector;", "Lcom/tencent/mobileqq/icgame/room/displayview/component/d;", "E", "", "Li32/a;", "c", "", "o", "Li22/k;", "event", "B", "Li22/h;", "w", "Li22/e;", ReportConstant.COSTREPORT_PREFIX, "Li22/g;", "u", "Li22/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "l", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, "Li22/d;", "p", "Lf32/b;", "connectorContext", "<init>", "(Lf32/b;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ICGameDisplayViewConnector extends RoomConnector {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ICGameDisplayViewConnector(@NotNull f32.b connectorContext) {
        super(connectorContext);
        Intrinsics.checkNotNullParameter(connectorContext, "connectorContext");
    }

    private final d E() {
        com.tencent.mobileqq.icgame.framework.component.d a16 = getConnectorContext().a(d.class);
        if (a16 != null) {
            return (d) a16.a();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void B(@NotNull k event) {
        Intrinsics.checkNotNullParameter(event, "event");
        d E = E();
        if (E != null) {
            E.X();
        }
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector, com.tencent.mobileqq.icgame.framework.connector.a, com.tencent.mobileqq.icgame.framework.connector.b
    @NotNull
    public List<i32.a<?>> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new i32.a(a.class, new b(getConnectorContext())));
        return arrayList;
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    protected void j() {
        d E = E();
        if (E != null) {
            E.V();
        }
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    protected void l() {
        d E = E();
        if (E != null) {
            E.W();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void m(@NotNull i22.b event) {
        Intrinsics.checkNotNullParameter(event, "event");
        d E = E();
        if (E != null) {
            E.N(event);
        }
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void o() {
        final com.tencent.mobileqq.icgame.base.room.c cVar;
        final com.tencent.mobileqq.icgame.base.room.c cVar2;
        final com.tencent.mobileqq.icgame.base.room.c cVar3;
        final com.tencent.mobileqq.icgame.base.room.c cVar4;
        com.tencent.mobileqq.icgame.framework.component.d a16 = com.tencent.mobileqq.icgame.base.room.b.a(this, com.tencent.mobileqq.icgame.room.component.a.class);
        final com.tencent.mobileqq.icgame.base.room.c cVar5 = null;
        if (a16 == null) {
            cVar = null;
        } else {
            cVar = new com.tencent.mobileqq.icgame.base.room.c(this, a16, d.class, "");
        }
        if (cVar != null) {
            f.a(cVar.b(), new g32.d(EnterRoomSuccessEvent.class, new Function1<EnterRoomSuccessEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.displayview.component.ICGameDisplayViewConnector$onInitEventConnector$$inlined$connect$1
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
                        ((d) e16).O();
                    }
                }
            }));
        }
        com.tencent.mobileqq.icgame.framework.component.d a17 = com.tencent.mobileqq.icgame.base.room.b.a(this, PreloadRoomComponent.class);
        if (a17 == null) {
            cVar2 = null;
        } else {
            cVar2 = new com.tencent.mobileqq.icgame.base.room.c(this, a17, d.class, "");
        }
        if (cVar2 != null) {
            f.a(cVar2.b(), new g32.d(ExitRoomAndPreloadSucEvent.class, new Function1<ExitRoomAndPreloadSucEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.displayview.component.ICGameDisplayViewConnector$onInitEventConnector$$inlined$connect$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ExitRoomAndPreloadSucEvent exitRoomAndPreloadSucEvent) {
                    invoke(exitRoomAndPreloadSucEvent);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull ExitRoomAndPreloadSucEvent it) {
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
                        ((d) e16).P(it);
                    }
                }
            }));
        }
        com.tencent.mobileqq.icgame.framework.component.d a18 = com.tencent.mobileqq.icgame.base.room.b.a(this, AudioFocusComponent.class);
        if (a18 == null) {
            cVar3 = null;
        } else {
            cVar3 = new com.tencent.mobileqq.icgame.base.room.c(this, a18, d.class, "");
        }
        if (cVar3 != null) {
            f.a(cVar3.b(), new g32.d(FocusChangeEvent.class, new Function1<FocusChangeEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.displayview.component.ICGameDisplayViewConnector$onInitEventConnector$$inlined$connect$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FocusChangeEvent focusChangeEvent) {
                    invoke(focusChangeEvent);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull FocusChangeEvent it) {
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
                        ((d) e16).Q(it.getHasFocus());
                    }
                }
            }));
        }
        com.tencent.mobileqq.icgame.framework.component.d a19 = com.tencent.mobileqq.icgame.base.room.b.a(this, TopAreaComponent.class);
        if (a19 == null) {
            cVar4 = null;
        } else {
            cVar4 = new com.tencent.mobileqq.icgame.base.room.c(this, a19, d.class, "");
        }
        if (cVar4 != null) {
            f.a(cVar4.b(), new g32.d(com.tencent.mobileqq.icgame.room.top.b.class, new Function1<com.tencent.mobileqq.icgame.room.top.b, Unit>() { // from class: com.tencent.mobileqq.icgame.room.displayview.component.ICGameDisplayViewConnector$onInitEventConnector$$inlined$connect$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.icgame.room.top.b bVar) {
                    invoke(bVar);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull com.tencent.mobileqq.icgame.room.top.b it) {
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
                        ((d) e16).Y();
                    }
                }
            }));
        }
        com.tencent.mobileqq.icgame.framework.component.d a26 = com.tencent.mobileqq.icgame.base.room.b.a(this, a42.c.class);
        if (a26 != null) {
            cVar5 = new com.tencent.mobileqq.icgame.base.room.c(this, a26, d.class, "");
        }
        if (cVar5 != null) {
            f.a(cVar5.b(), new g32.d(DispatchTouchEvent.class, new Function1<DispatchTouchEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.displayview.component.ICGameDisplayViewConnector$onInitEventConnector$$inlined$connect$5
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DispatchTouchEvent dispatchTouchEvent) {
                    invoke(dispatchTouchEvent);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull DispatchTouchEvent it) {
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
                        ((d) e16).E(it.getMotionEvent());
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void p(@NotNull OrientationChangedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        d E = E();
        if (E != null) {
            E.R(event);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void s(@NotNull i22.e event) {
        Intrinsics.checkNotNullParameter(event, "event");
        d E = E();
        if (E != null) {
            E.S(event);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void u(@NotNull g event) {
        Intrinsics.checkNotNullParameter(event, "event");
        d E = E();
        if (E != null) {
            E.T(event);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void w(@NotNull h event) {
        Intrinsics.checkNotNullParameter(event, "event");
        d E = E();
        if (E != null) {
            E.U(event);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void x() {
        d E = E();
        if (E != null) {
            E.K();
        }
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    protected void y() {
        d E = E();
        if (E != null) {
            E.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void z() {
        d E = E();
        if (E != null) {
            E.M();
        }
    }
}
