package com.tencent.mobileqq.guild.channel.managev2.container;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.util.GuildDebugUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/container/h;", "", "", "guildId", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Lcom/tencent/mobileqq/guild/channel/managev2/container/f;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f215153a = new h();

    h() {
    }

    @JvmStatic
    @NotNull
    public static final f a(@NotNull String guildId, @NotNull IGProChannelInfo channelInfo) {
        List emptyList;
        Boolean bool;
        Pair pair;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        int type = channelInfo.getType();
        if (type != 1) {
            if (type != 2) {
                if (type != 5) {
                    if (type == 7) {
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                        boolean contains = emptyList.contains(guildId);
                        r rVar = r.f214743a;
                        String str = "";
                        IRuntimeService S0 = ch.S0(IGPSService.class, "");
                        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
                        IGProGuildInfo guildInfo = ((IGPSService) S0).getGuildInfo(guildId);
                        if (guildInfo != null) {
                            bool = Boolean.valueOf(guildInfo.isMovePostSection());
                        } else {
                            bool = null;
                        }
                        if (contains) {
                            pair = TuplesKt.to(Boolean.TRUE, "HardCode");
                        } else if (bool == null) {
                            pair = TuplesKt.to(Boolean.FALSE, "NullGuildInfo");
                        } else {
                            pair = TuplesKt.to(bool, "GuildInfo");
                        }
                        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
                        String str2 = guildDebugUtils.e().get(guildId);
                        if (str2 != null) {
                            str = str2;
                        }
                        Intrinsics.checkNotNullExpressionValue(str, "newFeedSquareResults.get(guildId) ?: \"\"");
                        String pair2 = pair.toString();
                        if (!Intrinsics.areEqual(str, pair2)) {
                            Logger logger = Logger.f235387a;
                            if (QLog.isColorLevel()) {
                                logger.d().d("GUILD_DEBUG", 2, "isNewFeedSquare " + guildId + MsgSummary.STR_COLON + pair2);
                            }
                            guildDebugUtils.e().put(guildId, pair2);
                        }
                        if (((Boolean) pair.getFirst()).booleanValue()) {
                            return new d();
                        }
                        return new e();
                    }
                    return new a(channelInfo);
                }
                return new j();
            }
            return new b();
        }
        return new i();
    }
}
