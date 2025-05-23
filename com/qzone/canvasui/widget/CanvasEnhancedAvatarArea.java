package com.qzone.canvasui.widget;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasEnhancedAvatarArea extends CanvasAvatarArea {
    public static final int MASK_TYPE_GRAY_MASK = 2;
    public static final int MASK_TYPE_MORE = 1;
    public static final int MASK_TYPE_NONE = 0;
    private static Paint dotPaint;
    private static Drawable indicatorBgDrawable;
    private int maskType;

    public CanvasEnhancedAvatarArea(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        this.maskType = 0;
    }

    @Override // com.qzone.canvasui.widget.CanvasAvatarArea, com.qzone.canvasui.widget.AsyncCanvasImageArea, com.tencent.ditto.widget.DittoImageArea, com.tencent.ditto.area.DittoArea
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i3 = this.maskType;
        if (i3 != 1) {
            if (i3 == 2) {
                indicatorBgDrawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                indicatorBgDrawable.draw(canvas);
                return;
            }
            return;
        }
        indicatorBgDrawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        indicatorBgDrawable.draw(canvas);
        int measuredWidth = getMeasuredWidth() / 4;
        float measuredHeight = getMeasuredHeight() / 2;
        int i16 = AreaConst.f48747dp2;
        canvas.drawCircle(measuredWidth, measuredHeight, i16, dotPaint);
        canvas.drawCircle(r0 / 2, measuredHeight, i16, dotPaint);
        canvas.drawCircle(measuredWidth * 3, measuredHeight, i16, dotPaint);
    }

    public void setMaskType(int i3) {
        this.maskType = i3;
        if (i3 == 1) {
            if (indicatorBgDrawable == null) {
                indicatorBgDrawable = new ColorDrawable(Color.argb(77, 0, 0, 0));
            }
            if (dotPaint == null) {
                Paint paint = new Paint();
                dotPaint = paint;
                paint.setColor(-1);
                return;
            }
            return;
        }
        if (i3 == 2 && indicatorBgDrawable == null) {
            indicatorBgDrawable = new ColorDrawable(Color.parseColor("#4c4f7eff"));
        }
    }
}
