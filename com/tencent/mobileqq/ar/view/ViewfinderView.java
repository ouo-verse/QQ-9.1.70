package com.tencent.mobileqq.ar.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.internal.view.SupportMenu;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class ViewfinderView extends View {
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private String H;
    private int I;
    private boolean J;
    private float K;
    private float L;
    private boolean M;
    private boolean N;
    private Rect P;
    private String Q;
    private List<com.tencent.mobileqq.qrscan.a> R;
    private ValueAnimator S;
    private float T;
    private boolean U;
    private Rect V;
    private RectF W;

    /* renamed from: a0, reason: collision with root package name */
    private Rect f198784a0;

    /* renamed from: d, reason: collision with root package name */
    private final Paint f198785d;

    /* renamed from: e, reason: collision with root package name */
    private final int f198786e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f198787f;

    /* renamed from: h, reason: collision with root package name */
    private int f198788h;

    /* renamed from: i, reason: collision with root package name */
    private Bitmap f198789i;

    /* renamed from: m, reason: collision with root package name */
    private int f198790m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Rect f198791d;

        a(Rect rect) {
            this.f198791d = rect;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewfinderView.this.T = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ViewfinderView viewfinderView = ViewfinderView.this;
            Rect rect = this.f198791d;
            viewfinderView.postInvalidate(rect.left - 6, rect.top - 6, rect.right + 6, rect.bottom + 6);
        }
    }

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f198788h = 18;
        this.D = 0;
        this.N = true;
        this.U = true;
        this.V = new Rect();
        this.W = new RectF();
        this.f198784a0 = new Rect();
        this.f198785d = new Paint(1);
        this.f198787f = new Rect();
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), R.drawable.enk);
        this.f198789i = decodeResource;
        this.f198788h = decodeResource.getHeight();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ViewfinderView);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ViewfinderView_corner_width, b(context, 3.0f));
        this.f198790m = dimensionPixelSize;
        if ((dimensionPixelSize & 1) != 0) {
            this.f198790m = dimensionPixelSize + 1;
        }
        this.C = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ViewfinderView_corner_length, b(context, 16.0f));
        this.E = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ViewfinderView_corner_rect_length, b(context, 2.0f));
        this.G = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_corner_color, Color.parseColor("#FFFFFF"));
        this.F = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_corner_rect_color, -16776961);
        this.f198786e = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_mask_color, Color.parseColor("#000000"));
        String string = obtainStyledAttributes.getString(R.styleable.ViewfinderView_text_description);
        this.H = string;
        if (TextUtils.isEmpty(string)) {
            this.H = HardCodeUtil.qqStr(R.string.v9d);
        }
        this.I = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_text_color, Color.parseColor("#FFFFFF"));
        this.J = obtainStyledAttributes.getBoolean(R.styleable.ViewfinderView_text_visible, false);
        this.K = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ViewfinderView_text_margin, b(context, 20.0f));
        this.L = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ViewfinderView_text_size, e(context, 14.0f));
        this.D = b(context, 8.0f);
        obtainStyledAttributes.recycle();
    }

    public static int b(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void c(Rect rect, Canvas canvas) {
        if (!this.N) {
            return;
        }
        canvas.save();
        canvas.clipRect(rect);
        if (this.S == null) {
            int i3 = rect.top;
            int i16 = this.f198788h;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(i3 - i16, rect.bottom - i16);
            this.S = ofFloat;
            ofFloat.setDuration(4000L);
            this.S.setRepeatCount(-1);
            this.S.setRepeatMode(1);
            this.S.setInterpolator(new LinearInterpolator());
            this.S.addUpdateListener(new a(rect));
            this.U = true;
        }
        if (this.U) {
            this.S.start();
            this.U = false;
        }
        this.f198785d.setAntiAlias(true);
        this.f198785d.setDither(true);
        this.f198785d.setFilterBitmap(true);
        Rect rect2 = this.f198787f;
        int i17 = rect.left;
        float f16 = this.T;
        rect2.set(i17, (int) f16, rect.right, ((int) f16) + this.f198788h);
        canvas.drawBitmap(this.f198789i, (Rect) null, this.f198787f, this.f198785d);
        canvas.restore();
        this.f198785d.reset();
    }

    private void d(Rect rect, Canvas canvas) {
        this.f198785d.reset();
        this.f198785d.setStyle(Paint.Style.FILL);
        this.f198785d.setColor(this.G);
        this.f198785d.setAntiAlias(true);
        Rect rect2 = this.V;
        int i3 = rect.left;
        int i16 = this.D;
        rect2.set(i3 - i16, rect.top - i16, rect.right + i16, rect.bottom + i16);
        RectF rectF = this.W;
        Rect rect3 = this.V;
        rectF.set(rect3.left, rect3.top, r1 + this.C, r0 + this.f198790m);
        RectF rectF2 = this.W;
        int i17 = this.f198790m;
        canvas.drawRoundRect(rectF2, i17 / 2, i17 / 2, this.f198785d);
        RectF rectF3 = this.W;
        Rect rect4 = this.V;
        rectF3.set(rect4.left, rect4.top, r1 + this.f198790m, r0 + this.C);
        RectF rectF4 = this.W;
        int i18 = this.f198790m;
        canvas.drawRoundRect(rectF4, i18 / 2, i18 / 2, this.f198785d);
        RectF rectF5 = this.W;
        Rect rect5 = this.V;
        int i19 = rect5.right;
        rectF5.set(i19 - this.C, rect5.top, i19, r0 + this.f198790m);
        RectF rectF6 = this.W;
        int i26 = this.f198790m;
        canvas.drawRoundRect(rectF6, i26 / 2, i26 / 2, this.f198785d);
        RectF rectF7 = this.W;
        Rect rect6 = this.V;
        int i27 = rect6.right;
        rectF7.set(i27 - this.f198790m, rect6.top, i27, r0 + this.C);
        RectF rectF8 = this.W;
        int i28 = this.f198790m;
        canvas.drawRoundRect(rectF8, i28 / 2, i28 / 2, this.f198785d);
        RectF rectF9 = this.W;
        Rect rect7 = this.V;
        rectF9.set(rect7.left, r0 - this.C, r1 + this.f198790m, rect7.bottom);
        RectF rectF10 = this.W;
        int i29 = this.f198790m;
        canvas.drawRoundRect(rectF10, i29 / 2, i29 / 2, this.f198785d);
        RectF rectF11 = this.W;
        Rect rect8 = this.V;
        rectF11.set(rect8.left, r0 - this.f198790m, r1 + this.C, rect8.bottom);
        RectF rectF12 = this.W;
        int i36 = this.f198790m;
        canvas.drawRoundRect(rectF12, i36 / 2, i36 / 2, this.f198785d);
        RectF rectF13 = this.W;
        Rect rect9 = this.V;
        int i37 = rect9.right;
        rectF13.set(i37 - this.C, r0 - this.f198790m, i37, rect9.bottom);
        RectF rectF14 = this.W;
        int i38 = this.f198790m;
        canvas.drawRoundRect(rectF14, i38 / 2, i38 / 2, this.f198785d);
        RectF rectF15 = this.W;
        Rect rect10 = this.V;
        int i39 = rect10.right;
        rectF15.set(i39 - this.f198790m, r0 - this.C, i39, rect10.bottom);
        RectF rectF16 = this.W;
        int i46 = this.f198790m;
        canvas.drawRoundRect(rectF16, i46 / 2, i46 / 2, this.f198785d);
        this.f198785d.reset();
    }

    public static int e(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public void f() {
        ValueAnimator valueAnimator = this.S;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.S = null;
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        QLog.d("viewFinderView", 1, "onDetachedFromWindow ");
        super.onDetachedFromWindow();
        f();
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        if (this.P == null) {
            return;
        }
        Rect rect = new Rect(0, 0, z81.c.f452158a, z81.c.f452159b);
        canvas.getWidth();
        canvas.getHeight();
        this.f198785d.setColor(this.f198786e);
        this.f198785d.setAntiAlias(true);
        if (!this.M) {
            d(rect, canvas);
        }
        c(rect, canvas);
        List<com.tencent.mobileqq.qrscan.a> list = this.R;
        if (list != null && !list.isEmpty()) {
            for (com.tencent.mobileqq.qrscan.a aVar : list) {
                this.f198785d.setColor(SupportMenu.CATEGORY_MASK);
                this.f198785d.setStyle(Paint.Style.STROKE);
                this.f198785d.setStrokeWidth(4.0f);
                canvas.drawRect(aVar.f276532b, this.f198785d);
            }
        }
        if (!TextUtils.isEmpty(this.Q)) {
            TextPaint textPaint = new TextPaint();
            textPaint.setColor(SupportMenu.CATEGORY_MASK);
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setStrokeWidth(2.0f);
            textPaint.setTextSize(BaseAIOUtils.f(12.0f, getResources()));
            canvas.drawText(this.Q, 90.0f, 90.0f, textPaint);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i3) {
        QLog.d("viewFinderView", 2, "onVisibilityChanged " + i3);
        super.onVisibilityChanged(view, i3);
        if (i3 != 0) {
            f();
        }
    }

    public void setDetectRect(List<com.tencent.mobileqq.qrscan.a> list) {
        this.R = list;
        postInvalidate();
    }

    public void setMiniText(String str) {
        this.Q = str;
        postInvalidate();
    }

    public void setNeedHideRectCorner(boolean z16) {
        this.M = z16;
    }

    public void setRect(Rect rect) {
        if (rect != null && !rect.equals(this.P)) {
            this.P = new Rect(rect.left, rect.top, rect.right, rect.bottom);
            ValueAnimator valueAnimator = this.S;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.S = null;
            }
        }
    }

    public void setShowScanline(boolean z16) {
        if (z16) {
            this.N = true;
            invalidate();
        } else {
            this.N = false;
            f();
        }
    }
}
