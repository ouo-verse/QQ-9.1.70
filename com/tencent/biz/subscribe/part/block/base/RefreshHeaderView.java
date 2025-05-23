package com.tencent.biz.subscribe.part.block.base;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.IRefreshViewProvider;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RefreshHeaderView extends LinearLayout implements IRefreshViewProvider {
    protected int C;
    protected int D;
    protected float E;
    protected float F;
    protected c G;
    protected boolean H;
    private Handler I;
    private final String J;
    private final String K;
    private final String L;
    private final String M;
    private Drawable N;
    protected long P;
    private b Q;
    private boolean R;
    protected boolean S;
    private IRefreshViewProvider.OnRefreshListener T;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f96186d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f96187e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f96188f;

    /* renamed from: h, reason: collision with root package name */
    protected ProgressBar f96189h;

    /* renamed from: i, reason: collision with root package name */
    private RotateAnimation f96190i;

    /* renamed from: m, reason: collision with root package name */
    private RotateAnimation f96191m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f96192d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Animation.AnimationListener f96193e;

        a(int i3, Animation.AnimationListener animationListener) {
            this.f96192d = i3;
            this.f96193e = animationListener;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Animation.AnimationListener animationListener;
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            RefreshHeaderView.this.setVisibleHeight(intValue);
            if (this.f96192d == 0 && intValue == 0) {
                RefreshHeaderView.this.l();
            }
            if (this.f96192d == intValue && (animationListener = this.f96193e) != null) {
                animationListener.onAnimationEnd(null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
        boolean a();
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface c {
        void onRefresh();
    }

    public RefreshHeaderView(Context context) {
        this(context, null);
    }

    private void d() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        setLayoutParams(layoutParams);
        setPadding(0, 0, 0, 0);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.g3o, (ViewGroup) null);
        this.f96186d = linearLayout;
        addView(linearLayout, new LinearLayout.LayoutParams(-1, 0));
        this.f96187e = (ImageView) findViewById(R.id.y4_);
        this.f96188f = (TextView) findViewById(R.id.f110596iy);
        this.f96189h = (ProgressBar) findViewById(R.id.f235106m);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
        this.f96190i = rotateAnimation;
        rotateAnimation.setDuration(100L);
        this.f96190i.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.f96191m = rotateAnimation2;
        rotateAnimation2.setDuration(100L);
        this.f96191m.setFillAfter(true);
        measure(-2, -2);
        this.C = getMeasuredHeight();
        this.N = getResources().getDrawable(R.drawable.common_loading6);
    }

    private boolean h(float f16, boolean z16) {
        boolean z17;
        if (f16 > 0.0f && !z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.S = z17;
        return z17;
    }

    public Handler a() {
        if (this.I == null) {
            this.I = new Handler(Looper.getMainLooper());
        }
        return this.I;
    }

    public int b() {
        return ((LinearLayout.LayoutParams) this.f96186d.getLayoutParams()).height;
    }

    public void c() {
        this.E = -1.0f;
        if (f() && !this.H) {
            k();
        }
    }

    public boolean e() {
        if (f() && this.S && !this.H) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f() {
        b bVar = this.Q;
        if (bVar != null) {
            return bVar.a();
        }
        if (getParent() != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        return this.S;
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void handleRefreshGesture(MotionEvent motionEvent) {
        boolean z16;
        if (this.E == -1.0f) {
            this.E = motionEvent.getRawY();
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 2) {
                c();
                return;
            }
            float rawY = motionEvent.getRawY();
            float f16 = this.E;
            float f17 = (rawY - f16) / 2.0f;
            if (f16 == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.E = motionEvent.getRawY();
            this.F += f17;
            h(f17, z16);
            if (e()) {
                i(f17, this.F);
                return;
            }
            return;
        }
        this.E = motionEvent.getRawY();
        this.F = 0.0f;
    }

    public void i(float f16, float f17) {
        if (b() > 0 || f16 > 0.0f) {
            setVisibleHeight(((int) f16) + b());
            if (this.D <= 1) {
                if (b() > this.C) {
                    j();
                } else {
                    l();
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    /* renamed from: isRefresh */
    public boolean getIsRefreshing() {
        return this.H;
    }

    public void j() {
        setState(1);
    }

    public boolean k() {
        boolean z16;
        int i3;
        int b16 = b();
        if (b() > this.C && this.D < 2) {
            setState(2);
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.D == 2 && b16 > (i3 = this.C)) {
            n(i3);
        }
        if (this.D != 2) {
            p();
        }
        if (this.D == 2) {
            n(this.C);
        }
        return z16;
    }

    public void l() {
        setState(0);
    }

    public void m() {
        QLog.d("RefreshHeaderView", 1, "refreshComplete");
        long j3 = 1000 - this.P;
        if (j3 > 0) {
            a().postDelayed(new Runnable() { // from class: com.tencent.biz.subscribe.part.block.base.RefreshHeaderView.1
                @Override // java.lang.Runnable
                public void run() {
                    RefreshHeaderView.this.setState(3);
                }
            }, j3);
        } else {
            setState(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(int i3) {
        o(i3, null);
    }

    protected void o(int i3, Animation.AnimationListener animationListener) {
        ValueAnimator ofInt = ValueAnimator.ofInt(b(), i3);
        ofInt.setDuration(200L).start();
        ofInt.addUpdateListener(new a(i3, animationListener));
        ofInt.start();
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void onDestroy() {
        if (a() != null) {
            a().removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QZLog.i("QZoneConciseZPlan RefreshHeaderView", 1, "[onDetachedFromWindow] mState=" + this.D);
        if (this.D == 1) {
            setState(2);
        }
    }

    public void p() {
        n(0);
    }

    public void q(boolean z16) {
        int i3;
        this.f96189h.setIndeterminate(z16);
        ProgressBar progressBar = this.f96189h;
        if (!z16 && !this.R) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        progressBar.setVisibility(i3);
    }

    public void setAlwaysShowProgressBar(boolean z16) {
        this.R = z16;
        ProgressBar progressBar = this.f96189h;
        if (progressBar != null && z16) {
            progressBar.setVisibility(0);
            if (this.f96189h.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.f96189h.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            ImageView imageView = this.f96187e;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
    }

    public void setCanRefreshDelegate(b bVar) {
        this.Q = bVar;
    }

    public void setMeasuredHeight(int i3) {
        this.C = i3;
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void setOnRefreshListener(IRefreshViewProvider.OnRefreshListener onRefreshListener) {
        this.T = onRefreshListener;
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void setRefreshing(boolean z16) {
        QLog.i("QZoneConciseZPlan RefreshHeaderView", 1, "[setRefreshing] refreshing = " + z16);
        this.H = z16;
        if (!z16) {
            m();
        }
    }

    public void setState(int i3) {
        int i16 = this.D;
        if (i3 == i16) {
            return;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            QLog.d("QZoneConciseZPlan RefreshHeaderView", 1, "STATE_JUST_SHOW_REFRESH_ANIMATION");
                            this.P = System.currentTimeMillis();
                            this.f96187e.clearAnimation();
                            this.f96187e.setVisibility(8);
                            q(true);
                            n(this.C);
                            this.f96188f.setText(this.K);
                            setRefreshing(true);
                        }
                    } else {
                        this.f96187e.setVisibility(8);
                        q(false);
                        this.f96188f.setText(this.J);
                        p();
                    }
                } else {
                    this.P = System.currentTimeMillis();
                    this.f96187e.clearAnimation();
                    this.f96187e.setVisibility(8);
                    q(true);
                    n(this.C);
                    this.f96188f.setText(this.K);
                    c cVar = this.G;
                    if (cVar != null) {
                        cVar.onRefresh();
                    }
                    IRefreshViewProvider.OnRefreshListener onRefreshListener = this.T;
                    if (onRefreshListener != null) {
                        onRefreshListener.onRefresh();
                    }
                }
            } else {
                if (!this.R) {
                    this.f96187e.setVisibility(0);
                }
                q(false);
                if (this.D != 1) {
                    this.f96187e.clearAnimation();
                    this.f96187e.startAnimation(this.f96190i);
                    this.f96188f.setText(this.L);
                }
            }
        } else {
            if (i16 == 1) {
                this.f96187e.startAnimation(this.f96191m);
            }
            if (this.D == 2) {
                this.f96187e.clearAnimation();
            }
            this.f96188f.setText(this.M);
        }
        QLog.d("RefreshHeaderView", 1, "state:" + i3);
        this.D = i3;
    }

    public void setVisibleHeight(int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f96186d.getLayoutParams();
        layoutParams.height = i3;
        this.f96186d.setLayoutParams(layoutParams);
    }

    public RefreshHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setOnRefreshListener(c cVar) {
        this.G = cVar;
    }

    public RefreshHeaderView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.J = getResources().getString(R.string.hqk);
        this.K = getResources().getString(R.string.hqg);
        this.L = getResources().getString(R.string.hqj);
        this.M = getResources().getString(R.string.hqh);
        d();
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public View getRefreshView() {
        return this;
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void callRefresh(RecyclerView recyclerView) {
    }
}
