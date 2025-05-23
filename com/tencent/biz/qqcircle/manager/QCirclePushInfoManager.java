package com.tencent.biz.qqcircle.manager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCircleUndoPushUpdateEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.call.Call;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StPushList;
import feedcloud.FeedCloudWrite$StDoPushRsp;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;
import uq3.o;

/* loaded from: classes4.dex */
public class QCirclePushInfoManager {

    /* renamed from: d, reason: collision with root package name */
    private static volatile QCirclePushInfoManager f91488d;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, FeedCloudMeta$StPushList> f91489a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f91490b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private db0.f f91491c;

    /* loaded from: classes4.dex */
    class a implements Call.OnRspCallBack {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f91499d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f91500e;

        a(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
            this.f91499d = feedCloudMeta$StFeed;
            this.f91500e = i3;
        }

        @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
        @SuppressLint({"DefaultLocale"})
        public void onReceive(boolean z16, long j3, String str, Object obj, Object obj2, Bundle bundle) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed;
            if (obj2 != null && (feedCloudMeta$StFeed = this.f91499d) != null) {
                String str2 = feedCloudMeta$StFeed.f398449id.get();
                if (z16 && j3 == 0) {
                    QLog.d("QCirclePushTimesManager", 1, String.format("DoPush -> undoPush success! feedId = %s", str2));
                    if (!QCirclePushInfoManager.e().c(this.f91499d.f398449id.get()) && this.f91500e != 2) {
                        QCircleToast.i(QCircleToast.f91646f, R.string.f184703ml, 1);
                    } else {
                        QCircleToast.i(QCircleToast.f91646f, R.string.f185433ok, 1);
                    }
                    QCirclePushInfoManager.e().l(this.f91499d.f398449id.get());
                    QCircleFeedEvent qCircleFeedEvent = new QCircleFeedEvent(str2, 7);
                    qCircleFeedEvent.setTargetPage(9);
                    SimpleEventBus.getInstance().dispatchEvent(qCircleFeedEvent);
                    QCirclePushInfoManager.this.o(obj2);
                    if (o.Y1("qqcircle_enable_cancel_push_gesture_optimize_9155", true)) {
                        SimpleEventBus.getInstance().dispatchEvent(new QCircleUndoPushUpdateEvent(this.f91499d.f398449id.get()));
                        return;
                    }
                    return;
                }
                QLog.d("QCirclePushTimesManager", 1, String.format("DoPush -> undoPush failed! feedId = %s , retCode = %d , errMsg = %s", str2, Long.valueOf(j3), str));
                QCircleToast.i(QCircleToast.f91645e, R.string.f185423oj, 1);
            }
        }
    }

    private void d() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_push_info_manager_over_size_clear", true)) {
            return;
        }
        QLog.d("QCirclePushTimesManager", 1, "[clearPushInfoMap] size: " + this.f91489a.size());
        if (this.f91489a.size() > 500) {
            this.f91489a.clear();
        }
    }

    public static QCirclePushInfoManager e() {
        if (f91488d == null) {
            synchronized (QCirclePushInfoManager.class) {
                if (f91488d == null) {
                    f91488d = new QCirclePushInfoManager();
                }
            }
        }
        return f91488d;
    }

    private FeedCloudMeta$StPushList g(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return new FeedCloudMeta$StPushList();
        }
        FeedCloudMeta$StPushList feedCloudMeta$StPushList = this.f91489a.get(feedCloudMeta$StFeed.f398449id.get());
        if (feedCloudMeta$StPushList != null) {
            return feedCloudMeta$StPushList;
        }
        try {
            QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = new QQCircleFeedBase$StFeedBusiReqData();
            qQCircleFeedBase$StFeedBusiReqData.mergeFrom(feedCloudMeta$StFeed.busiData.get().toByteArray());
            return qQCircleFeedBase$StFeedBusiReqData.pushList;
        } catch (Exception e16) {
            RFWLog.fatal("QCirclePushTimesManager", RFWLog.USR, e16);
            return new FeedCloudMeta$StPushList();
        }
    }

    private FeedCloudMeta$StPushList h(e30.b bVar) {
        if (bVar != null && bVar.g() != null) {
            try {
                QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = new QQCircleFeedBase$StFeedBusiReqData();
                qQCircleFeedBase$StFeedBusiReqData.mergeFrom(bVar.g().busiData.get().toByteArray());
                return qQCircleFeedBase$StFeedBusiReqData.pushList;
            } catch (Exception e16) {
                RFWLog.fatal("QCirclePushTimesManager", RFWLog.USR, e16);
                return new FeedCloudMeta$StPushList();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Object obj) {
        if (!(obj instanceof FeedCloudWrite$StDoPushRsp)) {
            return;
        }
        com.tencent.biz.qqcircle.f.v().R(((FeedCloudWrite$StDoPushRsp) obj).myFuel.get());
    }

    public void b(String str) {
        ConcurrentHashMap<String, Long> concurrentHashMap = this.f91490b;
        if (concurrentHashMap != null) {
            concurrentHashMap.putIfAbsent(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public boolean c(String str) {
        Long l3 = this.f91490b.get(str);
        if (l3 != null && System.currentTimeMillis() - 60000 <= l3.longValue()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FeedCloudMeta$StPushList f(String str) {
        if (TextUtils.isEmpty(str)) {
            return new FeedCloudMeta$StPushList();
        }
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_push_info_manager_over_size_clear", true)) {
            return this.f91489a.get(str);
        }
        FeedCloudMeta$StPushList feedCloudMeta$StPushList = this.f91489a.get(str);
        if (feedCloudMeta$StPushList != null) {
            return feedCloudMeta$StPushList;
        }
        MutableLiveData globalData = w20.a.j().getGlobalData(e30.b.class, str);
        if (globalData == null) {
            return null;
        }
        return h((e30.b) globalData.getValue());
    }

    public ConcurrentHashMap<String, FeedCloudMeta$StPushList> i(String str) {
        return this.f91489a;
    }

    public void j(List<FeedCloudMeta$StFeed> list) {
        if (list != null && !list.isEmpty()) {
            d();
            for (FeedCloudMeta$StFeed feedCloudMeta$StFeed : list) {
                QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = new QQCircleFeedBase$StFeedBusiReqData();
                try {
                    qQCircleFeedBase$StFeedBusiReqData.mergeFrom(feedCloudMeta$StFeed.busiData.get().toByteArray());
                    e().n(feedCloudMeta$StFeed.f398449id.get(), qQCircleFeedBase$StFeedBusiReqData.pushList);
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    public void k() {
        ConcurrentHashMap<String, FeedCloudMeta$StPushList> concurrentHashMap = this.f91489a;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        ConcurrentHashMap<String, Long> concurrentHashMap2 = this.f91490b;
        if (concurrentHashMap2 != null) {
            concurrentHashMap2.clear();
        }
    }

    public void l(String str) {
        ConcurrentHashMap<String, Long> concurrentHashMap = this.f91490b;
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(str);
        }
    }

    public void m(FeedCloudMeta$StFeed feedCloudMeta$StFeed, db0.d dVar, int i3) {
        int i16;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        if (!e().c(feedCloudMeta$StFeed.f398449id.get()) && i3 != 2) {
            i16 = 2;
        } else {
            i16 = 1;
        }
        QCircleDoRecommendRequest qCircleDoRecommendRequest = new QCircleDoRecommendRequest(feedCloudMeta$StFeed, 0, g(feedCloudMeta$StFeed), i16, null);
        qCircleDoRecommendRequest.setPushVersion(i3);
        this.f91491c = new db0.f(true, null);
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().addInterceptor(dVar).addInterceptor(this.f91491c).addRequest(qCircleDoRecommendRequest).m250setRspOnCallBack((Call.OnRspCallBack) new a(feedCloudMeta$StFeed, i3)).execute();
    }

    public void n(String str, FeedCloudMeta$StPushList feedCloudMeta$StPushList) {
        if (!TextUtils.isEmpty(str) && feedCloudMeta$StPushList != null) {
            q(str, feedCloudMeta$StPushList);
            this.f91489a.put(str, feedCloudMeta$StPushList);
        }
    }

    public void p(final String str, final FeedCloudMeta$StPushList feedCloudMeta$StPushList) {
        if (!TextUtils.isEmpty(str) && feedCloudMeta$StPushList != null) {
            final FeedCloudMeta$StPushList f16 = f(str);
            if (f16 != null && f16.totalClickCount.get() > feedCloudMeta$StPushList.totalClickCount.get()) {
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.manager.QCirclePushInfoManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            feedCloudMeta$StPushList.set(f16);
                            QLog.d("QCirclePushTimesManager", 4, "setPushInfo from Manager feedId" + str);
                        } catch (Exception e16) {
                            QLog.e("QCirclePushTimesManager", 1, e16.getMessage(), e16);
                        }
                    }
                });
                return;
            }
            this.f91489a.put(str, feedCloudMeta$StPushList);
            QLog.d("QCirclePushTimesManager", 4, "updatePushInfo feedId" + str);
            q(str, feedCloudMeta$StPushList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void q(String str, final FeedCloudMeta$StPushList feedCloudMeta$StPushList) {
        final e30.b bVar;
        final MutableLiveData globalData = w20.a.j().getGlobalData(e30.b.class, str);
        if (globalData == null || (bVar = (e30.b) globalData.getValue()) == null) {
            return;
        }
        Object b16 = bVar.b("DITTO_FEED_BUSI_REQ_DATA");
        if (b16 == null) {
            b16 = new QQCircleFeedBase$StFeedBusiReqData();
        }
        if (b16 instanceof QQCircleFeedBase$StFeedBusiReqData) {
            final QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = (QQCircleFeedBase$StFeedBusiReqData) b16;
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.manager.QCirclePushInfoManager.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData2 = qQCircleFeedBase$StFeedBusiReqData;
                        qQCircleFeedBase$StFeedBusiReqData2.pushList = feedCloudMeta$StPushList;
                        bVar.o("DITTO_FEED_BUSI_REQ_DATA", qQCircleFeedBase$StFeedBusiReqData2);
                        globalData.setValue(bVar);
                    } catch (Exception e16) {
                        QLog.e("QCirclePushTimesManager", 1, e16.getMessage(), e16);
                    }
                }
            });
        }
    }
}
