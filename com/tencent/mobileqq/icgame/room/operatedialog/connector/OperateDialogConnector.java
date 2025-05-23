package com.tencent.mobileqq.icgame.room.operatedialog.connector;

import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.EnterRoomSuccessEvent;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.ExitRoomEvent;
import com.tencent.mobileqq.icgame.framework.component.d;
import com.tencent.mobileqq.icgame.framework.connector.a;
import f32.b;
import g32.f;
import g32.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/operatedialog/connector/OperateDialogConnector;", "Lcom/tencent/mobileqq/icgame/framework/connector/a;", "Lcom/tencent/mobileqq/icgame/framework/component/d;", "Lcom/tencent/mobileqq/icgame/room/component/a;", "f", "Lj42/a;", "e", "", "a", "Lf32/b;", "connectorContext", "<init>", "(Lf32/b;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class OperateDialogConnector extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperateDialogConnector(@NotNull b connectorContext) {
        super(connectorContext);
        Intrinsics.checkNotNullParameter(connectorContext, "connectorContext");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final j42.a e() {
        d a16 = getConnectorContext().a(j42.a.class);
        if (a16 != null) {
            return (j42.a) a16.a();
        }
        return null;
    }

    private final d<com.tencent.mobileqq.icgame.room.component.a> f() {
        return getConnectorContext().a(com.tencent.mobileqq.icgame.room.component.a.class);
    }

    @Override // com.tencent.mobileqq.icgame.framework.connector.a, com.tencent.mobileqq.icgame.framework.connector.b
    public void a() {
        g a16;
        d<com.tencent.mobileqq.icgame.room.component.a> f16 = f();
        if (f16 != null && (a16 = f.a(f16, new g32.d(EnterRoomSuccessEvent.class, new Function1<EnterRoomSuccessEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.operatedialog.connector.OperateDialogConnector$initEventConnector$1
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
                j42.a e16;
                Intrinsics.checkNotNullParameter(it, "it");
                e16 = OperateDialogConnector.this.e();
                if (e16 != null) {
                    e16.b();
                }
            }
        }))) != null) {
            f.a(a16, new g32.d(ExitRoomEvent.class, new Function1<ExitRoomEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.operatedialog.connector.OperateDialogConnector$initEventConnector$2
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
                    j42.a e16;
                    Intrinsics.checkNotNullParameter(it, "it");
                    e16 = OperateDialogConnector.this.e();
                    if (e16 != null) {
                        e16.c();
                    }
                }
            }));
        }
    }
}
