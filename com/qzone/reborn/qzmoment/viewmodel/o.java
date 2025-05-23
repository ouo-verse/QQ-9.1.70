package com.qzone.reborn.qzmoment.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.qzmoment.request.QZMGetPraiseListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qzonemoment.QZMomentMeta$StFeed;
import qzonemoment.QZMomentMeta$StLightInteractInfo;
import qzonemoment.QZMomentReader$StGetLightInteractListRsp;

/* compiled from: P */
/* loaded from: classes37.dex */
public class o extends an.b {

    /* renamed from: i, reason: collision with root package name */
    private LoadInfo f59114i = new LoadInfo();

    /* renamed from: m, reason: collision with root package name */
    private final List<bn.f> f59115m = new ArrayList();
    private MutableLiveData<Integer> C = new MutableLiveData<>();
    private final MutableLiveData<UIStateData<List<bn.f>>> D = new MutableLiveData<>();

    private void Q1(boolean z16, long j3, String str, QZMomentReader$StGetLightInteractListRsp qZMomentReader$StGetLightInteractListRsp, boolean z17) {
        UIStateData.ModifyListRecord obtainNotifyDataSetChanged;
        this.f59114i.setCurrentState(4);
        if (z16 && qZMomentReader$StGetLightInteractListRsp != null && j3 == 0) {
            QLog.d(getTAG(), 1, "[handleInterestListResponse]  | attachInfo: " + qZMomentReader$StGetLightInteractListRsp.attachInfo.get() + " | isFinish: " + qZMomentReader$StGetLightInteractListRsp.isFinish.get() + " | rsp.vecFeed: " + qZMomentReader$StGetLightInteractListRsp.listInfo.get().size());
            this.f59114i.setStringAttachInfo(qZMomentReader$StGetLightInteractListRsp.attachInfo.get());
            if (!z17) {
                this.f59115m.clear();
            }
            int size = this.f59115m.size();
            ArrayList arrayList = new ArrayList();
            Iterator<QZMomentMeta$StLightInteractInfo> it = qZMomentReader$StGetLightInteractListRsp.listInfo.get().iterator();
            while (it.hasNext()) {
                arrayList.add(new bn.f(it.next()));
            }
            this.f59115m.addAll(arrayList);
            if (bl.b(this.f59115m)) {
                this.D.postValue(UIStateData.obtainEmpty().setRetCode(j3).setLoadMore(z17));
                return;
            }
            if (z17) {
                obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyItemRangeInsert(size, arrayList.size());
            } else {
                obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyDataSetChanged();
            }
            this.D.postValue(UIStateData.obtainSuccess(VSNetworkHelper.isProtocolCache(str)).setData(z17, this.f59115m).setLatestModifyRecord(obtainNotifyDataSetChanged).setFinish(qZMomentReader$StGetLightInteractListRsp.isFinish.get() > 0));
            this.C.postValue(Integer.valueOf(qZMomentReader$StGetLightInteractListRsp.totalCount.get()));
            return;
        }
        QLog.e(getTAG(), 1, "handleInterestListResponse rsp error  isSuccess = " + z16 + " retCode = " + j3 + " errMsg = " + str + " rsp = " + qZMomentReader$StGetLightInteractListRsp);
        this.D.postValue(UIStateData.obtainError(str).setRetCode(j3).setLoadMore(z17));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S1(boolean z16, BaseRequest baseRequest, boolean z17, long j3, String str, QZMomentReader$StGetLightInteractListRsp qZMomentReader$StGetLightInteractListRsp) {
        M1("[requestInterestListData]", z17, baseRequest, j3, str, z16);
        Q1(z17, j3, str, qZMomentReader$StGetLightInteractListRsp, z16);
    }

    public MutableLiveData<UIStateData<List<bn.f>>> O1() {
        return this.D;
    }

    public MutableLiveData<Integer> P1() {
        return this.C;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZMPraiseListViewModel";
    }

    public void R1(QZMomentMeta$StFeed qZMomentMeta$StFeed) {
        U1(qZMomentMeta$StFeed, false, true);
    }

    public void T1(QZMomentMeta$StFeed qZMomentMeta$StFeed) {
        U1(qZMomentMeta$StFeed, true, false);
    }

    public void U1(QZMomentMeta$StFeed qZMomentMeta$StFeed, final boolean z16, boolean z17) {
        if (qZMomentMeta$StFeed == null) {
            return;
        }
        if (!z16) {
            this.f59114i = new LoadInfo();
        }
        QZMGetPraiseListRequest qZMGetPraiseListRequest = new QZMGetPraiseListRequest(qZMomentMeta$StFeed, z16 ? this.f59114i.getStringAttachInfo() : null);
        qZMGetPraiseListRequest.setEnableCache(z17);
        QLog.d(getTAG(), 1, "requestInterestListData  | attachInfo : " + this.f59114i.getStringAttachInfo() + " | isLoadMore : " + z16);
        sendRequest(qZMGetPraiseListRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.qzone.reborn.qzmoment.viewmodel.n
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z18, long j3, String str, Object obj) {
                o.this.S1(z16, baseRequest, z18, j3, str, (QZMomentReader$StGetLightInteractListRsp) obj);
            }
        });
    }
}
