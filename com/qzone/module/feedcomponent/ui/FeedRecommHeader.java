package com.qzone.module.feedcomponent.ui;

import NS_MOBILE_FEEDS.s_picurl;
import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.feed.utils.AlbumRecReporter;
import com.qzone.module.feedcomponent.FeedUtil;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellRecommAction;
import com.qzone.proxy.feedcomponent.model.CellRecommHeader;
import com.qzone.proxy.feedcomponent.model.CellReferInfo;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.ClickedPoint;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.gdt.GdtAdFeedUtil;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.widget.AvatarImageView;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.component.media.image.processor.NormalFeedImageProcessor;
import com.tencent.component.media.image.processor.OvalProcessor;
import com.tencent.component.media.image.view.AsyncImageView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.Constants;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedRecommHeader extends BaseFeedView implements FeedChildView {
    static final int BUTTON_TYPE_JUMP = 3;
    static final int BUTTON_TYPE_MORE = 2;
    static final int BUTTON_TYPE_NONE = 0;
    static final int BUTTON_TYPE_SHIELD = 1;
    public static final int adLargeIconStyle = 2;
    public AdExposureChecker.ExposureCallback adExposureCheckerCallback;
    CellRecommHeader cellRecommHeader;
    ImageView closeIcon;
    View downCommonLine;
    boolean isAdLargeIconStyle;
    boolean isBizRecomContainer;
    boolean isEventTagGalleryInContainer;
    boolean isFollowMoreContainer;
    boolean isFriendBirthdayInContainer;
    boolean isFriendRecommendInContainer;
    boolean isLikeFriendContainer;
    boolean isMultiAdvContainer;
    boolean isMyEventTagContainer;
    boolean isNewCardStyleHeader;
    boolean isSpecialCareInContainer;
    boolean isSpeialFollowFeedContainer;
    View.OnClickListener listener;
    AlbumRecReporter.c mAlbumRecInfo;
    private AvatarImageView mAvatar1;
    private AvatarImageView mAvatar2;
    private AvatarImageView mAvatar3;
    private View mAvatarList;
    View mDressBackGround;
    AsyncImageView mDressImage;
    BusinessFeedData mFeedData;
    boolean mHasCustomDropdownList;
    ViewGroup mHeaderBarArea;
    ViewGroup mHeaderRoot;
    AsyncImageView mHotStar;
    boolean mIsAdvFeed;
    boolean mIsHotRecommFeed;
    boolean mIsSubFeed;
    TextView mLeftTitle;
    TextView mLeftTitleDescription;
    View mMinusReportArrow;
    boolean mNeedReport;
    boolean mNeedRightTitle;
    View mRecommArray;
    View mRecommShield;
    TextView mRightTitle;
    int mStyle;
    int mTrans;
    boolean needHideDropdownListForBizRecomContainer;
    String userLogo;
    String userNickName;
    long userUin;
    public static final OvalProcessor DEFAULT_OVAL_PROCESSOR = new OvalProcessor();
    public static FeedViewSection.SectionController RecommHeaderController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedRecommHeader.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            if (businessFeedData == null || businessFeedData.isPublicAccountContent() || businessFeedData.isPublicAccountContainer()) {
                return true;
            }
            if (businessFeedData.isAlbumRecFeed()) {
                return false;
            }
            return businessFeedData.isSubFeed || businessFeedData.getRecommHeader() == null;
        }
    };
    private static String ADTExt = com.qzone.adapter.feedcomponent.h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AdLeftTitle", "\u5e7f\u544a");

    public FeedRecommHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStyle = -1;
        this.mTrans = 255;
        this.adExposureCheckerCallback = null;
        this.listener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedRecommHeader.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BusinessFeedData businessFeedData;
                EventCollector.getInstance().onViewClickedBefore(view);
                int id5 = view.getId();
                if (id5 == com.qzone.adapter.feedcomponent.j.O(Constants.Action.ACTION_NOTIFY_MSF_WEAK_NET_SWITCH)) {
                    FeedRecommHeader feedRecommHeader = FeedRecommHeader.this;
                    CellRecommHeader cellRecommHeader = feedRecommHeader.cellRecommHeader;
                    if (cellRecommHeader != null) {
                        feedRecommHeader.onHeaderClick(view, cellRecommHeader.btnType);
                    }
                    FeedRecommHeader feedRecommHeader2 = FeedRecommHeader.this;
                    com.qzone.proxy.feedcomponent.ui.g gVar = feedRecommHeader2.onFeedElementClickListener;
                    if (gVar != null) {
                        FeedElement feedElement = FeedElement.FEEDBACK_BAR;
                        int i3 = feedRecommHeader2.feedPosition;
                        gVar.onClick(view, feedElement, i3, Integer.valueOf(i3));
                    }
                } else if (id5 == com.qzone.adapter.feedcomponent.j.O(2323) && (businessFeedData = FeedRecommHeader.this.mFeedData) != null && businessFeedData.isQCircleRecommFeed()) {
                    FeedRecommHeader feedRecommHeader3 = FeedRecommHeader.this;
                    com.qzone.proxy.feedcomponent.ui.g gVar2 = feedRecommHeader3.onFeedElementClickListener;
                    if (gVar2 != null) {
                        FeedElement feedElement2 = FeedElement.FEEDBACK;
                        int i16 = feedRecommHeader3.feedPosition;
                        gVar2.onClick(view, feedElement2, i16, Integer.valueOf(i16));
                    }
                    FeedRecommHeader.this.doReport();
                }
                FeedRecommHeader feedRecommHeader4 = FeedRecommHeader.this;
                if (feedRecommHeader4.mIsAdvFeed && feedRecommHeader4.onFeedElementClickListener != null) {
                    if (id5 == com.qzone.adapter.feedcomponent.j.O(Constants.Action.ACTION_UPDATE_BEFORE_MSG_SYNC_CONTROL_CONFIG)) {
                        FeedRecommHeader feedRecommHeader5 = FeedRecommHeader.this;
                        feedRecommHeader5.onFeedElementClickListener.onClick(view, FeedElement.HOT_STAR, feedRecommHeader5.feedPosition, Long.valueOf(feedRecommHeader5.userUin));
                        FeedRecommHeader.this.gdtSupplementaryReport();
                    } else if (id5 == com.qzone.adapter.feedcomponent.j.O(Constants.Action.ACTION_AFTER_FETCH_CONFIG_LOG_REPORT)) {
                        FeedRecommHeader feedRecommHeader6 = FeedRecommHeader.this;
                        feedRecommHeader6.onFeedElementClickListener.onClick(view, FeedElement.FEEDBACK_LEFT_TITLE, feedRecommHeader6.feedPosition, Long.valueOf(feedRecommHeader6.userUin));
                        FeedRecommHeader.this.gdtSupplementaryReport();
                    } else {
                        FeedRecommHeader feedRecommHeader7 = FeedRecommHeader.this;
                        com.qzone.proxy.feedcomponent.ui.g gVar3 = feedRecommHeader7.onFeedElementClickListener;
                        FeedElement feedElement3 = FeedElement.FEEDBACK_BAR;
                        int i17 = feedRecommHeader7.feedPosition;
                        gVar3.onClick(view, feedElement3, i17, Integer.valueOf(i17));
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        initUI(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doReport() {
        String str;
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null && businessFeedData.getOperationInfoV2() != null) {
            int i3 = this.mFeedData.getFeedCommInfo().feedsAttr3 == 2 ? 804 : 801;
            Map<Integer, String> map = this.mFeedData.getOperationInfoV2().feedReportCookie;
            if (map != null) {
                str = map.get(50);
            } else {
                str = "";
            }
            com.qzone.adapter.feedcomponent.i.H().g(i3, 3, 1, "", "", str);
        }
        BusinessFeedData businessFeedData2 = this.mFeedData;
        if (businessFeedData2 == null || businessFeedData2.getFeedCommInfo() == null) {
            return;
        }
        com.qzone.adapter.feedcomponent.i.H().D(12, 150, 24, System.currentTimeMillis(), this.mFeedData.getFeedCommInfo().isRealTimeTTTReport());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gdtSupplementaryReport() {
        GdtAd gdtAd = new GdtAd(GdtFeedUtilForQZone.f(this.mFeedData));
        if (this.adExposureCheckerCallback == null) {
            this.adExposureCheckerCallback = new AdExposureChecker.ExposureCallback() { // from class: com.qzone.module.feedcomponent.ui.FeedRecommHeader.5
                @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
                public void onExposure(WeakReference<View> weakReference) {
                    if (com.qzone.proxy.feedcomponent.b.g()) {
                        com.qzone.proxy.feedcomponent.b.c("AdExposureChecker", "onExposure");
                    }
                    FeedRecommHeader feedRecommHeader = FeedRecommHeader.this;
                    GdtAdFeedUtil.doEffectiveExposureReport(feedRecommHeader.mFeedData, feedRecommHeader.getFeedPosition(), 0);
                }
            };
        }
        AdExposureChecker.onClick(getContext(), gdtAd, new WeakReference(this.adExposureCheckerCallback));
    }

    public String getCustomHeaderDressUrl() {
        Map<String, s_picurl> map;
        CellRecommHeader cellRecommHeader = this.cellRecommHeader;
        if (cellRecommHeader != null && (map = cellRecommHeader.mapCoverUrl) != null && map.get(AreaConst.ADV_RECOMM_HEADER_SIZE) != null) {
            return this.cellRecommHeader.mapCoverUrl.get(AreaConst.ADV_RECOMM_HEADER_SIZE).url;
        }
        return "";
    }

    void initUI(Context context) {
        LayoutInflater.from(context).inflate(com.qzone.adapter.feedcomponent.j.j(1642), this);
        this.mHeaderRoot = (ViewGroup) findViewById(com.qzone.adapter.feedcomponent.j.O(Constants.Action.ACTION_NOTIFY_MSF_WEAK_NET_SWITCH));
        this.mHeaderBarArea = (ViewGroup) findViewById(com.qzone.adapter.feedcomponent.j.O(2472));
        this.mLeftTitle = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(Constants.Action.ACTION_AFTER_FETCH_CONFIG_LOG_REPORT));
        this.mLeftTitleDescription = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2326));
        this.mRightTitle = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(Constants.Action.ACTION_UPDATE_COMPLEX_CONNECT_CONFIG));
        this.mRecommArray = findViewById(com.qzone.adapter.feedcomponent.j.O(Constants.Action.ACTION_UPDATE_MSF_MMKV_CONFIG));
        this.mRecommShield = findViewById(com.qzone.adapter.feedcomponent.j.O(Constants.Action.ACTION_NOTIFY_MSF_MSG_SYNC_END));
        this.mHotStar = (AsyncImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(Constants.Action.ACTION_UPDATE_BEFORE_MSG_SYNC_CONTROL_CONFIG));
        this.mRecommShield.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedRecommHeader.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                FeedRecommHeader feedRecommHeader = FeedRecommHeader.this;
                com.qzone.proxy.feedcomponent.ui.g gVar = feedRecommHeader.onFeedElementClickListener;
                if (gVar != null) {
                    FeedElement feedElement = FeedElement.SHIELD_RECOMM;
                    int i3 = feedRecommHeader.feedPosition;
                    gVar.onClick(view, feedElement, i3, Integer.valueOf(i3));
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.mHeaderRoot.setOnClickListener(this.listener);
        this.mLeftTitle.setOnClickListener(this.listener);
        this.mHotStar.setOnClickListener(this.listener);
        View findViewById = findViewById(com.qzone.adapter.feedcomponent.j.O(Constants.Action.ACTION_NOTIFY_MSF_ONLINE_REGISTER));
        this.mMinusReportArrow = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedRecommHeader.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                FeedRecommHeader feedRecommHeader = FeedRecommHeader.this;
                com.qzone.proxy.feedcomponent.ui.g gVar = feedRecommHeader.onFeedElementClickListener;
                if (gVar != null) {
                    if (feedRecommHeader.mHasCustomDropdownList) {
                        ClickedPoint clickedPoint = new ClickedPoint(feedRecommHeader.mMinusReportArrow.getLeft(), FeedRecommHeader.this.mMinusReportArrow.getTop(), 0, 0, FeedRecommHeader.this.mMinusReportArrow.getWidth(), FeedRecommHeader.this.mMinusReportArrow.getHeight());
                        FeedRecommHeader feedRecommHeader2 = FeedRecommHeader.this;
                        feedRecommHeader2.onFeedElementClickListener.onClick(feedRecommHeader2, FeedElement.DROPDOWN_BUTTON, feedRecommHeader2.feedPosition, clickedPoint);
                    } else {
                        View view2 = feedRecommHeader.mMinusReportArrow;
                        FeedElement feedElement = FeedElement.FEEDBACK;
                        int i3 = feedRecommHeader.feedPosition;
                        gVar.onClick(view2, feedElement, i3, Integer.valueOf(i3));
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.downCommonLine = findViewById(com.qzone.adapter.feedcomponent.j.O(2322));
        ImageView imageView = (ImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2323));
        this.closeIcon = imageView;
        imageView.setOnClickListener(this.listener);
        this.mDressImage = (AsyncImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2470));
        this.mDressBackGround = findViewById(com.qzone.adapter.feedcomponent.j.O(2471));
        AsyncImageView asyncImageView = this.mDressImage;
        if (asyncImageView != null) {
            asyncImageView.setAsyncImageProcessor(new NormalFeedImageProcessor(FeedGlobalEnv.g().getScreenWidth(), AreaConst.dp20, 0.0f, 0.0f));
        }
        setBoarderLineVisibility(0);
        this.mAvatarList = findViewById(com.qzone.adapter.feedcomponent.j.O(2863));
        this.mAvatar1 = (AvatarImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2864));
        this.mAvatar2 = (AvatarImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2865));
        this.mAvatar3 = (AvatarImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2866));
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    public boolean isEmptyData() {
        return this.cellRecommHeader == null;
    }

    public boolean isShowLargerIconStyle(BusinessFeedData businessFeedData) {
        if (businessFeedData.getRecommAction() == null || TextUtils.isEmpty(businessFeedData.getRecommAction().currency_pass_field)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(businessFeedData.getRecommAction().currency_pass_field);
            if (jSONObject.has("corporate_image_size_type")) {
                return jSONObject.getInt("corporate_image_size_type") == 2;
            }
            return false;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    void onHeaderClick(View view, int i3) {
        CellRecommHeader cellRecommHeader;
        com.qzone.proxy.feedcomponent.ui.g gVar = this.onFeedElementClickListener;
        if (gVar == null) {
            return;
        }
        if (i3 == 2) {
            FeedElement feedElement = FeedElement.MORE_RECOMM;
            int i16 = this.feedPosition;
            gVar.onClick(view, feedElement, i16, Integer.valueOf(i16));
        } else if (i3 == 3 && (cellRecommHeader = this.cellRecommHeader) != null) {
            gVar.onClick(view, FeedElement.MY_EVENT_TAG_LIST, this.feedPosition, cellRecommHeader.action_url);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        com.qzone.adapter.feedcomponent.i.H().t2(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setBizRecomContainer(boolean z16) {
        this.isBizRecomContainer = z16;
    }

    public void setBoarderLinePadding(int i3, int i16) {
        View view = this.downCommonLine;
        if (view != null) {
            view.setPadding(i3, 0, i16, 0);
        }
    }

    public void setBoarderLineVisibility(int i3) {
        View view = this.downCommonLine;
        if (view != null) {
            view.setVisibility(i3);
        }
    }

    public void setCloseIconBackground(int i3) {
        ImageView imageView = this.closeIcon;
        if (imageView != null) {
            imageView.setBackgroundResource(i3);
        }
    }

    public void setEventTagGalleryInContainer(boolean z16) {
        this.isEventTagGalleryInContainer = z16;
    }

    public void setFeedAttr(int i3, boolean z16) {
        this.mIsAdvFeed = FeedUtil.isAdvFeed(i3);
        this.mIsSubFeed = z16;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedData(BusinessFeedData businessFeedData) {
        String str;
        this.mFeedData = businessFeedData;
        if (businessFeedData == null) {
            return;
        }
        boolean z16 = true;
        boolean z17 = businessFeedData.feedType == 4098 || !(businessFeedData.getRecommAction() == null || businessFeedData.getRecommAction().isReport == 0) || (!(businessFeedData.getActiveAdv() == null || businessFeedData.getActiveAdv().isReport == 0) || ((businessFeedData.getFeedCommInfo().isYunYingFeeds() && (businessFeedData.getFeedCommInfo().operatemask & 1073741824) != 0) || businessFeedData.getRecommHeader() != null));
        int singlePicAdvStyle = businessFeedData.getSinglePicAdvStyle();
        if (singlePicAdvStyle > 0) {
            setStyle(singlePicAdvStyle);
        }
        if (businessFeedData.isAlbumRecFeed()) {
            CellRecommHeader cellRecommHeader = new CellRecommHeader();
            AlbumRecReporter.c cVar = businessFeedData.albumRecInfo;
            this.mAlbumRecInfo = cVar;
            if (cVar == null) {
                str = "";
            } else {
                str = cVar.title;
            }
            cellRecommHeader.leftTitle = str;
            setHeaderData(cellRecommHeader, true);
            setNeedRightTitle(false);
            setFeedAttr(0, false);
            setHasCustomDropdownList(false);
            setNeedHideDropdownListForBizRecomContainer(true);
            setIsHotRecommFeed(false);
        } else {
            setHeaderData(businessFeedData.getRecommHeader(), z17);
            setNeedRightTitle((businessFeedData.getPicTextInfo() == null || TextUtils.isEmpty(businessFeedData.getRecommHeader().rightTitle)) ? false : true);
            setFeedAttr(businessFeedData.getFeedCommInfo().feedsAttr, businessFeedData.isSubFeed);
            setHasCustomDropdownList(businessFeedData.hasCustomDropList());
            setNeedHideDropdownListForBizRecomContainer(!businessFeedData.hasCustomDropList());
            if (!businessFeedData.getFeedCommInfo().isHotRecommFeed() && !businessFeedData.getFeedCommInfo().isQbossPurchaseFeeds()) {
                z16 = false;
            }
            setIsHotRecommFeed(z16);
        }
        update();
    }

    public void setFollowMoreContainer(boolean z16) {
        this.isFollowMoreContainer = z16;
    }

    public void setFriendBirthdayInContainer(boolean z16) {
        this.isFriendBirthdayInContainer = z16;
    }

    public void setFriendRecommendInContainer(boolean z16) {
        this.isFriendRecommendInContainer = z16;
    }

    public void setHasCustomDropdownList(boolean z16) {
        this.mHasCustomDropdownList = z16;
    }

    public void setHeaderData(CellRecommHeader cellRecommHeader, boolean z16) {
        this.cellRecommHeader = cellRecommHeader;
        this.mNeedReport = z16;
    }

    void setHeaderDress() {
        int i3;
        int i16;
        int i17;
        String customHeaderDressUrl = getCustomHeaderDressUrl();
        if (!TextUtils.isEmpty(customHeaderDressUrl)) {
            this.mDressImage.setAsyncImage(customHeaderDressUrl);
            this.mDressImage.setVisibility(0);
            this.mDressBackGround.setVisibility(0);
            int i18 = AreaConst.LEFT_THUMB_TITLE_DEFAULT_MAX_LINE;
            int i19 = AreaConst.LEFT_THUMB_TITLE_DEFAULT_MAX_LINE;
            i3 = AreaConst.dp45;
            i16 = AreaConst.dp40;
            i17 = AreaConst.dp5;
        } else {
            this.mDressImage.setVisibility(8);
            if (this.isMyEventTagContainer) {
                this.mDressBackGround.setVisibility(0);
                if (this.mTrans < 255) {
                    this.mDressBackGround.setAlpha(0.15f);
                }
                ViewGroup.LayoutParams layoutParams = this.mDressBackGround.getLayoutParams();
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    layoutParams.height = AreaConst.FEED_BACKGROUND_PART1_HEIGHT;
                    this.mDressBackGround.setLayoutParams(layoutParams);
                }
            } else {
                this.mDressBackGround.setVisibility(8);
            }
            int i26 = AreaConst.LEFT_THUMB_TITLE_DEFAULT_MAX_LINE;
            if (this.isMyEventTagContainer) {
                i3 = AreaConst.dp45;
            } else {
                i3 = AreaConst.dp35;
            }
            i16 = i3;
            i17 = 0;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mHeaderRoot.getLayoutParams();
        layoutParams2.height = i3;
        if (this.isLikeFriendContainer) {
            layoutParams2.height = i3 - com.qzone.proxy.feedcomponent.util.g.a(9.0f);
        }
        if (this.isAdLargeIconStyle) {
            layoutParams2.height = com.qzone.proxy.feedcomponent.util.g.a(54.0f);
        }
        this.mHeaderRoot.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.mHeaderBarArea.getLayoutParams();
        layoutParams3.setMargins(0, i17, 0, 0);
        layoutParams3.height = i16;
        if (this.isLikeFriendContainer) {
            layoutParams3.height = i16 - com.qzone.proxy.feedcomponent.util.g.a(9.0f);
        }
        if (this.isMyEventTagContainer) {
            int i27 = layoutParams3.height;
            int i28 = AreaConst.FEED_BACKGROUND_PART1_HEIGHT;
            layoutParams3.height = i27 - i28;
            layoutParams3.setMargins(0, i28, 0, 0);
        }
        if (this.isAdLargeIconStyle) {
            layoutParams3.height = com.qzone.proxy.feedcomponent.util.g.a(66.0f);
        }
        this.mHeaderBarArea.setLayoutParams(layoutParams3);
        int i29 = (com.qzone.adapter.feedcomponent.i.f41892f || this.isFriendRecommendInContainer || this.isSpecialCareInContainer || this.isFriendBirthdayInContainer || this.isEventTagGalleryInContainer || this.isMyEventTagContainer) ? 0 : AreaConst.FEED_BACKGROUND_PART1_HEIGHT;
        if (this.isSpeialFollowFeedContainer) {
            i29 = AreaConst.FEED_BACKGROUND_PART1_HEIGHT;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        if (marginLayoutParams == null) {
            marginLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
        marginLayoutParams.setMargins(0, i29, 0, 0);
        setLayoutParams(marginLayoutParams);
    }

    public void setIsHotRecommFeed(boolean z16) {
        this.mIsHotRecommFeed = z16;
    }

    public void setLikeFriendContainer(boolean z16) {
        this.isLikeFriendContainer = z16;
    }

    public void setMultiAdvContainer(boolean z16) {
        this.isMultiAdvContainer = z16;
    }

    public void setMyEventTagInContainer(boolean z16) {
        this.isMyEventTagContainer = z16;
    }

    public void setNeedHideDropdownListForBizRecomContainer(boolean z16) {
        this.needHideDropdownListForBizRecomContainer = z16;
    }

    public void setNeedRightTitle(boolean z16) {
        this.mNeedRightTitle = z16;
    }

    public void setSpecialCareInContainer(boolean z16) {
        this.isSpecialCareInContainer = z16;
    }

    public void setSpecialFollowContainer(boolean z16) {
        this.isSpeialFollowFeedContainer = z16;
    }

    public void setStyle(int i3) {
        this.mStyle = i3;
    }

    public void setTransparent(int i3) {
        this.mTrans = i3;
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    protected void onUpdate() {
        boolean z16;
        TextView textView;
        CellRecommHeader cellRecommHeader;
        BusinessFeedData businessFeedData;
        CellReferInfo referInfoV2;
        User user;
        ArrayList<User> arrayList;
        AvatarImageView avatarImageView;
        AvatarImageView avatarImageView2;
        String str;
        CellRecommHeader cellRecommHeader2;
        int h16;
        this.isAdLargeIconStyle = false;
        if (this.cellRecommHeader == null) {
            return;
        }
        setPadding(0, 0, 0, 0);
        this.mLeftTitle.setPadding(0, 0, 0, 0);
        setUpNewBarStyleData(this.mFeedData);
        if (isShowLargerIconStyle(this.mFeedData)) {
            setUpAdLargeIconData(this.mFeedData);
        }
        if (this.mIsAdvFeed && !this.mIsSubFeed) {
            setVisibility(0);
            setViewGone(this.mRightTitle);
            setViewGone(this.mRecommArray);
            setViewVisbile(this.mHotStar);
            String str2 = ADTExt;
            CellRecommHeader cellRecommHeader3 = this.cellRecommHeader;
            if (cellRecommHeader3 != null && cellRecommHeader3.leftTitle == null) {
                cellRecommHeader3.leftTitle = str2;
            }
        }
        if (this.mNeedReport) {
            this.mMinusReportArrow.setVisibility(0);
            setViewGone(this.mRightTitle);
            setViewGone(this.mRecommArray);
            if (this.mHasCustomDropdownList) {
                h16 = com.qzone.adapter.feedcomponent.j.h(719);
                if (this.mIsAdvFeed) {
                    ViewCompat.setImportantForAccessibility(this.closeIcon, 2);
                    this.mMinusReportArrow.setContentDescription("\u5e7f\u544a \u5c55\u5f00 \u6309\u94ae");
                }
            } else {
                h16 = com.qzone.adapter.feedcomponent.j.h(TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY);
            }
            setCloseIconBackground(h16);
        } else {
            this.mMinusReportArrow.setVisibility(8);
        }
        setHeaderDress();
        CellRecommHeader cellRecommHeader4 = this.cellRecommHeader;
        if (cellRecommHeader4 != null && cellRecommHeader4.rightTitle == null) {
            cellRecommHeader4.rightTitle = "";
        }
        if (cellRecommHeader4 != null && cellRecommHeader4.leftTitle == null) {
            cellRecommHeader4.leftTitle = "";
        }
        if (cellRecommHeader4 != null) {
            this.mLeftTitle.setText(cellRecommHeader4.leftTitle);
            this.mLeftTitle.setContentDescription(this.cellRecommHeader.leftTitle);
        }
        if (this.isNewCardStyleHeader) {
            this.mLeftTitle.setText(this.userNickName);
            this.mLeftTitle.setContentDescription(this.userNickName);
            this.mLeftTitle.setTextSize(14.0f);
            this.mLeftTitle.setOnClickListener(this.listener);
            TextView textView2 = this.mRightTitle;
            if (textView2 != null) {
                textView2.setText(this.cellRecommHeader.leftTitle);
                this.mRightTitle.setContentDescription(this.cellRecommHeader.leftTitle);
                this.mRightTitle.setTextSize(12.0f);
                setViewVisbile(this.mRightTitle);
            }
        } else {
            this.mLeftTitle.setOnClickListener(null);
        }
        if (this.isAdLargeIconStyle) {
            this.mLeftTitle.setText(this.userNickName);
            this.mLeftTitle.setContentDescription(this.userNickName);
            this.mLeftTitle.setTextSize(16.0f);
            this.mLeftTitle.setOnClickListener(this.listener);
            TextView textView3 = this.mRightTitle;
            if (textView3 != null) {
                textView3.setText(this.cellRecommHeader.leftTitle);
                this.mRightTitle.setContentDescription(this.cellRecommHeader.leftTitle);
                this.mRightTitle.setTextSize(12.0f);
                setViewVisbile(this.mRightTitle);
            }
        }
        if (!this.mNeedReport && !this.mIsAdvFeed && (cellRecommHeader2 = this.cellRecommHeader) != null) {
            byte b16 = cellRecommHeader2.btnType;
            if (b16 == 1) {
                setViewVisbile(this.mRecommShield);
                setViewGone(this.mRightTitle);
                setViewGone(this.mRecommArray);
            } else if (b16 != 2) {
                setViewGone(this.mRecommArray);
                setViewGone(this.mRecommShield);
                setViewGone(this.mRightTitle);
            } else {
                setViewVisbile(this.mRecommArray);
                setViewGone(this.mRecommShield);
                if (TextUtils.isEmpty(this.cellRecommHeader.rightTitle)) {
                    setViewGone(this.mRightTitle);
                } else {
                    TextView textView4 = this.mRightTitle;
                    if (textView4 != null) {
                        textView4.setText(this.cellRecommHeader.rightTitle);
                        this.mRightTitle.setContentDescription(this.cellRecommHeader.rightTitle);
                        setViewVisbile(this.mRightTitle);
                    }
                }
            }
        } else if (this.mNeedRightTitle && this.cellRecommHeader != null) {
            setViewGone(this.mRecommArray);
            setViewGone(this.mRecommShield);
            if (TextUtils.isEmpty(this.cellRecommHeader.rightTitle)) {
                setViewGone(this.mRightTitle);
            } else {
                TextView textView5 = this.mRightTitle;
                if (textView5 != null) {
                    textView5.setText(this.cellRecommHeader.rightTitle);
                    this.mRightTitle.setContentDescription(this.cellRecommHeader.rightTitle);
                    setViewVisbile(this.mRightTitle);
                }
            }
        }
        if (this.cellRecommHeader != null) {
            BusinessFeedData businessFeedData2 = this.mFeedData;
            if (businessFeedData2 != null && businessFeedData2.isAlbumRecFeed()) {
                this.mHotStar.setOnClickListener(null);
                this.mHotStar.setAsyncImageProcessor(DEFAULT_OVAL_PROCESSOR);
                AsyncImageView asyncImageView = this.mHotStar;
                AlbumRecReporter.c cVar = this.mAlbumRecInfo;
                asyncImageView.setAsyncImage(cVar == null ? null : cVar.iconUrl);
                setViewVisbile(this.closeIcon);
            } else {
                if (!this.isNewCardStyleHeader && !this.isAdLargeIconStyle) {
                    this.mHotStar.setAsyncImageProcessor(null);
                    this.mHotStar.setOnClickListener(null);
                    str = this.cellRecommHeader.customIconUrl;
                } else {
                    str = this.userLogo;
                    this.mHotStar.setOnClickListener(this.listener);
                    this.mHotStar.setAsyncImageProcessor(DEFAULT_OVAL_PROCESSOR);
                }
                if (TextUtils.isEmpty(str)) {
                    z16 = false;
                } else {
                    this.mHotStar.setAsyncImage(str);
                    this.mHotStar.getLayoutParams().width = com.qzone.proxy.feedcomponent.util.g.a(18.0f);
                    this.mHotStar.getLayoutParams().height = com.qzone.proxy.feedcomponent.util.g.a(18.0f);
                    z16 = true;
                }
                if (!TextUtils.isEmpty(str) && this.isAdLargeIconStyle) {
                    this.mHotStar.setAsyncImage(str);
                    this.mHotStar.getLayoutParams().width = com.qzone.proxy.feedcomponent.util.g.a(37.0f);
                    this.mHotStar.getLayoutParams().height = com.qzone.proxy.feedcomponent.util.g.a(37.0f);
                } else if (this.isNewCardStyleHeader && this.userUin > 0) {
                    this.mHotStar.setAsyncImage(com.qzone.adapter.feedcomponent.i.H().P(Long.valueOf(this.userUin)));
                } else if (this.cellRecommHeader.recomm_uin > 0) {
                    this.mHotStar.setAsyncImageProcessor(AvatarArea.DEFAULT_OVAL_PROCESSOR);
                    this.mHotStar.setAsyncImage(com.qzone.adapter.feedcomponent.i.H().P(Long.valueOf(this.cellRecommHeader.recomm_uin)));
                }
            }
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.isSpecialCareInContainer) {
            setViewGone(this.mHotStar);
            CellRecommHeader cellRecommHeader5 = this.cellRecommHeader;
            if (cellRecommHeader5 != null) {
                if (TextUtils.isEmpty(cellRecommHeader5.desc)) {
                    this.mLeftTitleDescription.setText("");
                    setViewGone(this.mLeftTitleDescription);
                } else {
                    this.mLeftTitleDescription.setText(this.cellRecommHeader.desc);
                    setViewVisbile(this.mLeftTitleDescription);
                }
            }
        } else if (!this.isFriendRecommendInContainer && !this.isEventTagGalleryInContainer && !this.isMyEventTagContainer) {
            if (this.isBizRecomContainer) {
                setViewGone(this.mHotStar);
                if (this.needHideDropdownListForBizRecomContainer) {
                    setViewGone(this.closeIcon);
                }
            } else {
                if (!z16 && (((cellRecommHeader = this.cellRecommHeader) == null || cellRecommHeader.recomm_uin <= 0) && ((!this.isNewCardStyleHeader || this.userUin <= 0) && (!this.isAdLargeIconStyle || this.userUin <= 0)))) {
                    setViewGone(this.mHotStar);
                } else {
                    setViewVisbile(this.mHotStar);
                }
                setViewGone(this.mLeftTitleDescription);
            }
        } else {
            setViewGone(this.mHotStar);
            setViewGone(this.mLeftTitleDescription);
            if (this.isMyEventTagContainer && (textView = this.mRightTitle) != null && this.mRecommArray != null) {
                textView.setText(this.cellRecommHeader.rightTitle);
                this.mRightTitle.setContentDescription(this.cellRecommHeader.rightTitle);
                setViewVisbile(this.mRightTitle);
                setViewVisbile(this.mRecommArray);
            }
        }
        BusinessFeedData businessFeedData3 = this.mFeedData;
        if (businessFeedData3 != null) {
            if (businessFeedData3.isFriendPlayingFeed() || this.mFeedData.isFriendBirthdayGift() || this.mFeedData.isPublicAccountContainer()) {
                setBoarderLineVisibility(8);
            }
            if (this.mFeedData.isFriendPlayingRecomm()) {
                CellRecommAction recommAction = this.mFeedData.getRecommAction();
                if (recommAction != null && (arrayList = recommAction.userList) != null && arrayList.size() > 0) {
                    this.mAvatarList.setVisibility(0);
                    int size = recommAction.userList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        User user2 = recommAction.userList.get(i3);
                        if (i3 == 0) {
                            avatarImageView2 = this.mAvatar1;
                        } else if (i3 != 1) {
                            avatarImageView2 = i3 != 2 ? null : this.mAvatar3;
                        } else {
                            avatarImageView2 = this.mAvatar2;
                        }
                        if (user2 != null && avatarImageView2 != null) {
                            avatarImageView2.setStrokeWidth(com.qzone.proxy.feedcomponent.util.g.a(1.0f));
                            avatarImageView2.setStrokeColor(com.qzone.adapter.feedcomponent.j.m());
                            avatarImageView2.j(user2.uin);
                            com.qzone.adapter.feedcomponent.j.V(avatarImageView2);
                            avatarImageView2.setVisibility(0);
                        }
                        i3++;
                    }
                    while (size < 3) {
                        if (size == 0) {
                            avatarImageView = this.mAvatar1;
                        } else if (size != 1) {
                            avatarImageView = size != 2 ? null : this.mAvatar3;
                        } else {
                            avatarImageView = this.mAvatar2;
                        }
                        if (avatarImageView != null) {
                            avatarImageView.setVisibility(8);
                        }
                        size++;
                    }
                }
                CellUserInfo cellUserInfo = this.mFeedData.getCellUserInfo();
                if (cellUserInfo != null && (user = cellUserInfo.user) != null) {
                    if (user.logo != null) {
                        try {
                            ((LinearLayout.LayoutParams) this.mHotStar.getLayoutParams()).setMargins(0, 0, ViewUtils.dpToPx(4.0f), 0);
                        } catch (Exception unused) {
                        }
                        setViewVisbile(this.mHotStar);
                        this.mHotStar.setAsyncImageProcessor(DEFAULT_OVAL_PROCESSOR);
                        this.mHotStar.setAsyncImage(cellUserInfo.user.logo);
                    }
                    String str3 = cellUserInfo.user.nickName;
                    if (str3 != null) {
                        this.mLeftTitle.setText(str3);
                        this.mLeftTitle.setContentDescription(cellUserInfo.user.nickName);
                    }
                }
                CellRecommHeader cellRecommHeader6 = this.cellRecommHeader;
                if (cellRecommHeader6 != null && cellRecommHeader6.leftTitle != null) {
                    try {
                        TextView textView6 = this.mRightTitle;
                        if (textView6 != null) {
                            ((LinearLayout.LayoutParams) textView6.getLayoutParams()).setMargins(0, 0, ViewUtils.dpToPx(6.0f), 0);
                        }
                    } catch (Exception unused2) {
                    }
                    setViewVisbile(this.mRightTitle);
                    TextView textView7 = this.mRightTitle;
                    if (textView7 != null) {
                        textView7.setText(this.cellRecommHeader.leftTitle);
                        this.mRightTitle.setContentDescription(this.cellRecommHeader.leftTitle);
                    }
                }
            } else {
                this.mAvatarList.setVisibility(8);
                this.mAvatar1.setVisibility(8);
                this.mAvatar2.setVisibility(8);
                this.mAvatar3.setVisibility(8);
            }
        }
        if (this.mHotStar.getVisibility() != 0 && (businessFeedData = this.mFeedData) != null && businessFeedData.isFriendPlayingFeedV2() && (referInfoV2 = this.mFeedData.getReferInfoV2()) != null && referInfoV2.icon != null) {
            try {
                ((LinearLayout.LayoutParams) this.mHotStar.getLayoutParams()).setMargins(0, 0, ViewUtils.dpToPx(4.0f), 0);
            } catch (Exception unused3) {
            }
            setViewVisbile(this.mHotStar);
            this.mHotStar.setAsyncImageProcessor(DEFAULT_OVAL_PROCESSOR);
            this.mHotStar.setAsyncImage(referInfoV2.icon);
        }
        View view = this.downCommonLine;
        if (view != null) {
            view.setBackgroundColor(com.qzone.adapter.feedcomponent.j.H());
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    public void reset() {
        this.mStyle = -1;
        this.cellRecommHeader = null;
        this.mFeedData = null;
        this.mNeedReport = false;
        this.mIsAdvFeed = false;
        this.mNeedRightTitle = false;
    }

    public void setUpAdLargeIconData(BusinessFeedData businessFeedData) {
        if (businessFeedData != null && !businessFeedData.isBrandUgcAdvFeeds() && businessFeedData.isGDTAdvFeed() && !QZoneAdFeedDataExtKt.isLocalAd(businessFeedData) && businessFeedData.feedType == 4097 && !businessFeedData.isAlbumRecFeed() && businessFeedData.getUser() != null) {
            this.userLogo = businessFeedData.getUser().logo;
            this.userNickName = businessFeedData.getUser().nickName;
            this.userUin = businessFeedData.getUser().uin;
            this.isAdLargeIconStyle = true;
            setBoarderLineVisibility(8);
            return;
        }
        this.isAdLargeIconStyle = false;
    }

    public void setUpNewBarStyleData(BusinessFeedData businessFeedData) {
        if (businessFeedData != null && QZoneAdFeedDataExtKt.isAdLittleIconStyle(businessFeedData) && !businessFeedData.isAlbumRecFeed()) {
            this.userLogo = businessFeedData.getUser().logo;
            this.userNickName = businessFeedData.getUser().nickName;
            this.userUin = businessFeedData.getUser().uin;
            setBoarderLineVisibility(0);
            this.isNewCardStyleHeader = true;
            if (TextUtils.isEmpty(businessFeedData.getCellSummary().summary)) {
                setBoarderLineVisibility(8);
                return;
            }
            return;
        }
        this.isNewCardStyleHeader = false;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateIdle() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateScrolling() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setAlpha(int i3) {
    }
}
