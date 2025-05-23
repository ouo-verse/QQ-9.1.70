package com.tencent.luggage.wxa.zf;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.t;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.luggage.wxa.xd.o;
import com.tencent.luggage.wxa.zl.c;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandEmptyPickerView;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class e extends com.tencent.luggage.wxa.zl.b {

    /* renamed from: h, reason: collision with root package name */
    public static t.a f146577h = com.tencent.luggage.wxa.uk.e.f142670b;

    /* renamed from: b, reason: collision with root package name */
    public o f146578b;

    /* renamed from: c, reason: collision with root package name */
    public WeakReference f146579c;

    /* renamed from: d, reason: collision with root package name */
    public int f146580d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f146581e = true;

    /* renamed from: f, reason: collision with root package name */
    public final b f146582f = new b(null);

    /* renamed from: g, reason: collision with root package name */
    public String f146583g;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements c.i {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.zl.c.i
        public void onResult(boolean z16, Object obj) {
            e.this.b().d();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b implements com.tencent.luggage.wxa.zl.d {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference f146585a;

        public b() {
            this.f146585a = null;
        }

        public void a(WeakReference weakReference) {
            this.f146585a = weakReference;
        }

        @Override // com.tencent.luggage.wxa.zl.d
        public void a(boolean z16, View view) {
            w.d("WMPF.KeyBoardNav.MicroMsg.AppBrand.JsApiPickerHandler", "onShowingChanged: isShowing=[%s] pickerView=[%s]", Boolean.valueOf(z16), view);
            WeakReference weakReference = this.f146585a;
            if (weakReference == null || ((com.tencent.luggage.wxa.xd.f) weakReference.get()) == null) {
                return;
            }
            com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(d.class));
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public abstract void b(JSONObject jSONObject);

    public final void d() {
        if (((AppBrandEmptyPickerView) b(AppBrandEmptyPickerView.class)) == null) {
            w.b("MicroMsg.AppBrand.JsApiPickerHandler", "showEmptyView settlePicker returns NULL");
        } else {
            b().setOnResultListener(new a());
            b().j();
        }
    }

    public final void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        WeakReference weakReference = this.f146579c;
        com.tencent.luggage.wxa.xd.f fVar = weakReference == null ? null : (com.tencent.luggage.wxa.xd.f) weakReference.get();
        if (fVar == null) {
            return;
        }
        fVar.a(runnable);
    }

    public void a(JSONObject jSONObject) {
        this.f146583g = jSONObject.optString("headerText");
        b(jSONObject);
    }

    public final void a(o oVar, com.tencent.luggage.wxa.xd.f fVar, JSONObject jSONObject, int i3, boolean z16) {
        this.f146578b = oVar;
        WeakReference weakReference = new WeakReference(fVar);
        this.f146579c = weakReference;
        this.f146582f.a(weakReference);
        this.f146580d = i3;
        a(jSONObject);
    }

    @Override // com.tencent.luggage.wxa.zl.b
    public final View a() {
        try {
            return ((com.tencent.luggage.wxa.xd.f) this.f146579c.get()).getCustomViewContainer().c();
        } catch (NullPointerException unused) {
            w.f("MicroMsg.AppBrand.JsApiPickerHandler", "getInvokerView: return a null invoker view");
            return null;
        }
    }

    public final void a(k0 k0Var) {
        WeakReference weakReference = this.f146579c;
        com.tencent.luggage.wxa.xd.f fVar = weakReference == null ? null : (com.tencent.luggage.wxa.xd.f) weakReference.get();
        if (fVar == null) {
            return;
        }
        k0Var.setContext(fVar).dispatch();
    }

    public final void a(String str, Map map) {
        WeakReference weakReference = this.f146579c;
        if (weakReference == null || weakReference.get() == null || this.f146578b == null) {
            return;
        }
        ((com.tencent.luggage.wxa.xd.f) this.f146579c.get()).a(this.f146580d, this.f146578b.makeReturnJson(str, (Map<String, ? extends Object>) map));
    }

    public final void a(String str) {
        a(str, null);
    }

    @Override // com.tencent.luggage.wxa.zl.b
    public com.tencent.luggage.wxa.zl.a a(Context context) {
        WeakReference weakReference;
        com.tencent.luggage.wxa.xd.f fVar;
        com.tencent.luggage.wxa.zl.a a16 = super.a(context);
        w.a("MicroMsg.AppBrand.JsApiPickerHandler", "createPanel, hook for setOrientationGetter");
        if (a16 != null && (weakReference = this.f146579c) != null && (fVar = (com.tencent.luggage.wxa.xd.f) weakReference.get()) != null) {
            a16.setOrientationGetter(f146577h.a(fVar));
            a16.a((com.tencent.luggage.wxa.zl.d) this.f146582f);
        }
        return a16;
    }

    public static void a(t.a aVar) {
        f146577h = aVar;
    }
}
