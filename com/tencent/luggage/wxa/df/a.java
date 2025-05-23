package com.tencent.luggage.wxa.df;

import com.tencent.luggage.wxa.h6.l;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.nb.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends com.tencent.luggage.wxa.xd.a {
    /* JADX WARN: Removed duplicated region for block: B:12:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0170 A[Catch: Exception -> 0x01aa, TryCatch #4 {Exception -> 0x01aa, blocks: (B:26:0x0164, B:28:0x0170, B:29:0x0189, B:50:0x017d), top: B:25:0x0164 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x017d A[Catch: Exception -> 0x01aa, TryCatch #4 {Exception -> 0x01aa, blocks: (B:26:0x0164, B:28:0x0170, B:29:0x0189, B:50:0x017d), top: B:25:0x0164 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(com.tencent.luggage.wxa.vl.g gVar, JSONObject jSONObject, v vVar, int i3) {
        Exception e16;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        try {
            jSONObject2 = new JSONObject(jSONObject.getString("style"));
            try {
                gVar.f143664b = Integer.valueOf(com.tencent.luggage.wxa.tk.g.c(jSONObject2, "width"));
                try {
                    gVar.f143665c = Integer.valueOf(com.tencent.luggage.wxa.tk.g.c(jSONObject2, "height"));
                } catch (Exception unused) {
                }
                gVar.f143666d = Integer.valueOf(com.tencent.luggage.wxa.tk.g.c(jSONObject2, "top"));
                gVar.f143667e = Integer.valueOf(com.tencent.luggage.wxa.tk.g.c(jSONObject2, "left"));
            } catch (Exception e17) {
                e16 = e17;
                if (!e()) {
                    w.b("MicroMsg.AppBrandJsApiInputBase", "get position info from style, exp = %s", w0.a((Throwable) e16));
                    vVar.a(i3, makeReturnJson("fail:invalid data"));
                    return false;
                }
                if (jSONObject2 != null) {
                }
                gVar.f143685w = Boolean.valueOf(jSONObject.getBoolean("autoSize"));
                gVar.f143663a = jSONObject.optString(RemoteHandleConst.PARAM_DEFAULT_VALUE, jSONObject.optString("value", null));
                gVar.f143676n = Integer.valueOf(jSONObject.getInt("maxLength"));
                if (!jSONObject.has("placeholder")) {
                }
                if (!l.f126905a.a(vVar.getAppId())) {
                }
                gVar.f143680r = Integer.valueOf(com.tencent.luggage.wxa.tk.g.b(jSONObject3.getString("color")));
                gVar.f143679q = Integer.valueOf(com.tencent.luggage.wxa.tk.g.c(jSONObject3, "fontSize"));
                gVar.f143678p = jSONObject3.optString("fontWeight", "normal");
                gVar.f143682t = Boolean.valueOf(jSONObject.getBoolean("hidden"));
                gVar.f143681s = Boolean.valueOf(jSONObject.getBoolean("disabled"));
                gVar.f143686x = Boolean.valueOf(jSONObject.getBoolean(QCircleDaTongConstant.ElementParamValue.FIXED));
                gVar.f143688z = com.tencent.luggage.wxa.vl.c.a(jSONObject.optString("confirmType"));
                gVar.A = Boolean.valueOf(jSONObject.getBoolean("confirmHold"));
                gVar.B = com.tencent.luggage.wxa.h6.f.a(jSONObject.opt("adjustPosition"));
                return true;
            }
        } catch (Exception e18) {
            e16 = e18;
            jSONObject2 = null;
        }
        if (jSONObject2 != null) {
            if (!e()) {
                w.b("MicroMsg.AppBrandJsApiInputBase", "null style obj");
                vVar.a(i3, makeReturnJson("fail:invalid data"));
                return false;
            }
        } else {
            gVar.f143675m = jSONObject2.optString("fontWeight", null);
            try {
                gVar.f143668f = Integer.valueOf(com.tencent.luggage.wxa.tk.g.c(jSONObject2, NodeProps.MIN_HEIGHT));
            } catch (Exception unused2) {
            }
            try {
                gVar.f143669g = Integer.valueOf(com.tencent.luggage.wxa.tk.g.c(jSONObject2, NodeProps.MAX_HEIGHT));
            } catch (Exception unused3) {
            }
            gVar.f143670h = jSONObject2.optString("textAlign", null);
            try {
                gVar.f143672j = Integer.valueOf(com.tencent.luggage.wxa.tk.g.a(jSONObject2.getString("color"), -16777216));
            } catch (Exception unused4) {
            }
            try {
                gVar.f143671i = Integer.valueOf(com.tencent.luggage.wxa.tk.g.a(jSONObject2.getString("backgroundColor"), 0));
            } catch (Exception unused5) {
            }
            try {
                gVar.f143673k = Float.valueOf(com.tencent.luggage.wxa.tk.g.b(jSONObject2, "fontSize"));
            } catch (Exception unused6) {
            }
            try {
                gVar.f143687y = Integer.valueOf(com.tencent.luggage.wxa.tk.g.c(jSONObject2, NodeProps.MARGIN_BOTTOM));
            } catch (Exception unused7) {
                gVar.f143687y = null;
            }
            Integer a16 = com.tencent.luggage.wxa.vl.e.a(jSONObject2.opt("lineSpace"));
            gVar.D = a16;
            if (a16 != null) {
                gVar.D = Integer.valueOf(com.tencent.luggage.wxa.tk.g.a(a16.intValue()));
            }
            Integer a17 = com.tencent.luggage.wxa.vl.e.a(jSONObject2.opt(NodeProps.LINE_HEIGHT));
            gVar.E = a17;
            if (a17 != null) {
                gVar.E = Integer.valueOf(com.tencent.luggage.wxa.tk.g.a(a17.intValue()));
            }
        }
        try {
            gVar.f143685w = Boolean.valueOf(jSONObject.getBoolean("autoSize"));
        } catch (Exception unused8) {
        }
        gVar.f143663a = jSONObject.optString(RemoteHandleConst.PARAM_DEFAULT_VALUE, jSONObject.optString("value", null));
        try {
            gVar.f143676n = Integer.valueOf(jSONObject.getInt("maxLength"));
        } catch (Exception unused9) {
        }
        if (!jSONObject.has("placeholder")) {
            gVar.f143677o = jSONObject.optString("placeholder", null);
        } else {
            gVar.f143677o = null;
        }
        try {
            if (!l.f126905a.a(vVar.getAppId())) {
                jSONObject3 = new JSONObject(jSONObject.getString("placeholderStyleDark"));
            } else {
                jSONObject3 = new JSONObject(jSONObject.getString("placeholderStyle"));
            }
            gVar.f143680r = Integer.valueOf(com.tencent.luggage.wxa.tk.g.b(jSONObject3.getString("color")));
            gVar.f143679q = Integer.valueOf(com.tencent.luggage.wxa.tk.g.c(jSONObject3, "fontSize"));
            gVar.f143678p = jSONObject3.optString("fontWeight", "normal");
        } catch (Exception unused10) {
        }
        try {
            gVar.f143682t = Boolean.valueOf(jSONObject.getBoolean("hidden"));
        } catch (JSONException unused11) {
            gVar.f143682t = null;
        }
        try {
            gVar.f143681s = Boolean.valueOf(jSONObject.getBoolean("disabled"));
        } catch (Exception unused12) {
            gVar.f143681s = null;
        }
        try {
            gVar.f143686x = Boolean.valueOf(jSONObject.getBoolean(QCircleDaTongConstant.ElementParamValue.FIXED));
        } catch (Exception unused13) {
            gVar.f143686x = null;
        }
        gVar.f143688z = com.tencent.luggage.wxa.vl.c.a(jSONObject.optString("confirmType"));
        try {
            gVar.A = Boolean.valueOf(jSONObject.getBoolean("confirmHold"));
        } catch (Exception unused14) {
            gVar.A = null;
        }
        gVar.B = com.tencent.luggage.wxa.h6.f.a(jSONObject.opt("adjustPosition"));
        return true;
    }

    public final String b(int i3) {
        return com.tencent.luggage.wxa.nb.a.a().a("AppBrandJsInput@" + i3, true).a("passing_data", "");
    }

    public boolean e() {
        return false;
    }

    public final void a(int i3, String str) {
        com.tencent.luggage.wxa.nb.a.a().a("AppBrandJsInput@" + i3, true).b("passing_data", str);
    }

    public final void a(int i3, v vVar) {
        if (vVar == null) {
            return;
        }
        com.tencent.luggage.wxa.nb.a.a().a("AppBrandJsInput@" + i3, true).b("webview_reference", new WeakReference(vVar));
    }

    public final v a(int i3) {
        WeakReference weakReference;
        a.c c16 = com.tencent.luggage.wxa.nb.a.a().c("AppBrandJsInput@" + i3);
        if (c16 == null || (weakReference = (WeakReference) c16.a("webview_reference", (Object) null)) == null) {
            return null;
        }
        return (v) weakReference.get();
    }
}
