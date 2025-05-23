package com.tencent.ams.mosaic.jsengine.animation.basic;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.animatorview.animator.AlphaAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.ColorAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.RotationAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.RotationXAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.RotationYAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.ScaleAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.TranslateAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.ams.hippo.quickjs.android.JSContext;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.jsengine.animation.AnimationBase;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.ams.mosaic.jsengine.animation.layer.Layer;
import com.tencent.ams.mosaic.jsengine.component.Component;
import com.tencent.ams.mosaic.jsengine.e;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class BasicAnimationImpl extends AnimationBase implements BasicAnimation {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    private String f70706m;

    /* renamed from: n, reason: collision with root package name */
    private JSObject f70707n;

    /* renamed from: o, reason: collision with root package name */
    private JSObject f70708o;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        float f70709a;

        /* renamed from: b, reason: collision with root package name */
        float f70710b;

        a(float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16), Float.valueOf(f17));
            } else {
                this.f70709a = f16;
                this.f70710b = f17;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        float f70711a;

        /* renamed from: b, reason: collision with root package name */
        float f70712b;

        b(float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16), Float.valueOf(f17));
            } else {
                this.f70711a = f16;
                this.f70712b = f17;
            }
        }
    }

    public BasicAnimationImpl(JSContext jSContext) {
        super(jSContext);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) jSContext);
        }
    }

    @ColorInt
    private int g(JSObject jSObject, String str, int i3) {
        Map<String, Object> f16;
        if (jSObject != null && (f16 = e.f(this.f70686a, jSObject)) != null) {
            Object obj = f16.get(str);
            if (obj instanceof String) {
                return Utils.safeParseColor((String) obj, i3);
            }
            if (obj instanceof Number) {
                return ((Number) obj).intValue();
            }
        }
        return i3;
    }

    private Object h(JSObject jSObject) {
        Map<String, Object> f16;
        if (jSObject != null && (f16 = e.f(this.f70686a, jSObject)) != null) {
            Object obj = f16.get("position");
            if (obj instanceof Map) {
                Map map = (Map) obj;
                Object obj2 = map.get(HippyTKDListViewAdapter.X);
                Object obj3 = map.get("y");
                if ((obj2 instanceof Number) && (obj3 instanceof Number)) {
                    return new a(MosaicUtils.j(((Number) obj2).floatValue()), MosaicUtils.j(((Number) obj3).floatValue()));
                }
                Object obj4 = map.get("dx");
                Object obj5 = map.get("dy");
                if ((obj4 instanceof Number) && (obj5 instanceof Number)) {
                    return new b(MosaicUtils.j(((Number) obj4).floatValue()), MosaicUtils.j(((Number) obj5).floatValue()));
                }
            }
        }
        return new b(0.0f, 0.0f);
    }

    private float i(JSObject jSObject, String str, float f16) {
        Map<String, Object> f17;
        if (jSObject != null && (f17 = e.f(this.f70686a, jSObject)) != null) {
            Object obj = f17.get(str);
            if (obj instanceof Number) {
                return ((Number) obj).floatValue();
            }
        }
        return f16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.ams.mosaic.jsengine.animation.Animation
    public Animator getSystemAnimator(@NonNull Component component) {
        float f16;
        float f17;
        float f18;
        float f19;
        ObjectAnimator objectAnimator;
        char c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Animator) iPatchRedirector.redirect((short) 4, (Object) this, (Object) component);
        }
        String str = this.f70706m;
        if (str != null && component != null) {
            str.hashCode();
            char c17 = '\uffff';
            switch (str.hashCode()) {
                case -1267206133:
                    if (str.equals("opacity")) {
                        c17 = 0;
                        break;
                    }
                    break;
                case -1249320806:
                    if (str.equals(BasicAnimation.KeyPath.ROTATION_X)) {
                        c17 = 1;
                        break;
                    }
                    break;
                case -1249320805:
                    if (str.equals(BasicAnimation.KeyPath.ROTATION_Y)) {
                        c17 = 2;
                        break;
                    }
                    break;
                case -1063571914:
                    if (str.equals("textColor")) {
                        c16 = 3;
                        c17 = c16;
                        break;
                    }
                    break;
                case -908189618:
                    if (str.equals(BasicAnimation.KeyPath.SCALE_X)) {
                        c17 = 4;
                        break;
                    }
                    break;
                case -908189617:
                    if (str.equals(BasicAnimation.KeyPath.SCALE_Y)) {
                        c16 = 5;
                        c17 = c16;
                        break;
                    }
                    break;
                case -40300674:
                    if (str.equals(BasicAnimation.KeyPath.ROTATION)) {
                        c16 = 6;
                        c17 = c16;
                        break;
                    }
                    break;
                case 109250890:
                    if (str.equals("scale")) {
                        c16 = 7;
                        c17 = c16;
                        break;
                    }
                    break;
                case 747804969:
                    if (str.equals("position")) {
                        c16 = '\b';
                        c17 = c16;
                        break;
                    }
                    break;
                case 1287124693:
                    if (str.equals("backgroundColor")) {
                        c16 = '\t';
                        c17 = c16;
                        break;
                    }
                    break;
            }
            switch (c17) {
                case 0:
                    objectAnimator = ObjectAnimator.ofFloat(component.getView(), (Property<View, Float>) View.ALPHA, i(this.f70707n, "opacity", 1.0f), i(this.f70708o, "opacity", 1.0f));
                    break;
                case 1:
                    objectAnimator = ObjectAnimator.ofFloat(component.getView(), (Property<View, Float>) View.ROTATION_X, i(this.f70707n, BasicAnimation.KeyPath.ROTATION_X, 0.0f), i(this.f70708o, BasicAnimation.KeyPath.ROTATION_X, 0.0f));
                    break;
                case 2:
                    objectAnimator = ObjectAnimator.ofFloat(component.getView(), (Property<View, Float>) View.ROTATION_Y, i(this.f70707n, BasicAnimation.KeyPath.ROTATION_Y, 0.0f), i(this.f70708o, BasicAnimation.KeyPath.ROTATION_Y, 0.0f));
                    break;
                case 3:
                    ObjectAnimator ofInt = ObjectAnimator.ofInt(component.getView(), "textColor", g(this.f70707n, "color", 0), g(this.f70708o, "color", 0));
                    ofInt.setEvaluator(new ArgbEvaluator());
                    objectAnimator = ofInt;
                    break;
                case 4:
                    objectAnimator = ObjectAnimator.ofFloat(component.getView(), (Property<View, Float>) View.SCALE_X, i(this.f70707n, BasicAnimation.KeyPath.SCALE_X, 1.0f), i(this.f70708o, BasicAnimation.KeyPath.SCALE_X, 1.0f));
                    break;
                case 5:
                    objectAnimator = ObjectAnimator.ofFloat(component.getView(), (Property<View, Float>) View.SCALE_Y, i(this.f70707n, BasicAnimation.KeyPath.SCALE_Y, 1.0f), i(this.f70708o, BasicAnimation.KeyPath.SCALE_Y, 1.0f));
                    break;
                case 6:
                    objectAnimator = ObjectAnimator.ofFloat(component.getView(), (Property<View, Float>) View.ROTATION, i(this.f70707n, BasicAnimation.KeyPath.ROTATION, 0.0f), i(this.f70708o, BasicAnimation.KeyPath.ROTATION, 0.0f));
                    break;
                case 7:
                    float i3 = i(this.f70707n, "scale", 1.0f);
                    float i16 = i(this.f70708o, "scale", 1.0f);
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(component.getView(), (Property<View, Float>) View.SCALE_X, i3, i16);
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(component.getView(), (Property<View, Float>) View.SCALE_Y, i3, i16);
                    f(ofFloat);
                    f(ofFloat2);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(ofFloat, ofFloat2);
                    objectAnimator = animatorSet;
                    break;
                case '\b':
                    Object h16 = h(this.f70707n);
                    Object h17 = h(this.f70708o);
                    float left = component.getView().getLeft();
                    float top = component.getView().getTop();
                    float width = component.getView().getWidth() / 2.0f;
                    float height = component.getView().getHeight() / 2.0f;
                    if (h16 instanceof b) {
                        b bVar = (b) h16;
                        f16 = bVar.f70711a;
                        f17 = bVar.f70712b;
                    } else {
                        a aVar = (a) h16;
                        f16 = (aVar.f70709a - left) - width;
                        f17 = (aVar.f70710b - top) - height;
                    }
                    if (h17 instanceof b) {
                        b bVar2 = (b) h17;
                        f18 = bVar2.f70711a;
                        f19 = bVar2.f70712b;
                    } else {
                        a aVar2 = (a) h17;
                        f18 = (aVar2.f70709a - left) - width;
                        f19 = (aVar2.f70710b - top) - height;
                    }
                    f.a("BasicAnimationImpl", "getSystemAnimator, position, fromDx: " + f16 + ", toDx: " + f18 + ", fromDy: " + f17 + ", toDy: " + f19 + ", viewX: " + left + ", viewY: " + top);
                    ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(component.getView(), (Property<View, Float>) View.TRANSLATION_X, f16, f18);
                    ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(component.getView(), (Property<View, Float>) View.TRANSLATION_Y, f17, f19);
                    f(ofFloat3);
                    f(ofFloat4);
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    animatorSet2.playTogether(ofFloat3, ofFloat4);
                    objectAnimator = animatorSet2;
                    break;
                case '\t':
                    ObjectAnimator ofInt2 = ObjectAnimator.ofInt(component.getView(), "backgroundColor", g(this.f70707n, "color", 0), g(this.f70708o, "color", 0));
                    ofInt2.setEvaluator(new ArgbEvaluator());
                    objectAnimator = ofInt2;
                    break;
                default:
                    objectAnimator = null;
                    break;
            }
            d(objectAnimator, component);
            return objectAnimator;
        }
        return null;
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation
    public void setAnimationParams(String str, JSObject jSObject, JSObject jSObject2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, jSObject, jSObject2);
            return;
        }
        this.f70706m = str;
        this.f70707n = jSObject;
        this.f70708o = jSObject2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0080, code lost:
    
        if (r0.equals(com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation.KeyPath.SCALE_X) == false) goto L17;
     */
    @Override // com.tencent.ams.mosaic.jsengine.animation.Animation
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.tencent.ams.fusion.widget.animatorview.animator.Animator getAnimator(@NonNull Layer layer) {
        float x16;
        float y16;
        float x17;
        float y17;
        IPatchRedirector iPatchRedirector = $redirector_;
        char c16 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.ams.fusion.widget.animatorview.animator.Animator) iPatchRedirector.redirect((short) 3, (Object) this, (Object) layer);
        }
        com.tencent.ams.fusion.widget.animatorview.animator.Animator animator = null;
        com.tencent.ams.fusion.widget.animatorview.animator.Animator animator2 = null;
        animator = null;
        if (this.f70706m != null && layer != null) {
            AnimatorLayer animatorLayer = layer.getAnimatorLayer();
            if (animatorLayer == null) {
                return null;
            }
            String str = this.f70706m;
            str.hashCode();
            switch (str.hashCode()) {
                case -1267206133:
                    if (str.equals("opacity")) {
                        c16 = 0;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1249320806:
                    if (str.equals(BasicAnimation.KeyPath.ROTATION_X)) {
                        c16 = 1;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1249320805:
                    if (str.equals(BasicAnimation.KeyPath.ROTATION_Y)) {
                        c16 = 2;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -908189618:
                    break;
                case -908189617:
                    if (str.equals(BasicAnimation.KeyPath.SCALE_Y)) {
                        c16 = 4;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -40300674:
                    if (str.equals(BasicAnimation.KeyPath.ROTATION)) {
                        c16 = 5;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 109250890:
                    if (str.equals("scale")) {
                        c16 = 6;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 747804969:
                    if (str.equals("position")) {
                        c16 = 7;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1287124693:
                    if (str.equals("backgroundColor")) {
                        c16 = '\b';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                default:
                    c16 = '\uffff';
                    break;
            }
            switch (c16) {
                case 0:
                    animator2 = new AlphaAnimator(animatorLayer, i(this.f70707n, "opacity", 1.0f), i(this.f70708o, "opacity", 1.0f));
                    break;
                case 1:
                    float i3 = i(this.f70707n, BasicAnimation.KeyPath.ROTATION_X, 0.0f);
                    float i16 = i(this.f70708o, BasicAnimation.KeyPath.ROTATION_X, 0.0f);
                    RotationXAnimator rotationXAnimator = new RotationXAnimator(animatorLayer);
                    rotationXAnimator.setRotationDegrees(i3, i16);
                    animator2 = rotationXAnimator;
                    break;
                case 2:
                    float i17 = i(this.f70707n, BasicAnimation.KeyPath.ROTATION_Y, 0.0f);
                    float i18 = i(this.f70708o, BasicAnimation.KeyPath.ROTATION_Y, 0.0f);
                    RotationYAnimator rotationYAnimator = new RotationYAnimator(animatorLayer);
                    rotationYAnimator.setRotationDegrees(i17, i18);
                    animator2 = rotationYAnimator;
                    break;
                case 3:
                case 4:
                    animator2 = new ScaleAnimator(animatorLayer, i(this.f70707n, BasicAnimation.KeyPath.SCALE_X, 1.0f), i(this.f70708o, BasicAnimation.KeyPath.SCALE_X, 1.0f), i(this.f70707n, BasicAnimation.KeyPath.SCALE_Y, 1.0f), i(this.f70708o, BasicAnimation.KeyPath.SCALE_Y, 1.0f));
                    break;
                case 5:
                    float i19 = i(this.f70707n, BasicAnimation.KeyPath.ROTATION, 0.0f);
                    float i26 = i(this.f70708o, BasicAnimation.KeyPath.ROTATION, 0.0f);
                    RotationAnimator rotationAnimator = new RotationAnimator(animatorLayer);
                    rotationAnimator.setRotationDegrees(i19, i26);
                    animator2 = rotationAnimator;
                    break;
                case 6:
                    float i27 = i(this.f70707n, "scale", 1.0f);
                    float i28 = i(this.f70708o, "scale", 1.0f);
                    animator2 = new ScaleAnimator(animatorLayer, i27, i28, i27, i28);
                    break;
                case 7:
                    Object h16 = h(this.f70707n);
                    Object h17 = h(this.f70708o);
                    if (h16 instanceof b) {
                        b bVar = (b) h16;
                        x16 = bVar.f70711a;
                        y16 = bVar.f70712b;
                    } else {
                        a aVar = (a) h16;
                        x16 = aVar.f70709a - animatorLayer.getX();
                        y16 = aVar.f70710b - animatorLayer.getY();
                    }
                    float f16 = y16;
                    float f17 = x16;
                    if (h17 instanceof b) {
                        b bVar2 = (b) h17;
                        x17 = bVar2.f70711a;
                        y17 = bVar2.f70712b;
                    } else {
                        a aVar2 = (a) h17;
                        x17 = aVar2.f70709a - animatorLayer.getX();
                        y17 = aVar2.f70710b - animatorLayer.getY();
                    }
                    animator2 = new TranslateAnimator(animatorLayer, f17, x17, f16, y17);
                    break;
                case '\b':
                    animator2 = new ColorAnimator(animatorLayer, g(this.f70707n, "color", 0), g(this.f70708o, "color", 0));
                    break;
            }
            b(animator2, layer);
            animator = animator2;
        }
        return animator;
    }
}
