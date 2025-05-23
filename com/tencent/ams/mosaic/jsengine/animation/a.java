package com.tencent.ams.mosaic.jsengine.animation;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ams.hippo.quickjs.android.JSContext;
import com.tencent.ams.mosaic.jsengine.animation.Animation;
import com.tencent.ams.mosaic.jsengine.animation.IAnimationFactory;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimationImpl;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimationImpl;
import com.tencent.ams.mosaic.jsengine.animation.frame.FrameAnimationImpl;
import com.tencent.ams.mosaic.jsengine.animation.group.GroupAnimationImpl;
import com.tencent.ams.mosaic.jsengine.animation.timefunction.TimingFunction;
import com.tencent.ams.mosaic.jsengine.animation.timefunction.b;
import com.tencent.ams.mosaic.jsengine.animation.timefunction.c;
import com.tencent.ams.mosaic.jsengine.animation.timefunction.d;
import com.tencent.ams.mosaic.jsengine.animation.timefunction.e;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements IAnimationFactory {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, Class<? extends Animation>> f70703b;

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, Class<? extends TimingFunction>> f70704c;

    /* renamed from: a, reason: collision with root package name */
    private final com.tencent.ams.mosaic.jsengine.a f70705a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19268);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f70703b = new HashMap();
        f70704c = new HashMap();
        a("Basic", BasicAnimationImpl.class);
        a(IAnimationFactory.AnimationType.f70702GROUP, GroupAnimationImpl.class);
        a("Frame", FrameAnimationImpl.class);
        a("Custom", CustomAnimationImpl.class);
        b(Animation.TimingFunctionName.LINEAR, e.class);
        b(Animation.TimingFunctionName.EASE_IN, c.class);
        b(Animation.TimingFunctionName.EASE_OUT, d.class);
        b(Animation.TimingFunctionName.EASE_IN_EASE_OUT, b.class);
        b(Animation.TimingFunctionName.BEZIER_PATH, com.tencent.ams.mosaic.jsengine.animation.timefunction.a.class);
    }

    public a(Context context, com.tencent.ams.mosaic.jsengine.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) aVar);
        } else {
            this.f70705a = aVar;
        }
    }

    public static void a(String str, Class<? extends Animation> cls) {
        if (!TextUtils.isEmpty(str) && cls != null) {
            f70703b.put(str, cls);
        }
    }

    public static void b(@Animation.TimingFunctionName String str, Class<? extends TimingFunction> cls) {
        if (!TextUtils.isEmpty(str) && cls != null) {
            f70704c.put(str, cls);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.IAnimationFactory
    public Animation createAnimation(String str) {
        Class<? extends Animation> cls;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Animation) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        f.e("AnimationFactory", "createAnimation:" + str);
        try {
            cls = f70703b.get(str);
        } catch (Throwable th5) {
            f.i("AnimationFactory", "create animation failed: " + str, th5);
        }
        if (cls != null) {
            return cls.getConstructor(JSContext.class).newInstance(this.f70705a.l());
        }
        f.b("AnimationFactory", "animation type not support: " + str);
        return null;
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.IAnimationFactory
    public TimingFunction createTimingFunction(String str, float[] fArr) {
        Class<? extends TimingFunction> cls;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TimingFunction) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) fArr);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        f.e("AnimationFactory", "createTimingFunction:" + str);
        try {
            cls = f70704c.get(str);
        } catch (Throwable th5) {
            f.i("AnimationFactory", "createTimingFunction failed: " + str, th5);
        }
        if (cls != null) {
            if (Animation.TimingFunctionName.BEZIER_PATH.equals(str)) {
                return cls.getConstructor(float[].class).newInstance(fArr);
            }
            return cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        }
        f.b("AnimationFactory", "timing function type not support: " + str);
        return null;
    }
}
