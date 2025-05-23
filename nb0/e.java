package nb0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e extends ImageSpan {

    /* renamed from: d, reason: collision with root package name */
    private int f419612d;

    /* renamed from: e, reason: collision with root package name */
    private int f419613e;

    /* renamed from: f, reason: collision with root package name */
    private int f419614f;

    public e(@NonNull Drawable drawable) {
        super(drawable);
        this.f419612d = 0;
        this.f419613e = 0;
        this.f419614f = 0;
    }

    public void a(int i3) {
        this.f419612d = i3;
        this.f419613e = i3;
    }

    public void b(int i3) {
        this.f419614f = i3;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
        Drawable drawable = getDrawable();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f17 = i19 - i18;
        float f18 = fontMetrics.bottom;
        float f19 = fontMetrics.ascent;
        float f26 = fontMetrics.top;
        canvas.save();
        canvas.translate(f16 + this.f419612d, (((((f26 - f18) - (i17 - i19)) + (f19 - f26)) + this.f419614f) - (f17 - f18)) + i17);
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = getDrawable().getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            float f16 = fontMetrics.descent - fontMetrics.bottom;
            float height = fontMetrics.ascent + bounds.height();
            fontMetricsInt.descent = (int) height;
            fontMetricsInt.bottom = (int) (height + f16);
        }
        return bounds.right + this.f419612d + this.f419613e;
    }
}
