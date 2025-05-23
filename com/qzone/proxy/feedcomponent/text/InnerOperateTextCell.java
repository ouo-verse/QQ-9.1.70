package com.qzone.proxy.feedcomponent.text;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;

/* compiled from: P */
/* loaded from: classes39.dex */
public class InnerOperateTextCell extends ColorTextCell {
    public InnerOperateTextCell(int i3, String str) {
        super(i3, str);
    }

    @Override // com.qzone.proxy.feedcomponent.text.ColorTextCell, com.qzone.proxy.feedcomponent.text.TextCell
    public void draw(Canvas canvas, Paint paint, int i3, Rect rect, int i16, int i17, Bitmap bitmap) {
        if (paint instanceof d) {
            d dVar = (d) paint;
            if (dVar.i() && !dVar.f50712d) {
                return;
            }
        }
        Shader shader = paint.getShader();
        paint.setShader(null);
        paint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        float textSize = paint.getTextSize();
        paint.setTextSize(this.fontSize);
        int i18 = this.linkColor;
        super.draw(canvas, paint, i3, rect, i18, i18, bitmap);
        paint.setTextSize(textSize);
        paint.setShader(shader);
        paint.setShadowLayer(this.mShadowRadius, this.mShadowX, this.mShadowY, this.mShadowColor);
    }
}
