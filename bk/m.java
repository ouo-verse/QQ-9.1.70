package bk;

import com.qzone.reborn.base.n;
import com.qzone.reborn.intimate.request.QZoneIntimateDeleteMessageRequest;
import com.qzone.reborn.intimate.request.QZoneIntimateGetNoticeListRequest;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceReader$GetNoticeListRsp;
import qzone.QZIntimateSpaceReader$StNotice;
import qzone.QZIntimateSpaceWriter$StDelNoticeRsp;
import qzone.QZoneBaseCommon$StCommonExt;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J8\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J*\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00042\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010J&\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00022\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001d\u00a8\u0006!"}, d2 = {"Lbk/m;", "", "", "msg", "", "isSuccess", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "req", "", "retCode", "errMsg", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "g", "", "contextHashCode", "Lcom/qzone/reborn/base/n$a;", "", "Lcom/qzone/reborn/message/data/a;", "dataCallback", "e", "noticeId", "c", "a", "Ljava/lang/String;", "TAG", "b", "mAttachInfo", "Lqzone/QZoneBaseCommon$StCommonExt;", "Lqzone/QZoneBaseCommon$StCommonExt;", "mCommonExt", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZoneIntimateMessageServerRepo";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String mAttachInfo = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private QZoneBaseCommon$StCommonExt mCommonExt;

    private final void g(String msg2, boolean isSuccess, BaseRequest req, long retCode, String errMsg, boolean isLoadMore) {
        QLog.i(this.TAG, 1, msg2 + " responseLog onReceive, isSuccess: " + isSuccess + " | traceId: " + req.getTraceId() + " | seqId:" + req.getCurrentSeq() + " | cmdName:" + req.get$cmd() + " | retCode:" + retCode + " | retMessage:" + errMsg + " | isLoadMore:" + isLoadMore);
    }

    public final void c(int contextHashCode, String noticeId, final n.a<Object> dataCallback) {
        Intrinsics.checkNotNullParameter(noticeId, "noticeId");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        VSNetworkHelper.getInstance().sendRequest(contextHashCode, new QZoneIntimateDeleteMessageRequest(noticeId, 0, this.mCommonExt), new VSDispatchObserver.OnVSRspCallBack() { // from class: bk.l
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                m.d(m.this, dataCallback, baseRequest, z16, j3, str, (QZIntimateSpaceWriter$StDelNoticeRsp) obj);
            }
        });
    }

    public final void e(int contextHashCode, final boolean isLoadMore, final n.a<List<com.qzone.reborn.message.data.a>> dataCallback) {
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        if (!isLoadMore) {
            this.mAttachInfo = "";
        }
        VSNetworkHelper.getInstance().sendRequest(contextHashCode, new QZoneIntimateGetNoticeListRequest(this.mAttachInfo, this.mCommonExt), new VSDispatchObserver.OnVSRspCallBack() { // from class: bk.k
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                m.f(m.this, isLoadMore, dataCallback, baseRequest, z16, j3, str, (QZIntimateSpaceReader$GetNoticeListRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(m this$0, n.a dataCallback, BaseRequest request, boolean z16, long j3, String errMsg, QZIntimateSpaceWriter$StDelNoticeRsp qZIntimateSpaceWriter$StDelNoticeRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        Intrinsics.checkNotNullExpressionValue(request, "request");
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        this$0.g("[deleteMessage]", z16, request, j3, errMsg, false);
        if (!z16) {
            dataCallback.onFailure(j3, errMsg);
        } else if (qZIntimateSpaceWriter$StDelNoticeRsp != null) {
            dataCallback.onSuccess(qZIntimateSpaceWriter$StDelNoticeRsp, j3, errMsg, true);
        } else {
            dataCallback.onFailure(j3, "StDeleteMessageRsp is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(m this$0, boolean z16, n.a dataCallback, BaseRequest request, boolean z17, long j3, String errMsg, QZIntimateSpaceReader$GetNoticeListRsp qZIntimateSpaceReader$GetNoticeListRsp) {
        ArrayList arrayList;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        Intrinsics.checkNotNullExpressionValue(request, "request");
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        this$0.g("[requestList]", z17, request, j3, errMsg, z16);
        if (!z17) {
            dataCallback.onFailure(j3, errMsg);
            return;
        }
        if (qZIntimateSpaceReader$GetNoticeListRsp != null && j3 == 0) {
            String str = qZIntimateSpaceReader$GetNoticeListRsp.attach_info.get();
            Intrinsics.checkNotNullExpressionValue(str, "rsp.attach_info.get()");
            this$0.mAttachInfo = str;
            this$0.mCommonExt = qZIntimateSpaceReader$GetNoticeListRsp.ext.get();
            List<QZIntimateSpaceReader$StNotice> list = qZIntimateSpaceReader$GetNoticeListRsp.notices.get();
            if (list != null) {
                List<QZIntimateSpaceReader$StNotice> list2 = list;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                arrayList = new ArrayList(collectionSizeOrDefault);
                for (QZIntimateSpaceReader$StNotice it : list2) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    QZoneBaseCommon$StCommonExt qZoneBaseCommon$StCommonExt = qZIntimateSpaceReader$GetNoticeListRsp.ext;
                    Intrinsics.checkNotNullExpressionValue(qZoneBaseCommon$StCommonExt, "rsp.ext");
                    arrayList.add(new com.qzone.reborn.message.data.a(it, qZoneBaseCommon$StCommonExt));
                }
            } else {
                arrayList = new ArrayList();
            }
            dataCallback.onSuccess(arrayList, j3, errMsg, !qZIntimateSpaceReader$GetNoticeListRsp.has_more.get());
            return;
        }
        dataCallback.onFailure(j3, "message list rsp is null");
    }
}
