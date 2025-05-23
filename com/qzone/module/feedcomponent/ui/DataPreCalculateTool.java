package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import com.qzone.canvasui.widget.CanvasMultiGifArea;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasAttachView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasCellCommentView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView;
import com.qzone.module.feedcomponent.util.CanvasFeedContentUtil;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellBottomRecomm;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.CellCount;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellFollowGuide;
import com.qzone.proxy.feedcomponent.model.CellForwardListInfo;
import com.qzone.proxy.feedcomponent.model.CellInterest;
import com.qzone.proxy.feedcomponent.model.CellLbsInfo;
import com.qzone.proxy.feedcomponent.model.CellLeftThumb;
import com.qzone.proxy.feedcomponent.model.CellPicTextInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.CellQbossPsvAdv;
import com.qzone.proxy.feedcomponent.model.CellRecommHeader;
import com.qzone.proxy.feedcomponent.model.CellReferInfo;
import com.qzone.proxy.feedcomponent.model.CellRemarkInfo;
import com.qzone.proxy.feedcomponent.model.CellShareCard;
import com.qzone.proxy.feedcomponent.model.CellSummary;
import com.qzone.proxy.feedcomponent.model.CellTitleInfo;
import com.qzone.proxy.feedcomponent.model.CellVisitorInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.FeedPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.tencent.component.media.image.processor.AdvRoundCornerProcessor;
import com.tencent.component.media.image.processor.MergeProcessor;
import com.tencent.component.media.image.processor.NormalFeedImageProcessor;
import com.tencent.component.media.image.processor.RoundCornerProcessor;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes39.dex */
public class DataPreCalculateTool {
    public static final String TAG = "DataPreCalculateTool";
    public static boolean isFirstPageFeed = false;
    static final ConcurrentLinkedQueue<PreMeasureFeedView> preMeasureFeedViewList = new ConcurrentLinkedQueue<>();

    /* loaded from: classes39.dex */
    public static class PreMeasureFeedView {
        public CanvasAttachView mAttachView;
        public CanvasCellCommentView mCanvasCommentView;
        public CanvasFeedContentView mCanvasFeedContentView;
        public CanvasTitleView mCanvasTitleView;
        public PraiseListView mPraiseView;

        public PreMeasureFeedView(Context context) {
            com.qzone.proxy.feedcomponent.b.e("CANVAS", "create PreMeasureFeedView!");
            this.mCanvasTitleView = new CanvasTitleView(context, null);
            this.mAttachView = new CanvasAttachView(context, null);
            this.mPraiseView = new PraiseListView(context, null);
            this.mCanvasCommentView = new CanvasCellCommentView(context, null);
            this.mCanvasFeedContentView = new CanvasFeedContentView(context, null);
        }
    }

    DataPreCalculateTool() {
    }

    static void calculateDynamicAlbumPicItem(BusinessFeedData businessFeedData, FeedPictureInfo feedPictureInfo) {
        int screenWidth;
        int i3;
        int[] singleDesiredPicSize = CanvasFeedContentUtil.getSingleDesiredPicSize(feedPictureInfo, businessFeedData.photoMode, businessFeedData.getFeedCommInfo().isBizRecomFeeds(), businessFeedData);
        int i16 = singleDesiredPicSize[0];
        int i17 = singleDesiredPicSize[1];
        boolean z16 = i17 > i16;
        int i18 = AreaConst.MARGIN_LEFT;
        if (businessFeedData.isForwardFeed()) {
            int i19 = i18 * 2;
            screenWidth = FeedGlobalEnv.g().getScreenWidth() - i19;
            feedPictureInfo.f50256s = (FeedGlobalEnv.g().getScreenWidth() - i19) / 2;
        } else if (com.qzone.adapter.feedcomponent.i.H().s1()) {
            screenWidth = FeedGlobalEnv.g().getScreenWidth();
            feedPictureInfo.f50256s = FeedGlobalEnv.g().getScreenWidth() / 2;
        } else {
            int i26 = i18 * 2;
            screenWidth = FeedGlobalEnv.g().getScreenWidth() - i26;
            feedPictureInfo.f50256s = (FeedGlobalEnv.g().getScreenWidth() - i26) / 2;
        }
        if (!z16 && i16 != 0) {
            i3 = (screenWidth * i17) / i16;
            feedPictureInfo.f50257t = (feedPictureInfo.f50256s * i17) / i16;
        } else {
            feedPictureInfo.f50257t = feedPictureInfo.f50256s;
            i3 = screenWidth;
        }
        if (i3 < 300) {
            feedPictureInfo.f50257t = 150;
            i3 = 300;
        }
        float e16 = feedPictureInfo.e();
        float f16 = feedPictureInfo.f();
        businessFeedData.getCellDynamicAlbum().calculateDynamicAlbum(screenWidth, i3);
        feedPictureInfo.q(new NormalFeedImageProcessor(feedPictureInfo.f50256s, feedPictureInfo.f50257t, e16, f16));
        feedPictureInfo.w(null);
    }

