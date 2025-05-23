package com.tencent.luggage.wxa.we;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.tk.g;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.f;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.ee.d {
    public static final int CTRL_INDEX = 510;
    public static final String NAME = "updatePositioningContainer";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f144204a;

        public a(View view) {
            this.f144204a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f144204a.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f144206a;

        public b(View view) {
            this.f144206a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f144206a.setY(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    @Override // com.tencent.luggage.wxa.ee.d
    public boolean a(f fVar, int i3, View view, JSONObject jSONObject) {
        if (!(view instanceof e)) {
            return false;
        }
        int a16 = g.a(jSONObject, "contentOffsetLeft", 0);
        int a17 = g.a(jSONObject, "contentOffsetTop", 0);
        int optInt = jSONObject.optInt("animate", 0);
        e eVar = (e) view;
        try {
            eVar.setVisibility(jSONObject.getBoolean(NodeProps.VISIBLE) ? 0 : 4);
        } catch (JSONException unused) {
        }
        com.tencent.luggage.wxa.we.a aVar = (com.tencent.luggage.wxa.we.a) eVar.a(com.tencent.luggage.wxa.we.a.class);
        w.d("MicroMsg.JsApiUpdatePositioningContainer", "scrollLeft:%d, scrollTop:%d, animation:%d", Integer.valueOf(a16), Integer.valueOf(a17), Integer.valueOf(optInt));
        if (optInt == 1) {
            a(aVar, a16, a17);
        } else {
            aVar.setX(-a16);
            aVar.setY(-a17);
        }
        int a18 = g.a(jSONObject, "innerHeight", aVar.getHeight());
        int a19 = g.a(jSONObject, "innerWidth", aVar.getWidth());
        w.d("MicroMsg.JsApiUpdatePositioningContainer", "innerHeight:%d, innerWidth:%d", Integer.valueOf(a18), Integer.valueOf(a19));
        ViewGroup.LayoutParams layoutParams = aVar.getLayoutParams();
        layoutParams.height = a18;
        layoutParams.width = a19;
        aVar.setLayoutParams(layoutParams);
        return true;
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.getInt("containerId");
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c implements Interpolator {

        /* renamed from: a, reason: collision with root package name */
        public int f144208a;

        /* renamed from: b, reason: collision with root package name */
        public final PointF f144209b;

        /* renamed from: c, reason: collision with root package name */
        public final PointF f144210c;

        /* renamed from: d, reason: collision with root package name */
        public PointF f144211d;

        /* renamed from: e, reason: collision with root package name */
        public PointF f144212e;

        /* renamed from: f, reason: collision with root package name */
        public PointF f144213f;

        /* renamed from: g, reason: collision with root package name */
        public PointF f144214g;

        /* renamed from: h, reason: collision with root package name */
        public PointF f144215h;

        public c(PointF pointF, PointF pointF2) {
            this.f144208a = 0;
            this.f144209b = new PointF();
            this.f144210c = new PointF();
            this.f144213f = new PointF();
            this.f144214g = new PointF();
            this.f144215h = new PointF();
            float f16 = pointF.x;
            if (f16 >= 0.0f && f16 <= 1.0f) {
                float f17 = pointF2.x;
                if (f17 >= 0.0f && f17 <= 1.0f) {
                    this.f144211d = pointF;
                    this.f144212e = pointF2;
                    return;
                }
                throw new IllegalArgumentException("endX value must be in the range [0, 1]");
            }
            throw new IllegalArgumentException("startX value must be in the range [0, 1]");
        }

        public final float a(float f16) {
            PointF pointF = this.f144215h;
            PointF pointF2 = this.f144211d;
            float f17 = pointF2.x * 3.0f;
            pointF.x = f17;
            PointF pointF3 = this.f144214g;
            float f18 = ((this.f144212e.x - pointF2.x) * 3.0f) - f17;
            pointF3.x = f18;
            PointF pointF4 = this.f144213f;
            float f19 = (1.0f - pointF.x) - f18;
            pointF4.x = f19;
            return f16 * (pointF.x + ((pointF3.x + (f19 * f16)) * f16));
        }

        public float b(float f16) {
            PointF pointF = this.f144215h;
            PointF pointF2 = this.f144211d;
            float f17 = pointF2.y * 3.0f;
            pointF.y = f17;
            PointF pointF3 = this.f144214g;
            float f18 = ((this.f144212e.y - pointF2.y) * 3.0f) - f17;
            pointF3.y = f18;
            PointF pointF4 = this.f144213f;
            float f19 = (1.0f - pointF.y) - f18;
            pointF4.y = f19;
            return f16 * (pointF.y + ((pointF3.y + (f19 * f16)) * f16));
        }

        public final float c(float f16) {
            return this.f144215h.x + (f16 * ((this.f144214g.x * 2.0f) + (this.f144213f.x * 3.0f * f16)));
        }

        public float d(float f16) {
            float f17 = f16;
            for (int i3 = 1; i3 < 14; i3++) {
                float a16 = a(f17) - f16;
                if (Math.abs(a16) < 0.001d) {
                    break;
                }
                f17 -= a16 / c(f17);
            }
            return f17;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            return b(d(f16));
        }

        public c(float f16, float f17, float f18, float f19) {
            this(new PointF(f16, f17), new PointF(f18, f19));
        }
    }

    public final void a(View view, int i3, int i16) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, HippyTKDListViewAdapter.X, view.getX(), -i3);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "y", view.getY(), -i16);
        ofFloat.addUpdateListener(new a(view));
        ofFloat2.addUpdateListener(new b(view));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(1000L);
        animatorSet.setInterpolator(new c(0.0f, 0.0f, 0.58f, 1.0f));
        animatorSet.setTarget(view);
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
    }
}
