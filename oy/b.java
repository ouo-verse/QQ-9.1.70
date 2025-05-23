package oy;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.subscribe.network.SubscribeGetQCircleFeedListRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import mqq.util.WeakReference;
import oy.a;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b implements oy.a {

    /* renamed from: a, reason: collision with root package name */
    private String f424462a;

    /* renamed from: b, reason: collision with root package name */
    private a.InterfaceC10968a f424463b;

    /* renamed from: c, reason: collision with root package name */
    private a f424464c;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static class a implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<b> f424465a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f424466b;

        public a(b bVar, boolean z16) {
            this.f424465a = new WeakReference<>(bVar);
            this.f424466b = z16;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
            b bVar;
            QLog.i("SCF-ServiceQCircleFeedListModel", 1, "[onReceive] isSuccess=" + z16 + ",retCode=" + j3 + ",errMsg=" + str + ",traceId=" + baseRequest.getTraceId());
            WeakReference<b> weakReference = this.f424465a;
            if (weakReference == null) {
                bVar = null;
            } else {
                bVar = weakReference.get();
            }
            if (bVar == null) {
                QLog.e("SCF-ServiceQCircleFeedListModel", 1, "[onReceive] feed list model should not be null.");
                return;
            }
            if (!z16 || j3 != 0 || obj == null) {
                bVar.f(this.f424466b, j3, str);
            } else if (obj instanceof FeedCloudRead$StGetFeedListRsp) {
                bVar.g(this.f424466b, (FeedCloudRead$StGetFeedListRsp) obj);
            } else {
                QLog.e("SCF-ServiceQCircleFeedListModel", 1, "[onReceive] current get feed list rsp type error.");
            }
        }
    }

    private boolean e(boolean z16) {
        if (z16) {
            return false;
        }
        return TextUtils.isEmpty(this.f424462a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z16, long j3, String str) {
        a.InterfaceC10968a interfaceC10968a = this.f424463b;
        if (interfaceC10968a == null) {
            QLog.e("SCF-ServiceQCircleFeedListModel", 1, "[notifyLoadDataFail] feed calbback should not be null.");
        } else {
            interfaceC10968a.a(z16, j3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z16, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        String str;
        if (this.f424463b == null) {
            QLog.e("SCF-ServiceQCircleFeedListModel", 1, "[notifyLoadDataFinish] feed callback should not be null.");
            return;
        }
        if (feedCloudRead$StGetFeedListRsp == null) {
            str = null;
        } else {
            str = feedCloudRead$StGetFeedListRsp.feedAttchInfo.get();
        }
        this.f424462a = str;
        this.f424463b.b(z16, feedCloudRead$StGetFeedListRsp);
    }

    @Override // oy.a
    public void a(boolean z16) {
        if (e(z16)) {
            QLog.e("SCF-ServiceQCircleFeedListModel", 1, "[loadDataSource] current load more illegality.");
            return;
        }
        SubscribeGetQCircleFeedListRequest subscribeGetQCircleFeedListRequest = new SubscribeGetQCircleFeedListRequest(46);
        subscribeGetQCircleFeedListRequest.setEnableCache(false);
        this.f424464c = new a(this, z16);
        VSNetworkHelper.getInstance().sendRequest(subscribeGetQCircleFeedListRequest, this.f424464c);
    }

    @Override // oy.a
    public void b(a.InterfaceC10968a interfaceC10968a) {
        this.f424463b = interfaceC10968a;
    }
}
