package com.tencent.biz.qqstory.takevideo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.R;

@Deprecated
/* loaded from: classes5.dex */
public class AutoPlayImageView extends ImageView {
    private int C;
    private Drawable D;
    private Paint E;

    /* renamed from: d, reason: collision with root package name */
    private int f94224d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f94225e;

    /* renamed from: f, reason: collision with root package name */
    private String f94226f;

    /* renamed from: h, reason: collision with root package name */
    private int f94227h;

    /* renamed from: i, reason: collision with root package name */
    private int f94228i;

    /* renamed from: m, reason: collision with root package name */
    private Path f94229m;

    public AutoPlayImageView(Context context) {
        super(context);
        this.f94225e = true;
        this.C = 0;
        a();
    }

    private void a() {
        this.f94224d = 0;
        this.f94229m = new Path();
        super.setLayerType(2, null);
        Paint paint = new Paint();
        this.E = paint;
        paint.setColor(-2302756);
        this.E.setStyle(Paint.Style.STROKE);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f94229m == null) {
            this.f94229m = new Path();
        }
        this.f94229m.reset();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        RectF rectF = new RectF(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + width, getPaddingTop() + ((getHeight() - getPaddingTop()) - getPaddingBottom()));
        int i3 = this.C;
        if (i3 <= 0) {
            i3 = width / 30;
        }
        float f16 = i3;
        this.f94229m.addRoundRect(rectF, f16, f16, Path.Direction.CCW);
        this.f94229m.setFillType(Path.FillType.EVEN_ODD);
        canvas.clipPath(this.f94229m);
        super.draw(canvas);
        this.f94229m.reset();
        this.f94229m.addRoundRect(rectF, f16, f16, Path.Direction.CCW);
        if (QQStoryContext.i()) {
            this.E.setColor(getContext().getResources().getColor(R.color.a3c));
        }
        canvas.drawPath(this.f94229m, this.E);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
    }

    public void setBorderColor(@ColorInt int i3) {
        this.E.setColor(i3);
        invalidate();
    }

    public void setCorner(int i3) {
        if (i3 > 0) {
            this.C = i3;
            return;
        }
        throw new IllegalArgumentException("should not be less than 0");
    }

    public void setCoverDrawable(Drawable drawable) {
        this.D = drawable;
    }

    public void setCoverUrl(String str, int i3, int i16) {
        this.f94226f = str;
        this.f94227h = i3;
        this.f94228i = i16;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
    }

    public AutoPlayImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f94225e = true;
        this.C = 0;
        a();
    }

    public AutoPlayImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f94225e = true;
        this.C = 0;
        a();
    }
}
