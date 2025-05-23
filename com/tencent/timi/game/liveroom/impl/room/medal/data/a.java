package com.tencent.timi.game.liveroom.impl.room.medal.data;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/data/a;", "", "", "userId", "", "roomType", "", "c", "Lcom/tencent/mobileqq/qqlive/widget/chat/data/b;", "userMedalInfo", "", "d", "b", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final HashMap<String, com.tencent.mobileqq.qqlive.widget.chat.data.b> f377985b = new HashMap<>();

    private final String c(long userId, int roomType) {
        return userId + "_" + roomType;
    }

    public final void a() {
        f377985b.clear();
    }

    @Nullable
    public final com.tencent.mobileqq.qqlive.widget.chat.data.b b(long userId, int roomType) {
        return f377985b.get(c(userId, roomType));
    }

    public final void d(long userId, int roomType, @NotNull com.tencent.mobileqq.qqlive.widget.chat.data.b userMedalInfo) {
        Intrinsics.checkNotNullParameter(userMedalInfo, "userMedalInfo");
        f377985b.put(c(userId, roomType), userMedalInfo);
    }
}
