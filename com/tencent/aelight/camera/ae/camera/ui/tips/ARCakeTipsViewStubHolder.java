package com.tencent.aelight.camera.ae.camera.ui.tips;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ARCakeTipsViewStubHolder extends com.tencent.aelight.camera.ae.camera.ui.a {
    private final Runnable C;

    /* renamed from: h, reason: collision with root package name */
    private ViewGroup f63302h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f63303i;

    /* renamed from: m, reason: collision with root package name */
    private final Handler f63304m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ARCakeTipsViewStubHolder.this.f63302h.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ARCakeTipsViewStubHolder.this.f63302h.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ARCakeTipsViewStubHolder.this.f63302h.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ARCakeTipsViewStubHolder.this.f63302h.setVisibility(8);
        }
    }

    public ARCakeTipsViewStubHolder(ViewStub viewStub) {
        super(viewStub);
        this.C = new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.tips.ARCakeTipsViewStubHolder.1
            @Override // java.lang.Runnable
            public void run() {
                ARCakeTipsViewStubHolder.this.s();
            }
        };
        this.f63304m = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (k() && this.f63302h.getVisibility() == 0) {
            this.f63302h.animate().alpha(0.0f).setDuration(150L).setListener(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i3) {
        this.f63303i.setVisibility(0);
        this.f63303i.setText(this.f63303i.getContext().getResources().getString(R.string.y7r, Integer.valueOf(i3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        this.f63303i.setVisibility(0);
        this.f63303i.setText(R.string.f169902y80);
    }

    private void y(Runnable runnable, long j3) {
        i();
        runnable.run();
        this.f63304m.removeCallbacks(this.C);
        this.f63304m.postDelayed(this.C, j3);
        if (this.f63302h.getVisibility() == 0) {
            return;
        }
        this.f63302h.setAlpha(0.0f);
        this.f63302h.setVisibility(0);
        this.f63302h.animate().alpha(1.0f).setDuration(150L).setListener(new a());
    }

    public void r() {
        this.f63304m.removeCallbacks(this.C);
        this.f63304m.post(this.C);
    }

    public void v(final int i3) {
        y(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.tips.ARCakeTipsViewStubHolder.3
            @Override // java.lang.Runnable
            public void run() {
                ARCakeTipsViewStubHolder.this.t(i3);
            }
        }, 10000L);
    }

    public void w() {
        x(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.tips.ARCakeTipsViewStubHolder.2
            @Override // java.lang.Runnable
            public void run() {
                ARCakeTipsViewStubHolder.this.u();
            }
        });
    }

    private void x(Runnable runnable) {
        y(runnable, 2000L);
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.a
    protected void l(View view) {
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.roe);
        this.f63302h = viewGroup;
        this.f63303i = (TextView) viewGroup.findViewById(R.id.s37);
        this.f63302h.setVisibility(8);
    }
}
