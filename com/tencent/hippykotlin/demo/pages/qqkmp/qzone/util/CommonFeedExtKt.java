package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util;

import com.tencent.ark.ark;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellLocalInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellOrigin;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellRecommend;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMediaComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMediaLike;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonVideo;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0018\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010\u0005\u001a\f\u0010\u0006\u001a\u00020\u0003*\u0004\u0018\u00010\u0007\u001a\f\u0010\b\u001a\u00020\u0003*\u0004\u0018\u00010\u0005\u001a \u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n*\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0002\u001a\u0016\u0010\f\u001a\u00020\r*\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u001a\u0016\u0010\u000e\u001a\u00020\r*\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u001a\f\u0010\u0010\u001a\u00020\u0011*\u0004\u0018\u00010\u0005\u001a\f\u0010\u0012\u001a\u00020\u0011*\u0004\u0018\u00010\u0005\u001a\u001b\u0010\u0013\u001a\u00020\u0011*\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0002\u0010\u0016\u001a\f\u0010\u0017\u001a\u00020\u0011*\u0004\u0018\u00010\u0005\u001a\f\u0010\u0018\u001a\u00020\u0011*\u0004\u0018\u00010\u0005\u001a\f\u0010\u0019\u001a\u00020\u0011*\u0004\u0018\u00010\u0005\u001a\f\u0010\u001a\u001a\u00020\u0011*\u0004\u0018\u00010\u0005\u001a\f\u0010\u001b\u001a\u00020\u0011*\u0004\u0018\u00010\u0005\u001a\f\u0010\u001c\u001a\u00020\u0011*\u0004\u0018\u00010\u0005\u001a\f\u0010\u001d\u001a\u00020\u0011*\u0004\u0018\u00010\u0005\u001a\f\u0010\u001e\u001a\u00020\u0011*\u0004\u0018\u00010\u0005\u001a\f\u0010\u001f\u001a\u00020\u0011*\u0004\u0018\u00010\u0005\u001a\f\u0010 \u001a\u00020\u0011*\u0004\u0018\u00010\u0005\u001a\f\u0010!\u001a\u00020\u0011*\u0004\u0018\u00010\u0005\u001a\f\u0010\"\u001a\u00020\u0011*\u0004\u0018\u00010\u0005\u001a\f\u0010#\u001a\u00020\u0011*\u0004\u0018\u00010\u0005\u001a\f\u0010$\u001a\u00020\u0011*\u0004\u0018\u00010\u0005\u001a\f\u0010%\u001a\u00020\u0011*\u0004\u0018\u00010\u0005\u001a\f\u0010&\u001a\u00020\u0011*\u0004\u0018\u00010\u0005\u001a\f\u0010'\u001a\u00020\u0011*\u0004\u0018\u00010\u0005\u001a\f\u0010(\u001a\u00020\u0011*\u0004\u0018\u00010\u0005\u001a\f\u0010)\u001a\u00020\u0011*\u0004\u0018\u00010\u0007\u001a\u0016\u0010*\u001a\u00020\r*\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u001a\u0016\u0010+\u001a\u00020\r*\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u001a\f\u0010,\u001a\u00020\u0003*\u0004\u0018\u00010\u0001\u00a8\u0006-"}, d2 = {"fromJson", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", ark.ARKMETADATA_JSON, "", "getCellOriginFeed", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "getFeedProMediaPicId", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", "getFeedUniqueKey", "getFilterMediaList", "", "linkedLikeMediaId", "increaseMediaCommentCount", "", "increaseMediaLike", "linkedMediaId", "isAdFeed", "", "isAlbumFeed", "isBatchIdEqual", "batchId", "", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;Ljava/lang/Long;)Z", "isBigPicShareFeed", "isBlogFeed", "isBlogFeedAll", "isCommonAlbumFeed", "isCommonDefaultFeed", "isCommonForwardFeed", "isFakeFeed", "isForwardAlbumFeed", "isForwardBlogFeed", "isForwardFeed", "isForwardHandBlogFeed", "isHandBlogFeed", "isLeftPicRightTextShareFeed", "isMemorySealFeed", "isShareFeed", "isShuoShuoFeed", "isSupportMinMediaOperate", "isTianShuLargeCard", BaseProfileQZoneComponent.KEY_IS_VIDEO, "reduceMediaCommentCount", "reduceMediaLike", "toJson", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonFeedExtKt {
    public static final String getFeedProMediaPicId(CommonMedia commonMedia) {
        String lloc;
        CommonImage cover;
        if (commonMedia == null) {
            return "";
        }
        if (isVideo(commonMedia)) {
            CommonVideo video = commonMedia.getVideo();
            if (video == null || (cover = video.getCover()) == null || (lloc = cover.getLloc()) == null) {
                return "";
            }
        } else {
            CommonImage image = commonMedia.getImage();
            if (image == null || (lloc = image.getLloc()) == null) {
                return "";
            }
        }
        return lloc;
    }

    public static final boolean isForwardFeed(CommonFeed commonFeed) {
        return isCommonForwardFeed(commonFeed) || isForwardAlbumFeed(commonFeed) || isForwardBlogFeed(commonFeed) || isForwardHandBlogFeed(commonFeed);
    }

    public static final CommonUnionID fromJson(CommonUnionID commonUnionID, String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        e eVar = new e(str);
        CommonUnionID commonUnionID2 = new CommonUnionID();
        commonUnionID2.setFeedId(eVar.p("feedId"));
        commonUnionID2.setUfKey(eVar.p("ufKey"));
        commonUnionID2.setUgcId(eVar.p("ugcId"));
        return commonUnionID2;
    }

    public static final String getFeedUniqueKey(CommonFeed commonFeed) {
        CommonCellCommon cellCommon;
        CommonUnionID unionId;
        String ufKey;
        return (commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null || (unionId = cellCommon.getUnionId()) == null || (ufKey = unionId.getUfKey()) == null) ? "" : ufKey;
    }

    private static final List<CommonMedia> getFilterMediaList(CommonFeed commonFeed, String str) {
        List<CommonMedia> mediaItems;
        List<CommonMedia> emptyList;
        CommonCellMedia cellMedia;
        List<CommonMedia> emptyList2;
        if (commonFeed == null) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        if (isForwardFeed(commonFeed)) {
            CommonCellOrigin cellOrigin = commonFeed.getCellOrigin();
            if (cellOrigin != null && (cellMedia = cellOrigin.getCellMedia()) != null) {
                mediaItems = cellMedia.getMediaItems();
            }
            mediaItems = null;
        } else {
            CommonCellMedia cellMedia2 = commonFeed.getCellMedia();
            if (cellMedia2 != null) {
                mediaItems = cellMedia2.getMediaItems();
            }
            mediaItems = null;
        }
        if (!isSupportMinMediaOperate(commonFeed)) {
            return mediaItems;
        }
        if (str == null || str.length() == 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        if (mediaItems == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : mediaItems) {
            if (Intrinsics.areEqual(getFeedProMediaPicId((CommonMedia) obj), str)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final boolean isAdFeed(CommonFeed commonFeed) {
        CommonCellCommon cellCommon;
        Integer feedType;
        return (commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null || (feedType = cellCommon.getFeedType()) == null || feedType.intValue() != 3) ? false : true;
    }

    public static final boolean isFakeFeed(CommonFeed commonFeed) {
        CommonCellLocalInfo cellLocalInfo;
        if (commonFeed == null || (cellLocalInfo = commonFeed.getCellLocalInfo()) == null) {
            return false;
        }
        return cellLocalInfo.isFake();
    }

    public static final boolean isVideo(CommonMedia commonMedia) {
        Integer type;
        return (commonMedia == null || (type = commonMedia.getType()) == null || type.intValue() != 1) ? false : true;
    }

    public static final String toJson(CommonUnionID commonUnionID) {
        if (commonUnionID == null) {
            return "";
        }
        e eVar = new e();
        eVar.v("feedId", commonUnionID.getFeedId());
        eVar.v("ufKey", commonUnionID.getUfKey());
        eVar.v("ugcId", commonUnionID.getUgcId());
        return eVar.toString();
    }

    public static final CommonFeed getCellOriginFeed(CommonFeed commonFeed) {
        if (commonFeed == null) {
            return null;
        }
        CommonFeed commonFeed2 = new CommonFeed();
        CommonCellOrigin cellOrigin = commonFeed.getCellOrigin();
        commonFeed2.setCellCommon(cellOrigin != null ? cellOrigin.getCellCommon() : null);
        CommonCellOrigin cellOrigin2 = commonFeed.getCellOrigin();
        commonFeed2.setCellMedia(cellOrigin2 != null ? cellOrigin2.getCellMedia() : null);
        CommonCellOrigin cellOrigin3 = commonFeed.getCellOrigin();
        commonFeed2.setCellSummary(cellOrigin3 != null ? cellOrigin3.getCellSummary() : null);
        CommonCellOrigin cellOrigin4 = commonFeed.getCellOrigin();
        commonFeed2.setCellTitle(cellOrigin4 != null ? cellOrigin4.getCellTitle() : null);
        CommonCellOrigin cellOrigin5 = commonFeed.getCellOrigin();
        commonFeed2.setCellUserInfo(cellOrigin5 != null ? cellOrigin5.getCellUserInfo() : null);
        return commonFeed2;
    }

    public static final void increaseMediaCommentCount(CommonFeed commonFeed, String str) {
        List<CommonMedia> filterMediaList;
        if (commonFeed == null || (filterMediaList = getFilterMediaList(commonFeed, str)) == null) {
            return;
        }
        for (CommonMedia commonMedia : filterMediaList) {
            if (commonMedia.getComment() == null) {
                commonMedia.setComment(new CommonMediaComment());
            }
            CommonMediaComment comment = commonMedia.getComment();
            if (comment != null) {
                comment.getNum();
                CommonMediaComment comment2 = commonMedia.getComment();
                Intrinsics.checkNotNull(comment2);
                comment2.setNum(comment2.getNum() + 1);
            }
        }
    }

    public static final void increaseMediaLike(CommonFeed commonFeed, String str) {
        List<CommonMedia> filterMediaList;
        if (commonFeed == null || (filterMediaList = getFilterMediaList(commonFeed, str)) == null) {
            return;
        }
        for (CommonMedia commonMedia : filterMediaList) {
            if (commonMedia.getLike() == null) {
                commonMedia.setLike(new CommonMediaLike());
            }
            CommonMediaLike like = commonMedia.getLike();
            if (like != null && !like.getLiked()) {
                like.setLiked(true);
                like.setNum(like.getNum() + 1);
            }
        }
    }

    public static final boolean isAlbumFeed(CommonFeed commonFeed) {
        CommonCellCommon cellCommon;
        Integer feedType;
        Integer feedSubType;
        return (commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null || (feedType = cellCommon.getFeedType()) == null || feedType.intValue() != 1 || (feedSubType = cellCommon.getFeedSubType()) == null || feedSubType.intValue() != 2) ? false : true;
    }

    public static final boolean isBigPicShareFeed(CommonFeed commonFeed) {
        CommonCellCommon cellCommon;
        Integer feedType;
        Integer feedSubType;
        return (commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null || (feedType = cellCommon.getFeedType()) == null || feedType.intValue() != 1 || (feedSubType = cellCommon.getFeedSubType()) == null || feedSubType.intValue() != 4 || cellCommon.getFeedBizType() != 2) ? false : true;
    }

    public static final boolean isBlogFeed(CommonFeed commonFeed) {
        CommonCellCommon cellCommon;
        Integer feedType;
        Integer feedSubType;
        return (commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null || (feedType = cellCommon.getFeedType()) == null || feedType.intValue() != 1 || (feedSubType = cellCommon.getFeedSubType()) == null || feedSubType.intValue() != 3 || cellCommon.getFeedBizType() != 0) ? false : true;
    }

    public static final boolean isBlogFeedAll(CommonFeed commonFeed) {
        CommonCellCommon cellCommon;
        Integer feedType;
        Integer feedSubType;
        return (commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null || (feedType = cellCommon.getFeedType()) == null || feedType.intValue() != 1 || (feedSubType = cellCommon.getFeedSubType()) == null || feedSubType.intValue() != 3) ? false : true;
    }

    public static final boolean isCommonAlbumFeed(CommonFeed commonFeed) {
        CommonCellCommon cellCommon;
        Integer feedType;
        Integer feedSubType;
        return (commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null || (feedType = cellCommon.getFeedType()) == null || feedType.intValue() != 1 || (feedSubType = cellCommon.getFeedSubType()) == null || feedSubType.intValue() != 2 || cellCommon.getFeedBizType() != 0) ? false : true;
    }

    public static final boolean isCommonDefaultFeed(CommonFeed commonFeed) {
        CommonCellCommon cellCommon;
        Integer feedType;
        Integer feedSubType;
        return (commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null || (feedType = cellCommon.getFeedType()) == null || feedType.intValue() != 1 || (feedSubType = cellCommon.getFeedSubType()) == null || feedSubType.intValue() != 1 || cellCommon.getFeedBizType() != 0) ? false : true;
    }

    public static final boolean isCommonForwardFeed(CommonFeed commonFeed) {
        CommonCellCommon cellCommon;
        Integer feedType;
        Integer feedSubType;
        return (commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null || (feedType = cellCommon.getFeedType()) == null || feedType.intValue() != 1 || (feedSubType = cellCommon.getFeedSubType()) == null || feedSubType.intValue() != 1 || cellCommon.getFeedBizType() != 1) ? false : true;
    }

    public static final boolean isForwardAlbumFeed(CommonFeed commonFeed) {
        CommonCellCommon cellCommon;
        Integer feedType;
        Integer feedSubType;
        return (commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null || (feedType = cellCommon.getFeedType()) == null || feedType.intValue() != 1 || (feedSubType = cellCommon.getFeedSubType()) == null || feedSubType.intValue() != 2 || cellCommon.getFeedBizType() != 1) ? false : true;
    }

    public static final boolean isForwardBlogFeed(CommonFeed commonFeed) {
        CommonCellCommon cellCommon;
        Integer feedType;
        Integer feedSubType;
        return (commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null || (feedType = cellCommon.getFeedType()) == null || feedType.intValue() != 1 || (feedSubType = cellCommon.getFeedSubType()) == null || feedSubType.intValue() != 3 || cellCommon.getFeedBizType() != 2) ? false : true;
    }

    public static final boolean isForwardHandBlogFeed(CommonFeed commonFeed) {
        CommonCellCommon cellCommon;
        Integer feedType;
        Integer feedSubType;
        return (commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null || (feedType = cellCommon.getFeedType()) == null || feedType.intValue() != 1 || (feedSubType = cellCommon.getFeedSubType()) == null || feedSubType.intValue() != 3 || cellCommon.getFeedBizType() != 3) ? false : true;
    }

    public static final boolean isHandBlogFeed(CommonFeed commonFeed) {
        CommonCellCommon cellCommon;
        Integer feedType;
        Integer feedSubType;
        return (commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null || (feedType = cellCommon.getFeedType()) == null || feedType.intValue() != 1 || (feedSubType = cellCommon.getFeedSubType()) == null || feedSubType.intValue() != 3 || cellCommon.getFeedBizType() != 1) ? false : true;
    }

    public static final boolean isLeftPicRightTextShareFeed(CommonFeed commonFeed) {
        CommonCellCommon cellCommon;
        Integer feedType;
        Integer feedSubType;
        return (commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null || (feedType = cellCommon.getFeedType()) == null || feedType.intValue() != 1 || (feedSubType = cellCommon.getFeedSubType()) == null || feedSubType.intValue() != 4 || cellCommon.getFeedBizType() != 0) ? false : true;
    }

    public static final boolean isMemorySealFeed(CommonFeed commonFeed) {
        CommonCellCommon cellCommon;
        Integer feedType;
        return (commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null || (feedType = cellCommon.getFeedType()) == null || feedType.intValue() != 4) ? false : true;
    }

    public static final boolean isShareFeed(CommonFeed commonFeed) {
        CommonCellCommon cellCommon;
        Integer feedType;
        Integer feedSubType;
        return (commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null || (feedType = cellCommon.getFeedType()) == null || feedType.intValue() != 1 || (feedSubType = cellCommon.getFeedSubType()) == null || feedSubType.intValue() != 4) ? false : true;
    }

    public static final boolean isShuoShuoFeed(CommonFeed commonFeed) {
        CommonCellCommon cellCommon;
        Integer feedType;
        Integer feedSubType;
        return (commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null || (feedType = cellCommon.getFeedType()) == null || feedType.intValue() != 1 || (feedSubType = cellCommon.getFeedSubType()) == null || feedSubType.intValue() != 1) ? false : true;
    }

    public static final void reduceMediaCommentCount(CommonFeed commonFeed, String str) {
        List<CommonMedia> filterMediaList;
        if (commonFeed == null || (filterMediaList = getFilterMediaList(commonFeed, str)) == null) {
            return;
        }
        for (CommonMedia commonMedia : filterMediaList) {
            CommonMediaComment comment = commonMedia.getComment();
            if (comment != null) {
                comment.getNum();
                CommonMediaComment comment2 = commonMedia.getComment();
                Intrinsics.checkNotNull(comment2);
                comment2.setNum(comment2.getNum() - 1);
            }
        }
    }

    public static final void reduceMediaLike(CommonFeed commonFeed, String str) {
        List<CommonMedia> filterMediaList;
        if (commonFeed == null || (filterMediaList = getFilterMediaList(commonFeed, str)) == null) {
            return;
        }
        Iterator<T> it = filterMediaList.iterator();
        while (it.hasNext()) {
            CommonMediaLike like = ((CommonMedia) it.next()).getLike();
            if (like != null && like.getLiked()) {
                like.setLiked(false);
                like.setNum(like.getNum() - 1);
            }
        }
    }

    public static final boolean isBatchIdEqual(CommonFeed commonFeed, Long l3) {
        Long valueOf;
        CommonCellMedia cellMedia;
        if (commonFeed == null) {
            return false;
        }
        if (!isAlbumFeed(commonFeed)) {
            return true;
        }
        if (l3 == null) {
            return false;
        }
        if (isForwardFeed(commonFeed)) {
            CommonCellOrigin cellOrigin = commonFeed.getCellOrigin();
            if (cellOrigin != null && (cellMedia = cellOrigin.getCellMedia()) != null) {
                valueOf = Long.valueOf(cellMedia.getBatchId());
            }
            valueOf = null;
        } else {
            CommonCellMedia cellMedia2 = commonFeed.getCellMedia();
            if (cellMedia2 != null) {
                valueOf = Long.valueOf(cellMedia2.getBatchId());
            }
            valueOf = null;
        }
        return Intrinsics.areEqual(valueOf, l3);
    }

    public static final boolean isSupportMinMediaOperate(CommonFeed commonFeed) {
        if (commonFeed == null || isForwardAlbumFeed(commonFeed) || !isAlbumFeed(commonFeed)) {
            return false;
        }
        CommonCellMedia cellMedia = commonFeed.getCellMedia();
        return !(cellMedia != null && cellMedia.getUploadNum() == 1);
    }

    public static final boolean isTianShuLargeCard(CommonFeed commonFeed) {
        CommonCellRecommend cellRecommend;
        Integer customType;
        CommonCellCommon cellCommon;
        Integer feedType;
        if ((commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null || (feedType = cellCommon.getFeedType()) == null || feedType.intValue() != 2) ? false : true) {
            return commonFeed != null && (cellRecommend = commonFeed.getCellRecommend()) != null && (customType = cellRecommend.getCustomType()) != null && customType.intValue() == 1;
        }
        return false;
    }
}
