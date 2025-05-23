package com.tencent.mobileqq.guild.discovery.widget;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.IRefreshViewProvider;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LoadingUtil;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildRefreshHeadView extends LinearLayout implements IRefreshViewProvider {
    private IRefreshViewProvider.OnRefreshListener C;
    private boolean D;
    private Handler E;
    private long F;

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f216823d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f216824e;

    /* renamed from: f, reason: collision with root package name */
    private int f216825f;

    /* renamed from: h, reason: collision with root package name */
    private int f216826h;

    /* renamed from: i, reason: collision with root package name */
    private float f216827i;

    /* renamed from: m, reason: collision with root package name */
    private float f216828m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f216830d;

        a(int i3) {
            this.f216830d = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            GuildRefreshHeadView.this.setVisibleHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
            if (this.f216830d == 0 && ((Integer) valueAnimator.getAnimatedValue()).intValue() == 0) {
                GuildRefreshHeadView.this.setState(0);
            }
        }
    }

    public GuildRefreshHeadView(Context context) {
        this(context, null);
    }

    private void d() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        setLayoutParams(layoutParams);
        setPadding(0, 0, 0, 0);
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.f4_, (ViewGroup) null);
        this.f216823d = frameLayout;
        addView(frameLayout, new LinearLayout.LayoutParams(-1, 0));
        ImageView imageView = (ImageView) findViewById(R.id.wdg);
        this.f216824e = imageView;
        imageView.setImageDrawable(LoadingUtil.getLoadingDrawable(getContext(), 2));
        measure(-2, -2);
        this.f216825f = getMeasuredHeight();
    }

    private boolean e() {
        if (getParent() != null) {
            return true;
        }
        return false;
    }

    private boolean f(float f16, boolean z16) {
        return !z16;
    }

    private void l() {
        s(0);
    }

    private void m(int i3) {
        QLog.d("RefreshHeaderView", 4, "STATE_JUST_SHOW_REFRESH_ANIMATION");
        this.F = System.currentTimeMillis();
        r(i3);
        s(this.f216825f);
        setRefreshing(true);
    }

    private void n() {
        o(false);
    }

    private void o(boolean z16) {
        int i3;
        ImageView imageView = this.f216824e;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    private void p(int i3) {
        this.F = System.currentTimeMillis();
        r(i3);
        s(this.f216825f);
        IRefreshViewProvider.OnRefreshListener onRefreshListener = this.C;
        if (onRefreshListener != null) {
            onRefreshListener.onRefresh();
        }
    }

    private void q() {
        this.f216824e.setVisibility(0);
    }

    private void r(int i3) {
        o(true);
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
        return ((LinearLayout.LayoutParams) this.f216823d.getLayoutParams()).height;
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void callRefresh(final RecyclerView recyclerView) {
        setState(2);
        b().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.discovery.widget.GuildRefreshHeadView.3
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView2 = recyclerView;
                if (recyclerView2 != null) {
                    recyclerView2.scrollToPosition(0);
                }
            }
        }, 100L);
    }

    public void g(float f16, float f17) {
        if (c() > 0 || f16 > 0.0f) {
            setVisibleHeight(Math.max(((int) f16) + c(), this.f216825f));
            if (this.f216826h <= 1) {
                if (c() > this.f216825f) {
                    h();
                } else {
                    j();
                }
            }
        }
    }

    public void h() {
        setState(1);
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void handleRefreshGesture(MotionEvent motionEvent) {
        boolean z16;
        if (this.f216827i == -1.0f) {
            this.f216827i = motionEvent.getRawY();
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 2) {
                this.f216827i = -1.0f;
                if (e() && !this.D) {
                    i();
                    return;
                }
                return;
            }
            float rawY = motionEvent.getRawY();
            float f16 = this.f216827i;
            float f17 = (rawY - f16) / 2.0f;
            if (f16 == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f216827i = motionEvent.getRawY();
            this.f216828m += f17;
            if (e() && !this.D && f(f17, z16)) {
                g(f17, this.f216828m);
                c();
                return;
            }
            return;
        }
        this.f216827i = motionEvent.getRawY();
        this.f216828m = 0.0f;
    }

    public boolean i() {
        boolean z16;
        int i3;
        int c16 = c();
        if (c() > this.f216825f && this.f216826h < 2) {
            setState(2);
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.f216826h == 2 && c16 > (i3 = this.f216825f)) {
            s(i3);
        }
        if (this.f216826h != 2) {
            s(0);
        }
        if (this.f216826h == 2) {
            s(this.f216825f);
        }
        return z16;
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    /* renamed from: isRefresh */
    public boolean getIsRefreshing() {
        return this.D;
    }

    public void j() {
        setState(0);
    }

    public void k() {
        QLog.d("RefreshHeaderView", 1, "refreshComplete: state[" + this.f216826h + "]");
        int i3 = this.f216826h;
        if (i3 == 4 || i3 == 2) {
            long currentTimeMillis = 500 - (System.currentTimeMillis() - this.F);
            if (currentTimeMillis > 0) {
                b().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.discovery.widget.GuildRefreshHeadView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (GuildRefreshHeadView.this.f216826h == 4 || GuildRefreshHeadView.this.f216826h == 2) {
                            GuildRefreshHeadView.this.setState(3);
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
        if (this.f216826h == 1) {
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
        if (!z16) {
            k();
        }
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void setState(int i3) {
        if (i3 == this.f216826h) {
            return;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            m(i3);
                        }
                    } else {
                        l();
                    }
                } else {
                    p(i3);
                }
            } else {
                q();
            }
        } else {
            n();
        }
        QLog.d("RefreshHeaderView", 1, "state:" + i3);
        this.f216826h = i3;
    }

    public void setVisibleHeight(int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f216823d.getLayoutParams();
        layoutParams.height = i3;
        this.f216823d.setLayoutParams(layoutParams);
    }

    public GuildRefreshHeadView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuildRefreshHeadView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        d();
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public View getRefreshView() {
        return this;
    }
}
