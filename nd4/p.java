package nd4;

import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public final class p {
    private static JSONArray a(List<f> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && !list.isEmpty()) {
            Iterator<f> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(it.next().a());
            }
        }
        return jSONArray;
    }

    private static JSONObject b(g gVar) {
        JSONObject jSONObject = new JSONObject();
        if (gVar == null) {
            return jSONObject;
        }
        JSONArray d16 = d(gVar.d());
        try {
            jSONObject.put("dimensions", a(gVar.b()));
            jSONObject.put("time", gVar.f());
            jSONObject.put("values", d16);
            return jSONObject;
        } catch (JSONException e16) {
            Log.w("TAB.TabMetricsLogBean", e16.toString());
            return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String c(ConcurrentHashMap<String, i> concurrentHashMap) {
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        concurrentHashMap2.putAll(concurrentHashMap);
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            for (Map.Entry entry : concurrentHashMap2.entrySet()) {
                String str = (String) entry.getKey();
                i iVar = (i) entry.getValue();
                if (TextUtils.equals(str, iVar.b())) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("logname", str);
                    ConcurrentHashMap<String, g> a16 = iVar.a();
                    JSONArray jSONArray2 = new JSONArray();
                    Iterator<Map.Entry<String, g>> it = a16.entrySet().iterator();
                    while (it.hasNext()) {
                        jSONArray2.mo162put(b(it.next().getValue()));
                    }
                    jSONObject2.put("content", jSONArray2);
                    jSONArray.mo162put(jSONObject2);
                }
            }
            jSONObject.put("log", jSONArray);
            return jSONObject.toString();
        } catch (JSONException e16) {
            Log.w("TAB.TabMetricsLogBean", e16.toString());
            return jSONObject.toString();
        }
    }

    private static JSONArray d(List<j> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && !list.isEmpty()) {
            for (j jVar : list) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("count", jVar.b());
                    jSONObject.put("policy", jVar.a().name());
                    jSONObject.put("value", jVar.d());
                    jSONArray.mo162put(jSONObject);
                } catch (JSONException e16) {
                    Log.w("TAB.TabMetricsLogBean", e16.toString());
                }
            }
        }
        return jSONArray;
    }
}
