package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service;

import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCommentKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionIDKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetCommentRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetFeedDetailRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetRepliesRsp;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.QzoneGetFeedDetailCommentRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.QzoneGetFeedDetailRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.QzoneGetMoreRepliesRequest;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0002J/\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0000\u00a2\u0006\u0002\b\fJ+\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000f0\nH\u0000\u00a2\u0006\u0002\b\u0010JC\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00180\nH\u0000\u00a2\u0006\u0002\b\u0019J\b\u0010\u001a\u001a\u00020\bH\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneFeedDetailService;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneBaseService;", "()V", "fetchFeedDetail", "", CommonConstant.KEY_UNION_ID, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", ZPlanPublishSource.FROM_SCHEME, "", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetFeedDetailRsp;", "fetchFeedDetail$qecommerce_biz_release", "fetchFeedDetailComment", "attachInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetCommentRsp;", "fetchFeedDetailComment$qecommerce_biz_release", "fetchMoreReply", "commentAttachInfo", "curComment", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "replyAttachInfo", "pageSize", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetRepliesRsp;", "fetchMoreReply$qecommerce_biz_release", "getLogTag", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneFeedDetailService extends QzoneBaseService {
    public static final int $stable = 0;
    public static final String TAG = "QzoneFeedDetailService";

    public final void fetchFeedDetail$qecommerce_biz_release(CommonUnionID unionId, String scheme, DataCallback<GetFeedDetailRsp> dataCallback) {
        KLog.INSTANCE.i(TAG, "fetchFeedDetail unionId: " + unionId);
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new QzoneGetFeedDetailRequest(CommonUnionIDKt.toPb(unionId), scheme), dataCallback, null, 4, null);
    }

    public final void fetchFeedDetailComment$qecommerce_biz_release(CommonUnionID unionId, String attachInfo, DataCallback<GetCommentRsp> dataCallback) {
        KLog.INSTANCE.i(TAG, "fetchFeedDetailComment unionId: " + unionId + ", attachInfo: " + attachInfo);
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new QzoneGetFeedDetailCommentRequest(CommonUnionIDKt.toPb(unionId), attachInfo), dataCallback, null, 4, null);
    }

    public final void fetchMoreReply$qecommerce_biz_release(CommonUnionID unionId, String commentAttachInfo, CommonComment curComment, String replyAttachInfo, int pageSize, DataCallback<GetRepliesRsp> dataCallback) {
        KLog.INSTANCE.i(TAG, "fetchMoreReply unionId: " + unionId + ", commentAttachInfo: " + commentAttachInfo + ", curComment: " + curComment + ", replyAttachInfo: " + replyAttachInfo + ", pageSize: " + pageSize);
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new QzoneGetMoreRepliesRequest(CommonUnionIDKt.toPb(unionId), commentAttachInfo, CommonCommentKt.toPb(curComment), replyAttachInfo, pageSize), dataCallback, null, 4, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService
    public String getLogTag() {
        return TAG;
    }

    public static /* synthetic */ void fetchFeedDetail$qecommerce_biz_release$default(QzoneFeedDetailService qzoneFeedDetailService, CommonUnionID commonUnionID, String str, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        qzoneFeedDetailService.fetchFeedDetail$qecommerce_biz_release(commonUnionID, str, dataCallback);
    }
}
