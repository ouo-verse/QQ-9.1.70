package p70;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchGoodsCardData;
import com.tencent.biz.qqcircle.immersive.events.QFSSearchFilterDataEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSPicFeedPlayEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSVideoFeedPlayEvent;
import com.tencent.biz.qqcircle.immersive.request.QFSGetSearchPageRequest;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.qqcircle.immersive.utils.y;
import com.tencent.biz.qqcircle.immersive.views.search.feed.util.QFSSearchGoodsManager;
import com.tencent.biz.qqcircle.immersive.views.search.util.l;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.qqcircle.wink.QQWinkSchemaParamsModifier;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.engineer.test.api.RFWTestMock;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetSearchPageRsp;
import feedcloud.FeedCloudRead$StUserFeedsInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes4.dex */
public class i extends p70.a {
    private long C;
    private volatile String E;
    private String K;
    private String L;
    private boolean M;
    public volatile boolean S;
    private volatile boolean T;
    private com.tencent.biz.qqcircle.immersive.views.search.util.d V;
    private List<String> W;
    private final MutableLiveData<UIStateData<FeedCloudRead$StGetSearchPageRsp>> D = new MutableLiveData<>();
    private final MutableLiveData<UIStateData<List<e30.b>>> F = new MutableLiveData<>();
    private final MutableLiveData<String> G = new MutableLiveData<>();
    private final List<e30.b> H = new ArrayList();
    private Collection<e30.b> I = null;
    private final MutableLiveData<UIStateData<List<e30.b>>> J = new MediatorLiveData();
    private boolean N = true;
    private int P = 3;
    private long Q = 0;
    private boolean R = false;
    private final QFSSearchGoodsManager U = new QFSSearchGoodsManager();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetSearchPageRsp> {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<i> f425465a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f425466b;

        /* renamed from: c, reason: collision with root package name */
        private final String f425467c;

        /* renamed from: d, reason: collision with root package name */
        private final int f425468d;

        a(i iVar, boolean z16, String str, int i3) {
            this.f425465a = new WeakReference<>(iVar);
            this.f425466b = z16;
            this.f425467c = str;
            this.f425468d = i3;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp) {
            QLog.d("QFSSearchResultViewModel", 1, "[requestSearchResult] onReceive: dispatch Success:" + z16 + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
            if (baseRequest instanceof QFSGetSearchPageRequest) {
                QFSGetSearchPageRequest qFSGetSearchPageRequest = (QFSGetSearchPageRequest) baseRequest;
                qFSGetSearchPageRequest.addReportExtraData(QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, String.valueOf(this.f425466b)).addReportExtraData(QFSSearchBaseRequest.EXTRA_KEY_SEARCH_TYPE, qFSGetSearchPageRequest.getSearchTypeReportData()).addReportExtraData(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, String.valueOf(this.f425468d)).addReportExtraData("word", String.valueOf(this.f425467c)).addSearchPageRspExtraData(feedCloudRead$StGetSearchPageRsp, z16, j3).reportCmdSuccessRate(j3, str);
            }
            i iVar = this.f425465a.get();
            if (iVar != null && iVar.u2(baseRequest)) {
                iVar.o2(z16, j3, str, feedCloudRead$StGetSearchPageRsp, this.f425466b);
            }
        }
    }

    public i() {
        SimpleEventBus.getInstance().registerReceiver(this);
        Q1("feed");
    }

    private void D2() {
        this.U.j();
        L1();
    }

    public static boolean X1(UIStateData<?> uIStateData) {
        if (uIStateData == null) {
            return false;
        }
        return uIStateData.getIsFinish();
    }

    public static boolean Z1(UIStateData<?> uIStateData) {
        if (uIStateData == null) {
            return false;
        }
        if (!uIStateData.isLoading() && !uIStateData.isCacheData()) {
            return false;
        }
        return true;
    }

    private void a2() {
        int size;
        if (this.H.isEmpty()) {
            QLog.w("QFSSearchResultViewModel", 1, "[combineTopRankFeeds] no top rank feeds");
            return;
        }
        QLog.i("QFSSearchResultViewModel", 1, "[combineTopRankFeeds] combine begin, topRankFeeds size=" + this.H.size());
        ArrayList arrayList = new ArrayList(this.H);
        if (this.F.getValue() != null && this.F.getValue().getData() != null) {
            List<e30.b> data = this.F.getValue().getData();
            this.I = y.b(arrayList, data);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[combineTopRankFeeds] search size=");
            sb5.append(data.size());
            sb5.append(", filtered size=");
            Collection<e30.b> collection = this.I;
            if (collection == null) {
                size = 0;
            } else {
                size = collection.size();
            }
            sb5.append(size);
            QLog.i("QFSSearchResultViewModel", 1, sb5.toString());
            Collection<e30.b> collection2 = this.I;
            if (collection2 != null) {
                arrayList.addAll(collection2);
            }
        }
        QLog.i("QFSSearchResultViewModel", 1, "[combineTopRankFeeds] combine end, combined size=" + arrayList.size());
        UIStateData<List<e30.b>> value = this.F.getValue();
        if (value != null) {
            UIStateData<List<e30.b>> copy = value.copy();
            copy.setDataList(arrayList);
            this.J.postValue(copy);
            return;
        }
        QLog.i("QFSSearchResultViewModel", 1, "[combineTopRankFeeds] invalid data");
    }

    private void j2(QFSPicFeedPlayEvent qFSPicFeedPlayEvent) {
        if (TextUtils.equals(qFSPicFeedPlayEvent.globalKey, b2()) && !TextUtils.isEmpty(qFSPicFeedPlayEvent.feedId) && p.g(this.F.getValue(), qFSPicFeedPlayEvent.feedId) != null) {
            R1(qFSPicFeedPlayEvent.feedId, qFSPicFeedPlayEvent.progress);
        }
    }

    @WorkerThread
    private void k2(FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp) {
        List<FeedCloudCommon$Entry> list = feedCloudRead$StGetSearchPageRsp.extInfo.get().mapInfo.get();
        if (!list.isEmpty()) {
            for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
                if ("need_one_drag_n".equals(feedCloudCommon$Entry.key.get())) {
                    this.T = "1".equals(feedCloudCommon$Entry.value.get());
                }
            }
        }
    }

