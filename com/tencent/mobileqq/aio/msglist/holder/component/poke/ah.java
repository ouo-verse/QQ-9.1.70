package com.tencent.mobileqq.aio.msglist.holder.component.poke;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.model.layer.ImageLayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Field;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ah extends Animation {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public ImageLayer f191655d;

    /* renamed from: e, reason: collision with root package name */
    private LottieAnimationView f191656e;

    /* renamed from: f, reason: collision with root package name */
    private Matrix f191657f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f191658h;

    public ah(@NonNull LottieAnimationView lottieAnimationView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) lottieAnimationView);
            return;
        }
        this.f191657f = new Matrix();
        this.f191658h = false;
        this.f191656e = lottieAnimationView;
    }

    private CompositionLayer a() {
        LottieDrawable c16 = c();
        if (c16 == null) {
            return null;
        }
        return (CompositionLayer) e(c16, "compositionLayer", null);
    }

    private ImageLayer b() {
        List list;
        CompositionLayer a16 = a();
        if (a16 == null || (list = (List) e(a16, "layers", null)) == null || list.size() < 1 || !(list.get(0) instanceof ImageLayer)) {
            return null;
        }
        return (ImageLayer) list.get(0);
    }

    private LottieDrawable c() {
        Drawable drawable = this.f191656e.getDrawable();
        if (drawable instanceof LottieDrawable) {
            return (LottieDrawable) drawable;
        }
        return null;
    }

    @SuppressLint({"RestrictedApi"})
    private Matrix d() {
        TransformKeyframeAnimation transformKeyframeAnimation;
        ImageLayer imageLayer = this.f191655d;
        if (imageLayer == null || (transformKeyframeAnimation = (TransformKeyframeAnimation) e(imageLayer, "transform", BaseLayer.class)) == null) {
            return null;
        }
        return transformKeyframeAnimation.getMatrix();
    }

    private Object e(Object obj, String str, Class cls) {
        Field declaredField;
        try {
            if (cls != null) {
                declaredField = cls.getDeclaredField(str);
            } else {
                declaredField = obj.getClass().getDeclaredField(str);
            }
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private void f(Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        fArr[2] = fArr[2] * (-1.0f);
        matrix.setValues(fArr);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f16, Transformation transformation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), transformation);
            return;
        }
        super.applyTransformation(f16, transformation);
        Matrix matrix = transformation.getMatrix();
        if (this.f191655d != null) {
            this.f191657f.set(d());
            if (this.f191658h) {
                f(this.f191657f);
            }
            matrix.set(this.f191657f);
            return;
        }
        try {
            this.f191655d = b();
        } catch (NullPointerException e16) {
            e16.printStackTrace();
        }
    }

    public void h(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.f191658h = z16;
        }
    }

    @Override // android.view.animation.Animation
    public void initialize(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            super.initialize(i3, i16, i17, i18);
        }
    }
}
