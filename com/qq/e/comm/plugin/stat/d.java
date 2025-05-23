package com.qq.e.comm.plugin.stat;

import android.text.TextUtils;
import com.qq.e.comm.plugin.k.y;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(JSONObject jSONObject, String str) {
        String jSONObject2;
        Object opt;
        int a16 = f.a();
        if (!y.a(jSONObject)) {
            return "";
        }
        try {
            jSONObject2 = jSONObject.toString();
            opt = jSONObject.opt(str);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        if (!(opt instanceof JSONObject)) {
            return jSONObject2;
        }
        JSONObject jSONObject3 = (JSONObject) opt;
        int a17 = a16 + a(jSONObject3);
        String jSONObject4 = jSONObject.toString();
        if (jSONObject4.length() <= a17) {
            return jSONObject4;
        }
        Iterator keys = jSONObject3.keys();
        while (keys.hasNext()) {
            keys.next();
            keys.remove();
            String jSONObject5 = jSONObject.toString();
            if (jSONObject5.length() <= a17) {
                return jSONObject5;
            }
        }
        jSONObject.remove(str);
        return jSONObject.toString();
    }

    private static int a(JSONObject jSONObject) {
        return a(jSONObject, "ej", f.b()) + 0 + a(jSONObject, "opensdk_param", f.c());
    }

    private static int a(JSONObject jSONObject, String str, int i3) {
        if (y.a(jSONObject) && jSONObject.has(str)) {
            String e16 = y.e(jSONObject, str);
            if (TextUtils.isEmpty(e16)) {
                return 0;
            }
            if (i3 < e16.length()) {
                jSONObject.remove(str);
            } else {
                return e16.length();
            }
        }
        return 0;
    }
}
