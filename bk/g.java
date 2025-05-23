package bk;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellIntimateSpaceInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.reborn.base.n;
import com.qzone.reborn.intimate.request.QZoneIntimateDoCommentRequest;
import com.qzone.reborn.intimate.request.QZoneIntimateDoReplyRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceWriter$StDoCommentRsp;
import qzone.QZIntimateSpaceWriter$StDoReplyRsp;
import qzone.QZoneBaseCommon$StCommonExt;
import qzone.QZoneBaseMeta$StComment;
import qzone.QZoneBaseMeta$StReply;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015JB\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\n2\u0006\u0010\f\u001a\u00020\u0002H\u0002J.\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\nJ0\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\nJ8\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\n2\u0006\u0010\f\u001a\u00020\u0002J6\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\nJ8\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\n\u00a8\u0006\u0016"}, d2 = {"Lbk/g;", "", "", "contextHashCode", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "businessFeedData", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "comment", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "reply", "Lcom/qzone/reborn/base/n$a;", "dataCallback", "actionType", "", "g", "b", "d", "f", "c", "e", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class g {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J4\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"bk/g$a", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Lqzone/QZIntimateSpaceWriter$StDoCommentRsp;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "", "isSuccess", "", "retCode", "", "errMsg", "rsp", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class a implements VSDispatchObserver.OnVSRspCallBack<QZIntimateSpaceWriter$StDoCommentRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n.a<Comment> f28499a;

        a(n.a<Comment> aVar) {
            this.f28499a = aVar;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest request, boolean isSuccess, long retCode, String errMsg, QZIntimateSpaceWriter$StDoCommentRsp rsp) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            if (isSuccess && rsp != null && retCode == 0) {
                oj.a aVar = oj.a.f423008a;
                QZoneBaseMeta$StComment qZoneBaseMeta$StComment = rsp.comment;
                QZoneBaseCommon$StCommonExt qZoneBaseCommon$StCommonExt = rsp.ext_info;
                Intrinsics.checkNotNullExpressionValue(qZoneBaseCommon$StCommonExt, "rsp.ext_info");
                this.f28499a.onSuccess(aVar.P(qZoneBaseMeta$StComment, qZoneBaseCommon$StCommonExt), retCode, errMsg, true);
                return;
            }
            this.f28499a.onFailure(retCode, errMsg);
        }
    }

    private final void g(int contextHashCode, BusinessFeedData businessFeedData, Comment comment, Reply reply, final n.a<Reply> dataCallback, int actionType) {
        CellFeedCommInfo feedCommInfo = businessFeedData.getFeedCommInfo();
        String spaceId = businessFeedData.cellIntimateSpaceInfo.spaceId;
        if (feedCommInfo == null || comment == null) {
            return;
        }
        if (spaceId == null || spaceId.length() == 0) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(spaceId, "spaceId");
        VSNetworkHelper.getInstance().sendRequest(contextHashCode, new QZoneIntimateDoReplyRequest(businessFeedData, spaceId, comment, reply, actionType), new VSDispatchObserver.OnVSRspCallBack() { // from class: bk.f
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                g.h(n.a.this, baseRequest, z16, j3, str, (QZIntimateSpaceWriter$StDoReplyRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(n.a dataCallback, BaseRequest baseRequest, boolean z16, long j3, String errMsg, QZIntimateSpaceWriter$StDoReplyRsp qZIntimateSpaceWriter$StDoReplyRsp) {
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        if (z16 && qZIntimateSpaceWriter$StDoReplyRsp != null && j3 == 0) {
            oj.a aVar = oj.a.f423008a;
            QZoneBaseMeta$StReply qZoneBaseMeta$StReply = qZIntimateSpaceWriter$StDoReplyRsp.reply;
            QZoneBaseCommon$StCommonExt qZoneBaseCommon$StCommonExt = qZIntimateSpaceWriter$StDoReplyRsp.ext_info;
            Intrinsics.checkNotNullExpressionValue(qZoneBaseCommon$StCommonExt, "rsp.ext_info");
            Reply Z = aVar.Z(qZoneBaseMeta$StReply, qZoneBaseCommon$StCommonExt);
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            dataCallback.onSuccess(Z, j3, errMsg, true);
            return;
        }
        dataCallback.onFailure(j3, errMsg);
    }

    public final void b(int contextHashCode, BusinessFeedData businessFeedData, Comment comment, n.a<Comment> dataCallback) {
        Intrinsics.checkNotNullParameter(businessFeedData, "businessFeedData");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        f(contextHashCode, businessFeedData, comment, dataCallback, 1);
    }

    public final void c(int contextHashCode, BusinessFeedData businessFeedData, Comment comment, Reply reply, n.a<Reply> dataCallback) {
        Intrinsics.checkNotNullParameter(businessFeedData, "businessFeedData");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(reply, "reply");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        g(contextHashCode, businessFeedData, comment, reply, dataCallback, 1);
    }

    public final void d(int contextHashCode, BusinessFeedData businessFeedData, Comment comment, n.a<Comment> dataCallback) {
        Intrinsics.checkNotNullParameter(businessFeedData, "businessFeedData");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        f(contextHashCode, businessFeedData, comment, dataCallback, ef.b.h(businessFeedData) ? 2 : 0);
    }

    public final void e(int contextHashCode, BusinessFeedData businessFeedData, Comment comment, Reply reply, n.a<Reply> dataCallback) {
        Intrinsics.checkNotNullParameter(businessFeedData, "businessFeedData");
        Intrinsics.checkNotNullParameter(reply, "reply");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        g(contextHashCode, businessFeedData, comment, reply, dataCallback, ef.b.h(businessFeedData) ? 2 : 0);
    }

    public final void f(int contextHashCode, BusinessFeedData businessFeedData, Comment comment, n.a<Comment> dataCallback, int actionType) {
        Intrinsics.checkNotNullParameter(businessFeedData, "businessFeedData");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        CellFeedCommInfo feedCommInfo = businessFeedData.getFeedCommInfo();
        CellIntimateSpaceInfo cellIntimateSpaceInfo = businessFeedData.cellIntimateSpaceInfo;
        String str = cellIntimateSpaceInfo != null ? cellIntimateSpaceInfo.spaceId : null;
        if (feedCommInfo == null || comment == null) {
            return;
        }
        if (str == null || str.length() == 0) {
            return;
        }
        VSNetworkHelper.getInstance().sendRequest(contextHashCode, new QZoneIntimateDoCommentRequest(businessFeedData, str, comment, actionType), new a(dataCallback));
    }
}
