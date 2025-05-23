package nb0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d extends ImageSpan {

    /* renamed from: d, reason: collision with root package name */
    private int f419610d;

    /* renamed from: e, reason: collision with root package name */
    private int f419611e;

    public d(@NonNull Drawable drawable) {
        super(drawable);
        this.f419610d = 0;
        this.f419611e = 0;
    }

    public void a(int i3, int i16) {
        this.f419610d = i3;
        this.f419611e = i16;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
        Drawable drawable = getDrawable();
        canvas.save();
        canvas.translate(f16 + this.f419610d, (((i19 - i17) - drawable.getBounds().bottom) / 2) + i17);
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = getDrawable().getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i17 = fontMetricsInt2.bottom - fontMetricsInt2.top;
            int i18 = (bounds.bottom - bounds.top) / 2;
            int i19 = i17 / 4;
            int i26 = i18 - i19;
            int i27 = -(i18 + i19);
            fontMetricsInt.ascent = i27;
            fontMetricsInt.top = i27;
            fontMetricsInt.bottom = i26;
            fontMetricsInt.descent = i26;
        }
        return bounds.right + this.f419610d + this.f419611e;
    }

    public d(Drawable drawable, int i3) {
        super(drawable, i3);
        this.f419610d = 0;
        this.f419611e = 0;
    }
}
