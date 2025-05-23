package com.tencent.mobileqq.guild.message.unread.api.impl;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.directmessage.model.data.DirectMessageNode;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository;
import com.tencent.mobileqq.guild.message.m;
import com.tencent.mobileqq.guild.message.unread.ChannelMsgReadedReportHandler;
import com.tencent.mobileqq.guild.message.unread.api.IGuildMsgReadedService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildMsgReadedServiceImpl implements IGuildMsgReadedService {
    private final String TAG = "GuildMsgReadedServiceImpl";
    private AppRuntime app;

    /* JADX INFO: Access modifiers changed from: private */
    public void addChannelIds(String str, ArrayList<String> arrayList, boolean z16) {
        if (z16) {
            DirectMessageNode D = DirectMessageNodeRepository.D(str);
            if (D != null) {
                arrayList.add(D.getChannelId());
                return;
            }
            return;
        }
        List<IGProChannelInfo> channelList = ((IGPSService) this.app.getRuntimeService(IGPSService.class, "")).getChannelList(str);
        if (channelList != null && channelList.size() > 0) {
            for (IGProChannelInfo iGProChannelInfo : channelList) {
                if (!TextUtils.isEmpty(iGProChannelInfo.getChannelUin())) {
                    arrayList.add(iGProChannelInfo.getChannelUin());
                }
            }
        }
    }

    private void clearAtMsgEvent(String str, List<String> list) {
        IGuildMessageBoxDataService iGuildMessageBoxDataService = (IGuildMessageBoxDataService) this.app.getRuntimeService(IGuildMessageBoxDataService.class, "");
        if (!TextUtils.isEmpty(str) && list != null && iGuildMessageBoxDataService != null) {
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    iGuildMessageBoxDataService.clearChannelMsgBoxReadEventList(str2, 1L);
                    iGuildMessageBoxDataService.clearChannelMsgBoxReadEventList(str2, 100L);
                }
            }
        }
    }

    private void setMessageRecordReadedFrom(String str, List<String> list) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
            IGuildMsgSeqTimeService iGuildMsgSeqTimeService = (IGuildMsgSeqTimeService) this.app.getRuntimeService(IGuildMsgSeqTimeService.class, "");
            com.tencent.imcore.message.f y16 = ((m) ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) this.app).F(10014)).y(10014);
            for (String str2 : list) {
                IGuildMsgSeqTimeService.a readedMsgSeq = iGuildMsgSeqTimeService.getReadedMsgSeq(str2);
                if (readedMsgSeq.d()) {
                    long j3 = readedMsgSeq.f230119d;
                    if (j3 > 0) {
                        y16.v0(str2, 10014, j3);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMsgReadedAndReport(LinkedHashMap<String, ArrayList<String>> linkedHashMap, int i3, boolean z16) {
        AppInterface appInterface = (AppInterface) this.app;
        if (z16) {
            com.tencent.mobileqq.guild.message.unread.b.e(appInterface, linkedHashMap, true, i3);
        } else {
            ((ChannelMsgReadedReportHandler) appInterface.getBusinessHandler(ChannelMsgReadedReportHandler.class.getName())).K2(linkedHashMap, false, i3);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildMsgReadedService
    public boolean clearMsgNavigateInfo(String str, List<String> list) {
        if (TextUtils.isEmpty(str) || list == null || list.size() == 0) {
            return false;
        }
        com.tencent.mobileqq.troop.navigatebar.b a16 = m.P0().a((AppInterface) this.app);
        boolean z16 = false;
        for (String str2 : list) {
            List<Long> c16 = a16.c(str2, 0);
            if (c16 != null && c16.size() > 0) {
                a16.b(str2, 0);
                z16 = true;
            }
        }
        return z16;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.app = appRuntime;
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildMsgReadedService
    public void onMsgReadedNotify(String str, String str2, IGuildMsgSeqTimeService.a aVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && aVar != null) {
            QLog.i("GuildMsgReadedServiceImpl", 1, "onMsgReadedNotify key:" + str + " channelId:" + str2 + " seqTimeItem:" + aVar.toString());
            if (((IGuildMsgSeqTimeService) this.app.getRuntimeService(IGuildMsgSeqTimeService.class, "")).setReadedMsgSeq(str, str2, aVar, true)) {
                QLog.i("GuildMsgReadedServiceImpl", 1, "onMsgReadedNotify key:" + str + " channelId:" + str2 + " unreadCnt:" + ((IGuildUnreadCntService) this.app.getRuntimeService(IGuildUnreadCntService.class, "")).getChannelUnreadCnt(str2, 1).f230840d);
                ArrayList arrayList = new ArrayList();
                arrayList.add(str2);
                setMessageRecordReadedFrom(str, arrayList);
                clearMsgNavigateInfo(str, arrayList);
                clearAtMsgEvent(str, arrayList);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildMsgReadedService
    public void onRegisterProxyMsgReaded(String str, List<String> list) {
        clearMsgNavigateInfo(str, list);
        setMessageRecordReadedFrom(str, list);
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildMsgReadedService
    public void setChannelMsgReaded(String str, ArrayList<String> arrayList, int i3, boolean z16) {
        if (!TextUtils.isEmpty(str) && arrayList != null && arrayList.size() != 0) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                QLog.i("GuildMsgReadedServiceImpl", 1, "setChannelMsgReaded key:" + str + " channelId:" + it.next() + " from:" + i3);
            }
            LinkedHashMap<String, ArrayList<String>> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put(str, arrayList);
            setChannelMsgReaded(linkedHashMap, i3, z16);
            return;
        }
        QLog.w("GuildMsgReadedServiceImpl", 1, "setChannelMsgReaded guildId:" + str + " channelId:" + arrayList + " from:" + i3 + " isDirectMessage:" + z16);
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildMsgReadedService
    public void setGuildMsgReaded(String str, int i3, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(str);
        setGuildMsgReaded(linkedHashSet, i3, z16);
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildMsgReadedService
    public void setMessageRecordReaded(String str, List<String> list) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
            IGuildUnreadCntService iGuildUnreadCntService = (IGuildUnreadCntService) this.app.getRuntimeService(IGuildUnreadCntService.class, "");
            com.tencent.imcore.message.f y16 = ((m) ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) this.app).F(10014)).y(10014);
            for (String str2 : list) {
                if (iGuildUnreadCntService.getChannelUnreadCnt(str2, 1).f230840d > 0) {
                    y16.u0(str2, 10014, null, 0);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildMsgReadedService
    public void setMsgReadedAndReportForce(String str, ArrayList<String> arrayList, int i3, boolean z16, boolean z17) {
        AppInterface appInterface = (AppInterface) this.app;
        if (z16) {
            com.tencent.mobileqq.guild.message.unread.b.d(appInterface, str, arrayList, true, i3);
        } else {
            ((ChannelMsgReadedReportHandler) appInterface.getBusinessHandler(ChannelMsgReadedReportHandler.class.getName())).J2(str, arrayList, true, i3, z17);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildMsgReadedService
    public void setGuildMsgReaded(final LinkedHashSet<String> linkedHashSet, final int i3, final boolean z16) {
        if (linkedHashSet == null || linkedHashSet.size() == 0) {
            return;
        }
        QLog.i("GuildMsgReadedServiceImpl", 1, "setGuildMsgReaded from:" + i3 + " isDirectMessage:" + z16);
        if (z16) {
            long uptimeMillis = SystemClock.uptimeMillis();
            uh2.c gProGuildMsgService = ((IGProSession) this.app.getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
            if (gProGuildMsgService != null) {
                Iterator it = new ArrayList(linkedHashSet).iterator();
                while (it.hasNext()) {
                    gProGuildMsgService.setGProGuildMsgRead((String) it.next(), null);
                }
            }
            QLog.i("GuildMsgReadedServiceImpl", 1, "setGuildMsgReaded cost: " + (SystemClock.uptimeMillis() - uptimeMillis) + " size: " + linkedHashSet.size());
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.message.unread.api.impl.GuildMsgReadedServiceImpl.1
            @Override // java.lang.Runnable
            public void run() {
                long uptimeMillis2 = SystemClock.uptimeMillis();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Iterator it5 = linkedHashSet.iterator();
                while (it5.hasNext()) {
                    String str = (String) it5.next();
                    if (!TextUtils.isEmpty(str)) {
                        ArrayList arrayList = new ArrayList();
                        GuildMsgReadedServiceImpl.this.addChannelIds(str, arrayList, z16);
                        if (!arrayList.isEmpty()) {
                            linkedHashMap.put(str, arrayList);
                        }
                        GuildMsgReadedServiceImpl.this.setMessageRecordReaded(str, (List) linkedHashMap.get(str));
                    }
                }
                GuildMsgReadedServiceImpl.this.setMsgReadedAndReport(linkedHashMap, i3, z16);
                Iterator it6 = linkedHashSet.iterator();
                while (it6.hasNext()) {
                    String str2 = (String) it6.next();
                    if (!TextUtils.isEmpty(str2)) {
                        GuildMsgReadedServiceImpl.this.clearMsgNavigateInfo(str2, (List) linkedHashMap.get(str2));
                    }
                }
                QLog.i("GuildMsgReadedServiceImpl", 1, "setGuildMsgReaded cost:" + (SystemClock.uptimeMillis() - uptimeMillis2) + " allGuildData.size:" + linkedHashMap.size());
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildMsgReadedService
    public void setMsgReadedAndReport(String str, ArrayList<String> arrayList, int i3, boolean z16) {
        AppInterface appInterface = (AppInterface) this.app;
        if (z16) {
            com.tencent.mobileqq.guild.message.unread.b.d(appInterface, str, arrayList, false, i3);
        } else {
            ((ChannelMsgReadedReportHandler) appInterface.getBusinessHandler(ChannelMsgReadedReportHandler.class.getName())).J2(str, arrayList, false, i3, false);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildMsgReadedService
    public void setChannelMsgReaded(final LinkedHashMap<String, ArrayList<String>> linkedHashMap, final int i3, final boolean z16) {
        if (linkedHashMap == null || linkedHashMap.size() == 0) {
            return;
        }
        QLog.i("GuildMsgReadedServiceImpl", 1, "setChannelMsgReaded from:" + i3 + " isDirectMessage:" + z16);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.message.unread.api.impl.GuildMsgReadedServiceImpl.2
            @Override // java.lang.Runnable
            public void run() {
                long uptimeMillis = SystemClock.uptimeMillis();
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    GuildMsgReadedServiceImpl.this.setMessageRecordReaded((String) entry.getKey(), (List) entry.getValue());
                }
                GuildMsgReadedServiceImpl.this.setMsgReadedAndReport(linkedHashMap, i3, z16);
                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                    GuildMsgReadedServiceImpl.this.clearMsgNavigateInfo((String) entry2.getKey(), (List) entry2.getValue());
                }
                QLog.i("GuildMsgReadedServiceImpl", 1, "setChannelMsgReaded cost:" + (SystemClock.uptimeMillis() - uptimeMillis) + " channelIds.size:" + linkedHashMap.size());
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildMsgReadedService
    public void setMsgReadedAndReport(String str, String str2, IGuildMsgSeqTimeService.a aVar, boolean z16) {
        AppInterface appInterface = (AppInterface) this.app;
        if (z16) {
            com.tencent.mobileqq.guild.message.unread.b.c(appInterface, str, str2, aVar);
        } else {
            ((ChannelMsgReadedReportHandler) appInterface.getBusinessHandler(ChannelMsgReadedReportHandler.class.getName())).I2(str, str2, aVar);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
