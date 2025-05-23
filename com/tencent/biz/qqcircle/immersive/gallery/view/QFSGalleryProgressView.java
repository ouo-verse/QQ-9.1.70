package com.tencent.biz.qqcircle.immersive.gallery.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import y91.a;

/* loaded from: classes4.dex */
public class QFSGalleryProgressView extends View {
    private static final float I = cx.a(9.0f);
    private static int J = 255;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f86469d;

    /* renamed from: e, reason: collision with root package name */
    private int f86470e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f86471f;

    /* renamed from: h, reason: collision with root package name */
    private int f86472h;

    /* renamed from: i, reason: collision with root package name */
    private int f86473i;

    /* renamed from: m, reason: collision with root package name */
    private long f86474m;

    public QFSGalleryProgressView(Context context) {
        super(context);
        this.f86474m = 2000L;
        this.E = -1;
        this.F = 0;
        this.H = 0;
    }

    private void a(Canvas canvas, int i3, int i16, int i17) {
        if (canvas != null && this.f86469d != null) {
            b(canvas, this.E - 1);
            this.f86469d.setBounds(0, 0, i3, i16);
            canvas.translate((this.C + this.f86473i) * i17, 0.0f);
            this.f86469d.draw(canvas);
            canvas.translate((-i17) * (i3 + this.f86473i), 0.0f);
        }
    }

    private void b(Canvas canvas, int i3) {
        Drawable drawable;
        if (canvas == null) {
            return;
        }
        if (i3 >= this.G) {
            QLog.e(c(), 1, "[drawSelectType] pos = " + i3 + ", pos is error");
            return;
        }
        for (int i16 = 0; i16 < this.G; i16++) {
            if (i16 <= i3) {
                drawable = this.f86469d;
            } else {
                drawable = this.f86471f;
            }
            if (drawable == null) {
                QLog.e(c(), 1, "[drawSelectType] drawable is null i = " + i16 + ", pos = " + i3);
            } else {
                drawable.setBounds(0, 0, this.C, this.D);
                canvas.translate((this.C + this.f86473i) * i16, 0.0f);
                drawable.draw(canvas);
                canvas.translate((-i16) * (this.C + this.f86473i), 0.0f);
            }
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private void d(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        if (attributeSet == null || context == null || (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.H6)) == null) {
            return;
        }
        Drawable drawable = obtainStyledAttributes.getDrawable(a.K6);
        this.f86469d = drawable;
        if (drawable == null) {
            getResources().getDrawable(R.drawable.l8k);
        }
        int i3 = obtainStyledAttributes.getInt(a.J6, J);
        this.f86470e = i3;
        Drawable drawable2 = this.f86469d;
        if (drawable2 != null) {
            drawable2.setAlpha(i3);
        }
        Drawable drawable3 = obtainStyledAttributes.getDrawable(a.M6);
        this.f86471f = drawable3;
        if (drawable3 == null) {
            this.f86471f = getResources().getDrawable(R.drawable.l8m);
        }
        int i16 = obtainStyledAttributes.getInt(a.L6, J);
        this.f86472h = i16;
        Drawable drawable4 = this.f86471f;
        if (drawable4 != null) {
            drawable4.setAlpha(i16);
        }
        this.f86473i = (int) (obtainStyledAttributes.getDimension(a.I6, I) + 0.5f);
        obtainStyledAttributes.recycle();
    }

    protected String c() {
        return "QFSGalleryProgressView";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        if (this.G <= 0) {
            return;
        }
        int width = getWidth();
        int i3 = this.G;
        this.C = (width - ((i3 - 1) * this.f86473i)) / i3;
        int height = getHeight();
        this.D = height;
        int i16 = this.H;
        if (i16 == 0) {
            b(canvas, this.E);
        } else if (i16 == 1) {
            a(canvas, this.F, height, this.E);
        }
        canvas.restore();
    }

    public void setBlockDuration(long j3) {
        this.f86474m = j3;
    }

    public void setTotalCount(int i3) {
        this.G = i3;
        if (i3 <= 1) {
            return;
        }
        invalidate();
    }

    public QFSGalleryProgressView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f86474m = 2000L;
        this.E = -1;
        this.F = 0;
        this.H = 0;
        d(context, attributeSet);
    }

    public QFSGalleryProgressView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f86474m = 2000L;
        this.E = -1;
        this.F = 0;
        this.H = 0;
        d(context, attributeSet);
    }
}
