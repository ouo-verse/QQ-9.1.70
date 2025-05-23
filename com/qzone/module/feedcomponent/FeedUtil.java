package com.qzone.module.feedcomponent;

import android.text.TextUtils;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.CellFollowGuide;
import com.qzone.proxy.feedcomponent.model.CellForwardListInfo;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedUtil {
    public static boolean isAdvFeed(int i3) {
        if ((i3 & 98332) > 0) {
            return true;
        }
        return false;
    }

    public static boolean isCurrentFeedAdvFeedTopAfter(BusinessFeedData businessFeedData) {
        if (!i.T0() || businessFeedData == null) {
            return false;
        }
        int i3 = businessFeedData.feedType;
        if ((i3 != 4097 && i3 != 12290) || businessFeedData.getFeedCommInfo() == null || businessFeedData.getFeedCommInfo().feedskey == null || i.J() == null) {
            return false;
        }
        return businessFeedData.getFeedCommInfo().feedskey.equals(i.J());
    }

    public static boolean isNeedShowMemorySealBar(BusinessFeedData businessFeedData) {
        CellFollowGuide cellFollowGuide;
        if (i.H().i1() || businessFeedData == null || (cellFollowGuide = businessFeedData.cellFollowGuide) == null || cellFollowGuide.feed_type != 1) {
            return false;
        }
        return !TextUtils.isEmpty(cellFollowGuide.button_text);
    }

    public static boolean isNeedShowPrivateSpaceBar(BusinessFeedData businessFeedData) {
        CellFollowGuide cellFollowGuide;
        if (i.H().j1() || businessFeedData == null || (cellFollowGuide = businessFeedData.cellFollowGuide) == null || cellFollowGuide.feed_type != 4) {
            return false;
        }
        return !TextUtils.isEmpty(cellFollowGuide.button_text);
    }

    public static boolean hasComment(BusinessFeedData businessFeedData) {
        if (businessFeedData != null && businessFeedData.getCommentInfoV2() != null) {
            if (businessFeedData.getCommentInfoV2().commentNum > 0) {
                return true;
            }
            if (businessFeedData.getCommentInfoV2().commments != null && businessFeedData.getCommentInfoV2().commments.size() > 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCommentCount(BusinessFeedData businessFeedData) {
        CellCommentInfo commentInfoV2;
        return (businessFeedData == null || (commentInfoV2 = businessFeedData.getCommentInfoV2()) == null || commentInfoV2.realCount <= 0) ? false : true;
    }

    public static boolean hasForwardCount(BusinessFeedData businessFeedData) {
        CellForwardListInfo cellForwardInfo;
        return (businessFeedData == null || (cellForwardInfo = businessFeedData.getCellForwardInfo()) == null || TextUtils.isEmpty(cellForwardInfo.displayStr)) ? false : true;
    }

    public static boolean hasPraiseList(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return false;
        }
        return (!businessFeedData.isNewAdvStyle() || businessFeedData.getRecommAction() == null) && businessFeedData.getLikeInfoV2() != null && businessFeedData.getLikeInfoV2().likeNum > 0;
    }

    public static boolean hasRedBonus(BusinessFeedData businessFeedData) {
        return (businessFeedData == null || businessFeedData.getCellRedBonus() == null || (businessFeedData.getCellRedBonus().payMoney <= 0 && businessFeedData.getCellRedBonus().payTotalAccount <= 0 && businessFeedData.getCellRedBonus().payMenNum <= 0)) ? false : true;
    }

    public static boolean hasSpaceRedBonus(BusinessFeedData businessFeedData) {
        return (businessFeedData == null || businessFeedData.getCellLuckyMoney() == null) ? false : true;
    }
}
