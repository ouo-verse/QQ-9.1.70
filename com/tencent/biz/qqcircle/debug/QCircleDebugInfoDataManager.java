package com.tencent.biz.qqcircle.debug;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.requests.QCircleBatchGetFeedFeatureRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.BatchGetFeedFeatureRsp;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedEntity;
import feedcloud.FeedFeature;
import feedcloud.FeedInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleDebugInfoDataManager {

    /* renamed from: b, reason: collision with root package name */
    private static volatile QCircleDebugInfoDataManager f84160b;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, String> f84161a = new ConcurrentHashMap();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        void a(Map<String, String> map);
    }

    QCircleDebugInfoDataManager() {
    }

    private String f(@NonNull FeedFeature feedFeature) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\u4f5c\u8005\u7ef4\u5ea6\n");
        if (feedFeature.author != null) {
            FeedInfo feedInfo = feedFeature.feed;
            if (feedInfo != null && feedInfo.feed != null) {
                sb5.append("\u4f5c\u8005uin\uff1a");
                sb5.append(feedFeature.feed.feed.author_id);
                sb5.append("\n");
            }
            sb5.append("\u4f5c\u8005\u6765\u6e90\uff1a");
            sb5.append(feedFeature.author.source);
            sb5.append("\n");
            sb5.append("\u4f5c\u8005\u5206\u7c7b\uff1a");
            sb5.append(feedFeature.author.cate_info);
            sb5.append("\n");
            sb5.append("\u521b\u4f5c\u7c7b\u578b\u6807\u7b7e\uff1a");
            sb5.append(feedFeature.author.pub_kind);
            sb5.append("\n");
            sb5.append("\u521b\u4f5c\u8d28\u91cf\u6807\u7b7e\uff1a");
            sb5.append(feedFeature.author.pub_quality);
            sb5.append("\n");
            sb5.append("\u7ad9\u5916\u8eab\u4efd\u786e\u8ba4\uff1a");
            sb5.append(feedFeature.author.out_source_confirm);
            sb5.append("\n");
            sb5.append("\u6240\u5c5e\u673a\u6784\uff1a");
            sb5.append(feedFeature.author.organ_name);
        }
        sb5.append("\n\n");
        sb5.append("\u5185\u5bb9\u7ef4\u5ea6\n");
        FeedInfo feedInfo2 = feedFeature.feed;
        if (feedInfo2 != null) {
            if (feedInfo2.feed != null) {
                sb5.append("feedId\uff1a");
                sb5.append(feedFeature.feed.feed.feed_id);
                sb5.append("\n");
                sb5.append("\u89c6\u9891\u521b\u5efa\u65f6\u95f4\uff1a");
                sb5.append(feedFeature.feed.feed.create_time);
                sb5.append("\n");
            }
            sb5.append("\u5185\u5bb9\u6e20\u9053\u6765\u6e90\uff1a");
            sb5.append(feedFeature.feed.source);
            sb5.append("\n");
            sb5.append("\u63a8\u8350\u72b6\u6001\uff1a");
            sb5.append(feedFeature.feed.recom_status);
            sb5.append("\n");
            sb5.append("\u4eba\u6253\u6807\u7b7e\uff1a");
            sb5.append(feedFeature.feed.labels);
            sb5.append("\n");
            sb5.append("\u5185\u5bb9\u8d28\u91cf\u5206\u7ea7\uff1a");
            sb5.append(feedFeature.feed.grade);
            sb5.append("\n");
            sb5.append("\u5185\u5bb9\u5206\u7c7b\uff1a");
            sb5.append(feedFeature.feed.cate_info);
            sb5.append("\n");
        }
        return sb5.toString();
    }

    public static QCircleDebugInfoDataManager h() {
        if (f84160b == null) {
            synchronized (QCircleDebugInfoDataManager.class) {
                if (f84160b == null) {
                    f84160b = new QCircleDebugInfoDataManager();
                }
            }
        }
        return f84160b;
    }

    private void i(final List<FeedCloudMeta$StFeed> list, final boolean z16, final long j3, final String str, final BatchGetFeedFeatureRsp batchGetFeedFeatureRsp, final a aVar) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.debug.e
            @Override // java.lang.Runnable
            public final void run() {
                QCircleDebugInfoDataManager.this.k(z16, j3, batchGetFeedFeatureRsp, list, str, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(a aVar) {
        if (aVar != null) {
            aVar.a(this.f84161a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(boolean z16, long j3, BatchGetFeedFeatureRsp batchGetFeedFeatureRsp, List list, String str, final a aVar) {
        FeedInfo feedInfo;
        FeedEntity feedEntity;
        if (z16 && j3 == 0 && batchGetFeedFeatureRsp != null) {
            List<FeedFeature> list2 = batchGetFeedFeatureRsp.features;
            QLog.d("QCircleDebugInfoDataManager", 1, "[handleBatchGetFeedFeatureResponse] success, feedFeatures.size = " + list2.size());
            for (FeedFeature feedFeature : list2) {
                if (feedFeature != null && (feedInfo = feedFeature.feed) != null && (feedEntity = feedInfo.feed) != null) {
                    String str2 = feedEntity.feed_id;
                    if (TextUtils.isEmpty(str2)) {
                        QLog.e("QCircleDebugInfoDataManager", 1, "[handleBatchGetFeedFeatureResponse] feedId is empty");
                    } else {
                        this.f84161a.remove(str2);
                        this.f84161a.put(str2, f(feedFeature));
                    }
                } else {
                    QLog.e("QCircleDebugInfoDataManager", 1, "[handleBatchGetFeedFeatureResponse] feature or feed is null");
                }
            }
        } else {
            QLog.d("QCircleDebugInfoDataManager", 1, "[handleBatchGetFeedFeatureResponse] fail, feeds.size = " + list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) it.next();
                if (feedCloudMeta$StFeed != null && !TextUtils.isEmpty(feedCloudMeta$StFeed.f398449id.get())) {
                    this.f84161a.remove(feedCloudMeta$StFeed.f398449id.get());
                    this.f84161a.put(feedCloudMeta$StFeed.f398449id.get(), str);
                } else {
                    QLog.e("QCircleDebugInfoDataManager", 1, "[handleBatchGetFeedFeatureResponse] feedId is empty");
                }
            }
        }
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.debug.f
            @Override // java.lang.Runnable
            public final void run() {
                QCircleDebugInfoDataManager.this.j(aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(QCircleBatchGetFeedFeatureRequest qCircleBatchGetFeedFeatureRequest, List list, a aVar, BaseRequest baseRequest, boolean z16, long j3, String str, BatchGetFeedFeatureRsp batchGetFeedFeatureRsp) {
        QLog.d("QCircleDebugInfoDataManager", 1, "[requestBatchFeedFeature] onReceive: dispatch Success:" + z16 + " | TraceId:" + qCircleBatchGetFeedFeatureRequest.getTraceId() + " | SeqId:" + qCircleBatchGetFeedFeatureRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
        i(list, z16, j3, str, batchGetFeedFeatureRsp, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final List<FeedCloudMeta$StFeed> list, final a aVar) {
        if (list != null && !list.isEmpty()) {
            QLog.d("QCircleDebugInfoDataManager", 1, "[requestBatchFeedFeature] feeds.size = " + list.size());
            final QCircleBatchGetFeedFeatureRequest qCircleBatchGetFeedFeatureRequest = new QCircleBatchGetFeedFeatureRequest(list);
            VSNetworkHelper.getInstance().sendRequest(qCircleBatchGetFeedFeatureRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.debug.d
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                    QCircleDebugInfoDataManager.this.l(qCircleBatchGetFeedFeatureRequest, list, aVar, baseRequest, z16, j3, str, (BatchGetFeedFeatureRsp) obj);
                }
            });
            return;
        }
        QLog.d("QCircleDebugInfoDataManager", 1, "[requestBatchFeedFeature] feeds == null or empty");
        if (aVar != null) {
            aVar.a(this.f84161a);
        }
    }

    public String g(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null || !this.f84161a.containsKey(feedCloudMeta$StFeed.f398449id.get())) {
            return null;
        }
        return this.f84161a.get(feedCloudMeta$StFeed.f398449id.get());
    }

    public void m(final List<e30.b> list) {
        if (g.d() && g.b() && list != null && !list.isEmpty()) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.debug.QCircleDebugInfoDataManager.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = list.iterator();
                    while (true) {
                        FeedCloudMeta$StFeed feedCloudMeta$StFeed = null;
                        if (!it.hasNext()) {
                            QCircleDebugInfoDataManager.this.n(arrayList, null);
                            return;
                        }
                        e30.b bVar = (e30.b) it.next();
                        if (bVar != null) {
                            feedCloudMeta$StFeed = bVar.g();
                        }
                        if (feedCloudMeta$StFeed != null && !QCircleDebugInfoDataManager.this.f84161a.containsKey(feedCloudMeta$StFeed.f398449id.get())) {
                            arrayList.add(feedCloudMeta$StFeed);
                        }
                    }
                }
            });
        }
    }

    public void o(FeedCloudMeta$StFeed feedCloudMeta$StFeed, a aVar) {
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QCircleDebugInfoDataManager", 1, "[requestSingleFeedFeature] feed == null");
            return;
        }
        if (g.d() && g.b()) {
            if (this.f84161a.containsKey(feedCloudMeta$StFeed.f398449id.get())) {
                QLog.d("QCircleDebugInfoDataManager", 1, "[requestSingleFeedFeature] contain feedId = " + feedCloudMeta$StFeed.f398449id.get());
                if (aVar != null) {
                    aVar.a(this.f84161a);
                    return;
                }
                return;
            }
            QLog.d("QCircleDebugInfoDataManager", 1, "[requestSingleFeedFeature] feedId = " + feedCloudMeta$StFeed.f398449id.get());
            ArrayList arrayList = new ArrayList();
            arrayList.add(feedCloudMeta$StFeed);
            n(arrayList, aVar);
        }
    }
}
