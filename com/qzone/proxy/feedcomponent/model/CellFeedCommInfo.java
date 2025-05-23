package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_COMM.UgcRightInfo;
import NS_MOBILE_FEEDS.cell_comm;
import NS_MOBILE_FEEDS.s_droplist_option;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellFeedCommInfo implements SmartParcelable {
    public static final long MILLISECONDS_OF_DAY = 86400000;

    @NeedParcel
    public int actiontype;

    @NeedParcel
    public String actionurl;

    @NeedParcel
    public long advStyle;

    @NeedParcel
    public long adv_subtype;

    @NeedParcel
    public int appid;

    @NeedParcel
    public int bizId;

    @NeedParcel
    public String cacheTimeString;

    @NeedParcel
    public String clientkey;

    @NeedParcel
    public String curlikekey;

    @NeedParcel
    public ArrayList<s_droplist_option> customDroplist;

    @NeedParcel
    public Map<String, String> extendInfo;

    @NeedParcel
    public Map<String, byte[]> extendInfoData;

    @NeedParcel
    public int feedsAttr;

    @NeedParcel
    public int feedsAttr2;

    @NeedParcel
    public long feedsAttr3;

    @NeedParcel
    public long feedsDelTime;

    @NeedParcel
    public int feedsType;

    @NeedParcel
    public String feedsid;

    @NeedParcel
    public String feedskey;

    @NeedParcel
    public boolean hasDoAdvBtnAnimation;

    @NeedParcel
    public int iClick_area;

    @NeedParcel
    public String interestkey;

    @NeedParcel
    public boolean isFollowed;

    @NeedParcel
    public boolean isFriendAdded;

    @NeedParcel
    public boolean isHotFeedsFetched;
    public boolean isInstalled;
    boolean isShowDateCalculated;

    @NeedParcel
    public boolean isSpecialFollowed;

    @NeedParcel
    public boolean isStay;

    @NeedParcel
    public boolean isSubOfMultiAdvContainerFeed;

    @NeedParcel
    public boolean isSubOfSingleAdvContainerFeed;

    @NeedParcel
    public long lastModifyTime;

    @NeedParcel
    public boolean needShowFollowBtn;

    @NeedParcel
    public int operatemask;

    @NeedParcel
    public int operatemask2;

    @NeedParcel
    public long operatemask3;

    @NeedParcel
    public String orglikekey;

    @NeedParcel
    public int originaltype;

    @NeedParcel
    public String paykey;

    @NeedParcel
    public int positionmask;

    @NeedParcel
    public int positionmask2;

    @NeedParcel
    public boolean pull_qzone;
    public int recom_show_type;

    @NeedParcel
    public int recomlayout;

    @NeedParcel
    public long recomreportid;

    @NeedParcel
    public int recomtype;

    @NeedParcel
    public String refer;

    @NeedParcel
    public int reportfeedsattr;
    boolean showDate;

    @NeedParcel
    public long showMask;

    @NeedParcel
    public int spaceRight;

    @NeedParcel
    public String sqDynamicFeedsKey;

    @NeedParcel
    public Map<Integer, Integer> stMapABTest;

    @NeedParcel
    public int subid;

    @NeedParcel
    public long time;

    @NeedParcel
    public long timeStringCacheValidEnd;

    @NeedParcel
    public long timeStringCacheValidStart;

    @NeedParcel
    public int uflag;

    @NeedParcel
    public int ugcRight;

    @NeedParcel
    public String ugcRightKey;

    @NeedParcel
    @Deprecated
    public String ugckey;

    @NeedParcel
    public int wup_feeds_type;

    @NeedParcel
    public int hot_score = 0;

    @NeedParcel
    public boolean is_kuolie = false;

    @NeedParcel
    public boolean needPopupGdtTable = false;

    @NeedParcel
    public String iconToken = "";

    @NeedParcel
    public int commentViewNum = 0;

    public static boolean checkOperatemaskEnabled(long j3, int i3) {
        if ((j3 & (1 << i3)) != 0) {
            return true;
        }
        return false;
    }

    public static boolean isTodayInHistoryFeed(int i3) {
        return (i3 & 256) != 0;
    }

    public void calculateTimeString(long j3) {
        Calendar calendar = Calendar.getInstance();
        if (this.lastModifyTime > j3) {
            this.cacheTimeString = "\u7f16\u8f91\u4e8e" + com.qzone.proxy.feedcomponent.util.c.f(this.lastModifyTime, calendar);
        } else {
            this.cacheTimeString = com.qzone.proxy.feedcomponent.util.c.f(j3, calendar);
        }
        long g16 = com.qzone.proxy.feedcomponent.util.c.g(calendar);
        this.timeStringCacheValidStart = g16;
        this.timeStringCacheValidEnd = g16 + 86400000;
    }

    public boolean canCustomPraise() {
        return (this.operatemask2 & 256) == 0;
    }

    public boolean canGiveBack() {
        return checkOperatemaskEnabled(this.operatemask2, 24);
    }

    public boolean canPresent() {
        return checkOperatemaskEnabled(this.operatemask2, 23);
    }

    public void cancelFeedTop() {
        this.feedsAttr &= -2;
    }

    public boolean checkReqFlowFeed(int i3) {
        return ((1 << (i3 + (-2))) & this.iClick_area) != 0;
    }

    public boolean displayTimeStrValid() {
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis > this.timeStringCacheValidStart && currentTimeMillis < this.timeStringCacheValidEnd;
    }

    public String getAlbumRecType() {
        Map<String, String> map = this.extendInfo;
        if (map == null) {
            return null;
        }
        return map.get("photo_recommand_upload_type");
    }

    public String getAllFormatMaskInfo() {
        int length;
        int length2;
        String binaryString = Integer.toBinaryString(this.operatemask);
        String binaryString2 = Integer.toBinaryString(this.positionmask);
        String binaryString3 = Integer.toBinaryString(this.operatemask2);
        String binaryString4 = Integer.toBinaryString(this.positionmask2);
        if (binaryString.length() > binaryString2.length()) {
            length = binaryString.length();
        } else {
            length = binaryString2.length();
        }
        if (binaryString.length() > binaryString2.length()) {
            length2 = binaryString.length();
        } else {
            length2 = binaryString2.length();
        }
        return "operatemask :" + formatStr(binaryString, length, "0") + "\npositionmask:" + formatStr(binaryString2, length, "0") + "\noperatemask2 :" + formatStr(binaryString3, length2, "0") + "\npositionmask2:" + formatStr(binaryString4, length2, "0");
    }

    public String getDisplayTimeString() {
        if (getTime() == 0) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis > this.timeStringCacheValidStart && currentTimeMillis < this.timeStringCacheValidEnd) {
            return this.cacheTimeString;
        }
        calculateTimeString(getTime());
        return this.cacheTimeString;
    }

    public boolean getExpArg(int i3) {
        Map<Integer, Integer> map = this.stMapABTest;
        return map != null && map.containsKey(Integer.valueOf(i3)) && this.stMapABTest.get(Integer.valueOf(i3)).intValue() == 1;
    }

    public String getFormatMask(int i3, int i16) {
        String binaryString = Integer.toBinaryString(i3);
        return formatStr(binaryString, binaryString == null ? 0 : binaryString.length(), "0");
    }

    public Map<Integer, Integer> getStMapABTest() {
        return this.stMapABTest;
    }

    public long getTime() {
        return this.time;
    }

    public boolean isAlbumRec() {
        return (this.feedsAttr2 & 67108864) != 0;
    }

    public boolean isAppAdvFeed() {
        return (this.feedsAttr & 4) != 0;
    }

    public boolean isBizRecomFamousFeeds() {
        return this.recomtype == 10;
    }

    public boolean isBizRecomFeeds() {
        return (this.feedsAttr & 262144) != 0 || this.isSubOfMultiAdvContainerFeed;
    }

    public boolean isBizRecomRadioFeeds() {
        return this.recomtype == 4;
    }

    public boolean isBizRecomTopicFeeds() {
        int i3 = this.recomtype;
        return i3 == 1 || i3 == 2;
    }

    public boolean isBizRecomTopicGroupFeeds() {
        return this.recomtype == 1;
    }

    public boolean isBizRecomTopicSingleFeeds() {
        return this.recomtype == 2;
    }

    public boolean isBizRecomVedioFeeds() {
        return this.recomtype == 3;
    }

    public boolean isBlogSetTop() {
        return (this.feedsAttr & 1) != 0;
    }

    public boolean isCustomPraiseFeed() {
        return (this.feedsAttr & Integer.MIN_VALUE) != 0;
    }

    public boolean isExistDroplistFollowButton() {
        return (this.feedsAttr2 & 8192) != 0;
    }

    public boolean isFamousRecommAdvFeed() {
        return (this.feedsAttr & 8) != 0;
    }

    public boolean isFamousSpaceRecommFeed() {
        return (this.feedsAttr & 8192) != 0;
    }

    public boolean isFamousSpaceUserFeed() {
        return (this.feedsAttr & 67108864) != 0;
    }

    public boolean isFamousUgcAdvFeeds() {
        return (this.feedsAttr & 16) != 0;
    }

    public boolean isFeedCommentRapidCommentInBox() {
        return checkOperatemaskEnabled(this.operatemask2, 1);
    }

    public boolean isFeedCommentRedPocket() {
        return checkOperatemaskEnabled(this.operatemask, 29);
    }

    public boolean isFeedCommentRedPocketEnable() {
        return checkOperatemaskEnabled(this.operatemask, 31);
    }

    public boolean isFriendRecommFamousFeed() {
        int i3 = this.feedsAttr;
        return ((33554432 & i3) == 0 && (268435456 & i3) == 0 && (i3 & 536870912) == 0) ? false : true;
    }

    public boolean isGDTAdvFeed() {
        return (this.feedsAttr2 & 32) != 0;
    }

    public boolean isGDTForwardAdvFeed() {
        return (this.feedsAttr2 & 32768) != 0;
    }

    public boolean isGuideFeed() {
        return (this.feedsAttr & 1073741824) != 0;
    }

    public boolean isHighFiveAgain() {
        if (com.qzone.proxy.feedcomponent.b.g()) {
            com.qzone.proxy.feedcomponent.b.e("CellFeedCommInfo", "[highFive].isHighFiveAgain, feedsAttr2 = " + this.feedsAttr2 + ", attr2 = 33554432");
        }
        return (this.feedsAttr2 & 33554432) != 0;
    }

    public boolean isHotRecommFeed() {
        return (this.feedsAttr & 64) != 0;
    }

    public boolean isHotRecommFeeds() {
        return (this.feedsAttr & 64) != 0;
    }

    public boolean isLikeRecommFamousFeed() {
        return (this.feedsAttr & 33554432) != 0;
    }

    public boolean isLongPicsBrowsingMode() {
        Map<String, String> map = this.extendInfo;
        return map != null && map.containsKey("is_feeds_long_pics_browsing_mode") && this.extendInfo.get("is_feeds_long_pics_browsing_mode").equals("1");
    }

    public boolean isMayKnowFriendFeed() {
        return (this.feedsAttr2 & 1) != 0;
    }

    public boolean isMyMediaCardAdFeed() {
        return (this.feedsAttr2 & 131072) != 0;
    }

    public boolean isNeedAddFriendBtn() {
        return (this.operatemask2 & 128) != 0;
    }

    public boolean isNeedFollowBtn() {
        return (this.operatemask & 134217728) != 0;
    }

    public boolean isNeedInstalledFilter() {
        return (this.feedsAttr & 512) != 0;
    }

    public boolean isNeedShowMessageEntrance() {
        return checkOperatemaskEnabled(this.operatemask, 29);
    }

    public boolean isNeedShowRapidForwordLayout() {
        return (this.operatemask2 & 8) != 0;
    }

    public boolean isNeedShowSpecialFollowButton() {
        return (this.operatemask & 1048576) != 0 && (this.operatemask2 & 1048576) == 0;
    }

    public boolean isNotSortTimeFeed() {
        return (this.feedsAttr & 128) != 0;
    }

    public boolean isOperationFeed() {
        return (this.feedsAttr & 32) != 0;
    }

    public boolean isPicUpLayout() {
        return this.recomlayout == 1;
    }

    public boolean isPlayBarFeed() {
        return (this.feedsAttr & 16384) != 0;
    }

    public boolean isPrivateFeed() {
        return this.ugcRight > 1;
    }

    public boolean isQbossAdvFeeds() {
        return (this.feedsAttr & 2048) != 0;
    }

    public boolean isQbossPurchaseFeeds() {
        return (this.feedsAttr & 1024) != 0;
    }

    public boolean isRankingFeeds() {
        Map<Integer, Integer> map = this.stMapABTest;
        return map != null && map.containsKey(0);
    }

    public boolean isRealTimeTTTReport() {
        return (this.feedsAttr2 & 2) != 0;
    }

    public boolean isRecomFollowMoreFeed() {
        return this.recomtype == 15;
    }

    public boolean isRecomLiveShowFeed() {
        return this.recomtype == 12;
    }

    public boolean isRecomSpecialFollowMoreFeed() {
        return this.recomtype == 17;
    }

    public boolean isRecommendFriendsFeed() {
        return this.recomtype == 9;
    }

    public boolean isRecommendSchoolFeed() {
        return this.recomtype == 14;
    }

    public boolean isShowDate() {
        return this.showDate;
    }

    public boolean isShowDateCalculated() {
        return this.isShowDateCalculated;
    }

    public boolean isShowFeedRecommend() {
        return checkOperatemaskEnabled(this.operatemask3, 1);
    }

    public boolean isShowGoMessageBoard() {
        return checkOperatemaskEnabled(this.operatemask3, 4);
    }

    public boolean isTopFeed() {
        return (this.feedsAttr & 1) != 0;
    }

    public boolean isVideoAdv() {
        return (this.feedsAttr & 65536) != 0;
    }

    public boolean isVideoAdvShare() {
        return (this.feedsAttr & 131072) != 0;
    }

    public boolean isVideoAdvShareFeed() {
        return (this.feedsAttr & 131072) != 0;
    }

    public boolean isYunYingFeeds() {
        return (this.feedsAttr & 32) != 0;
    }

    public boolean needAdvReport() {
        int i3 = this.feedsAttr;
        return ((i3 & 4) == 0 && (i3 & 8) == 0 && (i3 & 16) == 0 && (i3 & 65536) == 0 && !isBrandUgcAdvFeeds() && !isMyMediaCardAdFeed()) ? false : true;
    }

    public boolean needQBossReport() {
        int i3 = this.feedsAttr;
        return ((i3 & 32) == 0 && (i3 & 1024) == 0) ? false : true;
    }

    public boolean needShowRecommIcon() {
        return (this.feedsAttr & 16) != 0;
    }

    void setExpArg(int i3, int i16) {
        Map<Integer, Integer> map = this.stMapABTest;
        if (map != null) {
            map.put(Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void setFeedTop() {
        this.feedsAttr |= 1;
    }

    public void setShowDate(boolean z16) {
        this.showDate = z16;
    }

    public void setShowDateCalculated(boolean z16) {
        this.isShowDateCalculated = z16;
    }

    public void setTime(long j3) {
        if (this.time == j3) {
            return;
        }
        this.time = j3;
        calculateTimeString(j3);
    }

    public boolean showDiss() {
        return checkOperatemaskEnabled(this.operatemask2, 26);
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CellFeedCommInfo {\n");
        sb5.append("bizId: ");
        sb5.append(this.bizId);
        sb5.append("\n");
        sb5.append("appid: ");
        sb5.append(this.appid);
        sb5.append("\n");
        sb5.append("subid: ");
        sb5.append(this.subid);
        sb5.append("\n");
        if (!TextUtils.isEmpty(this.refer)) {
            sb5.append("refer: ");
            sb5.append(this.refer);
            sb5.append("\n");
        }
        sb5.append("time: ");
        sb5.append(this.time);
        sb5.append("\n");
        sb5.append("actiontype: ");
        sb5.append(this.actiontype);
        sb5.append("\n");
        if (!TextUtils.isEmpty(this.actionurl)) {
            sb5.append("actionurl: ");
            sb5.append(this.actionurl);
            sb5.append("\n");
        }
        sb5.append("originaltype: ");
        sb5.append(this.originaltype);
        sb5.append("\n");
        sb5.append("operatemask: ");
        sb5.append(this.operatemask);
        sb5.append("\n");
        sb5.append("operatemask2: ");
        sb5.append(this.operatemask2);
        sb5.append("\n");
        sb5.append("positionmask: ");
        sb5.append(this.positionmask);
        sb5.append("\n");
        sb5.append("positionmask2: ");
        sb5.append(this.positionmask2);
        sb5.append("\n");
        if (!TextUtils.isEmpty(this.feedskey)) {
            sb5.append("feedskey: ");
            sb5.append(this.feedskey);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.clientkey)) {
            sb5.append("clientkey: ");
            sb5.append(this.clientkey);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.ugckey)) {
            sb5.append("ugckey: ");
            sb5.append(this.ugckey);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.orglikekey)) {
            sb5.append("orglikekey: ");
            sb5.append(this.orglikekey);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.curlikekey)) {
            sb5.append("curlikekey: ");
            sb5.append(this.curlikekey);
            sb5.append("\n");
        }
        sb5.append("feedsType: ");
        sb5.append(this.feedsType);
        sb5.append(",");
        sb5.append("feedsAttr: ");
        sb5.append(this.feedsAttr);
        sb5.append("\n");
        sb5.append("feedsAttr2: ");
        sb5.append(this.feedsAttr2);
        sb5.append("\n");
        sb5.append("feedsAttr3: ");
        sb5.append(this.feedsAttr3);
        sb5.append("\n");
        sb5.append("showMask: ");
        sb5.append(this.showMask);
        sb5.append("\n");
        sb5.append("uflag: ");
        sb5.append(this.uflag);
        sb5.append("\n");
        sb5.append("showDate: ");
        sb5.append(this.showDate);
        sb5.append("\n");
        sb5.append("reportfeedsattr: ");
        sb5.append(this.reportfeedsattr);
        sb5.append("\n");
        sb5.append("isShowDateCalculated: ");
        sb5.append(this.isShowDateCalculated);
        sb5.append("\n");
        sb5.append("feedsDelTime: ");
        sb5.append(this.feedsDelTime);
        sb5.append("\n");
        sb5.append("isStay: ");
        sb5.append(this.isStay);
        sb5.append("\n}");
        return sb5.toString();
    }

    static void changeDataInMapABTest(Map<Integer, Integer> map) {
        if (map.containsKey(1)) {
            map.put(1, 3);
        }
    }

    public boolean isTodayInHistoryFeed() {
        return (this.feedsAttr & 256) != 0;
    }

    public static void appendTodayInHistoryInfo(Map<Integer, String> map) {
        map.put(54, "tih");
    }

    public static CellFeedCommInfo create(l lVar) {
        if (lVar == null || lVar.f50340a == null) {
            return null;
        }
        CellFeedCommInfo cellFeedCommInfo = new CellFeedCommInfo();
        cell_comm cell_commVar = lVar.f50340a;
        cellFeedCommInfo.appid = cell_commVar.appid;
        cellFeedCommInfo.sqDynamicFeedsKey = cell_commVar.sqDynamicFeedsKey;
        cellFeedCommInfo.subid = cell_commVar.subid;
        cellFeedCommInfo.refer = cell_commVar.refer;
        cellFeedCommInfo.setTime(cell_commVar.time * 1000, cell_commVar.lastmodify_time * 1000);
        cell_comm cell_commVar2 = lVar.f50340a;
        cellFeedCommInfo.actiontype = cell_commVar2.actiontype;
        cellFeedCommInfo.actionurl = cell_commVar2.actionurl;
        cellFeedCommInfo.originaltype = cell_commVar2.originaltype;
        cellFeedCommInfo.operatemask = cell_commVar2.operatemask;
        cellFeedCommInfo.uflag = cell_commVar2.uflag;
        cellFeedCommInfo.recom_show_type = cell_commVar2.recom_show_type;
        String str = lVar.P;
        if (!TextUtils.isEmpty(cell_commVar2.feedskey)) {
            str = lVar.f50340a.feedskey;
        }
        String str2 = lVar.f50340a.ugckey;
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        String str3 = lVar.f50340a.clientkey;
        cellFeedCommInfo.clientkey = str3;
        if (TextUtils.isEmpty(str3)) {
            cellFeedCommInfo.clientkey = str;
        }
        if (TextUtils.isEmpty(str)) {
            str = UUID.randomUUID() + "";
        }
        cellFeedCommInfo.feedskey = str;
        if (TextUtils.isEmpty(str2)) {
            str2 = cellFeedCommInfo.feedskey;
        }
        cellFeedCommInfo.ugckey = str2;
        cell_comm cell_commVar3 = lVar.f50340a;
        cellFeedCommInfo.orglikekey = cell_commVar3.orglikekey;
        cellFeedCommInfo.curlikekey = cell_commVar3.curlikekey;
        cellFeedCommInfo.feedsType = cell_commVar3.feedstype;
        cellFeedCommInfo.feedsAttr = cell_commVar3.feedsattr;
        cellFeedCommInfo.feedsAttr2 = cell_commVar3.feedsattr2;
        cellFeedCommInfo.feedsAttr3 = cell_commVar3.feedsattr3;
        cellFeedCommInfo.showMask = cell_commVar3.show_mask;
        cellFeedCommInfo.ugcRightKey = cell_commVar3.ugcrightkey;
        cellFeedCommInfo.interestkey = cell_commVar3.interestkey;
        cellFeedCommInfo.recomtype = cell_commVar3.recomtype;
        cellFeedCommInfo.feedsid = cell_commVar3.feedsid;
        cellFeedCommInfo.advStyle = cell_commVar3.adv_stytle;
        cellFeedCommInfo.adv_subtype = cell_commVar3.adv_subtype;
        cellFeedCommInfo.reportfeedsattr = cell_commVar3.reportfeedsattr;
        cellFeedCommInfo.recomlayout = cell_commVar3.recomlayout;
        cellFeedCommInfo.ugcRight = 1;
        cellFeedCommInfo.spaceRight = cell_commVar3.space_right;
        cellFeedCommInfo.recomreportid = cell_commVar3.recomreportid;
        cellFeedCommInfo.isFollowed = com.qzone.proxy.feedcomponent.util.d.j(cellFeedCommInfo.operatemask, 20);
        cellFeedCommInfo.isSpecialFollowed = com.qzone.proxy.feedcomponent.util.d.j(cellFeedCommInfo.operatemask2, 20);
        Map<Integer, Integer> map = lVar.f50340a.stMapABTest;
        cellFeedCommInfo.stMapABTest = map;
        changeDataInMapABTest(map);
        cell_comm cell_commVar4 = lVar.f50340a;
        cellFeedCommInfo.customDroplist = cell_commVar4.custom_droplist;
        cellFeedCommInfo.isStay = cell_commVar4.is_stay;
        cellFeedCommInfo.wup_feeds_type = cell_commVar4.wup_feeds_type;
        cellFeedCommInfo.operatemask2 = cell_commVar4.operatemask2;
        cellFeedCommInfo.positionmask = cell_commVar4.positionmask;
        cellFeedCommInfo.positionmask2 = cell_commVar4.positionmask2;
        cellFeedCommInfo.feedsDelTime = cell_commVar4.feedsDelTime;
        UgcRightInfo ugcRightInfo = cell_commVar4.right_info;
        if (ugcRightInfo != null) {
            cellFeedCommInfo.ugcRight = ugcRightInfo.ugc_right;
        }
        cellFeedCommInfo.reportfeedsattr = cell_commVar4.reportfeedsattr;
        if (checkOperatemaskEnabled(cellFeedCommInfo.operatemask, 27)) {
            cellFeedCommInfo.isFollowed = false;
            cellFeedCommInfo.needShowFollowBtn = true;
        } else if (checkOperatemaskEnabled(cellFeedCommInfo.operatemask, 20)) {
            cellFeedCommInfo.isFollowed = true;
            cellFeedCommInfo.needShowFollowBtn = true;
        } else {
            cellFeedCommInfo.needShowFollowBtn = false;
        }
        if (checkOperatemaskEnabled(cellFeedCommInfo.operatemask2, 20)) {
            cellFeedCommInfo.isSpecialFollowed = true;
        } else {
            cellFeedCommInfo.isSpecialFollowed = false;
        }
        cell_comm cell_commVar5 = lVar.f50340a;
        cellFeedCommInfo.isStay = cell_commVar5.is_stay;
        cellFeedCommInfo.paykey = cell_commVar5.paykey;
        cellFeedCommInfo.iClick_area = cell_commVar5.iClick_area;
        cellFeedCommInfo.extendInfo = cell_commVar5.extendInfo;
        cellFeedCommInfo.extendInfoData = cell_commVar5.extendInfoData;
        cellFeedCommInfo.hot_score = cell_commVar5.hot_score;
        cellFeedCommInfo.is_kuolie = cell_commVar5.is_kuolie;
        cellFeedCommInfo.pull_qzone = cell_commVar5.pull_qzone;
        cellFeedCommInfo.operatemask3 = cell_commVar5.operatemask3;
        cellFeedCommInfo.iconToken = cell_commVar5.icon_token;
        cellFeedCommInfo.commentViewNum = cell_commVar5.comment_view_num;
        return cellFeedCommInfo;
    }

    public boolean isBrandUgcAdvFeeds() {
        return getExpArg(8);
    }

    public void setBrandUgcAdvFeeds() {
        setExpArg(8, 1);
    }

    public void setTime(long j3, long j16) {
        if (this.time == j3 && this.lastModifyTime == j16) {
            return;
        }
        this.lastModifyTime = j16;
        this.time = j3;
        calculateTimeString(j3);
    }

    String formatStr(String str, int i3, String str2) {
        if (str == null || i3 <= 0) {
            return str;
        }
        int length = i3 - str.length();
        StringBuffer stringBuffer = new StringBuffer();
        if (length == 0) {
            return str;
        }
        if (length > 0) {
            while (length > 0) {
                stringBuffer.append(str2);
                length--;
            }
            return stringBuffer.toString() + str;
        }
        return str.substring(0, i3 - 1);
    }
}
