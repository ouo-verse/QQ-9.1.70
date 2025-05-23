package com.tencent.mobileqq.guild.message.data;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildRoamMessageHandler;
import com.tencent.mobileqq.guild.navigatebar.GuildAioNavigateBarManager;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes33.dex */
public class b extends com.tencent.mobileqq.guild.message.base.c {
    @Override // com.tencent.mobileqq.guild.message.base.c
    public com.tencent.mobileqq.troop.navigatebar.c b(BaseMessageManager.a aVar) {
        return (com.tencent.mobileqq.troop.navigatebar.c) aVar.f116305j;
    }

    @Override // com.tencent.mobileqq.guild.message.base.c
    public String c(MessageRecord messageRecord) {
        return ((IPicHelper) QRoute.api(IPicHelper.class)).getMsgSummaryForAnimationPic((MessageForPic) messageRecord);
    }

    @Override // com.tencent.mobileqq.guild.message.base.c
    public boolean d(AppRuntime appRuntime, String str, long j3, long j16, boolean z16, Bundle bundle, int i3) {
        boolean isGuest = ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).isGuest(str);
        String string = bundle.getString("guild_id");
        if (isGuest) {
            QLog.i("GuildMessageManagerCallback", 1, "pullMsgFromUserRefresh. guildId: " + string + ", channelId: " + str + ", beginSeq: " + j3 + ", endSeq: " + j16);
            return ((st1.e) ((AppInterface) appRuntime).getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildPullMultiMsgHandlerName())).V1(string, str, j3, j16, bundle);
        }
        QLog.i("GuildMessageManagerCallback", 1, "reqPullRoamMsg. guildId: " + string + ", channelId: " + str + ", beginSeq: " + j3 + ", endSeq: " + j16);
        return ((IGuildRoamMessageHandler) ((AppInterface) appRuntime).getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildRoamMsgHandlerName())).reqPullRoamMsg(str, j3, j16, bundle);
    }

    @Override // com.tencent.mobileqq.guild.message.base.c
    public void e(AppRuntime appRuntime, String str, com.tencent.mobileqq.troop.data.c cVar, MessageRecord messageRecord, boolean z16) {
        com.tencent.mobileqq.guild.navigatebar.a.i((QQAppInterface) appRuntime, str, cVar, messageRecord, z16);
    }

    @Override // com.tencent.mobileqq.guild.message.base.c
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public GuildAioNavigateBarManager a(AppInterface appInterface) {
        return (GuildAioNavigateBarManager) appInterface.getManager(QQManagerFactory.GUILD_AIO_NAVIGATE_BAR);
    }
}
