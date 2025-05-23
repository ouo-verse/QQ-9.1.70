package com.tencent.guildlive.aio.msglist.holder.component;

import com.tencent.aio.data.AIOParam;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guildlive.aio.msglist.holder.component.f;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/holder/component/g;", "Lcom/tencent/guild/aio/msglist/holder/component/t;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "l", "Lol3/b;", "intent", "handleIntent", "<init>", "()V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class g extends com.tencent.guild.aio.msglist.holder.component.t {
    /* JADX WARN: Multi-variable type inference failed */
    private final void l(GuildMsgItem msgItem) {
        AppInterface appInterface;
        boolean z16;
        zo0.a aVar;
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        String g17 = com.tencent.guild.aio.util.a.g(g16);
        IGuildInfoUtilsApi iGuildInfoUtilsApi = (IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AIOParam g18 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
        boolean canTalkinChannel = iGuildInfoUtilsApi.canTalkinChannel(peekAppRuntime, g17, com.tencent.guild.aio.util.a.b(g18));
        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime2 instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime2;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            z16 = iGPSService.isGuest(g17);
        } else {
            z16 = true;
        }
        if (canTalkinChannel && !z16) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildLiveLongClickAvatar(msgItem));
            if (yr0.a.h(msgItem) && (aVar = ap0.f.guildRobotAtHelper) != null) {
                aVar.c(msgItem.getMsgRecord().senderUid);
            }
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.t, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.handleIntent(intent);
        if (intent instanceof f.a) {
            l(((f.a) intent).getMsgItem());
        }
    }
}
