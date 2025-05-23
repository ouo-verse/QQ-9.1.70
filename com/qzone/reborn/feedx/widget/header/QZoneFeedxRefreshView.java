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
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.IRefreshViewProvider;
import com.tencent.biz.subscribe.part.block.base.RefreshHeaderView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedxRefreshView extends LinearLayout implements IRefreshViewProvider {
    protected int C;
    protected float D;
    protected float E;
    protected boolean F;
    private Handler G;
    protected long H;
    private RefreshHeaderView.b I;
    protected boolean J;
    private IRefreshViewProvider.OnRefreshListener K;
    private final List<b> L;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f56133d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f56134e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f56135f;

    /* renamed from: h, reason: collision with root package name */
    private RotateAnimation f56136h;

    /* renamed from: i, reason: collision with root package name */
    private RotateAnimation f56137i;

    /* renamed from: m, reason: collision with root package name */
    protected int f56138m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f56139d;

        a(int i3) {
            this.f56139d = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QZoneFeedxRefreshView.this.setVisibleHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
            if (this.f56139d == 0 && ((Integer) valueAnimator.getAnimatedValue()).intValue() == 0) {
                QZoneFeedxRefreshView.this.l();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface b {
        boolean a(float f16, float f17);

        void onRelease();
    }

    public QZoneFeedxRefreshView(Context context) {
        this(context, null);
    }

    private void e() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        setLayoutParams(layoutParams);
        setPadding(0, 0, 0, 0);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.cgz, (ViewGroup) null);
        this.f56133d = linearLayout;
        addView(linearLayout, new LinearLayout.LayoutParams(-1, 0));
        this.f56134e = (ImageView) findViewById(R.id.l89);
        this.f56135f = (TextView) findViewById(R.id.nju);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
        this.f56136h = rotateAnimation;
        rotateAnimation.setDuration(100L);
        this.f56136h.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.f56137i = rotateAnimation2;
        rotateAnimation2.setDuration(100L);
        this.f56137i.setFillAfter(true);
        measure(-2, -2);
        this.f56138m = getMeasuredHeight();
    }

    public void a(b bVar) {
        this.L.add(bVar);
    }

    public Handler b() {
        if (this.G == null) {
            this.G = new Handler(Looper.getMainLooper());
        }
        return this.G;
    }

    public int c() {
        return ((LinearLayout.LayoutParams) this.f56133d.getLayoutParams()).height;
    }

    public boolean f() {
        return g() && this.J && !this.F;
    }

    protected boolean g() {
        RefreshHeaderView.b bVar = this.I;
        if (bVar != null) {
            return bVar.a();
        }
        return getParent() != null;
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void handleRefreshGesture(MotionEvent motionEvent) {
        if (this.D == -1.0f) {
            this.D = motionEvent.getRawY();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.D = motionEvent.getRawY();
            this.E = 0.0f;
            return;
        }
        if (action != 2) {
            Iterator<b> it = this.L.iterator();
            while (it.hasNext()) {
                it.next().onRelease();
            }
            d();
            return;
        }
        float rawY = motionEvent.getRawY();
        float f16 = this.D;
        float f17 = (rawY - f16) / 2.0f;
        boolean z16 = f16 == 0.0f;
        this.D = motionEvent.getRawY();
        this.E += f17;
        h(f17, z16);
        if (f()) {
            i(f17, this.E);
        }
    }

    public void i(float f16, float f17) {
        List<b> list = this.L;
        if (list != null && list.size() > 0) {
            Iterator<b> it = this.L.iterator();
            while (it.hasNext()) {
                if (it.next().a(f16, f17)) {
                    return;
                }
            }
        }
        if (c() > 0 || f16 > 0.0f) {
            setVisibleHeight(((int) f16) + c());
            if (this.C <= 1) {
                if (c() > this.f56138m) {
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
        return this.F;
    }

    public boolean k() {
        boolean z16;
        c();
        if (c() <= this.f56138m || this.C >= 2) {
            z16 = false;
        } else {
            setState(2);
            z16 = true;
        }
        o();
        return z16;
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
        QZLog.i("QZoneConciseZPlan RefreshHeaderView", 1, "[onDetachedFromWindow] mState=" + this.C);
        if (this.C == 1) {
            setState(2);
        }
    }

    public void setCanRefreshDelegate(RefreshHeaderView.b bVar) {
        this.I = bVar;
    }

    public void setMeasuredHeight(int i3) {
        this.f56138m = i3;
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void setOnRefreshListener(IRefreshViewProvider.OnRefreshListener onRefreshListener) {
        this.K = onRefreshListener;
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void setRefreshing(boolean z16) {
        QLog.i("QZoneConciseZPlan RefreshHeaderView", 1, "[setRefreshing] refreshing = " + z16);
        this.F = z16;
        if (z16) {
            return;
        }
        m();
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void setState(int i3) {
        if (i3 == this.C) {
            return;
        }
        if (i3 == 0) {
            this.f56135f.setText(getResources().getString(R.string.hqh));
        } else if (i3 == 1) {
            this.f56134e.setVisibility(0);
            if (this.C != 1) {
                this.f56135f.setText(getResources().getString(R.string.hqj));
            }
        } else if (i3 == 2) {
            this.H = System.currentTimeMillis();
            this.f56134e.clearAnimation();
            this.f56134e.setVisibility(8);
            o();
            this.f56135f.setText(getResources().getString(R.string.hqg));
            IRefreshViewProvider.OnRefreshListener onRefreshListener = this.K;
            if (onRefreshListener != null) {
                onRefreshListener.onRefresh();
            }
        } else if (i3 == 3) {
            this.f56134e.setVisibility(8);
            this.f56135f.setText(getResources().getString(R.string.hqk));
            o();
        } else if (i3 == 4) {
            QLog.d("QZoneConciseZPlan RefreshHeaderView", 1, "STATE_JUST_SHOW_REFRESH_ANIMATION");
            this.H = System.currentTimeMillis();
            this.f56134e.clearAnimation();
            this.f56134e.setVisibility(8);
            n(this.f56138m);
            this.f56135f.setText(getResources().getString(R.string.hqg));
            setRefreshing(true);
        }
        QLog.d("RefreshHeaderView", 1, "state:" + i3);
        this.C = i3;
    }

    public QZoneFeedxRefreshView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void j() {
        setState(1);
    }

    public void l() {
        setState(0);
    }

    public void m() {
        QLog.d("RefreshHeaderView", 1, "refreshComplete");
        long j3 = 1000 - this.H;
        if (j3 > 0) {
            b().postDelayed(new Runnable() { // from class: com.qzone.reborn.feedx.widget.header.QZoneFeedxRefreshView.1
                @Override // java.lang.Runnable
                public void run() {
                    QZoneFeedxRefreshView.this.setState(3);
                }
            }, j3);
        } else {
            setState(3);
        }
    }

    protected void n(int i3) {
        ValueAnimator ofInt = ValueAnimator.ofInt(c(), i3);
        ofInt.setDuration(200L).start();
        ofInt.addUpdateListener(new a(i3));
        ofInt.start();
    }

    public void o() {
        n(0);
    }

    public QZoneFeedxRefreshView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.L = new ArrayList();
        e();
    }

    public void d() {
        this.D = -1.0f;
        if (!g() || this.F) {
            return;
        }
        k();
    }

    public void setVisibleHeight(int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f56133d.getLayoutParams();
        layoutParams.height = i3;
        this.f56133d.setLayoutParams(layoutParams);
    }

    private boolean h(float f16, boolean z16) {
        boolean z17 = f16 > 0.0f && !z16;
        this.J = z17;
        return z17;
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public View getRefreshView() {
        return this;
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void callRefresh(RecyclerView recyclerView) {
    }
}
