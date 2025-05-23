package com.tencent.biz.qqcircle.immersive.gallery.viewmodel;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.UiThread;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QFSGalleryMainPageBean;
import com.tencent.biz.qqcircle.requests.QFSGalleryMixFeedListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.IQCircleReportSessionOperation;
import cooperation.qqcircle.report.QCircleReporterAgent;
import e30.b;
import e30.d;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StDittoFeed;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function1;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;
import qqcircle.QQCircleDitto$StItemContainer;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSGalleryFeedViewModel extends com.tencent.biz.qqcircle.viewmodels.a implements IQCircleReportSessionOperation, IDataDisplaySurface<b> {
    private QFSGalleryMainPageBean D;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<UIStateData<List<b>>> f86486m = new MutableLiveData<>();
    private final List<b> C = new CopyOnWriteArrayList();
    private String E = null;
    private String F = null;
    protected boolean G = false;
    protected FeedCloudCommon$StCommonExt H = null;
    private final MutableLiveData<QQCircleDitto$StItemContainer> I = new MutableLiveData<>();
    private final List<b> J = new CopyOnWriteArrayList();
    private final MutableLiveData<Object> K = new MutableLiveData<>();

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.immersive.gallery.viewmodel.QFSGalleryFeedViewModel$6, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass6 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f86495d;
        final /* synthetic */ QFSGalleryFeedViewModel this$0;

        @Override // java.lang.Runnable
        public void run() {
            int h26 = this.this$0.h2();
            if (h26 != -1) {
                this.this$0.C.remove(h26);
            }
            b bVar = new b(this.f86495d);
            bVar.o("key_gallery_publish_feed_status", "STATUS_SUCCESS");
            this.this$0.C.add(0, bVar);
            w20.a.j().initOrUpdateGlobalState(this.this$0.C, true);
            this.this$0.f86486m.setValue(UIStateData.obtainSuccess(false).setDataList(this.this$0.C).setFinish(false));
            this.this$0.K.setValue(null);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.immersive.gallery.viewmodel.QFSGalleryFeedViewModel$8, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass8 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1 f86496d;
        final /* synthetic */ QFSGalleryFeedViewModel this$0;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        @RequiresApi(api = 24)
        public void run() {
            UIStateData uIStateData = (UIStateData) this.this$0.f86486m.getValue();
            if (uIStateData == null) {
                return;
            }
            List<b> list = (List) uIStateData.getData();
            ArrayList arrayList = new ArrayList();
            for (b bVar : list) {
                if (!((Boolean) this.f86496d.invoke(bVar)).booleanValue()) {
                    arrayList.add(bVar);
                }
            }
            uIStateData.setDataList(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetFeedListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f86497a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QFSGalleryMixFeedListRequest f86498b;

        a(boolean z16, QFSGalleryMixFeedListRequest qFSGalleryMixFeedListRequest) {
            this.f86497a = z16;
            this.f86498b = qFSGalleryMixFeedListRequest;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
            int i3;
            boolean isProtocolCache = VSNetworkHelper.isProtocolCache(str);
            String tag = QFSGalleryFeedViewModel.this.getTAG();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[requestGalleryFeedList] hashCode:");
            sb5.append(hashCode());
            sb5.append(" | Success:");
            sb5.append(z16);
            sb5.append(" | retCode:");
            sb5.append(j3);
            sb5.append(" | retMessage:");
            sb5.append(str);
            sb5.append(" | isLoadMore:");
            sb5.append(this.f86497a);
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
            sb5.append(QFSGalleryFeedViewModel.this.i2());
            QLog.d(tag, 1, sb5.toString());
            if (z16 && j3 == 0) {
                QFSGalleryFeedViewModel.this.j2(isProtocolCache, feedCloudRead$StGetFeedListRsp, this.f86497a);
                return;
            }
            QFSGalleryFeedViewModel.this.s2(UIStateData.obtainError(str).setRetCode(j3).setData(this.f86497a, QFSGalleryFeedViewModel.this.g2()).setLoadMore(this.f86497a));
            if (QCirclePluginUtil.isRequestSecurityHit(j3)) {
                BaseRequest.reMoveCache(this.f86498b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c2(List<b> list) {
        this.C.addAll(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e2() {
        this.C.clear();
    }

    private List<b> f2(List<b> list, boolean z16) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            if (!z16) {
                this.J.clear();
            }
            for (b bVar : list) {
                if (bVar != null && bVar.g() != null) {
                    if (k2(bVar.g())) {
                        this.J.add(bVar);
                        l2(bVar.g());
                    } else {
                        arrayList.add(bVar);
                    }
                } else {
                    QLog.e(getTAG(), 1, "[filterDittoFeed] feed is null");
                }
            }
            return arrayList;
        }
        QLog.e(getTAG(), 1, "[filterDittoFeed] validBlockDataList == null or empty");
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<b> g2() {
        UIStateData<List<b>> value = this.f86486m.getValue();
        if (value == null) {
            return new ArrayList();
        }
        return value.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h2() {
        if (this.C.size() == 0) {
            return -1;
        }
        for (int i3 = 0; i3 < this.C.size(); i3++) {
            if (this.C.get(i3).b("key_gallery_publish_feed_status") != null) {
                return i3;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i2() {
        QFSGalleryMainPageBean qFSGalleryMainPageBean = this.D;
        if (qFSGalleryMainPageBean == null) {
            return "";
        }
        return qFSGalleryMainPageBean.getTabName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j2(final boolean z16, final FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, final boolean z17) {
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.gallery.viewmodel.QFSGalleryFeedViewModel.2
            @Override // java.lang.Runnable
            public void run() {
                QFSGalleryFeedViewModel.this.n2(feedCloudRead$StGetFeedListRsp);
                QFSGalleryFeedViewModel qFSGalleryFeedViewModel = QFSGalleryFeedViewModel.this;
                qFSGalleryFeedViewModel.G = qFSGalleryFeedViewModel.o2(feedCloudRead$StGetFeedListRsp);
                QFSGalleryFeedViewModel.this.q2(feedCloudRead$StGetFeedListRsp);
                QFSGalleryFeedViewModel.this.m2(feedCloudRead$StGetFeedListRsp);
                QFSGalleryFeedViewModel qFSGalleryFeedViewModel2 = QFSGalleryFeedViewModel.this;
                qFSGalleryFeedViewModel2.r2(feedCloudRead$StGetFeedListRsp, z17, z16, qFSGalleryFeedViewModel2.G);
            }
        });
    }

    private boolean k2(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed.dittoFeed.has() && feedCloudMeta$StFeed.dittoFeed.dittoId.get() != 0) {
            return true;
        }
        return false;
    }

    private void l2(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            QLog.e(getTAG(), 1, "[parseDittoInfo] tabName:" + i2() + ", feed == null");
            return;
        }
        if (feedCloudMeta$StFeed.dittoFeed.dittoId.get() == 39) {
            p2(feedCloudMeta$StFeed.dittoFeed);
            return;
        }
        QLog.d(getTAG(), 1, "[parseDittoInfo] dittoId:" + feedCloudMeta$StFeed.dittoFeed.dittoId.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m2(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        if (feedCloudRead$StGetFeedListRsp != null && feedCloudRead$StGetFeedListRsp.extInfo.has()) {
            this.H = feedCloudRead$StGetFeedListRsp.extInfo.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n2(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        if (feedCloudRead$StGetFeedListRsp == null) {
            return;
        }
        this.E = feedCloudRead$StGetFeedListRsp.feedAttchInfo.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o2(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        if (feedCloudRead$StGetFeedListRsp == null || feedCloudRead$StGetFeedListRsp.isFinish.get() > 0) {
            return true;
        }
        return false;
    }

    private void p2(FeedCloudMeta$StDittoFeed feedCloudMeta$StDittoFeed) {
        QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = new QQCircleDitto$StCircleDittoDataNew();
        try {
            qQCircleDitto$StCircleDittoDataNew.mergeFrom(feedCloudMeta$StDittoFeed.dittoDataNew.get().toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSGalleryFeedViewModel", 1, "[parseRecommendTagFeed] error ", Log.getStackTraceString(e16));
        }
        v2(qQCircleDitto$StCircleDittoDataNew.itemContainter.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q2(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        if (feedCloudRead$StGetFeedListRsp == null) {
            return;
        }
        QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData = new QQCircleFeedBase$StFeedListBusiRspData();
        if (!feedCloudRead$StGetFeedListRsp.busiRspData.has()) {
            QLog.d("QFSGalleryFeedViewModel", 1, "[parseRefreshFeedAttachInfo] rspData is empty");
            return;
        }
        try {
            qQCircleFeedBase$StFeedListBusiRspData.mergeFrom(feedCloudRead$StGetFeedListRsp.busiRspData.get().toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        this.F = qQCircleFeedBase$StFeedListBusiRspData.refreshAttachInfo.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r2(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, boolean z16, boolean z17, boolean z18) {
        Object obj;
        ArrayList<b> b16 = d.b(feedCloudRead$StGetFeedListRsp.vecFeed.get());
        List<b> f26 = f2(b16, z16);
        String tag = getTAG();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[postFeedData] tabName:");
        sb5.append(i2());
        sb5.append(" | hasCode:");
        sb5.append(hashCode());
        sb5.append(" | isFinish:");
        sb5.append(z18);
        sb5.append(" | isLoadMore:");
        sb5.append(z16);
        sb5.append(" | transForm size:");
        if (b16 != null) {
            obj = Integer.valueOf(b16.size());
        } else {
            obj = "0";
        }
        sb5.append(obj);
        sb5.append(" | filter ditto size:");
        sb5.append(f26.size());
        QLog.d(tag, 1, sb5.toString());
        w20.a.j().initOrUpdateGlobalState((List) this.C, true);
        t2(UIStateData.obtainSuccess(z17).setFinish(z18).setLoadMore(z16), z16, f26);
    }

    @UiThread
    private void v2(final QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer) {
        if (qQCircleDitto$StItemContainer == null) {
            return;
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.gallery.viewmodel.QFSGalleryFeedViewModel.3
            @Override // java.lang.Runnable
            public void run() {
                QFSGalleryFeedViewModel.this.I.setValue(qQCircleDitto$StItemContainer);
            }
        });
    }

    protected boolean d2() {
        int i3;
        String scheme;
        if (this.f86486m.getValue() != null) {
            i3 = this.f86486m.getValue().getState();
        } else {
            i3 = 0;
        }
        if (i3 != 1) {
            return false;
        }
        String tag = getTAG();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[canNotSendRequest] hashCode:");
        sb5.append(hashCode());
        sb5.append(" | tabName:");
        QFSGalleryMainPageBean qFSGalleryMainPageBean = this.D;
        if (qFSGalleryMainPageBean == null) {
            scheme = "";
        } else {
            scheme = qFSGalleryMainPageBean.getScheme();
        }
        sb5.append(scheme);
        sb5.append(", requestFeed is loading return:");
        QLog.d(tag, 1, sb5.toString());
        return true;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public MutableLiveData<UIStateData<List<b>>> getDisplaySurfaceData(Object... objArr) {
        return this.f86486m;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        return this.D.getSource();
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSGalleryFeedViewModel";
    }

    @Override // cooperation.qqcircle.report.IQCircleReportSessionOperation
    public FeedCloudCommon$StCommonExt getSession(boolean z16) {
        QCircleReporterAgent qCircleReporterAgent = this.f92839i;
        if (qCircleReporterAgent != null) {
            return qCircleReporterAgent.getSessionCommonExt(z16);
        }
        return new FeedCloudCommon$StCommonExt();
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
        if (!d2() && objArr.length > 0) {
            Object obj = objArr[0];
            if (obj instanceof Context) {
                u2((Context) obj, this.D, true, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
    }

    protected void s2(final UIStateData<List<b>> uIStateData) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.gallery.viewmodel.QFSGalleryFeedViewModel.4
            @Override // java.lang.Runnable
            public void run() {
                QFSGalleryFeedViewModel.this.f86486m.setValue(uIStateData);
            }
        });
    }

    protected void t2(final UIStateData<List<b>> uIStateData, final boolean z16, final List<b> list) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.gallery.viewmodel.QFSGalleryFeedViewModel.5
            @Override // java.lang.Runnable
            public void run() {
                if (!z16) {
                    QFSGalleryFeedViewModel.this.e2();
                }
                QFSGalleryFeedViewModel.this.c2(list);
                uIStateData.setDataList(QFSGalleryFeedViewModel.this.C);
                List list2 = list;
                if (list2 != null && list2.size() == 0) {
                    uIStateData.setState(0);
                }
                QFSGalleryFeedViewModel.this.f86486m.setValue(uIStateData);
            }
        });
    }

    public void u2(Context context, QFSGalleryMainPageBean qFSGalleryMainPageBean, boolean z16, boolean z17) {
        String str;
        if (qFSGalleryMainPageBean == null) {
            QLog.e("QFSGalleryFeedViewModel", 1, "[requestGalleryFeedList] initBean == null");
            return;
        }
        QLog.d("QFSGalleryFeedViewModel", 1, "[requestGalleryFeedList] hashCode:" + hashCode() + " | tabSource:" + qFSGalleryMainPageBean.getSource() + " | isLoadMore:" + z16 + " | enableCache:" + z17);
        if (z16) {
            str = this.E;
        } else {
            str = null;
        }
        QFSGalleryMixFeedListRequest qFSGalleryMixFeedListRequest = new QFSGalleryMixFeedListRequest(qFSGalleryMainPageBean, str, this.F);
        qFSGalleryMixFeedListRequest.setEnableCache(z17);
        qFSGalleryMixFeedListRequest.mRequest.extInfo.set(getSession(!z16));
        this.f86486m.setValue(UIStateData.obtainLoading());
        if (!z16) {
            VSNetworkHelper.getInstance().cancelRequest(context);
        }
        sendRequest(context, qFSGalleryMixFeedListRequest, new a(z16, qFSGalleryMixFeedListRequest));
    }

    @Override // cooperation.qqcircle.report.IQCircleReportSessionOperation
    public void updateSession(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
        QCircleReporterAgent qCircleReporterAgent = this.f92839i;
        if (qCircleReporterAgent != null) {
            qCircleReporterAgent.updateSubSession(feedCloudCommon$StCommonExt);
        }
    }
}
