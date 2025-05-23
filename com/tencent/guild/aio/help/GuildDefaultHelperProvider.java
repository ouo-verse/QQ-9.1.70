package com.tencent.guild.aio.help;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.guild.api.IGuildAioHelperFactoryApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\"\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/guild/aio/help/GuildDefaultHelperProvider;", "Lcom/tencent/guild/aio/help/BaseGuildHelperProvider;", "Lcom/tencent/aio/api/help/a;", "param", "", "", "Lkotlin/Function0;", "Lcom/tencent/aio/main/businesshelper/h;", "getLifeCycleHelperCreator", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class GuildDefaultHelperProvider extends BaseGuildHelperProvider {
    @Override // com.tencent.guild.aio.help.BaseGuildHelperProvider, com.tencent.aio.api.help.d
    @NotNull
    public Map<String, Function0<com.tencent.aio.main.businesshelper.h>> getLifeCycleHelperCreator(@NotNull com.tencent.aio.api.help.a param) {
        Map mapOf;
        Map<String, Function0<com.tencent.aio.main.businesshelper.h>> plus;
        Intrinsics.checkNotNullParameter(param, "param");
        Map<String, Function0<com.tencent.aio.main.businesshelper.h>> lifeCycleHelperCreator = super.getLifeCycleHelperCreator(param);
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("LocalFocusHelper", new Function0<q>() { // from class: com.tencent.guild.aio.help.GuildDefaultHelperProvider$getLifeCycleHelperCreator$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final q invoke() {
                return new q();
            }
        }), TuplesKt.to("MsgReadedHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.guild.aio.help.GuildDefaultHelperProvider$getLifeCycleHelperCreator$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new MsgReadedHelper();
            }
        }), TuplesKt.to("GuildAppAuthorHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.guild.aio.help.GuildDefaultHelperProvider$getLifeCycleHelperCreator$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new h();
            }
        }), TuplesKt.to("GuildMissionHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.guild.aio.help.GuildDefaultHelperProvider$getLifeCycleHelperCreator$4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new l();
            }
        }), TuplesKt.to("HeartBeatReportHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.guild.aio.help.GuildDefaultHelperProvider$getLifeCycleHelperCreator$5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new p();
            }
        }), TuplesKt.to("GuildAIOStatusHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.guild.aio.help.GuildDefaultHelperProvider$getLifeCycleHelperCreator$6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new g();
            }
        }), TuplesKt.to("GuildAIODTReportHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.guild.aio.help.GuildDefaultHelperProvider$getLifeCycleHelperCreator$7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new e();
            }
        }), TuplesKt.to("GuildAIOSampleReportHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.guild.aio.help.GuildDefaultHelperProvider$getLifeCycleHelperCreator$8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new f();
            }
        }), TuplesKt.to("MsgPreloadHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.guild.aio.help.GuildDefaultHelperProvider$getLifeCycleHelperCreator$9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new s();
            }
        }), TuplesKt.to("GuildSpeakRuleTipsHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.guild.aio.help.GuildDefaultHelperProvider$getLifeCycleHelperCreator$10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new n();
            }
        }), TuplesKt.to("GuildGiftHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.guild.aio.help.GuildDefaultHelperProvider$getLifeCycleHelperCreator$11
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new k();
            }
        }), TuplesKt.to("GuildDynamicPIcHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.guild.aio.help.GuildDefaultHelperProvider$getLifeCycleHelperCreator$12
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new GuildDynamicPIcHelper();
            }
        }), TuplesKt.to("VisitorJoinGuildDialogHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.guild.aio.help.GuildDefaultHelperProvider$getLifeCycleHelperCreator$13
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new w();
            }
        }), TuplesKt.to("GuildAIOChatBackgroundHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.guild.aio.help.GuildDefaultHelperProvider$getLifeCycleHelperCreator$14
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new d();
            }
        }), TuplesKt.to("GuildArkContainerHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.guild.aio.help.GuildDefaultHelperProvider$getLifeCycleHelperCreator$15
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new GuildArkContainerHelper();
            }
        }), TuplesKt.to("GuildAIOAnimationHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.guild.aio.help.GuildDefaultHelperProvider$getLifeCycleHelperCreator$16
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return ((IGuildAioHelperFactoryApi) QRoute.api(IGuildAioHelperFactoryApi.class)).getAioAnimatorHelper();
            }
        }));
        plus = MapsKt__MapsKt.plus(lifeCycleHelperCreator, com.tencent.guild.aio.util.ex.h.a(mapOf, com.tencent.mobileqq.springhb.interactive.b.f289214a.b(param)));
        return plus;
    }
}
