package com.tencent.biz.qqcircle.viewmodels;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest;
import com.tencent.biz.qqcircle.requests.QFSSubTabFeedListRequester;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.IQCircleReportSessionOperation;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StDittoFeed;
import feedcloud.FeedCloudRead$StGetFeedListReq;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;
import qqcircle.QQCircleDitto$StPicTextBanner;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase$StSubTabInfo;
import t30.f;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSMixFeedViewModel extends t30.a implements IQCircleReportSessionOperation, IDataDisplaySurface<e30.b> {
    private static final HashMap<String, Long> J = new HashMap<>();
    private QQCircleFeedBase$StSubTabInfo D;
    private QCircleTabInfo E;
    private QQCircleDitto$StPicTextBanner F;
    protected String G;
    private boolean H;
    private f.a I;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetFeedListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QCircleTabGetFeedListRequest f92835a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f92836b;

        a(QCircleTabGetFeedListRequest qCircleTabGetFeedListRequest, boolean z16) {
            this.f92835a = qCircleTabGetFeedListRequest;
            this.f92836b = z16;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
            int i3;
            boolean isProtocolCache = VSNetworkHelper.isProtocolCache(str);
            String tag = QFSMixFeedViewModel.this.getTAG();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(hashCode());
            sb5.append("|requestFeedsData onReceive: dispatch Success:");
            sb5.append(z16);
            sb5.append(" | TraceId:");
            sb5.append(this.f92835a.getTraceId());
            sb5.append(" | SeqId:");
            sb5.append(this.f92835a.getCurrentSeq());
            sb5.append(" | retCode:");
            sb5.append(j3);
            sb5.append(" | retMessage:");
            sb5.append(str);
            sb5.append(" | isLoadMore:");
            sb5.append(this.f92836b);
            sb5.append(" | isCache:");
            sb5.append(isProtocolCache);
            sb5.append(" | size:");
            if (feedCloudRead$StGetFeedListRsp != null) {
                i3 = feedCloudRead$StGetFeedListRsp.vecFeed.size();
            } else {
                i3 = 0;
            }
            sb5.append(i3);
            sb5.append(" | tabName:");
            sb5.append(QFSMixFeedViewModel.this.l2());
            QLog.d(tag, 1, sb5.toString());
            if (z16 && j3 == 0) {
                QFSMixFeedViewModel.this.m2(isProtocolCache, feedCloudRead$StGetFeedListRsp, this.f92836b);
                QFSMixFeedViewModel.this.x2(isProtocolCache);
            } else {
                QFSMixFeedViewModel.this.u2(UIStateData.obtainError(str).setRetCode(j3).setData(this.f92836b, QFSMixFeedViewModel.this.j2()).setLoadMore(this.f92836b));
                if (QCirclePluginUtil.isRequestSecurityHit(j3)) {
                    BaseRequest.reMoveCache(this.f92835a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b extends QCircleTabGetFeedListRequest.b {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest.b
        public FeedCloudRead$StGetFeedListReq g() {
            FeedCloudRead$StGetFeedListReq g16 = super.g();
            g16.subSource.set(QFSMixFeedViewModel.this.D.sourceType.get());
            return g16;
        }
    }

    private List<e30.b> g2(List<e30.b> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            for (e30.b bVar : list) {
                if (!TextUtils.isEmpty(bVar.g().f398449id.get())) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    private QCircleTabGetFeedListRequest.b i2(boolean z16) {
        QCircleTabGetFeedListRequest.b p16 = new b().o(this.D.sourceType.get()).p(this.E);
        String str = "";
        if (z16 && !TextUtils.isEmpty(this.G)) {
            str = this.G;
        }
        QCircleTabGetFeedListRequest.b h16 = p16.h(str);
        if (uq3.o.i()) {
            if (this.D.sourceType.get() == 1) {
                h16.j(com.tencent.biz.qqcircle.c.e().d());
            }
        } else {
            h16.j(com.tencent.biz.qqcircle.c.e().d());
        }
        return h16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<e30.b> j2() {
        UIStateData<List<e30.b>> value = this.f435354m.getValue();
        if (value == null) {
            return new ArrayList();
        }
        return value.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l2() {
        QQCircleFeedBase$StSubTabInfo qQCircleFeedBase$StSubTabInfo = this.D;
        if (qQCircleFeedBase$StSubTabInfo != null) {
            return qQCircleFeedBase$StSubTabInfo.tabName.get();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m2(final boolean z16, final FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, final boolean z17) {
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.viewmodels.QFSMixFeedViewModel.3
            @Override // java.lang.Runnable
            public void run() {
                QFSMixFeedViewModel.this.p2(feedCloudRead$StGetFeedListRsp);
                boolean q26 = QFSMixFeedViewModel.this.q2(feedCloudRead$StGetFeedListRsp);
                QFSMixFeedViewModel.this.s2(feedCloudRead$StGetFeedListRsp);
                QFSMixFeedViewModel.this.t2(feedCloudRead$StGetFeedListRsp, z17, z16, q26);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n2(List<e30.b> list, boolean z16) {
        int i3 = 0;
        if (!z16) {
            this.H = false;
        }
        if (this.H) {
            return;
        }
        while (i3 < list.size() - 1) {
            int i16 = i3 + 1;
            e30.b bVar = list.get(i16);
            int i17 = bVar.g().dittoFeed.dittoId.get();
            if (i17 == 52 || i17 == 53) {
                Object b16 = bVar.b(String.valueOf(i17));
                if (b16 instanceof QQCircleDitto$StCircleDittoDataNew) {
                    list.get(i3).o("key_layer_next_guide_text", ((QQCircleDitto$StCircleDittoDataNew) b16).dividingLine.summary.get());
                    this.H = true;
                    return;
                }
            }
            i3 = i16;
        }
    }

    private void o2(List<FeedCloudMeta$StDittoFeed> list) {
        if (list != null && !list.isEmpty()) {
            for (FeedCloudMeta$StDittoFeed feedCloudMeta$StDittoFeed : list) {
                QLog.d(getTAG(), 1, l2() + "| parseBannerInfo, dittoId: " + feedCloudMeta$StDittoFeed.dittoId.get());
                if (feedCloudMeta$StDittoFeed.dittoId.get() == 30) {
                    r2(feedCloudMeta$StDittoFeed);
                }
            }
            return;
        }
        QLog.d(getTAG(), 1, l2() + "| parseBannerInfo, bannerData is null or empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p2(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        if (feedCloudRead$StGetFeedListRsp == null) {
            return;
        }
        this.G = feedCloudRead$StGetFeedListRsp.feedAttchInfo.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q2(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        if (feedCloudRead$StGetFeedListRsp == null || feedCloudRead$StGetFeedListRsp.isFinish.get() > 0) {
            return true;
        }
        return false;
    }

    private void r2(FeedCloudMeta$StDittoFeed feedCloudMeta$StDittoFeed) {
        QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = new QQCircleDitto$StCircleDittoDataNew();
        try {
            qQCircleDitto$StCircleDittoDataNew.mergeFrom(feedCloudMeta$StDittoFeed.dittoDataNew.get().toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        this.F = qQCircleDitto$StCircleDittoDataNew.picTextBanner.get();
        z2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s2(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        if (feedCloudRead$StGetFeedListRsp != null && feedCloudRead$StGetFeedListRsp.busiRspData.has()) {
            QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData = new QQCircleFeedBase$StFeedListBusiRspData();
            try {
                qQCircleFeedBase$StFeedListBusiRspData.mergeFrom(feedCloudRead$StGetFeedListRsp.busiRspData.get().toByteArray());
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            QLog.d(getTAG(), 1, l2() + "| parseRefreshAttachInfo, has bannerData: " + qQCircleFeedBase$StFeedListBusiRspData.bannerData.has());
            if (qQCircleFeedBase$StFeedListBusiRspData.bannerData.has()) {
                o2(qQCircleFeedBase$StFeedListBusiRspData.bannerData.get());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t2(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, boolean z16, boolean z17, boolean z18) {
        Object obj;
        ArrayList<e30.b> b16 = e30.d.b(feedCloudRead$StGetFeedListRsp.vecFeed.get());
        String tag = getTAG();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(l2());
        sb5.append(hashCode());
        sb5.append("| transForm size:");
        if (b16 != null) {
            obj = Integer.valueOf(b16.size());
        } else {
            obj = "0";
        }
        sb5.append(obj);
        sb5.append(" |isFinish: ");
        sb5.append(z18);
        sb5.append(" |isLoadMore: ");
        sb5.append(z16);
        QLog.d(tag, 1, sb5.toString());
        List<e30.b> g26 = g2(b16);
        QLog.d(getTAG(), 1, l2() + hashCode() + "| filter ditto size:" + g26.size());
        w20.a.j().initOrUpdateGlobalState((List) g26, true);
        v2(UIStateData.obtainSuccess(z17).setFinish(z18).setLoadMore(z16), z16, b16);
    }

    private void z2() {
        QQCircleDitto$StPicTextBanner qQCircleDitto$StPicTextBanner = this.F;
        if (qQCircleDitto$StPicTextBanner == null) {
            QLog.w(getTAG(), 1, l2() + "| schemaAppendTabType, mPublishBannerInfo is null ");
            return;
        }
        String str = qQCircleDitto$StPicTextBanner.actionUrl.get();
        if (TextUtils.isEmpty(str)) {
            QLog.w(getTAG(), 1, l2() + "| schemaAppendTabType, jumpUrl is empty ");
            return;
        }
        if (this.E != null && this.D != null) {
            String str2 = str + "&main_tab_source_type=" + this.E.getType() + "&sub_tab_source_type=" + this.D.sourceType.get();
            QLog.d(getTAG(), 1, l2() + "| schemaAppendTabType, schema: " + str2);
            this.F.actionUrl.set(str2);
            return;
        }
        QLog.w(getTAG(), 1, l2() + "| schemaAppendTabType, tabInfo is null ");
    }

    public void A2(f.a aVar) {
        this.I = aVar;
    }

    public void B2(QCircleTabInfo qCircleTabInfo, int i3) {
        this.E = qCircleTabInfo;
        if (qCircleTabInfo.mTab.subTabInfo.size() > i3) {
            this.D = this.E.mTab.subTabInfo.get(i3);
        }
    }

    @Override // t30.b
    public int J() {
        f.a aVar = this.I;
        if (aVar != null) {
            return aVar.a();
        }
        return -1;
    }

    @Override // t30.a
    public int L1() {
        return 1;
    }

    protected boolean e2() {
        int i3;
        if (this.f435354m.getValue() != null) {
            i3 = this.f435354m.getValue().getState();
        } else {
            i3 = 0;
        }
        if (i3 != 1) {
            return false;
        }
        QLog.d(getTAG(), 1, hashCode() + "|requestFeed is loading return:" + l2());
        return true;
    }

    @NotNull
    protected QCircleTabGetFeedListRequest f2(boolean z16) {
        return new QFSSubTabFeedListRequester(i2(z16));
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public MutableLiveData<UIStateData<List<e30.b>>> getDisplaySurfaceData(Object... objArr) {
        return this.f435354m;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        return this.D.sourceType.get();
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSMixFeedViewModel";
    }

    @Override // cooperation.qqcircle.report.IQCircleReportSessionOperation
    public FeedCloudCommon$StCommonExt getSession(boolean z16) {
        return null;
    }

    public void h2() {
        boolean z16;
        Long l3 = J.get(l2());
        if (l3 != null && System.currentTimeMillis() - l3.longValue() < 600000) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d(getTAG(), 1, hashCode() + "| firstInit only cache:" + z16);
        y2(true, false, z16);
    }

    public QQCircleDitto$StPicTextBanner k2() {
        return this.F;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
        y2(false, true, false);
    }

    public void refresh() {
        y2(false, false, false);
    }

    protected void u2(final UIStateData<List<e30.b>> uIStateData) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.viewmodels.QFSMixFeedViewModel.4
            @Override // java.lang.Runnable
            public void run() {
                ((t30.a) QFSMixFeedViewModel.this).f435354m.setValue(uIStateData);
            }
        });
    }

    protected void v2(final UIStateData<List<e30.b>> uIStateData, final boolean z16, final List<e30.b> list) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.viewmodels.QFSMixFeedViewModel.5
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (((t30.a) QFSMixFeedViewModel.this).f435354m.getValue() != 0) {
                    List list2 = (List) ((UIStateData) ((t30.a) QFSMixFeedViewModel.this).f435354m.getValue()).getData();
                    ArrayList arrayList = new ArrayList();
                    if (z16 && list2 != null && list2.size() > 0) {
                        arrayList.addAll(list2);
                    }
                    List list3 = list;
                    if (list3 != null && list3.size() > 0) {
                        arrayList.addAll(list);
                    }
                    QFSMixFeedViewModel.this.n2(arrayList, z16);
                    uIStateData.setDataList(arrayList);
                    if (list != null && arrayList.size() == 0) {
                        uIStateData.setState(0);
                    }
                }
                ((t30.a) QFSMixFeedViewModel.this).f435354m.setValue(uIStateData);
            }
        });
    }

    protected void w2(boolean z16, boolean z17, QCircleTabGetFeedListRequest qCircleTabGetFeedListRequest) {
        if (z16 || !z17) {
            return;
        }
        if (BaseRequest.isCacheExist(qCircleTabGetFeedListRequest)) {
            QLog.d(getTAG(), 1, hashCode() + "|preInitEmptyReturn has Cache");
            return;
        }
        v2(UIStateData.obtainModify().setData(false, new ArrayList()), false, null);
    }

    protected void x2(boolean z16) {
        if (z16) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        J.put(l2(), Long.valueOf(currentTimeMillis));
        QLog.d(getTAG(), 1, l2() + "|" + currentTimeMillis);
    }

    protected void y2(boolean z16, boolean z17, boolean z18) {
        if (e2()) {
            return;
        }
        QCircleTabGetFeedListRequest f26 = f2(z17);
        f26.setEnableCache(z16);
        v2(UIStateData.obtainLoading(), true, null);
        w2(z17, z16, f26);
        sendRequest(f26, new a(f26, z17));
    }

    @Override // cooperation.qqcircle.report.IQCircleReportSessionOperation
    public void updateSession(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
    }
}
