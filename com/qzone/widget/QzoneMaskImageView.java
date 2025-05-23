package com.qzone.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QzoneMaskImageView extends AsyncImageView {
    private int C;

    /* renamed from: d, reason: collision with root package name */
    private float f60584d;

    /* renamed from: e, reason: collision with root package name */
    private float f60585e;

    /* renamed from: f, reason: collision with root package name */
    private float f60586f;

    /* renamed from: h, reason: collision with root package name */
    private float f60587h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f60588i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f60589m;

    public QzoneMaskImageView(Context context) {
        super(context);
        init();
    }

    private void f(Canvas canvas) {
        if (this.f60589m) {
            g(canvas);
            return;
        }
        if (this.C <= 0) {
            return;
        }
        canvas.drawColor(1711276032);
        int width = (getWidth() - ((int) ((this.f60588i.measureText(String.valueOf(this.C)) + this.f60586f) + this.f60585e))) / 2;
        float height = getHeight();
        float f16 = this.f60585e;
        int i3 = (int) ((height - f16) / 2.0f);
        Paint.FontMetrics fontMetrics = this.f60588i.getFontMetrics();
        float height2 = ((getHeight() - (fontMetrics.bottom - fontMetrics.top)) / 2.0f) - fontMetrics.top;
        Drawable drawable = getResources().getDrawable(R.drawable.fxe);
        drawable.setBounds(width, i3, (int) (width + f16), (int) (i3 + f16));
        drawable.draw(canvas);
        canvas.drawText(String.valueOf(this.C), r0 + width, height2, this.f60588i);
    }

    private void g(Canvas canvas) {
        int width = (int) ((getWidth() - this.f60587h) / 2.0f);
        int height = (int) ((getHeight() - this.f60587h) / 2.0f);
        Drawable drawable = getResources().getDrawable(R.drawable.bvo);
        if (drawable != null) {
            float f16 = this.f60587h;
            drawable.setBounds(width, height, (int) (width + f16), (int) (height + f16));
            drawable.draw(canvas);
        }
    }

    private void init() {
        Paint paint = new Paint();
        this.f60588i = paint;
        paint.setColor(-1);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f60584d = TypedValue.applyDimension(2, 18.0f, displayMetrics);
        this.f60586f = TypedValue.applyDimension(1, 4.0f, displayMetrics);
        this.f60585e = TypedValue.applyDimension(1, 12.0f, displayMetrics);
        this.f60587h = TypedValue.applyDimension(1, 28.0f, displayMetrics);
        this.f60588i.setTextSize(this.f60584d);
        this.f60588i.setAntiAlias(true);
        this.f60588i.setTextAlign(Paint.Align.RIGHT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.widget.ExtendImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        f(canvas);
    }

    public void setHasMore(int i3) {
        this.C = i3;
        invalidate();
    }

    public void setNeedShowPlayIcon(boolean z16) {
        this.f60589m = z16;
        invalidate();
    }

    public QzoneMaskImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public QzoneMaskImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init();
    }
}
