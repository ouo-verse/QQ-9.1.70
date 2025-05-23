package com.tencent.mobileqq.icgame.room.connector;

import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.icgame.base.room.c;
import com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector;
import com.tencent.mobileqq.icgame.framework.component.d;
import com.tencent.mobileqq.icgame.framework.component.e;
import com.tencent.mobileqq.icgame.room.component.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import f32.b;
import g32.f;
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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0001%B\u000f\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0014J\b\u0010\u0010\u001a\u00020\fH\u0014J\b\u0010\u0011\u001a\u00020\fH\u0014J\b\u0010\u0012\u001a\u00020\fH\u0014J\b\u0010\u0013\u001a\u00020\fH\u0014J\b\u0010\u0014\u001a\u00020\fH\u0014J\b\u0010\u0015\u001a\u00020\fH\u0014J\b\u0010\u0016\u001a\u00020\fH\u0014J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0014J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u001aH\u0014J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u001cH\u0014J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u001eH\u0014\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/connector/ICGameAudienceConnector;", "Lcom/tencent/mobileqq/icgame/base/room/service/connector/RoomConnector;", "Lcom/tencent/mobileqq/icgame/framework/component/d;", "Ltv0/a;", "H", "Lcom/tencent/mobileqq/icgame/room/component/a;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/icgame/room/displayview/definition/b;", "G", "", "Li32/a;", "c", "", "o", "j", "l", "g", "y", HippyTKDListViewAdapter.X, "v", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "r", DomainData.DOMAIN_NAME, "Li22/h;", "event", "w", "Li22/e;", ReportConstant.COSTREPORT_PREFIX, "Li22/g;", "u", "Li22/k;", "B", "Lf32/b;", "connectorContext", "<init>", "(Lf32/b;)V", "b", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ICGameAudienceConnector extends RoomConnector {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ICGameAudienceConnector(@NotNull b connectorContext) {
        super(connectorContext);
        Intrinsics.checkNotNullParameter(connectorContext, "connectorContext");
    }

    private final a F() {
        d a16 = getConnectorContext().a(a.class);
        if (a16 != null) {
            return (a) a16.a();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.icgame.room.displayview.definition.b G() {
        d a16 = getConnectorContext().a(com.tencent.mobileqq.icgame.room.displayview.definition.b.class);
        if (a16 != null) {
            return (com.tencent.mobileqq.icgame.room.displayview.definition.b) a16.a();
        }
        return null;
    }

    private final d<tv0.a> H() {
        return getConnectorContext().a(tv0.a.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void B(@NotNull k event) {
        Intrinsics.checkNotNullParameter(event, "event");
        a F = F();
        if (F != null) {
            F.W();
        }
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector, com.tencent.mobileqq.icgame.framework.connector.a, com.tencent.mobileqq.icgame.framework.connector.b
    @NotNull
    public List<i32.a<?>> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new i32.a(b42.b.class, new b42.a(getConnectorContext())));
        return arrayList;
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    protected void g() {
        a F = F();
        if (F != null) {
            F.T();
        }
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    protected void j() {
        a F = F();
        if (F != null) {
            F.U();
        }
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    protected void l() {
        a F = F();
        if (F != null) {
            F.V();
        }
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    protected void n() {
        a F = F();
        if (F != null) {
            F.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void o() {
        final c cVar;
        d<tv0.a> H = H();
        if (H != null) {
            f.a(H, new g32.d(uv0.b.class, new Function1<uv0.b, Unit>() { // from class: com.tencent.mobileqq.icgame.room.connector.ICGameAudienceConnector$onInitEventConnector$1
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
                    com.tencent.mobileqq.icgame.room.displayview.definition.b G;
                    Intrinsics.checkNotNullParameter(it, "it");
                    G = ICGameAudienceConnector.this.G();
                    if (G != null) {
                        G.x();
                    }
                }
            }));
        }
        d a16 = com.tencent.mobileqq.icgame.base.room.b.a(this, com.tencent.mobileqq.icgame.room.input.component.b.class);
        if (a16 == null) {
            cVar = null;
        } else {
            cVar = new c(this, a16, a.class, "");
        }
        if (cVar != null) {
            f.a(cVar.b(), new g32.d(com.tencent.mobileqq.icgame.room.input.component.c.class, new Function1<com.tencent.mobileqq.icgame.room.input.component.c, Unit>() { // from class: com.tencent.mobileqq.icgame.room.connector.ICGameAudienceConnector$onInitEventConnector$$inlined$connect$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.icgame.room.input.component.c cVar2) {
                    invoke(cVar2);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull com.tencent.mobileqq.icgame.room.input.component.c it) {
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
                        ((a) e16).O(it.getState());
                    }
                }
            }));
        }
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    protected void r() {
        a F = F();
        if (F != null) {
            F.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void s(@NotNull i22.e event) {
        Intrinsics.checkNotNullParameter(event, "event");
        a F = F();
        if (F != null) {
            F.Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void u(@NotNull g event) {
        Intrinsics.checkNotNullParameter(event, "event");
        a F = F();
        if (F != null) {
            F.R(event.getIsPageClose(), event.getShouldExitRoom());
        }
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    protected void v() {
        a F = F();
        if (F != null) {
            F.K();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void w(@NotNull h event) {
        Intrinsics.checkNotNullParameter(event, "event");
        a F = F();
        if (F != null) {
            F.S();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void x() {
        a F = F();
        if (F != null) {
            F.L();
        }
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    protected void y() {
        a F = F();
        if (F != null) {
            F.M();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void z() {
        a F = F();
        if (F != null) {
            F.N();
        }
    }
}
