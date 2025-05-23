package com.tencent.timi.game.liveroom.impl.room.anchor.pk;

import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.anchor.live.startlive.a;
import com.tencent.mobileqq.qqlive.base.room.c;
import com.tencent.mobileqq.qqlive.base.room.d;
import com.tencent.mobileqq.qqlive.framework.eventbroadcaster.f;
import com.tencent.mobileqq.qqlive.room.linkscreengame.b;
import com.tencent.timi.game.liveroom.impl.room.anchor.p;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u0010\u0006\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0018\u00010\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/anchor/pk/TimiCrossRoomLinkScreenStateConnector;", "Lcom/tencent/mobileqq/qqlive/framework/connector/a;", "", "a", "", "Lcom/tencent/mobileqq/qqlive/framework/interfaceService/a;", "c", "Lfi2/b;", "cc", "<init>", "(Lfi2/b;)V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TimiCrossRoomLinkScreenStateConnector extends com.tencent.mobileqq.qqlive.framework.connector.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/anchor/pk/TimiCrossRoomLinkScreenStateConnector$a", "Lcom/tencent/mobileqq/qqlive/room/linkscreengame/b;", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements b {
        a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimiCrossRoomLinkScreenStateConnector(@NotNull fi2.b cc5) {
        super(cc5);
        Intrinsics.checkNotNullParameter(cc5, "cc");
    }

    @Override // com.tencent.mobileqq.qqlive.framework.connector.a, com.tencent.mobileqq.qqlive.framework.connector.b
    public void a() {
        final d dVar;
        com.tencent.mobileqq.qqlive.framework.component.d a16 = c.a(this, p.class);
        if (a16 == null) {
            dVar = null;
        } else {
            dVar = new d(this, a16, com.tencent.mobileqq.qqlive.room.linkscreengame.a.class, "");
        }
        if (dVar != null) {
            f.a(dVar.b(), new com.tencent.mobileqq.qqlive.framework.eventbroadcaster.d(com.tencent.mobileqq.qqlive.anchor.live.startlive.a.class, new Function1<com.tencent.mobileqq.qqlive.anchor.live.startlive.a, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.anchor.pk.TimiCrossRoomLinkScreenStateConnector$initEventConnector$$inlined$connect$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                    invoke(aVar);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull a it) {
                    Object e16;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (TextUtils.isEmpty(d.this.d())) {
                        com.tencent.mobileqq.qqlive.framework.connector.b a17 = d.this.a();
                        Class c16 = d.this.c();
                        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.qqlive.framework.component.ISingleComponent>");
                        e16 = c.c(a17, c16);
                    } else {
                        com.tencent.mobileqq.qqlive.framework.connector.b a18 = d.this.a();
                        Class c17 = d.this.c();
                        Intrinsics.checkNotNull(c17, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.qqlive.framework.component.IMultiComponent>");
                        e16 = c.e(a18, c17, d.this.d());
                    }
                    if (e16 != null) {
                        ((com.tencent.mobileqq.qqlive.room.linkscreengame.a) e16).o();
                    }
                }
            }));
            f.a(dVar.b(), new com.tencent.mobileqq.qqlive.framework.eventbroadcaster.d(com.tencent.mobileqq.qqlive.anchor.live.startlive.b.class, new Function1<com.tencent.mobileqq.qqlive.anchor.live.startlive.b, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.anchor.pk.TimiCrossRoomLinkScreenStateConnector$initEventConnector$$inlined$connect$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqlive.anchor.live.startlive.b bVar) {
                    invoke(bVar);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull com.tencent.mobileqq.qqlive.anchor.live.startlive.b it) {
                    Object e16;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (TextUtils.isEmpty(d.this.d())) {
                        com.tencent.mobileqq.qqlive.framework.connector.b a17 = d.this.a();
                        Class c16 = d.this.c();
                        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.qqlive.framework.component.ISingleComponent>");
                        e16 = c.c(a17, c16);
                    } else {
                        com.tencent.mobileqq.qqlive.framework.connector.b a18 = d.this.a();
                        Class c17 = d.this.c();
                        Intrinsics.checkNotNull(c17, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.qqlive.framework.component.IMultiComponent>");
                        e16 = c.e(a18, c17, d.this.d());
                    }
                    if (e16 != null) {
                        ((com.tencent.mobileqq.qqlive.room.linkscreengame.a) e16).p();
                    }
                }
            }));
        }
    }

    @Override // com.tencent.mobileqq.qqlive.framework.connector.a, com.tencent.mobileqq.qqlive.framework.connector.b
    @Nullable
    public List<com.tencent.mobileqq.qqlive.framework.interfaceService.a<?>> c() {
        List<com.tencent.mobileqq.qqlive.framework.interfaceService.a<?>> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new com.tencent.mobileqq.qqlive.framework.interfaceService.a(b.class, new a()));
        return listOf;
    }
}
