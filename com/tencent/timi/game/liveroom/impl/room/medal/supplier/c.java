package com.tencent.timi.game.liveroom.impl.room.medal.supplier;

import com.tencent.mobileqq.qqlive.widget.chat.message.f;
import com.tencent.timi.game.liveroom.impl.room.medal.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/supplier/c;", "Lcom/tencent/timi/game/liveroom/impl/room/medal/e;", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/f;", "msg", "Lcom/tencent/timi/game/liveroom/impl/room/medal/e$a;", "callback", "", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c implements e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f378042a = new c();

    c() {
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.medal.e
    public void a(@NotNull f msg2, @NotNull e.a callback) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.a(msg2, null);
    }
}
