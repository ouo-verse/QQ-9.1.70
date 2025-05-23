package hc0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.utils.y;
import com.tencent.biz.qqcircle.rerank.request.QFSRankCloudGetFeedsReq;
import com.tencent.biz.qqcircle.rerank.util.QFSRankEdgeReportHelper;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeAction;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkpublish.publishconst.WinkHostConstants;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.tedger.outapi.beans.EdgeItem;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.delegate.d;
import com.tencent.tedger.outapi.proto.TEdgeCommon$MapEntry;
import com.tencent.tedger.outapi.proto.TEdgeEvent$Event;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import seal.SealCloudRerankInfo$CloudReRankInfo;
import seal.SealCloudRerankInfo$IneterRecommendFeedDetail;
import seal.SealCloudRerankInfo$InteractiveFeed;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static long f404686a;

    private static boolean c(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_rerank_give_up_when_feed_not_find", true) || feedCloudMeta$StFeed == null || !y.f(feedCloudMeta$StFeed)) {
            return false;
        }
        QLog.d("TEDGEQFS_QFSCloudRerank", 1, "enableGiveUpWhenNotFind is addFeed");
        return true;
    }

    public static void d(final List<EdgeItem> list, Map<String, Object> map, final d.a aVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            final QFSRankCloudGetFeedsReq qFSRankCloudGetFeedsReq = new QFSRankCloudGetFeedsReq(new QFSRankCloudGetFeedsReq.a().c(h((QFSEdgeAction) map.get("trigger_user_action"), list)).d(SemanticAttributes.HttpFlavorValues.HTTP_2_0));
            final HashMap hashMap = new HashMap();
            hashMap.put("traceId", qFSRankCloudGetFeedsReq.getTraceId());
            VSNetworkHelper.getInstance().sendRequest(qFSRankCloudGetFeedsReq, new VSDispatchObserver.OnVSRspCallBack() { // from class: hc0.a
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                    c.k(QFSRankCloudGetFeedsReq.this, list, aVar, hashMap, currentTimeMillis, baseRequest, z16, j3, str, (FeedCloudRead$StGetFeedListRsp) obj);
                }
            });
        } catch (Exception e16) {
            EdgeStatus edgeStatus = new EdgeStatus();
            edgeStatus.setCode(-100L);
            edgeStatus.setMsg("getBehavior error:" + e16);
            aVar.a(edgeStatus, new ArrayList(), new HashMap());
            QLog.e("TEDGEQFS_QFSCloudRerank", 1, "getItemList getInputParams error " + e16);
        }
    }

    private static String e(TEdgeEvent$Event tEdgeEvent$Event) {
        List<TEdgeCommon$MapEntry> list = tEdgeEvent$Event.properties.get();
        for (int i3 = 0; i3 < list.size(); i3++) {
            TEdgeCommon$MapEntry tEdgeCommon$MapEntry = list.get(i3);
            if (TextUtils.equals(tEdgeCommon$MapEntry.key.get(), "video_time")) {
                return tEdgeCommon$MapEntry.value.get();
            }
        }
        return null;
    }

    private static String f(TEdgeEvent$Event tEdgeEvent$Event) {
        List<TEdgeCommon$MapEntry> list = tEdgeEvent$Event.properties.get();
        for (int i3 = 0; i3 < list.size(); i3++) {
            TEdgeCommon$MapEntry tEdgeCommon$MapEntry = list.get(i3);
            if (TextUtils.equals(tEdgeCommon$MapEntry.key.get(), QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_END_PLAY_TIME)) {
                return tEdgeCommon$MapEntry.value.get();
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ad, code lost:
    
        if (r4 != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b3, code lost:
    
        if (c(r2) == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ba, code lost:
    
        return new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00bb, code lost:
    
        r0.add(r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static List<FeedCloudMeta$StFeed> g(@NonNull List<e30.b> list, @NonNull List<FeedCloudMeta$StFeed> list2) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        ArrayList arrayList = new ArrayList();
        Iterator<FeedCloudMeta$StFeed> it = list2.iterator();
        while (true) {
            boolean z16 = false;
            if (it.hasNext()) {
                FeedCloudMeta$StFeed next = it.next();
                if (next != null && next.has()) {
                    Iterator<e30.b> it5 = list.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            e30.b next2 = it5.next();
                            if (next2 != null && next2.g() != null) {
                                feedCloudMeta$StFeed = next2.g();
                                if (TextUtils.equals(feedCloudMeta$StFeed.f398449id.get(), next.f398449id.get())) {
                                    try {
                                        feedCloudMeta$StFeed.recomInfo.recomTrace.set(next.recomInfo.recomTrace.get());
                                        feedCloudMeta$StFeed.debugInfo.set(next.debugInfo.get());
                                        feedCloudMeta$StFeed.busiReport.set(next.busiReport.get());
                                    } catch (Exception e16) {
                                        QLog.e("TEDGEQFS_QFSCloudRerank", 1, "getReRankFeeds error:", e16.toString());
                                        if (WinkHostConstants.AppSetting.isDebugVersion()) {
                                            throw new RuntimeException("getReRankFeeds pb set option error " + e16);
                                        }
                                    }
                                    z16 = true;
                                    break;
                                }
                            }
                        } else {
                            feedCloudMeta$StFeed = next;
                            break;
                        }
                    }
                } else {
                    QLog.e("TEDGEQFS_QFSCloudRerank", 1, "getReRankFeeds find empty feed!");
                }
            } else {
                QLog.d("TEDGEQFS_QFSCloudRerank", 1, "getReRankFeeds done,size:", list2.size() + ", originFeeds size\uff1a" + list.size());
                return arrayList;
            }
        }
    }

    private static SealCloudRerankInfo$CloudReRankInfo h(QFSEdgeAction qFSEdgeAction, List<EdgeItem> list) {
        SealCloudRerankInfo$CloudReRankInfo sealCloudRerankInfo$CloudReRankInfo = new SealCloudRerankInfo$CloudReRankInfo();
        sealCloudRerankInfo$CloudReRankInfo.interactive_feed_list.set(m(qFSEdgeAction));
        sealCloudRerankInfo$CloudReRankInfo.candidate_feed_list.set(l(list));
        return sealCloudRerankInfo$CloudReRankInfo;
    }

    private static String i(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        return feedCloudMeta$StFeed.poster.f398463id.get() + "|" + feedCloudMeta$StFeed.f398449id.get() + "|" + feedCloudMeta$StFeed.createTime.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(List list, d.a aVar, EdgeStatus edgeStatus, Map map) {
        aVar.a(edgeStatus, ic0.b.c(e30.d.b(list), 1), map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(QFSRankCloudGetFeedsReq qFSRankCloudGetFeedsReq, List list, final d.a aVar, final Map map, long j3, BaseRequest baseRequest, boolean z16, long j16, String str, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        long j17;
        QLog.d("TEDGEQFS_QFSCloudRerank", 1, "getItemList onReceive: dispatch result:" + z16 + " | TraceId:" + qFSRankCloudGetFeedsReq.getTraceId() + " | SeqId:" + qFSRankCloudGetFeedsReq.getCurrentSeq() + " | retCode:" + j16 + " | retMessage:" + str);
        final EdgeStatus edgeStatus = new EdgeStatus();
        edgeStatus.setCode(j16);
        edgeStatus.setMsg(str);
        if (z16 && j16 == 0) {
            if (feedCloudRead$StGetFeedListRsp.vecFeed.has()) {
                final List<FeedCloudMeta$StFeed> g16 = g(ic0.b.b(list), feedCloudRead$StGetFeedListRsp.vecFeed.get());
                if (g16.isEmpty()) {
                    QLog.e("TEDGEQFS_QFSCloudRerank", 1, "getItemList onReceive marge list is empty");
                    aVar.a(edgeStatus, null, map);
                } else {
                    RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: hc0.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            c.j(g16, aVar, edgeStatus, map);
                        }
                    });
                }
            } else {
                QLog.e("TEDGEQFS_QFSCloudRerank", 1, "sendReRankRequest error:rsp.vecFeed is empty!");
                aVar.a(edgeStatus, null, map);
            }
        } else {
            QLog.e("TEDGEQFS_QFSCloudRerank", 1, "sendReRankRequest error:", str);
            aVar.a(edgeStatus, null, map);
        }
        QFSRankEdgeReportHelper.a q16 = new QFSRankEdgeReportHelper.a().n("tedgeRSV2_cloud_rerank").p(System.currentTimeMillis() - j3).q(baseRequest.getTraceId());
        if (z16 && j16 == 0) {
            j17 = !feedCloudRead$StGetFeedListRsp.vecFeed.has() ? 1 : 0;
        } else {
            j17 = j16;
        }
        QFSRankEdgeReportHelper.g(q16.o(j17).m(str));
    }

    private static List<SealCloudRerankInfo$IneterRecommendFeedDetail> l(List<EdgeItem> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            EdgeItem edgeItem = list.get(i3);
            if (edgeItem instanceof QFSEdgeItem) {
                QFSEdgeItem qFSEdgeItem = (QFSEdgeItem) edgeItem;
                if (qFSEdgeItem.getFeedBlockData() != null && qFSEdgeItem.getFeedBlockData().g() != null) {
                    SealCloudRerankInfo$IneterRecommendFeedDetail sealCloudRerankInfo$IneterRecommendFeedDetail = new SealCloudRerankInfo$IneterRecommendFeedDetail();
                    sealCloudRerankInfo$IneterRecommendFeedDetail.feedid.set(i(qFSEdgeItem.getFeedBlockData().g()));
                    sealCloudRerankInfo$IneterRecommendFeedDetail.pos.set(i3);
                    sealCloudRerankInfo$IneterRecommendFeedDetail.recom_trace.set(qFSEdgeItem.getFeedBlockData().g().recomInfo.recomTrace.get());
                    arrayList.add(sealCloudRerankInfo$IneterRecommendFeedDetail);
                }
            }
        }
        return arrayList;
    }

    private static List<SealCloudRerankInfo$InteractiveFeed> m(QFSEdgeAction qFSEdgeAction) {
        ArrayList arrayList = new ArrayList();
        if (qFSEdgeAction != null && !qFSEdgeAction.getEvents().isEmpty()) {
            ArrayList<TEdgeEvent$Event> events = qFSEdgeAction.getEvents();
            SealCloudRerankInfo$InteractiveFeed sealCloudRerankInfo$InteractiveFeed = new SealCloudRerankInfo$InteractiveFeed();
            sealCloudRerankInfo$InteractiveFeed.feedid.set(qFSEdgeAction.getItemID());
            TEdgeEvent$Event tEdgeEvent$Event = events.get(0);
            for (int i3 = 1; i3 < events.size(); i3++) {
                TEdgeEvent$Event tEdgeEvent$Event2 = events.get(i3);
                if (tEdgeEvent$Event == null || tEdgeEvent$Event2.timestamp.get() > tEdgeEvent$Event.timestamp.get()) {
                    tEdgeEvent$Event = tEdgeEvent$Event2;
                }
            }
            sealCloudRerankInfo$InteractiveFeed.interactive_timestamp.set(tEdgeEvent$Event.timestamp.get());
            long b16 = ic0.f.b(f(tEdgeEvent$Event), 0L);
            long b17 = ic0.f.b(e(tEdgeEvent$Event), 0L);
            sealCloudRerankInfo$InteractiveFeed.play_duration.set(b16);
            sealCloudRerankInfo$InteractiveFeed.physical_duration.set(b17);
            sealCloudRerankInfo$InteractiveFeed.interactive_count.set(f404686a);
            ArrayList arrayList2 = new ArrayList();
            long j3 = tEdgeEvent$Event.type.get();
            arrayList2.add(Long.valueOf(j3));
            sealCloudRerankInfo$InteractiveFeed.interactive_type_array.set(arrayList2);
            arrayList.add(sealCloudRerankInfo$InteractiveFeed);
            QLog.d("TEDGEQFS_QFSCloudRerank", 1, "wrapInteractiveInfo success actionType:" + j3 + ",playTime:" + b16 + ",physicalTime:" + b17);
        }
        return arrayList;
    }
}
