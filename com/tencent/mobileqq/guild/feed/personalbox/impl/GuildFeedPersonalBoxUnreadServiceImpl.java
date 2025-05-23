package com.tencent.mobileqq.guild.feed.personalbox.impl;

import android.content.SharedPreferences;
import android.text.TextUtils;
import cn1.b;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.feed.personalbox.GuildFeedPersonalBoxHandler;
import com.tencent.mobileqq.guild.feed.personalbox.IGuildFeedPersonalBoxUnreadService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import tencent.im.group_pro_proto.msgpush.servtype$FeedEvent;
import tencent.im.group_pro_proto.msgpush.servtype$ReadFeedNotify;
import tencent.im.group_pro_proto.synclogic.synclogic$FeedsEventNode;

/* loaded from: classes13.dex */
public class GuildFeedPersonalBoxUnreadServiceImpl extends Observable implements IGuildFeedPersonalBoxUnreadService {
    public static final String GUILD_FEED_EVENT_INFO = "guild_feed_event_info_";
    public static final String KEY_FEED_EVENT_LASTFEEDID = "feed_event_lastFeedId_";
    public static final String KEY_FEED_EVENT_LASTMSGSUMMARY = "feed_event_lastMsgSummary_";
    public static final String KEY_FEED_EVENT_LASTMSGTIME = "feed_event_lastMsgTime_";
    public static final String KEY_FEED_EVENT_UNREADNUM = "feed_event_unreadNum_";
    public static final String KEY_FEED_EVENT_UNREADTIMESTAMP = "feed_event_unreadTimeStamp_";
    public static final int MAX_CACHE_SIZE = 100;
    public static final String TAG = "GuildFeedPersonalBoxUnreadServiceImpl";
    private AppRuntime mApp;
    protected SharedPreferences mSp;
    private String mUin;
    private long mUnreadNum = 0;
    private long mUnreadTimeStamp = 0;
    private String mLastMsgSummary = "";
    private long mLastMsgTime = 0;
    private String mLastFeedId = "";
    private ConcurrentHashMap<String, Long> feedIdAndTimeCache = new ConcurrentHashMap<>();

