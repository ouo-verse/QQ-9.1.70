package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.adapter.feedcomponent.r;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedRecommBarView extends View implements r, FeedChildView {
    public static FeedViewSection.SectionController controller = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedRecommBarView.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            return false;
        }
    };
    private int VIEW_HEIGHT;
    private int VIEW_WIDTH;
    private Paint mBarPaint;
    private String mBarTitle;
    private Rect mBarTitleRect;
    private Drawable mCloseIcon;
    private int mCloseIconSize;
    private Rect mIconRect;
    private Rect mTextBound;

    public FeedRecommBarView(Context context) {
        this(context, null);
    }

    private float getBaseLine(Rect rect, Paint paint) {
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        return ((((rect.bottom + rect.top) - fontMetricsInt.bottom) - fontMetricsInt.top) - 2) / 2.0f;
    }

    private boolean isInRect(float f16, float f17, Rect rect) {
        return ((float) rect.left) <= f16 && f16 <= ((float) rect.right) && ((float) rect.top) <= f17 && f17 <= ((float) rect.bottom);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = this.mBarTitleRect;
        int i3 = AreaConst.dp8;
        rect.left = i3;
        rect.top = (this.VIEW_HEIGHT / 2) - (this.mTextBound.height() / 2);
        this.mBarTitleRect.right = this.mTextBound.width() + i3;
        this.mBarTitleRect.bottom = (this.VIEW_HEIGHT / 2) + (this.mTextBound.height() / 2);
        canvas.drawText(this.mBarTitle, r2.left, getBaseLine(this.mBarTitleRect, this.mBarPaint), this.mBarPaint);
        Rect rect2 = this.mIconRect;
        int i16 = this.VIEW_WIDTH;
        int i17 = this.mCloseIconSize;
        rect2.left = (i16 - i3) - i17;
        int i18 = this.VIEW_HEIGHT;
        rect2.top = (i18 / 2) - (i17 / 2);
        rect2.right = i16 - i3;
        rect2.bottom = (i18 / 2) + (i17 / 2);
        this.mCloseIcon.setBounds(rect2);
        this.mCloseIcon.draw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        setMeasuredDimension(this.VIEW_WIDTH, this.VIEW_HEIGHT);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && isInRect(motionEvent.getX(), motionEvent.getY(), this.mIconRect)) {
            if (getVisibility() == 0) {
                setVisibility(4);
            } else {
                setVisibility(0);
            }
        }
        return true;
    }

    public FeedRecommBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.VIEW_WIDTH = FeedGlobalEnv.g().getScreenWidth();
        this.VIEW_HEIGHT = AreaConst.dp36;
        this.mBarTitle = "";
        this.mBarTitleRect = new Rect();
        this.mIconRect = new Rect();
        Paint paint = new Paint();
        this.mBarPaint = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mBarPaint.setTextSize(AreaConst.dp14);
        this.mBarPaint.setStrokeWidth(2.0f);
        this.mBarPaint.setColor(-16578534);
        this.mTextBound = new Rect();
        Paint paint2 = this.mBarPaint;
        String str = this.mBarTitle;
        paint2.getTextBounds(str, 0, str.length(), this.mTextBound);
        this.mCloseIcon = com.qzone.adapter.feedcomponent.j.g(726);
        this.mCloseIconSize = AreaConst.dp16;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedData(BusinessFeedData businessFeedData) {
        Drawable g16 = com.qzone.adapter.feedcomponent.j.g(726);
        this.mCloseIcon = g16;
        if (g16 != null) {
            postInvalidate();
        }
    }

    @Override // com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
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

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedPosition(int i3) {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
    }
}
