package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.qzone.adapter.feedcomponent.r;
import com.qzone.module.feedcomponent.ui.SubAreaShell;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.CellPokeLike;
import com.qzone.proxy.feedcomponent.model.ClickedPoint;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.component.media.image.ImageUrl;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GuideCommentBar extends View implements r {
    private static final String COMMENT_GUIDE_BAR_CONTENT_DESCRIPTION = "\u8bc4\u8bba\u7f16\u8f91\u6846";
    int feedPosition;
    int mAreaHeight;
    GuideCommentArea mGuideArea;
    SubAreaShell mGuideAreaShell;
    protected SubAreaShell.OnAreaClickListener onClickListener;
    protected com.qzone.proxy.feedcomponent.ui.g onFeedElementClickListener;
    protected Paint paint;
    GuideCommentBarTouchHelper touchHelper;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class GuideCommentBarTouchHelper extends ExploreByTouchHelper {
        public GuideCommentBarTouchHelper(View view) {
            super(view);
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float f16, float f17) {
            GuideCommentArea guideCommentArea = GuideCommentBar.this.mGuideArea;
            return (guideCommentArea.commentIconVisibility == 0 && guideCommentArea.getRCRect().contains(f16, f17)) ? 2 : 1;
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int i3, int i16, Bundle bundle) {
            if (Build.VERSION.SDK_INT >= 26 || i16 != 16) {
                return false;
            }
            GuideCommentBar.this.onAreaClick(i3);
            return true;
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected void onPopulateEventForVirtualView(int i3, AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setContentDescription(getDescriptionForIndex(i3));
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int i3, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Rect rect;
            accessibilityNodeInfoCompat.setContentDescription(getDescriptionForIndex(i3));
            accessibilityNodeInfoCompat.addAction(16);
            if (i3 == 2) {
                rect = GuideCommentArea.iconRect;
            } else {
                rect = new Rect(0, 0, com.qzone.adapter.feedcomponent.b.c() - GuideCommentArea.iconRect.width(), AreaConst.DEFAULT_GUIDE_HEIGHT);
            }
            if (rect != null && rect.isEmpty()) {
                rect = new Rect(0, 0, 1, 1);
                com.qzone.proxy.feedcomponent.b.e("GuideCommentBar", "virtual bound is empty");
            }
            accessibilityNodeInfoCompat.setBoundsInParent(rect);
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> list) {
            list.add(1);
            GuideCommentArea guideCommentArea = GuideCommentBar.this.mGuideArea;
            if (guideCommentArea.commentIconVisibility == 0) {
                if (guideCommentArea.mNeedToShowRedPocket || guideCommentArea.mNeedToShowRapidCommentInBox || guideCommentArea.mShowGiftIcon || guideCommentArea.mNeedToShowDoodle) {
                    list.add(2);
                }
            }
        }

        String getDescriptionForIndex(int i3) {
            if (i3 == 2) {
                return GuideCommentBar.this.mGuideArea.getContentDescription();
            }
            return GuideCommentBar.COMMENT_GUIDE_BAR_CONTENT_DESCRIPTION;
        }
    }

    public GuideCommentBar(Context context) {
        super(context);
        this.onClickListener = new SubAreaShell.OnAreaClickListener() { // from class: com.qzone.module.feedcomponent.ui.GuideCommentBar.1
            @Override // com.qzone.module.feedcomponent.ui.SubAreaShell.OnAreaClickListener
            public void onAreaClicked(SubAreaShell subAreaShell, TextCell textCell) {
                if (GuideCommentBar.this.onFeedElementClickListener == null) {
                    return;
                }
                FeedElement feedElement = (FeedElement) subAreaShell.getData();
                ClickedPoint clickedPoint = new ClickedPoint(subAreaShell.getLeft(), subAreaShell.getTop(), 0, 0, subAreaShell.getWidth(), subAreaShell.getHeight());
                GuideCommentBar guideCommentBar = GuideCommentBar.this;
                guideCommentBar.onFeedElementClickListener.onClick(guideCommentBar, feedElement, guideCommentBar.feedPosition, clickedPoint);
            }
        };
        this.paint = new Paint(1);
        init();
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        GuideCommentBarTouchHelper guideCommentBarTouchHelper;
        return (com.qzone.adapter.feedcomponent.i.H().S0() && (guideCommentBarTouchHelper = this.touchHelper) != null && guideCommentBarTouchHelper.dispatchHoverEvent(motionEvent)) || super.dispatchHoverEvent(motionEvent);
    }

    public ClickedPoint getGuideAreaClickedPoint() {
        return new ClickedPoint(this.mGuideAreaShell.getLeft(), this.mGuideAreaShell.getTop(), 0, 0, this.mGuideAreaShell.getWidth(), this.mGuideAreaShell.getHeight());
    }

    void init() {
        setTextSize(AreaConst.commentTextSize);
        GuideCommentArea guideCommentArea = new GuideCommentArea();
        this.mGuideArea = guideCommentArea;
        guideCommentArea.measure(com.qzone.adapter.feedcomponent.b.c(), 0);
        this.mGuideArea.setRapidIconVisibility(0);
        SubAreaShell obtain = SubAreaShell.obtain(this.mGuideArea);
        this.mGuideAreaShell = obtain;
        obtain.setOnClickListener(this.onClickListener);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(getPaddingLeft(), getPaddingTop());
        this.mGuideArea.draw(canvas, this.paint);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        if (com.qzone.adapter.feedcomponent.i.H().S0() && this.touchHelper == null) {
            GuideCommentBarTouchHelper guideCommentBarTouchHelper = new GuideCommentBarTouchHelper(this);
            this.touchHelper = guideCommentBarTouchHelper;
            ViewCompat.setAccessibilityDelegate(this, guideCommentBarTouchHelper);
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        int defaultSize = View.getDefaultSize(getSuggestedMinimumWidth(), i3);
        int height = this.mGuideArea.getHeight();
        this.mAreaHeight = height;
        setMeasuredDimension(defaultSize, height + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(0.0f, this.mGuideAreaShell.getTop() * (-1));
        boolean onTouchEvent = this.mGuideAreaShell.onTouchEvent(obtain);
        obtain.recycle();
        return onTouchEvent;
    }

    public void setCellPokeLike(CellPokeLike cellPokeLike) {
        this.mGuideArea.setCellPokeLike(cellPokeLike);
    }

    public void setCommentPokeLike(boolean z16) {
        this.mGuideArea.setCommentPokeLike(z16);
    }

    public void setEnableRedPocket(boolean z16) {
        this.mGuideArea.setEnableRedPocket(z16);
    }

    public void setFeedPosition(int i3, int i16) {
        this.feedPosition = i3;
    }

    public void setGuideCommentRedPocketIconUrl(String str, ImageUrl imageUrl) {
        this.mGuideArea.setGuideCommentRedPocketIconUrl(str, imageUrl);
    }

    public void setHintText(String str) {
        this.mGuideArea.setHintText(str);
    }

    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.onFeedElementClickListener = gVar;
    }

    public void setRapidIconVisibility(int i3) {
        this.mGuideArea.setRapidIconVisibility(i3);
    }

    public void setShowDoodleIcon(boolean z16) {
        this.mGuideArea.setShowDoodleIcon(z16);
    }

    public void setShowGiftIcon(boolean z16) {
        this.mGuideArea.setShowGiftIcon(z16);
    }

    public void setShowRapidCommentInBox(boolean z16) {
        this.mGuideArea.setShowRapidCommentInBox(z16);
    }

    public void setShowRedPocket(boolean z16) {
        this.mGuideArea.setShowRedPocket(z16);
    }

    public void setTextSize(float f16) {
        float spValue = FeedGlobalEnv.g().getSpValue(f16);
        if (spValue != this.paint.getTextSize()) {
            this.paint.setTextSize(spValue);
        }
    }

    public void setTrans(int i3) {
        this.mGuideArea.setTrans(i3);
    }

    public void setUseWhiteBg(boolean z16) {
        this.mGuideArea.setUseWhiteBg(z16);
    }

    void onAreaClick(int i3) {
        super.playSoundEffect(0);
        GuideCommentBarTouchHelper guideCommentBarTouchHelper = this.touchHelper;
        if (guideCommentBarTouchHelper == null) {
            return;
        }
        guideCommentBarTouchHelper.invalidateVirtualView(i3);
        this.touchHelper.sendEventForVirtualView(i3, 1);
    }

    @Override // com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        this.onFeedElementClickListener = null;
        this.onClickListener = null;
        GuideCommentArea guideCommentArea = this.mGuideArea;
        if (guideCommentArea != null) {
            guideCommentArea.setCommentPokeLike(false);
        }
    }

    public GuideCommentBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.onClickListener = new SubAreaShell.OnAreaClickListener() { // from class: com.qzone.module.feedcomponent.ui.GuideCommentBar.1
            @Override // com.qzone.module.feedcomponent.ui.SubAreaShell.OnAreaClickListener
            public void onAreaClicked(SubAreaShell subAreaShell, TextCell textCell) {
                if (GuideCommentBar.this.onFeedElementClickListener == null) {
                    return;
                }
                FeedElement feedElement = (FeedElement) subAreaShell.getData();
                ClickedPoint clickedPoint = new ClickedPoint(subAreaShell.getLeft(), subAreaShell.getTop(), 0, 0, subAreaShell.getWidth(), subAreaShell.getHeight());
                GuideCommentBar guideCommentBar = GuideCommentBar.this;
                guideCommentBar.onFeedElementClickListener.onClick(guideCommentBar, feedElement, guideCommentBar.feedPosition, clickedPoint);
            }
        };
        this.paint = new Paint(1);
        init();
    }
}
