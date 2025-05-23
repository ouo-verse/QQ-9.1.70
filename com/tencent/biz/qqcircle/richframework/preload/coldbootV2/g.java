package com.tencent.biz.qqcircle.richframework.preload.coldbootV2;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.immersive.adapter.n;
import com.tencent.biz.qqcircle.immersive.manager.QFSEcommercePreloadManager;
import com.tencent.biz.qqcircle.immersive.utils.ba;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.coldboot.IPreloadTask;
import com.tencent.mobileqq.qcircle.api.event.QFSRedPointFeedAddEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSRedPointFeedRemoveEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedPointUIManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.engineer.test.api.RFWTestMock;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StPrePullCacheFeed;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import qqcircle.QQCircleFeedBase$PrePullRspFeedsOpActionDesc;

/* compiled from: P */
/* loaded from: classes5.dex */
public class g implements IPreloadTask {

    /* renamed from: a, reason: collision with root package name */
    private final int f91980a;

    /* renamed from: b, reason: collision with root package name */
    private final cb0.a f91981b;

    /* renamed from: c, reason: collision with root package name */
    private final String f91982c;

    /* renamed from: d, reason: collision with root package name */
    private volatile FeedCloudMeta$StFeed f91983d;

    /* renamed from: e, reason: collision with root package name */
    private volatile FeedCloudRead$StGetFeedListRsp f91984e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f91985f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f91986g;

    /* renamed from: h, reason: collision with root package name */
    private AtomicBoolean f91987h = new AtomicBoolean(false);

    public g(int i3, cb0.a aVar) {
        boolean z16 = false;
        this.f91980a = i3;
        this.f91982c = b(i3);
        this.f91981b = aVar;
        if (i3 == 10 && !uq3.c.c6()) {
            z16 = true;
        }
        this.f91986g = z16;
    }

    private String b(int i3) {
        if (i3 == 10) {
            return "cold_boot_normal";
        }
        if (i3 == 10000) {
            return "cold_boot_red_point";
        }
        if (i3 == 75) {
            return "cold_boot_friend_tab";
        }
        return "cold_boot_unknown";
    }

