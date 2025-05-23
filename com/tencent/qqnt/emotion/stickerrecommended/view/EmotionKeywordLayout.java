package com.tencent.qqnt.emotion.stickerrecommended.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.f;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes24.dex */
public class EmotionKeywordLayout extends LinearLayout {
    static IPatchRedirector $redirector_;
    private LinearLayout C;
    private TextView D;
    private LinearLayout E;
    private Animator.AnimatorListener F;

    /* renamed from: d, reason: collision with root package name */
    private ValueAnimator f356646d;

    /* renamed from: e, reason: collision with root package name */
    private ValueAnimator f356647e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f356648f;

    /* renamed from: h, reason: collision with root package name */
    private int f356649h;

    /* renamed from: i, reason: collision with root package name */
    private EmotionKeywordHorizonListView f356650i;

    /* renamed from: m, reason: collision with root package name */
    private d f356651m;

    /* compiled from: P */
    /* loaded from: classes24.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmotionKeywordLayout.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (QLog.isDevelopLevel()) {
                QLog.d("EmotionKeywordLayout", 4, "show:offset=" + floatValue);
            }
            if (EmotionKeywordLayout.this.E != null) {
                EmotionKeywordLayout.this.E.setTranslationY(floatValue);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes24.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmotionKeywordLayout.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (EmotionKeywordLayout.this.E != null) {
                EmotionKeywordLayout.this.E.setTranslationY(floatValue);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes24.dex */
    class c extends f {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmotionKeywordLayout.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            if (animator == EmotionKeywordLayout.this.f356647e) {
                EmotionKeywordLayout.this.setVisibility(8);
            }
            if (EmotionKeywordLayout.this.f356650i != null) {
                EmotionKeywordLayout.this.f356650i.resetCurrentX(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public interface d {
        void onVisibilityChanged(int i3);
    }

    public EmotionKeywordLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.F = new c();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private void e() {
        if (this.C == null) {
            this.C = (LinearLayout) findViewById(R.id.uso);
        }
        if (this.D == null) {
            this.D = (TextView) findViewById(R.id.usn);
        }
        if (this.f356650i == null) {
            this.f356650i = (EmotionKeywordHorizonListView) findViewById(R.id.bvm);
        }
        if (this.E == null) {
            this.E = (LinearLayout) findViewById(R.id.spu);
        }
    }

    private void g() {
        int i3;
        if (this.C.getVisibility() == 0) {
            i3 = 100;
        } else {
            i3 = 81;
        }
        this.f356649h = Utils.n(i3, getResources());
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        e();
        if (getVisibility() == 8) {
            return;
        }
        if (!this.f356648f) {
            setVisibility(8);
            return;
        }
        ValueAnimator valueAnimator = this.f356647e;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return;
        }
        ValueAnimator valueAnimator2 = this.f356646d;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.f356646d.cancel();
        }
        if (this.f356647e == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, this.f356649h);
            this.f356647e = ofFloat;
            ofFloat.addUpdateListener(new b());
            this.f356647e.setDuration(200L);
            this.f356647e.addListener(this.F);
        }
        this.f356647e.start();
    }

    public void f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EmotionKeywordLayout", 2, "show");
        }
        e();
        if (StringUtil.isEmpty(str)) {
            this.D.setText("");
            this.C.setVisibility(8);
        } else {
            this.D.setText(str);
            this.C.setVisibility(0);
        }
        g();
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        ValueAnimator valueAnimator = this.f356646d;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return;
        }
        ValueAnimator valueAnimator2 = this.f356647e;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.f356647e.cancel();
        }
        if (this.f356646d == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f356649h, 0.0f);
            this.f356646d = ofFloat;
            ofFloat.addUpdateListener(new a());
            this.f356646d.setDuration(200L);
            this.f356646d.addListener(this.F);
        }
        this.f356646d.start();
        invalidate();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setEnableAnim(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.f356648f = z16;
        }
    }

    public void setOnVisibilityListener(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) dVar);
        } else {
            this.f356651m = dVar;
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        super.setVisibility(i3);
        d dVar = this.f356651m;
        if (dVar != null) {
            dVar.onVisibilityChanged(i3);
        }
    }

    public EmotionKeywordLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.F = new c();
            this.f356649h = ViewUtils.dip2px(81.0f);
        }
    }
}
