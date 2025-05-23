package com.tencent.mobileqq.icgame.room.operationbar;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.EnterRoomSuccessEvent;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.ExitRoomEvent;
import com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector;
import com.tencent.mobileqq.icgame.framework.component.d;
import com.tencent.mobileqq.icgame.room.displayview.horizontal.o;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import f32.b;
import g32.f;
import g32.g;
import i22.OrientationChangedEvent;
import i22.e;
import i22.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ov0.ConfigUpdateEvent;
import rv0.DefinitionNeedChangeEvent;
import tv0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\u0007H\u0014J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000eH\u0014J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0010H\u0014J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0012H\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/operationbar/QQLiveAudienceOperationBarConnector;", "Lcom/tencent/mobileqq/icgame/base/room/service/connector/RoomConnector;", "Ltv0/a;", UserInfo.SEX_FEMALE, "", "Li32/a;", "c", "", "o", HippyTKDListViewAdapter.X, "k", "Li22/h;", "event", "w", "Li22/e;", ReportConstant.COSTREPORT_PREFIX, "Li22/g;", "u", "Li22/d;", "p", "Lf32/b;", "connectorContext", "<init>", "(Lf32/b;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class QQLiveAudienceOperationBarConnector extends RoomConnector {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveAudienceOperationBarConnector(@NotNull b connectorContext) {
        super(connectorContext);
        Intrinsics.checkNotNullParameter(connectorContext, "connectorContext");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a F() {
        d a16 = getConnectorContext().a(a.class);
        if (a16 != null) {
            return (a) a16.a();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector, com.tencent.mobileqq.icgame.framework.connector.a, com.tencent.mobileqq.icgame.framework.connector.b
    @NotNull
    public List<i32.a<?>> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new i32.a(vv0.a.class, new k42.a(getConnectorContext())));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void k() {
        super.k();
        a F = F();
        if (F != null) {
            F.C();
        }
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void o() {
        g a16;
        g a17;
        g a18;
        d a19 = getConnectorContext().a(com.tencent.mobileqq.icgame.room.component.a.class);
        if (a19 != null && (a16 = f.a(a19, new g32.d(EnterRoomSuccessEvent.class, new Function1<EnterRoomSuccessEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.operationbar.QQLiveAudienceOperationBarConnector$onInitEventConnector$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EnterRoomSuccessEvent enterRoomSuccessEvent) {
                invoke2(enterRoomSuccessEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EnterRoomSuccessEvent it) {
                a F;
                Intrinsics.checkNotNullParameter(it, "it");
                F = QQLiveAudienceOperationBarConnector.this.F();
                if (F != null) {
                    F.D();
                }
            }
        }))) != null && (a17 = f.a(a16, new g32.d(ExitRoomEvent.class, new Function1<ExitRoomEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.operationbar.QQLiveAudienceOperationBarConnector$onInitEventConnector$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ExitRoomEvent exitRoomEvent) {
                invoke2(exitRoomEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ExitRoomEvent it) {
                a F;
                Intrinsics.checkNotNullParameter(it, "it");
                F = QQLiveAudienceOperationBarConnector.this.F();
                if (F != null) {
                    F.E();
                }
            }
        }))) != null && (a18 = f.a(a17, new g32.d(ov0.b.class, new Function1<ov0.b, Unit>() { // from class: com.tencent.mobileqq.icgame.room.operationbar.QQLiveAudienceOperationBarConnector$onInitEventConnector$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ov0.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ov0.b it) {
                a F;
                Intrinsics.checkNotNullParameter(it, "it");
                F = QQLiveAudienceOperationBarConnector.this.F();
                if (F != null) {
                    F.I();
                }
            }
        }))) != null) {
            f.a(a18, new g32.d(ConfigUpdateEvent.class, new Function1<ConfigUpdateEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.operationbar.QQLiveAudienceOperationBarConnector$onInitEventConnector$4
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ConfigUpdateEvent configUpdateEvent) {
                    invoke2(configUpdateEvent);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull ConfigUpdateEvent it) {
                    a F;
                    Intrinsics.checkNotNullParameter(it, "it");
                    F = QQLiveAudienceOperationBarConnector.this.F();
                    if (F != null) {
                        F.K();
                    }
                }
            }));
        }
        d a26 = getConnectorContext().a(com.tencent.mobileqq.icgame.room.displayview.definition.b.class);
        if (a26 != null) {
            f.a(a26, new g32.d(DefinitionNeedChangeEvent.class, new Function1<DefinitionNeedChangeEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.operationbar.QQLiveAudienceOperationBarConnector$onInitEventConnector$5
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DefinitionNeedChangeEvent definitionNeedChangeEvent) {
                    invoke2(definitionNeedChangeEvent);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull DefinitionNeedChangeEvent it) {
                    a F;
                    Intrinsics.checkNotNullParameter(it, "it");
                    F = QQLiveAudienceOperationBarConnector.this.F();
                    if (F != null) {
                        F.M(it.getRoomId(), it.getShowTips());
                    }
                }
            }));
        }
        d a27 = getConnectorContext().a(o.class);
        if (a27 != null) {
            f.a(a27, new g32.d(DefinitionNeedChangeEvent.class, new Function1<DefinitionNeedChangeEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.operationbar.QQLiveAudienceOperationBarConnector$onInitEventConnector$6
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DefinitionNeedChangeEvent definitionNeedChangeEvent) {
                    invoke2(definitionNeedChangeEvent);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull DefinitionNeedChangeEvent it) {
                    a F;
                    Intrinsics.checkNotNullParameter(it, "it");
                    F = QQLiveAudienceOperationBarConnector.this.F();
                    if (F != null) {
                        F.M(it.getRoomId(), it.getShowTips());
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void p(@NotNull OrientationChangedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        a F = F();
        if (F != null) {
            F.F(event.getIsLandscape());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void s(@NotNull e event) {
        Intrinsics.checkNotNullParameter(event, "event");
        a F = F();
        if (F != null) {
            F.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void u(@NotNull i22.g event) {
        Intrinsics.checkNotNullParameter(event, "event");
        a F = F();
        if (F != null) {
            F.H();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void w(@NotNull h event) {
        Intrinsics.checkNotNullParameter(event, "event");
        a F = F();
        if (F != null) {
            F.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void x() {
        a F = F();
        if (F != null) {
            F.N();
        }
    }
}
