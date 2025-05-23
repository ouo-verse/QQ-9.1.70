package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: P */
/* loaded from: classes20.dex */
public class AudioAnimationView extends View {
    private Rect[] C;
    private int[] D;
    private int E;
    volatile boolean F;
    private Handler G;
    private Drawable H;

    /* renamed from: d, reason: collision with root package name */
    private int f315432d;

    /* renamed from: e, reason: collision with root package name */
    private int f315433e;

    /* renamed from: f, reason: collision with root package name */
    private int f315434f;

    /* renamed from: h, reason: collision with root package name */
    private Resources f315435h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f315436i;

    /* renamed from: m, reason: collision with root package name */
    private int f315437m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private class Animator implements Runnable {
        final /* synthetic */ AudioAnimationView this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.d();
            if (this.this$0.F) {
                this.this$0.G.postDelayed(this, 100L);
            }
            this.this$0.requestLayout();
            this.this$0.invalidate();
        }
    }

    public AudioAnimationView(Context context) {
        super(context);
        this.f315437m = 7;
        this.E = 1;
        this.F = false;
        this.G = new Handler();
        c();
    }

    public static int b(int i3, Resources resources) {
        return (int) ((resources.getDisplayMetrics().density * i3) + 0.5f);
    }

    void c() {
        this.f315435h = getResources();
        this.f315432d = b(2, getResources());
        this.f315433e = b(2, getResources());
        this.f315434f = b(12, getResources());
        Paint paint = new Paint();
        this.f315436i = paint;
        paint.setColor(-1);
        this.f315436i.setStyle(Paint.Style.FILL);
        this.f315436i.setStrokeWidth(4.0f);
        this.f315436i.setAlpha(204);
    }

    void d() {
        int i3 = (int) (this.f315434f * 0.6777f);
        for (int i16 = 0; i16 < this.f315437m; i16++) {
            this.D[i16] = (int) (i3 * Math.random());
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Handler handler = this.G;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.F) {
            int i3 = 0;
            while (i3 < this.f315437m) {
                Rect rect = this.C[i3];
                int i16 = this.f315432d;
                int i17 = this.f315433e;
                int i18 = (i16 + i17) * i3;
                int i19 = this.D[i3];
                int i26 = i3 + 1;
                int i27 = (i16 * i26) + (i17 * i3);
                int i28 = this.f315434f;
                if (this.E == 1) {
                    i28 -= i19;
                }
                rect.set(i18, i19, i27, i28);
                canvas.drawRect(rect, this.f315436i);
                i3 = i26;
            }
            return;
        }
        Drawable drawable = this.H;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        super.onMeasure(i3, i16);
        if (this.F) {
            int i19 = this.f315437m;
            i17 = (this.f315432d * i19) + ((i19 - 1) * this.f315433e);
            i18 = this.f315434f;
        } else {
            Drawable drawable = this.H;
            if (drawable != null) {
                i17 = drawable.getIntrinsicWidth();
                i18 = this.H.getIntrinsicHeight();
            } else {
                i17 = 0;
                i18 = 0;
            }
        }
        setMeasuredDimension(i17, i18);
    }

    public void setColor(int i3) {
        Paint paint = this.f315436i;
        if (paint != null) {
            paint.setColor(i3);
        }
    }

    public void setIcon(Drawable drawable) {
        this.H = drawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.H.getIntrinsicHeight());
        }
        requestLayout();
        invalidate();
    }

    public void setRectCount(int i3) {
        this.f315437m = i3;
        this.C = new Rect[i3];
        this.D = new int[i3];
        for (int i16 = 0; i16 <= this.f315437m - 1; i16++) {
            this.C[i16] = new Rect();
            this.D[i16] = 0;
        }
        d();
        requestLayout();
        invalidate();
    }

    public void setRectHeightMax(int i3) {
        this.f315434f = i3;
    }

    public void setRectInterval(int i3) {
        this.f315433e = i3;
    }

    public void setRectWidth(int i3) {
        this.f315432d = i3;
    }

    public void setSyle(int i3) {
        this.E = i3;
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315437m = 7;
        this.E = 1;
        this.F = false;
        this.G = new Handler();
        c();
    }
}
