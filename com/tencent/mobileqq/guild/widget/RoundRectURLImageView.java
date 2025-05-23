package com.tencent.mobileqq.guild.widget;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;

/* compiled from: P */
/* loaded from: classes14.dex */
public class RoundRectURLImageView extends URLImageView {

    /* renamed from: d, reason: collision with root package name */
    private float[] f236137d;

    /* renamed from: e, reason: collision with root package name */
    private Path f236138e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f236139f;

    public RoundRectURLImageView(Context context) {
        this(context, null);
    }

    public boolean c() {
        return this.f236139f;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (c()) {
            if (this.f236138e == null) {
                this.f236138e = new Path();
            }
            int save = canvas.save();
            try {
                try {
                    Path path = this.f236138e;
                    RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
                    path.reset();
                    path.addRoundRect(rectF, this.f236137d, Path.Direction.CW);
                    canvas.clipPath(path);
                    super.onDraw(canvas);
                } catch (UnsupportedOperationException unused) {
                    super.onDraw(canvas);
                }
                return;
            } finally {
                canvas.restoreToCount(save);
            }
        }
        super.onDraw(canvas);
    }

    public void setNeedRadius(boolean z16) {
        this.f236139f = z16;
    }

    public void setRadius(float f16) {
        if (f16 > 0.0f) {
            setRadius(new float[]{f16, f16, f16, f16, f16, f16, f16, f16});
        } else {
            setRadius((float[]) null);
        }
    }

    public RoundRectURLImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    public RoundRectURLImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public void setRadius(float[] fArr) {
        this.f236137d = fArr;
        setNeedRadius(fArr != null);
    }
}
