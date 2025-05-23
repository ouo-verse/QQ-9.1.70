package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.ee.d;
import com.tencent.luggage.wxa.ee.j;
import com.tencent.luggage.wxa.tk.g;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.f;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.a;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a extends d {
    public static final int CTRL_INDEX = 342;
    public static final String NAME = "animateCoverView";

    /* compiled from: P */
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.coverview.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C7058a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f152084a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AnimatorSet f152085b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j f152086c;

        public C7058a(final f fVar, final AnimatorSet animatorSet, j jVar) {
            this.f152084a = fVar;
            this.f152085b = animatorSet;
            this.f152086c = jVar;
            fVar.a(new Runnable() { // from class: com.tencent.mm.plugin.appbrand.jsapi.coverview.b
                @Override // java.lang.Runnable
                public final void run() {
                    a.C7058a.this.a(fVar, animatorSet, this);
                }
            });
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f152086c.a(a.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(f fVar, final AnimatorSet animatorSet, final AnimatorListenerAdapter animatorListenerAdapter) {
            if (fVar.getLifecycleOwner() != null) {
                fVar.getLifecycleOwner().getLifecycle().addObserver(new LifecycleObserver() { // from class: com.tencent.mm.plugin.appbrand.jsapi.coverview.JsApiAnimateCoverView$1$1
                    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                    public void onDestroyed() {
                        animatorSet.removeListener(animatorListenerAdapter);
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f152088a;

        public b(View view) {
            this.f152088a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Integer num = (Integer) valueAnimator.getAnimatedValue();
            this.f152088a.getLayoutParams().width = num.intValue();
            this.f152088a.requestLayout();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f152090a;

        public c(View view) {
            this.f152090a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Integer num = (Integer) valueAnimator.getAnimatedValue();
            this.f152090a.getLayoutParams().height = num.intValue();
            this.f152090a.requestLayout();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01af  */
    @Override // com.tencent.luggage.wxa.ee.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(f fVar, int i3, View view, JSONObject jSONObject, j jVar) {
        a aVar;
        int i16;
        JSONObject jSONObject2;
        float a16;
        float a17;
        float optDouble;
        float optDouble2;
        float optDouble3;
        float optDouble4;
        int a18;
        int i17;
        TimeInterpolator timeInterpolator;
        boolean z16;
        try {
            jSONObject2 = jSONObject.getJSONObject("finalStyle");
            a16 = g.a(jSONObject2, "left", g.b(view.getX()));
            a17 = g.a(jSONObject2, "top", g.b(view.getY()));
            optDouble = (float) jSONObject2.optDouble("opacity", view.getAlpha());
            optDouble2 = (float) jSONObject2.optDouble(CanvasView.ACTION_ROTATE, view.getRotation());
            optDouble3 = (float) jSONObject2.optDouble(BasicAnimation.KeyPath.SCALE_X, view.getScaleX());
            optDouble4 = (float) jSONObject2.optDouble(BasicAnimation.KeyPath.SCALE_Y, view.getScaleY());
            if (jSONObject2.has("width")) {
                try {
                    a18 = g.a(jSONObject2, "width", g.b(view.getWidth()));
                } catch (JSONException e16) {
                    e = e16;
                    i16 = 1;
                    aVar = this;
                    Object[] objArr = new Object[i16];
                    objArr[0] = Log.getStackTraceString(e);
                    w.h("MicroMsg.JsApiAnimateCoverView", "get finalStyle error : %s", objArr);
                    jVar.a(aVar.makeReturnJson("fail:missing finalStyle"));
                    return false;
                }
            } else {
                a18 = -1;
            }
        } catch (JSONException e17) {
            e = e17;
            aVar = this;
        }
        try {
            if (jSONObject2.has("height")) {
                i17 = g.a(jSONObject2, "height", g.b(view.getWidth()));
            } else {
                i17 = -1;
            }
            int optInt = jSONObject.optInt("duration", 300);
            String optString = jSONObject.optString("easing", CanvasView.ACTION_LINER);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, HippyTKDListViewAdapter.X, view.getX(), a16);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "y", view.getY(), a17);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, view.getAlpha(), optDouble);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.ROTATION, view.getRotation(), optDouble2);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, view.getScaleX(), optDouble3);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, view.getScaleY(), optDouble4);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(optInt);
            if (optString != null) {
                if (optString.equals("ease")) {
                    timeInterpolator = new AccelerateDecelerateInterpolator();
                } else if (optString.equals("ease-in")) {
                    timeInterpolator = new AccelerateInterpolator();
                } else if (optString.equals("ease-out")) {
                    timeInterpolator = new DecelerateInterpolator();
                }
                if (timeInterpolator == null) {
                    timeInterpolator = new LinearInterpolator();
                }
                animatorSet.setInterpolator(timeInterpolator);
                animatorSet.addListener(new C7058a(fVar, animatorSet, jVar));
                ArrayList arrayList = new ArrayList();
                arrayList.add(ofFloat);
                arrayList.add(ofFloat2);
                arrayList.add(ofFloat3);
                arrayList.add(ofFloat4);
                arrayList.add(ofFloat5);
                arrayList.add(ofFloat6);
                if (a18 != -1) {
                    ValueAnimator ofInt = ValueAnimator.ofInt(view.getWidth(), a18);
                    arrayList.add(ofInt);
                    ofInt.addUpdateListener(new b(view));
                }
                if (i17 == -1) {
                    z16 = true;
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(view.getHeight(), i17);
                    arrayList.add(ofInt2);
                    ofInt2.addUpdateListener(new c(view));
                } else {
                    z16 = true;
                }
                animatorSet.playTogether(arrayList);
                animatorSet.start();
                return z16;
            }
            timeInterpolator = null;
            if (timeInterpolator == null) {
            }
            animatorSet.setInterpolator(timeInterpolator);
            animatorSet.addListener(new C7058a(fVar, animatorSet, jVar));
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(ofFloat);
            arrayList2.add(ofFloat2);
            arrayList2.add(ofFloat3);
            arrayList2.add(ofFloat4);
            arrayList2.add(ofFloat5);
            arrayList2.add(ofFloat6);
            if (a18 != -1) {
            }
            if (i17 == -1) {
            }
            animatorSet.playTogether(arrayList2);
            animatorSet.start();
            return z16;
        } catch (JSONException e18) {
            e = e18;
            aVar = this;
            i16 = 1;
            Object[] objArr2 = new Object[i16];
            objArr2[0] = Log.getStackTraceString(e);
            w.h("MicroMsg.JsApiAnimateCoverView", "get finalStyle error : %s", objArr2);
            jVar.a(aVar.makeReturnJson("fail:missing finalStyle"));
            return false;
        }
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.getInt("viewId");
    }

    @Override // com.tencent.luggage.wxa.ee.d
    public boolean isAsyncCallback() {
        return true;
    }
}
