package com.tencent.ams.mosaic.jsengine.animation;

import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.text.TextUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.hippo.quickjs.android.JSContext;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.jsengine.animation.Animation;
import com.tencent.ams.mosaic.jsengine.animation.layer.Layer;
import com.tencent.ams.mosaic.jsengine.component.Component;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class AnimationBase implements Animation {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected JSContext f70686a;

    /* renamed from: b, reason: collision with root package name */
    protected String f70687b;

    /* renamed from: c, reason: collision with root package name */
    protected float f70688c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f70689d;

    /* renamed from: e, reason: collision with root package name */
    protected JSFunction f70690e;

    /* renamed from: f, reason: collision with root package name */
    protected JSFunction f70691f;

    /* renamed from: g, reason: collision with root package name */
    protected String f70692g;

    /* renamed from: h, reason: collision with root package name */
    protected float[] f70693h;

    /* renamed from: i, reason: collision with root package name */
    protected float f70694i;

    /* renamed from: j, reason: collision with root package name */
    protected int f70695j;

    /* renamed from: k, reason: collision with root package name */
    protected float f70696k;

    /* renamed from: l, reason: collision with root package name */
    protected String f70697l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Layer f70698d;

        a(Layer layer) {
            this.f70698d = layer;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnimationBase.this, (Object) layer);
            }
        }

        @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
        public void onAnimationFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Layer layer = this.f70698d;
            if (layer != null) {
                layer.getJSEngine().u(AnimationBase.this.f70691f, new Object[0], null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Component f70700d;

        b(Component component) {
            this.f70700d = component;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnimationBase.this, (Object) component);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                this.f70700d.getJSEngine().u(AnimationBase.this.f70691f, new Object[0], null);
            }
        }
    }

    public AnimationBase(JSContext jSContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) jSContext);
        } else {
            this.f70695j = 1;
            this.f70686a = jSContext;
        }
    }

    private void c(@NonNull Animator animator) {
        TimeInterpolator a16 = a();
        if (a16 != null) {
            animator.setInterpolator(a16);
        }
    }

    protected TimeInterpolator a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (TimeInterpolator) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        if (TextUtils.isEmpty(this.f70692g)) {
            return null;
        }
        String str = this.f70692g;
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -2018804923:
                if (str.equals(Animation.TimingFunctionName.LINEAR)) {
                    c16 = 0;
                    break;
                }
                break;
            case -300434336:
                if (str.equals(Animation.TimingFunctionName.EASE_OUT)) {
                    c16 = 1;
                    break;
                }
                break;
            case 1337131821:
                if (str.equals(Animation.TimingFunctionName.EASE_IN_EASE_OUT)) {
                    c16 = 2;
                    break;
                }
                break;
            case 1618111428:
                if (str.equals(Animation.TimingFunctionName.BEZIER_PATH)) {
                    c16 = 3;
                    break;
                }
                break;
            case 2068518355:
                if (str.equals(Animation.TimingFunctionName.EASE_IN)) {
                    c16 = 4;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return new LinearInterpolator();
            case 1:
                return new DecelerateInterpolator();
            case 2:
                return new AccelerateDecelerateInterpolator();
            case 3:
                float[] fArr = this.f70693h;
                if (fArr != null && fArr.length == 4) {
                    float[] fArr2 = this.f70693h;
                    return new PathInterpolator(fArr2[0], fArr2[1], fArr2[2], fArr2[3]);
                }
                f.h("AnimationBase", "set bezier path animator interpolator failed: invalid timing controllers");
                return null;
            case 4:
                return new AccelerateInterpolator();
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Animator animator, Layer layer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) animator, (Object) layer);
            return;
        }
        if (animator != null) {
            animator.setStartDelay(this.f70694i * 1000.0f);
            animator.setDuration(this.f70688c * 1000.0f);
            int i3 = this.f70695j;
            if (i3 <= 0) {
                animator.setRepeatCount(0);
            } else {
                animator.setRepeatCount(i3);
            }
            c(animator);
            if (this.f70691f != null) {
                animator.setAnimatorListener(new a(layer));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(android.animation.Animator animator, Component component) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) animator, (Object) component);
            return;
        }
        if (animator != null) {
            animator.setStartDelay(this.f70694i * 1000.0f);
            e(animator);
            if (animator instanceof ObjectAnimator) {
                f((ObjectAnimator) animator);
            }
            TimeInterpolator a16 = a();
            if (a16 != null) {
                animator.setInterpolator(a16);
            }
            if (this.f70691f != null) {
                animator.addListener(new b(component));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(android.animation.Animator animator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) animator);
        } else if (animator != null) {
            animator.setDuration(this.f70688c * 1000.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(ObjectAnimator objectAnimator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) objectAnimator);
            return;
        }
        if (objectAnimator != null) {
            int i3 = this.f70695j;
            if (i3 <= 0) {
                objectAnimator.setRepeatCount(-1);
            } else {
                objectAnimator.setRepeatCount(i3 - 1);
            }
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.Animation
    public String getAnimID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f70687b;
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.Animation
    public void onAnimationStart(Layer layer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) layer);
        } else if (this.f70690e != null && layer != null) {
            layer.getJSEngine().u(this.f70690e, new Object[0], null);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.Animation
    public void setAnimID(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        f.a("AnimationBase", "setAnimID: " + str);
        this.f70687b = str;
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.Animation
    public void setAnimStartListener(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) jSFunction);
        } else {
            this.f70690e = jSFunction;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.Animation
    public void setAnimStopListener(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) jSFunction);
        } else {
            this.f70691f = jSFunction;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.Animation
    public void setAutoReverses(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.f70689d = z16;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.Animation
    public void setBeginTime(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
        } else {
            this.f70694i = f16;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.Animation
    public void setDuration(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
        } else {
            this.f70688c = f16;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.Animation
    public void setFillMode(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        } else {
            this.f70697l = str;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.Animation
    public void setRepeatCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.f70695j = i3;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.Animation
    public void setRepeatDuration(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
        } else {
            this.f70696k = f16;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.Animation
    public void setTimingFunction(String str, float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) fArr);
        } else {
            this.f70692g = str;
            this.f70693h = fArr;
        }
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return getClass().getName() + "@" + this.f70687b;
    }
}
