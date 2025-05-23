package com.tencent.av.ui;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes3.dex */
public class QavFunctionPanel extends FrameLayout {
    private final int C;
    private final LinearLayout D;
    private final LinearLayout E;
    private final q F;
    private final QavPanelRecyclerView G;
    private final LinearLayoutManager H;
    private r I;
    private b J;
    private final List<Integer> K;

    /* renamed from: d, reason: collision with root package name */
    private float f75013d;

    /* renamed from: e, reason: collision with root package name */
    private float f75014e;

    /* renamed from: f, reason: collision with root package name */
    private int f75015f;

    /* renamed from: h, reason: collision with root package name */
    private int f75016h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f75017i;

    /* renamed from: m, reason: collision with root package name */
    private final int f75018m;

    /* loaded from: classes3.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull @NotNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            try {
                QavFunctionPanel.this.h();
            } catch (Exception unused) {
                QLog.d("QavFunctionReport", 2, "AV Panel Data Report Error");
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void dismiss();
    }

    public QavFunctionPanel(@NonNull Context context) {
        this(context, null);
    }

    private void d(float f16) {
        e(this.E.getY(), f16, 230);
    }

    private void e(float f16, float f17, int i3) {
        this.f75017i = false;
        this.f75016h = 0;
        long j3 = i3;
        ObjectAnimator.ofFloat(this.E, "Y", f16, f17).setDuration(j3).start();
        if (f17 == j()) {
            g(j3);
        }
    }

    private void g(long j3) {
        new Handler().postDelayed(new Runnable() { // from class: com.tencent.av.ui.QavFunctionPanel.3
            @Override // java.lang.Runnable
            public void run() {
                if (QavFunctionPanel.this.J != null) {
                    QavFunctionPanel.this.G.scrollToPosition(0);
                    QavFunctionPanel.this.J.dismiss();
                }
            }
        }, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.I.f76591b == null) {
            return;
        }
        int findLastVisibleItemPosition = this.H.findLastVisibleItemPosition();
        for (int findFirstVisibleItemPosition = this.H.findFirstVisibleItemPosition(); findFirstVisibleItemPosition < findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
            if (findFirstVisibleItemPosition < this.I.f76591b.size()) {
                rw.a aVar = this.I.f76591b.get(findFirstVisibleItemPosition);
                int c16 = aVar.c();
                if (!this.K.contains(Integer.valueOf(c16))) {
                    this.K.add(Integer.valueOf(c16));
                    p(aVar);
                }
            }
        }
    }

    private void i() {
        r rVar = this.I;
        if (rVar == null) {
            return;
        }
        Iterator<rw.a> it = rVar.f76590a.iterator();
        while (it.hasNext()) {
            p(it.next());
        }
        new Handler().postDelayed(new Runnable() { // from class: com.tencent.av.ui.QavFunctionPanel.4
            @Override // java.lang.Runnable
            public void run() {
                QavFunctionPanel.this.h();
            }
        }, 500L);
    }

    private float j() {
        return this.f75015f + this.f75018m;
    }

    private void l(float f16) {
        float f17 = f16 - this.f75013d;
        if (Math.abs(f17) > this.C) {
            if (f17 > 0.0f) {
                this.f75016h = 2;
            } else if (f17 < 0.0f) {
                this.f75016h = 1;
            }
        }
    }

    private void m(float f16) {
        if (this.f75014e <= f16) {
            l(f16);
            this.E.offsetTopAndBottom((int) (f16 - this.f75013d));
            this.f75013d = f16;
            return;
        }
        this.G.suppressLayout(false);
    }

    private void n() {
        this.G.suppressLayout(false);
        int i3 = this.f75016h;
        if (i3 == 2) {
            d(j());
            return;
        }
        if (i3 == 1) {
            d(0.0f);
        } else if ((this.f75018m - this.f75015f) + this.E.getY() > this.f75018m - (this.f75015f / 2)) {
            d(j());
        } else {
            d(0.0f);
        }
    }

    private void p(rw.a aVar) {
        AVUtil.r("0X800BC09", DataReport.v(com.tencent.av.n.e().f()), aVar.c(), "", "", "", "");
    }

    public void f() {
        QavPanelRecyclerView qavPanelRecyclerView = this.G;
        if (qavPanelRecyclerView != null) {
            qavPanelRecyclerView.setParentView(this);
            this.G.setLayoutManager(this.H);
            this.G.setAdapter(this.F);
            this.G.addOnScrollListener(new a());
            this.F.notifyDataSetChanged();
        }
    }

    public void k(r rVar) {
        q qVar = this.F;
        if (qVar != null) {
            this.I = rVar;
            qVar.i0(rVar);
        }
    }

    public void o() {
        if (this.K.size() > 0) {
            this.K.clear();
        }
        i();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f75017i = true;
        boolean z16 = false;
        if (motionEvent.getAction() == 10001) {
            motionEvent.setAction(0);
            return true;
        }
        Rect rect = new Rect();
        this.D.getGlobalVisibleRect(rect);
        if (!rect.isEmpty() && rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            z16 = true;
        }
        if (this.f75017i && z16) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.f75015f <= 0) {
            int measuredHeight = getMeasuredHeight();
            this.f75015f = measuredHeight;
            for (int i19 = 0; i19 < getChildCount(); i19++) {
                View childAt = getChildAt(i19);
                childAt.layout(0, 0, childAt.getMeasuredWidth(), measuredHeight);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    m(motionEvent.getRawY());
                    return true;
                }
            } else {
                n();
            }
        } else {
            this.f75013d = motionEvent.getRawY();
            this.f75014e = motionEvent.getRawY();
            if (this.f75017i) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void q() {
        new Handler().postDelayed(new Runnable() { // from class: com.tencent.av.ui.QavFunctionPanel.2
            @Override // java.lang.Runnable
            public void run() {
                if (QavFunctionPanel.this.G != null) {
                    QavFunctionPanel.this.G.scrollToPosition(0);
                }
            }
        }, 300L);
    }

    public void r(r rVar) {
        if (this.F != null) {
            this.I = rVar;
            this.E.setTranslationY(0.0f);
            this.F.t0(rVar);
        }
    }

    public void setOnDismissListener(b bVar) {
        this.J = bVar;
    }

    public void setPanelClickListener(k kVar) {
        q qVar = this.F;
        if (qVar != null) {
            qVar.q0(kVar);
        }
    }

    public QavFunctionPanel(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QavFunctionPanel(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.K = new ArrayList();
        View inflate = View.inflate(context, R.layout.fuc, this);
        QavPanelRecyclerView qavPanelRecyclerView = (QavPanelRecyclerView) inflate.findViewById(R.id.i4o);
        this.G = qavPanelRecyclerView;
        this.E = (LinearLayout) inflate.findViewById(R.id.b9r);
        this.D = (LinearLayout) inflate.findViewById(R.id.bq8);
        this.F = new q(context);
        this.H = new LinearLayoutManager(context);
        this.f75018m = ScreenUtil.getInstantScreenHeight(context);
        this.C = ViewConfiguration.get(getContext()).getScaledTouchSlop() + 55;
        qavPanelRecyclerView.setOverScrollMode(0);
    }
}
