package com.tencent.luggage.wxa.ee;

import android.view.View;
import com.tencent.luggage.wxa.ei.p;
import com.tencent.luggage.wxa.nb.a;
import com.tencent.luggage.wxa.tn.w;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d extends e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f124661a = "MicroMsg.BaseUpdateViewJsApi";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f124662a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p f124663b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f124664c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f124665d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ JSONObject f124666e;

        public a(WeakReference weakReference, p pVar, com.tencent.luggage.wxa.xd.d dVar, int i3, JSONObject jSONObject) {
            this.f124662a = weakReference;
            this.f124663b = pVar;
            this.f124664c = dVar;
            this.f124665d = i3;
            this.f124666e = jSONObject;
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0119  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x013c  */
        /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z16;
            View view;
            boolean z17;
            boolean isAsyncCallback;
            com.tencent.luggage.wxa.xd.f fVar = (com.tencent.luggage.wxa.xd.f) this.f124662a.get();
            if (fVar != null && fVar.a(d.this.getName(), this.f124663b)) {
                if (fVar.getCustomViewContainer() == null) {
                    w.f(d.f124661a, "fail, component custom view container is null");
                    this.f124664c.a(this.f124665d, d.this.makeReturnJson("fail:update view failed", com.tencent.luggage.wxa.af.e.f121309e));
                    return;
                }
                try {
                    int viewId = d.this.getViewId(this.f124666e);
                    boolean independent = d.this.getIndependent(this.f124666e);
                    View c16 = fVar.a(independent).c(viewId);
                    if (c16 == null) {
                        w.h(d.f124661a, "get view by viewId(%s) return null.", Integer.valueOf(viewId));
                        this.f124664c.a(this.f124665d, d.this.makeReturnJson("fail:got 'null' when get view by the given viewId", com.tencent.luggage.wxa.af.e.f121309e));
                        return;
                    }
                    if ((c16 instanceof com.tencent.luggage.wxa.ye.b) && this.f124666e.has("draggable")) {
                        com.tencent.luggage.wxa.ye.b bVar = (com.tencent.luggage.wxa.ye.b) c16;
                        bVar.a(d.this.getDraggable(this.f124666e), viewId);
                        bVar.setDragConfig(d.this.getDragConfig(this.f124666e));
                    }
                    d.this.a(fVar, viewId, c16, this.f124666e, independent);
                    try {
                        z16 = true;
                        view = c16;
                        try {
                            z17 = fVar.a(independent).a(viewId, d.this.getPosition(this.f124666e), d.this.getVisibility(this.f124666e), d.this.getFixed(this.f124666e), d.this.getFullScreen(this.f124666e));
                            w.d(d.f124661a, "update view(parentId : %s, viewId : %d), ret : %b", Integer.valueOf(fVar.a(independent).d(viewId)), Integer.valueOf(viewId), Integer.valueOf(view.hashCode()), Boolean.valueOf(z17));
                        } catch (JSONException unused) {
                            z17 = z16;
                            isAsyncCallback = d.this.isAsyncCallback();
                            if (z17) {
                            }
                            if (isAsyncCallback) {
                            }
                        }
                    } catch (JSONException unused2) {
                        z16 = true;
                        view = c16;
                    }
                    isAsyncCallback = d.this.isAsyncCallback();
                    if (z17) {
                        if (isAsyncCallback) {
                            z17 = d.this.a(fVar, viewId, view, this.f124666e, new j(this.f124664c, this.f124665d));
                        } else {
                            z17 = d.this.a(fVar, viewId, view, this.f124666e);
                        }
                    }
                    if (isAsyncCallback) {
                        if (z17) {
                            this.f124664c.a(this.f124665d, d.this.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
                            return;
                        } else {
                            this.f124664c.a(this.f124665d, d.this.makeReturnJson(com.tencent.luggage.wxa.af.e.f121309e));
                            return;
                        }
                    }
                    return;
                } catch (JSONException unused3) {
                    this.f124664c.a(this.f124665d, d.this.makeReturnJson("fail:view id do not exist", com.tencent.luggage.wxa.af.e.f121309e));
                    return;
                }
            }
            w.f(d.f124661a, "page view has been release.");
            this.f124664c.a(this.f124665d, d.this.makeReturnJson("fail:page is null", com.tencent.luggage.wxa.af.e.f121309e));
        }
    }

    public boolean a(com.tencent.luggage.wxa.xd.f fVar, int i3, View view, JSONObject jSONObject) {
        return true;
    }

    public boolean enableGesture() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        invoke(dVar, jSONObject, i3, dVar.getJsRuntime());
    }

    public boolean isAsyncCallback() {
        return false;
    }

    public boolean a(com.tencent.luggage.wxa.xd.f fVar, int i3, View view, JSONObject jSONObject, j jVar) {
        return true;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3, p pVar) {
        com.tencent.luggage.wxa.xd.f componentView = getComponentView(dVar, jSONObject);
        if (componentView == null) {
            dVar.a(i3, makeReturnJson("fail:ComponentView is null.", com.tencent.luggage.wxa.af.e.f121309e));
            return;
        }
        WeakReference weakReference = new WeakReference(componentView);
        beforeOperateFromOriginThread(dVar, jSONObject);
        dVar.a(new a(weakReference, pVar, dVar, i3, jSONObject));
    }

    public final void a(com.tencent.luggage.wxa.xd.f fVar, int i3, View view, JSONObject jSONObject, boolean z16) {
        if (enableGesture()) {
            try {
                a.c a16 = fVar.a(z16).a(i3, false);
                if (a16 != null) {
                    boolean z17 = jSONObject.getBoolean("disableScroll");
                    if (a16.c("isTouching")) {
                        if (a16.a("disableScroll", !z17) != z17) {
                            a16.b("disableScroll-nextState", z17);
                        }
                    } else {
                        a16.b("disableScroll", z17);
                    }
                }
            } catch (JSONException unused) {
            }
        }
    }
}
