package com.tencent.qqnt.kernel.nativeinterface;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes24.dex */
public interface IKernelPersonalAlbumService {

    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelPersonalAlbumService {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        CppProxy(long j3) {
            if (j3 != 0) {
                this.nativeRef = j3;
                return;
            }
            throw new RuntimeException("nativeRef is zero");
        }

        private native void nativeDestroy(long j3);

        private native void native_addAlbumPermissions(long j3, PAAddAlbumPermissionsReq pAAddAlbumPermissionsReq, IPersonalAlbumServiceAddAlbumPermissionsCallback iPersonalAlbumServiceAddAlbumPermissionsCallback);

        private native void native_addComment(long j3, PAAddCommentReq pAAddCommentReq, IPersonalAlbumServiceAddCommentCallback iPersonalAlbumServiceAddCommentCallback);

        private native void native_addReply(long j3, PAAddReplyReq pAAddReplyReq, IPersonalAlbumServiceAddReplyCallback iPersonalAlbumServiceAddReplyCallback);

        private native void native_cloneBatchMedia(long j3, PACloneBatchMediaReq pACloneBatchMediaReq, IPersonalAlbumServiceCloneBatchMediaCallback iPersonalAlbumServiceCloneBatchMediaCallback);

        private native void native_createAlbum(long j3, PACreateAlbumReq pACreateAlbumReq, IPersonalAlbumServiceCreateAlbumCallback iPersonalAlbumServiceCreateAlbumCallback);

        private native void native_delBatchPhoto(long j3, PADelBatchPhotoReq pADelBatchPhotoReq, IPersonalAlbumServiceDelBatchPhotoCallback iPersonalAlbumServiceDelBatchPhotoCallback);

        private native void native_deleteAlbum(long j3, PADeleteAlbumReq pADeleteAlbumReq, IPersonalAlbumServiceDeleteAlbumCallback iPersonalAlbumServiceDeleteAlbumCallback);

        private native void native_deleteAlbumMedia(long j3, PADeleteAlbumMediaReq pADeleteAlbumMediaReq, IPersonalAlbumServiceDeleteAlbumMediaCallback iPersonalAlbumServiceDeleteAlbumMediaCallback);

        private native void native_deleteComment(long j3, PADeleteCommentReq pADeleteCommentReq, IPersonalAlbumServiceDeleteCommentCallback iPersonalAlbumServiceDeleteCommentCallback);

        private native void native_deleteReply(long j3, PADeleteReplyReq pADeleteReplyReq, IPersonalAlbumServiceDeleteReplyCallback iPersonalAlbumServiceDeleteReplyCallback);

        private native void native_doLike(long j3, PADoLikeReq pADoLikeReq, IPersonalAlbumServiceDoLikeCallback iPersonalAlbumServiceDoLikeCallback);

        private native void native_editAlbum(long j3, PAEditAlbumReq pAEditAlbumReq, IPersonalAlbumServiceEditAlbumCallback iPersonalAlbumServiceEditAlbumCallback);

        private native void native_editBatchMedia(long j3, PAEditBatchMediaReq pAEditBatchMediaReq, IPersonalAlbumServiceEditBatchMediaCallback iPersonalAlbumServiceEditBatchMediaCallback);

        private native void native_editTravelAlbumScence(long j3, PAEditTravelAlbumScenceReq pAEditTravelAlbumScenceReq, IPersonalAlbumServiceEditTravelAlbumScenceCallback iPersonalAlbumServiceEditTravelAlbumScenceCallback);

        private native void native_forwardAlbumToQzone(long j3, PAForwardAlbumToQzoneReq pAForwardAlbumToQzoneReq, IPersonalAlbumServiceForwardAlbumToQzoneCallback iPersonalAlbumServiceForwardAlbumToQzoneCallback);

        private native void native_getAlbumInviteJoinPage(long j3, PAGetAlbumInviteJoinPageReq pAGetAlbumInviteJoinPageReq, IPersonalAlbumServiceGetAlbumInviteJoinPageCallback iPersonalAlbumServiceGetAlbumInviteJoinPageCallback);

        private native void native_getAlbumJoinApprovalPage(long j3, PAGetAlbumJoinApprovalPageReq pAGetAlbumJoinApprovalPageReq, IPersonalAlbumServiceGetAlbumJoinApprovalPageCallback iPersonalAlbumServiceGetAlbumJoinApprovalPageCallback);

        private native void native_getAlbumList(long j3, PAGetAlbumListReq pAGetAlbumListReq, IPersonalAlbumServiceGetAlbumListCallback iPersonalAlbumServiceGetAlbumListCallback);

        private native void native_getAlbumMemberList(long j3, PAGetAlbumMemberListReq pAGetAlbumMemberListReq, IPersonalAlbumServiceGetAlbumMemberListCallback iPersonalAlbumServiceGetAlbumMemberListCallback);

        private native void native_getCommentList(long j3, PAGetCommentListReq pAGetCommentListReq, IPersonalAlbumServiceGetCommentListCallback iPersonalAlbumServiceGetCommentListCallback);

        private native void native_getLayerTailpageRecommend(long j3, PAGetLayerTailpageRecommendReq pAGetLayerTailpageRecommendReq, IPersonalAlbumServiceGetLayerTailpageRecommendCallback iPersonalAlbumServiceGetLayerTailpageRecommendCallback);

        private native void native_getPhotoList(long j3, PAGetPhotoListReq pAGetPhotoListReq, IPersonalAlbumServiceGetPhotoListCallback iPersonalAlbumServiceGetPhotoListCallback);

        private native void native_getPhotoListByTimeLine(long j3, PAGetPhotoListByTimeLineReq pAGetPhotoListByTimeLineReq, IPersonalAlbumServiceGetPhotoListByTimeLineCallback iPersonalAlbumServiceGetPhotoListByTimeLineCallback);

        private native void native_getPhotoTab(long j3, PAGetPhotoTabReq pAGetPhotoTabReq, IPersonalAlbumServiceGetPhotoTabCallback iPersonalAlbumServiceGetPhotoTabCallback);

        private native void native_getPhotoTabByTimeLine(long j3, PAGetPhotoTabByTimeLineReq pAGetPhotoTabByTimeLineReq, IPersonalAlbumServiceGetPhotoTabByTimeLineCallback iPersonalAlbumServiceGetPhotoTabByTimeLineCallback);

        private native void native_getShareInfo(long j3, PAGetShareInfoReq pAGetShareInfoReq, IPersonalAlbumServiceGetShareInfoCallback iPersonalAlbumServiceGetShareInfoCallback);

        private native void native_getVideoTab(long j3, PAGetVideoTabReq pAGetVideoTabReq, IPersonalAlbumServiceGetVideoTabCallback iPersonalAlbumServiceGetVideoTabCallback);

        private native void native_getVideoTabByTimeLine(long j3, PAGetVideoTabByTimeLineReq pAGetVideoTabByTimeLineReq, IPersonalAlbumServiceGetVideoTabByTimeLineCallback iPersonalAlbumServiceGetVideoTabByTimeLineCallback);

        private native void native_inviteCheckForLoversAlbum(long j3, PAInviteCheckForLoversAlbumReq pAInviteCheckForLoversAlbumReq, IPersonalAlbumServiceInviteCheckForLoversAlbumCallback iPersonalAlbumServiceInviteCheckForLoversAlbumCallback);

        private native void native_joinShareAlbum(long j3, PAJoinShareAlbumReq pAJoinShareAlbumReq, IPersonalAlbumServiceJoinShareAlbumCallback iPersonalAlbumServiceJoinShareAlbumCallback);

        private native void native_moveBatchMedia(long j3, PAMoveBatchMediaReq pAMoveBatchMediaReq, IPersonalAlbumServiceMoveBatchMediaCallback iPersonalAlbumServiceMoveBatchMediaCallback);

        private native void native_moveBatchPhoto(long j3, PAMoveBatchPhotoReq pAMoveBatchPhotoReq, IPersonalAlbumServiceMoveBatchPhotoCallback iPersonalAlbumServiceMoveBatchPhotoCallback);

        private native void native_queryAlbum(long j3, PAQueryAlbumReq pAQueryAlbumReq, IPersonalAlbumServiceQueryAlbumCallback iPersonalAlbumServiceQueryAlbumCallback);

        private native void native_quitSharedAlbum(long j3, PAQuitSharedAlbumReq pAQuitSharedAlbumReq, IPersonalAlbumServiceQuitSharedAlbumCallback iPersonalAlbumServiceQuitSharedAlbumCallback);

        private native void native_removeAlbumMember(long j3, PARemoveAlbumMemberReq pARemoveAlbumMemberReq, IPersonalAlbumServiceRemoveAlbumMemberCallback iPersonalAlbumServiceRemoveAlbumMemberCallback);

        private native void native_respondToJoinRequest(long j3, PARespondToJoinRequestReq pARespondToJoinRequestReq, IPersonalAlbumServiceRespondToJoinRequestCallback iPersonalAlbumServiceRespondToJoinRequestCallback);

        private native void native_sendAlbumInvitation(long j3, PASendAlbumInvitationReq pASendAlbumInvitationReq, IPersonalAlbumServiceSendAlbumInvitationCallback iPersonalAlbumServiceSendAlbumInvitationCallback);

        private native void native_setAlbumServiceInfo(long j3, String str, String str2, String str3);

        private native void native_setTopAlbum(long j3, PASetTopAlbumReq pASetTopAlbumReq, IPersonalAlbumServiceSetTopAlbumCallback iPersonalAlbumServiceSetTopAlbumCallback);

        private native void native_sortPic(long j3, PASortPicReq pASortPicReq, IPersonalAlbumServiceSortPicCallback iPersonalAlbumServiceSortPicCallback);

        private native void native_unLike(long j3, PAUnLikeReq pAUnLikeReq, IPersonalAlbumServiceUnLikeCallback iPersonalAlbumServiceUnLikeCallback);

        private native void native_updateAlbumMember(long j3, PAUpdateAlbumMemberReq pAUpdateAlbumMemberReq, IPersonalAlbumServiceUpdateAlbumMemberCallback iPersonalAlbumServiceUpdateAlbumMemberCallback);

        private native void native_verifyAlbumQuestion(long j3, PAVerifyAlbumQuestionReq pAVerifyAlbumQuestionReq, IPersonalAlbumServiceVerifyAlbumQuestionCallback iPersonalAlbumServiceVerifyAlbumQuestionCallback);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void addAlbumPermissions(PAAddAlbumPermissionsReq pAAddAlbumPermissionsReq, IPersonalAlbumServiceAddAlbumPermissionsCallback iPersonalAlbumServiceAddAlbumPermissionsCallback) {
            native_addAlbumPermissions(this.nativeRef, pAAddAlbumPermissionsReq, iPersonalAlbumServiceAddAlbumPermissionsCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void addComment(PAAddCommentReq pAAddCommentReq, IPersonalAlbumServiceAddCommentCallback iPersonalAlbumServiceAddCommentCallback) {
            native_addComment(this.nativeRef, pAAddCommentReq, iPersonalAlbumServiceAddCommentCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void addReply(PAAddReplyReq pAAddReplyReq, IPersonalAlbumServiceAddReplyCallback iPersonalAlbumServiceAddReplyCallback) {
            native_addReply(this.nativeRef, pAAddReplyReq, iPersonalAlbumServiceAddReplyCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void cloneBatchMedia(PACloneBatchMediaReq pACloneBatchMediaReq, IPersonalAlbumServiceCloneBatchMediaCallback iPersonalAlbumServiceCloneBatchMediaCallback) {
            native_cloneBatchMedia(this.nativeRef, pACloneBatchMediaReq, iPersonalAlbumServiceCloneBatchMediaCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void createAlbum(PACreateAlbumReq pACreateAlbumReq, IPersonalAlbumServiceCreateAlbumCallback iPersonalAlbumServiceCreateAlbumCallback) {
            native_createAlbum(this.nativeRef, pACreateAlbumReq, iPersonalAlbumServiceCreateAlbumCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void delBatchPhoto(PADelBatchPhotoReq pADelBatchPhotoReq, IPersonalAlbumServiceDelBatchPhotoCallback iPersonalAlbumServiceDelBatchPhotoCallback) {
            native_delBatchPhoto(this.nativeRef, pADelBatchPhotoReq, iPersonalAlbumServiceDelBatchPhotoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void deleteAlbum(PADeleteAlbumReq pADeleteAlbumReq, IPersonalAlbumServiceDeleteAlbumCallback iPersonalAlbumServiceDeleteAlbumCallback) {
            native_deleteAlbum(this.nativeRef, pADeleteAlbumReq, iPersonalAlbumServiceDeleteAlbumCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void deleteAlbumMedia(PADeleteAlbumMediaReq pADeleteAlbumMediaReq, IPersonalAlbumServiceDeleteAlbumMediaCallback iPersonalAlbumServiceDeleteAlbumMediaCallback) {
            native_deleteAlbumMedia(this.nativeRef, pADeleteAlbumMediaReq, iPersonalAlbumServiceDeleteAlbumMediaCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void deleteComment(PADeleteCommentReq pADeleteCommentReq, IPersonalAlbumServiceDeleteCommentCallback iPersonalAlbumServiceDeleteCommentCallback) {
            native_deleteComment(this.nativeRef, pADeleteCommentReq, iPersonalAlbumServiceDeleteCommentCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void deleteReply(PADeleteReplyReq pADeleteReplyReq, IPersonalAlbumServiceDeleteReplyCallback iPersonalAlbumServiceDeleteReplyCallback) {
            native_deleteReply(this.nativeRef, pADeleteReplyReq, iPersonalAlbumServiceDeleteReplyCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void doLike(PADoLikeReq pADoLikeReq, IPersonalAlbumServiceDoLikeCallback iPersonalAlbumServiceDoLikeCallback) {
            native_doLike(this.nativeRef, pADoLikeReq, iPersonalAlbumServiceDoLikeCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void editAlbum(PAEditAlbumReq pAEditAlbumReq, IPersonalAlbumServiceEditAlbumCallback iPersonalAlbumServiceEditAlbumCallback) {
            native_editAlbum(this.nativeRef, pAEditAlbumReq, iPersonalAlbumServiceEditAlbumCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void editBatchMedia(PAEditBatchMediaReq pAEditBatchMediaReq, IPersonalAlbumServiceEditBatchMediaCallback iPersonalAlbumServiceEditBatchMediaCallback) {
            native_editBatchMedia(this.nativeRef, pAEditBatchMediaReq, iPersonalAlbumServiceEditBatchMediaCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void editTravelAlbumScence(PAEditTravelAlbumScenceReq pAEditTravelAlbumScenceReq, IPersonalAlbumServiceEditTravelAlbumScenceCallback iPersonalAlbumServiceEditTravelAlbumScenceCallback) {
            native_editTravelAlbumScence(this.nativeRef, pAEditTravelAlbumScenceReq, iPersonalAlbumServiceEditTravelAlbumScenceCallback);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void forwardAlbumToQzone(PAForwardAlbumToQzoneReq pAForwardAlbumToQzoneReq, IPersonalAlbumServiceForwardAlbumToQzoneCallback iPersonalAlbumServiceForwardAlbumToQzoneCallback) {
            native_forwardAlbumToQzone(this.nativeRef, pAForwardAlbumToQzoneReq, iPersonalAlbumServiceForwardAlbumToQzoneCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void getAlbumInviteJoinPage(PAGetAlbumInviteJoinPageReq pAGetAlbumInviteJoinPageReq, IPersonalAlbumServiceGetAlbumInviteJoinPageCallback iPersonalAlbumServiceGetAlbumInviteJoinPageCallback) {
            native_getAlbumInviteJoinPage(this.nativeRef, pAGetAlbumInviteJoinPageReq, iPersonalAlbumServiceGetAlbumInviteJoinPageCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void getAlbumJoinApprovalPage(PAGetAlbumJoinApprovalPageReq pAGetAlbumJoinApprovalPageReq, IPersonalAlbumServiceGetAlbumJoinApprovalPageCallback iPersonalAlbumServiceGetAlbumJoinApprovalPageCallback) {
            native_getAlbumJoinApprovalPage(this.nativeRef, pAGetAlbumJoinApprovalPageReq, iPersonalAlbumServiceGetAlbumJoinApprovalPageCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void getAlbumList(PAGetAlbumListReq pAGetAlbumListReq, IPersonalAlbumServiceGetAlbumListCallback iPersonalAlbumServiceGetAlbumListCallback) {
            native_getAlbumList(this.nativeRef, pAGetAlbumListReq, iPersonalAlbumServiceGetAlbumListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void getAlbumMemberList(PAGetAlbumMemberListReq pAGetAlbumMemberListReq, IPersonalAlbumServiceGetAlbumMemberListCallback iPersonalAlbumServiceGetAlbumMemberListCallback) {
            native_getAlbumMemberList(this.nativeRef, pAGetAlbumMemberListReq, iPersonalAlbumServiceGetAlbumMemberListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void getCommentList(PAGetCommentListReq pAGetCommentListReq, IPersonalAlbumServiceGetCommentListCallback iPersonalAlbumServiceGetCommentListCallback) {
            native_getCommentList(this.nativeRef, pAGetCommentListReq, iPersonalAlbumServiceGetCommentListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void getLayerTailpageRecommend(PAGetLayerTailpageRecommendReq pAGetLayerTailpageRecommendReq, IPersonalAlbumServiceGetLayerTailpageRecommendCallback iPersonalAlbumServiceGetLayerTailpageRecommendCallback) {
            native_getLayerTailpageRecommend(this.nativeRef, pAGetLayerTailpageRecommendReq, iPersonalAlbumServiceGetLayerTailpageRecommendCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void getPhotoList(PAGetPhotoListReq pAGetPhotoListReq, IPersonalAlbumServiceGetPhotoListCallback iPersonalAlbumServiceGetPhotoListCallback) {
            native_getPhotoList(this.nativeRef, pAGetPhotoListReq, iPersonalAlbumServiceGetPhotoListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void getPhotoListByTimeLine(PAGetPhotoListByTimeLineReq pAGetPhotoListByTimeLineReq, IPersonalAlbumServiceGetPhotoListByTimeLineCallback iPersonalAlbumServiceGetPhotoListByTimeLineCallback) {
            native_getPhotoListByTimeLine(this.nativeRef, pAGetPhotoListByTimeLineReq, iPersonalAlbumServiceGetPhotoListByTimeLineCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void getPhotoTab(PAGetPhotoTabReq pAGetPhotoTabReq, IPersonalAlbumServiceGetPhotoTabCallback iPersonalAlbumServiceGetPhotoTabCallback) {
            native_getPhotoTab(this.nativeRef, pAGetPhotoTabReq, iPersonalAlbumServiceGetPhotoTabCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void getPhotoTabByTimeLine(PAGetPhotoTabByTimeLineReq pAGetPhotoTabByTimeLineReq, IPersonalAlbumServiceGetPhotoTabByTimeLineCallback iPersonalAlbumServiceGetPhotoTabByTimeLineCallback) {
            native_getPhotoTabByTimeLine(this.nativeRef, pAGetPhotoTabByTimeLineReq, iPersonalAlbumServiceGetPhotoTabByTimeLineCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void getShareInfo(PAGetShareInfoReq pAGetShareInfoReq, IPersonalAlbumServiceGetShareInfoCallback iPersonalAlbumServiceGetShareInfoCallback) {
            native_getShareInfo(this.nativeRef, pAGetShareInfoReq, iPersonalAlbumServiceGetShareInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void getVideoTab(PAGetVideoTabReq pAGetVideoTabReq, IPersonalAlbumServiceGetVideoTabCallback iPersonalAlbumServiceGetVideoTabCallback) {
            native_getVideoTab(this.nativeRef, pAGetVideoTabReq, iPersonalAlbumServiceGetVideoTabCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void getVideoTabByTimeLine(PAGetVideoTabByTimeLineReq pAGetVideoTabByTimeLineReq, IPersonalAlbumServiceGetVideoTabByTimeLineCallback iPersonalAlbumServiceGetVideoTabByTimeLineCallback) {
            native_getVideoTabByTimeLine(this.nativeRef, pAGetVideoTabByTimeLineReq, iPersonalAlbumServiceGetVideoTabByTimeLineCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void inviteCheckForLoversAlbum(PAInviteCheckForLoversAlbumReq pAInviteCheckForLoversAlbumReq, IPersonalAlbumServiceInviteCheckForLoversAlbumCallback iPersonalAlbumServiceInviteCheckForLoversAlbumCallback) {
            native_inviteCheckForLoversAlbum(this.nativeRef, pAInviteCheckForLoversAlbumReq, iPersonalAlbumServiceInviteCheckForLoversAlbumCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void joinShareAlbum(PAJoinShareAlbumReq pAJoinShareAlbumReq, IPersonalAlbumServiceJoinShareAlbumCallback iPersonalAlbumServiceJoinShareAlbumCallback) {
            native_joinShareAlbum(this.nativeRef, pAJoinShareAlbumReq, iPersonalAlbumServiceJoinShareAlbumCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void moveBatchMedia(PAMoveBatchMediaReq pAMoveBatchMediaReq, IPersonalAlbumServiceMoveBatchMediaCallback iPersonalAlbumServiceMoveBatchMediaCallback) {
            native_moveBatchMedia(this.nativeRef, pAMoveBatchMediaReq, iPersonalAlbumServiceMoveBatchMediaCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void moveBatchPhoto(PAMoveBatchPhotoReq pAMoveBatchPhotoReq, IPersonalAlbumServiceMoveBatchPhotoCallback iPersonalAlbumServiceMoveBatchPhotoCallback) {
            native_moveBatchPhoto(this.nativeRef, pAMoveBatchPhotoReq, iPersonalAlbumServiceMoveBatchPhotoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void queryAlbum(PAQueryAlbumReq pAQueryAlbumReq, IPersonalAlbumServiceQueryAlbumCallback iPersonalAlbumServiceQueryAlbumCallback) {
            native_queryAlbum(this.nativeRef, pAQueryAlbumReq, iPersonalAlbumServiceQueryAlbumCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void quitSharedAlbum(PAQuitSharedAlbumReq pAQuitSharedAlbumReq, IPersonalAlbumServiceQuitSharedAlbumCallback iPersonalAlbumServiceQuitSharedAlbumCallback) {
            native_quitSharedAlbum(this.nativeRef, pAQuitSharedAlbumReq, iPersonalAlbumServiceQuitSharedAlbumCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void removeAlbumMember(PARemoveAlbumMemberReq pARemoveAlbumMemberReq, IPersonalAlbumServiceRemoveAlbumMemberCallback iPersonalAlbumServiceRemoveAlbumMemberCallback) {
            native_removeAlbumMember(this.nativeRef, pARemoveAlbumMemberReq, iPersonalAlbumServiceRemoveAlbumMemberCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void respondToJoinRequest(PARespondToJoinRequestReq pARespondToJoinRequestReq, IPersonalAlbumServiceRespondToJoinRequestCallback iPersonalAlbumServiceRespondToJoinRequestCallback) {
            native_respondToJoinRequest(this.nativeRef, pARespondToJoinRequestReq, iPersonalAlbumServiceRespondToJoinRequestCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void sendAlbumInvitation(PASendAlbumInvitationReq pASendAlbumInvitationReq, IPersonalAlbumServiceSendAlbumInvitationCallback iPersonalAlbumServiceSendAlbumInvitationCallback) {
            native_sendAlbumInvitation(this.nativeRef, pASendAlbumInvitationReq, iPersonalAlbumServiceSendAlbumInvitationCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void setAlbumServiceInfo(String str, String str2, String str3) {
            native_setAlbumServiceInfo(this.nativeRef, str, str2, str3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void setTopAlbum(PASetTopAlbumReq pASetTopAlbumReq, IPersonalAlbumServiceSetTopAlbumCallback iPersonalAlbumServiceSetTopAlbumCallback) {
            native_setTopAlbum(this.nativeRef, pASetTopAlbumReq, iPersonalAlbumServiceSetTopAlbumCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void sortPic(PASortPicReq pASortPicReq, IPersonalAlbumServiceSortPicCallback iPersonalAlbumServiceSortPicCallback) {
            native_sortPic(this.nativeRef, pASortPicReq, iPersonalAlbumServiceSortPicCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void unLike(PAUnLikeReq pAUnLikeReq, IPersonalAlbumServiceUnLikeCallback iPersonalAlbumServiceUnLikeCallback) {
            native_unLike(this.nativeRef, pAUnLikeReq, iPersonalAlbumServiceUnLikeCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void updateAlbumMember(PAUpdateAlbumMemberReq pAUpdateAlbumMemberReq, IPersonalAlbumServiceUpdateAlbumMemberCallback iPersonalAlbumServiceUpdateAlbumMemberCallback) {
            native_updateAlbumMember(this.nativeRef, pAUpdateAlbumMemberReq, iPersonalAlbumServiceUpdateAlbumMemberCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService
        public void verifyAlbumQuestion(PAVerifyAlbumQuestionReq pAVerifyAlbumQuestionReq, IPersonalAlbumServiceVerifyAlbumQuestionCallback iPersonalAlbumServiceVerifyAlbumQuestionCallback) {
            native_verifyAlbumQuestion(this.nativeRef, pAVerifyAlbumQuestionReq, iPersonalAlbumServiceVerifyAlbumQuestionCallback);
        }
    }

    void addAlbumPermissions(PAAddAlbumPermissionsReq pAAddAlbumPermissionsReq, IPersonalAlbumServiceAddAlbumPermissionsCallback iPersonalAlbumServiceAddAlbumPermissionsCallback);

    void addComment(PAAddCommentReq pAAddCommentReq, IPersonalAlbumServiceAddCommentCallback iPersonalAlbumServiceAddCommentCallback);

    void addReply(PAAddReplyReq pAAddReplyReq, IPersonalAlbumServiceAddReplyCallback iPersonalAlbumServiceAddReplyCallback);

    void cloneBatchMedia(PACloneBatchMediaReq pACloneBatchMediaReq, IPersonalAlbumServiceCloneBatchMediaCallback iPersonalAlbumServiceCloneBatchMediaCallback);

    void createAlbum(PACreateAlbumReq pACreateAlbumReq, IPersonalAlbumServiceCreateAlbumCallback iPersonalAlbumServiceCreateAlbumCallback);

    void delBatchPhoto(PADelBatchPhotoReq pADelBatchPhotoReq, IPersonalAlbumServiceDelBatchPhotoCallback iPersonalAlbumServiceDelBatchPhotoCallback);

    void deleteAlbum(PADeleteAlbumReq pADeleteAlbumReq, IPersonalAlbumServiceDeleteAlbumCallback iPersonalAlbumServiceDeleteAlbumCallback);

    void deleteAlbumMedia(PADeleteAlbumMediaReq pADeleteAlbumMediaReq, IPersonalAlbumServiceDeleteAlbumMediaCallback iPersonalAlbumServiceDeleteAlbumMediaCallback);

    void deleteComment(PADeleteCommentReq pADeleteCommentReq, IPersonalAlbumServiceDeleteCommentCallback iPersonalAlbumServiceDeleteCommentCallback);

    void deleteReply(PADeleteReplyReq pADeleteReplyReq, IPersonalAlbumServiceDeleteReplyCallback iPersonalAlbumServiceDeleteReplyCallback);

    void doLike(PADoLikeReq pADoLikeReq, IPersonalAlbumServiceDoLikeCallback iPersonalAlbumServiceDoLikeCallback);

    void editAlbum(PAEditAlbumReq pAEditAlbumReq, IPersonalAlbumServiceEditAlbumCallback iPersonalAlbumServiceEditAlbumCallback);

    void editBatchMedia(PAEditBatchMediaReq pAEditBatchMediaReq, IPersonalAlbumServiceEditBatchMediaCallback iPersonalAlbumServiceEditBatchMediaCallback);

    void editTravelAlbumScence(PAEditTravelAlbumScenceReq pAEditTravelAlbumScenceReq, IPersonalAlbumServiceEditTravelAlbumScenceCallback iPersonalAlbumServiceEditTravelAlbumScenceCallback);

    void forwardAlbumToQzone(PAForwardAlbumToQzoneReq pAForwardAlbumToQzoneReq, IPersonalAlbumServiceForwardAlbumToQzoneCallback iPersonalAlbumServiceForwardAlbumToQzoneCallback);

    void getAlbumInviteJoinPage(PAGetAlbumInviteJoinPageReq pAGetAlbumInviteJoinPageReq, IPersonalAlbumServiceGetAlbumInviteJoinPageCallback iPersonalAlbumServiceGetAlbumInviteJoinPageCallback);

    void getAlbumJoinApprovalPage(PAGetAlbumJoinApprovalPageReq pAGetAlbumJoinApprovalPageReq, IPersonalAlbumServiceGetAlbumJoinApprovalPageCallback iPersonalAlbumServiceGetAlbumJoinApprovalPageCallback);

    void getAlbumList(PAGetAlbumListReq pAGetAlbumListReq, IPersonalAlbumServiceGetAlbumListCallback iPersonalAlbumServiceGetAlbumListCallback);

    void getAlbumMemberList(PAGetAlbumMemberListReq pAGetAlbumMemberListReq, IPersonalAlbumServiceGetAlbumMemberListCallback iPersonalAlbumServiceGetAlbumMemberListCallback);

    void getCommentList(PAGetCommentListReq pAGetCommentListReq, IPersonalAlbumServiceGetCommentListCallback iPersonalAlbumServiceGetCommentListCallback);

    void getLayerTailpageRecommend(PAGetLayerTailpageRecommendReq pAGetLayerTailpageRecommendReq, IPersonalAlbumServiceGetLayerTailpageRecommendCallback iPersonalAlbumServiceGetLayerTailpageRecommendCallback);

    void getPhotoList(PAGetPhotoListReq pAGetPhotoListReq, IPersonalAlbumServiceGetPhotoListCallback iPersonalAlbumServiceGetPhotoListCallback);

    void getPhotoListByTimeLine(PAGetPhotoListByTimeLineReq pAGetPhotoListByTimeLineReq, IPersonalAlbumServiceGetPhotoListByTimeLineCallback iPersonalAlbumServiceGetPhotoListByTimeLineCallback);

    void getPhotoTab(PAGetPhotoTabReq pAGetPhotoTabReq, IPersonalAlbumServiceGetPhotoTabCallback iPersonalAlbumServiceGetPhotoTabCallback);

    void getPhotoTabByTimeLine(PAGetPhotoTabByTimeLineReq pAGetPhotoTabByTimeLineReq, IPersonalAlbumServiceGetPhotoTabByTimeLineCallback iPersonalAlbumServiceGetPhotoTabByTimeLineCallback);

    void getShareInfo(PAGetShareInfoReq pAGetShareInfoReq, IPersonalAlbumServiceGetShareInfoCallback iPersonalAlbumServiceGetShareInfoCallback);

    void getVideoTab(PAGetVideoTabReq pAGetVideoTabReq, IPersonalAlbumServiceGetVideoTabCallback iPersonalAlbumServiceGetVideoTabCallback);

    void getVideoTabByTimeLine(PAGetVideoTabByTimeLineReq pAGetVideoTabByTimeLineReq, IPersonalAlbumServiceGetVideoTabByTimeLineCallback iPersonalAlbumServiceGetVideoTabByTimeLineCallback);

    void inviteCheckForLoversAlbum(PAInviteCheckForLoversAlbumReq pAInviteCheckForLoversAlbumReq, IPersonalAlbumServiceInviteCheckForLoversAlbumCallback iPersonalAlbumServiceInviteCheckForLoversAlbumCallback);

    void joinShareAlbum(PAJoinShareAlbumReq pAJoinShareAlbumReq, IPersonalAlbumServiceJoinShareAlbumCallback iPersonalAlbumServiceJoinShareAlbumCallback);

    void moveBatchMedia(PAMoveBatchMediaReq pAMoveBatchMediaReq, IPersonalAlbumServiceMoveBatchMediaCallback iPersonalAlbumServiceMoveBatchMediaCallback);

    void moveBatchPhoto(PAMoveBatchPhotoReq pAMoveBatchPhotoReq, IPersonalAlbumServiceMoveBatchPhotoCallback iPersonalAlbumServiceMoveBatchPhotoCallback);

    void queryAlbum(PAQueryAlbumReq pAQueryAlbumReq, IPersonalAlbumServiceQueryAlbumCallback iPersonalAlbumServiceQueryAlbumCallback);

    void quitSharedAlbum(PAQuitSharedAlbumReq pAQuitSharedAlbumReq, IPersonalAlbumServiceQuitSharedAlbumCallback iPersonalAlbumServiceQuitSharedAlbumCallback);

    void removeAlbumMember(PARemoveAlbumMemberReq pARemoveAlbumMemberReq, IPersonalAlbumServiceRemoveAlbumMemberCallback iPersonalAlbumServiceRemoveAlbumMemberCallback);

    void respondToJoinRequest(PARespondToJoinRequestReq pARespondToJoinRequestReq, IPersonalAlbumServiceRespondToJoinRequestCallback iPersonalAlbumServiceRespondToJoinRequestCallback);

    void sendAlbumInvitation(PASendAlbumInvitationReq pASendAlbumInvitationReq, IPersonalAlbumServiceSendAlbumInvitationCallback iPersonalAlbumServiceSendAlbumInvitationCallback);

    void setAlbumServiceInfo(String str, String str2, String str3);

    void setTopAlbum(PASetTopAlbumReq pASetTopAlbumReq, IPersonalAlbumServiceSetTopAlbumCallback iPersonalAlbumServiceSetTopAlbumCallback);

    void sortPic(PASortPicReq pASortPicReq, IPersonalAlbumServiceSortPicCallback iPersonalAlbumServiceSortPicCallback);

    void unLike(PAUnLikeReq pAUnLikeReq, IPersonalAlbumServiceUnLikeCallback iPersonalAlbumServiceUnLikeCallback);

    void updateAlbumMember(PAUpdateAlbumMemberReq pAUpdateAlbumMemberReq, IPersonalAlbumServiceUpdateAlbumMemberCallback iPersonalAlbumServiceUpdateAlbumMemberCallback);

    void verifyAlbumQuestion(PAVerifyAlbumQuestionReq pAVerifyAlbumQuestionReq, IPersonalAlbumServiceVerifyAlbumQuestionCallback iPersonalAlbumServiceVerifyAlbumQuestionCallback);
}
