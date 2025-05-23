package com.tencent.av.ui.part.invite;

import android.app.Activity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.utils.ba;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import mw.m;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b extends Part {
    private m Q;
    private boolean X;

    /* renamed from: d, reason: collision with root package name */
    private QavPanel f76429d = null;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f76430e = null;

    /* renamed from: f, reason: collision with root package name */
    private TextView f76431f = null;

    /* renamed from: h, reason: collision with root package name */
    private TextView f76432h = null;

    /* renamed from: i, reason: collision with root package name */
    private View f76433i = null;

    /* renamed from: m, reason: collision with root package name */
    private View f76434m = null;
    private View C = null;
    private Animation D = null;
    private Animation E = null;
    private Animation F = null;
    private Animation G = null;
    private Animation H = null;
    private Animation I = null;
    private Animation J = null;
    private Animation K = null;
    private Animation L = null;
    private Animation M = null;
    private Animation N = null;
    private Animation.AnimationListener P = null;
    private d R = null;
    private d S = null;
    private Animation.AnimationListener T = null;
    private Animation.AnimationListener U = null;
    private Interpolator V = null;
    private Interpolator W = null;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface d {
        void onAnimationEnd();

        void onAnimationStart();
    }

    public b(boolean z16) {
        this.X = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N9() {
        View view = this.f76433i;
        if (view != null && view.getVisibility() == 0 && this.F == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
            this.F = translateAnimation;
            translateAnimation.setDuration(620L);
            this.F.setInterpolator(this.V);
        }
        if (this.G == null) {
            TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 0, -((int) (ba.getScreenHeight(getContext()) * 0.18f)), 1, 0.0f);
            this.G = translateAnimation2;
            translateAnimation2.setDuration(620L);
            this.G.setInterpolator(this.V);
        }
        if (this.H == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.H = alphaAnimation;
            alphaAnimation.setDuration(620L);
        }
    }

    private void O9() {
        if (this.W == null) {
            this.W = new AccelerateInterpolator();
        }
        if (this.M == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
            this.M = translateAnimation;
            translateAnimation.setDuration(620);
            this.M.setInterpolator(this.W);
        }
        if (this.N == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.0f);
            this.N = alphaAnimation;
            alphaAnimation.setDuration(620);
        }
        View view = this.f76433i;
        if (view != null && view.getVisibility() == 0 && this.J == null) {
            TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
            this.J = translateAnimation2;
            translateAnimation2.setDuration(620);
            this.J.setInterpolator(this.W);
        }
        if ((this.f76430e != null || this.f76434m != null) && this.K == null) {
            TranslateAnimation translateAnimation3 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 0, -((int) (ba.getScreenHeight(getContext()) * 0.18f)));
            this.K = translateAnimation3;
            translateAnimation3.setDuration(620);
            this.K.setInterpolator(this.W);
        }
        if (this.L == null) {
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.L = alphaAnimation2;
            alphaAnimation2.setDuration(620);
        }
    }

    private void P9() {
        if (this.T == null) {
            this.T = new a();
        }
        if (this.U == null) {
            this.U = new AnimationAnimationListenerC0770b();
        }
        if (this.V == null) {
            this.V = new DecelerateInterpolator();
        }
        if (this.I == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
            this.I = translateAnimation;
            translateAnimation.setDuration(620L);
            this.I.setInterpolator(this.V);
        }
        if (this.D == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.0f);
            this.D = alphaAnimation;
            alphaAnimation.setDuration(500L);
        }
        if (this.E == null) {
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 0.0f);
            this.E = alphaAnimation2;
            alphaAnimation2.setDuration(500L);
        }
    }

    private void destroy() {
        Animation animation = this.F;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.G;
        if (animation2 != null) {
            animation2.cancel();
        }
        Animation animation3 = this.H;
        if (animation3 != null) {
            animation3.cancel();
        }
        Animation animation4 = this.I;
        if (animation4 != null) {
            animation4.cancel();
        }
        Animation animation5 = this.J;
        if (animation5 != null) {
            animation5.cancel();
        }
        Animation animation6 = this.K;
        if (animation6 != null) {
            animation6.cancel();
        }
        Animation animation7 = this.L;
        if (animation7 != null) {
            animation7.cancel();
        }
        Animation animation8 = this.M;
        if (animation8 != null) {
            animation8.cancel();
        }
        Animation animation9 = this.N;
        if (animation9 != null) {
            animation9.cancel();
        }
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.P = null;
        this.R = null;
        this.f76429d = null;
        this.f76433i = null;
        this.f76434m = null;
        this.f76430e = null;
        this.f76431f = null;
        this.f76432h = null;
        this.C = null;
    }

    public void Q9(d dVar) {
        SessionInfo sessionInfo = this.Q.getSessionInfo();
        this.S = dVar;
        if (sessionInfo == null || sessionInfo.F1 || this.f76429d == null) {
            if (dVar != null) {
                dVar.onAnimationStart();
                this.S.onAnimationEnd();
                return;
            }
            return;
        }
        P9();
        this.I.setAnimationListener(this.T);
        this.D.setAnimationListener(this.U);
        this.f76429d.startAnimation(this.D);
        View view = this.f76433i;
        if (view != null) {
            view.startAnimation(this.E);
        }
        View view2 = this.f76434m;
        if (view2 != null) {
            view2.startAnimation(this.E);
        }
        ImageView imageView = this.f76430e;
        if (imageView != null) {
            imageView.startAnimation(this.E);
        }
        TextView textView = this.f76431f;
        if (textView != null) {
            textView.startAnimation(this.E);
        }
        TextView textView2 = this.f76432h;
        if (textView2 != null) {
            textView2.startAnimation(this.E);
        }
        View view3 = this.C;
        if (view3 != null) {
            view3.startAnimation(this.E);
        }
    }

    public void R9(d dVar) {
        this.R = dVar;
        SessionInfo sessionInfo = this.Q.getSessionInfo();
        if (sessionInfo != null && !sessionInfo.G1 && this.f76429d != null) {
            O9();
            Animation animation = this.M;
            if (this.f76429d.getVisibility() != 0) {
                animation = this.N;
            }
            if (this.P == null) {
                this.P = new c();
            }
            animation.setAnimationListener(this.P);
            this.f76429d.startAnimation(animation);
            View view = this.f76433i;
            if (view != null && view.getVisibility() == 0) {
                this.f76433i.startAnimation(this.J);
            }
            View view2 = this.f76434m;
            if (view2 != null && view2.getVisibility() == 0) {
                this.f76434m.startAnimation(this.K);
            }
            ImageView imageView = this.f76430e;
            if (imageView != null && imageView.getVisibility() == 0) {
                this.f76430e.startAnimation(this.K);
            }
            TextView textView = this.f76431f;
            if (textView != null && textView.getVisibility() == 0) {
                this.f76431f.startAnimation(this.L);
            }
            TextView textView2 = this.f76432h;
            if (textView2 != null && textView2.getVisibility() == 0) {
                this.f76432h.startAnimation(this.L);
            }
            View view3 = this.C;
            if (view3 == null || view3.getVisibility() != 0) {
                return;
            }
            this.C.startAnimation(this.L);
            return;
        }
        d dVar2 = this.R;
        if (dVar2 != null) {
            dVar2.onAnimationStart();
            this.R.onAnimationEnd();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        if (view == null) {
            QLog.e("AVInviteAnimationPart", 1, "onInitView rootView is null");
            return;
        }
        this.f76429d = (QavPanel) view.findViewById(R.id.f166587gb4);
        this.f76432h = (TextView) view.findViewById(R.id.a2k);
        if (this.X) {
            this.f76431f = (TextView) view.findViewById(R.id.ksf);
            this.f76430e = (ImageView) view.findViewById(R.id.kse);
        } else {
            this.f76431f = (TextView) view.findViewById(R.id.a2g);
            this.f76430e = (ImageView) view.findViewById(R.id.a2d);
        }
        this.Q = (m) RFWIocAbilityProvider.g().getIocInterface(m.class, getPartRootView(), null);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        destroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (QLog.isColorLevel()) {
                QLog.d("AVInviteAnimationPart", 2, "InAnimation onAnimationEnd");
            }
            try {
                if (b.this.S != null) {
                    b.this.S.onAnimationEnd();
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("AVInviteAnimationPart", 2, "QavInAnimationListener onAnimationEnd Exception :" + e16);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (QLog.isColorLevel()) {
                QLog.d("AVInviteAnimationPart", 2, "InAnimation onAnimationStart");
            }
            try {
                if (b.this.S != null) {
                    b.this.S.onAnimationStart();
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("AVInviteAnimationPart", 2, "QavInAnimationListener onAnimationStart Exception :" + e16);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.av.ui.part.invite.b$b, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class AnimationAnimationListenerC0770b implements Animation.AnimationListener {
        AnimationAnimationListenerC0770b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.N9();
            if (b.this.f76429d != null) {
                b.this.f76429d.clearAnimation();
                b.this.f76429d.startAnimation(b.this.I);
            }
            if (b.this.f76433i != null) {
                b.this.f76433i.clearAnimation();
                if (b.this.f76433i.getVisibility() == 0) {
                    b.this.f76433i.startAnimation(b.this.F);
                }
            }
            if (b.this.f76434m != null) {
                b.this.f76434m.clearAnimation();
                if (b.this.f76434m.getVisibility() == 0) {
                    b.this.f76434m.startAnimation(b.this.G);
                }
            }
            if (b.this.f76430e != null) {
                b.this.f76430e.clearAnimation();
                if (b.this.f76430e.getVisibility() == 0) {
                    b.this.f76430e.startAnimation(b.this.G);
                }
            }
            if (b.this.f76431f != null) {
                b.this.f76431f.clearAnimation();
                if (b.this.f76431f.getVisibility() == 0) {
                    b.this.f76431f.startAnimation(b.this.H);
                }
            }
            if (b.this.f76432h != null) {
                b.this.f76432h.clearAnimation();
                if (b.this.f76432h.getVisibility() == 0) {
                    b.this.f76432h.startAnimation(b.this.H);
                }
            }
            if (b.this.C != null) {
                b.this.C.clearAnimation();
                if (b.this.C.getVisibility() == 0) {
                    b.this.C.startAnimation(b.this.H);
                }
            }
            if (b.this.Q != null) {
                b.this.Q.k();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (QLog.isColorLevel()) {
                QLog.d("AVInviteAnimationPart", 2, "OutAnimation onAnimationEnd");
            }
            try {
                if (b.this.f76429d != null) {
                    b.this.f76429d.setVisibility(4);
                }
                if (b.this.f76433i != null) {
                    b.this.f76433i.setVisibility(4);
                }
                if (b.this.f76434m != null) {
                    b.this.f76434m.setVisibility(4);
                }
                if (b.this.f76430e != null) {
                    b.this.f76430e.setVisibility(4);
                }
                if (b.this.f76431f != null) {
                    b.this.f76431f.setVisibility(4);
                }
                if (b.this.f76432h != null) {
                    b.this.f76432h.setVisibility(4);
                }
                if (b.this.C != null) {
                    b.this.C.setVisibility(4);
                }
                if (b.this.R != null) {
                    b.this.R.onAnimationEnd();
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("AVInviteAnimationPart", 2, "QavOutAnimationListener onAnimationEnd Exception :" + e16);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (QLog.isColorLevel()) {
                QLog.d("AVInviteAnimationPart", 2, "OutAnimation onAnimationStart");
            }
            try {
                if (b.this.R != null) {
                    b.this.R.onAnimationStart();
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("AVInviteAnimationPart", 2, "QavOutAnimationListener onAnimationStart Exception :" + e16);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
