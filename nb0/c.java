package nb0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c extends ImageSpan {

    /* renamed from: d, reason: collision with root package name */
    private int f419608d;

    /* renamed from: e, reason: collision with root package name */
    private int f419609e;

    public c(@NonNull Drawable drawable) {
        super(drawable);
        this.f419608d = 0;
        this.f419609e = 0;
    }

    public void a(int i3, int i16) {
        this.f419608d = i3;
        this.f419609e = i16;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
        Drawable drawable = getDrawable();
        float height = (i19 - drawable.getBounds().height()) - ((i19 - i18) - paint.getFontMetricsInt().bottom);
        canvas.save();
        canvas.translate(f16 + this.f419608d, height);
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = getDrawable().getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            float f16 = fontMetrics.top - fontMetrics.ascent;
            float height = fontMetrics.descent - bounds.height();
            fontMetricsInt.ascent = (int) height;
            fontMetricsInt.top = (int) (height + f16);
        }
        return bounds.right + this.f419608d + this.f419609e;
    }

    public c(Drawable drawable, int i3) {
        super(drawable, i3);
        this.f419608d = 0;
        this.f419609e = 0;
    }
}
