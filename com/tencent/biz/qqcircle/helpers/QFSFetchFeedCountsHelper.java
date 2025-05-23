package com.tencent.biz.qqcircle.helpers;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.gcore.abase.utils.PatternUtils;
import com.tencent.biz.qqcircle.immersive.request.QFSBatchGetFeedCountsRequest;
import com.tencent.biz.qqcircle.immersive.utils.ba;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StPushList;
import feedcloud.FeedCloudRead$FeedCountEntry;
import feedcloud.FeedCloudRead$StBatchGetFeedCountsRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFetchFeedCountsHelper {

    /* renamed from: f, reason: collision with root package name */
    private static volatile QFSFetchFeedCountsHelper f84562f;

    /* renamed from: c, reason: collision with root package name */
    private long f84565c;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<t30.b> f84566d;

    /* renamed from: a, reason: collision with root package name */
    private final Handler f84563a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    private long f84564b = 5000;

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f84567e = new AnonymousClass1();

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.helpers.QFSFetchFeedCountsHelper$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            final t30.b bVar;
            List<e30.b> feedList;
            QFSFetchFeedCountsHelper.this.f84563a.removeCallbacks(QFSFetchFeedCountsHelper.this.f84567e);
            QFSFetchFeedCountsHelper.this.f84563a.postDelayed(QFSFetchFeedCountsHelper.this.f84567e, QFSFetchFeedCountsHelper.this.f84564b);
            if (QFSFetchFeedCountsHelper.this.f84566d != null && (bVar = (t30.b) QFSFetchFeedCountsHelper.this.f84566d.get()) != null && bVar.m1() && (feedList = bVar.getFeedList()) != null && !feedList.isEmpty()) {
                if (System.currentTimeMillis() - QFSFetchFeedCountsHelper.this.f84565c >= QFSFetchFeedCountsHelper.this.f84564b) {
                    QFSFetchFeedCountsHelper.this.f84565c = System.currentTimeMillis();
                    int J = bVar.J();
                    List m3 = QFSFetchFeedCountsHelper.this.m(feedList, J, bVar.F0());
                    if (QFSFetchFeedCountsHelper.this.s(m3)) {
                        List<FeedCloudMeta$StFeed> p16 = QFSFetchFeedCountsHelper.this.p(m3, J);
                        QLog.d("QFSBatchFeedCountsHelper", 1, "mFetchTask run " + bVar.getLogTag() + ",currentFeedPos:" + J + ",reqSize:" + p16.size());
                        VSNetworkHelper.getInstance().sendRequest(new QFSBatchGetFeedCountsRequest.a().f(p16).b(), new VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StBatchGetFeedCountsRsp>() { // from class: com.tencent.biz.qqcircle.helpers.QFSFetchFeedCountsHelper.1.1
                            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                            /* renamed from: a, reason: merged with bridge method [inline-methods] */
                            public void onReceive(BaseRequest baseRequest, final boolean z16, final long j3, final String str, final FeedCloudRead$StBatchGetFeedCountsRsp feedCloudRead$StBatchGetFeedCountsRsp) {
                                RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.helpers.QFSFetchFeedCountsHelper.1.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        C08711 c08711 = C08711.this;
                                        QFSFetchFeedCountsHelper.this.r(bVar, z16, j3, str, feedCloudRead$StBatchGetFeedCountsRsp);
                                    }
                                });
                            }
                        });
                        return;
                    }
                    QLog.d("QFSBatchFeedCountsHelper", 1, "mFetchTask run " + bVar.getLogTag() + "feed not need update");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void t(final t30.b bVar, final List<FeedCloudRead$FeedCountEntry> list) {
        final List<e30.b> feedList;
        if (bVar != null && (feedList = bVar.getFeedList()) != null && !feedList.isEmpty()) {
            boolean w3 = w(list, feedList, bVar.J(), bVar.R());
            if (bVar.Z()) {
                RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.helpers.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        QFSFetchFeedCountsHelper.this.u(list, feedList, bVar);
                    }
                });
                bVar.U0(feedList);
            } else if (w3) {
                bVar.U0(feedList);
            }
        }
    }

    private void B(FeedCloudRead$FeedCountEntry feedCloudRead$FeedCountEntry, FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StFeed feedCloudMeta$StFeed2) {
        if (feedCloudRead$FeedCountEntry != null && feedCloudMeta$StFeed != null && feedCloudMeta$StFeed2 != null && !feedCloudRead$FeedCountEntry.failFields.get().contains(4)) {
            QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = new QQCircleFeedBase$StFeedBusiReqData();
            QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData2 = new QQCircleFeedBase$StFeedBusiReqData();
            try {
                qQCircleFeedBase$StFeedBusiReqData.mergeFrom(feedCloudMeta$StFeed.busiData.get().toByteArray());
                qQCircleFeedBase$StFeedBusiReqData2.mergeFrom(feedCloudMeta$StFeed2.busiData.get().toByteArray());
                FeedCloudMeta$StPushList feedCloudMeta$StPushList = qQCircleFeedBase$StFeedBusiReqData.pushList.get();
                feedCloudMeta$StPushList.totalClickCount.set(qQCircleFeedBase$StFeedBusiReqData2.pushList.totalClickCount.get());
                qQCircleFeedBase$StFeedBusiReqData.pushList = feedCloudMeta$StPushList;
                feedCloudMeta$StFeed.busiData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StFeedBusiReqData.toByteArray()));
                QCirclePushInfoManager.e().q(feedCloudMeta$StFeed.f398449id.get(), qQCircleFeedBase$StFeedBusiReqData.pushList.get());
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QFSBatchFeedCountsHelper", 1, "[parse feedBusiReqData] error: ", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<e30.b> m(List<e30.b> list, int i3, int i16) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list);
        if (arrayList.size() > i16) {
            int min = Math.min(Math.max(i3, 0), arrayList.size() - 1);
            int i17 = i16 / 2;
            return arrayList.subList(Math.max(min - i17, 0), Math.min(min + i17, arrayList.size()));
        }
        return arrayList;
    }

    public static QFSFetchFeedCountsHelper n() {
        if (f84562f == null) {
            synchronized (QFSFetchFeedCountsHelper.class) {
                if (f84562f == null) {
                    f84562f = new QFSFetchFeedCountsHelper();
                }
            }
        }
        return f84562f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<FeedCloudMeta$StFeed> p(List<e30.b> list, int i3) {
        FeedCloudMeta$StFeed g16;
        if (list == null) {
            return new ArrayList();
        }
        ArrayList<e30.b> arrayList = new ArrayList(list);
        ArrayList arrayList2 = new ArrayList();
        for (e30.b bVar : arrayList) {
            if (!v30.b.i(bVar) && (g16 = bVar.g()) != null && !TextUtils.equals(ba.b(g16, "clientPublishFeed"), "1")) {
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
                feedCloudMeta$StFeed.f398449id.set(g16.f398449id.get());
                feedCloudMeta$StFeed.poster.set(g16.poster.get());
                arrayList2.add(feedCloudMeta$StFeed);
            }
        }
        return arrayList2;
    }

    private List<e30.b> q(List<FeedCloudRead$FeedCountEntry> list, List<e30.b> list2) {
        if (list != null && list2 != null) {
            ArrayList arrayList = new ArrayList(list2);
            for (FeedCloudRead$FeedCountEntry feedCloudRead$FeedCountEntry : list) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    e30.b bVar = (e30.b) it.next();
                    if (bVar != null) {
                        FeedCloudMeta$StFeed g16 = bVar.g();
                        FeedCloudMeta$StFeed feedCloudMeta$StFeed = feedCloudRead$FeedCountEntry.vecFeed.get();
                        if (TextUtils.equals(feedCloudMeta$StFeed.f398449id.get(), g16.f398449id.get())) {
                            if (!feedCloudRead$FeedCountEntry.failFields.get().contains(1)) {
                                g16.commentCount.set(feedCloudMeta$StFeed.commentCount.get());
                            }
                            if (!feedCloudRead$FeedCountEntry.failFields.get().contains(2)) {
                                g16.share.sharedCount.set(feedCloudMeta$StFeed.share.sharedCount.get());
                            }
                            if (!feedCloudRead$FeedCountEntry.failFields.get().contains(3)) {
                                g16.likeInfo.count.set(feedCloudMeta$StFeed.likeInfo.count.get());
                            }
                            B(feedCloudRead$FeedCountEntry, g16, feedCloudMeta$StFeed);
                        }
                    }
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(final t30.b bVar, boolean z16, long j3, String str, FeedCloudRead$StBatchGetFeedCountsRsp feedCloudRead$StBatchGetFeedCountsRsp) {
        if (z16 && j3 == 0) {
            if (feedCloudRead$StBatchGetFeedCountsRsp == null) {
                return;
            }
            QLog.d("QFSBatchFeedCountsHelper", 1, bVar.getLogTag() + " handleGetFeedCountRsp  retCode = " + j3 + "feedCountInfo size=" + feedCloudRead$StBatchGetFeedCountsRsp.feedCountInfo.size() + "nextReqTimeInterval" + feedCloudRead$StBatchGetFeedCountsRsp.nextReqTimeInterval.get());
            this.f84564b = feedCloudRead$StBatchGetFeedCountsRsp.nextReqTimeInterval.get() * 1000;
            final List<FeedCloudRead$FeedCountEntry> list = feedCloudRead$StBatchGetFeedCountsRsp.feedCountInfo.get();
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.helpers.m
                @Override // java.lang.Runnable
                public final void run() {
                    QFSFetchFeedCountsHelper.this.t(bVar, list);
                }
            });
            return;
        }
        QLog.e("QFSBatchFeedCountsHelper", 1, "handleGetFeedCountRsp retCode = " + j3 + " errMsg =  " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s(List<e30.b> list) {
        if (list != null && !list.isEmpty()) {
            int o16 = o();
            if (o16 <= 0) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            for (int i3 = 0; i3 < list.size(); i3++) {
                e30.b bVar = list.get(i3);
                if (bVar != null && currentTimeMillis - bVar.d() > o16) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(List list, List list2, t30.b bVar) {
        List<e30.b> q16 = q(list, list2);
        if (bVar.R0()) {
            w20.a.j().initOrUpdateGlobalState((List) q16, true);
        }
    }

    public static void v() {
        if (f84562f != null) {
            synchronized (QFSFetchFeedCountsHelper.class) {
                if (f84562f != null) {
                    f84562f.y();
                    f84562f = null;
                }
            }
        }
    }

    private boolean w(List<FeedCloudRead$FeedCountEntry> list, List<e30.b> list2, int i3, boolean z16) {
        if (list == null || list2 == null) {
            return false;
        }
        boolean z17 = false;
        for (FeedCloudRead$FeedCountEntry feedCloudRead$FeedCountEntry : list) {
            int i16 = 0;
            while (i16 < list2.size()) {
                e30.b bVar = list2.get(i16);
                if (bVar != null) {
                    FeedCloudMeta$StFeed g16 = bVar.g();
                    if (TextUtils.equals(feedCloudRead$FeedCountEntry.vecFeed.get().f398449id.get(), g16.f398449id.get()) && feedCloudRead$FeedCountEntry.invalidFeed.get()) {
                        RFWLog.d("QFSBatchFeedCountsHelper", RFWLog.USR, "removeInvalidFeed remove feed:" + g16.f398449id.get() + ",index:" + i16 + ",currentIndex:" + i3);
                        list2.remove(bVar);
                        if (i3 == i16 && z16) {
                            z();
                        }
                        i16--;
                        z17 = true;
                    }
                }
                i16++;
            }
        }
        return z17;
    }

    private void z() {
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_feed_invalid_toast_msg", "\u5f53\u524d\u4f5c\u54c1\u5df2\u88ab\u5220\u9664\uff0c\u4e3a\u60a8\u63a8\u8350\u66f4\u591a\u7cbe\u5f69\u4f5c\u54c1");
        RFWLog.d("QFSBatchFeedCountsHelper", RFWLog.USR, "toastFeedRemove :" + loadAsString);
        if (!TextUtils.equals(loadAsString, PatternUtils.NO_MATCH)) {
            QCircleToast.o(loadAsString, 3000);
        }
    }

    public int o() {
        try {
            return Integer.parseInt(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qcircle_config_feed_count_feed_expired_interval", String.valueOf(30))) * 1000;
        } catch (Exception unused) {
            return 30000;
        }
    }

    public void x(t30.b bVar) {
        this.f84566d = new WeakReference<>(bVar);
        if (!uq3.c.p1() || this.f84566d == null) {
            return;
        }
        QLog.d("QFSBatchFeedCountsHelper", 1, "setViewModel and start check;" + bVar.getLogTag());
        this.f84563a.removeCallbacks(this.f84567e);
        this.f84563a.post(this.f84567e);
    }

    public void y() {
        this.f84563a.removeCallbacks(this.f84567e);
    }
}
