package com.google.android.apps.internal.games.memoryadvice;

import android.content.res.AssetManager;
import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
class a {
    private static Map<String, SortedSet<Long>> a(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            JSONObject jSONObject2 = jSONObject.getJSONObject((String) keys.next()).getJSONObject("baseline");
            Iterator keys2 = jSONObject2.keys();
            while (keys2.hasNext()) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject((String) keys2.next());
                Iterator keys3 = jSONObject3.keys();
                while (keys3.hasNext()) {
                    String str = (String) keys3.next();
                    if (!hashMap.containsKey(str)) {
                        hashMap.put(str, new TreeSet());
                    }
                    ((SortedSet) hashMap.get(str)).add(Long.valueOf(jSONObject3.getLong(str)));
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject b(AssetManager assetManager, JSONObject jSONObject, JSONObject jSONObject2) {
        String d16;
        JSONObject jSONObject3 = new JSONObject();
        try {
            JSONObject jSONObject4 = new JSONObject(e.f(assetManager.open("memoryadvice/lookup.json")));
            String optString = jSONObject.optString("matchStrategy", "fingerprint");
            if ("fingerprint".equals(optString)) {
                d16 = e(jSONObject4);
            } else if ("baseline".equals(optString)) {
                d16 = d(jSONObject4, jSONObject2);
            } else {
                throw new IllegalStateException("Unknown match strategy " + optString);
            }
            jSONObject3.put("limits", jSONObject4.getJSONObject(d16));
            jSONObject3.put("matched", d16);
            jSONObject3.put("fingerprint", Build.FINGERPRINT);
        } catch (IOException | JSONException e16) {
            Log.w("Profile problem.", e16);
        }
        return jSONObject3;
    }

    private static int c(Iterable<Long> iterable, long j3) {
        Iterator<Long> it = iterable.iterator();
        int i3 = 0;
        while (it.hasNext() && it.next().longValue() <= j3) {
            i3++;
        }
        return i3;
    }

    private static String d(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = jSONObject2;
        Map<String, SortedSet<Long>> a16 = a(jSONObject);
        Iterator keys = jSONObject.keys();
        float f16 = Float.MAX_VALUE;
        String str = null;
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            JSONObject jSONObject4 = jSONObject.getJSONObject(str2).getJSONObject("baseline");
            Iterator keys2 = jSONObject4.keys();
            float f17 = 0.0f;
            int i3 = 0;
            while (keys2.hasNext()) {
                String str3 = (String) keys2.next();
                if (jSONObject3.has(str3)) {
                    JSONObject jSONObject5 = jSONObject4.getJSONObject(str3);
                    JSONObject jSONObject6 = jSONObject3.getJSONObject(str3);
                    Iterator keys3 = jSONObject5.keys();
                    while (keys3.hasNext()) {
                        String str4 = (String) keys3.next();
                        if (jSONObject6.has(str4)) {
                            i3++;
                            SortedSet<Long> sortedSet = a16.get(str4);
                            f17 += Math.abs(c(sortedSet, jSONObject5.getLong(str4)) - c(sortedSet, jSONObject6.getLong(str4))) / sortedSet.size();
                            a16 = a16;
                            keys = keys;
                        }
                    }
                    jSONObject3 = jSONObject2;
                }
            }
            Map<String, SortedSet<Long>> map = a16;
            Iterator it = keys;
            if (i3 > 0) {
                f17 /= i3;
            }
            if (f17 < f16) {
                str = str2;
                f16 = f17;
            }
            jSONObject3 = jSONObject2;
            a16 = map;
            keys = it;
        }
        return str;
    }

    private static String e(JSONObject jSONObject) {
        Iterator keys = jSONObject.keys();
        int i3 = -1;
        String str = null;
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            int f16 = f(Build.FINGERPRINT, str2);
            if (f16 > i3) {
                str = str2;
                i3 = f16;
            }
        }
        return str;
    }

    private static int f(CharSequence charSequence, CharSequence charSequence2) {
        int i3 = 0;
        while (i3 < charSequence.length() && i3 < charSequence2.length()) {
            if (charSequence.charAt(i3) != charSequence2.charAt(i3)) {
                return i3;
            }
            i3++;
        }
        return i3;
    }
}
