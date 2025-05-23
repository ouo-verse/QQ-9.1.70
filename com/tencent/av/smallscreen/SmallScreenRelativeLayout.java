package com.tencent.av.smallscreen;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class SmallScreenRelativeLayout extends RelativeLayout implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, View.OnClickListener {
    boolean C;
    boolean D;
    final int E;
    final int F;
    int G;
    int H;
    final int I;
    final int J;
    int K;
    final int L;
    int M;
    int N;
    int P;
    int Q;
    int R;
    int S;
    int T;
    int U;
    int V;
    int W;

    /* renamed from: a0, reason: collision with root package name */
    b f74503a0;

    /* renamed from: b0, reason: collision with root package name */
    int f74504b0;

    /* renamed from: c0, reason: collision with root package name */
    RectF f74505c0;

    /* renamed from: d, reason: collision with root package name */
    a f74506d;

    /* renamed from: d0, reason: collision with root package name */
    View.OnClickListener f74507d0;

    /* renamed from: e, reason: collision with root package name */
    ValueAnimator f74508e;

    /* renamed from: f, reason: collision with root package name */
    ValueAnimator f74509f;

    /* renamed from: h, reason: collision with root package name */
    Display f74510h;

    /* renamed from: i, reason: collision with root package name */
    boolean f74511i;

    /* renamed from: m, reason: collision with root package name */
    boolean f74512m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        boolean b(SmallScreenRelativeLayout smallScreenRelativeLayout);

        void e(SmallScreenRelativeLayout smallScreenRelativeLayout, int i3, int i16, int i17, int i18);

        int i(SmallScreenRelativeLayout smallScreenRelativeLayout);

        void m(SmallScreenRelativeLayout smallScreenRelativeLayout);

        int o(SmallScreenRelativeLayout smallScreenRelativeLayout);
    }

    public SmallScreenRelativeLayout(Context context) {
        this(context, null);
    }

    private int g() {
        try {
            return this.f74510h.getRotation();
        } catch (Exception e16) {
            AVCoreLog.printErrorLog("SmallScreenRelativeLayout", e16.getMessage());
            return 0;
        }
    }

    public int b() {
        int left;
        int top;
        if (this.V != 0 && this.W != 0) {
            a aVar = this.f74506d;
            if (aVar != null) {
                left = aVar.i(this);
                top = this.f74506d.o(this);
            } else {
                left = getLeft();
                top = getTop();
            }
            this.f74504b0 = f(left, top, left, top);
        }
        return this.f74504b0;
    }

    public boolean c() {
        return this.f74512m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00af, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Point d(int i3) {
        Rect e16 = e();
        Point point = new Point();
        switch (i3) {
            case 0:
                point.x = e16.centerX();
                point.y = e16.centerY();
                break;
            case 1:
                point.x = e16.left;
                point.y = e16.top;
                break;
            case 2:
                point.x = e16.left;
                point.y = e16.top + this.K;
                break;
            case 3:
                point.x = e16.left;
                point.y = e16.centerY();
                break;
            case 4:
                point.x = e16.left;
                point.y = e16.bottom - this.L;
                break;
            case 5:
                point.x = e16.left;
                point.y = e16.bottom;
                break;
            case 6:
                point.x = e16.right;
                point.y = e16.top;
                break;
            case 7:
                point.x = e16.right;
                point.y = e16.top + this.K;
                break;
            case 8:
                point.x = e16.right;
                point.y = e16.centerY();
                break;
            case 9:
                point.x = e16.right;
                point.y = e16.bottom - this.L;
                break;
            case 10:
                point.x = e16.right;
                point.y = e16.bottom;
                break;
            case 11:
                point.x = e16.centerX() / 2;
                point.y = e16.top;
                break;
            case 12:
                point.x = e16.centerX();
                point.y = e16.top;
                break;
            case 13:
                point.x = (e16.centerX() * 3) / 2;
                point.y = e16.top;
                break;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int action = motionEvent.getAction();
        boolean z16 = false;
        if (action == 0) {
            this.f74508e.cancel();
            this.P = rawX;
            this.Q = rawY;
            a aVar = this.f74506d;
            if (aVar != null) {
                this.M = aVar.i(this);
                this.N = this.f74506d.o(this);
            } else {
                this.M = getLeft();
                this.N = getTop();
            }
            this.C = false;
        } else if (action == 1) {
            if (this.C) {
                n(rawX, rawY);
            } else {
                RectF rectF = this.f74505c0;
                boolean z17 = rectF != null && rectF.contains(motionEvent.getX(), motionEvent.getY());
                a aVar2 = this.f74506d;
                if (aVar2 != null && !z17) {
                    z16 = aVar2.b(this);
                } else {
                    View.OnClickListener onClickListener = this.f74507d0;
                    if (onClickListener != null) {
                        onClickListener.onClick(this);
                    }
                }
            }
            a aVar3 = this.f74506d;
            if (aVar3 != null) {
                this.R = aVar3.i(this);
                this.S = this.f74506d.o(this);
            } else {
                this.R = getLeft();
                this.S = getTop();
            }
            if (!z16) {
                this.f74508e.start();
            }
        } else if (action != 2) {
            if (action == 3) {
                if (this.C) {
                    n(rawX, rawY);
                }
                a aVar4 = this.f74506d;
                if (aVar4 != null) {
                    this.R = aVar4.i(this);
                    this.S = this.f74506d.o(this);
                } else {
                    this.R = getLeft();
                    this.S = getTop();
                }
                this.f74508e.start();
            }
        } else if (this.C) {
            n(rawX, rawY);
        } else if (Math.abs(rawX - this.P) > this.F || Math.abs(rawY - this.Q) > this.F) {
            this.C = true;
        }
        return true;
    }

    Rect e() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z16 = g() % 2 == 0;
        if (z16) {
            i3 = this.I;
        } else {
            i3 = this.J;
        }
        if (z16) {
            i16 = this.J;
        } else {
            i16 = this.I;
        }
        Rect rect = new Rect();
        rect.left = i3;
        rect.top = i16;
        if (!z16 && this.f74511i) {
            i17 = this.H;
            i18 = this.G;
        } else {
            i17 = this.G;
            i18 = this.H;
        }
        int i26 = this.V;
        if (i26 != 0 && (i19 = this.W) != 0) {
            rect.right = (i26 - i17) - i3;
            rect.bottom = (i19 - i18) - i16;
        } else {
            try {
                rect.right = (this.f74510h.getWidth() - i17) - i3;
                rect.bottom = (this.f74510h.getHeight() - i18) - i16;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("SmallScreenRelativeLayout", 2, "getPositionRect e = " + e16);
                }
            }
        }
        return rect;
    }

    public void i() {
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenRelativeLayout", 2, "onCreate");
        }
        this.D = true;
        this.f74503a0.enable();
    }

    public void j() {
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenRelativeLayout", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        this.f74506d = null;
        this.f74503a0.disable();
    }

    public void k() {
        int g16 = g();
        boolean o16 = SmallScreenUtils.o();
        Point point = new Point();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRealSize(point);
        int i3 = point.x;
        int i16 = point.y;
        if (o16) {
            i16 -= this.E;
        }
        int i17 = this.U;
        this.f74504b0 = a(this.V, this.W, i3, i16, this.f74504b0);
        if (this.U == g16 && i3 == this.V && ((g16 != 0 || this.W >= i16) && (g16 == 0 || this.W == i16))) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w("SmallScreenRelativeLayout", 1, "onOrientationChangedInner, mPosition[" + i17 + "->" + this.f74504b0 + "], mRotation[" + this.U + "->" + g16 + "], mScreenWidth[" + this.V + "->" + i3 + "], mScreenHeight[" + this.W + "->" + i16 + "], mIsInit[" + this.D + "]");
        }
        if (this.D && g16 != 0) {
            this.D = false;
        }
        this.f74508e.cancel();
        this.U = g16;
        this.V = i3;
        this.W = i16;
        setCurPosition(this.f74504b0);
        a aVar = this.f74506d;
        if (aVar != null) {
            int i18 = aVar.i(this);
            this.R = i18;
            this.M = i18;
            int o17 = this.f74506d.o(this);
            this.S = o17;
            this.N = o17;
        } else {
            int left = getLeft();
            this.R = left;
            this.M = left;
            int top = getTop();
            this.S = top;
            this.N = top;
        }
        if (this.D) {
            return;
        }
        this.f74508e.start();
    }

    void m(boolean z16) {
        a aVar;
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenRelativeLayout", 2, "startShowHideAnimation mIsShow = " + this.f74512m);
            QLog.d("SmallScreenRelativeLayout", 2, "startShowHideAnimation isShow = " + z16);
        }
        this.f74512m = z16;
        setVisibility(z16 ? 0 : 8);
        if (z16 || (aVar = this.f74506d) == null) {
            return;
        }
        aVar.m(this);
    }

    void n(int i3, int i16) {
        int i17;
        int i18;
        int i19 = (this.M + i3) - this.P;
        int i26 = (this.N + i16) - this.Q;
        if (this.U % 2 != 0 && this.f74511i) {
            i17 = this.H;
            i18 = this.G;
        } else {
            i17 = this.G;
            i18 = this.H;
        }
        int i27 = this.V - i17;
        int i28 = this.W - i18;
        if (i19 < 0) {
            i19 = 0;
        }
        int i29 = i19 > i27 ? i27 : i19;
        if (i26 < 0) {
            i26 = 0;
        }
        int i36 = i26 > i28 ? i28 : i26;
        a aVar = this.f74506d;
        if (aVar != null) {
            aVar.e(this, i29, i36, i29 + i17, i36 + i18);
        } else {
            layout(i29, i36, i17 + i29, i18 + i36);
        }
    }

    public void o() {
        int i3;
        int i16;
        if (this.V == 0 || this.W == 0) {
            return;
        }
        Point d16 = d(this.f74504b0);
        if (this.U % 2 != 0 && this.f74511i) {
            i3 = this.H;
            i16 = this.G;
        } else {
            i3 = this.G;
            i16 = this.H;
        }
        a aVar = this.f74506d;
        if (aVar != null) {
            int i17 = d16.x;
            int i18 = d16.y;
            aVar.e(this, i17, i18, i17 + i3, i18 + i16);
        } else {
            int i19 = d16.x;
            int i26 = d16.y;
            layout(i19, i26, i3 + i19, i16 + i26);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        String str;
        int i3;
        int i16;
        if (animator == this.f74508e) {
            Point d16 = d(this.T);
            int i17 = this.T;
            if (i17 == 1) {
                str = "0X80057E1";
            } else if (i17 == 10) {
                str = "0X80057E4";
            } else if (i17 != 5) {
                str = i17 != 6 ? null : "0X80057E2";
            } else {
                str = "0X80057E3";
            }
            String str2 = str;
            if (this.U % 2 != 0 && this.f74511i) {
                i3 = this.H;
                i16 = this.G;
            } else {
                i3 = this.G;
                i16 = this.H;
            }
            a aVar = this.f74506d;
            if (aVar != null) {
                int i18 = d16.x;
                int i19 = d16.y;
                aVar.e(this, i18, i19, i18 + i3, i19 + i16);
            } else {
                int i26 = d16.x;
                int i27 = d16.y;
                layout(i26, i27, i3 + i26, i16 + i27);
            }
            this.D = false;
            this.f74504b0 = this.T;
            if (str2 != null) {
                ReportController.o(null, "CliOper", "", "", str2, str2, 0, 0, "", "", "", "");
                return;
            }
            return;
        }
        if (animator != this.f74509f || this.f74512m) {
            return;
        }
        setVisibility(8);
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenRelativeLayout", 2, "onAnimationEnd setVisibility(GONE)");
        }
        a aVar2 = this.f74506d;
        if (aVar2 != null) {
            aVar2.m(this);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        if (animator == this.f74508e) {
            this.T = f(this.M, this.N, this.R, this.S);
            return;
        }
        if (animator == this.f74509f && this.f74512m) {
            setVisibility(0);
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenRelativeLayout", 2, "onAnimationStart setVisibility(VISIBLE)");
            }
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i3;
        int i16;
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (valueAnimator == this.f74508e) {
            Point d16 = d(this.T);
            int i17 = (int) (this.R + ((d16.x - r1) * floatValue));
            int i18 = (int) (this.S + ((d16.y - r1) * floatValue));
            if (this.U % 2 != 0 && this.f74511i) {
                i3 = this.H;
                i16 = this.G;
            } else {
                i3 = this.G;
                i16 = this.H;
            }
            a aVar = this.f74506d;
            if (aVar != null) {
                aVar.e(this, i17, i18, i17 + i3, i18 + i16);
            } else {
                layout(i17, i18, i3 + i17, i16 + i18);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        if (!AppSetting.f99565y || (aVar = this.f74506d) == null) {
            return;
        }
        aVar.b(this);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        k();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        if (this.V == 0 || this.W == 0) {
            Rect rect = new Rect();
            getWindowVisibleDisplayFrame(rect);
            this.V = rect.width();
            if (this.W < rect.height()) {
                this.W = rect.height();
            }
            setCurPosition(this.f74504b0);
        }
    }

    public void setCurPosition(int i3) {
        int i16;
        int i17;
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenRelativeLayout", 2, "setCurPosition position = " + i3);
            QLog.d("SmallScreenRelativeLayout", 2, "setCurPosition mScreenWidth = " + this.V);
            QLog.d("SmallScreenRelativeLayout", 2, "setCurPosition mScreenHeight = " + this.W);
        }
        this.f74504b0 = i3;
        if (this.V == 0 || this.W == 0) {
            return;
        }
        Point d16 = d(i3);
        if (this.U % 2 != 0 && this.f74511i) {
            i16 = this.H;
            i17 = this.G;
        } else {
            i16 = this.G;
            i17 = this.H;
        }
        a aVar = this.f74506d;
        if (aVar != null) {
            int i18 = d16.x;
            int i19 = d16.y;
            aVar.e(this, i18, i19, i18 + i16, i19 + i17);
        } else {
            int i26 = d16.x;
            int i27 = d16.y;
            layout(i26, i27, i16 + i26, i17 + i27);
        }
    }

    public void setFloatListener(a aVar) {
        this.f74506d = aVar;
    }

    public void setIntercetRect(int i3, int i16, int i17, int i18, View.OnClickListener onClickListener) {
        this.f74505c0 = new RectF(i3, i16, i17, i18);
        this.f74507d0 = onClickListener;
    }

    public void setIsRotateSize(boolean z16) {
        this.f74511i = z16;
    }

    public void setSize(int i3, int i16) {
        this.G = i3;
        this.H = i16;
    }

    public void setTitleHeight(int i3) {
        this.K = i3;
    }

    public SmallScreenRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void h() {
        m(false);
    }

    public void l() {
        m(true);
    }

    public SmallScreenRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f74511i = false;
        this.f74512m = false;
        this.C = false;
        this.D = true;
        this.M = -1;
        this.N = -1;
        this.P = -1;
        this.Q = -1;
        this.R = -1;
        this.S = -1;
        this.T = 6;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.f74503a0 = null;
        this.f74504b0 = 7;
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenRelativeLayout", 2, "SmallScreenRelativeLayout");
        }
        this.F = ViewConfiguration.get(context).getScaledTouchSlop();
        this.I = getResources().getDimensionPixelSize(R.dimen.a9a);
        this.J = getResources().getDimensionPixelSize(R.dimen.a9b);
        this.E = getResources().getDimensionPixelSize(R.dimen.a9i);
        this.K = getResources().getDimensionPixelSize(R.dimen.title_bar_height);
        this.L = getResources().getDimensionPixelSize(R.dimen.a99);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f74508e = ofFloat;
        ofFloat.setDuration(200L);
        this.f74508e.addListener(this);
        this.f74508e.addUpdateListener(this);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f74509f = ofFloat2;
        ofFloat2.setDuration(400L);
        this.f74509f.addListener(this);
        this.f74508e.addUpdateListener(this);
        this.f74510h = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        this.U = g();
        this.f74503a0 = new b(getContext(), 2);
        setOnClickListener(this);
    }

    int f(int i3, int i16, int i17, int i18) {
        int i19 = Integer.MAX_VALUE;
        int i26 = 0;
        for (int i27 = 1; i27 < 14; i27++) {
            Point d16 = d(i27);
            int i28 = d16.x;
            int i29 = d16.y;
            int i36 = ((i17 - i28) * (i17 - i28)) + ((i18 - i29) * (i18 - i29));
            if (i36 < i19) {
                i26 = i27;
                i19 = i36;
            }
        }
        return i26;
    }

    int a(int i3, int i16, int i17, int i18, int i19) {
        int i26;
        boolean z16 = i3 < i16 && i17 > i18;
        boolean z17 = i3 > i16 && i17 < i18;
        if (z16 || z17) {
            SharedPreferences U0 = ea.U0(getContext());
            SharedPreferences.Editor edit = U0.edit();
            if (z16) {
                i26 = U0.getInt("small_window_position_land", 12);
            } else {
                if (z17) {
                    edit.putInt("small_window_position_land", i19);
                    i26 = 7;
                }
                edit.commit();
            }
            i19 = i26;
            edit.commit();
        }
        return i19;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b extends OrientationEventListener {

        /* renamed from: a, reason: collision with root package name */
        private int f74513a;

        b(Context context, int i3) {
            super(context, i3);
            this.f74513a = -1;
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i3) {
            if (i3 < 0) {
                i3 += 360;
            }
            int i16 = (i3 > 314 || i3 < 45) ? 0 : i3 < 135 ? 90 : i3 < 225 ? 180 : 270;
            if (i16 != this.f74513a) {
                this.f74513a = i16;
                SmallScreenRelativeLayout.this.k();
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }
}
