package on;

import android.util.Log;
import com.qzone.reborn.qzmoment.bean.QZMPublishBean;
import com.qzone.reborn.qzmoment.event.QZMNotifyNewPublishFeedEvent;
import com.qzone.reborn.qzmoment.publish.request.QZMPublishRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.winkpublish.MediaInfo;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.mobileqq.winkpublish.result.ImageResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QZoneConfigHelper;
import java.util.HashMap;
import java.util.Objects;
import qzonemoment.QZMomentMeta$StImage;
import qzonemoment.QZMomentWriter$StPublishFeedRsp;
import rn.d;

/* compiled from: P */
/* loaded from: classes38.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final c f423189a;

    /* renamed from: b, reason: collision with root package name */
    private ITaskListener.Stub f423190b;

    /* renamed from: c, reason: collision with root package name */
    private QZMPublishBean f423191c;

    /* renamed from: d, reason: collision with root package name */
    private QZMPublishRequest f423192d;

    /* renamed from: e, reason: collision with root package name */
    private int f423193e = 1;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public interface c {
        void a();

        void b();

        void c(boolean z16);
    }

    public e(c cVar) {
        this.f423189a = cVar;
        j();
    }

    private void B() {
        WinkPublishServiceProxy2 service;
        try {
            if (this.f423190b == null || (service = WinkPublishHelper2.INSTANCE.getService(9)) == null) {
                return;
            }
            service.removeTaskListener(this.f423190b);
        } catch (Exception e16) {
            QLog.e(n(), 1, "[removeWinkPublishTaskListener]", e16);
        }
    }

    private void E(HashMap<String, ImageResult> hashMap) {
        if (hashMap.containsKey(this.f423191c.mFrontPath) && hashMap.containsKey(this.f423191c.mBackPath)) {
            try {
                ImageResult imageResult = hashMap.get(this.f423191c.mFrontPath);
                Objects.requireNonNull(imageResult);
                QZMomentMeta$StImage b16 = f.b(imageResult);
                b16.image_type.set(1);
                ImageResult imageResult2 = hashMap.get(this.f423191c.mBackPath);
                Objects.requireNonNull(imageResult2);
                QZMomentMeta$StImage b17 = f.b(imageResult2);
                b17.image_type.set(2);
                if (QLog.isColorLevel()) {
                    QLog.d(n(), 1, "sendQZoneMomentPublishReq send,frontPath:", b16.picUrl.get(), " ,backPath:", b17.picUrl.get());
                }
                QZMPublishRequest qZMPublishRequest = new QZMPublishRequest(b16, b17, this.f423191c.mContent, f.c(this.f423191c.mPoiInfo));
                this.f423192d = qZMPublishRequest;
                z(qZMPublishRequest);
                return;
            } catch (Exception e16) {
                QLog.e(n(), 1, "sendQZoneMomentPublishReq error:", Log.getStackTraceString(e16), ",traceId:", this.f423191c.mTraceId);
                return;
            }
        }
        v(true);
        QLog.e(n(), 1, "sendQZoneMomentPublishReq miss uploadResult,traceId:", this.f423191c.mTraceId);
    }

    private void j() {
        this.f423190b = new a();
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: on.b
            @Override // java.lang.Runnable
            public final void run() {
                e.this.s();
            }
        });
    }

    private void l(final long j3) {
        WinkPublishHelper2.INSTANCE.bindService(9, new WinkPublishHelper2.Callback() { // from class: on.a
            @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
            public final void onServiceConnected(WinkPublishServiceProxy2 winkPublishServiceProxy2) {
                winkPublishServiceProxy2.cancelTaskWithId(j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(TaskInfo taskInfo) {
        QZMPublishBean qZMPublishBean = this.f423191c;
        return qZMPublishBean != null && qZMPublishBean.mTraceId.equals(taskInfo.getTraceId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String n() {
        return "QZMPublish_QZMPublishManager";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(TaskInfo taskInfo) {
        QZMPublishBean qZMPublishBean = this.f423191c;
        if (qZMPublishBean != null && !qZMPublishBean.isInValid()) {
            if (!q(taskInfo)) {
                v(true);
                QLog.e(n(), 1, "handleUploadResult task failed,traceid:", taskInfo.getTraceId());
                return;
            }
            try {
                HashMap<String, ImageResult> hashMap = new HashMap<>();
                for (MediaInfo mediaInfo : taskInfo.getMediaInfos()) {
                    if (mediaInfo != null && (mediaInfo.getUploadResult() instanceof ImageResult)) {
                        hashMap.put(mediaInfo.getMediaPath(), (ImageResult) mediaInfo.getUploadResult());
                    }
                }
                E(hashMap);
                return;
            } catch (Exception e16) {
                v(true);
                QLog.e(n(), 1, "handleUploadResult send new qzmoment feed error:", Log.getStackTraceString(e16), ",traceId:", taskInfo.getTraceId());
                return;
            }
        }
        v(false);
        QLog.e(n(), 1, "handleUploadResult mPublishBean is inValid");
    }

    private boolean q(TaskInfo taskInfo) {
        return taskInfo.getBusinessType() == 9 && taskInfo.getMediaInfos().size() == 2 && taskInfo.getMediaInfos().get(0).getUploadResult() != null && taskInfo.getMediaInfos().get(1).getUploadResult() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s() {
        try {
            WinkPublishHelper2.INSTANCE.bindService(9, new WinkPublishHelper2.Callback() { // from class: on.d
                @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
                public final void onServiceConnected(WinkPublishServiceProxy2 winkPublishServiceProxy2) {
                    e.this.r(winkPublishServiceProxy2);
                }
            });
        } catch (Exception e16) {
            QLog.e(n(), 1, "[addWinkPublishTaskListener] bindService", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(BaseRequest baseRequest, boolean z16, long j3, String str, QZMomentWriter$StPublishFeedRsp qZMomentWriter$StPublishFeedRsp) {
        String str2;
        String n3 = n();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(" sendQZoneMomentPublishReq onReceive: dispatch isSuccess:");
        sb5.append(z16);
        sb5.append(" | TaskTraceId:");
        QZMPublishBean qZMPublishBean = this.f423191c;
        if (qZMPublishBean == null) {
            str2 = "bean is null";
        } else {
            str2 = qZMPublishBean.mTraceId;
        }
        sb5.append(str2);
        sb5.append(" | ReqTraceId:");
        sb5.append(baseRequest.getTraceId());
        sb5.append(" | seqId:");
        sb5.append(baseRequest.getCurrentSeq());
        sb5.append(" | retCode:");
        sb5.append(j3);
        sb5.append(" | retMessage:");
        sb5.append(str);
        QLog.d(n3, 1, sb5.toString());
        if (z16 && j3 == 0) {
            o(qZMomentWriter$StPublishFeedRsp);
        } else {
            v(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z16) {
        if (this.f423189a == null) {
            return;
        }
        boolean z17 = z16 && !y();
        this.f423189a.c(z17);
        if (z17) {
            return;
        }
        C();
    }

    private void w() {
        c cVar = this.f423189a;
        if (cVar == null) {
            return;
        }
        cVar.a();
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        c cVar = this.f423189a;
        if (cVar == null) {
            return;
        }
        cVar.b();
    }

    private boolean y() {
        return this.f423193e > QZoneConfigHelper.s0();
    }

    private void z(QZMPublishRequest qZMPublishRequest) {
        VSNetworkHelper.getInstance().sendRequest(qZMPublishRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: on.c
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                e.this.u(baseRequest, z16, j3, str, (QZMomentWriter$StPublishFeedRsp) obj);
            }
        });
    }

    public void A() {
        QZMPublishBean qZMPublishBean = this.f423191c;
        if (qZMPublishBean != null) {
            l(qZMPublishBean.mTaskId);
            QLog.d(n(), 1, "release abandon current task:", this.f423191c.mTraceId);
        }
        C();
        B();
        QLog.d(n(), 1, "release");
    }

    public boolean D() {
        if (this.f423191c == null || y()) {
            return false;
        }
        this.f423193e++;
        QZMPublishRequest qZMPublishRequest = this.f423192d;
        if (qZMPublishRequest == null) {
            rn.d.b(this.f423191c, new b());
        } else {
            z(qZMPublishRequest);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a extends ITaskListener.Stub {
        a() {
        }

        @Override // com.tencent.mobileqq.winkpublish.api.ITaskListener
        public void onTaskChange(TaskInfo taskInfo) {
            if (taskInfo != null && taskInfo.isTrueUpload() && e.this.m(taskInfo)) {
                if (taskInfo.isActive()) {
                    e.this.x();
                    return;
                }
                if (taskInfo.isCancelled()) {
                    QLog.d(e.this.n(), 1, "getUploadTaskResult cancel,traceId:", taskInfo.getTraceId(), ",state:", Integer.valueOf(taskInfo.getState()), ",errorCode:", taskInfo.getErrCode(), ",errorMsg:", taskInfo.getErrMsg());
                } else if (taskInfo.isFinish()) {
                    QLog.d(e.this.n(), 1, "getUploadTaskResult finish,traceId:", taskInfo.getTraceId(), ",state:", Integer.valueOf(taskInfo.getState()), ",errorCode:", taskInfo.getErrCode(), ",errorMsg:", taskInfo.getErrMsg());
                    e.this.p(taskInfo);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class b implements d.a {
        b() {
        }

        @Override // rn.d.a
        public void a(boolean z16) {
            if (z16) {
                return;
            }
            e.this.v(true);
        }
    }

    private void C() {
        this.f423191c = null;
        this.f423192d = null;
        this.f423193e = 1;
    }

    private void o(QZMomentWriter$StPublishFeedRsp qZMomentWriter$StPublishFeedRsp) {
        if (qZMomentWriter$StPublishFeedRsp != null && qZMomentWriter$StPublishFeedRsp.feed.has()) {
            com.tencent.mobileqq.service.qzone.b.z(qZMomentWriter$StPublishFeedRsp.nextPublishTime.get());
            SimpleEventBus.getInstance().dispatchEvent(new QZMNotifyNewPublishFeedEvent(qZMomentWriter$StPublishFeedRsp.feed));
            w();
        } else {
            v(true);
            QLog.e(n(), 1, "handleQZoneMomentPublishRsp error,rsp is null or rsp.feed is empty!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(WinkPublishServiceProxy2 winkPublishServiceProxy2) {
        if (winkPublishServiceProxy2 == null) {
            QLog.i(n(), 1, "[addWinkPublishTaskListener] service is null");
        } else {
            winkPublishServiceProxy2.addTaskListener2(this.f423190b);
        }
    }

    public void k(QZMPublishBean qZMPublishBean) {
        if (qZMPublishBean == null) {
            return;
        }
        QZMPublishBean qZMPublishBean2 = this.f423191c;
        if (qZMPublishBean2 != null && !qZMPublishBean2.mTraceId.equals(qZMPublishBean.mTraceId)) {
            QLog.d(n(), 1, "bindPublishBean abandon old task:", this.f423191c.mTraceId);
            l(this.f423191c.mTaskId);
            C();
        }
        this.f423191c = qZMPublishBean;
        QLog.d(n(), 1, "bindPublishBean new task:", qZMPublishBean.mTraceId);
    }
}
