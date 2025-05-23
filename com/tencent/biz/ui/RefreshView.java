package com.tencent.biz.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.p;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RefreshView extends CustomScrollView {
    private d C;
    private int D;
    private boolean E;
    private final int F;
    private volatile boolean G;
    private Handler H;
    private OverScrollViewListener I;

    /* renamed from: i, reason: collision with root package name */
    public p f97003i;

    /* renamed from: m, reason: collision with root package name */
    int f97004m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                RefreshView.this.h();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b implements OverScrollViewListener {
        b() {
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public void onNotCompleteVisable(int i3, View view, ListView listView) {
            RefreshView refreshView = RefreshView.this;
            if (refreshView.f97004m == 2) {
                refreshView.f97003i.g();
            } else {
                refreshView.f97003i.i(0L);
            }
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public void onViewCompleteVisable(int i3, View view, ListView listView) {
            RefreshView refreshView = RefreshView.this;
            if (refreshView.f97004m != 2) {
                refreshView.f97003i.d(0L);
            }
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public boolean onViewCompleteVisableAndReleased(int i3, View view, ListView listView) {
            RefreshView refreshView = RefreshView.this;
            if (refreshView.f97004m != 2) {
                refreshView.G = false;
                RefreshView refreshView2 = RefreshView.this;
                refreshView2.d(refreshView2.j());
                RefreshView.this.f97003i.h(0L);
                RefreshView refreshView3 = RefreshView.this;
                refreshView3.f97004m = 2;
                refreshView3.m();
            }
            return false;
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public void onViewNotCompleteVisableAndReleased(int i3, View view, ListView listView) {
            RefreshView.this.h();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface c {
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface d {
        void onRefresh();
    }

    public RefreshView(Context context) {
        super(context, null);
        this.D = 0;
        this.E = false;
        this.F = 0;
        this.G = true;
        this.H = new a();
        this.I = new b();
        l(context);
    }

    private boolean i() {
        int scrollY = getScrollY();
        boolean z16 = false;
        if (scrollY < 0) {
            if (scrollY > (-j())) {
                if (this.E) {
                    int i3 = this.D;
                    if (i3 == 0 || i3 == 2) {
                        this.I.onNotCompleteVisable(0, null, null);
                    }
                } else {
                    int i16 = this.D;
                    if (i16 == 1 || i16 == 2) {
                        this.I.onViewNotCompleteVisableAndReleased(0, null, null);
                    }
                }
                this.D = 1;
            } else {
                if (this.E) {
                    int i17 = this.D;
                    if (i17 == 0 || i17 == 1) {
                        this.I.onViewCompleteVisable(0, null, null);
                    }
                } else if (this.D == 2) {
                    z16 = this.I.onViewCompleteVisableAndReleased(0, null, null);
                }
                this.D = 2;
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int j() {
        return this.f97003i.b().getMeasuredHeight();
    }

    private void k() {
        this.f97003i.b().setMinimumHeight((int) (getResources().getDisplayMetrics().density * 60.0f));
        this.f97003i.b().setVisibility(8);
    }

    @SuppressLint({"InflateParams"})
    private void l(Context context) {
        PullRefreshHeader a16 = com.tencent.mobileqq.webview.view.a.a(context);
        this.f97003i = a16;
        addView(a16.b(), 0);
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        d dVar = this.C;
        if (dVar != null) {
            dVar.onRefresh();
        } else {
            h();
        }
    }

    @Override // com.tencent.biz.ui.CustomScrollView
    protected boolean c() {
        if (!this.G && this.f97004m != 3) {
            return false;
        }
        return true;
    }

    protected void h() {
        this.G = true;
        super.onBack();
    }

    public void n() {
        this.G = true;
        this.f97004m = 3;
        if (this.f97003i.k() == 0) {
            h();
        } else {
            this.H.sendEmptyMessageDelayed(0, this.f97003i.k());
        }
    }

    @Override // com.tencent.biz.ui.CustomScrollView, com.tencent.biz.ui.TouchWebView.OnOverScrollHandler
    public void onBack() {
        this.E = false;
        if (this.C == null) {
            super.onBack();
        } else {
            i();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.f97003i.b().layout(0, -this.f97003i.b().getMeasuredHeight(), this.f97003i.b().getMeasuredWidth(), 0);
    }

    @Override // com.tencent.biz.ui.CustomScrollView, com.tencent.biz.ui.TouchWebView.OnOverScrollHandler
    public void onOverScroll(int i3) {
        super.onOverScroll(i3);
        this.E = true;
        if (this.f97004m != 2) {
            i();
        }
    }

    public void setDelayBeforeScrollBack(long j3) {
        p pVar = this.f97003i;
        if (pVar instanceof PullRefreshHeader) {
            ((PullRefreshHeader) pVar).L = j3;
        }
    }

    public void setHeader(p pVar) {
        if (pVar == null) {
            return;
        }
        removeViewAt(0);
        this.f97003i = pVar;
        addView(pVar.b(), 0);
        k();
    }

    public final void setHeaderBgColor(int i3) {
        p pVar = this.f97003i;
        if (pVar != null) {
            pVar.setHeaderBgColor(i3);
        }
    }

    public final void setHeaderBgDrawable(Drawable drawable) {
        p pVar = this.f97003i;
        if (pVar != null) {
            pVar.setHeaderBgDrawable(drawable);
        }
    }

    public final void setHeaderBgRes(int i3) {
        p pVar = this.f97003i;
        if (pVar != null) {
            pVar.setHeaderBgRes(i3);
        }
    }

    public final void setHeaderTextColor(int i3, int i16, int i17, int i18, int i19) {
        p pVar = this.f97003i;
        if (pVar != null) {
            pVar.setTextColor(i3, i16, i17, i18, i19);
        }
    }

    public void setOnRefreshListener(d dVar) {
        this.C = dVar;
        if (dVar == null) {
            this.f97003i.b().setVisibility(8);
        } else {
            this.f97003i.b().setVisibility(0);
        }
    }

    public RefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = 0;
        this.E = false;
        this.F = 0;
        this.G = true;
        this.H = new a();
        this.I = new b();
        l(context);
    }

    public void setOnCancelListener(c cVar) {
    }
}
