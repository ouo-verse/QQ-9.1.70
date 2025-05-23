package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager;

import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.consts.QzoneDataUpdateAction;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCommentKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonReply;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonReplyKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneCommentEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneEventBus;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneReplyEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetMediaLayerRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.AddCommentRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.AddReplyRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.DeleteCommentRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.DeleteReplyRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.DoLikeRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.OverlayInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.UnLikeRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader.GetLayerTailpageRecommendRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commwriter.media_commwriter.CloneBatchMediaRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commwriter.media_commwriter.DeleteAlbumMediaRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commwriter.media_commwriter.EditBatchMediaRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commwriter.media_commwriter.EditPhoto;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StReply;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.UnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneMediaLayerService;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c4\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 G2\u00020\u0001:\u0001GB\u0005\u00a2\u0006\u0002\u0010\u0002JS\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u00a2\u0006\u0002\u0010\u0016JQ\u0010\u0017\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0014\u00a2\u0006\u0002\u0010\u001bJN\u0010\u001c\u001a\u00020\u00062\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0 2\b\u0010!\u001a\u0004\u0018\u00010\u001e2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\t\u001a\u0004\u0018\u00010$2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020%0\u0014J0\u0010&\u001a\u00020\u00062\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001e2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001e0 2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020)0\u0014JI\u0010*\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020+0\u0014\u00a2\u0006\u0002\u0010,JQ\u0010-\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020.0\u0014\u00a2\u0006\u0002\u0010\u001bJG\u0010/\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u00100\u001a\u00020\u001e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002010\u0014\u00a2\u0006\u0002\u00102JD\u00103\u001a\u00020\u00062\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001e2\u0012\b\u0002\u00104\u001a\f\u0012\b\u0012\u000605j\u0002`60 2\u000e\b\u0002\u00107\u001a\b\u0012\u0004\u0012\u0002080 2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002090\u0014J$\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020=2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020>0\u0014J8\u0010?\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010@\u001a\u00020\u001e2\u0006\u0010A\u001a\u00020\u001e2\n\u0010B\u001a\u000605j\u0002`C2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020D0\u0014JG\u0010E\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u00100\u001a\u00020\u001e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020F0\u0014\u00a2\u0006\u0002\u00102R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006H"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneMediaLayerManager;", "", "()V", "mediaService", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneMediaLayerService;", "addComment", "", "commonFeed", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", CommonConstant.KEY_UNION_ID, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "comment", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "isPrivate", "", "overlayInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/OverlayInfo;", "batchId", "", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/AddCommentRsp;", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;ZLcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/OverlayInfo;Ljava/lang/Long;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;)V", "addReply", "reply", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/AddReplyRsp;", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/OverlayInfo;Ljava/lang/Long;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;)V", "cloneBatchMedia", "srcAlbumid", "", "srcMediaIds", "", "dstAlbumid", "albumOwner", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/UnionID;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commwriter/media_commwriter/CloneBatchMediaRsp;", "deleteAlbumMedia", "albumId", "mediaIdList", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commwriter/media_commwriter/DeleteAlbumMediaRsp;", "deleteComment", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/DeleteCommentRsp;", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/OverlayInfo;Ljava/lang/Long;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;)V", "deleteReply", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/DeleteReplyRsp;", "doLike", "likeKey", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/DoLikeRsp;", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;Ljava/lang/String;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/OverlayInfo;Ljava/lang/Long;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;)V", "editBatchMedia", "operations", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commwriter/media_commwriter/EditPhotoOperaType;", "editPhotoList", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commwriter/media_commwriter/EditPhoto;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commwriter/media_commwriter/EditBatchMediaRsp;", "fetchLayerTailPageRecommendReq", "currentAlbumId", "owner", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commreader/media_commreader/GetLayerTailpageRecommendRsp;", "fetchMediaLayerInfo", "lloc", "attachInfo", WinkDaTongReportConstant.ElementParamValue.BOTTOM_TAB_SWITCH_TYPE_SLIDE, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/MediaLayerSlideType;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetMediaLayerRsp;", "unlike", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/UnLikeRsp;", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneMediaLayerManager {
    public static final String TAG = "QzoneMediaLayerManager";
    private QzoneMediaLayerService mediaService = new QzoneMediaLayerService();
    public static final int $stable = 8;

    public final void addComment(final CommonFeed commonFeed, final CommonUnionID unionId, CommonComment comment, boolean isPrivate, final OverlayInfo overlayInfo, final Long batchId, final DataCallback<AddCommentRsp> dataCallback) {
        this.mediaService.addComment(unionId, comment, isPrivate, overlayInfo, new DataCallback<AddCommentRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneMediaLayerManager$addComment$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                dataCallback.onFailure(errorCode, errorMsg);
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(AddCommentRsp t16, long retCode, String msg2, boolean isFinish) {
                dataCallback.onSuccess(t16, retCode, msg2, isFinish);
                KLog.INSTANCE.i(QzoneMediaLayerManager.TAG, "addComment succeed");
                StComment stComment = t16.comment;
                CommonComment common2 = stComment != null ? CommonCommentKt.toCommon(stComment) : null;
                if (unionId == null || common2 == null || overlayInfo == null || !CommonFeedExtKt.isBatchIdEqual(commonFeed, batchId)) {
                    return;
                }
                QzoneEventBus.INSTANCE.postEvent(new QzoneCommentEvent(QzoneDataUpdateAction.ADD_COMMENT, unionId, common2, overlayInfo.lloc));
            }
        });
    }

    public final void addReply(final CommonFeed commonFeed, CommonUnionID unionId, final CommonComment comment, CommonReply reply, final OverlayInfo overlayInfo, final Long batchId, final DataCallback<AddReplyRsp> dataCallback) {
        this.mediaService.addReply(unionId, comment, reply, overlayInfo, new DataCallback<AddReplyRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneMediaLayerManager$addReply$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                dataCallback.onFailure(errorCode, errorMsg);
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(AddReplyRsp t16, long retCode, String msg2, boolean isFinish) {
                CommonCellCommon cellCommon;
                dataCallback.onSuccess(t16, retCode, msg2, isFinish);
                KLog.INSTANCE.i(QzoneMediaLayerManager.TAG, "addReply succeed");
                CommonFeed commonFeed2 = commonFeed;
                CommonUnionID unionId2 = (commonFeed2 == null || (cellCommon = commonFeed2.getCellCommon()) == null) ? null : cellCommon.getUnionId();
                StReply stReply = t16.reply;
                CommonReply common2 = stReply != null ? CommonReplyKt.toCommon(stReply) : null;
                CommonFeed commonFeed3 = commonFeed;
                if (commonFeed3 == null || unionId2 == null || common2 == null || overlayInfo == null || !CommonFeedExtKt.isBatchIdEqual(commonFeed3, batchId)) {
                    return;
                }
                QzoneEventBus.INSTANCE.postEvent(new QzoneReplyEvent(QzoneDataUpdateAction.ADD_REPLY, unionId2, comment, common2, overlayInfo.lloc));
            }
        });
    }

    public final void cloneBatchMedia(String srcAlbumid, List<String> srcMediaIds, String dstAlbumid, StUser albumOwner, UnionID unionId, DataCallback<CloneBatchMediaRsp> dataCallback) {
        this.mediaService.cloneBatchMedia(srcAlbumid, srcMediaIds, dstAlbumid, albumOwner, unionId, dataCallback);
    }

    public final void deleteAlbumMedia(String albumId, List<String> mediaIdList, DataCallback<DeleteAlbumMediaRsp> dataCallback) {
        this.mediaService.deleteAlbumMedia(albumId, mediaIdList, dataCallback);
    }

    public final void deleteComment(final CommonFeed commonFeed, final CommonUnionID unionId, final CommonComment comment, final OverlayInfo overlayInfo, final Long batchId, final DataCallback<DeleteCommentRsp> dataCallback) {
        this.mediaService.deleteComment(unionId, comment, overlayInfo, new DataCallback<DeleteCommentRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneMediaLayerManager$deleteComment$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                dataCallback.onFailure(errorCode, errorMsg);
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(DeleteCommentRsp t16, long retCode, String msg2, boolean isFinish) {
                dataCallback.onSuccess(t16, retCode, msg2, isFinish);
                KLog.INSTANCE.i(QzoneMediaLayerManager.TAG, "deleteComment succeed");
                if (unionId == null || overlayInfo == null || !CommonFeedExtKt.isBatchIdEqual(commonFeed, batchId)) {
                    return;
                }
                QzoneEventBus.INSTANCE.postEvent(new QzoneCommentEvent(QzoneDataUpdateAction.DELETE_COMMENT, unionId, comment, overlayInfo.lloc));
            }
        });
    }

    public final void doLike(final CommonFeed commonFeed, CommonUnionID unionId, String likeKey, final OverlayInfo overlayInfo, final Long batchId, final DataCallback<DoLikeRsp> dataCallback) {
        this.mediaService.doLike(unionId, likeKey, overlayInfo, new DataCallback<DoLikeRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneMediaLayerManager$doLike$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                dataCallback.onFailure(errorCode, errorMsg);
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(DoLikeRsp t16, long retCode, String msg2, boolean isFinish) {
                CommonFeed commonFeed2;
                dataCallback.onSuccess(t16, retCode, msg2, isFinish);
                KLog.INSTANCE.i(QzoneMediaLayerManager.TAG, "doLike succeed");
                if (overlayInfo == null || (commonFeed2 = commonFeed) == null || !CommonFeedExtKt.isBatchIdEqual(commonFeed2, batchId)) {
                    return;
                }
                QzoneFeedLikeManager.INSTANCE.updateStatusAndNotify(commonFeed, true, overlayInfo.lloc);
            }
        });
    }

    public final void editBatchMedia(String albumId, List<Integer> operations, List<EditPhoto> editPhotoList, DataCallback<EditBatchMediaRsp> dataCallback) {
        this.mediaService.editBatchMedia(albumId, operations, editPhotoList, dataCallback);
    }

    public final void fetchLayerTailPageRecommendReq(String currentAlbumId, CommonUser owner, DataCallback<GetLayerTailpageRecommendRsp> dataCallback) {
        this.mediaService.fetchLayerTailPageRecommendReq(currentAlbumId, owner, dataCallback);
    }

    public final void fetchMediaLayerInfo(CommonUnionID unionId, String lloc, String attachInfo, int slide, DataCallback<GetMediaLayerRsp> dataCallback) {
        this.mediaService.fetchMediaLayerInfo(unionId, lloc, attachInfo, slide, dataCallback);
    }

    public final void unlike(final CommonFeed commonFeed, CommonUnionID unionId, String likeKey, final OverlayInfo overlayInfo, final Long batchId, final DataCallback<UnLikeRsp> dataCallback) {
        this.mediaService.unlike(unionId, likeKey, overlayInfo, new DataCallback<UnLikeRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneMediaLayerManager$unlike$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                dataCallback.onFailure(errorCode, errorMsg);
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(UnLikeRsp t16, long retCode, String msg2, boolean isFinish) {
                dataCallback.onSuccess(t16, retCode, msg2, isFinish);
                KLog.INSTANCE.i(QzoneMediaLayerManager.TAG, "unlike succeed");
                CommonFeed commonFeed2 = commonFeed;
                if (commonFeed2 == null || overlayInfo == null || !CommonFeedExtKt.isBatchIdEqual(commonFeed2, batchId)) {
                    return;
                }
                QzoneFeedLikeManager.INSTANCE.updateStatusAndNotify(commonFeed, false, overlayInfo.lloc);
            }
        });
    }

    public final void deleteReply(final CommonFeed commonFeed, final CommonUnionID unionId, final CommonComment comment, final CommonReply reply, final OverlayInfo overlayInfo, final Long batchId, final DataCallback<DeleteReplyRsp> dataCallback) {
        this.mediaService.deleteReply(unionId, comment, reply, overlayInfo, new DataCallback<DeleteReplyRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneMediaLayerManager$deleteReply$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                dataCallback.onFailure(errorCode, errorMsg);
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(DeleteReplyRsp t16, long retCode, String msg2, boolean isFinish) {
                dataCallback.onSuccess(t16, retCode, msg2, isFinish);
                KLog.INSTANCE.i(QzoneMediaLayerManager.TAG, "deleteReply succeed");
                if (unionId == null || overlayInfo == null || !CommonFeedExtKt.isBatchIdEqual(commonFeed, batchId)) {
                    return;
                }
                QzoneEventBus.INSTANCE.postEvent(new QzoneReplyEvent(QzoneDataUpdateAction.DELETE_REPLY, unionId, comment, reply, overlayInfo.lloc));
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void deleteAlbumMedia$default(QzoneMediaLayerManager qzoneMediaLayerManager, String str, List list, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 2) != 0) {
            list = new ArrayList();
        }
        qzoneMediaLayerManager.deleteAlbumMedia(str, list, dataCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void editBatchMedia$default(QzoneMediaLayerManager qzoneMediaLayerManager, String str, List list, List list2, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 2) != 0) {
            list = new ArrayList();
        }
        if ((i3 & 4) != 0) {
            list2 = new ArrayList();
        }
        qzoneMediaLayerManager.editBatchMedia(str, list, list2, dataCallback);
    }

    public static /* synthetic */ void cloneBatchMedia$default(QzoneMediaLayerManager qzoneMediaLayerManager, String str, List list, String str2, StUser stUser, UnionID unionID, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        String str3 = str;
        if ((i3 & 2) != 0) {
            list = new ArrayList();
        }
        qzoneMediaLayerManager.cloneBatchMedia(str3, list, str2, stUser, unionID, dataCallback);
    }
}
