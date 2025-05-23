package com.tencent.mobileqq.guild.main.announcement.detail.aio;

import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.guild.aio.help.BaseGuildHelperProvider;
import com.tencent.guild.aio.help.GuildArkContainerHelper;
import com.tencent.guild.aio.help.d;
import com.tencent.guild.aio.help.p;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qqguild.base.aio.helpers.ArticlePageNavigateHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/main/announcement/detail/aio/GuildAnnouncementHelperProvider;", "Lcom/tencent/guild/aio/help/BaseGuildHelperProvider;", "", "guildId", "", "b", "Lcom/tencent/aio/api/help/a;", "param", "", "Lkotlin/Function0;", "Lcom/tencent/aio/main/businesshelper/h;", "getLifeCycleHelperCreator", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildAnnouncementHelperProvider extends BaseGuildHelperProvider {
    /* JADX INFO: Access modifiers changed from: private */
    public final int b(String guildId) {
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        IGProGuildInfo guildInfo = ((IGPSService) S0).getGuildInfo(guildId);
        if (guildInfo != null && guildInfo.getUserType() != 0) {
            if (guildInfo.getUserType() != 1) {
                return 1;
            }
            return 2;
        }
        return 3;
    }

    @Override // com.tencent.guild.aio.help.BaseGuildHelperProvider, com.tencent.aio.api.help.d
    @NotNull
    public Map<String, Function0<h>> getLifeCycleHelperCreator(@NotNull com.tencent.aio.api.help.a param) {
        Map mapOf;
        Map<String, Function0<h>> plus;
        Intrinsics.checkNotNullParameter(param, "param");
        Map<String, Function0<h>> lifeCycleHelperCreator = super.getLifeCycleHelperCreator(param);
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("GuildArkContainerHelper", new Function0<h>() { // from class: com.tencent.mobileqq.guild.main.announcement.detail.aio.GuildAnnouncementHelperProvider$getLifeCycleHelperCreator$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final h invoke() {
                return new GuildArkContainerHelper();
            }
        }), TuplesKt.to("HeartBeatReportHelper", new Function0<h>() { // from class: com.tencent.mobileqq.guild.main.announcement.detail.aio.GuildAnnouncementHelperProvider$getLifeCycleHelperCreator$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final h invoke() {
                return new p();
            }
        }), TuplesKt.to("DtPageReportHelper", new Function0<h>() { // from class: com.tencent.mobileqq.guild.main.announcement.detail.aio.GuildAnnouncementHelperProvider$getLifeCycleHelperCreator$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final h invoke() {
                final GuildAnnouncementHelperProvider guildAnnouncementHelperProvider = GuildAnnouncementHelperProvider.this;
                return new com.tencent.qqguild.base.aio.helpers.a("pg_sgrp_main_post", new Function1<AIOParam, Map<String, Object>>() { // from class: com.tencent.mobileqq.guild.main.announcement.detail.aio.GuildAnnouncementHelperProvider$getLifeCycleHelperCreator$3.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final Map<String, Object> invoke(@NotNull AIOParam aioParam) {
                        int b16;
                        Map<String, Object> mutableMapOf;
                        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
                        b16 = GuildAnnouncementHelperProvider.this.b(com.tencent.guild.aio.util.a.g(aioParam));
                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("sgrp_user_type", Integer.valueOf(b16)));
                        return mutableMapOf;
                    }
                });
            }
        }), TuplesKt.to("ArticlePageNavigateHelper", new Function0<h>() { // from class: com.tencent.mobileqq.guild.main.announcement.detail.aio.GuildAnnouncementHelperProvider$getLifeCycleHelperCreator$4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final h invoke() {
                return new ArticlePageNavigateHelper();
            }
        }), TuplesKt.to("GuildAIOChatBackgroundHelper", new Function0<h>() { // from class: com.tencent.mobileqq.guild.main.announcement.detail.aio.GuildAnnouncementHelperProvider$getLifeCycleHelperCreator$5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final h invoke() {
                return new d();
            }
        }));
        plus = MapsKt__MapsKt.plus(lifeCycleHelperCreator, mapOf);
        return plus;
    }
}
