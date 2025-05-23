package com.tencent.mobileqq.onlinestatus.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ay extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private final Paint f256530a;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f256531b;

    /* renamed from: c, reason: collision with root package name */
    private final Paint f256532c;

    /* renamed from: d, reason: collision with root package name */
    private final int f256533d;

    /* renamed from: e, reason: collision with root package name */
    private int f256534e;

    /* renamed from: f, reason: collision with root package name */
    private final int f256535f;

    /* renamed from: g, reason: collision with root package name */
    private final int f256536g;

    /* renamed from: h, reason: collision with root package name */
    private final int f256537h;

    /* renamed from: i, reason: collision with root package name */
    private final int f256538i;

    /* renamed from: j, reason: collision with root package name */
    private final int f256539j;

    /* renamed from: k, reason: collision with root package name */
    private final int f256540k;

    /* renamed from: l, reason: collision with root package name */
    private final Bitmap f256541l;

    /* renamed from: m, reason: collision with root package name */
    private final Bitmap f256542m;

    /* renamed from: n, reason: collision with root package name */
    private String f256543n;

    /* renamed from: o, reason: collision with root package name */
    private int f256544o;

    /* renamed from: p, reason: collision with root package name */
    private Resources f256545p;

    public ay(Resources resources) {
        this.f256545p = resources;
        this.f256533d = a(19, resources);
        int a16 = a(6, resources);
        this.f256535f = a16;
        int a17 = a(2, resources);
        this.f256537h = a17;
        this.f256536g = a(3, resources);
        int a18 = a(12, resources);
        this.f256538i = a18;
        this.f256540k = a(12, resources);
        this.f256539j = (a16 * 2) + a18 + a17;
        this.f256542m = b(resources);
        this.f256541l = c(resources);
        Paint paint = new Paint(1);
        this.f256530a = paint;
        this.f256532c = new Paint(1);
        Paint paint2 = new Paint(1);
        this.f256531b = paint2;
        paint2.setColorFilter(new LightingColorFilter(0, this.f256545p.getColor(R.color.qui_common_icon_nav_primary)));
        paint.setTextSize(a(10, resources));
        e();
    }

    private int a(int i3, Resources resources) {
        return (int) ((resources.getDisplayMetrics().density * i3) + 0.5f);
    }

    private Bitmap b(Resources resources) {
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, R.drawable.n59);
        Matrix matrix = new Matrix();
        matrix.postScale((this.f256538i * 1.0f) / decodeResource.getWidth(), (this.f256538i * 1.0f) / decodeResource.getHeight());
        return Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix, true);
    }

    private Bitmap c(Resources resources) {
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, R.drawable.arrow_conversation_status);
        Matrix matrix = new Matrix();
        float a16 = a(9, resources) * 1.0f;
        matrix.postScale(a16 / decodeResource.getWidth(), a16 / decodeResource.getHeight());
        return Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix, true);
    }

    private void e() {
        if (!"2921".equals(QQTheme.getCurrentThemeId()) && !"2971".equals(QQTheme.getCurrentThemeId())) {
            this.f256534e = Color.parseColor("#80F5F5F5");
        } else {
            this.f256534e = this.f256545p.getColor(R.color.skin_color_fff5f5f5);
        }
    }

    public void d(String str) {
        this.f256543n = str;
        int measureText = (int) this.f256530a.measureText(str, 0, str.length());
        this.f256544o = measureText;
        setBounds(0, 0, measureText + this.f256539j, this.f256540k);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        RectF rectF = new RectF();
        rectF.top = bounds.top;
        rectF.bottom = r2 + this.f256540k;
        float f16 = bounds.left;
        rectF.left = f16;
        rectF.right = f16 + this.f256544o + this.f256539j;
        this.f256532c.setColor(this.f256534e);
        int i3 = this.f256533d;
        canvas.drawRoundRect(rectF, i3, i3, this.f256532c);
        canvas.drawBitmap(this.f256542m, rectF.left + this.f256535f, rectF.centerY() - (this.f256542m.getHeight() / 2.0f), this.f256530a);
        Paint.FontMetrics fontMetrics = this.f256530a.getFontMetrics();
        float width = rectF.left + this.f256535f + this.f256542m.getWidth() + this.f256537h;
        float centerY = rectF.centerY() - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f);
        String str = this.f256543n;
        canvas.drawText(str, 0, str.length(), width, centerY, this.f256530a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f256531b.setColorFilter(new LightingColorFilter(0, this.f256545p.getColor(R.color.qui_common_icon_nav_primary)));
        e();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f256530a.setAlpha(i3);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f256530a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
