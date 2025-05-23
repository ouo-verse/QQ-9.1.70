package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AccountDetailXListView extends XListView implements AbsListView.OnScrollListener, Runnable {
    public b C;
    public boolean D;
    private a E;
    private int F;
    private int G;
    protected boolean H;
    protected float I;
    protected float J;
    protected float K;
    protected int L;
    protected float M;
    float N;

    /* renamed from: d, reason: collision with root package name */
    protected int f79248d;

    /* renamed from: e, reason: collision with root package name */
    protected int f79249e;

    /* renamed from: f, reason: collision with root package name */
    protected int f79250f;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f79251h;

    /* renamed from: i, reason: collision with root package name */
    protected RelativeLayout f79252i;

    /* renamed from: m, reason: collision with root package name */
    protected ProgressBar f79253m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void a(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
        void startLoadMore(ListView listView);
    }

    public AccountDetailXListView(Context context) {
        this(context, null);
    }

    private void b0(int i3) {
        RelativeLayout relativeLayout = this.f79252i;
        if (relativeLayout != null) {
            relativeLayout.setPadding(relativeLayout.getPaddingLeft(), 0, this.f79252i.getPaddingRight(), i3);
        }
    }

    private void d0(Context context, AttributeSet attributeSet) {
        e0();
        this.f79250f = context.getResources().getDisplayMetrics().heightPixels;
        setOnScrollListener(this);
    }

    private void e0() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.a4a, (ViewGroup) this, false);
        this.f79252i = relativeLayout;
        this.f79253m = (ProgressBar) relativeLayout.findViewById(R.id.g5n);
        this.f79251h = (TextView) this.f79252i.findViewById(R.id.g5o);
        addFooterView(this.f79252i, null, false);
        setFooterDividersEnabled(false);
    }

    private boolean f0() {
        return getAdapter() != null && getFooterViewsCount() > 0 && getLastVisiblePosition() == getAdapter().getCount() - 1;
    }

    private void i0() {
        if (!f0() || this.C == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AccountDetailXListView", 2, "loadingMore");
        }
        this.f79252i.setVisibility(0);
        this.f79253m.setVisibility(0);
        this.f79251h.setText(R.string.f169988bi);
        b0(0);
        this.f79248d = 1;
        this.C.startLoadMore(this);
    }

    public void g0(boolean z16) {
        if (this.f79252i != null) {
            if (QLog.isColorLevel()) {
                QLog.d("AccountDetailXListView", 2, "loadMoreComplete hasMoreData = " + z16);
            }
            this.f79248d = 0;
            if (!z16) {
                this.f79251h.setText(R.string.f169989bj);
                this.f79253m.setVisibility(8);
                this.f79252i.setVisibility(0);
                this.D = false;
                return;
            }
            this.f79252i.setVisibility(8);
        }
    }

    public void h0() {
        if (this.f79252i != null) {
            if (QLog.isColorLevel()) {
                QLog.d("AccountDetailXListView", 2, "loadMoreFail");
            }
            this.f79252i.setVisibility(0);
            this.f79251h.setText(R.string.f169987bh);
            this.f79253m.setVisibility(8);
            b0(0);
            this.f79248d = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ListView, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, com.tencent.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        RelativeLayout relativeLayout;
        super.onLayout(z16, i3, i16, i17, i18);
        if (!z16 || this.f79249e >= 0 || (relativeLayout = this.f79252i) == null) {
            return;
        }
        int height = relativeLayout.getHeight();
        this.f79249e = height;
        b0(-height);
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        this.J = motionEvent.getY();
        if (action == 0) {
            this.L = (int) motionEvent.getY();
            float f16 = this.J;
            this.I = f16;
            this.H = true;
            this.K = f16;
        } else if (action == 2) {
            this.L = (int) (motionEvent.getY() - this.L);
            if (Math.abs(this.J - this.I) < x.c(super.getContext(), 10.0f)) {
                this.L = (int) motionEvent.getY();
                float f17 = this.J;
                this.M = f17 - this.K;
                this.K = f17;
            }
        } else if (motionEvent.getAction() == 1) {
            this.N = Math.abs(this.M);
            this.K = this.J;
            this.L = (int) motionEvent.getY();
            this.H = false;
            float f18 = this.J;
            this.M = f18 - this.K;
            this.K = f18;
            this.F = getScrollY();
            removeCallbacks(this);
            postDelayed(this, this.G);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.F - getScrollY() == 0) {
            a aVar = this.E;
            if (aVar != null) {
                aVar.a((int) this.N);
                return;
            }
            return;
        }
        this.F = getScrollY();
        postDelayed(this, this.G);
    }

    public void setOnEndScrollListener(a aVar) {
        this.E = aVar;
    }

    public void setRefreshCallback(b bVar) {
        this.C = bVar;
    }

    public AccountDetailXListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f79248d = 0;
        this.f79250f = 0;
        this.D = true;
        this.G = 100;
        this.I = 0.0f;
        this.J = 0.0f;
        this.K = 0.0f;
        this.L = 0;
        this.M = 0.0f;
        this.N = 0.0f;
        d0(context, attributeSet);
    }

    public void c0() {
        this.C = null;
    }

    public void j0(boolean z16) {
        if (z16) {
            if (this.f79252i == null) {
                e0();
            }
            if (getFooterViewsCount() <= 0) {
                addFooterView(this.f79252i);
                return;
            }
            return;
        }
        if (this.f79252i == null || getFooterViewsCount() <= 0) {
            return;
        }
        removeFooterView(this.f79252i);
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        if (i3 == 0 && this.f79248d == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && this.D) {
            i0();
        }
    }

    public AccountDetailXListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f79248d = 0;
        this.f79250f = 0;
        this.D = true;
        this.G = 100;
        this.I = 0.0f;
        this.J = 0.0f;
        this.K = 0.0f;
        this.L = 0;
        this.M = 0.0f;
        this.N = 0.0f;
        d0(context, attributeSet);
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
    }
}
