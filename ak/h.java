package ak;

import com.qzone.reborn.intimate.bean.init.QZoneIntimateManageInitBean;
import com.qzone.reborn.intimate.request.QZoneIntimateGetISpaceListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateProfileReader$GetISpaceListRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00102\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\t\u0010B\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\b\u0012\u00060\u0002R\u00020\u0000\u0018\u00010\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lak/h;", "Lcom/tencent/mobileqq/engineering/preload/BasePreLoadTask;", "Lak/h$b;", "Lcom/tencent/mobileqq/engineering/preload/inter/OnPreLoadListener;", "preLoadListener", "", "startLoadData", "onRemove", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateManageInitBean;", "a", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateManageInitBean;", "getInitBean", "()Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateManageInitBean;", "initBean", "<init>", "(Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateManageInitBean;)V", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class h extends BasePreLoadTask<b> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final QZoneIntimateManageInitBean initBean;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010$\u001a\u00020\u001f\u00a2\u0006\u0004\b%\u0010&R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0017\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u0003\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010$\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010 \u001a\u0004\b\u000b\u0010!\"\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lak/h$b;", "", "", "a", "Z", "e", "()Z", "setSuccess", "(Z)V", "isSuccess", "", "b", "J", "c", "()J", "setRetCode", "(J)V", "retCode", "", "Ljava/lang/String;", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "errMsg", "Lqzone/QZIntimateProfileReader$GetISpaceListRsp;", "d", "Lqzone/QZIntimateProfileReader$GetISpaceListRsp;", "()Lqzone/QZIntimateProfileReader$GetISpaceListRsp;", "setRsp", "(Lqzone/QZIntimateProfileReader$GetISpaceListRsp;)V", "rsp", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "()Lcom/tencent/biz/richframework/network/request/BaseRequest;", "setRequest", "(Lcom/tencent/biz/richframework/network/request/BaseRequest;)V", Const.BUNDLE_KEY_REQUEST, "<init>", "(Lak/h;ZJLjava/lang/String;Lqzone/QZIntimateProfileReader$GetISpaceListRsp;Lcom/tencent/biz/richframework/network/request/BaseRequest;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long retCode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private String errMsg;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private QZIntimateProfileReader$GetISpaceListRsp rsp;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private BaseRequest request;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ h f26188f;

        public b(h hVar, boolean z16, long j3, String errMsg, QZIntimateProfileReader$GetISpaceListRsp qZIntimateProfileReader$GetISpaceListRsp, BaseRequest request) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Intrinsics.checkNotNullParameter(request, "request");
            this.f26188f = hVar;
            this.isSuccess = z16;
            this.retCode = j3;
            this.errMsg = errMsg;
            this.rsp = qZIntimateProfileReader$GetISpaceListRsp;
            this.request = request;
        }

        /* renamed from: a, reason: from getter */
        public final String getErrMsg() {
            return this.errMsg;
        }

        /* renamed from: b, reason: from getter */
        public final BaseRequest getRequest() {
            return this.request;
        }

        /* renamed from: c, reason: from getter */
        public final long getRetCode() {
            return this.retCode;
        }

        /* renamed from: d, reason: from getter */
        public final QZIntimateProfileReader$GetISpaceListRsp getRsp() {
            return this.rsp;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }
    }

    public h(QZoneIntimateManageInitBean qZoneIntimateManageInitBean) {
        this.initBean = qZoneIntimateManageInitBean;
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void startLoadData(final OnPreLoadListener<b> preLoadListener) {
        QZoneIntimateGetISpaceListRequest qZoneIntimateGetISpaceListRequest = new QZoneIntimateGetISpaceListRequest(this.initBean);
        VSNetworkHelper.getInstance().sendRequest(qZoneIntimateGetISpaceListRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: ak.g
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                h.b(OnPreLoadListener.this, this, baseRequest, z16, j3, str, (QZIntimateProfileReader$GetISpaceListRsp) obj);
            }
        });
        QLog.d("QZoneIntimateManagePreloadTask", 1, "prefetch: CmdName: " + qZoneIntimateGetISpaceListRequest.getCmdName() + " | TraceId: " + qZoneIntimateGetISpaceListRequest.getTraceId() + " | SeqId: " + qZoneIntimateGetISpaceListRequest.getCurrentSeq());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(OnPreLoadListener onPreLoadListener, h this$0, BaseRequest req, boolean z16, long j3, String errMsg, QZIntimateProfileReader$GetISpaceListRsp qZIntimateProfileReader$GetISpaceListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.i("QZoneIntimateManagePreloadTask", 1, " responseLog onReceive,  | isSuccess: " + z16 + " | traceId: " + req.getTraceId() + " | seqId: " + req.getCurrentSeq() + " | cmdName: " + req.getCmdName() + " | retCode: " + j3 + " | retMessage: " + errMsg);
        if (onPreLoadListener != null) {
            onPreLoadListener.onLoaded(new b(this$0, z16, j3, errMsg, qZIntimateProfileReader$GetISpaceListRsp, req));
        }
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void onRemove() {
    }
}
