package b50;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.rerank.request.QFSRankEdgeGetDetailsReq;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.Pair;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StBatchGetFeedDetailRsp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import uq3.o;

/* compiled from: P */
/* loaded from: classes4.dex */
public class g extends com.tencent.biz.qqcircle.immersive.layer.base.e {
    private QCircleInitBean K;
    private String L;
    private String M;
    private String P;
    private String N = "";
    private final AtomicInteger Q = new AtomicInteger(0);
    private final AtomicBoolean R = new AtomicBoolean(false);
    private final List<Long> S = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public QCircleInitBean f27913a;

        /* renamed from: b, reason: collision with root package name */
        public List<FeedCloudMeta$StFeed> f27914b;

        /* renamed from: c, reason: collision with root package name */
        public List<FeedCloudMeta$StFeed> f27915c;

        /* renamed from: d, reason: collision with root package name */
        public List<Long> f27916d;

        /* renamed from: e, reason: collision with root package name */
        public int f27917e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f27918f;

        /* renamed from: g, reason: collision with root package name */
        public long f27919g;

        /* renamed from: h, reason: collision with root package name */
        public String f27920h;

        /* renamed from: i, reason: collision with root package name */
        public FeedCloudRead$StBatchGetFeedDetailRsp f27921i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f27922j;

