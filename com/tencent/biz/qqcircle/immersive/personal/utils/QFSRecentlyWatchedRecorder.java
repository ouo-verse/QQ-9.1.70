package com.tencent.biz.qqcircle.immersive.personal.utils;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.LruCache;
import com.tencent.biz.qcircleshadow.lib.variation.HostAppSettingUtil;
import com.tencent.biz.qcircleshadow.libmanager.QCircleListenerProxyManager;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSAddViewHistoryRequest;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.qcircle.api.IQQFrontBackListener;
import com.tencent.qcircle.cooperation.config.AccountChangeEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.call.Call;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleFeedBase$StViewedFeedData;
import qqcircle.QQCircleFeedBase$ViewedFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSRecentlyWatchedRecorder implements Call.OnRspCallBack<QFSAddViewHistoryRequest>, IQQFrontBackListener, SimpleEventReceiver {
    private static volatile QFSRecentlyWatchedRecorder C;

    /* renamed from: d, reason: collision with root package name */
    private final int f89054d;

    /* renamed from: e, reason: collision with root package name */
    private final long f89055e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f89056f;

    /* renamed from: h, reason: collision with root package name */
    private final String f89057h;

    /* renamed from: i, reason: collision with root package name */
    private final LruCache<String, QQCircleFeedBase$ViewedFeed> f89058i;

    /* renamed from: m, reason: collision with root package name */
    private final Runnable f89059m = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.utils.QFSRecentlyWatchedRecorder.1
        @Override // java.lang.Runnable
        public void run() {
            if (!QFSRecentlyWatchedRecorder.this.f89056f) {
                return;
            }
            QFSRecentlyWatchedRecorder.this.x();
            RFWThreadManager.getInstance().getSerialThreadHandler().postDelayed(QFSRecentlyWatchedRecorder.this.f89059m, QFSRecentlyWatchedRecorder.this.f89055e);
        }
    };

    QFSRecentlyWatchedRecorder() {
        int G4 = uq3.c.G4();
        this.f89054d = G4;
        this.f89055e = uq3.c.F4();
        this.f89056f = uq3.c.z0();
        this.f89057h = r.q();
        this.f89058i = new LruCache<>(G4);
        s();
        u();
        QCircleListenerProxyManager.getInstance().addQQFrontBackListener(this);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @NonNull
    private QQCircleFeedBase$ViewedFeed h(@NotNull e30.b bVar, long j3) {
        QQCircleFeedBase$ViewedFeed qQCircleFeedBase$ViewedFeed = new QQCircleFeedBase$ViewedFeed();
        String str = bVar.g().f398449id.get();
        long j16 = bVar.g().createTime.get();
        String str2 = bVar.g().poster.f398463id.get();
        qQCircleFeedBase$ViewedFeed.view_time.set(j3);
        qQCircleFeedBase$ViewedFeed.feed_id.set(str);
        qQCircleFeedBase$ViewedFeed.feed_create_time.set(j16);
        qQCircleFeedBase$ViewedFeed.feed_uid.set(str2);
        return qQCircleFeedBase$ViewedFeed;
    }

    public static QFSRecentlyWatchedRecorder i() {
        QFSRecentlyWatchedRecorder qFSRecentlyWatchedRecorder;
        synchronized (QFSRecentlyWatchedRecorder.class) {
            if (C == null) {
                C = new QFSRecentlyWatchedRecorder();
            } else if (!TextUtils.equals(C.f89057h, r.q())) {
                QLog.e("QFSRecentlyWatchedRecorder", 1, "getInstance | uins unmatched | mUin=" + C.f89057h + " | currentAccount=" + r.q());
                C.w();
                C = new QFSRecentlyWatchedRecorder();
            }
            qFSRecentlyWatchedRecorder = C;
        }
        return qFSRecentlyWatchedRecorder;
    }

    private String j() {
        return this.f89057h + "_QFSRecentlyWatchedRecorder";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(QQCircleFeedBase$StViewedFeedData qQCircleFeedBase$StViewedFeedData) {
        uq3.k.b().k(j(), qQCircleFeedBase$StViewedFeedData.toByteArray());
    }

    private void q(List<QQCircleFeedBase$ViewedFeed> list) {
        QLog.d("QFSRecentlyWatchedRecorder", 1, "--history(feed_id | view_time)--");
        for (QQCircleFeedBase$ViewedFeed qQCircleFeedBase$ViewedFeed : list) {
            QLog.d("QFSRecentlyWatchedRecorder", 1, qQCircleFeedBase$ViewedFeed.feed_id.get() + APLogFileUtil.SEPARATOR_LOG + qQCircleFeedBase$ViewedFeed.view_time.get());
        }
    }

    public static void r() {
        QLog.d("QFSRecentlyWatchedRecorder", 1, "releaseInstance");
        if (C != null) {
            synchronized (QFSRecentlyWatchedRecorder.class) {
                if (C != null) {
                    C.v();
                    QCircleListenerProxyManager.getInstance().removeQQFrontBackListener(C);
                    SimpleEventBus.getInstance().unRegisterReceiver(C);
                    C = null;
                }
            }
        }
    }

    private void s() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.utils.p
            @Override // java.lang.Runnable
            public final void run() {
                QFSRecentlyWatchedRecorder.this.l();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void l() {
        synchronized (this.f89058i) {
            byte[] d16 = uq3.k.b().d(j(), new byte[0]);
            if (d16.length == 0) {
                QLog.d("QFSRecentlyWatchedRecorder", 1, "restorePrevious | bytes.length=0");
                return;
            }
            QQCircleFeedBase$StViewedFeedData qQCircleFeedBase$StViewedFeedData = new QQCircleFeedBase$StViewedFeedData();
            try {
                qQCircleFeedBase$StViewedFeedData.mergeFrom(d16);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            List<QQCircleFeedBase$ViewedFeed> list = qQCircleFeedBase$StViewedFeedData.feeds.get();
            if (list == null) {
                QLog.e("QFSRecentlyWatchedRecorder", 1, "restorePrevious | previousFeeds=null");
                return;
            }
            QLog.d("QFSRecentlyWatchedRecorder", 1, "restorePrevious success | mUin=" + this.f89057h + " | previousFeeds.size=" + list.size());
            List<QQCircleFeedBase$ViewedFeed> k3 = k();
            this.f89058i.evictAll();
            for (QQCircleFeedBase$ViewedFeed qQCircleFeedBase$ViewedFeed : list) {
                this.f89058i.put(qQCircleFeedBase$ViewedFeed.feed_id.get(), qQCircleFeedBase$ViewedFeed);
            }
            for (QQCircleFeedBase$ViewedFeed qQCircleFeedBase$ViewedFeed2 : k3) {
                this.f89058i.put(qQCircleFeedBase$ViewedFeed2.feed_id.get(), qQCircleFeedBase$ViewedFeed2);
            }
            uq3.k.b().r(j());
        }
    }

    private void u() {
        QLog.d("QFSRecentlyWatchedRecorder", 1, "startPushingTask");
        RFWThreadManager.getInstance().getSerialThreadHandler().removeCallbacks(this.f89059m);
        RFWThreadManager.getInstance().getSerialThreadHandler().postDelayed(this.f89059m, this.f89055e);
    }

    private void v() {
        QLog.d("QFSRecentlyWatchedRecorder", 1, "stopPushingTask");
        RFWThreadManager.getInstance().getSerialThreadHandler().removeCallbacks(this.f89059m);
    }

    private void w() {
        QLog.d("QFSRecentlyWatchedRecorder", 1, "storeHistoryMMKV | mmkvKey=" + j());
        List<QQCircleFeedBase$ViewedFeed> k3 = k();
        if (k3.size() > 0) {
            final QQCircleFeedBase$StViewedFeedData qQCircleFeedBase$StViewedFeedData = new QQCircleFeedBase$StViewedFeedData();
            qQCircleFeedBase$StViewedFeedData.setHasFlag(true);
            qQCircleFeedBase$StViewedFeedData.feeds.set(k3);
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.utils.o
                @Override // java.lang.Runnable
                public final void run() {
                    QFSRecentlyWatchedRecorder.this.m(qQCircleFeedBase$StViewedFeedData);
                }
            });
        }
        r();
    }

    public void f() {
        synchronized (this.f89058i) {
            this.f89058i.evictAll();
        }
    }

    public void g(List<QQCircleFeedBase$ViewedFeed> list) {
        synchronized (this.f89058i) {
            QLog.d("QFSRecentlyWatchedRecorder", 1, "clearUploadedRecord | currentSize=" + this.f89058i.size());
            if (list == null) {
                return;
            }
            if (HostAppSettingUtil.isDebugVersion()) {
                q(list);
            }
            for (QQCircleFeedBase$ViewedFeed qQCircleFeedBase$ViewedFeed : list) {
                QQCircleFeedBase$ViewedFeed qQCircleFeedBase$ViewedFeed2 = this.f89058i.get(qQCircleFeedBase$ViewedFeed.feed_id.get());
                if (qQCircleFeedBase$ViewedFeed2 != null && qQCircleFeedBase$ViewedFeed2.view_time.get() == qQCircleFeedBase$ViewedFeed.view_time.get()) {
                    this.f89058i.remove(qQCircleFeedBase$ViewedFeed.feed_id.get());
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(AccountChangeEvent.class);
        return arrayList;
    }

    public List<QQCircleFeedBase$ViewedFeed> k() {
        return new ArrayList(this.f89058i.snapshot().values());
    }

    public void n(e30.b bVar) {
        if (bVar == null) {
            QLog.e("QFSRecentlyWatchedRecorder", 1, "offerRecord | feedBlockData is null!exiting...");
        } else {
            o(h(bVar, System.currentTimeMillis()));
        }
    }

    public void o(@NotNull QQCircleFeedBase$ViewedFeed qQCircleFeedBase$ViewedFeed) {
        synchronized (this.f89058i) {
            String str = qQCircleFeedBase$ViewedFeed.feed_id.get();
            QLog.d("QFSRecentlyWatchedRecorder", 1, "offerRecord | feedId=" + str + " | viewTime=" + qQCircleFeedBase$ViewedFeed.view_time.get() + " | previousSize=" + this.f89058i.size());
            if (TextUtils.isEmpty(str)) {
                QLog.e("QFSRecentlyWatchedRecorder", 1, "offerRecord: empty feedId" + str);
                return;
            }
            this.f89058i.put(str, qQCircleFeedBase$ViewedFeed);
            if (HostAppSettingUtil.isDebugVersion()) {
                q(k());
            }
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQQFrontBackListener
    public void onQQEnterBackground() {
        QLog.d("QFSRecentlyWatchedRecorder", 1, "onQQEnterBackground | mHistory.size=" + this.f89058i.size());
        x();
        v();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQQFrontBackListener
    public void onQQEnterForeground() {
        QLog.d("QFSRecentlyWatchedRecorder", 1, "onQQEnterForeground");
        u();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof AccountChangeEvent) {
            AccountChangeEvent accountChangeEvent = (AccountChangeEvent) simpleBaseEvent;
            String q16 = r.q();
            QLog.d("QFSRecentlyWatchedRecorder", 1, "onReceiveEvent | mUin=" + this.f89057h + " | currentAccount=" + q16);
            if (!TextUtils.equals(this.f89057h, q16) && accountChangeEvent.hasSwitchAccount()) {
                w();
            }
        }
    }

    @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onReceive(boolean z16, long j3, String str, QFSAddViewHistoryRequest qFSAddViewHistoryRequest, Object obj, Bundle bundle) {
        QLog.d("QFSRecentlyWatchedRecorder", 1, "onReceive | cmdName=" + qFSAddViewHistoryRequest.getCmd() + " | traceId=" + qFSAddViewHistoryRequest.getTraceId() + " | isSuccess=" + z16 + " | retCode=" + j3);
        if (z16 && j3 == 0) {
            g(qFSAddViewHistoryRequest.getHistorySent());
        }
    }

    public void x() {
        List<QQCircleFeedBase$ViewedFeed> k3 = k();
        QLog.d("QFSRecentlyWatchedRecorder", 1, "uploadHistory | historySize=" + k3.size());
        if (HostAppSettingUtil.isDebugVersion()) {
            q(k3);
        }
        if (k3.size() == 0) {
            return;
        }
        com.tencent.biz.qqcircle.immersive.personal.request.b.h(k3, this);
    }
}
