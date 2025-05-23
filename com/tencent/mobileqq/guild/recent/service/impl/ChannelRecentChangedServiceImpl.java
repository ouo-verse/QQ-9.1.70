package com.tencent.mobileqq.guild.recent.service.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.guild.guildtab.IGuildUserService;
import com.tencent.mobileqq.guild.recent.service.IChannelRecentChangedService;
import com.tencent.mobileqq.guild.recent.service.IChannelRecentNotifyService;
import com.tencent.mobileqq.guild.recent.service.IChannelRecentUserApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.fk;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import uh2.e;

/* compiled from: P */
/* loaded from: classes14.dex */
public class ChannelRecentChangedServiceImpl implements IChannelRecentChangedService {
    private static final String TAG = "ChannelRecentChangedServiceImpl";
    private AppRuntime mAppRuntime;
    private final AtomicBoolean mRefreshRecentListFlag = new AtomicBoolean(false);
    private final GPServiceObserver mGPServiceObserver = new a();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends GPServiceObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(String str, int i3) {
            QLog.d(ChannelRecentChangedServiceImpl.TAG, 1, "onBeKickFromGuild onBeKickFromGuild = " + str + " black = " + i3);
            ChannelRecentChangedServiceImpl.this.handleExitGuild(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(String str) {
            ChannelRecentChangedServiceImpl.this.handleChannelInfoUpdated(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(String str) {
            QLog.d(ChannelRecentChangedServiceImpl.TAG, 1, "onDestoryGuild guildId = " + str);
            ChannelRecentChangedServiceImpl.this.handleExitGuild(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(String str) {
            ChannelRecentChangedServiceImpl.this.handleGuildInfoUpdated(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onPushChannelDestroy(String str, List<String> list) {
            ChannelRecentChangedServiceImpl.this.handlePushChannelDestroy(str, list);
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onQQMsgListChannelDataReady() {
            if (ChannelRecentChangedServiceImpl.this.mRefreshRecentListFlag.compareAndSet(false, true)) {
                ((IChannelRecentUserApi) QRoute.api(IChannelRecentUserApi.class)).refreshMsgListChannelForRecentList(ChannelRecentChangedServiceImpl.this.mAppRuntime);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onQQMsgListChannelUpdated(List<Integer> list, List<fk> list2) {
            boolean z16 = false;
            for (int i3 = 0; i3 < list.size(); i3++) {
                QLog.d(ChannelRecentChangedServiceImpl.TAG, 1, "operator = " + list.get(i3) + "channelId = " + list2.get(i3).getChannelId());
                int intValue = list.get(i3).intValue();
                if (intValue == -1) {
                    z16 = ChannelRecentChangedServiceImpl.this.handleUnSetTopChannelInRecentList(list2.get(i3));
                } else if (intValue == 1) {
                    z16 = ChannelRecentChangedServiceImpl.this.handleAddChannelToRecentList(list2.get(i3));
                } else if (intValue == 2) {
                    z16 = ChannelRecentChangedServiceImpl.this.handleDeleteChannelFromRecentList(list2.get(i3));
                } else if (intValue == 3) {
                    z16 = ChannelRecentChangedServiceImpl.this.handleSetTopChannelInRecentList(list2.get(i3));
                } else if (intValue == 4) {
                    z16 = ChannelRecentChangedServiceImpl.this.handleRefreshChannelInRecentList(list2.get(i3));
                }
            }
            if (z16) {
                ((IChannelRecentNotifyService) ChannelRecentChangedServiceImpl.this.mAppRuntime.getRuntimeService(IChannelRecentNotifyService.class, "")).refreshRecentList(2, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(String str) {
            QLog.d(ChannelRecentChangedServiceImpl.TAG, 1, "onRemoveGuild guildId = " + str);
            ChannelRecentChangedServiceImpl.this.handleExitGuild(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleAddChannelToRecentList(fk fkVar) {
        ((IChannelRecentUserApi) QRoute.api(IChannelRecentUserApi.class)).tryToAddAndShowChannelInRecentList(this.mAppRuntime, fkVar);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleChannelInfoUpdated(String str) {
        IGProChannelInfo channelInfo = ((IGPSService) this.mAppRuntime.getRuntimeService(IGPSService.class, "")).getChannelInfo(str);
        if (channelInfo == null) {
            QLog.d(TAG, 1, "handleChannelInfoUpdated channelInfo is null channelId = " + str);
            return;
        }
        e eVar = (e) this.mAppRuntime.getRuntimeService(IGPSService.class, "");
        RecentUserProxy recentUserProxy = ((IChannelRecentUserApi) QRoute.api(IChannelRecentUserApi.class)).getRecentUserProxy(this.mAppRuntime);
        if (eVar.isQQMsgListChannel(channelInfo.getGuildId(), str)) {
            RecentUser findRecentUser = recentUserProxy.findRecentUser(str, 10014);
            if (findRecentUser != null && !TextUtils.isEmpty(channelInfo.getChannelName()) && !channelInfo.getChannelName().equals(findRecentUser.displayName)) {
                findRecentUser.displayName = channelInfo.getChannelName();
                recentUserProxy.saveRecentUser(findRecentUser);
                Bundle bundle = new Bundle();
                bundle.putString("channelId", str);
                ((IChannelRecentNotifyService) this.mAppRuntime.getRuntimeService(IChannelRecentNotifyService.class, "")).refreshRecentList(0, bundle);
                return;
            }
            QLog.d(TAG, 1, "not show in recentlist, update channel info return");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleDeleteChannelFromRecentList(fk fkVar) {
        return ((IChannelRecentUserApi) QRoute.api(IChannelRecentUserApi.class)).tryToRemoveChannelInRecentUserCache(this.mAppRuntime, fkVar.getChannelId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleExitGuild(String str) {
        RecentUserProxy recentUserProxy = ((IChannelRecentUserApi) QRoute.api(IChannelRecentUserApi.class)).getRecentUserProxy(this.mAppRuntime);
        boolean z16 = false;
        for (RecentUser recentUser : recentUserProxy.getRecentList(false)) {
            if (TextUtils.equals(recentUser.troopUin, str)) {
                QLog.d(TAG, 1, "handleExitGuild delRecentUser id = " + recentUser.uin + " " + recentUser.troopUin);
                recentUserProxy.delRecentUser(recentUser);
                z16 = true;
            }
        }
        if (z16) {
            ((IChannelRecentNotifyService) this.mAppRuntime.getRuntimeService(IChannelRecentNotifyService.class, "")).refreshRecentList(2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleGuildInfoUpdated(String str) {
        RecentUserProxy recentUserProxy = ((IChannelRecentUserApi) QRoute.api(IChannelRecentUserApi.class)).getRecentUserProxy(this.mAppRuntime);
        IGPSService iGPSService = (IGPSService) this.mAppRuntime.getRuntimeService(IGPSService.class, "");
        List<IGProChannelInfo> channelList = iGPSService.getChannelList(str);
        ArrayList arrayList = new ArrayList();
        for (IGProChannelInfo iGProChannelInfo : channelList) {
            if (iGProChannelInfo == null) {
                QLog.d(TAG, 1, "handleGuildInfoUpdated channelInfo null guildId = " + str);
            } else if (iGPSService.isQQMsgListChannel(str, iGProChannelInfo.getChannelUin()) && recentUserProxy.findRecentUser(iGProChannelInfo.getChannelUin(), 10014) != null) {
                arrayList.add(iGProChannelInfo);
            }
        }
        if (arrayList.size() == 1) {
            Bundle bundle = new Bundle();
            bundle.putString("channelId", ((IGProChannelInfo) arrayList.get(0)).getChannelUin());
            ((IChannelRecentNotifyService) this.mAppRuntime.getRuntimeService(IChannelRecentNotifyService.class, "")).refreshRecentList(0, bundle);
        } else if (arrayList.size() > 1) {
            ((IChannelRecentNotifyService) this.mAppRuntime.getRuntimeService(IChannelRecentNotifyService.class, "")).refreshRecentList(2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePushChannelDestroy(String str, List<String> list) {
        if (list != null && !list.isEmpty()) {
            QLog.d(TAG, 1, "handlePushChannelDestroy guildId = " + str + " size = " + list.size());
            IChannelRecentUserApi iChannelRecentUserApi = (IChannelRecentUserApi) QRoute.api(IChannelRecentUserApi.class);
            Iterator<String> it = list.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                z16 = iChannelRecentUserApi.tryToRemoveChannelInRecentUserCache(this.mAppRuntime, it.next());
            }
            if (z16) {
                ((IChannelRecentNotifyService) this.mAppRuntime.getRuntimeService(IChannelRecentNotifyService.class, "")).refreshRecentList(2, null);
                return;
            }
            return;
        }
        QLog.d(TAG, 1, "handlePushChannelDestroy args error! guildId = " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleRefreshChannelInRecentList(fk fkVar) {
        ((IChannelRecentUserApi) QRoute.api(IChannelRecentUserApi.class)).tryToRefreshChannelInRecentList(this.mAppRuntime, fkVar);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleSetTopChannelInRecentList(fk fkVar) {
        return ((IChannelRecentUserApi) QRoute.api(IChannelRecentUserApi.class)).tryToSetTopChannelInRecentUserCache(this.mAppRuntime, fkVar.getChannelId(), fkVar.getTopTimestamp() / 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleUnSetTopChannelInRecentList(fk fkVar) {
        return ((IChannelRecentUserApi) QRoute.api(IChannelRecentUserApi.class)).tryToUnsetTopChannelInRecentUserCache(this.mAppRuntime, fkVar.getChannelId());
    }

    private void init() {
        QLog.d(TAG, 1, "addObserver success!");
        ((IGProGlobalService) this.mAppRuntime.getRuntimeService(IGProGlobalService.class, "")).addObserver(this.mGPServiceObserver);
        if (((IGuildUserService) this.mAppRuntime.getRuntimeService(IGuildUserService.class, "")).isGuildUser() && ((IGPSService) this.mAppRuntime.getRuntimeService(IGPSService.class, "")).isQQMsgListReady() && this.mRefreshRecentListFlag.compareAndSet(false, true)) {
            ((IChannelRecentUserApi) QRoute.api(IChannelRecentUserApi.class)).refreshMsgListChannelForRecentList(this.mAppRuntime);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mAppRuntime = appRuntime;
        init();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        QLog.d(TAG, 1, "deleteObserver");
        ((IGProGlobalService) this.mAppRuntime.getRuntimeService(IGProGlobalService.class, "")).deleteObserver(this.mGPServiceObserver);
    }
}
