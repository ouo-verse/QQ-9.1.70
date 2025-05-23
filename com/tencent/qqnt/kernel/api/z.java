package com.tencent.qqnt.kernel.api;

import com.qzone.album.protocol.QZoneOptAlbumRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceAddAlbumPermissionsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceAddCommentCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceAddReplyCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceCloneBatchMediaCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceCreateAlbumCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceDeleteAlbumCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceDeleteAlbumMediaCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceDeleteCommentCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceDeleteReplyCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceDoLikeCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceEditAlbumCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceEditBatchMediaCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceEditTravelAlbumScenceCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceForwardAlbumToQzoneCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetAlbumInviteJoinPageCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetAlbumJoinApprovalPageCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetAlbumListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetAlbumMemberListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetCommentListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetLayerTailpageRecommendCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetPhotoListByTimeLineCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetPhotoListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetPhotoTabByTimeLineCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetPhotoTabCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetShareInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetVideoTabByTimeLineCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetVideoTabCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceJoinShareAlbumCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceMoveBatchPhotoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceQueryAlbumCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceRemoveAlbumMemberCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceRespondToJoinRequestCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceSendAlbumInvitationCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceSortPicCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceUnLikeCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceUpdateAlbumMemberCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceVerifyAlbumQuestionCallback;
import com.tencent.qqnt.kernel.nativeinterface.PAAddAlbumPermissionsReq;
import com.tencent.qqnt.kernel.nativeinterface.PAAddCommentReq;
import com.tencent.qqnt.kernel.nativeinterface.PAAddReplyReq;
import com.tencent.qqnt.kernel.nativeinterface.PACloneBatchMediaReq;
import com.tencent.qqnt.kernel.nativeinterface.PACreateAlbumReq;
import com.tencent.qqnt.kernel.nativeinterface.PADeleteAlbumMediaReq;
import com.tencent.qqnt.kernel.nativeinterface.PADeleteAlbumReq;
import com.tencent.qqnt.kernel.nativeinterface.PADeleteCommentReq;
import com.tencent.qqnt.kernel.nativeinterface.PADeleteReplyReq;
import com.tencent.qqnt.kernel.nativeinterface.PADoLikeReq;
import com.tencent.qqnt.kernel.nativeinterface.PAEditAlbumReq;
import com.tencent.qqnt.kernel.nativeinterface.PAEditBatchMediaReq;
import com.tencent.qqnt.kernel.nativeinterface.PAEditTravelAlbumScenceReq;
import com.tencent.qqnt.kernel.nativeinterface.PAForwardAlbumToQzoneReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetAlbumInviteJoinPageReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetAlbumJoinApprovalPageReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetAlbumListReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetAlbumMemberListReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetCommentListReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetLayerTailpageRecommendReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetPhotoListByTimeLineReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetPhotoListReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetPhotoTabByTimeLineReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetPhotoTabReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetShareInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetVideoTabByTimeLineReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetVideoTabReq;
import com.tencent.qqnt.kernel.nativeinterface.PAJoinShareAlbumReq;
import com.tencent.qqnt.kernel.nativeinterface.PAMoveBatchPhotoReq;
import com.tencent.qqnt.kernel.nativeinterface.PAQueryAlbumReq;
import com.tencent.qqnt.kernel.nativeinterface.PARemoveAlbumMemberReq;
import com.tencent.qqnt.kernel.nativeinterface.PARespondToJoinRequestReq;
import com.tencent.qqnt.kernel.nativeinterface.PASendAlbumInvitationReq;
import com.tencent.qqnt.kernel.nativeinterface.PASortPicReq;
import com.tencent.qqnt.kernel.nativeinterface.PAUnLikeReq;
import com.tencent.qqnt.kernel.nativeinterface.PAUpdateAlbumMemberReq;
import com.tencent.qqnt.kernel.nativeinterface.PAVerifyAlbumQuestionReq;
import cooperation.qzone.QZoneHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&J\u001c\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u001c\u0010\u0010\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\u000fH&J\u001c\u0010\u0013\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\u0012H&J\u001c\u0010\u0016\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\u0015H&J\u001c\u0010\u0019\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00172\b\u0010\u000b\u001a\u0004\u0018\u00010\u0018H&J\u001c\u0010\u001c\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u001a2\b\u0010\u000b\u001a\u0004\u0018\u00010\u001bH&J\u001c\u0010\u001f\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u001d2\b\u0010\u000b\u001a\u0004\u0018\u00010\u001eH&J\u001c\u0010\"\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010 2\b\u0010\u000b\u001a\u0004\u0018\u00010!H&J\u001c\u0010%\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010#2\b\u0010\u000b\u001a\u0004\u0018\u00010$H&J\u001c\u0010(\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010&2\b\u0010\u000b\u001a\u0004\u0018\u00010'H&J\u001c\u0010+\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010)2\b\u0010\u000b\u001a\u0004\u0018\u00010*H&J\u001c\u0010.\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010,2\b\u0010\u000b\u001a\u0004\u0018\u00010-H&J\u001c\u00101\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010/2\b\u0010\u000b\u001a\u0004\u0018\u000100H&J\u001c\u00104\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u0001022\b\u0010\u000b\u001a\u0004\u0018\u000103H&J\u001c\u00107\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u0001052\b\u0010\u000b\u001a\u0004\u0018\u000106H&J\u001c\u0010:\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u0001082\b\u0010\u000b\u001a\u0004\u0018\u000109H&J\u001c\u0010=\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010;2\b\u0010\u000b\u001a\u0004\u0018\u00010<H&J\u001c\u0010@\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010>2\b\u0010\u000b\u001a\u0004\u0018\u00010?H&J\u001c\u0010C\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010A2\b\u0010\u000b\u001a\u0004\u0018\u00010BH&J\u001c\u0010F\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010D2\b\u0010\u000b\u001a\u0004\u0018\u00010EH&J\u001c\u0010I\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010G2\b\u0010\u000b\u001a\u0004\u0018\u00010HH&J\u001c\u0010L\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010J2\b\u0010\u000b\u001a\u0004\u0018\u00010KH&J\u001c\u0010O\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010M2\b\u0010\u000b\u001a\u0004\u0018\u00010NH&J\u001c\u0010R\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010P2\b\u0010\u000b\u001a\u0004\u0018\u00010QH&J\u001c\u0010U\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010S2\b\u0010\u000b\u001a\u0004\u0018\u00010TH&J\u001c\u0010X\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010V2\b\u0010\u000b\u001a\u0004\u0018\u00010WH&J\u001c\u0010[\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010Y2\b\u0010\u000b\u001a\u0004\u0018\u00010ZH&J\u001c\u0010^\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\\2\b\u0010\u000b\u001a\u0004\u0018\u00010]H&J\u001c\u0010a\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010_2\b\u0010\u000b\u001a\u0004\u0018\u00010`H&J\u001c\u0010d\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010b2\b\u0010\u000b\u001a\u0004\u0018\u00010cH&J\u001c\u0010g\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010e2\b\u0010\u000b\u001a\u0004\u0018\u00010fH&J\u001c\u0010j\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010h2\b\u0010\u000b\u001a\u0004\u0018\u00010iH&J\u001c\u0010m\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010k2\b\u0010\u000b\u001a\u0004\u0018\u00010lH&J\u001c\u0010p\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010n2\b\u0010\u000b\u001a\u0004\u0018\u00010oH&J\u001c\u0010s\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010q2\b\u0010\u000b\u001a\u0004\u0018\u00010rH&J\u0018\u0010v\u001a\u00020\f2\u0006\u0010\t\u001a\u00020t2\u0006\u0010\u000b\u001a\u00020uH&J\u001c\u0010y\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010w2\b\u0010\u000b\u001a\u0004\u0018\u00010xH&\u00a8\u0006z"}, d2 = {"Lcom/tencent/qqnt/kernel/api/z;", "Lcom/tencent/qqnt/kernel/api/j;", "", "uin", "qua", "deviceInfo", "", "setAlbumServiceInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/PAQueryAlbumReq;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceQueryAlbumCallback;", "callback", "", "queryAlbum", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetAlbumListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetAlbumListCallback;", "getAlbumList", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetPhotoListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetPhotoListCallback;", QZoneHelper.QZoneAppConstants.REFER_PHOTO_LIST, "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetPhotoListByTimeLineReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetPhotoListByTimeLineCallback;", "getPhotoListByTimeLine", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetCommentListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetCommentListCallback;", "getCommentList", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetPhotoTabReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetPhotoTabCallback;", "getPhotoTab", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetPhotoTabByTimeLineReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetPhotoTabByTimeLineCallback;", "getPhotoTabByTimeLine", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetVideoTabReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetVideoTabCallback;", "getVideoTab", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetVideoTabByTimeLineReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetVideoTabByTimeLineCallback;", "getVideoTabByTimeLine", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetShareInfoReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetShareInfoCallback;", "getShareInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/PACreateAlbumReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceCreateAlbumCallback;", QZoneOptAlbumRequest.FIELD_CMD_CREATE, "Lcom/tencent/qqnt/kernel/nativeinterface/PAEditAlbumReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceEditAlbumCallback;", QZoneOptAlbumRequest.FIELD_CMD_EDIT, "Lcom/tencent/qqnt/kernel/nativeinterface/PADeleteAlbumReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceDeleteAlbumCallback;", "deleteAlbum", "Lcom/tencent/qqnt/kernel/nativeinterface/PASortPicReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceSortPicCallback;", "sortPic", "Lcom/tencent/qqnt/kernel/nativeinterface/PAMoveBatchPhotoReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceMoveBatchPhotoCallback;", "moveBatchPhoto", "Lcom/tencent/qqnt/kernel/nativeinterface/PAEditBatchMediaReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceEditBatchMediaCallback;", "editBatchMedia", "Lcom/tencent/qqnt/kernel/nativeinterface/PACloneBatchMediaReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceCloneBatchMediaCallback;", "cloneBatchMedia", "Lcom/tencent/qqnt/kernel/nativeinterface/PADeleteAlbumMediaReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceDeleteAlbumMediaCallback;", "deleteAlbumMedia", "Lcom/tencent/qqnt/kernel/nativeinterface/PAAddCommentReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceAddCommentCallback;", "addComment", "Lcom/tencent/qqnt/kernel/nativeinterface/PAAddReplyReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceAddReplyCallback;", "addReply", "Lcom/tencent/qqnt/kernel/nativeinterface/PADeleteCommentReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceDeleteCommentCallback;", "deleteComment", "Lcom/tencent/qqnt/kernel/nativeinterface/PADeleteReplyReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceDeleteReplyCallback;", "deleteReply", "Lcom/tencent/qqnt/kernel/nativeinterface/PADoLikeReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceDoLikeCallback;", "doLike", "Lcom/tencent/qqnt/kernel/nativeinterface/PAUnLikeReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceUnLikeCallback;", "unLike", "Lcom/tencent/qqnt/kernel/nativeinterface/PAAddAlbumPermissionsReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceAddAlbumPermissionsCallback;", "addAlbumPermissions", "Lcom/tencent/qqnt/kernel/nativeinterface/PAVerifyAlbumQuestionReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceVerifyAlbumQuestionCallback;", "verifyAlbumQuestion", "Lcom/tencent/qqnt/kernel/nativeinterface/PASendAlbumInvitationReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceSendAlbumInvitationCallback;", "sendAlbumInvitation", "Lcom/tencent/qqnt/kernel/nativeinterface/PAJoinShareAlbumReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceJoinShareAlbumCallback;", "joinShareAlbum", "Lcom/tencent/qqnt/kernel/nativeinterface/PARespondToJoinRequestReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceRespondToJoinRequestCallback;", "respondToJoinRequest", "Lcom/tencent/qqnt/kernel/nativeinterface/PAUpdateAlbumMemberReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceUpdateAlbumMemberCallback;", "updateAlbumMember", "Lcom/tencent/qqnt/kernel/nativeinterface/PARemoveAlbumMemberReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceRemoveAlbumMemberCallback;", "removeAlbumMember", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetAlbumJoinApprovalPageReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetAlbumJoinApprovalPageCallback;", "getAlbumJoinApprovalPage", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetAlbumInviteJoinPageReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetAlbumInviteJoinPageCallback;", "getAlbumInviteJoinPage", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetAlbumMemberListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetAlbumMemberListCallback;", "getAlbumMemberList", "Lcom/tencent/qqnt/kernel/nativeinterface/PAForwardAlbumToQzoneReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceForwardAlbumToQzoneCallback;", "forwardAlbumToQzone", "Lcom/tencent/qqnt/kernel/nativeinterface/PAEditTravelAlbumScenceReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceEditTravelAlbumScenceCallback;", "editTravelAlbumScence", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetLayerTailpageRecommendReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetLayerTailpageRecommendCallback;", "getLayerTailpageRecommend", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface z extends j {
    int addAlbumPermissions(@Nullable PAAddAlbumPermissionsReq request, @Nullable IPersonalAlbumServiceAddAlbumPermissionsCallback callback);

    int addComment(@Nullable PAAddCommentReq request, @Nullable IPersonalAlbumServiceAddCommentCallback callback);

    int addReply(@Nullable PAAddReplyReq request, @Nullable IPersonalAlbumServiceAddReplyCallback callback);

    int cloneBatchMedia(@Nullable PACloneBatchMediaReq request, @Nullable IPersonalAlbumServiceCloneBatchMediaCallback callback);

    int createAlbum(@Nullable PACreateAlbumReq request, @Nullable IPersonalAlbumServiceCreateAlbumCallback callback);

    int deleteAlbum(@Nullable PADeleteAlbumReq request, @Nullable IPersonalAlbumServiceDeleteAlbumCallback callback);

    int deleteAlbumMedia(@Nullable PADeleteAlbumMediaReq request, @Nullable IPersonalAlbumServiceDeleteAlbumMediaCallback callback);

    int deleteComment(@Nullable PADeleteCommentReq request, @Nullable IPersonalAlbumServiceDeleteCommentCallback callback);

    int deleteReply(@Nullable PADeleteReplyReq request, @Nullable IPersonalAlbumServiceDeleteReplyCallback callback);

    int doLike(@Nullable PADoLikeReq request, @Nullable IPersonalAlbumServiceDoLikeCallback callback);

    int editAlbum(@Nullable PAEditAlbumReq request, @Nullable IPersonalAlbumServiceEditAlbumCallback callback);

    int editBatchMedia(@Nullable PAEditBatchMediaReq request, @Nullable IPersonalAlbumServiceEditBatchMediaCallback callback);

    int editTravelAlbumScence(@NotNull PAEditTravelAlbumScenceReq request, @NotNull IPersonalAlbumServiceEditTravelAlbumScenceCallback callback);

    int forwardAlbumToQzone(@Nullable PAForwardAlbumToQzoneReq request, @Nullable IPersonalAlbumServiceForwardAlbumToQzoneCallback callback);

    int getAlbumInviteJoinPage(@Nullable PAGetAlbumInviteJoinPageReq request, @Nullable IPersonalAlbumServiceGetAlbumInviteJoinPageCallback callback);

    int getAlbumJoinApprovalPage(@Nullable PAGetAlbumJoinApprovalPageReq request, @Nullable IPersonalAlbumServiceGetAlbumJoinApprovalPageCallback callback);

    int getAlbumList(@Nullable PAGetAlbumListReq request, @Nullable IPersonalAlbumServiceGetAlbumListCallback callback);

    int getAlbumMemberList(@Nullable PAGetAlbumMemberListReq request, @Nullable IPersonalAlbumServiceGetAlbumMemberListCallback callback);

    int getCommentList(@Nullable PAGetCommentListReq request, @Nullable IPersonalAlbumServiceGetCommentListCallback callback);

    int getLayerTailpageRecommend(@Nullable PAGetLayerTailpageRecommendReq request, @Nullable IPersonalAlbumServiceGetLayerTailpageRecommendCallback callback);

    int getPhotoList(@Nullable PAGetPhotoListReq request, @Nullable IPersonalAlbumServiceGetPhotoListCallback callback);

    int getPhotoListByTimeLine(@Nullable PAGetPhotoListByTimeLineReq request, @Nullable IPersonalAlbumServiceGetPhotoListByTimeLineCallback callback);

    int getPhotoTab(@Nullable PAGetPhotoTabReq request, @Nullable IPersonalAlbumServiceGetPhotoTabCallback callback);

    int getPhotoTabByTimeLine(@Nullable PAGetPhotoTabByTimeLineReq request, @Nullable IPersonalAlbumServiceGetPhotoTabByTimeLineCallback callback);

    int getShareInfo(@Nullable PAGetShareInfoReq request, @Nullable IPersonalAlbumServiceGetShareInfoCallback callback);

    int getVideoTab(@Nullable PAGetVideoTabReq request, @Nullable IPersonalAlbumServiceGetVideoTabCallback callback);

    int getVideoTabByTimeLine(@Nullable PAGetVideoTabByTimeLineReq request, @Nullable IPersonalAlbumServiceGetVideoTabByTimeLineCallback callback);

    int joinShareAlbum(@Nullable PAJoinShareAlbumReq request, @Nullable IPersonalAlbumServiceJoinShareAlbumCallback callback);

    int moveBatchPhoto(@Nullable PAMoveBatchPhotoReq request, @Nullable IPersonalAlbumServiceMoveBatchPhotoCallback callback);

    int queryAlbum(@Nullable PAQueryAlbumReq request, @Nullable IPersonalAlbumServiceQueryAlbumCallback callback);

    int removeAlbumMember(@Nullable PARemoveAlbumMemberReq request, @Nullable IPersonalAlbumServiceRemoveAlbumMemberCallback callback);

    int respondToJoinRequest(@Nullable PARespondToJoinRequestReq request, @Nullable IPersonalAlbumServiceRespondToJoinRequestCallback callback);

    int sendAlbumInvitation(@Nullable PASendAlbumInvitationReq request, @Nullable IPersonalAlbumServiceSendAlbumInvitationCallback callback);

    void setAlbumServiceInfo(@Nullable String uin, @Nullable String qua, @Nullable String deviceInfo);

    int sortPic(@Nullable PASortPicReq request, @Nullable IPersonalAlbumServiceSortPicCallback callback);

    int unLike(@Nullable PAUnLikeReq request, @Nullable IPersonalAlbumServiceUnLikeCallback callback);

    int updateAlbumMember(@Nullable PAUpdateAlbumMemberReq request, @Nullable IPersonalAlbumServiceUpdateAlbumMemberCallback callback);

    int verifyAlbumQuestion(@Nullable PAVerifyAlbumQuestionReq request, @Nullable IPersonalAlbumServiceVerifyAlbumQuestionCallback callback);
}
