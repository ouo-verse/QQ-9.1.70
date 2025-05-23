package com.tencent.mobileqq.icgame.room.touchdelegate;

import android.text.TextUtils;
import com.tencent.mobileqq.icgame.base.room.c;
import com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector;
import com.tencent.mobileqq.icgame.framework.component.d;
import com.tencent.mobileqq.icgame.framework.component.e;
import g32.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import y32.ConfigurationChangeEvent;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/touchdelegate/TouchDelegateConnector;", "Lcom/tencent/mobileqq/icgame/base/room/service/connector/RoomConnector;", "", "o", "Lf32/b;", "connectorContext", "<init>", "(Lf32/b;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class TouchDelegateConnector extends RoomConnector {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TouchDelegateConnector(@NotNull f32.b connectorContext) {
        super(connectorContext);
        Intrinsics.checkNotNullParameter(connectorContext, "connectorContext");
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void o() {
        final c cVar;
        d a16 = com.tencent.mobileqq.icgame.base.room.b.a(this, com.tencent.mobileqq.icgame.room.component.a.class);
        final c cVar2 = null;
        if (a16 == null) {
            cVar = null;
        } else {
            cVar = new c(this, a16, TouchDelegateComponent.class, "");
        }
        if (cVar != null) {
            f.a(cVar.b(), new g32.d(ConfigurationChangeEvent.class, new Function1<ConfigurationChangeEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.touchdelegate.TouchDelegateConnector$onInitEventConnector$$inlined$connect$1
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
                        ((TouchDelegateComponent) e16).q(it.getNewConfig());
                    }
                }
            }));
        }
        d a17 = com.tencent.mobileqq.icgame.base.room.b.a(this, com.tencent.mobileqq.icgame.room.input.component.b.class);
        if (a17 != null) {
            cVar2 = new c(this, a17, TouchDelegateComponent.class, "");
        }
        if (cVar2 != null) {
            f.a(cVar2.b(), new g32.d(com.tencent.mobileqq.icgame.room.input.component.c.class, new Function1<com.tencent.mobileqq.icgame.room.input.component.c, Unit>() { // from class: com.tencent.mobileqq.icgame.room.touchdelegate.TouchDelegateConnector$onInitEventConnector$$inlined$connect$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.icgame.room.input.component.c cVar3) {
                    invoke(cVar3);
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
                        ((TouchDelegateComponent) e16).r(it.getState());
                    }
                }
            }));
        }
    }
}
