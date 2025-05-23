package com.qzone.proxy.feedcomponent.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class NetEmoCell extends EmoCell {
    private static final long serialVersionUID = -218748061751747788L;
    public String emoUrl;
    public int mHeight;
    public int mLeftPadding;
    public int mRightPadding;
    public int mWidth;

    public NetEmoCell(String str) {
        super(str);
    }

    @Override // com.qzone.proxy.feedcomponent.text.EmoCell, com.qzone.proxy.feedcomponent.text.TextCell
    public void draw(Canvas canvas, Paint paint, int i3, int i16, int i17, int i18) {
        Drawable emoDrawable = getEmoDrawable();
        if ((i18 <= 0 || i18 >= this.rect.right) && emoDrawable != null) {
            emoDrawable.setBounds(0, 0, this.mWidth, this.mHeight);
            int i19 = this.rect.left + this.mLeftPadding;
            int height = (r4.top - 1) + ((i3 - emoDrawable.getBounds().height()) / 2);
            canvas.save();
            canvas.translate(i19, height);
            emoDrawable.draw(canvas);
            canvas.restore();
        }
    }

    @Override // com.qzone.proxy.feedcomponent.text.EmoCell, com.qzone.proxy.feedcomponent.text.TextCell
    public int getHeight(Paint paint) {
        Drawable drawable = this.emoDrawable;
        if (drawable != null) {
            return drawable.getBounds().height();
        }
        return this.mHeight;
    }

    @Override // com.qzone.proxy.feedcomponent.text.EmoCell, com.qzone.proxy.feedcomponent.text.TextCell
    public float getWidth(Paint paint) {
        int i3;
        Drawable drawable = this.emoDrawable;
        if (drawable != null) {
            i3 = drawable.getBounds().width() + this.mLeftPadding + this.mRightPadding;
        } else {
            i3 = this.mWidth;
        }
        return i3;
    }

    public NetEmoCell(String str, Drawable drawable) {
        super(str, drawable);
    }
}
