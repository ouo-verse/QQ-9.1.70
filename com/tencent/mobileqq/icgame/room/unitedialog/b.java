package com.tencent.mobileqq.icgame.room.unitedialog;

import com.tencent.mobileqq.icgame.framework.component.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0006\u00a2\u0006\u0004\b\t\u0010\nJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/unitedialog/b;", "Lfx0/a;", "Lcom/tencent/mobileqq/icgame/room/component/a;", "b", "", "a", "Lf32/b;", "Lf32/b;", "connectorContext", "<init>", "(Lf32/b;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b implements fx0.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f32.b connectorContext;

    public b(@NotNull f32.b connectorContext) {
        Intrinsics.checkNotNullParameter(connectorContext, "connectorContext");
        this.connectorContext = connectorContext;
    }

    private final com.tencent.mobileqq.icgame.room.component.a b() {
        d a16 = this.connectorContext.a(com.tencent.mobileqq.icgame.room.component.a.class);
        if (a16 != null) {
            return (com.tencent.mobileqq.icgame.room.component.a) a16.a();
        }
        return null;
    }

    @Override // fx0.a
    public boolean a() {
        if (b() == null) {
            return false;
        }
        com.tencent.mobileqq.icgame.room.component.a b16 = b();
        Intrinsics.checkNotNull(b16);
        return b16.H();
    }
}
