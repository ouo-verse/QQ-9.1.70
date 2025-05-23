package com.tencent.biz.qqcircle.beans;

import android.app.Activity;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.utils.be;
import cooperation.qqcircle.report.QCircleReportBean;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentInputWindowConfig {
    public static final int EMOJI_PIC_TYPE = 2;
    public static final int LOCAL_PIC_TYPE = 3;
    public static final int TEXT_TYPE = 1;
    public Activity activity;
    public boolean allowShowGoodsView;
    public boolean canAutoOpenRecPicBar;
    public QFSFeedCommentInfo commentInfo;
    public int commentPicHeight;
    public String commentPicPath;
    public int commentPicWidth;
    public be ecommerceBean;
    public String emojiPicUrl;
    public boolean enableShowQQVideoCommentPublicTips;
    public int from;
    public String goodsContent;
    public QFSCommentHelper.b inputListener;
    public boolean isFromContentPage;
    public boolean isFullScreen;
    public boolean isShowAiComment;
    public boolean isShowEmoji;
    public boolean isShowHalfScreenPicPanel;
    public boolean isShowPostBtn;
    public boolean isShowRecPicBar;
    public boolean needShowAt;
    public boolean needShowPublishIcon;
    public boolean needShowRecPicLoading;
    public String qqVideoCommentPublicTipsContent;
    public QCircleReportBean reportBean;
    public boolean showPicEntranceRedPoint;
    public int relocationType = 100;
    public boolean needShowAtIcon = true;
    public boolean needShowRecommendBar = true;
    public boolean needShowFavoriteTab = true;
    public boolean isAllowAiComment = true;
    public int publishType = 1;
}
