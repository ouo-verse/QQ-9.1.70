package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service;

import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCommentKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonReply;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonReplyKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionIDKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUserKt;
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
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.UnionID;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.CloneBatchMediaRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.GetLayerTailPageRecommendRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.GetMediaLayerRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.QzoneDeleteAlbumMediaRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.QzoneEditBatchMediaRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.QzoneLayerAddCommentRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.QzoneLayerAddReplyRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.QzoneLayerDeleteCommentRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.QzoneLayerDeleteReplyRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.QzoneLayerDoLikeRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.QzoneLayerUnlikeRequest;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 >2\u00020\u0001:\u0001>B\u0005\u00a2\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ8\u0010\u0010\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eJN\u0010\u0014\u001a\u00020\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u001c2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000eJ0\u0010\u001e\u001a\u00020\u00042\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00162\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160\u00182\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020!0\u000eJ0\u0010\"\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020#0\u000eJ8\u0010$\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020%0\u000eJ.\u0010&\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020(0\u000eJD\u0010)\u001a\u00020\u00042\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00162\u0012\b\u0002\u0010*\u001a\f\u0012\b\u0012\u00060+j\u0002`,0\u00182\u000e\b\u0002\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00182\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020/0\u000eJ$\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u0002032\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002040\u000eJ8\u00105\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u00162\n\u00108\u001a\u00060+j\u0002`92\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020:0\u000eJ\b\u0010;\u001a\u00020\u0016H\u0016J.\u0010<\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020=0\u000e\u00a8\u0006?"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneMediaLayerService;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneBaseService;", "()V", "addComment", "", CommonConstant.KEY_UNION_ID, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "comment", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "isPrivate", "", "overlayInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/OverlayInfo;", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/AddCommentRsp;", "addReply", "reply", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/AddReplyRsp;", "cloneBatchMedia", "srcAlbumid", "", "srcMediaIds", "", "dstAlbumid", "albumOwner", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/UnionID;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commwriter/media_commwriter/CloneBatchMediaRsp;", "deleteAlbumMedia", "albumId", "mediaIdList", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commwriter/media_commwriter/DeleteAlbumMediaRsp;", "deleteComment", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/DeleteCommentRsp;", "deleteReply", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/DeleteReplyRsp;", "doLike", "likeKey", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/DoLikeRsp;", "editBatchMedia", "operations", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commwriter/media_commwriter/EditPhotoOperaType;", "editPhotoList", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commwriter/media_commwriter/EditPhoto;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commwriter/media_commwriter/EditBatchMediaRsp;", "fetchLayerTailPageRecommendReq", "currentAlbumId", "owner", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commreader/media_commreader/GetLayerTailpageRecommendRsp;", "fetchMediaLayerInfo", "lloc", "attachInfo", WinkDaTongReportConstant.ElementParamValue.BOTTOM_TAB_SWITCH_TYPE_SLIDE, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/MediaLayerSlideType;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetMediaLayerRsp;", "getLogTag", "unlike", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/UnLikeRsp;", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneMediaLayerService extends QzoneBaseService {
    public static final int $stable = 0;
    public static final String TAG = "QzoneMediaLayerService";

    public final void addComment(CommonUnionID unionId, CommonComment comment, boolean isPrivate, OverlayInfo overlayInfo, DataCallback<AddCommentRsp> dataCallback) {
        KLog.INSTANCE.i(TAG, "addComment unionId: " + unionId + ", comment: " + comment.getId());
        if (unionId == null) {
            return;
        }
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new QzoneLayerAddCommentRequest(null, CommonUnionIDKt.toPb(unionId), CommonCommentKt.toPb(comment), isPrivate, overlayInfo), dataCallback, null, 4, null);
    }

    public final void addReply(CommonUnionID unionId, CommonComment comment, CommonReply reply, OverlayInfo overlayInfo, DataCallback<AddReplyRsp> dataCallback) {
        KLog.INSTANCE.i(TAG, "addReply unionId: " + unionId + ", comment: " + comment.getId());
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new QzoneLayerAddReplyRequest(null, CommonUnionIDKt.toPb(unionId), CommonCommentKt.toPb(comment), CommonReplyKt.toPb(reply), overlayInfo), dataCallback, null, 4, null);
    }

    public final void cloneBatchMedia(String srcAlbumid, List<String> srcMediaIds, String dstAlbumid, StUser albumOwner, UnionID unionId, DataCallback<CloneBatchMediaRsp> dataCallback) {
        KLog.INSTANCE.i(QzoneFeedWriteService.TAG, QUISkinImage$$ExternalSyntheticOutline0.m("cloneBatchMedia srcAlbumid:", srcAlbumid, ",dstAlbumid:", dstAlbumid));
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new CloneBatchMediaRequest(srcAlbumid, srcMediaIds, dstAlbumid, albumOwner, unionId), dataCallback, null, 4, null);
    }

    public final void deleteAlbumMedia(String albumId, List<String> mediaIdList, DataCallback<DeleteAlbumMediaRsp> dataCallback) {
        KLog.INSTANCE.i(TAG, "deleteAlbumMedia albumId: " + albumId + ", mediaIdList: " + mediaIdList);
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new QzoneDeleteAlbumMediaRequest(albumId, mediaIdList), dataCallback, null, 4, null);
    }

    public final void deleteComment(CommonUnionID unionId, CommonComment comment, OverlayInfo overlayInfo, DataCallback<DeleteCommentRsp> dataCallback) {
        KLog.INSTANCE.i(TAG, "deleteComment unionId: " + unionId + ", comment: " + comment.getId());
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new QzoneLayerDeleteCommentRequest(null, CommonUnionIDKt.toPb(unionId), CommonCommentKt.toPb(comment), overlayInfo), dataCallback, null, 4, null);
    }

    public final void deleteReply(CommonUnionID unionId, CommonComment comment, CommonReply reply, OverlayInfo overlayInfo, DataCallback<DeleteReplyRsp> dataCallback) {
        KLog.INSTANCE.i(TAG, "deleteReply unionId: " + unionId + ", comment: " + comment.getId());
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new QzoneLayerDeleteReplyRequest(null, CommonUnionIDKt.toPb(unionId), CommonCommentKt.toPb(comment), CommonReplyKt.toPb(reply), overlayInfo), dataCallback, null, 4, null);
    }

    public final void doLike(CommonUnionID unionId, String likeKey, OverlayInfo overlayInfo, DataCallback<DoLikeRsp> dataCallback) {
        KLog.INSTANCE.i(TAG, "doLike unionId: " + unionId + ", likeKey: " + likeKey);
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new QzoneLayerDoLikeRequest(likeKey, CommonUnionIDKt.toPb(unionId), overlayInfo), dataCallback, null, 4, null);
    }

    public final void editBatchMedia(String albumId, List<Integer> operations, List<EditPhoto> editPhotoList, DataCallback<EditBatchMediaRsp> dataCallback) {
        KLog.INSTANCE.i(TAG, "editBatchMedia albumId: " + albumId + ", operations: " + operations + ", editPhotoList: " + editPhotoList);
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new QzoneEditBatchMediaRequest(albumId, operations, editPhotoList), dataCallback, null, 4, null);
    }

    public final void fetchLayerTailPageRecommendReq(String currentAlbumId, CommonUser owner, DataCallback<GetLayerTailpageRecommendRsp> dataCallback) {
        KLog.INSTANCE.i(TAG, "getLayerTailPageRecommendReq currentAlbumId: " + currentAlbumId + ", user: " + owner);
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new GetLayerTailPageRecommendRequest(currentAlbumId, CommonUserKt.toPb(owner)), dataCallback, null, 4, null);
    }

    public final void fetchMediaLayerInfo(CommonUnionID unionId, String lloc, String attachInfo, int slide, DataCallback<GetMediaLayerRsp> dataCallback) {
        KLog.INSTANCE.i(TAG, "fetchMediaLayerInfo attachInfo: " + attachInfo);
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new GetMediaLayerRequest(CommonUnionIDKt.toPb(unionId), lloc, attachInfo, slide), dataCallback, null, 4, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService
    public String getLogTag() {
        return TAG;
    }

    public final void unlike(CommonUnionID unionId, String likeKey, OverlayInfo overlayInfo, DataCallback<UnLikeRsp> dataCallback) {
        KLog.INSTANCE.i(TAG, "unlike unionId: " + unionId + ", likeKey: " + likeKey);
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new QzoneLayerUnlikeRequest(likeKey, CommonUnionIDKt.toPb(unionId), overlayInfo), dataCallback, null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void deleteAlbumMedia$default(QzoneMediaLayerService qzoneMediaLayerService, String str, List list, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 2) != 0) {
            list = new ArrayList();
        }
        qzoneMediaLayerService.deleteAlbumMedia(str, list, dataCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void editBatchMedia$default(QzoneMediaLayerService qzoneMediaLayerService, String str, List list, List list2, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 2) != 0) {
            list = new ArrayList();
        }
        if ((i3 & 4) != 0) {
            list2 = new ArrayList();
        }
        qzoneMediaLayerService.editBatchMedia(str, list, list2, dataCallback);
    }

    public static /* synthetic */ void cloneBatchMedia$default(QzoneMediaLayerService qzoneMediaLayerService, String str, List list, String str2, StUser stUser, UnionID unionID, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        String str3 = str;
        if ((i3 & 2) != 0) {
            list = new ArrayList();
        }
        qzoneMediaLayerService.cloneBatchMedia(str3, list, str2, stUser, unionID, dataCallback);
    }

    public static /* synthetic */ void addComment$default(QzoneMediaLayerService qzoneMediaLayerService, CommonUnionID commonUnionID, CommonComment commonComment, boolean z16, OverlayInfo overlayInfo, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        qzoneMediaLayerService.addComment(commonUnionID, commonComment, z16, overlayInfo, dataCallback);
    }
}
