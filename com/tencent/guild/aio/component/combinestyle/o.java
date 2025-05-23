package com.tencent.guild.aio.component.combinestyle;

import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.component.combinestyle.n;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/guild/aio/component/combinestyle/o;", "Lcom/tencent/guild/aio/msglist/holder/component/t;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "l", "Lol3/b;", "intent", "handleIntent", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class o extends com.tencent.guild.aio.msglist.holder.component.t {
    /* JADX WARN: Multi-variable type inference failed */
    private final void l(GuildMsgItem msgItem) {
        zo0.a aVar;
        IGuildInfoUtilsApi iGuildInfoUtilsApi = (IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        String g17 = com.tencent.guild.aio.util.a.g(g16);
        AIOParam g18 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
        if (iGuildInfoUtilsApi.canTalkinChannel(peekAppRuntime, g17, com.tencent.guild.aio.util.a.b(g18))) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMediaLongClickAvatar(msgItem));
            if (com.tencent.guild.aio.util.h.f112401a.x(msgItem) && (aVar = ap0.f.guildRobotAtHelper) != null) {
                aVar.c(msgItem.getMsgRecord().senderUid);
            }
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.t, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.handleIntent(intent);
        if (intent instanceof n.a) {
            l(((n.a) intent).getMsgItem());
        }
    }
}
