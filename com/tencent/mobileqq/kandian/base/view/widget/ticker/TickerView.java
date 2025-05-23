package com.tencent.mobileqq.kandian.base.view.widget.ticker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
public class TickerView extends View {
    private static final Interpolator N = new AccelerateDecelerateInterpolator();
    private int C;
    private int D;
    private int E;
    private int F;
    private float G;
    private int H;
    private long I;
    private long J;
    private Interpolator K;
    private boolean L;
    private String M;

    /* renamed from: d, reason: collision with root package name */
    protected final Paint f239195d;

    /* renamed from: e, reason: collision with root package name */
    private final d f239196e;

    /* renamed from: f, reason: collision with root package name */
    private final com.tencent.mobileqq.kandian.base.view.widget.ticker.c f239197f;

    /* renamed from: h, reason: collision with root package name */
    private final ValueAnimator f239198h;

    /* renamed from: i, reason: collision with root package name */
    private final Rect f239199i;

    /* renamed from: m, reason: collision with root package name */
    private String f239200m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TickerView.this.f239197f.g(valueAnimator.getAnimatedFraction());
            TickerView.this.c();
            TickerView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TickerView.this.f239197f.f();
            TickerView.this.c();
            TickerView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        int f239203a;

        /* renamed from: b, reason: collision with root package name */
        int f239204b;

        /* renamed from: c, reason: collision with root package name */
        float f239205c;

        /* renamed from: d, reason: collision with root package name */
        float f239206d;

        /* renamed from: e, reason: collision with root package name */
        float f239207e;

        /* renamed from: f, reason: collision with root package name */
        String f239208f;

        /* renamed from: g, reason: collision with root package name */
        int f239209g = -16777216;

        /* renamed from: h, reason: collision with root package name */
        float f239210h;

        /* renamed from: i, reason: collision with root package name */
        int f239211i;

        c(Resources resources) {
            if (resources != null) {
                this.f239210h = TypedValue.applyDimension(2, 12.0f, resources.getDisplayMetrics());
            }
            this.f239203a = 8388611;
        }

