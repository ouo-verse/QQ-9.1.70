package com.tencent.mobileqq.guild.recent.service.impl;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.message.lastmsg.GuildLastMsgItem;
import com.tencent.mobileqq.guild.message.lastmsg.api.IGuildLastMsgService;
import com.tencent.mobileqq.guild.recent.service.IChannelRecentNotifyService;
import com.tencent.mobileqq.guild.recent.service.IChannelRecentUserApi;
import com.tencent.mobileqq.guild.summary.GuildSummaryData;
import com.tencent.mobileqq.guild.summary.api.IGuildSummaryApi;
import com.tencent.mobileqq.guild.util.GuildChannelIconUtil;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.fk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import vh2.cc;

/* compiled from: P */
/* loaded from: classes14.dex */
public class ChannelRecentUserApiImpl implements IChannelRecentUserApi {
    private static final long REFRESH_MSG_TAB_NUM_DELAY_TIME = 300;
    private static final String TAG = "ChannelRecentUserApiImpl";

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppRuntime f231952d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f231953e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f231954f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f231955h;

        b(AppRuntime appRuntime, Context context, String str, String str2) {
            this.f231952d = appRuntime;
            this.f231953e = context;
            this.f231954f = str;
            this.f231955h = str2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ChannelRecentUserApiImpl.this.sendCancelSubScribeReqToSvr(this.f231952d, this.f231953e, this.f231954f, this.f231955h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements cc {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f231957a;

        c(Context context) {
            this.f231957a = context;
        }

        @Override // vh2.cc
        public void onResult(int i3, String str) {
            if (i3 == 0) {
                QQToast.makeText(this.f231957a, 2, R.string.f152741a8, 0).show();
                return;
            }
            QLog.d(ChannelRecentUserApiImpl.TAG, 1, "sendCancelSubScribeReqToSvr result = " + i3 + " errorMsg = " + str);
        }
    }

    private void handleAudioRecentUserDataUpdate(IGProChannelInfo iGProChannelInfo, RecentUser recentUser) {
        if (recentUser.lastmsgtime == 0) {
            recentUser.lastmsgtime = iGProChannelInfo.getCreateTime();
        }
    }

    private void handleBusinessRecentUserDataUpdate(AppRuntime appRuntime, String str, RecentUser recentUser) {
        IGProChannelInfo channelInfo;
        if (appRuntime == null || (channelInfo = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getChannelInfo(str)) == null) {
            return;
        }
        if (channelInfo.getType() == 5) {
            handleLiveRecentUserDataUpdate(channelInfo, recentUser);
        } else if (channelInfo.getType() == 2) {
            handleAudioRecentUserDataUpdate(channelInfo, recentUser);
        }
    }

    private void handleLiveRecentUserDataUpdate(IGProChannelInfo iGProChannelInfo, RecentUser recentUser) {
        if (recentUser.lastmsgtime == 0) {
            recentUser.lastmsgtime = iGProChannelInfo.getCreateTime();
        }
    }

    private void refreshMsgTabUnreadNumDelay(final AppRuntime appRuntime, long j3) {
        if (appRuntime != null) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.recent.service.impl.ChannelRecentUserApiImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).refreshMsgTabUnreadNum(appRuntime);
                }
            }, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCancelSubScribeReqToSvr(AppRuntime appRuntime, Context context, String str, String str2) {
        ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).setQQMsgListChannel(str, str2, 2, new c(context));
    }

    @Override // com.tencent.mobileqq.guild.recent.service.IChannelRecentUserApi
    public void cancelSubscribeChannel(AppRuntime appRuntime, Context context, String str, String str2) {
        if (appRuntime != null && context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            QQCustomDialog message = DialogUtil.createCustomDialog(context, 230).setMessage(context.getString(R.string.f152721a6));
            message.setNegativeButton(context.getString(R.string.f140850f3), new a());
            message.setPositiveButton(context.getString(R.string.f152731a7), new b(appRuntime, context, str, str2));
            try {
                message.show();
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        QLog.d(TAG, 1, "cancelSubscribeChannel args error! guildId = " + str + " channelId = " + str2);
    }

    @Override // com.tencent.mobileqq.guild.recent.service.IChannelRecentUserApi
    public boolean channelIsInRecentUserCache(AppRuntime appRuntime, String str) {
        if (getRecentUserProxy(appRuntime).findRecentUser(str, 10014) != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.recent.service.IChannelRecentUserApi
    public int getChannelTypeIcon(int i3) {
        return GuildChannelIconUtil.g(i3);
    }

    @Override // com.tencent.mobileqq.guild.recent.service.IChannelRecentUserApi
    public fk getQQMsgListChannel(AppRuntime appRuntime, String str, String str2) {
        if (appRuntime != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            IGPSService iGPSService = (IGPSService) appRuntime.getRuntimeService(IGPSService.class, "");
            if (!iGPSService.isQQMsgListChannel(str, str2)) {
                return null;
            }
            return iGPSService.getQQMsgListChannel(str, str2);
        }
        QLog.d(TAG, 1, "getQQMsgListChannel args error!");
        return null;
    }

    @Override // com.tencent.mobileqq.guild.recent.service.IChannelRecentUserApi
    public RecentUserProxy getRecentUserProxy(AppRuntime appRuntime) {
        return ((IRecentUserProxyService) appRuntime.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    }

    @Override // com.tencent.mobileqq.guild.recent.service.IChannelRecentUserApi
    public String getWelcomeMsgForRecentList(AppRuntime appRuntime, String str) {
        return "\u6b22\u8fce\u6765\u5230 " + str;
    }

    @Override // com.tencent.mobileqq.guild.recent.service.IChannelRecentUserApi
    public void refreshMsgListChannelForRecentList(AppRuntime appRuntime) {
        String str;
        String guildId;
        boolean z16;
        QLog.d(TAG, 1, "refreshMsgListChannelForRecentList");
        String str2 = "";
        IGPSService iGPSService = (IGPSService) appRuntime.getRuntimeService(IGPSService.class, "");
        RecentUserProxy recentUserProxy = ((IChannelRecentUserApi) QRoute.api(IChannelRecentUserApi.class)).getRecentUserProxy(appRuntime);
        for (RecentUser recentUser : recentUserProxy.getRecentList(false)) {
            if (recentUser.getType() == 10014 && !iGPSService.isQQMsgListChannel(recentUser.troopUin, recentUser.uin)) {
                recentUserProxy.delRecentUser(recentUser);
                QLog.d(TAG, 1, "refreshMsgListChannelForRecentList del channelId = " + recentUser.uin);
            }
        }
        IGuildSummaryApi iGuildSummaryApi = (IGuildSummaryApi) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGuildSummaryApi.class);
        List<fk> qQMsgListChannels = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getQQMsgListChannels();
        QLog.d(TAG, 1, "addToRecentUser channelList size = " + qQMsgListChannels.size());
        for (fk fkVar : qQMsgListChannels) {
            GuildSummaryData summary = iGuildSummaryApi.getSummary(fkVar.getGuildId(), fkVar.getChannelId(), false);
            RecentUser findRecentUserByUin = recentUserProxy.findRecentUserByUin(fkVar.getChannelId(), 10014);
            if (summary.getDraftInfo() != null && summary.getDraftInfo().getHasDraft()) {
                str = str2;
                findRecentUserByUin.lastmsgdrafttime = summary.getDraftInfo().getTime();
            } else {
                str = str2;
                findRecentUserByUin.lastmsgdrafttime = 0L;
            }
            if (summary.getLastMessage() != null) {
                findRecentUserByUin.lastmsgtime = summary.getLastMessage().getTime();
            }
            findRecentUserByUin.extraInfo = summary;
            if (TextUtils.isEmpty(summary.getGuildId())) {
                guildId = fkVar.getGuildId();
            } else {
                guildId = summary.getGuildId();
            }
            findRecentUserByUin.troopUin = guildId;
            findRecentUserByUin.showUpTime = fkVar.getTopTimestamp() / 1000;
            findRecentUserByUin.displayName = fkVar.getChannelName();
            handleBusinessRecentUserDataUpdate(appRuntime, fkVar.getChannelId(), findRecentUserByUin);
            recentUserProxy.saveRecentUser(findRecentUserByUin);
            QLog.d(TAG, 1, "refreshMsgListChannelForRecentList saveRecentUser channelId = " + findRecentUserByUin.uin);
            if (findRecentUserByUin.lastmsgtime <= 0) {
                z16 = true;
                QLog.d(TAG, 1, "addToRecentUser channelId = " + fkVar.getChannelId() + " time <= 0");
            } else {
                z16 = true;
            }
            str2 = str;
        }
        ((IChannelRecentNotifyService) appRuntime.getRuntimeService(IChannelRecentNotifyService.class, str2)).refreshRecentList(2, null);
    }

    @Override // com.tencent.mobileqq.guild.recent.service.IChannelRecentUserApi
    public boolean tryToAddAndShowChannelInRecentList(AppRuntime appRuntime, fk fkVar) {
        String guildId;
        QLog.d(TAG, 1, "tryToAddAndShowChannelInRecentList channelId = " + fkVar.getChannelId());
        RecentUserProxy recentUserProxy = ((IChannelRecentUserApi) QRoute.api(IChannelRecentUserApi.class)).getRecentUserProxy(appRuntime);
        if (recentUserProxy.findRecentUser(fkVar.getChannelId(), 10014) != null) {
            QLog.d(TAG, 1, "tryToAddAndShowChannelInRecentList exist! channelId = " + fkVar.getChannelId());
            return false;
        }
        GuildSummaryData summary = ((IGuildSummaryApi) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGuildSummaryApi.class)).getSummary(fkVar.getGuildId(), fkVar.getChannelId(), false);
        RecentUser recentUser = new RecentUser(fkVar.getChannelId(), 10014);
        if (summary.getDraftInfo() != null && summary.getDraftInfo().getHasDraft()) {
            recentUser.lastmsgdrafttime = summary.getDraftInfo().getTime();
        } else {
            recentUser.lastmsgdrafttime = 0L;
        }
        if (summary.getLastMessage() != null) {
            recentUser.lastmsgtime = summary.getLastMessage().getTime();
        }
        recentUser.extraInfo = summary;
        if (TextUtils.isEmpty(summary.getGuildId())) {
            guildId = fkVar.getGuildId();
        } else {
            guildId = summary.getGuildId();
        }
        recentUser.troopUin = guildId;
        recentUser.showUpTime = fkVar.getTopTimestamp() / 1000;
        recentUser.displayName = fkVar.getChannelName();
        handleBusinessRecentUserDataUpdate(appRuntime, fkVar.getChannelId(), recentUser);
        QLog.d(TAG, 1, "tryToAddAndShowChannelInRecentList add! channelId = " + fkVar.getChannelId());
        recentUserProxy.saveRecentUser(recentUser);
        refreshMsgTabUnreadNumDelay(appRuntime, 300L);
        ((IChannelRecentNotifyService) appRuntime.getRuntimeService(IChannelRecentNotifyService.class, "")).refreshRecentList(2, null);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.recent.service.IChannelRecentUserApi
    public void tryToAddChannelsInRecentList(AppRuntime appRuntime, List<fk> list) {
        long j3;
        if (list != null && !list.isEmpty()) {
            IGPSService iGPSService = (IGPSService) appRuntime.getRuntimeService(IGPSService.class, "");
            RecentUserProxy recentUserProxy = ((IChannelRecentUserApi) QRoute.api(IChannelRecentUserApi.class)).getRecentUserProxy(appRuntime);
            IGuildLastMsgService iGuildLastMsgService = (IGuildLastMsgService) appRuntime.getRuntimeService(IGuildLastMsgService.class, "");
            boolean z16 = false;
            for (fk fkVar : list) {
                if (iGPSService.isQQMsgListChannel(fkVar.getGuildId(), fkVar.getChannelId()) && recentUserProxy.findRecentUser(fkVar.getChannelId(), 10014) == null) {
                    GuildLastMsgItem lastMsgItem = iGuildLastMsgService.getLastMsgItem(fkVar.getChannelId(), true);
                    RecentUser recentUser = new RecentUser(fkVar.getChannelId(), 10014);
                    Message message = lastMsgItem.message;
                    if (message != null) {
                        j3 = message.time;
                    } else {
                        j3 = 0;
                    }
                    recentUser.lastmsgdrafttime = lastMsgItem.draftTime;
                    recentUser.lastmsgtime = j3;
                    recentUser.extraInfo = lastMsgItem;
                    recentUser.troopUin = fkVar.getGuildId();
                    recentUser.showUpTime = fkVar.getTopTimestamp() / 1000;
                    recentUser.displayName = fkVar.getChannelName();
                    handleBusinessRecentUserDataUpdate(appRuntime, fkVar.getChannelId(), recentUser);
                    recentUserProxy.saveRecentUser(recentUser);
                    z16 = true;
                } else {
                    QLog.d(TAG, 1, "tryToAddChannelsInRecentList not add channel channelId = " + fkVar.getChannelId());
                }
            }
            if (z16) {
                ((IChannelRecentNotifyService) appRuntime.getRuntimeService(IChannelRecentNotifyService.class, "")).refreshRecentList(2, null);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.recent.service.IChannelRecentUserApi
    public boolean tryToRefreshChannelInRecentList(AppRuntime appRuntime, fk fkVar) {
        RecentUserProxy recentUserProxy = ((IChannelRecentUserApi) QRoute.api(IChannelRecentUserApi.class)).getRecentUserProxy(appRuntime);
        RecentUser findRecentUser = recentUserProxy.findRecentUser(fkVar.getChannelId(), 10014);
        if (findRecentUser == null) {
            return false;
        }
        findRecentUser.extraInfo = ((IGuildSummaryApi) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGuildSummaryApi.class)).getSummary(fkVar.getGuildId(), fkVar.getChannelId(), false);
        findRecentUser.showUpTime = fkVar.getTopTimestamp() / 1000;
        findRecentUser.displayName = fkVar.getChannelName();
        handleBusinessRecentUserDataUpdate(appRuntime, fkVar.getChannelId(), findRecentUser);
        recentUserProxy.saveRecentUser(findRecentUser);
        Bundle bundle = new Bundle();
        bundle.putString("channelId", fkVar.getChannelId());
        ((IChannelRecentNotifyService) appRuntime.getRuntimeService(IChannelRecentNotifyService.class, "")).refreshRecentList(0, bundle);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.recent.service.IChannelRecentUserApi
    public boolean tryToRemoveChannelInRecentUserCache(AppRuntime appRuntime, String str) {
        QLog.d(TAG, 1, "tryToRemoveChannelInRecentUserCache channelId = " + str);
        RecentUserProxy recentUserProxy = getRecentUserProxy(appRuntime);
        RecentUser findRecentUser = recentUserProxy.findRecentUser(str, 10014);
        if (findRecentUser != null) {
            QLog.d(TAG, 1, "tryToRemoveChannelInRecentUserCache delRecentUser uin = " + findRecentUser.uin + " type = " + findRecentUser.type);
            recentUserProxy.delRecentUser(findRecentUser);
            refreshMsgTabUnreadNumDelay(appRuntime, 300L);
            return true;
        }
        QLog.d(TAG, 1, "tryToRemoveChannelInRecentUserCache error! channelId = " + str);
        return false;
    }

    @Override // com.tencent.mobileqq.guild.recent.service.IChannelRecentUserApi
    public boolean tryToSetTopChannelInRecentUserCache(AppRuntime appRuntime, String str, long j3) {
        RecentUserProxy recentUserProxy = getRecentUserProxy(appRuntime);
        RecentUser findRecentUser = recentUserProxy.findRecentUser(str, 10014);
        if (findRecentUser != null) {
            findRecentUser.showUpTime = j3;
            recentUserProxy.saveRecentUser(findRecentUser);
            return true;
        }
        QLog.d(TAG, 1, "tryToSetTopChannelInRecentUserCache error! channelId = " + str);
        return false;
    }

    @Override // com.tencent.mobileqq.guild.recent.service.IChannelRecentUserApi
    public boolean tryToUnsetTopChannelInRecentUserCache(AppRuntime appRuntime, String str) {
        RecentUserProxy recentUserProxy = getRecentUserProxy(appRuntime);
        RecentUser findRecentUser = recentUserProxy.findRecentUser(str, 10014);
        if (findRecentUser != null) {
            findRecentUser.showUpTime = 0L;
            recentUserProxy.saveRecentUser(findRecentUser);
            return true;
        }
        QLog.d(TAG, 1, "tryToUnsetTopChannelInRecentUserCache error! channelId = " + str);
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