    @WorkerThread
    private void l2(List<e30.b> list, boolean z16, boolean z17) {
        if (z16) {
            List<e30.b> data = this.F.getValue().getData();
            ArrayList arrayList = new ArrayList(data.size() + list.size());
            arrayList.addAll(data);
            arrayList.addAll(list);
            this.F.postValue(UIStateData.obtainSuccess(false).setData(true, arrayList).setFinish(z17));
        } else {
            this.F.postValue(UIStateData.obtainSuccess(false).setData(false, list).setFinish(z17));
        }
        a2();
    }

    private void m2(FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp) {
        if (!this.M && !TextUtils.equals(this.K, this.L) && this.N) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSSearchFilterDataEvent(feedCloudRead$StGetSearchPageRsp.filter.groups.get(), this.contextHashCode));
            this.K = this.L;
            this.W = null;
        }
    }

    @WorkerThread
    private void n2(long j3, FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp, boolean z16, boolean z17) {
        boolean z18;
        if (z16) {
            return;
        }
        boolean z19 = true;
        if (feedCloudRead$StGetSearchPageRsp != null && !TextUtils.isEmpty(feedCloudRead$StGetSearchPageRsp.searchMixTag.tagInfo.tagName.get())) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            this.G.postValue(QQWinkSchemaParamsModifier.f93925a.a(feedCloudRead$StGetSearchPageRsp.searchMixTag.tagInfo.optInfo.publishSchema.get(), feedCloudRead$StGetSearchPageRsp.searchMixTag.tagInfo));
        }
        if (feedCloudRead$StGetSearchPageRsp.searchUserInfo.userList.isEmpty() && feedCloudRead$StGetSearchPageRsp.searchTagInfo.tagList.isEmpty() && feedCloudRead$StGetSearchPageRsp.bannerInfo.banners.isEmpty() && feedCloudRead$StGetSearchPageRsp.searchHotEventInfo.feedList.isEmpty() && feedCloudRead$StGetSearchPageRsp.mixPageTagInfo.feeds.isEmpty() && !feedCloudRead$StGetSearchPageRsp.mixPageUserInfo.has() && !z18) {
            z19 = false;
        }
        if (feedCloudRead$StGetSearchPageRsp.searchFeedInfo.feedList.isEmpty() && !z19) {
            this.D.postValue(UIStateData.obtainEmpty().setRetCode(j3).setLoadMore(false).setFinish(z17));
        } else {
            this.D.postValue(UIStateData.obtainSuccess(false).setData(false, feedCloudRead$StGetSearchPageRsp).setFinish(z17));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RFWTestMock(id = "QFS_SEARCH_RESULT")
    @WorkerThread
    /* renamed from: p2, reason: merged with bridge method [inline-methods] */
    public void v2(boolean z16, long j3, String str, final FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp, boolean z17) {
        boolean z18;
        if (feedCloudRead$StGetSearchPageRsp != null && z16 && j3 == 0) {
            this.E = feedCloudRead$StGetSearchPageRsp.searchFeedInfo.attachInfo.get();
            this.S = feedCloudRead$StGetSearchPageRsp.searchFeedInfo.isJumpTagSearch.get();
            ArrayList<e30.b> b16 = e30.d.b(feedCloudRead$StGetSearchPageRsp.searchFeedInfo.feedList.get());
            if (!VSNetworkHelper.isProtocolCache(str)) {
                z2(feedCloudRead$StGetSearchPageRsp, b16, z17);
            }
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: p70.g
                @Override // java.lang.Runnable
                public final void run() {
                    i.this.w2(feedCloudRead$StGetSearchPageRsp);
                }
            });
            if (feedCloudRead$StGetSearchPageRsp.searchFeedInfo.isOver.get() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            n2(j3, feedCloudRead$StGetSearchPageRsp, z17, z18);
            l2(b16, z17, z18);
            k2(feedCloudRead$StGetSearchPageRsp);
            m2(feedCloudRead$StGetSearchPageRsp);
            return;
        }
        this.D.postValue(UIStateData.obtainError(str).setData(z17, feedCloudRead$StGetSearchPageRsp).setRetCode(j3));
    }

    private void q2(QFSVideoFeedPlayEvent qFSVideoFeedPlayEvent) {
        e30.b g16;
        if ((!TextUtils.equals(qFSVideoFeedPlayEvent.globalKey, b2()) && !TextUtils.equals(qFSVideoFeedPlayEvent.globalKey, c2())) || TextUtils.isEmpty(qFSVideoFeedPlayEvent.feedId)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.C < 500) {
            return;
        }
        this.C = currentTimeMillis;
        if (TextUtils.equals(qFSVideoFeedPlayEvent.globalKey, c2())) {
            g16 = p.f(this.I, qFSVideoFeedPlayEvent.feedId);
        } else {
            g16 = p.g(this.F.getValue(), qFSVideoFeedPlayEvent.feedId);
        }
        if (g16 != null && TextUtils.equals(p.m(g16.g()), qFSVideoFeedPlayEvent.playUrl)) {
            R1(qFSVideoFeedPlayEvent.feedId, qFSVideoFeedPlayEvent.progress);
        }
    }

    private static void s2(final List<e30.b> list) {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: p70.h
            @Override // java.lang.Runnable
            public final void run() {
                i.x2(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u2(BaseRequest baseRequest) {
        if ((baseRequest instanceof QFSGetSearchPageRequest) && TextUtils.equals(this.L, ((QFSGetSearchPageRequest) baseRequest).getWord())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w2(FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp) {
        this.U.c(feedCloudRead$StGetSearchPageRsp.searchFeedInfo.feedAds.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x2(List list) {
        w20.a.j().initOrUpdateGlobalState(list, true);
    }

    @WorkerThread
    private static void z2(FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp, List<e30.b> list, boolean z16) {
        s2(list);
        if (!z16) {
            List<FeedCloudMeta$StFeed> list2 = feedCloudRead$StGetSearchPageRsp.searchHotEventInfo.feedList.get();
            if (!list2.isEmpty()) {
                ArrayList arrayList = new ArrayList(list2);
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (p.y((FeedCloudMeta$StFeed) arrayList.get(size))) {
                        arrayList.remove(size);
                    }
                }
                s2(e30.d.b(arrayList));
            }
            Iterator<FeedCloudRead$StUserFeedsInfo> it = feedCloudRead$StGetSearchPageRsp.searchUserInfo.userFeeds.get().iterator();
            while (it.hasNext()) {
                List<FeedCloudMeta$StFeed> list3 = it.next().feeds.get();
                if (!list3.isEmpty()) {
                    s2(e30.d.b(list3));
                }
            }
        }
    }

    public void A2(e30.b bVar) {
        UIStateData<List<e30.b>> value = this.F.getValue();
        Objects.requireNonNull(value);
        List<e30.b> data = value.getData();
        data.remove(bVar);
        this.F.postValue(UIStateData.obtainSuccess(false).setData(true, data));
    }

    public void B2(String str, l lVar) {
        C2(str, lVar, null);
    }

    public void C2(String str, l lVar, List<FeedCloudCommon$Entry> list) {
        String str2;
        this.L = str;
        this.N = lVar.d();
        this.M = lVar.b();
        ArrayList arrayList = new ArrayList();
        if (!lVar.b()) {
            D2();
            arrayList.add(5);
            arrayList.add(6);
            arrayList.add(4);
            arrayList.add(9);
            arrayList.add(10);
            arrayList.add(13);
            arrayList.add(14);
            arrayList.add(11);
            arrayList.add(12);
            if (lVar.d()) {
                arrayList.add(7);
            }
            if (lVar.c()) {
                arrayList.add(15);
            }
            arrayList.add(16);
            if (com.tencent.biz.qqcircle.immersive.utils.a.h(str)) {
                arrayList.add(17);
            }
            arrayList.add(18);
        }
        arrayList.add(3);
        QFSGetSearchPageRequest.a k3 = new QFSGetSearchPageRequest.a().l(str).j(1).k(arrayList);
        if (lVar.b()) {
            str2 = this.E;
        } else {
            str2 = "";
        }
        QFSGetSearchPageRequest b16 = k3.h(str2).i(this.W).e(list).b();
        b16.setEnableCache(lVar.a());
        QLog.d(getTAG(), 1, "[requestSearchResult] start request");
        sendRequest(b16, new a(this, lVar.b(), str, this.P));
    }

    public void E2(List<String> list) {
        if (list == null) {
            this.K = null;
        }
        this.W = list;
    }

    public void F2(boolean z16) {
        this.R = z16;
    }

    public void G2(String str) {
        this.L = str;
    }

    public void H2(int i3) {
        this.P = i3;
    }

    public void I2(long j3) {
        this.Q = j3;
    }

    public void J2(List<e30.b> list) {
        this.H.clear();
        this.H.addAll(list);
        a2();
    }

    @Override // p70.a
    public void O1(Context context) {
        int hashCode;
        super.O1(context);
        if (context == null) {
            hashCode = 0;
        } else {
            hashCode = context.hashCode();
        }
        this.contextHashCode = hashCode;
    }

    public String b2() {
        return getTAG() + hashCode();
    }

    public String c2() {
        return b2() + "-TopRank";
    }

    @Nullable
    public QFSSearchGoodsCardData d2(String str) {
        return this.U.g(str);
    }

    public String e2() {
        return this.L;
    }

    public com.tencent.biz.qqcircle.immersive.views.search.util.d f2() {
        if (this.V == null) {
            this.V = new com.tencent.biz.qqcircle.immersive.views.search.util.d();
        }
        return this.V;
    }

    public long g2() {
        return this.Q;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public MutableLiveData<UIStateData<List<e30.b>>> getDisplaySurfaceData(Object... objArr) {
        if (objArr.length >= 2) {
            Object obj = objArr[1];
            if ((obj instanceof QCircleLayerBean) && TextUtils.equals(((QCircleLayerBean) obj).getGlobalViewModelKey(), c2())) {
                QLog.d("QFSSearchResultViewModel", 1, "[getDisplaySurfaceData] get feeds with top rank");
                return this.J;
            }
        }
        return this.F;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<?>> getEventClass() {
        ArrayList<Class<?>> arrayList = new ArrayList<>();
        arrayList.add(QFSVideoFeedPlayEvent.class);
        arrayList.add(QFSPicFeedPlayEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSSearchResultViewModel";
    }

    public MutableLiveData<UIStateData<List<e30.b>>> h2() {
        return this.F;
    }

    public MutableLiveData<UIStateData<FeedCloudRead$StGetSearchPageRsp>> i2() {
        return this.D;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
        y2();
    }

    public void o2(final boolean z16, final long j3, final String str, final FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp, final boolean z17) {
        if (RFWThreadManager.isMainThread()) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: p70.f
                @Override // java.lang.Runnable
                public final void run() {
                    i.this.v2(z16, j3, str, feedCloudRead$StGetSearchPageRsp, z17);
                }
            });
        } else {
            v2(z16, j3, str, feedCloudRead$StGetSearchPageRsp, z17);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSVideoFeedPlayEvent) {
            q2((QFSVideoFeedPlayEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSPicFeedPlayEvent) {
            j2((QFSPicFeedPlayEvent) simpleBaseEvent);
        }
    }

    public boolean r2() {
        return this.R;
    }

    public boolean t2() {
        return this.T;
    }

    protected void y2() {
        if (!Z1(this.F.getValue()) && !X1(this.F.getValue())) {
            l lVar = new l();
            lVar.e(true);
            B2(this.L, lVar);
        }
    }
}
