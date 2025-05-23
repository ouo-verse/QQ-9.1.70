package com.tencent.mobileqq.icgame.room.top;

import android.text.TextUtils;
import com.tencent.icgame.game.liveroom.impl.room.roomconfig.RoomConfigComponent;
import com.tencent.mobileqq.icgame.base.room.c;
import com.tencent.mobileqq.icgame.base.room.d;
import com.tencent.mobileqq.icgame.base.room.service.lifecycle.PageLifecycle;
import com.tencent.mobileqq.icgame.framework.component.e;
import com.tencent.mobileqq.icgame.framework.component.h;
import com.tencent.mobileqq.icgame.room.top.a;
import d22.GiftEvent;
import g32.f;
import g32.g;
import i22.OrientationChangedEvent;
import i22.PageLifecycleEvent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/top/TopAreaConnector;", "Lcom/tencent/mobileqq/icgame/framework/connector/a;", "", "Li32/a;", "c", "", "a", "Lf32/b;", "connectorContext", "<init>", "(Lf32/b;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class TopAreaConnector extends com.tencent.mobileqq.icgame.framework.connector.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/icgame/room/top/TopAreaConnector$a", "Lcom/tencent/mobileqq/icgame/room/top/a;", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements com.tencent.mobileqq.icgame.room.top.a {
        a() {
        }

        @Override // com.tencent.mobileqq.icgame.room.top.a
        public boolean a() {
            return a.C7930a.a(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopAreaConnector(@NotNull f32.b connectorContext) {
        super(connectorContext);
        Intrinsics.checkNotNullParameter(connectorContext, "connectorContext");
    }

    @Override // com.tencent.mobileqq.icgame.framework.connector.a, com.tencent.mobileqq.icgame.framework.connector.b
    public void a() {
        final d dVar;
        final c cVar;
        final c cVar2;
        final c cVar3;
        h hVar;
        g c16 = getConnectorContext().c();
        com.tencent.mobileqq.icgame.framework.component.d a16 = com.tencent.mobileqq.icgame.base.room.b.a(this, TopAreaComponent.class);
        final c cVar4 = null;
        if (a16 != null && (hVar = (h) a16.a()) != null) {
            dVar = new d(c16, hVar);
        } else {
            dVar = null;
        }
        if (dVar != null) {
            f.a(dVar.getRegister(), new g32.d(PageLifecycleEvent.class, new Function1<PageLifecycleEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.top.TopAreaConnector$initEventConnector$$inlined$pageResume$1
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
                    e b16 = d.this.b();
                    if (it.getPageLifecycle() == PageLifecycle.PAGE_RESUME) {
                        ((TopAreaComponent) b16).J();
                    }
                }
            }));
        } else {
            dVar = null;
        }
        if (dVar != null) {
            f.a(dVar.getRegister(), new g32.d(i22.h.class, new Function1<i22.h, Unit>() { // from class: com.tencent.mobileqq.icgame.room.top.TopAreaConnector$initEventConnector$$inlined$pagePreload$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(i22.h hVar2) {
                    invoke(hVar2);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull i22.h it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ((TopAreaComponent) d.this.b()).K();
                }
            }));
        } else {
            dVar = null;
        }
        if (dVar != null) {
            f.a(dVar.getRegister(), new g32.d(i22.e.class, new Function1<i22.e, Unit>() { // from class: com.tencent.mobileqq.icgame.room.top.TopAreaConnector$initEventConnector$$inlined$pageIn$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(i22.e eVar) {
                    invoke(eVar);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull i22.e it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ((TopAreaComponent) d.this.b()).H();
                }
            }));
        } else {
            dVar = null;
        }
        if (dVar != null) {
            f.a(dVar.getRegister(), new g32.d(i22.g.class, new Function1<i22.g, Unit>() { // from class: com.tencent.mobileqq.icgame.room.top.TopAreaConnector$initEventConnector$$inlined$pageOut$1
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
                    ((TopAreaComponent) d.this.b()).I();
                }
            }));
        } else {
            dVar = null;
        }
        if (dVar != null) {
            f.a(dVar.getRegister(), new g32.d(OrientationChangedEvent.class, new Function1<OrientationChangedEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.top.TopAreaConnector$initEventConnector$$inlined$orientationChange$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(OrientationChangedEvent orientationChangedEvent) {
                    invoke(orientationChangedEvent);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull OrientationChangedEvent it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ((TopAreaComponent) d.this.b()).G(it.getIsLandscape());
                }
            }));
        }
        com.tencent.mobileqq.icgame.framework.component.d a17 = com.tencent.mobileqq.icgame.base.room.b.a(this, d22.d.class);
        if (a17 == null) {
            cVar = null;
        } else {
            cVar = new c(this, a17, TopAreaComponent.class, "");
        }
        if (cVar != null) {
            f.a(cVar.b(), new g32.d(GiftEvent.class, new Function1<GiftEvent, Unit>() { // from class: com.tencent.mobileqq.icgame.room.top.TopAreaConnector$initEventConnector$$inlined$connect$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GiftEvent giftEvent) {
                    invoke(giftEvent);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull GiftEvent it) {
                    e e16;
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
                        ((TopAreaComponent) e16).L();
                    }
                }
            }));
        }
        com.tencent.mobileqq.icgame.framework.component.d a18 = com.tencent.mobileqq.icgame.base.room.b.a(this, RoomConfigComponent.class);
        if (a18 == null) {
            cVar2 = null;
        } else {
            cVar2 = new c(this, a18, TopAreaComponent.class, "");
        }
        if (cVar2 != null) {
            f.a(cVar2.b(), new g32.d(com.tencent.icgame.game.liveroom.impl.room.roomconfig.c.class, new Function1<com.tencent.icgame.game.liveroom.impl.room.roomconfig.c, Unit>() { // from class: com.tencent.mobileqq.icgame.room.top.TopAreaConnector$initEventConnector$$inlined$connect$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.icgame.game.liveroom.impl.room.roomconfig.c cVar5) {
                    invoke(cVar5);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull com.tencent.icgame.game.liveroom.impl.room.roomconfig.c it) {
                    e e16;
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
                        ((TopAreaComponent) e16).E(it.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String());
                    }
                }
            }));
        }
        com.tencent.mobileqq.icgame.framework.component.d a19 = com.tencent.mobileqq.icgame.base.room.b.a(this, com.tencent.mobileqq.icgame.room.component.a.class);
        if (a19 == null) {
            cVar3 = null;
        } else {
            cVar3 = new c(this, a19, TopAreaComponent.class, "");
        }
        if (cVar3 != null) {
            f.a(cVar3.b(), new g32.d(d22.f.class, new Function1<d22.f, Unit>() { // from class: com.tencent.mobileqq.icgame.room.top.TopAreaConnector$initEventConnector$$inlined$connect$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(d22.f fVar) {
                    invoke(fVar);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull d22.f it) {
                    e e16;
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
                        ((TopAreaComponent) e16).B(it.getRoomId());
                    }
                }
            }));
        }
        com.tencent.mobileqq.icgame.framework.component.d a26 = com.tencent.mobileqq.icgame.base.room.b.a(this, tv0.a.class);
        if (a26 != null) {
            cVar4 = new c(this, a26, TopAreaComponent.class, "");
        }
        if (cVar4 != null) {
            f.a(cVar4.b(), new g32.d(com.tencent.icgame.game.liveroom.impl.room.roomconfig.b.class, new Function1<com.tencent.icgame.game.liveroom.impl.room.roomconfig.b, Unit>() { // from class: com.tencent.mobileqq.icgame.room.top.TopAreaConnector$initEventConnector$$inlined$connect$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.icgame.game.liveroom.impl.room.roomconfig.b bVar) {
                    invoke(bVar);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull com.tencent.icgame.game.liveroom.impl.room.roomconfig.b it) {
                    e e16;
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
                        ((TopAreaComponent) e16).D(it.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String());
                    }
                }
            }));
        }
    }

    @Override // com.tencent.mobileqq.icgame.framework.connector.a, com.tencent.mobileqq.icgame.framework.connector.b
    @NotNull
    public List<i32.a<?>> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new i32.a(com.tencent.mobileqq.icgame.room.top.a.class, new a()));
        return arrayList;
    }
}
