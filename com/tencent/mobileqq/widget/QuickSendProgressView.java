package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/* loaded from: classes20.dex */
public class QuickSendProgressView extends View {
    private int C;
    private int D;
    private int E;
    private Drawable F;
    private Drawable G;
    private Drawable H;
    private Drawable I;
    private RectF J;
    private Rect K;
    private Path L;
    private Paint M;
    private Paint N;
    private int P;
    private int Q;
    private int R;
    private int S;
    private String T;
    private boolean U;
    private RefreshProgressRunnable V;

    /* renamed from: d, reason: collision with root package name */
    private int f316133d;

    /* renamed from: e, reason: collision with root package name */
    private int f316134e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f316135f;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f316136h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f316137i;

    /* renamed from: m, reason: collision with root package name */
    private int f316138m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static class RefreshProgressRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QuickSendProgressView> f316139d;

        /* renamed from: e, reason: collision with root package name */
        private volatile long f316140e;

        /* renamed from: f, reason: collision with root package name */
        private long f316141f = 800;

        /* renamed from: h, reason: collision with root package name */
        private volatile boolean f316142h;

        public RefreshProgressRunnable() {
            this.f316140e = -1L;
            this.f316142h = true;
            this.f316140e = -1L;
            this.f316142h = true;
        }

        public boolean e() {
            return !this.f316142h;
        }

        public void f(QuickSendProgressView quickSendProgressView) {
            if (!e() && quickSendProgressView != null) {
                this.f316140e = -1L;
                this.f316142h = false;
                this.f316139d = new WeakReference<>(quickSendProgressView);
                ViewCompat.postOnAnimation(quickSendProgressView, this);
            }
        }

