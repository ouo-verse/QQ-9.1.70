package com.qzone.reborn.qzmoment.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.qzmoment.bean.QZMFeedDetailInitBean;
import com.qzone.reborn.qzmoment.comment.QZMFeedCommentInfo;
import com.qzone.reborn.qzmoment.comment.event.QZMFeedListDataEvent;
import com.qzone.reborn.qzmoment.request.QZMGetFeedDetailRequest;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.List;
import qzonemoment.QZMomentReader$StGetFeedDetailRsp;

/* compiled from: P */
/* loaded from: classes37.dex */
public class i extends an.b implements SimpleEventReceiver {

    /* renamed from: i, reason: collision with root package name */
    private LoadInfo f59106i = new LoadInfo();

    /* renamed from: m, reason: collision with root package name */
    private final List<bn.b> f59107m = new ArrayList();
    private final MutableLiveData<UIStateData<List<bn.b>>> C = new MutableLiveData<>();

    public i() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private void P1(boolean z16, long j3, String str, QZMomentReader$StGetFeedDetailRsp qZMomentReader$StGetFeedDetailRsp, boolean z17) {
        UIStateData.ModifyListRecord obtainNotifyDataSetChanged;
        this.f59106i.setCurrentState(4);
        if (z16 && qZMomentReader$StGetFeedDetailRsp != null && j3 == 0) {
            if (!z17) {
                this.f59107m.clear();
            }
            int size = this.f59107m.size();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new bn.b(qZMomentReader$StGetFeedDetailRsp.feed.get()));
            this.f59107m.addAll(arrayList);
            QLog.d(getTAG(), 1, "[handleFeedDetailResponse]  | rsp.vecFeed.size: " + qZMomentReader$StGetFeedDetailRsp.feed.get() + " | mAllFeeds.size: " + this.f59107m.size());
            if (bl.b(this.f59107m)) {
                this.C.postValue(UIStateData.obtainEmpty().setRetCode(j3).setLoadMore(z17));
                return;
            }
            if (z17) {
                obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyItemRangeInsert(size, arrayList.size());
            } else {
                obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyDataSetChanged();
            }
            this.C.postValue(UIStateData.obtainSuccess(VSNetworkHelper.isProtocolCache(str)).setData(z17, this.f59107m).setLatestModifyRecord(obtainNotifyDataSetChanged).setFinish(true));
            Q1();
            SimpleEventBus.getInstance().dispatchEvent(new QZMFeedListDataEvent(this.f59107m, "page_type_feed_detail_do_like"));
            return;
        }
        QLog.e(getTAG(), 1, "handleFeedDetailResponse rsp error  isSuccess = " + z16 + " retCode = " + j3 + " rsp = " + qZMomentReader$StGetFeedDetailRsp);
        this.C.postValue(UIStateData.obtainError(str).setRetCode(j3).setLoadMore(z17));
    }

    private void Q1() {
        List<bn.b> list = this.f59107m;
        if (list == null || list.isEmpty()) {
            return;
        }
        en.a.a().initOrUpdateGlobalState((en.a) new QZMFeedCommentInfo(this.f59107m.get(0).a(), this.f59107m.get(0).a().commentCount.get()), true);
        en.a.a().initOrUpdateGlobalState((en.a) new bn.c(this.f59107m.get(0).a().f430362id.get(), this.f59107m.get(0).a()), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R1(BaseRequest baseRequest, boolean z16, long j3, String str, QZMomentReader$StGetFeedDetailRsp qZMomentReader$StGetFeedDetailRsp) {
        M1("[requestGetFeedDetail]", z16, baseRequest, j3, str, false);
        P1(z16, j3, str, qZMomentReader$StGetFeedDetailRsp, false);
    }

    public MutableLiveData<UIStateData<List<bn.b>>> O1() {
        return this.C;
    }

    public void S1(QZMFeedDetailInitBean qZMFeedDetailInitBean) {
        QZMGetFeedDetailRequest qZMGetFeedDetailRequest = new QZMGetFeedDetailRequest(qZMFeedDetailInitBean);
        qZMGetFeedDetailRequest.setEnableCache(true);
        this.C.setValue(UIStateData.obtainLoading());
        QLog.d(getTAG(), 1, "requestGetFeedDetail  | attachInfo : " + this.f59106i.getStringAttachInfo() + " | isLoadMore : false");
        sendRequest(qZMGetFeedDetailRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.qzone.reborn.qzmoment.viewmodel.h
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                i.this.R1(baseRequest, z16, j3, str, (QZMomentReader$StGetFeedDetailRsp) obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        return new ArrayList<>();
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZMFeedDetailViewModel";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
    }
}
