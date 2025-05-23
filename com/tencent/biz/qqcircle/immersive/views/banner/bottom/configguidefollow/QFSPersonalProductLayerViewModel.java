package com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QFSGetProfileFeedsRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSPersonalProductLayerViewModel extends com.tencent.biz.qqcircle.viewmodels.a implements IDataDisplaySurface<e30.b> {
    private String D;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<UIStateData<List<e30.b>>> f90663m = new MutableLiveData<>();
    private final List<e30.b> C = new ArrayList();
    private volatile String E = "";

    private UIStateData.ModifyListRecord O1(List<e30.b> list, List<e30.b> list2) {
        if (list != null && list2 != null) {
            return UIStateData.ModifyListRecord.obtainNotifyItemRangeInsert(list2.size() - list.size(), list.size());
        }
        return UIStateData.ModifyListRecord.obtainNotifyDataSetChanged();
    }

    private boolean Q1() {
        UIStateData<List<e30.b>> value = this.f90663m.getValue();
        if (value != null && value.isLoading()) {
            QLog.e("QFSPersonalProductLayerViewModel", 1, "isLoading:true_" + P1());
            return true;
        }
        return false;
    }

    private void R1() {
        QLog.d("QFSPersonalProductLayerViewModel", 1, "[preLoadData]");
        QFSGetProfileFeedsRequest qFSGetProfileFeedsRequest = new QFSGetProfileFeedsRequest(this.D);
        qFSGetProfileFeedsRequest.setAttachInfo(this.E);
        sendRequest(qFSGetProfileFeedsRequest, new VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetFeedListRsp>() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.QFSPersonalProductLayerViewModel.1
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, final FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
                QLog.e("QFSPersonalProductLayerViewModel", 1, "requestProducts error:" + j3 + "  errorMsg:" + str + "_" + QFSPersonalProductLayerViewModel.this.P1());
                if (!z16 || j3 != 0 || feedCloudRead$StGetFeedListRsp == null) {
                    QFSPersonalProductLayerViewModel.this.T1(str);
                } else {
                    RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.QFSPersonalProductLayerViewModel.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QFSPersonalProductLayerViewModel.this.W1(feedCloudRead$StGetFeedListRsp);
                        }
                    });
                }
            }
        });
    }

    private void S1() {
        QLog.d("QFSPersonalProductLayerViewModel", 1, "[requestData]");
        if (Q1()) {
            return;
        }
        U1();
        R1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T1(String str) {
        this.f90663m.postValue(UIStateData.obtainError(str).setLoadMore(true));
    }

    private void U1() {
        this.f90663m.postValue(UIStateData.obtainLoading().setLoadMore(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W1(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        ArrayList<e30.b> b16 = e30.d.b(feedCloudRead$StGetFeedListRsp.vecFeed.get());
        ArrayList arrayList = new ArrayList(this.C);
        this.C.addAll(b16);
        QLog.d("QFSPersonalProductLayerViewModel", 1, "setSuccessStatus newDataList size:" + b16.size());
        boolean z16 = false;
        UIStateData loadMore = UIStateData.obtainSuccess(false).setLoadMore(true);
        if (feedCloudRead$StGetFeedListRsp.isFinish.get() > 0) {
            z16 = true;
        }
        UIStateData<List<e30.b>> dataList = loadMore.setFinish(z16).setLatestModifyRecord(O1(arrayList, this.C)).setDataList(this.C);
        this.E = feedCloudRead$StGetFeedListRsp.feedAttchInfo.get();
        QLog.d("QFSPersonalProductLayerViewModel", 1, "attachInfo" + this.E + "_" + P1());
        this.f90663m.postValue(dataList);
    }

    public void N1(List<e30.b> list, String str, String str2) {
        String str3;
        if (list == null) {
            QLog.e("QFSPersonalProductLayerViewModel", 1, "[bindData] blockDatas should not be null");
            return;
        }
        this.C.clear();
        this.C.addAll(list);
        if (list.size() > 0) {
            this.f90663m.setValue(UIStateData.obtainSuccess(true).setData(false, list));
        } else {
            this.f90663m.setValue(UIStateData.obtainLoading());
        }
        if (TextUtils.isEmpty(str2)) {
            str3 = "";
        } else {
            str3 = str2;
        }
        this.E = str3;
        this.D = str;
        QLog.d("QFSPersonalProductLayerViewModel", 1, "bindData uin:" + str + " size: " + list.size() + " attachInfo:" + str2 + " getViewModeKey():" + P1());
        R1();
    }

    public String P1() {
        return String.valueOf(hashCode());
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public MutableLiveData<UIStateData<List<e30.b>>> getDisplaySurfaceData(Object... objArr) {
        return this.f90663m;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalProductLayerViewModel";
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
        S1();
    }
}
