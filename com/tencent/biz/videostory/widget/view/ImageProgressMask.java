package com.tencent.biz.videostory.widget.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.co;

/* loaded from: classes5.dex */
public class ImageProgressMask extends View {

    /* renamed from: d, reason: collision with root package name */
    private Paint f97226d;

    /* renamed from: e, reason: collision with root package name */
    private Path f97227e;

    /* renamed from: f, reason: collision with root package name */
    private float f97228f;

    /* renamed from: h, reason: collision with root package name */
    private RectF f97229h;

    /* renamed from: i, reason: collision with root package name */
    private int f97230i;

    /* renamed from: m, reason: collision with root package name */
    private int f97231m;

    public ImageProgressMask(Context context) {
        this(context, null, 0);
    }

    private void a() {
        Paint paint = new Paint();
        this.f97226d = paint;
        paint.setColor(getResources().getColor(R.color.f156938fs));
        this.f97226d.setAntiAlias(true);
        this.f97227e = new Path();
        this.f97229h = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            canvas.save();
            canvas.clipPath(this.f97227e);
            if (this.f97230i == 0 && this.f97231m == 0) {
                this.f97230i = getWidth();
                this.f97231m = getHeight();
                int i3 = this.f97231m;
                this.f97229h = new RectF(0.0f, i3 * this.f97228f, this.f97230i, i3);
            }
            canvas.drawRect(this.f97229h, this.f97226d);
            super.onDraw(canvas);
            canvas.restore();
        } catch (Exception unused) {
            super.onDraw(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        if (i3 != 0 && i16 != 0) {
            if (i3 != i17 || i16 != i18) {
                this.f97227e = co.b(i3, i16);
            }
        }
    }

    public void setProgress(float f16) {
        this.f97228f = f16;
        this.f97230i = getWidth();
        this.f97231m = getHeight();
        int i3 = this.f97231m;
        this.f97229h = new RectF(0.0f, i3 * this.f97228f, this.f97230i, i3);
        postInvalidate();
    }

    public ImageProgressMask(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageProgressMask(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }
}
