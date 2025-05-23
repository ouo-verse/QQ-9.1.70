package com.qzone.reborn.qzmoment.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.qzmoment.request.QZMMessageListRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qzonemoment.QZMomentMeta$StNotice;
import qzonemoment.QZMomentReader$StGetNoticeListRsp;

/* compiled from: P */
/* loaded from: classes37.dex */
public class l extends an.b {

    /* renamed from: i, reason: collision with root package name */
    protected LoadInfo f59110i = new LoadInfo();

    /* renamed from: m, reason: collision with root package name */
    protected final List<bn.g> f59111m = new ArrayList();
    protected final MutableLiveData<UIStateData<List<bn.g>>> C = new MutableLiveData<>();

    private void P1(boolean z16, long j3, String str, QZMomentReader$StGetNoticeListRsp qZMomentReader$StGetNoticeListRsp, boolean z17) {
        UIStateData.ModifyListRecord obtainNotifyDataSetChanged;
        this.f59110i.setCurrentState(4);
        if (z16 && qZMomentReader$StGetNoticeListRsp != null && j3 == 0) {
            QLog.d(getTAG(), 1, "[handleNoticeListResponse]  | attachInfo: " + qZMomentReader$StGetNoticeListRsp.feedAttchInfo.get() + " | isFinish: " + qZMomentReader$StGetNoticeListRsp.isFinish.get() + " | rsp.vecFeed: " + qZMomentReader$StGetNoticeListRsp.vecNotice.get().size());
            this.f59110i.setStringAttachInfo(qZMomentReader$StGetNoticeListRsp.feedAttchInfo.get());
            if (!z17) {
                this.f59111m.clear();
            }
            int size = this.f59111m.size();
            ArrayList arrayList = new ArrayList();
            Iterator<QZMomentMeta$StNotice> it = qZMomentReader$StGetNoticeListRsp.vecNotice.get().iterator();
            while (it.hasNext()) {
                arrayList.add(new bn.g(it.next()));
            }
            this.f59111m.addAll(arrayList);
            if (bl.b(this.f59111m)) {
                this.C.postValue(UIStateData.obtainEmpty().setRetCode(j3).setLoadMore(z17));
                return;
            }
            if (z17) {
                obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyItemRangeInsert(size, arrayList.size());
            } else {
                obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyDataSetChanged();
            }
            this.C.postValue(UIStateData.obtainSuccess(false).setData(z17, this.f59111m).setLatestModifyRecord(obtainNotifyDataSetChanged).setFinish(qZMomentReader$StGetNoticeListRsp.isFinish.get() > 0));
            return;
        }
        QLog.e(getTAG(), 1, "handleNoticeListResponse rsp error  isSuccess = " + z16 + " retCode = " + j3 + " errMsg = " + str + " rsp = " + qZMomentReader$StGetNoticeListRsp);
        this.C.postValue(UIStateData.obtainError(str).setRetCode(j3).setLoadMore(z17));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q1(boolean z16, BaseRequest baseRequest, boolean z17, long j3, String str, QZMomentReader$StGetNoticeListRsp qZMomentReader$StGetNoticeListRsp) {
        M1("[requestMessageList]", z17, baseRequest, j3, str, z16);
        P1(z17, j3, str, qZMomentReader$StGetNoticeListRsp, z16);
    }

    public MutableLiveData<UIStateData<List<bn.g>>> O1() {
        return this.C;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZMMessageListViewModel";
    }

    public void refresh() {
        R1(false, false);
    }

    public void R1(final boolean z16, boolean z17) {
        if (!z16) {
            this.f59110i = new LoadInfo();
        }
        QZMMessageListRequest qZMMessageListRequest = new QZMMessageListRequest(z16 ? this.f59110i.getStringAttachInfo() : null);
        qZMMessageListRequest.setEnableCache(z17);
        QLog.d(getTAG(), 1, "requestMessageList  | attachInfo : " + this.f59110i.getStringAttachInfo() + " | isLoadMore : " + z16);
        sendRequest(qZMMessageListRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.qzone.reborn.qzmoment.viewmodel.k
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z18, long j3, String str, Object obj) {
                l.this.Q1(z16, baseRequest, z18, j3, str, (QZMomentReader$StGetNoticeListRsp) obj);
            }
        });
    }

    public void init() {
        R1(false, true);
    }

    public void loadMore() {
        R1(true, false);
    }
}