        void a(TypedArray typedArray) {
            this.f239203a = typedArray.getInt(j52.a.f409413p6, this.f239203a);
            this.f239204b = typedArray.getColor(j52.a.f409431r6, this.f239204b);
            this.f239205c = typedArray.getFloat(j52.a.f409440s6, this.f239205c);
            this.f239206d = typedArray.getFloat(j52.a.f409449t6, this.f239206d);
            this.f239207e = typedArray.getFloat(j52.a.f409458u6, this.f239207e);
            this.f239208f = typedArray.getString(j52.a.f409422q6);
            this.f239209g = typedArray.getColor(j52.a.f409404o6, this.f239209g);
            this.f239210h = typedArray.getDimension(j52.a.f409387m6, this.f239210h);
            this.f239211i = typedArray.getInt(j52.a.f409395n6, this.f239211i);
        }
    }

    public TickerView(Context context) {
        super(context);
        TextPaint textPaint = new TextPaint(1);
        this.f239195d = textPaint;
        d dVar = new d(textPaint);
        this.f239196e = dVar;
        this.f239197f = new com.tencent.mobileqq.kandian.base.view.widget.ticker.c(dVar);
        this.f239198h = ValueAnimator.ofFloat(1.0f);
        this.f239199i = new Rect();
        f(context, null, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        boolean z16;
        boolean z17 = true;
        if (this.C != e()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.D == d()) {
            z17 = false;
        }
        if (z16 || z17) {
            requestLayout();
        }
    }

    private int d() {
        return ((int) this.f239196e.b()) + getPaddingTop() + getPaddingBottom();
    }

    private int e() {
        float e16;
        if (this.L) {
            e16 = this.f239197f.d();
        } else {
            e16 = this.f239197f.e();
        }
        return ((int) e16) + getPaddingLeft() + getPaddingRight();
    }

    private void h() {
        this.f239196e.e();
        c();
        invalidate();
    }

    private void i(Canvas canvas) {
        j(canvas, this.E, this.f239199i, this.f239197f.d(), this.f239196e.b());
    }

    static void j(Canvas canvas, int i3, Rect rect, float f16, float f17) {
        float f18;
        float f19;
        int width = rect.width();
        int height = rect.height();
        if ((i3 & 16) == 16) {
            f18 = rect.top + ((height - f17) / 2.0f);
        } else {
            f18 = 0.0f;
        }
        if ((i3 & 1) == 1) {
            f19 = rect.left + ((width - f16) / 2.0f);
        } else {
            f19 = 0.0f;
        }
        if ((i3 & 48) == 48) {
            f18 = 0.0f;
        }
        if ((i3 & 80) == 80) {
            f18 = rect.top + (height - f17);
        }
        if ((i3 & 8388611) == 8388611) {
            f19 = 0.0f;
        }
        if ((i3 & 8388613) == 8388613) {
            f19 = rect.left + (width - f16);
        }
        canvas.translate(f19, f18);
        canvas.clipRect(0.0f, 0.0f, f16, f17);
    }

    protected void f(Context context, AttributeSet attributeSet, int i3, int i16) {
        c cVar = new c(context.getResources());
        int[] iArr = j52.a.f409371k6;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i3, i16);
        int resourceId = obtainStyledAttributes.getResourceId(j52.a.f409379l6, -1);
        if (resourceId != -1) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, iArr);
            cVar.a(obtainStyledAttributes2);
            obtainStyledAttributes2.recycle();
        }
        cVar.a(obtainStyledAttributes);
        this.K = N;
        this.J = obtainStyledAttributes.getInt(j52.a.f409474w6, ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID);
        this.L = obtainStyledAttributes.getBoolean(j52.a.f409466v6, false);
        this.E = cVar.f239203a;
        int i17 = cVar.f239204b;
        if (i17 != 0) {
            this.f239195d.setShadowLayer(cVar.f239207e, cVar.f239205c, cVar.f239206d, i17);
        }
        int i18 = cVar.f239211i;
        if (i18 != 0) {
            this.H = i18;
            setTypeface(this.f239195d.getTypeface());
        }
        setTextColor(cVar.f239209g);
        setTextSize(cVar.f239210h);
        int i19 = obtainStyledAttributes.getInt(j52.a.f409483x6, 0);
        if (i19 != 1) {
            if (i19 != 2) {
                if (isInEditMode()) {
                    setCharacterLists(x52.b.b());
                }
            } else {
                setCharacterLists(x52.b.a());
            }
        } else {
            setCharacterLists(x52.b.b());
        }
        int i26 = obtainStyledAttributes.getInt(j52.a.f409492y6, 0);
        if (i26 != 0) {
            if (i26 != 1) {
                if (i26 == 2) {
                    this.f239196e.f(2);
                } else {
                    throw new IllegalArgumentException("Unsupported ticker_defaultPreferredScrollingDirection: " + i26);
                }
            } else {
                this.f239196e.f(1);
            }
        } else {
            this.f239196e.f(0);
        }
        if (g()) {
            setText(cVar.f239208f, false);
        } else {
            this.M = cVar.f239208f;
        }
        obtainStyledAttributes.recycle();
        this.f239198h.addUpdateListener(new a());
        this.f239198h.addListener(new b());
    }

    public boolean g() {
        if (this.f239197f.b() != null) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        i(canvas);
        canvas.translate(0.0f, this.f239196e.a());
        this.f239197f.a(canvas, this.f239195d);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        this.C = e();
        this.D = d();
        setMeasuredDimension(View.resolveSize(this.C, i3), View.resolveSize(this.D, i16));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.f239199i.set(getPaddingLeft(), getPaddingTop(), i3 - getPaddingRight(), i16 - getPaddingBottom());
    }

    public void setAnimateMeasurementChange(boolean z16) {
        this.L = z16;
    }

    public void setAnimationDelay(long j3) {
        this.I = j3;
    }

    public void setAnimationDuration(long j3) {
        this.J = j3;
    }

    public void setAnimationInterpolator(Interpolator interpolator) {
        this.K = interpolator;
    }

    public void setCharacterLists(String... strArr) {
        this.f239197f.h(strArr);
        String str = this.M;
        if (str != null) {
            setText(str, false);
            this.M = null;
        }
    }

    public void setCustomCharacterList(ArrayList<String> arrayList) {
        this.f239197f.i(arrayList);
    }

    public void setDigitalAnimWidthSpeedIncrement(boolean z16) {
        this.f239197f.j(z16);
    }

    public void setGravity(int i3) {
        if (this.E != i3) {
            this.E = i3;
            invalidate();
        }
    }

    public void setIgnoreWidthAnim(boolean z16) {
        this.f239197f.k(z16);
    }

    public void setPreferredScrollingDirection(int i3) {
        this.f239196e.f(i3);
    }

    public void setText(String str) {
        setText(str, !TextUtils.isEmpty(this.f239200m));
    }

    public void setTextColor(int i3) {
        if (this.F != i3) {
            this.F = i3;
            this.f239195d.setColor(i3);
            invalidate();
        }
    }

    public void setTextSize(float f16) {
        if (this.G != f16) {
            this.G = f16;
            this.f239195d.setTextSize(f16);
            h();
        }
    }

    public void setTypeface(Typeface typeface) {
        int i3 = this.H;
        if (i3 == 3) {
            typeface = Typeface.create(typeface, 3);
        } else if (i3 == 1) {
            typeface = Typeface.create(typeface, 1);
        } else if (i3 == 2) {
            typeface = Typeface.create(typeface, 2);
        }
        this.f239195d.setTypeface(typeface);
        h();
    }

    public void setText(String str, boolean z16) {
        if (TextUtils.equals(str, this.f239200m)) {
            return;
        }
        this.f239200m = str;
        this.f239197f.l(str == null ? new char[0] : str.toCharArray());
        setContentDescription(str);
        if (z16) {
            if (this.f239198h.isRunning()) {
                this.f239198h.cancel();
            }
            this.f239198h.setStartDelay(this.I);
            this.f239198h.setDuration(this.J);
            this.f239198h.setInterpolator(this.K);
            this.f239198h.start();
            return;
        }
        this.f239197f.g(1.0f);
        this.f239197f.f();
        c();
        invalidate();
    }

    public TickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TextPaint textPaint = new TextPaint(1);
        this.f239195d = textPaint;
        d dVar = new d(textPaint);
        this.f239196e = dVar;
        this.f239197f = new com.tencent.mobileqq.kandian.base.view.widget.ticker.c(dVar);
        this.f239198h = ValueAnimator.ofFloat(1.0f);
        this.f239199i = new Rect();
        f(context, attributeSet, 0, 0);
    }

    public TickerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        TextPaint textPaint = new TextPaint(1);
        this.f239195d = textPaint;
        d dVar = new d(textPaint);
        this.f239196e = dVar;
        this.f239197f = new com.tencent.mobileqq.kandian.base.view.widget.ticker.c(dVar);
        this.f239198h = ValueAnimator.ofFloat(1.0f);
        this.f239199i = new Rect();
        f(context, attributeSet, i3, 0);
    }
}
