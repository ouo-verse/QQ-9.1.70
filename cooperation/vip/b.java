package cooperation.vip;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b {
    public static ArrayList<Object> a(JSONArray jSONArray) throws JSONException {
        if (jSONArray != null && jSONArray.length() != 0) {
            ArrayList<Object> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                Object opt = jSONArray.opt(i3);
                if (opt != null) {
                    if (opt.getClass() == JSONObject.class) {
                        arrayList.add(b((JSONObject) opt));
                    } else if (opt.getClass() == JSONArray.class) {
                        arrayList.add(a((JSONArray) opt));
                    }
                }
            }
            return arrayList;
        }
        return null;
    }

    public static Map<String, Object> b(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = keys.next() + "";
            Object obj = jSONObject.get(str);
            if (obj != null) {
                if (obj.getClass() == JSONObject.class) {
                    linkedHashMap.put(str, b((JSONObject) obj));
                } else if (obj.getClass() == JSONArray.class) {
                    linkedHashMap.put(str, a((JSONArray) obj));
                } else {
                    linkedHashMap.put(str, obj);
                }
            }
        }
        return linkedHashMap;
    }

    public static Map<String, Object> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            return b(new JSONObject(str));
        } catch (Exception e16) {
            e16.printStackTrace();
            return linkedHashMap;
        }
    }
}
