package com.tencent.ams.mosaic.jsengine.component.image;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.f;
import com.tencent.ams.mosaic.jsengine.animation.Animation;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimationImpl;
import com.tencent.ams.mosaic.jsengine.component.BasicComponent;
import com.tencent.ams.mosaic.jsengine.component.image.c;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ImageComponentImpl extends BasicComponent implements ImageComponent {
    static IPatchRedirector $redirector_;
    private JSFunction C;
    private JSFunction D;
    private JSFunction E;
    private com.tencent.ams.mosaic.jsengine.component.image.drawable.c F;
    private boolean G;

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.ams.mosaic.jsengine.component.image.c f71153d;

    /* renamed from: e, reason: collision with root package name */
    private float f71154e;

    /* renamed from: f, reason: collision with root package name */
    private String f71155f;

    /* renamed from: h, reason: collision with root package name */
    private int f71156h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f71157i;

    /* renamed from: m, reason: collision with root package name */
    private JSFunction f71158m;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements c.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f71159a;

        a(String str) {
            this.f71159a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ImageComponentImpl.this, (Object) str);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.component.image.c.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                ImageComponentImpl.this.getJSEngine().n("imageComponentOnFirstDrawWithContent", new Object[]{this.f71159a}, null);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.component.image.c.a
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ImageComponentImpl.this.getJSEngine().g().b(new com.tencent.ams.mosaic.g("imageComponentOnFirstDraw", this.f71159a));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b implements f.c.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f71161a;

        b(String str) {
            this.f71161a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ImageComponentImpl.this, (Object) str);
            }
        }

        @Override // com.tencent.ams.mosaic.f.c.a
        public void onLoadFinish(Object obj) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, obj);
                return;
            }
            if (!TextUtils.equals(this.f71161a, ImageComponentImpl.this.f71155f)) {
                return;
            }
            String str = "onLoadFinish: " + this.f71161a + ", width:" + ImageComponentImpl.this.getWidth() + ", height:" + ImageComponentImpl.this.getHeight() + ", object: " + obj;
            if (com.tencent.ams.mosaic.f.k().y()) {
                com.tencent.ams.mosaic.utils.f.a("ImageComponentImpl", str);
            } else {
                com.tencent.ams.mosaic.utils.f.e("ImageComponentImpl", str);
            }
            com.tencent.ams.mosaic.jsengine.a jSEngine = ImageComponentImpl.this.getJSEngine();
            if (obj instanceof Bitmap) {
                ImageComponentImpl.this.T((Bitmap) obj);
            } else if (obj instanceof Drawable) {
                ImageComponentImpl.this.V((Drawable) obj);
            } else if (obj instanceof com.tencent.ams.mosaic.jsengine.component.image.drawable.a) {
                ImageComponentImpl.this.V(((com.tencent.ams.mosaic.jsengine.component.image.drawable.a) obj).getDrawable());
            } else if (obj instanceof com.tencent.ams.mosaic.jsengine.component.image.b) {
                ImageComponentImpl.this.W((com.tencent.ams.mosaic.jsengine.component.image.b) obj);
            }
            if (obj != null) {
                ImageComponentImpl imageComponentImpl = ImageComponentImpl.this;
                imageComponentImpl.F = new com.tencent.ams.mosaic.jsengine.component.image.drawable.c(imageComponentImpl.getJSEngine(), obj);
                if (ImageComponentImpl.this.F.isAnimatable()) {
                    ImageComponentImpl.this.F.setAnimationCallback(ImageComponentImpl.this.D, ImageComponentImpl.this.E);
                    ImageComponentImpl.this.F.setRepeatCount(ImageComponentImpl.this.f71156h);
                    ImageComponentImpl.this.F.setAutoPlay(ImageComponentImpl.this.f71157i);
                }
            }
            if (jSEngine != null && ImageComponentImpl.this.C != null) {
                JSFunction jSFunction = ImageComponentImpl.this.C;
                Object[] objArr = new Object[2];
                if (obj == null) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                objArr[0] = Integer.valueOf(i3);
                objArr[1] = this.f71161a;
                jSEngine.u(jSFunction, objArr, null);
            }
        }

        @Override // com.tencent.ams.mosaic.f.c.a
        public void onLoadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            String str = "onLoadStart: " + this.f71161a + ", width:" + ImageComponentImpl.this.getWidth() + ", height:" + ImageComponentImpl.this.getHeight();
            if (com.tencent.ams.mosaic.f.k().y()) {
                com.tencent.ams.mosaic.utils.f.a("ImageComponentImpl", str);
            } else {
                com.tencent.ams.mosaic.utils.f.e("ImageComponentImpl", str);
            }
            if (ImageComponentImpl.this.f71158m != null) {
                ImageComponentImpl.this.getJSEngine().u(ImageComponentImpl.this.f71158m, new Object[]{this.f71161a}, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ImageComponentImpl.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
            } else {
                ImageComponentImpl.this.Y(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ImageComponentImpl.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
            } else {
                ImageComponentImpl.this.X(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    public ImageComponentImpl(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.f71156h = -1;
        this.f71157i = true;
        if (com.tencent.ams.mosaic.f.k().B()) {
            this.f71153d = new FastCustomImageView(context);
        } else {
            this.f71153d = new CustomImageView(context);
        }
        this.f71153d.setRealDrawListener(new a(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(Bitmap bitmap) {
        if (bitmap != null) {
            this.f71153d.setImageBitmap(bitmap);
            String str = "setBitmap success:" + this.f71155f + ", width:" + getWidth() + ", height:" + getHeight();
            if (com.tencent.ams.mosaic.f.k().y()) {
                com.tencent.ams.mosaic.utils.f.a("ImageComponentImpl", str);
            } else {
                com.tencent.ams.mosaic.utils.f.e("ImageComponentImpl", str);
            }
            if (!this.G) {
                this.G = true;
                com.tencent.ams.mosaic.jsengine.a jSEngine = getJSEngine();
                if (jSEngine != null) {
                    jSEngine.g().b(new com.tencent.ams.mosaic.g("imageComponentSetImageBitmap", getId()));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(Drawable drawable) {
        this.f71153d.setImageDrawable(drawable);
        String str = "setDrawable success:" + this.f71155f + ", width:" + getWidth() + ", height:" + getHeight();
        if (com.tencent.ams.mosaic.f.k().y()) {
            com.tencent.ams.mosaic.utils.f.a("ImageComponentImpl", str);
        } else {
            com.tencent.ams.mosaic.utils.f.e("ImageComponentImpl", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(com.tencent.ams.mosaic.jsengine.component.image.b bVar) {
        this.f71153d.setMovie(bVar.a());
        com.tencent.ams.mosaic.utils.f.e("ImageComponentImpl", "setGif success:" + this.f71155f + ", width:" + getWidth() + ", height:" + getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(Animator animator, Animation animation) {
        ((ValueAnimator) animator).addUpdateListener(new d());
        animator.start();
        this.mAnimator = animator;
        com.tencent.ams.mosaic.utils.f.a(tag(), "startColorFilterAnimation() start - CompID=" + getId() + ", AnimID=" + animation.getAnimID());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(final Animation animation) {
        final Animator customAnimator = ((CustomAnimationImpl) animation).getCustomAnimator(this);
        if (customAnimator != null) {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.image.k
                @Override // java.lang.Runnable
                public final void run() {
                    ImageComponentImpl.this.O(customAnimator, animation);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(Animator animator, Animation animation) {
        ((ValueAnimator) animator).addUpdateListener(new c());
        animator.start();
        this.mAnimator = animator;
        com.tencent.ams.mosaic.utils.f.a(tag(), "startMaskColorAnimation: start - CompID=" + getId() + ", AnimID=" + animation.getAnimID());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(final Animation animation) {
        final Animator customAnimator = ((CustomAnimationImpl) animation).getCustomAnimator(this);
        if (customAnimator != null) {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.image.j
                @Override // java.lang.Runnable
                public final void run() {
                    ImageComponentImpl.this.Q(customAnimator, animation);
                }
            });
        }
    }

    private void S(final Bitmap bitmap) {
        MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.image.e
            @Override // java.lang.Runnable
            public final void run() {
                ImageComponentImpl.this.K(bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(Bitmap bitmap) {
        S(bitmap);
        float f16 = this.f71154e;
        if (f16 > 0.0f) {
            L(bitmap, f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 17)
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public void L(Bitmap bitmap, float f16) {
        S(MosaicUtils.e(bitmap, f16, this.f71153d.getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(final Drawable drawable) {
        if (drawable != null) {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.image.g
                @Override // java.lang.Runnable
                public final void run() {
                    ImageComponentImpl.this.M(drawable);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(final com.tencent.ams.mosaic.jsengine.component.image.b bVar) {
        if (bVar != null) {
            com.tencent.ams.mosaic.utils.f.a("ImageComponentImpl", "setGif: " + bVar);
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.image.h
                @Override // java.lang.Runnable
                public final void run() {
                    ImageComponentImpl.this.N(bVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(int i3) {
        if (this.f71153d != null && i3 != 0) {
            this.f71153d.setTintColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_IN));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(int i3) {
        this.f71153d.setMaskColor(i3);
    }

    private void Z(final Animation animation) {
        getView().post(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.image.f
            @Override // java.lang.Runnable
            public final void run() {
                ImageComponentImpl.this.P(animation);
            }
        });
    }

    private void a0(final Animation animation) {
        getView().post(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.image.d
            @Override // java.lang.Runnable
            public final void run() {
                ImageComponentImpl.this.R(animation);
            }
        });
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.BasicComponent, com.tencent.ams.mosaic.jsengine.component.Component
    public void addAnimation(Animation animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) animation);
            return;
        }
        if (animation instanceof CustomAnimationImpl) {
            CustomAnimationImpl customAnimationImpl = (CustomAnimationImpl) animation;
            if (CustomAnimation.KeyPath.MASK_COLOR.equals(customAnimationImpl.getKeyPath())) {
                a0(animation);
                return;
            } else if (CustomAnimation.KeyPath.COLOR_FILTER.equals(customAnimationImpl.getKeyPath())) {
                Z(animation);
                return;
            }
        }
        super.addAnimation(animation);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f71153d.d();
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.IAnimatableImageComponent
    public boolean isAnimatable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        com.tencent.ams.mosaic.jsengine.component.image.drawable.c cVar = this.F;
        if (cVar != null && cVar.isAnimatable()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.IAnimatableImageComponent
    public boolean isRunning() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        com.tencent.ams.mosaic.jsengine.component.image.drawable.c cVar = this.F;
        if (cVar != null && cVar.isRunning()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.IAnimatableImageComponent
    public void setAnimationCallback(JSFunction jSFunction, JSFunction jSFunction2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) jSFunction, (Object) jSFunction2);
            return;
        }
        this.D = jSFunction;
        this.E = jSFunction2;
        com.tencent.ams.mosaic.jsengine.component.image.drawable.c cVar = this.F;
        if (cVar != null) {
            cVar.setAnimationCallback(jSFunction, jSFunction2);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.IAnimatableImageComponent
    public void setAutoPlay(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
            return;
        }
        this.f71157i = z16;
        com.tencent.ams.mosaic.jsengine.component.image.drawable.c cVar = this.F;
        if (cVar != null) {
            cVar.setAutoPlay(z16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.ImageComponent
    public void setBlurRadius(final float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16));
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("ImageComponentImpl", "setBlurRadius: " + f16);
        if (f16 > 0.0f && f16 <= 25.0f) {
            this.f71154e = f16;
            if (this.f71153d.getDrawable() instanceof BitmapDrawable) {
                final Bitmap bitmap = ((BitmapDrawable) this.f71153d.getDrawable()).getBitmap();
                MosaicUtils.F(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.image.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageComponentImpl.this.L(bitmap, f16);
                    }
                });
            }
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.BasicComponent, com.tencent.ams.mosaic.jsengine.component.Component
    public void setBorder(float f16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Float.valueOf(f16), str);
        } else {
            this.f71153d.setBorderWidth(MosaicUtils.j(f16));
            this.f71153d.setBorderColor(MosaicUtils.O(str));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.BasicComponent, com.tencent.ams.mosaic.jsengine.component.Component
    public void setCornerRadii(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) fArr);
            return;
        }
        if (fArr != null && fArr.length >= 4) {
            this.f71153d.setRadius(MosaicUtils.j(fArr[0]), MosaicUtils.j(fArr[1]), MosaicUtils.j(fArr[2]), MosaicUtils.j(fArr[3]));
        } else {
            com.tencent.ams.mosaic.utils.f.h("ImageComponentImpl", "setCornerRadii fail, invalid radii: " + Arrays.toString(fArr));
        }
        super.setCornerRadii(fArr);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.BasicComponent, com.tencent.ams.mosaic.jsengine.component.Component
    public void setCornerRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Float.valueOf(f16));
        } else {
            this.f71153d.setRadius(MosaicUtils.j(f16));
            super.setCornerRadius(f16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.ImageComponent
    public void setEnableFastDraw(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        com.tencent.ams.mosaic.jsengine.component.image.c cVar = this.f71153d;
        if (cVar instanceof FastCustomImageView) {
            ((FastCustomImageView) cVar).setEnableFastDraw(z16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.ImageComponent
    public void setImageData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            T(MosaicUtils.d(str, 0.0f, 0.0f));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.ImageComponent
    public void setImageDataSequence(String[] strArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) strArr, i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.ImageComponent
    public void setImageLoaderCallback(JSFunction jSFunction, JSFunction jSFunction2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) jSFunction, (Object) jSFunction2);
        } else {
            this.f71158m = jSFunction;
            this.C = jSFunction2;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.ImageComponent
    public void setImageTintColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.h("ImageComponentImpl", "setImageTintColor\uff1a" + str);
        X(MosaicUtils.O(str));
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.ImageComponent
    public void setMaskColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            Y(MosaicUtils.O(str));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.IAnimatableImageComponent
    public void setRepeatCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
            return;
        }
        this.f71156h = i3;
        com.tencent.ams.mosaic.jsengine.component.image.drawable.c cVar = this.F;
        if (cVar != null) {
            cVar.setRepeatCount(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.ImageComponent
    public void setScaleType(String str) {
        ImageView.ScaleType scaleType;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    c16 = 0;
                    break;
                }
                break;
            case -1274298614:
                if (str.equals("fitEnd")) {
                    c16 = 1;
                    break;
                }
                break;
            case -522179887:
                if (str.equals("fitStart")) {
                    c16 = 2;
                    break;
                }
                break;
            case -340708175:
                if (str.equals("centerInside")) {
                    c16 = 3;
                    break;
                }
                break;
            case 97441490:
                if (str.equals("fitXY")) {
                    c16 = 4;
                    break;
                }
                break;
            case 1161480325:
                if (str.equals("centerCrop")) {
                    c16 = 5;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                scaleType = ImageView.ScaleType.CENTER;
                break;
            case 1:
                scaleType = ImageView.ScaleType.FIT_END;
                break;
            case 2:
                scaleType = ImageView.ScaleType.FIT_START;
                break;
            case 3:
                scaleType = ImageView.ScaleType.CENTER_INSIDE;
                break;
            case 4:
                scaleType = ImageView.ScaleType.FIT_XY;
                break;
            case 5:
                scaleType = ImageView.ScaleType.CENTER_CROP;
                break;
            default:
                scaleType = ImageView.ScaleType.FIT_CENTER;
                break;
        }
        this.f71153d.setScaleType(scaleType);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.ImageComponent
    public void setSrc(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.f71155f = str;
            getImageLoader().loadImage(str, new b(str));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.ImageComponent
    public void setSrcSequence(String[] strArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) strArr, i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.IAnimatableImageComponent
    public boolean start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        com.tencent.ams.mosaic.jsengine.component.image.drawable.c cVar = this.F;
        if (cVar != null && cVar.start()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.IAnimatableImageComponent
    public boolean stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        com.tencent.ams.mosaic.jsengine.component.image.drawable.c cVar = this.F;
        if (cVar != null && cVar.stop()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "ImageComponentImpl";
    }
}
