package com.tencent.mobileqq.icgame.room.end;

import android.text.TextUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import i22.OrientationChangedEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0002H\u0014J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\tH\u0014J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u000bH\u0014\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/end/LiveEndConnector;", "Lcom/tencent/mobileqq/icgame/base/room/service/connector/RoomConnector;", "", "o", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Li22/d;", "event", "p", "Li22/e;", ReportConstant.COSTREPORT_PREFIX, "Li22/g;", "u", "Lf32/b;", "connectorContext", "<init>", "(Lf32/b;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LiveEndConnector extends RoomConnector {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveEndConnector(@NotNull f32.b connectorContext) {
        super(connectorContext);
        Intrinsics.checkNotNullParameter(connectorContext, "connectorContext");
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void o() {
        final com.tencent.mobileqq.icgame.base.room.c cVar;
        super.o();
        com.tencent.mobileqq.icgame.framework.component.d a16 = com.tencent.mobileqq.icgame.base.room.b.a(this, com.tencent.mobileqq.icgame.room.component.a.class);
        if (a16 == null) {
            cVar = null;
        } else {
            cVar = new com.tencent.mobileqq.icgame.base.room.c(this, a16, g.class, "");
        }
        if (cVar != null) {
            g32.f.a(cVar.b(), new g32.d(EndLiveEvent.class, new Function1<EndLiveEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.end.LiveEndConnector$onInitEventConnector$$inlined$connect$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(EndLiveEvent endLiveEvent) {
                    invoke(endLiveEvent);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull EndLiveEvent it) {
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
                        ((g) e16).K(it.getEndInfo());
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void p(@NotNull OrientationChangedEvent event) {
        g gVar;
        Intrinsics.checkNotNullParameter(event, "event");
        super.p(event);
        com.tencent.mobileqq.icgame.framework.component.d a16 = com.tencent.mobileqq.icgame.base.room.b.a(this, g.class);
        if (a16 != null && (gVar = (g) a16.a()) != null) {
            gVar.F();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void s(@NotNull i22.e event) {
        g gVar;
        Intrinsics.checkNotNullParameter(event, "event");
        super.s(event);
        com.tencent.mobileqq.icgame.framework.component.d a16 = com.tencent.mobileqq.icgame.base.room.b.a(this, g.class);
        if (a16 != null && (gVar = (g) a16.a()) != null) {
            gVar.H();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void u(@NotNull i22.g event) {
        g gVar;
        Intrinsics.checkNotNullParameter(event, "event");
        super.u(event);
        com.tencent.mobileqq.icgame.framework.component.d a16 = com.tencent.mobileqq.icgame.base.room.b.a(this, g.class);
        if (a16 != null && (gVar = (g) a16.a()) != null) {
            gVar.I(event.getIsPageClose(), event.getShouldExitRoom());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void x() {
        g gVar;
        super.x();
        com.tencent.mobileqq.icgame.framework.component.d a16 = com.tencent.mobileqq.icgame.base.room.b.a(this, g.class);
        if (a16 != null && (gVar = (g) a16.a()) != null) {
            gVar.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void z() {
        g gVar;
        super.z();
        com.tencent.mobileqq.icgame.framework.component.d a16 = com.tencent.mobileqq.icgame.base.room.b.a(this, g.class);
        if (a16 != null && (gVar = (g) a16.a()) != null) {
            gVar.E();
        }
    }
}
