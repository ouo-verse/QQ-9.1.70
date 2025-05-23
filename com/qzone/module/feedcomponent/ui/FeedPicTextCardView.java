package com.qzone.module.feedcomponent.ui;

import NS_MOBILE_FEEDS.s_join_list;
import NS_MOBILE_FEEDS.s_user;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.adapter.feedcomponent.r;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellBottomRecomm;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.component.media.image.processor.NormalFeedImageProcessor;
import com.tencent.mobileqq.mini.share.MiniShareQuicklySendPanelFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes39.dex */
public class FeedPicTextCardView extends View implements r, FeedChildView {
    public static final String GDT_AD_ICON_URL = "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_gdt_window_ad_2.png";
    private Drawable BACKGROUND_DRAWABLE;
    private int actionButtonMarginLeft;
    private int actionButtonMarginRight;
    private int actionButtonMarginTop;
    private int actionPicMarginLeft;
    private int actionPicMarginRight;
    private int actionPicMarginTop;
    private int advTitleIconMarginLeft;
    private int avatarListOfAnchorMarginLeft;
    private int avatarListOfAnchorMarginRight;
    private int avatarListOfAnchorMarginTop;
    private int avatarListOfAnchorOffestX;
    private CellBottomRecomm cellBottomRecomm;
    private View.OnClickListener clickListener;
    private BusinessFeedData feedData;
    private int feedPosition;
    private boolean isDetail;
    protected boolean isExposure;
    private boolean isOriginalAreaEventTag;
    private TextButtonArea mActionButton;
    private SubAreaShell mActionButtonShell;
    private DrawUrlPicArea mAdvTitleIcon;
    private SubAreaShell mAdvTitleIconShell;
    private AvatarsLayoutByRowArea mAvatarListOfAnchor;
    private SubAreaShell mAvatarListOfAnchorShell;
    private DrawUrlPicArea mCloseButton;
    private SubAreaShell mCloseButtonShell;
    private FeedSkinDrawUrlPicArea mLeftPic;
    protected SubAreaShell mLeftPicShell;
    protected List<SubAreaShell> mSubAreaShellLists;
    private FeedTextArea mSummary;
    private SubAreaShell mSummaryShell;
    protected FeedTextArea mTitle;
    protected SubAreaShell mTitleShell;
    int mTrans;
    private com.qzone.proxy.feedcomponent.ui.g onFeedElementClickListener;
    private int summaryMarginTop;
    private int titleMarginLeft;
    private int titleMarginTop;
    private SubAreaShell touchingArea;
    private boolean used;
    private static Drawable LEFT_PIC_BACKGROUND_DRAWABLE = new ColorDrawable(Color.parseColor("#E0E0E0"));
    private static Drawable ACTION_BUTTON_BACKGROUND_DRAWABLE = FeedGlobalEnv.getContext().getResources().getDrawable(com.qzone.adapter.feedcomponent.j.h(706));
    private static int VIEW_HEIGHT = com.qzone.proxy.feedcomponent.util.g.a(58.0f);
    protected static int VIEW_WIDTH = (FeedGlobalEnv.g().getScreenWidth() - AreaConst.MARGIN_LEFT) - AreaConst.MARGIN_RIGHT;
    private static int LEFT_PIC_SIZE = com.qzone.proxy.feedcomponent.util.g.a(58.0f);
    private static int ADV_ICON_WIDTH = com.qzone.proxy.feedcomponent.util.g.a(25.0f);
    private static int ADV_ICON_HEIGHT = com.qzone.proxy.feedcomponent.util.g.a(14.0f);
    private static int ACTION_PIC_SIZE = com.qzone.proxy.feedcomponent.util.g.a(34.0f);
    private static int CLOSE_BUTTON_SIZE = com.qzone.proxy.feedcomponent.util.g.a(14.0f);
    private static int AVATAR_OF_ANCHOR_SIZE = com.qzone.proxy.feedcomponent.util.g.a(20.0f);
    private static int NUM_OF_AVATAR_OF_ANCHOR = 3;
    public static FeedViewSection.SectionController PicTextCardController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedPicTextCardView.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            return businessFeedData.getCellBottomRecomm() == null || businessFeedData.isPublicAccountContent() || businessFeedData.isAppShareCardFeed() || businessFeedData.isPublicAccountShare() || businessFeedData.isQCircleShareCardFeed() || businessFeedData.isNewTailStyle();
        }
    };

    public FeedPicTextCardView(Context context) {
        super(context);
        this.mLeftPic = new FeedSkinDrawUrlPicArea();
        this.mAdvTitleIcon = new DrawUrlPicArea();
        this.mTitle = new FeedTextArea(0);
        this.mSummary = new FeedTextArea(0);
        this.BACKGROUND_DRAWABLE = new ColorDrawable(com.qzone.adapter.feedcomponent.j.E());
        this.mActionButton = new TextButtonArea(0, 14.0f, AreaConst.dp58, AreaConst.dp29, ACTION_BUTTON_BACKGROUND_DRAWABLE, "", com.qzone.adapter.feedcomponent.j.o());
        this.mCloseButton = new DrawUrlPicArea();
        this.mAvatarListOfAnchor = new AvatarsLayoutByRowArea();
        this.mSubAreaShellLists = new ArrayList();
        int i3 = AreaConst.dp8;
        this.titleMarginLeft = i3;
        this.titleMarginTop = 0;
        int i16 = AreaConst.f48747dp2;
        this.summaryMarginTop = i16;
        this.advTitleIconMarginLeft = AreaConst.f48749dp4;
        this.actionPicMarginLeft = i3;
        int i17 = AreaConst.dp12;
        this.actionPicMarginRight = i17;
        this.actionPicMarginTop = 0;
        this.actionButtonMarginLeft = i3;
        this.actionButtonMarginRight = i17;
        this.actionButtonMarginTop = 0;
        this.avatarListOfAnchorMarginLeft = i3;
        this.avatarListOfAnchorMarginRight = i3;
        this.avatarListOfAnchorMarginTop = i16;
        this.avatarListOfAnchorOffestX = AreaConst.dp16;
        this.isDetail = false;
        this.isOriginalAreaEventTag = false;
        this.mTrans = 255;
        this.isExposure = false;
        this.clickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedPicTextCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                EventCollector.getInstance().onViewClickedBefore(view);
                if (FeedPicTextCardView.this.feedData != null) {
                    com.qzone.adapter.feedcomponent.i.H().D(12, 211, 1, System.currentTimeMillis(), FeedPicTextCardView.this.feedData.getFeedCommInfo().isRealTimeTTTReport());
                }
                if (FeedPicTextCardView.this.cellBottomRecomm != null && FeedPicTextCardView.this.onFeedElementClickListener != null) {
                    if (FeedPicTextCardView.this.cellBottomRecomm.anonymity == CellBottomRecomm.TYPE_ADV) {
                        com.qzone.proxy.feedcomponent.ui.g gVar = FeedPicTextCardView.this.onFeedElementClickListener;
                        FeedPicTextCardView feedPicTextCardView = FeedPicTextCardView.this;
                        gVar.onClick(feedPicTextCardView, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_ADV, feedPicTextCardView.feedPosition, Boolean.valueOf(FeedPicTextCardView.this.isDetail));
                    } else if (FeedPicTextCardView.this.cellBottomRecomm.anonymity == CellBottomRecomm.TYPE_EVENT_TAG) {
                        if (FeedPicTextCardView.this.isOriginalAreaEventTag) {
                            com.qzone.proxy.feedcomponent.ui.g gVar2 = FeedPicTextCardView.this.onFeedElementClickListener;
                            FeedPicTextCardView feedPicTextCardView2 = FeedPicTextCardView.this;
                            gVar2.onClick(feedPicTextCardView2, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_EVENT_TAG, feedPicTextCardView2.feedPosition, FeedPicTextCardView.this.feedData);
                        } else {
                            com.qzone.proxy.feedcomponent.ui.g gVar3 = FeedPicTextCardView.this.onFeedElementClickListener;
                            FeedPicTextCardView feedPicTextCardView3 = FeedPicTextCardView.this;
                            gVar3.onClick(feedPicTextCardView3, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_EVENT_TAG, feedPicTextCardView3.feedPosition, Boolean.valueOf(FeedPicTextCardView.this.isDetail));
                        }
                    } else if (FeedPicTextCardView.this.cellBottomRecomm.anonymity == CellBottomRecomm.TYPE_PHOTO) {
                        com.qzone.proxy.feedcomponent.ui.g gVar4 = FeedPicTextCardView.this.onFeedElementClickListener;
                        FeedPicTextCardView feedPicTextCardView4 = FeedPicTextCardView.this;
                        gVar4.onClick(feedPicTextCardView4, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_PHOTO, feedPicTextCardView4.feedPosition, Boolean.valueOf(FeedPicTextCardView.this.isDetail));
                    } else {
                        com.qzone.proxy.feedcomponent.ui.g gVar5 = FeedPicTextCardView.this.onFeedElementClickListener;
                        FeedPicTextCardView feedPicTextCardView5 = FeedPicTextCardView.this;
                        gVar5.onClick(feedPicTextCardView5, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_EVENT_TAG, feedPicTextCardView5.feedPosition, FeedPicTextCardView.this.feedData);
                        if (FeedPicTextCardView.this.cellBottomRecomm.anonymity >= 6) {
                            int i18 = FeedPicTextCardView.this.cellBottomRecomm.iReportFlag;
                            if (FeedPicTextCardView.this.feedData == null || FeedPicTextCardView.this.feedData.feedType != 2) {
                                if (FeedPicTextCardView.this.feedData != null && FeedPicTextCardView.this.feedData.feedType == 3) {
                                    str = "7";
                                } else {
                                    str = "1";
                                }
                            } else {
                                str = "2";
                            }
                            com.qzone.adapter.feedcomponent.i.H().f2(MiniShareQuicklySendPanelFragment.QUCIKLY_SHARE_REQUEST_CODE, i18, 2, str);
                        }
                        if (FeedPicTextCardView.this.cellBottomRecomm.anonymity == CellBottomRecomm.TYPE_QZONE_LIVE) {
                            com.qzone.adapter.feedcomponent.i.H().f(236, 2, 2);
                        }
                    }
                }
                FeedPicTextCardView.this.clickReport();
                com.qzone.adapter.feedcomponent.i.H().f(803, 0, 2);
                EventCollector.getInstance().onViewClicked(view);
            }
        };
    }

    private void measure() {
        SubAreaShell subAreaShell;
        SubAreaShell subAreaShell2;
        SubAreaShell subAreaShell3;
        SubAreaShell subAreaShell4;
        int width;
        int i3;
        SubAreaShell subAreaShell5;
        SubAreaShell subAreaShell6;
        int width2;
        int i16;
        SubAreaShell subAreaShell7 = this.mLeftPicShell;
        if (subAreaShell7 != null) {
            subAreaShell7.measure(0, 0);
            this.mLeftPicShell.setLeft(0);
            this.mLeftPicShell.setTop(0);
        }
        SubAreaShell subAreaShell8 = this.mActionButtonShell;
        if (subAreaShell8 != null) {
            subAreaShell8.measure(0, 0);
            this.actionButtonMarginTop = (VIEW_HEIGHT - this.mActionButtonShell.getHeight()) / 2;
            SubAreaShell subAreaShell9 = this.mActionButtonShell;
            subAreaShell9.setLeft((VIEW_WIDTH - subAreaShell9.getWidth()) - this.actionButtonMarginRight);
            this.mActionButtonShell.setTop(this.actionButtonMarginTop);
        }
        if (this.mTitleShell != null && (subAreaShell6 = this.mLeftPicShell) != null) {
            if (this.mAdvTitleIconShell != null) {
                if (this.mActionButtonShell != null) {
                    width2 = (((((VIEW_WIDTH - subAreaShell6.getWidth()) - this.titleMarginLeft) - this.advTitleIconMarginLeft) - this.mAdvTitleIconShell.getWidth()) - this.actionButtonMarginLeft) - this.mActionButtonShell.getWidth();
                    i16 = this.actionButtonMarginRight;
                } else {
                    width2 = ((VIEW_WIDTH - subAreaShell6.getWidth()) - this.titleMarginLeft) - this.advTitleIconMarginLeft;
                    i16 = this.mAdvTitleIconShell.getWidth();
                }
            } else if (this.mActionButtonShell != null) {
                width2 = (((VIEW_WIDTH - subAreaShell6.getWidth()) - this.titleMarginLeft) - this.actionButtonMarginLeft) - this.mActionButtonShell.getWidth();
                i16 = this.actionButtonMarginRight;
            } else {
                width2 = VIEW_WIDTH - subAreaShell6.getWidth();
                i16 = this.titleMarginLeft;
            }
            this.mTitleShell.setMaxWidth(width2 - i16);
            this.mTitleShell.measure(-2, 0);
        }
        if (this.mAvatarListOfAnchorShell != null && this.mSummaryShell != null && (subAreaShell5 = this.mLeftPicShell) != null && this.mActionButtonShell != null) {
            this.mAvatarListOfAnchorShell.setMaxWidth(((((((VIEW_WIDTH - subAreaShell5.getWidth()) - this.titleMarginLeft) - this.actionButtonMarginLeft) - this.mActionButtonShell.getWidth()) - this.actionButtonMarginRight) - this.mSummaryShell.getWidth()) - this.avatarListOfAnchorMarginRight);
            this.mAvatarListOfAnchorShell.measure(-2, 0);
        }
        if (this.mSummaryShell != null && this.mTitleShell != null && (subAreaShell4 = this.mLeftPicShell) != null) {
            if (this.mActionButtonShell != null) {
                width = (((VIEW_WIDTH - subAreaShell4.getWidth()) - this.titleMarginLeft) - this.actionButtonMarginLeft) - this.mActionButtonShell.getWidth();
                i3 = this.actionButtonMarginRight;
            } else {
                width = VIEW_WIDTH - subAreaShell4.getWidth();
                i3 = this.titleMarginLeft;
            }
            int i17 = width - i3;
            CellBottomRecomm cellBottomRecomm = this.cellBottomRecomm;
            if (cellBottomRecomm != null && cellBottomRecomm.anonymity == CellBottomRecomm.TYPE_EVENT_TAG) {
                com.qzone.adapter.feedcomponent.i H = com.qzone.adapter.feedcomponent.i.H();
                Paint paint = this.mSummary.getPaint();
                CellBottomRecomm cellBottomRecomm2 = this.cellBottomRecomm;
                this.mSummary.setData(H.F0(paint, cellBottomRecomm2.summary, cellBottomRecomm2.joinListTruncateNum, i17), 0);
                this.mSummaryShell.setMaxWidth(i17);
                this.mSummaryShell.measure(-2, 0);
            } else {
                this.mSummaryShell.setMaxWidth(i17);
                this.mSummaryShell.measure(-2, 0);
            }
        }
        SubAreaShell subAreaShell10 = this.mTitleShell;
        if (subAreaShell10 != null) {
            if (this.mSummaryShell != null) {
                if (this.mAvatarListOfAnchorShell != null) {
                    this.titleMarginTop = (VIEW_HEIGHT - ((subAreaShell10.getHeight() + this.avatarListOfAnchorMarginTop) + this.mAvatarListOfAnchorShell.getHeight())) / 2;
                } else {
                    this.titleMarginTop = (VIEW_HEIGHT - ((subAreaShell10.getHeight() + this.summaryMarginTop) + this.mSummaryShell.getHeight())) / 2;
                }
            } else {
                this.titleMarginTop = (VIEW_HEIGHT - subAreaShell10.getHeight()) / 2;
            }
        }
        SubAreaShell subAreaShell11 = this.mTitleShell;
        if (subAreaShell11 != null && (subAreaShell3 = this.mLeftPicShell) != null) {
            subAreaShell11.setLeft(subAreaShell3.getRight() + this.titleMarginLeft);
            this.mTitleShell.setTop(this.titleMarginTop);
        }
        SubAreaShell subAreaShell12 = this.mAvatarListOfAnchorShell;
        if (subAreaShell12 != null && this.mTitleShell != null && (subAreaShell2 = this.mLeftPicShell) != null) {
            subAreaShell12.setLeft(subAreaShell2.getRight() + this.avatarListOfAnchorMarginLeft);
            this.mAvatarListOfAnchorShell.setTop(this.mTitleShell.getBottom() + this.avatarListOfAnchorMarginTop);
        }
        SubAreaShell subAreaShell13 = this.mSummaryShell;
        if (subAreaShell13 != null && this.mTitleShell != null && (subAreaShell = this.mLeftPicShell) != null) {
            SubAreaShell subAreaShell14 = this.mAvatarListOfAnchorShell;
            if (subAreaShell14 != null) {
                subAreaShell13.setLeft(subAreaShell14.getRight() + this.avatarListOfAnchorMarginRight);
                this.mSummaryShell.setTop(this.mTitleShell.getBottom() + this.summaryMarginTop + ((this.mAvatarListOfAnchorShell.getHeight() - this.mSummary.getHeight()) / 2));
            } else {
                subAreaShell13.setLeft(subAreaShell.getRight() + this.titleMarginLeft);
                this.mSummaryShell.setTop(this.mTitleShell.getBottom() + this.summaryMarginTop);
            }
        }
        if (this.mAdvTitleIconShell != null && this.mTitleShell != null) {
            BusinessFeedData businessFeedData = this.feedData;
            if (businessFeedData != null && businessFeedData.isWindowAd()) {
                this.mAdvTitleIconShell.setLeft(this.mLeftPic.getWidth() - this.mAdvTitleIconShell.getWidth());
                this.mAdvTitleIconShell.setTop(this.mLeftPic.getHeight() - this.mAdvTitleIconShell.getHeight());
            } else {
                this.mAdvTitleIconShell.setLeft(this.mTitleShell.getRight() + this.advTitleIconMarginLeft);
                this.mAdvTitleIconShell.setTop(this.titleMarginTop + AreaConst.dp0_5);
            }
        }
        if (this.mCloseButtonShell != null) {
            int a16 = com.qzone.proxy.feedcomponent.util.g.a(10.0f);
            this.mCloseButtonShell.setLeft((VIEW_WIDTH - CLOSE_BUTTON_SIZE) - a16);
            this.mCloseButtonShell.setTop(a16);
        }
    }

    SubAreaShell findArea(float f16, float f17) {
        for (SubAreaShell subAreaShell : this.mSubAreaShellLists) {
            if (f17 > subAreaShell.getTop() && f17 < subAreaShell.getBottom() && f16 > subAreaShell.getLeft() && f16 < subAreaShell.getRight()) {
                return subAreaShell;
            }
        }
        return null;
    }

    public boolean hasUsed() {
        return this.used;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i3 = this.mLeftPicShell != null ? LEFT_PIC_SIZE : 0;
        this.BACKGROUND_DRAWABLE.setAlpha(this.mTrans);
        this.BACKGROUND_DRAWABLE.setBounds(i3, 0, VIEW_WIDTH, VIEW_HEIGHT);
        this.BACKGROUND_DRAWABLE.draw(canvas);
        if (this.mLeftPicShell == null) {
            Drawable drawable = LEFT_PIC_BACKGROUND_DRAWABLE;
            int i16 = LEFT_PIC_SIZE;
            drawable.setBounds(0, 0, i16, i16);
            LEFT_PIC_BACKGROUND_DRAWABLE.draw(canvas);
        }
        Paint paint = new Paint();
        for (SubAreaShell subAreaShell : this.mSubAreaShellLists) {
            if (subAreaShell != null) {
                canvas.save();
                canvas.translate(subAreaShell.getLeft(), subAreaShell.getTop());
                subAreaShell.draw(canvas, paint);
                canvas.restore();
            }
        }
        if (this.isExposure) {
            return;
        }
        com.qzone.adapter.feedcomponent.i.H().f(803, 0, 1);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        setMeasuredDimension(VIEW_WIDTH, VIEW_HEIGHT);
    }

    @Override // com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        this.mSubAreaShellLists.clear();
        this.mLeftPicShell = null;
        this.mAdvTitleIconShell = null;
        this.mTitleShell = null;
        this.mSummaryShell = null;
        this.mAvatarListOfAnchorShell = null;
        this.mActionButtonShell = null;
        this.feedData = null;
        this.cellBottomRecomm = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        SubAreaShell findArea = findArea(motionEvent.getX(), motionEvent.getY());
        SubAreaShell subAreaShell = this.touchingArea;
        if (findArea != subAreaShell) {
            if (subAreaShell != null) {
                subAreaShell.clearTouchingEvent();
            }
            this.touchingArea = findArea;
        }
        if (findArea != null && findArea.equals(this.mCloseButtonShell) && motionEvent.getAction() == 1) {
            com.qzone.proxy.feedcomponent.ui.g gVar = this.onFeedElementClickListener;
            if (gVar != null) {
                gVar.onClick(this, FeedElement.FEED_MYMEDIA_CARD_CLOSE, this.feedPosition, Boolean.valueOf(this.isDetail));
            }
            setVisibility(8);
            this.feedData.setCellBottomRecomm(null);
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void reset() {
        this.mSubAreaShellLists.clear();
        this.mLeftPicShell = null;
        this.mAdvTitleIconShell = null;
        this.mTitleShell = null;
        this.mSummaryShell = null;
        this.mActionButtonShell = null;
        this.mAvatarListOfAnchorShell = null;
        this.feedData = null;
        this.cellBottomRecomm = null;
        this.touchingArea = null;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setAlpha(int i3) {
        this.mTrans = com.qzone.proxy.feedcomponent.util.g.b(i3);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedData(BusinessFeedData businessFeedData) {
        setData(businessFeedData, businessFeedData.getCellBottomRecomm(), 0);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedPosition(int i3) {
        this.feedPosition = i3;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.onFeedElementClickListener = gVar;
    }

    public void setUsed(boolean z16) {
        this.used = z16;
    }

    public void updateActionButtonText(String str) {
        TextButtonArea textButtonArea = this.mActionButton;
        if (textButtonArea != null) {
            textButtonArea.setNormalText(str);
        }
        invalidate();
    }

    public void setEventTagInOriginalArea() {
        this.isOriginalAreaEventTag = true;
    }

    public void setData(BusinessFeedData businessFeedData, CellBottomRecomm cellBottomRecomm, int i3) {
        if (cellBottomRecomm == null) {
            return;
        }
        setVisibility(0);
        this.feedData = businessFeedData;
        this.cellBottomRecomm = cellBottomRecomm;
        if (i3 == 2) {
            this.isDetail = true;
        } else {
            this.isDetail = false;
        }
        setOnClickListener(this.clickListener);
        VIEW_WIDTH = (FeedGlobalEnv.g().getScreenWidth() - AreaConst.MARGIN_LEFT) - AreaConst.MARGIN_RIGHT;
        bindBottomViewData(businessFeedData, cellBottomRecomm, i3);
        if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null) {
            com.qzone.adapter.feedcomponent.i.H().D(12, 211, 19, System.currentTimeMillis(), businessFeedData.getFeedCommInfo().isRealTimeTTTReport());
        }
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x02a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void bindBottomViewData(BusinessFeedData businessFeedData, CellBottomRecomm cellBottomRecomm, int i3) {
        int i16;
        int i17;
        int o16;
        TextButtonArea textButtonArea;
        int i18 = cellBottomRecomm.anonymity;
        if (i18 == CellBottomRecomm.TYPE_ADV) {
            if (this.isDetail) {
                com.qzone.adapter.feedcomponent.i.H().D(3, 65, 19, System.currentTimeMillis(), true);
            } else {
                com.qzone.adapter.feedcomponent.i.H().D(12, 65, 19, System.currentTimeMillis(), true);
            }
        } else if (i18 == CellBottomRecomm.TYPE_MAGIC) {
            VIEW_WIDTH = FeedGlobalEnv.g().getScreenWidth();
        } else {
            String str = "7";
            if (i18 == CellBottomRecomm.TYPE_WEISHI) {
                if (i3 == 1) {
                    VIEW_WIDTH = FeedGlobalEnv.g().getScreenWidth();
                }
                if (!TextUtils.isEmpty(cellBottomRecomm.weishiText)) {
                    cellBottomRecomm.buttontext = cellBottomRecomm.weishiText;
                } else if (!TextUtils.isEmpty(cellBottomRecomm.weishiDownloadUrl)) {
                    String N0 = com.qzone.adapter.feedcomponent.i.H().N0(cellBottomRecomm.weishiDownloadUrl);
                    if (!TextUtils.isEmpty(N0)) {
                        cellBottomRecomm.buttontext = N0;
                        com.qzone.adapter.feedcomponent.i.H().Q2(MiniShareQuicklySendPanelFragment.QUCIKLY_SHARE_REQUEST_CODE, 6, 1, businessFeedData);
                    }
                }
                if (businessFeedData != null) {
                    int i19 = cellBottomRecomm.iReportFlag;
                    int i26 = businessFeedData.feedType;
                    if (i26 == 2) {
                        str = "2";
                    } else if (i26 != 3) {
                        str = "1";
                    }
                    com.qzone.adapter.feedcomponent.i.H().f2(MiniShareQuicklySendPanelFragment.QUCIKLY_SHARE_REQUEST_CODE, i19, 1, str);
                }
            } else if (i18 >= 7 && businessFeedData != null) {
                int i27 = cellBottomRecomm.iReportFlag;
                int i28 = businessFeedData.feedType;
                if (i28 == 2) {
                    str = "2";
                } else if (i28 != 3) {
                    str = "1";
                }
                com.qzone.adapter.feedcomponent.i.H().f2(MiniShareQuicklySendPanelFragment.QUCIKLY_SHARE_REQUEST_CODE, i27, 1, str);
            }
        }
        if (i3 == 1) {
            this.mTitle.setTextColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
            this.BACKGROUND_DRAWABLE = new ColorDrawable(Color.parseColor("#1f1f24"));
        } else {
            this.mTitle.setTextColor(com.qzone.adapter.feedcomponent.j.o());
            if (this.isOriginalAreaEventTag) {
                this.BACKGROUND_DRAWABLE = new ColorDrawable(com.qzone.adapter.feedcomponent.j.r());
            } else {
                this.BACKGROUND_DRAWABLE = new ColorDrawable(com.qzone.adapter.feedcomponent.j.E());
            }
        }
        PictureItem pictureItem = cellBottomRecomm.picinfo;
        if (pictureItem != null && pictureItem.currentUrl != null) {
            int i29 = LEFT_PIC_SIZE;
            PictureUrl pictureUrl = cellBottomRecomm.picinfo.currentUrl;
            NormalFeedImageProcessor normalFeedImageProcessor = new NormalFeedImageProcessor(i29, i29, pictureUrl.pivotXRate, pictureUrl.pivotYRate);
            FeedSkinDrawUrlPicArea feedSkinDrawUrlPicArea = this.mLeftPic;
            PictureUrl pictureUrl2 = cellBottomRecomm.picinfo.currentUrl;
            String str2 = pictureUrl2.url;
            int i36 = LEFT_PIC_SIZE;
            feedSkinDrawUrlPicArea.setData(str2, i36, i36, normalFeedImageProcessor, pictureUrl2.imageUrl);
            SubAreaShell obtain = SubAreaShell.obtain(this.mLeftPic);
            this.mLeftPicShell = obtain;
            obtain.setParent(this);
            this.mSubAreaShellLists.add(this.mLeftPicShell);
        }
        if (businessFeedData != null && businessFeedData.isWindowAd()) {
            this.mAdvTitleIcon.setData(GDT_AD_ICON_URL, com.qzone.proxy.feedcomponent.util.g.a(23.0f), com.qzone.proxy.feedcomponent.util.g.a(10.0f), (ImageUrl) null);
            SubAreaShell obtain2 = SubAreaShell.obtain(this.mAdvTitleIcon);
            this.mAdvTitleIconShell = obtain2;
            obtain2.setParent(this);
            this.mSubAreaShellLists.add(this.mAdvTitleIconShell);
        } else if (!TextUtils.isEmpty(cellBottomRecomm.AdvIconUrl)) {
            this.mAdvTitleIcon.setData(cellBottomRecomm.AdvIconUrl, ADV_ICON_WIDTH, ADV_ICON_HEIGHT, cellBottomRecomm.imageUrl);
            SubAreaShell obtain3 = SubAreaShell.obtain(this.mAdvTitleIcon);
            this.mAdvTitleIconShell = obtain3;
            obtain3.setParent(this);
            this.mSubAreaShellLists.add(this.mAdvTitleIconShell);
        }
        if (!TextUtils.isEmpty(cellBottomRecomm.buttontext) && !cellBottomRecomm.isSupportFeedback && (i16 = cellBottomRecomm.anonymity) != (i17 = CellBottomRecomm.TYPE_WEISHI)) {
            if (i3 == 1) {
                ACTION_BUTTON_BACKGROUND_DRAWABLE = FeedGlobalEnv.getContext().getResources().getDrawable(com.qzone.adapter.feedcomponent.j.h(807));
            } else {
                if (i16 == i17) {
                    ACTION_BUTTON_BACKGROUND_DRAWABLE = FeedGlobalEnv.getContext().getResources().getDrawable(com.qzone.adapter.feedcomponent.j.h(847));
                    o16 = 4013373;
                } else if (i16 != CellBottomRecomm.TYPE_ADV && i16 != CellBottomRecomm.TYPE_QZONE_LIVE) {
                    o16 = com.qzone.adapter.feedcomponent.j.o();
                    float f16 = AreaConst.dp14_5;
                    ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f16, f16, f16, f16, f16, f16, f16, f16}, null, null));
                    shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
                    if (this.isOriginalAreaEventTag) {
                        shapeDrawable.getPaint().setColor(com.qzone.adapter.feedcomponent.j.q());
                    } else {
                        shapeDrawable.getPaint().setColor(com.qzone.adapter.feedcomponent.j.m());
                    }
                    ACTION_BUTTON_BACKGROUND_DRAWABLE = shapeDrawable;
                } else {
                    float f17 = AreaConst.dp14_5;
                    ShapeDrawable shapeDrawable2 = new ShapeDrawable(new RoundRectShape(new float[]{f17, f17, f17, f17, f17, f17, f17, f17}, null, null));
                    shapeDrawable2.getPaint().setStyle(Paint.Style.FILL);
                    shapeDrawable2.getPaint().setColor(com.qzone.adapter.feedcomponent.j.x());
                    ACTION_BUTTON_BACKGROUND_DRAWABLE = shapeDrawable2;
                }
                Paint paint = new Paint();
                paint.setTextSize(AreaConst.dp14);
                int round = Math.round(paint.measureText(cellBottomRecomm.buttontext)) + AreaConst.dp30;
                textButtonArea = this.mActionButton;
                if (textButtonArea != null) {
                    this.mActionButton = new TextButtonArea(0, 14.0f, round, AreaConst.dp28, ACTION_BUTTON_BACKGROUND_DRAWABLE, "", o16);
                } else {
                    textButtonArea.setBtnWidth(round);
                    this.mActionButton.setBtnNormalDrawable(ACTION_BUTTON_BACKGROUND_DRAWABLE);
                    this.mActionButton.setNormalTextColor(o16);
                }
                this.mActionButton.setEnablePressState(false);
                this.mActionButton.setNormalText(cellBottomRecomm.buttontext);
                SubAreaShell obtain4 = SubAreaShell.obtain(this.mActionButton);
                this.mActionButtonShell = obtain4;
                obtain4.setParent(this);
                this.mSubAreaShellLists.add(this.mActionButtonShell);
            }
            o16 = 16777215;
            Paint paint2 = new Paint();
            paint2.setTextSize(AreaConst.dp14);
            int round2 = Math.round(paint2.measureText(cellBottomRecomm.buttontext)) + AreaConst.dp30;
            textButtonArea = this.mActionButton;
            if (textButtonArea != null) {
            }
            this.mActionButton.setEnablePressState(false);
            this.mActionButton.setNormalText(cellBottomRecomm.buttontext);
            SubAreaShell obtain42 = SubAreaShell.obtain(this.mActionButton);
            this.mActionButtonShell = obtain42;
            obtain42.setParent(this);
            this.mSubAreaShellLists.add(this.mActionButtonShell);
        }
        if (cellBottomRecomm.title != null) {
            if (cellBottomRecomm.anonymity == 6) {
                this.mTitle.setLineSpace(2.0f);
            } else {
                this.mTitle.setLineSpace(0.0f);
            }
            this.mTitle.setTextSize(14.0f);
            this.mTitle.setMaxLine(1);
            this.mTitle.setUseSoftLineBreak(false);
            this.mTitle.setData(cellBottomRecomm.title, 0);
            SubAreaShell obtain5 = SubAreaShell.obtain(this.mTitle);
            this.mTitleShell = obtain5;
            obtain5.setParent(this);
            this.mSubAreaShellLists.add(this.mTitleShell);
        }
        if (!TextUtils.isEmpty(com.qzone.adapter.feedcomponent.j.K(1109)) && cellBottomRecomm.isSupportFeedback) {
            DrawUrlPicArea drawUrlPicArea = this.mCloseButton;
            String K = com.qzone.adapter.feedcomponent.j.K(1109);
            int i37 = CLOSE_BUTTON_SIZE;
            drawUrlPicArea.setData(K, i37, i37, (ImageUrl) null);
            SubAreaShell obtain6 = SubAreaShell.obtain(this.mCloseButton);
            this.mCloseButtonShell = obtain6;
            obtain6.setParent(this);
            this.mSubAreaShellLists.add(this.mCloseButtonShell);
        }
        s_join_list s_join_listVar = cellBottomRecomm.joinlist;
        if (s_join_listVar != null && cellBottomRecomm.anonymity == CellBottomRecomm.TYPE_QZONE_LIVE) {
            ArrayList<s_user> arrayList = s_join_listVar.users;
            if (arrayList != null && !arrayList.isEmpty()) {
                ArrayList<User> arrayList2 = new ArrayList<>();
                Iterator<s_user> it = arrayList.iterator();
                while (it.hasNext()) {
                    User q16 = com.qzone.proxy.feedcomponent.util.e.q(it.next());
                    if (q16 != null) {
                        arrayList2.add(q16);
                    }
                }
                if (this.mAvatarListOfAnchor == null) {
                    this.mAvatarListOfAnchor = new AvatarsLayoutByRowArea();
                }
                this.mAvatarListOfAnchor.setDrawParams(NUM_OF_AVATAR_OF_ANCHOR, this.avatarListOfAnchorOffestX, 0);
                this.mAvatarListOfAnchor.setUsersData(arrayList2, true);
                this.mAvatarListOfAnchor.setAvatarSizeForEach(AVATAR_OF_ANCHOR_SIZE);
                SubAreaShell obtain7 = SubAreaShell.obtain(this.mAvatarListOfAnchor);
                this.mAvatarListOfAnchorShell = obtain7;
                obtain7.setParent(this);
                this.mSubAreaShellLists.add(this.mAvatarListOfAnchorShell);
            }
            com.qzone.adapter.feedcomponent.i.H().f(236, 2, 1);
        }
        if (!TextUtils.isEmpty(cellBottomRecomm.summary)) {
            if (cellBottomRecomm.anonymity == 6) {
                this.mSummary.setLineSpace(2.0f);
            } else {
                this.mSummary.setLineSpace(0.0f);
            }
            this.mSummary.setTextSize(11.0f);
            if (!TextUtils.isEmpty(cellBottomRecomm.summaryColor)) {
                try {
                    this.mSummary.setTextColor(Color.parseColor(cellBottomRecomm.summaryColor));
                } catch (Exception e16) {
                    com.qzone.proxy.feedcomponent.b.d("Feed", "FeedPicTextCardView error color! " + cellBottomRecomm.summaryColor, e16);
                    this.mSummary.setTextColor(com.qzone.adapter.feedcomponent.j.o());
                }
            } else if (cellBottomRecomm.anonymity == 6 && i3 == 1) {
                this.mSummary.setTextColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
            } else {
                this.mSummary.setTextColor(com.qzone.adapter.feedcomponent.j.o());
            }
            this.mSummary.setMaxLine(1);
            this.mSummary.setUseSoftLineBreak(false);
            this.mSummary.setData(cellBottomRecomm.summary, 0);
            SubAreaShell obtain8 = SubAreaShell.obtain(this.mSummary);
            this.mSummaryShell = obtain8;
            obtain8.setParent(this);
            this.mSubAreaShellLists.add(this.mSummaryShell);
        }
        measure();
    }

    protected void clickReport() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateIdle() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateScrolling() {
    }

    public FeedPicTextCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLeftPic = new FeedSkinDrawUrlPicArea();
        this.mAdvTitleIcon = new DrawUrlPicArea();
        this.mTitle = new FeedTextArea(0);
        this.mSummary = new FeedTextArea(0);
        this.BACKGROUND_DRAWABLE = new ColorDrawable(com.qzone.adapter.feedcomponent.j.E());
        this.mActionButton = new TextButtonArea(0, 14.0f, AreaConst.dp58, AreaConst.dp29, ACTION_BUTTON_BACKGROUND_DRAWABLE, "", com.qzone.adapter.feedcomponent.j.o());
        this.mCloseButton = new DrawUrlPicArea();
        this.mAvatarListOfAnchor = new AvatarsLayoutByRowArea();
        this.mSubAreaShellLists = new ArrayList();
        int i3 = AreaConst.dp8;
        this.titleMarginLeft = i3;
        this.titleMarginTop = 0;
        int i16 = AreaConst.f48747dp2;
        this.summaryMarginTop = i16;
        this.advTitleIconMarginLeft = AreaConst.f48749dp4;
        this.actionPicMarginLeft = i3;
        int i17 = AreaConst.dp12;
        this.actionPicMarginRight = i17;
        this.actionPicMarginTop = 0;
        this.actionButtonMarginLeft = i3;
        this.actionButtonMarginRight = i17;
        this.actionButtonMarginTop = 0;
        this.avatarListOfAnchorMarginLeft = i3;
        this.avatarListOfAnchorMarginRight = i3;
        this.avatarListOfAnchorMarginTop = i16;
        this.avatarListOfAnchorOffestX = AreaConst.dp16;
        this.isDetail = false;
        this.isOriginalAreaEventTag = false;
        this.mTrans = 255;
        this.isExposure = false;
        this.clickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedPicTextCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                EventCollector.getInstance().onViewClickedBefore(view);
                if (FeedPicTextCardView.this.feedData != null) {
                    com.qzone.adapter.feedcomponent.i.H().D(12, 211, 1, System.currentTimeMillis(), FeedPicTextCardView.this.feedData.getFeedCommInfo().isRealTimeTTTReport());
                }
                if (FeedPicTextCardView.this.cellBottomRecomm != null && FeedPicTextCardView.this.onFeedElementClickListener != null) {
                    if (FeedPicTextCardView.this.cellBottomRecomm.anonymity == CellBottomRecomm.TYPE_ADV) {
                        com.qzone.proxy.feedcomponent.ui.g gVar = FeedPicTextCardView.this.onFeedElementClickListener;
                        FeedPicTextCardView feedPicTextCardView = FeedPicTextCardView.this;
                        gVar.onClick(feedPicTextCardView, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_ADV, feedPicTextCardView.feedPosition, Boolean.valueOf(FeedPicTextCardView.this.isDetail));
                    } else if (FeedPicTextCardView.this.cellBottomRecomm.anonymity == CellBottomRecomm.TYPE_EVENT_TAG) {
                        if (FeedPicTextCardView.this.isOriginalAreaEventTag) {
                            com.qzone.proxy.feedcomponent.ui.g gVar2 = FeedPicTextCardView.this.onFeedElementClickListener;
                            FeedPicTextCardView feedPicTextCardView2 = FeedPicTextCardView.this;
                            gVar2.onClick(feedPicTextCardView2, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_EVENT_TAG, feedPicTextCardView2.feedPosition, FeedPicTextCardView.this.feedData);
                        } else {
                            com.qzone.proxy.feedcomponent.ui.g gVar3 = FeedPicTextCardView.this.onFeedElementClickListener;
                            FeedPicTextCardView feedPicTextCardView3 = FeedPicTextCardView.this;
                            gVar3.onClick(feedPicTextCardView3, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_EVENT_TAG, feedPicTextCardView3.feedPosition, Boolean.valueOf(FeedPicTextCardView.this.isDetail));
                        }
                    } else if (FeedPicTextCardView.this.cellBottomRecomm.anonymity == CellBottomRecomm.TYPE_PHOTO) {
                        com.qzone.proxy.feedcomponent.ui.g gVar4 = FeedPicTextCardView.this.onFeedElementClickListener;
                        FeedPicTextCardView feedPicTextCardView4 = FeedPicTextCardView.this;
                        gVar4.onClick(feedPicTextCardView4, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_PHOTO, feedPicTextCardView4.feedPosition, Boolean.valueOf(FeedPicTextCardView.this.isDetail));
                    } else {
                        com.qzone.proxy.feedcomponent.ui.g gVar5 = FeedPicTextCardView.this.onFeedElementClickListener;
                        FeedPicTextCardView feedPicTextCardView5 = FeedPicTextCardView.this;
                        gVar5.onClick(feedPicTextCardView5, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_EVENT_TAG, feedPicTextCardView5.feedPosition, FeedPicTextCardView.this.feedData);
                        if (FeedPicTextCardView.this.cellBottomRecomm.anonymity >= 6) {
                            int i18 = FeedPicTextCardView.this.cellBottomRecomm.iReportFlag;
                            if (FeedPicTextCardView.this.feedData == null || FeedPicTextCardView.this.feedData.feedType != 2) {
                                if (FeedPicTextCardView.this.feedData != null && FeedPicTextCardView.this.feedData.feedType == 3) {
                                    str = "7";
                                } else {
                                    str = "1";
                                }
                            } else {
                                str = "2";
                            }
                            com.qzone.adapter.feedcomponent.i.H().f2(MiniShareQuicklySendPanelFragment.QUCIKLY_SHARE_REQUEST_CODE, i18, 2, str);
                        }
                        if (FeedPicTextCardView.this.cellBottomRecomm.anonymity == CellBottomRecomm.TYPE_QZONE_LIVE) {
                            com.qzone.adapter.feedcomponent.i.H().f(236, 2, 2);
                        }
                    }
                }
                FeedPicTextCardView.this.clickReport();
                com.qzone.adapter.feedcomponent.i.H().f(803, 0, 2);
                EventCollector.getInstance().onViewClicked(view);
            }
        };
    }

    public FeedPicTextCardView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mLeftPic = new FeedSkinDrawUrlPicArea();
        this.mAdvTitleIcon = new DrawUrlPicArea();
        this.mTitle = new FeedTextArea(0);
        this.mSummary = new FeedTextArea(0);
        this.BACKGROUND_DRAWABLE = new ColorDrawable(com.qzone.adapter.feedcomponent.j.E());
        this.mActionButton = new TextButtonArea(0, 14.0f, AreaConst.dp58, AreaConst.dp29, ACTION_BUTTON_BACKGROUND_DRAWABLE, "", com.qzone.adapter.feedcomponent.j.o());
        this.mCloseButton = new DrawUrlPicArea();
        this.mAvatarListOfAnchor = new AvatarsLayoutByRowArea();
        this.mSubAreaShellLists = new ArrayList();
        int i16 = AreaConst.dp8;
        this.titleMarginLeft = i16;
        this.titleMarginTop = 0;
        int i17 = AreaConst.f48747dp2;
        this.summaryMarginTop = i17;
        this.advTitleIconMarginLeft = AreaConst.f48749dp4;
        this.actionPicMarginLeft = i16;
        int i18 = AreaConst.dp12;
        this.actionPicMarginRight = i18;
        this.actionPicMarginTop = 0;
        this.actionButtonMarginLeft = i16;
        this.actionButtonMarginRight = i18;
        this.actionButtonMarginTop = 0;
        this.avatarListOfAnchorMarginLeft = i16;
        this.avatarListOfAnchorMarginRight = i16;
        this.avatarListOfAnchorMarginTop = i17;
        this.avatarListOfAnchorOffestX = AreaConst.dp16;
        this.isDetail = false;
        this.isOriginalAreaEventTag = false;
        this.mTrans = 255;
        this.isExposure = false;
        this.clickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedPicTextCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                EventCollector.getInstance().onViewClickedBefore(view);
                if (FeedPicTextCardView.this.feedData != null) {
                    com.qzone.adapter.feedcomponent.i.H().D(12, 211, 1, System.currentTimeMillis(), FeedPicTextCardView.this.feedData.getFeedCommInfo().isRealTimeTTTReport());
                }
                if (FeedPicTextCardView.this.cellBottomRecomm != null && FeedPicTextCardView.this.onFeedElementClickListener != null) {
                    if (FeedPicTextCardView.this.cellBottomRecomm.anonymity == CellBottomRecomm.TYPE_ADV) {
                        com.qzone.proxy.feedcomponent.ui.g gVar = FeedPicTextCardView.this.onFeedElementClickListener;
                        FeedPicTextCardView feedPicTextCardView = FeedPicTextCardView.this;
                        gVar.onClick(feedPicTextCardView, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_ADV, feedPicTextCardView.feedPosition, Boolean.valueOf(FeedPicTextCardView.this.isDetail));
                    } else if (FeedPicTextCardView.this.cellBottomRecomm.anonymity == CellBottomRecomm.TYPE_EVENT_TAG) {
                        if (FeedPicTextCardView.this.isOriginalAreaEventTag) {
                            com.qzone.proxy.feedcomponent.ui.g gVar2 = FeedPicTextCardView.this.onFeedElementClickListener;
                            FeedPicTextCardView feedPicTextCardView2 = FeedPicTextCardView.this;
                            gVar2.onClick(feedPicTextCardView2, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_EVENT_TAG, feedPicTextCardView2.feedPosition, FeedPicTextCardView.this.feedData);
                        } else {
                            com.qzone.proxy.feedcomponent.ui.g gVar3 = FeedPicTextCardView.this.onFeedElementClickListener;
                            FeedPicTextCardView feedPicTextCardView3 = FeedPicTextCardView.this;
                            gVar3.onClick(feedPicTextCardView3, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_EVENT_TAG, feedPicTextCardView3.feedPosition, Boolean.valueOf(FeedPicTextCardView.this.isDetail));
                        }
                    } else if (FeedPicTextCardView.this.cellBottomRecomm.anonymity == CellBottomRecomm.TYPE_PHOTO) {
                        com.qzone.proxy.feedcomponent.ui.g gVar4 = FeedPicTextCardView.this.onFeedElementClickListener;
                        FeedPicTextCardView feedPicTextCardView4 = FeedPicTextCardView.this;
                        gVar4.onClick(feedPicTextCardView4, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_PHOTO, feedPicTextCardView4.feedPosition, Boolean.valueOf(FeedPicTextCardView.this.isDetail));
                    } else {
                        com.qzone.proxy.feedcomponent.ui.g gVar5 = FeedPicTextCardView.this.onFeedElementClickListener;
                        FeedPicTextCardView feedPicTextCardView5 = FeedPicTextCardView.this;
                        gVar5.onClick(feedPicTextCardView5, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_EVENT_TAG, feedPicTextCardView5.feedPosition, FeedPicTextCardView.this.feedData);
                        if (FeedPicTextCardView.this.cellBottomRecomm.anonymity >= 6) {
                            int i182 = FeedPicTextCardView.this.cellBottomRecomm.iReportFlag;
                            if (FeedPicTextCardView.this.feedData == null || FeedPicTextCardView.this.feedData.feedType != 2) {
                                if (FeedPicTextCardView.this.feedData != null && FeedPicTextCardView.this.feedData.feedType == 3) {
                                    str = "7";
                                } else {
                                    str = "1";
                                }
                            } else {
                                str = "2";
                            }
                            com.qzone.adapter.feedcomponent.i.H().f2(MiniShareQuicklySendPanelFragment.QUCIKLY_SHARE_REQUEST_CODE, i182, 2, str);
                        }
                        if (FeedPicTextCardView.this.cellBottomRecomm.anonymity == CellBottomRecomm.TYPE_QZONE_LIVE) {
                            com.qzone.adapter.feedcomponent.i.H().f(236, 2, 2);
                        }
                    }
                }
                FeedPicTextCardView.this.clickReport();
                com.qzone.adapter.feedcomponent.i.H().f(803, 0, 2);
                EventCollector.getInstance().onViewClicked(view);
            }
        };
    }
}
