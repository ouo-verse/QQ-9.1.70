package com.qzone.reborn.qzmoment.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.qzmoment.comment.QZMFeedCommentInfo;
import com.qzone.reborn.qzmoment.comment.event.QZMFeedListDataEvent;
import com.qzone.reborn.qzmoment.event.QZMNotifyDeleteFeedEvent;
import com.qzone.reborn.qzmoment.request.QZMBaseRequest;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qzonemoment.QZMomentMeta$StFeed;
import qzonemoment.QZMomentReader$StGetFeedListRsp;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class c extends an.b implements SimpleEventReceiver {

    /* renamed from: i, reason: collision with root package name */
    protected LoadInfo f59094i = new LoadInfo();

    /* renamed from: m, reason: collision with root package name */
    protected final List<bn.b> f59095m = new ArrayList();
    protected final MutableLiveData<UIStateData<List<bn.b>>> C = new MutableLiveData<>();

    public c() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private boolean P1() {
        if (!PreLoader.exists(W1())) {
            return false;
        }
        QLog.d(getTAG(), 1, "requestGetFriendFeedList from preload task");
        Q1();
        return true;
    }

    private void Q1() {
        PreLoader.addListener(W1(), new OnTaskListener() { // from class: com.qzone.reborn.qzmoment.viewmodel.b
            @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
            public final void onComplete(Object[] objArr) {
                c.this.b2(objArr);
            }
        });
    }

    private String R1(List<QZMomentMeta$StFeed> list) {
        StringBuilder sb5 = new StringBuilder();
        if (bl.b(list)) {
            return sb5.toString();
        }
        Iterator<QZMomentMeta$StFeed> it = list.iterator();
        while (it.hasNext()) {
            sb5.append(it.next().f430362id.get());
            sb5.append(",");
        }
        return sb5.toString();
    }

    private void X1(QZMNotifyDeleteFeedEvent qZMNotifyDeleteFeedEvent) {
        boolean z16;
        if (qZMNotifyDeleteFeedEvent.getFeed() == null || this.f59095m.size() == 0) {
            return;
        }
        Iterator<bn.b> it = this.f59095m.iterator();
        while (true) {
            if (!it.hasNext()) {
                z16 = false;
                break;
            }
            bn.b next = it.next();
            if (next != null && TextUtils.equals(next.a().f430362id.get(), qZMNotifyDeleteFeedEvent.getFeed().f430362id.get())) {
                it.remove();
                z16 = true;
                QLog.d(getTAG(), 1, "handleDeleteFeedEvent  | feedId = " + qZMNotifyDeleteFeedEvent.getFeed().f430362id.get() + " | mAllFeeds.size = " + this.f59095m.size());
                break;
            }
        }
        if (z16) {
            this.C.postValue(UIStateData.obtainDelete().setData(false, this.f59095m).setFinish(this.f59094i.isFinish()));
        }
    }

    private void Z1(boolean z16, long j3, String str, QZMomentReader$StGetFeedListRsp qZMomentReader$StGetFeedListRsp, boolean z17) {
        UIStateData.ModifyListRecord obtainNotifyDataSetChanged;
        this.f59094i.setCurrentState(4);
        if (z16 && qZMomentReader$StGetFeedListRsp != null && j3 == 0) {
            this.f59094i.setStringAttachInfo(qZMomentReader$StGetFeedListRsp.feedAttchInfo.get());
            if (!z17) {
                this.f59095m.clear();
            }
            int size = this.f59095m.size();
            ArrayList arrayList = new ArrayList();
            Iterator<QZMomentMeta$StFeed> it = qZMomentReader$StGetFeedListRsp.vecFeed.get().iterator();
            while (it.hasNext()) {
                arrayList.add(new bn.b(it.next()));
            }
            this.f59095m.addAll(arrayList);
            QLog.d(getTAG(), 1, "[handleFeedListResponse]  | attachInfo: " + qZMomentReader$StGetFeedListRsp.feedAttchInfo.get() + " | isFinish: " + qZMomentReader$StGetFeedListRsp.isFinish.get() + " | rsp.vecFeed.size: " + qZMomentReader$StGetFeedListRsp.vecFeed.get().size() + " | mAllFeeds.size: " + this.f59095m.size() + " | newFeedIdList = " + R1(qZMomentReader$StGetFeedListRsp.vecFeed.get()));
            if (bl.b(this.f59095m)) {
                this.C.postValue(UIStateData.obtainEmpty().setRetCode(j3).setLoadMore(z17));
                return;
            }
            if (z17) {
                obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyItemRangeInsert(size, arrayList.size());
            } else {
                obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyDataSetChanged();
            }
            boolean z18 = qZMomentReader$StGetFeedListRsp.isFinish.get() > 0;
            this.C.postValue(UIStateData.obtainSuccess(VSNetworkHelper.isProtocolCache(str)).setData(z17, this.f59095m).setLatestModifyRecord(obtainNotifyDataSetChanged).setFinish(z18));
            this.f59094i.setFinish(z18);
            a2(arrayList);
            SimpleEventBus.getInstance().dispatchEvent(new QZMFeedListDataEvent(this.f59095m, U1()));
            return;
        }
        QLog.e(getTAG(), 1, "handleFeedListResponse rsp error  isSuccess = " + z16 + " retCode = " + j3 + " errMsg = " + str + " rsp = " + qZMomentReader$StGetFeedListRsp);
        this.C.postValue(UIStateData.obtainError(str).setRetCode(j3).setLoadMore(z17));
    }

    private void a2(List<bn.b> list) {
        if (bl.b(list)) {
            return;
        }
        for (bn.b bVar : list) {
            en.a.a().initOrUpdateGlobalState((en.a) new QZMFeedCommentInfo(bVar.a(), bVar.a().commentCount.get()), true);
            en.a.a().initOrUpdateGlobalState((en.a) new bn.c(bVar.a().f430362id.get(), bVar.a()), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c2(boolean z16, BaseRequest baseRequest, boolean z17, long j3, String str, QZMomentReader$StGetFeedListRsp qZMomentReader$StGetFeedListRsp) {
        M1("[requestGetFeedList]", z17, baseRequest, j3, str, z16);
        Z1(z17, j3, str, qZMomentReader$StGetFeedListRsp, z16);
    }

    private void e2() {
        LoadInfo loadInfo = new LoadInfo();
        this.f59094i = loadInfo;
        loadInfo.setStringAttachInfo(null);
        this.f59094i.setFinish(false);
    }

    protected abstract QZMBaseRequest S1();

    public MutableLiveData<UIStateData<List<bn.b>>> T1() {
        return this.C;
    }

    protected abstract String U1();

    protected abstract String W1();

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZMNotifyDeleteFeedEvent.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZMNotifyDeleteFeedEvent) {
            X1((QZMNotifyDeleteFeedEvent) simpleBaseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b2(Object[] objArr) {
        if (objArr == null || objArr.length != 4) {
            return;
        }
        QLog.d(getTAG(), 1, "fetchNewDataFromPreload requestTabData onReceive: dispatch Success:" + objArr[0] + " | retCode:" + objArr[1] + " | retMessage:" + objArr[2]);
        Z1(((Boolean) objArr[0]).booleanValue(), ((Long) objArr[1]).longValue(), (String) objArr[2], (QZMomentReader$StGetFeedListRsp) objArr[3], false);
    }

    public void d2(final boolean z16) {
        if (!z16) {
            e2();
        }
        if (z16 || !P1()) {
            QZMBaseRequest S1 = S1();
            QLog.d(getTAG(), 1, "requestGetFriendFeedList  | attachInfo : " + this.f59094i.getStringAttachInfo() + " | isLoadMore : " + z16);
            sendRequest(S1, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.qzone.reborn.qzmoment.viewmodel.a
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str, Object obj) {
                    c.this.c2(z16, baseRequest, z17, j3, str, (QZMomentReader$StGetFeedListRsp) obj);
                }
            });
        }
    }
}
