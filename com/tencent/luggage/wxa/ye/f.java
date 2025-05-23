package com.tencent.luggage.wxa.ye;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.tencent.luggage.wxa.nb.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.luggage.wxa.ye.b;
import com.tencent.luggage.wxa.ye.h;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class f extends com.tencent.luggage.wxa.ee.b {
    private static final int CTRL_INDEX = 253;
    public static final String NAME = "insertImageView";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.c f145576a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.f f145577b;

        public a(a.c cVar, com.tencent.luggage.wxa.xd.f fVar) {
            this.f145576a = cVar;
            this.f145577b = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            w.d("MicroMsg.JsApiInsertImageView", NodeProps.ON_CLICK);
            e eVar = new e(null);
            HashMap hashMap = new HashMap();
            hashMap.put("data", this.f145576a.a("data", ""));
            eVar.setData(hashMap);
            if ("webview".equals(this.f145576a.a("sendTo", (String) null))) {
                this.f145577b.a(eVar);
            } else {
                this.f145577b.a(eVar, (int[]) null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.c f145579a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.f f145580b;

        public b(a.c cVar, com.tencent.luggage.wxa.xd.f fVar) {
            this.f145579a = cVar;
            this.f145580b = fVar;
        }

        @Override // com.tencent.luggage.wxa.ye.b.a
        public void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
            h.f fVar = new h.f();
            HashMap hashMap = new HashMap();
            hashMap.put("data", str2);
            hashMap.put("stage", str);
            hashMap.put("drag", jSONObject);
            hashMap.put("target", jSONObject2);
            fVar.setData(hashMap);
            w.d("MicroMsg.JsApiInsertImageView", "callback stage:%s, drag:%s, data:%s, target:%s", str, jSONObject, str2, jSONObject2);
            if ("webview".equals(this.f145579a.a("sendTo", (String) null))) {
                this.f145580b.a(fVar);
            } else {
                this.f145580b.a(fVar, (int[]) null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.c f145582a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.f f145583b;

        public c(a.c cVar, com.tencent.luggage.wxa.xd.f fVar) {
            this.f145582a = cVar;
            this.f145583b = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!this.f145582a.c("clickable")) {
                return;
            }
            e eVar = new e(null);
            HashMap hashMap = new HashMap();
            hashMap.put("data", this.f145582a.a("data", ""));
            eVar.setData(hashMap);
            eVar.setContext(this.f145583b);
            if ("webview".equals(this.f145582a.a("sendTo", (String) null))) {
                this.f145583b.a(eVar);
            } else {
                this.f145583b.a(eVar, (int[]) null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.c f145585a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.f f145586b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f145587c;

        public d(a.c cVar, com.tencent.luggage.wxa.xd.f fVar, int i3) {
            this.f145585a = cVar;
            this.f145586b = fVar;
            this.f145587c = i3;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            com.tencent.luggage.wxa.ye.e.a(this.f145586b, view, this.f145587c, motionEvent, this.f145585a.a("data", ""), "webview".equals(this.f145585a.a("sendTo", (String) null)));
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class e extends k0 {
        private static final int CTRL_INDEX = 256;
        private static final String NAME = "onImageViewClick";

        public e() {
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.getInt("viewId");
    }

    @Override // com.tencent.luggage.wxa.ee.b
    public View inflateView(com.tencent.luggage.wxa.xd.f fVar, JSONObject jSONObject) {
        Context context = fVar.getContext();
        if (com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.nl.b.class) == null) {
            w.b("MicroMsg.JsApiInsertImageView", "view is null, may not support IGifCoverViewFactory.");
            com.tencent.luggage.wxa.nl.e eVar = new com.tencent.luggage.wxa.nl.e(context);
            eVar.setScaleType(ImageView.ScaleType.FIT_XY);
            return new com.tencent.luggage.wxa.ye.b(context, eVar.getView());
        }
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.nl.b.class));
        throw null;
    }

    @Override // com.tencent.luggage.wxa.ee.b
    public void onInsertView(com.tencent.luggage.wxa.xd.f fVar, int i3, View view, JSONObject jSONObject) {
        boolean z16;
        String str;
        w.a("MicroMsg.JsApiInsertImageView", "onInsertView(viewId : %s, %s)", Integer.valueOf(i3), jSONObject);
        com.tencent.luggage.wxa.ye.b bVar = (com.tencent.luggage.wxa.ye.b) view;
        com.tencent.luggage.wxa.nl.a aVar = (com.tencent.luggage.wxa.nl.a) bVar.a(com.tencent.luggage.wxa.nl.a.class);
        if (aVar == null) {
            w.h("MicroMsg.JsApiInsertImageView", "onInsertView(viewId : %d) failed, targetView is null", Integer.valueOf(i3));
            return;
        }
        boolean optBoolean = jSONObject.optBoolean("clickable");
        boolean optBoolean2 = jSONObject.optBoolean("gesture");
        boolean draggable = getDraggable(jSONObject);
        boolean optBoolean3 = jSONObject.optBoolean("transEvt");
        String optString = jSONObject.optString("sendTo", "appservice");
        String a16 = com.tencent.luggage.wxa.qn.a.a(jSONObject, "data");
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        a.c a17 = fVar.a(getIndependent(jSONObject)).a(i3, true);
        a17.b("data", (Object) a16);
        a17.b("sendTo", (Object) optString);
        a17.b("transEvt", Boolean.valueOf(optBoolean3));
        a17.b("clickable", Boolean.valueOf(optBoolean));
        aVar.setKeyValueSet(a17);
        com.tencent.luggage.wxa.gh.f.a(view, optJSONObject);
        com.tencent.luggage.wxa.gh.c.a(fVar, i3, aVar, jSONObject, new com.tencent.luggage.wxa.ye.d(i3, a17, fVar));
        com.tencent.luggage.wxa.gh.b.a(aVar.getView(), jSONObject);
        boolean independent = getIndependent(jSONObject);
        int i16 = -1;
        if (independent) {
            int parentId = getParentId(jSONObject);
            if (parentId == 0) {
                str = "appservice";
                z16 = false;
            } else {
                boolean b16 = fVar.a(independent).b(parentId);
                str = "appservice";
                i16 = fVar.a(independent).i(parentId);
                z16 = b16;
            }
            a17.b("sendTo", str);
        } else {
            z16 = false;
        }
        w.d("MicroMsg.JsApiInsertImageView", "clickable:%b, gesture:%b, draggable:%b\uff0c independent:%b, isParentCanDrag:%b", Boolean.valueOf(optBoolean), Boolean.valueOf(optBoolean2), Boolean.valueOf(draggable), Boolean.valueOf(independent), Boolean.valueOf(z16));
        if (independent && (z16 || draggable)) {
            w.d("MicroMsg.JsApiInsertImageView", "CoverViewContainer setOnClickListener");
            if (optBoolean) {
                bVar.b(i3, i16);
                bVar.setIsInterceptEvent(true);
                bVar.setOnCustomerClickListener(new a(a17, fVar));
            }
            bVar.setDragEventCallback(new b(a17, fVar));
        } else {
            w.d("MicroMsg.JsApiInsertImageView", "targetView setOnClickListener");
            aVar.getView().setOnClickListener(new c(a17, fVar));
            aVar.getView().setClickable(optBoolean);
        }
        w.d("MicroMsg.JsApiInsertImageView", "clickable:%b, gesture:%b, draggable:%b", Boolean.valueOf(optBoolean), Boolean.valueOf(optBoolean2), Boolean.valueOf(draggable));
        if (!optBoolean && optBoolean2 && !draggable) {
            view.setDuplicateParentStateEnabled(true);
            aVar.getView().setDuplicateParentStateEnabled(true);
            aVar.getView().setOnTouchListener(new d(a17, fVar, i3));
        }
    }
}
