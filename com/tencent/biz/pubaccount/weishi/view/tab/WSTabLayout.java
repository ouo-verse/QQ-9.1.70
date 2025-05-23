package com.tencent.biz.pubaccount.weishi.view.tab;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSTabLayout extends TabLayoutCompat {

    /* renamed from: i0, reason: collision with root package name */
    private final Interpolator f82489i0;

    /* renamed from: j0, reason: collision with root package name */
    private ValueAnimator f82490j0;

    /* renamed from: k0, reason: collision with root package name */
    private ValueAnimator f82491k0;

    /* renamed from: l0, reason: collision with root package name */
    private final ArrayList<a20.c> f82492l0;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f82493m0;

    /* renamed from: n0, reason: collision with root package name */
    private LinearLayout f82494n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f82495o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f82496p0;

    /* renamed from: q0, reason: collision with root package name */
    private Paint f82497q0;

    /* renamed from: r0, reason: collision with root package name */
    private int f82498r0;

    /* renamed from: s0, reason: collision with root package name */
    private int f82499s0;

    /* renamed from: t0, reason: collision with root package name */
    private int f82500t0;

    /* renamed from: u0, reason: collision with root package name */
    private int f82501u0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f82502a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LinearLayout.LayoutParams f82503b;

        a(int i3, LinearLayout.LayoutParams layoutParams) {
            this.f82502a = i3;
            this.f82503b = layoutParams;
        }

        @Override // com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WSTabLayout.this.k0(valueAnimator, this.f82502a, this.f82503b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // com.nineoldandroids.animation.AnimatorListenerAdapter, com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            WSTabLayout.this.c0();
            x.b("WSTabLayoutLog", "[WSTabLayout.java][onAnimationCancel] showTab!!");
        }

        @Override // com.nineoldandroids.animation.AnimatorListenerAdapter, com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            WSTabLayout.this.c0();
            x.b("WSTabLayoutLog", "[WSTabLayout.java][onAnimationCancel] showTab!!");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f82506a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LinearLayout.LayoutParams f82507b;

        c(int i3, LinearLayout.LayoutParams layoutParams) {
            this.f82506a = i3;
            this.f82507b = layoutParams;
        }

        @Override // com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WSTabLayout.this.j0(valueAnimator, this.f82506a, this.f82507b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // com.nineoldandroids.animation.AnimatorListenerAdapter, com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            WSTabLayout.this.a0();
            x.b("WSTabLayoutLog", "[WSTabLayout.java][onAnimationCancel] hideTab!!");
        }

        @Override // com.nineoldandroids.animation.AnimatorListenerAdapter, com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            WSTabLayout.this.a0();
            x.b("WSTabLayoutLog", "[WSTabLayout.java][onAnimationEnd] hideTab!!");
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface e {
        void a(com.tencent.biz.pubaccount.weishi.view.tab.a aVar);

        void b(com.tencent.biz.pubaccount.weishi.view.tab.a aVar);
    }

    public WSTabLayout(Context context) {
        this(context, null);
    }

    private void Z() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
        int i3 = layoutParams.topMargin;
        if (i3 == (-ba.f81742q)) {
            x.f("WSTabLayoutLog", "[WSTabLayout.java][doHideTabLayoutAnim] currentTopMargin:" + i3 + ", doNothing!!");
            return;
        }
        q0();
        v0(layoutParams, i3);
    }

    private void b0() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
        int i3 = layoutParams.topMargin;
        if (i3 == 0) {
            x.f("WSTabLayoutLog", "[WSTabLayout.java][doShowTabLayoutAnim] currentTopMargin:0, doNothing!!");
        } else {
            r0();
            w0(layoutParams, i3);
        }
    }

    private void d0(Canvas canvas) {
        int i3;
        int i16 = this.f82495o0;
        if (i16 < 0 || (i3 = this.f82496p0) <= i16) {
            return;
        }
        int i17 = (int) (((i3 - i16) - this.f82498r0) / 2.0f);
        float f16 = this.f82499s0 / 2.0f;
        canvas.drawRoundRect(i16 + i17, (getHeight() - this.f82499s0) - this.f82500t0, this.f82496p0 - i17, getHeight() - this.f82500t0, f16, f16, this.f82497q0);
    }

    private float e0(Integer num) {
        return (num.intValue() * 1.0f) / 10000.0f;
    }

    private Animator.AnimatorListener f0() {
        return new d();
    }

    private long g0(int i3) {
        int i16 = ba.f81742q;
        return (Math.abs(i3 + i16) / i16) * 200.0f;
    }

    private Animator.AnimatorListener h0() {
        return new b();
    }

    private long i0(int i3) {
        return (Math.abs(i3) / ba.f81742q) * 200.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(ValueAnimator valueAnimator, int i3, LinearLayout.LayoutParams layoutParams) {
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            float e06 = e0((Integer) animatedValue);
            int i16 = (int) (i3 - ((ba.f81742q + i3) * e06));
            layoutParams.topMargin = i16;
            setLayoutParams(layoutParams);
            x.b("WSTabLayoutLog", "[WSTabLayout.java][doHideTabLayoutAnim] onAnimationUpdate currentTopMargin:" + i3 + ", animatorPercent:" + e06 + ", offset:" + i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(ValueAnimator valueAnimator, int i3, LinearLayout.LayoutParams layoutParams) {
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            float e06 = e0((Integer) animatedValue);
            int i16 = (int) (i3 * (1.0f - e06));
            layoutParams.topMargin = i16;
            setLayoutParams(layoutParams);
            x.b("WSTabLayoutLog", "[WSTabLayout.java][doShowTabLayoutAnim] onAnimationUpdate currentTopMargin:" + i3 + ", animatorPercent:" + e06 + ", offset:" + i16);
        }
    }

    private void m0(AttributeSet attributeSet) {
        p0(attributeSet);
        this.f82494n0 = (LinearLayout) getChildAt(0);
        setSelectedTabIndicatorHeight(0);
        o0();
    }

    private void o0() {
        Paint paint = new Paint();
        this.f82497q0 = paint;
        paint.setColor(this.f82501u0);
        this.f82497q0.setAntiAlias(true);
    }

    private void q0() {
        ValueAnimator valueAnimator = this.f82491k0;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f82491k0.removeAllListeners();
        this.f82491k0.cancel();
    }

    private void r0() {
        ValueAnimator valueAnimator = this.f82490j0;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f82490j0.cancel();
        this.f82490j0.removeAllListeners();
    }

    private void s0(int i3, int i16) {
        if (i3 == this.f82495o0 && i16 == this.f82496p0) {
            return;
        }
        this.f82495o0 = i3;
        this.f82496p0 = i16;
        ViewCompat.postInvalidateOnAnimation(this);
    }

    private void t0() {
        if (this.f82492l0.size() <= 5) {
            setTabMode(1);
            setTabGravity(0);
        } else {
            setTabMode(0);
            setTabGravity(1);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        d0(canvas);
    }

    public void l0(boolean z16) {
        x.j("WSTabLayoutLog", "[WSTabLayout.java][hideTabLayout] isStartAnim:" + z16);
        if (z16) {
            Z();
        } else {
            a0();
        }
    }

    public void setTabLayoutParams(int i3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
        layoutParams.topMargin = i3;
        setLayoutParams(layoutParams);
    }

    public void u0(boolean z16) {
        x.j("WSTabLayoutLog", "[WSTabLayout.java][showTabLayout] isStartAnim:" + z16);
        if (z16) {
            b0();
        } else {
            c0();
        }
    }

    public void x0(int i3, float f16) {
        int i16;
        int i17;
        View childAt = this.f82494n0.getChildAt(i3);
        if (childAt == null || childAt.getWidth() <= 0) {
            i16 = -1;
            i17 = -1;
        } else {
            i16 = childAt.getLeft();
            i17 = childAt.getRight();
            if (f16 > 0.0f && i3 < this.f82494n0.getChildCount() - 1) {
                View childAt2 = this.f82494n0.getChildAt(i3 + 1);
                float f17 = 1.0f - f16;
                i16 = (int) ((childAt2.getLeft() * f16) + (i16 * f17));
                i17 = (int) ((f16 * childAt2.getRight()) + (f17 * i17));
            }
        }
        s0(i16, i17);
    }

    public WSTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void Y(e eVar) {
        for (int i3 = 0; i3 < this.f82492l0.size(); i3++) {
            TabLayoutCompat.f E = E();
            if (E == null) {
                x.f("WSTabLayoutLog", "[WSTabLayout.java][initData] createTab newTab: null!");
                return;
            }
            E.l(R.layout.fwk);
            com.tencent.biz.pubaccount.weishi.view.tab.a aVar = new com.tencent.biz.pubaccount.weishi.view.tab.a(E.b());
            aVar.j(E);
            E.o(aVar);
            aVar.k(this.f82492l0.get(i3));
            aVar.h(eVar);
            h(E);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        this.f82493m0 = false;
        setTabLayoutParams(-ba.f81742q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0() {
        this.f82493m0 = true;
        setTabLayoutParams(0);
    }

    private void v0(LinearLayout.LayoutParams layoutParams, int i3) {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 10000);
        this.f82491k0 = ofInt;
        ofInt.setInterpolator(this.f82489i0);
        this.f82491k0.addUpdateListener(new c(i3, layoutParams));
        this.f82491k0.addListener(f0());
        this.f82491k0.setDuration(g0(i3));
        this.f82491k0.start();
    }

    private void w0(LinearLayout.LayoutParams layoutParams, int i3) {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 10000);
        this.f82490j0 = ofInt;
        ofInt.setInterpolator(this.f82489i0);
        this.f82490j0.addUpdateListener(new a(i3, layoutParams));
        this.f82490j0.addListener(h0());
        this.f82490j0.setDuration(i0(i3));
        this.f82490j0.start();
    }

    public void setTabItemSelect(int i3, int i16) {
        com.tencent.biz.pubaccount.weishi.view.tab.a aVar;
        for (int i17 = 0; i17 < this.f82492l0.size(); i17++) {
            TabLayoutCompat.f z16 = z(i17);
            if (z16 != null && (aVar = (com.tencent.biz.pubaccount.weishi.view.tab.a) z16.f()) != null) {
                if (i17 == i3) {
                    aVar.i(i16);
                } else {
                    aVar.m();
                }
            }
        }
    }

    public WSTabLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f82489i0 = new LinearInterpolator();
        this.f82490j0 = null;
        this.f82491k0 = null;
        this.f82492l0 = new ArrayList<>();
        this.f82493m0 = true;
        m0(attributeSet);
    }

    public void n0(List<a20.c> list, e eVar) {
        if (list != null && list.size() != 0) {
            this.f82492l0.clear();
            this.f82492l0.addAll(list);
            G();
            t0();
            Y(eVar);
            return;
        }
        x.f("WSTabLayoutLog", "[WSTabLayout.java][initData] initData list: null");
    }

    private void p0(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, f00.a.f397486a);
        this.f82498r0 = (int) obtainStyledAttributes.getDimension(3, 0.0f);
        this.f82499s0 = (int) obtainStyledAttributes.getDimension(2, 0.0f);
        this.f82500t0 = (int) obtainStyledAttributes.getDimension(1, 0.0f);
        this.f82501u0 = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
    }
}