    static String calculateFarwardNickName(BusinessFeedData businessFeedData, BusinessFeedData businessFeedData2, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        User user = businessFeedData2.getUser();
        boolean z16 = (businessFeedData.getFeedCommInfo().showMask & 4) > 0;
        boolean isNeedFollowBtn = businessFeedData2.getFeedCommInfo().isNeedFollowBtn();
        boolean isCanShowFamousIcon = businessFeedData2.getUser().isCanShowFamousIcon();
        StringBuilder sb5 = new StringBuilder();
        if (user != null && !TextUtils.isEmpty(user.nickName) && !z16 && !isNeedFollowBtn) {
            if (user.actiontype == 2 && !QZoneAdFeedDataExtKt.isGDTForwardFeed(businessFeedData)) {
                sb5.append(com.qzone.proxy.feedcomponent.util.h.a(user.actionurl, user.nickName));
            } else {
                sb5.append(com.qzone.proxy.feedcomponent.util.h.d(user.uin, user.nickName));
            }
        }
        if (!isNeedFollowBtn && isCanShowFamousIcon) {
            sb5.append("[dra]qzone_famous_icon[/dra]");
        }
        sb5.append(parseFontStr(str, true));
        return sb5.toString();
    }

    public static void calculateImageUrl() {
        try {
            FeedComment.redpocketImageUrl = PictureUrl.calculateImageUrl(FeedGlobalEnv.g().getGuideCommentRedpocketIconUrl());
            CanvasTitleView.loverZoneIconImageUrl = PictureUrl.calculateImageUrl(CanvasTitleView.loverZoneIconUrlDafult);
            FeedView.detailBackgroundImageUrl = PictureUrl.calculateImageUrl(FeedView.detailBackgroundUrl);
            FeedView.backgroundImageUrl = PictureUrl.calculateImageUrl(FeedView.backgroundUrl);
        } catch (Throwable th5) {
            com.qzone.proxy.feedcomponent.b.c(TAG, th5.toString());
        }
    }

    public static void clearCache() {
        preMeasureFeedViewList.clear();
    }

    public static PreMeasureFeedView obtainPreMeasureFeedView() {
        PreMeasureFeedView poll = preMeasureFeedViewList.poll();
        return poll == null ? new PreMeasureFeedView(FeedGlobalEnv.g().getPluginContext()) : poll;
    }

    public static String parseFontStr(String str, boolean z16) {
        int F;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        if (str.startsWith("\uff1a")) {
            if (z16) {
                F = com.qzone.adapter.feedcomponent.j.o();
            } else {
                F = com.qzone.adapter.feedcomponent.j.F();
            }
            sb5.append("{text:\uff1a,color:");
            sb5.append(Integer.toHexString(F));
            sb5.append(",useDefaultFont:1}");
            sb5.append(str.substring(1));
        } else {
            sb5.append(str);
        }
        return sb5.toString();
    }

    public static String preCalcRichText(String str, int i3, float f16) {
        String str2;
        Matcher matcher;
        String str3 = "text:";
        if (TextUtils.isEmpty(str) || !str.contains("{type:")) {
            return str;
        }
        try {
            matcher = Pattern.compile("\\{type:.*?,text:.*?,.*?\\}").matcher(str);
        } catch (Throwable th5) {
            th = th5;
            str2 = str;
        }
        if (!matcher.find()) {
            return str;
        }
        String group = matcher.group();
        if (TextUtils.isEmpty(group)) {
            return str;
        }
        if (!group.contains("text:")) {
            str3 = null;
        }
        if (TextUtils.isEmpty(str3)) {
            return str;
        }
        int indexOf = group.indexOf(str3) + str3.length();
        String substring = group.substring(indexOf, group.indexOf(",", indexOf));
        str2 = str.replace(group, substring);
        try {
            String substring2 = str2.substring(0, str2.indexOf(substring));
            String substring3 = str2.substring(str2.indexOf(substring) + substring.length(), str2.length());
            long measureText = FeedTextArea.measureText(str2, f16);
            com.qzone.proxy.feedcomponent.b.e("Feed PreCalcRichText", "nickname: " + substring + " displaySummary: " + str2 + " displayWidth: " + measureText);
            while (measureText > i3) {
                String truncate = truncate(substring);
                if (substring.equals(truncate)) {
                    break;
                }
                str2 = substring2 + truncate + "\u2026" + substring3;
                long measureText2 = FeedTextArea.measureText(str2, f16);
                com.qzone.proxy.feedcomponent.b.e("Feed PreCalcRichText", "displaySummary: " + str2 + " displayWidth: " + measureText2);
                substring = truncate;
                measureText = measureText2;
            }
        } catch (Throwable th6) {
            th = th6;
            com.qzone.proxy.feedcomponent.b.d("Feed", "parseEllipsizeContent error! content:" + str, th);
            return str2;
        }
        return str2;
    }

