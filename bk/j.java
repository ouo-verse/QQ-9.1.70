package bk;

import com.qzone.module.feedcomponent.manage.FeedManager;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.base.n;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateSpaceInitRequestBean;
import com.qzone.reborn.intimate.request.QZoneIntimateDeleteFeedRequest;
import com.qzone.reborn.intimate.request.QZoneIntimateGetFeedListRequest;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceReader$GetSpaceMainPageFeedsRsp;
import qzone.QZIntimateSpaceReader$StClientFeed;
import qzone.QZIntimateSpaceWriter$StDeleteFeedRsp;
import qzone.QZoneBaseCommon$StCommonExt;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J<\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH\u0002JF\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH\u0002J\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J,\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH\u0016J,\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH\u0016J8\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001d\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\nH\u0016R\u0016\u0010!\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lbk/j;", "", "", "contextHashCode", "Lcom/qzone/reborn/intimate/bean/init/b;", "initRequestBean", "", "attachInfo", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "Lcom/qzone/reborn/base/n$a;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "dataCallback", "", "c", "isSuccess", "", "retCode", "errMsg", "Lqzone/QZIntimateSpaceReader$GetSpaceMainPageFeedsRsp;", "rsp", FeedManager.LOAD_MORE, "d", "f", "g", "e", "businessFeedData", "spaceId", "isDelMediaFileInAlbum", "b", "a", "Ljava/lang/String;", "mAttachInfo", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String mAttachInfo = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J4\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"bk/j$a", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Lqzone/QZIntimateSpaceWriter$StDeleteFeedRsp;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "", "isSuccess", "", "retCode", "", "errMsg", "rsp", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class a implements VSDispatchObserver.OnVSRspCallBack<QZIntimateSpaceWriter$StDeleteFeedRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n.a<BusinessFeedData> f28505a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f28506b;

        a(n.a<BusinessFeedData> aVar, BusinessFeedData businessFeedData) {
            this.f28505a = aVar;
            this.f28506b = businessFeedData;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest request, boolean isSuccess, long retCode, String errMsg, QZIntimateSpaceWriter$StDeleteFeedRsp rsp) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            if (isSuccess && rsp != null && retCode == 0) {
                this.f28505a.onSuccess(this.f28506b, retCode, errMsg, true);
            } else {
                this.f28505a.onFailure(retCode, errMsg);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J4\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"bk/j$b", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Lqzone/QZIntimateSpaceReader$GetSpaceMainPageFeedsRsp;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "", "isSuccess", "", "retCode", "", "errMsg", "rsp", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class b implements VSDispatchObserver.OnVSRspCallBack<QZIntimateSpaceReader$GetSpaceMainPageFeedsRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f28508b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ n.a<List<BusinessFeedData>> f28509c;

        b(boolean z16, n.a<List<BusinessFeedData>> aVar) {
            this.f28508b = z16;
            this.f28509c = aVar;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest request, boolean isSuccess, long retCode, String errMsg, QZIntimateSpaceReader$GetSpaceMainPageFeedsRsp rsp) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            j.this.d(isSuccess, retCode, errMsg, rsp, this.f28508b, this.f28509c);
        }
    }

    private final void c(int contextHashCode, QZoneIntimateSpaceInitRequestBean initRequestBean, String attachInfo, boolean isLoadMore, n.a<List<BusinessFeedData>> dataCallback) {
        VSNetworkHelper.getInstance().sendRequest(contextHashCode, new QZoneIntimateGetFeedListRequest(attachInfo, initRequestBean), new b(isLoadMore, dataCallback));
    }

    public void b(int contextHashCode, BusinessFeedData businessFeedData, String spaceId, boolean isDelMediaFileInAlbum, n.a<BusinessFeedData> dataCallback) {
        Intrinsics.checkNotNullParameter(businessFeedData, "businessFeedData");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        VSNetworkHelper.getInstance().sendRequest(contextHashCode, new QZoneIntimateDeleteFeedRequest(businessFeedData, spaceId, isDelMediaFileInAlbum), new a(dataCallback, businessFeedData));
    }

    public void e(int contextHashCode, QZoneIntimateSpaceInitRequestBean initRequestBean, n.a<List<BusinessFeedData>> dataCallback) {
        Intrinsics.checkNotNullParameter(initRequestBean, "initRequestBean");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        c(contextHashCode, initRequestBean, this.mAttachInfo, true, dataCallback);
    }

    public void g(int contextHashCode, QZoneIntimateSpaceInitRequestBean initRequestBean, n.a<List<BusinessFeedData>> dataCallback) {
        Intrinsics.checkNotNullParameter(initRequestBean, "initRequestBean");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        c(contextHashCode, initRequestBean, "", false, dataCallback);
    }

    private final List<BusinessFeedData> f(QZIntimateSpaceReader$GetSpaceMainPageFeedsRsp rsp) {
        if (rsp != null && rsp.feeds.get() != null) {
            oj.a aVar = oj.a.f423008a;
            List<QZIntimateSpaceReader$StClientFeed> list = rsp.feeds.get();
            Intrinsics.checkNotNullExpressionValue(list, "rsp.feeds.get()");
            QZoneBaseCommon$StCommonExt qZoneBaseCommon$StCommonExt = rsp.ext.get();
            Intrinsics.checkNotNullExpressionValue(qZoneBaseCommon$StCommonExt, "rsp.ext.get()");
            return aVar.E(list, qZoneBaseCommon$StCommonExt);
        }
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(boolean isSuccess, long retCode, String errMsg, QZIntimateSpaceReader$GetSpaceMainPageFeedsRsp rsp, boolean loadMore, n.a<List<BusinessFeedData>> dataCallback) {
        if (isSuccess && rsp != null && retCode == 0) {
            String str = rsp.attach_info.get();
            Intrinsics.checkNotNullExpressionValue(str, "rsp.attach_info.get()");
            this.mAttachInfo = str;
            dataCallback.onSuccess(f(rsp), retCode, errMsg, !rsp.has_more.get());
            return;
        }
        dataCallback.onFailure(retCode, errMsg);
    }
}
