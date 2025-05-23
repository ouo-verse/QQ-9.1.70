package com.tencent.ams.mosaic.jsengine.component.image.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.tencent.ams.animateddrawable.webp.WebPDrawable;
import com.tencent.ams.fusion.widget.apng.APNGDrawable;
import com.tencent.ams.fusion.widget.apng.frame.animation.Animatable2;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.jsengine.component.image.IAnimatableImageComponent;
import com.tencent.ams.mosaic.jsengine.component.image.drawable.a;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c implements IAnimatableImageComponent {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private JSFunction f71170d;

    /* renamed from: e, reason: collision with root package name */
    private JSFunction f71171e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.ams.mosaic.jsengine.a f71172f;

    /* renamed from: h, reason: collision with root package name */
    private Object f71173h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f71174i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a extends Animatable2.AnimationCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // android.graphics.drawable.Animatable2.AnimationCallback
        public void onAnimationEnd(Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                c.this.d(drawable);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable);
            }
        }

        @Override // android.graphics.drawable.Animatable2.AnimationCallback
        public void onAnimationStart(Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                c.this.e(drawable);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements a.InterfaceC0691a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.ams.mosaic.jsengine.component.image.drawable.c$c, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0692c extends Animatable2.AnimationCallback {
        static IPatchRedirector $redirector_;

        C0692c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.ams.fusion.widget.apng.frame.animation.Animatable2.AnimationCallback
        public void onAnimationEnd(Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                c.this.d(drawable);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable);
            }
        }

        @Override // com.tencent.ams.fusion.widget.apng.frame.animation.Animatable2.AnimationCallback
        public void onAnimationStart(Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                c.this.e(drawable);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable);
            }
        }
    }

    public c(com.tencent.ams.mosaic.jsengine.a aVar, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, obj);
            return;
        }
        this.f71174i = false;
        this.f71172f = aVar;
        f(obj);
        c();
    }

    private void c() {
        Object obj = this.f71173h;
        if (obj instanceof android.graphics.drawable.Animatable2) {
            com.tencent.ams.mosaic.utils.f.e("MosaicAnimataleDrawableWrapper", "initAnimationCallback Animatable2 callback");
            ((android.graphics.drawable.Animatable2) obj).registerAnimationCallback(new a());
        } else if (obj instanceof com.tencent.ams.mosaic.jsengine.component.image.drawable.a) {
            ((com.tencent.ams.mosaic.jsengine.component.image.drawable.a) obj).s(new b());
        } else if (MosaicUtils.x() && (obj instanceof com.tencent.ams.fusion.widget.apng.frame.animation.Animatable2)) {
            ((com.tencent.ams.fusion.widget.apng.frame.animation.Animatable2) obj).registerAnimationCallback(new C0692c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Drawable drawable) {
        JSFunction jSFunction;
        com.tencent.ams.mosaic.utils.f.e("MosaicAnimataleDrawableWrapper", "notifyAnimationEnd");
        com.tencent.ams.mosaic.jsengine.a aVar = this.f71172f;
        if (aVar != null && (jSFunction = this.f71171e) != null) {
            aVar.u(jSFunction, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Drawable drawable) {
        JSFunction jSFunction;
        com.tencent.ams.mosaic.utils.f.e("MosaicAnimataleDrawableWrapper", "notifyAnimationStart");
        com.tencent.ams.mosaic.jsengine.a aVar = this.f71172f;
        if (aVar != null && (jSFunction = this.f71170d) != null) {
            aVar.u(jSFunction, null, null);
        }
    }

    public void f(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, obj);
            return;
        }
        if (!(obj instanceof com.tencent.ams.mosaic.jsengine.component.image.drawable.a) && !(obj instanceof Drawable)) {
            if (obj instanceof Bitmap) {
                this.f71173h = new BitmapDrawable((Bitmap) obj);
                return;
            }
            com.tencent.ams.mosaic.utils.f.h("MosaicAnimataleDrawableWrapper", "not support drawable type, drawable: " + obj);
            return;
        }
        this.f71173h = obj;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.IAnimatableImageComponent
    public boolean isAnimatable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        Object obj = this.f71173h;
        if (obj instanceof com.tencent.ams.mosaic.jsengine.component.image.drawable.a) {
            return ((com.tencent.ams.mosaic.jsengine.component.image.drawable.a) obj).isAnimatable();
        }
        if (MosaicUtils.x() && (obj instanceof APNGDrawable)) {
            return true;
        }
        return obj instanceof Animatable;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.IAnimatableImageComponent
    public boolean isRunning() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        Object obj = this.f71173h;
        if (obj instanceof Animatable) {
            z16 = ((Animatable) obj).isRunning();
        } else if (obj instanceof APNGDrawable) {
            z16 = ((APNGDrawable) obj).isRunning();
        } else {
            z16 = false;
        }
        com.tencent.ams.mosaic.utils.f.e("MosaicAnimataleDrawableWrapper", "isRunning");
        return z16;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.IAnimatableImageComponent
    public void setAnimationCallback(JSFunction jSFunction, JSFunction jSFunction2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSFunction, (Object) jSFunction2);
        } else {
            this.f71170d = jSFunction;
            this.f71171e = jSFunction2;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.IAnimatableImageComponent
    public void setAutoPlay(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("MosaicAnimataleDrawableWrapper", "setAutoPlay, autoPlay: " + z16);
        try {
            Object obj = this.f71173h;
            if (obj instanceof com.tencent.ams.mosaic.jsengine.component.image.drawable.a) {
                ((com.tencent.ams.mosaic.jsengine.component.image.drawable.a) obj).setAutoPlay(z16);
            } else if (MosaicUtils.w() && (obj instanceof WebPDrawable)) {
                ((WebPDrawable) obj).setAutoPlay(z16);
            } else if (obj instanceof Animatable) {
                if (z16 && !((Animatable) obj).isRunning()) {
                    ((Animatable) obj).start();
                } else if (!z16 && ((Animatable) obj).isRunning() && !this.f71174i) {
                    ((Animatable) obj).stop();
                }
            } else if (obj instanceof APNGDrawable) {
                ((APNGDrawable) obj).setAutoPlay(z16);
            }
        } catch (Throwable th5) {
            com.tencent.ams.mosaic.utils.f.c("MosaicAnimataleDrawableWrapper", "setAutoPlay failure.", th5);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.IAnimatableImageComponent
    public void setRepeatCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("MosaicAnimataleDrawableWrapper", "setRepeatCount, repeatCount: " + i3);
        if (i3 < -1) {
            com.tencent.ams.mosaic.utils.f.h("MosaicAnimataleDrawableWrapper", "invalid repeatCount.");
            return;
        }
        try {
            Object obj = this.f71173h;
            if (obj instanceof com.tencent.ams.mosaic.jsengine.component.image.drawable.a) {
                ((com.tencent.ams.mosaic.jsengine.component.image.drawable.a) obj).setRepeatCount(i3);
            } else if (MosaicUtils.w() && (obj instanceof WebPDrawable)) {
                ((WebPDrawable) obj).getFrameSeqDecoder().setLoopLimit(i3);
            } else if (Build.VERSION.SDK_INT >= 28 && (obj instanceof AnimatedImageDrawable)) {
                ((AnimatedImageDrawable) obj).setRepeatCount(i3);
            } else if (obj instanceof APNGDrawable) {
                ((APNGDrawable) obj).setLoopLimit(i3);
            } else {
                com.tencent.ams.mosaic.utils.f.h("MosaicAnimataleDrawableWrapper", "not support drawable set repeatCount, drawable: " + obj);
            }
        } catch (Throwable th5) {
            com.tencent.ams.mosaic.utils.f.c("MosaicAnimataleDrawableWrapper", "setRepeatCount failure.", th5);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.IAnimatableImageComponent
    public boolean start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        com.tencent.ams.mosaic.utils.f.e("MosaicAnimataleDrawableWrapper", "start");
        Object obj = this.f71173h;
        if (obj instanceof Animatable) {
            this.f71174i = true;
            Animatable animatable = (Animatable) obj;
            if (animatable.isRunning()) {
                com.tencent.ams.mosaic.utils.f.e("MosaicAnimataleDrawableWrapper", "start failure, is running.");
                return false;
            }
            animatable.start();
            return true;
        }
        if (obj instanceof APNGDrawable) {
            this.f71174i = true;
            APNGDrawable aPNGDrawable = (APNGDrawable) obj;
            if (aPNGDrawable.isRunning()) {
                com.tencent.ams.mosaic.utils.f.h("MosaicAnimataleDrawableWrapper", "apng image stop failure, is running.");
                return false;
            }
            aPNGDrawable.start();
            return true;
        }
        com.tencent.ams.mosaic.utils.f.e("MosaicAnimataleDrawableWrapper", "start failure, is not animatable drawable.");
        return false;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.IAnimatableImageComponent
    public boolean stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        com.tencent.ams.mosaic.utils.f.e("MosaicAnimataleDrawableWrapper", "stop");
        Object obj = this.f71173h;
        if (obj instanceof Animatable) {
            this.f71174i = false;
            Animatable animatable = (Animatable) obj;
            if (!animatable.isRunning()) {
                com.tencent.ams.mosaic.utils.f.h("MosaicAnimataleDrawableWrapper", "animatable image stop failure, is not start.");
                return false;
            }
            animatable.stop();
            return true;
        }
        if (obj instanceof APNGDrawable) {
            this.f71174i = false;
            APNGDrawable aPNGDrawable = (APNGDrawable) obj;
            if (!aPNGDrawable.isRunning()) {
                com.tencent.ams.mosaic.utils.f.h("MosaicAnimataleDrawableWrapper", "apng image stop failure, is not start.");
                return false;
            }
            aPNGDrawable.stop();
            return true;
        }
        com.tencent.ams.mosaic.utils.f.e("MosaicAnimataleDrawableWrapper", "stop failure, is not animatable drawable.");
        return false;
    }
}
