package com.tencent.luggage.wxa.re;

import android.util.Size;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class n extends com.tencent.luggage.wxa.ee.d {
    private static final int CTRL_INDEX = 331;
    public static final String NAME = "updateCamera";

    @Override // com.tencent.luggage.wxa.ee.d
    public boolean a(com.tencent.luggage.wxa.xd.f fVar, int i3, View view, JSONObject jSONObject) {
        boolean z16;
        int[] a16;
        w.d("MicroMsg.JsApiUpdateCamera", "onUpdateView : cameraId=%d", Integer.valueOf(i3));
        if (!(view instanceof com.tencent.luggage.wxa.ye.b)) {
            w.h("MicroMsg.JsApiUpdateCamera", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i3));
            return false;
        }
        KeyEvent.Callback callback = (View) ((com.tencent.luggage.wxa.ye.b) view).a(View.class);
        if (callback != null && (callback instanceof e)) {
            e eVar = (e) callback;
            int optInt = jSONObject.optInt("cameraId");
            String optString = jSONObject.optString("devicePosition", "back");
            String optString2 = jSONObject.optString("flash", "auto");
            boolean optBoolean = jSONObject.optBoolean("needOutput", false);
            eVar.setAppId(fVar.getAppId());
            eVar.a(optString, false);
            eVar.setFlash(optString2);
            eVar.setNeedOutput(optBoolean);
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            int a17 = com.tencent.luggage.wxa.tk.g.a(optJSONObject, "width", 0);
            int a18 = com.tencent.luggage.wxa.tk.g.a(optJSONObject, "height", 0);
            w.a("MicroMsg.JsApiUpdateCamera", "onUpdateView cameraId: %d, devicePosition: %s,flash: %s,width\uff1a %d,height\uff1a %d", Integer.valueOf(optInt), optString, optString2, Integer.valueOf(a17), Integer.valueOf(a18));
            if (a17 != 0 && a18 != 0) {
                z16 = eVar.a(a17, a18, false);
            } else {
                z16 = false;
            }
            d dVar = (d) fVar.b(d.class);
            if (dVar != null && (a16 = dVar.a(fVar)) != null && a16.length == 2 && a16[0] > 0 && a16[1] > 0) {
                eVar.setDisplayScreenSize(new Size(a16[0], a16[1]));
                w.d("MicroMsg.JsApiUpdateCamera", "onUpdateView screen width: %d, screen height: %d", Integer.valueOf(a16[0]), Integer.valueOf(a16[1]));
            }
            String optString3 = jSONObject.optString("mode");
            if (!w0.c(optString3)) {
                eVar.setMode(optString3);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("scanArea");
            if (optJSONArray != null && optJSONArray.length() == 4) {
                w.d("MicroMsg.JsApiUpdateCamera", "scanAreaArray:%s, scanAreaArray.length:%d", optJSONArray, Integer.valueOf(optJSONArray.length()));
                eVar.a(com.tencent.luggage.wxa.tk.g.a(optJSONArray.optInt(0)), com.tencent.luggage.wxa.tk.g.a(optJSONArray.optInt(1)), com.tencent.luggage.wxa.tk.g.a(optJSONArray.optInt(2)), com.tencent.luggage.wxa.tk.g.a(optJSONArray.optInt(3)));
            }
            eVar.setScanFreq(jSONObject.optInt("scanFreq"));
            if (z16) {
                eVar.release();
                eVar.a();
            } else {
                eVar.c();
            }
            return true;
        }
        w.h("MicroMsg.JsApiUpdateCamera", "the camera view(%s) is null", Integer.valueOf(i3));
        return false;
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.optInt("cameraId");
    }
}
