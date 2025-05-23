package ak;

import android.text.TextUtils;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateMainPageInitBean;
import com.qzone.reborn.intimate.request.QZoneIntimateGetAlbumListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceAlbum$GetAlbumListRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00102\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\t\u0010B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\b\u0012\u00060\u0002R\u00020\u0000\u0018\u00010\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lak/d;", "Lcom/tencent/mobileqq/engineering/preload/BasePreLoadTask;", "Lak/d$b;", "Lcom/tencent/mobileqq/engineering/preload/inter/OnPreLoadListener;", "preLoadListener", "", "startLoadData", "onRemove", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateMainPageInitBean;", "a", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateMainPageInitBean;", "getInitBean", "()Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateMainPageInitBean;", "initBean", "<init>", "(Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateMainPageInitBean;)V", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class d extends BasePreLoadTask<b> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final QZoneIntimateMainPageInitBean initBean;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B+\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\u0011\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0003\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u0012\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lak/d$b;", "", "", "a", "Z", "d", "()Z", "setSuccess", "(Z)V", "isSuccess", "", "b", "J", "()J", "setRetCode", "(J)V", "retCode", "", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "errMsg", "Lqzone/QZIntimateSpaceAlbum$GetAlbumListRsp;", "Lqzone/QZIntimateSpaceAlbum$GetAlbumListRsp;", "()Lqzone/QZIntimateSpaceAlbum$GetAlbumListRsp;", "setRsp", "(Lqzone/QZIntimateSpaceAlbum$GetAlbumListRsp;)V", "rsp", "<init>", "(Lak/d;ZJLjava/lang/String;Lqzone/QZIntimateSpaceAlbum$GetAlbumListRsp;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long retCode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private String errMsg;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private QZIntimateSpaceAlbum$GetAlbumListRsp rsp;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f26169e;

        public b(d dVar, boolean z16, long j3, String errMsg, QZIntimateSpaceAlbum$GetAlbumListRsp qZIntimateSpaceAlbum$GetAlbumListRsp) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f26169e = dVar;
            this.isSuccess = z16;
            this.retCode = j3;
            this.errMsg = errMsg;
            this.rsp = qZIntimateSpaceAlbum$GetAlbumListRsp;
        }

        /* renamed from: a, reason: from getter */
        public final String getErrMsg() {
            return this.errMsg;
        }

        /* renamed from: b, reason: from getter */
        public final long getRetCode() {
            return this.retCode;
        }

        /* renamed from: c, reason: from getter */
        public final QZIntimateSpaceAlbum$GetAlbumListRsp getRsp() {
            return this.rsp;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }
    }

    public d(QZoneIntimateMainPageInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.initBean = initBean;
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void startLoadData(final OnPreLoadListener<b> preLoadListener) {
        if (TextUtils.isEmpty(this.initBean.getSpaceId())) {
            return;
        }
        QZoneIntimateGetAlbumListRequest qZoneIntimateGetAlbumListRequest = new QZoneIntimateGetAlbumListRequest(this.initBean.getSpaceId(), "", this.initBean.getScene());
        VSNetworkHelper.getInstance().sendRequest(qZoneIntimateGetAlbumListRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: ak.c
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                d.b(OnPreLoadListener.this, this, baseRequest, z16, j3, str, (QZIntimateSpaceAlbum$GetAlbumListRsp) obj);
            }
        });
        QLog.d("QZoneIntimateAlbumListPreLoaderTask", 1, "prefetch: CmdName: " + qZoneIntimateGetAlbumListRequest.get$cmd() + " | TraceId: " + qZoneIntimateGetAlbumListRequest.getTraceId() + " | SeqId: " + qZoneIntimateGetAlbumListRequest.getCurrentSeq());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(OnPreLoadListener onPreLoadListener, d this$0, BaseRequest req, boolean z16, long j3, String errMsg, QZIntimateSpaceAlbum$GetAlbumListRsp qZIntimateSpaceAlbum$GetAlbumListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.d("QZoneIntimateAlbumListPreLoaderTask", 1, " responseLog onReceive, ", " | isSuccess: " + z16, " | traceId: " + req.getTraceId(), " | seqId: " + req.getCurrentSeq(), " | cmdName: " + req.get$cmd(), " | retCode: " + j3, " | retMessage: " + errMsg);
        if (onPreLoadListener != null) {
            onPreLoadListener.onLoaded(new b(this$0, z16, j3, errMsg, qZIntimateSpaceAlbum$GetAlbumListRsp));
        }
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void onRemove() {
    }
}
