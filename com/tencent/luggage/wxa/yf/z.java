package com.tencent.luggage.wxa.yf;

import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.luggage.wxa.xd.o1;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class z extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 198;
    public static final String NAME = "setNavigationBarColor";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f145769a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f145770b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f145771c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f145772d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f145773e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f145774f;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.yf.z$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C6955a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.kj.v f145776a;

            public C6955a(com.tencent.luggage.wxa.kj.v vVar) {
                this.f145776a = vVar;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f145776a.e(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.kj.v f145778a;

            public b(com.tencent.luggage.wxa.kj.v vVar) {
                this.f145778a = vVar;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f145778a.f(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        public a(com.tencent.luggage.wxa.ic.d dVar, int i3, int i16, int i17, int i18, String str) {
            this.f145769a = dVar;
            this.f145770b = i3;
            this.f145771c = i16;
            this.f145772d = i17;
            this.f145773e = i18;
            this.f145774f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            TimeInterpolator timeInterpolator;
            com.tencent.luggage.wxa.kj.v a16 = o1.a(this.f145769a);
            if (a16 == null) {
                this.f145769a.a(this.f145770b, z.this.makeReturnJson("fail:page don't exist"));
                return;
            }
            if (!a16.isRunning()) {
                return;
            }
            if (a16.getRuntime().v0()) {
                View findViewById = a16.getRuntime().Y().getRootView().findViewById(R.id.sqo);
                if (findViewById != null) {
                    findViewById.setBackgroundColor(this.f145771c);
                    a16.f(this.f145772d);
                    return;
                }
                return;
            }
            if (a16.I0() && !a16.N0()) {
                return;
            }
            a16.P();
            if (this.f145773e <= 0) {
                a16.f(this.f145772d);
                a16.e(this.f145771c);
                return;
            }
            int backgroundColor = a16.W().getBackgroundColor();
            int foregroundColor = a16.W().getForegroundColor();
            if (CanvasView.ACTION_LINER.equals(this.f145774f)) {
                timeInterpolator = new LinearInterpolator();
            } else if ("easeIn".equals(this.f145774f)) {
                timeInterpolator = new AccelerateInterpolator();
            } else if ("easeOut".equals(this.f145774f)) {
                timeInterpolator = new DecelerateInterpolator();
            } else if ("easeInOut".equals(this.f145774f)) {
                timeInterpolator = new AccelerateDecelerateInterpolator();
            } else {
                timeInterpolator = null;
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(backgroundColor, this.f145771c);
            valueAnimator.setEvaluator(new ArgbEvaluator());
            valueAnimator.setDuration(this.f145773e);
            valueAnimator.setInterpolator(timeInterpolator);
            valueAnimator.addUpdateListener(new C6955a(a16));
            ValueAnimator valueAnimator2 = new ValueAnimator();
            valueAnimator2.setIntValues(foregroundColor, this.f145772d);
            valueAnimator2.setEvaluator(new ArgbEvaluator());
            valueAnimator2.setDuration(this.f145773e);
            valueAnimator2.setInterpolator(timeInterpolator);
            valueAnimator2.addUpdateListener(new b(a16));
            valueAnimator.start();
            valueAnimator2.start();
            a16.a(valueAnimator, valueAnimator2);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
        int i16;
        String str;
        try {
            int b16 = com.tencent.luggage.wxa.tk.g.b(jSONObject.getString("frontColor"));
            int b17 = com.tencent.luggage.wxa.tk.g.b(jSONObject.getString("backgroundColor"));
            jSONObject.optDouble(com.tencent.luggage.wxa.c8.c.f123400v, 1.0d);
            JSONObject optJSONObject = jSONObject.optJSONObject("animation");
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt("duration");
                str = optJSONObject.optString("timingFunc");
                i16 = optInt;
            } else {
                i16 = 0;
                str = "";
            }
            a aVar = new a(dVar, i3, b17, b16, i16, str);
            if (!(dVar instanceof com.tencent.luggage.wxa.kj.v) && dVar.getRuntime().m1()) {
                dVar.getRuntime().c(aVar);
            } else {
                dVar.a(aVar);
            }
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
        } catch (Exception unused) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSetNavigationBarColor", "Color parse error");
            dVar.a(i3, makeReturnJson("fail:invalid color"));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public boolean dispatchInJsThread() {
        return true;
    }
}
