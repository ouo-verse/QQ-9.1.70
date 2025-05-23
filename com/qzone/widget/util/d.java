package com.qzone.widget.util;

import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.tavcut.util.FloatUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public ValueAnimator f61132a;

    /* renamed from: b, reason: collision with root package name */
    public ValueAnimator f61133b;

    /* renamed from: c, reason: collision with root package name */
    public ValueAnimator f61134c;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewGroup.LayoutParams f61135d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f61136e;

        a(ViewGroup.LayoutParams layoutParams, View view) {
            this.f61135d = layoutParams;
            this.f61136e = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f61135d.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.f61136e.setLayoutParams(this.f61135d);
            this.f61136e.requestLayout();
        }
    }

    private void d(View view, float f16, float f17, AnimatorListenerAdapter animatorListenerAdapter) {
        if (FloatUtils.isEquals(f16, f17)) {
            return;
        }
        QZLog.i("QzonePanelAnimateHelper", "animateToTargetY top =" + f16 + " targetY=" + f17);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "y", f16, f17);
        this.f61133b = ofFloat;
        if (f16 > f17) {
            he0.b.l(ofFloat, R.anim.f154974uh);
        } else {
            he0.b.l(ofFloat, R.anim.f154977uk);
        }
        if (animatorListenerAdapter != null) {
            this.f61133b.addListener(animatorListenerAdapter);
        }
        this.f61133b.setDuration(150L).start();
    }

    public void e(View view, AnimatorListenerAdapter animatorListenerAdapter) {
        d(view, view.getBottom(), view.getTop(), animatorListenerAdapter);
    }

    public void f(View view, AnimatorListenerAdapter animatorListenerAdapter) {
        d(view, view.getTop(), view.getBottom(), animatorListenerAdapter);
    }

    public void g() {
        ValueAnimator valueAnimator = this.f61132a;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f61132a.removeAllListeners();
            this.f61132a.cancel();
        }
        ValueAnimator valueAnimator2 = this.f61133b;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
            this.f61133b.removeAllListeners();
            this.f61133b.cancel();
        }
        ValueAnimator valueAnimator3 = this.f61134c;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
            this.f61134c.removeAllListeners();
            this.f61134c.cancel();
        }
    }

    public void h(View view, float f16, float f17, int i3, AnimatorListenerAdapter animatorListenerAdapter) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, f16, f17);
        this.f61134c = ofFloat;
        ofFloat.setDuration(i3);
        if (animatorListenerAdapter != null) {
            this.f61134c.addListener(animatorListenerAdapter);
        }
        this.f61134c.start();
    }

    public void c(View view, int i3) {
        if (view == null) {
            return;
        }
        int height = view.getHeight();
        QLog.d("QzonePanelAnimateHelper", 1, "[animHeightToTargetView] fromY =" + height + "\uff0ctargetY=" + i3);
        if (height == i3) {
            return;
        }
        ValueAnimator valueAnimator = this.f61132a;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f61132a.removeAllListeners();
            this.f61132a.removeAllUpdateListeners();
            this.f61132a.cancel();
        }
        view.setVisibility(0);
        this.f61132a = ValueAnimator.ofInt(height, i3);
        this.f61132a.addUpdateListener(new a(view.getLayoutParams(), view));
        if (i3 > 0) {
            he0.b.l(this.f61132a, R.anim.f154974uh);
        } else {
            he0.b.l(this.f61132a, R.anim.f154977uk);
        }
        this.f61132a.setDuration(200L);
        this.f61132a.start();
    }

    public void a(View view) {
        h(view, 0.0f, 1.0f, 100, null);
    }

    public void b(View view, AnimatorListenerAdapter animatorListenerAdapter) {
        h(view, 1.0f, 0.0f, 50, animatorListenerAdapter);
    }
}
