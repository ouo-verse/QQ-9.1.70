package com.tencent.guildlive.aio.halfpop.menu;

import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.halfpop.menu.x;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/guildlive/aio/halfpop/menu/a;", "Lcom/tencent/guild/aio/halfpop/menu/x;", "", "", "configType", "", "E", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "data", "", "t", "<init>", "()V", h.F, "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class a extends x {
    public a() {
        super(null, 1, null);
    }

    @Override // com.tencent.guild.aio.halfpop.menu.t
    public void E(@NotNull List<Integer> configType) {
        Intrinsics.checkNotNullParameter(configType, "configType");
        configType.add(6);
        configType.add(7);
        configType.add(23);
        configType.add(24);
        configType.add(28);
        configType.add(27);
    }

    @Override // com.tencent.guild.aio.halfpop.menu.ReplyActionItem, com.tencent.guild.aio.halfpop.menu.t, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: t */
    public boolean a(@NotNull GuildMsgItem data) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(data, "data");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Integer num = null;
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
        if (iGPSService != null) {
            num = Integer.valueOf(iGPSService.getSelfLiveChannelBanStatus(data.getMsgRecord().guildId, data.getMsgRecord().channelId));
        }
        QLog.i("GuildLiveReplyActionIte", 1, "[canShown] banStatus:" + num);
        if (super.a(data) && (num == null || num.intValue() != 2)) {
            return true;
        }
        return false;
    }
}
