package com.tencent.ams.mosaic.jsengine.animation.frame;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.ProgressAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.hippo.quickjs.android.JSContext;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.jsengine.animation.AnimationBase;
import com.tencent.ams.mosaic.jsengine.animation.layer.Layer;
import com.tencent.ams.mosaic.jsengine.component.Component;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FrameAnimationImpl extends AnimationBase implements FrameAnimation {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    private int f70716m;

    /* renamed from: n, reason: collision with root package name */
    private JSFunction f70717n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements Animator.AnimatorProgressListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Layer f70718d;

        a(Layer layer) {
            this.f70718d = layer;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FrameAnimationImpl.this, (Object) layer);
            }
        }

        @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorProgressListener
        public void onAnimationProgressUpdate(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
                return;
            }
            Layer layer = this.f70718d;
            if (layer != null) {
                layer.getJSEngine().u(FrameAnimationImpl.this.f70717n, new Object[]{Float.valueOf(f16)}, null);
            }
        }

        @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorProgressListener
        public int updateInterval() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            if (FrameAnimationImpl.this.f70716m > 0) {
                return 1000 / FrameAnimationImpl.this.f70716m;
            }
            return 16;
        }
    }

    public FrameAnimationImpl(JSContext jSContext) {
        super(jSContext);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) jSContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(Component component, ValueAnimator valueAnimator) {
        if (component != null) {
            component.getJSEngine().u(this.f70717n, new Object[]{valueAnimator.getAnimatedValue()}, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.animation.AnimationBase
    public void b(Animator animator, Layer layer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) animator, (Object) layer);
            return;
        }
        super.b(animator, layer);
        if (animator != null && this.f70717n != null) {
            f.a("FrameAnimationImpl", "setAnimatorProgressListener");
            animator.setAnimatorProgressListener(new a(layer));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.animation.AnimationBase
    public void d(android.animation.Animator animator, final Component component) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) animator, (Object) component);
            return;
        }
        super.d(animator, component);
        if ((animator instanceof ValueAnimator) && this.f70717n != null) {
            f.a("FrameAnimationImpl", "addUpdateListener");
            ((ValueAnimator) animator).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.ams.mosaic.jsengine.animation.frame.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FrameAnimationImpl.this.j(component, valueAnimator);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.Animation
    public android.animation.Animator getSystemAnimator(@NonNull Component component) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (android.animation.Animator) iPatchRedirector.redirect((short) 3, (Object) this, (Object) component);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        d(ofFloat, component);
        return ofFloat;
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.frame.FrameAnimation
    public void setFrameProgressListener(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) jSFunction);
        } else {
            this.f70717n = jSFunction;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.frame.FrameAnimation
    public void setFrameRate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        if (i3 > 0) {
            this.f70716m = i3;
            return;
        }
        f.h("FrameAnimationImpl", "setFrameRate failed: invalid frameRate - " + i3);
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.Animation
    public Animator getAnimator(@NonNull Layer layer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Animator) iPatchRedirector.redirect((short) 2, (Object) this, (Object) layer);
        }
        AnimatorLayer animatorLayer = layer.getAnimatorLayer();
        if (animatorLayer == null) {
            return null;
        }
        ProgressAnimator progressAnimator = new ProgressAnimator(animatorLayer, 0.0f, 1.0f);
        b(progressAnimator, layer);
        return progressAnimator;
    }
}
