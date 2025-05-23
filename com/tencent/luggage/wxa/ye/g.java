package com.tencent.luggage.wxa.ye;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.wxa.nb.a;
import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class g extends com.tencent.luggage.wxa.ee.b {
    private static final int CTRL_INDEX = 446;
    public static final String NAME = "insertScrollView";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements q {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.f f145589a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f145590b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f145591c;

        public a(com.tencent.luggage.wxa.xd.f fVar, boolean z16, int i3) {
            this.f145589a = fVar;
            this.f145590b = z16;
            this.f145591c = i3;
        }

        @Override // com.tencent.luggage.wxa.ye.q
        public void a(View view, int i3, int i16, int i17, int i18) {
            a.c a16;
            String a17;
            if (!(view instanceof t) || (a16 = this.f145589a.a(this.f145590b).a(this.f145591c, false)) == null || (a17 = a16.a("data", (String) null)) == null) {
                return;
            }
            ViewGroup targetView = ((t) view).getTargetView();
            HashMap hashMap = new HashMap();
            hashMap.put("data", a17);
            hashMap.put("scrollLeft", Integer.valueOf(com.tencent.luggage.wxa.tk.g.b(i3)));
            hashMap.put("scrollTop", Integer.valueOf(com.tencent.luggage.wxa.tk.g.b(i16)));
            hashMap.put("scrollWidth", Integer.valueOf(com.tencent.luggage.wxa.tk.g.b(targetView.getWidth())));
            hashMap.put("scrollHeight", Integer.valueOf(com.tencent.luggage.wxa.tk.g.b(targetView.getHeight())));
            this.f145589a.a(new p().setData(hashMap), (int[]) null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f145593a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f145594b;

        public b(t tVar, int i3) {
            this.f145593a = tVar;
            this.f145594b = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            t tVar = this.f145593a;
            tVar.scrollTo(tVar.getScrollX(), this.f145594b);
        }
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.getInt("viewId");
    }

    @Override // com.tencent.luggage.wxa.ee.b
    public View inflateView(com.tencent.luggage.wxa.xd.f fVar, JSONObject jSONObject) {
        return new t(fVar.getContext());
    }

    @Override // com.tencent.luggage.wxa.ee.b
    public void onInsertView(com.tencent.luggage.wxa.xd.f fVar, int i3, View view, JSONObject jSONObject) {
        w.a("MicroMsg.JsApiInsertScrollView", "onInsertView(viewId : %s, %s)", Integer.valueOf(i3), jSONObject);
        t tVar = (t) view;
        boolean optBoolean = jSONObject.optBoolean("needScrollEvent");
        String a16 = com.tencent.luggage.wxa.qn.a.a(jSONObject, "data");
        com.tencent.luggage.wxa.gh.f.a(view, jSONObject.optJSONObject("style"));
        boolean independent = getIndependent(jSONObject);
        fVar.a(independent).a(i3, true).b("data", (Object) a16);
        if (optBoolean) {
            tVar.setOnScrollChangedListener(new a(fVar, independent, i3));
        }
        jSONObject.optInt("scrollLeft", 0);
        if (jSONObject.has("scrollX")) {
            boolean optBoolean2 = jSONObject.optBoolean("scrollX", true);
            w.d("MicroMsg.JsApiInsertScrollView", "scrollHorizontal:%b", Boolean.valueOf(optBoolean2));
            tVar.setScrollHorizontal(optBoolean2);
        }
        if (jSONObject.has("scrollY")) {
            boolean optBoolean3 = jSONObject.optBoolean("scrollY", true);
            w.d("MicroMsg.JsApiInsertScrollView", "scrollVertical:%b", Boolean.valueOf(optBoolean3));
            tVar.setScrollVertical(optBoolean3);
        }
        if (jSONObject.has("scrollTop")) {
            int a17 = com.tencent.luggage.wxa.tk.g.a(jSONObject, "scrollTop", tVar.getScrollY());
            w.d("MicroMsg.JsApiInsertScrollView", "scrollTop:%d", Integer.valueOf(a17));
            tVar.postDelayed(new b(tVar, a17), 100L);
        }
    }
}
