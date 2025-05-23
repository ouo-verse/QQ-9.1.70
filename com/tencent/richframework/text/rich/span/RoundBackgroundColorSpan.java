package com.tencent.richframework.text.rich.span;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.helpers.QCircleSkinHelper;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RoundBackgroundColorSpan extends ReplacementSpan {
    private static final int RADIUS = ImmersiveUtils.dpToPx(2.0f);
    private int bgColor;
    private Drawable mDrawable;
    private RectF rectF = new RectF();
    private int textColor;

    public RoundBackgroundColorSpan(int i3, int i16) {
        this.bgColor = QCircleSkinHelper.getInstance().getColor(i3);
        this.textColor = QCircleSkinHelper.getInstance().getColor(i16);
    }

    private void drawDrawable(@NonNull Canvas canvas, @NonNull Paint paint, float f16, int i3, Bitmap bitmap, Rect rect) {
        RectF rectF = new RectF();
        float dpToPx = f16 - ImmersiveUtils.dpToPx(12.0f);
        rectF.left = dpToPx;
        rectF.right = dpToPx + rect.right;
        float f17 = i3;
        rectF.bottom = f17;
        rectF.top = f17 - rect.bottom;
        QLog.d("rbgcs", 2, "[drawDrawable] bitmapDrawable.getBitmap() = " + bitmap + ",drawableRectF =" + rectF + ",rect =" + rect);
        canvas.drawBitmap(bitmap, (Rect) null, rectF, paint);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint) {
        int i26;
        Drawable drawable;
        StringBuilder sb5 = new StringBuilder(charSequence.toString());
        paint.setColor(this.bgColor);
        paint.setTextSize(ImmersiveUtils.dpToPx(14.0f));
        if (f16 == 0.0f && this.mDrawable != null) {
            canvas.translate(ImmersiveUtils.dpToPx(16.0f), 0.0f);
        }
        if (this.mDrawable != null) {
            i26 = ImmersiveUtils.dpToPx(16.0f);
        } else {
            i26 = 0;
        }
        RectF rectF = this.rectF;
        rectF.left = f16 - i26;
        float f17 = i18;
        rectF.top = paint.ascent() + f17;
        this.rectF.right = f16 + ((int) paint.measureText(charSequence, i3, i16)) + ImmersiveUtils.dpToPx(6.0f);
        this.rectF.bottom = paint.descent() + f17;
        RectF rectF2 = this.rectF;
        int i27 = RADIUS;
        canvas.drawRoundRect(rectF2, i27, i27, paint);
        paint.setColor(this.textColor);
        paint.setFakeBoldText(true);
        canvas.drawText(sb5, i3, i16, f16 + i27, f17, paint);
        if (f16 == 0.0f && (drawable = this.mDrawable) != null) {
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                drawDrawable(canvas, paint, f16, i18, bitmapDrawable.getBitmap(), bitmapDrawable.getBounds());
            } else if (drawable instanceof SkinnableBitmapDrawable) {
                SkinnableBitmapDrawable skinnableBitmapDrawable = (SkinnableBitmapDrawable) drawable;
                drawDrawable(canvas, paint, f16, i18, skinnableBitmapDrawable.getBitmap(), skinnableBitmapDrawable.getBounds());
            }
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return ((int) paint.measureText(charSequence, i3, i16)) + ImmersiveUtils.dpToPx(6.0f);
    }

    public void setDrawable(Drawable drawable) {
        this.mDrawable = drawable;
    }
}