        public void g() {
            this.f316142h = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            QuickSendProgressView quickSendProgressView;
            if (this.f316142h) {
                if (QLog.isColorLevel()) {
                    QLog.e("QuickSendProgressView", 2, " stopAnim in isStopped");
                }
                this.f316139d = null;
                return;
            }
            WeakReference<QuickSendProgressView> weakReference = this.f316139d;
            if (weakReference != null && (quickSendProgressView = weakReference.get()) != null) {
                if (this.f316140e == -1) {
                    this.f316140e = SystemClock.uptimeMillis();
                }
                long uptimeMillis = SystemClock.uptimeMillis() - this.f316140e;
                long j3 = this.f316141f;
                if (uptimeMillis >= j3) {
                    quickSendProgressView.k(1.0f);
                    this.f316140e = SystemClock.uptimeMillis();
                } else {
                    quickSendProgressView.k((((float) uptimeMillis) * 1.0f) / ((float) j3));
                }
                if (!this.f316142h) {
                    ViewCompat.postOnAnimation(quickSendProgressView, this);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("QuickSendProgressView", 2, "mView is null, stopAnim in isStopped");
            }
            this.f316142h = true;
            this.f316139d = null;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes20.dex */
    public @interface Status {
        public static final int STATUS_NORMAL = 0;
        public static final int STATUS_SENDING = 1;
        public static final int STATUS_SEND_FAIL = 2;
        public static final int STATUS_SUCCESS = 3;
    }

    public QuickSendProgressView(Context context) {
        super(context);
        this.f316133d = 0;
        this.f316134e = 0;
        this.U = false;
        i();
    }

    private int b(float f16, Resources resources) {
        return (int) ((resources.getDisplayMetrics().density * f16) + 0.5f);
    }

    private void c(Canvas canvas) {
        Drawable drawable;
        int width = getWidth();
        int height = getHeight();
        if (width > 0 && height > 0) {
            int min = Math.min(width, height);
            if (this.f316133d == 0) {
                Rect rect = this.K;
                int i3 = this.Q;
                rect.set(0, 0, min - (i3 * 2), min - (i3 * 2));
            } else {
                Rect rect2 = this.K;
                int i16 = this.P;
                int i17 = this.Q;
                rect2.set(0, 0, (min - (i16 * 2)) - (i17 * 2), (min - (i16 * 2)) - (i17 * 2));
            }
            Rect rect3 = this.K;
            rect3.offset((min - rect3.width()) / 2, (min - this.K.height()) / 2);
            canvas.save();
            int i18 = this.f316133d;
            if (i18 != 0) {
                if (i18 != 1) {
                    if (i18 != 2) {
                        drawable = null;
                    } else {
                        drawable = this.f316137i;
                    }
                } else {
                    drawable = this.f316136h;
                }
            } else {
                drawable = this.f316135f;
            }
            if (drawable != null) {
                drawable.setBounds(this.K);
                this.L.reset();
                this.L.addCircle(this.K.centerX(), this.K.centerY(), (this.K.width() * 1.0f) / 2.0f, Path.Direction.CCW);
                canvas.clipPath(this.L);
                drawable.draw(canvas);
            }
            canvas.restore();
        }
    }

    private void d(Canvas canvas, Drawable drawable) {
        if (drawable != null) {
            int width = getWidth();
            int height = getHeight();
            if (width > 0 && height > 0) {
                this.I = drawable;
                int min = Math.min(width, height);
                canvas.save();
                this.L.reset();
                Rect rect = this.K;
                int i3 = this.P;
                int i16 = this.Q;
                rect.set(0, 0, (min - (i3 * 2)) - (i16 * 2), (min - (i3 * 2)) - (i16 * 2));
                Rect rect2 = this.K;
                rect2.offset((min - rect2.width()) / 2, (min - this.K.height()) / 2);
                this.L.addCircle(this.K.centerX(), this.K.centerY(), (this.K.width() * 1.0f) / 2.0f, Path.Direction.CCW);
                canvas.clipPath(this.L);
                if (this.f316133d == 0) {
                    Rect rect3 = this.K;
                    int i17 = this.Q;
                    int i18 = this.R;
                    rect3.set(0, 0, (min - (i17 * 2)) - (i18 * 2), (min - (i17 * 2)) - (i18 * 2));
                } else {
                    Rect rect4 = this.K;
                    int i19 = this.P;
                    int i26 = this.Q;
                    int i27 = this.R;
                    rect4.set(0, 0, ((min - (i19 * 2)) - (i26 * 2)) - (i27 * 2), ((min - (i19 * 2)) - (i26 * 2)) - (i27 * 2));
                }
                Rect rect5 = this.K;
                rect5.offset((min - rect5.width()) / 2, (min - this.K.height()) / 2);
                drawable.setBounds(this.K);
                canvas.translate(this.S, -r0);
                drawable.draw(canvas);
                canvas.restore();
            }
        }
    }

    private void e(Canvas canvas, @ColorInt int i3) {
        int width = getWidth();
        int height = getHeight();
        if (width > 0 && height > 0) {
            int min = Math.min(width, height);
            this.M.setColor(i3);
            RectF rectF = this.J;
            int i16 = this.Q;
            rectF.set(i16, i16, min - i16, min - i16);
            canvas.drawArc(this.J, -90.0f, ((this.f316134e * 1.0f) / 100.0f) * 360.0f, false, this.M);
        }
    }

    private void f(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        if (width > 0 && height > 0) {
            int i3 = this.f316133d;
            if (i3 != 1 && i3 != 2) {
                return;
            }
            if (i3 != 1) {
                if (i3 == 2) {
                    this.M.setColor(this.E);
                }
            } else {
                this.M.setColor(this.D);
            }
            int min = Math.min(width, height);
            RectF rectF = this.J;
            int i16 = this.Q;
            rectF.set(i16, i16, min - i16, min - i16);
            canvas.drawArc(this.J, 0.0f, 360.0f, false, this.M);
        }
    }

    private void g(Canvas canvas) {
        if (this.T != null) {
            int width = getWidth();
            int height = getHeight();
            if (width > 0 && height > 0) {
                canvas.drawText(this.T, 0.0f, Math.min(width, height) / 2.0f, this.N);
            }
        }
    }

    private float h(float f16, float f17, float f18) {
        return f17 + (f16 * (f18 - f17));
    }

    private boolean j(Drawable drawable) {
        if (drawable != null && drawable.isStateful() && drawable.setState(StateSet.NOTHING)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(float f16) {
        int width = getWidth();
        int height = getHeight();
        if (width > 0 && height > 0) {
            int min = Math.min(width, height);
            this.S = (int) Math.ceil(h(f16, (-min) / 2.0f, min / 2.0f));
            invalidate();
        }
    }

    private void l(Drawable drawable) {
        if (drawable != null && drawable.isStateful() && drawable.setState(getDrawableState())) {
            invalidateDrawable(drawable);
        }
    }

    private void m() {
        j(this.f316135f);
        j(this.f316136h);
        j(this.f316137i);
        j(this.I);
    }

    private void n() {
        l(this.f316135f);
        l(this.f316136h);
        l(this.f316137i);
        l(this.I);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        n();
    }

    public void i() {
        this.U = false;
        this.Q = b(2.0f, getResources());
        this.P = b(3.0f, getResources());
        this.R = b(1.0f, getResources());
        this.T = getResources().getString(R.string.f214845u0);
        this.f316135f = getResources().getDrawable(R.drawable.hgy);
        this.f316138m = Color.parseColor("#19BAFF");
        this.f316136h = getResources().getDrawable(R.drawable.f161890hh0);
        this.D = Color.parseColor("#3300CAFC");
        this.E = Color.parseColor("#33FF596A");
        this.f316137i = getResources().getDrawable(R.drawable.hgw);
        this.C = Color.parseColor("#FF596A");
        Paint paint = new Paint();
        this.M = paint;
        paint.setStrokeWidth(this.Q);
        this.M.setStyle(Paint.Style.STROKE);
        this.M.setAntiAlias(true);
        this.M.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.N = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.N.setAntiAlias(true);
        this.N.setTextSize(b(14.0f, getResources()));
        this.N.setColor(getResources().getColor(R.color.common_text_gray));
        this.K = new Rect();
        this.J = new RectF();
        this.L = new Path();
        this.F = getResources().getDrawable(R.drawable.hgz);
        this.G = getResources().getDrawable(R.drawable.f161891hh1);
        this.H = getResources().getDrawable(R.drawable.hgx);
        setContentDescription(getResources().getString(R.string.f214835tz));
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.I;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f316135f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f316136h;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
        Drawable drawable4 = this.f316137i;
        if (drawable4 != null) {
            drawable4.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        RefreshProgressRunnable refreshProgressRunnable = this.V;
        if (refreshProgressRunnable != null) {
            refreshProgressRunnable.g();
            this.V = null;
        }
        if (this.f316133d == 1) {
            RefreshProgressRunnable refreshProgressRunnable2 = new RefreshProgressRunnable();
            this.V = refreshProgressRunnable2;
            refreshProgressRunnable2.f(this);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RefreshProgressRunnable refreshProgressRunnable = this.V;
        if (refreshProgressRunnable != null) {
            refreshProgressRunnable.g();
            this.V = null;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.I = null;
        c(canvas);
        f(canvas);
        int i3 = this.f316133d;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    d(canvas, this.F);
                    return;
                } else {
                    g(canvas);
                    return;
                }
            }
            d(canvas, this.H);
            e(canvas, this.C);
            return;
        }
        d(canvas, this.G);
        e(canvas, this.f316138m);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int intrinsicWidth;
        int intrinsicHeight;
        String str;
        Paint paint;
        Drawable drawable = this.F;
        if (drawable == null) {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        } else {
            intrinsicWidth = drawable.getIntrinsicWidth();
            intrinsicHeight = this.F.getIntrinsicHeight();
            if (intrinsicWidth <= 0) {
                intrinsicWidth = 1;
            }
            if (intrinsicHeight <= 0) {
                intrinsicHeight = 1;
            }
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i17 = paddingLeft + paddingRight;
        int i18 = this.P;
        int i19 = this.Q;
        int i26 = this.R;
        int max = Math.max(intrinsicWidth + i17 + (i18 * 2) + (i19 * 2) + (i26 * 2), getSuggestedMinimumWidth());
        int max2 = Math.max(intrinsicHeight + paddingTop + paddingBottom + (i18 * 2) + (i19 * 2) + (i26 * 2), getSuggestedMinimumHeight());
        int resolveSizeAndState = View.resolveSizeAndState(max, i3, 0);
        int resolveSizeAndState2 = View.resolveSizeAndState(max2, i16, 0);
        if (this.U && (str = this.T) != null && (paint = this.N) != null) {
            resolveSizeAndState = Math.max(resolveSizeAndState, ((int) paint.measureText(str)) + this.Q);
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    public void setProgress(@IntRange(from = 0, to = 100) int i3) {
        if (this.f316134e == i3) {
            return;
        }
        this.f316134e = i3;
        if (i3 >= 100) {
            this.f316134e = 100;
        }
        invalidate();
    }

    public void setSpacing(int i3) {
        this.P = i3;
    }

    public void setStatus(int i3) {
        setStatus(i3, true);
    }

    public void setSuccessText(String str) {
        this.T = str;
    }

    public void setmArcStrokeWidth(int i3) {
        this.Q = i3;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        boolean z16;
        if (drawable != null && (this.f316135f == drawable || this.f316136h == drawable || this.f316137i == drawable || this.I == drawable)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || super.verifyDrawable(drawable)) {
            return true;
        }
        return false;
    }

    public void setStatus(int i3, boolean z16) {
        if (this.f316133d == i3) {
            return;
        }
        this.S = 0;
        this.f316133d = i3;
        if (i3 == 0) {
            setContentDescription(getResources().getString(R.string.f214835tz));
        } else if (i3 == 1) {
            setContentDescription(getResources().getString(R.string.f214825ty));
        } else if (i3 == 2) {
            setContentDescription(getResources().getString(R.string.h2a));
        } else {
            String str = this.T;
            if (str != null) {
                setContentDescription(str);
            }
        }
        m();
        RefreshProgressRunnable refreshProgressRunnable = this.V;
        if (refreshProgressRunnable != null) {
            refreshProgressRunnable.g();
            this.V = null;
        }
        if (this.f316133d == 1) {
            RefreshProgressRunnable refreshProgressRunnable2 = new RefreshProgressRunnable();
            this.V = refreshProgressRunnable2;
            refreshProgressRunnable2.f(this);
        }
        boolean z17 = this.f316133d == 3;
        if (this.U != z17) {
            this.U = z17;
            requestLayout();
        }
        if (z16) {
            invalidate();
        }
    }

    public QuickSendProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f316133d = 0;
        this.f316134e = 0;
        this.U = false;
        i();
    }

    public QuickSendProgressView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316133d = 0;
        this.f316134e = 0;
        this.U = false;
        i();
    }
}
