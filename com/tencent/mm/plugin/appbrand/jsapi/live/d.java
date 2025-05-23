package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import android.view.View;
import com.tencent.live2.jsplugin.V2TXJSAdapterConstants;
import com.tencent.luggage.wxa.ff.j;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.uk.g;
import com.tencent.luggage.wxa.xd.f;
import com.tencent.luggage.wxa.y8.i;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class d extends com.tencent.luggage.wxa.ee.d {
    private static final int CTRL_INDEX = 361;
    public static final String NAME = "updateLivePusher";

    /* renamed from: b, reason: collision with root package name */
    private static final String f152135b = "MicroMsg.JsApiUpdateLivePusher";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements g.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.live.b f152136a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f152137b;

        public a(com.tencent.mm.plugin.appbrand.jsapi.live.b bVar, String str) {
            this.f152136a = bVar;
            this.f152137b = str;
        }

        @Override // com.tencent.luggage.wxa.uk.g.d
        public void onLoad(String str) {
            if (!w0.c(str)) {
                String a16 = i.a(str, false);
                w.d(d.f152135b, "convertBackgroundImageToLocalPath, targetPath:%s", a16);
                Bundle bundle = new Bundle();
                bundle.putString("backgroundImage", a16);
                this.f152136a.b(bundle);
                return;
            }
            w.d(d.f152135b, "convertBackgroundImageToLocalPath, load background image fail");
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("url", this.f152137b);
            this.f152136a.a(com.tencent.luggage.wxa.af.g.f121349r, 10004, "load background image fail", hashMap);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements g.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.live.b f152139a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f152140b;

        public b(com.tencent.mm.plugin.appbrand.jsapi.live.b bVar, String str) {
            this.f152139a = bVar;
            this.f152140b = str;
        }

        @Override // com.tencent.luggage.wxa.uk.g.d
        public void onLoad(String str) {
            if (!w0.c(str)) {
                String a16 = i.a(str, false);
                w.d(d.f152135b, "convertFilterImageToLocalPath, targetPath:%s", a16);
                Bundle bundle = new Bundle();
                bundle.putString(V2TXJSAdapterConstants.PUSHER_KEY_FILTER_IMAGE, a16);
                this.f152139a.b(bundle);
                return;
            }
            w.d(d.f152135b, "convertFilterImageToLocalPath, load background image fail");
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("url", this.f152140b);
            this.f152139a.a(com.tencent.luggage.wxa.af.g.f121349r, 10005, "load filter image fail", hashMap);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements g.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.live.b f152142a;

        public c(com.tencent.mm.plugin.appbrand.jsapi.live.b bVar) {
            this.f152142a = bVar;
        }

        @Override // com.tencent.luggage.wxa.uk.g.d
        public void onLoad(String str) {
            if (!w0.c(str)) {
                String a16 = i.a(str, false);
                w.d(d.f152135b, "convertWatermarkImageToLocalPath, targetPath:%s", a16);
                Bundle bundle = new Bundle();
                bundle.putString("watermarkImage", a16);
                this.f152142a.b(bundle);
            }
        }
    }

    private void convertBackgroundImageToLocalPath(com.tencent.luggage.wxa.xd.d dVar, com.tencent.mm.plugin.appbrand.jsapi.live.b bVar, JSONObject jSONObject) {
        try {
            if (jSONObject.has("backgroundImage")) {
                String string = jSONObject.getString("backgroundImage");
                String optString = jSONObject.optString("backgroundMD5");
                if (w0.c(string)) {
                    w.d(f152135b, "convertBackgroundImageToLocalPath, url is null");
                } else {
                    g.c(dVar, string, optString, new a(bVar, string));
                }
            }
        } catch (JSONException e16) {
            w.d(f152135b, "onUpdateView param=%s exp=%s", "backgroundImage", e16.getLocalizedMessage());
        }
    }

    private void convertFilterImageToLocalPath(com.tencent.luggage.wxa.xd.d dVar, com.tencent.mm.plugin.appbrand.jsapi.live.b bVar, JSONObject jSONObject) {
        try {
            if (jSONObject.has(V2TXJSAdapterConstants.PUSHER_KEY_FILTER_IMAGE)) {
                String string = jSONObject.getString(V2TXJSAdapterConstants.PUSHER_KEY_FILTER_IMAGE);
                if (w0.c(string)) {
                    w.d(f152135b, "convertFilterImageToLocalPath, url is null");
                } else {
                    g.c(dVar, string, null, new b(bVar, string));
                }
            }
        } catch (JSONException e16) {
            w.d(f152135b, "onUpdateView param=%s exp=%s", V2TXJSAdapterConstants.PUSHER_KEY_FILTER_IMAGE, e16.getLocalizedMessage());
        }
    }

    private void convertWatermarkImageToLocalPath(com.tencent.luggage.wxa.xd.d dVar, com.tencent.mm.plugin.appbrand.jsapi.live.b bVar, JSONObject jSONObject) {
        try {
            if (jSONObject.has("watermarkImage")) {
                String string = jSONObject.getString("watermarkImage");
                String optString = jSONObject.optString("watermarkMD5");
                if (w0.c(string)) {
                    w.d(f152135b, "convertWatermarkImageToLocalPath, url is null");
                } else {
                    g.c(dVar, string, optString, new c(bVar));
                }
            }
        } catch (JSONException e16) {
            w.d(f152135b, "onUpdateView param=%s exp=%s", "watermarkImage", e16.getLocalizedMessage());
        }
    }

    private void parseFilterImage(JSONObject jSONObject, com.tencent.mm.plugin.appbrand.jsapi.live.b bVar) {
        if (jSONObject.has(V2TXJSAdapterConstants.PUSHER_KEY_FILTER_IMAGE)) {
            bVar.f152110e = jSONObject.optString(V2TXJSAdapterConstants.PUSHER_KEY_FILTER_IMAGE, bVar.f152110e);
            bVar.f152111f = jSONObject.optString(com.tencent.luggage.wxa.ff.g.f126099a, null);
            if (w0.c(bVar.f152110e)) {
                try {
                    jSONObject.put(V2TXJSAdapterConstants.PUSHER_KEY_FILTER_IMAGE, "");
                    return;
                } catch (JSONException e16) {
                    w.h(f152135b, "parseFilterImage, ignore exception:%s", e16);
                    return;
                }
            }
            if (bVar.f152110e.startsWith("http://") || bVar.f152110e.startsWith("https://")) {
                jSONObject.remove(V2TXJSAdapterConstants.PUSHER_KEY_FILTER_IMAGE);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ee.d
    public boolean a(f fVar, int i3, View view, JSONObject jSONObject) {
        w.d(f152135b, "onUpdateView : livePusherId=%d", Integer.valueOf(i3));
        if (!(view instanceof com.tencent.luggage.wxa.ye.b)) {
            w.h(f152135b, "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i3));
            return false;
        }
        View view2 = (View) ((com.tencent.luggage.wxa.ye.b) view).a(View.class);
        if (!(view2 instanceof com.tencent.mm.plugin.appbrand.jsapi.live.b)) {
            w.b(f152135b, "targetView not AppBrandLivePusherView");
            return false;
        }
        com.tencent.mm.plugin.appbrand.jsapi.live.b bVar = (com.tencent.mm.plugin.appbrand.jsapi.live.b) view2;
        parseFilterImage(jSONObject, bVar);
        bVar.b(j.b(jSONObject));
        convertBackgroundImageToLocalPath(fVar, bVar, jSONObject);
        convertFilterImageToLocalPath(fVar, bVar, jSONObject);
        convertWatermarkImageToLocalPath(fVar, bVar, jSONObject);
        return true;
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.optInt("livePusherId");
    }
}
