package com.tencent.luggage.wxa.rh;

import android.util.Size;
import android.view.Surface;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.re.f;
import com.tencent.luggage.wxa.tk.g;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.uk.n0;
import com.tencent.luggage.wxa.xd.i;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends a {
    private static final int CTRL_INDEX = 807;
    public static final String NAME = "updateXWebCamera";

    public boolean a(com.tencent.luggage.wxa.xd.d dVar, Surface surface, f fVar, JSONObject jSONObject) {
        boolean z16;
        boolean z17;
        w.d("MicroMsg.JsApiUpdateXWebCamera", "update xweb camera view");
        if (fVar == null) {
            w.f("MicroMsg.JsApiUpdateXWebCamera", "the camera view is null");
            return false;
        }
        int optInt = jSONObject.optInt("cameraId");
        String optString = jSONObject.optString("devicePosition", "back");
        String optString2 = jSONObject.optString("flash", "auto");
        boolean optBoolean = jSONObject.optBoolean("needOutput", false);
        fVar.setAppId(dVar.getAppId());
        fVar.a(optString, false);
        fVar.setFlash(optString2);
        fVar.setNeedOutput(optBoolean);
        if (surface != null) {
            fVar.setCustomSurface(surface);
            w.d("MicroMsg.JsApiUpdateXWebCamera", "set a new surface when update camera");
            z16 = true;
        } else {
            z16 = false;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        int a16 = g.a(optJSONObject, "width", 0);
        int a17 = g.a(optJSONObject, "height", 0);
        w.a("MicroMsg.JsApiUpdateXWebCamera", "onUpdateView cameraId: %d, devicePosition: %s,flash: %s,width\uff1a %d,height\uff1a %d", Integer.valueOf(optInt), optString, optString2, Integer.valueOf(a16), Integer.valueOf(a17));
        if (a16 != 0 && a17 != 0) {
            z17 = fVar.a(a16, a17, false);
        } else {
            z17 = false;
        }
        if (dVar instanceof v) {
            int[] a18 = n0.a((i) dVar);
            fVar.setDisplayScreenSize(new Size(a18[0], a18[1]));
        }
        String optString3 = jSONObject.optString("mode");
        if (!w0.c(optString3)) {
            fVar.setMode(optString3);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("scanArea");
        if (optJSONArray != null && optJSONArray.length() == 4) {
            w.d("MicroMsg.JsApiUpdateXWebCamera", "scanAreaArray:%s, scanAreaArray.length:%d", optJSONArray, Integer.valueOf(optJSONArray.length()));
            fVar.a(g.a(optJSONArray.optInt(0)), g.a(optJSONArray.optInt(1)), g.a(optJSONArray.optInt(2)), g.a(optJSONArray.optInt(3)));
        }
        fVar.setScanFreq(jSONObject.optInt("scanFreq"));
        if (!z17 && !z16) {
            fVar.c();
        } else {
            fVar.release();
            fVar.a();
        }
        return true;
    }
}
