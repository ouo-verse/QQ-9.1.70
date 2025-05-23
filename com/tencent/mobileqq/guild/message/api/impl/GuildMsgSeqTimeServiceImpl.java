package com.tencent.mobileqq.guild.message.api.impl;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.eventflow.GuildEventFlowTimeItem;
import com.tencent.mobileqq.guild.message.registerproxy.GuildRegisterProxyMsgHandler;
import com.tencent.mobileqq.guild.message.unread.DecreaseMsgSeqInfo;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.BaseTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildMsgSeqTimeServiceImpl extends Observable implements IGuildMsgSeqTimeService {
    private AppRuntime appRuntime;
    private EntityManager mEm;
    private final String TAG = "GuildMsgSeqTimeServiceImpl";
    private volatile ConcurrentHashMap<String, a> msgSeqTimeItemMap = new ConcurrentHashMap<>();
    private ArrayList<String> syncSaveList = new ArrayList<>();
    private HashMap<String, IGuildMsgSeqTimeService.a> mLatestHasSeenMsgMap = new HashMap<>();
    private HashMap<String, Pair<Long, byte[]>> mLatestMsgTokenMap = new HashMap<>();
    private CopyOnWriteArraySet<Observer> notifyObservers = new CopyOnWriteArraySet<>();
    private final Object lock = new Object();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f230138a;

        /* renamed from: b, reason: collision with root package name */
        public String f230139b;

        /* renamed from: c, reason: collision with root package name */
        public IGuildMsgSeqTimeService.a f230140c = new IGuildMsgSeqTimeService.a();

        /* renamed from: d, reason: collision with root package name */
        public IGuildMsgSeqTimeService.a f230141d = new IGuildMsgSeqTimeService.a();

        /* renamed from: e, reason: collision with root package name */
        public IGuildMsgSeqTimeService.a f230142e = new IGuildMsgSeqTimeService.a();

        /* renamed from: f, reason: collision with root package name */
        public IGuildMsgSeqTimeService.a f230143f = new IGuildMsgSeqTimeService.a();

        /* renamed from: g, reason: collision with root package name */
        public long f230144g = 0;

        /* renamed from: h, reason: collision with root package name */
        public HashSet<DecreaseMsgSeqInfo> f230145h = new HashSet<>();

        /* renamed from: i, reason: collision with root package name */
        public GuildEventFlowTimeItem f230146i = new GuildEventFlowTimeItem();

        public a(String str, String str2) {
            this.f230138a = str;
            this.f230139b = str2;
        }
    }

    private ConcurrentHashMap<String, a> getMsgSeqTimeItemMap() {
        return this.msgSeqTimeItemMap;
    }

    private BaseTransaction getTransactionObj(Entity entity) {
        if (entity == null || !this.mEm.isOpen()) {
            return null;
        }
        if (entity.getStatus() == 1000) {
            return new PersistOrReplaceTransaction(entity);
        }
        if (entity.getStatus() != 1001 && entity.getStatus() != 1002) {
            return null;
        }
        return new UpdateTransaction(entity);
    }

    private void notifyUnreadCntSeqChange(String str) {
        for (Observer observer : (Observer[]) this.notifyObservers.toArray(new Observer[0])) {
            observer.update(this, str);
        }
    }

    private boolean updateEntity(Entity entity) {
        if (this.mEm.isOpen()) {
            if (entity.getStatus() == 1000) {
                this.mEm.persistOrReplace(entity);
                if (entity.getStatus() != 1001) {
                    return false;
                }
                return true;
            }
            if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
                return this.mEm.update(entity);
            }
        }
        return false;
    }

    private boolean verifyLastLocalMsgSeq(String str, String str2, IGuildMsgSeqTimeService.a aVar) {
        if (TextUtils.isEmpty(str2) || aVar == null) {
            return false;
        }
        if (!getMsgSeqTimeItemMap().containsKey(str2)) {
            return true;
        }
        a aVar2 = getMsgSeqTimeItemMap().get(str2);
        synchronized (aVar2) {
            if (aVar2.f230140c.f230119d <= aVar.f230119d) {
                return true;
            }
            QLog.e("GuildMsgSeqTimeServiceImpl", 1, "verifyLastLocalMsgSeq error guildid:" + str + " channelid:" + str2 + " localMsgSeq:" + aVar2.f230140c.toString() + " msgSeqTimeItemSvr:" + aVar.toString());
            aVar2.f230140c.e(aVar);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public void addDecreaseMsgSeq(String str, String str2, DecreaseMsgSeqInfo decreaseMsgSeqInfo) {
        boolean z16;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && decreaseMsgSeqInfo != null) {
            getMsgSeqTimeItemMap().putIfAbsent(str2, new a(str, str2));
            a aVar = getMsgSeqTimeItemMap().get(str2);
            synchronized (aVar) {
                if (decreaseMsgSeqInfo.msgSeq > aVar.f230142e.f230119d && !aVar.f230145h.contains(decreaseMsgSeqInfo)) {
                    aVar.f230145h.add(decreaseMsgSeqInfo);
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
            if (z16) {
                saveEntityAsync(str2);
                notifyUnreadCntSeqChange(str2);
            }
        }
    }

    @Override // java.util.Observable, com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public void addObserver(Observer observer) {
        this.notifyObservers.add(observer);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public void delDecreaseMsgSeq(String str, DecreaseMsgSeqInfo decreaseMsgSeqInfo) {
        a aVar;
        boolean remove;
        if (TextUtils.isEmpty(str) || decreaseMsgSeqInfo == null || (aVar = getMsgSeqTimeItemMap().get(str)) == null) {
            return;
        }
        synchronized (aVar) {
            remove = aVar.f230145h.remove(decreaseMsgSeqInfo);
        }
        if (remove) {
            saveEntityAsync(str);
            notifyUnreadCntSeqChange(str);
        }
    }

    @Override // java.util.Observable, com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public void deleteObserver(Observer observer) {
        this.notifyObservers.remove(observer);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public HashSet<DecreaseMsgSeqInfo> getDecreaseMsgSeqList(String str) {
        HashSet<DecreaseMsgSeqInfo> hashSet;
        if (!TextUtils.isEmpty(str) && getMsgSeqTimeItemMap().containsKey(str)) {
            a aVar = getMsgSeqTimeItemMap().get(str);
            synchronized (aVar) {
                hashSet = (HashSet) aVar.f230145h.clone();
            }
            return hashSet;
        }
        return new HashSet<>();
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public GuildEventFlowTimeItem getEventFlowTimeItem(String str) {
        GuildEventFlowTimeItem m191clone;
        if (!TextUtils.isEmpty(str) && getMsgSeqTimeItemMap().containsKey(str)) {
            a aVar = getMsgSeqTimeItemMap().get(str);
            synchronized (aVar) {
                m191clone = aVar.f230146i.m191clone();
            }
            return m191clone;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public long getExpiredMsgSeq(String str) {
        long j3;
        if (!TextUtils.isEmpty(str) && getMsgSeqTimeItemMap().containsKey(str)) {
            a aVar = getMsgSeqTimeItemMap().get(str);
            synchronized (aVar) {
                j3 = aVar.f230144g;
            }
            return j3;
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public IGuildMsgSeqTimeService.a getLastLocallMsgSeq(String str) {
        IGuildMsgSeqTimeService.a clone;
        if (!TextUtils.isEmpty(str) && getMsgSeqTimeItemMap().containsKey(str)) {
            a aVar = getMsgSeqTimeItemMap().get(str);
            synchronized (aVar) {
                clone = aVar.f230140c.clone();
            }
            return clone;
        }
        return new IGuildMsgSeqTimeService.a();
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public IGuildMsgSeqTimeService.a getLastLocallVisibleMsgSeq(String str) {
        IGuildMsgSeqTimeService.a clone;
        if (!TextUtils.isEmpty(str) && getMsgSeqTimeItemMap().containsKey(str)) {
            a aVar = getMsgSeqTimeItemMap().get(str);
            synchronized (aVar) {
                clone = aVar.f230143f.clone();
            }
            return clone;
        }
        return new IGuildMsgSeqTimeService.a();
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public IGuildMsgSeqTimeService.a getLastSvrMsgSeq(String str) {
        IGuildMsgSeqTimeService.a clone;
        if (!TextUtils.isEmpty(str) && getMsgSeqTimeItemMap().containsKey(str)) {
            a aVar = getMsgSeqTimeItemMap().get(str);
            synchronized (aVar) {
                clone = aVar.f230141d.clone();
            }
            return clone;
        }
        return new IGuildMsgSeqTimeService.a();
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public IGuildMsgSeqTimeService.a getLatestHasSeenMsg(String str) {
        synchronized (this.mLatestHasSeenMsgMap) {
            if (!TextUtils.isEmpty(str) && this.mLatestHasSeenMsgMap.containsKey(str) && this.mLatestHasSeenMsgMap.get(str) != null) {
                return this.mLatestHasSeenMsgMap.get(str).clone();
            }
            return null;
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public Pair<Long, byte[]> getLatestMsgToken(String str) {
        synchronized (this.mLatestMsgTokenMap) {
            if (!TextUtils.isEmpty(str) && this.mLatestMsgTokenMap.containsKey(str) && this.mLatestMsgTokenMap.get(str) != null && this.mLatestMsgTokenMap.get(str).second != null) {
                return new Pair<>((Long) this.mLatestMsgTokenMap.get(str).first, (byte[]) ((byte[]) this.mLatestMsgTokenMap.get(str).second).clone());
            }
            return null;
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public IGuildMsgSeqTimeService.a getReadedMsgSeq(String str) {
        IGuildMsgSeqTimeService.a clone;
        if (!TextUtils.isEmpty(str) && getMsgSeqTimeItemMap().containsKey(str)) {
            a aVar = getMsgSeqTimeItemMap().get(str);
            synchronized (aVar) {
                clone = aVar.f230142e.clone();
            }
            return clone;
        }
        return new IGuildMsgSeqTimeService.a();
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public IGuildMsgSeqTimeService.a getReportSeqTimeItem(String str, boolean z16) {
        return com.tencent.mobileqq.guild.message.unread.c.b((AppInterface) this.appRuntime, str, z16);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.appRuntime = appRuntime;
        this.mEm = appRuntime.getEntityManagerFactory().createEntityManager();
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public void setEventFlowTimeItem(String str, String str2, GuildEventFlowTimeItem guildEventFlowTimeItem) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        getMsgSeqTimeItemMap().putIfAbsent(str2, new a(str, str2));
        a aVar = getMsgSeqTimeItemMap().get(str2);
        synchronized (aVar) {
            aVar.f230146i = guildEventFlowTimeItem;
        }
        saveEntityAsync(str2);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public void setExpiredMsgSeq(String str, String str2, long j3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            getMsgSeqTimeItemMap().putIfAbsent(str2, new a(str, str2));
            a aVar = getMsgSeqTimeItemMap().get(str2);
            synchronized (aVar) {
                aVar.f230144g = j3;
            }
            saveEntityAsync(str2);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public boolean setLastLocalMsgSeq(String str, String str2, IGuildMsgSeqTimeService.a aVar) {
        if (TextUtils.isEmpty(str2) || aVar == null) {
            return false;
        }
        getMsgSeqTimeItemMap().putIfAbsent(str2, new a(str, str2));
        a aVar2 = getMsgSeqTimeItemMap().get(str2);
        synchronized (aVar2) {
            if (aVar.f230119d <= aVar2.f230140c.f230119d) {
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.i("GuildMsgSeqTimeServiceImpl", 2, "setLastLocalMsgSeq guildid:" + str + " channelid:" + str2 + " localMsgSeqTimeItem(old):" + aVar2.f230140c.toString());
            }
            aVar2.f230140c.e(aVar);
            if (QLog.isColorLevel()) {
                QLog.i("GuildMsgSeqTimeServiceImpl", 2, "setLastLocalMsgSeq guildid:" + str + " channelid:" + str2 + " localMsgSeqTimeItem(new):" + aVar2.f230140c.toString());
            }
            saveEntityAsync(str2);
            return true;
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public boolean setLastLocalVisibleMsgSeq(String str, String str2, IGuildMsgSeqTimeService.a aVar) {
        if (TextUtils.isEmpty(str2) || aVar == null) {
            return false;
        }
        getMsgSeqTimeItemMap().putIfAbsent(str2, new a(str, str2));
        a aVar2 = getMsgSeqTimeItemMap().get(str2);
        synchronized (aVar2) {
            if (aVar.f230119d <= aVar2.f230143f.f230119d) {
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.i("GuildMsgSeqTimeServiceImpl", 2, "setLastLocalVisibleMsgSeq guildid:" + str + " channelid:" + str2 + " localVisibleMsgSeqTimeItem(old):" + aVar2.f230143f.toString());
            }
            aVar2.f230143f.e(aVar);
            if (QLog.isColorLevel()) {
                QLog.i("GuildMsgSeqTimeServiceImpl", 2, "setLastLocalVisibleMsgSeq guildid:" + str + " channelid:" + str2 + " localVisibleMsgSeqTimeItem(new):" + aVar2.f230143f.toString());
            }
            saveEntityAsync(str2);
            return true;
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public boolean setLastSvrMsgSeq(String str, String str2, IGuildMsgSeqTimeService.a aVar, boolean z16) {
        if (TextUtils.isEmpty(str2) || aVar == null) {
            return false;
        }
        getMsgSeqTimeItemMap().putIfAbsent(str2, new a(str, str2));
        a aVar2 = getMsgSeqTimeItemMap().get(str2);
        synchronized (aVar2) {
            if (aVar.f230119d <= aVar2.f230141d.f230119d) {
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.i("GuildMsgSeqTimeServiceImpl", 2, "setLastSvrMsgSeq guildid:" + str + " channelid:" + str2 + " svrMsgSeqTimeItem(old):" + aVar2.f230141d.toString());
            }
            aVar2.f230141d.e(aVar);
            if (QLog.isColorLevel()) {
                QLog.i("GuildMsgSeqTimeServiceImpl", 2, "setLastSvrMsgSeq guildid:" + str + " channelid:" + str2 + " svrMsgSeqTimeItem(new):" + aVar2.f230141d.toString());
            }
            saveEntityAsync(str2);
            if (z16) {
                notifyUnreadCntSeqChange(str2);
                return true;
            }
            return true;
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public void setLatestHasSeenMsg(String str, IGuildMsgSeqTimeService.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.mLatestHasSeenMsgMap) {
            this.mLatestHasSeenMsgMap.put(str, aVar);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public void setLatestMsgToken(String str, long j3, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null) {
            synchronized (this.mLatestMsgTokenMap) {
                this.mLatestMsgTokenMap.put(str, new Pair<>(Long.valueOf(j3), bArr));
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public boolean setReadedMsgSeq(String str, String str2, IGuildMsgSeqTimeService.a aVar, boolean z16) {
        if (!TextUtils.isEmpty(str2) && aVar != null) {
            getMsgSeqTimeItemMap().putIfAbsent(str2, new a(str, str2));
            a aVar2 = getMsgSeqTimeItemMap().get(str2);
            synchronized (aVar2) {
                long j3 = aVar.f230119d;
                IGuildMsgSeqTimeService.a aVar3 = aVar2.f230142e;
                long j16 = aVar3.f230119d;
                if (j3 < j16) {
                    return false;
                }
                if (j3 == j16 && aVar.f230120e <= aVar3.f230120e) {
                    return false;
                }
                String str3 = "";
                if (QLog.isColorLevel()) {
                    str3 = "setReadedMsgSeq guildid:" + str + " channelid:" + str2 + " readedMsgSeqTimeItem(old):" + aVar2.f230142e.toString();
                }
                aVar2.f230142e.e(aVar);
                if (QLog.isColorLevel()) {
                    QLog.i("GuildMsgSeqTimeServiceImpl", 2, str3 + " readedMsgSeqTimeItem(new):" + aVar2.f230142e.toString());
                }
                delDecreaseMsgSeq(str2, aVar2.f230142e.f230119d);
                saveEntityAsync(str2);
                if (z16) {
                    notifyUnreadCntSeqChange(str2);
                }
                return true;
            }
        }
        QLog.i("GuildMsgSeqTimeServiceImpl", 1, "setReadedMsgSeq, channelid : " + str2 + ", readMsgSeqTimeItem : " + aVar);
        return false;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public void updateLastSeqAndTime(ArrayList<MessageRecord> arrayList) {
        if (arrayList.isEmpty()) {
            return;
        }
        IGuildMessageUtilsApi iGuildMessageUtilsApi = (IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class);
        IGuildMsgSeqTimeService iGuildMsgSeqTimeService = (IGuildMsgSeqTimeService) ch.R0(IGuildMsgSeqTimeService.class);
        com.tencent.mobileqq.guild.message.registerproxy.g gVar = (com.tencent.mobileqq.guild.message.registerproxy.g) ch.j(GuildRegisterProxyMsgHandler.class);
        Iterator<MessageRecord> it = arrayList.iterator();
        while (it.hasNext()) {
            MessageRecord next = it.next();
            if (iGuildMessageUtilsApi.isLocalOnlyMsg(next)) {
                if (QLog.isColorLevel()) {
                    QLog.d("GuildMsgSeqTimeServiceImpl", 2, "updateLastSeqAndTime. isLocalOnlyMsg = true, will not update last seq");
                }
            } else {
                IGuildMsgSeqTimeService.a aVar = new IGuildMsgSeqTimeService.a(next.shmsgseq, iGuildMessageUtilsApi.getCntSeqFromMR(next), next.time, iGuildMessageUtilsApi.getMsgMetaFromMr(next));
                String b16 = su1.c.b(next);
                String a16 = su1.c.a(next);
                iGuildMsgSeqTimeService.setLastLocalMsgSeq(b16, a16, aVar);
                iGuildMsgSeqTimeService.setLastSvrMsgSeq(b16, a16, aVar, true);
                if (su1.c.d(next)) {
                    iGuildMsgSeqTimeService.setLastLocalVisibleMsgSeq(b16, a16, aVar);
                }
                gVar.f1(next.time);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public boolean verifyLastLocalVisibleMsgSeq(String str, String str2, IGuildMsgSeqTimeService.a aVar) {
        if (TextUtils.isEmpty(str2) || aVar == null) {
            return false;
        }
        if (!getMsgSeqTimeItemMap().containsKey(str2)) {
            return true;
        }
        a aVar2 = getMsgSeqTimeItemMap().get(str2);
        synchronized (aVar2) {
            if (aVar2.f230143f.f230119d <= aVar.f230119d) {
                return true;
            }
            QLog.e("GuildMsgSeqTimeServiceImpl", 1, "verifyLastLocalVisibleMsgSeq error guildid:" + str + " channelid:" + str2 + " localMsgSeq:" + aVar2.f230143f.toString() + " msgSeqTimeItemSvr:" + aVar.toString());
            aVar2.f230143f.e(aVar);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public boolean verifyLastSvrMsgSeq(String str, String str2, IGuildMsgSeqTimeService.a aVar) {
        if (!TextUtils.isEmpty(str2) && aVar != null) {
            verifyLastLocalMsgSeq(str, str2, aVar);
            verifyLastLocalVisibleMsgSeq(str, str2, aVar);
            getMsgSeqTimeItemMap().putIfAbsent(str2, new a(str, str2));
            a aVar2 = getMsgSeqTimeItemMap().get(str2);
            if (QLog.isColorLevel()) {
                QLog.i("GuildMsgSeqTimeServiceImpl", 2, "verifyLastSvrMsgSeq guildid:" + str + " channelid:" + str2 + " svrMsgSeqTimeItem(old):" + aVar2.f230141d.toString());
            }
            synchronized (aVar2) {
                aVar2.f230141d.e(aVar);
            }
            if (QLog.isColorLevel()) {
                QLog.i("GuildMsgSeqTimeServiceImpl", 2, "verifyLastSvrMsgSeq guildid:" + str + " channelid:" + str2 + " svrMsgSeqTimeItem(new):" + aVar2.f230141d.toString());
            }
            saveEntityAsync(str2);
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public boolean verifyReadedMsgSeq(String str, String str2, IGuildMsgSeqTimeService.a aVar) {
        boolean z16 = false;
        if (TextUtils.isEmpty(str2) || aVar == null) {
            return false;
        }
        getMsgSeqTimeItemMap().putIfAbsent(str2, new a(str, str2));
        a aVar2 = getMsgSeqTimeItemMap().get(str2);
        synchronized (aVar2) {
            if (!aVar2.f230142e.d() || aVar2.f230142e.f230119d <= aVar.f230119d) {
                z16 = true;
            }
            if (!z16) {
                QLog.e("GuildMsgSeqTimeServiceImpl", 1, "verifyReadedMsgSeq error readedMsgSeq:" + aVar2.f230142e.toString() + " readMsgSeqTimeItemSvr:" + aVar.toString());
            }
            aVar2.f230142e.e(aVar);
        }
        delDecreaseMsgSeq(str2, aVar2.f230142e.f230119d);
        saveEntityAsync(str2);
        return z16;
    }

    protected void delDecreaseMsgSeq(String str, long j3) {
        if (TextUtils.isEmpty(str) || !getMsgSeqTimeItemMap().containsKey(str)) {
            return;
        }
        a aVar = getMsgSeqTimeItemMap().get(str);
        synchronized (aVar) {
            HashSet<DecreaseMsgSeqInfo> hashSet = new HashSet<>();
            Iterator<DecreaseMsgSeqInfo> it = aVar.f230145h.iterator();
            while (it.hasNext()) {
                DecreaseMsgSeqInfo next = it.next();
                if (next.msgSeq > j3) {
                    hashSet.add(next);
                }
            }
            aVar.f230145h = hashSet;
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public void setEventFlowTimeItem(String str, String str2, long j3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        getMsgSeqTimeItemMap().putIfAbsent(str2, new a(str, str2));
        a aVar = getMsgSeqTimeItemMap().get(str2);
        synchronized (aVar) {
            aVar.f230146i.registProxyTime = j3;
        }
        saveEntityAsync(str2);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
    public void setEventFlowTimeItem(String str, String str2, long j3, long j16, byte[] bArr) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        getMsgSeqTimeItemMap().putIfAbsent(str2, new a(str, str2));
        a aVar = getMsgSeqTimeItemMap().get(str2);
        synchronized (aVar) {
            GuildEventFlowTimeItem guildEventFlowTimeItem = aVar.f230146i;
            guildEventFlowTimeItem.eventBeginTime = j3;
            guildEventFlowTimeItem.eventEndTime = j16;
            guildEventFlowTimeItem.cookie = bArr;
        }
        saveEntityAsync(str2);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }

    protected void saveEntityAsync(String str) {
    }
}
