package com.tencent.mobileqq.guild.message.lastmsg;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.message.lastmsg.api.IGuildLastMsgService;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.fk;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

/* loaded from: classes14.dex */
public class GuildLastMsgRealTimeProcessor {

    /* renamed from: a, reason: collision with root package name */
    private HashSet<String> f230590a = new HashSet<>();

    /* renamed from: b, reason: collision with root package name */
    private HashSet<String> f230591b = new HashSet<>();

    /* renamed from: c, reason: collision with root package name */
    private AppRuntime f230592c;

    /* renamed from: d, reason: collision with root package name */
    private final GPServiceObserver f230593d;

    /* loaded from: classes14.dex */
    class a extends GPServiceObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(String str) {
            boolean z16;
            Message message;
            BaseMessageManager F = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) GuildLastMsgRealTimeProcessor.this.f230592c).F(10014);
            IGuildLastMsgService iGuildLastMsgService = (IGuildLastMsgService) GuildLastMsgRealTimeProcessor.this.f230592c.getRuntimeService(IGuildLastMsgService.class, "");
            GuildLastMsgItem guildLastMsgItem = iGuildLastMsgService.getClonedLastItemMap().get(str);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onChannelInfoUpdated: channelUin: ");
            sb5.append(str);
            sb5.append(", found msgItem: ");
            if (guildLastMsgItem != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.i("GuildLastMsgRealTimeProcessor", 1, sb5.toString());
            if (guildLastMsgItem != null && (message = guildLastMsgItem.message) != null && message.msgtype == -4028) {
                GuildLastMsgRealTimeProcessor.this.l(F, iGuildLastMsgService, str, guildLastMsgItem);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(String str) {
            Message message;
            BaseMessageManager F = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) GuildLastMsgRealTimeProcessor.this.f230592c).F(10014);
            IGuildLastMsgService iGuildLastMsgService = (IGuildLastMsgService) GuildLastMsgRealTimeProcessor.this.f230592c.getRuntimeService(IGuildLastMsgService.class, "");
            ConcurrentHashMap<String, GuildLastMsgItem> clonedLastItemMap = iGuildLastMsgService.getClonedLastItemMap();
            Iterator<IGProChannelInfo> it = ((IGPSService) GuildLastMsgRealTimeProcessor.this.f230592c.getRuntimeService(IGPSService.class, "")).getChannelList(str).iterator();
            while (it.hasNext()) {
                String channelUin = it.next().getChannelUin();
                GuildLastMsgItem guildLastMsgItem = clonedLastItemMap.get(channelUin);
                if (guildLastMsgItem != null && (message = guildLastMsgItem.message) != null && message.msgtype == -4028) {
                    if (QLog.isColorLevel()) {
                        QLog.i("GuildLastMsgRealTimeProcessor", 2, "onChannelListUpdated: channelId: " + channelUin);
                    }
                    GuildLastMsgRealTimeProcessor.this.l(F, iGuildLastMsgService, channelUin, guildLastMsgItem);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onQQMsgListChannelUpdated(List<Integer> list, List<fk> list2) {
            boolean z16;
            if (list2 != null && !list2.isEmpty()) {
                IGuildLastMsgService iGuildLastMsgService = (IGuildLastMsgService) GuildLastMsgRealTimeProcessor.this.f230592c.getRuntimeService(IGuildLastMsgService.class, "");
                ConcurrentHashMap<String, GuildLastMsgItem> clonedLastItemMap = iGuildLastMsgService.getClonedLastItemMap();
                for (fk fkVar : list2) {
                    GuildLastMsgItem guildLastMsgItem = clonedLastItemMap.get(fkVar.getChannelId());
                    if (guildLastMsgItem != null) {
                        iGuildLastMsgService.lazyNotifyLastMsgChange(fkVar.getChannelId(), guildLastMsgItem);
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("onQQMsgListChannelUpdated. channelId: ");
                    sb5.append(fkVar.getChannelId());
                    sb5.append(", msgItem found: ");
                    if (guildLastMsgItem != null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    sb5.append(z16);
                    QLog.i("GuildLastMsgRealTimeProcessor", 1, sb5.toString());
                }
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserDisplayNameUpdate(String str) {
            QLog.d("GuildLastMsgRealTimeProcessor", 4, "onUserDisplayNameUpdate: tinyId:" + str);
            GuildLastMsgRealTimeProcessor.this.m(str);
        }
    }

    public GuildLastMsgRealTimeProcessor(AppRuntime appRuntime) {
        a aVar = new a();
        this.f230593d = aVar;
        this.f230592c = appRuntime;
        ((IGProGlobalService) appRuntime.getRuntimeService(IGProGlobalService.class, "")).addObserver(aVar);
    }

    private boolean h(Message message) {
        if (message.msgtype == -4050 && !TextUtils.isEmpty(message.getExtInfoFromExtStr("RevokeGrayTipOperatorTid"))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(GuildLastMsgItem guildLastMsgItem, HashSet<String> hashSet) {
        Message message;
        if (guildLastMsgItem == null || (message = guildLastMsgItem.message) == null) {
            return false;
        }
        if (message.msgtype == -4050 && !hashSet.contains(message.getExtInfoFromExtStr("RevokeGrayTipOperatorTid"))) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(BaseMessageManager baseMessageManager, IGuildLastMsgService iGuildLastMsgService, String str, GuildLastMsgItem guildLastMsgItem) {
        Message message;
        if (baseMessageManager != null && iGuildLastMsgService != null && guildLastMsgItem != null && (message = guildLastMsgItem.message) != null) {
            try {
                String str2 = message.f203106msg;
                String str3 = "";
                if (str2 == null) {
                    str2 = "";
                }
                baseMessageManager.h(message);
                String str4 = guildLastMsgItem.message.f203106msg;
                if (str4 != null) {
                    str3 = str4;
                }
                if (!str3.equals(str2)) {
                    QLog.i("GuildLastMsgRealTimeProcessor", 1, "updateLastMsgAndNotify: " + guildLastMsgItem);
                    iGuildLastMsgService.lazyNotifyLastMsgChange(str, guildLastMsgItem);
                }
            } catch (Throwable th5) {
                QLog.e("GuildLastMsgRealTimeProcessor", 1, "asyncUpdateLastMsg. channelId:" + str + " exception:" + th5.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str) {
        g(str);
    }

    public void g(String str) {
        boolean isEmpty;
        synchronized (this.f230590a) {
            if (this.f230590a.isEmpty()) {
                return;
            }
            synchronized (this.f230591b) {
                isEmpty = this.f230591b.isEmpty();
                this.f230591b.add(str);
            }
            if (!isEmpty) {
                return;
            }
            QLog.i("GuildLastMsgRealTimeProcessor", 1, "asyncUpdateLastMsgLazy start");
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.guild.message.lastmsg.GuildLastMsgRealTimeProcessor.2
                @Override // java.lang.Runnable
                public void run() {
                    HashSet hashSet = new HashSet();
                    synchronized (GuildLastMsgRealTimeProcessor.this.f230591b) {
                        hashSet.addAll(GuildLastMsgRealTimeProcessor.this.f230591b);
                        GuildLastMsgRealTimeProcessor.this.f230591b.clear();
                    }
                    IGuildLastMsgService iGuildLastMsgService = (IGuildLastMsgService) GuildLastMsgRealTimeProcessor.this.f230592c.getRuntimeService(IGuildLastMsgService.class, "");
                    BaseMessageManager F = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) GuildLastMsgRealTimeProcessor.this.f230592c).F(10014);
                    ConcurrentHashMap<String, GuildLastMsgItem> clonedLastItemMap = iGuildLastMsgService.getClonedLastItemMap();
                    if (clonedLastItemMap.isEmpty()) {
                        return;
                    }
                    HashSet hashSet2 = new HashSet();
                    synchronized (GuildLastMsgRealTimeProcessor.this.f230590a) {
                        hashSet2.addAll(GuildLastMsgRealTimeProcessor.this.f230590a);
                    }
                    Iterator it = hashSet2.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        GuildLastMsgItem guildLastMsgItem = clonedLastItemMap.get(str2);
                        if (guildLastMsgItem != null && guildLastMsgItem.message != null && GuildLastMsgRealTimeProcessor.this.i(guildLastMsgItem, hashSet)) {
                            GuildLastMsgRealTimeProcessor.this.l(F, iGuildLastMsgService, str2, guildLastMsgItem);
                        }
                    }
                    QLog.i("GuildLastMsgRealTimeProcessor", 1, "asyncUpdateLastMsgLazy done tinyidUpdateSetCopy.size():" + hashSet.size());
                }
            }, 16, null, true, 5000L);
        }
    }

    public void j() {
        ((IGProGlobalService) this.f230592c.getRuntimeService(IGProGlobalService.class, "")).deleteObserver(this.f230593d);
    }

    public void k(String str, GuildLastMsgItem guildLastMsgItem) {
        synchronized (this.f230590a) {
            if (guildLastMsgItem != null) {
                if (guildLastMsgItem.message != null && !TextUtils.isEmpty(str)) {
                    if (h(guildLastMsgItem.message)) {
                        this.f230590a.add(str);
                        QLog.i("GuildLastMsgRealTimeProcessor", 1, "record add item:" + guildLastMsgItem);
                    } else {
                        if (this.f230590a.contains(str)) {
                            QLog.i("GuildLastMsgRealTimeProcessor", 1, "record remove item:" + guildLastMsgItem);
                        }
                        this.f230590a.remove(str);
                    }
                }
            }
        }
    }
}
