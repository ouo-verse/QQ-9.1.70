package com.qzone.canvasui.widget;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes39.dex */
public class LineArea extends AsyncCanvasImageArea {
    private PictureItem pictureItem;

    public LineArea(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
    }

    @Override // com.qzone.canvasui.widget.AsyncCanvasImageArea, com.tencent.ditto.widget.DittoImageArea, com.tencent.ditto.area.DittoArea
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStrokeWidth(2.0f);
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#9E9E9E"));
        canvas.drawLine(0.0f, ViewUtils.dpToPx(3.5f), 0.0f, getHeight() - ViewUtils.dpToPx(2.0f), paint);
    }

    @Override // com.tencent.ditto.widget.DittoImageArea, com.tencent.ditto.area.DittoArea
    public void onLayout(int i3, int i16, int i17, int i18) {
        super.onLayout(i3, i16, i17, i18);
    }

    @Override // com.tencent.ditto.widget.DittoImageArea, com.tencent.ditto.area.DittoArea
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
    }
}
