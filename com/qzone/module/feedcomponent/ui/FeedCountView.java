package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.module.feedcomponent.ui.SubAreaShell;
import com.qzone.proxy.feedcomponent.model.CellVisitorInfo;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedCountView extends View {
    SubAreaShell countShell;
    protected int feedPosition;
    protected boolean hasRemark;
    protected int mIndex;
    protected SubAreaShell.OnAreaClickListener onClickListener;
    protected com.qzone.proxy.feedcomponent.ui.g onFeedElementClickListener;
    int paddingTop;
    SubAreaShell touchingArea;
    CellVisitorInfo visitInfo;

    public FeedCountView(Context context) {
        super(context);
        this.onClickListener = new SubAreaShell.OnAreaClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedCountView.1
            @Override // com.qzone.module.feedcomponent.ui.SubAreaShell.OnAreaClickListener
            public void onAreaClicked(SubAreaShell subAreaShell, TextCell textCell) {
                if (FeedCountView.this.onFeedElementClickListener == null || subAreaShell.getType() != 30) {
                    return;
                }
                FeedCountView feedCountView = FeedCountView.this;
                feedCountView.onFeedElementClickListener.onClick(feedCountView, FeedElement.VISIT, feedCountView.feedPosition, feedCountView.visitInfo);
            }
        };
    }

    SubAreaShell findArea(float f16, float f17) {
        return this.countShell;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setOnFeedElementClickListener(null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        if (this.countShell != null) {
            canvas.translate(0.0f, this.paddingTop);
            this.countShell.draw(canvas, null);
            canvas.translate(0.0f, this.countShell.getHeight());
        }
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        int height;
        SubAreaShell subAreaShell = this.countShell;
        int i18 = 0;
        if (subAreaShell != null) {
            int i19 = this.paddingTop + 0;
            subAreaShell.setTop(i19);
            if (!this.hasRemark) {
                i18 = this.countShell.getWidth();
                height = this.countShell.getHeight();
            } else {
                i18 = this.countShell.getWidth();
                height = this.countShell.getHeight();
            }
            i17 = height + i19;
        } else {
            i17 = 0;
        }
        setMeasuredDimension(i18, i17);
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
        if (findArea != null) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.offsetLocation(0.0f, findArea.getTop() * (-1));
            boolean onTouchEvent = findArea.onTouchEvent(obtain);
            obtain.recycle();
            if (onTouchEvent) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    void recycleShell() {
        SubAreaShell subAreaShell = this.countShell;
        if (subAreaShell != null) {
            SubAreaShell.recycle(subAreaShell);
            this.hasRemark = false;
            this.countShell = null;
        }
    }

    void recycleShellCache() {
        if (this.visitInfo != null) {
            AreaManager.getInstance().removeAreaFromCache(this.visitInfo.unikey);
            this.visitInfo = null;
        }
    }

    public void reset() {
        recycleShell();
        this.hasRemark = false;
        this.touchingArea = null;
        recycleShellCache();
    }

    public void setFeedPosition(int i3, int i16) {
        this.feedPosition = i3;
        this.mIndex = i16;
        setTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE), Integer.valueOf(i16));
    }

    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.onFeedElementClickListener = gVar;
    }

    public void setPaddingTop(int i3) {
        this.paddingTop = i3;
    }

    public FeedCountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.onClickListener = new SubAreaShell.OnAreaClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedCountView.1
            @Override // com.qzone.module.feedcomponent.ui.SubAreaShell.OnAreaClickListener
            public void onAreaClicked(SubAreaShell subAreaShell, TextCell textCell) {
                if (FeedCountView.this.onFeedElementClickListener == null || subAreaShell.getType() != 30) {
                    return;
                }
                FeedCountView feedCountView = FeedCountView.this;
                feedCountView.onFeedElementClickListener.onClick(feedCountView, FeedElement.VISIT, feedCountView.feedPosition, feedCountView.visitInfo);
            }
        };
    }

    public FeedCountView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.onClickListener = new SubAreaShell.OnAreaClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedCountView.1
            @Override // com.qzone.module.feedcomponent.ui.SubAreaShell.OnAreaClickListener
            public void onAreaClicked(SubAreaShell subAreaShell, TextCell textCell) {
                if (FeedCountView.this.onFeedElementClickListener == null || subAreaShell.getType() != 30) {
                    return;
                }
                FeedCountView feedCountView = FeedCountView.this;
                feedCountView.onFeedElementClickListener.onClick(feedCountView, FeedElement.VISIT, feedCountView.feedPosition, feedCountView.visitInfo);
            }
        };
    }
}
