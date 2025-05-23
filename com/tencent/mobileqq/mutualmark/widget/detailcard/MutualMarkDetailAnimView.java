package com.tencent.mobileqq.mutualmark.widget.detailcard;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.mutualmark.model.MutualMarkModel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MutualMarkDetailAnimView extends RelativeLayout {
    static IPatchRedirector $redirector_;
    private final ImageView C;
    private final RelativeLayout D;
    private final TextView E;
    private final TextView F;
    private final TextView G;
    private final h H;
    private final com.tencent.mobileqq.mutualmark.widget.detailcard.b I;
    private int J;
    private int K;
    private int L;
    protected int M;
    private int N;
    private int P;
    private int Q;
    protected int R;
    private int S;
    private i T;

    /* renamed from: d, reason: collision with root package name */
    private final Context f252324d;

    /* renamed from: e, reason: collision with root package name */
    public final View f252325e;

    /* renamed from: f, reason: collision with root package name */
    private final RelativeLayout f252326f;

    /* renamed from: h, reason: collision with root package name */
    private final RelativeLayout f252327h;

    /* renamed from: i, reason: collision with root package name */
    private final RelativeLayout f252328i;

    /* renamed from: m, reason: collision with root package name */
    private final ImageView f252329m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a extends TranslateAnimation {
        static IPatchRedirector $redirector_;

        a(float f16, float f17, float f18, float f19) {
            super(f16, f17, f18, f19);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MutualMarkDetailAnimView.this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            }
        }

        @Override // android.view.animation.TranslateAnimation, android.view.animation.Animation
        protected void applyTransformation(float f16, Transformation transformation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), transformation);
                return;
            }
            super.applyTransformation(f16, transformation);
            MutualMarkDetailAnimView mutualMarkDetailAnimView = MutualMarkDetailAnimView.this;
            if (mutualMarkDetailAnimView.S != 1) {
                f16 = 1.0f - f16;
            }
            mutualMarkDetailAnimView.f(f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f252331d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewGroup f252332e;

        b(c cVar, ViewGroup viewGroup) {
            this.f252331d = cVar;
            this.f252332e = viewGroup;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MutualMarkDetailAnimView.this, cVar, viewGroup);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            c cVar = this.f252331d;
            if (cVar != null) {
                cVar.onFinish();
            }
            if (MutualMarkDetailAnimView.this.S == 2) {
                this.f252332e.removeView(MutualMarkDetailAnimView.this.f252325e);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface c {
        void onFinish();
    }

    public MutualMarkDetailAnimView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void c(float f16) {
        if (f16 > 0.75f) {
            float f17 = (f16 - 0.75f) / 0.25f;
            this.D.setAlpha(f17);
            this.F.setAlpha(f17);
            this.G.setAlpha(f17);
            this.H.p(f17);
        } else {
            this.D.setAlpha(0.0f);
            this.F.setAlpha(0.0f);
            this.G.setAlpha(0.0f);
            this.H.p(0.0f);
        }
        if (f16 > 0.95f) {
            this.I.f252368a.setAlpha((f16 - 0.95f) / 0.050000012f);
        } else {
            this.I.f252368a.setAlpha(0.0f);
        }
    }

    private static int e(Context context) {
        if (!(context instanceof Activity)) {
            return 0;
        }
        return ((Activity) context).getWindow().getDecorView().getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(float f16) {
        h(f16);
        i(f16);
        c(f16);
    }

    private void g(ViewGroup viewGroup, c cVar) {
        int i3;
        a aVar = new a(0.0f, this.N - this.J, 0.0f, this.P - this.K);
        aVar.setAnimationListener(new b(cVar, viewGroup));
        aVar.setFillAfter(true);
        if (this.S == 1) {
            i3 = R.anim.f154977uk;
        } else {
            i3 = R.anim.f154974uh;
        }
        he0.b.m(aVar, i3, 2.0f);
        this.f252325e.startAnimation(aVar);
    }

    private void h(float f16) {
        Resources resources = this.f252324d.getResources();
        int i3 = this.L;
        if (i3 <= 0) {
            i3 = resources.getDimensionPixelSize(R.dimen.d7w);
        }
        if (this.S == 2) {
            i3 = resources.getDimensionPixelSize(R.dimen.d7w);
        }
        float dimensionPixelSize = i3 + ((resources.getDimensionPixelSize(R.dimen.d7n) - i3) * f16);
        int i16 = this.M;
        if (i16 <= 0) {
            i16 = resources.getDimensionPixelSize(R.dimen.d7v);
        }
        if (this.S == 2) {
            i16 = resources.getDimensionPixelSize(R.dimen.d7v);
        }
        float dimensionPixelSize2 = i16 + ((resources.getDimensionPixelSize(R.dimen.d7l) - i16) * f16);
        ViewGroup.LayoutParams layoutParams = this.f252326f.getLayoutParams();
        layoutParams.width = (int) dimensionPixelSize;
        layoutParams.height = (int) dimensionPixelSize2;
        this.f252326f.setLayoutParams(layoutParams);
    }

    private void i(float f16) {
        Resources resources = this.f252324d.getResources();
        float dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.d7o) + ((resources.getDimensionPixelSize(R.dimen.d7f) - r1) * f16);
        float dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.d7s) + ((resources.getDimensionPixelSize(R.dimen.d7j) - r1) * f16);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f252327h.getLayoutParams();
        int i3 = (int) dimensionPixelSize;
        layoutParams.width = i3;
        layoutParams.height = i3;
        layoutParams.topMargin = (int) dimensionPixelSize2;
        this.f252327h.setLayoutParams(layoutParams);
        float dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.d7t) + ((resources.getDimensionPixelSize(R.dimen.d7k) - r1) * f16);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f252328i.getLayoutParams();
        int i16 = (int) dimensionPixelSize3;
        layoutParams2.width = i16;
        layoutParams2.height = i16;
        this.f252328i.setLayoutParams(layoutParams2);
        float dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.d7p) + ((resources.getDimensionPixelSize(R.dimen.d7g) - r1) * f16);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f252329m.getLayoutParams();
        int i17 = (int) dimensionPixelSize4;
        layoutParams3.width = i17;
        layoutParams3.height = i17;
        this.f252329m.setLayoutParams(layoutParams3);
        float dimensionPixelSize5 = resources.getDimensionPixelSize(R.dimen.d7r) + ((resources.getDimensionPixelSize(R.dimen.d7i) - r1) * f16);
        float dimensionPixelSize6 = resources.getDimensionPixelSize(R.dimen.d7q) + ((resources.getDimensionPixelSize(R.dimen.d7h) - r1) * f16);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
        layoutParams4.width = (int) dimensionPixelSize5;
        layoutParams4.height = (int) dimensionPixelSize6;
        this.C.setLayoutParams(layoutParams4);
    }

    public void d(ViewGroup viewGroup, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) viewGroup, (Object) cVar);
            return;
        }
        f(0.0f);
        Resources resources = this.f252324d.getResources();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(resources.getDimensionPixelSize(R.dimen.d7n), resources.getDimensionPixelSize(R.dimen.d7m));
        layoutParams.leftMargin = this.J;
        layoutParams.topMargin = this.K;
        viewGroup.addView(this.f252325e, layoutParams);
        long j3 = resources.getDisplayMetrics().widthPixels;
        int e16 = e(this.f252324d);
        if (e16 == 0) {
            e16 = this.f252324d.getResources().getDisplayMetrics().heightPixels;
        }
        long j16 = e16;
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.d7n) + resources.getDimensionPixelSize(R.dimen.f158713n2);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.d7m);
        this.N = (int) (((float) ((j3 - dimensionPixelSize) / 2)) + 27.0f);
        this.P = ((int) (j16 - dimensionPixelSize2)) / 2;
        g(viewGroup, cVar);
    }

    public void j(ViewGroup viewGroup, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) viewGroup, (Object) cVar);
            return;
        }
        f(1.0f);
        Resources resources = this.f252324d.getResources();
        long j3 = resources.getDisplayMetrics().widthPixels;
        int e16 = e(this.f252324d);
        if (e16 == 0) {
            e16 = this.f252324d.getResources().getDisplayMetrics().heightPixels;
        }
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.d7n) + resources.getDimensionPixelSize(R.dimen.f158713n2);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.d7m);
        this.J = (int) (((float) ((j3 - dimensionPixelSize) / 2)) + 27.0f);
        this.K = ((int) (e16 - dimensionPixelSize2)) / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(resources.getDimensionPixelSize(R.dimen.d7n), resources.getDimensionPixelSize(R.dimen.d7m));
        layoutParams.leftMargin = this.J;
        layoutParams.topMargin = this.K;
        viewGroup.addView(this.f252325e, layoutParams);
        g(viewGroup, cVar);
    }

    public void setCardSelectedLevel(int i3, MutualMarkModel mutualMarkModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) mutualMarkModel);
        } else {
            if (i3 == -1) {
                return;
            }
            this.E.setText(mutualMarkModel.Y.get(i3).f252169e);
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).setDescProgressThresholdTextView(this.F, mutualMarkModel, i3);
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).setProgressIconWithModel(this.f252329m, mutualMarkModel, i3, null);
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void setData(MutualMarkModel mutualMarkModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) mutualMarkModel);
            return;
        }
        i iVar = this.T;
        if (iVar != null) {
            iVar.q(new MutualMarkModel(mutualMarkModel));
        }
    }

    public void setDestParams(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.N = i3;
        this.P = i16;
        this.Q = i17;
        this.R = i18;
    }

    public void setMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.S = i3;
        }
    }

    public void setOriginParams(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.J = i3;
        this.K = i16;
        this.L = i17;
        this.M = i18;
    }

    public MutualMarkDetailAnimView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public MutualMarkDetailAnimView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 1;
        this.f252324d = context;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f168825gz2, (ViewGroup) null);
        this.f252325e = inflate;
        this.f252326f = (RelativeLayout) inflate.findViewById(R.id.zku);
        this.f252327h = (RelativeLayout) inflate.findViewById(R.id.zkz);
        this.f252328i = (RelativeLayout) inflate.findViewById(R.id.zkw);
        this.f252329m = (ImageView) inflate.findViewById(R.id.zkv);
        this.C = (ImageView) inflate.findViewById(R.id.zl_);
        this.D = (RelativeLayout) inflate.findViewById(R.id.zky);
        this.E = (TextView) inflate.findViewById(R.id.zl7);
        this.F = (TextView) inflate.findViewById(R.id.zla);
        this.G = (TextView) inflate.findViewById(R.id.f166368zl2);
        this.H = new h((LinearLayout) inflate.findViewById(R.id.zl8));
        this.I = new com.tencent.mobileqq.mutualmark.widget.detailcard.b(inflate.findViewById(R.id.zkq));
        this.T = new i(context, inflate);
    }
}
