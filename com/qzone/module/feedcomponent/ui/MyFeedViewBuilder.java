package com.qzone.module.feedcomponent.ui;

import NS_MOBILE_FEEDS.stPhotoTag;
import android.content.Context;
import android.text.TextUtils;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedDrawerView;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellGiftInfo;
import com.qzone.proxy.feedcomponent.model.CellLeftThumb;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.CellQbossPsvAdv;
import com.qzone.proxy.feedcomponent.model.CellTitleInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.FeedPictureInfo;
import com.qzone.proxy.feedcomponent.model.MusicInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class MyFeedViewBuilder {
    public static boolean setCommentAreaData(BusinessFeedData businessFeedData, FeedComment feedComment) {
        ArrayList<Comment> arrayList;
        ArrayList<Comment> arrayList2;
        CellCommentInfo commentInfoV2 = businessFeedData.getCommentInfoV2();
        if (commentInfoV2 == null || (arrayList2 = commentInfoV2.commments) == null || arrayList2.size() == 0) {
            commentInfoV2 = businessFeedData.getOriginalInfo() == null ? null : businessFeedData.getOriginalInfo().getCommentInfoV2();
        }
        int W = com.qzone.adapter.feedcomponent.i.H().W();
        if (com.qzone.adapter.feedcomponent.i.H().k1()) {
            feedComment.setShowGuide(false);
        } else if ((businessFeedData.getLocalInfo().canComment || businessFeedData.getLocalInfo().canReferComment || businessFeedData.getLocalInfo().canReply || businessFeedData.getLocalInfo().canReferReply) && !businessFeedData.getLocalInfo().canReturnGift) {
            feedComment.setShowGuide(true);
        } else {
            feedComment.setShowGuide(false);
        }
        feedComment.setIsPassive(true);
        boolean z16 = commentInfoV2 == null || (arrayList = commentInfoV2.commments) == null || arrayList.size() == 0;
        if (!z16 && !businessFeedData.hasHighFive) {
            feedComment.setCommentViewVisibile(true);
            feedComment.setPhotoMode(W);
            feedComment.setFeedData(businessFeedData);
            feedComment.setCommentInfo(commentInfoV2, true);
        } else {
            feedComment.setCommentViewVisibile(false);
            feedComment.setHintText(businessFeedData);
            feedComment.setFeedData(businessFeedData);
        }
        feedComment.update();
        return z16;
    }

    public static boolean setContentArea(BusinessFeedData businessFeedData, FeedView feedView, int i3, String str) {
        return setContentArea(businessFeedData, feedView.getFeedContent(), i3, str);
    }

    public static void setFeedViewData(AbsFeedView absFeedView, BusinessFeedData businessFeedData, boolean z16) {
        if (absFeedView instanceof FeedView) {
            FeedView feedView = (FeedView) absFeedView;
            feedView.beginSetData();
            com.qzone.adapter.feedcomponent.i.H().W();
            int i3 = businessFeedData.getFeedCommInfo().actiontype;
            boolean z17 = true;
            if (i3 != 0) {
                if (i3 == 1 && businessFeedData.getOriginalInfo() != null) {
                    String str = businessFeedData.getOriginalInfo().getIdInfo().cellId;
                }
            } else {
                String str2 = businessFeedData.getIdInfo().cellId;
            }
            feedView.setData(businessFeedData);
            CanvasFeedDrawerView feedDrawerView = feedView.getFeedDrawerView();
            if (feedDrawerView != null) {
                feedDrawerView.setVisibility(8);
            }
            FeedViewSection.FeedViewOptions feedViewOptions = new FeedViewSection.FeedViewOptions();
            feedViewOptions.isPassive = true;
            feedViewOptions.isMessage = false;
            feedViewOptions.canComment = businessFeedData.getLocalInfo().canComment || businessFeedData.getLocalInfo().canReferComment;
            if (!businessFeedData.getLocalInfo().canReply && !businessFeedData.getLocalInfo().canReferReply) {
                z17 = false;
            }
            feedViewOptions.canReply = z17;
            feedViewOptions.canReturnGift = businessFeedData.getLocalInfo().canReturnGift;
            feedViewOptions.canLookUp = businessFeedData.getLocalInfo().canLookUp;
            feedViewOptions.canJoinAlbum = businessFeedData.getLocalInfo().canJoinAlbum;
            feedViewOptions.joinedAlbum = businessFeedData.getLocalInfo().joinedAlbum;
            feedViewOptions.canGiveBack = businessFeedData.getFeedCommInfo().canGiveBack();
            feedView.setData(businessFeedData, feedViewOptions);
            feedView.finishSetData();
        }
    }

    public static void setGoodsData(FeedGoods feedGoods, BusinessFeedData businessFeedData, int i3) {
        FeedPictureInfo[] u16;
        if ((businessFeedData.getFeedCommInfo().feedsAttr & 2048) != 0 && (u16 = com.qzone.adapter.feedcomponent.d.u(businessFeedData, i3)) != null && u16.length > 0) {
            feedGoods.setGoodsPicture(u16[0]);
            feedGoods.setCellPictureInfo(businessFeedData.getPictureInfo());
        }
        feedGoods.update();
    }

    public static void setOperationData(FeedOperation feedOperation, BusinessFeedData businessFeedData, boolean z16) {
        feedOperation.setFeedData(businessFeedData);
        if (businessFeedData.getOriginalInfo() != null && businessFeedData.getOriginalInfo().getPermissionInfoV2() != null) {
            feedOperation.setPermissionInfo(businessFeedData.getOriginalInfo().getPermissionInfoV2());
        } else {
            feedOperation.setPermissionInfo(businessFeedData.getPermissionInfoV2());
        }
        if (businessFeedData.getOriginalInfo() != null && businessFeedData.getOriginalInfo().getReferInfoV2() != null) {
            feedOperation.setReferInfo(businessFeedData.getOriginalInfo().getReferInfoV2());
        } else {
            feedOperation.setReferInfo(businessFeedData.getReferInfoV2());
        }
        if (businessFeedData.getOriginalInfo() != null && businessFeedData.getOriginalInfo().getRemarkInfoV2() != null) {
            feedOperation.setRemarkInfo(businessFeedData.getOriginalInfo().getRemarkInfoV2());
        } else {
            feedOperation.setRemarkInfo(businessFeedData.getRemarkInfoV2());
        }
        FeedGlobalEnv.g();
        if (FeedGlobalEnv.PRAISE_AVATAR_MODE) {
            CellTitleInfo titleInfoV2 = businessFeedData.getTitleInfoV2();
            if (titleInfoV2 != null) {
                ArrayList arrayList = new ArrayList();
                List<User> list = titleInfoV2.userList;
                if (list != null) {
                    Iterator<User> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new CellLikeInfo.LikeMan(it.next(), 0, null));
                    }
                }
                feedOperation.setPraiseInfo(arrayList, titleInfoV2.userNum);
            }
        } else {
            feedOperation.setFeedTitleInfo(businessFeedData.getTitleInfoV2());
        }
        feedOperation.setIsOnBottom(z16);
        feedOperation.update();
    }

    public static void setQbossPsvAdvDatas(FeedContent feedContent, BusinessFeedData businessFeedData) {
        CellQbossPsvAdv cellQbossPsvAdv = businessFeedData.getCellQbossPsvAdv();
        feedContent.setQbossPsvAdvData(cellQbossPsvAdv);
        if (cellQbossPsvAdv != null) {
            feedContent.setQbossPsvAdvPictureInfo(cellQbossPsvAdv.getPictureInfo());
            feedContent.setQbossPsvAdvBackgdPictureInfo(cellQbossPsvAdv.getBackgdPictureInfo());
            feedContent.setQbossPsvAdvFloatPictureInfo(cellQbossPsvAdv.getFloatPictureInfo());
        }
    }

    static void setRecommHeaderData(FeedRecommHeader feedRecommHeader, BusinessFeedData businessFeedData) {
        if (businessFeedData.isSubFeed) {
            return;
        }
        int singlePicAdvStyle = businessFeedData.getSinglePicAdvStyle();
        if (singlePicAdvStyle > 0) {
            feedRecommHeader.setStyle(singlePicAdvStyle);
        }
        boolean z16 = true;
        feedRecommHeader.setHeaderData(businessFeedData.getRecommHeader(), true);
        feedRecommHeader.setFeedAttr(businessFeedData.getFeedCommInfo().feedsAttr, businessFeedData.isSubFeed);
        feedRecommHeader.setHasCustomDropdownList(businessFeedData.hasCustomDropList());
        feedRecommHeader.setNeedHideDropdownListForBizRecomContainer(!businessFeedData.hasCustomDropList());
        if (!businessFeedData.getFeedCommInfo().isHotRecommFeed() && !businessFeedData.getFeedCommInfo().isQbossPurchaseFeeds()) {
            z16 = false;
        }
        feedRecommHeader.setIsHotRecommFeed(z16);
        feedRecommHeader.update();
    }

    public static boolean setContentArea(BusinessFeedData businessFeedData, FeedContent feedContent, int i3, String str) {
        FeedPictureInfo feedPictureInfo = null;
        CellLeftThumb leftThumb = businessFeedData != null ? businessFeedData.getLeftThumb() : null;
        FeedPictureInfo[] feedPictureInfoArr = new FeedPictureInfo[0];
        if (businessFeedData != null) {
            feedPictureInfoArr = convertPics(businessFeedData.getPictureInfo(), businessFeedData.getVideoInfo(), businessFeedData.getMusicInfo(), businessFeedData.getGiftInfo());
        }
        feedContent.setPhotoMode(i3);
        feedContent.setPictureInfos(feedPictureInfoArr);
        if (businessFeedData != null) {
            feedContent.setAudioInfo(businessFeedData.getAudioInfo());
        }
        boolean z16 = feedPictureInfoArr != null && feedPictureInfoArr.length > 0;
        feedContent.setForward(false);
        feedContent.setCellId(str);
        feedContent.setBusinessFeedData(businessFeedData);
        feedContent.setIsPassive(true);
        if (businessFeedData != null && businessFeedData.getGiftInfo() != null && !TextUtils.isEmpty(businessFeedData.getGiftInfo().smallGiftUrl)) {
            if (leftThumb == null) {
                leftThumb = new CellLeftThumb();
            }
            leftThumb.setSummary(businessFeedData.getGiftInfo().giftDesc);
            if (TextUtils.isEmpty(leftThumb.getSummary())) {
                leftThumb.setSummary(businessFeedData.getGiftInfo().giftName);
            }
            if (businessFeedData.getPictureInfo() != null && businessFeedData.getPictureInfo().pics != null && businessFeedData.getPictureInfo().pics.size() > 0) {
                leftThumb.setPictureItem(businessFeedData.getPictureInfo().pics.get(0));
            }
            leftThumb.setActionType(businessFeedData.getFeedCommInfo().actiontype);
            businessFeedData.setLeftThumb(leftThumb);
            if (z16) {
                FeedPictureInfo feedPictureInfo2 = feedPictureInfoArr[0];
                feedContent.setPictureInfos(null);
                feedPictureInfo = feedPictureInfo2;
                z16 = false;
            }
        }
        setLeftThumbDatas(feedContent, leftThumb, feedPictureInfo);
        boolean hasPhoto = hasPhoto(leftThumb);
        if (businessFeedData != null && businessFeedData.isCellQbossPsvAdv()) {
            setQbossPsvAdvDatas(feedContent, businessFeedData);
        }
        feedContent.update();
        return z16 || hasPhoto;
    }

    public static FeedView generateMyFeedView(Context context, com.qzone.proxy.feedcomponent.ui.g gVar) {
        if (context != null) {
            context.getApplicationContext();
        }
        return new FeedView(context, false);
    }

    public static void setLeftThumbDatas(FeedContent feedContent, CellLeftThumb cellLeftThumb, FeedPictureInfo feedPictureInfo) {
        if (cellLeftThumb != null) {
            cellLeftThumb.getParseTitle();
            cellLeftThumb.getParseSummary();
            feedContent.setLeftThumbData(cellLeftThumb);
            feedContent.setLeftThumbPictureInfo(cellLeftThumb.getPictureInfo());
        }
        if (feedPictureInfo != null) {
            feedContent.setLeftThumbPictureInfo(feedPictureInfo);
        }
    }

    static boolean hasPhoto(CellLeftThumb cellLeftThumb) {
        PictureItem pictureItem;
        PictureUrl pictureUrl;
        return (cellLeftThumb == null || (pictureItem = cellLeftThumb.getPictureItem()) == null || (pictureUrl = pictureItem.currentUrl) == null || TextUtils.isEmpty(pictureUrl.url)) ? false : true;
    }

    public static boolean setSourceContentArea(BusinessFeedData businessFeedData, FeedContent feedContent, int i3) {
        FeedPictureInfo feedPictureInfo;
        PictureUrl h16;
        if (feedContent == null) {
            return false;
        }
        BusinessFeedData originalInfo = businessFeedData.getOriginalInfo();
        if ((businessFeedData.getFeedCommInfo().showMask & 1) <= 0 && originalInfo != null) {
            CellLeftThumb leftThumb = originalInfo.getLeftThumb();
            FeedViewBuilder.setLeftThumbDatas(feedContent, leftThumb, true);
            boolean hasPhoto = hasPhoto(leftThumb);
            FeedPictureInfo[] convertPics = convertPics(originalInfo.getPictureInfo(), originalInfo.getVideoInfo(), originalInfo.getMusicInfo(), originalInfo.getGiftInfo());
            boolean z16 = (convertPics == null || convertPics.length <= 0 || (feedPictureInfo = convertPics[0]) == null || (h16 = feedPictureInfo.h()) == null || TextUtils.isEmpty(h16.url)) ? false : true;
            feedContent.setPhotoMode(i3);
            feedContent.setPictureInfos(convertPics);
            feedContent.setAudioInfo(originalInfo.getAudioInfo());
            feedContent.setForward(true);
            feedContent.setIsPassive(true);
            feedContent.setCellId(businessFeedData.getIdInfo().cellId);
            feedContent.setBusinessFeedData(businessFeedData);
            feedContent.update();
            return z16 || hasPhoto;
        }
        feedContent.update();
        return false;
    }

    static FeedPictureInfo[] convertPics(CellPictureInfo cellPictureInfo, VideoInfo videoInfo, MusicInfo musicInfo, CellGiftInfo cellGiftInfo) {
        PictureUrl pictureUrl;
        PictureUrl pictureUrl2;
        ArrayList<PictureItem> arrayList;
        FeedPictureInfo.ImageType imageType;
        if (cellPictureInfo == null || (arrayList = cellPictureInfo.pics) == null || arrayList.size() <= 0) {
            if (videoInfo != null && (pictureUrl2 = videoInfo.currentUrl) != null) {
                return new FeedPictureInfo[]{new FeedPictureInfo(FeedPictureInfo.ImageType.VIDEO, pictureUrl2, new String[0])};
            }
            if (musicInfo != null && (pictureUrl = musicInfo.coverUrl) != null) {
                return new FeedPictureInfo[]{new FeedPictureInfo(FeedPictureInfo.ImageType.MUSIC, pictureUrl, new String[0])};
            }
            if (cellGiftInfo == null || TextUtils.isEmpty(cellGiftInfo.smallGiftUrl)) {
                return null;
            }
            return new FeedPictureInfo[]{new FeedPictureInfo(new PictureUrl(cellGiftInfo.smallGiftUrl, 0, 0), cellGiftInfo.bigGitUrl)};
        }
        int size = cellPictureInfo.pics.size();
        FeedPictureInfo[] feedPictureInfoArr = new FeedPictureInfo[size];
        for (int i3 = 0; i3 < size; i3++) {
            PictureItem pictureItem = cellPictureInfo.pics.get(i3);
            PictureUrl pictureUrl3 = pictureItem.currentUrl;
            if (!pictureItem.isGoldenCudgel() && !FeedViewBuilder.isisGoldenCudgel(pictureItem.currentUrl)) {
                imageType = FeedPictureInfo.ImageType.NORMAL;
            } else {
                imageType = FeedPictureInfo.ImageType.IMAGE_GOLDEN_CUDGEL;
            }
            if (!pictureItem.isFakeLongPic()) {
                if (pictureUrl3.pictureType != 2 && pictureItem.type != 2) {
                    if (pictureItem.isBallPanorama()) {
                        imageType = FeedPictureInfo.ImageType.BALL_PANORAMA;
                    } else if (pictureItem.isCirclePanorama()) {
                        imageType = FeedPictureInfo.ImageType.CIRCLE_PANORAMA;
                    }
                } else {
                    imageType = FeedPictureInfo.ImageType.IMAGE_GIF;
                }
            }
            float f16 = pictureItem.pivotXRate;
            float f17 = pictureItem.pivotYRate;
            int i16 = pictureItem.actiontype;
            String str = pictureItem.actionurl;
            String str2 = pictureItem.currentUrl.url;
            FeedPictureInfo feedPictureInfo = new FeedPictureInfo(imageType, pictureUrl3, f16, f17, i16, str, str2, str2, pictureItem.bigUrl.url);
            feedPictureInfoArr[i3] = feedPictureInfo;
            ArrayList<stPhotoTag> arrayList2 = pictureItem.photoTag;
            if (arrayList2 != null) {
                feedPictureInfo.t(arrayList2);
            }
            if (pictureItem.isBallPanorama() || pictureItem.isCirclePanorama()) {
                feedPictureInfoArr[i3].n(pictureItem.bigUrl);
                feedPictureInfoArr[i3].s(pictureItem.originUrl);
            }
            feedPictureInfoArr[i3].o(pictureItem.isFakeLongPic());
        }
        return feedPictureInfoArr;
    }

    static void setTopHeader(FeedTopHeader feedTopHeader, CellFeedCommInfo cellFeedCommInfo) {
    }
}
