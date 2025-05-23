package com.tencent.biz.qqcircle.viewmodels;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetFeedListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.IQCircleReportSessionOperation;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto$StItemInfo;

/* loaded from: classes5.dex */
public class QFSMixFeedTalentPeopleViewModel extends com.tencent.biz.qqcircle.viewmodels.a implements IQCircleReportSessionOperation, IDataDisplaySurface<e30.b> {
    private String C;
    private String D;
    private String E;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<UIStateData<List<e30.b>>> f92817m = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetFeedListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QFSGetFeedListRequest f92825a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f92826b;

        a(QFSGetFeedListRequest qFSGetFeedListRequest, boolean z16) {
            this.f92825a = qFSGetFeedListRequest;
            this.f92826b = z16;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
            int i3;
            boolean isProtocolCache = VSNetworkHelper.isProtocolCache(str);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(hashCode());
            sb5.append("|requestFeedsData onReceive: dispatch Success:");
            sb5.append(z16);
            sb5.append(" | TraceId:");
            sb5.append(this.f92825a.getTraceId());
            sb5.append(" | SeqId:");
            sb5.append(this.f92825a.getCurrentSeq());
            sb5.append(" | retCode:");
            sb5.append(j3);
            sb5.append(" | retMessage:");
            sb5.append(str);
            sb5.append(" | isCache:");
            sb5.append(isProtocolCache);
            sb5.append(" | size:");
            if (feedCloudRead$StGetFeedListRsp != null) {
                i3 = feedCloudRead$StGetFeedListRsp.vecFeed.size();
            } else {
                i3 = 0;
            }
            sb5.append(i3);
            QLog.d("QFSMixFeedTalentPeopleViewModel", 1, sb5.toString());
            if (z16 && j3 == 0) {
                QFSMixFeedTalentPeopleViewModel.this.U1(isProtocolCache, feedCloudRead$StGetFeedListRsp, this.f92826b);
                return;
            }
            QFSMixFeedTalentPeopleViewModel.this.a2(UIStateData.obtainError(str).setRetCode(j3));
            if (QCirclePluginUtil.isRequestSecurityHit(j3)) {
                BaseRequest.reMoveCache(this.f92825a);
            }
        }
    }

    private boolean Q1() {
        int i3;
        if (this.f92817m.getValue() != null) {
            i3 = this.f92817m.getValue().getState();
        } else {
            i3 = 0;
        }
        if (i3 != 1) {
            return false;
        }
        return true;
    }

    private List<e30.b> R1(List<e30.b> list) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void U1(final boolean z16, final FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, final boolean z17) {
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.viewmodels.QFSMixFeedTalentPeopleViewModel.3
            @Override // java.lang.Runnable
            public void run() {
                QFSMixFeedTalentPeopleViewModel.this.W1(feedCloudRead$StGetFeedListRsp);
                QFSMixFeedTalentPeopleViewModel.this.Z1(feedCloudRead$StGetFeedListRsp, z17, z16, QFSMixFeedTalentPeopleViewModel.this.X1(feedCloudRead$StGetFeedListRsp));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W1(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        if (feedCloudRead$StGetFeedListRsp == null) {
            return;
        }
        this.E = feedCloudRead$StGetFeedListRsp.feedAttchInfo.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean X1(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        if (feedCloudRead$StGetFeedListRsp == null || feedCloudRead$StGetFeedListRsp.isFinish.get() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z1(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, boolean z16, boolean z17, boolean z18) {
        Object obj;
        ArrayList<e30.b> b16 = e30.d.b(feedCloudRead$StGetFeedListRsp.vecFeed.get());
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
        sb5.append(z18);
        sb5.append(" |isLoadMore: ");
        sb5.append(z16);
        QLog.d("QFSMixFeedTalentPeopleViewModel", 1, sb5.toString());
        List<e30.b> R1 = R1(b16);
        QLog.d("QFSMixFeedTalentPeopleViewModel", 1, hashCode() + "| filter ditto size:" + R1.size());
        w20.a.j().initOrUpdateGlobalState((List) R1, true);
        b2(UIStateData.obtainSuccess(z17).setFinish(z18), z16, b16);
    }

    private void c2(boolean z16, boolean z17, String str, String str2) {
        if (Q1()) {
            return;
        }
        QFSGetFeedListRequest.b i3 = new QFSGetFeedListRequest.b(str2).i(str);
        String str3 = "";
        if (z17 && !TextUtils.isEmpty(this.E)) {
            str3 = this.E;
        }
        QFSGetFeedListRequest b16 = i3.f(str3).b();
        b16.setEnableCache(z16);
        b2(UIStateData.obtainLoading(), true, null);
        sendRequest(b16, new a(b16, z17));
    }

    public void S1(String str, String str2) {
        this.C = str;
        this.D = str2;
    }

    public String T1(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        if (qQCircleDitto$StItemInfo != null) {
            return hashCode() + qQCircleDitto$StItemInfo.f429300id.get();
        }
        return "";
    }

    protected void a2(final UIStateData<List<e30.b>> uIStateData) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.viewmodels.QFSMixFeedTalentPeopleViewModel.2
            @Override // java.lang.Runnable
            public void run() {
                QFSMixFeedTalentPeopleViewModel.this.f92817m.setValue(uIStateData);
            }
        });
    }

    protected void b2(final UIStateData<List<e30.b>> uIStateData, final boolean z16, final List<e30.b> list) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.viewmodels.QFSMixFeedTalentPeopleViewModel.4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (QFSMixFeedTalentPeopleViewModel.this.f92817m.getValue() != 0) {
                    List list2 = (List) ((UIStateData) QFSMixFeedTalentPeopleViewModel.this.f92817m.getValue()).getData();
                    ArrayList arrayList = new ArrayList();
                    if (z16 && list2 != null && list2.size() > 0) {
                        arrayList.addAll(list2);
                    }
                    List list3 = list;
                    if (list3 != null && list3.size() > 0) {
                        arrayList.addAll(list);
                    }
                    uIStateData.setDataList(arrayList);
                    if (list != null && arrayList.size() == 0) {
                        uIStateData.setState(0);
                    }
                }
                QFSMixFeedTalentPeopleViewModel.this.f92817m.setValue(uIStateData);
            }
        });
    }

    public void d2() {
        c2(true, false, this.C, this.D);
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public MutableLiveData<UIStateData<List<e30.b>>> getDisplaySurfaceData(Object... objArr) {
        return this.f92817m;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSMixFeedTalentPeopleViewModel";
    }

    @Override // cooperation.qqcircle.report.IQCircleReportSessionOperation
    public FeedCloudCommon$StCommonExt getSession(boolean z16) {
        return null;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
        c2(false, true, this.C, this.D);
    }

    @Override // cooperation.qqcircle.report.IQCircleReportSessionOperation
    public void updateSession(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
    }
}
