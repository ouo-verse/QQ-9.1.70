package bk;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.base.n;
import com.qzone.reborn.intimate.request.QZoneIntimateGetFeedDetailRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceReader$GetFeedDetailRsp;
import qzone.QZIntimateSpaceReader$StClientFeed;
import qzone.QZoneBaseCommon$StCommonExt;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J8\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J$\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a8\u0006\u0016"}, d2 = {"Lbk/h;", "", "", "success", "", "retCode", "", "errMsg", "Lqzone/QZIntimateSpaceReader$GetFeedDetailRsp;", "rsp", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "dataCallback", "", "b", "c", "", "contextHashCode", "feedId", "d", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class h {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J4\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"bk/h$a", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Lqzone/QZIntimateSpaceReader$GetFeedDetailRsp;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "", "isSuccess", "", "retCode", "", "errMsg", "rsp", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class a implements VSDispatchObserver.OnVSRspCallBack<QZIntimateSpaceReader$GetFeedDetailRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ n.a<BusinessFeedData> f28501b;

        a(n.a<BusinessFeedData> aVar) {
            this.f28501b = aVar;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest request, boolean isSuccess, long retCode, String errMsg, QZIntimateSpaceReader$GetFeedDetailRsp rsp) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            h.this.b(isSuccess, retCode, errMsg, rsp, this.f28501b);
        }
    }

    public final void d(int contextHashCode, String feedId, n.a<BusinessFeedData> dataCallback) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        VSNetworkHelper.getInstance().sendRequest(contextHashCode, new QZoneIntimateGetFeedDetailRequest(feedId), new a(dataCallback));
    }

    private final BusinessFeedData c(QZIntimateSpaceReader$GetFeedDetailRsp rsp) {
        if (rsp == null || rsp.feed.get() == null) {
            return null;
        }
        oj.a aVar = oj.a.f423008a;
        QZIntimateSpaceReader$StClientFeed qZIntimateSpaceReader$StClientFeed = rsp.feed.get();
        Intrinsics.checkNotNullExpressionValue(qZIntimateSpaceReader$StClientFeed, "rsp.feed.get()");
        QZoneBaseCommon$StCommonExt qZoneBaseCommon$StCommonExt = rsp.ext;
        Intrinsics.checkNotNullExpressionValue(qZoneBaseCommon$StCommonExt, "rsp.ext");
        return aVar.A(qZIntimateSpaceReader$StClientFeed, qZoneBaseCommon$StCommonExt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(boolean success, long retCode, String errMsg, QZIntimateSpaceReader$GetFeedDetailRsp rsp, n.a<BusinessFeedData> dataCallback) {
        if (success && rsp != null && retCode == 0) {
            BusinessFeedData c16 = c(rsp);
            if (c16 != null) {
                dataCallback.onSuccess(c16, retCode, errMsg, false);
                return;
            } else {
                dataCallback.onFailure(retCode, com.qzone.util.l.a(R.string.jlo));
                return;
            }
        }
        dataCallback.onFailure(retCode, errMsg);
    }
}
