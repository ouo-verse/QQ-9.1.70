package com.tencent.biz.qqcircle.drawer;

import android.text.TextUtils;
import android.util.Pair;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleSidebarRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.qcircle.api.helper.QCircleChatBoxHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudCommon$StCommonExt;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleCounter$AttachInfo;
import qqcircle.QQCircleCounter$PrivateMessage;
import trpcprotocol.feedcloud.sidebar.Bottom;
import trpcprotocol.feedcloud.sidebar.Drawer;
import trpcprotocol.feedcloud.sidebar.GetSidebarRsp;
import trpcprotocol.feedcloud.sidebar.Header;

/* compiled from: P */
/* loaded from: classes4.dex */
public class j extends com.tencent.biz.qqcircle.viewmodels.a {
    private final MutableLiveData<UIStateData<Header>> C;
    private final MutableLiveData<List<Bottom>> D;
    private final LiveData<UIStateData<List<Drawer>>> E;
    private final LiveData<UIStateData<Header>> F;
    private final LiveData<List<Bottom>> G;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<UIStateData<List<Drawer>>> f84406m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<GetSidebarRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QCircleSidebarRequest f84407a;

        a(QCircleSidebarRequest qCircleSidebarRequest) {
            this.f84407a = qCircleSidebarRequest;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, GetSidebarRsp getSidebarRsp) {
            boolean isProtocolCache = VSNetworkHelper.isProtocolCache(str);
            QLog.d("QFSDrawerViewModel", 1, "[requestSidebar] | onReceive: dispatch Success:" + z16 + " CMD:" + this.f84407a.get$cmd() + " | TraceId:" + this.f84407a.getTraceId() + " | SeqId:" + this.f84407a.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str + " | isCache:" + isProtocolCache);
            if (z16 && j3 == 0 && getSidebarRsp != null) {
                j.this.f84406m.postValue(UIStateData.obtainSuccess(isProtocolCache).setData(false, getSidebarRsp.drawers).setFinish(true));
                j.this.C.postValue(UIStateData.obtainSuccess(isProtocolCache).setData(false, getSidebarRsp.header).setFinish(true));
                j.this.D.postValue(getSidebarRsp.bottoms);
                return;
            }
            j.this.f84406m.postValue(UIStateData.obtainError(str));
        }
    }

    public j() {
        MutableLiveData<UIStateData<List<Drawer>>> mutableLiveData = new MutableLiveData<>();
        this.f84406m = mutableLiveData;
        MutableLiveData<UIStateData<Header>> mutableLiveData2 = new MutableLiveData<>();
        this.C = mutableLiveData2;
        MutableLiveData<List<Bottom>> mutableLiveData3 = new MutableLiveData<>();
        this.D = mutableLiveData3;
        this.E = mutableLiveData;
        this.F = mutableLiveData2;
        this.G = mutableLiveData3;
    }

    private byte[] R1(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
        List<FeedCloudCommon$BytesEntry> list;
        if (feedCloudCommon$StCommonExt != null) {
            list = feedCloudCommon$StCommonExt.mapBytesInfo.get();
        } else {
            list = null;
        }
        if (list == null) {
            return null;
        }
        Iterator<FeedCloudCommon$BytesEntry> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            FeedCloudCommon$BytesEntry next = it.next();
            if (next != null && TextUtils.equals(QCircleSidebarRequest.KEY_EXT_MESSAGE_INSERT_LIVE, next.key.get())) {
                if (next.value.get() != null) {
                    QLog.d(getTAG(), 1, "[getLiveMessageCommonExt] has live message");
                    return next.value.get().toByteArray();
                }
            }
        }
        return null;
    }

    private byte[] S1() {
        Pair<Integer, List<QQCircleCounter$PrivateMessage>> unReadMessages = QCircleChatBoxHelper.getInstance().getUnReadMessages();
        if (unReadMessages != null && unReadMessages.second != null) {
            QQCircleCounter$AttachInfo qQCircleCounter$AttachInfo = new QQCircleCounter$AttachInfo();
            QLog.d("QFSDrawerViewModel", 1, "[getPrivateMessageAttachInfo] unReadMessages size =" + ((List) unReadMessages.second).size());
            qQCircleCounter$AttachInfo.privateMsgList.set((List) unReadMessages.second);
            return qQCircleCounter$AttachInfo.toByteArray();
        }
        return null;
    }

    public LiveData<List<Bottom>> O1() {
        return this.G;
    }

    public LiveData<UIStateData<List<Drawer>>> P1() {
        return this.E;
    }

    public LiveData<UIStateData<Header>> Q1() {
        return this.F;
    }

    public void T1(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
        QCircleSidebarRequest qCircleSidebarRequest = new QCircleSidebarRequest(S1(), R1(feedCloudCommon$StCommonExt));
        this.f84406m.postValue(UIStateData.obtainLoading());
        VSNetworkHelper.getInstance().sendRequest(qCircleSidebarRequest, new a(qCircleSidebarRequest));
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSDrawerViewModel";
    }
}
