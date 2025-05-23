package bk;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.base.n;
import com.qzone.reborn.intimate.request.QZoneIntimateDoLikeRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceWriter$StDoLikeRsp;
import qzone.QZoneBaseMeta$StLike;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ:\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00022\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u00a8\u0006\u0010"}, d2 = {"Lbk/i;", "", "", "contextHashCode", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "businessFeedData", "", "spaceId", "actionType", "Lcom/qzone/reborn/base/n$a;", "Lqzone/QZoneBaseMeta$StLike;", "dataCallback", "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class i {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J4\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"bk/i$b", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Lqzone/QZIntimateSpaceWriter$StDoLikeRsp;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "", "isSuccess", "", "retCode", "", "errMsg", "rsp", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class b implements VSDispatchObserver.OnVSRspCallBack<QZIntimateSpaceWriter$StDoLikeRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n.a<QZoneBaseMeta$StLike> f28503a;

        b(n.a<QZoneBaseMeta$StLike> aVar) {
            this.f28503a = aVar;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest request, boolean isSuccess, long retCode, String errMsg, QZIntimateSpaceWriter$StDoLikeRsp rsp) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            if (isSuccess) {
                this.f28503a.onSuccess(rsp != null ? rsp.like : null, retCode, errMsg, true);
            } else {
                this.f28503a.onFailure(retCode, errMsg);
            }
        }
    }

    public final void a(int contextHashCode, BusinessFeedData businessFeedData, String spaceId, int actionType, n.a<QZoneBaseMeta$StLike> dataCallback) {
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null) {
            if (!(spaceId == null || spaceId.length() == 0)) {
                VSNetworkHelper.getInstance().sendRequest(contextHashCode, new QZoneIntimateDoLikeRequest(businessFeedData, spaceId, actionType), new b(dataCallback));
                return;
            }
        }
        RFWLog.e("QZoneIntimateFeedLikeRepo", RFWLog.USR, "doLike error, businessFeedData: " + businessFeedData + ", spaceId: " + spaceId);
    }
}
