package com.tencent.mobileqq.guild.message.api.impl;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.data.ChannelMsgEvent;
import com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.unread.DecreaseMsgSeqInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.BaseTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import tencent.im.group_pro_proto.synclogic.synclogic$GuildNode;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildMessageBoxDataServiceImpl implements IGuildMessageBoxDataService {
    private static final String GUILD_MSG_BOX_SP_NAME = "guildMsgBoxSP";
    private static final String TAG = "GuildMessageBoxDataServiceImpl";
    private AppRuntime mApp;
    private EntityManager mEntityManager;
    private final Object lock = new Object();
    private ConcurrentHashMap<String, List<ChannelMsgEvent>> mChannelMsgEventMap = new ConcurrentHashMap<>();
    private ou1.a mGuildRegisterProxyObserver = new a();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends ou1.a {
        a() {
        }

        @Override // ou1.a
        protected void e(boolean z16, ArrayList<synclogic$GuildNode> arrayList) {
            GuildMessageBoxDataServiceImpl.this.verifyMsgEventList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements Comparator<ChannelMsgEvent> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ChannelMsgEvent channelMsgEvent, ChannelMsgEvent channelMsgEvent2) {
            return Long.compare(channelMsgEvent2.msgSeq, channelMsgEvent.msgSeq);
        }
    }

    private boolean addChannelMsgEventToCache(ChannelMsgEvent channelMsgEvent) {
        boolean z16 = true;
        QLog.d(TAG, 1, "addChannelMsgEventToCache, info = " + channelMsgEvent);
        if (channelMsgEvent != null && !TextUtils.isEmpty(channelMsgEvent.channelId)) {
            synchronized (this.mChannelMsgEventMap) {
                List<ChannelMsgEvent> list = this.mChannelMsgEventMap.get(channelMsgEvent.channelId);
                if (list != null) {
                    if (!list.contains(channelMsgEvent)) {
                        list.add(channelMsgEvent);
                    } else {
                        z16 = verifySubType(channelMsgEvent, list);
                    }
                } else {
                    list = new ArrayList<>();
                    list.add(channelMsgEvent);
                }
                this.mChannelMsgEventMap.put(channelMsgEvent.channelId, list);
            }
            return z16;
        }
        return false;
    }

    private boolean filterEventTypeForGetUnreadCnt(long j3, int i3, int i16) {
        if (j3 == 1 && i3 == 2 && i16 != 1) {
            return true;
        }
        return false;
    }

    private BaseTransaction getTransactionObj(Entity entity) {
        if (entity != null && this.mEntityManager.isOpen()) {
            if (entity.getStatus() == 1000) {
                return new PersistOrReplaceTransaction(entity);
            }
            return new UpdateTransaction(entity);
        }
        return null;
    }

    private void sortChannelMsgEventList(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.mChannelMsgEventMap) {
            Collections.sort(this.mChannelMsgEventMap.get(str), new b());
        }
    }

    private boolean updateEntity(Entity entity) {
        if (entity == null || !this.mEntityManager.isOpen()) {
            return false;
        }
        if (entity.getStatus() == 1000) {
            this.mEntityManager.persistOrReplace(entity);
            if (entity.getStatus() != 1001) {
                return false;
            }
            return true;
        }
        return this.mEntityManager.update(entity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void verifyMsgEventList() {
        IGuildMsgSeqTimeService iGuildMsgSeqTimeService = (IGuildMsgSeqTimeService) this.mApp.getRuntimeService(IGuildMsgSeqTimeService.class, "");
        if (iGuildMsgSeqTimeService == null) {
            QLog.d(TAG, 1, "verifyMsgEventList, guildMsgSeqTimeService == null");
            return;
        }
        synchronized (this.mChannelMsgEventMap) {
            for (Map.Entry<String, List<ChannelMsgEvent>> entry : this.mChannelMsgEventMap.entrySet()) {
                if (entry != null) {
                    IGuildMsgSeqTimeService.a readedMsgSeq = iGuildMsgSeqTimeService.getReadedMsgSeq(entry.getKey());
                    HashSet<DecreaseMsgSeqInfo> decreaseMsgSeqList = iGuildMsgSeqTimeService.getDecreaseMsgSeqList(entry.getKey());
                    DecreaseMsgSeqInfo decreaseMsgSeqInfo = new DecreaseMsgSeqInfo();
                    if (entry.getValue() != null) {
                        Iterator<ChannelMsgEvent> it = entry.getValue().iterator();
                        while (it.hasNext()) {
                            long j3 = it.next().msgSeq;
                            decreaseMsgSeqInfo.msgSeq = j3;
                            if ((readedMsgSeq != null && readedMsgSeq.f230119d >= j3) || decreaseMsgSeqList.contains(decreaseMsgSeqInfo)) {
                                it.remove();
                            }
                        }
                        sortChannelMsgEventList(entry.getKey());
                    }
                }
            }
            QLog.d(TAG, 1, "verifyMsgEventList, mChannelMsgEventMap = " + this.mChannelMsgEventMap);
        }
    }

    private boolean verifySubType(ChannelMsgEvent channelMsgEvent, List<ChannelMsgEvent> list) {
        int indexOf;
        ChannelMsgEvent channelMsgEvent2;
        if (channelMsgEvent.subType != 0 && (indexOf = list.indexOf(channelMsgEvent)) != -1 && (channelMsgEvent2 = list.get(indexOf)) != null && channelMsgEvent2.subType != 0) {
            channelMsgEvent2.subType = channelMsgEvent.subType;
            QLog.i(TAG, 1, "verifySubType change subType, old = " + channelMsgEvent2.toString() + " new = " + channelMsgEvent.toString());
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService
    public void addChannelMsgBoxEvent(ChannelMsgEvent channelMsgEvent) {
        QLog.d(TAG, 1, "addChannelMsgBoxEvent, event = " + channelMsgEvent);
        if (channelMsgEvent == null) {
            return;
        }
        IGuildMsgSeqTimeService iGuildMsgSeqTimeService = (IGuildMsgSeqTimeService) this.mApp.getRuntimeService(IGuildMsgSeqTimeService.class, "");
        IGuildMsgSeqTimeService.a readedMsgSeq = iGuildMsgSeqTimeService.getReadedMsgSeq(channelMsgEvent.channelId);
        HashSet<DecreaseMsgSeqInfo> decreaseMsgSeqList = iGuildMsgSeqTimeService.getDecreaseMsgSeqList(channelMsgEvent.channelId);
        if ((readedMsgSeq == null || readedMsgSeq.f230119d < channelMsgEvent.msgSeq) && !decreaseMsgSeqList.contains(new DecreaseMsgSeqInfo(channelMsgEvent.msgSeq, DecreaseMsgSeqInfo.MSGTYPE_NONE)) && addChannelMsgEventToCache(channelMsgEvent)) {
            sortChannelMsgEventList(channelMsgEvent.channelId);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService
    public void addChannelMsgBoxEventList(String str, List<ChannelMsgEvent> list) {
        QLog.d(TAG, 1, "addChannelMsgBoxEventList, channelId = " + str + ", eventList = " + list);
        if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
            IGuildMsgSeqTimeService iGuildMsgSeqTimeService = (IGuildMsgSeqTimeService) this.mApp.getRuntimeService(IGuildMsgSeqTimeService.class, "");
            IGuildMsgSeqTimeService.a readedMsgSeq = iGuildMsgSeqTimeService.getReadedMsgSeq(str);
            HashSet<DecreaseMsgSeqInfo> decreaseMsgSeqList = iGuildMsgSeqTimeService.getDecreaseMsgSeqList(str);
            ArrayList arrayList = new ArrayList();
            boolean z16 = false;
            for (ChannelMsgEvent channelMsgEvent : list) {
                if (channelMsgEvent != null && !decreaseMsgSeqList.contains(new DecreaseMsgSeqInfo(channelMsgEvent.msgSeq, DecreaseMsgSeqInfo.MSGTYPE_NONE)) && (readedMsgSeq == null || readedMsgSeq.f230119d < channelMsgEvent.msgSeq)) {
                    if (addChannelMsgEventToCache(channelMsgEvent)) {
                        arrayList.add(channelMsgEvent);
                        z16 = true;
                    }
                }
            }
            if (z16) {
                sortChannelMsgEventList(str);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService
    public void clearChannelMsgBoxReadEventList(String str, long j3) {
        QLog.d(TAG, 1, "clearChannelMsgBoxReadEventList, channelId = " + str + ", eventType = " + j3);
        if (!TextUtils.isEmpty(str) && this.mChannelMsgEventMap.containsKey(str) && this.mChannelMsgEventMap.get(str) != null) {
            ArrayList arrayList = new ArrayList();
            IGuildMsgSeqTimeService.a readedMsgSeq = ((IGuildMsgSeqTimeService) this.mApp.getRuntimeService(IGuildMsgSeqTimeService.class, "")).getReadedMsgSeq(str);
            QLog.d(TAG, 1, "clearChannelMsgBoxReadEventList, readedMsgSeq = " + readedMsgSeq);
            synchronized (this.mChannelMsgEventMap) {
                Iterator<ChannelMsgEvent> it = this.mChannelMsgEventMap.get(str).iterator();
                while (it.hasNext()) {
                    ChannelMsgEvent next = it.next();
                    if (next != null && next.eventType == j3) {
                        if (next.msgSeq > readedMsgSeq.f230119d) {
                            QLog.d(TAG, 1, "clearChannelMsgBoxReadEventList, event = " + next);
                        } else {
                            arrayList.add(next);
                            it.remove();
                        }
                    }
                }
            }
            arrayList.isEmpty();
            return;
        }
        QLog.d(TAG, 1, "clearChannelMsgBoxReadEventList, channelId = " + str + ": no even list");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService
    public HashMap<String, List<ChannelMsgEvent>> getAllChannelMsgEventList() {
        HashMap<String, List<ChannelMsgEvent>> hashMap = new HashMap<>();
        synchronized (this.mChannelMsgEventMap) {
            for (Map.Entry<String, List<ChannelMsgEvent>> entry : this.mChannelMsgEventMap.entrySet()) {
                if (entry.getValue() != null) {
                    hashMap.put(entry.getKey(), ((ArrayList) entry.getValue()).clone());
                }
            }
            QLog.d(TAG, 2, "getAllChannelMsgEventList, mChannelMsgEventMap = " + this.mChannelMsgEventMap);
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService
    @Nullable
    public List<ChannelMsgEvent> getChannelMsgEventList(String str, long j3) {
        ArrayList arrayList;
        if (!TextUtils.isEmpty(str) && this.mChannelMsgEventMap.containsKey(str) && this.mChannelMsgEventMap.get(str) != null) {
            synchronized (this.mChannelMsgEventMap) {
                arrayList = new ArrayList();
                for (ChannelMsgEvent channelMsgEvent : this.mChannelMsgEventMap.get(str)) {
                    if (channelMsgEvent != null && channelMsgEvent.eventType == j3) {
                        arrayList.add(channelMsgEvent);
                    }
                }
            }
            return arrayList;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService
    public int getChannelMsgEventUnreadCount(String str, long j3) {
        int i3;
        int i16 = 0;
        if (TextUtils.isEmpty(str) || !this.mChannelMsgEventMap.containsKey(str) || this.mChannelMsgEventMap.get(str) == null) {
            return 0;
        }
        IGuildMsgSeqTimeService.a readedMsgSeq = ((IGuildMsgSeqTimeService) this.mApp.getRuntimeService(IGuildMsgSeqTimeService.class, "")).getReadedMsgSeq(str);
        IGProChannelInfo channelInfo = ((IGPSService) this.mApp.getRuntimeService(IGPSService.class, "")).getChannelInfo(str);
        if (channelInfo != null) {
            i3 = channelInfo.getFinalMsgNotify();
        } else {
            i3 = 0;
        }
        synchronized (this.mChannelMsgEventMap) {
            for (ChannelMsgEvent channelMsgEvent : this.mChannelMsgEventMap.get(str)) {
                if (channelMsgEvent != null && channelMsgEvent.msgSeq > readedMsgSeq.f230119d) {
                    if (channelMsgEvent.eventType == j3 && !filterEventTypeForGetUnreadCnt(j3, channelMsgEvent.subType, i3)) {
                        i16++;
                    }
                }
                QLog.d(TAG, 1, "getChannelMsgEventUnreadCount, event = " + channelMsgEvent);
            }
            QLog.d(TAG, 1, "getChannelMsgEventUnreadCount, count = " + i16);
        }
        return i16;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService
    public String getMessageBoxCookie() {
        String currentUin = this.mApp.getCurrentUin();
        if (TextUtils.isEmpty(currentUin)) {
            QLog.d(TAG, 1, "getMessageBoxCookie, spKeyName = null");
            return null;
        }
        return this.mApp.getApp().getSharedPreferences(GUILD_MSG_BOX_SP_NAME, 0).getString(currentUin, "");
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mApp = appRuntime;
        ((AppInterface) appRuntime).addObserver(this.mGuildRegisterProxyObserver, true);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        EntityManager entityManager = this.mEntityManager;
        if (entityManager != null) {
            entityManager.close();
        }
        ((AppInterface) this.mApp).removeObserver(this.mGuildRegisterProxyObserver);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService
    public void removeChannelMsgBoxReadEvent(ChannelMsgEvent channelMsgEvent) {
        QLog.d(TAG, 1, "removeChannelMsgBoxReadEvent, event = " + channelMsgEvent);
        synchronized (this.mChannelMsgEventMap) {
            if (channelMsgEvent != null) {
                if (this.mChannelMsgEventMap.get(channelMsgEvent.channelId) != null && this.mChannelMsgEventMap.get(channelMsgEvent.channelId).contains(channelMsgEvent)) {
                    this.mChannelMsgEventMap.get(channelMsgEvent.channelId).remove(channelMsgEvent);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService
    public boolean setMessageBoxCookie(String str) {
        QLog.d(TAG, 1, "setMessageBoxCookie, cookie = " + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String currentUin = this.mApp.getCurrentUin();
        if (TextUtils.isEmpty(currentUin)) {
            return false;
        }
        this.mApp.getApp().getSharedPreferences(GUILD_MSG_BOX_SP_NAME, 0).edit().putString(currentUin, str).commit();
        return true;
    }

    public void initMsgBoxData() {
    }
}
