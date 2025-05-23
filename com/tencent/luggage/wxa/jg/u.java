package com.tencent.luggage.wxa.jg;

import android.app.Activity;
import android.content.Context;
import android.view.WindowManager;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class u extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 229;
    public static final String NAME = "setScreenBrightness";

    /* renamed from: a, reason: collision with root package name */
    public float f131127a = Float.NaN;

    /* renamed from: b, reason: collision with root package name */
    public float f131128b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f131129a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f131130b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f131131c;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.jg.u$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6339a extends e.c {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ WindowManager.LayoutParams f131133a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Activity f131134b;

            public C6339a(WindowManager.LayoutParams layoutParams, Activity activity) {
                this.f131133a = layoutParams;
                this.f131134b = activity;
            }

            @Override // com.tencent.luggage.wxa.ic.e.c
            public void onPause(e.d dVar) {
                this.f131133a.screenBrightness = u.this.f131127a;
                Activity activity = this.f131134b;
                if (activity != null && !activity.isFinishing() && this.f131134b.getWindow() != null) {
                    this.f131134b.getWindow().setAttributes(this.f131133a);
                }
            }

            @Override // com.tencent.luggage.wxa.ic.e.c
            public void onResume() {
                this.f131133a.screenBrightness = u.this.f131128b;
                Activity activity = this.f131134b;
                if (activity != null && !activity.isFinishing() && this.f131134b.getWindow() != null) {
                    this.f131134b.getWindow().setAttributes(this.f131133a);
                }
            }
        }

        public a(JSONObject jSONObject, com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f131129a = jSONObject;
            this.f131130b = dVar;
            this.f131131c = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            float f16;
            u.this.f131128b = (float) this.f131129a.optDouble("value");
            Object[] objArr = new Object[2];
            objArr[0] = Float.valueOf(u.this.f131128b);
            if (!Float.isNaN(u.this.f131127a)) {
                f16 = u.this.f131127a;
            } else {
                f16 = -100.0f;
            }
            objArr[1] = Float.valueOf(f16);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiSetScreenBrightness", "set brightness: %f, system brightness: %f", objArr);
            if (!Float.isNaN(u.this.f131128b) && ((u.this.f131128b >= 0.0f || ((int) u.this.f131128b) == -1) && u.this.f131128b <= 1.0f)) {
                Context context = this.f131130b.getContext();
                if (context == null) {
                    this.f131130b.a(this.f131131c, u.this.makeReturnJson("fail"));
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSetScreenBrightness", "context is null, invoke fail!");
                    return;
                }
                if (!(this.f131130b.getContext() instanceof Activity)) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSetScreenBrightness", "setScreenBrightness, server context is not activity, don't do invoke");
                    this.f131130b.a(this.f131131c, u.this.makeReturnJson("fail:context is not activity"));
                    return;
                }
                Activity activity = (Activity) context;
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                if (Float.isNaN(u.this.f131127a)) {
                    u.this.f131127a = attributes.screenBrightness;
                    com.tencent.luggage.wxa.ic.e.a(this.f131130b.getAppId(), new C6339a(attributes, activity));
                }
                if (((int) u.this.f131128b) == -1) {
                    attributes.screenBrightness = -1.0f;
                } else {
                    attributes.screenBrightness = Math.max(u.this.f131128b, 0.01f);
                }
                activity.getWindow().setAttributes(attributes);
                this.f131130b.a(this.f131131c, u.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
                return;
            }
            this.f131130b.a(this.f131131c, u.this.makeReturnJson("fail:value invalid"));
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSetScreenBrightness", "value invalid");
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.JsApiSetScreenBrightness", "JsApiSetScreenBrightness!");
        if (jSONObject == null) {
            dVar.a(i3, makeReturnJson("fail:data is null"));
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSetScreenBrightness", "data is null");
        } else if (!(dVar.getContext() instanceof Activity)) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSetScreenBrightness", "setScreenBrightness, server context is not activity, don't do invoke");
            dVar.a(i3, makeReturnJson("fail:context is not activity"));
        } else {
            com.tencent.luggage.wxa.tn.c0.a(new a(jSONObject, dVar, i3));
        }
    }
}
