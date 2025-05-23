package a25;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f25416a = Logger.getLogger(a.class.getName());

    /* compiled from: P */
    /* renamed from: a25.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public static class C0004a {

        /* renamed from: a, reason: collision with root package name */
        public c f25417a;

        /* renamed from: b, reason: collision with root package name */
        public byte[][] f25418b;
    }

    private static Object a(Object obj, List<byte[]> list) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("_placeholder", true);
                jSONObject.put(WidgetCacheConstellationData.NUM, list.size());
                list.add((byte[]) obj);
                return jSONObject;
            } catch (JSONException e16) {
                f25416a.log(Level.WARNING, "An error occured while putting data to JSONObject", (Throwable) e16);
                return null;
            }
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = (JSONArray) obj;
            int length = jSONArray2.length();
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    jSONArray.put(i3, a(jSONArray2.get(i3), list));
                } catch (JSONException e17) {
                    f25416a.log(Level.WARNING, "An error occured while putting packet data to JSONObject", (Throwable) e17);
                    return null;
                }
            }
            return jSONArray;
        }
        if (obj instanceof JSONObject) {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = (JSONObject) obj;
            Iterator keys = jSONObject3.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                try {
                    jSONObject2.put(str, a(jSONObject3.get(str), list));
                } catch (JSONException e18) {
                    f25416a.log(Level.WARNING, "An error occured while putting data to JSONObject", (Throwable) e18);
                    return null;
                }
            }
            return jSONObject2;
        }
        return obj;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
    public static C0004a b(c cVar) {
        ArrayList arrayList = new ArrayList();
        cVar.f25423d = a(cVar.f25423d, arrayList);
        cVar.f25424e = arrayList.size();
        C0004a c0004a = new C0004a();
        c0004a.f25417a = cVar;
        c0004a.f25418b = (byte[][]) arrayList.toArray(new byte[arrayList.size()]);
        return c0004a;
    }
}