    public static boolean c() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101740", true);
    }

    private void d(@NonNull FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        if (!this.f91986g) {
            return;
        }
        List<FeedCloudMeta$StFeed> list = feedCloudRead$StGetFeedListRsp.vecFeed.get();
        if (!list.isEmpty() && (feedCloudMeta$StFeed = list.get(0)) != null && feedCloudMeta$StFeed.feedType.get() == 4) {
            list.remove(feedCloudMeta$StFeed);
            QLog.d("FeedLine_QCircleColdBootPreloadTaskV2", 1, "filterAdFeedIfNeed hit,id:", feedCloudMeta$StFeed.f398449id.get() + " | trace id: " + ba.d(feedCloudMeta$StFeed));
            QCircleExtraTypeInfo qCircleExtraTypeInfo = new QCircleExtraTypeInfo();
            qCircleExtraTypeInfo.mFeed = feedCloudMeta$StFeed;
            com.tencent.biz.qqcircle.immersive.utils.d.f90201a.h(400, 6, qCircleExtraTypeInfo, 1);
        }
        feedCloudRead$StGetFeedListRsp.vecFeed.set(list);
    }

    private boolean e(String str) {
        boolean z16 = false;
        if (this.f91984e != null && this.f91984e.vecFeed.has()) {
            Iterator<FeedCloudMeta$StFeed> it = this.f91984e.vecFeed.get().iterator();
            while (it.hasNext()) {
                FeedCloudMeta$StFeed next = it.next();
                if (str.equals(next.f398449id.get())) {
                    String d16 = ba.d(next);
                    QLog.d(i(), 1, "filterExposeFeed " + str + ",traceId:" + d16);
                    it.remove();
                    z16 = true;
                }
            }
        }
        return z16;
    }

    private void f(List<FeedCloudMeta$StPrePullCacheFeed> list) {
        if (list != null && list.size() != 0) {
            QLog.d(i(), 1, "filterFeedsNeedDelete before,feeds.size: " + list.size());
            for (FeedCloudMeta$StPrePullCacheFeed feedCloudMeta$StPrePullCacheFeed : list) {
                if (feedCloudMeta$StPrePullCacheFeed != null) {
                    e(feedCloudMeta$StPrePullCacheFeed.f398456id.get());
                }
            }
            if (this.f91984e != null && this.f91984e.vecFeed != null) {
                List<FeedCloudMeta$StFeed> list2 = this.f91984e.vecFeed.get();
                QLog.d(i(), 1, "filterFeedsNeedDelete after,feeds.size: " + list2.size());
                if (list2.size() > 0) {
                    n(list2);
                } else {
                    j();
                }
            }
        }
    }

    private void l() {
        RFWThreadManager.getInstance().getSerialThreadHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.preload.coldbootV2.f
            @Override // java.lang.Runnable
            public final void run() {
                g.this.m();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        if (!((IRedPointUIManager) QRoute.api(IRedPointUIManager.class)).isSwitchOn()) {
            QLog.d(i(), 1, "init load cache data from sp");
            FeedCloudRead$StGetFeedListRsp h16 = h();
            if (h16 != null && h16.has()) {
                QLog.d(i(), 1, "init load cache data from sp success");
                q(h16);
            }
        }
        QLog.d(i(), 1, "init success");
        this.f91985f = true;
        cb0.a aVar = this.f91981b;
        if (aVar != null) {
            aVar.onRspPreload();
        }
    }

    private String o() {
        return "cold_boot_cache_data_v2" + this.f91980a;
    }

    @WorkerThread
    private void q(@NonNull FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        d(feedCloudRead$StGetFeedListRsp);
        QFSEcommercePreloadManager.j().l(feedCloudRead$StGetFeedListRsp);
        this.f91984e = feedCloudRead$StGetFeedListRsp;
        List<FeedCloudMeta$StFeed> list = feedCloudRead$StGetFeedListRsp.vecFeed.get();
        fb0.b.b(list, this.f91982c);
        fb0.b.a(list, feedCloudRead$StGetFeedListRsp);
        fb0.b.e(feedCloudRead$StGetFeedListRsp.extInfo.mapInfo, "KEY_RSP_TIME", System.currentTimeMillis() + "");
        if (list.size() > 0) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = list.get(0);
            QLog.d(i(), 1, "resolvePreloadRsp success!feed size:" + list.size() + " | Cover:" + feedCloudMeta$StFeed.cover.picUrl.get() + " | Video:" + feedCloudMeta$StFeed.video.playUrl.get() + " | TraceId:" + ba.d(feedCloudMeta$StFeed) + " \uff5c TopView: " + n.k(feedCloudMeta$StFeed));
            this.f91983d = feedCloudMeta$StFeed;
            this.f91981b.onPreloadFeedChange(feedCloudMeta$StFeed);
            this.f91981b.doPreloadImage(feedCloudMeta$StFeed);
            this.f91981b.doPreloadVideo(feedCloudMeta$StFeed, false);
            QFSEcommercePreloadManager.j().p(feedCloudMeta$StFeed);
        } else {
            this.f91983d = null;
            this.f91981b.onPreloadFeedChange(null);
            QLog.e(i(), 1, "resolvePreloadRsp failed!feed size:" + list.size());
        }
        try {
            r(feedCloudRead$StGetFeedListRsp.toByteArray());
        } catch (Exception e16) {
            QLog.e("FeedLine_QCircleColdBootPreloadTaskV2", 1, "resolvePreloadRsp exception:", e16.toString());
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.coldboot.IPreloadTask
    public void clearAllCacheInfo() {
        QLog.d(i(), 1, "clear all cache info");
        if (this.f91984e != null && this.f91984e.vecFeed != null) {
            this.f91984e.vecFeed.clear();
        }
        this.f91983d = null;
        this.f91981b.onPreloadFeedChange(null);
        p();
    }

    @Override // com.tencent.mobileqq.qcircle.api.coldboot.IPreloadTask
    public void dealWithPagePrePullRsp(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        if (feedCloudRead$StGetFeedListRsp != null && feedCloudRead$StGetFeedListRsp.has()) {
            QLog.d(i(), 1, "[dealWithPagePrePullRsp] resolvePreloadRsp");
            q(feedCloudRead$StGetFeedListRsp);
        } else {
            QLog.e(i(), 1, "[dealWithPagePrePullRsp] rsp is empty");
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.coldboot.IPreloadTask
    @WorkerThread
    public void filterFeedById(String str) {
        QLog.d(i(), 1, "filterFeedById id:" + str);
        if (!TextUtils.isEmpty(str) && e(str)) {
            List<FeedCloudMeta$StFeed> list = this.f91984e.vecFeed.get();
            QLog.d(i(), 1, "hit filter,update preload feeds.size:", Integer.valueOf(list.size()));
            if (list.size() > 0) {
                n(list);
            } else {
                j();
            }
        }
    }

    public List<FeedCloudMeta$StPrePullCacheFeed> g() {
        ArrayList arrayList = new ArrayList();
        if (this.f91984e != null && this.f91984e.vecFeed.size() > 0) {
            for (FeedCloudMeta$StFeed feedCloudMeta$StFeed : this.f91984e.vecFeed.get()) {
                if (feedCloudMeta$StFeed != null) {
                    FeedCloudMeta$StPrePullCacheFeed feedCloudMeta$StPrePullCacheFeed = new FeedCloudMeta$StPrePullCacheFeed();
                    feedCloudMeta$StPrePullCacheFeed.f398456id.set(feedCloudMeta$StFeed.f398449id.get());
                    feedCloudMeta$StPrePullCacheFeed.poster.set(feedCloudMeta$StFeed.poster.get());
                    feedCloudMeta$StPrePullCacheFeed.createTime.set(feedCloudMeta$StFeed.createTime.get());
                    feedCloudMeta$StPrePullCacheFeed.busiTranparent.set(feedCloudMeta$StFeed.busiTranparent.get());
                    arrayList.add(feedCloudMeta$StPrePullCacheFeed);
                }
            }
        }
        QLog.d(i(), 1, "getPrePullCacheFeeds size: ", Integer.valueOf(arrayList.size()));
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qcircle.api.coldboot.IPreloadTask
    public FeedCloudMeta$StFeed getPreloadFeed() {
        return this.f91983d;
    }

    @Override // com.tencent.mobileqq.qcircle.api.coldboot.IPreloadTask
    public Object getPreloadRsp() {
        if (this.f91984e != null) {
            return this.f91984e;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qcircle.api.coldboot.IPreloadTask
    public byte[] getPreloadRspData() {
        if (this.f91984e != null) {
            return this.f91984e.toByteArray();
        }
        return null;
    }

    public FeedCloudRead$StGetFeedListRsp h() {
        String o16 = o();
        SharedPreferences C = com.tencent.biz.qqcircle.f.C();
        if (C != null) {
            try {
                String string = C.getString(o16, "");
                if (!TextUtils.isEmpty(string)) {
                    byte[] decode = Base64.decode(string.getBytes(), 0);
                    FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp = new FeedCloudRead$StGetFeedListRsp();
                    feedCloudRead$StGetFeedListRsp.mergeFrom(decode);
                    QLog.d(i(), 1, "getPreloadData success, key: ", o16);
                    return feedCloudRead$StGetFeedListRsp;
                }
            } catch (Exception e16) {
                QLog.e(i(), 1, "getPreloadData Exception:", e16.toString());
                return null;
            } catch (OutOfMemoryError e17) {
                QLog.e(i(), 1, "getPreloadData OOM:", e17.toString());
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qcircle.api.coldboot.IPreloadTask
    @RFWTestMock(id = "QFS_TOP_VIEW")
    @WorkerThread
    public void handlePreloadRsp(@NonNull FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, @NonNull QQCircleFeedBase$PrePullRspFeedsOpActionDesc qQCircleFeedBase$PrePullRspFeedsOpActionDesc) {
        if (qQCircleFeedBase$PrePullRspFeedsOpActionDesc.opActionDesc.get() == 0) {
            QLog.d(i(), 1, "handlePreloadRsp doNothing");
            return;
        }
        if (qQCircleFeedBase$PrePullRspFeedsOpActionDesc.opActionDesc.get() == 1) {
            QLog.d(i(), 1, "handlePreloadRsp cover");
            q(feedCloudRead$StGetFeedListRsp);
            if (c()) {
                QLog.d(i(), 1, "handlePreloadRsp feed size:" + feedCloudRead$StGetFeedListRsp.vecFeed.size());
                if (feedCloudRead$StGetFeedListRsp.vecFeed.size() > 0) {
                    SimpleEventBus.getInstance().dispatchEvent(new QFSRedPointFeedAddEvent(this.f91980a, feedCloudRead$StGetFeedListRsp));
                    return;
                } else {
                    SimpleEventBus.getInstance().dispatchEvent(new QFSRedPointFeedRemoveEvent(this.f91980a));
                    return;
                }
            }
            return;
        }
        if (qQCircleFeedBase$PrePullRspFeedsOpActionDesc.opActionDesc.get() == 2) {
            QLog.d(i(), 1, "handlePreloadRsp delete");
            f(qQCircleFeedBase$PrePullRspFeedsOpActionDesc.feeds.get());
            if (c()) {
                SimpleEventBus.getInstance().dispatchEvent(new QFSRedPointFeedRemoveEvent(this.f91980a));
            }
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.coldboot.IPreloadTask
    public boolean hasPreloadData() {
        boolean z16;
        if (this.f91983d != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d(i(), 1, "has valid preload data: ", Boolean.valueOf(z16));
        return z16;
    }

    public String i() {
        return "FeedLine_QCircleColdBootPreloadTaskV2_" + this.f91980a;
    }

    protected void j() {
        clearAllCacheInfo();
        QLog.d(i(), 1, "filterFeedById hit, no remain size,wait next pull");
    }

    public boolean k() {
        return this.f91985f;
    }

    protected void n(List<FeedCloudMeta$StFeed> list) {
        synchronized (this) {
            this.f91983d = list.get(0);
            this.f91981b.onPreloadFeedChange(this.f91983d);
            this.f91984e.vecFeed.set(list);
            try {
                r(this.f91984e.toByteArray());
            } catch (Exception e16) {
                QLog.e(i(), 1, "loadNextFeed failed,can't save!", e16);
            }
            QLog.d(i(), 1, "filterFeedById hit, remain size:" + list.size());
        }
    }

    public void p() {
        String o16 = o();
        SharedPreferences C = com.tencent.biz.qqcircle.f.C();
        if (C != null) {
            C.edit().remove(o16).apply();
            QLog.d(i(), 1, "removePreloadData success, key: ", o16);
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.coldboot.IPreloadTask
    public void preloadFeed() {
        if (this.f91985f) {
            cb0.a aVar = this.f91981b;
            if (aVar != null) {
                aVar.onRspPreload();
                return;
            }
            return;
        }
        if (this.f91987h.compareAndSet(false, true)) {
            QLog.d(i(), 1, "[preloadFeed]");
            l();
        } else {
            QLog.d(i(), 1, "[preloadFeed] have preload once");
        }
    }

    public void r(byte[] bArr) {
        String o16 = o();
        SharedPreferences C = com.tencent.biz.qqcircle.f.C();
        if (C != null) {
            try {
                C.edit().putString(o16, new String(Base64.encode(bArr, 0))).apply();
                QLog.d(i(), 1, "savePreloadData success, key: ", o16);
            } catch (Exception e16) {
                QLog.e(i(), 1, "savePreloadData Exception:", e16.toString());
            } catch (OutOfMemoryError e17) {
                QLog.e(i(), 1, "savePreloadData OOM:", e17.toString());
            }
        }
    }
}
