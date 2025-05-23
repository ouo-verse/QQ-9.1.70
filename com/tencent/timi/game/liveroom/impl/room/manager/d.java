package com.tencent.timi.game.liveroom.impl.room.manager;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\u0004R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/manager/d;", "", "", "roomId", "", "d", "", "nick", "c", "b", "", "g", "hideNick", "e", "f", "", "a", "Ljava/util/List;", "anniversaryRoomList", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final d f377928c = new d();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Long> anniversaryRoomList = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/manager/d$a;", "", "Lcom/tencent/timi/game/liveroom/impl/room/manager/d;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/timi/game/liveroom/impl/room/manager/d;", "a", "()Lcom/tencent/timi/game/liveroom/impl/room/manager/d;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.manager.d$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final d a() {
            return d.f377928c;
        }

        Companion() {
        }
    }

    private final String c(String nick) {
        int i3;
        if (nick != null) {
            i3 = nick.length();
        } else {
            i3 = 0;
        }
        if (nick != null && i3 > 1) {
            if (i3 == 2) {
                char[] charArray = nick.toCharArray();
                Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
                return charArray[0] + "*";
            }
            char[] charArray2 = nick.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray2, "this as java.lang.String).toCharArray()");
            char c16 = charArray2[0];
            char[] charArray3 = nick.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray3, "this as java.lang.String).toCharArray()");
            return c16 + "**" + charArray3[i3 - 1];
        }
        return nick;
    }

    private final void d(long roomId) {
        if (!this.anniversaryRoomList.contains(Long.valueOf(roomId))) {
            this.anniversaryRoomList.add(Long.valueOf(roomId));
        }
    }

    @Nullable
    public final String b(long roomId, @Nullable String nick) {
        if (g(roomId)) {
            return c(nick);
        }
        return nick;
    }

    public final void e(long roomId, boolean hideNick) {
        if (hideNick) {
            d(roomId);
        } else if (this.anniversaryRoomList.contains(Long.valueOf(roomId))) {
            this.anniversaryRoomList.remove(Long.valueOf(roomId));
        }
    }

    public final void f() {
        this.anniversaryRoomList.clear();
    }

    public final boolean g(long roomId) {
        return this.anniversaryRoomList.contains(Long.valueOf(roomId));
    }
}
