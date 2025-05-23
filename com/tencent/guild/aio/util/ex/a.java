package com.tencent.guild.aio.util.ex;

import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.component.slowmode.GuildSlowModeEvent;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.mobileqq.guild.api.IGuildDirectMsgChannelApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.message.utils.IGuildDirectMsgUtilApi;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.k;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\u0012\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003\u001a\n\u0010\t\u001a\u00020\b*\u00020\u0000\u001a\n\u0010\n\u001a\u00020\b*\u00020\u0000\u001a\n\u0010\u000b\u001a\u00020\b*\u00020\u0000\u001a\n\u0010\f\u001a\u00020\b*\u00020\u0000\u001a\n\u0010\r\u001a\u00020\b*\u00020\u0000\u001a\n\u0010\u000e\u001a\u00020\b*\u00020\u0000\u001a\n\u0010\u000f\u001a\u00020\b*\u00020\u0000\u001a\n\u0010\u0010\u001a\u00020\b*\u00020\u0000\u001a\n\u0010\u0011\u001a\u00020\b*\u00020\u0000\u001a\n\u0010\u0012\u001a\u00020\b*\u00020\u0000\u001a\f\u0010\u0014\u001a\u0004\u0018\u00010\u0013*\u00020\u0000\"\u0015\u0010\u0018\u001a\u00020\u0015*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/guild/aio/util/ex/ContainerType;", "c", "", "d", "scene", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", DomainData.DOMAIN_NAME, "o", "b", "l", "j", "a", "i", tl.h.F, "k", "g", "Lcom/tencent/guild/aio/factory/b;", "e", "", "f", "(Lcom/tencent/aio/api/runtime/a;)Ljava/lang/String;", "sourceGuildId", "aio-guild_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {
    public static final boolean a(@NotNull com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return aVar.g().l().getBoolean("entrance_from_jubao");
    }

    public static final boolean b(@NotNull com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return aVar.g().l().getBoolean("From_SplashActivity");
    }

    @NotNull
    public static final ContainerType c(@NotNull com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        try {
            Serializable serializable = aVar.g().l().getSerializable("AIOParam_ContainerType");
            if (serializable == null) {
                serializable = ContainerType.NONE_TYPE;
            }
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.tencent.guild.aio.util.ex.ContainerType");
            return (ContainerType) serializable;
        } catch (Exception unused) {
            return ContainerType.NONE_TYPE;
        }
    }

    public static final int d(@NotNull com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return aVar.g().l().getInt("AIOParam_FromScene", FromScene.DEFAULT.ordinal());
    }

    @Nullable
    public static final com.tencent.guild.aio.factory.b e(@NotNull com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        com.tencent.aio.main.businesshelper.c h16 = aVar.h();
        if (h16 instanceof com.tencent.guild.aio.factory.b) {
            return (com.tencent.guild.aio.factory.b) h16;
        }
        return null;
    }

    @NotNull
    public static final String f(@NotNull com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (d(aVar) != FromScene.DIRECT.ordinal()) {
            AIOParam aioParam = aVar.g();
            Intrinsics.checkNotNullExpressionValue(aioParam, "aioParam");
            return com.tencent.guild.aio.util.a.g(aioParam);
        }
        QRouteApi api = QRoute.api(IGuildDirectMsgUtilApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildDirectMsgUtilApi::class.java)");
        AIOParam aioParam2 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(aioParam2, "aioParam");
        return String.valueOf(((IGuildDirectMsgUtilApi) api).getSourceGuildId(com.tencent.guild.aio.util.a.b(aioParam2)));
    }

    public static final boolean g(@NotNull com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (c(aVar) != ContainerType.MF_TYPE) {
            return true;
        }
        return ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).isAioFullyOpen();
    }

    public static final boolean h(@NotNull com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return ((IGuildDirectMsgChannelApi) QRoute.api(IGuildDirectMsgChannelApi.class)).isDirectMsgChannelFactoryName(aVar.g().n());
    }

    public static final boolean i(@NotNull com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (aVar.g().l().getInt(((IGuildRobotApi) QRoute.api(IGuildRobotApi.class)).getGuildDirectMsgTypeKey()) == 2) {
            return true;
        }
        return false;
    }

    public static final boolean j(@NotNull com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
        AIOParam aioParam = aVar.g();
        Intrinsics.checkNotNullExpressionValue(aioParam, "aioParam");
        String b16 = com.tencent.guild.aio.util.a.b(aioParam);
        AIOParam aioParam2 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(aioParam2, "aioParam");
        return iGuildChannelApi.isSelfGuest(b16, com.tencent.guild.aio.util.a.g(aioParam2));
    }

    public static final boolean k(@NotNull com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        k k3 = aVar.e().k(GuildSlowModeEvent.GetIsInSlowModeLimit.f110320d);
        if (!(k3 instanceof com.tencent.guild.aio.component.slowmode.e)) {
            return false;
        }
        return ((com.tencent.guild.aio.component.slowmode.e) k3).getIsLimited();
    }

    public static final boolean l(@NotNull com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        AIOParam aioParam = aVar.g();
        Intrinsics.checkNotNullExpressionValue(aioParam, "aioParam");
        return GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(com.tencent.guild.aio.util.a.b(aioParam), d(aVar)));
    }

    public static final void m(@NotNull com.tencent.aio.api.runtime.a aVar, int i3) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        aVar.g().l().putInt("AIOParam_FromScene", i3);
    }

    public static final boolean n(@NotNull com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        IQQGuildRouterApi iQQGuildRouterApi = (IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class);
        AIOParam aioParam = aVar.g();
        Intrinsics.checkNotNullExpressionValue(aioParam, "aioParam");
        return iQQGuildRouterApi.showNavigateTitle(com.tencent.guild.aio.util.a.g(aioParam));
    }

    public static final boolean o(@NotNull com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (aVar.g().l().getBoolean("SHOW_UnreadMsgCnt") || aVar.g().l().getInt(JumpGuildParam.EXTRA_KEY_CHANNEL_LOAD_FROM, -1) == 1) {
            return true;
        }
        return false;
    }
}
