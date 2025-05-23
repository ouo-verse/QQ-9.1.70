package com.tencent.mobileqq.guild.message.api.impl;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.message.api.IGuildFocusChannelService;
import com.tencent.mobileqq.guild.message.api.IGuildLocalFocusService;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildFocusChannelServiceImpl implements IGuildFocusChannelService {
    private static final String GUILD_HUGE_CHANNEL_LIST_SP_NAME = "guildHugeChannelListSpName";
    private static final String GUILD_HUGE_GUILD_LIST_SP_NAME = "guildHugeGuildListSpName";
    private static final String TAG = "GuildFocusChannelServiceImpl";
    private AppRuntime mApp;
    private HashSet<String> mHugeChannelIdSet = new HashSet<>();
    private HashSet<String> mHugeGuildIdSet = new HashSet<>();
    private boolean mInitLoadSp = false;

    private com.tencent.mobileqq.guild.message.f convertToGuildFocusInfo(Set<String> set, Set<String> set2, int i3, int i16) {
        HashSet<String> hashSet = new HashSet<>();
        if (set != null) {
            hashSet.addAll(set);
        }
        HashSet<String> hashSet2 = new HashSet<>();
        if (set2 != null) {
            hashSet2.addAll(set2);
        }
        return new com.tencent.mobileqq.guild.message.f().c(hashSet).b(hashSet2).i(i3).a(i16);
    }

    private int getActiveStatus() {
        if (((IGuildLocalFocusService) this.mApp.getRuntimeService(IGuildLocalFocusService.class, "")).getAppOnForeground()) {
            return 1;
        }
        return 2;
    }

    private String getCurActiveGuildId() {
        com.tencent.mobileqq.guild.message.d activeGuild;
        IGuildLocalFocusService iGuildLocalFocusService = (IGuildLocalFocusService) this.mApp.getRuntimeService(IGuildLocalFocusService.class, "");
        long activeGuildId = iGuildLocalFocusService.getActiveGuildId();
        if (iGuildLocalFocusService.getAppOnForeground() && activeGuildId != com.tencent.mobileqq.guild.message.api.impl.onlinepush.e.B && (activeGuild = iGuildLocalFocusService.getActiveGuild()) != null) {
            if (activeGuild.f230363b == 1 && iGuildLocalFocusService.getSelTab() == 1) {
                return String.valueOf(activeGuildId);
            }
            if (activeGuild.f230363b == 2) {
                return String.valueOf(activeGuildId);
            }
        }
        return "";
    }

    private com.tencent.mobileqq.guild.message.f getCurGuildFocusInfo() {
        HashSet hashSet = new HashSet();
        String curActiveGuildId = getCurActiveGuildId();
        if (isHugeGuild(curActiveGuildId)) {
            hashSet.add(curActiveGuildId);
        }
        HashSet hashSet2 = new HashSet();
        String curActiveChannelId = getCurActiveChannelId();
        if (isHugeChannel(curActiveChannelId)) {
            hashSet2.add(curActiveChannelId);
        }
        return convertToGuildFocusInfo(hashSet, hashSet2, getFocusOnMsgTabFlag(), getActiveStatus());
    }

    private int getFocusOnMsgTabFlag() {
        IGuildLocalFocusService iGuildLocalFocusService = (IGuildLocalFocusService) this.mApp.getRuntimeService(IGuildLocalFocusService.class, "");
        if (iGuildLocalFocusService.getSelTab() == 2 && iGuildLocalFocusService.getAppOnForeground()) {
            return 1;
        }
        return 0;
    }

    private String getGuildId(String str) {
        IGProChannelInfo channelInfo = ((IGPSService) this.mApp.getRuntimeService(IGPSService.class, "")).getChannelInfo(str);
        if (channelInfo != null) {
            return channelInfo.getGuildId();
        }
        return null;
    }

    private SharedPreferences getHugeChannelListSp() {
        return this.mApp.getApp().getSharedPreferences(GUILD_HUGE_CHANNEL_LIST_SP_NAME, 0);
    }

    private SharedPreferences getHugeGuildListSp() {
        return this.mApp.getApp().getSharedPreferences(GUILD_HUGE_GUILD_LIST_SP_NAME, 0);
    }

    private void loadHugeChannelListFromSp() {
        Set<Map.Entry<String, ?>> entrySet;
        SharedPreferences hugeChannelListSp = getHugeChannelListSp();
        if (hugeChannelListSp.getAll() == null || (entrySet = hugeChannelListSp.getAll().entrySet()) == null) {
            return;
        }
        for (Map.Entry<String, ?> entry : entrySet) {
            if (((Integer) entry.getValue()).intValue() == 1) {
                this.mHugeChannelIdSet.add(entry.getKey());
            }
        }
    }

    private void loadHugeGuildListFromSp() {
        Set<Map.Entry<String, ?>> entrySet;
        SharedPreferences hugeGuildListSp = getHugeGuildListSp();
        if (hugeGuildListSp.getAll() == null || (entrySet = hugeGuildListSp.getAll().entrySet()) == null) {
            return;
        }
        for (Map.Entry<String, ?> entry : entrySet) {
            if (((Integer) entry.getValue()).intValue() == 1) {
                this.mHugeGuildIdSet.add(entry.getKey());
            }
        }
    }

    private synchronized void loadSpToCache() {
        if (this.mInitLoadSp) {
            return;
        }
        this.mInitLoadSp = true;
        loadHugeChannelListFromSp();
        loadHugeGuildListFromSp();
    }

    private boolean shouldUpdateFocusChannel(com.tencent.mobileqq.guild.message.f fVar, com.tencent.mobileqq.guild.message.f fVar2) {
        return !fVar.equals(fVar2);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildFocusChannelService
    public synchronized void addHugeChannel(HashSet<String> hashSet) {
        if (hashSet != null) {
            if (!hashSet.isEmpty()) {
                loadSpToCache();
                SharedPreferences hugeChannelListSp = getHugeChannelListSp();
                String str = "";
                Iterator<String> it = hashSet.iterator();
                boolean z16 = false;
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null && this.mHugeChannelIdSet.add(next)) {
                        hugeChannelListSp.edit().putInt(next, 1);
                        str = str + next + " ";
                        z16 = true;
                    }
                }
                if (z16) {
                    QLog.d(TAG, 1, "addHugeChannel, hugeChannelList = " + str);
                    hugeChannelListSp.edit().apply();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildFocusChannelService
    public synchronized void addHugeGuild(HashSet<String> hashSet) {
        if (hashSet != null) {
            if (!hashSet.isEmpty()) {
                loadSpToCache();
                SharedPreferences hugeGuildListSp = getHugeGuildListSp();
                String str = "";
                Iterator<String> it = hashSet.iterator();
                boolean z16 = false;
                while (it.hasNext()) {
                    String next = it.next();
                    if (!TextUtils.isEmpty(next) && this.mHugeGuildIdSet.add(next)) {
                        hugeGuildListSp.edit().putInt(next, 1);
                        str = str + next + " ";
                        z16 = true;
                    }
                }
                if (z16) {
                    QLog.d(TAG, 1, "addHugeGuild, hugeGuildList = " + str);
                    hugeGuildListSp.edit().apply();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildFocusChannelService
    public String getCurActiveChannelId() {
        IGuildLocalFocusService iGuildLocalFocusService = (IGuildLocalFocusService) this.mApp.getRuntimeService(IGuildLocalFocusService.class, "");
        if (iGuildLocalFocusService.getActiveChannelId() == com.tencent.mobileqq.guild.message.api.impl.onlinepush.e.B) {
            return "";
        }
        return String.valueOf(iGuildLocalFocusService.getActiveChannelId());
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildFocusChannelService
    public synchronized boolean isHugeChannel(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        loadSpToCache();
        return this.mHugeChannelIdSet.contains(str);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildFocusChannelService
    public synchronized boolean isHugeGuild(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        loadSpToCache();
        return this.mHugeGuildIdSet.contains(str);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mApp = appRuntime;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildFocusChannelService
    public synchronized void removeHugeChannel(HashSet<String> hashSet) {
        if (hashSet != null) {
            if (!hashSet.isEmpty()) {
                loadSpToCache();
                SharedPreferences hugeChannelListSp = getHugeChannelListSp();
                String str = "";
                Iterator<String> it = hashSet.iterator();
                boolean z16 = false;
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null && this.mHugeChannelIdSet.remove(next)) {
                        hugeChannelListSp.edit().remove(next);
                        str = str + next + " ";
                        z16 = true;
                    }
                }
                if (z16) {
                    QLog.d(TAG, 1, "removeHugeChannel, channelList = " + str);
                    hugeChannelListSp.edit().apply();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildFocusChannelService
    public synchronized void removeHugeGuild(HashSet<String> hashSet) {
        if (hashSet != null) {
            if (!hashSet.isEmpty()) {
                loadSpToCache();
                SharedPreferences hugeGuildListSp = getHugeGuildListSp();
                String str = "";
                Iterator<String> it = hashSet.iterator();
                boolean z16 = false;
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null && this.mHugeGuildIdSet.remove(next)) {
                        hugeGuildListSp.edit().remove(next);
                        str = str + next + " ";
                        z16 = true;
                    }
                }
                if (z16) {
                    QLog.d(TAG, 1, "removeHugeGuild, guildList = " + str);
                    hugeGuildListSp.edit().apply();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildFocusChannelService
    public void reportGuildFocusInfo() {
        com.tencent.mobileqq.guild.message.f curGuildFocusInfo = getCurGuildFocusInfo();
        ((io1.a) ((AppInterface) this.mApp).getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildReportFocusInfoHandlerName())).P(curGuildFocusInfo);
        QLog.d(TAG, 1, "reportGuildFocusInfo " + curGuildFocusInfo.toString());
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildFocusChannelService
    public void updateFocusChannel(com.tencent.mobileqq.guild.message.f fVar) {
        if (fVar == null) {
            return;
        }
        com.tencent.mobileqq.guild.message.f curGuildFocusInfo = getCurGuildFocusInfo();
        if (shouldUpdateFocusChannel(fVar, curGuildFocusInfo)) {
            QLog.d(TAG, 1, "shouldUpdateFocusChannel. svrFocusGuildSet: " + fVar.toString() + " reportGuildFocusInfo:" + curGuildFocusInfo.toString());
            ((io1.a) ((AppInterface) this.mApp).getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildReportFocusInfoHandlerName())).P(curGuildFocusInfo);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
