package com.tencent.biz.qqcircle.immersive.viewmodel.pymk;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetFeedListRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.thread.RFWThreadManager;
import e30.b;
import e30.d;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSListPYMKProductViewModel extends com.tencent.biz.qqcircle.viewmodels.a implements IDataDisplaySurface<b> {
    private String D;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<UIStateData<List<b>>> f90265m = new MutableLiveData<>();
    private final List<b> C = new ArrayList();
    private volatile String E = "";

    private UIStateData.ModifyListRecord O1(List<b> list, List<b> list2) {
        if (list != null && list2 != null) {
            return UIStateData.ModifyListRecord.obtainNotifyItemRangeInsert(list2.size() - list.size(), list.size());
        }
        return UIStateData.ModifyListRecord.obtainNotifyDataSetChanged();
    }

    private boolean Q1() {
        UIStateData<List<b>> value = this.f90265m.getValue();
        if (value != null && value.isLoading()) {
            QLog.e("QFSListPYMKProductViewModel", 1, "isLoading:true_" + P1());
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R1(String str) {
        this.f90265m.postValue(UIStateData.obtainError(str).setLoadMore(true));
    }

    private void S1() {
        this.f90265m.postValue(UIStateData.obtainLoading().setLoadMore(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T1(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        ArrayList<b> b16 = d.b(feedCloudRead$StGetFeedListRsp.vecFeed.get());
        ArrayList arrayList = new ArrayList(this.C);
        this.C.addAll(b16);
        QLog.d("QFSListPYMKProductViewModel", 1, "setSuccessStatus newDataList size:" + b16.size());
        boolean z16 = false;
        UIStateData loadMore = UIStateData.obtainSuccess(false).setLoadMore(true);
        if (feedCloudRead$StGetFeedListRsp.isFinish.get() > 0) {
            z16 = true;
        }
        UIStateData<List<b>> dataList = loadMore.setFinish(z16).setLatestModifyRecord(O1(arrayList, this.C)).setDataList(this.C);
        this.E = feedCloudRead$StGetFeedListRsp.feedAttchInfo.get();
        QLog.d("QFSListPYMKProductViewModel", 1, "attachInfo" + this.E + "_" + P1());
        this.f90265m.postValue(dataList);
    }

    public void N1(List<b> list, String str, String str2) {
        String str3;
        if (list == null) {
            return;
        }
        this.C.clear();
        this.C.addAll(list);
        this.f90265m.setValue(UIStateData.obtainSuccess(true).setData(false, list));
        if (TextUtils.isEmpty(str2)) {
            str3 = "";
        } else {
            str3 = str2;
        }
        this.E = str3;
        this.D = str;
        QLog.d("QFSListPYMKProductViewModel", 1, "bindData" + str + " size" + list.size() + " attachInfo:" + str2 + "_" + P1());
    }

    public String P1() {
        return String.valueOf(hashCode());
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public MutableLiveData<UIStateData<List<b>>> getDisplaySurfaceData(Object... objArr) {
        return this.f90265m;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSListPYMKProductViewModel";
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
        if (Q1()) {
            return;
        }
        S1();
        sendRequest(new QFSGetFeedListRequest.b(this.D).f(this.E).k(8).a(), new VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetFeedListRsp>() { // from class: com.tencent.biz.qqcircle.immersive.viewmodel.pymk.QFSListPYMKProductViewModel.1
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, final FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
                QLog.e("QFSListPYMKProductViewModel", 1, "requestFuelTips error:" + j3 + "  errorMsg:" + str + "_" + QFSListPYMKProductViewModel.this.P1());
                if (!z16 || j3 != 0 || feedCloudRead$StGetFeedListRsp == null) {
                    QFSListPYMKProductViewModel.this.R1(str);
                } else {
                    RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.viewmodel.pymk.QFSListPYMKProductViewModel.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QFSListPYMKProductViewModel.this.T1(feedCloudRead$StGetFeedListRsp);
                        }
                    });
                }
            }
        });
    }
}
