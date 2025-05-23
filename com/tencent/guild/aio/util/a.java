package com.tencent.guild.aio.util;

import com.tencent.aio.data.AIOParam;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u0000\u001a\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007*\u00020\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001a\f\u0010\f\u001a\u0004\u0018\u00010\u000b*\u00020\u0000\u001a\n\u0010\u000e\u001a\u00020\r*\u00020\u0000\u001a\n\u0010\u000f\u001a\u00020\r*\u00020\u0000\u001a\n\u0010\u0010\u001a\u00020\r*\u00020\u0000\u001a\n\u0010\u0011\u001a\u00020\r*\u00020\u0000\u001a\f\u0010\u0013\u001a\u0004\u0018\u00010\u0012*\u00020\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/aio/data/AIOParam;", "", "b", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "a", "g", "f", "", "e", "d", "(Lcom/tencent/aio/data/AIOParam;)Ljava/lang/Integer;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "c", "", "k", "j", "l", "i", "Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", tl.h.F, "aio-guild_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {
    @NotNull
    public static final String a(@NotNull com.tencent.aio.part.root.panel.mvx.config.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        AIOParam g16 = cVar.a().g();
        Intrinsics.checkNotNullExpressionValue(g16, "mAIOContext.aioParam");
        return b(g16);
    }

    @NotNull
    public static final String b(@NotNull AIOParam aIOParam) {
        Intrinsics.checkNotNullParameter(aIOParam, "<this>");
        return aIOParam.r().c().j();
    }

    @Nullable
    public static final IGProChannelInfo c(@NotNull AIOParam aIOParam) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(aIOParam, "<this>");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService == null) {
            return null;
        }
        return iGPSService.getChannelInfo(b(aIOParam));
    }

    @Nullable
    public static final Integer d(@NotNull AIOParam aIOParam) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        IGProChannelInfo channelInfo;
        Intrinsics.checkNotNullParameter(aIOParam, "<this>");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService == null || (channelInfo = iGPSService.getChannelInfo(b(aIOParam))) == null) {
            return null;
        }
        return Integer.valueOf(channelInfo.getType());
    }

    public static final int e(@NotNull AIOParam aIOParam) {
        Intrinsics.checkNotNullParameter(aIOParam, "<this>");
        return aIOParam.r().c().e();
    }

    @NotNull
    public static final String f(@NotNull com.tencent.aio.part.root.panel.mvx.config.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        AIOParam g16 = cVar.a().g();
        Intrinsics.checkNotNullExpressionValue(g16, "mAIOContext.aioParam");
        return g(g16);
    }

    @NotNull
    public static final String g(@NotNull AIOParam aIOParam) {
        Intrinsics.checkNotNullParameter(aIOParam, "<this>");
        return aIOParam.r().c().f();
    }

    @Nullable
    public static final GuildAppReportSourceInfo h(@NotNull AIOParam aIOParam) {
        Intrinsics.checkNotNullParameter(aIOParam, "<this>");
        return (GuildAppReportSourceInfo) aIOParam.l().getParcelable("GuildAppReportSourceInfo");
    }

    public static final boolean i(@NotNull AIOParam aIOParam) {
        Intrinsics.checkNotNullParameter(aIOParam, "<this>");
        return ((IGuildChannelApi) QRoute.api(IGuildChannelApi.class)).isSelfGuest(b(aIOParam), g(aIOParam));
    }

    public static final boolean j(@NotNull AIOParam aIOParam) {
        Intrinsics.checkNotNullParameter(aIOParam, "<this>");
        Integer d16 = d(aIOParam);
        if (d16 != null && d16.intValue() == 5) {
            return true;
        }
        return false;
    }

    public static final boolean k(@NotNull AIOParam aIOParam) {
        Intrinsics.checkNotNullParameter(aIOParam, "<this>");
        Integer d16 = d(aIOParam);
        if (d16 != null && d16.intValue() == 1) {
            return true;
        }
        return false;
    }

    public static final boolean l(@NotNull AIOParam aIOParam) {
        Intrinsics.checkNotNullParameter(aIOParam, "<this>");
        Integer d16 = d(aIOParam);
        if (d16 != null && d16.intValue() == 2) {
            return true;
        }
        return false;
    }
}
