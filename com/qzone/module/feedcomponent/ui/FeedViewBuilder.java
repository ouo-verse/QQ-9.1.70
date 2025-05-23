package com.qzone.module.feedcomponent.ui;

import NS_MOBILE_FEEDS.stPhotoTag;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.qzone.module.feedcomponent.ui.DataPreCalculateTool;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasAttachView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasCellCommentView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommAction;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellAdvContainerAttach;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.CellLeftThumb;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.FeedPictureInfo;
import com.qzone.proxy.feedcomponent.model.MusicInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedViewBuilder {
    private static final String TAG = "FeedViewBuilder";

    public static CellPictureInfo doConvertFeedPictureInfo(BusinessFeedData businessFeedData) {
        ArrayList<BusinessFeedData> recBusinessFeedDatas = businessFeedData.getRecBusinessFeedDatas();
        CellPictureInfo cellPictureInfo = null;
        if (recBusinessFeedDatas != null && recBusinessFeedDatas.size() > 0) {
            for (int i3 = 0; i3 < recBusinessFeedDatas.size(); i3++) {
                CellPictureInfo pictureInfo = recBusinessFeedDatas.get(i3).getPictureInfo();
                if (pictureInfo != null) {
                    if (cellPictureInfo == null) {
                        cellPictureInfo = pictureInfo;
                    } else {
                        cellPictureInfo.pics.add(pictureInfo.pics.get(0));
                    }
                }
            }
        }
        return cellPictureInfo;
    }

    public static FeedView generateFeedView(Context context, com.qzone.proxy.feedcomponent.ui.g gVar, boolean z16, boolean z17) {
        FeedView feedView = new FeedView(context, z16);
        feedView.setOnFeedElementClickListener(gVar);
        if (z17) {
            feedView.getPlayBarView();
        }
        return feedView;
    }

    public static void preCalculateFeedView(Context context, DataPreCalculateTool.PreMeasureFeedView preMeasureFeedView, BusinessFeedData businessFeedData, boolean z16, boolean z17) {
        com.qzone.proxy.feedcomponent.b.e("CANVAS", "FeedViewBuilder preCalculateFeedView!");
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(FeedGlobalEnv.g().getScreenWidth(), 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        CanvasTitleView canvasTitleView = preMeasureFeedView.mCanvasTitleView;
        canvasTitleView.setFeedData(businessFeedData, false, false);
        canvasTitleView.update();
        canvasTitleView.measure(makeMeasureSpec, makeMeasureSpec2);
        CanvasAttachView canvasAttachView = preMeasureFeedView.mAttachView;
        canvasAttachView.setRemarkInfo(businessFeedData.getRemarkInfoV2());
        canvasAttachView.setReferInfo(businessFeedData.getReferInfoV2());
        canvasAttachView.setLbsInfo(businessFeedData.getLbsInfoV2());
        canvasAttachView.setTitleInfo(businessFeedData.getTitleInfoV2());
        canvasAttachView.setFeedData(businessFeedData);
        canvasAttachView.update();
        canvasAttachView.measure(makeMeasureSpec, makeMeasureSpec2);
        PraiseListView praiseListView = preMeasureFeedView.mPraiseView;
        praiseListView.setLikeInfo(businessFeedData, businessFeedData.getLikeInfoV2(), false, -1);
        praiseListView.setRedPocketInfo(businessFeedData.getCellRedBonus(), businessFeedData);
        praiseListView.setSpaceRedPocketInfo(businessFeedData.getCellLuckyMoney(), businessFeedData);
        praiseListView.setForwardListInfo(businessFeedData.getCellForwardInfo(), businessFeedData);
        praiseListView.setCommentCountInfo(businessFeedData.getCommentInfoV2(), businessFeedData);
        praiseListView.update();
        praiseListView.measure(makeMeasureSpec, makeMeasureSpec2);
        CanvasCellCommentView canvasCellCommentView = preMeasureFeedView.mCanvasCommentView;
        if (businessFeedData.getCommentInfoV2() != null) {
            canvasCellCommentView.setFeedData(businessFeedData);
            canvasCellCommentView.setCommentInfo(businessFeedData.getCommentInfoV2(), businessFeedData.getCommentInfoV2().commentState, businessFeedData.getCommentInfoV2().moreCommentHasLoaded > 0 ? 258 : 257, true);
            canvasCellCommentView.measure(makeMeasureSpec, makeMeasureSpec2);
        }
        CanvasFeedContentView canvasFeedContentView = preMeasureFeedView.mCanvasFeedContentView;
        canvasFeedContentView.setContentInfo(businessFeedData, null, com.qzone.adapter.feedcomponent.i.H().W(), false, false);
        canvasFeedContentView.measure(makeMeasureSpec, makeMeasureSpec2);
    }

    static boolean setCommentData(Context context, FeedComment feedComment, BusinessFeedData businessFeedData, boolean z16) {
        return setCommentData(context, feedComment, businessFeedData, 15, z16);
    }

    public static void setFeedDataInternal(Context context, AbsFeedView absFeedView, BusinessFeedData businessFeedData, boolean z16, boolean z17) {
        setFeedDataInternal(context, absFeedView, businessFeedData, null);
    }

    public static void setFeedViewData(Context context, AbsFeedView absFeedView, BusinessFeedData businessFeedData) {
        setFeedViewData(context, absFeedView, businessFeedData, false, false);
    }

    public static void updateFollowInfo(Context context, AbsFeedView absFeedView, BusinessFeedData businessFeedData) {
        CanvasTitleView canvasTitleView;
        FeedView feedView = (FeedView) absFeedView;
        if (!businessFeedData.isCardFriendsRecommendContainerFeed() && !businessFeedData.isCardSchoolRecommendContainerFeed() && !businessFeedData.isCardSpecialFollowMoreRecommendContainerFeed() && !businessFeedData.isCardFollowMoreRecommendContainerFeed()) {
            if (businessFeedData.getFeedCommInfo().isBizRecomFamousFeeds() && feedView.getFeedContent() != null && feedView.getFeedContent().mAutoVideo != null) {
                canvasTitleView = feedView.getFeedContent().mAutoVideo.getTitleView();
            } else {
                canvasTitleView = feedView.getFeedTitle() != null ? feedView.getFeedTitle().mCanvasTitleView : null;
            }
            if (canvasTitleView != null) {
                canvasTitleView.update();
            }
            if (businessFeedData.needShowForwardTitle()) {
                CanvasTitleView canvasTitleView2 = feedView.getFeedForwardTitle() != null ? feedView.getFeedForwardTitle().mCanvasTitleView : null;
                if (canvasTitleView2 != null) {
                    canvasTitleView2.update();
                }
            }
            if (!businessFeedData.isQzoneCardFeed() || feedView.getQzoneCardView() == null) {
                return;
            }
            feedView.getQzoneCardView().update();
            return;
        }
        FeedRecommendFriendsHorizontalCardView recommendFriendsHorizontalCardView = feedView.getRecommendFriendsHorizontalCardView();
        if (recommendFriendsHorizontalCardView != null) {
            if (businessFeedData.isCardSpecialFollowMoreRecommendContainerFeed()) {
                recommendFriendsHorizontalCardView.updateSpecialFollowState();
            } else {
                recommendFriendsHorizontalCardView.updateFollowState();
            }
        }
    }

    private static void updateTopDrawable(BusinessFeedData businessFeedData, FeedView feedView) {
        FeedAutoVideo autoVideoView = feedView.getAutoVideoView();
        if (autoVideoView == null) {
            return;
        }
        if (businessFeedData.getRecommAction() != null && businessFeedData.getRecommAction().extendInfo != null && businessFeedData.getRecommAction().extendInfo.containsKey(24)) {
            final String str = businessFeedData.getRecommAction().extendInfo.get(24);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            final WeakReference weakReference = new WeakReference(feedView);
            autoVideoView.setVideoPlayStartListener(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedViewBuilder.1
                @Override // java.lang.Runnable
                public void run() {
                    FeedView feedView2 = (FeedView) weakReference.get();
                    if (feedView2 == null) {
                        return;
                    }
                    Drawable K = com.qzone.adapter.feedcomponent.i.H().K(str, false);
                    if (K != null) {
                        K.setCallback(feedView2);
                    }
                    feedView2.setTopDrawable(K);
                }
            });
            return;
        }
        feedView.setTopDrawable(null);
        autoVideoView.setVideoPlayStartListener(null);
    }

    static boolean setCommentData(Context context, FeedComment feedComment, BusinessFeedData businessFeedData, int i3, boolean z16) {
        boolean z17;
        if (feedComment == null) {
            return false;
        }
        feedComment.setPhotoMode(checkShowBigPhoto(context, com.qzone.adapter.feedcomponent.i.H().W()));
        CellCommentInfo commentInfoV2 = businessFeedData.getCommentInfoV2();
        if (commentInfoV2 != null) {
            CellCommentInfo.CommentState commentState = commentInfoV2.commentState;
            if (commentState == null) {
                commentInfoV2.commentState = CellCommentInfo.CommentState.FOLDED;
                com.qzone.proxy.feedcomponent.b.i("CommentState", "commentState is null !!");
            } else if (commentState == CellCommentInfo.CommentState.LOADING) {
                commentInfoV2.commentState = CellCommentInfo.CommentState.FOLDED;
            }
        }
        feedComment.setIsPassive(false);
        feedComment.setFeedData(businessFeedData);
        feedComment.setUseWhiteBg(z16);
        feedComment.setLikeInfo(businessFeedData.getLikeInfoV2());
        feedComment.setRedBonusInfo(businessFeedData.getCellRedBonus());
        feedComment.setLuckyMoneyInfo(businessFeedData.getCellLuckyMoney());
        feedComment.setVisitorInfo(businessFeedData.getVisitorInfo());
        if (businessFeedData.isRecommendFeed()) {
            z17 = FeedComment.RECOMMEND_FEED_SHOW_COMMENT_BAR;
        } else {
            z17 = (businessFeedData.feedType == 12290 || !businessFeedData.getLocalInfo().canComment || businessFeedData.isSubFeed) ? false : true;
        }
        feedComment.setShowGuide(z17);
        feedComment.setCommentInfo(businessFeedData.getCommentInfoV2(), false);
        feedComment.update();
        return commentInfoV2 == null && businessFeedData.getLikeInfoV2() == null;
    }

    public static void setFeedDataInternal(Context context, AbsFeedView absFeedView, BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
        if ((absFeedView instanceof FeedView) && businessFeedData != null) {
            u8.a.a("setFeedDataInternal");
            FeedView feedView = (FeedView) absFeedView;
            if (feedViewOptions == null) {
                feedViewOptions = new FeedViewSection.FeedViewOptions();
            }
            feedView.beginSetData();
            feedView.setData(businessFeedData);
            if (businessFeedData.isGDTAdvFeed() && businessFeedData.getCellDecorateInfo() != null && businessFeedData.getCellDecorateInfo().cellCustomPraise != null) {
                com.qzone.proxy.feedcomponent.service.a.b().d(businessFeedData.getCellDecorateInfo().cellCustomPraise);
            }
            com.qzone.proxy.feedcomponent.b.c("DebugFeedView", "setFeedDataInternal ugckey:" + businessFeedData.getFeedCommInfo().ugckey + " feeddview:" + Integer.valueOf(feedView.hashCode()));
            if (com.qzone.adapter.feedcomponent.i.H().S0() && !businessFeedData.hasCalculate) {
                businessFeedData.preCalculate(false);
            }
            feedViewOptions.canComment = false;
            feedViewOptions.canReply = false;
            feedViewOptions.isMessage = false;
            feedViewOptions.isInterest = businessFeedData.getCellInterest() != null;
            if (com.qzone.adapter.feedcomponent.i.f41890d && !com.qzone.adapter.feedcomponent.i.O0()) {
                feedViewOptions.titleGapVisible = false;
            } else {
                feedViewOptions.titleGapVisible = true;
            }
            feedViewOptions.setContext(context);
            feedView.showFrameLine(businessFeedData.isSubOfMultiAdvContainerFeed() || businessFeedData.isSubOfSingleAdvContainerNewStyle() || businessFeedData.getFeedCommInfo().isPicUpLayout() || businessFeedData.isSubOfFriendBirthdayContainerFeed());
            feedView.needBackground((businessFeedData.isSubOfMultiAdvContainerFeed() || businessFeedData.isSubOfSingleAdvContainerFeed() || businessFeedData.isSpecialCareInContainerFeed() || businessFeedData.isSubOfFriendBirthdayContainerFeed() || businessFeedData.isCardFriendsRecommendContainerFeed() || businessFeedData.isCardSpecialFollowMoreRecommendContainerFeed() || businessFeedData.isCardSchoolRecommendContainerFeed() || businessFeedData.isCardFollowMoreRecommendContainerFeed() || businessFeedData.getFeedCommInfo().isBizRecomFamousFeeds() || (businessFeedData.getFeedCommInfo().isBizRecomFeeds() && businessFeedData.getFeedCommInfo().isPicUpLayout()) || businessFeedData.isSubFeed) ? false : true);
            BusinessFeedData businessFeedData2 = businessFeedData.parentFeedData;
            if (businessFeedData2 != null && businessFeedData2.isFriendLikeContainer()) {
                feedView.setIsLikeFriendContainer(true);
                feedView.showFrameLine(true);
                feedView.needBackground(false);
            } else {
                feedView.setIsLikeFriendContainer(false);
            }
            feedView.setData(businessFeedData, feedViewOptions);
            feedView.finishSetData();
            updateTopDrawable(businessFeedData, feedView);
            u8.a.b();
        }
    }

    public static void setFeedViewData(Context context, AbsFeedView absFeedView, BusinessFeedData businessFeedData, boolean z16) {
        setFeedViewData(context, absFeedView, businessFeedData, z16, false);
    }

    public static void updateLikeInfo(Context context, AbsFeedView absFeedView, BusinessFeedData businessFeedData) {
        FeedView feedView = (FeedView) absFeedView;
        if (businessFeedData.getFeedCommInfo().isBizRecomFeeds()) {
            setFeedViewData(context, absFeedView, businessFeedData);
            return;
        }
        setCommentData(context, feedView.getFeedComment(), businessFeedData, feedView.useWhiteCommentBg());
        if (feedView.getFeedComment() != null) {
            feedView.getFeedComment().setFeedData(businessFeedData);
        }
        FeedOperation feedOperation = feedView.getFeedOperation();
        if (feedOperation != null) {
            feedOperation.setFakeType(businessFeedData.getLocalInfo().fakeType);
            if (!businessFeedData.getFeedCommInfo().isQbossPurchaseFeeds() && (businessFeedData.getRecommAction() == null || !businessFeedData.isNewAdvStyle())) {
                feedOperation.setCanPraise(businessFeedData.getLocalInfo().canLike);
                feedOperation.setCanComment(businessFeedData.getLocalInfo().canComment);
                feedOperation.setCanForward(canForward(businessFeedData));
            } else {
                feedOperation.setCanPraise(false);
                feedOperation.setCanComment(false);
                feedOperation.setCanForward(false);
            }
            warnNullCelllikeinfo(businessFeedData);
            feedOperation.setHasPraised(businessFeedData.getLikeInfoV2() != null ? businessFeedData.getLikeInfoV2().isLiked : false);
            feedOperation.updateLikeInfo(businessFeedData);
        }
        absFeedView.requestLayout();
    }

    public static FeedPictureInfo[] convertPics(CellPictureInfo cellPictureInfo, VideoInfo videoInfo, MusicInfo musicInfo, boolean z16) {
        if (cellPictureInfo == null) {
            return doConvertMusic(musicInfo);
        }
        return doConvertPics(cellPictureInfo.pics, videoInfo, musicInfo, z16);
    }

    public static FeedPictureInfo[] convertPics4attach(CellAdvContainerAttach cellAdvContainerAttach, VideoInfo videoInfo, MusicInfo musicInfo, boolean z16) {
        if (cellAdvContainerAttach != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(cellAdvContainerAttach.picinfo);
            return doConvertPics(arrayList, videoInfo, musicInfo, z16);
        }
        return doConvertMusic(musicInfo);
    }

    static void setFeedAdvContainerData(FeedAdvContainer feedAdvContainer, BusinessFeedData businessFeedData) {
        if (feedAdvContainer != null) {
            feedAdvContainer.setFeedData(businessFeedData);
        }
    }

    static void setFeedContainerData(FeedContainer feedContainer, BusinessFeedData businessFeedData) {
        if (feedContainer != null) {
            feedContainer.setFeedData(businessFeedData);
        }
    }

    static void setFeedGalleryContainerData(FeedGalleryContainer feedGalleryContainer, BusinessFeedData businessFeedData) {
        if (feedGalleryContainer != null) {
            feedGalleryContainer.setFeedData(businessFeedData);
        }
    }

    public static void setFeedViewData(Context context, AbsFeedView absFeedView, BusinessFeedData businessFeedData, boolean z16, boolean z17) {
        com.qzone.adapter.feedcomponent.i.B2(com.qzone.adapter.feedcomponent.i.H().t1(context));
        if (absFeedView instanceof FeedView) {
            setFeedDataInternal(context, (FeedView) absFeedView, businessFeedData, z16, z17);
            return;
        }
        if (absFeedView instanceof FeedContainer) {
            setFeedContainerData((FeedContainer) absFeedView, businessFeedData);
            return;
        }
        if (absFeedView instanceof FunctionGuideFeedView) {
            ((FunctionGuideFeedView) absFeedView).setData(businessFeedData);
            return;
        }
        if (absFeedView instanceof FriendAnniversaryFeedView) {
            ((FriendAnniversaryFeedView) absFeedView).setData(businessFeedData);
            return;
        }
        if (absFeedView instanceof FeedGalleryContainer) {
            setFeedGalleryContainerData((FeedGalleryContainer) absFeedView, businessFeedData);
            return;
        }
        if (absFeedView instanceof NegativeFeedbackFeedView) {
            ((NegativeFeedbackFeedView) absFeedView).setData(businessFeedData, 1);
            return;
        }
        if (absFeedView instanceof RecomFollowVerticalFeedView) {
            ((RecomFollowVerticalFeedView) absFeedView).setData(businessFeedData);
            return;
        }
        if (absFeedView instanceof QzoneSecretFeedView) {
            ((QzoneSecretFeedView) absFeedView).setData(businessFeedData);
            return;
        }
        if (absFeedView instanceof FriendVideoFeedView) {
            ((FriendVideoFeedView) absFeedView).setData(businessFeedData);
            return;
        }
        if (absFeedView instanceof FrdLikeVideoFeedView) {
            ((FrdLikeVideoFeedView) absFeedView).setFeedData(businessFeedData);
            return;
        }
        if (absFeedView instanceof RegisterAnniversaryFeedView) {
            ((RegisterAnniversaryFeedView) absFeedView).setData(businessFeedData);
            return;
        }
        if (absFeedView instanceof FeedAdvContainer) {
            setFeedAdvContainerData((FeedAdvContainer) absFeedView, businessFeedData);
            return;
        }
        if (absFeedView instanceof FrdLikeVideoSlideFeedView) {
            absFeedView.setData(businessFeedData);
            return;
        }
        com.qzone.proxy.feedcomponent.b.c("DebugFeedView", "setFeedViewData error! Cann't recogonized its type! " + absFeedView);
    }

    public static <T> T[] toArray(T... tArr) {
        if (tArr == null || tArr.length == 0) {
            return null;
        }
        return tArr;
    }

    private static void warnNullCelllikeinfo(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getLikeInfoV2() != null || businessFeedData.getFeedCommInfo() == null) {
            return;
        }
        com.qzone.proxy.feedcomponent.b.a(TAG, businessFeedData.getFeedCommInfo().feedsid + " cellLikeInfo == null");
    }

    static FeedPictureInfo[] doConvertMusic(MusicInfo musicInfo) {
        if (musicInfo == null) {
            return null;
        }
        FeedPictureInfo[] feedPictureInfoArr = new FeedPictureInfo[1];
        PictureUrl pictureUrl = musicInfo.coverUrl;
        if (pictureUrl == null) {
            return feedPictureInfoArr;
        }
        feedPictureInfoArr[0] = new FeedPictureInfo(FeedPictureInfo.ImageType.MUSIC, pictureUrl, new String[0]);
        return feedPictureInfoArr;
    }

    public static boolean isisGoldenCudgel(PictureUrl pictureUrl) {
        int i3;
        int i16;
        return (pictureUrl == null || (i3 = pictureUrl.width) == 0 || (i16 = pictureUrl.height) == 0 || i3 * 5 >= i16) ? false : true;
    }

    public static void updateFeedTitle(AbsFeedView absFeedView, BusinessFeedData businessFeedData, @Deprecated Boolean bool) {
        CanvasTitleView canvasTitleView;
        if (businessFeedData == null) {
            return;
        }
        FeedView feedView = (FeedView) absFeedView;
        if (businessFeedData.getFeedCommInfo().isBizRecomFamousFeeds() && feedView.getFeedContent() != null && feedView.getFeedContent().mAutoVideo != null) {
            canvasTitleView = feedView.getFeedContent().mAutoVideo.getTitleView();
        } else {
            canvasTitleView = feedView.getFeedTitle() != null ? feedView.getFeedTitle().mCanvasTitleView : null;
        }
        if (canvasTitleView != null) {
            canvasTitleView.updateGapAlpha();
        }
    }

    public static void updateRecommendListInfo(Context context, FeedView feedView, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        FeedTitle feedTitle = feedView.getFeedTitle();
        if (feedTitle != null) {
            feedTitle.update();
        }
        FeedOperation feedOperation = feedView.getFeedOperation();
        if (feedOperation != null) {
            feedOperation.updateOperation(businessFeedData);
        }
        feedView.requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
    
        if (com.qzone.adapter.feedcomponent.i.a1(r1) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean canForward(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return false;
        }
        int i3 = businessFeedData.getFeedCommInfo().appid;
        if (!businessFeedData.getFeedCommInfo().isYunYingFeeds() && !businessFeedData.isSubFeed) {
            com.qzone.adapter.feedcomponent.i.H();
            if (!com.qzone.adapter.feedcomponent.i.c1(i3)) {
                com.qzone.adapter.feedcomponent.i.H();
                if (!com.qzone.adapter.feedcomponent.i.b1(i3)) {
                    com.qzone.adapter.feedcomponent.i.H();
                }
            }
            if (businessFeedData.getAudioInfo() == null) {
                return true;
            }
        }
        return businessFeedData.getLocalInfo().canForward || businessFeedData.getLocalInfo().canQuote || businessFeedData.getLocalInfo().canShare;
    }

    static boolean hasPhoto(CellLeftThumb cellLeftThumb) {
        PictureItem pictureItem;
        PictureUrl pictureUrl;
        return (cellLeftThumb == null || (pictureItem = cellLeftThumb.getPictureItem()) == null || (pictureUrl = pictureItem.currentUrl) == null || TextUtils.isEmpty(pictureUrl.url)) ? false : true;
    }

    public static void setLeftThumbDatas(FeedContent feedContent, CellLeftThumb cellLeftThumb, boolean z16) {
        if (feedContent == null) {
            return;
        }
        if (cellLeftThumb != null) {
            cellLeftThumb.getParseTitle();
            cellLeftThumb.getParseSummary();
            feedContent.setLeftThumbData(cellLeftThumb);
            feedContent.setLeftThumbPictureInfo(cellLeftThumb.getPictureInfo());
            feedContent.setIsPassive(z16);
            return;
        }
        feedContent.setLeftThumbData(cellLeftThumb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void setRecommActionData(CanvasRecommAction canvasRecommAction, BusinessFeedData businessFeedData) {
        ArrayList<BusinessFeedData> recBusinessFeedDatas;
        BusinessFeedData businessFeedData2;
        if (canvasRecommAction == null || businessFeedData == null || (businessFeedData.getFeedCommInfo().feedsAttr & 32768) > 0 || businessFeedData.isCanvasAd()) {
            return;
        }
        if ((!businessFeedData.isSingleAdvContainerFeed() || businessFeedData.isSubFeed || businessFeedData.isAdvContainerThreeGridStyle()) && businessFeedData.getRecommAction() != null && businessFeedData.getRecommAction().isHideActionArea == 0) {
            if (businessFeedData.containerSubType == 1 && !businessFeedData.isAdvContainerThreeGridStyle() && (recBusinessFeedDatas = businessFeedData.getRecBusinessFeedDatas()) != null && businessFeedData.currShowIndex >= 0) {
                int size = recBusinessFeedDatas.size();
                int i3 = businessFeedData.currShowIndex;
                if (size > i3 && (businessFeedData2 = recBusinessFeedDatas.get(i3)) != null) {
                    businessFeedData2.getRecommAction();
                }
            }
            canvasRecommAction.setFeedData(businessFeedData);
            canvasRecommAction.update();
        }
    }

    public static FeedPictureInfo[] doConvertPics(List<PictureItem> list, VideoInfo videoInfo, MusicInfo musicInfo, boolean z16) {
        String[] strArr;
        PictureUrl pictureUrl;
        PictureUrl pictureUrl2;
        int i3;
        FeedPictureInfo.ImageType imageType;
        char c16;
        VideoInfo videoInfo2;
        FeedPictureInfo feedPictureInfo;
        PictureUrl pictureUrl3;
        String[] strArr2;
        if (list == null || list.size() <= 0) {
            return null;
        }
        int size = list.size();
        FeedPictureInfo[] feedPictureInfoArr = new FeedPictureInfo[size];
        char c17 = 0;
        int i16 = 0;
        while (i16 < size) {
            PictureItem pictureItem = list.get(i16);
            if (pictureItem instanceof PictureItem) {
                PictureItem pictureItem2 = pictureItem;
                if (z16) {
                    if (size == 1) {
                        pictureUrl3 = pictureItem2.currentUrl;
                        String[] strArr3 = new String[1];
                        strArr3[c17] = pictureItem2.localFileUrl;
                        strArr2 = (String[]) toArray(strArr3);
                    } else {
                        pictureUrl3 = pictureItem2.currentUrl;
                        String[] strArr4 = new String[3];
                        strArr4[c17] = pictureItem2.localFileUrl;
                        strArr4[1] = pictureItem2.bigUrl.url;
                        strArr4[2] = pictureUrl3.url;
                        strArr2 = (String[]) toArray(strArr4);
                    }
                    pictureUrl = pictureUrl3;
                    strArr = strArr2;
                } else {
                    PictureUrl pictureUrl4 = pictureItem2.bigUrl;
                    if (pictureUrl4 != null) {
                        int i17 = pictureUrl4.width;
                        if (i17 == 0 || (i3 = pictureUrl4.height) == 0 || i17 * 2 < i3) {
                            pictureUrl2 = pictureItem2.currentUrl;
                            String[] strArr5 = new String[3];
                            strArr5[c17] = pictureItem2.localFileUrl;
                            strArr5[1] = pictureUrl4.url;
                            strArr5[2] = pictureUrl2.url;
                            strArr = (String[]) toArray(strArr5);
                        } else if (size > 1) {
                            pictureUrl2 = pictureItem2.currentUrl;
                            String[] strArr6 = new String[3];
                            strArr6[c17] = pictureItem2.localFileUrl;
                            strArr6[1] = pictureUrl4.url;
                            strArr6[2] = pictureUrl2.url;
                            strArr = (String[]) toArray(strArr6);
                        } else {
                            pictureUrl2 = pictureItem2.currentUrl;
                            String[] strArr7 = new String[4];
                            strArr7[c17] = pictureItem2.localFileUrl;
                            strArr7[1] = pictureUrl4.url;
                            String str = pictureUrl2.url;
                            strArr7[2] = str;
                            strArr7[3] = str;
                            strArr = (String[]) toArray(strArr7);
                        }
                        pictureUrl = pictureUrl2;
                    } else {
                        strArr = null;
                        pictureUrl = null;
                    }
                }
                if (!pictureItem2.isGoldenCudgel() && !isisGoldenCudgel(pictureItem2.currentUrl)) {
                    imageType = FeedPictureInfo.ImageType.NORMAL;
                } else {
                    imageType = FeedPictureInfo.ImageType.IMAGE_GOLDEN_CUDGEL;
                }
                if (pictureUrl != null && !pictureItem2.isFakeLongPic()) {
                    if (pictureUrl.pictureType == 2) {
                        imageType = FeedPictureInfo.ImageType.IMAGE_GIF;
                    }
                    if (pictureItem2.type == 2) {
                        imageType = FeedPictureInfo.ImageType.IMAGE_GIF;
                    } else if (musicInfo != null) {
                        if (musicInfo.coverUrl != null) {
                            imageType = FeedPictureInfo.ImageType.MUSIC;
                        }
                    } else if (pictureItem2.isBallPanorama()) {
                        imageType = FeedPictureInfo.ImageType.BALL_PANORAMA;
                    } else if (pictureItem2.isCirclePanorama()) {
                        imageType = FeedPictureInfo.ImageType.CIRCLE_PANORAMA;
                    }
                }
                FeedPictureInfo.ImageType imageType2 = imageType;
                if (pictureItem2.type == 2) {
                    feedPictureInfoArr[i16] = new FeedPictureInfo(imageType2, pictureUrl, pictureItem2.bigUrl, pictureItem2.isAutoPlayGif, pictureItem2.pivotXRate, pictureItem2.pivotYRate, pictureItem2.actiontype, pictureItem2.actionurl, strArr);
                } else {
                    feedPictureInfoArr[i16] = new FeedPictureInfo(imageType2, pictureUrl, pictureItem2.pivotXRate, pictureItem2.pivotYRate, pictureItem2.actiontype, pictureItem2.actionurl, strArr);
                }
                FeedPictureInfo feedPictureInfo2 = feedPictureInfoArr[i16];
                feedPictureInfo2.f50255r = i16;
                if (size == 1 && pictureItem2.type == 3) {
                    c16 = 0;
                    feedPictureInfoArr[0].f50252o = true;
                } else {
                    c16 = 0;
                }
                ArrayList<stPhotoTag> arrayList = pictureItem2.photoTag;
                if (arrayList != null && feedPictureInfo2 != null) {
                    feedPictureInfo2.t(arrayList);
                }
                feedPictureInfoArr[i16].p(pictureItem2.isGoldenCudgel());
                Map<Integer, String> map = pictureItem2.busi_param;
                if (map != null && (feedPictureInfo = feedPictureInfoArr[i16]) != null) {
                    feedPictureInfo.f50259v = map;
                }
                if (pictureItem2.videoflag == 1 && (videoInfo2 = pictureItem2.videodata) != null) {
                    FeedPictureInfo feedPictureInfo3 = feedPictureInfoArr[i16];
                    feedPictureInfo3.f50260w = 1;
                    feedPictureInfo3.f50261x = videoInfo2;
                }
                if (!TextUtils.isEmpty(pictureItem2.audio_summary)) {
                    feedPictureInfoArr[i16].m(pictureItem2.audio_summary);
                }
                if (pictureItem2.isBallPanorama() || pictureItem2.isCirclePanorama()) {
                    feedPictureInfoArr[i16].n(pictureItem2.bigUrl);
                    feedPictureInfoArr[i16].s(pictureItem2.originUrl);
                }
                feedPictureInfoArr[i16].o(pictureItem2.isFakeLongPic());
            } else {
                c16 = c17;
            }
            i16++;
            c17 = c16;
        }
        return feedPictureInfoArr;
    }

    public static int checkShowBigPhoto(Context context, int i3) {
        return i3;
    }
}
