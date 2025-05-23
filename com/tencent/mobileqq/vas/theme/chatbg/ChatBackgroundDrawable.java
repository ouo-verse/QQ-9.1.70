package com.tencent.mobileqq.vas.theme.chatbg;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ChatBackgroundDrawable extends BitmapDrawable {
    public int chatWindowHeight;
    private Bitmap mBitmap;
    private Rect mDrawRect;
    private final Paint mPaint;

    public ChatBackgroundDrawable(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
        this.mPaint = new Paint(2);
        this.mBitmap = null;
        this.mDrawRect = new Rect();
        this.mBitmap = bitmap;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            canvas.drawBitmap(this.mBitmap, this.mDrawRect, getBounds(), this.mPaint);
        }
    }

    protected Rect getImageDrawnRect(Rect rect) {
        Rect rect2;
        if (getBitmap() == null) {
            return this.mDrawRect;
        }
        int height = getBitmap().getHeight();
        int width = getBitmap().getWidth();
        if (rect == null) {
            return new Rect(0, 0, width, height);
        }
        QLog.d("chatbg", 1, "dstRect = " + rect);
        QLog.d("chatbg", 1, "img width = " + width + " img height = " + height);
        if (this.chatWindowHeight < rect.height()) {
            this.chatWindowHeight = rect.height();
        }
        if (this.chatWindowHeight / rect.width() >= height / width) {
            int width2 = rect.width() * height;
            int i3 = this.chatWindowHeight;
            int i16 = width2 / i3;
            int i17 = (int) ((width - i16) * 0.5d);
            if (i3 > rect.height()) {
                height = (getBitmap().getHeight() * rect.height()) / this.chatWindowHeight;
            }
            rect2 = new Rect(i17, 0, i16 + i17, height);
        } else {
            int height2 = (rect.height() * width) / rect.width();
            int width3 = (int) ((height - ((this.chatWindowHeight * width) / rect.width())) * 0.5d);
            rect2 = new Rect(0, width3, width, height2 + width3);
        }
        QLog.d("chatbg", 1, " result = " + rect2 + " chatWindowHeight " + this.chatWindowHeight);
        return rect2;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.mDrawRect = getImageDrawnRect(getBounds());
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
