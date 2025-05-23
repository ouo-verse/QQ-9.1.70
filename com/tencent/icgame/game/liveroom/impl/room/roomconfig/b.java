package com.tencent.icgame.game.liveroom.impl.room.roomconfig;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/roomconfig/b;", "Lg32/b;", "Lep4/b;", "c", "Lep4/b;", "()Lep4/b;", DownloadInfo.spKey_Config, "<init>", "(Lep4/b;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class b extends g32.b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ep4.b config;

    public b(@NotNull ep4.b config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final ep4.b getConfig() {
        return this.config;
    }
}
