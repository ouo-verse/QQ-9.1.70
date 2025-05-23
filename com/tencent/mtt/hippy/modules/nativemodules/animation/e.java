package com.tencent.mtt.hippy.modules.nativemodules.animation;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes20.dex */
public class e extends a {

    /* renamed from: m, reason: collision with root package name */
    private static final Pattern f337464m = Pattern.compile("^cubic-bezier\\(([^,]*),([^,]*),([^,]*),([^,]*)\\)$");

    /* renamed from: d, reason: collision with root package name */
    protected Number f337465d;

    /* renamed from: e, reason: collision with root package name */
    protected Number f337466e;

    /* renamed from: f, reason: collision with root package name */
    protected int f337467f;

    /* renamed from: g, reason: collision with root package name */
    protected String f337468g;

    /* renamed from: h, reason: collision with root package name */
    protected final ValueAnimator f337469h;

    /* renamed from: i, reason: collision with root package name */
    protected String f337470i;

    /* renamed from: j, reason: collision with root package name */
    protected int f337471j;

    /* renamed from: k, reason: collision with root package name */
    protected f f337472k;

    /* renamed from: l, reason: collision with root package name */
    protected int f337473l;

    /* renamed from: n, reason: collision with root package name */
    private Object f337474n;

    public e(int i3) {
        super(i3);
        this.f337465d = 0;
        this.f337466e = 0;
        this.f337471j = 0;
        this.f337473l = 0;
        this.f337474n = Double.valueOf(0.0d);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f337469h = valueAnimator;
        valueAnimator.addUpdateListener(this);
        valueAnimator.addListener(this);
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.animation.a
    public Animator a() {
        return this.f337469h;
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.animation.a
    public void b() {
        this.f337469h.start();
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.animation.a
    public void c() {
        this.f337469h.cancel();
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.animation.a
    public Object f() {
        StringBuilder sb5;
        f fVar;
        Object a16;
        Object g16 = g();
        if ((g16 instanceof Number) && (fVar = this.f337472k) != null && (a16 = fVar.a((Number) g16)) != null) {
            g16 = a16;
        }
        String str = "rad";
        if (TextUtils.equals(this.f337470i, "rad")) {
            sb5 = new StringBuilder();
        } else {
            str = "deg";
            if (TextUtils.equals(this.f337470i, "deg")) {
                sb5 = new StringBuilder();
            } else {
                return g16;
            }
        }
        sb5.append(g16);
        sb5.append(str);
        return sb5.toString();
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.animation.a
    public Object g() {
        return this.f337474n;
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.animation.a
    public void h() {
        ValueAnimator valueAnimator = this.f337469h;
        if (valueAnimator != null) {
            valueAnimator.resume();
        }
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.animation.a
    public void i() {
        ValueAnimator valueAnimator = this.f337469h;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.animation.a, android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (valueAnimator != null) {
            this.f337474n = this.f337469h.getAnimatedValue();
        }
        super.onAnimationUpdate(valueAnimator);
    }

    private void a(float f16, float f17, float f18, float f19) {
        this.f337469h.setInterpolator(new PathInterpolator(f16, f17, f18, f19));
    }

    public void a(HippyMap hippyMap) {
        ValueAnimator valueAnimator;
        TimeInterpolator linearInterpolator;
        if (hippyMap.containsKey("valueType")) {
            this.f337470i = hippyMap.getString("valueType");
        }
        if (hippyMap.containsKey("delay")) {
            this.f337473l = hippyMap.getInt("delay");
        }
        if (hippyMap.containsKey("startValue")) {
            Object obj = hippyMap.get("startValue");
            this.f337465d = obj instanceof Number ? (Number) obj : 0;
        }
        this.f337474n = this.f337465d;
        if (hippyMap.containsKey("toValue")) {
            Object obj2 = hippyMap.get("toValue");
            this.f337466e = obj2 instanceof Number ? (Number) obj2 : 0;
        }
        if (hippyMap.containsKey("duration")) {
            this.f337467f = hippyMap.getInt("duration");
        }
        if (hippyMap.containsKey("timingFunction")) {
            this.f337468g = hippyMap.getString("timingFunction");
        }
        if (hippyMap.containsKey("repeatCount")) {
            int i3 = hippyMap.getInt("repeatCount");
            this.f337471j = i3;
            if (i3 > 0) {
                this.f337471j = i3 - 1;
            }
            this.f337469h.setRepeatCount(this.f337471j);
            this.f337469h.setRepeatMode(1);
        }
        if (hippyMap.containsKey("inputRange")) {
            HippyArray array = hippyMap.getArray("inputRange");
            if (hippyMap.containsKey("outputRange")) {
                this.f337472k = new f(array, hippyMap.getArray("outputRange"));
            }
        }
        if (TextUtils.isEmpty(this.f337470i) || !this.f337470i.equals("color")) {
            this.f337469h.setFloatValues(this.f337465d.floatValue(), this.f337466e.floatValue());
        } else {
            this.f337469h.setIntValues(this.f337465d.intValue(), this.f337466e.intValue());
            this.f337469h.setEvaluator(new ArgbEvaluator());
        }
        this.f337469h.setDuration(this.f337467f);
        if (TextUtils.equals("ease-in", this.f337468g)) {
            valueAnimator = this.f337469h;
            linearInterpolator = new AccelerateInterpolator();
        } else if (TextUtils.equals("ease-out", this.f337468g)) {
            valueAnimator = this.f337469h;
            linearInterpolator = new DecelerateInterpolator();
        } else {
            if (!TextUtils.equals("ease-in-out", this.f337468g)) {
                if (TextUtils.equals("ease_bezier", this.f337468g)) {
                    a(0.42f, 0.0f, 1.0f, 1.0f);
                } else {
                    Matcher matcher = f337464m.matcher(this.f337468g.trim());
                    if (matcher.matches()) {
                        try {
                            a(Float.parseFloat(matcher.group(1)), Float.parseFloat(matcher.group(2)), Float.parseFloat(matcher.group(3)), Float.parseFloat(matcher.group(4)));
                        } catch (Exception unused) {
                            valueAnimator = this.f337469h;
                            linearInterpolator = new LinearInterpolator();
                        }
                    } else {
                        valueAnimator = this.f337469h;
                        linearInterpolator = new LinearInterpolator();
                    }
                }
                this.f337469h.setStartDelay(this.f337473l);
            }
            valueAnimator = this.f337469h;
            linearInterpolator = new AccelerateDecelerateInterpolator();
        }
        valueAnimator.setInterpolator(linearInterpolator);
        this.f337469h.setStartDelay(this.f337473l);
    }
}
