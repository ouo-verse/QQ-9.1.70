package be2;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private final Drawable f28307a;

    /* renamed from: b, reason: collision with root package name */
    private final RectF f28308b = new RectF();

    /* renamed from: c, reason: collision with root package name */
    private final Path f28309c = new Path();

    public a(Drawable drawable) {
        this.f28307a = drawable;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        int save = canvas.save();
        canvas.clipPath(this.f28309c);
        this.f28307a.setBounds(getBounds());
        this.f28307a.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f28307a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f28308b.set(0.0f, 0.0f, rect.width(), rect.height());
        this.f28309c.reset();
        float width = rect.width() / 2.0f;
        this.f28309c.addRoundRect(this.f28308b, width, width, Path.Direction.CW);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f28307a.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f28307a.setColorFilter(colorFilter);
    }
}
