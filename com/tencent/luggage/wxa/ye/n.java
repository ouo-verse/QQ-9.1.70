package com.tencent.luggage.wxa.ye;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.wxa.nb.a;
import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class n extends com.tencent.luggage.wxa.ee.d {
    private static final int CTRL_INDEX = 447;
    public static final String NAME = "updateScrollView";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements q {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.f f145611a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f145612b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f145613c;

        public a(com.tencent.luggage.wxa.xd.f fVar, JSONObject jSONObject, int i3) {
            this.f145611a = fVar;
            this.f145612b = jSONObject;
            this.f145613c = i3;
        }

        @Override // com.tencent.luggage.wxa.ye.q
        public void a(View view, int i3, int i16, int i17, int i18) {
            a.c a16;
            String a17;
            if (!(view instanceof t) || (a16 = this.f145611a.a(n.this.getIndependent(this.f145612b)).a(this.f145613c, false)) == null || (a17 = a16.a("data", (String) null)) == null) {
                return;
            }
            ViewGroup targetView = ((t) view).getTargetView();
            HashMap hashMap = new HashMap();
            hashMap.put("data", a17);
            hashMap.put("scrollLeft", Integer.valueOf(com.tencent.luggage.wxa.tk.g.b(i3)));
            hashMap.put("scrollTop", Integer.valueOf(com.tencent.luggage.wxa.tk.g.b(i16)));
            hashMap.put("scrollWidth", Integer.valueOf(com.tencent.luggage.wxa.tk.g.b(targetView.getWidth())));
            hashMap.put("scrollHeight", Integer.valueOf(com.tencent.luggage.wxa.tk.g.b(targetView.getHeight())));
            this.f145611a.a(new p().setData(hashMap), (int[]) null);
        }
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.getInt("viewId");
    }

    @Override // com.tencent.luggage.wxa.ee.d
    public boolean a(com.tencent.luggage.wxa.xd.f fVar, int i3, View view, JSONObject jSONObject) {
        w.a("MicroMsg.JsApiUpdateScrollView", "onUpdateView(viewId : %s, %s)", Integer.valueOf(i3), jSONObject);
        if (!(view instanceof t)) {
            w.h("MicroMsg.JsApiUpdateScrollView", "the view(%s) is not a instance of WxaScrollView", Integer.valueOf(i3));
            return false;
        }
        t tVar = (t) view;
        com.tencent.luggage.wxa.gh.f.a(view, jSONObject.optJSONObject("style"));
        try {
            if (jSONObject.getBoolean("needScrollEvent")) {
                tVar.setOnScrollChangedListener(new a(fVar, jSONObject, i3));
            } else {
                tVar.setOnScrollChangedListener(null);
            }
        } catch (JSONException unused) {
        }
        jSONObject.optInt("scrollLeft", 0);
        if (jSONObject.has("scrollX")) {
            boolean optBoolean = jSONObject.optBoolean("scrollX", true);
            w.d("MicroMsg.JsApiUpdateScrollView", "scrollHorizontal:%b", Boolean.valueOf(optBoolean));
            tVar.setScrollHorizontal(optBoolean);
        }
        if (jSONObject.has("scrollY")) {
            boolean optBoolean2 = jSONObject.optBoolean("scrollY", true);
            w.d("MicroMsg.JsApiUpdateScrollView", "scrollVertical:%b", Boolean.valueOf(optBoolean2));
            tVar.setScrollVertical(optBoolean2);
        }
        if (jSONObject.has("scrollTop")) {
            int a16 = com.tencent.luggage.wxa.tk.g.a(jSONObject, "scrollTop", tVar.getScrollY());
            w.d("MicroMsg.JsApiUpdateScrollView", "scrollTop:%d", Integer.valueOf(a16));
            tVar.scrollTo(tVar.getScrollX(), a16);
        }
        return super.a(fVar, i3, view, jSONObject);
    }
}
