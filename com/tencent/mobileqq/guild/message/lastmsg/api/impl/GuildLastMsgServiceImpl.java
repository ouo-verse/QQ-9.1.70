package com.tencent.mobileqq.guild.message.lastmsg.api.impl;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.data.ChannelMsgEvent;
import com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.lastmsg.GuildLastMsgItem;
import com.tencent.mobileqq.guild.message.lastmsg.GuildLastMsgRealTimeProcessor;
import com.tencent.mobileqq.guild.message.lastmsg.a;
import com.tencent.mobileqq.guild.message.lastmsg.api.IGuildLastMsgService;
import com.tencent.mobileqq.guild.message.m;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildLastMsgServiceImpl extends Observable implements IGuildLastMsgService {
    private static final int DELAY_TIMER = 500;
    private static final int MESSAGE_TYPE_NOTIFY_UI = 11;
    private static final String TAG = "GuildLastMsgServiceImpl";
    private AppRuntime app;
    private LastMsgProcessorProvider lastMsgProcessorProvider;
    private GuildLastMsgRealTimeProcessor lastMsgRealTimeProcessor;
    private EntityManager mEm;
    private ConcurrentHashMap<String, GuildLastMsgItem> lastMsgItemMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> readEntityLocks = new ConcurrentHashMap<>();
    private HashSet<com.tencent.mobileqq.guild.message.lastmsg.c> lazyNotifySet = new HashSet<>();
    private volatile long lastNotifyTime = 0;
    private final Observer guildUnreadObserver = new a();
    private Handler mHandler = new Handler(ThreadManagerV2.getQQCommonThreadLooper(), new c());

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements Observer {
        a() {
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            GuildLastMsgItem guildLastMsgItem;
            if (obj instanceof IGuildUnreadCntService.a) {
                IGuildUnreadCntService.a aVar = (IGuildUnreadCntService.a) obj;
                if (aVar.f230838a != 1) {
                    return;
                }
                String str = aVar.f230839b;
                if (TextUtils.isEmpty(str) || (guildLastMsgItem = (GuildLastMsgItem) GuildLastMsgServiceImpl.this.lastMsgItemMap.get(str)) == null) {
                    return;
                }
                synchronized (guildLastMsgItem) {
                    GuildLastMsgServiceImpl.this.updateUnreadCnt(str, guildLastMsgItem);
                    GuildLastMsgServiceImpl.this.updateLastMsgItem(str, guildLastMsgItem);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements IGuildLastMsgService.a {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.message.lastmsg.api.IGuildLastMsgService.a
        public void a(String str, GuildLastMsgItem guildLastMsgItem) {
            if (guildLastMsgItem == null) {
                return;
            }
            GuildLastMsgServiceImpl.this.lazyNotifyLastMsgChange(str, guildLastMsgItem);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (message.what == 11) {
                ArrayList arrayList = new ArrayList();
                synchronized (GuildLastMsgServiceImpl.this.lazyNotifySet) {
                    arrayList.addAll(GuildLastMsgServiceImpl.this.lazyNotifySet);
                    GuildLastMsgServiceImpl.this.lazyNotifySet.clear();
                }
                GuildLastMsgServiceImpl.this.setChanged();
                GuildLastMsgServiceImpl.this.notifyObservers(arrayList);
                GuildLastMsgServiceImpl.this.lastNotifyTime = System.currentTimeMillis();
                QLog.i(GuildLastMsgServiceImpl.TAG, 1, "lazyNotifyLastMsgChange done. notifyEvents size: " + arrayList.size());
                return false;
            }
            return false;
        }
    }

    private void getLastMsgItemAsyncByMsgRevoke(String str) {
        getLastMsgItemAsyncForce(str);
    }

    private void getLastMsgItemAsyncForce(String str) {
        this.lastMsgItemMap.remove(str);
        getLastMsgItemAsync(str, new b());
    }

    private boolean handleAtMeHighlightInfo(String str, GuildLastMsgItem guildLastMsgItem) {
        List<ChannelMsgEvent> channelMsgEventList;
        ChannelMsgEvent channelMsgEvent;
        if (!TextUtils.isEmpty(str) && guildLastMsgItem != null && (channelMsgEventList = ((IGuildMessageBoxDataService) this.app.getRuntimeService(IGuildMessageBoxDataService.class, "")).getChannelMsgEventList(str, 1L)) != null && channelMsgEventList.size() > 0 && (channelMsgEvent = channelMsgEventList.get(0)) != null) {
            int i3 = a.InterfaceC7854a.f230607b;
            int i16 = channelMsgEvent.subType;
            if (i16 == 1) {
                i3 = a.InterfaceC7854a.f230609d;
            } else if (i16 == 2) {
                i3 = a.InterfaceC7854a.f230610e;
            } else if (i16 == 3) {
                i3 = a.InterfaceC7854a.f230611f;
            }
            long j3 = channelMsgEvent.msgSeq;
            if (j3 > ((IGuildMsgSeqTimeService) this.app.getRuntimeService(IGuildMsgSeqTimeService.class, "")).getReadedMsgSeq(str).f230119d) {
                guildLastMsgItem.highlightSeq = j3;
                guildLastMsgItem.highlightBiztype = i3;
                QLog.i(TAG, 1, "hanldeHighlightInfo channelId:" + str + " highlightBiztype:" + i3 + " highlightSeq:" + j3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postInLogicHandler(final String str, final GuildLastMsgItem guildLastMsgItem, final IGuildLastMsgService.a aVar) {
        if (aVar == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.message.lastmsg.api.impl.GuildLastMsgServiceImpl.5
            @Override // java.lang.Runnable
            public void run() {
                aVar.a(str, guildLastMsgItem);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GuildLastMsgItem readEntityAndUpdate(String str) {
        GuildLastMsgItem guildLastMsgItem;
        if (this.readEntityLocks.get(str) == null) {
            synchronized (this.readEntityLocks) {
                if (this.readEntityLocks.get(str) == null) {
                    this.readEntityLocks.put(str, new Object());
                }
            }
        }
        synchronized (this.readEntityLocks.get(str)) {
            guildLastMsgItem = this.lastMsgItemMap.get(str);
            if (guildLastMsgItem == null) {
                guildLastMsgItem = readEntity(str);
                this.lastMsgRealTimeProcessor.k(str, guildLastMsgItem);
                this.lastMsgItemMap.put(str, guildLastMsgItem);
            }
        }
        return guildLastMsgItem;
    }

    @Override // com.tencent.mobileqq.guild.message.lastmsg.api.IGuildLastMsgService
    public synchronized ConcurrentHashMap<String, GuildLastMsgItem> getClonedLastItemMap() {
        return new ConcurrentHashMap<>(this.lastMsgItemMap);
    }

    @Override // com.tencent.mobileqq.guild.message.lastmsg.api.IGuildLastMsgService
    public GuildLastMsgItem getLastMsgItem(final String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return new GuildLastMsgItem();
        }
        GuildLastMsgItem guildLastMsgItem = this.lastMsgItemMap.get(str);
        if (guildLastMsgItem != null) {
            return guildLastMsgItem.m192clone();
        }
        if (!z16) {
            return readEntityAndUpdate(str);
        }
        QLog.i(TAG, 1, "getLastMsgItem readEntityAndUpdate channelId:" + str);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.message.lastmsg.api.impl.GuildLastMsgServiceImpl.3
            @Override // java.lang.Runnable
            public void run() {
                QLog.i(GuildLastMsgServiceImpl.TAG, 1, "getLastMsgItem readEntityAndUpdate run channelId:" + str);
                GuildLastMsgServiceImpl.this.lazyNotifyLastMsgChange(str, GuildLastMsgServiceImpl.this.readEntityAndUpdate(str));
            }
        }, 32, null, true);
        return new GuildLastMsgItem();
    }

    @Override // com.tencent.mobileqq.guild.message.lastmsg.api.IGuildLastMsgService
    public void getLastMsgItemAsync(final String str, final IGuildLastMsgService.a aVar) {
        if (TextUtils.isEmpty(str)) {
            postInLogicHandler(str, null, aVar);
            return;
        }
        GuildLastMsgItem guildLastMsgItem = this.lastMsgItemMap.get(str);
        if (guildLastMsgItem != null) {
            postInLogicHandler(str, guildLastMsgItem, aVar);
            return;
        }
        QLog.i(TAG, 1, "getLastMsgItemAsync readEntityAndUpdate channelId:" + str);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.message.lastmsg.api.impl.GuildLastMsgServiceImpl.4
            @Override // java.lang.Runnable
            public void run() {
                QLog.i(GuildLastMsgServiceImpl.TAG, 1, "getLastMsgItemAsync readEntityAndUpdate run channelId:" + str);
                GuildLastMsgServiceImpl.this.postInLogicHandler(str, GuildLastMsgServiceImpl.this.readEntityAndUpdate(str), aVar);
            }
        }, 32, null, true);
    }

    @Override // com.tencent.mobileqq.guild.message.lastmsg.api.IGuildLastMsgService
    public void lazyNotifyLastMsgChange(String str, GuildLastMsgItem guildLastMsgItem) {
        boolean add;
        if (guildLastMsgItem == null) {
            QLog.i(TAG, 1, "lazyNotifyLastMsgChange channelId:" + str + " msgItem:null");
            return;
        }
        boolean isQQMsgListChannel = ((IGPSService) this.app.getRuntimeService(IGPSService.class, "")).isQQMsgListChannel(guildLastMsgItem.getGuildId(), str);
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "lazyNotifyLastMsgChange. adding to lazyNotifySet. channelId: " + str + ", shmsgseq: " + guildLastMsgItem.message.shmsgseq + ", unreadCnt: " + guildLastMsgItem.msgCnt + ", isInMsgList: " + isQQMsgListChannel);
        }
        com.tencent.mobileqq.guild.message.lastmsg.c cVar = new com.tencent.mobileqq.guild.message.lastmsg.c(str, false, isQQMsgListChannel, 1, guildLastMsgItem.m192clone());
        synchronized (this.lazyNotifySet) {
            if (this.lazyNotifySet.contains(cVar)) {
                this.lazyNotifySet.remove(cVar);
            }
            add = this.lazyNotifySet.add(cVar);
        }
        if (!add) {
            QLog.e(TAG, 1, "lazyNotifyLastMsgChange FAIL! channelId: " + str + ", shmsgseq: " + guildLastMsgItem.message.shmsgseq + ", unreadCnt: " + guildLastMsgItem.msgCnt);
        }
        if (this.mHandler.hasMessages(11)) {
            return;
        }
        if (System.currentTimeMillis() - this.lastNotifyTime > 500) {
            Message message = new Message();
            message.what = 11;
            this.mHandler.sendMessage(message);
        } else {
            Message message2 = new Message();
            message2.what = 11;
            this.mHandler.sendMessageDelayed(message2, 500L);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.app = appRuntime;
        this.mEm = appRuntime.getEntityManagerFactory().createEntityManager();
        this.lastMsgProcessorProvider = new LastMsgProcessorProvider(this.app);
        ((IGuildUnreadCntService) this.app.getRuntimeService(IGuildUnreadCntService.class, "")).addImmediateObserver(this.guildUnreadObserver);
        this.lastMsgRealTimeProcessor = new GuildLastMsgRealTimeProcessor(this.app);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        ((IGuildUnreadCntService) this.app.getRuntimeService(IGuildUnreadCntService.class, "")).deleteObserver(this.guildUnreadObserver);
        this.lastMsgRealTimeProcessor.j();
    }

    @Override // com.tencent.mobileqq.guild.message.lastmsg.api.IGuildLastMsgService
    public void onDraftChangeNotify(String str, String str2, long j3) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onDraftChangeNotify channelId:" + str + " text:" + str2 + " drafttime:" + j3);
        }
        GuildLastMsgItem guildLastMsgItem = this.lastMsgItemMap.get(str);
        if (guildLastMsgItem == null) {
            return;
        }
        synchronized (guildLastMsgItem) {
            guildLastMsgItem.draftText = str2;
            guildLastMsgItem.draftTime = j3;
            updateLastMsgItem(str, guildLastMsgItem);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.lastmsg.api.IGuildLastMsgService
    public void onMsgRevoke(String str, long j3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        GuildLastMsgItem guildLastMsgItem = this.lastMsgItemMap.get(str);
        if (guildLastMsgItem == null) {
            QLog.i(TAG, 1, "onMsgRevoke msgItem is null! channelId:" + str + " msgSeq:" + j3);
            return;
        }
        synchronized (guildLastMsgItem) {
            if (j3 >= guildLastMsgItem.message.shmsgseq) {
                QLog.i(TAG, 1, "onMsgRevoke msg revoke channelId:" + str + " msgItem.message.shmsgseq:" + guildLastMsgItem.message.shmsgseq + " msgSeq:" + j3);
                getLastMsgItemAsyncByMsgRevoke(str);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.message.lastmsg.api.IGuildLastMsgService
    public void onMsgUpdate(String str, long j3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        GuildLastMsgItem guildLastMsgItem = this.lastMsgItemMap.get(str);
        if (guildLastMsgItem == null) {
            QLog.i(TAG, 1, "onMsgUpdate msgItem is null! channelId:" + str + " msgSeq:" + j3);
            return;
        }
        synchronized (guildLastMsgItem) {
            if (j3 >= guildLastMsgItem.message.shmsgseq) {
                QLog.i(TAG, 1, "onMsgUpdate msg update channelId:" + str + " msgSeq:" + j3);
                getLastMsgItemAsyncByMsgRevoke(str);
            }
        }
    }

    protected GuildLastMsgItem readEntity(String str) {
        if (TextUtils.isEmpty(str)) {
            return new GuildLastMsgItem();
        }
        GuildLastMsgItem guildLastMsgItem = new GuildLastMsgItem();
        guildLastMsgItem.channelId = str;
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            com.tencent.imcore.message.Message S = ((m) ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) this.app).F(10014)).y(10014).S(MessageRecord.getTableName(str, 10014), this.mEm);
            if (S == null) {
                S = new com.tencent.imcore.message.Message();
                S.frienduin = str;
                S.istroop = 10014;
                su1.c.e(S, su1.b.c(str));
            } else {
                Iterator<e> it = this.lastMsgProcessorProvider.get().iterator();
                while (it.hasNext()) {
                    it.next().a(S);
                }
            }
            guildLastMsgItem.message = S;
            updateUnreadCnt(str, guildLastMsgItem);
            QLog.i(TAG, 1, "readEntity channelId:" + str + " retMsgItems:" + guildLastMsgItem.toString() + " cost:" + (SystemClock.uptimeMillis() - uptimeMillis));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "readEntity exception + " + e16.getMessage(), e16);
        }
        return guildLastMsgItem;
    }

    protected void saveEntityAsync(String str, GuildLastMsgItem guildLastMsgItem) {
        if (!TextUtils.isEmpty(str) && guildLastMsgItem != null) {
            this.lastMsgRealTimeProcessor.k(str, guildLastMsgItem);
            lazyNotifyLastMsgChange(str, guildLastMsgItem);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.lastmsg.api.IGuildLastMsgService
    public void updateLastMsgItem(String str, GuildLastMsgItem guildLastMsgItem) {
        if (!TextUtils.isEmpty(str) && guildLastMsgItem != null) {
            this.lastMsgItemMap.put(str, guildLastMsgItem);
            saveEntityAsync(str, guildLastMsgItem);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.lastmsg.api.IGuildLastMsgService
    public void updateUnreadCnt(String str, GuildLastMsgItem guildLastMsgItem) {
        if (!TextUtils.isEmpty(str) && guildLastMsgItem != null) {
            IGuildUnreadCntService.c cVar = new IGuildUnreadCntService.c();
            long j3 = cVar.f230844c;
            long j16 = cVar.f230845d;
            long j17 = cVar.f230846e;
            long j18 = j3 + j16 + j17;
            guildLastMsgItem.aboutMeMsgCnt = j18;
            guildLastMsgItem.calendarMsgCnt = j17;
            guildLastMsgItem.msgShowType = cVar.f230847f;
            int i3 = cVar.f230848g;
            if (i3 == 1) {
                guildLastMsgItem.msgCnt = cVar.f230842a;
            } else if (i3 == 2) {
                guildLastMsgItem.msgCnt = cVar.f230843b;
            }
            guildLastMsgItem.highlightBiztype = a.InterfaceC7854a.f230606a;
            guildLastMsgItem.highlightSeq = -1L;
            if (j18 == 1) {
                if (j3 == 1) {
                    handleAtMeHighlightInfo(str, guildLastMsgItem);
                    return;
                }
                if (j16 == 1) {
                    guildLastMsgItem.highlightBiztype = a.InterfaceC7854a.f230608c;
                    guildLastMsgItem.highlightSeq = -1L;
                } else if (j17 == 1) {
                    guildLastMsgItem.highlightBiztype = a.InterfaceC7854a.f230612g;
                }
            }
        }
    }
}