    public static String preCalcText(String str, int i3, int i16) {
        String str2;
        Matcher matcher;
        String str3 = "text:";
        if (TextUtils.isEmpty(str) || !str.contains("{type:")) {
            return str;
        }
        Paint paint = new Paint(257);
        paint.setTextSize(ViewUtils.getSpValue(i16));
        try {
            matcher = Pattern.compile("\\{type:.*?,text:.*?,.*?\\}").matcher(str);
        } catch (Throwable th5) {
            th = th5;
            str2 = str;
        }
        if (!matcher.find()) {
            return str;
        }
        String group = matcher.group();
        if (TextUtils.isEmpty(group)) {
            return str;
        }
        if (!group.contains("text:")) {
            str3 = null;
        }
        if (TextUtils.isEmpty(str3)) {
            return str;
        }
        int indexOf = group.indexOf(str3) + str3.length();
        String substring = group.substring(indexOf, group.indexOf(",", indexOf));
        str2 = str.replace(group, substring);
        try {
            String substring2 = str2.substring(0, str2.indexOf(substring));
            String substring3 = str2.substring(str2.indexOf(substring) + substring.length(), str2.length());
            long measureText = (int) paint.measureText(str2);
            while (measureText > i3) {
                String truncate = truncate(substring);
                if (substring.equals(truncate)) {
                    break;
                }
                str2 = substring2 + truncate + "\u2026" + substring3;
                substring = truncate;
                measureText = (int) paint.measureText(str2);
            }
        } catch (Throwable th6) {
            th = th6;
            com.qzone.proxy.feedcomponent.b.d("Feed", "parseEllipsizeContent error! content:" + str, th);
            return str2;
        }
        return str2;
    }

    public static String preCalcTextByLength(String str, int i3, String str2) {
        String str3 = "text:";
        if (TextUtils.isEmpty(str) || !str.contains("{url:")) {
            return str;
        }
        try {
            Matcher matcher = Pattern.compile("\\{url:.*?,text:.*?\\}").matcher(str);
            if (!matcher.find()) {
                return str;
            }
            String group = matcher.group();
            if (TextUtils.isEmpty(group)) {
                return str;
            }
            if (!group.contains("text:")) {
                str3 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                return str;
            }
            int indexOf = group.indexOf(str3) + str3.length();
            String substring = group.substring(indexOf, group.indexOf("}", indexOf));
            if (substring.length() > i3) {
                substring = substring.substring(0, i3) + str2;
            }
            return str.replace(group, substring);
        } catch (Throwable th5) {
            com.qzone.proxy.feedcomponent.b.d("Feed preCalcTextByLength", "parseEllipsizeContent error! content:" + str, th5);
            return str;
        }
    }

    public static void recyclePreMeasureFeedView(PreMeasureFeedView preMeasureFeedView) {
        preMeasureFeedView.mCanvasTitleView.onRecycled();
        preMeasureFeedView.mAttachView.onRecycled();
        preMeasureFeedView.mPraiseView.onRecycled();
        preMeasureFeedView.mCanvasCommentView.onRecycled();
        preMeasureFeedView.mCanvasFeedContentView.onRecycled();
        preMeasureFeedViewList.add(preMeasureFeedView);
    }

    private static String truncate(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char charAt = str.charAt(str.length() - 1);
        return (Character.isLowSurrogate(charAt) || Character.isHighSurrogate(charAt)) ? str.length() <= 2 ? str : str.substring(0, str.length() - 2) : str.length() <= 1 ? str : str.substring(0, str.length() - 1);
    }

