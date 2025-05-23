package com.tencent.mobileqq.guild.media.core.notify;

import at1.GuildGameCreateBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/notify/f;", "Lcom/tencent/mobileqq/guild/media/core/notify/x;", "Lat1/a;", "d", "Lat1/a;", "a", "()Lat1/a;", "gameInfo", "<init>", "(Lat1/a;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class f implements x {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildGameCreateBean gameInfo;

    public f(@NotNull GuildGameCreateBean gameInfo) {
        Intrinsics.checkNotNullParameter(gameInfo, "gameInfo");
        this.gameInfo = gameInfo;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final GuildGameCreateBean getGameInfo() {
        return this.gameInfo;
    }
}
