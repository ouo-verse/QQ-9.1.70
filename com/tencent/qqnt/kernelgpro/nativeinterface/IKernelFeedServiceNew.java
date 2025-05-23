package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelFeedServiceNew {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelFeedServiceNew {
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

        public static native GProRecommendCardPosAdvertise decodeRecommendCardPosAdvertise(byte[] bArr);

        private native void nativeDestroy(long j3);

        private native long native_addKernelFeedListener(long j3, IKernelFeedListener iKernelFeedListener);

        private native void native_alterFeed(long j3, GProStAlterFeedReq gProStAlterFeedReq, IGProAlterFeedCallback iGProAlterFeedCallback);

        private native void native_batchGetFeedDetail(long j3, GProBatchGetFeedDetailReq gProBatchGetFeedDetailReq, IGProBatchGetFeedDetailCallback iGProBatchGetFeedDetailCallback);

        private native void native_batchManageOperate(long j3, GProBatchManageOperateReq gProBatchManageOperateReq, IGProBatchManageOperateCallback iGProBatchManageOperateCallback);

        private native void native_batchTransThirdPlatformURL(long j3, GProBatchTransThirdPlatformURLReq gProBatchTransThirdPlatformURLReq, IGProBatchTransThirdPlatformURCallback iGProBatchTransThirdPlatformURCallback);

        private native void native_clearFeedsRecentViewHistory(long j3, IGproFeedOperateCallback iGproFeedOperateCallback);

        private native void native_createShare(long j3, GProCreateShareReq gProCreateShareReq, int i3, IGProCreateShareCallback iGProCreateShareCallback);

        private native GProBusiData native_decodeBusiData(long j3, byte[] bArr);

        private native GProStFeed native_decodeStFeed(long j3, byte[] bArr);

        private native void native_delFeed(long j3, GProStDelFeedReq gProStDelFeedReq, IGProDelFeedCallback iGProDelFeedCallback);

        private native void native_deleteFeedInteractNotice(long j3, GProDeleteInteractReq gProDeleteInteractReq, IGProDeleteFeedInteractNoticeCallback iGProDeleteFeedInteractNoticeCallback);

        private native void native_doComment(long j3, GProStDoCommentReq gProStDoCommentReq, IGProDoCommentCallback iGProDoCommentCallback);

        private native void native_doFeedPrefer(long j3, GProDoFeedPreferReq gProDoFeedPreferReq, IGProDoFeedPreferCallback iGProDoFeedPreferCallback);

        private native void native_doLike(long j3, GProStDoLikeReq gProStDoLikeReq, IGProDoLikeCallback iGProDoLikeCallback);

        private native void native_doReply(long j3, GProStDoReplyReq gProStDoReplyReq, IGProDoReplyCallback iGProDoReplyCallback);

        private native void native_downloadFeedRichMedia(long j3, FeedRichMediaDownloadReq feedRichMediaDownloadReq);

        private native byte[] native_encodeGProGetGuildFeedsRsp(long j3, GProGetGuildFeedsRsp gProGetGuildFeedsRsp);

        private native byte[] native_encodeGProStGetChannelFeedsRsp(long j3, GProStGetChannelFeedsRsp gProStGetChannelFeedsRsp);

        private native byte[] native_encodeGProTopFeed(long j3, GProTopFeed gProTopFeed);

        private native byte[] native_encodeStFeed(long j3, GProStFeed gProStFeed);

        private native void native_getAllFeedNotices(long j3, GProGetFeedNoticesReq gProGetFeedNoticesReq, boolean z16, IGProGetAllFeedNoticesCallback iGProGetAllFeedNoticesCallback);

        private native void native_getChannelDraft(long j3, String str, IGProGetChannelDraftCallback iGProGetChannelDraftCallback);

        private native void native_getChannelRecommendFeeds(long j3, GProStGetChannelFeedsReq gProStGetChannelFeedsReq, IGProGetChannelTimelineFeedsCallback iGProGetChannelTimelineFeedsCallback);

        private native void native_getChannelTimelineFeeds(long j3, GProStGetChannelFeedsReq gProStGetChannelFeedsReq, boolean z16, IGProGetChannelTimelineFeedsCallback iGProGetChannelTimelineFeedsCallback);

        private native void native_getDetailRecommendFeeds(long j3, GProGetDetailRecommendFeedsReq gProGetDetailRecommendFeedsReq, IGProGetDetailRecommendFeedsCallback iGProGetDetailRecommendFeedsCallback);

        private native void native_getDynamicPageRecommend(long j3, GProGetDynamicPageRecommendReq gProGetDynamicPageRecommendReq, IGProGetDynamicPageRecommendCallback iGProGetDynamicPageRecommendCallback);

        private native void native_getExternalComments(long j3, GProGetExternalCommentsReq gProGetExternalCommentsReq, IGProGetExternalCommentsCallback iGProGetExternalCommentsCallback);

        private native void native_getFeedComments(long j3, GProStGetFeedCommentsReq gProStGetFeedCommentsReq, IGProGetFeedCommentsCallback iGProGetFeedCommentsCallback);

        private native void native_getFeedCount(long j3, GProGetFeedCountReq gProGetFeedCountReq, IGProGetFeedCountCallback iGProGetFeedCountCallback);

        private native void native_getFeedDetail(long j3, GProStGetFeedDetailReq gProStGetFeedDetailReq, boolean z16, IGProGetFeedDetailCallback iGProGetFeedDetailCallback);

        private native void native_getFeedDetailWithHotComments(long j3, GProStGetFeedDetailReq gProStGetFeedDetailReq, IGProGetFeedDetailWithHotCommentsCallback iGProGetFeedDetailWithHotCommentsCallback);

        private native void native_getFeedLikeUserList(long j3, GProFeedLikeUserListReq gProFeedLikeUserListReq, int i3, IGProGetFeedLikeUserListCallback iGProGetFeedLikeUserListCallback);

        private native void native_getFeedNotices(long j3, GProGetFeedNoticesReq gProGetFeedNoticesReq, boolean z16, IGProGetFeedNoticesCallback iGProGetFeedNoticesCallback);

        private native String native_getFeedRichMediaFilePath(long j3, int i3, String str, String str2, int i16, boolean z16);

        private native void native_getFeeds(long j3, GProGetFeedsReq gProGetFeedsReq, IGProgetFeedsCallback iGProgetFeedsCallback);

        private native void native_getFeedsByIndex(long j3, GProGetFeedsByIndexReq gProGetFeedsByIndexReq, IGProGetFeedsByIndexCallback iGProGetFeedsByIndexCallback);

        private native void native_getGuildFeeds(long j3, GProGetGuildFeedsReq gProGetGuildFeedsReq, boolean z16, IGProGetGuildFeedsCallback iGProGetGuildFeedsCallback);

        private native void native_getImmersiveFeeds(long j3, GProGetImmersiveFeedsReq gProGetImmersiveFeedsReq, IGProGetImmersiveFeedsCallback iGProGetImmersiveFeedsCallback);

        private native void native_getJoinedRecommendItems(long j3, GProGetJoinedRecommendItemsReq gProGetJoinedRecommendItemsReq, boolean z16, IGProGetJoinedRecommendItemsCallback iGProGetJoinedRecommendItemsCallback);

        private native void native_getMultiChannelFeeds(long j3, GProGetMultiChannelFeedsReq gProGetMultiChannelFeedsReq, IGProGetMultiChannelFeedsCallback iGProGetMultiChannelFeedsCallback);

        private native void native_getMyJoinGuild(long j3, GProGetMyJoinGuildReq gProGetMyJoinGuildReq, boolean z16, IGProGetMyJoinGuildCallback iGProGetMyJoinGuildCallback);

        private native void native_getNextPageReplies(long j3, GProGetNextPageRepliesReq gProGetNextPageRepliesReq, IGProgetNextPageRepliesCallback iGProgetNextPageRepliesCallback);

        private native void native_getNotices(long j3, GProGetNoticesReq gProGetNoticesReq, boolean z16, IGProGetNoticesCallback iGProGetNoticesCallback);

        private native void native_getProfileFeeds(long j3, GProGetProfileFeedsReq gProGetProfileFeedsReq, boolean z16, IGProGetProfileFeedsCallback iGProGetProfileFeedsCallback);

        private native void native_getTopFeedConfig(long j3, GProGetTopFeedConfigReq gProGetTopFeedConfigReq, IGProGetTopFeedConfigCallback iGProGetTopFeedConfigCallback);

        private native void native_getTopFeeds(long j3, GProGetTopFeedsReq gProGetTopFeedsReq, IGProGetTopFeedsCallback iGProGetTopFeedsCallback);

        private native void native_getTopicFeeds(long j3, GProGetTopicFeedsReq gProGetTopicFeedsReq, IGProGetTopicFeedsCallback iGProGetTopicFeedsCallback);

        private native void native_getUserPageDigestContentList(long j3, GProGetUserPageDigestContentListReq gProGetUserPageDigestContentListReq, IGProGetUserPageDigestContentListCallback iGProGetUserPageDigestContentListCallback);

        private native void native_impeach(long j3, GProImpeachReq gProImpeachReq, IGProImpeachCallback iGProImpeachCallback);

        private native void native_moveFeed(long j3, GProMoveFeedReq gProMoveFeedReq, IGProMoveFeedCallback iGProMoveFeedCallback);

        private native void native_preloadGuildFeeds(long j3, GProPreloadGuildFeedsReq gProPreloadGuildFeedsReq, IGProPreloadGuildFeedsCallback iGProPreloadGuildFeedsCallback);

        private native void native_publishFeed(long j3, GProStPublishFeedReq gProStPublishFeedReq, IGPropublishFeedCallback iGPropublishFeedCallback);

        private native void native_removeKernelFeedListener(long j3, long j16);

        private native void native_reportRecentViewFeed(long j3, GProReportRecentViewFeedReq gProReportRecentViewFeedReq, IGproFeedOperateCallback iGproFeedOperateCallback);

        private native void native_searchTopic(long j3, GProSearchTopicReq gProSearchTopicReq, IGProSearchTopicCallback iGProSearchTopicCallback);

        private native void native_sendDataReport(long j3, GProStDataReportReq gProStDataReportReq, IGProFeedDataReportCallback iGProFeedDataReportCallback);

        private native void native_setChannelDraft(long j3, String str, String str2, IGproFeedOperateCallback iGproFeedOperateCallback);

        private native void native_setTopComment(long j3, GProSetTopCommentReq gProSetTopCommentReq, IGProSetTopCommentCallback iGProSetTopCommentCallback);

        private native void native_topChannelFeed(long j3, GProTopChannelFeedReq gProTopChannelFeedReq, IGProTopChannelFeedCallback iGProTopChannelFeedCallback);

        private native void native_topFeedAction(long j3, GProTopFeedActionReq gProTopFeedActionReq, IGProTopFeedActionCallback iGProTopFeedActionCallback);

        private native void native_unDoDelFeed(long j3, GProUnDoDelFeedReq gProUnDoDelFeedReq, IGProUnDoDelFeedCallback iGProUnDoDelFeedCallback);

        private native void native_updateFeedInteractBlockedStatus(long j3, GProUPdateFeedInteractSwitchReq gProUPdateFeedInteractSwitchReq, IGProUpdateFeedInteractBlockedStatusCallback iGProUpdateFeedInteractBlockedStatusCallback);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public long addKernelFeedListener(IKernelFeedListener iKernelFeedListener) {
            return native_addKernelFeedListener(this.nativeRef, iKernelFeedListener);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void alterFeed(GProStAlterFeedReq gProStAlterFeedReq, IGProAlterFeedCallback iGProAlterFeedCallback) {
            native_alterFeed(this.nativeRef, gProStAlterFeedReq, iGProAlterFeedCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void batchGetFeedDetail(GProBatchGetFeedDetailReq gProBatchGetFeedDetailReq, IGProBatchGetFeedDetailCallback iGProBatchGetFeedDetailCallback) {
            native_batchGetFeedDetail(this.nativeRef, gProBatchGetFeedDetailReq, iGProBatchGetFeedDetailCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void batchManageOperate(GProBatchManageOperateReq gProBatchManageOperateReq, IGProBatchManageOperateCallback iGProBatchManageOperateCallback) {
            native_batchManageOperate(this.nativeRef, gProBatchManageOperateReq, iGProBatchManageOperateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void batchTransThirdPlatformURL(GProBatchTransThirdPlatformURLReq gProBatchTransThirdPlatformURLReq, IGProBatchTransThirdPlatformURCallback iGProBatchTransThirdPlatformURCallback) {
            native_batchTransThirdPlatformURL(this.nativeRef, gProBatchTransThirdPlatformURLReq, iGProBatchTransThirdPlatformURCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void clearFeedsRecentViewHistory(IGproFeedOperateCallback iGproFeedOperateCallback) {
            native_clearFeedsRecentViewHistory(this.nativeRef, iGproFeedOperateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void createShare(GProCreateShareReq gProCreateShareReq, int i3, IGProCreateShareCallback iGProCreateShareCallback) {
            native_createShare(this.nativeRef, gProCreateShareReq, i3, iGProCreateShareCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public GProBusiData decodeBusiData(byte[] bArr) {
            return native_decodeBusiData(this.nativeRef, bArr);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public GProStFeed decodeStFeed(byte[] bArr) {
            return native_decodeStFeed(this.nativeRef, bArr);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void delFeed(GProStDelFeedReq gProStDelFeedReq, IGProDelFeedCallback iGProDelFeedCallback) {
            native_delFeed(this.nativeRef, gProStDelFeedReq, iGProDelFeedCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void deleteFeedInteractNotice(GProDeleteInteractReq gProDeleteInteractReq, IGProDeleteFeedInteractNoticeCallback iGProDeleteFeedInteractNoticeCallback) {
            native_deleteFeedInteractNotice(this.nativeRef, gProDeleteInteractReq, iGProDeleteFeedInteractNoticeCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void doComment(GProStDoCommentReq gProStDoCommentReq, IGProDoCommentCallback iGProDoCommentCallback) {
            native_doComment(this.nativeRef, gProStDoCommentReq, iGProDoCommentCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void doFeedPrefer(GProDoFeedPreferReq gProDoFeedPreferReq, IGProDoFeedPreferCallback iGProDoFeedPreferCallback) {
            native_doFeedPrefer(this.nativeRef, gProDoFeedPreferReq, iGProDoFeedPreferCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void doLike(GProStDoLikeReq gProStDoLikeReq, IGProDoLikeCallback iGProDoLikeCallback) {
            native_doLike(this.nativeRef, gProStDoLikeReq, iGProDoLikeCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void doReply(GProStDoReplyReq gProStDoReplyReq, IGProDoReplyCallback iGProDoReplyCallback) {
            native_doReply(this.nativeRef, gProStDoReplyReq, iGProDoReplyCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void downloadFeedRichMedia(FeedRichMediaDownloadReq feedRichMediaDownloadReq) {
            native_downloadFeedRichMedia(this.nativeRef, feedRichMediaDownloadReq);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public byte[] encodeGProGetGuildFeedsRsp(GProGetGuildFeedsRsp gProGetGuildFeedsRsp) {
            return native_encodeGProGetGuildFeedsRsp(this.nativeRef, gProGetGuildFeedsRsp);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public byte[] encodeGProStGetChannelFeedsRsp(GProStGetChannelFeedsRsp gProStGetChannelFeedsRsp) {
            return native_encodeGProStGetChannelFeedsRsp(this.nativeRef, gProStGetChannelFeedsRsp);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public byte[] encodeGProTopFeed(GProTopFeed gProTopFeed) {
            return native_encodeGProTopFeed(this.nativeRef, gProTopFeed);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public byte[] encodeStFeed(GProStFeed gProStFeed) {
            return native_encodeStFeed(this.nativeRef, gProStFeed);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void getAllFeedNotices(GProGetFeedNoticesReq gProGetFeedNoticesReq, boolean z16, IGProGetAllFeedNoticesCallback iGProGetAllFeedNoticesCallback) {
            native_getAllFeedNotices(this.nativeRef, gProGetFeedNoticesReq, z16, iGProGetAllFeedNoticesCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void getChannelDraft(String str, IGProGetChannelDraftCallback iGProGetChannelDraftCallback) {
            native_getChannelDraft(this.nativeRef, str, iGProGetChannelDraftCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void getChannelRecommendFeeds(GProStGetChannelFeedsReq gProStGetChannelFeedsReq, IGProGetChannelTimelineFeedsCallback iGProGetChannelTimelineFeedsCallback) {
            native_getChannelRecommendFeeds(this.nativeRef, gProStGetChannelFeedsReq, iGProGetChannelTimelineFeedsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void getChannelTimelineFeeds(GProStGetChannelFeedsReq gProStGetChannelFeedsReq, boolean z16, IGProGetChannelTimelineFeedsCallback iGProGetChannelTimelineFeedsCallback) {
            native_getChannelTimelineFeeds(this.nativeRef, gProStGetChannelFeedsReq, z16, iGProGetChannelTimelineFeedsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void getDetailRecommendFeeds(GProGetDetailRecommendFeedsReq gProGetDetailRecommendFeedsReq, IGProGetDetailRecommendFeedsCallback iGProGetDetailRecommendFeedsCallback) {
            native_getDetailRecommendFeeds(this.nativeRef, gProGetDetailRecommendFeedsReq, iGProGetDetailRecommendFeedsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void getDynamicPageRecommend(GProGetDynamicPageRecommendReq gProGetDynamicPageRecommendReq, IGProGetDynamicPageRecommendCallback iGProGetDynamicPageRecommendCallback) {
            native_getDynamicPageRecommend(this.nativeRef, gProGetDynamicPageRecommendReq, iGProGetDynamicPageRecommendCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void getExternalComments(GProGetExternalCommentsReq gProGetExternalCommentsReq, IGProGetExternalCommentsCallback iGProGetExternalCommentsCallback) {
            native_getExternalComments(this.nativeRef, gProGetExternalCommentsReq, iGProGetExternalCommentsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void getFeedComments(GProStGetFeedCommentsReq gProStGetFeedCommentsReq, IGProGetFeedCommentsCallback iGProGetFeedCommentsCallback) {
            native_getFeedComments(this.nativeRef, gProStGetFeedCommentsReq, iGProGetFeedCommentsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void getFeedCount(GProGetFeedCountReq gProGetFeedCountReq, IGProGetFeedCountCallback iGProGetFeedCountCallback) {
            native_getFeedCount(this.nativeRef, gProGetFeedCountReq, iGProGetFeedCountCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void getFeedDetail(GProStGetFeedDetailReq gProStGetFeedDetailReq, boolean z16, IGProGetFeedDetailCallback iGProGetFeedDetailCallback) {
            native_getFeedDetail(this.nativeRef, gProStGetFeedDetailReq, z16, iGProGetFeedDetailCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void getFeedDetailWithHotComments(GProStGetFeedDetailReq gProStGetFeedDetailReq, IGProGetFeedDetailWithHotCommentsCallback iGProGetFeedDetailWithHotCommentsCallback) {
            native_getFeedDetailWithHotComments(this.nativeRef, gProStGetFeedDetailReq, iGProGetFeedDetailWithHotCommentsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void getFeedLikeUserList(GProFeedLikeUserListReq gProFeedLikeUserListReq, int i3, IGProGetFeedLikeUserListCallback iGProGetFeedLikeUserListCallback) {
            native_getFeedLikeUserList(this.nativeRef, gProFeedLikeUserListReq, i3, iGProGetFeedLikeUserListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void getFeedNotices(GProGetFeedNoticesReq gProGetFeedNoticesReq, boolean z16, IGProGetFeedNoticesCallback iGProGetFeedNoticesCallback) {
            native_getFeedNotices(this.nativeRef, gProGetFeedNoticesReq, z16, iGProGetFeedNoticesCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public String getFeedRichMediaFilePath(int i3, String str, String str2, int i16, boolean z16) {
            return native_getFeedRichMediaFilePath(this.nativeRef, i3, str, str2, i16, z16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void getFeeds(GProGetFeedsReq gProGetFeedsReq, IGProgetFeedsCallback iGProgetFeedsCallback) {
            native_getFeeds(this.nativeRef, gProGetFeedsReq, iGProgetFeedsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void getFeedsByIndex(GProGetFeedsByIndexReq gProGetFeedsByIndexReq, IGProGetFeedsByIndexCallback iGProGetFeedsByIndexCallback) {
            native_getFeedsByIndex(this.nativeRef, gProGetFeedsByIndexReq, iGProGetFeedsByIndexCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void getGuildFeeds(GProGetGuildFeedsReq gProGetGuildFeedsReq, boolean z16, IGProGetGuildFeedsCallback iGProGetGuildFeedsCallback) {
            native_getGuildFeeds(this.nativeRef, gProGetGuildFeedsReq, z16, iGProGetGuildFeedsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void getImmersiveFeeds(GProGetImmersiveFeedsReq gProGetImmersiveFeedsReq, IGProGetImmersiveFeedsCallback iGProGetImmersiveFeedsCallback) {
            native_getImmersiveFeeds(this.nativeRef, gProGetImmersiveFeedsReq, iGProGetImmersiveFeedsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void getJoinedRecommendItems(GProGetJoinedRecommendItemsReq gProGetJoinedRecommendItemsReq, boolean z16, IGProGetJoinedRecommendItemsCallback iGProGetJoinedRecommendItemsCallback) {
            native_getJoinedRecommendItems(this.nativeRef, gProGetJoinedRecommendItemsReq, z16, iGProGetJoinedRecommendItemsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void getMultiChannelFeeds(GProGetMultiChannelFeedsReq gProGetMultiChannelFeedsReq, IGProGetMultiChannelFeedsCallback iGProGetMultiChannelFeedsCallback) {
            native_getMultiChannelFeeds(this.nativeRef, gProGetMultiChannelFeedsReq, iGProGetMultiChannelFeedsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void getMyJoinGuild(GProGetMyJoinGuildReq gProGetMyJoinGuildReq, boolean z16, IGProGetMyJoinGuildCallback iGProGetMyJoinGuildCallback) {
            native_getMyJoinGuild(this.nativeRef, gProGetMyJoinGuildReq, z16, iGProGetMyJoinGuildCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void getNextPageReplies(GProGetNextPageRepliesReq gProGetNextPageRepliesReq, IGProgetNextPageRepliesCallback iGProgetNextPageRepliesCallback) {
            native_getNextPageReplies(this.nativeRef, gProGetNextPageRepliesReq, iGProgetNextPageRepliesCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void getNotices(GProGetNoticesReq gProGetNoticesReq, boolean z16, IGProGetNoticesCallback iGProGetNoticesCallback) {
            native_getNotices(this.nativeRef, gProGetNoticesReq, z16, iGProGetNoticesCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void getProfileFeeds(GProGetProfileFeedsReq gProGetProfileFeedsReq, boolean z16, IGProGetProfileFeedsCallback iGProGetProfileFeedsCallback) {
            native_getProfileFeeds(this.nativeRef, gProGetProfileFeedsReq, z16, iGProGetProfileFeedsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void getTopFeedConfig(GProGetTopFeedConfigReq gProGetTopFeedConfigReq, IGProGetTopFeedConfigCallback iGProGetTopFeedConfigCallback) {
            native_getTopFeedConfig(this.nativeRef, gProGetTopFeedConfigReq, iGProGetTopFeedConfigCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void getTopFeeds(GProGetTopFeedsReq gProGetTopFeedsReq, IGProGetTopFeedsCallback iGProGetTopFeedsCallback) {
            native_getTopFeeds(this.nativeRef, gProGetTopFeedsReq, iGProGetTopFeedsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void getTopicFeeds(GProGetTopicFeedsReq gProGetTopicFeedsReq, IGProGetTopicFeedsCallback iGProGetTopicFeedsCallback) {
            native_getTopicFeeds(this.nativeRef, gProGetTopicFeedsReq, iGProGetTopicFeedsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void getUserPageDigestContentList(GProGetUserPageDigestContentListReq gProGetUserPageDigestContentListReq, IGProGetUserPageDigestContentListCallback iGProGetUserPageDigestContentListCallback) {
            native_getUserPageDigestContentList(this.nativeRef, gProGetUserPageDigestContentListReq, iGProGetUserPageDigestContentListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void impeach(GProImpeachReq gProImpeachReq, IGProImpeachCallback iGProImpeachCallback) {
            native_impeach(this.nativeRef, gProImpeachReq, iGProImpeachCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void moveFeed(GProMoveFeedReq gProMoveFeedReq, IGProMoveFeedCallback iGProMoveFeedCallback) {
            native_moveFeed(this.nativeRef, gProMoveFeedReq, iGProMoveFeedCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void preloadGuildFeeds(GProPreloadGuildFeedsReq gProPreloadGuildFeedsReq, IGProPreloadGuildFeedsCallback iGProPreloadGuildFeedsCallback) {
            native_preloadGuildFeeds(this.nativeRef, gProPreloadGuildFeedsReq, iGProPreloadGuildFeedsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void publishFeed(GProStPublishFeedReq gProStPublishFeedReq, IGPropublishFeedCallback iGPropublishFeedCallback) {
            native_publishFeed(this.nativeRef, gProStPublishFeedReq, iGPropublishFeedCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void removeKernelFeedListener(long j3) {
            native_removeKernelFeedListener(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void reportRecentViewFeed(GProReportRecentViewFeedReq gProReportRecentViewFeedReq, IGproFeedOperateCallback iGproFeedOperateCallback) {
            native_reportRecentViewFeed(this.nativeRef, gProReportRecentViewFeedReq, iGproFeedOperateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void searchTopic(GProSearchTopicReq gProSearchTopicReq, IGProSearchTopicCallback iGProSearchTopicCallback) {
            native_searchTopic(this.nativeRef, gProSearchTopicReq, iGProSearchTopicCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void sendDataReport(GProStDataReportReq gProStDataReportReq, IGProFeedDataReportCallback iGProFeedDataReportCallback) {
            native_sendDataReport(this.nativeRef, gProStDataReportReq, iGProFeedDataReportCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void setChannelDraft(String str, String str2, IGproFeedOperateCallback iGproFeedOperateCallback) {
            native_setChannelDraft(this.nativeRef, str, str2, iGproFeedOperateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void setTopComment(GProSetTopCommentReq gProSetTopCommentReq, IGProSetTopCommentCallback iGProSetTopCommentCallback) {
            native_setTopComment(this.nativeRef, gProSetTopCommentReq, iGProSetTopCommentCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void topChannelFeed(GProTopChannelFeedReq gProTopChannelFeedReq, IGProTopChannelFeedCallback iGProTopChannelFeedCallback) {
            native_topChannelFeed(this.nativeRef, gProTopChannelFeedReq, iGProTopChannelFeedCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void topFeedAction(GProTopFeedActionReq gProTopFeedActionReq, IGProTopFeedActionCallback iGProTopFeedActionCallback) {
            native_topFeedAction(this.nativeRef, gProTopFeedActionReq, iGProTopFeedActionCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void unDoDelFeed(GProUnDoDelFeedReq gProUnDoDelFeedReq, IGProUnDoDelFeedCallback iGProUnDoDelFeedCallback) {
            native_unDoDelFeed(this.nativeRef, gProUnDoDelFeedReq, iGProUnDoDelFeedCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew
        public void updateFeedInteractBlockedStatus(GProUPdateFeedInteractSwitchReq gProUPdateFeedInteractSwitchReq, IGProUpdateFeedInteractBlockedStatusCallback iGProUpdateFeedInteractBlockedStatusCallback) {
            native_updateFeedInteractBlockedStatus(this.nativeRef, gProUPdateFeedInteractSwitchReq, iGProUpdateFeedInteractBlockedStatusCallback);
        }
    }

    long addKernelFeedListener(IKernelFeedListener iKernelFeedListener);

    void alterFeed(GProStAlterFeedReq gProStAlterFeedReq, IGProAlterFeedCallback iGProAlterFeedCallback);

    void batchGetFeedDetail(GProBatchGetFeedDetailReq gProBatchGetFeedDetailReq, IGProBatchGetFeedDetailCallback iGProBatchGetFeedDetailCallback);

    void batchManageOperate(GProBatchManageOperateReq gProBatchManageOperateReq, IGProBatchManageOperateCallback iGProBatchManageOperateCallback);

    void batchTransThirdPlatformURL(GProBatchTransThirdPlatformURLReq gProBatchTransThirdPlatformURLReq, IGProBatchTransThirdPlatformURCallback iGProBatchTransThirdPlatformURCallback);

    void clearFeedsRecentViewHistory(IGproFeedOperateCallback iGproFeedOperateCallback);

    void createShare(GProCreateShareReq gProCreateShareReq, int i3, IGProCreateShareCallback iGProCreateShareCallback);

    GProBusiData decodeBusiData(byte[] bArr);

    GProStFeed decodeStFeed(byte[] bArr);

    void delFeed(GProStDelFeedReq gProStDelFeedReq, IGProDelFeedCallback iGProDelFeedCallback);

    void deleteFeedInteractNotice(GProDeleteInteractReq gProDeleteInteractReq, IGProDeleteFeedInteractNoticeCallback iGProDeleteFeedInteractNoticeCallback);

    void doComment(GProStDoCommentReq gProStDoCommentReq, IGProDoCommentCallback iGProDoCommentCallback);

    void doFeedPrefer(GProDoFeedPreferReq gProDoFeedPreferReq, IGProDoFeedPreferCallback iGProDoFeedPreferCallback);

    void doLike(GProStDoLikeReq gProStDoLikeReq, IGProDoLikeCallback iGProDoLikeCallback);

    void doReply(GProStDoReplyReq gProStDoReplyReq, IGProDoReplyCallback iGProDoReplyCallback);

    void downloadFeedRichMedia(FeedRichMediaDownloadReq feedRichMediaDownloadReq);

    byte[] encodeGProGetGuildFeedsRsp(GProGetGuildFeedsRsp gProGetGuildFeedsRsp);

    byte[] encodeGProStGetChannelFeedsRsp(GProStGetChannelFeedsRsp gProStGetChannelFeedsRsp);

    byte[] encodeGProTopFeed(GProTopFeed gProTopFeed);

    byte[] encodeStFeed(GProStFeed gProStFeed);

    void getAllFeedNotices(GProGetFeedNoticesReq gProGetFeedNoticesReq, boolean z16, IGProGetAllFeedNoticesCallback iGProGetAllFeedNoticesCallback);

    void getChannelDraft(String str, IGProGetChannelDraftCallback iGProGetChannelDraftCallback);

    void getChannelRecommendFeeds(GProStGetChannelFeedsReq gProStGetChannelFeedsReq, IGProGetChannelTimelineFeedsCallback iGProGetChannelTimelineFeedsCallback);

    void getChannelTimelineFeeds(GProStGetChannelFeedsReq gProStGetChannelFeedsReq, boolean z16, IGProGetChannelTimelineFeedsCallback iGProGetChannelTimelineFeedsCallback);

    void getDetailRecommendFeeds(GProGetDetailRecommendFeedsReq gProGetDetailRecommendFeedsReq, IGProGetDetailRecommendFeedsCallback iGProGetDetailRecommendFeedsCallback);

    void getDynamicPageRecommend(GProGetDynamicPageRecommendReq gProGetDynamicPageRecommendReq, IGProGetDynamicPageRecommendCallback iGProGetDynamicPageRecommendCallback);

    void getExternalComments(GProGetExternalCommentsReq gProGetExternalCommentsReq, IGProGetExternalCommentsCallback iGProGetExternalCommentsCallback);

    void getFeedComments(GProStGetFeedCommentsReq gProStGetFeedCommentsReq, IGProGetFeedCommentsCallback iGProGetFeedCommentsCallback);

    void getFeedCount(GProGetFeedCountReq gProGetFeedCountReq, IGProGetFeedCountCallback iGProGetFeedCountCallback);

    void getFeedDetail(GProStGetFeedDetailReq gProStGetFeedDetailReq, boolean z16, IGProGetFeedDetailCallback iGProGetFeedDetailCallback);

    void getFeedDetailWithHotComments(GProStGetFeedDetailReq gProStGetFeedDetailReq, IGProGetFeedDetailWithHotCommentsCallback iGProGetFeedDetailWithHotCommentsCallback);

    void getFeedLikeUserList(GProFeedLikeUserListReq gProFeedLikeUserListReq, int i3, IGProGetFeedLikeUserListCallback iGProGetFeedLikeUserListCallback);

    void getFeedNotices(GProGetFeedNoticesReq gProGetFeedNoticesReq, boolean z16, IGProGetFeedNoticesCallback iGProGetFeedNoticesCallback);

    String getFeedRichMediaFilePath(int i3, String str, String str2, int i16, boolean z16);

    void getFeeds(GProGetFeedsReq gProGetFeedsReq, IGProgetFeedsCallback iGProgetFeedsCallback);

    void getFeedsByIndex(GProGetFeedsByIndexReq gProGetFeedsByIndexReq, IGProGetFeedsByIndexCallback iGProGetFeedsByIndexCallback);

    void getGuildFeeds(GProGetGuildFeedsReq gProGetGuildFeedsReq, boolean z16, IGProGetGuildFeedsCallback iGProGetGuildFeedsCallback);

    void getImmersiveFeeds(GProGetImmersiveFeedsReq gProGetImmersiveFeedsReq, IGProGetImmersiveFeedsCallback iGProGetImmersiveFeedsCallback);

    void getJoinedRecommendItems(GProGetJoinedRecommendItemsReq gProGetJoinedRecommendItemsReq, boolean z16, IGProGetJoinedRecommendItemsCallback iGProGetJoinedRecommendItemsCallback);

    void getMultiChannelFeeds(GProGetMultiChannelFeedsReq gProGetMultiChannelFeedsReq, IGProGetMultiChannelFeedsCallback iGProGetMultiChannelFeedsCallback);

    void getMyJoinGuild(GProGetMyJoinGuildReq gProGetMyJoinGuildReq, boolean z16, IGProGetMyJoinGuildCallback iGProGetMyJoinGuildCallback);

    void getNextPageReplies(GProGetNextPageRepliesReq gProGetNextPageRepliesReq, IGProgetNextPageRepliesCallback iGProgetNextPageRepliesCallback);

    void getNotices(GProGetNoticesReq gProGetNoticesReq, boolean z16, IGProGetNoticesCallback iGProGetNoticesCallback);

    void getProfileFeeds(GProGetProfileFeedsReq gProGetProfileFeedsReq, boolean z16, IGProGetProfileFeedsCallback iGProGetProfileFeedsCallback);

    void getTopFeedConfig(GProGetTopFeedConfigReq gProGetTopFeedConfigReq, IGProGetTopFeedConfigCallback iGProGetTopFeedConfigCallback);

    void getTopFeeds(GProGetTopFeedsReq gProGetTopFeedsReq, IGProGetTopFeedsCallback iGProGetTopFeedsCallback);

    void getTopicFeeds(GProGetTopicFeedsReq gProGetTopicFeedsReq, IGProGetTopicFeedsCallback iGProGetTopicFeedsCallback);

    void getUserPageDigestContentList(GProGetUserPageDigestContentListReq gProGetUserPageDigestContentListReq, IGProGetUserPageDigestContentListCallback iGProGetUserPageDigestContentListCallback);

    void impeach(GProImpeachReq gProImpeachReq, IGProImpeachCallback iGProImpeachCallback);

    void moveFeed(GProMoveFeedReq gProMoveFeedReq, IGProMoveFeedCallback iGProMoveFeedCallback);

    void preloadGuildFeeds(GProPreloadGuildFeedsReq gProPreloadGuildFeedsReq, IGProPreloadGuildFeedsCallback iGProPreloadGuildFeedsCallback);

    void publishFeed(GProStPublishFeedReq gProStPublishFeedReq, IGPropublishFeedCallback iGPropublishFeedCallback);

    void removeKernelFeedListener(long j3);

    void reportRecentViewFeed(GProReportRecentViewFeedReq gProReportRecentViewFeedReq, IGproFeedOperateCallback iGproFeedOperateCallback);

    void searchTopic(GProSearchTopicReq gProSearchTopicReq, IGProSearchTopicCallback iGProSearchTopicCallback);

    void sendDataReport(GProStDataReportReq gProStDataReportReq, IGProFeedDataReportCallback iGProFeedDataReportCallback);

    void setChannelDraft(String str, String str2, IGproFeedOperateCallback iGproFeedOperateCallback);

    void setTopComment(GProSetTopCommentReq gProSetTopCommentReq, IGProSetTopCommentCallback iGProSetTopCommentCallback);

    void topChannelFeed(GProTopChannelFeedReq gProTopChannelFeedReq, IGProTopChannelFeedCallback iGProTopChannelFeedCallback);

    void topFeedAction(GProTopFeedActionReq gProTopFeedActionReq, IGProTopFeedActionCallback iGProTopFeedActionCallback);

    void unDoDelFeed(GProUnDoDelFeedReq gProUnDoDelFeedReq, IGProUnDoDelFeedCallback iGProUnDoDelFeedCallback);

    void updateFeedInteractBlockedStatus(GProUPdateFeedInteractSwitchReq gProUPdateFeedInteractSwitchReq, IGProUpdateFeedInteractBlockedStatusCallback iGProUpdateFeedInteractBlockedStatusCallback);
}
