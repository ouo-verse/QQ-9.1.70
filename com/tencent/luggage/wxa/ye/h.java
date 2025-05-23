package com.tencent.luggage.wxa.ye;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.luggage.wxa.nb.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.luggage.wxa.ye.b;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class h extends com.tencent.luggage.wxa.ee.b {
    private static final int CTRL_INDEX = 253;
    public static final String NAME = "insertTextView";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.c f145596a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.f f145597b;

        public a(a.c cVar, com.tencent.luggage.wxa.xd.f fVar) {
            this.f145596a = cVar;
            this.f145597b = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            w.d("MicroMsg.JsApiInsertTextView", NodeProps.ON_CLICK);
            e eVar = new e(null);
            HashMap hashMap = new HashMap();
            hashMap.put("data", this.f145596a.a("data", ""));
            eVar.setData(hashMap);
            if ("webview".equals(this.f145596a.a("sendTo", (String) null))) {
                this.f145597b.a(eVar);
            } else {
                this.f145597b.a(eVar, (int[]) null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.c f145599a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.f f145600b;

        public b(a.c cVar, com.tencent.luggage.wxa.xd.f fVar) {
            this.f145599a = cVar;
            this.f145600b = fVar;
        }

        @Override // com.tencent.luggage.wxa.ye.b.a
        public void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
            f fVar = new f();
            HashMap hashMap = new HashMap();
            hashMap.put("data", str2);
            hashMap.put("stage", str);
            hashMap.put("drag", jSONObject);
            hashMap.put("target", jSONObject2);
            fVar.setData(hashMap);
            w.d("MicroMsg.JsApiInsertTextView", "callback stage:%s, drag:%s, data:%s\uff0c target:%s", str, jSONObject, str2, jSONObject2);
            if ("webview".equals(this.f145599a.a("sendTo", (String) null))) {
                this.f145600b.a(fVar);
            } else {
                this.f145600b.a(fVar, (int[]) null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.c f145602a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.f f145603b;

        public c(a.c cVar, com.tencent.luggage.wxa.xd.f fVar) {
            this.f145602a = cVar;
            this.f145603b = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!this.f145602a.c("clickable")) {
                return;
            }
            w.d("MicroMsg.JsApiInsertTextView", NodeProps.ON_CLICK);
            e eVar = new e(null);
            HashMap hashMap = new HashMap();
            hashMap.put("data", this.f145602a.a("data", ""));
            eVar.setData(hashMap);
            if ("webview".equals(this.f145602a.a("sendTo", (String) null))) {
                this.f145603b.a(eVar);
            } else {
                this.f145603b.a(eVar, (int[]) null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.c f145605a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.f f145606b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f145607c;

        public d(a.c cVar, com.tencent.luggage.wxa.xd.f fVar, int i3) {
            this.f145605a = cVar;
            this.f145606b = fVar;
            this.f145607c = i3;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            com.tencent.luggage.wxa.ye.e.a(this.f145606b, view, this.f145607c, motionEvent, this.f145605a.a("data", ""), "webview".equals(this.f145605a.a("sendTo", (String) null)));
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class e extends k0 {
        private static final int CTRL_INDEX = 256;
        private static final String NAME = "onTextViewClick";

        public e() {
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class f extends k0 {
        private static final int CTRL_INDEX = 840;
        private static final String NAME = "onTextViewDrag";
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.getInt("viewId");
    }

    @Override // com.tencent.luggage.wxa.ee.b
    public View inflateView(com.tencent.luggage.wxa.xd.f fVar, JSONObject jSONObject) {
        Context context = fVar.getContext();
        return new com.tencent.luggage.wxa.ye.b(context, new com.tencent.luggage.wxa.il.h(context));
    }

    @Override // com.tencent.luggage.wxa.ee.b
    public void onInsertView(com.tencent.luggage.wxa.xd.f fVar, int i3, View view, JSONObject jSONObject) {
        int i16;
        boolean z16;
        int parentId;
        w.a("MicroMsg.JsApiInsertTextView", "onInsertView(viewId : %s, %s)", Integer.valueOf(i3), jSONObject);
        com.tencent.luggage.wxa.ye.b bVar = (com.tencent.luggage.wxa.ye.b) view;
        com.tencent.luggage.wxa.il.h hVar = (com.tencent.luggage.wxa.il.h) bVar.a(com.tencent.luggage.wxa.il.h.class);
        if (hVar == null) {
            w.h("MicroMsg.JsApiInsertTextView", "onInsertView(viewId : %d) failed, targetView is null", Integer.valueOf(i3));
            return;
        }
        boolean optBoolean = jSONObject.optBoolean("clickable");
        boolean optBoolean2 = jSONObject.optBoolean("transEvt");
        boolean optBoolean3 = jSONObject.optBoolean("gesture");
        boolean draggable = getDraggable(jSONObject);
        String optString = jSONObject.optString("sendTo", "appservice");
        String a16 = com.tencent.luggage.wxa.qn.a.a(jSONObject, "data");
        com.tencent.luggage.wxa.gh.c.a(hVar, jSONObject.optJSONObject("label"));
        com.tencent.luggage.wxa.gh.b.a(hVar, jSONObject);
        com.tencent.luggage.wxa.gh.f.a(view, jSONObject.optJSONObject("style"));
        a.c a17 = fVar.a(getIndependent(jSONObject)).a(i3, true);
        a17.b("data", (Object) a16);
        a17.b("sendTo", (Object) optString);
        a17.b("transEvt", Boolean.valueOf(optBoolean2));
        a17.b("clickable", Boolean.valueOf(optBoolean));
        boolean independent = getIndependent(jSONObject);
        if (independent && (parentId = getParentId(jSONObject)) != 0) {
            z16 = fVar.a(independent).b(parentId);
            i16 = fVar.a(independent).i(parentId);
        } else {
            i16 = -1;
            z16 = false;
        }
        w.d("MicroMsg.JsApiInsertTextView", "clickable:%b, gesture:%b, draggable:%b\uff0c independent:%b, isParentCanDrag:%b", Boolean.valueOf(optBoolean), Boolean.valueOf(optBoolean3), Boolean.valueOf(draggable), Boolean.valueOf(independent), Boolean.valueOf(z16));
        if (independent && (z16 || draggable)) {
            w.d("MicroMsg.JsApiInsertTextView", "CoverViewContainer setOnClickListener");
            if (optBoolean) {
                bVar.b(i3, i16);
                bVar.setIsInterceptEvent(true);
                bVar.setOnCustomerClickListener(new a(a17, fVar));
            }
            bVar.setDragEventCallback(new b(a17, fVar));
        } else {
            w.d("MicroMsg.JsApiInsertTextView", "targetView setOnClickListener");
            hVar.setOnClickListener(new c(a17, fVar));
            hVar.setClickable(optBoolean);
        }
        if (!optBoolean && optBoolean3 && !draggable) {
            view.setDuplicateParentStateEnabled(true);
            hVar.setDuplicateParentStateEnabled(true);
            hVar.setOnTouchListener(new d(a17, fVar, i3));
        }
    }
}
