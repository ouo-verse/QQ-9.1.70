package com.qzone.album.business.photolist.ui.listitem;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R;

/* loaded from: classes39.dex */
public class PhotoBgView extends View {
    private Paint C;
    private boolean D;
    int E;
    int F;
    int G;
    int H;

    /* renamed from: d, reason: collision with root package name */
    public int f43639d;

    /* renamed from: e, reason: collision with root package name */
    private float[] f43640e;

    /* renamed from: f, reason: collision with root package name */
    private int f43641f;

    /* renamed from: h, reason: collision with root package name */
    private Path f43642h;

    /* renamed from: i, reason: collision with root package name */
    private RectF f43643i;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f43644m;

    public PhotoBgView(Context context) {
        super(context);
        this.f43639d = 0;
        this.f43640e = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.f43641f = 0;
        this.f43643i = new RectF();
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = 0;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f43642h == null) {
            this.f43642h = new Path();
        }
        int save = canvas.save();
        try {
            try {
                Path path = this.f43642h;
                RectF rectF = this.f43643i;
                RectF rectF2 = new RectF();
                Paint paint = new Paint();
                paint.setColor(getResources().getColor(R.color.a5z));
                paint.setStyle(Paint.Style.STROKE);
                paint.setAntiAlias(true);
                path.reset();
                rectF2.set(0.0f, 2.0f, getWidth(), getHeight());
                path.addRoundRect(rectF2, this.f43640e, Path.Direction.CW);
                canvas.drawPath(path, paint);
                rectF.set(this.E, this.F, getWidth() - this.G, getHeight() - this.H);
                path.reset();
                if (this.f43639d == 0) {
                    path.addRect(rectF, Path.Direction.CW);
                } else {
                    path.addRoundRect(rectF, this.f43640e, Path.Direction.CW);
                }
                canvas.drawPath(path, this.C);
                super.onDraw(canvas);
                if (this.f43644m != null && this.D) {
                    this.f43642h.computeBounds(new RectF(), true);
                    canvas.translate(((getWidth() - getPaddingRight()) - getPaddingLeft()) - this.f43644m.getIntrinsicWidth(), ((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.f43644m.getIntrinsicHeight());
                    Drawable drawable = this.f43644m;
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f43644m.getIntrinsicHeight());
                    this.f43644m.draw(canvas);
                }
            } catch (UnsupportedOperationException unused) {
                super.onDraw(canvas);
            }
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public void setCorner(int i3) {
        this.f43641f = i3;
    }

    public void setDrawable(Drawable drawable) {
        this.f43644m = drawable;
        this.D = true;
    }

    public void setIsDrawDrawable(boolean z16) {
        this.D = z16;
    }

    public void setRadius(float[] fArr) {
        this.f43640e = fArr;
    }

    public void setRadiusType(int i3) {
        this.f43639d = i3;
        if (i3 == 0) {
            this.f43640e = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            return;
        }
        if (i3 == 1) {
            int i16 = this.f43641f;
            this.f43640e = new float[]{i16, i16, i16, i16, 0.0f, 0.0f, 0.0f, 0.0f};
            return;
        }
        if (i3 == 2) {
            int i17 = this.f43641f;
            this.f43640e = new float[]{0.0f, 0.0f, 0.0f, 0.0f, i17, i17, i17, i17};
        } else if (i3 == 3) {
            int i18 = this.f43641f;
            this.f43640e = new float[]{i18, i18, i18, i18, i18, i18, i18, i18};
        } else {
            if (i3 != 4) {
                return;
            }
            int i19 = this.f43641f;
            this.f43640e = new float[]{0.0f, 0.0f, i19, i19, i19, i19, 0.0f, 0.0f};
        }
    }

    public void setShadowPadding(int i3, int i16, int i17, int i18) {
        this.E = i3;
        this.F = i16;
        this.G = i17;
        this.H = i18;
    }

    public PhotoBgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f43639d = 0;
        this.f43640e = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.f43641f = 0;
        this.f43643i = new RectF();
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = 0;
    }

    public PhotoBgView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f43639d = 0;
        this.f43640e = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.f43641f = 0;
        this.f43643i = new RectF();
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = 0;
    }
}
