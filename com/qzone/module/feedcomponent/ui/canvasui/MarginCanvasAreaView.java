package com.qzone.module.feedcomponent.ui.canvasui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.canvasui.widget.QzoneCanvasAreaView;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.utils.DittoLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class MarginCanvasAreaView extends QzoneCanvasAreaView {
    public MarginCanvasAreaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView, com.tencent.ditto.DittoAreaView, android.view.View
    public void onDraw(Canvas canvas) {
        int saveCount = canvas.getSaveCount();
        canvas.save();
        if (getCanvasArea() != null) {
            canvas.save();
            canvas.translate(getCanvasArea().getLeft(), getCanvasArea().getTop());
            getCanvasArea().draw(canvas);
            canvas.restore();
        }
        canvas.restoreToCount(saveCount);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ditto.DittoAreaView, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        try {
            if (getCanvasArea() != null) {
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                LayoutAttrSet layoutAttr = getCanvasArea().getLayoutAttr();
                getCanvasArea().layout(paddingLeft + layoutAttr.leftMargin, paddingTop + layoutAttr.topMargin, ((i17 - i3) - getPaddingRight()) - layoutAttr.rightMargin, ((i18 - i16) - getPaddingBottom()) - layoutAttr.bottomMargin);
            }
        } catch (Exception e16) {
            DittoLog.e("layout error");
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ditto.DittoAreaView, android.view.View
    public void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        if (getCanvasArea() != null) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            LayoutAttrSet layoutAttr = getCanvasArea().getLayoutAttr();
            getCanvasArea().measure(ViewGroup.getChildMeasureSpec(i3, layoutAttr.leftMargin + paddingLeft + paddingRight + layoutAttr.rightMargin, layoutAttr.width), ViewGroup.getChildMeasureSpec(i16, paddingTop + paddingBottom + layoutAttr.topMargin + layoutAttr.bottomMargin, layoutAttr.height));
            i17 = getCanvasArea().getMeasuredWidth() + paddingLeft + paddingRight + layoutAttr.rightMargin + layoutAttr.leftMargin;
            i18 = getCanvasArea().getMeasuredHeight() + paddingTop + paddingBottom + layoutAttr.topMargin + layoutAttr.bottomMargin;
        } else {
            i17 = 0;
            i18 = 0;
        }
        int mode = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i16);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824) {
            size = Math.max(i18, getSuggestedMinimumHeight());
        }
        if (mode2 != 1073741824) {
            size2 = Math.max(i17, getSuggestedMinimumWidth());
        }
        setMeasuredDimension(size2, size);
    }
}
