package com.tencent.mobileqq.guild.media.game.service.repository;

import bt1.RoomAuthParams;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.fi;
import com.tencent.mobileqq.qqguildsdk.data.genc.fj;
import com.tencent.mobileqq.qqguildsdk.data.genc.fl;
import com.tencent.mobileqq.qqguildsdk.data.genc.fm;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import vh2.dh;
import wh2.em;
import wh2.eu;
import wh2.ev;
import wh2.ew;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u000eJ6\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0016J\u001e\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u001aJ\u001e\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/media/game/service/repository/a;", "", "Lmqq/app/AppRuntime;", "appRuntime", "Lbt1/i;", "roomAuthParams", "Lvh2/dh;", "cb", "", "a", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/fi;", "baseParams", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/fm;", "smobaParams", "Lwh2/eu;", "b", "", "roomId", "", "roomType", "guildId", "channelId", "Lwh2/ev;", "d", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/fl;", "req", "Lwh2/ew;", "e", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/fj;", "Lwh2/em;", "c", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {
    public final void a(@NotNull AppRuntime appRuntime, @NotNull RoomAuthParams roomAuthParams, @NotNull dh cb5) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(roomAuthParams, "roomAuthParams");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).voiceChannelAuth0x10b6(roomAuthParams.getGuildId(), roomAuthParams.getChannelId(), roomAuthParams.getGameType(), roomAuthParams.getNeedGameMode(), roomAuthParams.getServiceType(), cb5);
    }

    public final void b(@NotNull AppRuntime appRuntime, @NotNull fi baseParams, @NotNull fm smobaParams, @NotNull eu cb5) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(baseParams, "baseParams");
        Intrinsics.checkNotNullParameter(smobaParams, "smobaParams");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).voiceSmobaGameCreateRoom(baseParams, smobaParams, cb5);
    }

    public final void c(@NotNull AppRuntime appRuntime, @NotNull fj req, @NotNull em cb5) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).voiceSmobaGameDissmissRoom(req, cb5);
    }

    public final void d(@NotNull AppRuntime appRuntime, long roomId, int roomType, long guildId, long channelId, @NotNull ev cb5) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).voiceSmobaGameEnterRoom(roomId, roomType, guildId, channelId, cb5);
    }

    public final void e(@NotNull AppRuntime appRuntime, @NotNull fl req, @NotNull ew cb5) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).voiceSmobaGameQuitRoom(req, cb5);
    }
}
