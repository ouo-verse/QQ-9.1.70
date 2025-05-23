package com.tencent.luggage.wxa.ef;

import android.app.Activity;
import android.content.Context;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends com.tencent.luggage.wxa.xd.a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f124670a;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ef.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6162a implements LuggageActivityHelper.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f124671a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f124672b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f124673c;

        public C6162a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
            this.f124671a = dVar;
            this.f124672b = jSONObject;
            this.f124673c = i3;
        }

        @Override // com.tencent.luggage.util.LuggageActivityHelper.h
        public void a(String[] strArr, int[] iArr) {
            if (iArr != null && iArr.length > 0 && iArr[0] == 0) {
                w.d("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "PERMISSION_GRANTED, do invoke again");
                a.this.invoke(this.f124671a, this.f124672b, this.f124673c);
            } else {
                w.b("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "SYS_PERM_DENIED");
                a.this.f124670a = true;
                this.f124671a.a(this.f124673c, a.this.makeReturnJson("fail:system permission denied"));
            }
        }
    }

    public abstract void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3);

    public final boolean b(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        if (b(dVar)) {
            return true;
        }
        if (this.f124670a) {
            dVar.a(i3, makeReturnJson("fail:system permission denied"));
            return false;
        }
        Activity activity = dVar.getContext() instanceof Activity ? (Activity) dVar.getContext() : null;
        if (activity == null) {
            w.b("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "operateRecorder, pageContext is null");
            dVar.a(i3, makeReturnJson("fail:internal error invalid android context"));
            return false;
        }
        return LuggageActivityHelper.FOR(activity).checkRequestPermission(dVar, "android.permission.ACCESS_FINE_LOCATION", new C6162a(dVar, jSONObject, i3));
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        if (!b(dVar, jSONObject, i3)) {
            w.b("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "%s requestPermission fail", getName());
        } else if (jSONObject == null) {
            w.b("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "%s invalid data", getName());
            dVar.a(i3, makeReturnJson("fail:invalid data"));
        } else {
            a(dVar, jSONObject, i3);
        }
    }

    public final boolean b(com.tencent.luggage.wxa.xd.d dVar) {
        Context context = dVar.getContext();
        if (context == null) {
            context = z.c();
        }
        return com.tencent.luggage.wxa.h6.k.a(context, dVar, "android.permission.ACCESS_FINE_LOCATION");
    }
}
