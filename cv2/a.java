package cv2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends ImageSpan {

    /* renamed from: d, reason: collision with root package name */
    private int f391894d;

    /* renamed from: e, reason: collision with root package name */
    private int f391895e;

    public a(Drawable drawable, int i3, int i16) {
        super(drawable);
        if (drawable.getBounds().right == 0 && drawable.getBounds().bottom == 0) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.f391894d = i3;
        this.f391895e = i16;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint) {
        try {
            Drawable drawable = getDrawable();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int i26 = ((((fontMetricsInt.descent + i18) + i18) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2);
            canvas.save();
            if (f16 > 0.0f) {
                canvas.translate(f16 + this.f391894d, i26);
            } else {
                canvas.translate(f16, i26);
            }
            drawable.draw(canvas);
            canvas.restore();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return this.f391894d + super.getSize(paint, charSequence, i3, i16, fontMetricsInt) + this.f391895e;
    }
}
