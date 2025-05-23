package com.tencent.ams.mosaic.jsengine.animation.group;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.animatorview.animator.GroupAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.SequentialAnimator;
import com.tencent.ams.hippo.quickjs.android.JSContext;
import com.tencent.ams.mosaic.jsengine.animation.Animation;
import com.tencent.ams.mosaic.jsengine.animation.AnimationBase;
import com.tencent.ams.mosaic.jsengine.animation.group.GroupAnimation;
import com.tencent.ams.mosaic.jsengine.animation.layer.Layer;
import com.tencent.ams.mosaic.jsengine.component.Component;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GroupAnimationImpl extends AnimationBase implements GroupAnimation {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    private final List<Animation> f70722m;

    /* renamed from: n, reason: collision with root package name */
    @GroupAnimation.PlayBackOrder
    private String f70723n;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f70724d;

        /* renamed from: e, reason: collision with root package name */
        private int f70725e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f70726f;

        /* renamed from: h, reason: collision with root package name */
        private long f70727h;

        a(boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            this.f70726f = false;
            this.f70724d = z16;
            this.f70725e = i3;
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                f.a("GroupAnimationImpl", "animation listener cancel");
                this.f70726f = true;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
            } else {
                this.f70726f = true;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                return;
            }
            if (System.currentTimeMillis() - this.f70727h < 10) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!this.f70726f) {
                int i3 = this.f70725e - 1;
                this.f70725e = i3;
                if ((i3 > 0 || this.f70724d) && !z16) {
                    try {
                        animator.start();
                    } catch (Throwable th5) {
                        f.i("GroupAnimationImpl", "repeat animation failed", th5);
                    }
                    this.f70727h = System.currentTimeMillis();
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                this.f70726f = false;
            }
        }
    }

    public GroupAnimationImpl(JSContext jSContext) {
        super(jSContext);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) jSContext);
        } else {
            this.f70722m = new ArrayList();
            this.f70723n = GroupAnimation.PlayBackOrder.SERIAL;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.group.GroupAnimation
    public void addAnimation(Animation animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            return;
        }
        f.a("GroupAnimationImpl", "addAnimation: " + animation);
        if (animation == null) {
            return;
        }
        this.f70722m.add(animation);
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.AnimationBase
    protected void e(Animator animator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) animator);
        } else if (!GroupAnimation.PlayBackOrder.SERIAL.equals(this.f70723n)) {
            super.e(animator);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.ams.fusion.widget.animatorview.animator.GroupAnimator] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, com.tencent.ams.fusion.widget.animatorview.animator.Animator] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.tencent.ams.fusion.widget.animatorview.animator.SequentialAnimator] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.tencent.ams.mosaic.jsengine.animation.group.GroupAnimationImpl, com.tencent.ams.mosaic.jsengine.animation.AnimationBase, java.lang.Object] */
    @Override // com.tencent.ams.mosaic.jsengine.animation.Animation
    public Object getAnimator(@NonNull Layer layer) {
        ?? groupAnimator;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this, (Object) layer);
        }
        if (GroupAnimation.PlayBackOrder.SERIAL.equals(this.f70723n)) {
            groupAnimator = new SequentialAnimator(layer.getAnimatorLayer());
            Iterator<Animation> it = this.f70722m.iterator();
            while (it.hasNext()) {
                groupAnimator.addAnimator((com.tencent.ams.fusion.widget.animatorview.animator.Animator) it.next().getAnimator(layer));
            }
        } else {
            groupAnimator = new GroupAnimator(layer.getAnimatorLayer(), new com.tencent.ams.fusion.widget.animatorview.animator.Animator[0]);
            Iterator<Animation> it5 = this.f70722m.iterator();
            while (it5.hasNext()) {
                groupAnimator.addAnimators((com.tencent.ams.fusion.widget.animatorview.animator.Animator) it5.next().getAnimator(layer));
            }
        }
        b(groupAnimator, layer);
        return groupAnimator;
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.Animation
    public Animator getSystemAnimator(@NonNull Component component) {
        Animator systemAnimator;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Animator) iPatchRedirector.redirect((short) 6, (Object) this, (Object) component);
        }
        ArrayList arrayList = new ArrayList();
        for (Animation animation : this.f70722m) {
            if (animation != null && (systemAnimator = animation.getSystemAnimator(component)) != null) {
                arrayList.add(systemAnimator);
            }
        }
        if (arrayList.isEmpty()) {
            f.h("GroupAnimationImpl", "getSystemAnimator failed: empty animator list");
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        if (GroupAnimation.PlayBackOrder.SERIAL.equals(this.f70723n)) {
            animatorSet.playSequentially(arrayList);
        } else {
            animatorSet.playTogether(arrayList);
        }
        int i3 = this.f70695j;
        if (i3 <= 0) {
            animatorSet.addListener(new a(true, this.f70695j));
        } else if (i3 > 1) {
            animatorSet.addListener(new a(false, this.f70695j));
        }
        d(animatorSet, component);
        return animatorSet;
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.group.GroupAnimation
    public void setAnimGroup(Animation[] animationArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) animationArr);
        } else if (animationArr != null && animationArr.length != 0) {
            this.f70722m.clear();
            this.f70722m.addAll(Arrays.asList(animationArr));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.group.GroupAnimation
    public void setPlayBackOrder(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.f70723n = str;
        }
    }
}
