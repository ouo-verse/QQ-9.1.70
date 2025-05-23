package com.tencent.mm.plugin.appbrand.jsapi.sensor;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.luggage.wxa.fg.g;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.h0;
import com.tencent.luggage.wxa.xd.d;
import com.tencent.luggage.wxa.xd.v;
import com.tencent.luggage.wxa.zp.h;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class JsApiEnableDeviceOrientation extends v {
    public static final int CTRL_INDEX = 472;
    public static final String NAME = "enableDeviceOrientationChangeListening";

    /* renamed from: a, reason: collision with root package name */
    public boolean f152145a = false;

    /* renamed from: b, reason: collision with root package name */
    public h0 f152146b;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a implements h0.b {

        /* renamed from: a, reason: collision with root package name */
        public final String f152150a;

        /* compiled from: P */
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.sensor.JsApiEnableDeviceOrientation$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC7062a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ h0.a f152151a;

            public RunnableC7062a(h0.a aVar) {
                this.f152151a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                g a16 = g.a(a.this.f152150a, false);
                if (a16 != null) {
                    a16.a(this.f152151a);
                }
            }
        }

        public a(String str) {
            this.f152150a = str;
        }

        @Override // com.tencent.luggage.wxa.uk.h0.b
        public void onFourOrientationsChange(h0.a aVar, h0.a aVar2) {
            w.d("MicroMsg.JsApiEnableDeviceOrientation", "OrientationListener lastOrientation:" + aVar.name() + "; newOrientation:" + aVar2.name());
            c0.a(new RunnableC7062a(aVar2), 500L);
        }
    }

    public final void b(d dVar) {
        if (!this.f152145a) {
            h0 h0Var = new h0(dVar.getContext(), new a(dVar.getAppId()));
            this.f152146b = h0Var;
            h0Var.enable();
            this.f152145a = true;
            final LifecycleOwner lifecycleOwner = dVar.getLifecycleOwner();
            if (lifecycleOwner != null) {
                h.f146825d.a(new Runnable() { // from class: com.tencent.mm.plugin.appbrand.jsapi.sensor.JsApiEnableDeviceOrientation.1
                    @Override // java.lang.Runnable
                    public void run() {
                        lifecycleOwner.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.tencent.mm.plugin.appbrand.jsapi.sensor.JsApiEnableDeviceOrientation.1.1
                            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                            public void onDestroyed() {
                                JsApiEnableDeviceOrientation.this.e();
                            }
                        });
                    }
                });
            }
        }
    }

    public final void e() {
        if (this.f152145a) {
            this.f152146b.disable();
            this.f152146b = null;
            this.f152145a = false;
        }
    }

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(d dVar, JSONObject jSONObject) {
        if (jSONObject.optBoolean("enable", false)) {
            g.a(dVar);
            b(dVar);
        } else {
            g.d(dVar);
            e();
        }
        return makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
    }
}
