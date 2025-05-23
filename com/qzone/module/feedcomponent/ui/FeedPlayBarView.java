package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.adapter.feedcomponent.r;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.module.feedcomponent.ui.SubAreaShell;
import com.qzone.module.feedcomponent.util.CardUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellPicTextInfo;
import com.qzone.proxy.feedcomponent.model.PicText;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.text.ColorTextCell;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.UrlCell;
import com.qzone.proxy.feedcomponent.text.UserNameCell;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import java.util.ArrayList;

/* loaded from: classes39.dex */
public class FeedPlayBarView extends View implements r, FeedChildView {
    public static FeedViewSection.SectionController FeedPlayBarController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedPlayBarView.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            CellPicTextInfo picTextInfo;
            ArrayList<PicText> arrayList;
            return businessFeedData == null || businessFeedData.isFriendPlayingFeed() || (picTextInfo = businessFeedData.getPicTextInfo()) == null || (arrayList = picTextInfo.picTexts) == null || arrayList.size() <= 0;
        }
    };
    Paint backgroundPaint;
    Paint cardPaint;
    Context context;
    int descMarginBottom;
    int descMarginTop;
    BusinessFeedData feedData;
    protected int feedPosition;
    int gameNameMarginTop;
    float gameNameTextSize;
    int leftActiontype;
    String leftActionurl;
    int leftLeft;
    PlayBarUserArea mDescAreaLeft;
    SubAreaShell mDescAreaLeftShell;
    PlayBarUserArea mDescAreaRight;
    SubAreaShell mDescAreaRightShell;
    LightSingleLineTextArea mGameNameLeft;
    SubAreaShell mGameNameLeftShell;
    LightSingleLineTextArea mGameNameRight;
    SubAreaShell mGameNameRightShell;
    boolean mHasRecyled;
    SinglePlayPicArea mPicAreaLeft;
    SubAreaShell mPicAreaLeftShell;
    SinglePlayPicArea mPicAreaRight;
    SubAreaShell mPicAreaRightShell;
    int mPicMaxHeight;
    protected SubAreaShell.OnAreaClickListener onClickListener;
    protected com.qzone.proxy.feedcomponent.ui.g onFeedElementClickListener;
    CellPicTextInfo picTextInfo;
    int rightActiontype;
    int rightLeft;
    String rightSctionurl;
    int textMarginLeft;

    public FeedPlayBarView(Context context) {
        super(context);
        int i3 = AreaConst.FEED_INTERVAL;
        this.leftLeft = i3;
        this.rightLeft = i3 + SinglePlayPicArea.DEFAULT_PIC_WIDTH + AreaConst.FEED_INTERVAL;
        this.onClickListener = new SubAreaShell.OnAreaClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedPlayBarView.2
            @Override // com.qzone.module.feedcomponent.ui.SubAreaShell.OnAreaClickListener
            public void onAreaClicked(SubAreaShell subAreaShell, TextCell textCell) {
                if (textCell == null) {
                    if (FeedPlayBarView.this.onFeedElementClickListener == null) {
                        return;
                    }
                    subAreaShell.getType();
                    return;
                }
                FeedPlayBarView feedPlayBarView = FeedPlayBarView.this;
                com.qzone.proxy.feedcomponent.ui.g gVar = feedPlayBarView.onFeedElementClickListener;
                if (gVar != null) {
                    if (textCell instanceof UserNameCell) {
                        gVar.onClick(feedPlayBarView, FeedElement.FRIEND_NICKNAME, feedPlayBarView.feedPosition, ((UserNameCell) textCell).getUin());
                        return;
                    }
                    if (textCell instanceof UrlCell) {
                        UrlCell urlCell = (UrlCell) textCell;
                        if (urlCell.getAction() == 2) {
                            FeedPlayBarView feedPlayBarView2 = FeedPlayBarView.this;
                            com.qzone.proxy.feedcomponent.ui.g gVar2 = feedPlayBarView2.onFeedElementClickListener;
                            FeedElement feedElement = FeedElement.CONTENT;
                            int i16 = feedPlayBarView2.feedPosition;
                            gVar2.onClick(feedPlayBarView2, feedElement, i16, Integer.valueOf(i16));
                            return;
                        }
                        FeedPlayBarView feedPlayBarView3 = FeedPlayBarView.this;
                        feedPlayBarView3.onFeedElementClickListener.onClick(feedPlayBarView3, FeedElement.URL, feedPlayBarView3.feedPosition, new com.qzone.proxy.feedcomponent.model.e(urlCell.getUrl(), urlCell.post, FeedPlayBarView.this.feedPosition));
                        return;
                    }
                    if (textCell instanceof ColorTextCell) {
                        if (textCell.getType() == 5) {
                            FeedPlayBarView feedPlayBarView4 = FeedPlayBarView.this;
                            com.qzone.proxy.feedcomponent.ui.g gVar3 = feedPlayBarView4.onFeedElementClickListener;
                            FeedElement feedElement2 = FeedElement.CONTENT;
                            int i17 = feedPlayBarView4.feedPosition;
                            gVar3.onClick(feedPlayBarView4, feedElement2, i17, Integer.valueOf(i17));
                            return;
                        }
                        return;
                    }
                    FeedElement feedElement3 = FeedElement.NOTHING;
                    int i18 = feedPlayBarView.feedPosition;
                    gVar.onClick(feedPlayBarView, feedElement3, i18, Integer.valueOf(i18));
                }
            }
        };
        this.context = context;
        init();
    }

    void bindData(CellPicTextInfo cellPicTextInfo) {
        if (cellPicTextInfo.dataNum <= 0 || cellPicTextInfo.picTexts == null) {
            return;
        }
        for (int i3 = 0; i3 < cellPicTextInfo.picTexts.size(); i3++) {
            PicText picText = cellPicTextInfo.picTexts.get(i3);
            PictureItem pictureItem = picText.pictureItem;
            String str = picText.summary;
            String str2 = picText.title;
            if (i3 == 0) {
                this.mPicAreaLeft.setPicInfo(pictureItem, picText, this.feedData);
                this.mGameNameLeft.setText(str2);
                this.mGameNameLeft.setTextSize(this.gameNameTextSize);
                this.mGameNameLeft.setTextColor(com.qzone.adapter.feedcomponent.j.o());
                this.mGameNameLeft.setTextBold(false);
                this.mGameNameLeft.setMaxWidth(PlayBarUserArea.DEFAULT_WIDTH);
                PlayBarUserArea playBarUserArea = (PlayBarUserArea) AreaManager.getInstance().getPicTextArea(str, picText.postFix, cellPicTextInfo.uniKeyLeft);
                this.mDescAreaLeft = playBarUserArea;
                playBarUserArea.setTextColor(com.qzone.adapter.feedcomponent.j.F());
                this.leftActiontype = picText.actionType;
                this.leftActionurl = picText.actionUrl;
            } else if (i3 == 1) {
                this.mPicAreaRight.setPicInfo(pictureItem, picText, this.feedData);
                this.mGameNameRight.setText(str2);
                this.mGameNameRight.setTextSize(this.gameNameTextSize);
                this.mGameNameRight.setTextColor(com.qzone.adapter.feedcomponent.j.o());
                this.mGameNameRight.setTextBold(false);
                this.mGameNameRight.setMaxWidth(PlayBarUserArea.DEFAULT_WIDTH);
                PlayBarUserArea playBarUserArea2 = (PlayBarUserArea) AreaManager.getInstance().getPicTextArea(str, picText.postFix, cellPicTextInfo.uniKeyRight);
                this.mDescAreaRight = playBarUserArea2;
                playBarUserArea2.setTextColor(com.qzone.adapter.feedcomponent.j.F());
                this.rightActiontype = picText.actionType;
                this.rightSctionurl = picText.actionUrl;
            }
        }
    }

    public boolean canHide() {
        CellPicTextInfo cellPicTextInfo = this.picTextInfo;
        return cellPicTextInfo == null || cellPicTextInfo.dataNum == 0 || cellPicTextInfo.picTexts.size() == 0;
    }

    SubAreaShell findArea(float f16, float f17) {
        if (isInArea(this.mPicAreaLeftShell, f16, f17)) {
            return this.mPicAreaLeftShell;
        }
        if (isInArea(this.mPicAreaRightShell, f16, f17)) {
            return this.mPicAreaRightShell;
        }
        if (isInArea(this.mGameNameLeftShell, f16, f17)) {
            return this.mGameNameLeftShell;
        }
        if (isInArea(this.mGameNameRightShell, f16, f17)) {
            return this.mGameNameRightShell;
        }
        if (isInArea(this.mDescAreaLeftShell, f16, f17)) {
            return this.mDescAreaLeftShell;
        }
        if (isInArea(this.mDescAreaRightShell, f16, f17)) {
            return this.mDescAreaRightShell;
        }
        return null;
    }

    void init() {
        this.mPicAreaLeft = new SinglePlayPicArea();
        this.mPicAreaRight = new SinglePlayPicArea();
        this.mGameNameLeft = new LightSingleLineTextArea(32);
        this.mGameNameRight = new LightSingleLineTextArea(32);
        this.mDescAreaLeft = new PlayBarUserArea();
        this.mDescAreaRight = new PlayBarUserArea();
        this.textMarginLeft = PlayBarUserArea.TEXT_MARGIN_LEFT;
        this.gameNameMarginTop = com.qzone.proxy.feedcomponent.util.g.a(10.0f);
        this.descMarginTop = com.qzone.proxy.feedcomponent.util.g.a(2.0f);
        this.descMarginBottom = com.qzone.proxy.feedcomponent.util.g.a(6.0f);
        this.gameNameTextSize = AreaConst.secondTextSize;
        Paint paint = new Paint();
        this.backgroundPaint = paint;
        paint.setColor(com.qzone.adapter.feedcomponent.j.c(10));
        this.backgroundPaint.setStrokeWidth(1.0f);
        this.backgroundPaint.setStyle(Paint.Style.STROKE);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (canHide()) {
            return;
        }
        canvas.translate(AreaConst.FEED_INTERVAL + AreaConst.f48746dp1, CardUtils.CARD_SHADOW_TOP_SPACE);
        canvas.save();
        if (this.mPicAreaLeftShell != null) {
            SubAreaShell subAreaShell = this.mGameNameLeftShell;
            int height = subAreaShell != null ? subAreaShell.getHeight() : 0;
            RectF rectF = new RectF(0.0f, 0.0f, SinglePlayPicArea.DEFAULT_PIC_WIDTH, this.mPicMaxHeight + height + this.gameNameMarginTop + this.descMarginTop + (this.mDescAreaLeftShell != null ? r6.getHeight() : 0) + this.descMarginBottom);
            CardUtils.drawCardShadow(canvas, rectF, 12, this.backgroundPaint);
            canvas.save();
            Path path = new Path();
            path.addRoundRect(rectF, 12.0f, 12.0f, Path.Direction.CCW);
            canvas.clipPath(path);
            this.mPicAreaLeftShell.draw(canvas, null);
            canvas.restore();
            canvas.translate(0.0f, this.mPicMaxHeight);
        }
        if (this.mGameNameLeftShell != null && this.mDescAreaLeftShell != null) {
            canvas.translate(this.textMarginLeft, 0.0f);
            canvas.translate(0.0f, this.gameNameMarginTop);
            this.mGameNameLeftShell.draw(canvas, null);
            canvas.translate(0.0f, this.mGameNameLeftShell.getHeight());
            canvas.translate(0.0f, this.descMarginTop);
            this.mDescAreaLeftShell.draw(canvas, null);
        }
        canvas.restore();
        canvas.save();
        int i3 = SinglePlayPicArea.DEFAULT_PIC_WIDTH;
        canvas.translate((AreaConst.FEED_INTERVAL + i3) - AreaConst.f48747dp2, 0.0f);
        if (this.mPicAreaRightShell != null) {
            SubAreaShell subAreaShell2 = this.mGameNameRightShell;
            int height2 = subAreaShell2 != null ? subAreaShell2.getHeight() : 0;
            RectF rectF2 = new RectF(0.0f, 0.0f, i3, this.mPicMaxHeight + height2 + this.gameNameMarginTop + this.descMarginTop + (this.mDescAreaRightShell != null ? r7.getHeight() : 0) + this.descMarginBottom);
            CardUtils.drawCardShadow(canvas, rectF2, 12, this.backgroundPaint);
            canvas.save();
            Path path2 = new Path();
            path2.addRoundRect(rectF2, 12.0f, 12.0f, Path.Direction.CCW);
            canvas.clipPath(path2);
            this.mPicAreaRightShell.draw(canvas, null);
            canvas.restore();
            canvas.translate(0.0f, this.mPicMaxHeight);
        }
        if (this.mGameNameRightShell != null && this.mDescAreaRightShell != null) {
            canvas.translate(this.textMarginLeft, 0.0f);
            canvas.translate(0.0f, this.gameNameMarginTop);
            this.mGameNameRightShell.draw(canvas, null);
            canvas.translate(0.0f, this.mGameNameRightShell.getHeight());
            canvas.translate(0.0f, this.descMarginTop);
            this.mDescAreaRightShell.draw(canvas, null);
        }
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        if (canHide()) {
            setMeasuredDimension(0, 0);
            return;
        }
        int i17 = AreaConst.SCREEN_WIDTH;
        this.mPicMaxHeight = 0;
        SubAreaShell subAreaShell = this.mPicAreaLeftShell;
        if (subAreaShell != null) {
            subAreaShell.setTop(0);
            this.mPicAreaLeftShell.setLeft(this.leftLeft);
            this.mPicMaxHeight = this.mPicAreaLeftShell.getHeight();
        }
        SubAreaShell subAreaShell2 = this.mPicAreaRightShell;
        if (subAreaShell2 != null) {
            subAreaShell2.setTop(0);
            this.mPicAreaRightShell.setLeft(this.rightLeft);
            if (this.mPicMaxHeight < this.mPicAreaRightShell.getHeight()) {
                this.mPicMaxHeight = this.mPicAreaRightShell.getHeight();
            }
        }
        int i18 = 0 + this.mPicMaxHeight;
        SubAreaShell subAreaShell3 = this.mGameNameLeftShell;
        if (subAreaShell3 != null) {
            subAreaShell3.setTop(i18);
            this.mGameNameLeftShell.setLeft(this.leftLeft);
        }
        SubAreaShell subAreaShell4 = this.mGameNameRightShell;
        if (subAreaShell4 != null) {
            subAreaShell4.setTop(i18);
            this.mGameNameRightShell.setLeft(this.rightLeft);
            i18 += this.gameNameMarginTop + this.mGameNameRightShell.getHeight();
        }
        SubAreaShell subAreaShell5 = this.mDescAreaLeftShell;
        if (subAreaShell5 != null) {
            subAreaShell5.setTop(i18);
            this.mDescAreaLeftShell.setLeft(this.leftLeft);
        }
        SubAreaShell subAreaShell6 = this.mDescAreaRightShell;
        if (subAreaShell6 != null) {
            subAreaShell6.setTop(i18);
            this.mDescAreaRightShell.setLeft(this.rightLeft);
            i18 += this.descMarginTop + this.mDescAreaRightShell.getHeight() + this.descMarginBottom;
        }
        int i19 = i18 + 1;
        BusinessFeedData businessFeedData = this.feedData;
        if (businessFeedData != null && !businessFeedData.isCommentEmpty()) {
            i19 += AreaManager.dp8;
        }
        setMeasuredDimension(i17, i19);
    }

    public void onPause() {
        SinglePlayPicArea singlePlayPicArea = this.mPicAreaLeft;
        if (singlePlayPicArea != null) {
            singlePlayPicArea.onPause();
        }
        SinglePlayPicArea singlePlayPicArea2 = this.mPicAreaRight;
        if (singlePlayPicArea2 != null) {
            singlePlayPicArea2.onPause();
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateIdle() {
        SinglePlayPicArea singlePlayPicArea = this.mPicAreaLeft;
        if (singlePlayPicArea != null) {
            singlePlayPicArea.onStateIdle();
        }
        SinglePlayPicArea singlePlayPicArea2 = this.mPicAreaRight;
        if (singlePlayPicArea2 != null) {
            singlePlayPicArea2.onStateIdle();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        if (motionEvent.getAction() == 1) {
            float x16 = motionEvent.getX();
            int i3 = 0;
            if (x16 > this.leftLeft && x16 < this.rightLeft) {
                z16 = this.mPicAreaLeft.shouldPlay(motionEvent.getX() - this.mPicAreaLeftShell.getLeft(), motionEvent.getY() - this.mPicAreaLeftShell.getTop());
                if (z16) {
                    this.mPicAreaLeft.onPlayIconClicked();
                }
                com.qzone.adapter.feedcomponent.i.H().g2(0, this.picTextInfo.picTexts, this.feedData);
            } else if (x16 > this.rightLeft) {
                boolean shouldPlay = this.mPicAreaRight.shouldPlay(motionEvent.getX() - this.mPicAreaRightShell.getLeft(), motionEvent.getY() - this.mPicAreaRightShell.getTop());
                if (shouldPlay) {
                    this.mPicAreaRight.onPlayIconClicked();
                }
                com.qzone.adapter.feedcomponent.i.H().g2(1, this.picTextInfo.picTexts, this.feedData);
                z16 = shouldPlay;
                i3 = 1;
            } else {
                z16 = false;
                i3 = -1;
            }
            if (i3 != -1 && !z16) {
                this.onFeedElementClickListener.onClick(this, FeedElement.PLAYBAR, this.feedPosition, Integer.valueOf(i3));
            }
        }
        return true;
    }

    public void reset() {
        if (this.mHasRecyled) {
            return;
        }
        this.picTextInfo = null;
        SubAreaShell.recycle(this.mPicAreaLeftShell);
        this.mPicAreaLeftShell = null;
        SubAreaShell.recycle(this.mPicAreaRightShell);
        this.mPicAreaRightShell = null;
        SubAreaShell.recycle(this.mGameNameLeftShell);
        this.mGameNameLeftShell = null;
        SubAreaShell.recycle(this.mGameNameRightShell);
        this.mGameNameRightShell = null;
        SubAreaShell.recycle(this.mDescAreaLeftShell);
        this.mDescAreaLeftShell = null;
        SubAreaShell.recycle(this.mDescAreaRightShell);
        this.mDescAreaRightShell = null;
        this.mHasRecyled = true;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedData(BusinessFeedData businessFeedData) {
        this.feedData = businessFeedData;
        if (businessFeedData != null) {
            this.picTextInfo = businessFeedData.getPicTextInfo();
        } else {
            this.picTextInfo = null;
        }
        update();
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedPosition(int i3) {
        this.feedPosition = i3;
        this.mPicAreaLeft.setFeedPosition(i3);
        this.mPicAreaRight.setFeedPosition(i3);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.onFeedElementClickListener = gVar;
        this.mPicAreaLeft.setOnFeedElementClickListener(gVar);
        this.mPicAreaRight.setOnFeedElementClickListener(gVar);
    }

    @Override // com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        this.onFeedElementClickListener = null;
        reset();
        SinglePlayPicArea singlePlayPicArea = this.mPicAreaLeft;
        if (singlePlayPicArea != null) {
            singlePlayPicArea.onRecycled();
        }
        SinglePlayPicArea singlePlayPicArea2 = this.mPicAreaRight;
        if (singlePlayPicArea2 != null) {
            singlePlayPicArea2.onRecycled();
        }
    }

    public void update() {
        this.mHasRecyled = false;
        if (canHide()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        bindData(this.picTextInfo);
        SinglePlayPicArea singlePlayPicArea = this.mPicAreaLeft;
        if (singlePlayPicArea != null) {
            SubAreaShell obtain = SubAreaShell.obtain(singlePlayPicArea);
            this.mPicAreaLeftShell = obtain;
            obtain.setOnClickListener(this.onClickListener);
            this.mPicAreaLeftShell.setParent(this);
        }
        SinglePlayPicArea singlePlayPicArea2 = this.mPicAreaRight;
        if (singlePlayPicArea2 != null) {
            SubAreaShell obtain2 = SubAreaShell.obtain(singlePlayPicArea2);
            this.mPicAreaRightShell = obtain2;
            obtain2.setOnClickListener(this.onClickListener);
            this.mPicAreaRightShell.setParent(this);
        }
        LightSingleLineTextArea lightSingleLineTextArea = this.mGameNameLeft;
        if (lightSingleLineTextArea != null) {
            SubAreaShell obtain3 = SubAreaShell.obtain(lightSingleLineTextArea);
            this.mGameNameLeftShell = obtain3;
            obtain3.setOnClickListener(this.onClickListener);
            this.mGameNameLeftShell.setParent(this);
        }
        LightSingleLineTextArea lightSingleLineTextArea2 = this.mGameNameRight;
        if (lightSingleLineTextArea2 != null) {
            SubAreaShell obtain4 = SubAreaShell.obtain(lightSingleLineTextArea2);
            this.mGameNameRightShell = obtain4;
            obtain4.setOnClickListener(this.onClickListener);
            this.mGameNameRightShell.setParent(this);
        }
        PlayBarUserArea playBarUserArea = this.mDescAreaLeft;
        if (playBarUserArea != null) {
            SubAreaShell obtain5 = SubAreaShell.obtain(playBarUserArea);
            this.mDescAreaLeftShell = obtain5;
            obtain5.setOnClickListener(this.onClickListener);
            this.mDescAreaLeftShell.setParent(this);
        }
        PlayBarUserArea playBarUserArea2 = this.mDescAreaRight;
        if (playBarUserArea2 != null) {
            SubAreaShell obtain6 = SubAreaShell.obtain(playBarUserArea2);
            this.mDescAreaRightShell = obtain6;
            obtain6.setOnClickListener(this.onClickListener);
            this.mDescAreaRightShell.setParent(this);
        }
        forceLayout();
    }

    static boolean isInArea(SubAreaShell subAreaShell, float f16, float f17) {
        return subAreaShell != null && ((float) subAreaShell.getTop()) < f17 && ((float) subAreaShell.getBottom()) > f17 && ((float) subAreaShell.getLeft()) < f16 && ((float) subAreaShell.getRight()) > f16;
    }

    public FeedPlayBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i3 = AreaConst.FEED_INTERVAL;
        this.leftLeft = i3;
        this.rightLeft = i3 + SinglePlayPicArea.DEFAULT_PIC_WIDTH + AreaConst.FEED_INTERVAL;
        this.onClickListener = new SubAreaShell.OnAreaClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedPlayBarView.2
            @Override // com.qzone.module.feedcomponent.ui.SubAreaShell.OnAreaClickListener
            public void onAreaClicked(SubAreaShell subAreaShell, TextCell textCell) {
                if (textCell == null) {
                    if (FeedPlayBarView.this.onFeedElementClickListener == null) {
                        return;
                    }
                    subAreaShell.getType();
                    return;
                }
                FeedPlayBarView feedPlayBarView = FeedPlayBarView.this;
                com.qzone.proxy.feedcomponent.ui.g gVar = feedPlayBarView.onFeedElementClickListener;
                if (gVar != null) {
                    if (textCell instanceof UserNameCell) {
                        gVar.onClick(feedPlayBarView, FeedElement.FRIEND_NICKNAME, feedPlayBarView.feedPosition, ((UserNameCell) textCell).getUin());
                        return;
                    }
                    if (textCell instanceof UrlCell) {
                        UrlCell urlCell = (UrlCell) textCell;
                        if (urlCell.getAction() == 2) {
                            FeedPlayBarView feedPlayBarView2 = FeedPlayBarView.this;
                            com.qzone.proxy.feedcomponent.ui.g gVar2 = feedPlayBarView2.onFeedElementClickListener;
                            FeedElement feedElement = FeedElement.CONTENT;
                            int i16 = feedPlayBarView2.feedPosition;
                            gVar2.onClick(feedPlayBarView2, feedElement, i16, Integer.valueOf(i16));
                            return;
                        }
                        FeedPlayBarView feedPlayBarView3 = FeedPlayBarView.this;
                        feedPlayBarView3.onFeedElementClickListener.onClick(feedPlayBarView3, FeedElement.URL, feedPlayBarView3.feedPosition, new com.qzone.proxy.feedcomponent.model.e(urlCell.getUrl(), urlCell.post, FeedPlayBarView.this.feedPosition));
                        return;
                    }
                    if (textCell instanceof ColorTextCell) {
                        if (textCell.getType() == 5) {
                            FeedPlayBarView feedPlayBarView4 = FeedPlayBarView.this;
                            com.qzone.proxy.feedcomponent.ui.g gVar3 = feedPlayBarView4.onFeedElementClickListener;
                            FeedElement feedElement2 = FeedElement.CONTENT;
                            int i17 = feedPlayBarView4.feedPosition;
                            gVar3.onClick(feedPlayBarView4, feedElement2, i17, Integer.valueOf(i17));
                            return;
                        }
                        return;
                    }
                    FeedElement feedElement3 = FeedElement.NOTHING;
                    int i18 = feedPlayBarView.feedPosition;
                    gVar.onClick(feedPlayBarView, feedElement3, i18, Integer.valueOf(i18));
                }
            }
        };
        this.context = context;
        init();
    }

    public FeedPlayBarView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        int i16 = AreaConst.FEED_INTERVAL;
        this.leftLeft = i16;
        this.rightLeft = i16 + SinglePlayPicArea.DEFAULT_PIC_WIDTH + AreaConst.FEED_INTERVAL;
        this.onClickListener = new SubAreaShell.OnAreaClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedPlayBarView.2
            @Override // com.qzone.module.feedcomponent.ui.SubAreaShell.OnAreaClickListener
            public void onAreaClicked(SubAreaShell subAreaShell, TextCell textCell) {
                if (textCell == null) {
                    if (FeedPlayBarView.this.onFeedElementClickListener == null) {
                        return;
                    }
                    subAreaShell.getType();
                    return;
                }
                FeedPlayBarView feedPlayBarView = FeedPlayBarView.this;
                com.qzone.proxy.feedcomponent.ui.g gVar = feedPlayBarView.onFeedElementClickListener;
                if (gVar != null) {
                    if (textCell instanceof UserNameCell) {
                        gVar.onClick(feedPlayBarView, FeedElement.FRIEND_NICKNAME, feedPlayBarView.feedPosition, ((UserNameCell) textCell).getUin());
                        return;
                    }
                    if (textCell instanceof UrlCell) {
                        UrlCell urlCell = (UrlCell) textCell;
                        if (urlCell.getAction() == 2) {
                            FeedPlayBarView feedPlayBarView2 = FeedPlayBarView.this;
                            com.qzone.proxy.feedcomponent.ui.g gVar2 = feedPlayBarView2.onFeedElementClickListener;
                            FeedElement feedElement = FeedElement.CONTENT;
                            int i162 = feedPlayBarView2.feedPosition;
                            gVar2.onClick(feedPlayBarView2, feedElement, i162, Integer.valueOf(i162));
                            return;
                        }
                        FeedPlayBarView feedPlayBarView3 = FeedPlayBarView.this;
                        feedPlayBarView3.onFeedElementClickListener.onClick(feedPlayBarView3, FeedElement.URL, feedPlayBarView3.feedPosition, new com.qzone.proxy.feedcomponent.model.e(urlCell.getUrl(), urlCell.post, FeedPlayBarView.this.feedPosition));
                        return;
                    }
                    if (textCell instanceof ColorTextCell) {
                        if (textCell.getType() == 5) {
                            FeedPlayBarView feedPlayBarView4 = FeedPlayBarView.this;
                            com.qzone.proxy.feedcomponent.ui.g gVar3 = feedPlayBarView4.onFeedElementClickListener;
                            FeedElement feedElement2 = FeedElement.CONTENT;
                            int i17 = feedPlayBarView4.feedPosition;
                            gVar3.onClick(feedPlayBarView4, feedElement2, i17, Integer.valueOf(i17));
                            return;
                        }
                        return;
                    }
                    FeedElement feedElement3 = FeedElement.NOTHING;
                    int i18 = feedPlayBarView.feedPosition;
                    gVar.onClick(feedPlayBarView, feedElement3, i18, Integer.valueOf(i18));
                }
            }
        };
        init();
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateScrolling() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setAlpha(int i3) {
    }
}
