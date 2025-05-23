package com.tencent.mobileqq.icgame.room.p006float.component;

import android.text.TextUtils;
import com.tencent.mobileqq.icgame.base.room.c;
import com.tencent.mobileqq.icgame.base.room.service.lifecycle.ActivityLifecycle;
import com.tencent.mobileqq.icgame.base.room.service.lifecycle.PageLifecycle;
import com.tencent.mobileqq.icgame.framework.component.d;
import com.tencent.mobileqq.icgame.framework.component.h;
import d22.a;
import f32.b;
import g32.f;
import g32.g;
import i22.ActivityLifecycleEvent;
import i22.PageLifecycleEvent;
import i22.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/float/component/FloatControlConnector;", "Lcom/tencent/mobileqq/icgame/framework/connector/a;", "Lcom/tencent/mobileqq/icgame/room/float/component/FloatControlComponent;", "e", "", "a", "", "Li32/a;", "c", "Lf32/b;", "cc", "<init>", "(Lf32/b;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class FloatControlConnector extends com.tencent.mobileqq.icgame.framework.connector.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/icgame/room/float/component/FloatControlConnector$a", "Lcom/tencent/mobileqq/icgame/room/float/component/a;", "", "b", "", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements com.tencent.mobileqq.icgame.room.p006float.component.a {
        a() {
        }

        @Override // com.tencent.mobileqq.icgame.room.p006float.component.a
        public boolean a() {
            FloatControlComponent e16 = FloatControlConnector.this.e();
            if (e16 == null || !e16.getEnterFloatWindowWhenActivityStop()) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.icgame.room.p006float.component.a
        public void b() {
            FloatControlComponent e16 = FloatControlConnector.this.e();
            if (e16 != null) {
                e16.y(true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatControlConnector(@NotNull b cc5) {
        super(cc5);
        Intrinsics.checkNotNullParameter(cc5, "cc");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FloatControlComponent e() {
        d a16 = getConnectorContext().a(FloatControlComponent.class);
        if (a16 != null) {
            return (FloatControlComponent) a16.a();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.icgame.framework.connector.a, com.tencent.mobileqq.icgame.framework.connector.b
    public void a() {
        final com.tencent.mobileqq.icgame.base.room.d dVar;
        final c cVar;
        h hVar;
        g c16 = getConnectorContext().c();
        d a16 = com.tencent.mobileqq.icgame.base.room.b.a(this, FloatControlComponent.class);
        final c cVar2 = null;
        if (a16 != null && (hVar = (h) a16.a()) != null) {
            dVar = new com.tencent.mobileqq.icgame.base.room.d(c16, hVar);
        } else {
            dVar = null;
        }
        if (dVar != null) {
            f.a(dVar.getRegister(), new g32.d(e.class, new Function1<e, Unit>() { // from class: com.tencent.mobileqq.icgame.room.float.component.FloatControlConnector$initEventConnector$$inlined$pageIn$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(e eVar) {
                    invoke(eVar);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull e it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ((FloatControlComponent) com.tencent.mobileqq.icgame.base.room.d.this.b()).w();
                }
            }));
        } else {
            dVar = null;
        }
        if (dVar != null) {
            f.a(dVar.getRegister(), new g32.d(i22.g.class, new Function1<i22.g, Unit>() { // from class: com.tencent.mobileqq.icgame.room.float.component.FloatControlConnector$initEventConnector$$inlined$pageOut$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(i22.g gVar) {
                    invoke(gVar);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull i22.g it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    i22.g gVar = it;
                    ((FloatControlComponent) com.tencent.mobileqq.icgame.base.room.d.this.b()).x(gVar.getIsPageClose(), gVar.getShouldExitRoom());
                }
            }));
        } else {
            dVar = null;
        }
        if (dVar != null) {
            f.a(dVar.getRegister(), new g32.d(PageLifecycleEvent.class, new Function1<PageLifecycleEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.float.component.FloatControlConnector$initEventConnector$$inlined$pageDestroy$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PageLifecycleEvent pageLifecycleEvent) {
                    invoke(pageLifecycleEvent);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull PageLifecycleEvent it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    com.tencent.mobileqq.icgame.framework.component.e b16 = com.tencent.mobileqq.icgame.base.room.d.this.b();
                    if (it.getPageLifecycle() == PageLifecycle.PAGE_DESTROY) {
                        ((FloatControlComponent) b16).v();
                    }
                }
            }));
        } else {
            dVar = null;
        }
        if (dVar != null) {
            f.a(dVar.getRegister(), new g32.d(ActivityLifecycleEvent.class, new Function1<ActivityLifecycleEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.float.component.FloatControlConnector$initEventConnector$$inlined$activityResume$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ActivityLifecycleEvent activityLifecycleEvent) {
                    invoke(activityLifecycleEvent);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull ActivityLifecycleEvent it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    com.tencent.mobileqq.icgame.framework.component.e b16 = com.tencent.mobileqq.icgame.base.room.d.this.b();
                    if (it.getLifecycle() == ActivityLifecycle.ON_RESUME) {
                        ((FloatControlComponent) b16).n();
                    }
                }
            }));
        } else {
            dVar = null;
        }
        if (dVar != null) {
            f.a(dVar.getRegister(), new g32.d(ActivityLifecycleEvent.class, new Function1<ActivityLifecycleEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.float.component.FloatControlConnector$initEventConnector$$inlined$activityPause$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ActivityLifecycleEvent activityLifecycleEvent) {
                    invoke(activityLifecycleEvent);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull ActivityLifecycleEvent it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    com.tencent.mobileqq.icgame.framework.component.e b16 = com.tencent.mobileqq.icgame.base.room.d.this.b();
                    if (it.getLifecycle() == ActivityLifecycle.ON_PAUSE) {
                        ((FloatControlComponent) b16).c();
                    }
                }
            }));
        } else {
            dVar = null;
        }
        if (dVar != null) {
            f.a(dVar.getRegister(), new g32.d(ActivityLifecycleEvent.class, new Function1<ActivityLifecycleEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.float.component.FloatControlConnector$initEventConnector$$inlined$activityStop$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ActivityLifecycleEvent activityLifecycleEvent) {
                    invoke(activityLifecycleEvent);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull ActivityLifecycleEvent it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    com.tencent.mobileqq.icgame.framework.component.e b16 = com.tencent.mobileqq.icgame.base.room.d.this.b();
                    if (it.getLifecycle() == ActivityLifecycle.ON_STOP) {
                        ((FloatControlComponent) b16).o();
                    }
                }
            }));
        }
        d a17 = com.tencent.mobileqq.icgame.base.room.b.a(this, d22.d.class);
        if (a17 == null) {
            cVar = null;
        } else {
            cVar = new c(this, a17, FloatControlComponent.class, "");
        }
        if (cVar != null) {
            f.a(cVar.b(), new g32.d(d22.a.class, new Function1<d22.a, Unit>() { // from class: com.tencent.mobileqq.icgame.room.float.component.FloatControlConnector$initEventConnector$$inlined$connect$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                    invoke(aVar);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull a it) {
                    com.tencent.mobileqq.icgame.framework.component.e e16;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (TextUtils.isEmpty(c.this.getToKey())) {
                        com.tencent.mobileqq.icgame.framework.connector.b conn = c.this.getConn();
                        Class c17 = c.this.c();
                        Intrinsics.checkNotNull(c17, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.ISingleComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.c(conn, c17);
                    } else {
                        com.tencent.mobileqq.icgame.framework.connector.b conn2 = c.this.getConn();
                        Class c18 = c.this.c();
                        Intrinsics.checkNotNull(c18, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.IMultiComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.e(conn2, c18, c.this.getToKey());
                    }
                    if (e16 != null) {
                        ((FloatControlComponent) e16).q();
                    }
                }
            }));
            cVar2 = cVar;
        }
        if (cVar2 != null) {
            f.a(cVar2.b(), new g32.d(Object.class, new Function1<Object, Unit>() { // from class: com.tencent.mobileqq.icgame.room.float.component.FloatControlConnector$initEventConnector$$inlined$connect$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                    invoke(obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull Object it) {
                    com.tencent.mobileqq.icgame.framework.component.e e16;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (TextUtils.isEmpty(c.this.getToKey())) {
                        com.tencent.mobileqq.icgame.framework.connector.b conn = c.this.getConn();
                        Class c17 = c.this.c();
                        Intrinsics.checkNotNull(c17, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.ISingleComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.c(conn, c17);
                    } else {
                        com.tencent.mobileqq.icgame.framework.connector.b conn2 = c.this.getConn();
                        Class c18 = c.this.c();
                        Intrinsics.checkNotNull(c18, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.icgame.framework.component.IMultiComponent>");
                        e16 = com.tencent.mobileqq.icgame.base.room.b.e(conn2, c18, c.this.getToKey());
                    }
                    if (e16 != null) {
                        ((FloatControlComponent) e16).u();
                    }
                }
            }));
        }
    }

    @Override // com.tencent.mobileqq.icgame.framework.connector.a, com.tencent.mobileqq.icgame.framework.connector.b
    @NotNull
    public List<i32.a<?>> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new i32.a(com.tencent.mobileqq.icgame.room.p006float.component.a.class, new a()));
        return arrayList;
    }
}
