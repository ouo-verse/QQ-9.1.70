package com.tencent.mobileqq.popanim.state;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class PopDeleteState extends com.tencent.mobileqq.popanim.state.a {
    static IPatchRedirector $redirector_;
    private TextView C;
    private LottieDrawable D;
    private e E;
    private int F;
    ObjectAnimator G;
    private final int H;
    private final int I;

    /* renamed from: h, reason: collision with root package name */
    private LottieAnimationView f259117h;

    /* renamed from: i, reason: collision with root package name */
    private LottieAnimationView f259118i;

    /* renamed from: m, reason: collision with root package name */
    private View f259119m;

    /* loaded from: classes16.dex */
    class a implements LottieHelper.d {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PopDeleteState.this);
            }
        }

        @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
        public void onLoad(LottieDrawable lottieDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                PopDeleteState.this.D = lottieDrawable;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) lottieDrawable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class b implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PopDeleteState.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) animator);
                return;
            }
            PopDeleteState.this.u();
            com.tencent.mobileqq.popanim.view.a.j(4, PopDeleteState.this.f259118i, PopDeleteState.this.f259119m);
            PopDeleteState.this.f259119m.setTranslationY(0.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                onAnimationEnd(animator);
            } else {
                iPatchRedirector.redirect((short) 3, this, animator, Boolean.valueOf(z16));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                onAnimationStart(animator);
            } else {
                iPatchRedirector.redirect((short) 2, this, animator, Boolean.valueOf(z16));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
                return;
            }
            PopDeleteState.this.u();
            com.tencent.mobileqq.popanim.view.a.j(4, PopDeleteState.this.f259118i, PopDeleteState.this.f259119m);
            PopDeleteState.this.f259119m.setTranslationY(0.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                return;
            }
            PopDeleteState.this.f259119m.setTranslationY(0.0f);
            PopDeleteState.this.f259119m.getLayoutParams().height = PopDeleteState.this.I;
            PopDeleteState.this.f259119m.setBackgroundResource(R.drawable.jlp);
            PopDeleteState.this.f259119m.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PopDeleteState(RelativeLayout relativeLayout, f fVar) {
        super(relativeLayout, fVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) relativeLayout, (Object) fVar);
            return;
        }
        this.f259117h = (LottieAnimationView) this.f259123e.findViewById(R.id.v6d);
        this.f259118i = (LottieAnimationView) this.f259123e.findViewById(R.id.f26350da);
        this.f259119m = this.f259123e.findViewById(R.id.f26360db);
        this.C = (TextView) this.f259123e.findViewById(R.id.tlj);
        this.F = this.f259122d.getResources().getDisplayMetrics().heightPixels;
        int i3 = this.f259119m.getLayoutParams().height;
        this.H = i3;
        this.I = i3 + ViewUtils.dpToPx(10.0f);
        LottieHelper.b(this.f259122d, "emoc/pop_anim_del_confirm.json", null, 50, 50, 0, new a());
    }

    private void t() {
        f fVar = this.f259124f;
        if (fVar.f259148m) {
            return;
        }
        fVar.f259148m = true;
        this.E.G.h();
        com.tencent.mobileqq.stickerbubble.viewholder.b.f290239a.k().n();
        if (QLog.isColorLevel()) {
            QLog.d("PopDeleteState", 2, "pausePopAnim");
        }
    }

    private void v() {
        if (!this.f259124f.f259148m) {
            return;
        }
        this.E.G.i();
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.popanim.state.PopDeleteState.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PopDeleteState.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    com.tencent.mobileqq.stickerbubble.viewholder.b.f290239a.k().o();
                }
            }
        }, 300L);
        if (QLog.isColorLevel()) {
            QLog.d("PopDeleteState", 2, "resumePopAnim");
        }
    }

    private void w() {
        View view = this.f259119m;
        if (view == null) {
            return;
        }
        if (this.G == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", this.I);
            this.G = ofFloat;
            ofFloat.setDuration(400L);
            this.G.addListener(new b());
        }
        this.G.start();
    }

    @Override // com.tencent.mobileqq.popanim.state.a
    public void a(com.tencent.mobileqq.popanim.state.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        if (!(aVar instanceof e)) {
            QLog.d("PopDeleteState", 1, new Exception(), "preState error, ", aVar);
            return;
        }
        this.E = (e) aVar;
        LottieDrawable lottieDrawable = this.D;
        if (lottieDrawable != null) {
            this.f259118i.setImageDrawable(lottieDrawable);
        }
        com.tencent.mobileqq.popanim.view.a.j(0, this.f259118i);
        this.f259119m.getLayoutParams().height = this.I;
        this.f259119m.setBackgroundResource(R.drawable.jlp);
        this.f259119m.requestLayout();
        com.tencent.mobileqq.popanim.view.a.j(4, this.f259117h);
        t();
        int c16 = com.tencent.mobileqq.popanim.util.a.c(this.F, this.f259124f.f259141f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
        this.C.setVisibility(0);
        layoutParams.setMargins(0, 0, 0, c16);
        f fVar = this.f259124f;
        if (!fVar.f259147l) {
            fVar.f259147l = true;
            com.tencent.mobileqq.popanim.view.a.h("0X800BBA2", fVar.f259137b);
        }
    }

    @Override // com.tencent.mobileqq.popanim.state.a
    public void b(com.tencent.mobileqq.popanim.state.a aVar) {
        com.tencent.mobileqq.activity.aio.stickerbubble.e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        v();
        if (aVar instanceof e) {
            u();
            this.f259124f.f259148m = false;
            com.tencent.mobileqq.popanim.view.a.j(0, this.f259117h);
            this.C.setVisibility(4);
            return;
        }
        w();
        com.tencent.mobileqq.popanim.view.a.j(4, this.C, this.f259117h);
        e eVar2 = this.E;
        if (eVar2 != null && (eVar = eVar2.G) != null) {
            eVar.d();
            this.E.G.a();
        }
    }

    @Override // com.tencent.mobileqq.popanim.state.a
    public boolean c(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return true;
    }

    protected void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.f259118i.setImageResource(R.drawable.mac);
        this.f259119m.getLayoutParams().height = this.H;
        this.f259119m.setBackgroundResource(R.drawable.jlo);
        this.f259119m.requestLayout();
    }
}
