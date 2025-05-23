package com.tencent.open.agent.util;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class o {
    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            t.e("ParseUtil", "parseInt text isEmpty");
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e16) {
            t.d("ParseUtil", "Exception", e16);
            return 0;
        }
    }

    public static JSONObject b(String str) throws JSONException {
        if (str.equals("false")) {
            str = "{value : false}";
        } else if (str.equals("true")) {
            str = "{value : true}";
        }
        if (str.contains("allback(")) {
            str = str.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
        }
        if (str.contains("online[0]=")) {
            str = "{online:" + str.charAt(str.length() - 2) + "}";
        }
        return new JSONObject(str);
    }

    public static long c(String str) {
        if (TextUtils.isEmpty(str)) {
            t.e("ParseUtil", "parseLong text = ", str);
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            t.e("ParseUtil", "parseLong text = ", str);
            return 0L;
        }
    }
}
