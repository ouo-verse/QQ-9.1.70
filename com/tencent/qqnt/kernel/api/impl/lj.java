package com.tencent.qqnt.kernel.api.impl;

import com.qzone.album.protocol.QZoneOptAlbumRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService;
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
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00aa\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0086\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u0087\u0001B\u001e\u0012\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001\u00a2\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0010\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u0013\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0016\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010\u0019\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00172\b\u0010\u000f\u001a\u0004\u0018\u00010\u0018H\u0016J\u001c\u0010\u001c\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u001a2\b\u0010\u000f\u001a\u0004\u0018\u00010\u001bH\u0016J\u001c\u0010\u001f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u001d2\b\u0010\u000f\u001a\u0004\u0018\u00010\u001eH\u0016J\u001c\u0010\"\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010 2\b\u0010\u000f\u001a\u0004\u0018\u00010!H\u0016J\u001c\u0010%\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010#2\b\u0010\u000f\u001a\u0004\u0018\u00010$H\u0016J\u001c\u0010(\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010&2\b\u0010\u000f\u001a\u0004\u0018\u00010'H\u0016J\u001c\u0010+\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010)2\b\u0010\u000f\u001a\u0004\u0018\u00010*H\u0016J\u001c\u0010.\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010,2\b\u0010\u000f\u001a\u0004\u0018\u00010-H\u0016J\u001c\u00101\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010/2\b\u0010\u000f\u001a\u0004\u0018\u000100H\u0016J\u001c\u00104\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u0001022\b\u0010\u000f\u001a\u0004\u0018\u000103H\u0016J\u001c\u00107\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u0001052\b\u0010\u000f\u001a\u0004\u0018\u000106H\u0016J\u001c\u0010:\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u0001082\b\u0010\u000f\u001a\u0004\u0018\u000109H\u0016J\u001c\u0010=\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010;2\b\u0010\u000f\u001a\u0004\u0018\u00010<H\u0016J\u001c\u0010@\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010>2\b\u0010\u000f\u001a\u0004\u0018\u00010?H\u0016J\u001c\u0010C\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010A2\b\u0010\u000f\u001a\u0004\u0018\u00010BH\u0016J\u001c\u0010F\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010D2\b\u0010\u000f\u001a\u0004\u0018\u00010EH\u0016J\u001c\u0010I\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010G2\b\u0010\u000f\u001a\u0004\u0018\u00010HH\u0016J\u001c\u0010L\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010J2\b\u0010\u000f\u001a\u0004\u0018\u00010KH\u0016J\u001c\u0010O\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010M2\b\u0010\u000f\u001a\u0004\u0018\u00010NH\u0016J\u001c\u0010R\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010P2\b\u0010\u000f\u001a\u0004\u0018\u00010QH\u0016J\u001c\u0010U\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010S2\b\u0010\u000f\u001a\u0004\u0018\u00010TH\u0016J\u001c\u0010X\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010V2\b\u0010\u000f\u001a\u0004\u0018\u00010WH\u0016J\u001c\u0010[\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010Y2\b\u0010\u000f\u001a\u0004\u0018\u00010ZH\u0016J\u001c\u0010^\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\\2\b\u0010\u000f\u001a\u0004\u0018\u00010]H\u0016J\u001c\u0010a\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010_2\b\u0010\u000f\u001a\u0004\u0018\u00010`H\u0016J\u001c\u0010d\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010b2\b\u0010\u000f\u001a\u0004\u0018\u00010cH\u0016J\u001c\u0010g\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010e2\b\u0010\u000f\u001a\u0004\u0018\u00010fH\u0016J\u001c\u0010j\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010h2\b\u0010\u000f\u001a\u0004\u0018\u00010iH\u0016J\u001c\u0010m\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010k2\b\u0010\u000f\u001a\u0004\u0018\u00010lH\u0016J\u001c\u0010p\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010n2\b\u0010\u000f\u001a\u0004\u0018\u00010oH\u0016J\u001c\u0010s\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010q2\b\u0010\u000f\u001a\u0004\u0018\u00010rH\u0016J\u001c\u0010v\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010t2\b\u0010\u000f\u001a\u0004\u0018\u00010uH\u0016J\u0018\u0010y\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020w2\u0006\u0010\u000f\u001a\u00020xH\u0016J\u001c\u0010|\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010z2\b\u0010\u000f\u001a\u0004\u0018\u00010{H\u0016R\u0017\u0010\u0080\u0001\u001a\u00020}8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010\u007f\u00a8\u0006\u0088\u0001"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/lj;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelPersonalAlbumService;", "Lcom/tencent/qqnt/kernel/api/z;", "", "p4", "", "uin", "qua", "deviceInfo", "", "setAlbumServiceInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/PAQueryAlbumReq;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceQueryAlbumCallback;", "callback", "queryAlbum", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetAlbumListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetAlbumListCallback;", "getAlbumList", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetPhotoListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetPhotoListCallback;", QZoneHelper.QZoneAppConstants.REFER_PHOTO_LIST, "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetPhotoListByTimeLineReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetPhotoListByTimeLineCallback;", "getPhotoListByTimeLine", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetCommentListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetCommentListCallback;", "getCommentList", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetPhotoTabReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetPhotoTabCallback;", "getPhotoTab", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetPhotoTabByTimeLineReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetPhotoTabByTimeLineCallback;", "getPhotoTabByTimeLine", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetVideoTabReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetVideoTabCallback;", "getVideoTab", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetVideoTabByTimeLineReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetVideoTabByTimeLineCallback;", "getVideoTabByTimeLine", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetShareInfoReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetShareInfoCallback;", "getShareInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/PACreateAlbumReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceCreateAlbumCallback;", QZoneOptAlbumRequest.FIELD_CMD_CREATE, "Lcom/tencent/qqnt/kernel/nativeinterface/PAEditAlbumReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceEditAlbumCallback;", QZoneOptAlbumRequest.FIELD_CMD_EDIT, "Lcom/tencent/qqnt/kernel/nativeinterface/PADeleteAlbumReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceDeleteAlbumCallback;", "deleteAlbum", "Lcom/tencent/qqnt/kernel/nativeinterface/PASortPicReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceSortPicCallback;", "sortPic", "Lcom/tencent/qqnt/kernel/nativeinterface/PAMoveBatchPhotoReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceMoveBatchPhotoCallback;", "moveBatchPhoto", "Lcom/tencent/qqnt/kernel/nativeinterface/PAEditBatchMediaReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceEditBatchMediaCallback;", "editBatchMedia", "Lcom/tencent/qqnt/kernel/nativeinterface/PACloneBatchMediaReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceCloneBatchMediaCallback;", "cloneBatchMedia", "Lcom/tencent/qqnt/kernel/nativeinterface/PADeleteAlbumMediaReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceDeleteAlbumMediaCallback;", "deleteAlbumMedia", "Lcom/tencent/qqnt/kernel/nativeinterface/PAAddCommentReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceAddCommentCallback;", "addComment", "Lcom/tencent/qqnt/kernel/nativeinterface/PAAddReplyReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceAddReplyCallback;", "addReply", "Lcom/tencent/qqnt/kernel/nativeinterface/PADeleteCommentReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceDeleteCommentCallback;", "deleteComment", "Lcom/tencent/qqnt/kernel/nativeinterface/PADeleteReplyReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceDeleteReplyCallback;", "deleteReply", "Lcom/tencent/qqnt/kernel/nativeinterface/PADoLikeReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceDoLikeCallback;", "doLike", "Lcom/tencent/qqnt/kernel/nativeinterface/PAUnLikeReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceUnLikeCallback;", "unLike", "Lcom/tencent/qqnt/kernel/nativeinterface/PAAddAlbumPermissionsReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceAddAlbumPermissionsCallback;", "addAlbumPermissions", "Lcom/tencent/qqnt/kernel/nativeinterface/PAVerifyAlbumQuestionReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceVerifyAlbumQuestionCallback;", "verifyAlbumQuestion", "Lcom/tencent/qqnt/kernel/nativeinterface/PASendAlbumInvitationReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceSendAlbumInvitationCallback;", "sendAlbumInvitation", "Lcom/tencent/qqnt/kernel/nativeinterface/PAJoinShareAlbumReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceJoinShareAlbumCallback;", "joinShareAlbum", "Lcom/tencent/qqnt/kernel/nativeinterface/PARespondToJoinRequestReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceRespondToJoinRequestCallback;", "respondToJoinRequest", "Lcom/tencent/qqnt/kernel/nativeinterface/PAUpdateAlbumMemberReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceUpdateAlbumMemberCallback;", "updateAlbumMember", "Lcom/tencent/qqnt/kernel/nativeinterface/PARemoveAlbumMemberReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceRemoveAlbumMemberCallback;", "removeAlbumMember", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetAlbumJoinApprovalPageReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetAlbumJoinApprovalPageCallback;", "getAlbumJoinApprovalPage", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetAlbumInviteJoinPageReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetAlbumInviteJoinPageCallback;", "getAlbumInviteJoinPage", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetAlbumMemberListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetAlbumMemberListCallback;", "getAlbumMemberList", "Lcom/tencent/qqnt/kernel/nativeinterface/PAForwardAlbumToQzoneReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceForwardAlbumToQzoneCallback;", "forwardAlbumToQzone", "Lcom/tencent/qqnt/kernel/nativeinterface/PAEditTravelAlbumScenceReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceEditTravelAlbumScenceCallback;", "editTravelAlbumScence", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetLayerTailpageRecommendReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetLayerTailpageRecommendCallback;", "getLayerTailpageRecommend", "Ljava/util/concurrent/atomic/AtomicInteger;", "d", "Ljava/util/concurrent/atomic/AtomicInteger;", "seqCount", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelPersonalAlbumService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "e", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class lj extends BaseService<IKernelPersonalAlbumService, IKernelPersonalAlbumService> implements com.tencent.qqnt.kernel.api.z {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicInteger seqCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/lj$a;", "", "", "SUB_TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.lj$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52038);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 44)) {
            redirector.redirect((short) 44);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lj(@Nullable IKernelPersonalAlbumService iKernelPersonalAlbumService, @NotNull py content) {
        super("QZAlbumxService", content, iKernelPersonalAlbumService);
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iKernelPersonalAlbumService, (Object) content);
        } else {
            this.seqCount = new AtomicInteger(0);
        }
    }

    private final int p4() {
        return this.seqCount.incrementAndGet();
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int addAlbumPermissions(@Nullable PAAddAlbumPermissionsReq request, @Nullable IPersonalAlbumServiceAddAlbumPermissionsCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.addAlbumPermissions(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int addComment(@Nullable PAAddCommentReq request, @Nullable IPersonalAlbumServiceAddCommentCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.addComment(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int addReply(@Nullable PAAddReplyReq request, @Nullable IPersonalAlbumServiceAddReplyCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.addReply(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int cloneBatchMedia(@Nullable PACloneBatchMediaReq request, @Nullable IPersonalAlbumServiceCloneBatchMediaCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.cloneBatchMedia(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int createAlbum(@Nullable PACreateAlbumReq request, @Nullable IPersonalAlbumServiceCreateAlbumCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.createAlbum(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int deleteAlbum(@Nullable PADeleteAlbumReq request, @Nullable IPersonalAlbumServiceDeleteAlbumCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.deleteAlbum(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int deleteAlbumMedia(@Nullable PADeleteAlbumMediaReq request, @Nullable IPersonalAlbumServiceDeleteAlbumMediaCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.deleteAlbumMedia(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int deleteComment(@Nullable PADeleteCommentReq request, @Nullable IPersonalAlbumServiceDeleteCommentCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.deleteComment(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int deleteReply(@Nullable PADeleteReplyReq request, @Nullable IPersonalAlbumServiceDeleteReplyCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.deleteReply(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int doLike(@Nullable PADoLikeReq request, @Nullable IPersonalAlbumServiceDoLikeCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.doLike(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int editAlbum(@Nullable PAEditAlbumReq request, @Nullable IPersonalAlbumServiceEditAlbumCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.editAlbum(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int editBatchMedia(@Nullable PAEditBatchMediaReq request, @Nullable IPersonalAlbumServiceEditBatchMediaCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.editBatchMedia(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int editTravelAlbumScence(@NotNull PAEditTravelAlbumScenceReq request, @NotNull IPersonalAlbumServiceEditTravelAlbumScenceCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Integer) iPatchRedirector.redirect((short) 42, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callback, "callback");
        int p46 = p4();
        request.seq = p46;
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.editTravelAlbumScence(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int forwardAlbumToQzone(@Nullable PAForwardAlbumToQzoneReq request, @Nullable IPersonalAlbumServiceForwardAlbumToQzoneCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Integer) iPatchRedirector.redirect((short) 41, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.forwardAlbumToQzone(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int getAlbumInviteJoinPage(@Nullable PAGetAlbumInviteJoinPageReq request, @Nullable IPersonalAlbumServiceGetAlbumInviteJoinPageCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.getAlbumInviteJoinPage(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int getAlbumJoinApprovalPage(@Nullable PAGetAlbumJoinApprovalPageReq request, @Nullable IPersonalAlbumServiceGetAlbumJoinApprovalPageCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Integer) iPatchRedirector.redirect((short) 38, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.getAlbumJoinApprovalPage(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int getAlbumList(@Nullable PAGetAlbumListReq request, @Nullable IPersonalAlbumServiceGetAlbumListCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.getAlbumList(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int getAlbumMemberList(@Nullable PAGetAlbumMemberListReq request, @Nullable IPersonalAlbumServiceGetAlbumMemberListCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Integer) iPatchRedirector.redirect((short) 40, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.getAlbumMemberList(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int getCommentList(@Nullable PAGetCommentListReq request, @Nullable IPersonalAlbumServiceGetCommentListCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.getCommentList(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int getLayerTailpageRecommend(@Nullable PAGetLayerTailpageRecommendReq request, @Nullable IPersonalAlbumServiceGetLayerTailpageRecommendCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Integer) iPatchRedirector.redirect((short) 43, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.getLayerTailpageRecommend(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int getPhotoList(@Nullable PAGetPhotoListReq request, @Nullable IPersonalAlbumServiceGetPhotoListCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.getPhotoList(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int getPhotoListByTimeLine(@Nullable PAGetPhotoListByTimeLineReq request, @Nullable IPersonalAlbumServiceGetPhotoListByTimeLineCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.getPhotoListByTimeLine(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int getPhotoTab(@Nullable PAGetPhotoTabReq request, @Nullable IPersonalAlbumServiceGetPhotoTabCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.getPhotoTab(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int getPhotoTabByTimeLine(@Nullable PAGetPhotoTabByTimeLineReq request, @Nullable IPersonalAlbumServiceGetPhotoTabByTimeLineCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.getPhotoTabByTimeLine(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int getShareInfo(@Nullable PAGetShareInfoReq request, @Nullable IPersonalAlbumServiceGetShareInfoCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.getShareInfo(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int getVideoTab(@Nullable PAGetVideoTabReq request, @Nullable IPersonalAlbumServiceGetVideoTabCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.getVideoTab(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int getVideoTabByTimeLine(@Nullable PAGetVideoTabByTimeLineReq request, @Nullable IPersonalAlbumServiceGetVideoTabByTimeLineCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.getVideoTabByTimeLine(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int joinShareAlbum(@Nullable PAJoinShareAlbumReq request, @Nullable IPersonalAlbumServiceJoinShareAlbumCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.joinShareAlbum(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int moveBatchPhoto(@Nullable PAMoveBatchPhotoReq request, @Nullable IPersonalAlbumServiceMoveBatchPhotoCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.moveBatchPhoto(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int queryAlbum(@Nullable PAQueryAlbumReq request, @Nullable IPersonalAlbumServiceQueryAlbumCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.queryAlbum(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int removeAlbumMember(@Nullable PARemoveAlbumMemberReq request, @Nullable IPersonalAlbumServiceRemoveAlbumMemberCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Integer) iPatchRedirector.redirect((short) 36, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.removeAlbumMember(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int respondToJoinRequest(@Nullable PARespondToJoinRequestReq request, @Nullable IPersonalAlbumServiceRespondToJoinRequestCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.respondToJoinRequest(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int sendAlbumInvitation(@Nullable PASendAlbumInvitationReq request, @Nullable IPersonalAlbumServiceSendAlbumInvitationCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.sendAlbumInvitation(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public void setAlbumServiceInfo(@Nullable String uin, @Nullable String qua, @Nullable String deviceInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, uin, qua, deviceInfo);
            return;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.setAlbumServiceInfo(uin, qua, deviceInfo);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int sortPic(@Nullable PASortPicReq request, @Nullable IPersonalAlbumServiceSortPicCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.sortPic(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int unLike(@Nullable PAUnLikeReq request, @Nullable IPersonalAlbumServiceUnLikeCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.unLike(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int updateAlbumMember(@Nullable PAUpdateAlbumMemberReq request, @Nullable IPersonalAlbumServiceUpdateAlbumMemberCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.updateAlbumMember(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.z
    public int verifyAlbumQuestion(@Nullable PAVerifyAlbumQuestionReq request, @Nullable IPersonalAlbumServiceVerifyAlbumQuestionCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelPersonalAlbumService service = getService();
        if (service != null) {
            service.verifyAlbumQuestion(request, callback);
        }
        return p46;
    }
}
