package com.tencent.guildlive.aio.factory;

import com.tencent.aio.main.businesshelper.h;
import com.tencent.guild.aio.help.BaseGuildHelperProvider;
import com.tencent.guild.aio.help.GuildArkContainerHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\"\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/guildlive/aio/factory/GuildLiveAnnounceDetailHelperProvider;", "Lcom/tencent/guild/aio/help/BaseGuildHelperProvider;", "Lcom/tencent/aio/api/help/a;", "param", "", "", "Lkotlin/Function0;", "Lcom/tencent/aio/main/businesshelper/h;", "getLifeCycleHelperCreator", "<init>", "()V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLiveAnnounceDetailHelperProvider extends BaseGuildHelperProvider {
    @Override // com.tencent.guild.aio.help.BaseGuildHelperProvider, com.tencent.aio.api.help.d
    @NotNull
    public Map<String, Function0<h>> getLifeCycleHelperCreator(@NotNull com.tencent.aio.api.help.a param) {
        Map mapOf;
        Map<String, Function0<h>> plus;
        Intrinsics.checkNotNullParameter(param, "param");
        Map<String, Function0<h>> lifeCycleHelperCreator = super.getLifeCycleHelperCreator(param);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("GuildArkContainerHelper", new Function0<GuildArkContainerHelper>() { // from class: com.tencent.guildlive.aio.factory.GuildLiveAnnounceDetailHelperProvider$getLifeCycleHelperCreator$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildArkContainerHelper invoke() {
                return new GuildArkContainerHelper();
            }
        }));
        plus = MapsKt__MapsKt.plus(lifeCycleHelperCreator, mapOf);
        return plus;
    }
}
