package com.qzone.reborn.feedx.widget.header;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.IRefreshViewProvider;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LoadingUtil;

/* loaded from: classes37.dex */
public class QZoneOnlyProgressRefreshView extends LinearLayout implements IRefreshViewProvider {
    private IRefreshViewProvider.OnRefreshListener C;
    private boolean D;
    private Handler E;
    private long F;

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f56145d;

    /* renamed from: e, reason: collision with root package name */
    private ProgressBar f56146e;

    /* renamed from: f, reason: collision with root package name */
    private int f56147f;

    /* renamed from: h, reason: collision with root package name */
    private int f56148h;

    /* renamed from: i, reason: collision with root package name */
    private float f56149i;

    /* renamed from: m, reason: collision with root package name */
    private float f56150m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f56152d;

        a(int i3) {
            this.f56152d = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QZoneOnlyProgressRefreshView.this.setVisibleHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
            if (this.f56152d == 0 && ((Integer) valueAnimator.getAnimatedValue()).intValue() == 0) {
                QZoneOnlyProgressRefreshView.this.setState(0);
            }
        }
    }

    public QZoneOnlyProgressRefreshView(Context context) {
        this(context, null);
    }

    private void d() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        setLayoutParams(layoutParams);
        setPadding(0, 0, 0, 0);
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.cm8, (ViewGroup) null);
        this.f56145d = frameLayout;
        addView(frameLayout, new LinearLayout.LayoutParams(-1, 0));
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.kal);
        this.f56146e = progressBar;
        progressBar.setIndeterminateDrawable(LoadingUtil.getLoadingDrawable(getContext(), 2));
        measure(-2, -2);
        this.f56147f = getMeasuredHeight();
    }

    private boolean e() {
        return getParent() != null;
    }

    private boolean f(float f16, boolean z16) {
        QLog.d("RefreshHeaderView", 1, "delaty:" + f16);
        return !z16;
    }

    private void o(boolean z16) {
        this.f56146e.setVisibility(z16 ? 0 : 8);
    }

    private void p(int i3) {
        this.F = System.currentTimeMillis();
        r(i3);
        s(this.f56147f);
        IRefreshViewProvider.OnRefreshListener onRefreshListener = this.C;
        if (onRefreshListener != null) {
            onRefreshListener.onRefresh();
        }
    }

    private void q() {
        this.f56146e.setVisibility(0);
    }

    private void s(int i3) {
        if (i3 == c()) {
            QLog.i("RefreshHeaderView", 1, "smoothScrollTo: same height, dstHeight[" + i3 + "] visiHeight[" + c() + "]");
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(c(), i3);
        ofInt.setDuration(200L);
        ofInt.addUpdateListener(new a(i3));
        ofInt.start();
    }

    public Handler b() {
        if (this.E == null) {
            this.E = new Handler(Looper.getMainLooper());
        }
        return this.E;
    }

    public int c() {
        return ((LinearLayout.LayoutParams) this.f56145d.getLayoutParams()).height;
    }

    public void g(float f16, float f17) {
        if (c() > 0 || f16 > 0.0f) {
            setVisibleHeight(Math.max(((int) f16) + c(), this.f56147f));
            if (this.f56148h <= 1) {
                if (c() > this.f56147f) {
                    h();
                } else {
                    j();
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void handleRefreshGesture(MotionEvent motionEvent) {
        if (this.f56149i == -1.0f) {
            this.f56149i = motionEvent.getRawY();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f56149i = motionEvent.getRawY();
            this.f56150m = 0.0f;
            return;
        }
        if (action != 2) {
            this.f56149i = -1.0f;
            if (!e() || this.D) {
                return;
            }
            i();
            return;
        }
        float rawY = motionEvent.getRawY();
        float f16 = this.f56149i;
        float f17 = (rawY - f16) / 2.0f;
        boolean z16 = f16 == 0.0f;
        this.f56149i = motionEvent.getRawY();
        this.f56150m += f17;
        if (e() && !this.D && f(f17, z16)) {
            g(f17, this.f56150m);
            c();
        }
    }

    public boolean i() {
        boolean z16;
        int i3;
        int c16 = c();
        if (c() <= this.f56147f || this.f56148h >= 2) {
            z16 = false;
        } else {
            setState(2);
            z16 = true;
        }
        if (this.f56148h == 2 && c16 > (i3 = this.f56147f)) {
            s(i3);
        }
        if (this.f56148h != 2) {
            s(0);
        }
        if (this.f56148h == 2) {
            s(this.f56147f);
        }
        return z16;
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    /* renamed from: isRefresh */
    public boolean getIsRefreshing() {
        return this.D;
    }

    public void k() {
        QLog.d("RefreshHeaderView", 1, "refreshComplete: state[" + this.f56148h + "]");
        int i3 = this.f56148h;
        if (i3 == 4 || i3 == 2 || i3 == 0) {
            long currentTimeMillis = 500 - (System.currentTimeMillis() - this.F);
            if (currentTimeMillis > 0) {
                b().postDelayed(new Runnable() { // from class: com.qzone.reborn.feedx.widget.header.QZoneOnlyProgressRefreshView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QZoneOnlyProgressRefreshView.this.f56148h == 4 || QZoneOnlyProgressRefreshView.this.f56148h == 2 || QZoneOnlyProgressRefreshView.this.f56148h == 0) {
                            QZoneOnlyProgressRefreshView.this.setState(3);
                        }
                    }
                }, currentTimeMillis);
            } else {
                setState(3);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void onDestroy() {
        if (b() != null) {
            b().removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f56148h == 1) {
            setState(2);
        }
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void setOnRefreshListener(IRefreshViewProvider.OnRefreshListener onRefreshListener) {
        this.C = onRefreshListener;
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void setRefreshing(boolean z16) {
        this.D = z16;
        if (z16) {
            return;
        }
        k();
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void setState(int i3) {
        if (i3 == this.f56148h) {
            return;
        }
        if (i3 == 0) {
            n();
        } else if (i3 == 1) {
            q();
        } else if (i3 == 2) {
            p(i3);
        } else if (i3 == 3) {
            l();
        } else if (i3 == 4) {
            m(i3);
        }
        QLog.d("RefreshHeaderView", 1, "state:" + i3);
        this.f56148h = i3;
    }

    public QZoneOnlyProgressRefreshView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void l() {
        s(0);
    }

    private void m(int i3) {
        QLog.d("RefreshHeaderView", 4, "STATE_JUST_SHOW_REFRESH_ANIMATION");
        this.F = System.currentTimeMillis();
        r(i3);
        s(this.f56147f);
        setRefreshing(true);
    }

    private void n() {
        o(false);
    }

    private void r(int i3) {
        o(true);
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void callRefresh(final RecyclerView recyclerView) {
        setState(2);
        b().postDelayed(new Runnable() { // from class: com.qzone.reborn.feedx.widget.header.QZoneOnlyProgressRefreshView.3
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView2 = recyclerView;
                if (recyclerView2 != null) {
                    recyclerView2.scrollToPosition(0);
                }
            }
        }, 100L);
    }

    public void h() {
        setState(1);
    }

    public void j() {
        setState(0);
    }

    public QZoneOnlyProgressRefreshView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        d();
    }

    public void setVisibleHeight(int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f56145d.getLayoutParams();
        layoutParams.height = i3;
        this.f56145d.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public View getRefreshView() {
        return this;
    }
}
