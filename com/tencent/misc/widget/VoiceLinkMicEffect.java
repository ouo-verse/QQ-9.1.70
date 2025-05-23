package com.tencent.misc.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class VoiceLinkMicEffect extends RelativeLayout {
    static IPatchRedirector $redirector_;
    private ArrayList<b> C;
    int D;

    /* renamed from: d, reason: collision with root package name */
    private float f151672d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f151673e;

    /* renamed from: f, reason: collision with root package name */
    private int f151674f;

    /* renamed from: h, reason: collision with root package name */
    private AnimatorSet f151675h;

    /* renamed from: i, reason: collision with root package name */
    private List<Animator> f151676i;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout.LayoutParams f151677m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VoiceLinkMicEffect.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                VoiceLinkMicEffect.this.f151673e = false;
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
            } else if (VoiceLinkMicEffect.this.f151673e) {
                VoiceLinkMicEffect.this.f151675h.start();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b extends View {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        Paint f151679d;

        public b(Context context, int i3) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, VoiceLinkMicEffect.this, context, Integer.valueOf(i3));
                return;
            }
            Paint paint = new Paint();
            this.f151679d = paint;
            paint.setAntiAlias(true);
            this.f151679d.setStyle(Paint.Style.FILL);
            this.f151679d.setColor(i3);
            setVisibility(4);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            } else {
                float min = Math.min(getWidth(), getHeight()) / 2;
                canvas.drawCircle(min, min, min, this.f151679d);
            }
        }
    }

    public VoiceLinkMicEffect(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void d() {
        for (int i3 = 0; i3 < 2; i3++) {
            b bVar = new b(getContext(), this.f151674f);
            addView(bVar, 0, this.f151677m);
            this.C.add(bVar);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar, "ScaleX", 1.0f, this.f151672d);
            long j3 = i3 * 500;
            ofFloat.setStartDelay(j3);
            this.f151676i.add(ofFloat);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar, "ScaleY", 1.0f, this.f151672d);
            ofFloat2.setStartDelay(j3);
            this.f151676i.add(ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(bVar, "Alpha", 0.4f, 0.0f);
            ofFloat3.setStartDelay(j3);
            this.f151676i.add(ofFloat3);
            ofFloat.setDuration(1000L);
            ofFloat2.setDuration(1000L);
            ofFloat3.setDuration(1000L);
        }
    }

    private void e() {
        for (int i3 = 0; i3 < 8; i3++) {
            b bVar = new b(getContext(), this.f151674f);
            addView(bVar, 2, this.f151677m);
            this.C.add(bVar);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar, "ScaleX", 1.0f, this.f151672d);
            this.f151676i.add(ofFloat);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar, "ScaleY", 1.0f, this.f151672d);
            this.f151676i.add(ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(bVar, "Alpha", 0.4f, 0.0f);
            this.f151676i.add(ofFloat3);
            ofFloat.setDuration(1000L);
            ofFloat2.setDuration(1000L);
            ofFloat3.setDuration(1000L);
            if (i3 == 0) {
                ofFloat.setStartDelay(5933L);
                ofFloat2.setStartDelay(5933L);
                ofFloat3.setStartDelay(5933L);
            } else if (i3 == 1) {
                ofFloat.setStartDelay(6433L);
                ofFloat2.setStartDelay(6433L);
                ofFloat3.setStartDelay(6433L);
            } else if (i3 == 2) {
                ofFloat.setStartDelay(7433L);
                ofFloat2.setStartDelay(7433L);
                ofFloat3.setStartDelay(7433L);
            } else if (i3 == 3) {
                ofFloat.setStartDelay(7666L);
                ofFloat2.setStartDelay(7666L);
                ofFloat3.setStartDelay(7666L);
            } else if (i3 == 4) {
                ofFloat.setStartDelay(7999L);
                ofFloat2.setStartDelay(7999L);
                ofFloat3.setStartDelay(7999L);
            } else if (i3 == 5) {
                ofFloat.setStartDelay(8666L);
                ofFloat2.setStartDelay(8666L);
                ofFloat3.setStartDelay(8666L);
            } else if (i3 == 6) {
                ofFloat.setStartDelay(9166L);
                ofFloat2.setStartDelay(9166L);
                ofFloat3.setStartDelay(9166L);
            } else if (i3 == 7) {
                ofFloat.setStartDelay(9666L);
                ofFloat2.setStartDelay(9666L);
                ofFloat3.setStartDelay(9666L);
            }
        }
    }

    private void f() {
        for (int i3 = 0; i3 < 3; i3++) {
            b bVar = new b(getContext(), this.f151674f);
            addView(bVar, 1, this.f151677m);
            this.C.add(bVar);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar, "ScaleX", 1.0f, this.f151672d);
            this.f151676i.add(ofFloat);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar, "ScaleY", 1.0f, this.f151672d);
            this.f151676i.add(ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(bVar, "Alpha", 0.4f, 0.0f);
            this.f151676i.add(ofFloat3);
            ofFloat.setDuration(1000L);
            ofFloat2.setDuration(1000L);
            ofFloat3.setDuration(1000L);
            if (i3 == 0) {
                ofFloat.setStartDelay(3266L);
                ofFloat2.setStartDelay(3266L);
                ofFloat3.setStartDelay(3266L);
            } else if (i3 == 1) {
                ofFloat.setStartDelay(3499L);
                ofFloat2.setStartDelay(3499L);
                ofFloat3.setStartDelay(3499L);
            } else {
                ofFloat.setStartDelay(3899L);
                ofFloat2.setStartDelay(3899L);
                ofFloat3.setStartDelay(3899L);
            }
        }
    }

    private void g(AttributeSet attributeSet) {
        if (isInEditMode()) {
            return;
        }
        float f16 = (getContext().getResources().getDisplayMetrics().density * 35.0f) + 0.5f;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, li2.a.f414754q7);
            f16 = obtainStyledAttributes.getDimension(li2.a.f414772s7, f16);
            this.D = obtainStyledAttributes.getInteger(li2.a.f414763r7, 3);
        }
        int i3 = (int) (f16 * 2.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i3);
        this.f151677m = layoutParams;
        layoutParams.addRule(13, -1);
        h();
    }

    private void h() {
        this.f151675h = new AnimatorSet();
        this.f151676i = new ArrayList();
        if (this.D >= 1) {
            d();
        }
        if (this.D >= 2) {
            f();
        }
        if (this.D >= 3) {
            e();
        }
        this.f151675h.playTogether(this.f151676i);
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f151673e;
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        k();
        this.f151673e = true;
        Iterator<b> it = this.C.iterator();
        while (it.hasNext()) {
            it.next().setVisibility(0);
        }
        this.f151675h.start();
        this.f151675h.addListener(new a());
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (i()) {
            this.f151673e = false;
            this.f151675h.end();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onDetachedFromWindow();
            k();
        }
    }

    public void setWaveRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
            return;
        }
        if (f16 == 0.0f) {
            return;
        }
        int i3 = (int) (f16 * 2.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i3);
        this.f151677m = layoutParams;
        layoutParams.addRule(13, -1);
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            if (getChildAt(i16) instanceof b) {
                removeViewAt(i16);
            }
        }
        boolean i17 = i();
        k();
        this.C.clear();
        this.f151675h.cancel();
        this.f151675h = null;
        this.f151676i.clear();
        this.f151676i = null;
        h();
        if (i17) {
            j();
        }
    }

    public VoiceLinkMicEffect(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public VoiceLinkMicEffect(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f151672d = 1.8f;
        this.f151673e = false;
        this.f151674f = Color.argb(255, 255, 255, 255);
        this.C = new ArrayList<>();
        this.D = 3;
        g(attributeSet);
    }
}
