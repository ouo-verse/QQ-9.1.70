package com.tencent.ams.mosaic.jsengine.animation.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Region;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.f;
import com.tencent.ams.mosaic.jsengine.animation.Animation;
import com.tencent.ams.mosaic.jsengine.animation.AnimationProperty;
import com.tencent.ams.mosaic.jsengine.component.Component;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class LayerBase<T extends AnimatorLayer> implements Layer, AnimationProperty {
    static IPatchRedirector $redirector_ = null;
    public static final int LAYOUT_MATCH_PARENT = -1;
    public static final float NOT_SET = Float.MIN_VALUE;
    protected float C;
    protected float D;
    protected float E;
    protected float F;
    protected float G;
    protected float H;
    protected float I;
    protected String[] J;
    protected final T K;
    protected Component L;
    protected Animation M;
    protected float N;
    protected float P;
    protected ShapeLayer Q;
    protected int R;

    /* renamed from: d, reason: collision with root package name */
    protected final Context f70733d;

    /* renamed from: e, reason: collision with root package name */
    protected final String f70734e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.ams.mosaic.jsengine.a f70735f;

    /* renamed from: h, reason: collision with root package name */
    protected float f70736h;

    /* renamed from: i, reason: collision with root package name */
    protected float f70737i;

    /* renamed from: m, reason: collision with root package name */
    protected float f70738m;

    public LayerBase(Context context, String str, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.f70738m = Float.MIN_VALUE;
        this.C = Float.MIN_VALUE;
        this.f70733d = context;
        this.f70734e = str;
        this.K = a();
        setSize(f16, f17);
    }

    @NonNull
    protected abstract T a();

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.Layer, com.tencent.ams.mosaic.jsengine.component.Component
    public void addAnimation(Animation animation) {
        Animator animator;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) animation);
            return;
        }
        if (animation == null) {
            f.h("LayerBase", "add animation failed: null animation");
            return;
        }
        if (this.K != null && (animator = (Animator) animation.getAnimator(this)) != null) {
            this.K.setAnimator(animator);
        }
        this.M = animation;
        f.e("LayerBase", "add animation success: " + animation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, (Object) canvas);
        } else if (canvas != null) {
            canvas.restore();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Canvas canvas) {
        Region.Op op5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, (Object) canvas);
            return;
        }
        if (canvas != null) {
            canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null, 31);
            ShapeLayer shapeLayer = this.Q;
            if (shapeLayer != null && shapeLayer.getPath() != null) {
                Path path = this.Q.getPath();
                if (this.R == 2) {
                    op5 = Region.Op.DIFFERENCE;
                } else {
                    op5 = Region.Op.INTERSECT;
                }
                canvas.clipPath(path, op5);
            }
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void commit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
        }
    }

    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            return;
        }
        T t16 = this.K;
        if (t16 != null) {
            t16.draw(canvas);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public Component findComponentById(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return (Component) iPatchRedirector.redirect((short) 70, (Object) this, (Object) str);
        }
        return null;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public String focusSearch(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            return (String) iPatchRedirector.redirect((short) 72, (Object) this, i3);
        }
        return null;
    }

    public String[] getAlignParentArray() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (String[]) iPatchRedirector.redirect((short) 45, (Object) this);
        }
        return this.J;
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.Layer
    public float getAnchorPointX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Float) iPatchRedirector.redirect((short) 36, (Object) this)).floatValue();
        }
        return this.f70738m;
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.Layer
    public float getAnchorPointY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Float) iPatchRedirector.redirect((short) 37, (Object) this)).floatValue();
        }
        return this.C;
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.Layer
    public Animation getAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (Animation) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        return this.M;
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.Layer
    public AnimatorLayer getAnimatorLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 38, (Object) this);
        }
        return this.K;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public float getHeight() {
        Component component;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, (Object) this)).floatValue();
        }
        float f16 = this.f70737i;
        if (f16 == -1.0f && (component = this.L) != null) {
            return component.getHeight();
        }
        return f16;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public String getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f70734e;
    }

    public f.c getImageLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (f.c) iPatchRedirector.redirect((short) 46, (Object) this);
        }
        f.c c16 = getJSEngine().c();
        if (c16 == null) {
            return com.tencent.ams.mosaic.f.k().j();
        }
        return c16;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public com.tencent.ams.mosaic.jsengine.a getJSEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.ams.mosaic.jsengine.a) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f70735f;
    }

    public float getMarginBottom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Float) iPatchRedirector.redirect((short) 42, (Object) this)).floatValue();
        }
        return this.G;
    }

    public float getMarginLeft() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Float) iPatchRedirector.redirect((short) 39, (Object) this)).floatValue();
        }
        return this.D;
    }

    public float getMarginRight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Float) iPatchRedirector.redirect((short) 41, (Object) this)).floatValue();
        }
        return this.F;
    }

    public float getMarginTop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Float) iPatchRedirector.redirect((short) 40, (Object) this)).floatValue();
        }
        return this.E;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public Component getParent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Component) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.L;
    }

    public float getPositionX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Float) iPatchRedirector.redirect((short) 51, (Object) this)).floatValue();
        }
        return this.N;
    }

    public float getPositionY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Float) iPatchRedirector.redirect((short) 52, (Object) this)).floatValue();
        }
        return this.P;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public float getRealHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Float) iPatchRedirector.redirect((short) 7, (Object) this)).floatValue();
        }
        return getHeight();
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public float getRealWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
        }
        return getWidth();
    }

    public f.InterfaceC0685f getVideoLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (f.InterfaceC0685f) iPatchRedirector.redirect((short) 47, (Object) this);
        }
        f.InterfaceC0685f videoLoader = getJSEngine().getVideoLoader();
        if (videoLoader == null) {
            return com.tencent.ams.mosaic.f.k().s();
        }
        return videoLoader;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public float getWidth() {
        Component component;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
        }
        float f16 = this.f70736h;
        if (f16 == -1.0f && (component = this.L) != null) {
            return component.getWidth();
        }
        return f16;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public float getX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Float) iPatchRedirector.redirect((short) 43, (Object) this)).floatValue();
        }
        return this.H;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public float getXInScreen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            return ((Float) iPatchRedirector.redirect((short) 73, (Object) this)).floatValue();
        }
        return 0.0f;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public float getY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Float) iPatchRedirector.redirect((short) 44, (Object) this)).floatValue();
        }
        return this.I;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public float getYInScreen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            return ((Float) iPatchRedirector.redirect((short) 74, (Object) this)).floatValue();
        }
        return 0.0f;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public boolean isFocused() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return ((Boolean) iPatchRedirector.redirect((short) 71, (Object) this)).booleanValue();
        }
        return false;
    }

    public void notifyAnimationStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this);
            return;
        }
        Animation animation = this.M;
        if (animation != null) {
            animation.onAnimationStart(this);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void onAddedToParent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void onRemovedFromParent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.Layer, com.tencent.ams.mosaic.jsengine.component.Component
    public void removeAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        T t16 = this.K;
        if (t16 != null) {
            t16.setAnimator(new KeepAnimator(t16));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void requestFocus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setAlignParent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
        } else if (!TextUtils.isEmpty(str)) {
            this.J = str.split("[|]");
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setAlpha(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Float.valueOf(f16));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.Layer, com.tencent.ams.mosaic.jsengine.component.Component
    public void setAnchorPoint(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.f70738m = f16;
        this.C = f17;
        T t16 = this.K;
        if (t16 != null) {
            t16.setPx(MosaicUtils.j(f16));
            this.K.setPy(MosaicUtils.j(f17));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setBackgroundColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setBackgroundDrawable(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setBackgroundGradient(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setBorder(float f16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Float.valueOf(f16), str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setBoxShadow(float f16, float f17, float f18, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setCornerRadii(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) fArr);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setCornerRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Float.valueOf(f16));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setFlexLayout(JSObject jSObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) jSObject);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setFocusable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, z16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setFocusableInTouchMode(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this, z16);
        }
    }

    public void setFrame(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        this.H = f16;
        this.I = f17;
        T t16 = this.K;
        if (t16 != null) {
            t16.setX(MosaicUtils.j(f16));
            this.K.setY(MosaicUtils.j(f17));
            this.K.setWidth((int) MosaicUtils.j(f18));
            this.K.setHeight((int) MosaicUtils.j(f19));
            setSize(f18, f19);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setJSEngine(com.tencent.ams.mosaic.jsengine.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) aVar);
        } else {
            this.f70735f = aVar;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setMargin(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        this.D = f16;
        this.E = f17;
        this.F = f18;
        this.G = f19;
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.Layer
    public void setMaskLayer(ShapeLayer shapeLayer, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, (Object) shapeLayer, i3);
        } else {
            this.Q = shapeLayer;
            this.R = i3;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setNextFocusDownId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setNextFocusLeftId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setNextFocusRightId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setNextFocusUpId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setOnClickListener(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) jSFunction);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setOnFocusChangeListener(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this, (Object) jSFunction);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setOnTouchListener(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) jSFunction);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.AnimationProperty
    public void setOpacity(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, this, Float.valueOf(f16));
            return;
        }
        T t16 = this.K;
        if (t16 != null) {
            t16.postAlpha((int) (f16 * 255.0f));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setPadding(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setParent(Component component) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) component);
        } else {
            this.L = component;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.AnimationProperty
    public void setPosition(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, this, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.N = f16;
        this.P = f17;
        T t16 = this.K;
        if (t16 != null) {
            t16.setX(MosaicUtils.j(f16));
            this.K.setY(MosaicUtils.j(f17));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.AnimationProperty
    public void setPositionOffset(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, this, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        T t16 = this.K;
        if (t16 != null) {
            t16.postTranslate(MosaicUtils.j(f16), MosaicUtils.j(f17));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.AnimationProperty
    public void setRotation(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, this, Float.valueOf(f16));
            return;
        }
        T t16 = this.K;
        if (t16 != null) {
            t16.postRotation(f16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.AnimationProperty
    public void setScale(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, this, Float.valueOf(f16));
            return;
        }
        T t16 = this.K;
        if (t16 != null) {
            t16.postScale(f16, f16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setSize(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.f70736h = f16;
        this.f70737i = f17;
        T t16 = this.K;
        if (t16 != null) {
            t16.setWidth((int) MosaicUtils.j(f16));
            this.K.setHeight((int) MosaicUtils.j(f17));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setZIndex(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return (String) iPatchRedirector.redirect((short) 61, (Object) this);
        }
        return getClass().getName() + "@" + Integer.toHexString(hashCode()) + "#" + getId();
    }
}