        a() {
        }
    }

    private void A2(String str, FeedCloudRead$StBatchGetFeedDetailRsp feedCloudRead$StBatchGetFeedDetailRsp) {
        if (!VSNetworkHelper.isProtocolCache(str) && feedCloudRead$StBatchGetFeedDetailRsp != null) {
            w20.a.j().initOrUpdateGlobalState((List) e30.d.b(feedCloudRead$StBatchGetFeedDetailRsp.feeds.get()), true);
        }
    }

    private void B2(List<FeedCloudMeta$StFeed> list, List<FeedCloudMeta$StFeed> list2, List<Long> list3, boolean z16) {
        Long l3;
        if (list != null && !list.isEmpty() && list2 != null && !list2.isEmpty() && list3 != null && !list3.isEmpty()) {
            if (!z16) {
                this.S.clear();
            }
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < list2.size(); i3++) {
                String g16 = bj.g((FeedCloudMeta$StFeed) RFSafeListUtils.get(list2, i3));
                int i16 = 0;
                while (true) {
                    if (i16 >= list.size()) {
                        break;
                    }
                    if (TextUtils.equals(bj.g((FeedCloudMeta$StFeed) RFSafeListUtils.get(list, i16)), g16) && (l3 = (Long) RFSafeListUtils.get(list3, i16)) != null && !this.S.contains(l3)) {
                        this.S.add(l3);
                        sb5.append(l3 + ",");
                        break;
                    }
                    i16++;
                }
            }
            RFWLog.d("QCHV-QFSLayerChatHistoryViewModel", RFWLog.USR, "[updateSeqList] size: " + this.S.size() + " | cur seq list: " + ((Object) sb5));
        }
    }

    private List<FeedCloudMeta$StFeed> o2(List<String> list, int i3) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            int min = Math.min(list.size(), i3);
            for (int i16 = 0; i16 < min; i16++) {
                String str = list.get(i16);
                if (!TextUtils.isEmpty(str)) {
                    FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
                    feedCloudMeta$StFeed.f398449id.set(str);
                    arrayList.add(feedCloudMeta$StFeed);
                }
            }
            return arrayList;
        }
        return null;
    }

    private void q2(final QCircleInitBean qCircleInitBean, final List<FeedCloudMeta$StFeed> list, final int i3, final boolean z16) {
        Pair<List<FeedCloudMeta$StFeed>, List<Long>> w26 = w2(list, z16);
        final List<FeedCloudMeta$StFeed> list2 = w26.first;
        final List<Long> list3 = w26.second;
        if (list2 != null && !list2.isEmpty()) {
            this.K = qCircleInitBean;
            final QFSRankEdgeGetDetailsReq qFSRankEdgeGetDetailsReq = new QFSRankEdgeGetDetailsReq(list2, 0);
            qFSRankEdgeGetDetailsReq.mRequest.extInfo.set(getSession(true));
            String x26 = x2(list2, list3);
            RFWLog.d("QCHV-QFSLayerChatHistoryViewModel", RFWLog.USR, "[getSourceFeedList] req size: " + list2.size() + " | ids: " + x26);
            sendRequest(qFSRankEdgeGetDetailsReq, new VSDispatchObserver.OnVSRspCallBack() { // from class: b50.e
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str, Object obj) {
                    g.this.t2(qFSRankEdgeGetDetailsReq, qCircleInitBean, i3, list, list2, list3, z16, baseRequest, z17, j3, str, (FeedCloudRead$StBatchGetFeedDetailRsp) obj);
                }
            });
            return;
        }
        RFWLog.d("QCHV-QFSLayerChatHistoryViewModel", RFWLog.USR, "[getSourceFeedList] currentReqFeed == null || currentReqFeed.isEmpty().");
    }

    private void r2(@NonNull final a aVar) {
        if (this.Q.get() >= aVar.f27917e) {
            this.R.set(false);
        }
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: b50.f
            @Override // java.lang.Runnable
            public final void run() {
                g.this.u2(aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t2(QFSRankEdgeGetDetailsReq qFSRankEdgeGetDetailsReq, QCircleInitBean qCircleInitBean, int i3, List list, List list2, List list3, boolean z16, BaseRequest baseRequest, boolean z17, long j3, String str, FeedCloudRead$StBatchGetFeedDetailRsp feedCloudRead$StBatchGetFeedDetailRsp) {
        S1(z17, qFSRankEdgeGetDetailsReq, j3, str, "getBatchGetFeedDetail");
        a aVar = new a();
        aVar.f27913a = qCircleInitBean;
        aVar.f27917e = i3;
        aVar.f27914b = list;
        aVar.f27915c = list2;
        aVar.f27916d = list3;
        aVar.f27918f = z17;
        aVar.f27919g = j3;
        aVar.f27920h = str;
        aVar.f27921i = feedCloudRead$StBatchGetFeedDetailRsp;
        aVar.f27922j = z16;
        r2(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u2(a aVar) {
        FeedCloudRead$StBatchGetFeedDetailRsp feedCloudRead$StBatchGetFeedDetailRsp;
        if (aVar == null) {
            RFWLog.w("QCHV-QFSLayerChatHistoryViewModel", RFWLog.USR, "[handleSourceDetailRsp] result == null.");
            return;
        }
        if (aVar.f27918f && (feedCloudRead$StBatchGetFeedDetailRsp = aVar.f27921i) != null) {
            if (feedCloudRead$StBatchGetFeedDetailRsp.extInfo.has()) {
                updateSession(aVar.f27921i.extInfo.get());
            }
            U1(aVar.f27920h, false, this.K);
            this.f86506m.setCurrentState(4);
            if (aVar.f27919g != 0) {
                this.D.postValue(UIStateData.obtainError(aVar.f27920h).setRetCode(aVar.f27919g).setLoadMore(false));
                return;
            }
            List<FeedCloudMeta$StFeed> list = aVar.f27921i.feeds.get();
            String x26 = x2(list, aVar.f27916d);
            RFWLog.d("QCHV-QFSLayerChatHistoryViewModel", RFWLog.USR, "[getSourceFeedList] rsp feed size: " + list.size() + " | ids: " + x26);
            String g16 = bj.g((FeedCloudMeta$StFeed) RFSafeListUtils.get(aVar.f27921i.feeds.get(), 0));
            String g17 = bj.g((FeedCloudMeta$StFeed) RFSafeListUtils.get(aVar.f27915c, 0));
            if (!aVar.f27922j && !TextUtils.equals(g16, g17)) {
                RFWLog.d("QCHV-QFSLayerChatHistoryViewModel", RFWLog.USR, "[getSourceFeedList] reqFirstFeedId: " + g17 + " | rspFirstFeedId: " + g16);
                this.D.postValue(UIStateData.obtainError("\u89c6\u9891\u6682\u4e0d\u53ef\u67e5\u770b").setRetCode(10014L).setLoadMore(false));
                return;
            }
            A2(aVar.f27920h, aVar.f27921i);
            k2(aVar.f27922j, list, true, 0);
            B2(aVar.f27915c, aVar.f27921i.feeds.get(), aVar.f27916d, aVar.f27922j);
            if (this.Q.get() < aVar.f27917e) {
                this.Q.incrementAndGet();
                q2(aVar.f27913a, aVar.f27914b, aVar.f27917e, true);
                return;
            }
            return;
        }
        this.D.postValue(UIStateData.obtainError(aVar.f27920h).setRetCode(aVar.f27919g).setLoadMore(false));
    }

    private List<Long> v2() {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = new JSONArray(this.P);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(Long.valueOf(jSONArray.getLong(i3)));
            }
            return arrayList;
        } catch (Throwable unused) {
            return new ArrayList();
        }
    }

    private Pair<List<FeedCloudMeta$StFeed>, List<Long>> w2(List<FeedCloudMeta$StFeed> list, boolean z16) {
        int size;
        int size2;
        List<Long> v26 = v2();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int O = o.O(6);
        int i3 = this.Q.get() * O;
        int i16 = O + i3;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        int min = Math.min(size, i16);
        for (int i17 = i3; i17 < min; i17++) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) RFSafeListUtils.get(list, i17);
            if (feedCloudMeta$StFeed != null) {
                arrayList2.add(feedCloudMeta$StFeed);
            }
            Long l3 = (Long) RFSafeListUtils.get(v26, i17);
            if (l3 != null) {
                arrayList.add(l3);
            }
        }
        int i18 = RFWLog.USR;
        Object[] objArr = new Object[1];
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[obtainCurrentFeed] startIndex: ");
        sb5.append(i3);
        sb5.append(" | endIndex: ");
        sb5.append(min);
        sb5.append(" | req feed size: ");
        sb5.append(arrayList2.size());
        sb5.append(" | req seq size: ");
        if (v26 == null) {
            size2 = 0;
        } else {
            size2 = v26.size();
        }
        sb5.append(size2);
        sb5.append(" | isLoadMore: ");
        sb5.append(z16);
        objArr[0] = sb5.toString();
        RFWLog.d("QCHV-QFSLayerChatHistoryViewModel", i18, objArr);
        return new Pair<>(arrayList2, arrayList);
    }

    private String x2(List<FeedCloudMeta$StFeed> list, List<Long> list2) {
        if (list != null && !list.isEmpty()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[");
            for (int i3 = 0; i3 < list.size(); i3++) {
                String g16 = bj.g((FeedCloudMeta$StFeed) RFSafeListUtils.get(list, i3));
                Long l3 = (Long) RFSafeListUtils.get(list2, i3);
                sb5.append(g16);
                sb5.append("|");
                sb5.append(l3);
                sb5.append(",");
            }
            sb5.append("]");
            return sb5.toString();
        }
        return "";
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.e, com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseViewModel, com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCHV-QFSLayerChatHistoryViewModel";
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.e
    public boolean h2() {
        String[] split;
        if (!z20.g.a()) {
            return false;
        }
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_enable_load_more_back_up_feed_white_list", com.tencent.biz.qqcircle.immersive.layer.base.e.J);
        if (!TextUtils.isEmpty(loadAsString) && (split = loadAsString.split("\\|")) != null && split.length != 0) {
            for (String str : split) {
                if (TextUtils.equals(str, this.L)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public void onPreloadComplete(Object[] objArr) {
        super.onPreloadComplete(objArr);
    }

    public Long p2(int i3) {
        return (Long) RFSafeListUtils.get(this.S, i3);
    }

    public void s2(QCircleInitBean qCircleInitBean) {
        if (qCircleInitBean != null && qCircleInitBean.getSchemeAttrs() != null) {
            HashMap<String, String> schemeAttrs = qCircleInitBean.getSchemeAttrs();
            this.L = schemeAttrs.get("xsj_main_entrance");
            this.P = schemeAttrs.get("chat_seq_list");
            RFWLog.d("QCHV-QFSLayerChatHistoryViewModel", RFWLog.USR, "[initSchemaParams] mLoginMainEntrance:" + this.L);
        }
    }

    public void y2(QCircleInitBean qCircleInitBean, boolean z16, boolean z17) {
        int size;
        int max;
        if (qCircleInitBean == null) {
            QLog.d("QCHV-QFSLayerChatHistoryViewModel", 1, "[requestFeedDetailAndList] bean is null. ");
            return;
        }
        int P = o.P(3);
        int O = o.O(6);
        List<FeedCloudMeta$StFeed> o26 = o2(qCircleInitBean.getSourceIds(), P * O);
        if (o26 == null) {
            size = 0;
        } else {
            size = o26.size();
        }
        if (size == 0) {
            max = 1;
        } else {
            max = Math.max(size / O, 1);
        }
        if (this.R.get()) {
            QLog.d("QCHV-QFSLayerChatHistoryViewModel", 1, "[requestFeedDetailAndList] current request data, not send.");
            return;
        }
        QLog.d("QCHV-QFSLayerChatHistoryViewModel", 1, "[requestFeedDetailAndList] isGetFeedList: " + z16 + " | isRefresh: " + z17 + " | loadMoreReqCount: " + P + " | loadMorePageMaxCount: " + O + " | refreshReqCount: " + max);
        this.K = qCircleInitBean;
        s2(qCircleInitBean);
        P1().setCurrentState(3);
        this.D.setValue(UIStateData.obtainLoading());
        this.R.set(true);
        this.Q.set(0);
        q2(qCircleInitBean, o26, max, false);
    }

    public void z2(String str) {
        this.M = str;
    }
}
