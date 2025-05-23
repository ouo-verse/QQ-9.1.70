package com.tencent.qqnt.doutu.combo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.doutu.combo.ComboResource;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes24.dex */
public class ComboMasterView extends LinearLayout implements Animator.AnimatorListener {
    static IPatchRedirector $redirector_;
    private ImageView C;
    private int D;
    boolean E;
    ComboResource.a F;

    /* renamed from: d, reason: collision with root package name */
    private b f356051d;

    /* renamed from: e, reason: collision with root package name */
    com.tencent.qqnt.doutu.combo.a f356052e;

    /* renamed from: f, reason: collision with root package name */
    AnimatorSet f356053f;

    /* renamed from: h, reason: collision with root package name */
    boolean f356054h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f356055i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f356056m;

    /* compiled from: P */
    /* loaded from: classes24.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PathMeasure f356057d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float[] f356058e;

        a(PathMeasure pathMeasure, float[] fArr) {
            this.f356057d = pathMeasure;
            this.f356058e = fArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ComboMasterView.this, pathMeasure, fArr);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            this.f356057d.getPosTan(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.f356058e, null);
            ComboMasterView.this.setTranslationX(this.f356058e[0]);
            ComboMasterView.this.setTranslationY(this.f356058e[1]);
        }
    }

    public ComboMasterView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f356054h = false;
        this.D = 0;
        this.E = true;
    }

    private Drawable c(View view, ComboResource.a aVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = aVar.f356077a;
        layoutParams.height = aVar.f356078b;
        return aVar.f356079c;
    }

    private PathMeasure d() {
        float f16;
        int i3 = getContext().getResources().getDisplayMetrics().widthPixels;
        int i16 = getContext().getResources().getDisplayMetrics().heightPixels;
        try {
            f16 = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
            if (QLog.isColorLevel()) {
                QLog.d("ComboMasterView", 2, "get status_bar_height " + f16);
            }
        } catch (Exception unused) {
            f16 = (int) ((getContext().getResources().getDisplayMetrics().density * 25.0f) + 0.5d);
        }
        float n3 = f16 + Utils.n(54.0f, getContext().getResources()) + getContext().getResources().getDimension(R.dimen.title_bar_height);
        float n16 = i3 - Utils.n(40.0f, getContext().getResources());
        float f17 = i3 / 2.0f;
        float f18 = i16 / 2.0f;
        float f19 = n16 - f17;
        float f26 = n3 - f18;
        float f27 = (((f19 - 0.0f) * 1.0f) / 14.0f) + 0.0f;
        float f28 = (((0.0f - f26) * 1.0f) / 13.0f) + f26;
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f27, f28, f19, f26);
        if (QLog.isColorLevel()) {
            QLog.d("ComboMasterView", 2, "mCount " + this.D + " startX: " + f17 + " startY:" + f18 + " toX:" + n16 + " toY: " + n3 + " middleX:" + f27 + " middleY: " + f28);
        }
        return new PathMeasure(path, false);
    }

    private boolean f(int i3) {
        ComboResource.a c16 = ComboResource.c(i3, getContext());
        if (c16 == null) {
            this.E = false;
            return false;
        }
        this.F = c16;
        return true;
    }

    private boolean h(ImageView imageView, int i3) {
        ComboResource.a b16 = ComboResource.b(i3, getContext());
        if (b16 == null) {
            this.E = false;
            return false;
        }
        imageView.setImageDrawable(c(imageView, b16));
        return true;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        setBackgroundDrawable(c(this, this.F));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.1f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.1f);
        ofFloat.setDuration(200L);
        ofFloat2.setDuration(200L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, BasicAnimation.KeyPath.SCALE_X, 1.1f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this, BasicAnimation.KeyPath.SCALE_Y, 1.1f, 1.0f);
        ofFloat3.setDuration(200L);
        ofFloat4.setDuration(200L);
        PathMeasure d16 = d();
        ValueAnimator ofFloat5 = ValueAnimator.ofFloat(0.0f, d16.getLength());
        ofFloat5.addUpdateListener(new a(d16, new float[2]));
        ofFloat5.setDuration(400L);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this, c.f123400v, 1.0f, 0.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.27f);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.27f);
        ofFloat6.setDuration(400L);
        ofFloat7.setDuration(400L);
        ofFloat8.setDuration(400L);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f356053f = animatorSet;
        animatorSet.play(ofFloat).with(ofFloat2).before(ofFloat3);
        this.f356053f.play(ofFloat3).with(ofFloat4);
        ofFloat5.setStartDelay(600L);
        ofFloat6.setStartDelay(600L);
        ofFloat7.setStartDelay(600L);
        ofFloat8.setStartDelay(600L);
        this.f356053f.play(ofFloat5);
        this.f356053f.play(ofFloat6);
        this.f356053f.play(ofFloat7);
        this.f356053f.play(ofFloat8);
        this.f356053f.addListener(this);
        this.f356053f.start();
    }

    public void b(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) viewGroup);
        } else if (viewGroup != null) {
            viewGroup.removeView(this);
            this.f356054h = true;
            this.f356053f.cancel();
        }
    }

    public void e(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
            return;
        }
        this.f356055i = (ImageView) findViewById(R.id.f164106js);
        this.f356056m = (ImageView) findViewById(R.id.f164107jt);
        this.C = (ImageView) findViewById(R.id.f164108ju);
        this.f356051d = bVar;
    }

    public boolean g(com.tencent.qqnt.doutu.combo.a aVar) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar)).booleanValue();
        }
        this.f356052e = aVar;
        int i17 = aVar.f356081b;
        int i18 = i17 % 10;
        int i19 = i17 / 10;
        if (i19 != 0) {
            i3 = i19 % 10;
            i19 /= 10;
        } else {
            i3 = 0;
        }
        if (i19 != 0) {
            i16 = i19 % 100;
        } else {
            i16 = 0;
        }
        this.C.setVisibility(0);
        h(this.C, i18);
        if (i16 == 0) {
            if (i3 == 0) {
                this.f356056m.setVisibility(8);
                this.f356055i.setVisibility(8);
                f(1);
            } else {
                this.f356056m.setVisibility(0);
                this.f356055i.setVisibility(8);
                h(this.f356056m, i3);
                f(2);
            }
        } else {
            this.f356056m.setVisibility(0);
            this.f356055i.setVisibility(0);
            h(this.f356056m, i3);
            h(this.f356055i, i16);
            f(3);
        }
        setPadding(Utils.n(162.0f / ComboResource.f356070e, getContext().getResources()), 0, 0, 0);
        ((LinearLayout.LayoutParams) this.f356055i.getLayoutParams()).setMargins(0, 0, 0 - Utils.n(20.0f / ComboResource.f356070e, getContext().getResources()), 0);
        ((LinearLayout.LayoutParams) this.f356056m.getLayoutParams()).setMargins(0, 0, 0 - Utils.n(20.0f / ComboResource.f356070e, getContext().getResources()), 0);
        this.D = i17;
        return this.E;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) animator);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            onAnimationEnd(animator);
        } else {
            iPatchRedirector.redirect((short) 8, this, animator, Boolean.valueOf(z16));
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) animator);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) animator);
            return;
        }
        b bVar = this.f356051d;
        if (bVar == null || this.f356053f == null) {
            return;
        }
        if (!this.f356054h) {
            bVar.g(animator, this);
        }
        animator.removeAllListeners();
        this.f356051d = null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            onAnimationStart(animator);
        } else {
            iPatchRedirector.redirect((short) 7, this, animator, Boolean.valueOf(z16));
        }
    }

    public ComboMasterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f356054h = false;
        this.D = 0;
        this.E = true;
    }
}
