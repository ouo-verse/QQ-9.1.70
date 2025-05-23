package com.qzone.canvasui.widget;

import NS_MOBILE_FEEDS.s_join_list;
import NS_MOBILE_FEEDS.s_user;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.adapter.feedcomponent.r;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.ui.AvatarsLayoutByRowArea;
import com.qzone.module.feedcomponent.ui.DrawUrlPicArea;
import com.qzone.module.feedcomponent.ui.FeedTextArea;
import com.qzone.module.feedcomponent.ui.SubAreaShell;
import com.qzone.module.feedcomponent.ui.TextButtonArea;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellBottomRecomm;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.ui.g;
import com.qzone.proxy.feedcomponent.util.e;
import com.tencent.component.media.image.processor.NormalFeedImageProcessor;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasFeedEventTagArea extends DittoArea implements r {
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
    private BusinessFeedData feedData;
    private int feedPosition;
    private boolean isDetail;
    private TextButtonArea mActionButton;
    private SubAreaShell mActionButtonShell;
    private DrawUrlPicArea mActionPic;
    private SubAreaShell mActionPicShell;
    private DrawUrlPicArea mAdvTitleIcon;
    private SubAreaShell mAdvTitleIconShell;
    private AvatarsLayoutByRowArea mAvatarListOfAnchor;
    private SubAreaShell mAvatarListOfAnchorShell;
    protected DrawUrlPicArea mLeftPic;
    protected SubAreaShell mLeftPicShell;
    protected List<SubAreaShell> mSubAreaShellLists;
    private FeedTextArea mSummary;
    private SubAreaShell mSummaryShell;
    protected FeedTextArea mTitle;
    protected SubAreaShell mTitleShell;
    int mTrans;
    private g onFeedElementClickListener;
    Paint subPaint;
    private int summaryMarginTop;
    private int titleMarginLeft;
    private int titleMarginTop;
    private static Drawable LEFT_PIC_BACKGROUND_DRAWABLE = new ColorDrawable(Color.parseColor("#E0E0E0"));
    private static Drawable ACTION_BUTTON_BACKGROUND_DRAWABLE = FeedGlobalEnv.getContext().getResources().getDrawable(j.h(706));
    private static int VIEW_HEIGHT = com.qzone.proxy.feedcomponent.util.g.a(50.0f);
    protected static int VIEW_WIDTH = (FeedGlobalEnv.g().getScreenWidth() - AreaConst.MARGIN_LEFT) - AreaConst.MARGIN_RIGHT;
    private static int LEFT_PIC_SIZE = com.qzone.proxy.feedcomponent.util.g.a(50.0f);
    private static int ADV_ICON_WIDTH = com.qzone.proxy.feedcomponent.util.g.a(25.0f);
    private static int ADV_ICON_HEIGHT = com.qzone.proxy.feedcomponent.util.g.a(14.0f);
    private static int ACTION_PIC_SIZE = com.qzone.proxy.feedcomponent.util.g.a(34.0f);
    private static int AVATAR_OF_ANCHOR_SIZE = com.qzone.proxy.feedcomponent.util.g.a(20.0f);
    private static int NUM_OF_AVATAR_OF_ANCHOR = 3;

    public CanvasFeedEventTagArea(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        this.mLeftPic = new DrawUrlPicArea();
        this.mAdvTitleIcon = new DrawUrlPicArea();
        this.mActionPic = new DrawUrlPicArea();
        this.mTitle = new FeedTextArea(0);
        this.mSummary = new FeedTextArea(0);
        this.mActionButton = new TextButtonArea(0, 14.0f, AreaConst.dp60, AreaConst.dp28, ACTION_BUTTON_BACKGROUND_DRAWABLE, "", j.c(21));
        this.mSubAreaShellLists = new ArrayList();
        this.mAvatarListOfAnchor = new AvatarsLayoutByRowArea();
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
        this.isDetail = false;
        this.avatarListOfAnchorMarginLeft = i3;
        this.avatarListOfAnchorMarginRight = i3;
        this.avatarListOfAnchorMarginTop = i16;
        this.avatarListOfAnchorOffestX = AreaConst.dp16;
        this.mTrans = 255;
        this.subPaint = new Paint();
        this.mHost = dittoHost;
    }

    private void measure() {
        SubAreaShell subAreaShell;
        SubAreaShell subAreaShell2;
        SubAreaShell subAreaShell3;
        SubAreaShell subAreaShell4;
        SubAreaShell subAreaShell5;
        int width;
        int i3;
        SubAreaShell subAreaShell6;
        SubAreaShell subAreaShell7;
        int width2;
        int i16;
        SubAreaShell subAreaShell8 = this.mLeftPicShell;
        if (subAreaShell8 != null) {
            subAreaShell8.measure(0, 0);
            this.mLeftPicShell.setLeft(0);
            this.mLeftPicShell.setTop(0);
        }
        SubAreaShell subAreaShell9 = this.mActionPicShell;
        if (subAreaShell9 != null) {
            this.actionPicMarginTop = (VIEW_HEIGHT - subAreaShell9.getHeight()) / 2;
            SubAreaShell subAreaShell10 = this.mActionPicShell;
            subAreaShell10.setLeft((VIEW_WIDTH - subAreaShell10.getWidth()) - this.actionPicMarginRight);
            this.mActionPicShell.setTop(this.actionPicMarginTop);
        }
        SubAreaShell subAreaShell11 = this.mActionButtonShell;
        if (subAreaShell11 != null) {
            subAreaShell11.measure(0, 0);
            this.actionButtonMarginTop = (VIEW_HEIGHT - this.mActionButtonShell.getHeight()) / 2;
            SubAreaShell subAreaShell12 = this.mActionButtonShell;
            subAreaShell12.setLeft((VIEW_WIDTH - subAreaShell12.getWidth()) - this.actionButtonMarginRight);
            this.mActionButtonShell.setTop(this.actionButtonMarginTop);
        }
        if (this.mTitleShell != null && (subAreaShell7 = this.mLeftPicShell) != null) {
            if (this.mAdvTitleIconShell != null) {
                if (this.mActionPicShell != null) {
                    width2 = (((((VIEW_WIDTH - subAreaShell7.getWidth()) - this.titleMarginLeft) - this.advTitleIconMarginLeft) - this.mAdvTitleIconShell.getWidth()) - this.actionPicMarginLeft) - this.mActionPicShell.getWidth();
                    i16 = this.actionPicMarginRight;
                } else if (this.mActionButtonShell != null) {
                    width2 = (((((VIEW_WIDTH - subAreaShell7.getWidth()) - this.titleMarginLeft) - this.advTitleIconMarginLeft) - this.mAdvTitleIconShell.getWidth()) - this.actionButtonMarginLeft) - this.mActionButtonShell.getWidth();
                    i16 = this.actionButtonMarginRight;
                } else {
                    width2 = ((VIEW_WIDTH - subAreaShell7.getWidth()) - this.titleMarginLeft) - this.advTitleIconMarginLeft;
                    i16 = this.mAdvTitleIconShell.getWidth();
                }
            } else if (this.mActionPicShell != null) {
                width2 = (((VIEW_WIDTH - subAreaShell7.getWidth()) - this.titleMarginLeft) - this.actionPicMarginLeft) - this.mActionPicShell.getWidth();
                i16 = this.actionPicMarginRight;
            } else if (this.mActionButtonShell != null) {
                width2 = (((VIEW_WIDTH - subAreaShell7.getWidth()) - this.titleMarginLeft) - this.actionButtonMarginLeft) - this.mActionButtonShell.getWidth();
                i16 = this.actionButtonMarginRight;
            } else {
                width2 = VIEW_WIDTH - subAreaShell7.getWidth();
                i16 = this.titleMarginLeft;
            }
            this.mTitleShell.setMaxWidth(width2 - i16);
            this.mTitleShell.measure(-2, 0);
        }
        if (this.mAvatarListOfAnchorShell != null && this.mSummaryShell != null && (subAreaShell6 = this.mLeftPicShell) != null && this.mActionButtonShell != null) {
            this.mAvatarListOfAnchorShell.setMaxWidth(((((((VIEW_WIDTH - subAreaShell6.getWidth()) - this.titleMarginLeft) - this.actionButtonMarginLeft) - this.mActionButtonShell.getWidth()) - this.actionButtonMarginRight) - this.mSummaryShell.getWidth()) - this.avatarListOfAnchorMarginRight);
            this.mAvatarListOfAnchorShell.measure(-2, 0);
        }
        if (this.mSummaryShell != null && this.mTitleShell != null && (subAreaShell5 = this.mLeftPicShell) != null) {
            if (this.mActionPicShell != null) {
                width = (((VIEW_WIDTH - subAreaShell5.getWidth()) - this.titleMarginLeft) - this.actionPicMarginLeft) - this.mActionPicShell.getWidth();
                i3 = this.actionPicMarginRight;
            } else if (this.mActionButtonShell != null) {
                width = (((VIEW_WIDTH - subAreaShell5.getWidth()) - this.titleMarginLeft) - this.actionButtonMarginLeft) - this.mActionButtonShell.getWidth();
                i3 = this.actionButtonMarginRight;
            } else {
                width = VIEW_WIDTH - subAreaShell5.getWidth();
                i3 = this.titleMarginLeft;
            }
            int i17 = width - i3;
            CellBottomRecomm cellBottomRecomm = this.cellBottomRecomm;
            if (cellBottomRecomm != null && cellBottomRecomm.anonymity == CellBottomRecomm.TYPE_EVENT_TAG) {
                i H = i.H();
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
        SubAreaShell subAreaShell13 = this.mTitleShell;
        if (subAreaShell13 != null) {
            if (this.mSummaryShell != null) {
                if (this.mAvatarListOfAnchorShell != null) {
                    this.titleMarginTop = (VIEW_HEIGHT - ((subAreaShell13.getHeight() + this.avatarListOfAnchorMarginTop) + this.mAvatarListOfAnchorShell.getHeight())) / 2;
                } else {
                    this.titleMarginTop = (VIEW_HEIGHT - ((subAreaShell13.getHeight() + this.summaryMarginTop) + this.mSummaryShell.getHeight())) / 2;
                }
            } else {
                this.titleMarginTop = (VIEW_HEIGHT - subAreaShell13.getHeight()) / 2;
            }
        }
        SubAreaShell subAreaShell14 = this.mTitleShell;
        if (subAreaShell14 != null && (subAreaShell4 = this.mLeftPicShell) != null) {
            subAreaShell14.setLeft(subAreaShell4.getRight() + this.titleMarginLeft);
            this.mTitleShell.setTop(this.titleMarginTop);
        }
        SubAreaShell subAreaShell15 = this.mAvatarListOfAnchorShell;
        if (subAreaShell15 != null && this.mTitleShell != null && (subAreaShell3 = this.mLeftPicShell) != null) {
            subAreaShell15.setLeft(subAreaShell3.getRight() + this.avatarListOfAnchorMarginLeft);
            this.mAvatarListOfAnchorShell.setTop(this.mTitleShell.getBottom() + this.avatarListOfAnchorMarginTop);
        }
        SubAreaShell subAreaShell16 = this.mSummaryShell;
        if (subAreaShell16 != null && this.mTitleShell != null && (subAreaShell2 = this.mLeftPicShell) != null) {
            SubAreaShell subAreaShell17 = this.mAvatarListOfAnchorShell;
            if (subAreaShell17 != null) {
                subAreaShell16.setLeft(subAreaShell17.getRight() + this.avatarListOfAnchorMarginRight);
                this.mSummaryShell.setTop(this.mTitleShell.getBottom() + this.summaryMarginTop + ((this.mAvatarListOfAnchorShell.getHeight() - this.mSummary.getHeight()) / 2));
            } else {
                subAreaShell16.setLeft(subAreaShell2.getRight() + this.titleMarginLeft);
                this.mSummaryShell.setTop(this.mTitleShell.getBottom() + this.summaryMarginTop);
            }
        }
        SubAreaShell subAreaShell18 = this.mAdvTitleIconShell;
        if (subAreaShell18 != null && (subAreaShell = this.mTitleShell) != null) {
            subAreaShell18.setLeft(subAreaShell.getRight() + this.advTitleIconMarginLeft);
            this.mAdvTitleIconShell.setTop(this.titleMarginTop + AreaConst.dp0_5);
        }
        invalidate();
    }

    protected void bindEventTagView(CellBottomRecomm cellBottomRecomm, View view) {
        ArrayList<s_user> arrayList;
        PictureItem pictureItem = cellBottomRecomm.picinfo;
        if (pictureItem != null && pictureItem.currentUrl != null) {
            int i3 = LEFT_PIC_SIZE;
            PictureUrl pictureUrl = cellBottomRecomm.picinfo.currentUrl;
            NormalFeedImageProcessor normalFeedImageProcessor = new NormalFeedImageProcessor(i3, i3, pictureUrl.pivotXRate, pictureUrl.pivotYRate);
            DrawUrlPicArea drawUrlPicArea = this.mLeftPic;
            PictureUrl pictureUrl2 = cellBottomRecomm.picinfo.currentUrl;
            String str = pictureUrl2.url;
            int i16 = LEFT_PIC_SIZE;
            drawUrlPicArea.setData(str, i16, i16, normalFeedImageProcessor, pictureUrl2.imageUrl);
            SubAreaShell obtain = SubAreaShell.obtain(this.mLeftPic);
            this.mLeftPicShell = obtain;
            obtain.setParent(view);
            this.mSubAreaShellLists.add(this.mLeftPicShell);
        }
        if (!TextUtils.isEmpty(cellBottomRecomm.AdvIconUrl)) {
            this.mAdvTitleIcon.setData(cellBottomRecomm.AdvIconUrl, ADV_ICON_WIDTH, ADV_ICON_HEIGHT, cellBottomRecomm.imageUrl);
            SubAreaShell obtain2 = SubAreaShell.obtain(this.mAdvTitleIcon);
            this.mAdvTitleIconShell = obtain2;
            obtain2.setParent(view);
            this.mSubAreaShellLists.add(this.mAdvTitleIconShell);
        }
        if (!TextUtils.isEmpty(cellBottomRecomm.buttonIconUrl)) {
            DrawUrlPicArea drawUrlPicArea2 = this.mActionPic;
            String str2 = cellBottomRecomm.buttonIconUrl;
            int i17 = ACTION_PIC_SIZE;
            drawUrlPicArea2.setData(str2, i17, i17, cellBottomRecomm.imageUrl);
            SubAreaShell obtain3 = SubAreaShell.obtain(this.mActionPic);
            this.mActionPicShell = obtain3;
            obtain3.setParent(view);
            this.mSubAreaShellLists.add(this.mActionPicShell);
        } else if (!TextUtils.isEmpty(cellBottomRecomm.buttontext)) {
            if (cellBottomRecomm.anonymity == CellBottomRecomm.TYPE_QZONE_LIVE) {
                this.mActionButton = new TextButtonArea(0, 14.0f, AreaConst.dp58, AreaConst.dp29, ACTION_BUTTON_BACKGROUND_DRAWABLE, "", j.o());
                float f16 = AreaConst.dp14_5;
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f16, f16, f16, f16, f16, f16, f16, f16}, null, null));
                shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
                shapeDrawable.getPaint().setColor(j.x());
                ACTION_BUTTON_BACKGROUND_DRAWABLE = shapeDrawable;
                Paint paint = new Paint();
                paint.setTextSize(AreaConst.dp14);
                int round = Math.round(paint.measureText(cellBottomRecomm.buttontext)) + AreaConst.dp30;
                TextButtonArea textButtonArea = this.mActionButton;
                if (textButtonArea == null) {
                    this.mActionButton = new TextButtonArea(0, 14.0f, round, AreaConst.dp28, ACTION_BUTTON_BACKGROUND_DRAWABLE, "", 16777215);
                } else {
                    textButtonArea.setBtnWidth(round);
                    this.mActionButton.setBtnNormalDrawable(ACTION_BUTTON_BACKGROUND_DRAWABLE);
                    this.mActionButton.setNormalTextColor(16777215);
                }
                i.H().f(236, 2, 1);
            } else {
                this.mActionButton = new TextButtonArea(0, 14.0f, AreaConst.dp60, AreaConst.dp28, ACTION_BUTTON_BACKGROUND_DRAWABLE, "", j.c(21));
            }
            this.mActionButton.setEnablePressState(false);
            this.mActionButton.setNormalText(cellBottomRecomm.buttontext);
            SubAreaShell obtain4 = SubAreaShell.obtain(this.mActionButton);
            this.mActionButtonShell = obtain4;
            obtain4.setParent(view);
            this.mSubAreaShellLists.add(this.mActionButtonShell);
        }
        if (cellBottomRecomm.title != null) {
            this.mTitle.setLineSpace(0.0f);
            this.mTitle.setTextSize(14.0f);
            this.mTitle.setTextColor(Color.parseColor("#000000"));
            this.mTitle.setMaxLine(1);
            this.mTitle.setData(cellBottomRecomm.title, 0);
            SubAreaShell obtain5 = SubAreaShell.obtain(this.mTitle);
            this.mTitleShell = obtain5;
            obtain5.setParent(view);
            this.mSubAreaShellLists.add(this.mTitleShell);
        }
        s_join_list s_join_listVar = cellBottomRecomm.joinlist;
        if (s_join_listVar != null && cellBottomRecomm.anonymity == CellBottomRecomm.TYPE_QZONE_LIVE && (arrayList = s_join_listVar.users) != null && !arrayList.isEmpty()) {
            ArrayList<User> arrayList2 = new ArrayList<>();
            Iterator<s_user> it = arrayList.iterator();
            while (it.hasNext()) {
                User q16 = e.q(it.next());
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
            SubAreaShell obtain6 = SubAreaShell.obtain(this.mAvatarListOfAnchor);
            this.mAvatarListOfAnchorShell = obtain6;
            obtain6.setParent(view);
            this.mSubAreaShellLists.add(this.mAvatarListOfAnchorShell);
        }
        if (!TextUtils.isEmpty(cellBottomRecomm.summary)) {
            this.mSummary.setLineSpace(0.0f);
            this.mSummary.setTextSize(14.0f);
            if (!TextUtils.isEmpty(cellBottomRecomm.summaryColor)) {
                this.mSummary.setTextColor(Color.parseColor(cellBottomRecomm.summaryColor));
            } else {
                this.mSummary.setTextColor(Color.parseColor("#707070"));
            }
            this.mSummary.setMaxLine(1);
            this.mSummary.setData(cellBottomRecomm.summary, 0);
            SubAreaShell obtain7 = SubAreaShell.obtain(this.mSummary);
            this.mSummaryShell = obtain7;
            obtain7.setParent(view);
            this.mSubAreaShellLists.add(this.mSummaryShell);
        }
        measure();
    }

    @Override // com.tencent.ditto.area.DittoArea, com.tencent.ditto.area.DittoElement
    public int getHeight() {
        return VIEW_HEIGHT;
    }

    @Override // com.tencent.ditto.area.DittoArea
    public int getType() {
        return 79;
    }

    @Override // com.tencent.ditto.area.DittoArea, com.tencent.ditto.area.DittoElement
    public int getWidth() {
        return VIEW_WIDTH;
    }

    public void handleClickEvent(View view) {
        if (this.feedData != null) {
            i.H().D(12, 211, 1, System.currentTimeMillis(), this.feedData.getFeedCommInfo().isRealTimeTTTReport());
        }
        CellBottomRecomm cellBottomRecomm = this.cellBottomRecomm;
        if (cellBottomRecomm != null) {
            int i3 = cellBottomRecomm.anonymity;
            if (i3 == CellBottomRecomm.TYPE_ADV) {
                this.onFeedElementClickListener.onClick(view, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_ADV, this.feedPosition, Boolean.valueOf(this.isDetail));
                return;
            }
            if (i3 == CellBottomRecomm.TYPE_EVENT_TAG) {
                this.onFeedElementClickListener.onClick(view, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_EVENT_TAG, this.feedPosition, this.feedData);
                return;
            }
            if (i3 == CellBottomRecomm.TYPE_PHOTO) {
                this.onFeedElementClickListener.onClick(view, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_PHOTO, this.feedPosition, Boolean.valueOf(this.isDetail));
            } else if (i3 == CellBottomRecomm.TYPE_QZONE_LIVE) {
                i.H().f(236, 2, 2);
            } else {
                this.onFeedElementClickListener.onClick(view, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_EVENT_TAG, this.feedPosition, this.feedData);
            }
        }
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onDraw(Canvas canvas) {
        ColorDrawable colorDrawable = new ColorDrawable(j.m());
        colorDrawable.setAlpha(this.mTrans);
        colorDrawable.setBounds(0, 0, VIEW_WIDTH, VIEW_HEIGHT);
        colorDrawable.draw(canvas);
        Drawable drawable = LEFT_PIC_BACKGROUND_DRAWABLE;
        int i3 = LEFT_PIC_SIZE;
        drawable.setBounds(0, 0, i3, i3);
        LEFT_PIC_BACKGROUND_DRAWABLE.draw(canvas);
        for (SubAreaShell subAreaShell : this.mSubAreaShellLists) {
            if (subAreaShell != null) {
                canvas.save();
                canvas.translate(subAreaShell.getLeft(), subAreaShell.getTop());
                subAreaShell.draw(canvas, this.subPaint);
                canvas.restore();
            }
        }
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onMeasure(int i3, int i16) {
        setMeasuredDimension(VIEW_WIDTH, VIEW_HEIGHT);
    }

    @Override // com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        this.mSubAreaShellLists.clear();
        this.mLeftPicShell = null;
        this.mAdvTitleIconShell = null;
        this.mActionPicShell = null;
        this.mTitleShell = null;
        this.mSummaryShell = null;
        this.mActionButtonShell = null;
        this.cellBottomRecomm = null;
        this.mAvatarListOfAnchorShell = null;
    }

    @Override // com.tencent.ditto.area.DittoArea
    public boolean onTouchEvent(MotionEvent motionEvent) {
        DittoArea.ClickListener clickListener;
        if (motionEvent.getAction() == 1 && (clickListener = this.clickListener) != null) {
            clickListener.onClick(this, null, null);
        }
        return true;
    }

    public void reset() {
        this.mSubAreaShellLists.clear();
        this.mLeftPicShell = null;
        this.mAdvTitleIconShell = null;
        this.mActionPicShell = null;
        this.mTitleShell = null;
        this.mSummaryShell = null;
        this.mActionButtonShell = null;
        this.cellBottomRecomm = null;
        this.mAvatarListOfAnchorShell = null;
    }

    public void setFeedPosition(int i3) {
        this.feedPosition = i3;
    }

    public void setOnFeedElementClickListener(g gVar) {
        this.onFeedElementClickListener = gVar;
    }

    public void setTrans(int i3) {
        this.mTrans = i3;
    }

    public void setData(BusinessFeedData businessFeedData, CellBottomRecomm cellBottomRecomm, boolean z16, View view) {
        if (cellBottomRecomm == null) {
            return;
        }
        setVisibility(TextUtils.isEmpty(cellBottomRecomm.title) ? 8 : 0);
        this.feedData = businessFeedData;
        this.cellBottomRecomm = cellBottomRecomm;
        this.isDetail = z16;
        if (cellBottomRecomm.anonymity == CellBottomRecomm.TYPE_ADV) {
            if (z16) {
                i.H().D(3, 65, 19, System.currentTimeMillis(), true);
            } else {
                i.H().D(12, 65, 19, System.currentTimeMillis(), true);
            }
        }
        bindEventTagView(cellBottomRecomm, view);
    }
}
