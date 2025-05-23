package com.qzone.canvasui.widget;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.ui.SubArea;
import com.qzone.module.feedcomponent.ui.TimeDelArea;
import com.qzone.module.feedcomponent.ui.ViewArea;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;

/* compiled from: P */
/* loaded from: classes39.dex */
public class TimeCountDownArea extends DittoArea implements ViewArea.OnAreaClickedListener, SubArea.ViewHost {
    private TimeDelArea mTimeDelArea;

    public TimeCountDownArea(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        TimeDelArea timeDelArea = new TimeDelArea();
        this.mTimeDelArea = timeDelArea;
        timeDelArea.setTextSize(AreaConst.thirdTextSize);
        this.mTimeDelArea.setTextColor(j.F());
        this.mTimeDelArea.setMaxLine(1);
        this.mTimeDelArea.setViewHost(this);
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea.ViewHost
    public View getAttachedView() {
        Object obj = this.mHost;
        if (obj instanceof View) {
            return (View) obj;
        }
        return null;
    }

    @Override // com.tencent.ditto.area.DittoArea, com.tencent.ditto.area.DittoElement, com.qzone.module.feedcomponent.ui.SubArea.ViewHost
    public void invalidateDelayed(long j3) {
        this.mMainHandler.postDelayed(new Runnable() { // from class: com.qzone.canvasui.widget.TimeCountDownArea.1
            @Override // java.lang.Runnable
            public void run() {
                TimeCountDownArea.this.invalidate();
            }
        }, j3);
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea.OnAreaClickedListener
    public void onAreaClicked(ViewArea viewArea, TextCell textCell) {
        DittoArea.ClickListener clickListener = this.clickListener;
        if (clickListener != null) {
            clickListener.onClick(this, null, textCell);
        }
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onDraw(Canvas canvas) {
        this.mTimeDelArea.draw(canvas, null);
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onMeasure(int i3, int i16) {
        this.mTimeDelArea.measure(i3, i16);
        setMeasuredDimension(this.mTimeDelArea.getWidth(), this.mTimeDelArea.getMeasuredHeight());
    }

    @Override // com.tencent.ditto.area.DittoArea
    public boolean onTouchEvent(MotionEvent motionEvent) {
        TimeDelArea timeDelArea = this.mTimeDelArea;
        if (timeDelArea != null) {
            return timeDelArea.onTouchEvent(motionEvent, this, this.longClickListener != null);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setTime(BusinessFeedData businessFeedData, long j3) {
        if (businessFeedData != null && businessFeedData.getCellTheme() != null) {
            this.mTimeDelArea.setTextColor(businessFeedData.getCellTheme().minorForeColor);
        }
        this.mTimeDelArea.setFeedDelTime(j3);
    }
}
