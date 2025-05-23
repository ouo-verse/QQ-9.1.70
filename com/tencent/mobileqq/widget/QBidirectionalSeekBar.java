package com.tencent.mobileqq.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QBidirectionalSeekBar extends View {

    /* renamed from: d0, reason: collision with root package name */
    private static final int f316020d0;

    /* renamed from: e0, reason: collision with root package name */
    private static final int f316021e0;

    /* renamed from: f0, reason: collision with root package name */
    private static final int f316022f0;

    /* renamed from: g0, reason: collision with root package name */
    private static final int f316023g0;

    /* renamed from: h0, reason: collision with root package name */
    private static final int f316024h0;

    /* renamed from: i0, reason: collision with root package name */
    private static int f316025i0;

    /* renamed from: j0, reason: collision with root package name */
    private static int f316026j0;
    private View C;
    private View D;
    private final Paint E;
    private final Paint F;
    private final a G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private float P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private long U;
    private boolean V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f316027a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f316028b0;

    /* renamed from: c0, reason: collision with root package name */
    private b f316029c0;

    /* renamed from: d, reason: collision with root package name */
    private WindowManager f316030d;

    /* renamed from: e, reason: collision with root package name */
    private WindowManager.LayoutParams f316031e;

    /* renamed from: f, reason: collision with root package name */
    private WindowManager.LayoutParams f316032f;

    /* renamed from: h, reason: collision with root package name */
    private WindowManager.LayoutParams f316033h;

    /* renamed from: i, reason: collision with root package name */
    private Bitmap f316034i;

    /* renamed from: m, reason: collision with root package name */
    private View f316035m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f316036a;

        /* renamed from: b, reason: collision with root package name */
        public int f316037b;

        a() {
        }

        public void a(int[] iArr) {
            if (iArr != null && iArr.length == 2) {
                this.f316036a = iArr[0];
                this.f316037b = iArr[1];
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
        void onChange(int i3, int i16);
    }

    static {
        int parseColor = Color.parseColor("#00CEFF");
        f316020d0 = parseColor;
        f316021e0 = Color.parseColor("#0099FF");
        f316022f0 = Color.parseColor("#0066CC");
        int parseColor2 = Color.parseColor("#EBEBEB");
        f316023g0 = parseColor2;
        f316024h0 = Color.parseColor("#999999");
        f316025i0 = parseColor2;
        f316026j0 = parseColor;
    }

    public QBidirectionalSeekBar(Context context) {
        this(context, null);
    }

    private void a() {
        if (QQTheme.isNowThemeIsNight()) {
            f316026j0 = f316022f0;
            f316025i0 = f316024h0;
        } else if (QQTheme.isNowSimpleUI()) {
            f316026j0 = f316021e0;
            f316025i0 = f316023g0;
        } else {
            f316026j0 = f316020d0;
            f316025i0 = f316023g0;
        }
        if (!QQTheme.isNowThemeIsNight()) {
            QQTheme.isNowSimpleUI();
        }
        View view = this.f316035m;
        if (view != null) {
            view.setBackgroundResource(R.drawable.qui_common_bubble_blue_bg);
        }
        View view2 = this.C;
        if (view2 != null) {
            view2.setBackgroundResource(R.drawable.qui_common_bubble_blue_bg);
        }
        View view3 = this.D;
        if (view3 != null) {
            view3.setBackgroundResource(R.drawable.qui_common_bubble_blue_bg);
        }
    }

    private void b() {
        boolean z16;
        int f16 = BaseAIOUtils.f(40.0f, getResources());
        int f17 = BaseAIOUtils.f(32.0f, getResources());
        int f18 = BaseAIOUtils.f(32.0f, getResources());
        int f19 = BaseAIOUtils.f(8.0f, getResources());
        a aVar = this.G;
        int i3 = aVar.f316037b;
        int i16 = this.M;
        int i17 = f16 / 2;
        int i18 = f18 - i17;
        this.I = ((i3 - i16) - i18) + f19;
        float f26 = i17;
        float f27 = this.P;
        int i19 = this.S;
        int i26 = this.R;
        int i27 = aVar.f316036a;
        float f28 = f17 / 2;
        this.H = (int) (((((i19 * f27) / i26) + f26) + i27) - f28);
        this.K = ((i3 - i16) - i18) + f19;
        this.J = (int) (((((this.T * f27) / i26) + f26) + i27) - f28);
        this.L = (int) (((f26 + ((f27 * ((i19 + r2) / 2)) / i26)) + i27) - (BaseAIOUtils.f(47.0f, getResources()) / 2));
        if (this.f316035m != null && this.C != null) {
            boolean z17 = this.W;
            if (Math.abs(this.H - this.J) < f17 && this.S != this.T) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.W = z16;
            if (z16 != z17 && System.currentTimeMillis() - this.U < BaseAIOUtils.f(200.0f, getResources())) {
                this.W = z17;
            } else {
                this.U = System.currentTimeMillis();
            }
        }
    }

    private void c() {
        View view = this.f316035m;
        if (view != null) {
            s(view, false, 100);
        }
        View view2 = this.C;
        if (view2 != null) {
            s(view2, false, 100);
        }
        View view3 = this.D;
        if (view3 != null) {
            s(view3, false, 100);
        }
    }

    private void d(Canvas canvas) {
        int f16 = BaseAIOUtils.f(40.0f, getResources()) / 2;
        int f17 = BaseAIOUtils.f(3.0f, getResources()) / 2;
        RectF rectF = new RectF(f16, r0 - f17, this.N - f16, r0 + f17);
        float f18 = f17;
        canvas.drawRoundRect(rectF, f18, f18, this.E);
    }

    private void e(Canvas canvas) {
        int f16 = BaseAIOUtils.f(40.0f, getResources());
        float f17 = this.P;
        int i3 = this.R;
        float f18 = f16 / 2;
        float f19 = ((this.S * f17) / i3) + f18;
        float f26 = ((f17 * this.T) / i3) + f18;
        int f27 = BaseAIOUtils.f(3.0f, getResources()) / 2;
        RectF rectF = new RectF(f19, f16 - f27, f26, f16 + f27);
        float f28 = f27;
        canvas.drawRoundRect(rectF, f28, f28, this.F);
    }

    private void f() {
        b();
        i();
        h();
        j();
        u();
    }

    private void g(Canvas canvas) {
        int i3;
        int i16;
        if (this.f316034i == null) {
            return;
        }
        int f16 = BaseAIOUtils.f(40.0f, getResources());
        int f17 = BaseAIOUtils.f(2.0f, getResources());
        float f18 = this.P;
        if (this.V) {
            i3 = this.T;
        } else {
            i3 = this.S;
        }
        float f19 = (f16 / 2) + f17;
        canvas.drawBitmap(this.f316034i, (f18 * i3) / this.R, f19, (Paint) null);
        float f26 = this.P;
        if (this.V) {
            i16 = this.S;
        } else {
            i16 = this.T;
        }
        canvas.drawBitmap(this.f316034i, (f26 * i16) / this.R, f19, (Paint) null);
    }

    private void h() {
        View view = this.C;
        if (view == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = this.f316032f;
        layoutParams.x = this.J;
        layoutParams.y = this.K;
        if (view.getParent() == null) {
            this.f316030d.addView(this.C, this.f316032f);
        } else {
            this.f316030d.updateViewLayout(this.C, this.f316032f);
        }
        this.C.setVisibility(8);
        this.C.clearAnimation();
        this.C.setAlpha(1.0f);
    }

    private void i() {
        View view = this.f316035m;
        if (view == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = this.f316031e;
        layoutParams.x = this.H;
        layoutParams.y = this.I;
        if (view.getParent() == null) {
            this.f316030d.addView(this.f316035m, this.f316031e);
        } else {
            this.f316030d.updateViewLayout(this.f316035m, this.f316031e);
        }
        this.f316035m.setVisibility(8);
        this.f316035m.clearAnimation();
        this.f316035m.setAlpha(1.0f);
    }

    private void j() {
        boolean z16;
        View view = this.D;
        if (view == null) {
            return;
        }
        if (this.f316027a0 && this.W && this.S != this.T) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (view.getParent() != null) {
                this.f316030d.removeViewImmediate(this.D);
                return;
            }
            return;
        }
        WindowManager.LayoutParams layoutParams = this.f316033h;
        layoutParams.x = this.L;
        layoutParams.y = this.I;
        layoutParams.width = BaseAIOUtils.f(47.0f, getResources());
        if (this.D.getParent() == null) {
            this.f316030d.addView(this.D, this.f316033h);
        } else {
            this.f316030d.updateViewLayout(this.D, this.f316033h);
        }
        this.D.setVisibility(0);
        this.D.clearAnimation();
        this.D.setAlpha(1.0f);
    }

    private void l(MotionEvent motionEvent) {
        int x16 = (int) (motionEvent.getX() - (BaseAIOUtils.f(40.0f, getResources()) / 2));
        int i3 = this.R;
        int i16 = (int) ((x16 * i3) / this.P);
        if (this.V) {
            if (i16 < 0) {
                this.S = 0;
                return;
            } else {
                this.S = Math.min(i16, this.T);
                return;
            }
        }
        int i17 = this.S;
        if (i16 < i17) {
            this.T = i17;
        } else {
            this.T = Math.min(i16, i3);
        }
    }

    private void m(View view) {
        if (view == null) {
            return;
        }
        view.setVisibility(8);
        if (view.getParent() != null) {
            this.f316030d.removeViewImmediate(view);
        }
    }

    private void o(WindowManager.LayoutParams layoutParams) {
        layoutParams.gravity = 8388659;
        layoutParams.width = BaseAIOUtils.f(32.0f, getResources());
        layoutParams.height = BaseAIOUtils.f(32.0f, getResources());
        layoutParams.format = -3;
        layoutParams.flags = 40;
    }

    private void p(Context context) {
        this.f316030d = (WindowManager) context.getSystemService("window");
        this.f316035m = LayoutInflater.from(getContext()).inflate(R.layout.e3c, (ViewGroup) null);
        this.C = LayoutInflater.from(getContext()).inflate(R.layout.e3c, (ViewGroup) null);
        this.D = LayoutInflater.from(getContext()).inflate(R.layout.e3c, (ViewGroup) null);
        this.f316033h = new WindowManager.LayoutParams();
        this.f316031e = new WindowManager.LayoutParams();
        this.f316032f = new WindowManager.LayoutParams();
        o(this.f316033h);
        o(this.f316031e);
        o(this.f316032f);
    }

    private void q(Context context) {
        this.f316034i = t();
        p(context);
        a();
        this.F.setColor(context.getResources().getColor(R.color.qui_common_brand_standard));
        this.E.setColor(f316025i0);
        this.M = ImmersiveUtils.getStatusBarHeight(getContext());
    }

    private boolean r(MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        int f16 = BaseAIOUtils.f(40.0f, getResources());
        int f17 = BaseAIOUtils.f(5.0f, getResources());
        float x16 = motionEvent.getX();
        float f18 = f16 / 2;
        if (motionEvent.getY() < f18) {
            return false;
        }
        float f19 = this.P;
        int i3 = this.R;
        float f26 = ((this.S * f19) / i3) + f18;
        float f27 = ((f19 * this.T) / i3) + f18;
        float f28 = f17;
        if (x16 > (f26 - f18) - f28 && x16 < f26 + f18 + f28) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (x16 > (f27 - f18) - f28 && x16 < f27 + f16 + f28) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (this.V) {
            if (z16) {
                this.V = true;
                return true;
            }
            if (z17) {
                this.V = false;
                return true;
            }
        } else {
            if (z17) {
                this.V = false;
                return true;
            }
            if (z16) {
                this.V = true;
                return true;
            }
        }
        return false;
    }

    private void s(View view, boolean z16, int i3) {
        float f16;
        float[] fArr = new float[2];
        float f17 = 0.0f;
        if (z16) {
            f16 = 0.0f;
        } else {
            f16 = 1.0f;
        }
        fArr[0] = f16;
        if (z16) {
            f17 = 1.0f;
        }
        fArr[1] = f17;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, fArr);
        ofFloat.setDuration(i3);
        ofFloat.start();
    }

    private Bitmap t() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.jhy, options);
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = false;
        options2.inSampleSize = (int) (options.outWidth / 40.0f);
        return BitmapFactory.decodeResource(getResources(), R.drawable.jhy, options2);
    }

    private void u() {
        boolean z16;
        int i3;
        String valueOf = String.valueOf(this.S + this.Q);
        String valueOf2 = String.valueOf(this.T + this.Q);
        View view = this.f316035m;
        int i16 = 8;
        boolean z17 = true;
        if (view != null && view.getParent() != null) {
            if (this.f316027a0 && (!this.W || this.S == this.T)) {
                z16 = true;
            } else {
                z16 = false;
            }
            View view2 = this.f316035m;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view2.setVisibility(i3);
            ((TextView) this.f316035m).setText(valueOf);
        }
        View view3 = this.C;
        if (view3 != null && view3.getParent() != null) {
            if (!this.f316027a0 || this.W || this.S == this.T) {
                z17 = false;
            }
            View view4 = this.C;
            if (z17) {
                i16 = 0;
            }
            view4.setVisibility(i16);
            ((TextView) this.C).setText(valueOf2);
        }
        View view5 = this.D;
        if (view5 != null && view5.getParent() != null) {
            ((TextView) this.D).setText(valueOf + "-" + valueOf2);
        }
        b bVar = this.f316029c0;
        if (bVar != null) {
            int i17 = this.S;
            int i18 = this.Q;
            bVar.onChange(i17 + i18, this.T + i18);
        }
    }

    public boolean k() {
        return this.f316028b0;
    }

    public void n(int i3, int i16, b bVar) {
        this.Q = i3;
        this.S = 0;
        int i17 = i16 - i3;
        this.R = i17;
        this.T = i17;
        if (i17 == 0) {
            this.V = false;
        }
        this.f316029c0 = bVar;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d(canvas);
        e(canvas);
        g(canvas);
        f();
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        this.N = size;
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824) {
                    this.N = size;
                }
            } else {
                this.N = BaseAIOUtils.f(100.0f, getResources());
            }
        } else {
            this.N = Math.min(BaseAIOUtils.f(100.0f, getResources()), size);
        }
        setMeasuredDimension(this.N, BaseAIOUtils.f(60.0f, getResources()));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.P = this.N - BaseAIOUtils.f(40.0f, getResources());
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        this.G.a(iArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
    
        if (r1 != 3) goto L19;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f316028b0 = true;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    this.f316027a0 = true;
                    int i3 = this.S;
                    int i16 = this.T;
                    l(motionEvent);
                    if (i3 != this.S || i16 != this.T) {
                        invalidate();
                    }
                }
            }
            this.f316027a0 = false;
            c();
        } else {
            performClick();
            getParent().requestDisallowInterceptTouchEvent(true);
            if (!r(motionEvent)) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i3) {
        if (i3 != 0) {
            m(this.f316035m);
            m(this.C);
            m(this.D);
        }
        super.onVisibilityChanged(view, i3);
    }

    public void v(int i3, int i16) {
        int i17 = this.Q;
        int i18 = i3 - i17;
        this.S = i18;
        int i19 = i16 - i17;
        this.T = i19;
        if (i19 == i18 && i18 == 0) {
            this.V = false;
        }
        invalidate();
    }

    public QBidirectionalSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QBidirectionalSeekBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.E = new Paint(1);
        this.F = new Paint(1);
        this.G = new a();
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.Q = 0;
        this.R = 100;
        this.S = 0;
        this.T = 100;
        this.U = 0L;
        this.V = true;
        this.W = false;
        this.f316027a0 = false;
        this.f316028b0 = false;
        q(context);
    }
}
