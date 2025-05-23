package com.tencent.mobileqq.guild.recent.service.impl;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.BaseQQMessageFacade;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.guild.recent.service.IChannelRecentMsgService;
import com.tencent.mobileqq.guild.recent.service.IChannelRecentNotifyService;
import com.tencent.mobileqq.guild.recent.service.IChannelRecentUserApi;
import com.tencent.mobileqq.guild.summary.GuildSummaryData;
import com.tencent.mobileqq.guild.summary.api.IGuildSummaryApi;
import com.tencent.mobileqq.guild.summary.d;
import com.tencent.mobileqq.qqguildsdk.data.fk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class ChannelRecentMsgServiceImpl implements IChannelRecentMsgService {
    private static final String TAG = "ChannelRecentMsgServiceImpl";
    private AppRuntime mAppRuntime;
    private final d summaryUpdateCallback = new d() { // from class: com.tencent.mobileqq.guild.recent.service.impl.b
        @Override // com.tencent.mobileqq.guild.summary.d
        public final void a(List list) {
            ChannelRecentMsgServiceImpl.this.lambda$new$1(list);
        }
    };

    private void init() {
        ((IGuildSummaryApi) this.mAppRuntime.getRuntimeService(IGuildSummaryApi.class, "")).registerSummaryUpdateCallback(this.summaryUpdateCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(List list) {
        IChannelRecentUserApi iChannelRecentUserApi = (IChannelRecentUserApi) QRoute.api(IChannelRecentUserApi.class);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            GuildSummaryData guildSummaryData = (GuildSummaryData) it.next();
            fk qQMsgListChannel = iChannelRecentUserApi.getQQMsgListChannel(this.mAppRuntime, guildSummaryData.getGuildId(), guildSummaryData.getChannelId());
            if (qQMsgListChannel != null) {
                updateRecentUserFromLastMsgChanged(this.mAppRuntime, guildSummaryData, qQMsgListChannel);
                new Bundle().putString("channelId", guildSummaryData.getChannelId());
                ((IChannelRecentNotifyService) this.mAppRuntime.getRuntimeService(IChannelRecentNotifyService.class, "")).refreshRecentListForLastMsgChanged(guildSummaryData.getLastMessage());
                ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) this.mAppRuntime).K0(new BaseQQMessageFacade.a(guildSummaryData.getChannelId(), 10014, 1, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(final List list) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.recent.service.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                ChannelRecentMsgServiceImpl.this.lambda$new$0(list);
            }
        });
    }

    private void updateRecentUserFromLastMsgChanged(AppRuntime appRuntime, GuildSummaryData guildSummaryData, fk fkVar) {
        if (appRuntime != null && guildSummaryData.getLastMessage() != null && fkVar != null) {
            RecentUserProxy recentUserProxy = ((IChannelRecentUserApi) QRoute.api(IChannelRecentUserApi.class)).getRecentUserProxy(appRuntime);
            RecentUser findRecentUser = recentUserProxy.findRecentUser(guildSummaryData.getLastMessage().getChannelId(), 10014);
            if (findRecentUser == null) {
                QLog.d(TAG, 1, "recent user not in recent list. channelId = " + guildSummaryData.getLastMessage().getChannelId());
                return;
            }
            long time = guildSummaryData.getLastMessage().getTime();
            if (time == 0) {
                QLog.d(TAG, 1, "all time zero. return. channelId = " + guildSummaryData.getLastMessage().getChannelId());
                return;
            }
            if (findRecentUser.lastmsgtime > time) {
                QLog.d(TAG, 1, "judge time failed. return. channelId = " + guildSummaryData.getLastMessage().getChannelId());
                return;
            }
            findRecentUser.setType(10014);
            findRecentUser.displayName = fkVar.getChannelName();
            findRecentUser.lastmsgtime = Math.max(findRecentUser.lastmsgtime, time);
            if (guildSummaryData.getDraftInfo() != null && guildSummaryData.getDraftInfo().getHasDraft()) {
                findRecentUser.lastmsgdrafttime = guildSummaryData.getDraftInfo().getTime();
            } else {
                findRecentUser.lastmsgdrafttime = 0L;
            }
            findRecentUser.showUpTime = fkVar.getTopTimestamp() / 1000;
            findRecentUser.extraInfo = guildSummaryData;
            findRecentUser.troopUin = fkVar.getGuildId();
            recentUserProxy.saveRecentUser(findRecentUser);
            return;
        }
        QLog.e(TAG, 1, "updateRecentUserFromMsg args error!");
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mAppRuntime = appRuntime;
        init();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        ((IGuildSummaryApi) this.mAppRuntime.getRuntimeService(IGuildSummaryApi.class, "")).unregisterSummaryUpdateCallback(this.summaryUpdateCallback);
    }
}
