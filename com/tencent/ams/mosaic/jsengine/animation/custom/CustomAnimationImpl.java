package com.tencent.ams.mosaic.jsengine.animation.custom;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.ams.hippo.quickjs.android.JSContext;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.jsengine.animation.AnimationBase;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.ams.mosaic.jsengine.animation.layer.Layer;
import com.tencent.ams.mosaic.jsengine.component.Component;
import com.tencent.ams.mosaic.jsengine.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class CustomAnimationImpl extends AnimationBase implements CustomAnimation {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    private String f70713m;

    /* renamed from: n, reason: collision with root package name */
    private JSObject f70714n;

    /* renamed from: o, reason: collision with root package name */
    private JSObject f70715o;

    public CustomAnimationImpl(JSContext jSContext) {
        super(jSContext);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) jSContext);
        }
    }

    private ValueAnimator g() {
        ValueAnimator ofInt = ValueAnimator.ofInt(h(this.f70714n, "color", 0), h(this.f70715o, "color", 0));
        ofInt.setEvaluator(new ArgbEvaluator());
        ofInt.setStartDelay(this.f70694i * 1000.0f);
        ofInt.setDuration(this.f70688c * 1000.0f);
        return ofInt;
    }

    @ColorInt
    private int h(JSObject jSObject, String str, int i3) {
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

    @Override // com.tencent.ams.mosaic.jsengine.animation.Animation
    public Animator getAnimator(@NonNull Layer layer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return null;
        }
        return (Animator) iPatchRedirector.redirect((short) 4, (Object) this, (Object) layer);
    }

    public android.animation.Animator getCustomAnimator(@NonNull Component component) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (android.animation.Animator) iPatchRedirector.redirect((short) 6, (Object) this, (Object) component);
        }
        String str = this.f70713m;
        if (str == null || component == null) {
            return null;
        }
        str.hashCode();
        if (!str.equals(CustomAnimation.KeyPath.MASK_COLOR) && !str.equals(CustomAnimation.KeyPath.COLOR_FILTER)) {
            return null;
        }
        return g();
    }

    public String getKeyPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f70713m;
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.Animation
    public android.animation.Animator getSystemAnimator(@NonNull Component component) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (android.animation.Animator) iPatchRedirector.redirect((short) 5, (Object) this, (Object) component);
        }
        return null;
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation
    public void setAnimationParams(String str, JSObject jSObject, JSObject jSObject2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, jSObject, jSObject2);
            return;
        }
        this.f70713m = str;
        this.f70714n = jSObject;
        this.f70715o = jSObject2;
    }
}