    private void addFeedEventToCache(long j3, String str) {
        this.feedIdAndTimeCache.put(str, Long.valueOf(j3));
        if (this.feedIdAndTimeCache.size() > 100) {
            String str2 = "";
            long j16 = Long.MAX_VALUE;
            for (Map.Entry<String, Long> entry : this.feedIdAndTimeCache.entrySet()) {
                if (entry.getValue().longValue() < j16) {
                    j16 = entry.getValue().longValue();
                    str2 = entry.getKey();
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                this.feedIdAndTimeCache.remove(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLogStr() {
        return " {info} mLastMsgSummary:" + this.mLastMsgSummary + " mLastMsgTime:" + this.mLastMsgTime + " mLastFeedId:" + this.mLastFeedId + " mUnreadTimeStamp:" + this.mUnreadTimeStamp + " mUnreadNum:" + this.mUnreadNum + ", this: " + hashCode();
    }

    private void handleReadFeedEvent(long j3) {
        long j16 = this.mUnreadTimeStamp;
        if (j3 < j16) {
            j3 = j16;
        }
        removeCacheByTime(j3);
        this.mUnreadTimeStamp = j3;
        this.mUnreadNum = this.feedIdAndTimeCache.size();
        notifyLastMsgChange();
        QLog.i(TAG, 1, "handleReadFeedEvent readedTime:" + j3 + getLogStr());
    }

    private void initLoadData() {
        this.mUnreadNum = this.mSp.getLong(KEY_FEED_EVENT_UNREADNUM, 0L);
        this.mUnreadTimeStamp = this.mSp.getLong(KEY_FEED_EVENT_UNREADTIMESTAMP, 0L);
        this.mLastMsgSummary = this.mSp.getString(KEY_FEED_EVENT_LASTMSGSUMMARY, "");
        this.mLastMsgTime = this.mSp.getLong(KEY_FEED_EVENT_LASTMSGTIME, 0L);
        this.mLastFeedId = this.mSp.getString(KEY_FEED_EVENT_LASTFEEDID, "");
    }

    private void notifyLastMsgChange() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.personalbox.impl.GuildFeedPersonalBoxUnreadServiceImpl.1
            @Override // java.lang.Runnable
            public void run() {
                GuildFeedPersonalBoxUnreadServiceImpl.this.setChanged();
                GuildFeedPersonalBoxUnreadServiceImpl guildFeedPersonalBoxUnreadServiceImpl = GuildFeedPersonalBoxUnreadServiceImpl.this;
                guildFeedPersonalBoxUnreadServiceImpl.notifyObservers(guildFeedPersonalBoxUnreadServiceImpl.getGuildFeedPersonalBoxLastMsg());
                if (QLog.isColorLevel()) {
                    QLog.i(GuildFeedPersonalBoxUnreadServiceImpl.TAG, 2, "notifyLastMsgChange:" + GuildFeedPersonalBoxUnreadServiceImpl.this.getLogStr());
                }
                GuildFeedPersonalBoxUnreadServiceImpl.this.saveData();
            }
        });
    }

    private void realDoReport(long j3) {
        AppRuntime appRuntime = this.mApp;
        if (appRuntime instanceof AppInterface) {
            ((b) ((AppInterface) appRuntime).getBusinessHandler(GuildFeedPersonalBoxHandler.class.getName())).z2(j3);
            handleReadFeedEvent(j3);
        } else {
            QLog.e(TAG, 1, "mApp is NOT AppInterface.");
        }
    }

    private void removeCacheByTime(long j3) {
        Iterator<Map.Entry<String, Long>> it = this.feedIdAndTimeCache.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().longValue() <= j3) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveData() {
        this.mSp.edit().putLong(KEY_FEED_EVENT_UNREADNUM, this.mUnreadNum).putLong(KEY_FEED_EVENT_UNREADTIMESTAMP, this.mUnreadTimeStamp).putString(KEY_FEED_EVENT_LASTMSGSUMMARY, this.mLastMsgSummary).putLong(KEY_FEED_EVENT_LASTMSGTIME, this.mLastMsgTime).putString(KEY_FEED_EVENT_LASTFEEDID, this.mLastFeedId).commit();
    }

    @Override // com.tencent.mobileqq.guild.feed.personalbox.IGuildFeedPersonalBoxUnreadService
    public IGuildFeedPersonalBoxUnreadService.a getGuildFeedPersonalBoxLastMsg() {
        IGuildFeedPersonalBoxUnreadService.a aVar = new IGuildFeedPersonalBoxUnreadService.a();
        IGuildUnreadCntService.b bVar = aVar.f222745a;
        bVar.f230840d = this.mUnreadNum;
        bVar.f230841e = 1;
        aVar.f222746b = this.mLastMsgSummary;
        aVar.f222747c = this.mLastMsgTime;
        aVar.f222748d = this.mLastFeedId;
        QLog.d(TAG, 2, "getGuildFeedPersonalBoxLastMsg:" + aVar.toString() + ", this: " + hashCode());
        return aVar;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mApp = appRuntime;
        this.mUin = appRuntime.getCurrentAccountUin();
        this.mSp = this.mApp.getApplication().getSharedPreferences(GUILD_FEED_EVENT_INFO + this.mUin, 0);
        initLoadData();
    }

    @Override // com.tencent.mobileqq.guild.feed.personalbox.IGuildFeedPersonalBoxUnreadService
    public synchronized void onFeedsEventOnlinePush(servtype$FeedEvent servtype_feedevent) {
        if (servtype_feedevent == null) {
            return;
        }
        String str = servtype_feedevent.str_msg_summary.get();
        long j3 = servtype_feedevent.uint64_event_time.get();
        String str2 = servtype_feedevent.str_feed_id.get();
        if (this.feedIdAndTimeCache.contains(str2)) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "onFeedsEventOnlinePush find lastMsgFeedsId:" + str2);
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onFeedsEventOnlinePush lastMsgTime:" + j3);
        }
        if (j3 >= this.mLastMsgTime) {
            this.mLastMsgSummary = str;
            this.mLastMsgTime = j3;
            this.mLastFeedId = str2;
        }
        if (j3 >= this.mUnreadTimeStamp) {
            this.mUnreadNum++;
        }
        addFeedEventToCache(j3, str2);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onFeedsEventOnlinePush:" + getLogStr());
        }
        notifyLastMsgChange();
    }

    @Override // com.tencent.mobileqq.guild.feed.personalbox.IGuildFeedPersonalBoxUnreadService
    public synchronized void onReadFeedEventPush(servtype$ReadFeedNotify servtype_readfeednotify) {
        if (servtype_readfeednotify == null) {
            return;
        }
        long j3 = servtype_readfeednotify.report_time.get();
        QLog.i(TAG, 2, "onReadFeedEventPush. readedTime: " + j3);
        handleReadFeedEvent(j3);
    }

    @Override // com.tencent.mobileqq.guild.feed.personalbox.IGuildFeedPersonalBoxUnreadService
    public synchronized void onReceiveRegistProxy(synclogic$FeedsEventNode synclogic_feedseventnode) {
        if (synclogic_feedseventnode == null) {
            return;
        }
        long j3 = synclogic_feedseventnode.unread_num.get();
        String stringUtf8 = synclogic_feedseventnode.msg_summary.get().toStringUtf8();
        long j16 = synclogic_feedseventnode.last_event_time.get();
        String stringUtf82 = synclogic_feedseventnode.last_feed_id.get().toStringUtf8();
        if (j16 >= this.mLastMsgTime) {
            this.mLastMsgSummary = stringUtf8;
            this.mLastMsgTime = j16;
            this.mLastFeedId = stringUtf82;
        }
        this.mUnreadTimeStamp = j16;
        this.mUnreadNum = j3;
        removeCacheByTime(j16);
        this.mUnreadNum += this.feedIdAndTimeCache.size();
        notifyLastMsgChange();
        QLog.i(TAG, 1, "feedIdAndTimeCache.size:" + this.feedIdAndTimeCache.size() + getLogStr());
    }

    @Override // com.tencent.mobileqq.guild.feed.personalbox.IGuildFeedPersonalBoxUnreadService
    public void reportFeedRead() {
        realDoReport(this.mLastMsgTime);
    }

    @Override // com.tencent.mobileqq.guild.feed.personalbox.IGuildFeedPersonalBoxUnreadService
    public void reportFeedRead(long j3) {
        long j16 = this.mLastMsgTime;
        if (j3 > j16) {
            realDoReport(j3);
        } else {
            realDoReport(j16);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