    public static void preCalculate(BusinessFeedData businessFeedData, boolean z16) {
        int i3;
        ArrayList<Comment> arrayList;
        String str;
        String str2;
        int i16;
        String str3;
        CellPictureInfo doConvertFeedPictureInfo;
        String str4;
        CellPictureInfo pictureInfo;
        ArrayList<PictureItem> arrayList2;
        PictureItem pictureItem;
        if (businessFeedData.getFeedCommInfo().extendInfo != null && businessFeedData.getFeedCommInfo().extendInfo.size() != 0 && (str4 = businessFeedData.getFeedCommInfo().extendInfo.get("is_feeds_long_pics_browsing_mode")) != null && str4.equals("1")) {
            if (businessFeedData.getPictureInfo() != null) {
                pictureInfo = businessFeedData.getPictureInfo();
            } else {
                pictureInfo = businessFeedData.getOriginalInfoSafe().getPictureInfo();
            }
            if (pictureInfo != null && (arrayList2 = pictureInfo.pics) != null && arrayList2.size() != 0 && (pictureItem = pictureInfo.pics.get(0)) != null) {
                pictureItem.fakeLongPic = 1;
            }
        }
        calculatePic(businessFeedData);
        if (businessFeedData.isGDTAdvFeed()) {
            com.qzone.adapter.feedcomponent.i.H().M1(businessFeedData);
        }
        CellFeedCommInfo feedCommInfo = businessFeedData.getFeedCommInfo();
        feedCommInfo.calculateTimeString(feedCommInfo.getTime());
        com.qzone.adapter.feedcomponent.d.e(businessFeedData.getUser(), businessFeedData.getFeedCommInfo().feedskey);
        com.qzone.adapter.feedcomponent.d.n(businessFeedData.getUser());
        com.qzone.adapter.feedcomponent.d.g(businessFeedData.getUser(), businessFeedData.getFeedCommInfo().feedskey);
        CellTitleInfo titleInfoV2 = businessFeedData.getTitleInfoV2();
        if (titleInfoV2 != null) {
            com.qzone.adapter.feedcomponent.d.m(titleInfoV2, titleInfoV2.title, businessFeedData.getFeedCommInfo().feedskey, false, businessFeedData.feedType == 4098, businessFeedData.getFeedCommInfo().isBizRecomFeeds());
        }
        CellSummary cellSummaryV2 = businessFeedData.getCellSummaryV2();
        if (cellSummaryV2 != null) {
            i3 = 4098;
            com.qzone.adapter.feedcomponent.d.l(cellSummaryV2, cellSummaryV2.summary, businessFeedData.getFeedCommInfo().feedskey, false, businessFeedData.feedType == 4098, businessFeedData.getFeedCommInfo().isBizRecomFeeds(), businessFeedData);
        } else {
            i3 = 4098;
        }
        CellLbsInfo lbsInfoV2 = businessFeedData.getLbsInfoV2();
        if (lbsInfoV2 != null) {
            com.qzone.adapter.feedcomponent.d.f(lbsInfoV2, businessFeedData.getFeedCommInfo().feedskey, businessFeedData.getCellTheme());
        }
        CellLeftThumb leftThumb = businessFeedData.getLeftThumb();
        if (leftThumb != null) {
            leftThumb.setPicActionUrl(leftThumb.getPicActionUrl());
            com.qzone.adapter.feedcomponent.d.p(leftThumb, businessFeedData.getFeedCommInfo().feedskey, businessFeedData.feedType == i3, false, businessFeedData.getFeedCommInfo().isBizRecomFeeds());
        }
        CellQbossPsvAdv cellQbossPsvAdv = businessFeedData.getCellQbossPsvAdv();
        if (cellQbossPsvAdv != null) {
            com.qzone.adapter.feedcomponent.d.q(cellQbossPsvAdv, businessFeedData.getFeedCommInfo().feedskey);
        }
        if (businessFeedData.isAdvContainerThreeGridStyle() && businessFeedData.getPictureInfo() == null && (doConvertFeedPictureInfo = FeedViewBuilder.doConvertFeedPictureInfo(businessFeedData)) != null) {
            businessFeedData.setCellPictureInfo(doConvertFeedPictureInfo);
        }
        CellPictureInfo pictureInfo2 = businessFeedData.getPictureInfo();
        String str5 = "";
        if (pictureInfo2 != null) {
            if (businessFeedData.isAppShareCardFeed()) {
                str3 = "";
            } else {
                str3 = com.qzone.adapter.feedcomponent.i.H().j(pictureInfo2);
            }
            com.qzone.adapter.feedcomponent.d.h(pictureInfo2, str3, businessFeedData.getFeedCommInfo().feedskey, false);
        }
        CellPicTextInfo picTextInfo = businessFeedData.getPicTextInfo();
        if (picTextInfo != null) {
            com.qzone.adapter.feedcomponent.d.i(picTextInfo, businessFeedData.getFeedCommInfo().feedskey);
        }
        CellReferInfo referInfoV2 = businessFeedData.getReferInfoV2();
        if (referInfoV2 != null) {
            com.qzone.adapter.feedcomponent.d.j(referInfoV2, businessFeedData.getFeedCommInfo().feedskey);
        }
        CellRemarkInfo remarkInfoV2 = businessFeedData.getRemarkInfoV2();
        if (remarkInfoV2 != null) {
            com.qzone.adapter.feedcomponent.d.k(remarkInfoV2, businessFeedData.getFeedCommInfo().feedskey, false);
        }
        CellInterest cellInterest = businessFeedData.getCellInterest();
        if (cellInterest != null) {
            cellInterest.calculateDisplayStr(businessFeedData.getFeedCommInfo().feedskey);
        }
        CellVisitorInfo visitorInfo = businessFeedData.getVisitorInfo();
        if (visitorInfo != null) {
            com.qzone.adapter.feedcomponent.d.o(visitorInfo, businessFeedData.getFeedCommInfo().feedskey, businessFeedData.feedType == 2);
        }
        VideoInfo videoInfo = businessFeedData.getVideoInfo();
        if (videoInfo != null) {
            videoInfo.calcuShowVideoTime(videoInfo.videoTime);
        }
        CellRecommHeader recommHeader = businessFeedData.getRecommHeader();
        if (recommHeader != null && businessFeedData.getFeedCommInfo().isBizRecomFeeds()) {
            recommHeader.calDesLeftTitle();
        }
        CellCount cellCount = businessFeedData.getCellCount();
        if (cellCount != null && businessFeedData.getFeedCommInfo().isBizRecomFeeds()) {
            cellCount.calculate(businessFeedData.getFeedCommInfo().feedskey);
        }
        BusinessFeedData originalInfo = businessFeedData.getOriginalInfo();
        if (originalInfo != null) {
            if (businessFeedData.isLiveVideoFeed() && businessFeedData.isForwardFeed() && (i16 = businessFeedData.feedType) == 2) {
                originalInfo.feedType = i16;
            }
            calculatePic(originalInfo);
            CellFeedCommInfo feedCommInfo2 = originalInfo.getFeedCommInfo();
            feedCommInfo2.calculateTimeString(feedCommInfo2.getTime());
            CellTitleInfo titleInfoV22 = originalInfo.getTitleInfoV2();
            if (titleInfoV22 != null) {
                str = calculateFarwardNickName(businessFeedData, originalInfo, titleInfoV22.title);
                com.qzone.adapter.feedcomponent.d.m(titleInfoV22, str, businessFeedData.getFeedCommInfo().feedskey, true, businessFeedData.feedType == i3, businessFeedData.getFeedCommInfo().isBizRecomFeeds());
            } else {
                str = null;
            }
            CellSummary cellSummaryV22 = originalInfo.getCellSummaryV2();
            if (cellSummaryV22 != null) {
                if (TextUtils.isEmpty(str)) {
                    str2 = calculateFarwardNickName(businessFeedData, originalInfo, cellSummaryV22.summary);
                } else {
                    str2 = cellSummaryV22.summary;
                }
                com.qzone.adapter.feedcomponent.d.l(cellSummaryV22, str2, businessFeedData.getFeedCommInfo().feedskey, true, businessFeedData.feedType == i3, businessFeedData.getFeedCommInfo().isBizRecomFeeds(), null);
            }
            CellLeftThumb leftThumb2 = originalInfo.getLeftThumb();
            if (leftThumb2 != null) {
                leftThumb2.setPicActionUrl(leftThumb2.getPicActionUrl());
                com.qzone.adapter.feedcomponent.d.p(leftThumb2, businessFeedData.getFeedCommInfo().feedskey, businessFeedData.feedType == i3, true, businessFeedData.getFeedCommInfo().isBizRecomFeeds());
            }
            if (originalInfo.getPictureInfo() != null) {
                CellPictureInfo pictureInfo3 = originalInfo.getPictureInfo();
                if (!businessFeedData.isAppShareCardFeed()) {
                    str5 = com.qzone.adapter.feedcomponent.i.H().j(pictureInfo3);
                }
                com.qzone.adapter.feedcomponent.d.h(pictureInfo3, str5, businessFeedData.getFeedCommInfo().feedskey, true);
            }
            if (originalInfo.getReferInfoV2() != null) {
                com.qzone.adapter.feedcomponent.d.j(originalInfo.getReferInfoV2(), businessFeedData.getFeedCommInfo().feedskey);
            }
            if (originalInfo.getRemarkInfoV2() != null) {
                com.qzone.adapter.feedcomponent.d.k(originalInfo.getRemarkInfoV2(), businessFeedData.getFeedCommInfo().feedskey, true);
            }
            VideoInfo videoInfo2 = originalInfo.getVideoInfo();
            if (videoInfo2 != null) {
                videoInfo2.calcuShowVideoTime(videoInfo2.videoTime);
            }
            originalInfo.hasCalculate = true;
        }
        com.qzone.adapter.feedcomponent.i.H().P(Long.valueOf(businessFeedData.getUser().uin));
        businessFeedData.calculateTimeDescription();
        int i17 = businessFeedData.getHeader() != null ? businessFeedData.getHeader().type : 0;
        CellCommentInfo commentInfoV2 = businessFeedData.getCommentInfoV2();
        if (commentInfoV2 == null || (arrayList = commentInfoV2.commments) == null || arrayList.size() == 0) {
            commentInfoV2 = businessFeedData.getOriginalInfo() != null ? businessFeedData.getOriginalInfo().getCommentInfoV2() : null;
        }
        if (commentInfoV2 != null) {
            commentInfoV2.feedType = businessFeedData.feedType;
            com.qzone.adapter.feedcomponent.d.c(commentInfoV2);
        }
        CellForwardListInfo cellForwardInfo = businessFeedData.getCellForwardInfo();
        if (cellForwardInfo != null) {
            cellForwardInfo.calculateDisplayStr(businessFeedData.getFeedCommInfo().feedskey, false);
        }
        businessFeedData.setNickNameKey(i17);
        businessFeedData.setStandaloneKey(i17);
        businessFeedData.setLoverZoneKey(i17);
        businessFeedData.setStarVipKey(i17);
        businessFeedData.setYellowVipKey(i17);
        businessFeedData.setLiveMedalKey(i17);
        businessFeedData.setCanFollowIconKey(i17);
        businessFeedData.setFamousKey(i17);
        preCalculateVideoInfo(businessFeedData);
        preCalculateVideoInfo(businessFeedData.getOriginalInfo());
        CellBottomRecomm cellBottomRecomm = businessFeedData.getCellBottomRecomm();
        if (cellBottomRecomm != null) {
            cellBottomRecomm.preCalculate();
        }
        if (businessFeedData.cellFollowGuide != null) {
            preCalculateFollowGuide(businessFeedData);
        }
        businessFeedData.hasCalculate = true;
        if (businessFeedData.getRecBusinessFeedDatas() != null && !businessFeedData.isAdvContainerThreeGridStyle()) {
            Iterator<BusinessFeedData> it = businessFeedData.getRecBusinessFeedDatas().iterator();
            while (it.hasNext()) {
                BusinessFeedData next = it.next();
                if (!next.hasCalculate) {
                    com.qzone.adapter.feedcomponent.d.w(next);
                }
            }
        }
        CellShareCard cellShareCard = businessFeedData.cellShareCard;
        if (cellShareCard != null) {
            if (cellShareCard.content_line < 0) {
                AreaManager.getInstance().preCalcCampusContentTextSize(businessFeedData.cellShareCard);
            }
            businessFeedData.cellShareCard.contentAreaKey = businessFeedData.getFeedCommInfo().feedskey + "_campus_" + businessFeedData.cellShareCard.content_line + "_" + businessFeedData.cellShareCard.content_TextSize;
            CellShareCard cellShareCard2 = businessFeedData.cellShareCard;
            cellShareCard2.integerContentAreaKey = Integer.valueOf(cellShareCard2.contentAreaKey.hashCode());
        }
    }

