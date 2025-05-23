package com.tencent.biz.qqcircle.richframework.part.block.base;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.widgets.QCircleRippleAnimView;
import com.tencent.biz.richframework.part.IRefreshViewProvider;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LoadingUtil;
import cooperation.qqcircle.helpers.QCircleSkinHelper;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RefreshHeaderView extends LinearLayout implements IRefreshViewProvider {
    private TextView C;
    private int D;
    private int E;
    private int F;
    private float G;
    private float H;
    private float I;
    private float J;
    private IRefreshViewProvider.OnRefreshListener K;
    private boolean L;
    private boolean M;
    private String N;
    private Handler P;
    private final String Q;
    private final String R;
    private final String S;
    private long T;
    private Drawable U;
    private b V;

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f91932d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f91933e;

    /* renamed from: f, reason: collision with root package name */
    private FrameLayout f91934f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f91935h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f91936i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f91937m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f91941d;

        a(int i3) {
            this.f91941d = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator != null && valueAnimator.getAnimatedValue() != null) {
                RefreshHeaderView.this.setVisibleHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
                if (this.f91941d == 0 && ((Integer) valueAnimator.getAnimatedValue()).intValue() == 0) {
                    RefreshHeaderView.this.setState(0);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
        void onChange(int i3);
    }

    public RefreshHeaderView(Context context) {
        this(context, null);
    }

    private void f(Context context, @Nullable AttributeSet attributeSet) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 1);
        setLayoutParams(layoutParams);
        setPadding(0, 0, 0, 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y91.a.f449652f8);
        int i3 = obtainStyledAttributes.getInt(y91.a.f449665g8, 17);
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.g5j, (ViewGroup) null);
        this.f91932d = frameLayout;
        LinearLayout linearLayout = (LinearLayout) frameLayout.findViewById(R.id.yqc);
        this.f91933e = linearLayout;
        ViewGroup.LayoutParams layoutParams2 = linearLayout.getLayoutParams();
        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams2).gravity = i3;
        } else if (layoutParams2 instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams2).gravity = i3;
        }
        this.f91933e.setLayoutParams(layoutParams2);
        this.f91934f = (FrameLayout) this.f91932d.findViewById(R.id.v8x);
        this.f91935h = (ImageView) this.f91932d.findViewById(R.id.y4_);
        this.f91936i = (TextView) this.f91932d.findViewById(R.id.f110596iy);
        int resourceId = obtainStyledAttributes.getResourceId(y91.a.f449678h8, R.color.qvideo_skin_color_text_light);
        this.f91936i.setTextColor(QCircleSkinHelper.getInstance().getColor(resourceId));
        TextView textView = (TextView) this.f91932d.findViewById(R.id.f110586ix);
        this.f91937m = textView;
        textView.setTextColor(QCircleSkinHelper.getInstance().getColor(resourceId));
        this.C = (TextView) this.f91932d.findViewById(R.id.f112236nd);
        addView(this.f91932d, new LinearLayout.LayoutParams(-1, 0));
        measure(-2, -2);
        this.D = getMeasuredHeight();
        this.U = LoadingUtil.getLoadingDrawable(getContext(), 2);
    }

    private boolean g() {
        QLog.d("RefreshHeaderView", 4, "[isOnTop] -> " + getParent());
        if (getParent() != null) {
            return true;
        }
        return false;
    }

    private boolean h(float f16, boolean z16) {
        if (f16 > 0.0f && !z16) {
            return true;
        }
        return false;
    }

    private void m(int i3) {
        if (i3 == 2 || i3 == 4) {
            this.f91935h.setImageDrawable(this.U);
        }
    }

    private void u(int i3) {
        IRefreshViewProvider.OnRefreshListener onRefreshListener = this.K;
        if (onRefreshListener != null) {
            this.N = onRefreshListener.getRefreshUpdateTips();
        }
        QLog.d("RefreshHeaderView", 1, "showDynamicLogoView");
        m(i3);
    }

    private void v() {
        if (getContext() != null && getContext().getResources() != null) {
            int width = getWidth();
            int height = getHeight();
            this.C.setText(this.N);
            QCircleRippleAnimView qCircleRippleAnimView = new QCircleRippleAnimView(getContext());
            qCircleRippleAnimView.k(getContext().getResources().getColor(R.color.qvideo_skin_color_bg_default)).p(width / 6).n((int) (Math.sqrt((width * width) + (height * height)) / 2.0d)).j(320L).l(width / 2.0f, height / 2.0f).f(this.f91934f).m(new lc0.a(0.2f, 0.0f, 0.17f, 1.0f)).o(new QCircleRippleAnimView.c() { // from class: com.tencent.biz.qqcircle.richframework.part.block.base.RefreshHeaderView.2
                @Override // com.tencent.biz.qqcircle.widgets.QCircleRippleAnimView.c
                public void onAnimationEnd() {
                    RefreshHeaderView.this.d().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.part.block.base.RefreshHeaderView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RefreshHeaderView.this.x(0);
                            RefreshHeaderView.this.M = false;
                            RefreshHeaderView.this.N = null;
                        }
                    }, 1500L);
                }
            });
            qCircleRippleAnimView.q();
        }
    }

    private void w() {
        this.f91935h.setImageDrawable(this.U);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i3) {
        if (i3 == e()) {
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(e(), i3);
        ofInt.setDuration(200L);
        ofInt.addUpdateListener(new a(i3));
        ofInt.start();
    }

    private void y(boolean z16) {
        int i3;
        TextView textView = this.f91936i;
        int i16 = 0;
        if (!z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
        TextView textView2 = this.f91937m;
        if (!z16) {
            i16 = 8;
        }
        textView2.setVisibility(i16);
    }

    private void z(boolean z16) {
        int i3;
        LinearLayout linearLayout = this.f91933e;
        int i16 = 0;
        if (!z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        linearLayout.setVisibility(i3);
        FrameLayout frameLayout = this.f91934f;
        if (!z16) {
            i16 = 8;
        }
        frameLayout.setVisibility(i16);
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void callRefresh(final RecyclerView recyclerView) {
        setState(2);
        d().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.part.block.base.RefreshHeaderView.4
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView2 = recyclerView;
                if (recyclerView2 != null) {
                    recyclerView2.scrollToPosition(0);
                }
            }
        }, 100L);
    }

    public Handler d() {
        if (this.P == null) {
            this.P = new Handler(Looper.getMainLooper());
        }
        return this.P;
    }

    public int e() {
        return ((LinearLayout.LayoutParams) this.f91932d.getLayoutParams()).height;
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void handleRefreshGesture(MotionEvent motionEvent) {
        boolean z16;
        if (this.G == -1.0f || this.H == -1.0f) {
            this.G = motionEvent.getRawY();
            this.H = motionEvent.getRawX();
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 2) {
                this.G = -1.0f;
                this.H = -1.0f;
                if (g() && !this.L && !this.M) {
                    k();
                    return;
                }
                return;
            }
            float rawY = (motionEvent.getRawY() - this.G) / 2.0f;
            float rawX = (motionEvent.getRawX() - this.H) / 2.0f;
            if (this.G == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.G = motionEvent.getRawY();
            this.H = motionEvent.getRawX();
            this.I = this.I + rawY;
            this.J += rawX;
            int round = Math.round((float) ((Math.asin(Math.abs(this.I) / Math.sqrt((Math.abs(r7) * Math.abs(this.I)) + (Math.abs(this.J) * Math.abs(this.J)))) / 3.141592653589793d) * 180.0d));
            if (g() && !this.L && !this.M && h(rawY, z16) && round > 45.0f && Math.abs(this.I) > Math.abs(this.J)) {
                i(rawY, this.I);
                e();
                return;
            }
            return;
        }
        this.G = motionEvent.getRawY();
        this.H = motionEvent.getRawX();
        this.I = 0.0f;
        this.J = 0.0f;
    }

    public void i(float f16, float f17) {
        if (e() > 0 || f16 > 0.0f) {
            setVisibleHeight(((int) f16) + e());
            if (this.F <= 1) {
                if (e() > this.D) {
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
        return this.L;
    }

    public void j() {
        setState(1);
    }

    public boolean k() {
        boolean z16;
        int i3;
        int e16 = e();
        if (e() > this.D && this.F < 2) {
            setState(2);
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.F == 2 && e16 > (i3 = this.D)) {
            x(i3);
        }
        if (this.F != 2) {
            x(0);
        }
        int i16 = this.F;
        if (i16 == 2 || i16 == 5) {
            x(this.D);
        }
        return z16;
    }

    public void l() {
        setState(0);
    }

    public void n() {
        char c16;
        QLog.d("RefreshHeaderView", 1, "refreshComplete");
        if (!TextUtils.isEmpty(this.N)) {
            c16 = 5;
        } else {
            c16 = 3;
        }
        if (c16 == 3) {
            long j3 = 1000 - this.T;
            if (j3 > 0) {
                d().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.part.block.base.RefreshHeaderView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RefreshHeaderView.this.setState(3);
                    }
                }, j3);
                return;
            } else {
                setState(3);
                return;
            }
        }
        setState(5);
    }

    void o() {
        y(true);
        x(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m(this.F);
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void onDestroy() {
        if (d() != null) {
            d().removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.F == 1) {
            setState(2);
        }
        w();
    }

    void p(int i3) {
        QLog.d("RefreshHeaderView", 4, "STATE_JUST_SHOW_REFRESH_ANIMATION");
        this.T = System.currentTimeMillis();
        y(true);
        u(i3);
        x(this.D);
        setRefreshing(true);
    }

    void q() {
        z(false);
        if (this.F == 1) {
            this.f91935h.setImageDrawable(this.U);
        }
        if (this.F == 2) {
            this.f91935h.clearAnimation();
        }
        w();
        y(false);
        this.f91936i.setText(this.S);
    }

    void r(int i3) {
        this.T = System.currentTimeMillis();
        y(true);
        u(i3);
        x(this.D);
        IRefreshViewProvider.OnRefreshListener onRefreshListener = this.K;
        if (onRefreshListener != null) {
            onRefreshListener.onRefresh();
        } else {
            QLog.i("RefreshHeaderView", 1, "refresh listener is null");
        }
    }

    void s() {
        w();
        y(false);
        this.f91936i.setText(this.R);
    }

    public void setHeightListener(b bVar) {
        this.V = bVar;
    }

    public void setMaxHeight(int i3) {
        this.E = i3;
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void setOnRefreshListener(IRefreshViewProvider.OnRefreshListener onRefreshListener) {
        this.K = onRefreshListener;
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void setRefreshing(boolean z16) {
        this.L = z16;
        if (!z16) {
            n();
        }
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void setState(int i3) {
        if (i3 == this.F) {
            return;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                t();
                            }
                        } else {
                            p(i3);
                        }
                    } else {
                        o();
                    }
                } else {
                    r(i3);
                }
            } else {
                s();
            }
        } else {
            q();
        }
        QLog.d("RefreshHeaderView", 1, "state:" + i3);
        this.F = i3;
    }

    public void setVisibleHeight(int i3) {
        int i16 = this.E;
        if (i16 != 0 && i3 > i16) {
            return;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f91932d.getLayoutParams();
        layoutParams.height = i3;
        this.f91932d.setLayoutParams(layoutParams);
        b bVar = this.V;
        if (bVar != null) {
            bVar.onChange(i3);
        }
    }

    void t() {
        this.M = true;
        z(true);
        v();
    }

    public RefreshHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RefreshHeaderView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.N = null;
        this.Q = getResources().getString(R.string.hqk);
        this.R = getResources().getString(R.string.hqj);
        this.S = getResources().getString(R.string.hqh);
        f(context, attributeSet);
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public View getRefreshView() {
        return this;
    }
}
