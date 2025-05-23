package com.tencent.mobileqq.search.business.qcircle.video.common.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.request.QFSGetSearchPageRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetSearchPageRsp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends com.tencent.biz.qqcircle.viewmodels.a implements IDataDisplaySurface<e30.b> {
    private String C;
    private String D;

    /* renamed from: m, reason: collision with root package name */
    private final MediatorLiveData<UIStateData<List<e30.b>>> f283077m = new MediatorLiveData<>();
    private final Collection<String> E = new ArrayList(3);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetSearchPageRsp> {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<c> f283078a;

        a(c cVar) {
            this.f283078a = new WeakReference<>(cVar);
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp) {
            int i3;
            c cVar = this.f283078a.get();
            if (cVar == null) {
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(hashCode());
            sb5.append("|requestFeedsData onReceive: dispatch Success:");
            sb5.append(z16);
            sb5.append(" | TraceId:");
            sb5.append(baseRequest.getTraceId());
            sb5.append(" | SeqId:");
            sb5.append(baseRequest.getCurrentSeq());
            sb5.append(" | retCode:");
            sb5.append(j3);
            sb5.append(" | retMessage:");
            sb5.append(str);
            sb5.append(" | size:");
            if (feedCloudRead$StGetSearchPageRsp != null) {
                i3 = feedCloudRead$StGetSearchPageRsp.searchFeedInfo.feedList.size();
            } else {
                i3 = 0;
            }
            sb5.append(i3);
            com.tencent.xaction.log.b.a("QCircleSearchCommonVideoDataViewModel", 1, sb5.toString());
            if (z16 && j3 == 0) {
                cVar.S1(feedCloudRead$StGetSearchPageRsp);
            } else {
                cVar.a2(UIStateData.obtainError(str).setRetCode(j3).setData(true, cVar.R1()).setLoadMore(true));
            }
        }
    }

    private QFSGetSearchPageRequest P1() {
        return new QFSGetSearchPageRequest.a(this.D).h(this.C).a();
    }

    private List<e30.b> Q1(Collection<e30.b> collection) {
        ArrayList arrayList = new ArrayList();
        if (collection != null && !collection.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            for (e30.b bVar : collection) {
                if (!TextUtils.isEmpty(bVar.g().f398449id.get())) {
                    arrayList.add(bVar);
                }
                if (this.E.contains(bVar.g().f398449id.get())) {
                    arrayList2.add(bVar);
                }
            }
            collection.removeAll(arrayList2);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S1(final FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.search.business.qcircle.video.common.viewmodel.a
            @Override // java.lang.Runnable
            public final void run() {
                c.this.T1(feedCloudRead$StGetSearchPageRsp);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T1(FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp) {
        W1(feedCloudRead$StGetSearchPageRsp);
        Z1(feedCloudRead$StGetSearchPageRsp, X1(feedCloudRead$StGetSearchPageRsp));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U1(boolean z16, Collection collection, UIStateData uIStateData) {
        if (this.f283077m.getValue() != null) {
            List<e30.b> data = this.f283077m.getValue().getData();
            ArrayList arrayList = new ArrayList();
            if (z16 && data != null && !data.isEmpty()) {
                arrayList.addAll(data);
            }
            if (collection != null && !collection.isEmpty()) {
                arrayList.addAll(collection);
            }
            uIStateData.setDataList(arrayList);
            if (collection != null && arrayList.isEmpty()) {
                uIStateData.setState(0);
            }
        }
        this.f283077m.setValue(uIStateData);
    }

    private void W1(FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp) {
        if (feedCloudRead$StGetSearchPageRsp == null) {
            return;
        }
        this.C = feedCloudRead$StGetSearchPageRsp.searchFeedInfo.attachInfo.get();
    }

    private static boolean X1(FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp) {
        if (feedCloudRead$StGetSearchPageRsp == null || feedCloudRead$StGetSearchPageRsp.searchFeedInfo.isOver.get() > 0) {
            return true;
        }
        return false;
    }

    private void Z1(FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp, boolean z16) {
        Object obj;
        ArrayList<e30.b> b16 = e30.d.b(feedCloudRead$StGetSearchPageRsp.searchFeedInfo.feedList.get());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(hashCode());
        sb5.append("| transForm size:");
        if (b16 != null) {
            obj = Integer.valueOf(b16.size());
        } else {
            obj = "0";
        }
        sb5.append(obj);
        sb5.append(" |isFinish: ");
        sb5.append(z16);
        com.tencent.xaction.log.b.a("QCircleSearchCommonVideoDataViewModel", 1, sb5.toString());
        List<e30.b> Q1 = Q1(b16);
        com.tencent.xaction.log.b.a("QCircleSearchCommonVideoDataViewModel", 1, hashCode() + "| filter ditto size:" + Q1.size());
        w20.a.j().initOrUpdateGlobalState((List) Q1, true);
        b2(UIStateData.obtainSuccess(false).setFinish(z16).setLoadMore(true), true, b16);
    }

    private void b2(final UIStateData<List<e30.b>> uIStateData, final boolean z16, final Collection<e30.b> collection) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.search.business.qcircle.video.common.viewmodel.b
            @Override // java.lang.Runnable
            public final void run() {
                c.this.U1(z16, collection, uIStateData);
            }
        });
    }

    protected boolean O1() {
        int i3;
        if (this.f283077m.getValue() != null) {
            i3 = this.f283077m.getValue().getState();
        } else {
            i3 = 0;
        }
        if (i3 != 1) {
            return false;
        }
        com.tencent.xaction.log.b.a(getLogTag(), 1, hashCode() + "|requestFeed is loading");
        return true;
    }

    List<e30.b> R1() {
        UIStateData<List<e30.b>> value = this.f283077m.getValue();
        if (value == null) {
            return new ArrayList(0);
        }
        return value.getData();
    }

    void a2(UIStateData<List<e30.b>> uIStateData) {
        this.f283077m.postValue(uIStateData);
    }

    public void c2(List<FeedCloudMeta$StFeed> list) {
        if (list != null && !list.isEmpty()) {
            if (this.f283077m.getValue() != null) {
                return;
            }
            this.E.clear();
            for (FeedCloudMeta$StFeed feedCloudMeta$StFeed : list) {
                if (feedCloudMeta$StFeed != null && !TextUtils.isEmpty(feedCloudMeta$StFeed.f398449id.get())) {
                    this.E.add(feedCloudMeta$StFeed.f398449id.get());
                }
            }
            ArrayList<e30.b> b16 = e30.d.b(list);
            UIStateData<List<e30.b>> obtainSuccess = UIStateData.obtainSuccess(true);
            obtainSuccess.setData(false, b16);
            this.f283077m.setValue(obtainSuccess);
            return;
        }
        this.f283077m.setValue(null);
        com.tencent.xaction.log.b.a("QCircleSearchCommonVideoDataViewModel", 2, "#refreshData: empty data");
    }

    protected void d2() {
        if (O1()) {
            return;
        }
        sendRequest(P1(), new a(this));
    }

    public void e2() {
        this.f283077m.setValue(null);
        this.E.clear();
    }

    public void f2(String str) {
        this.D = str;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public MutableLiveData<UIStateData<List<e30.b>>> getDisplaySurfaceData(Object... objArr) {
        return this.f283077m;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QCircleSearchCommonVideoDataViewModel";
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
        d2();
    }
}
