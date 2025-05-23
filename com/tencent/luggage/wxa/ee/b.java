package com.tencent.luggage.wxa.ee;

import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ei.p;
import com.tencent.luggage.wxa.nb.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.f;
import com.tencent.luggage.wxa.xd.g;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b extends e {
    public static final String KEY_BASE_VIEW_DESTROY_LISTENER = "baseViewDestroyListener";
    private static final String TAG = "MicroMsg.BaseInsertViewJsApi";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.f f124645a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p f124646b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j f124647c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f124648d;

        public a(com.tencent.luggage.wxa.xd.f fVar, p pVar, j jVar, JSONObject jSONObject) {
            this.f124645a = fVar;
            this.f124646b = pVar;
            this.f124647c = jVar;
            this.f124648d = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            if (!this.f124645a.a(b.this.getName(), this.f124646b)) {
                w.f(b.TAG, "fail, component is not running");
                return;
            }
            if (this.f124645a.getCustomViewContainer() == null) {
                w.f(b.TAG, "fail, component custom view container is null");
                this.f124647c.a(b.this.makeReturnJson("fail:insert view failed", com.tencent.luggage.wxa.af.e.f121309e));
                return;
            }
            try {
                int viewId = b.this.getViewId(this.f124648d);
                View inflateView = b.this.inflateView(this.f124645a, this.f124648d, viewId);
                if (inflateView == null) {
                    w.f(b.TAG, "inflate view return null.");
                    this.f124647c.a(b.this.makeReturnJson("fail:inflate view failed", com.tencent.luggage.wxa.af.e.f121309e));
                    return;
                }
                boolean independent = b.this.getIndependent(this.f124648d);
                if ((inflateView instanceof com.tencent.luggage.wxa.ye.b) && this.f124648d.has("draggable")) {
                    com.tencent.luggage.wxa.ye.b bVar = (com.tencent.luggage.wxa.ye.b) inflateView;
                    bVar.a(b.this.getDraggable(this.f124648d), viewId, com.tencent.luggage.wxa.qn.a.a(this.f124648d, "data"));
                    bVar.setDragConfig(b.this.getDragConfig(this.f124648d));
                }
                if (this.f124645a.a(independent).g(viewId)) {
                    w.h(b.TAG, "insert view(%d) failed, it has been inserted before.", Integer.valueOf(viewId));
                    this.f124647c.a(b.this.makeReturnJson("fail:the view has already exist", com.tencent.luggage.wxa.af.e.f121309e));
                    return;
                }
                int parentId = b.this.getParentId(this.f124648d);
                try {
                    float[] position = b.this.getPosition(this.f124648d);
                    int visibility = b.this.getVisibility(this.f124648d);
                    Boolean fixed = b.this.getFixed(this.f124648d);
                    Boolean fullScreen = b.this.getFullScreen(this.f124648d);
                    Boolean underView = b.this.getUnderView(this.f124648d);
                    f.a a16 = this.f124645a.a(independent);
                    if (fixed != null && fixed.booleanValue()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (fullScreen != null && fullScreen.booleanValue()) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (underView != null && underView.booleanValue()) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    z16 = a16.a(inflateView, viewId, parentId, position, visibility, z17, z18, z19);
                } catch (JSONException e16) {
                    w.b(b.TAG, "parse position error. Exception :%s", e16);
                    z16 = false;
                }
                boolean isAsyncCallback = b.this.isAsyncCallback();
                if (z16) {
                    b.this.a(this.f124645a, viewId, inflateView, this.f124648d, independent);
                    if (isAsyncCallback) {
                        b.this.onInsertViewWithAsyncCallback(this.f124645a, viewId, inflateView, this.f124648d, this.f124647c);
                    } else {
                        b.this.onInsertView(this.f124645a, viewId, inflateView, this.f124648d);
                    }
                }
                b.this.a(this.f124645a, viewId, independent);
                w.d(b.TAG, "insert view(parentId : %s, viewId : %s, view : %s, r : %s)", Integer.valueOf(parentId), Integer.valueOf(viewId), Integer.valueOf(inflateView.hashCode()), Boolean.valueOf(z16));
                if (!isAsyncCallback) {
                    if (z16) {
                        this.f124647c.a(b.this.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
                    } else {
                        this.f124647c.a(b.this.makeReturnJson("fail:insert view fail", com.tencent.luggage.wxa.af.e.f121309e));
                    }
                }
            } catch (JSONException unused) {
                this.f124647c.a(b.this.makeReturnJson("fail:invalid view id", com.tencent.luggage.wxa.af.e.f121309e));
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ee.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6161b implements g.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.f f124650a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f124651b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f124652c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a.c f124653d;

        public C6161b(com.tencent.luggage.wxa.xd.f fVar, boolean z16, int i3, a.c cVar) {
            this.f124650a = fVar;
            this.f124651b = z16;
            this.f124652c = i3;
            this.f124653d = cVar;
        }

        @Override // com.tencent.luggage.wxa.xd.g.c
        public void onDestroy() {
            this.f124650a.a(this.f124651b).h(this.f124652c);
            this.f124653d.b();
            System.gc();
        }
    }

    public final void a(com.tencent.luggage.wxa.xd.f fVar, p pVar, JSONObject jSONObject, j jVar) {
        beforeOperateFromOriginThread(fVar, jSONObject);
        fVar.a(new a(fVar, pVar, jVar, jSONObject));
    }

    public boolean enableGesture() {
        return false;
    }

    public boolean enableLongClick() {
        return false;
    }

    @Nullable
    public View inflateView(com.tencent.luggage.wxa.xd.f fVar, JSONObject jSONObject, int i3) {
        return inflateView(fVar, jSONObject);
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        invoke(dVar, jSONObject, i3, dVar.getJsRuntime());
    }

    public boolean isAsyncCallback() {
        return false;
    }

    public View inflateView(com.tencent.luggage.wxa.xd.f fVar, JSONObject jSONObject) {
        throw new IllegalStateException("inflateView must be inflated." + this);
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3, p pVar) {
        com.tencent.luggage.wxa.xd.f componentView = getComponentView(dVar, jSONObject);
        if (componentView == null) {
            w.h(TAG, "invoke JsApi(%s) failed, component view is null", getName());
            dVar.a(i3, makeReturnJson("fail:ComponentView is null.", com.tencent.luggage.wxa.af.e.f121309e));
        } else {
            a(componentView, pVar, jSONObject, new j(dVar, i3));
        }
    }

    public final void a(com.tencent.luggage.wxa.xd.f fVar, int i3, View view, JSONObject jSONObject, boolean z16) {
        if (enableGesture()) {
            a.c a16 = fVar.a(z16).a(i3, true);
            a16.b("disableScroll", jSONObject.optBoolean("disableScroll", false));
            a16.b("enableLongClick", enableLongClick());
            a16.b("data", com.tencent.luggage.wxa.qn.a.a(jSONObject, "data"));
            if (jSONObject.optBoolean("gesture", false)) {
                com.tencent.luggage.wxa.gh.e.a(fVar, view, a16);
            }
        }
    }

    public final void a(com.tencent.luggage.wxa.xd.f fVar, int i3, boolean z16) {
        a.c a16 = fVar.a(z16).a(i3, true);
        if (((g.c) a16.a(KEY_BASE_VIEW_DESTROY_LISTENER, (Object) null)) == null) {
            C6161b c6161b = new C6161b(fVar, z16, i3, a16);
            a16.b(KEY_BASE_VIEW_DESTROY_LISTENER, c6161b);
            fVar.a(c6161b);
        }
    }

    public void onInsertViewWithAsyncCallback(com.tencent.luggage.wxa.xd.f fVar, int i3, View view, JSONObject jSONObject, j jVar) {
    }

    public void onInsertView(com.tencent.luggage.wxa.xd.f fVar, int i3, View view, JSONObject jSONObject) {
    }
}
