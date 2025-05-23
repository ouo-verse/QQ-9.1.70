package com.tencent.luggage.wxa.ee;

import android.view.View;
import com.tencent.luggage.wxa.ei.p;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c extends e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f124655a = "MicroMsg.BaseRemoveViewJsApi";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f124656a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p f124657b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f124658c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f124659d;

        public a(com.tencent.luggage.wxa.xd.d dVar, p pVar, JSONObject jSONObject, int i3) {
            this.f124656a = dVar;
            this.f124657b = pVar;
            this.f124658c = jSONObject;
            this.f124659d = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a(this.f124656a, this.f124657b, this.f124658c, this.f124659d);
        }
    }

    public boolean a(com.tencent.luggage.wxa.xd.f fVar, int i3, View view, JSONObject jSONObject) {
        return true;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        invoke(dVar, jSONObject, i3, dVar.getJsRuntime());
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3, p pVar) {
        beforeOperateFromOriginThread(dVar, jSONObject);
        if (c0.b()) {
            a(dVar, pVar, jSONObject, i3);
        } else {
            c0.a(new a(dVar, pVar, jSONObject, i3));
        }
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, p pVar, JSONObject jSONObject, int i3) {
        boolean z16;
        if (!dVar.a(getName(), pVar)) {
            dVar.a(i3, "fail:interrupted");
            return;
        }
        com.tencent.luggage.wxa.xd.f componentView = getComponentView(dVar, jSONObject);
        if (componentView == null) {
            w.h(f124655a, "invoke JsApi(%s) failed, component view is null", getName());
            dVar.a(i3, makeReturnJson("fail:ComponentView is null.", com.tencent.luggage.wxa.af.e.f121309e));
            return;
        }
        if (componentView.getCustomViewContainer() == null) {
            w.f(f124655a, "fail, component custom view container is null");
            dVar.a(i3, makeReturnJson("fail:remove view failed", com.tencent.luggage.wxa.af.e.f121309e));
            return;
        }
        try {
            int viewId = getViewId(jSONObject);
            boolean independent = getIndependent(jSONObject);
            View c16 = componentView.a(independent).c(viewId);
            if ((c16 instanceof com.tencent.luggage.wxa.ye.b) && jSONObject.has("draggable") && getDraggable(jSONObject)) {
                ((com.tencent.luggage.wxa.ye.b) c16).a(viewId);
            }
            if (componentView.a(independent).g(viewId)) {
                z16 = componentView.a(independent).f(viewId);
                if (z16) {
                    z16 = a(componentView, viewId, c16, jSONObject);
                }
            } else {
                z16 = false;
            }
            if (z16) {
                componentView.a(independent).h(viewId);
            }
            w.d(f124655a, "remove view(parentId : %s, viewId : %s, r : %s)", Integer.valueOf(getParentId(jSONObject)), Integer.valueOf(viewId), Boolean.valueOf(z16));
            dVar.a(i3, makeReturnJson(z16 ? com.tencent.luggage.wxa.af.e.f121305a : com.tencent.luggage.wxa.af.e.f121309e));
        } catch (JSONException e16) {
            w.b(f124655a, "get viewId error. exception : %s", e16);
            dVar.a(i3, makeReturnJson("fail:view id do not exist", com.tencent.luggage.wxa.af.e.f121309e));
        }
    }
}
