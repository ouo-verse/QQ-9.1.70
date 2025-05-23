package bk;

import com.qzone.reborn.base.n;
import com.qzone.reborn.intimate.bean.QZoneAlbumInfoBean;
import com.qzone.reborn.intimate.request.QZoneIntimateGetAllAlbumListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceAlbum$AlbumSpaceInfo;
import qzone.QZIntimateSpaceAlbum$GetAllAlbumListByUserRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J0\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\nH\u0002J4\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u001c\u0010\u0017\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b0\u0016R\u0014\u0010\u001b\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lbk/c;", "", "Lqzone/QZIntimateSpaceAlbum$GetAllAlbumListByUserRsp;", "rsp", "", "uin", "Ljava/util/ArrayList;", "Lcom/qzone/reborn/intimate/bean/QZoneAlbumInfoBean;", "Lkotlin/collections/ArrayList;", "b", "", "msg", "", "isSuccess", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "req", "retCode", "errMsg", "", "e", "", "contextHashCode", "Lcom/qzone/reborn/base/n$a;", "dataCallback", "c", "a", "Ljava/lang/String;", "TAG", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZoneAlbumIntimateTabServerRepo";

    private final ArrayList<QZoneAlbumInfoBean> b(QZIntimateSpaceAlbum$GetAllAlbumListByUserRsp rsp, long uin) {
        ArrayList<QZoneAlbumInfoBean> arrayList = new ArrayList<>();
        if (rsp != null && rsp.space_list.get() != null) {
            List<QZIntimateSpaceAlbum$AlbumSpaceInfo> list = rsp.space_list.get();
            Intrinsics.checkNotNullExpressionValue(list, "rsp.space_list.get()");
            for (QZIntimateSpaceAlbum$AlbumSpaceInfo it : list) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(new QZoneAlbumInfoBean(it, rsp.ext, uin));
            }
        }
        return arrayList;
    }

    private final void e(String msg2, boolean isSuccess, BaseRequest req, long retCode, String errMsg) {
        QLog.i(this.TAG, 1, msg2 + " responseLog onReceive, isSuccess: " + isSuccess + " | traceId: " + req.getTraceId() + " | seqId:" + req.getCurrentSeq() + " | cmdName:" + req.get$cmd() + " | retCode:" + retCode + " | retMessage:" + errMsg);
    }

    public final void c(int contextHashCode, final long uin, final n.a<ArrayList<QZoneAlbumInfoBean>> dataCallback) {
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        VSNetworkHelper.getInstance().sendRequest(contextHashCode, new QZoneIntimateGetAllAlbumListRequest(uin), new VSDispatchObserver.OnVSRspCallBack() { // from class: bk.b
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                c.d(c.this, uin, dataCallback, baseRequest, z16, j3, str, (QZIntimateSpaceAlbum$GetAllAlbumListByUserRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(c this$0, long j3, n.a dataCallback, BaseRequest request, boolean z16, long j16, String errMsg, QZIntimateSpaceAlbum$GetAllAlbumListByUserRsp qZIntimateSpaceAlbum$GetAllAlbumListByUserRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        if (z16 && qZIntimateSpaceAlbum$GetAllAlbumListByUserRsp != null && j16 == 0) {
            ArrayList<QZoneAlbumInfoBean> b16 = this$0.b(qZIntimateSpaceAlbum$GetAllAlbumListByUserRsp, j3);
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            dataCallback.onSuccess(b16, j16, errMsg, false);
        } else {
            dataCallback.onFailure(j16, errMsg);
        }
        Intrinsics.checkNotNullExpressionValue(request, "request");
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        this$0.e("requestFeeds", z16, request, j16, errMsg);
    }
}
