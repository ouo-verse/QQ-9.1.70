package com.qzone.proxy.feedcomponent.text;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class SystemEmoCell extends TextCell {
    public Drawable emoDrawable;
    public int mHeight;
    public int mWidth;

    public SystemEmoCell(String str, int i3) {
        super(0, str);
        this.mHeight = i3;
        this.mWidth = i3;
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public void draw(Canvas canvas, Paint paint, int i3, Rect rect, int i16, int i17, Bitmap bitmap) {
        if (!this.useDefaultFont && (paint instanceof d)) {
            d dVar = (d) paint;
            if (dVar.i() && !dVar.f50712d) {
                return;
            }
        }
        Drawable drawable = this.emoDrawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, this.mWidth, this.mHeight);
            canvas.save();
            canvas.translate(rect.left, (rect.top - 1) + ((i3 - this.emoDrawable.getBounds().height()) / 2));
            this.emoDrawable.draw(canvas);
            canvas.restore();
            return;
        }
        super.draw(canvas, paint, i3, rect, i16, i17, bitmap);
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public int getHeight(Paint paint) {
        return this.mHeight;
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public float getWidth(Paint paint) {
        return this.mWidth;
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public int getWidths(Paint paint, int i3, int i16, float[] fArr) {
        fArr[0] = this.mWidth;
        return 1;
    }

    public void reloadDrawable(TextLayoutBase textLayoutBase, com.qzone.proxy.feedcomponent.text.font.a aVar) {
        EmoObjectPool.f().q(this, textLayoutBase, aVar);
    }

    public SystemEmoCell(String str, int i3, Drawable drawable) {
        super(0, str);
        this.emoDrawable = drawable;
        if (drawable == null || i3 <= 0) {
            return;
        }
        this.mHeight = i3;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth > 0 && intrinsicHeight > 0) {
            i3 = (int) ((i3 * intrinsicWidth) / intrinsicHeight);
        }
        this.mWidth = i3;
    }
}
