package com.tencent.sqshow.zootopia.view.pull2refresh;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.widget.pull2refresh.PullToRefreshListener;
import com.tencent.widget.pull2refresh.anim.IAnimManager;

/* loaded from: classes34.dex */
public class ZootopiaDetailPullToRefreshView extends AbsPullToRefreshView implements PullToRefreshListener {
    private c L;
    private boolean M;
    private int N;
    private int P;
    public b Q;
    private ThreadLocal<Boolean> R;

    /* loaded from: classes34.dex */
    class a extends ThreadLocal<Boolean> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean initialValue() {
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes34.dex */
    public interface b {
        void Xf(RelativeLayout.LayoutParams layoutParams);

        boolean canScrollVertically(int i3);

        ViewGroup.LayoutParams u7();
    }

    /* loaded from: classes34.dex */
    public interface c {
        void F1(ZootopiaDetailPullToRefreshView zootopiaDetailPullToRefreshView, boolean z16);

        void endOfRefresh();
    }

    public ZootopiaDetailPullToRefreshView(Context context) {
        super(context);
        this.M = true;
        this.N = 0;
        this.P = 0;
        this.R = new a();
        i();
    }

    private void i() {
        u(this);
    }

    private IAnimManager w() {
        if (this.I == null) {
            this.I = new e(getContext());
        }
        return this.I;
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.AbsPullToRefreshView
    protected int e() {
        return this.I.getPullRefreshAreaHeight();
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.AbsPullToRefreshView
    protected View f() {
        return null;
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.AbsPullToRefreshView
    protected View g() {
        View refreshView = this.I.getRefreshView(this);
        setPullHeaderBgDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        refreshView.setId(R.id.qeo);
        return refreshView;
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.AbsPullToRefreshView
    protected void j() {
        setAnimType(w());
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.AbsPullToRefreshView
    protected boolean k() {
        return !this.Q.canScrollVertically(1);
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.AbsPullToRefreshView
    protected boolean l() {
        if (this.M) {
            return !this.Q.canScrollVertically(-1);
        }
        return false;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        a(this.f373347f);
    }

    @Override // com.tencent.widget.pull2refresh.PullToRefreshListener
    public void onNotCompleteVisable(View view, int i3) {
        IAnimManager iAnimManager = this.I;
        if (iAnimManager == null || view != iAnimManager.getRefreshView(this)) {
            return;
        }
        this.I.onPullRefreshing(i3, this.f373346e);
    }

    @Override // com.tencent.widget.pull2refresh.PullToRefreshListener
    public void onViewCompleteVisable(View view) {
        IAnimManager iAnimManager = this.I;
        if (iAnimManager == null || view != iAnimManager.getRefreshView(this)) {
            return;
        }
        this.I.onPullRefreshing(100, this.f373346e);
    }

    @Override // com.tencent.widget.pull2refresh.PullToRefreshListener
    public boolean onViewCompleteVisableAndReleased(View view) {
        boolean booleanValue = this.R.get().booleanValue();
        this.R.set(Boolean.FALSE);
        IAnimManager iAnimManager = this.I;
        if (iAnimManager == null || view != iAnimManager.getRefreshView(this)) {
            return true;
        }
        this.I.onPullRefreshComplete(booleanValue);
        c cVar = this.L;
        if (cVar == null) {
            return true;
        }
        cVar.F1(this, booleanValue);
        return true;
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.AbsPullToRefreshView
    public void s(boolean z16) {
        super.s(z16);
        IAnimManager iAnimManager = this.I;
        if (iAnimManager != null) {
            iAnimManager.showRefreshResult(z16, "");
        }
        c cVar = this.L;
        if (cVar != null) {
            cVar.endOfRefresh();
        }
    }

    public void setHeaderNightStyle(Boolean bool) {
        IAnimManager iAnimManager = this.I;
        if (iAnimManager instanceof e) {
            ((e) iAnimManager).c(bool.booleanValue());
        }
    }

    public void setOnRefreshPullDistanceListener(IAnimManager.OnRefreshPullDistanceListener onRefreshPullDistanceListener) {
        w().setRefreshPullDistanceListener(onRefreshPullDistanceListener);
    }

    public void setPullRefreshMode(int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Q.u7();
        if (i3 == 0) {
            layoutParams.addRule(3, 0);
            this.Q.Xf(layoutParams);
        } else {
            if (i3 != 1) {
                return;
            }
            layoutParams.addRule(3, R.id.qeo);
            this.Q.Xf(layoutParams);
        }
    }

    public void setRefreshCallback(c cVar) {
        this.L = cVar;
    }

    public void setRefreshEnable(boolean z16) {
        this.M = z16;
    }

    public void x() {
        IAnimManager iAnimManager = this.I;
        if (iAnimManager instanceof e) {
            ((e) iAnimManager).a();
        }
    }

    public ZootopiaDetailPullToRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.M = true;
        this.N = 0;
        this.P = 0;
        this.R = new a();
        i();
    }

    public ZootopiaDetailPullToRefreshView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.M = true;
        this.N = 0;
        this.P = 0;
        this.R = new a();
        i();
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.AbsPullToRefreshView
    protected void d(boolean z16) {
    }

    @Override // com.tencent.widget.pull2refresh.PullToRefreshListener
    public void onViewNotCompleteVisableAndReleased(View view) {
    }

    @Override // com.tencent.widget.pull2refresh.PullToRefreshListener
    public void onRefreshCompleted(View view, boolean z16) {
    }
}
