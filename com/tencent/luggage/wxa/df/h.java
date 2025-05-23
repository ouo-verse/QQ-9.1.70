package com.tencent.luggage.wxa.df;

import android.text.TextUtils;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.ol.g1;
import com.tencent.luggage.wxa.ol.k;
import com.tencent.luggage.wxa.ol.l;
import com.tencent.luggage.wxa.ol.m;
import com.tencent.luggage.wxa.ol.m0;
import com.tencent.luggage.wxa.ol.p0;
import com.tencent.luggage.wxa.ol.r;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.c0;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.luggage.wxa.xd.p;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.sdk.plugins.InputJsPlugin;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h extends com.tencent.luggage.wxa.df.a {
    public static final int CTRL_INDEX = 1;
    public static final String NAME = "showKeyboard";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f124216a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f124217b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f124218c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f124219d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f124220e;

        public a(v vVar, int i3, int i16, int i17, int i18) {
            this.f124216a = vVar;
            this.f124217b = i3;
            this.f124218c = i16;
            this.f124219d = i17;
            this.f124220e = i18;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r.a(this.f124216a, this.f124217b, this.f124218c, this.f124219d)) {
                this.f124216a.a(this.f124220e, h.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            } else {
                this.f124216a.a(this.f124220e, h.this.makeReturnJson("fail:invalid data"));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f124222a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f124223b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f124224c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f124225d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.vl.f f124226e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f124227f;

        public b(v vVar, int i3, int i16, String str, com.tencent.luggage.wxa.vl.f fVar, int i17) {
            this.f124222a = vVar;
            this.f124223b = i3;
            this.f124224c = i16;
            this.f124225d = str;
            this.f124226e = fVar;
            this.f124227f = i17;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.a(this.f124222a, this.f124223b, this.f124224c, this.f124225d, this.f124226e, this.f124227f);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements com.tencent.luggage.wxa.sl.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f124229a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f124230b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ v f124231c;

        public c(l lVar, String str, v vVar) {
            this.f124229a = lVar;
            this.f124230b = str;
            this.f124231c = vVar;
        }

        @Override // com.tencent.luggage.wxa.sl.c
        public void a(String str, int i3) {
            int inputId = this.f124229a.getInputId();
            if (this.f124229a.d() == null) {
                w.b("MicroMsg.JsApiShowKeyboard", "dispatchKBValue(%s), but get NULL inputWidget", this.f124230b);
                return;
            }
            k0 gVar = new g();
            HashMap hashMap = new HashMap();
            hashMap.put("value", com.tencent.luggage.wxa.uk.j.a(str));
            hashMap.put("data", h.this.b(inputId));
            hashMap.put("cursor", Integer.valueOf(i3));
            hashMap.put("inputId", Integer.valueOf(inputId));
            hashMap.put("keyCode", Integer.valueOf(this.f124229a.d().getLastKeyPressed()));
            gVar.setData(hashMap);
            this.f124231c.a(gVar, (int[]) null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements l.u {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f124233a;

        public d(WeakReference weakReference) {
            this.f124233a = weakReference;
        }

        @Override // com.tencent.luggage.wxa.ol.l.u
        public void a(p0 p0Var, int i3) {
            try {
                v vVar = (v) this.f124233a.get();
                if (vVar != null) {
                    h.this.a(p0Var.getInputId(), i3, vVar);
                    new c0().a(i3, vVar.y0(), vVar, Integer.valueOf(p0Var.getInputId()));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f124235a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f124236b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.vl.f f124237c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f124238d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f124239e;

        public e(WeakReference weakReference, l lVar, com.tencent.luggage.wxa.vl.f fVar, int i3, int i16) {
            this.f124235a = weakReference;
            this.f124236b = lVar;
            this.f124237c = fVar;
            this.f124238d = i3;
            this.f124239e = i16;
        }

        @Override // java.lang.Runnable
        public void run() {
            v vVar = (v) this.f124235a.get();
            if (vVar != null && vVar.D0() != null) {
                this.f124236b.a(this.f124237c, this.f124238d, this.f124239e);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends p {
        public static final int CTRL_INDEX = 78;
        public static final String NAME = "onKeyboardValueChange";
    }

    public void a(l lVar) {
    }

    public boolean f() {
        return true;
    }

    public boolean g() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(v vVar, JSONObject jSONObject, int i3) {
        int optInt;
        int optInt2 = jSONObject.optInt("cursor", -2);
        if (jSONObject.has("selectionStart") || jSONObject.has("selectionEnd")) {
            optInt2 = jSONObject.optInt("selectionStart", -2);
            optInt = jSONObject.optInt("selectionEnd", -2);
        } else {
            optInt = optInt2;
        }
        try {
            int i16 = jSONObject.getInt("inputId");
            if (g()) {
                com.tencent.luggage.wxa.tn.c0.a(new a(vVar, i16, optInt2, optInt, i3));
                return;
            }
        } catch (JSONException unused) {
        }
        com.tencent.luggage.wxa.vl.f fVar = new com.tencent.luggage.wxa.vl.f();
        if (!a(fVar, jSONObject, vVar, i3)) {
            vVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121315k));
            return;
        }
        if (r.f(fVar.R) && com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.tl.c.class) == null) {
            vVar.a(i3, makeReturnJson("fail:not supported type '" + fVar.R + "'"));
            return;
        }
        if (!jSONObject.has("inputId")) {
            int a16 = com.tencent.luggage.wxa.ee.i.a(vVar, System.nanoTime());
            fVar.Q = a16;
            a(a16, 0, vVar);
        }
        com.tencent.luggage.wxa.tk.l.a(new b(vVar, optInt2, optInt, com.tencent.luggage.wxa.qn.a.a(jSONObject, "data"), fVar, i3));
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f extends l {
        public final /* synthetic */ WeakReference P;
        public final /* synthetic */ int Q;
        public final /* synthetic */ String R;

        public f(WeakReference weakReference, int i3, String str) {
            this.P = weakReference;
            this.Q = i3;
            this.R = str;
        }

        public final void B() {
            v vVar = (v) this.P.get();
            if (vVar != null && vVar.D0() != null) {
                k.a().c(vVar);
            }
        }

        @Override // com.tencent.luggage.wxa.ol.l
        public void a(String str, int i3, boolean z16, boolean z17) {
            String str2;
            com.tencent.luggage.wxa.xd.d dVar = (com.tencent.luggage.wxa.xd.d) this.P.get();
            if (dVar == null) {
                return;
            }
            try {
                str2 = new JSONObject().put("value", com.tencent.luggage.wxa.uk.j.a(str)).put("inputId", getInputId()).put("cursor", i3).toString();
            } catch (JSONException e16) {
                w.b("MicroMsg.JsApiShowKeyboard", "dispatch input done, exp = %s", w0.a((Throwable) e16));
                str2 = null;
            }
            a(dVar, str2, z16, z17);
        }

        @Override // com.tencent.luggage.wxa.ol.l
        public void u() {
            if (this.P.get() != null) {
                int inputId = getInputId();
                HashMap hashMap = new HashMap(1);
                hashMap.put("inputId", Integer.valueOf(inputId));
                ((v) this.P.get()).a(this.Q, h.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
                h.this.a(inputId, this.R);
                h.this.a(inputId, (v) this.P.get());
            }
        }

        @Override // com.tencent.luggage.wxa.ol.l
        public void v() {
            if (this.P.get() != null) {
                ((v) this.P.get()).a(this.Q, h.this.makeReturnJson("fail"));
                B();
            }
        }

        @Override // com.tencent.luggage.wxa.ol.l
        public void a(String str, int i3, boolean z16, boolean z17, String str2, String str3) {
            com.tencent.luggage.wxa.xd.d dVar = (com.tencent.luggage.wxa.xd.d) this.P.get();
            if (dVar == null) {
                return;
            }
            String str4 = null;
            try {
                JSONObject put = new JSONObject().put("value", com.tencent.luggage.wxa.uk.j.a(str)).put("inputId", getInputId()).put("cursor", i3);
                if (str2 != null) {
                    put.put("encryptValue", str2);
                }
                if (str3 != null) {
                    put.put("encryptError", str3);
                }
                str4 = put.toString();
                w.d("MicroMsg.JsApiShowKeyboard", "onInputDoneWithEncryptedValue, eventData: %s", str4);
            } catch (JSONException e16) {
                w.b("MicroMsg.JsApiShowKeyboard", "dispatch input done, exp = %s", w0.a((Throwable) e16));
            }
            a(dVar, str4, z16, z17);
        }

        public final void a(com.tencent.luggage.wxa.xd.d dVar, String str, boolean z16, boolean z17) {
            if (!TextUtils.isEmpty(str)) {
                if (z16) {
                    dVar.a(InputJsPlugin.ON_KEYBOARD_CONFIRM_CALLBACK, str);
                }
                if (!z17) {
                    dVar.a(InputJsPlugin.ON_KEYBOARD_COMPLETE_CALLBACK, str);
                }
            }
            if (z17) {
                return;
            }
            B();
        }

        @Override // com.tencent.luggage.wxa.ol.l
        public void a(String str) {
            v vVar = (v) this.P.get();
            if (vVar == null) {
                return;
            }
            try {
                int inputId = getInputId();
                g gVar = new g();
                gVar.setData(new JSONObject().put("value", com.tencent.luggage.wxa.uk.j.a(str)).put("data", h.this.b(inputId)).put("cursor", 0).put("inputId", inputId).put("keyCode", 8).toString());
                vVar.a(gVar, (int[]) null);
            } catch (Exception e16) {
                w.b("MicroMsg.JsApiShowKeyboard", "onBackspacePressedWhileValueNoChange, e = %s", e16);
            }
        }
    }

    public final void a(v vVar, int i3, int i16, String str, com.tencent.luggage.wxa.vl.f fVar, int i17) {
        Integer a16 = m.a().a(fVar, str, i3, i16, vVar);
        if (a16 != null) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("inputId", a16);
            vVar.a(i17, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
            return;
        }
        String appId = vVar.getAppId();
        vVar.getComponentId();
        WeakReference weakReference = new WeakReference(vVar);
        fVar.W = weakReference;
        l a17 = a(weakReference, str, i17);
        a17.a(new c(a17, appId, vVar));
        a17.a(new d(weakReference));
        a(a17);
        com.tencent.luggage.wxa.tk.l.a(new e(weakReference, a17, fVar, i3, i16));
    }

    public final void a(int i3, int i16, v vVar) {
        try {
            vVar.a("onKeyboardShow", com.tencent.luggage.wxa.xa.g.c().put("inputId", i3).put("height", com.tencent.luggage.wxa.tk.g.a(vVar.getContext(), i16)).toString());
        } catch (com.tencent.luggage.wxa.xa.f e16) {
            w.b("MicroMsg.JsApiShowKeyboard", "", e16.getMessage());
        }
    }

    public l a(WeakReference weakReference, String str, int i3) {
        return new f(weakReference, i3, str);
    }

    public boolean a(com.tencent.luggage.wxa.vl.f fVar, JSONObject jSONObject, v vVar, int i3) {
        JSONObject optJSONObject;
        if (!super.a((com.tencent.luggage.wxa.vl.g) fVar, jSONObject, vVar, i3)) {
            return false;
        }
        fVar.P = jSONObject.optInt("parentId");
        fVar.Q = jSONObject.optInt("inputId");
        fVar.f143664b = Integer.valueOf(Math.max(0, fVar.f143664b.intValue()));
        Integer num = fVar.f143665c;
        fVar.f143665c = Integer.valueOf(num == null ? 0 : Math.max(0, num.intValue()));
        fVar.R = jSONObject.optString("type", "text");
        if (!r.f136918b.contains(fVar.R)) {
            vVar.a(i3, makeReturnJson("fail:unsupported input type"));
            return false;
        }
        if (fVar.B == null) {
            fVar.B = Boolean.TRUE;
        }
        fVar.S = jSONObject.optBoolean(NotificationActivity.PASSWORD);
        fVar.F = Boolean.valueOf(jSONObject.optBoolean(NotificationActivity.PASSWORD));
        if (jSONObject.has("showCoverView")) {
            fVar.G = Boolean.valueOf(jSONObject.optBoolean("showCoverView", false));
        }
        g1.a(jSONObject, fVar);
        m0.a(jSONObject, fVar);
        if (!f() || (optJSONObject = jSONObject.optJSONObject("dropdown")) == null) {
            return true;
        }
        com.tencent.luggage.wxa.vl.a aVar = new com.tencent.luggage.wxa.vl.a();
        aVar.f143644a = optJSONObject.optInt(NodeProps.MARGIN_LEFT);
        aVar.f143645b = optJSONObject.optInt(NodeProps.MARGIN_RIGHT);
        aVar.f143646c = optJSONObject.optString("width");
        JSONArray optJSONArray = optJSONObject.optJSONArray("options");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return true;
        }
        aVar.f143647d = new ArrayList();
        for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i16);
            if (optJSONObject2 != null) {
                String optString = optJSONObject2.optString("id");
                String optString2 = optJSONObject2.optString("title");
                String optString3 = optJSONObject2.optString("content");
                if (!w0.c(optString) && !w0.c(optString2)) {
                    com.tencent.luggage.wxa.vl.b bVar = new com.tencent.luggage.wxa.vl.b();
                    bVar.f143648a = optString;
                    bVar.f143649b = optString2;
                    bVar.f143650c = optString3;
                    aVar.f143647d.add(bVar);
                }
            }
        }
        fVar.V = aVar;
        return true;
    }
}
