package com.qq.e.comm.plugin.base.ad.c;

import android.util.Pair;
import com.qq.e.comm.plugin.k.bb;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.util.GDTLogger;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class j extends a {
    private void a(JSONObject jSONObject, String str) {
        int i3;
        GDTLogger.d("preloadWXMiniProgramInfo : " + jSONObject);
        if (com.qq.e.comm.plugin.k.b.e(jSONObject)) {
            List<JSONObject> a16 = bb.a(jSONObject);
            if (com.qq.e.comm.plugin.k.g.b(a16)) {
                return;
            }
            int min = Math.min(a16.size(), com.qq.e.comm.plugin.j.c.a(str, "wxPreloadSubMaxNum", 3));
            boolean a17 = k.a().a(jSONObject, str);
            for (int i16 = 0; i16 < min; i16++) {
                if (y.a(a16.get(i16))) {
                    JSONObject jSONObject2 = a16.get(i16);
                    if (a17) {
                        i3 = 2;
                    } else {
                        i3 = 1;
                    }
                    bb.a(jSONObject2, jSONObject, str, i3, true);
                }
            }
        }
    }

    @Override // com.qq.e.comm.plugin.base.ad.c.a
    protected void b(JSONArray jSONArray, String str) {
        k.a().a(str);
        Pair<JSONArray, Boolean> a16 = k.a().a(jSONArray);
        JSONArray jSONArray2 = (JSONArray) a16.first;
        if (((Boolean) a16.second).booleanValue() && com.qq.e.comm.plugin.j.c.a(str, "wxLuggagePreload", 0, 1)) {
            com.qq.e.comm.plugin.base.ad.clickcomponent.d.h.d();
        }
        if (y.a(jSONArray2)) {
            GDTLogger.d("WXMiniProgramPreloader: adInfo is null");
            k.a().b();
            return;
        }
        try {
            int min = Math.min(jSONArray2.length(), com.qq.e.comm.plugin.j.c.a(str, "wxPreloadMaxNum", 4));
            for (int i3 = 0; i3 < min; i3++) {
                a(jSONArray2.getJSONObject(i3), str);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        k.a().b();
    }
}
