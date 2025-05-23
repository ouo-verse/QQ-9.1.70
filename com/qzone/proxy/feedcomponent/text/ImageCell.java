package com.qzone.proxy.feedcomponent.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ImageCell extends TextCell {
    private static final long serialVersionUID = -3999833992135197771L;
    public Drawable emoDrawable;
    private Context mContext;
    public int resId;

    public ImageCell() {
        this.type = 0;
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public boolean canBreak() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public void draw(Canvas canvas, Paint paint, int i3, Rect rect, int i16, int i17, Bitmap bitmap) {
        if (paint instanceof d) {
            d dVar = (d) paint;
            if (dVar.i() && !dVar.f50712d) {
                return;
            }
        }
        Drawable emoDrawable = getEmoDrawable();
        if (emoDrawable != null) {
            canvas.translate(rect.left, (rect.top - 1) + ((i3 - emoDrawable.getBounds().height()) / 2));
            emoDrawable.draw(canvas);
            canvas.translate(-r5, -r4);
        }
    }

    public Drawable getEmoDrawable() {
        Drawable drawable = this.emoDrawable;
        return drawable != null ? drawable : this.mContext.getResources().getDrawable(this.resId);
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public int getHeight(Paint paint) {
        Drawable emoDrawable = getEmoDrawable();
        if (emoDrawable == null) {
            return 0;
        }
        return emoDrawable.getBounds().height();
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public int getLength() {
        return 1;
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public String getText() {
        if (TextUtils.isEmpty(this.text)) {
            return "[image]";
        }
        return this.text;
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public float getWidth(Paint paint) {
        if (getEmoDrawable() == null) {
            return 0.0f;
        }
        return r2.getBounds().width() + ViewUtils.dip2px(4.0f);
    }

    public ImageCell(int i3, Context context) {
        this.mContext = context;
        this.type = 0;
        this.resId = i3;
        this.emoDrawable = context.getResources().getDrawable(i3);
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.f158707mw);
        this.emoDrawable.setBounds(0, 0, dimensionPixelOffset, dimensionPixelOffset);
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public boolean fadedDraw(Canvas canvas, Paint paint, int i3, Rect rect, int i16, int i17, Bitmap bitmap, int i18, long j3) {
        double d16 = j3;
        int floor = ((int) Math.floor(d16 / TextCell.FADE_START_INTERVAL)) - i18;
        int alpha = paint.getAlpha();
        if (floor > 0) {
            draw(canvas, paint, i3, rect, i16, i17, bitmap);
            return false;
        }
        String a16 = com.qzone.util.l.a(R.string.ne8);
        paint.measureText(a16 + a16);
        paint.measureText(a16);
        double d17 = d16 - (((double) (i18 + 1)) * TextCell.FADE_START_INTERVAL);
        if (d17 <= 0.0d) {
            paint.setAlpha(alpha);
            return true;
        }
        double d18 = TextCell.FADE_SCALE;
        double d19 = (d17 % d18) / d18;
        int i19 = (int) (255.0d * d19);
        int i26 = ((int) ((1.0d - d19) * TextCell.FADE_LENGTH)) + rect.left;
        Rect rect2 = new Rect(rect);
        rect2.left = i26;
        paint.setAlpha(i19);
        draw(canvas, paint, i3, rect2, i16, i17, bitmap);
        paint.setAlpha(alpha);
        return false;
    }
}
