package com.qq.e.comm.plugin.base.ad.c;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class i extends a {
    private void a(JSONObject jSONObject) {
        if (com.qq.e.comm.plugin.l.a.b().getVelenPreloadUrl(jSONObject) == null) {
            return;
        }
        com.qq.e.comm.plugin.l.a.b().preloadAdFileSource(jSONObject);
    }

    @Override // com.qq.e.comm.plugin.base.ad.c.a
    protected void b(JSONArray jSONArray, String str) {
        if (!com.qq.e.comm.plugin.l.a.a()) {
            return;
        }
        if (!com.qq.e.comm.plugin.j.c.a("velen_switch", 0, 1)) {
            return;
        }
        if (y.a(jSONArray)) {
            GDTLogger.d("VelenPreloader: adInfo is null");
            return;
        }
        com.qq.e.comm.plugin.l.a.b().init(GDTADManager.getInstance().getAppContext().getApplicationContext());
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                a(jSONArray.getJSONObject(i3));
            } catch (JSONException e16) {
                e16.printStackTrace();
                return;
            }
        }
    }
}
