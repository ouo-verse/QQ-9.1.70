package bk;

import com.qzone.reborn.base.n;
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateSpaceInitRequestBean;
import com.qzone.reborn.intimate.request.QZoneIntimateClearRedDotRequest;
import com.qzone.reborn.intimate.request.QZoneIntimateModifyAnniversaryRequest;
import com.qzone.reborn.intimate.request.QZoneIntimateSpaceMainRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateProfileReader$ClientModISpaceInfoRsp;
import qzone.QZIntimateSpaceReader$ClearReddotRsp;
import qzone.QZIntimateSpaceReader$GetSpaceMainPageHeadRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J,\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006J$\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006\u00a8\u0006\u0016"}, d2 = {"Lbk/q;", "", "", "contextHashCode", "Lcom/qzone/reborn/intimate/bean/init/b;", "initRequestBean", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/reborn/intimate/bean/QZoneIntimateSpaceBean;", "dataCallback", "", tl.h.F, "", "spaceId", "", "timeStampInSecond", "f", "pageType", "Lqzone/QZIntimateSpaceReader$ClearReddotRsp;", "d", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public class q {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(n.a dataCallback, BaseRequest baseRequest, boolean z16, long j3, String errMsg, QZIntimateSpaceReader$ClearReddotRsp qZIntimateSpaceReader$ClearReddotRsp) {
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        QLog.i("QZoneIntimateSpaceMainRepo", 1, "doClearRedDot,isSuccess = " + z16 + " | retCode = " + j3 + " | errMsg = " + errMsg + " | cmdName = " + (baseRequest != null ? baseRequest.get$cmd() : null) + " | traceId = " + (baseRequest != null ? baseRequest.getTraceId() : null));
        if (!z16) {
            dataCallback.onFailure(j3, errMsg);
        } else if (qZIntimateSpaceReader$ClearReddotRsp != null) {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            dataCallback.onSuccess(qZIntimateSpaceReader$ClearReddotRsp, j3, errMsg, true);
        } else {
            dataCallback.onFailure(j3, "[doClearRedDot] rsp is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(n.a dataCallback, BaseRequest baseRequest, boolean z16, long j3, String errMsg, QZIntimateProfileReader$ClientModISpaceInfoRsp qZIntimateProfileReader$ClientModISpaceInfoRsp) {
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        if (!z16) {
            dataCallback.onFailure(j3, errMsg);
            return;
        }
        if (qZIntimateProfileReader$ClientModISpaceInfoRsp != null && j3 == 0) {
            Integer valueOf = Integer.valueOf(qZIntimateProfileReader$ClientModISpaceInfoRsp.relation_days.get());
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            dataCallback.onSuccess(valueOf, j3, errMsg, true);
            return;
        }
        dataCallback.onFailure(j3, errMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(QZoneIntimateSpaceInitRequestBean initRequestBean, n.a dataCallback, BaseRequest baseRequest, boolean z16, long j3, String errMsg, QZIntimateSpaceReader$GetSpaceMainPageHeadRsp qZIntimateSpaceReader$GetSpaceMainPageHeadRsp) {
        Intrinsics.checkNotNullParameter(initRequestBean, "$initRequestBean");
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        if (z16 && qZIntimateSpaceReader$GetSpaceMainPageHeadRsp != null && j3 == 0) {
            QZoneIntimateSpaceBean a16 = QZoneIntimateSpaceBean.INSTANCE.a(qZIntimateSpaceReader$GetSpaceMainPageHeadRsp);
            if (a16 != null) {
                a16.setDraft(initRequestBean.getIsDraft());
            }
            if (a16 != null) {
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                dataCallback.onSuccess(a16, j3, errMsg, true);
                return;
            } else {
                dataCallback.onFailure(j3, "spaceBean parse error");
                return;
            }
        }
        dataCallback.onFailure(j3, errMsg);
    }

    public final void d(int contextHashCode, int pageType, final n.a<QZIntimateSpaceReader$ClearReddotRsp> dataCallback) {
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        VSNetworkHelper.getInstance().sendRequest(contextHashCode, new QZoneIntimateClearRedDotRequest(pageType), new VSDispatchObserver.OnVSRspCallBack() { // from class: bk.p
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                q.e(n.a.this, baseRequest, z16, j3, str, (QZIntimateSpaceReader$ClearReddotRsp) obj);
            }
        });
    }

    public final void f(int contextHashCode, String spaceId, long timeStampInSecond, final n.a<Integer> dataCallback) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        if (spaceId.length() == 0) {
            return;
        }
        VSNetworkHelper.getInstance().sendRequest(contextHashCode, new QZoneIntimateModifyAnniversaryRequest(spaceId, timeStampInSecond), new VSDispatchObserver.OnVSRspCallBack() { // from class: bk.n
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                q.g(n.a.this, baseRequest, z16, j3, str, (QZIntimateProfileReader$ClientModISpaceInfoRsp) obj);
            }
        });
    }

    public void h(int contextHashCode, final QZoneIntimateSpaceInitRequestBean initRequestBean, final n.a<QZoneIntimateSpaceBean> dataCallback) {
        Intrinsics.checkNotNullParameter(initRequestBean, "initRequestBean");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        if (!(initRequestBean.getSpaceId().length() == 0) || initRequestBean.getIsDraft()) {
            VSNetworkHelper.getInstance().sendRequest(contextHashCode, new QZoneIntimateSpaceMainRequest(initRequestBean), new VSDispatchObserver.OnVSRspCallBack() { // from class: bk.o
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                    q.i(QZoneIntimateSpaceInitRequestBean.this, dataCallback, baseRequest, z16, j3, str, (QZIntimateSpaceReader$GetSpaceMainPageHeadRsp) obj);
                }
            });
        }
    }
}
