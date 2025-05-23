package com.qzone.personalize.flashnickname.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FlashCellTextView extends CellTextView {
    private static final PorterDuffXfermode I;
    private static final Paint J;
    private ValueAnimator C;
    private final HashMap<Integer, Drawable> D;
    private Bitmap E;
    private boolean F;
    private int G;
    private ValueAnimator.AnimatorUpdateListener H;

    /* renamed from: d, reason: collision with root package name */
    public int f49210d;

    /* renamed from: e, reason: collision with root package name */
    public int f49211e;

    /* renamed from: f, reason: collision with root package name */
    public float f49212f;

    /* renamed from: h, reason: collision with root package name */
    protected int f49213h;

    /* renamed from: i, reason: collision with root package name */
    protected int f49214i;

    /* renamed from: m, reason: collision with root package name */
    private float f49215m;

    static {
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        I = porterDuffXfermode;
        Paint paint = new Paint();
        J = paint;
        paint.setXfermode(porterDuffXfermode);
    }

    public FlashCellTextView(Context context) {
        super(context);
        this.f49210d = 1;
        this.f49211e = -1;
        this.f49212f = 17.36f;
        this.D = new HashMap<>();
        this.F = false;
        this.G = -1;
    }

    private int d() {
        if (this.f49210d == 3) {
            return this.f49214i;
        }
        return this.f49213h;
    }

    private float e() {
        int d16 = d();
        if (this.f49210d == 3) {
            return (this.f49215m * (this.f49214i + d16)) - d16;
        }
        return this.f49214i * this.f49215m;
    }

    private void f(Context context) {
        if (this.D.size() > 0 || context == null) {
            return;
        }
        this.D.put(4, context.getResources().getDrawable(R.drawable.atj));
        this.D.put(1, context.getResources().getDrawable(R.drawable.atj));
        this.D.put(2, context.getResources().getDrawable(R.drawable.ldq));
        this.D.put(3, context.getResources().getDrawable(R.drawable.m1g));
        this.D.put(0, context.getResources().getDrawable(R.drawable.ati));
    }

    private void g() {
        if (this.f49214i == 0 || this.f49213h == 0 || this.F) {
            return;
        }
        this.F = true;
        f(this.mContext);
        Drawable drawable = this.D.get(Integer.valueOf(this.f49210d));
        try {
            if (this.E == null) {
                this.E = Bitmap.createBitmap(this.f49214i, this.f49213h, Bitmap.Config.ARGB_8888);
            }
            Canvas canvas = new Canvas(this.E);
            if (drawable != null) {
                drawable.setBounds(0, 0, d(), this.f49213h);
                drawable.draw(canvas);
            }
        } catch (Throwable th5) {
            QLog.e("FlashCellTextView", 1, "create bitmap error " + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(ValueAnimator valueAnimator) {
        int i3;
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue instanceof Float) {
            this.f49215m = ((Float) animatedValue).floatValue();
            invalidate();
            if (this.f49215m != 1.0f || (i3 = this.G) <= 0) {
                return;
            }
            int i16 = i3 - 1;
            this.G = i16;
            if (i16 == 0) {
                j();
            }
        }
    }

    public void c() {
        j();
        this.C = null;
        invalidate();
    }

    public void i() {
        if (this.f49214i == 0 || this.f49213h == 0) {
            return;
        }
        if (this.C == null) {
            g();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.C = ofFloat;
            ofFloat.setInterpolator(new LinearInterpolator());
            this.C.setRepeatCount(this.f49211e);
            this.C.setRepeatMode(1);
            this.C.setDuration((int) (ar.r(this.f49214i) * this.f49212f));
        }
        if (this.C.isRunning()) {
            return;
        }
        if (this.H == null) {
            this.H = new ValueAnimator.AnimatorUpdateListener() { // from class: com.qzone.personalize.flashnickname.ui.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlashCellTextView.this.h(valueAnimator);
                }
            };
        }
        this.G = this.f49211e;
        this.C.addUpdateListener(this.H);
        this.C.start();
    }

    public void j() {
        ValueAnimator valueAnimator = this.C;
        if (valueAnimator == null) {
            return;
        }
        valueAnimator.removeUpdateListener(this.H);
        this.H = null;
        this.C.cancel();
    }

    @Override // com.qzone.proxy.feedcomponent.text.CellTextView, android.view.View
    public void onDraw(Canvas canvas) {
        int i3;
        super.onDraw(canvas);
        int i16 = this.f49214i;
        if (i16 == 0 || (i3 = this.f49213h) == 0 || this.C == null || this.E == null) {
            return;
        }
        canvas.saveLayerAlpha(0.0f, 0.0f, i16, i3, 255, 31);
        super.onDraw(canvas);
        canvas.drawBitmap(this.E, e(), 0.0f, J);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.f49213h = getMeasuredHeight();
        this.f49214i = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.proxy.feedcomponent.text.CellTextView, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
    }

    public FlashCellTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f49210d = 1;
        this.f49211e = -1;
        this.f49212f = 17.36f;
        this.D = new HashMap<>();
        this.F = false;
        this.G = -1;
    }

    public FlashCellTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f49210d = 1;
        this.f49211e = -1;
        this.f49212f = 17.36f;
        this.D = new HashMap<>();
        this.F = false;
        this.G = -1;
    }
}