    public static void preCalculateFollowGuide(BusinessFeedData businessFeedData) {
        CellFollowGuide cellFollowGuide;
        if (businessFeedData == null || (cellFollowGuide = businessFeedData.cellFollowGuide) == null || TextUtils.isEmpty(cellFollowGuide.summary)) {
            return;
        }
        ArrayList<User> arrayList = businessFeedData.cellFollowGuide.followed_list;
        int size = arrayList != null ? arrayList.size() : 0;
        int i3 = AreaManager.dp24;
        int i16 = AreaManager.f48752dp3;
        int i17 = size - 1;
        int screenWidth = (((FeedGlobalEnv.g().getScreenWidth() - (i3 * 2)) - AreaManager.dp30) - (((i3 * size) + (i16 * i17)) + 24)) - AreaManager.dp5;
        CellFollowGuide cellFollowGuide2 = businessFeedData.cellFollowGuide;
        String str = cellFollowGuide2.summary;
        cellFollowGuide2.displaySummary = preCalcText(str, screenWidth, str.contains("{type:") ? 12 : 14);
        int screenWidth2 = ((FeedGlobalEnv.g().getScreenWidth() - (((AreaManager.dp20 * size) + (i16 * i17)) + 24)) - AreaManager.dp35) - AreaManager.dp10;
        CellFollowGuide cellFollowGuide3 = businessFeedData.cellFollowGuide;
        cellFollowGuide3.displayBarSummary = preCalcText(cellFollowGuide3.summary, screenWidth2, 12);
        com.qzone.proxy.feedcomponent.b.e("Feeds", "preCalculateFollowGuide summary:" + businessFeedData.cellFollowGuide.summary + " display:" + businessFeedData.cellFollowGuide.displaySummary + " maxWidth:" + screenWidth2);
    }

