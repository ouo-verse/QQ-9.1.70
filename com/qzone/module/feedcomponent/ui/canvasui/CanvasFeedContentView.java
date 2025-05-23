package com.qzone.module.feedcomponent.ui.canvasui;

import NS_MOBILE_FEEDS.cnst.ADV_DESC;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.RelativeLayout;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.canvasui.gdtui.CanvasRecommActionButton;
import com.qzone.canvasui.widget.CanvasAvatarArea;
import com.qzone.canvasui.widget.CanvasFeedEventTagSmallTailArea;
import com.qzone.canvasui.widget.CanvasFlexPicAreaGroup;
import com.qzone.canvasui.widget.CanvasMultiGifArea;
import com.qzone.canvasui.widget.FeedDynamicAlbumCanvasArea;
import com.qzone.canvasui.widget.FeedSinglePicCanvasArea;
import com.qzone.canvasui.widget.LineArea;
import com.qzone.canvasui.widget.QzoneCanvasAreaView;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.qzone.canvasui.widget.TagImageArea;
import com.qzone.canvasui.widget.danmaku.bubble.GdtBubbleDanmakuPresenter;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.commoncode.module.videorecommend.widget.PopupText;
import com.qzone.feed.gift.util.FeedGiftUtil;
import com.qzone.feed.utils.AlbumRecReporter;
import com.qzone.module.feedcomponent.manage.FeedSpanManager;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.ui.AreaManager;
import com.qzone.module.feedcomponent.ui.FeedAlbumRec;
import com.qzone.module.feedcomponent.ui.FeedVideoView;
import com.qzone.module.feedcomponent.ui.FeedView;
import com.qzone.module.feedcomponent.util.CardUtils;
import com.qzone.module.feedcomponent.util.CommentSpanData;
import com.qzone.module.feedcomponent.util.MaxCommentLineConfig;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellAdvContainerAttach;
import com.qzone.proxy.feedcomponent.model.CellBottomRecomm;
import com.qzone.proxy.feedcomponent.model.CellDecorateInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.CellSummary;
import com.qzone.proxy.feedcomponent.model.CellTitleInfo;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.FeedPictureInfo;
import com.qzone.proxy.feedcomponent.model.RegionData;
import com.qzone.proxy.feedcomponent.model.e;
import com.qzone.proxy.feedcomponent.model.f;
import com.qzone.proxy.feedcomponent.model.gdt.GdtAdFeedUtil;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.text.ColorTextCell;
import com.qzone.proxy.feedcomponent.text.ComboNetImageCell;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import com.qzone.proxy.feedcomponent.text.UrlCell;
import com.qzone.proxy.feedcomponent.text.UserNameCell;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.ui.g;
import com.qzone.widget.particle.ParticleManager;
import com.qzone.widget.particle.ParticleTextSurfaceView;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.annoations.DittoField;
import com.tencent.ditto.annoations.DittoOnClick;
import com.tencent.ditto.annoations.DittoOnLongClick;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.widget.DittoBridgeArea;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.ditto.widget.DittoTextArea;
import com.tencent.ditto.widget.LinearAreaLayout;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasFeedContentView extends QzoneCanvasAreaView implements ParticleManager.b, FeedSinglePicCanvasArea.HotAreaCallBack {
    private static final String BLOG_TITLE = "\u53d1\u8868\u4e86\u65e5\u5fd7";
    private static final String BLOG_TITLE_IMG_URL = "https://qzonestyle.gtimg.cn/aoi/sola/20200106173334_iNOeYHSdEP.png";
    private static final int MSG_SHOW_PARTICLES_GUIDE = 2;
    private static final int MSG_UPDATE_PARTICLES = 1;
    private static final String QZONE_FEED_PARTICLE_GUIDE_URL = "https://qzonestyle.gtimg.cn/aoi/sola/20181029170118_3NSJaI4XLN.png";
    private static final int detailHash = 254942715;
    private final String GUIDE_TEXT;
    private final String TAG;
    public AdExposureChecker.ExposureCallback adExposureCheckerCallback;
    private String addGroupAdvUrl;

    @DittoField
    protected LineArea blog_line_area;
    private Runnable bubbleDanmakuRunnable;

    @DittoField
    protected DittoArea canvas_feed_content_view;
    private CellSummary cellSummaryInfo;
    private CellTitleInfo cellTitleInfo;
    public String desc;
    protected BusinessFeedData feedData;

    @DittoField
    protected RichCanvasTextArea feed_content_bizReco_title;

    @DittoField
    protected RichCanvasTextArea feed_content_bizRecom_summary;

    @DittoField
    protected RichCanvasTextArea feed_content_blog_forward_nickname;

    @DittoField
    protected RichCanvasTextArea feed_content_blog_normal_summary;

    @DittoField
    protected TagImageArea feed_content_blog_normal_tag_img;

    @DittoField
    protected RichCanvasTextArea feed_content_blog_normal_title;

    @DittoField
    protected RichCanvasTextArea feed_content_blog_title;

    @DittoField
    protected CanvasMultiGifArea feed_content_comment_pic;

    @DittoField
    protected FeedDynamicAlbumCanvasArea feed_content_dynamic_album;

    @DittoField
    protected CanvasFeedEventTagSmallTailArea feed_content_event_tag;

    @DittoField
    protected CanvasFlexPicAreaGroup feed_content_flex_pic_area;

    @DittoField
    protected RichCanvasTextArea feed_content_logo_attach_text;

    @DittoField
    protected CanvasMultiGifArea feed_content_multi_pic;

    @DittoField
    protected DittoImageArea feed_content_no_photo_mode;

    @DittoField
    protected RichCanvasTextArea feed_content_normal_summary;

    @DittoField
    protected RichCanvasTextArea feed_content_normal_title;

    @DittoField
    protected RichCanvasTextArea feed_content_picInfo_display;

    @DittoField
    protected FeedSinglePicCanvasArea feed_content_singal_pic;

    @DittoField
    protected RichCanvasTextArea feed_content_superlike_summary;

    @DittoField
    public LinearAreaLayout gdt_addGroup;

    @DittoField
    public CanvasRecommActionButton gdt_addGroup_button;

    @DittoField
    public LinearAreaLayout gdt_addGroup_container;

    @DittoField
    public DittoTextArea gdt_addGroup_desc;

    @DittoField
    public CanvasAvatarArea gdt_addGroup_logo;
    public GdtBubbleDanmakuPresenter gdt_bubble_danmaku_presenter;
    public DittoBridgeArea gdt_bubble_danmaku_presenter_bridge_area;
    protected boolean hasSummary;
    protected boolean hideSummary;
    private Runnable invalidateRunnable;
    private boolean isBizRecomFeeds;
    private boolean isBlog;
    public boolean isDetail;
    public boolean isForward;
    private boolean isPassive;
    boolean isRecycled;
    private boolean isShowFowardIcon;
    protected boolean isSpan;
    protected final List<DittoArea> mAreasList;
    private boolean mCanShowParticle;
    private boolean mDataSummaryChanged;
    private int mFontHideFlag;
    private Handler mHandler;
    private boolean mIsBlogNightMode;
    private boolean mIsNewHandBlog;
    protected FeedVideoView mMultiPicAreaVideo;
    protected int mMultiPicAreaVideoIndex;
    protected ParticleTextSurfaceView mParticleTextView;
    private boolean mShadowForward;
    private int mShadowHeight;
    private final Paint mShadowPaint;
    private RectF mShadowRect;
    private boolean mShadowSingleLine;
    private int mShadowWidth;
    private int mShowCount;
    private long mUin;
    protected String summaryKey;
    public String summaryString;
    protected FeedContentViewTouchHelper touchHelper;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class FeedContentViewTouchHelper extends ExploreByTouchHelper {
        HashMap<Integer, DittoArea> areaShells;

        public FeedContentViewTouchHelper(View view) {
            super(view);
            this.areaShells = new HashMap<>(2);
        }

        public Rect getBoundsForIndex(int i3) {
            Rect rect = new Rect();
            if (i3 != Integer.MIN_VALUE) {
                try {
                    HashMap<Integer, DittoArea> hashMap = this.areaShells;
                    if (hashMap != null) {
                        if (i3 == 0) {
                            DittoArea dittoArea = hashMap.get(0);
                            if (dittoArea != null && (dittoArea instanceof RichCanvasTextArea)) {
                                rect.left = 0;
                                rect.top = 0;
                                rect.right = dittoArea.getWidth();
                                rect.bottom = dittoArea.getTop() + ((RichCanvasTextArea) dittoArea).getHeight();
                            }
                        } else {
                            DittoArea dittoArea2 = hashMap.get(1);
                            if (dittoArea2 == null) {
                                return rect;
                            }
                            if (dittoArea2 instanceof FeedSinglePicCanvasArea) {
                                FeedSinglePicCanvasArea feedSinglePicCanvasArea = (FeedSinglePicCanvasArea) dittoArea2;
                                rect.left = feedSinglePicCanvasArea.getPaddingLeft();
                                rect.top = feedSinglePicCanvasArea.getMarginTop();
                                rect.right = rect.left + feedSinglePicCanvasArea.getWidth();
                                rect.bottom = rect.top + feedSinglePicCanvasArea.getHeight();
                            } else if (dittoArea2 instanceof FeedDynamicAlbumCanvasArea) {
                                FeedDynamicAlbumCanvasArea feedDynamicAlbumCanvasArea = (FeedDynamicAlbumCanvasArea) dittoArea2;
                                rect.left = dittoArea2.getLeft();
                                rect.top = feedDynamicAlbumCanvasArea.getMarginTop();
                                rect.right = rect.left + feedDynamicAlbumCanvasArea.getWidth();
                                rect.bottom = rect.top + feedDynamicAlbumCanvasArea.getHeight();
                            } else if (dittoArea2 instanceof CanvasMultiGifArea) {
                                CanvasMultiGifArea canvasMultiGifArea = (CanvasMultiGifArea) dittoArea2;
                                int i16 = i3 - 1;
                                rect.left = ((int) canvasMultiGifArea.getPicLeft(i16, canvasMultiGifArea.getColumnNum(), canvasMultiGifArea.getPicNum(), canvasMultiGifArea.getSinglePicSize())) + canvasMultiGifArea.getPaddingLeft();
                                rect.top = ((int) canvasMultiGifArea.getPicTop(i16, canvasMultiGifArea.getColumnNum(), canvasMultiGifArea.getPicNum(), canvasMultiGifArea.getSinglePicSize())) + canvasMultiGifArea.getMarginTop();
                                rect.right = rect.left + canvasMultiGifArea.getSinglePicSize();
                                rect.bottom = rect.top + canvasMultiGifArea.getSinglePicSize();
                            }
                            rect.top += dittoArea2.getTop() + dittoArea2.getPaddingTop();
                            rect.bottom += dittoArea2.getTop() + dittoArea2.getPaddingTop();
                        }
                        return rect;
                    }
                } catch (Exception unused) {
                    if (b.g()) {
                        b.c("CanvasFeedContentView", "getBoundsForIndex exception");
                    }
                }
            }
            return rect;
        }

        public String getDescriptionForIndex(int i3) {
            DittoArea dittoArea;
            CanvasMultiGifArea canvasMultiGifArea;
            String str;
            if (i3 == 0) {
                BusinessFeedData businessFeedData = CanvasFeedContentView.this.feedData;
                return (businessFeedData == null || (str = businessFeedData.feedContentReadstr) == null) ? "" : str;
            }
            HashMap<Integer, DittoArea> hashMap = this.areaShells;
            if (hashMap == null || (dittoArea = hashMap.get(1)) == null) {
                return "";
            }
            if ((dittoArea instanceof CanvasMultiGifArea) && (canvasMultiGifArea = CanvasFeedContentView.this.feed_content_multi_pic) != null) {
                return "\u56fe" + i3 + "/" + canvasMultiGifArea.mUPloadNum;
            }
            if (dittoArea instanceof FeedDynamicAlbumCanvasArea) {
                return "\u52a8\u611f\u5f71\u96c6\u5c01\u9762";
            }
            if (!(dittoArea instanceof FeedSinglePicCanvasArea)) {
                return "";
            }
            return "\u56fe1/1";
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float f16, float f17) {
            DittoArea findArea = CanvasFeedContentView.this.findArea(f16, f17);
            if (findArea == null) {
                return Integer.MIN_VALUE;
            }
            try {
                if (findArea instanceof FeedSinglePicCanvasArea) {
                    return ((FeedSinglePicCanvasArea) findArea).isInPicArea(f16, f17) ? 1 : Integer.MIN_VALUE;
                }
                if (findArea instanceof FeedDynamicAlbumCanvasArea) {
                    return ((FeedDynamicAlbumCanvasArea) findArea).isInPicArea(f16, f17) ? 1 : Integer.MIN_VALUE;
                }
                if (findArea instanceof RichCanvasTextArea) {
                    return 0;
                }
                if (!(findArea instanceof CanvasMultiGifArea)) {
                    return Integer.MIN_VALUE;
                }
                int round = (Math.round(f16) - findArea.getLeft()) - findArea.getPaddingLeft();
                int round2 = (Math.round(f17) - findArea.getTop()) - findArea.getPaddingTop();
                int findPos = ((CanvasMultiGifArea) findArea).findPos(round, round2, ((CanvasMultiGifArea) findArea).getColumnNum(), ((CanvasMultiGifArea) findArea).getSinglePicSize());
                boolean isInRect = ((CanvasMultiGifArea) findArea).isInRect(round, round2, findPos);
                if (FeedGlobalEnv.g().isDebug()) {
                    b.c("CanvasFeedContentView", "get virtualview at  " + findPos);
                }
                if (isInRect) {
                    return findPos + 1;
                }
                return Integer.MIN_VALUE;
            } catch (Exception unused) {
                if (!b.g()) {
                    return Integer.MIN_VALUE;
                }
                b.c("CanvasFeedContentView", "getVirtualViewAt has exception");
                return Integer.MIN_VALUE;
            }
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> list) {
            if (this.areaShells.size() > 2) {
                this.areaShells.clear();
            }
            for (DittoArea dittoArea : CanvasFeedContentView.this.mAreasList) {
                int i3 = 0;
                if (dittoArea instanceof RichCanvasTextArea) {
                    list.add(0);
                    this.areaShells.put(0, dittoArea);
                } else if (dittoArea instanceof FeedSinglePicCanvasArea) {
                    list.add(1);
                    this.areaShells.put(1, dittoArea);
                } else if (dittoArea instanceof FeedDynamicAlbumCanvasArea) {
                    list.add(1);
                    this.areaShells.put(1, dittoArea);
                } else if (dittoArea instanceof CanvasMultiGifArea) {
                    this.areaShells.put(1, dittoArea);
                    while (true) {
                        CanvasMultiGifArea canvasMultiGifArea = CanvasFeedContentView.this.feed_content_multi_pic;
                        if (canvasMultiGifArea != null && i3 < canvasMultiGifArea.getPicNum()) {
                            i3++;
                            list.add(Integer.valueOf(i3));
                        }
                    }
                }
            }
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int i3, int i16, Bundle bundle) {
            if (Build.VERSION.SDK_INT >= 26 || i16 != 16) {
                return false;
            }
            CanvasFeedContentView.this.onFeedContentViewClick(i3);
            return true;
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected void onPopulateEventForVirtualView(int i3, AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setContentDescription(getDescriptionForIndex(i3));
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int i3, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.setContentDescription(getDescriptionForIndex(i3));
            accessibilityNodeInfoCompat.addAction(16);
            Rect boundsForIndex = getBoundsForIndex(i3);
            if (boundsForIndex.isEmpty()) {
                boundsForIndex = new Rect(0, 0, 1, 1);
            }
            if (boundsForIndex.left == 0 && boundsForIndex.top == 0 && boundsForIndex.right == 1 && boundsForIndex.bottom == 1) {
                b.e("FeedContentView", "virtual id = " + i3 + " is Rect(0, 0, 1, 1)");
            }
            if (boundsForIndex.isEmpty()) {
                b.e("FeedContentView", "virtual id = " + i3 + " is Empty");
            }
            if (FeedGlobalEnv.g().isDebug()) {
                b.c("CanvasFeedContentView", " virtual id " + i3);
            }
            accessibilityNodeInfoCompat.setBoundsInParent(boundsForIndex);
        }
    }

    public CanvasFeedContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isBizRecomFeeds = false;
        this.isShowFowardIcon = false;
        this.isForward = false;
        this.isDetail = false;
        this.GUIDE_TEXT = "guide_text";
        this.mDataSummaryChanged = false;
        this.mCanShowParticle = false;
        this.mMultiPicAreaVideoIndex = -1;
        this.desc = "";
        this.summaryString = "";
        this.TAG = "CanvasFeedContentView";
        this.mAreasList = new Vector();
        this.mShowCount = 0;
        this.isBlog = false;
        this.mIsNewHandBlog = false;
        this.mFontHideFlag = 0;
        this.adExposureCheckerCallback = null;
        this.invalidateRunnable = new Runnable() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentView.1
            @Override // java.lang.Runnable
            public void run() {
                if (((QzoneCanvasAreaView) CanvasFeedContentView.this).mScrollState == 1) {
                    CanvasFeedContentView.this.postInvalidate();
                }
            }
        };
        this.bubbleDanmakuRunnable = new Runnable() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentView.2
            @Override // java.lang.Runnable
            public void run() {
                CanvasFeedContentView.this.gdt_bubble_danmaku_presenter.getLayoutParams().width = CanvasFeedContentView.this.getWidth() / 2;
                CanvasFeedContentView.this.gdt_bubble_danmaku_presenter_bridge_area.getLayoutAttr().width = CanvasFeedContentView.this.getWidth() / 2;
                CanvasFeedContentView.this.requestLayout();
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i3 = message.what;
                if (i3 == 1) {
                    CanvasFeedContentView.this.updateParticles();
                } else if (i3 == 2) {
                    CanvasFeedContentView.this.showParticleGuide();
                }
                super.handleMessage(message);
            }
        };
        init();
        Paint paint = new Paint();
        this.mShadowPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1.0f);
    }

    protected static void clearAreaList(List<DittoArea> list) {
        list.clear();
    }

    private void gdtSupplementaryReport() {
        GdtAd gdtAd = new GdtAd(GdtFeedUtilForQZone.f(this.feedData));
        if (this.adExposureCheckerCallback == null) {
            this.adExposureCheckerCallback = new AdExposureChecker.ExposureCallback() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentView.5
                @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
                public void onExposure(WeakReference<View> weakReference) {
                    if (b.g()) {
                        b.c("AdExposureChecker", "onExposure");
                    }
                    CanvasFeedContentView canvasFeedContentView = CanvasFeedContentView.this;
                    GdtAdFeedUtil.doEffectiveExposureReport(canvasFeedContentView.feedData, canvasFeedContentView.getFeedPosition(), 0);
                }
            };
        }
        AdExposureChecker.onClick(getContext(), gdtAd, new WeakReference(this.adExposureCheckerCallback));
    }

    private int getSummaryHeight() {
        RichCanvasTextArea richCanvasTextArea = this.feed_content_normal_summary;
        int i3 = 0;
        if (richCanvasTextArea != null && richCanvasTextArea.getVisibility() == 0) {
            i3 = 0 + this.feed_content_normal_summary.getHeight();
        }
        RichCanvasTextArea richCanvasTextArea2 = this.feed_content_superlike_summary;
        return (richCanvasTextArea2 == null || richCanvasTextArea2.getVisibility() != 0) ? i3 : i3 + this.feed_content_superlike_summary.getHeight();
    }

    private void init() {
        setContentAreaForJsonFile("qzone_canvas_ui_feedcontent.json");
        this.feed_content_singal_pic.hotAreaCallBack = this;
    }

    private boolean isInMultiArea(float f16, float f17, DittoArea dittoArea) {
        return f17 > ((float) dittoArea.getTop()) && f17 < ((float) dittoArea.getBottom()) && f16 > ((float) dittoArea.getLeft()) && f16 < ((float) dittoArea.getRight());
    }

    private boolean isQCircleRecommFeed() {
        BusinessFeedData businessFeedData = this.feedData;
        return businessFeedData != null && businessFeedData.isQCircleRecommFeed();
    }

    private void setCommentPicArea(int i3, int i16) {
        BusinessFeedData originalInfo;
        if (!this.isForward) {
            originalInfo = this.feedData;
        } else {
            originalInfo = this.feedData.getOriginalInfo();
        }
        if (originalInfo == null) {
            this.feed_content_comment_pic.setVisibility(8);
            return;
        }
        if (this.isPassive && originalInfo.getCellSummaryV2() != null && originalInfo.getCellSummaryV2().summarypic != null) {
            this.feed_content_comment_pic.setVisibility(0);
            this.feed_content_comment_pic.setCanAutoPlayGif(i.H().k());
            this.feed_content_comment_pic.setPictureItems(originalInfo.getCellSummaryV2().summarypic, this.feedData.isInterestMessageFeeds());
            this.feed_content_comment_pic.setQunFeed(i.H().u1(originalInfo));
            this.feed_content_comment_pic.setPicUploadNum(i16, i3);
            this.mShowCount++;
            return;
        }
        this.feed_content_comment_pic.setVisibility(8);
    }

    private void setContentViewVideoPos(int i3, int i16) {
        FeedVideoView feedVideoView = this.mMultiPicAreaVideo;
        if (feedVideoView != null) {
            feedVideoView.setIfNeedShowVideoCover(false);
            int i17 = ((RelativeLayout.LayoutParams) this.mMultiPicAreaVideo.getLayoutParams()).topMargin;
            FeedVideoView feedVideoView2 = this.mMultiPicAreaVideo;
            feedVideoView2.setPadding(i3, i16 - i17, feedVideoView2.getPaddingRight(), this.mMultiPicAreaVideo.getPaddingBottom());
            if (this.mMultiPicAreaVideo.getVisibility() != 0) {
                this.mMultiPicAreaVideo.setVisibility(0);
            }
        }
    }

    private void setFlexPicInfo(BusinessFeedData businessFeedData, boolean z16, FeedPictureInfo[] feedPictureInfoArr, boolean z17, int i3) {
        int length;
        if (businessFeedData.getPictureInfo() != null) {
            length = businessFeedData.getPictureInfo().uploadnum;
        } else {
            length = feedPictureInfoArr != null ? feedPictureInfoArr.length : 0;
        }
        if (z16 && businessFeedData.getOriginalInfo() != null && businessFeedData.getOriginalInfo().getPictureInfo() != null) {
            length = businessFeedData.getOriginalInfo().getPictureInfo().uploadnum;
        }
        int imageCount = getImageCount(feedPictureInfoArr);
        CanvasFlexPicAreaGroup canvasFlexPicAreaGroup = this.feed_content_flex_pic_area;
        if (canvasFlexPicAreaGroup != null) {
            if (feedPictureInfoArr != null) {
                canvasFlexPicAreaGroup.setPicUploadNum(length, imageCount);
                this.feed_content_flex_pic_area.setPicInfos(feedPictureInfoArr, z16, this.hasSummary);
            } else {
                canvasFlexPicAreaGroup.setVisibility(8);
            }
        }
    }

    private void setGdtCrossAdDescription() {
        RichCanvasTextArea richCanvasTextArea = this.feed_content_normal_summary;
        if (richCanvasTextArea != null) {
            richCanvasTextArea.setVisibility(8);
        }
        setPadding(getPaddingLeft(), 0, getPaddingRight(), getPaddingBottom());
    }

    private void setLogoAttach() {
        FeedView feedView;
        int i3;
        if (this.feedData.isAttach()) {
            if ((getParent() instanceof FeedView) || (getParent().getParent() instanceof FeedView)) {
                if (getParent() instanceof FeedView) {
                    feedView = (FeedView) getParent();
                } else {
                    feedView = (FeedView) getParent().getParent();
                }
                if (feedView == null || feedView.getLayoutParams() == null) {
                    return;
                }
                int i16 = feedView.getLayoutParams().height;
                int i17 = AreaConst.ATTACH_PIC_WIDTH_IN_PX;
                int i18 = (i16 - ((AreaConst.ATTACH_TEXT_MARGIN_TOP_IN_PX + i17) + AreaConst.ATTACH_TEXT_SIZIE_IN_PX)) / 2;
                FeedSinglePicCanvasArea feedSinglePicCanvasArea = this.feed_content_singal_pic;
                if (this.feedData.isSquareCardStyle()) {
                    i3 = AreaConst.SQUARE_CARD_CONTAINER_WIDTH_IN_PX;
                } else {
                    i3 = AreaConst.cardContainerWidth;
                }
                feedSinglePicCanvasArea.setPaddingLeft((i3 - i17) / 2);
                this.feed_content_singal_pic.setPaddingTop(i18);
                setLogoAttachTextArea(this.feedData);
                return;
            }
            return;
        }
        this.feed_content_logo_attach_text.setVisibility(8);
    }

    private void setLogoAttachTextArea(BusinessFeedData businessFeedData) {
        CellAdvContainerAttach cellAdvContainerAttach = businessFeedData.getCellAdvContainerAttach();
        if (cellAdvContainerAttach == null || TextUtils.isEmpty(cellAdvContainerAttach.remark)) {
            return;
        }
        this.feed_content_logo_attach_text.setText(cellAdvContainerAttach.remark);
        this.feed_content_logo_attach_text.setVisibility(0);
    }

    private void setNoPhoto(int i3, FeedPictureInfo[] feedPictureInfoArr, boolean z16) {
        DittoImageArea dittoImageArea = this.feed_content_no_photo_mode;
        if (dittoImageArea == null) {
            return;
        }
        dittoImageArea.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showParticleGuide() {
        ParticleTextSurfaceView particleTextSurfaceView = this.mParticleTextView;
        if (particleTextSurfaceView == null || particleTextSurfaceView.getVisibility() != 0) {
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentView.4
            @Override // java.lang.Runnable
            public void run() {
                ParticleTextSurfaceView particleTextSurfaceView2;
                if (ParticleManager.u() && ParticleManager.i(CanvasFeedContentView.this.getContext()) && (particleTextSurfaceView2 = CanvasFeedContentView.this.mParticleTextView) != null && particleTextSurfaceView2.getVisibility() == 0 && CanvasFeedContentView.this.mCanShowParticle) {
                    CanvasFeedContentView canvasFeedContentView = CanvasFeedContentView.this;
                    if (canvasFeedContentView.isForward) {
                        return;
                    }
                    ParticleManager.K(canvasFeedContentView.getContext(), false);
                    new PopupText(CanvasFeedContentView.this.getContext(), ViewUtils.dpToPx(100.0f), ViewUtils.dpToPx(43.0f), CanvasFeedContentView.QZONE_FEED_PARTICLE_GUIDE_URL).e(CanvasFeedContentView.this, (ViewUtils.getScreenWidth() - ViewUtils.dpToPx(100.0f)) / 2, -(ViewUtils.dpToPx(43.0f) + CanvasFeedContentView.this.getMeasuredHeight()), true, true, 1000);
                    i.H().Y1("46", "12", "10", true);
                }
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateParticles() {
        ParticleTextSurfaceView particleTextSurfaceView;
        if (!ParticleManager.u() || (particleTextSurfaceView = this.mParticleTextView) == null || this.feed_content_normal_summary == null || !this.mCanShowParticle) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) particleTextSurfaceView.getLayoutParams();
        int i3 = layoutParams.height;
        boolean z16 = (i3 == 0 || i3 == this.feed_content_normal_summary.getHeight()) ? false : true;
        layoutParams.leftMargin = this.feed_content_normal_summary.getLeft();
        layoutParams.topMargin = this.feed_content_normal_summary.getTop();
        layoutParams.width = this.feed_content_normal_summary.getWidth();
        layoutParams.height = this.feed_content_normal_summary.getHeight();
        this.mParticleTextView.setLayoutParams(layoutParams);
        if (this.mDataSummaryChanged || z16) {
            this.mDataSummaryChanged = false;
            this.mParticleTextView.setVisibility(0);
            this.mParticleTextView.o(this);
        }
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView, android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        FeedContentViewTouchHelper feedContentViewTouchHelper;
        if (i.H().S0() && (feedContentViewTouchHelper = this.touchHelper) != null && feedContentViewTouchHelper.dispatchHoverEvent(motionEvent)) {
            return true;
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    DittoArea findArea(float f16, float f17) {
        if (this.isPassive) {
            for (DittoArea dittoArea : this.mAreasList) {
                if (dittoArea != null && f17 > dittoArea.getTop() && f17 < dittoArea.getBottom() && f16 > dittoArea.getLeft() && f16 < dittoArea.getRight()) {
                    return dittoArea;
                }
            }
            return null;
        }
        for (DittoArea dittoArea2 : this.mAreasList) {
            if (dittoArea2 != null && f17 > dittoArea2.getTop() && f17 < dittoArea2.getBottom()) {
                return dittoArea2;
            }
        }
        return null;
    }

    @Override // com.qzone.widget.particle.ParticleManager.b
    public Bitmap getBitmap() {
        int paddingLeft = getPaddingLeft();
        this.feed_content_normal_summary.measure(View.MeasureSpec.makeMeasureSpec((ViewUtils.getScreenWidth() - paddingLeft) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        Bitmap createBitmap = Bitmap.createBitmap(this.feed_content_normal_summary.getMeasuredWidth(), this.feed_content_normal_summary.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        RichCanvasTextArea richCanvasTextArea = this.feed_content_normal_summary;
        richCanvasTextArea.layout(0, 0, richCanvasTextArea.getMeasuredWidth(), this.feed_content_normal_summary.getMeasuredHeight());
        RichCanvasTextArea richCanvasTextArea2 = this.feed_content_normal_summary;
        richCanvasTextArea2.mDrawIgnoreVisible = true;
        richCanvasTextArea2.resetTextAnimation();
        this.feed_content_normal_summary.draw(canvas);
        this.feed_content_normal_summary.mDrawIgnoreVisible = false;
        return createBitmap;
    }

    @Override // com.qzone.widget.particle.ParticleManager.b
    public int getLineHeight() {
        RichCanvasTextArea richCanvasTextArea = this.feed_content_normal_summary;
        if (richCanvasTextArea != null) {
            return richCanvasTextArea.getLineHeight();
        }
        return 0;
    }

    @Override // com.qzone.widget.particle.ParticleManager.b
    public int getParticleHeight() {
        return this.feed_content_normal_summary.getHeight();
    }

    @Override // com.qzone.widget.particle.ParticleManager.b
    public int getParticleTextVisibility() {
        return this.feed_content_normal_summary.getVisibility();
    }

    @Override // com.qzone.widget.particle.ParticleManager.b
    public int getParticleWidth() {
        return this.feed_content_normal_summary.getWidth();
    }

    public FeedSinglePicCanvasArea getSinglePicArea() {
        return this.feed_content_singal_pic;
    }

    @Override // com.qzone.canvasui.widget.FeedSinglePicCanvasArea.HotAreaCallBack
    public void handleHotAreaClickEvent(RegionData regionData) {
        this.onFeedElementClickListener.onClick(this, FeedElement.GAME_SHARE_HOT_AREA, this.feedPosition, regionData.parseClickParamMap());
    }

    public boolean isAreaEmpty() {
        return this.mShowCount == 0;
    }

    public boolean isDirectAppDownloadFeed() {
        BusinessFeedData businessFeedData = this.feedData;
        return (businessFeedData == null || businessFeedData.getPictureInfo() == null || this.feedData.getPictureInfo().busiParam == null || !"1".equals(this.feedData.getPictureInfo().busiParam.get(61))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bd  */
    @DittoOnClick(values = {"feed_content_multi_pic", "feed_content_singal_pic", "feed_content_dynamic_album", "feed_content_event_tag", "feed_content_flex_pic_area", "gdt_bubble_danmaku_presenter_bridge_area"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCanvasAreaClicked(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
        boolean z16;
        FeedSinglePicCanvasArea feedSinglePicCanvasArea;
        FeedElement feedElement;
        String str;
        b.c("CANVASLOG", "onCanvasAreaClicked " + dittoArea.getId());
        if (this.onFeedElementClickListener == null) {
            return;
        }
        if (obj != null && (obj instanceof TextCell)) {
            return;
        }
        int type = dittoArea.getType();
        if (type != 79) {
            switch (type) {
                case 6:
                    if (isDirectAppDownloadFeed()) {
                        FeedSinglePicCanvasArea feedSinglePicCanvasArea2 = (FeedSinglePicCanvasArea) dittoArea;
                        float clickPosX = feedSinglePicCanvasArea2.getClickPosX();
                        int width = feedSinglePicCanvasArea2.getWidth();
                        if (clickPosX >= width * 0.78d && clickPosX <= width) {
                            z16 = true;
                            feedSinglePicCanvasArea = (FeedSinglePicCanvasArea) dittoArea;
                            if (!feedSinglePicCanvasArea.isTemplateShuoshuo(feedSinglePicCanvasArea.curPictureInfo, feedSinglePicCanvasArea.curFeedData)) {
                                g gVar = this.onFeedElementClickListener;
                                FeedElement feedElement2 = FeedElement.NOTHING;
                                int i3 = this.feedPosition;
                                gVar.onClick(this, feedElement2, i3, Integer.valueOf(i3));
                                return;
                            }
                            if (z16) {
                                g gVar2 = this.onFeedElementClickListener;
                                FeedElement feedElement3 = FeedElement.DOWNLOAD_APP;
                                int i16 = this.feedPosition;
                                gVar2.onClick(this, feedElement3, i16, new f(i16, 0, this.isShowFowardIcon));
                                return;
                            }
                            if (isNewHandBlog(this.feedData)) {
                                this.onFeedElementClickListener.onClick(this, FeedElement.BLOG_NEW_STYLE, this.feedPosition, null);
                                return;
                            }
                            if (isQCircleRecommFeed()) {
                                this.onFeedElementClickListener.onClick(this, FeedElement.FEED_QCIRCLE_RECOMMEND_CONTENT, this.feedPosition, this.feedData);
                                BusinessFeedData businessFeedData = this.feedData;
                                if (businessFeedData != null) {
                                    if (businessFeedData.getOperationInfoV2() != null && this.feedData.getOperationInfoV2().feedReportCookie != null) {
                                        str = this.feedData.getOperationInfoV2().feedReportCookie.get(50);
                                    } else {
                                        str = "";
                                    }
                                    i.H().g(801, 2, 1, "", "", str);
                                    return;
                                }
                                return;
                            }
                            g gVar3 = this.onFeedElementClickListener;
                            if (this.feedData.isAttach()) {
                                feedElement = FeedElement.LOGO_ATTACH;
                            } else {
                                feedElement = FeedElement.PHOTO;
                            }
                            int i17 = this.feedPosition;
                            gVar3.onClick(this, feedElement, i17, new f(i17, 0, this.isShowFowardIcon));
                            gdtSupplementaryReport();
                            return;
                        }
                    }
                    z16 = false;
                    feedSinglePicCanvasArea = (FeedSinglePicCanvasArea) dittoArea;
                    if (!feedSinglePicCanvasArea.isTemplateShuoshuo(feedSinglePicCanvasArea.curPictureInfo, feedSinglePicCanvasArea.curFeedData)) {
                    }
                    break;
                case 7:
                    CanvasMultiGifArea.ClickedPos clickedPos = (CanvasMultiGifArea.ClickedPos) dittoArea.getData();
                    g gVar4 = this.onFeedElementClickListener;
                    FeedElement feedElement4 = FeedElement.PHOTO;
                    int i18 = this.feedPosition;
                    gVar4.onClick(this, feedElement4, i18, new f(i18, clickedPos.selectedPos, clickedPos.isMask, this.isShowFowardIcon));
                    return;
                case 8:
                    g gVar5 = this.onFeedElementClickListener;
                    FeedElement feedElement5 = FeedElement.PHOTO;
                    int i19 = this.feedPosition;
                    gVar5.onClick(this, feedElement5, i19, new f(i19, ((Integer) dittoArea.getData()).intValue(), this.isShowFowardIcon));
                    return;
                case 9:
                    this.onFeedElementClickListener.onClick(this, FeedElement.BLOG_NEW_STYLE, this.feedPosition, null);
                    return;
                default:
                    return;
            }
        } else {
            CanvasFeedEventTagSmallTailArea canvasFeedEventTagSmallTailArea = this.feed_content_event_tag;
            if (canvasFeedEventTagSmallTailArea != null) {
                canvasFeedEventTagSmallTailArea.setFeedPosition(this.feedPosition);
                this.feed_content_event_tag.setOnFeedElementClickListener(this.onFeedElementClickListener);
                this.feed_content_event_tag.handleClickEvent(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DittoOnLongClick(values = {"feed_content_bizReco_title", "feed_content_normal_title", "feed_content_superlike_summary", "feed_content_normal_summary", "feed_content_bizRecom_summary", "feed_content_no_photo_mode", "feed_content_multi_pic", "feed_content_singal_pic", "feed_content_dynamic_album"})
    public void onCanvasAreaLongClick(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
        b.c("CANVASLOG", "onCanvasAreaLongClicked " + dittoArea.getId());
        if (this.onFeedElementClickListener == null) {
            return;
        }
        if (TextUtils.equals(dittoArea.getId(), "feed_content_normal_summary")) {
            if (this.isPassive) {
                return;
            }
            this.onFeedElementClickListener.a(FeedElement.SUMMARY, Integer.valueOf(this.feedPosition), this, null);
            return;
        }
        if (TextUtils.equals(dittoArea.getId(), "feed_content_singal_pic")) {
            f fVar = new f(this.feedPosition, 0, this.isShowFowardIcon);
            if (obj instanceof String) {
                fVar.e((String) obj);
            }
            this.onFeedElementClickListener.a(FeedElement.PHOTO, fVar, this, null);
            return;
        }
        if (TextUtils.equals(dittoArea.getId(), "feed_content_multi_pic")) {
            CanvasMultiGifArea.ClickedPos clickedPos = (CanvasMultiGifArea.ClickedPos) dittoArea.getData();
            f fVar2 = new f(this.feedPosition, clickedPos.selectedPos, clickedPos.isMask, this.isShowFowardIcon);
            if (obj instanceof String) {
                fVar2.e((String) obj);
            }
            this.onFeedElementClickListener.a(FeedElement.PHOTO, fVar2, this, null);
            return;
        }
        if (TextUtils.equals(dittoArea.getId(), "feed_content_dynamic_album")) {
            this.onFeedElementClickListener.a(FeedElement.PHOTO, new f(this.feedPosition, ((Integer) dittoArea.getData()).intValue(), this.isShowFowardIcon), this, null);
        } else {
            this.onFeedElementClickListener.onClick(this, FeedElement.ITEM_LONG_CLICKED, this.feedPosition, null);
        }
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView, com.tencent.ditto.DittoAreaView, android.view.View
    protected void onDraw(Canvas canvas) {
        CellSummary cellSummary;
        String str;
        int i3;
        if (this.isBlog && !this.isPassive && !this.isDetail && !this.mIsNewHandBlog) {
            CanvasFlexPicAreaGroup canvasFlexPicAreaGroup = this.feed_content_flex_pic_area;
            boolean z16 = (canvasFlexPicAreaGroup == null || canvasFlexPicAreaGroup.getVisibility() != 0) && (cellSummary = this.cellSummaryInfo) != null && (str = cellSummary.displayStr) != null && str.length() > 0 && this.cellSummaryInfo.displayStr.length() < 20;
            if (this.mShadowRect == null || this.mShadowWidth != getWidth() || this.mShadowHeight != getHeight() || this.mShadowForward != this.isForward || this.mShadowSingleLine != z16) {
                this.mShadowWidth = getWidth();
                this.mShadowHeight = getHeight();
                this.mShadowForward = this.isForward;
                this.mShadowSingleLine = z16;
                int i16 = AreaConst.dp8;
                float f16 = i16;
                if (this.mShadowForward) {
                    i3 = AreaConst.dp38;
                } else {
                    i3 = AreaConst.f48746dp1;
                }
                float f17 = i3;
                float width = getWidth() - i16;
                int height = getHeight();
                if (this.mShadowSingleLine) {
                    i16 = AreaConst.dp12;
                }
                this.mShadowRect = new RectF(f16, f17, width, height - i16);
            }
            CardUtils.drawCardShadow(canvas, this.mShadowRect, 8, this.mShadowPaint, i.H().p1() ? MiniChatConstants.COLOR_SELECTED_NIGHT : -1);
        }
        BusinessFeedData businessFeedData = this.feedData;
        if (businessFeedData != null && businessFeedData.isGDTAdvFeed() && QZoneAdFeedDataExtKt.isDanmakuAdv(this.feedData) && !this.feedData.isVideo() && this.gdt_bubble_danmaku_presenter.isRunning()) {
            getHandler().postDelayed(this.bubbleDanmakuRunnable, 100L);
        }
        super.onDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ditto.DittoAreaView, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        setMultiPicAreaVideoPos();
        setParticleTextViewPos();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ditto.DittoAreaView, android.view.View
    public void onMeasure(int i3, int i16) {
        onMeasurePadding();
        super.onMeasure(i3, i16);
        if (i.H().S0() && this.touchHelper == null) {
            FeedContentViewTouchHelper feedContentViewTouchHelper = new FeedContentViewTouchHelper(this);
            this.touchHelper = feedContentViewTouchHelper;
            ViewCompat.setAccessibilityDelegate(this, feedContentViewTouchHelper);
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    protected void onMeasurePadding() {
        if (this.canvas_feed_content_view != null) {
            if (this.isForward) {
                BusinessFeedData businessFeedData = this.feedData;
                if (businessFeedData != null && businessFeedData.needShowForwardTitle()) {
                    this.canvas_feed_content_view.setPadding(0, 0, 0, AreaConst.f48747dp2);
                    return;
                }
                BusinessFeedData businessFeedData2 = this.feedData;
                if (businessFeedData2 != null && (businessFeedData2.isQCircleShareCardFeed() || this.feedData.isQCircleRecommFeed())) {
                    this.canvas_feed_content_view.setPadding(0, AreaConst.dp6, 0, 0);
                    return;
                } else {
                    this.canvas_feed_content_view.setPadding(0, AreaConst.dp6, 0, AreaConst.f48747dp2);
                    return;
                }
            }
            BusinessFeedData businessFeedData3 = this.feedData;
            if (businessFeedData3 != null && businessFeedData3.isSubOfFriendBirthdayContainerFeed()) {
                DittoArea dittoArea = this.canvas_feed_content_view;
                int i3 = AreaManager.dp5;
                dittoArea.setPadding(i3, 0, i3, 0);
                return;
            }
            this.canvas_feed_content_view.setPadding(0, 0, 0, 0);
        }
    }

    public void onPause() {
        FeedSinglePicCanvasArea feedSinglePicCanvasArea = this.feed_content_singal_pic;
        if (feedSinglePicCanvasArea != null) {
            feedSinglePicCanvasArea.onPause();
        }
        CanvasMultiGifArea canvasMultiGifArea = this.feed_content_multi_pic;
        if (canvasMultiGifArea != null) {
            canvasMultiGifArea.onPause();
        }
        ParticleTextSurfaceView particleTextSurfaceView = this.mParticleTextView;
        if (particleTextSurfaceView == null || particleTextSurfaceView.getVisibility() != 0) {
            return;
        }
        this.mParticleTextView.m();
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView
    public void onStateIdle() {
        CanvasMultiGifArea canvasMultiGifArea = this.feed_content_multi_pic;
        if (canvasMultiGifArea != null) {
            canvasMultiGifArea.onStateIdle();
        }
        FeedDynamicAlbumCanvasArea feedDynamicAlbumCanvasArea = this.feed_content_dynamic_album;
        if (feedDynamicAlbumCanvasArea != null) {
            feedDynamicAlbumCanvasArea.onStateIdle();
        }
        FeedSinglePicCanvasArea feedSinglePicCanvasArea = this.feed_content_singal_pic;
        if (feedSinglePicCanvasArea != null) {
            feedSinglePicCanvasArea.onStateIdle();
        }
        CanvasMultiGifArea canvasMultiGifArea2 = this.feed_content_comment_pic;
        if (canvasMultiGifArea2 != null) {
            canvasMultiGifArea2.onStateIdle();
        }
        CanvasFlexPicAreaGroup canvasFlexPicAreaGroup = this.feed_content_flex_pic_area;
        if (canvasFlexPicAreaGroup != null && canvasFlexPicAreaGroup.getVisibility() == 0) {
            this.feed_content_flex_pic_area.playGIF();
        }
        ParticleTextSurfaceView particleTextSurfaceView = this.mParticleTextView;
        if (particleTextSurfaceView != null && particleTextSurfaceView.getVisibility() == 0) {
            this.mParticleTextView.n();
        }
        RichCanvasTextArea richCanvasTextArea = this.feed_content_normal_summary;
        if (richCanvasTextArea != null) {
            richCanvasTextArea.onStateIdle();
        }
        setParticleGuide();
        getHandler().postDelayed(this.invalidateRunnable, 100L);
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView, com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateScrolling() {
        CanvasMultiGifArea canvasMultiGifArea = this.feed_content_multi_pic;
        if (canvasMultiGifArea != null) {
            canvasMultiGifArea.onStateScrolling();
        }
        CanvasFlexPicAreaGroup canvasFlexPicAreaGroup = this.feed_content_flex_pic_area;
        if (canvasFlexPicAreaGroup != null) {
            canvasFlexPicAreaGroup.onStateScrolling();
        }
        FeedSinglePicCanvasArea feedSinglePicCanvasArea = this.feed_content_singal_pic;
        if (feedSinglePicCanvasArea != null) {
            feedSinglePicCanvasArea.onStateScrolling();
        }
        CanvasMultiGifArea canvasMultiGifArea2 = this.feed_content_comment_pic;
        if (canvasMultiGifArea2 != null) {
            canvasMultiGifArea2.onStateScrolling();
        }
        ParticleTextSurfaceView particleTextSurfaceView = this.mParticleTextView;
        if (particleTextSurfaceView != null && particleTextSurfaceView.getVisibility() == 0) {
            this.mParticleTextView.m();
            this.mHandler.removeMessages(2);
        }
        RichCanvasTextArea richCanvasTextArea = this.feed_content_normal_summary;
        if (richCanvasTextArea != null) {
            richCanvasTextArea.onStateScrolling();
        }
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView
    public void reset() {
        CanvasMultiGifArea canvasMultiGifArea = this.feed_content_multi_pic;
        if (canvasMultiGifArea != null) {
            canvasMultiGifArea.reset();
        }
        this.mShowCount = 0;
        this.touchHelper = null;
        CanvasFeedEventTagSmallTailArea canvasFeedEventTagSmallTailArea = this.feed_content_event_tag;
        if (canvasFeedEventTagSmallTailArea != null) {
            canvasFeedEventTagSmallTailArea.reset();
        }
        ParticleTextSurfaceView particleTextSurfaceView = this.mParticleTextView;
        if (particleTextSurfaceView != null && particleTextSurfaceView.getVisibility() == 0) {
            this.mParticleTextView.l();
            this.mParticleTextView.setVisibility(8);
        }
        RichCanvasTextArea richCanvasTextArea = this.feed_content_normal_summary;
        if (richCanvasTextArea != null) {
            richCanvasTextArea.reset();
        }
        clearAreaList(this.mAreasList);
    }

    public void setBlogNormalSummary(CellSummary cellSummary, boolean z16, String str, boolean z17, boolean z18, int i3) {
        this.mFontHideFlag = cellSummary.getHideFlag();
        String str2 = cellSummary.displayStr;
        this.feed_content_blog_normal_summary.setTextSize(AreaConst.summaryTextSize);
        this.feed_content_blog_normal_summary.setTextColor(this.mIsBlogNightMode ? -6184543 : -10592674);
        this.feed_content_blog_normal_summary.setLineSpace(3);
        this.feed_content_blog_normal_summary.setIsNeedLineSpace(false);
        this.feed_content_blog_normal_summary.setMaxLines(i3 <= 0 ? 4 : 3);
        this.feed_content_blog_normal_summary.setIsShowMore(true);
        this.feed_content_blog_normal_summary.setHasMore(cellSummary.isMore > 0);
        CellSummary.SparkleWord sparkleWord = cellSummary.sparkleWord;
        if (sparkleWord != null && !sparkleWord.isEmpty()) {
            this.feed_content_blog_normal_summary.setTextColorAnimation(sparkleWord.sparkle_color, sparkleWord.span_time);
        } else {
            this.feed_content_blog_normal_summary.setTextColorAnimation(null, 0);
        }
        this.feed_content_blog_normal_summary.setFont(cellSummary.getFontId(z18), cellSummary.getFontUrl(z18), TextCellLayout.fontType2native(cellSummary.getFontType(z18)), cellSummary.getFontBGUrl(z18));
        this.feed_content_blog_normal_summary.setTextInType(cellSummary.getFontSize());
        this.feed_content_blog_normal_summary.setFontInfo(cellSummary.getSuperFontInfo(z18));
        this.feed_content_blog_normal_summary.setText(str2);
        if (z17) {
            this.feed_content_blog_normal_summary.setPackOrUnpackDirect(0);
            this.feed_content_blog_normal_summary.setIsShowMore(false);
            this.feed_content_blog_normal_summary.setHasMore(false);
        } else {
            this.feed_content_blog_normal_summary.setPackOrUnpackDirect(0);
            this.feed_content_blog_normal_summary.setMaxPack(8);
            this.feed_content_blog_normal_summary.setMinPack(AreaConst.minPack);
            this.feed_content_blog_normal_summary.setSummaryPackShowLine(AreaConst.packShowLine);
            this.feed_content_blog_normal_summary.setShowPackOrUnpack(true);
        }
    }

    public void setBlogNormalTitle(String str, boolean z16) {
        this.feed_content_blog_normal_title.setText(str);
        this.feed_content_blog_normal_title.setTextSize(18.0f);
        this.feed_content_blog_normal_title.setTextColor(this.mIsBlogNightMode ? -198683 : -16578534);
        this.feed_content_blog_normal_title.setTextBold(true);
        this.feed_content_blog_normal_title.setMaxLines(1);
        this.feed_content_blog_normal_title.setIsShowMore(false);
        this.feed_content_blog_normal_tag_img.setAsyncImage(null, BLOG_TITLE_IMG_URL, null, null);
        if (z16) {
            return;
        }
        this.feed_content_blog_normal_title.setPadding(0, 0, ViewUtils.dip2px(10.0f), 0);
    }

    public void setBlogTitle(BusinessFeedData businessFeedData) {
        int i3;
        if (this.isForward) {
            if (businessFeedData != null && businessFeedData.getUser() != null) {
                String str = businessFeedData.getUser().nickName;
                if (str.length() > 10) {
                    str = str.substring(0, 10) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                }
                this.feed_content_blog_forward_nickname.setText(str + MsgSummary.STR_COLON);
                RichCanvasTextArea richCanvasTextArea = this.feed_content_blog_title;
                if (this.mIsNewHandBlog) {
                    i3 = AreaConst.dp8;
                } else {
                    i3 = AreaConst.dp20;
                }
                richCanvasTextArea.setPadding(0, 0, 0, i3);
                this.feed_content_blog_title.setText(BLOG_TITLE);
            }
            this.feed_content_blog_forward_nickname.setTextSize(16.0f);
            this.feed_content_blog_forward_nickname.setTextColor(j.I());
            RichCanvasTextArea richCanvasTextArea2 = this.feed_content_blog_forward_nickname;
            richCanvasTextArea2.setPadding(richCanvasTextArea2.getPaddingLeft(), this.feed_content_blog_forward_nickname.getPaddingTop(), this.feed_content_blog_forward_nickname.getPaddingRight(), this.mIsNewHandBlog ? 0 : AreaConst.dp20);
            this.feed_content_blog_forward_nickname.setVisibility(0);
            this.feed_content_blog_title.setTextSize(16.0f);
            this.feed_content_blog_title.setTextColor(this.mIsBlogNightMode ? -1 : -16777216);
            this.feed_content_blog_title.setVisibility(0);
            return;
        }
        this.feed_content_blog_forward_nickname.setVisibility(8);
        this.feed_content_blog_title.setVisibility(8);
    }

    public void setContentViewVideoMode() {
        FeedVideoView feedVideoView = this.mMultiPicAreaVideo;
        if (feedVideoView != null) {
            feedVideoView.setVideoPicMixMode(true);
            CanvasMultiGifArea canvasMultiGifArea = this.feed_content_multi_pic;
            if (canvasMultiGifArea != null) {
                this.mMultiPicAreaVideo.setVideoPicMixModeClipSize(canvasMultiGifArea.getSinglePicSize());
            }
        }
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setDetailNormalSummary(CellSummary cellSummary, boolean z16, String str, boolean z17) {
        String str2;
        this.feed_content_normal_summary.setTextSize(AreaConst.summaryTextSize);
        this.feed_content_normal_summary.setTextColor(j.o());
        this.feed_content_normal_summary.setLineSpace(3);
        this.feed_content_normal_summary.setMaxLines(-1);
        this.feed_content_normal_summary.setIsShowMore(false);
        CellSummary.SparkleWord sparkleWord = cellSummary.sparkleWord;
        if (sparkleWord != null && !sparkleWord.isEmpty()) {
            this.feed_content_normal_summary.setTextColorAnimation(sparkleWord.sparkle_color, sparkleWord.span_time);
        } else {
            this.feed_content_normal_summary.setTextColorAnimation(null, 0);
        }
        this.feed_content_normal_summary.setFont(cellSummary.getFontId(false), cellSummary.getFontUrl(false), TextCellLayout.fontType2native(cellSummary.getFontType(false)), cellSummary.getFontBGUrl(false));
        this.feed_content_normal_summary.setTextInType(cellSummary.getFontSize());
        this.feed_content_normal_summary.setFontInfo(cellSummary.getSuperFontInfo(false));
        RichCanvasTextArea richCanvasTextArea = this.feed_content_normal_summary;
        if (z17) {
            str2 = cellSummary.displayStr;
        } else {
            str2 = cellSummary.summary;
        }
        richCanvasTextArea.setText(str2);
    }

    protected void setDynamicAlbumArea(BusinessFeedData businessFeedData, FeedPictureInfo[] feedPictureInfoArr) {
        this.feed_content_dynamic_album.setPicInfo(businessFeedData, feedPictureInfoArr, false);
        this.feed_content_dynamic_album.setVisibility(0);
        this.mAreasList.add(this.feed_content_dynamic_album);
    }

    protected void setEventTagArea(BusinessFeedData businessFeedData, CellBottomRecomm cellBottomRecomm, boolean z16) {
        if (this.isForward) {
            this.feed_content_event_tag.setPadding(AreaConst.dp8, AreaConst.dp5, getPaddingRight(), AreaConst.f48747dp2);
        }
        cellBottomRecomm.preCalculate();
        this.feed_content_event_tag.setData(businessFeedData, cellBottomRecomm, z16, this);
    }

    public void setFeedData(BusinessFeedData businessFeedData) {
        if (this.feedData != businessFeedData) {
            this.feedData = businessFeedData;
            this.gdt_bubble_danmaku_presenter_bridge_area = (DittoBridgeArea) findAreaById("gdt_bubble_danmaku_presenter");
            this.gdt_bubble_danmaku_presenter = (GdtBubbleDanmakuPresenter) findBridgeViewById("gdt_bubble_danmaku_presenter", GdtBubbleDanmakuPresenter.class);
            this.gdt_bubble_danmaku_presenter_bridge_area.setContentDescription("\u6c14\u6ce1\u5f39\u5e55");
        }
    }

    public void setFeedPos(int i3) {
        this.feedPosition = i3;
    }

    public void setHideSummary(boolean z16) {
        this.hideSummary = z16;
    }

    public void setIsDetail(boolean z16) {
        this.isDetail = z16;
    }

    public void setIsForward(boolean z16) {
        this.isForward = z16;
        this.isShowFowardIcon = z16;
    }

    protected void setMultiPicArea(int i3, int i16, FeedPictureInfo[] feedPictureInfoArr, boolean z16) {
        this.feed_content_multi_pic.setVisibility(0);
        this.feed_content_multi_pic.setCanAutoPlayGif(i.H().k());
        this.feed_content_multi_pic.setPicInfos(feedPictureInfoArr, this.feedData.isQCircleRecommFeed(), z16, this.hasSummary, this.feedData);
        this.feed_content_multi_pic.setQunFeed(i.H().u1(this.feedData));
        this.feed_content_multi_pic.setPicUploadNum(i16, i3);
        this.feed_content_multi_pic.setIsGdtPic(this.feedData.isGDTAdvFeed(), QZoneAdFeedDataExtKt.isBrandOptimizationAdv(this.feedData));
        this.mAreasList.add(this.feed_content_multi_pic);
    }

    public void setMultiPicAreaVideo(int i3, FeedVideoView feedVideoView) {
        this.mMultiPicAreaVideoIndex = i3;
        this.mMultiPicAreaVideo = feedVideoView;
    }

    public void setMultiPicAreaVideoPos() {
        int i3;
        if (this.feed_content_multi_pic.getColumnNum() == 0 || (i3 = this.mMultiPicAreaVideoIndex) < 0) {
            return;
        }
        CanvasMultiGifArea canvasMultiGifArea = this.feed_content_multi_pic;
        float picLeft = canvasMultiGifArea.getPicLeft(i3, canvasMultiGifArea.getColumnNum(), this.feed_content_multi_pic.getPicNum(), this.feed_content_multi_pic.getSinglePicSize());
        CanvasMultiGifArea canvasMultiGifArea2 = this.feed_content_multi_pic;
        float picTop = canvasMultiGifArea2.getPicTop(this.mMultiPicAreaVideoIndex, canvasMultiGifArea2.getColumnNum(), this.feed_content_multi_pic.getPicNum(), this.feed_content_multi_pic.getSinglePicSize());
        float f16 = picLeft <= 0.0f ? 0.0f : picLeft + 0.5f;
        float f17 = picTop > 0.0f ? picTop + 0.5f : 0.0f;
        int[] locationToViewHost = DittoAreaView.getLocationToViewHost(this.feed_content_multi_pic);
        int i16 = locationToViewHost[0];
        setContentViewVideoPos(((int) f16) + getLeft() + this.feed_content_multi_pic.getLeft() + this.feed_content_multi_pic.getPaddingLeft(), ((int) f17) + locationToViewHost[1] + this.feed_content_multi_pic.getPaddingTop());
    }

    public void setNormalSummary(CellSummary cellSummary, boolean z16, String str, boolean z17, boolean z18) {
        String str2;
        String str3;
        int i3;
        String str4 = cellSummary.displayStr;
        this.feed_content_normal_summary.setTextSize(AreaConst.summaryTextSize);
        if (this.isBlog) {
            this.feed_content_normal_summary.setTextColor(j.F());
        } else {
            this.feed_content_normal_summary.setTextColor(j.o());
        }
        this.feed_content_normal_summary.setLineSpace(3);
        this.feed_content_normal_summary.setIsNeedLineSpace(false);
        this.feed_content_normal_summary.setMaxLines(AreaConst.normalMaxLines);
        this.feed_content_normal_summary.setIsShowMore(true);
        this.feed_content_normal_summary.setHasMore(cellSummary.isMore > 0);
        CellSummary.SparkleWord sparkleWord = cellSummary.sparkleWord;
        if (sparkleWord != null && !sparkleWord.isEmpty()) {
            this.feed_content_normal_summary.setTextColorAnimation(sparkleWord.sparkle_color, sparkleWord.span_time);
        } else {
            this.feed_content_normal_summary.setTextColorAnimation(null, 0);
        }
        this.feed_content_normal_summary.setBarrageInfo(cellSummary.barrageEffectInfo);
        this.feed_content_normal_summary.setFont(cellSummary.getFontId(z18), cellSummary.getFontUrl(z18), TextCellLayout.fontType2native(cellSummary.getFontType(z18)), cellSummary.getFontBGUrl(z18));
        this.feed_content_normal_summary.setTextInType(cellSummary.getFontSize());
        this.feed_content_normal_summary.setFontInfo(cellSummary.getSuperFontInfo(z18));
        Map<String, String> map = cellSummary.mapExt;
        if (map != null && map.get("guide_text") != null && cellSummary.barrageEffectInfo != null) {
            str4 = (str4 + cellSummary.mapExt.get("guide_text")).replace("{id}", cellSummary.barrageEffectInfo.f51896id + "");
        }
        Map<String, String> map2 = cellSummary.mapExt;
        if (map2 != null && (str2 = map2.get("pokeLikeEmotion")) != null && (str3 = cellSummary.mapExt.get("pokeLikeCount")) != null) {
            b.a("CanvasFeedContentView", "setNormalSummary: poke msg " + str2 + " " + str3);
            try {
                i3 = Integer.parseInt(str3);
            } catch (NumberFormatException e16) {
                b.j("CanvasFeedContentView", "setNormalSummary: wrong poke count " + str3, e16);
                i3 = -1;
            }
            str4 = Comment.getPokeLikeCommentStatic(str4, str2, i3);
            b.a("CanvasFeedContentView", "setNormalSummary: parse poke tag " + str4);
        }
        if (this.feedData.isQCircleRecommFeed()) {
            j.g(978);
            LayoutAttrSet layoutAttr = this.feed_content_normal_summary.getLayoutAttr();
            layoutAttr.leftPadding = AreaConst.dp11;
            int i16 = AreaConst.dp8;
            layoutAttr.leftMargin = i16;
            layoutAttr.rightMargin = i16;
            this.feed_content_normal_summary.setLayoutAttr(layoutAttr);
            if (!TextUtils.isEmpty(cellSummary.summary)) {
                this.feed_content_normal_summary.setText(cellSummary.summary);
            }
        } else {
            this.feed_content_normal_summary.setText(str4);
        }
        if (z17) {
            this.feed_content_normal_summary.setMaxLines(AreaConst.ADV_CONTAINER_SUMMARY_MAX_LINE);
            this.feed_content_normal_summary.setMinLine(cellSummary.minLine);
            this.feed_content_normal_summary.setPackOrUnpackDirect(0);
            this.feed_content_normal_summary.setIsShowMore(false);
            this.feed_content_normal_summary.setHasMore(false);
            return;
        }
        this.feed_content_normal_summary.setPackOrUnpackDirect(AreaConst.packOrUnpackDirect);
        this.feed_content_normal_summary.setMaxPack(AreaConst.maxPack);
        this.feed_content_normal_summary.setMinPack(AreaConst.minPack);
        this.feed_content_normal_summary.setSummaryPackShowLine(AreaConst.packShowLine);
        this.feed_content_normal_summary.setShowPackOrUnpack(true);
        this.feed_content_normal_summary.setIsSpan(FeedSpanManager.getInstance().getState(str));
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView
    public void setOnFeedElementClickListener(g gVar) {
        this.onFeedElementClickListener = gVar;
    }

    public void setParticleGuide() {
        ParticleTextSurfaceView particleTextSurfaceView = this.mParticleTextView;
        if (particleTextSurfaceView == null || particleTextSurfaceView.getVisibility() != 0) {
            return;
        }
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessageDelayed(2, 1000L);
    }

    public void setParticleTextViewPos() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 200L);
    }

    @Override // com.qzone.widget.particle.ParticleManager.b
    public void setParticleTextVisibility(int i3) {
        if (this.mCanShowParticle || i3 == 0) {
            this.feed_content_normal_summary.setParticleTextVisibility(i3);
            invalidate();
        }
    }

    public void setParticletextView(ParticleTextSurfaceView particleTextSurfaceView) {
        this.mParticleTextView = particleTextSurfaceView;
        this.feed_content_normal_summary.setParticleTextView(particleTextSurfaceView);
    }

    protected void setPicInfo(BusinessFeedData businessFeedData, boolean z16, FeedPictureInfo[] feedPictureInfoArr, boolean z17, int i3) {
        int length;
        LinearAreaLayout linearAreaLayout;
        if (businessFeedData.getPictureInfo() != null) {
            length = businessFeedData.getPictureInfo().uploadnum;
        } else {
            length = feedPictureInfoArr != null ? feedPictureInfoArr.length : 0;
        }
        if (z16 && businessFeedData.getOriginalInfo() != null && businessFeedData.getOriginalInfo().getPictureInfo() != null) {
            length = businessFeedData.getOriginalInfo().getPictureInfo().uploadnum;
        }
        int imageCount = getImageCount(feedPictureInfoArr);
        if (imageCount > 1 && businessFeedData.isPublicAccountContent()) {
            imageCount = 1;
        }
        businessFeedData.getAdData();
        boolean z18 = (z16 || !(businessFeedData.isQCircleRecommFeed() || businessFeedData.isQCircleShareCardFeed()) || businessFeedData.getOriginalInfo() == null || businessFeedData.getOriginalInfo().getCellSummaryV2() == null || TextUtils.isEmpty(businessFeedData.getOriginalInfo().getCellSummaryV2().summary)) ? imageCount > 0 && !QZoneAdFeedDataExtKt.isTouchFlipAdv(businessFeedData) : false;
        setNoPhoto(i3, feedPictureInfoArr, z17);
        setCommentPicArea(imageCount, length);
        if (z18 && feedPictureInfoArr != null && feedPictureInfoArr.length > 0) {
            if (businessFeedData.isDynamicAlbumFeed()) {
                setDynamicAlbumArea(businessFeedData, feedPictureInfoArr);
                this.feed_content_singal_pic.setVisibility(8);
                this.feed_content_multi_pic.setVisibility(8);
                LinearAreaLayout linearAreaLayout2 = this.gdt_addGroup;
                if (linearAreaLayout2 != null && this.gdt_addGroup_container != null) {
                    linearAreaLayout2.setVisibility(8);
                    this.gdt_addGroup_container.setVisibility(8);
                }
                this.mShowCount++;
                return;
            }
            if (imageCount != 1) {
                if (imageCount > 1) {
                    setMultiPicArea(imageCount, length, feedPictureInfoArr, z16);
                    this.feed_content_dynamic_album.setVisibility(8);
                    this.feed_content_singal_pic.setVisibility(8);
                    LinearAreaLayout linearAreaLayout3 = this.gdt_addGroup;
                    if (linearAreaLayout3 != null && this.gdt_addGroup_container != null) {
                        linearAreaLayout3.setVisibility(8);
                        this.gdt_addGroup_container.setVisibility(8);
                    }
                    this.mShowCount++;
                    return;
                }
                return;
            }
            setSingPicArea(imageCount, feedPictureInfoArr);
            if (!QZoneAdFeedDataExtKt.isAddGroupAdv(businessFeedData) && (linearAreaLayout = this.gdt_addGroup) != null && this.gdt_addGroup_container != null) {
                linearAreaLayout.setVisibility(8);
                this.gdt_addGroup_container.setVisibility(8);
            }
            if (!businessFeedData.isVideo() && QZoneAdFeedDataExtKt.isDanmakuAdv(businessFeedData) && QZoneAdFeedDataExtKt.isGDTAdvFeed(businessFeedData)) {
                String[] danmakuAdContents = businessFeedData.getAdData().getDanmakuAdContents();
                if (danmakuAdContents != null && danmakuAdContents.length != 0) {
                    showBubbleDanmakuView(danmakuAdContents);
                }
            } else {
                this.gdt_bubble_danmaku_presenter_bridge_area.setVisibility(8);
                this.gdt_bubble_danmaku_presenter.setVisibility(8);
            }
            this.feed_content_dynamic_album.setVisibility(8);
            this.feed_content_multi_pic.setVisibility(8);
            this.mShowCount++;
            return;
        }
        this.feed_content_dynamic_album.setVisibility(8);
        this.feed_content_singal_pic.setVisibility(8);
        this.feed_content_multi_pic.setVisibility(8);
        LinearAreaLayout linearAreaLayout4 = this.gdt_addGroup;
        if (linearAreaLayout4 == null || this.gdt_addGroup_container == null) {
            return;
        }
        linearAreaLayout4.setVisibility(8);
        this.gdt_addGroup_container.setVisibility(8);
    }

    protected void setTextInfo(BusinessFeedData businessFeedData, boolean z16, FeedPictureInfo[] feedPictureInfoArr) {
        clearParticleFlag();
        if (businessFeedData.getPictureInfo() != null) {
            int i3 = businessFeedData.getPictureInfo().uploadnum;
        }
        int imageCount = getImageCount(feedPictureInfoArr);
        if (this.hideSummary) {
            return;
        }
        if (z16) {
            if (businessFeedData.isQCircleShareCardFeed()) {
                return;
            }
            setTitleAndSummary(businessFeedData.getOriginalInfo(), imageCount);
            return;
        }
        setTitleAndSummary(businessFeedData, imageCount);
    }

    public void showBubbleDanmakuView(String[] strArr) {
        b.e("GdtBubbleDanmakuPresenter", "danmaku should show here");
        GdtBubbleDanmakuPresenter gdtBubbleDanmakuPresenter = this.gdt_bubble_danmaku_presenter;
        if (gdtBubbleDanmakuPresenter == null || this.gdt_bubble_danmaku_presenter_bridge_area == null) {
            return;
        }
        if (gdtBubbleDanmakuPresenter.getVisibility() == 0 && this.gdt_bubble_danmaku_presenter_bridge_area.getVisibility() == 0) {
            return;
        }
        if (strArr.length != 0) {
            this.gdt_bubble_danmaku_presenter.initDanmakuItemViews(strArr);
            this.gdt_bubble_danmaku_presenter.start();
            this.gdt_bubble_danmaku_presenter.setVisibility(0);
            this.gdt_bubble_danmaku_presenter_bridge_area.setVisibility(0);
            return;
        }
        this.gdt_bubble_danmaku_presenter.setVisibility(8);
        this.gdt_bubble_danmaku_presenter_bridge_area.setVisibility(8);
    }

    private void setSingPicArea(int i3, FeedPictureInfo[] feedPictureInfoArr) {
        CellDecorateInfo cellDecorateInfo;
        CellDecorateInfo.CellGiftData cellGiftData;
        int i16;
        FeedPictureInfo feedPictureInfo = feedPictureInfoArr[0];
        if (feedPictureInfo.d() != FeedPictureInfo.ImageType.BALL_PANORAMA && feedPictureInfo.d() != FeedPictureInfo.ImageType.CIRCLE_PANORAMA) {
            if (this.feedData.isAppShareCardFeed()) {
                this.feed_content_singal_pic.setVisibility(8);
                return;
            }
            if (FeedGiftUtil.c() && (cellDecorateInfo = this.feedData.cellDecorateInfo) != null && (cellGiftData = cellDecorateInfo.cellGiftData) != null && ((i16 = cellGiftData.iType) == 1 || i16 == 2)) {
                this.feed_content_singal_pic.setVisibility(8);
                return;
            }
            this.feed_content_singal_pic.setCanAutoPlayGif(i.H().k());
            this.feed_content_singal_pic.setIsPassive(this.isPassive);
            setLogoAttach();
            this.feed_content_singal_pic.setPicInfo(this.feedData, feedPictureInfo, feedPictureInfo.f50256s, feedPictureInfo.f50257t, getContext(), this.feedData.getFeedCommInfo().isBizRecomFeeds() || this.feedData.isSubOfMultiAdvContainerFeed() || this.feedData.isSubOfSingleAdvContainerFeed());
            if (this.feedData.isSubOfMultiAdvContainerFeed() || this.feedData.isSubOfSingleAdvContainerFeed()) {
                this.feed_content_singal_pic.setFlag(0);
            }
            this.feed_content_singal_pic.setVisibility(0);
            this.mAreasList.add(this.feed_content_singal_pic);
            return;
        }
        this.feed_content_singal_pic.setVisibility(8);
    }

    public void clearParticleFlag() {
        this.mCanShowParticle = false;
        this.mDataSummaryChanged = false;
        ParticleTextSurfaceView particleTextSurfaceView = this.mParticleTextView;
        if (particleTextSurfaceView != null) {
            particleTextSurfaceView.setCanShowParticle(false);
        }
    }

    public View getSinglePicAreaPos(Rect rect) {
        int[] iArr = new int[2];
        int[] iArr2 = {getWidth(), getHeight()};
        int[] iArr3 = new int[2];
        getLocationOnScreen(iArr3);
        if (rect == null) {
            rect = new Rect();
        }
        int paddingLeft = iArr3[0] + getPaddingLeft();
        rect.left = paddingLeft;
        int i3 = iArr3[1] + iArr2[1];
        int i16 = iArr[1];
        int i17 = i3 - i16;
        rect.top = i17;
        rect.right = paddingLeft + iArr[0];
        rect.bottom = i17 + i16;
        return this;
    }

    protected void onFeedContentViewClick(int i3) {
        super.playSoundEffect(0);
        if (this.touchHelper == null) {
            return;
        }
        if (FeedGlobalEnv.g().isDebug()) {
            b.c("CanvasFeedContentView", " on click virtual " + i3);
        }
        this.touchHelper.invalidateVirtualView(i3);
        this.touchHelper.sendEventForVirtualView(i3, 1);
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        BusinessFeedData businessFeedData;
        this.isRecycled = true;
        this.mShowCount = 0;
        this.isBizRecomFeeds = false;
        ParticleTextSurfaceView particleTextSurfaceView = this.mParticleTextView;
        if (particleTextSurfaceView != null) {
            particleTextSurfaceView.setVisibility(8);
        }
        this.mCanShowParticle = false;
        RichCanvasTextArea richCanvasTextArea = this.feed_content_normal_summary;
        if (richCanvasTextArea != null) {
            richCanvasTextArea.onRecycled();
        }
        TagImageArea tagImageArea = this.feed_content_blog_normal_tag_img;
        if (tagImageArea != null) {
            tagImageArea.onRecycled();
        }
        super.onRecycled();
        if (this.gdt_bubble_danmaku_presenter == null || (businessFeedData = this.feedData) == null || !businessFeedData.isGDTAdvFeed() || this.feedData.isVideo()) {
            return;
        }
        this.gdt_bubble_danmaku_presenter.recycle();
        this.gdt_bubble_danmaku_presenter.setVisibility(8);
        this.gdt_bubble_danmaku_presenter_bridge_area.setVisibility(8);
    }

    public static int getImageCount(FeedPictureInfo[] feedPictureInfoArr) {
        if (feedPictureInfoArr != null) {
            return feedPictureInfoArr.length;
        }
        return 0;
    }

    protected boolean hasEventTagInForwardView(BusinessFeedData businessFeedData) {
        return (businessFeedData == null || this.feed_content_event_tag == null || businessFeedData.getOriginalInfo() == null || businessFeedData.getOriginalInfo().getCellBottomRecomm() == null) ? false : true;
    }

    boolean isNewHandBlog(BusinessFeedData businessFeedData) {
        return businessFeedData != null && (businessFeedData.isNewHandBlogFeed() || (this.isForward && businessFeedData.getOriginalInfoSafe().isNewHandBlogFeed()));
    }

    public void setAddGroupView(FeedPictureInfo[] feedPictureInfoArr) {
        FeedPictureInfo feedPictureInfo;
        if (feedPictureInfoArr == null || feedPictureInfoArr.length <= 0 || (feedPictureInfo = feedPictureInfoArr[0]) == null || this.gdt_addGroup == null || this.gdt_addGroup_container == null || this.gdt_addGroup_logo == null || this.gdt_addGroup_desc == null || this.gdt_addGroup_button == null) {
            return;
        }
        BusinessFeedData businessFeedData = this.feedData;
        if (businessFeedData != null && businessFeedData.getRecommAction() != null) {
            this.addGroupAdvUrl = this.feedData.getRecommAction().dest_url;
        }
        BusinessFeedData businessFeedData2 = this.feedData;
        String str = (businessFeedData2 == null || businessFeedData2.getRecommAction() == null || TextUtils.isEmpty(this.feedData.getRecommAction().buttonText)) ? null : this.feedData.getRecommAction().buttonText;
        if ((str != null ? str.length() : 0) < 4) {
            this.gdt_addGroup_button.getLayoutAttr().setMargin(com.qzone.proxy.feedcomponent.util.g.a(26.0f), com.qzone.proxy.feedcomponent.util.g.a(16.0f), 0, 0);
        } else {
            this.gdt_addGroup_button.getLayoutAttr().setMargin(com.qzone.proxy.feedcomponent.util.g.a(19.0f), com.qzone.proxy.feedcomponent.util.g.a(16.0f), 0, 0);
        }
        BusinessFeedData businessFeedData3 = this.feedData;
        String str2 = (businessFeedData3 == null || businessFeedData3.getCellSummary() == null || this.feedData.getCellSummary().mapExt == null || !this.feedData.getCellSummary().mapExt.containsKey(ADV_DESC.value)) ? null : this.feedData.getCellSummary().mapExt.get(ADV_DESC.value);
        this.gdt_addGroup.getLayoutAttr().width = feedPictureInfo.f50256s;
        this.gdt_addGroup.getLayoutAttr().height = feedPictureInfo.f50257t;
        this.gdt_addGroup_container.getLayoutAttr().height = feedPictureInfo.f50257t;
        this.gdt_addGroup.setMargin(com.qzone.proxy.feedcomponent.util.g.a(8.0f), -feedPictureInfo.f50257t, 0, 0);
        LinearAreaLayout linearAreaLayout = this.gdt_addGroup_container;
        linearAreaLayout.setMargin(feedPictureInfo.f50256s - linearAreaLayout.width, 0, 0, 0);
        BusinessFeedData businessFeedData4 = this.feedData;
        if (businessFeedData4 != null && businessFeedData4.getUser() != null) {
            this.gdt_addGroup_logo.setAsyncImage(null, this.feedData.getUser().logo, null, null);
        }
        this.gdt_addGroup_logo.setBorderRadius(AreaConst.dp40);
        this.gdt_addGroup_desc.setText(str2);
        this.gdt_addGroup_button.setText(str);
        this.gdt_addGroup.setVisibility(0);
        this.gdt_addGroup_container.setVisibility(0);
        this.gdt_addGroup_logo.setVisibility(0);
        this.gdt_addGroup_desc.setVisibility(0);
        this.gdt_addGroup_desc.setTextAlignment(Layout.Alignment.ALIGN_CENTER);
        this.gdt_addGroup_button.setVisibility(0);
        if (i.H().p1()) {
            this.gdt_addGroup_container.setBackgroundColor(Color.parseColor("#0071FF"));
            this.gdt_addGroup_desc.setTextColor(Color.parseColor("#FFFFFF"));
            this.gdt_addGroup_button.setTextColor(Color.parseColor("#0071FF"));
        } else {
            this.gdt_addGroup_container.setBackgroundColor(Color.parseColor("#00CAFC"));
            this.gdt_addGroup_desc.setTextColor(Color.parseColor("#FFFFFF"));
            this.gdt_addGroup_button.setTextColor(Color.parseColor("#21BBED"));
        }
        this.gdt_addGroup_logo.setAlpha(255.0f);
        this.gdt_addGroup_button.setAlpha(255.0f);
        this.gdt_addGroup_container.setAlpha(217.0f);
        this.gdt_addGroup.setAlpha(0.0f);
    }

    private void setTitleAndSummary(BusinessFeedData businessFeedData, int i3) {
        RichCanvasTextArea richCanvasTextArea;
        boolean z16;
        ParticleTextSurfaceView particleTextSurfaceView;
        CellSummary cellSummary;
        CellTitleInfo cellTitleInfo;
        CellTitleInfo cellTitleInfo2;
        String str;
        if (businessFeedData == null) {
            return;
        }
        if (businessFeedData.isAlbumRecFeed()) {
            AlbumRecReporter.c cVar = businessFeedData.albumRecInfo;
            this.cellTitleInfo = null;
            CellSummary cellSummary2 = new CellSummary();
            this.cellSummaryInfo = cellSummary2;
            if (cVar == null) {
                str = "";
            } else {
                str = cVar.content;
            }
            cellSummary2.summary = str;
            cellSummary2.actionType = 20;
            cellSummary2.displayStr = str;
        } else {
            this.cellTitleInfo = businessFeedData.getTitleInfoV2();
            this.cellSummaryInfo = businessFeedData.getCellSummaryV2();
        }
        if (this.feed_content_bizReco_title == null || this.feed_content_normal_title == null || this.feed_content_superlike_summary == null || (richCanvasTextArea = this.feed_content_normal_summary) == null || this.feed_content_blog_title == null) {
            return;
        }
        richCanvasTextArea.setMaxCommentLine(TextCellLayout.isInMsgPage() ? MaxCommentLineConfig.MAX_COMMENT_LINE_MSG : 0);
        this.feed_content_blog_normal_tag_img.setVisibility(8);
        if (this.isBlog && !this.isPassive && !this.isDetail) {
            this.mIsBlogNightMode = i.H().p1();
            setBlogTitle(businessFeedData);
            CellTitleInfo cellTitleInfo3 = this.cellTitleInfo;
            if (cellTitleInfo3 != null && !TextUtils.isEmpty(cellTitleInfo3.title)) {
                this.feed_content_blog_normal_title.setAreaCacheKey(this.cellTitleInfo.integerUnikey);
                setBlogNormalTitle(this.cellTitleInfo.title, this.cellSummaryInfo != null);
                this.feed_content_blog_normal_title.setVisibility(0);
                this.feed_content_blog_normal_tag_img.setVisibility(0);
                this.mShowCount++;
            } else {
                this.feed_content_blog_normal_title.setVisibility(8);
            }
            CellSummary cellSummary3 = this.cellSummaryInfo;
            if (cellSummary3 != null && !TextUtils.isEmpty(cellSummary3.displayStr) && !this.mIsNewHandBlog) {
                this.feed_content_blog_normal_summary.setAreaCacheKey(Integer.valueOf((this.cellSummaryInfo.summaryAreaCacheKey.intValue() * 31) + i3));
                setBlogNormalSummary(this.cellSummaryInfo, this.isForward, this.summaryKey, this.isBizRecomFeeds, businessFeedData.feedType == 4097, i3);
                this.feed_content_blog_normal_summary.setVisibility(0);
                this.mShowCount++;
            } else {
                this.feed_content_blog_normal_summary.setVisibility(8);
            }
            this.feed_content_normal_title.setVisibility(8);
            this.feed_content_normal_summary.setVisibility(8);
            this.feed_content_bizReco_title.setVisibility(8);
            this.feed_content_superlike_summary.setVisibility(8);
            ParticleTextSurfaceView particleTextSurfaceView2 = this.mParticleTextView;
            if (particleTextSurfaceView2 != null) {
                particleTextSurfaceView2.setVisibility(8);
            }
            this.blog_line_area.setVisibility(8);
            return;
        }
        this.feed_content_blog_title.setVisibility(8);
        this.feed_content_blog_normal_summary.setVisibility(8);
        this.feed_content_blog_normal_title.setVisibility(8);
        this.blog_line_area.setVisibility(8);
        if (!this.isPassive && (cellTitleInfo2 = this.cellTitleInfo) != null && !TextUtils.isEmpty(cellTitleInfo2.displayTitle) && !businessFeedData.getFeedCommInfo().isPicUpLayout() && this.isBizRecomFeeds) {
            this.feed_content_bizReco_title.setAreaCacheKey(this.cellTitleInfo.integerUnikey);
            this.feed_content_bizReco_title.setText(this.cellTitleInfo.displayTitle);
            this.feed_content_bizReco_title.setVisibility(0);
            this.mAreasList.add(this.feed_content_bizReco_title);
            this.mShowCount++;
        } else {
            this.feed_content_bizReco_title.setVisibility(8);
        }
        if (!this.isPassive && (cellTitleInfo = this.cellTitleInfo) != null && !TextUtils.isEmpty(cellTitleInfo.displayTitle) && !businessFeedData.getFeedCommInfo().isPicUpLayout() && !this.isBizRecomFeeds) {
            this.feed_content_normal_title.setAreaCacheKey(this.cellTitleInfo.integerUnikey);
            if (businessFeedData.isPublicAccountContent()) {
                this.feed_content_normal_title.setMaxLines(1);
            }
            this.feed_content_normal_title.setText(this.cellTitleInfo.displayTitle);
            this.feed_content_normal_title.setVisibility(0);
            this.mAreasList.add(this.feed_content_normal_title);
            this.summaryString = this.cellTitleInfo.displayTitle;
            this.mShowCount++;
        } else {
            this.feed_content_normal_title.setVisibility(8);
        }
        CellSummary cellSummary4 = this.cellSummaryInfo;
        if (cellSummary4 != null) {
            this.mFontHideFlag = cellSummary4.getHideFlag();
        } else {
            this.mFontHideFlag = 0;
        }
        if (this.isPassive && (businessFeedData.getFeedCommInfo().feedsAttr & 524288) != 0 && (cellSummary = this.cellSummaryInfo) != null && !TextUtils.isEmpty(cellSummary.displayStr)) {
            this.feed_content_superlike_summary.setAreaCacheKey(this.cellSummaryInfo.summaryAreaCacheKey);
            this.feed_content_superlike_summary.setText(this.cellSummaryInfo.displayStr);
            this.feed_content_superlike_summary.setVisibility(0);
            this.mAreasList.add(this.feed_content_superlike_summary);
            this.mShowCount++;
        } else {
            CellSummary cellSummary5 = this.cellSummaryInfo;
            if (cellSummary5 != null && !TextUtils.isEmpty(cellSummary5.displayStr)) {
                CellSummary cellSummary6 = this.cellSummaryInfo;
                this.summaryKey = cellSummary6.uniKey;
                this.feed_content_normal_summary.setAreaCacheKey(cellSummary6.summaryAreaCacheKey);
                if (!this.isDetail) {
                    setNormalSummary(this.cellSummaryInfo, this.isForward, this.summaryKey, this.isBizRecomFeeds, businessFeedData.feedType == 4097);
                    this.mShowCount++;
                    this.mAreasList.add(this.feed_content_normal_summary);
                } else {
                    this.summaryKey += "isDetail";
                    this.feed_content_normal_summary.setAreaCacheKey(Integer.valueOf(this.cellSummaryInfo.summaryAreaCacheKey.intValue() + detailHash));
                    if (businessFeedData.getCellLuckyMoney() == null && (!(z16 = this.isForward) || !this.isDetail)) {
                        setDetailNormalSummary(this.cellSummaryInfo, z16, this.summaryKey, false);
                        this.mAreasList.add(this.feed_content_normal_summary);
                        this.mShowCount++;
                    } else {
                        setDetailNormalSummary(this.cellSummaryInfo, this.isForward, this.summaryKey, true);
                        this.mAreasList.add(this.feed_content_normal_summary);
                        this.mShowCount++;
                    }
                }
                if (businessFeedData.isFriendBirthdayContainerFeed()) {
                    this.feed_content_normal_summary.setMaxLines(1);
                }
                this.summaryString = this.cellSummaryInfo.displayReadeableStr;
                if (ParticleManager.u() && (particleTextSurfaceView = this.mParticleTextView) != null && !this.isDetail && !this.isForward) {
                    if (this.mFontHideFlag == 0) {
                        this.mCanShowParticle = false;
                        particleTextSurfaceView.setCanShowParticle(false);
                        if (!(businessFeedData.isPublicAccountContent() && (TextUtils.isEmpty(this.summaryString) || TextUtils.isEmpty(this.summaryString.trim())))) {
                            this.feed_content_normal_summary.setParticleTextVisibility(0);
                            this.feed_content_normal_summary.setVisibility(0);
                        }
                    } else {
                        this.mDataSummaryChanged = true;
                        this.mCanShowParticle = true;
                        particleTextSurfaceView.l();
                        this.mParticleTextView.setCanShowParticle(this.mCanShowParticle);
                        this.feed_content_normal_summary.setParticleTextVisibility(0);
                        this.feed_content_normal_summary.setVisibility(4);
                    }
                } else {
                    this.feed_content_normal_summary.setParticleTextVisibility(0);
                    this.feed_content_normal_summary.setVisibility(0);
                }
            } else {
                this.feed_content_superlike_summary.setVisibility(8);
                this.feed_content_normal_summary.setVisibility(8);
                ParticleTextSurfaceView particleTextSurfaceView3 = this.mParticleTextView;
                if (particleTextSurfaceView3 != null) {
                    particleTextSurfaceView3.setVisibility(8);
                }
            }
        }
        CellPictureInfo pictureInfo = businessFeedData.getPictureInfo();
        if (pictureInfo != null && !TextUtils.isEmpty(pictureInfo.displayStr)) {
            this.feed_content_picInfo_display.setVisibility(0);
            this.feed_content_picInfo_display.setAreaCacheKey(pictureInfo.integerUniKey);
            this.feed_content_picInfo_display.setText(pictureInfo.displayStr);
            this.mAreasList.add(this.feed_content_picInfo_display);
            this.mShowCount++;
            return;
        }
        this.feed_content_picInfo_display.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DittoOnClick(values = {"feed_content_bizReco_title", "feed_content_comment_pic", "feed_content_normal_title", "feed_content_superlike_summary", "feed_content_normal_summary", "feed_content_bizRecom_summary", "feed_content_no_photo_mode", "feed_content_picInfo_display", "canvas_feed_content_view", "feed_content_logo_attach_text", "gdt_addGroup_container"})
    public void onCanvasAreaOtherClicked(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
        FeedElement feedElement;
        FeedElement feedElement2;
        if (obj != null && (obj instanceof TextCell)) {
            TextCell textCell = (TextCell) obj;
            boolean z16 = this.isForward;
            if (this.onFeedElementClickListener != null) {
                BusinessFeedData businessFeedData = this.feedData;
                if (businessFeedData != null && businessFeedData.isAttach()) {
                    g gVar = this.onFeedElementClickListener;
                    FeedElement feedElement3 = FeedElement.LOGO_ATTACH;
                    int i3 = this.feedPosition;
                    gVar.onClick(this, feedElement3, i3, new f(i3, 0, this.isShowFowardIcon));
                    return;
                }
                if (textCell instanceof UserNameCell) {
                    if (z16 && QZoneAdFeedDataExtKt.isGDTForwardFeed(this.feedData)) {
                        this.onFeedElementClickListener.onClick(this, FeedElement.ORIGINAL_NICKNAME, this.feedPosition, textCell.getUin());
                    } else {
                        this.onFeedElementClickListener.onClick(this, FeedElement.FRIEND_NICKNAME, this.feedPosition, ((UserNameCell) textCell).getUin());
                    }
                }
                if (textCell instanceof UrlCell) {
                    UrlCell urlCell = (UrlCell) textCell;
                    if (urlCell.getAction() == 2) {
                        g gVar2 = this.onFeedElementClickListener;
                        FeedElement feedElement4 = FeedElement.CONTENT;
                        int i16 = this.feedPosition;
                        gVar2.onClick(this, feedElement4, i16, Integer.valueOf(i16));
                    } else {
                        this.onFeedElementClickListener.onClick(this, FeedElement.CONTENT_EXTERNAL_URL_CLICK, this.feedPosition, new e(urlCell.getUrl(), urlCell.post, this.feedPosition));
                    }
                }
                if (textCell instanceof ColorTextCell) {
                    if (textCell.getType() == 5) {
                        BusinessFeedData businessFeedData2 = this.feedData;
                        if (businessFeedData2 != null && businessFeedData2.getFeedCommInfo().isBizRecomFeeds()) {
                            g gVar3 = this.onFeedElementClickListener;
                            FeedElement feedElement5 = FeedElement.SUMMARY;
                            int i17 = this.feedPosition;
                            gVar3.onClick(this, feedElement5, i17, Integer.valueOf(i17));
                        } else if (this.isPassive) {
                            this.onFeedElementClickListener.onClick(this, FeedElement.CONTENT, this.feedPosition, Boolean.TRUE);
                        } else {
                            g gVar4 = this.onFeedElementClickListener;
                            FeedElement feedElement6 = FeedElement.CONTENT;
                            int i18 = this.feedPosition;
                            gVar4.onClick(this, feedElement6, i18, Integer.valueOf(i18));
                        }
                    } else if (textCell.getType() == 18) {
                        FeedSpanManager feedSpanManager = FeedSpanManager.getInstance();
                        boolean z17 = !feedSpanManager.getState(this.summaryKey);
                        this.isSpan = z17;
                        if (z17) {
                            if (!feedSpanManager.isContainKey(this.summaryKey)) {
                                feedSpanManager.saveState(this.summaryKey, this.isSpan);
                            }
                        } else if (feedSpanManager.isContainKey(this.summaryKey)) {
                            feedSpanManager.removeKey(this.summaryKey);
                        }
                        RichCanvasTextArea richCanvasTextArea = this.feed_content_normal_summary;
                        if (richCanvasTextArea != null) {
                            richCanvasTextArea.updateIsSpan(this.isSpan);
                        }
                        requestLayout();
                    } else if (textCell.getType() == 10) {
                        this.onFeedElementClickListener.onClick(this, FeedElement.OPEN_MORE_COMMENT, this.feedPosition, new CommentSpanData((ClickedComment) dittoArea.getData(), 0.0f));
                    }
                }
                if (textCell instanceof ComboNetImageCell) {
                    ComboNetImageCell comboNetImageCell = (ComboNetImageCell) textCell;
                    long j3 = this.mUin;
                    if (j3 != 0) {
                        comboNetImageCell.setUin(Long.valueOf(j3));
                    }
                    BusinessFeedData businessFeedData3 = this.feedData;
                    if (businessFeedData3 != null && businessFeedData3.getUser().nickName != null) {
                        comboNetImageCell.setNickname(this.feedData.getUser().nickName);
                    }
                    this.onFeedElementClickListener.onClick(this, FeedElement.COMMENT_POKE_COMBO, this.feedPosition, comboNetImageCell);
                    return;
                }
                return;
            }
            return;
        }
        if (this.onFeedElementClickListener != null) {
            if (!TextUtils.equals(dittoArea.getId(), "feed_content_normal_title") && !TextUtils.equals(dittoArea.getId(), "feed_content_bizReco_title")) {
                if (TextUtils.equals(dittoArea.getId(), "feed_content_superlike_summary")) {
                    g gVar5 = this.onFeedElementClickListener;
                    FeedElement feedElement7 = FeedElement.SUPERLIKE;
                    int i19 = this.feedPosition;
                    gVar5.onClick(this, feedElement7, i19, Integer.valueOf(i19));
                    return;
                }
                if (!TextUtils.equals(dittoArea.getId(), "feed_content_bizRecom_summary") && !TextUtils.equals(dittoArea.getId(), "feed_content_normal_summary")) {
                    if (TextUtils.equals(dittoArea.getId(), "feed_content_multi_pic")) {
                        this.onFeedElementClickListener.onClick(this, FeedElement.COMMENT_PIC, this.feedPosition, dittoArea.getData());
                        return;
                    }
                    if (TextUtils.equals(dittoArea.getId(), "canvas_feed_content_view")) {
                        BusinessFeedData businessFeedData4 = this.feedData;
                        if (businessFeedData4 != null && QZoneAdFeedDataExtKt.isGDTForwardFeed(businessFeedData4) && this.isForward) {
                            g gVar6 = this.onFeedElementClickListener;
                            FeedElement feedElement8 = FeedElement.ORIGINAL_SUMMARY;
                            int i26 = this.feedPosition;
                            gVar6.onClick(this, feedElement8, i26, Integer.valueOf(i26));
                            return;
                        }
                        if (this.feedData != null && this.isBlog && !this.isPassive && !this.isDetail) {
                            g gVar7 = this.onFeedElementClickListener;
                            FeedElement feedElement9 = FeedElement.BLOG_NEW_STYLE;
                            int i27 = this.feedPosition;
                            gVar7.onClick(this, feedElement9, i27, Integer.valueOf(i27));
                            return;
                        }
                        this.onFeedElementClickListener.onClick(this, FeedElement.NOTHING, this.feedPosition, dittoArea.getData());
                        return;
                    }
                    if (TextUtils.equals(dittoArea.getId(), "feed_content_comment_pic")) {
                        this.onFeedElementClickListener.onClick(this, FeedElement.COMMENT_PIC, this.feedPosition, dittoArea.getData());
                        return;
                    }
                    if (TextUtils.equals(dittoArea.getId(), "gdt_addGroup_container")) {
                        g gVar8 = this.onFeedElementClickListener;
                        if (this.feedData.isAttach()) {
                            feedElement2 = FeedElement.LOGO_ATTACH;
                        } else {
                            feedElement2 = FeedElement.PHOTO;
                        }
                        int i28 = this.feedPosition;
                        gVar8.onClick(this, feedElement2, i28, new f(i28, 0, this.isShowFowardIcon));
                        return;
                    }
                    return;
                }
                if (this.isPassive) {
                    this.onFeedElementClickListener.onClick(this, FeedElement.CONTENT, this.feedPosition, Boolean.FALSE);
                    return;
                }
                BusinessFeedData businessFeedData5 = this.feedData;
                if (businessFeedData5 != null && businessFeedData5.isAlbumRecFeed()) {
                    WeakReference<FeedAlbumRec> weakReference = FeedAlbumRec.sLastRef;
                    FeedAlbumRec feedAlbumRec = weakReference == null ? null : weakReference.get();
                    if (feedAlbumRec != null) {
                        feedAlbumRec.onClick(this);
                        return;
                    }
                    return;
                }
                BusinessFeedData businessFeedData6 = this.feedData;
                if (businessFeedData6 != null && QZoneAdFeedDataExtKt.isGDTForwardFeed(businessFeedData6) && this.isForward) {
                    g gVar9 = this.onFeedElementClickListener;
                    FeedElement feedElement10 = FeedElement.ORIGINAL_SUMMARY;
                    int i29 = this.feedPosition;
                    gVar9.onClick(this, feedElement10, i29, Integer.valueOf(i29));
                    return;
                }
                g gVar10 = this.onFeedElementClickListener;
                FeedElement feedElement11 = FeedElement.SUMMARY;
                int i36 = this.feedPosition;
                gVar10.onClick(this, feedElement11, i36, Integer.valueOf(i36));
                gdtSupplementaryReport();
                return;
            }
            g gVar11 = this.onFeedElementClickListener;
            if (this.feedData.isAttach()) {
                feedElement = FeedElement.LOGO_ATTACH;
            } else {
                feedElement = FeedElement.TITLE;
            }
            int i37 = this.feedPosition;
            gVar11.onClick(this, feedElement, i37, Integer.valueOf(i37));
        }
    }

    public void setContentInfo(BusinessFeedData businessFeedData, FeedPictureInfo[] feedPictureInfoArr, int i3, boolean z16, boolean z17) {
        FeedPictureInfo[] feedPictureInfoArr2;
        int i16;
        if (businessFeedData == null || !businessFeedData.isAlbumRecFeed()) {
            feedPictureInfoArr2 = feedPictureInfoArr;
        } else {
            feedPictureInfoArr2 = new FeedPictureInfo[0];
            z17 = false;
        }
        setContentAreaForJsonFile("qzone_canvas_ui_feedcontent.json");
        this.feed_content_singal_pic.hotAreaCallBack = this;
        setFeedData(businessFeedData);
        this.isPassive = z16;
        clearAreaList(this.mAreasList);
        if (businessFeedData == null) {
            return;
        }
        this.mUin = businessFeedData.getUser().uin;
        if (!this.isForward) {
            this.hasSummary = (businessFeedData.getCellSummaryV2() == null || TextUtils.isEmpty(businessFeedData.getCellSummaryV2().displayStr)) ? false : true;
            this.isBlog = businessFeedData.isBlogFeed();
            if (businessFeedData.getOriginalInfo() != null && businessFeedData.getOriginalInfo().isBlogFeed()) {
                this.isBlog = false;
            }
        } else if (businessFeedData.getOriginalInfo() != null) {
            this.hasSummary = (businessFeedData.getOriginalInfo().getCellSummaryV2() == null || TextUtils.isEmpty(businessFeedData.getOriginalInfo().getCellSummaryV2().displayStr)) ? false : true;
            this.isBlog = businessFeedData.getOriginalInfo().isBlogFeed();
        }
        this.mIsNewHandBlog = isNewHandBlog(businessFeedData);
        this.isBizRecomFeeds = businessFeedData.getFeedCommInfo().isBizRecomFeeds();
        if (businessFeedData.isFriendPlayingFeed()) {
            setPadding(getPaddingLeft(), 0, getPaddingRight(), getPaddingBottom());
        } else if (businessFeedData.isSubFeed && businessFeedData.parentContainerSubType == 1) {
            setPadding(getPaddingLeft(), this.hasSummary ? AreaConst.dp10 : 0, getPaddingRight(), getPaddingBottom());
        } else if (!QZoneAdFeedDataExtKt.isAdLittleIconStyle(businessFeedData) && !businessFeedData.isAlbumRecFeed()) {
            if (businessFeedData.isFriendPlayingRecomm()) {
                setPadding(getPaddingLeft(), AreaConst.dp10, getPaddingRight(), getPaddingBottom());
            } else {
                setPadding(getPaddingLeft(), 0, getPaddingRight(), getPaddingBottom());
            }
        } else {
            setPadding(getPaddingLeft(), AreaConst.dp10, getPaddingRight(), getPaddingBottom());
        }
        if (this.isBlog && !z16 && !this.isDetail && !this.mIsNewHandBlog) {
            int i17 = AreaConst.dp16;
            if (this.isForward) {
                i16 = AreaConst.f48747dp2;
            } else {
                i16 = AreaConst.dp14;
            }
            setPadding(i17, i16, i17, AreaConst.dp12);
        } else {
            setPadding(0, getPaddingTop(), 0, 0);
        }
        setTextInfo(businessFeedData, this.isForward, feedPictureInfoArr2);
        if (!z16 && this.isBlog && feedPictureInfoArr2 != null && !this.mIsNewHandBlog) {
            setFlexPicInfo(businessFeedData, this.isForward, feedPictureInfoArr2, z17, i3);
            this.feed_content_flex_pic_area.setVisibility(0);
            this.feed_content_multi_pic.setVisibility(8);
            this.feed_content_singal_pic.setVisibility(8);
            this.feed_content_dynamic_album.setVisibility(8);
            this.feed_content_comment_pic.setVisibility(8);
            LinearAreaLayout linearAreaLayout = this.gdt_addGroup;
            if (linearAreaLayout != null && this.gdt_addGroup_container != null) {
                linearAreaLayout.setVisibility(8);
                this.gdt_addGroup_container.setVisibility(8);
            }
            this.mShowCount++;
        } else {
            setPicInfo(businessFeedData, this.isForward, feedPictureInfoArr2, z17, i3);
            this.feed_content_flex_pic_area.setVisibility(8);
        }
        if (!z17 && hasEventTagInForwardView(businessFeedData) && this.isForward) {
            boolean z18 = businessFeedData.feedType == 2;
            this.feed_content_event_tag.setVisibility(0);
            setEventTagArea(businessFeedData, businessFeedData.getOriginalInfo().getCellBottomRecomm(), z18);
        } else {
            this.feed_content_event_tag.setVisibility(8);
        }
        if (businessFeedData.isLoverZonePassiveFeed()) {
            LpReportInfo_dc03950.report(new LpReportInfo_dc03950("25", "7", "1", "1"));
        }
        if (GdtAdFeedUtil.isCrossAd(businessFeedData)) {
            setGdtCrossAdDescription();
        }
    }

    public void update() {
    }
}
