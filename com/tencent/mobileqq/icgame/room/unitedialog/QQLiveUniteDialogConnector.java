package com.tencent.mobileqq.icgame.room.unitedialog;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.EnterRoomSuccessEvent;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.ExitRoomEvent;
import com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector;
import com.tencent.mobileqq.icgame.framework.component.d;
import g32.f;
import g32.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\u0007H\u0014\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/unitedialog/QQLiveUniteDialogConnector;", "Lcom/tencent/mobileqq/icgame/base/room/service/connector/RoomConnector;", "Lcom/tencent/mobileqq/icgame/room/unitedialog/a;", UserInfo.SEX_FEMALE, "", "Li32/a;", "c", "", "o", "j", "i", "Lf32/b;", "connectorContext", "<init>", "(Lf32/b;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class QQLiveUniteDialogConnector extends RoomConnector {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveUniteDialogConnector(@NotNull f32.b connectorContext) {
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
        arrayList.add(new i32.a(fx0.a.class, new b(getConnectorContext())));
        return arrayList;
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    protected void i() {
        a F = F();
        if (F != null) {
            F.b();
        }
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    protected void j() {
        a F = F();
        if (F != null) {
            F.c();
        }
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void o() {
        g a16;
        d a17 = getConnectorContext().a(com.tencent.mobileqq.icgame.room.component.a.class);
        if (a17 != null && (a16 = f.a(a17, new g32.d(EnterRoomSuccessEvent.class, new Function1<EnterRoomSuccessEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.unitedialog.QQLiveUniteDialogConnector$onInitEventConnector$1
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
                F = QQLiveUniteDialogConnector.this.F();
                if (F != null) {
                    F.n();
                }
            }
        }))) != null) {
            f.a(a16, new g32.d(ExitRoomEvent.class, new Function1<ExitRoomEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.unitedialog.QQLiveUniteDialogConnector$onInitEventConnector$2
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
                    F = QQLiveUniteDialogConnector.this.F();
                    if (F != null) {
                        F.o();
                    }
                }
            }));
        }
    }
}
