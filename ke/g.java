package ke;

import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerListBean;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneMediaLayerManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetMediaLayerRsp;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.util.ArrayUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lke/g;", "Lke/b;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetMediaLayerRsp;", "rsp", "Lge/g;", "requestBean", "", "q2", "d2", "<init>", "()V", BdhLogUtil.LogTag.Tag_Req, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class g extends ke.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"ke/g$b", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetMediaLayerRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "rsp", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements DataCallback<GetMediaLayerRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ge.g f412085b;

        b(ge.g gVar) {
            this.f412085b = gVar;
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(GetMediaLayerRsp rsp, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            g.this.q2(rsp, this.f412085b);
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            QLog.d("QzoneFeedProLongPicLayerViewModel", 1, "fetch layer info error, errorCode: " + errorCode + ", errorMsg: " + errorMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q2(GetMediaLayerRsp rsp, ge.g requestBean) {
        QzoneFeedProLayerListBean qzoneFeedProLayerListBean = new QzoneFeedProLayerListBean();
        qzoneFeedProLayerListBean.o(je.a.q(rsp.mediaList, rsp.album));
        qzoneFeedProLayerListBean.f0(qzoneFeedProLayerListBean.g().size());
        if (ArrayUtils.isOutOfArrayIndex(0, qzoneFeedProLayerListBean.g())) {
            M1().postValue(UIStateData.obtainEmpty());
        } else {
            M1().postValue(UIStateData.obtainSuccess(false).setDataList(qzoneFeedProLayerListBean));
        }
    }

    @Override // ke.b
    public void d2(ge.g requestBean) {
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        if (getOwner() == null) {
            QLog.e("QzoneFeedProLongPicLayerViewModel", 1, "owner is null");
            return;
        }
        if (Q1() == null) {
            QLog.e("QzoneFeedProLongPicLayerViewModel", 1, "unionId is null");
            return;
        }
        o2(requestBean);
        QzoneMediaLayerManager mediaLayerManager = getMediaLayerManager();
        CommonUnionID Q1 = Q1();
        Intrinsics.checkNotNull(Q1);
        mediaLayerManager.fetchMediaLayerInfo(Q1, requestBean.getLLoc(), "", 0, new b(requestBean));
    }
}