    private static void preCalculateVideoInfo(BusinessFeedData businessFeedData) {
        PictureUrl pictureUrl;
        if (businessFeedData == null || businessFeedData.getVideoInfo() == null) {
            return;
        }
        VideoInfo videoInfo = businessFeedData.getVideoInfo();
        FeedVideoView.sVerticalVideoData = FeedVideoView.getVerticalVideo();
        videoInfo.calcuShowVideoTime(videoInfo.videoTime);
        PictureUrl pictureUrl2 = videoInfo.coverUrl;
        int i3 = pictureUrl2 != null ? pictureUrl2.width : 0;
        int i16 = pictureUrl2 != null ? pictureUrl2.height : 0;
        if ((i3 <= 0 || i16 <= 0) && ((pictureUrl = videoInfo.currentUrl) == null || (i3 = pictureUrl.width) <= 0 || (i16 = pictureUrl.height) <= 0)) {
            BusinessFeedData businessFeedData2 = businessFeedData.parentFeedData;
            if (businessFeedData2 == null || !businessFeedData2.isFrdLikeVideoContainer()) {
                i3 = 480;
                i16 = 360;
            } else {
                i3 = 540;
                i16 = 960;
            }
        }
        if (!com.qzone.proxy.feedcomponent.model.c.c(businessFeedData)) {
            videoInfo.width = i3;
            videoInfo.height = i16;
        }
        videoInfo.processor = new NormalFeedImageProcessor(i3, i16);
    }

