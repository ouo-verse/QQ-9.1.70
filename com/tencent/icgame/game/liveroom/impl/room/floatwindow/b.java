package com.tencent.icgame.game.liveroom.impl.room.floatwindow;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0006\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/b;", "", "", "roomId", "", "a", "b", "J", "getRoomid", "()J", "c", "(J)V", "roomid", "Z", "getOpenFloatWindowWhenBackpress", "()Z", "(Z)V", "openFloatWindowWhenBackpress", "<init>", "()V", "ic-game-timi-game-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static volatile long roomid;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f115282a = new b();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean openFloatWindowWhenBackpress = true;

    b() {
    }

    public final boolean a(long roomId) {
        if (roomId == roomid && openFloatWindowWhenBackpress) {
            return true;
        }
        return false;
    }

    public final void b(boolean z16) {
        openFloatWindowWhenBackpress = z16;
    }

    public final void c(long j3) {
        roomid = j3;
    }
}
