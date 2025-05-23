package com.qzone.canvasui.widget;

import android.graphics.Canvas;
import android.view.View;
import com.qzone.module.feedcomponent.ui.SubArea;
import com.qzone.module.feedcomponent.ui.TitleAttachArea;
import com.qzone.module.feedcomponent.ui.ViewArea;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasAttachArea extends DittoArea implements ViewArea.OnAreaClickedListener, SubArea.ViewHost {
    private TitleAttachArea mAttachArea;

    public CanvasAttachArea(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        this.mAttachArea = new TitleAttachArea();
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea.ViewHost
    public View getAttachedView() {
        Object obj = this.mHost;
        if (obj instanceof View) {
            return (View) obj;
        }
        return null;
    }

    @Override // com.tencent.ditto.area.DittoArea
    public int getType() {
        return this.mAttachArea.getType();
    }

    @Override // com.tencent.ditto.area.DittoArea, com.tencent.ditto.area.DittoElement, com.qzone.module.feedcomponent.ui.SubArea.ViewHost
    public void invalidateDelayed(long j3) {
        this.mMainHandler.postDelayed(new Runnable() { // from class: com.qzone.canvasui.widget.CanvasAttachArea.1
            @Override // java.lang.Runnable
            public void run() {
                CanvasAttachArea.this.invalidate();
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
        this.mAttachArea.draw(canvas, null);
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onMeasure(int i3, int i16) {
        this.mAttachArea.measure(i3, i16);
        setMeasuredDimension(this.mAttachArea.getWidth(), this.mAttachArea.getHeight());
    }

    public void setFeedData(BusinessFeedData businessFeedData, boolean z16) {
        this.mAttachArea.setFeedData(businessFeedData, z16);
        setTag(Integer.valueOf(this.mAttachArea.getType()));
    }
}