    public static void calculatePic(BusinessFeedData businessFeedData) {
        FeedPictureInfo[] convertPics;
        float[] fArr;
        ArrayList<PictureItem> arrayList;
        PictureItem pictureItem;
        PictureItem pictureItem2;
        int defaultSize2PicForward;
        if (businessFeedData == null) {
            return;
        }
        int checkShowBigPhoto = FeedViewBuilder.checkShowBigPhoto(FeedGlobalEnv.getContext(), com.qzone.adapter.feedcomponent.i.H().W());
        businessFeedData.photoMode = checkShowBigPhoto;
        if (businessFeedData.isAttach()) {
            convertPics = FeedViewBuilder.convertPics4attach(businessFeedData.getCellAdvContainerAttach(), businessFeedData.getVideoInfo(), businessFeedData.getMusicInfo(), true);
        } else {
            convertPics = FeedViewBuilder.convertPics(businessFeedData.getPictureInfo(), businessFeedData.getVideoInfo(), businessFeedData.getMusicInfo(), true);
        }
        businessFeedData.pics = convertPics;
        if (convertPics == null || convertPics.length <= 0) {
            return;
        }
        if (convertPics[0] == null) {
            return;
        }
        if (convertPics.length != 1 && !businessFeedData.isPublicAccountContent()) {
            if (QZoneAdFeedDataExtKt.isTouchFlipAdv(businessFeedData)) {
                int[] singleDesiredPicSize = CanvasFeedContentUtil.getSingleDesiredPicSize(convertPics[0], checkShowBigPhoto, businessFeedData.getFeedCommInfo().isBizRecomFeeds(), businessFeedData);
                int i3 = singleDesiredPicSize[0];
                int i16 = singleDesiredPicSize[1];
                int i17 = singleDesiredPicSize[2];
                int i18 = singleDesiredPicSize[3];
                if (businessFeedData.isSingleCardStyle()) {
                    FeedPictureInfo feedPictureInfo = convertPics[0];
                    feedPictureInfo.f50257t = i16;
                    feedPictureInfo.f50256s = i3;
                    float[] fArr2 = {5.0f, 5.0f, 5.0f, 5.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    feedPictureInfo.q(new AdvRoundCornerProcessor(fArr2, i3, i16));
                    FeedPictureInfo feedPictureInfo2 = convertPics[0];
                    feedPictureInfo2.w(CanvasFeedContentUtil.ImageProcessorSupplier.supplySingleRaw(checkShowBigPhoto, feedPictureInfo2, i3, i16));
                    FeedPictureInfo feedPictureInfo3 = convertPics[1];
                    feedPictureInfo3.f50257t = i16;
                    feedPictureInfo3.f50256s = i3;
                    feedPictureInfo3.q(new AdvRoundCornerProcessor(fArr2, i3, i16));
                    convertPics[1].w(CanvasFeedContentUtil.ImageProcessorSupplier.supplySingleRaw(checkShowBigPhoto, convertPics[0], i3, i16));
                    return;
                }
                FeedPictureInfo feedPictureInfo4 = convertPics[0];
                feedPictureInfo4.f50257t = i16;
                feedPictureInfo4.f50256s = i3;
                feedPictureInfo4.q(CanvasFeedContentUtil.ImageProcessorSupplier.supplySingle(checkShowBigPhoto, feedPictureInfo4, i3, i16, i17, i18, businessFeedData.getFeedCommInfo().isBizRecomFeeds(), businessFeedData.isLiveVideoFeed()));
                FeedPictureInfo feedPictureInfo5 = convertPics[0];
                feedPictureInfo5.w(CanvasFeedContentUtil.ImageProcessorSupplier.supplySingleRaw(checkShowBigPhoto, feedPictureInfo5, i3, i16));
                FeedPictureInfo feedPictureInfo6 = convertPics[1];
                feedPictureInfo6.f50257t = i16;
                feedPictureInfo6.f50256s = i3;
                feedPictureInfo6.q(CanvasFeedContentUtil.ImageProcessorSupplier.supplySingle(checkShowBigPhoto, convertPics[0], i3, i16, i17, i18, businessFeedData.getFeedCommInfo().isBizRecomFeeds(), businessFeedData.isLiveVideoFeed()));
                convertPics[1].w(CanvasFeedContentUtil.ImageProcessorSupplier.supplySingleRaw(checkShowBigPhoto, convertPics[0], i3, i16));
                return;
            }
            if (convertPics.length != 2 && convertPics.length != 4) {
                defaultSize2PicForward = CanvasMultiGifArea.getDefaultSize();
            } else {
                defaultSize2PicForward = CanvasMultiGifArea.getDefaultSize2PicForward();
            }
            int i19 = (convertPics.length == 3 && businessFeedData.isGDTAdvFeed() && !QZoneAdFeedDataExtKt.isBrandOptimizationAdv(businessFeedData)) ? (int) ((defaultSize2PicForward * 4.0f) / 3.0f) : defaultSize2PicForward;
            for (FeedPictureInfo feedPictureInfo7 : convertPics) {
                if (feedPictureInfo7 != null) {
                    feedPictureInfo7.q(CanvasFeedContentUtil.ImageProcessorSupplier.supplyMulti(checkShowBigPhoto, feedPictureInfo7, i19, defaultSize2PicForward));
                    feedPictureInfo7.w(CanvasFeedContentUtil.ImageProcessorSupplier.supplyMultiRaw(checkShowBigPhoto, feedPictureInfo7, i19, defaultSize2PicForward));
                }
            }
            return;
        }
        int[] singleDesiredPicSize2 = CanvasFeedContentUtil.getSingleDesiredPicSize(convertPics[0], checkShowBigPhoto, businessFeedData.getFeedCommInfo().isBizRecomFeeds(), businessFeedData);
        int i26 = singleDesiredPicSize2[0];
        int i27 = singleDesiredPicSize2[1];
        int i28 = singleDesiredPicSize2[2];
        int i29 = singleDesiredPicSize2[3];
        if (businessFeedData.isDynamicAlbumFeed()) {
            calculateDynamicAlbumPicItem(businessFeedData, convertPics[0]);
            return;
        }
        if (businessFeedData.isSubOfSingleAdvContainerFeed()) {
            FeedPictureInfo feedPictureInfo8 = convertPics[0];
            feedPictureInfo8.f50256s = i26;
            feedPictureInfo8.f50257t = i27;
            if (businessFeedData.isSubOfSingleAdvContainerNewStyle() && !businessFeedData.isAttach()) {
                int i36 = AreaConst.CONTAINER_LINE_WIDTH;
                FeedPictureInfo feedPictureInfo9 = convertPics[0];
                float f16 = i36;
                feedPictureInfo9.q(CanvasFeedContentUtil.ImageProcessorSupplier.supplyMultiMerge(checkShowBigPhoto, feedPictureInfo9, i26, i27, new float[]{f16, f16, f16, f16, 0.0f, 0.0f, 0.0f, 0.0f}));
            } else {
                FeedPictureInfo feedPictureInfo10 = convertPics[0];
                feedPictureInfo10.q(CanvasFeedContentUtil.ImageProcessorSupplier.supplyMulti(checkShowBigPhoto, feedPictureInfo10, i26, i27));
            }
            FeedPictureInfo feedPictureInfo11 = convertPics[0];
            feedPictureInfo11.w(CanvasFeedContentUtil.ImageProcessorSupplier.supplyMultiRaw(checkShowBigPhoto, feedPictureInfo11, i26, i27));
            return;
        }
        if (businessFeedData.isSubOfMultiAdvContainerFeed()) {
            FeedPictureInfo feedPictureInfo12 = convertPics[0];
            feedPictureInfo12.f50256s = i26;
            feedPictureInfo12.f50257t = i27;
            feedPictureInfo12.q(CanvasFeedContentUtil.ImageProcessorSupplier.supplyMulti(checkShowBigPhoto, feedPictureInfo12, i26, i27));
            FeedPictureInfo feedPictureInfo13 = convertPics[0];
            feedPictureInfo13.w(CanvasFeedContentUtil.ImageProcessorSupplier.supplyMultiRaw(checkShowBigPhoto, feedPictureInfo13, i26, i27));
            return;
        }
        if (businessFeedData.isCanvasAd()) {
            FeedPictureInfo feedPictureInfo14 = convertPics[0];
            feedPictureInfo14.f50257t = i27;
            feedPictureInfo14.f50256s = i26;
            feedPictureInfo14.u(0.5f);
            convertPics[0].v(0.5f);
            if (businessFeedData.getSinglePicAdvStyle() == 4) {
                NormalFeedImageProcessor normalFeedImageProcessor = new NormalFeedImageProcessor(i26, i27, 0.5f, 0.5f);
                normalFeedImageProcessor.setDefaultScaleType(10);
                MergeProcessor mergeProcessor = new MergeProcessor();
                mergeProcessor.addProcessor(normalFeedImageProcessor);
                mergeProcessor.addProcessor(new RoundCornerProcessor(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 0.0f, 0.0f, 0.0f, 0.0f}));
                convertPics[0].q(mergeProcessor);
            } else {
                FeedPictureInfo feedPictureInfo15 = convertPics[0];
                feedPictureInfo15.q(CanvasFeedContentUtil.ImageProcessorSupplier.supplySingle(checkShowBigPhoto, feedPictureInfo15, i26, i27, i28, i29, businessFeedData.getFeedCommInfo().isBizRecomFeeds(), businessFeedData.isLiveVideoFeed()));
            }
            FeedPictureInfo feedPictureInfo16 = convertPics[0];
            feedPictureInfo16.w(CanvasFeedContentUtil.ImageProcessorSupplier.supplySingleRaw(checkShowBigPhoto, feedPictureInfo16, i26, i27));
            return;
        }
        if (businessFeedData.getSinglePicAdvStyle() != 4 && (!businessFeedData.isAdFeeds() || !businessFeedData.isSingleCardStyle())) {
            FeedPictureInfo feedPictureInfo17 = convertPics[0];
            feedPictureInfo17.f50257t = i27;
            feedPictureInfo17.f50256s = i26;
            feedPictureInfo17.q(CanvasFeedContentUtil.ImageProcessorSupplier.supplySingle(checkShowBigPhoto, feedPictureInfo17, i26, i27, i28, i29, businessFeedData.getFeedCommInfo().isBizRecomFeeds(), businessFeedData.isLiveVideoFeed()));
            if (businessFeedData.isFakeFeed() && businessFeedData.getPictureInfo() != null && businessFeedData.getPictureInfo().pics != null && businessFeedData.getPictureInfo().pics.size() != 0 && (pictureItem2 = businessFeedData.getPictureInfo().pics.get(0)) != null && pictureItem2.isFakeLongPic() && (pictureItem2.isCirclePanorama() || pictureItem2.isBallPanorama())) {
                convertPics[0].q(new NormalFeedImageProcessor(i26, (i26 * 9) / 16, 0.5f, 0.5f));
            }
            FeedPictureInfo feedPictureInfo18 = convertPics[0];
            feedPictureInfo18.w(CanvasFeedContentUtil.ImageProcessorSupplier.supplySingleRaw(checkShowBigPhoto, feedPictureInfo18, i26, i27));
            CellPictureInfo pictureInfo = businessFeedData.getPictureInfo();
            if (pictureInfo == null || (arrayList = pictureInfo.pics) == null || arrayList.size() <= 0 || (pictureItem = businessFeedData.getPictureInfo().pics.get(0)) == null) {
                return;
            }
            convertPics[0].f50262y = pictureItem.luckyMoneyDesc;
            return;
        }
        FeedPictureInfo feedPictureInfo19 = convertPics[0];
        feedPictureInfo19.f50257t = i27;
        feedPictureInfo19.f50256s = i26;
        if (businessFeedData.isSingleCardStyle()) {
            fArr = new float[]{5.0f, 5.0f, 5.0f, 5.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        } else {
            fArr = new float[]{10.0f, 10.0f, 10.0f, 10.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        }
        convertPics[0].q(new AdvRoundCornerProcessor(fArr, i26, i27));
        FeedPictureInfo feedPictureInfo20 = convertPics[0];
        feedPictureInfo20.w(CanvasFeedContentUtil.ImageProcessorSupplier.supplySingleRaw(checkShowBigPhoto, feedPictureInfo20, i26, i27));
    }

    public static void makeUpForwardFeedInfo(BusinessFeedData businessFeedData, BusinessFeedData businessFeedData2) {
        if (businessFeedData == null || businessFeedData2 == null) {
            return;
        }
        businessFeedData.setCommentInfo(businessFeedData2.getCommentInfoV2());
        businessFeedData.cellLikeInfo = businessFeedData2.getLikeInfoV2();
        businessFeedData.cellOperationInfo = businessFeedData2.getOperationInfoV2();
    }

    private static void preCalculateCanvasFeedView(FeedView feedView, BusinessFeedData businessFeedData) {
    }
}
