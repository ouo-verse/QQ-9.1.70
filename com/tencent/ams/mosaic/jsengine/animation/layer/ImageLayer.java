package com.tencent.ams.mosaic.jsengine.animation.layer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.GroupAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.RotationAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.f;
import com.tencent.ams.mosaic.jsengine.component.image.ImageComponent;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ImageLayer extends LayerBase<BitmapLayer> implements ImageComponent {
    static IPatchRedirector $redirector_;
    private float S;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements f.c.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f70728a;

        a(String str) {
            this.f70728a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ImageLayer.this, (Object) str);
            }
        }

        @Override // com.tencent.ams.mosaic.f.c.a
        public void onLoadFinish(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, obj);
                return;
            }
            com.tencent.ams.mosaic.utils.f.a("ImageLayer", "onLoadFinish: " + this.f70728a + ", object: " + obj);
            int j3 = (int) MosaicUtils.j(ImageLayer.this.f70736h);
            int j16 = (int) MosaicUtils.j(ImageLayer.this.f70737i);
            if (obj instanceof Bitmap) {
                Bitmap scaleBitmapSafe = Utils.scaleBitmapSafe((Bitmap) obj, j3, j16);
                if (ImageLayer.this.S > 0.0f) {
                    scaleBitmapSafe = MosaicUtils.e(scaleBitmapSafe, ImageLayer.this.S, ImageLayer.this.f70733d);
                }
                ImageLayer.this.g(scaleBitmapSafe);
                return;
            }
            if (obj instanceof Drawable) {
                ImageLayer.this.g(MosaicUtils.k((Drawable) obj, j3, j16));
            }
        }

        @Override // com.tencent.ams.mosaic.f.c.a
        public void onLoadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.ams.mosaic.utils.f.a("ImageLayer", "onLoadStart: " + this.f70728a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b extends BitmapLayer {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ImageLayer.this);
            }
        }

        @Override // com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
        public void draw(Canvas canvas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
                return;
            }
            ImageLayer.this.c(canvas);
            super.draw(canvas);
            ImageLayer.this.b(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c extends GroupAnimator {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private RotationAnimator f70731a;

        public c(AnimatorLayer animatorLayer, Animator... animatorArr) {
            super(animatorLayer, animatorArr);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ImageLayer.this, animatorLayer, animatorArr);
            } else {
                init(animatorLayer);
            }
        }

        private void init(AnimatorLayer animatorLayer) {
            RotationAnimator rotationAnimator = new RotationAnimator(animatorLayer);
            this.f70731a = rotationAnimator;
            rotationAnimator.setRepeatCount(0);
            addAnimators(this.f70731a);
        }

        public void a(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
                return;
            }
            RotationAnimator rotationAnimator = this.f70731a;
            if (rotationAnimator != null) {
                rotationAnimator.setRotationDegrees(f16, f16);
            }
        }
    }

    public ImageLayer(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Bitmap bitmap) {
        ((BitmapLayer) this.K).setBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.LayerBase
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public BitmapLayer a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BitmapLayer) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        b bVar = new b();
        bVar.setAnimator(new c(bVar, new Animator[0]));
        return bVar;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.IAnimatableImageComponent
    public boolean isAnimatable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.IAnimatableImageComponent
    public boolean isRunning() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.LayerBase, com.tencent.ams.mosaic.jsengine.animation.layer.Layer, com.tencent.ams.mosaic.jsengine.component.Component
    public void removeAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        T t16 = this.K;
        if (t16 != 0) {
            ((BitmapLayer) t16).setAnimator(new c(t16, new Animator[0]));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.IAnimatableImageComponent
    public void setAnimationCallback(JSFunction jSFunction, JSFunction jSFunction2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) jSFunction, (Object) jSFunction2);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.IAnimatableImageComponent
    public void setAutoPlay(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.ImageComponent
    public void setBlurRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("ImageLayer", "setBlurRadius: " + f16);
        if (f16 > 0.0f && f16 <= 25.0f) {
            this.S = f16;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.ImageComponent
    public void setEnableFastDraw(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.LayerBase
    public void setFrame(float f16, float f17, float f18, float f19) {
        Matrix matrix;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        super.setFrame(f16, f17, f18, f19);
        T t16 = this.K;
        if (t16 != 0 && (matrix = ((BitmapLayer) t16).getMatrix()) != null) {
            matrix.reset();
            matrix.preTranslate(((BitmapLayer) this.K).getX(), ((BitmapLayer) this.K).getY());
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.ImageComponent
    public void setImageData(String str) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        float f17 = 0.0f;
        if (getWidth() > 0.0f) {
            f16 = getWidth();
        } else {
            f16 = 0.0f;
        }
        if (getHeight() > 0.0f) {
            f17 = getHeight();
        }
        g(MosaicUtils.d(str, MosaicUtils.j(f16), MosaicUtils.j(f17)));
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.ImageComponent
    public void setImageDataSequence(String[] strArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) strArr, i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.ImageComponent
    public void setImageLoaderCallback(JSFunction jSFunction, JSFunction jSFunction2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) jSFunction, (Object) jSFunction2);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.ImageComponent
    public void setImageTintColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.ImageComponent
    public void setMaskColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.IAnimatableImageComponent
    public void setRepeatCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.LayerBase, com.tencent.ams.mosaic.jsengine.animation.AnimationProperty
    public void setRotation(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Float.valueOf(f16));
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ImageLayer", "setRotation, rotation: " + f16);
        super.setRotation(f16);
        T t16 = this.K;
        if (t16 != 0) {
            Animator animator = ((BitmapLayer) t16).getAnimator();
            if (animator instanceof c) {
                ((c) animator).a(f16);
            }
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.ImageComponent
    public void setScaleType(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.ImageComponent
    public void setSrc(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            getImageLoader().loadImage(str, new a(str));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.ImageComponent
    public void setSrcSequence(String[] strArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) strArr, i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.IAnimatableImageComponent
    public boolean start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.IAnimatableImageComponent
    public boolean stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return false;
    }
}
