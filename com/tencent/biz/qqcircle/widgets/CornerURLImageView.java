package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.component.media.image.view.ViewForeground;
import com.tencent.image.URLImageView;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CornerURLImageView extends URLImageView {

    /* renamed from: d, reason: collision with root package name */
    private float[] f92878d;

    /* renamed from: e, reason: collision with root package name */
    private Path f92879e;

    /* renamed from: f, reason: collision with root package name */
    private RectF f92880f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f92881h;

    /* renamed from: i, reason: collision with root package name */
    private ViewForeground f92882i;

    public CornerURLImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f92880f = new RectF();
        this.f92882i = new ViewForeground(this, (Drawable) null);
    }

    public boolean c() {
        return this.f92881h;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!c()) {
            super.onDraw(canvas);
            return;
        }
        if (this.f92879e == null) {
            this.f92879e = new Path();
        }
        int save = canvas.save();
        try {
            try {
                Path path = this.f92879e;
                RectF rectF = this.f92880f;
                rectF.set(0.0f, 0.0f, getWidth(), getHeight());
                path.reset();
                path.addRoundRect(rectF, this.f92878d, Path.Direction.CW);
                canvas.clipPath(path);
                super.onDraw(canvas);
                ViewForeground viewForeground = this.f92882i;
                if (viewForeground != null) {
                    viewForeground.draw(canvas);
                }
            } catch (UnsupportedOperationException unused) {
                super.onDraw(canvas);
            }
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public void setNeedRadius(boolean z16) {
        this.f92881h = z16;
    }

    public void setRadius(float f16) {
        if (f16 > 0.0f) {
            setRadius(new float[]{f16, f16, f16, f16, f16, f16, f16, f16});
        } else {
            setRadius((float[]) null);
        }
    }

    public void setRadius(float[] fArr) {
        this.f92878d = fArr;
        setNeedRadius(fArr != null);
    }

    public CornerURLImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f92880f = new RectF();
        this.f92882i = new ViewForeground(this, (Drawable) null);
    }

    public CornerURLImageView(Context context) {
        super(context);
        this.f92880f = new RectF();
        this.f92882i = new ViewForeground(this, (Drawable) null);
    }
}
