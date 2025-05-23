package com.qzone.reborn.qzmoment.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.qzmoment.comment.event.QZMFeedListDataEvent;
import com.qzone.reborn.qzmoment.request.QZMDoLikeRequest;
import com.qzone.util.ToastUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import qzonemoment.QZMomentMeta$StFeed;
import qzonemoment.QZMomentMeta$StLike;
import qzonemoment.QZMomentWriter$StDoLikeRsp;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMFeedDoLikeViewModel extends an.b implements SimpleEventReceiver {

    /* renamed from: i, reason: collision with root package name */
    private String f59083i;

    /* renamed from: m, reason: collision with root package name */
    private final List<bn.b> f59084m = new ArrayList();
    private final Map<String, ArrayList<bn.b>> C = new HashMap();
    public final MutableLiveData<UIStateData<List<bn.b>>> D = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<QZMomentWriter$StDoLikeRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QZMomentMeta$StFeed f59087a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f59088b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QZMomentMeta$StLike f59089c;

        a(QZMomentMeta$StFeed qZMomentMeta$StFeed, int i3, QZMomentMeta$StLike qZMomentMeta$StLike) {
            this.f59087a = qZMomentMeta$StFeed;
            this.f59088b = i3;
            this.f59089c = qZMomentMeta$StLike;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QZMomentWriter$StDoLikeRsp qZMomentWriter$StDoLikeRsp) {
            QLog.d(QZMFeedDoLikeViewModel.this.getLogTag(), 1, "do like ->onReceive: " + z16 + " |feedId:" + this.f59087a.f430362id.get() + " |traceId:" + baseRequest.getTraceId() + " | retCode:" + j3 + " | retMessage:" + str);
            if (!z16 || j3 != 0 || qZMomentWriter$StDoLikeRsp == null) {
                QZMFeedDoLikeViewModel.this.T1(this.f59088b, this.f59087a, this.f59089c);
                QZMFeedDoLikeViewModel.this.a2(HardCodeUtil.qqStr(j3 == 10014 ? R.string.f133305r : R.string.f133315s));
                QLog.e(QZMFeedDoLikeViewModel.this.getLogTag(), 1, "doLike error:" + j3 + "  errorMsg:" + str);
                return;
            }
            QZMFeedDoLikeViewModel.this.U1(this.f59087a, qZMomentWriter$StDoLikeRsp);
        }
    }

    public QZMFeedDoLikeViewModel() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private ArrayList<bn.b> S1() {
        MutableLiveData<UIStateData<List<bn.b>>> mutableLiveData = this.D;
        if (mutableLiveData != null && mutableLiveData.getValue() != null) {
            return (ArrayList) this.D.getValue().getData();
        }
        QLog.e(getLogTag(), 1, "local feeds is null");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U1(final QZMomentMeta$StFeed qZMomentMeta$StFeed, final QZMomentWriter$StDoLikeRsp qZMomentWriter$StDoLikeRsp) {
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.qzone.reborn.qzmoment.viewmodel.QZMFeedDoLikeViewModel.2
            @Override // java.lang.Runnable
            public void run() {
                QZMomentWriter$StDoLikeRsp qZMomentWriter$StDoLikeRsp2 = qZMomentWriter$StDoLikeRsp;
                if (qZMomentWriter$StDoLikeRsp2 == null) {
                    return;
                }
                QZMFeedDoLikeViewModel.this.W1(qZMomentMeta$StFeed, qZMomentWriter$StDoLikeRsp2.like);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void W1(QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StLike qZMomentMeta$StLike) {
        bn.b bVar;
        try {
            MutableLiveData globalData = en.a.a().getGlobalData(bn.b.class, qZMomentMeta$StFeed.f430362id.get());
            if (globalData != null && (bVar = (bn.b) globalData.getValue()) != null && bVar.a() != null) {
                bVar.a().likeInfo.set(qZMomentMeta$StLike);
                globalData.postValue(bVar);
            }
        } catch (Exception e16) {
            QLog.e("QZMFeedDoLikeViewModel", 1, "exception is " + e16);
        }
    }

    private void X1(int i3, int i16, QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StLike qZMomentMeta$StLike) {
        VSNetworkHelper.getInstance().sendRequest(i16, new QZMDoLikeRequest(qZMomentMeta$StFeed, qZMomentMeta$StLike, i3), new a(qZMomentMeta$StFeed, i3, qZMomentMeta$StLike));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a2(String str) {
        if (!NetworkUtil.isNetworkAvailable(MobileQQ.sMobileQQ)) {
            ToastUtil.o(R.string.f1338579, 4);
        } else {
            ToastUtil.s(str, 4);
        }
    }

    private void b2(int i3, QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StLike qZMomentMeta$StLike) {
        ArrayList<bn.b> S1 = S1();
        if (S1 != null && !S1.isEmpty()) {
            int i16 = 0;
            while (true) {
                if (i16 >= S1.size()) {
                    break;
                }
                bn.b bVar = S1.get(i16);
                if (bVar != null && TextUtils.equals(bVar.a().f430362id.get(), qZMomentMeta$StFeed.f430362id.get())) {
                    if (i3 == 1) {
                        PBUInt32Field pBUInt32Field = qZMomentMeta$StLike.count;
                        pBUInt32Field.set(pBUInt32Field.get() + 1);
                        qZMomentMeta$StLike.status.set(1);
                    } else {
                        PBUInt32Field pBUInt32Field2 = qZMomentMeta$StLike.count;
                        pBUInt32Field2.set(pBUInt32Field2.get() - 1);
                        qZMomentMeta$StLike.status.set(0);
                    }
                    bVar.a().likeInfo = qZMomentMeta$StLike;
                    S1.set(i16, bVar);
                } else {
                    i16++;
                }
            }
            this.C.put(qZMomentMeta$StFeed.f430362id.get(), S1);
            en.a.a().initOrUpdateGlobalState((en.a) new bn.c(qZMomentMeta$StFeed.f430362id.get(), qZMomentMeta$StFeed), true);
            return;
        }
        QLog.e(getLogTag(), 1, "like list is null");
    }

    public void Z1(String str) {
        this.f59083i = str;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZMFeedListDataEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QZMFeedDoLikeViewModel";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZMFeedListDataEvent) {
            QZMFeedListDataEvent qZMFeedListDataEvent = (QZMFeedListDataEvent) simpleBaseEvent;
            if (this.f59083i.equals(qZMFeedListDataEvent.getPageType())) {
                this.D.setValue(UIStateData.obtainSuccess(false).setDataList(qZMFeedListDataEvent.getFeedsData()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T1(int i3, QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StLike qZMomentMeta$StLike) {
        if (i3 == 1) {
            b2(0, qZMomentMeta$StFeed, qZMomentMeta$StLike);
        } else {
            b2(1, qZMomentMeta$StFeed, qZMomentMeta$StLike);
        }
    }

    public void R1(int i3, int i16, QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StLike qZMomentMeta$StLike) {
        if (qZMomentMeta$StFeed != null && qZMomentMeta$StLike != null) {
            b2(i16, qZMomentMeta$StFeed, qZMomentMeta$StLike);
            X1(i16, i3, qZMomentMeta$StFeed, qZMomentMeta$StLike);
        } else {
            QLog.e(getLogTag(), 1, "feed or like is null");
        }
    }
}
