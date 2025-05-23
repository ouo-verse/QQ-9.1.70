package com.tencent.mobileqq.icgame.room.pendant.component;

import android.text.TextUtils;
import android.widget.FrameLayout;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.EnterRoomSuccessEvent;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.ExitRoomEvent;
import com.tencent.mobileqq.icgame.base.room.b;
import com.tencent.mobileqq.icgame.base.room.c;
import com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector;
import com.tencent.mobileqq.icgame.framework.component.d;
import com.tencent.mobileqq.icgame.framework.component.e;
import com.tencent.mobileqq.icgame.room.displayview.horizontal.o;
import d42.g;
import g32.f;
import i22.OrientationChangedEvent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rv0.AutoCollapseViewExpanded;
import rv0.SoftKeyBoardStateEvent;
import y32.ConfigurationChangeEvent;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/pendant/component/QQIvLivePendantConnector;", "Lcom/tencent/mobileqq/icgame/base/room/service/connector/RoomConnector;", "", "Li32/a;", "c", "", "o", "Li22/d;", "event", "p", "Lf32/b;", "cc", "<init>", "(Lf32/b;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class QQIvLivePendantConnector extends RoomConnector {

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/icgame/room/pendant/component/QQIvLivePendantConnector$a", "Lcom/tencent/mobileqq/icgame/room/pendant/component/a;", "Landroid/widget/FrameLayout;", "b", "c", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements com.tencent.mobileqq.icgame.room.pendant.component.a {
        a() {
        }

        @Override // com.tencent.mobileqq.icgame.room.pendant.component.a
        @Nullable
        public FrameLayout a() {
            com.tencent.mobileqq.icgame.room.component.a aVar = (com.tencent.mobileqq.icgame.room.component.a) b.c(QQIvLivePendantConnector.this, com.tencent.mobileqq.icgame.room.component.a.class);
            if (aVar != null) {
                return aVar.E();
            }
            return null;
        }

        @Override // com.tencent.mobileqq.icgame.room.pendant.component.a
        @Nullable
        public FrameLayout b() {
            com.tencent.mobileqq.icgame.room.component.a aVar = (com.tencent.mobileqq.icgame.room.component.a) b.c(QQIvLivePendantConnector.this, com.tencent.mobileqq.icgame.room.component.a.class);
            if (aVar != null) {
                return aVar.C();
            }
            return null;
        }

        @Override // com.tencent.mobileqq.icgame.room.pendant.component.a
        @Nullable
        public FrameLayout c() {
            com.tencent.mobileqq.icgame.room.component.a aVar = (com.tencent.mobileqq.icgame.room.component.a) b.c(QQIvLivePendantConnector.this, com.tencent.mobileqq.icgame.room.component.a.class);
            if (aVar != null) {
                return aVar.F();
            }
            return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQIvLivePendantConnector(@NotNull f32.b cc5) {
        super(cc5);
        Intrinsics.checkNotNullParameter(cc5, "cc");
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector, com.tencent.mobileqq.icgame.framework.connector.a, com.tencent.mobileqq.icgame.framework.connector.b
    @NotNull
    public List<i32.a<?>> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new i32.a(com.tencent.mobileqq.icgame.room.pendant.component.a.class, new a()));
        return arrayList;
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void o() {
        final c cVar;
        final c cVar2;
        final c cVar3;
        final c cVar4;
        final c cVar5;
        d a16 = b.a(this, com.tencent.mobileqq.icgame.room.component.a.class);
        final c cVar6 = null;
        if (a16 == null) {
            cVar = null;
        } else {
            cVar = new c(this, a16, QQLivePendantComponent.class, "");
        }
        if (cVar != null) {
            f.a(cVar.b(), new g32.d(EnterRoomSuccessEvent.class, new Function1<EnterRoomSuccessEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.pendant.component.QQIvLivePendantConnector$onInitEventConnector$$inlined$connect$1
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
                    if (TextUtils.isEmpty(c.this.getToKey())) {
                        com.tencent.mobileqq.icgame.framework.connector.b conn = c.this.getConn();
                        Class c16 = c.this.c();
                        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.ISingleComponent>");
                        e16 = b.c(conn, c16);
                    } else {
                        com.tencent.mobileqq.icgame.framework.connector.b conn2 = c.this.getConn();
                        Class c17 = c.this.c();
                        Intrinsics.checkNotNull(c17, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.IMultiComponent>");
                        e16 = b.e(conn2, c17, c.this.getToKey());
                    }
                    if (e16 != null) {
                        ((QQLivePendantComponent) e16).q();
                    }
                }
            }));
        }
        d a17 = b.a(this, com.tencent.mobileqq.icgame.room.component.a.class);
        if (a17 == null) {
            cVar2 = null;
        } else {
            cVar2 = new c(this, a17, QQLivePendantComponent.class, "");
        }
        if (cVar2 != null) {
            f.a(cVar2.b(), new g32.d(ExitRoomEvent.class, new Function1<ExitRoomEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.pendant.component.QQIvLivePendantConnector$onInitEventConnector$$inlined$connect$2
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
                    if (TextUtils.isEmpty(c.this.getToKey())) {
                        com.tencent.mobileqq.icgame.framework.connector.b conn = c.this.getConn();
                        Class c16 = c.this.c();
                        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.ISingleComponent>");
                        e16 = b.c(conn, c16);
                    } else {
                        com.tencent.mobileqq.icgame.framework.connector.b conn2 = c.this.getConn();
                        Class c17 = c.this.c();
                        Intrinsics.checkNotNull(c17, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.IMultiComponent>");
                        e16 = b.e(conn2, c17, c.this.getToKey());
                    }
                    if (e16 != null) {
                        ((QQLivePendantComponent) e16).w();
                    }
                }
            }));
        }
        d a18 = b.a(this, com.tencent.mobileqq.icgame.room.component.a.class);
        if (a18 == null) {
            cVar3 = null;
        } else {
            cVar3 = new c(this, a18, QQLivePendantComponent.class, "");
        }
        if (cVar3 != null) {
            f.a(cVar3.b(), new g32.d(ConfigurationChangeEvent.class, new Function1<ConfigurationChangeEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.pendant.component.QQIvLivePendantConnector$onInitEventConnector$$inlined$connect$3
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
                        e16 = b.c(conn, c16);
                    } else {
                        com.tencent.mobileqq.icgame.framework.connector.b conn2 = c.this.getConn();
                        Class c17 = c.this.c();
                        Intrinsics.checkNotNull(c17, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.IMultiComponent>");
                        e16 = b.e(conn2, c17, c.this.getToKey());
                    }
                    if (e16 != null) {
                        ((QQLivePendantComponent) e16).s(it);
                    }
                }
            }));
        }
        d a19 = b.a(this, com.tencent.mobileqq.icgame.room.displayview.component.d.class);
        if (a19 == null) {
            cVar4 = null;
        } else {
            cVar4 = new c(this, a19, QQLivePendantComponent.class, "");
        }
        if (cVar4 != null) {
            f.a(cVar4.b(), new g32.d(g.class, new Function1<g, Unit>() { // from class: com.tencent.mobileqq.icgame.room.pendant.component.QQIvLivePendantConnector$onInitEventConnector$$inlined$connect$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(g gVar) {
                    invoke(gVar);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull g it) {
                    e e16;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (TextUtils.isEmpty(c.this.getToKey())) {
                        com.tencent.mobileqq.icgame.framework.connector.b conn = c.this.getConn();
                        Class c16 = c.this.c();
                        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.ISingleComponent>");
                        e16 = b.c(conn, c16);
                    } else {
                        com.tencent.mobileqq.icgame.framework.connector.b conn2 = c.this.getConn();
                        Class c17 = c.this.c();
                        Intrinsics.checkNotNull(c17, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.IMultiComponent>");
                        e16 = b.e(conn2, c17, c.this.getToKey());
                    }
                    if (e16 != null) {
                        ((QQLivePendantComponent) e16).v(it);
                    }
                }
            }));
        }
        d a26 = b.a(this, o.class);
        if (a26 == null) {
            cVar5 = null;
        } else {
            cVar5 = new c(this, a26, QQLivePendantComponent.class, "");
        }
        if (cVar5 != null) {
            f.a(cVar5.b(), new g32.d(AutoCollapseViewExpanded.class, new Function1<AutoCollapseViewExpanded, Unit>() { // from class: com.tencent.mobileqq.icgame.room.pendant.component.QQIvLivePendantConnector$onInitEventConnector$$inlined$connect$5
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AutoCollapseViewExpanded autoCollapseViewExpanded) {
                    invoke(autoCollapseViewExpanded);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull AutoCollapseViewExpanded it) {
                    e e16;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (TextUtils.isEmpty(c.this.getToKey())) {
                        com.tencent.mobileqq.icgame.framework.connector.b conn = c.this.getConn();
                        Class c16 = c.this.c();
                        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.ISingleComponent>");
                        e16 = b.c(conn, c16);
                    } else {
                        com.tencent.mobileqq.icgame.framework.connector.b conn2 = c.this.getConn();
                        Class c17 = c.this.c();
                        Intrinsics.checkNotNull(c17, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.IMultiComponent>");
                        e16 = b.e(conn2, c17, c.this.getToKey());
                    }
                    if (e16 != null) {
                        ((QQLivePendantComponent) e16).r(it.getExpand());
                    }
                }
            }));
            cVar6 = cVar5;
        }
        if (cVar6 != null) {
            f.a(cVar6.b(), new g32.d(SoftKeyBoardStateEvent.class, new Function1<SoftKeyBoardStateEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.pendant.component.QQIvLivePendantConnector$onInitEventConnector$$inlined$connect$6
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SoftKeyBoardStateEvent softKeyBoardStateEvent) {
                    invoke(softKeyBoardStateEvent);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull SoftKeyBoardStateEvent it) {
                    e e16;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (TextUtils.isEmpty(c.this.getToKey())) {
                        com.tencent.mobileqq.icgame.framework.connector.b conn = c.this.getConn();
                        Class c16 = c.this.c();
                        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.ISingleComponent>");
                        e16 = b.c(conn, c16);
                    } else {
                        com.tencent.mobileqq.icgame.framework.connector.b conn2 = c.this.getConn();
                        Class c17 = c.this.c();
                        Intrinsics.checkNotNull(c17, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.IMultiComponent>");
                        e16 = b.e(conn2, c17, c.this.getToKey());
                    }
                    if (e16 != null) {
                        ((QQLivePendantComponent) e16).u(it);
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void p(@NotNull OrientationChangedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        QQLivePendantComponent qQLivePendantComponent = (QQLivePendantComponent) b.c(this, QQLivePendantComponent.class);
        if (qQLivePendantComponent != null) {
            qQLivePendantComponent.t(event);
        }
    }
}
