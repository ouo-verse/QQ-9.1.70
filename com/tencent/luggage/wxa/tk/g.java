package com.tencent.luggage.wxa.tk;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g {

    /* renamed from: b, reason: collision with root package name */
    public static Float f141496b;

    /* renamed from: a, reason: collision with root package name */
    public static DisplayMetrics f141495a = z.c().getResources().getDisplayMetrics();

    /* renamed from: c, reason: collision with root package name */
    public static boolean f141497c = true;

    public static int a(JSONArray jSONArray) {
        int argb;
        if (jSONArray == null || jSONArray.length() < 3) {
            return 0;
        }
        if (jSONArray.length() == 3) {
            argb = Color.rgb(jSONArray.optInt(0) & 255, jSONArray.optInt(1) & 255, jSONArray.optInt(2) & 255);
        } else {
            argb = Color.argb(jSONArray.optInt(3) & 255, jSONArray.optInt(0) & 255, jSONArray.optInt(1) & 255, jSONArray.optInt(2) & 255);
        }
        return f141497c ? com.tencent.luggage.wxa.h6.l.f126905a.a(argb) : argb;
    }

    public static int b(String str) {
        long parseLong;
        long parseLong2;
        if (!TextUtils.isEmpty(str)) {
            Map map = f.f141494a;
            if (map.containsKey(str)) {
                return ((Integer) map.get(str)).intValue();
            }
            if (str.charAt(0) == '#') {
                if (str.length() == 4) {
                    StringBuilder sb5 = new StringBuilder(str);
                    sb5.insert(2, str.charAt(1));
                    sb5.insert(4, str.charAt(2));
                    sb5.insert(6, str.charAt(3));
                    str = sb5.toString();
                }
                if (str.length() == 7) {
                    parseLong = Long.parseLong(str.substring(1), 16);
                    parseLong2 = -16777216;
                } else if (str.length() == 9) {
                    parseLong = Long.parseLong(str.substring(1, 7), 16);
                    parseLong2 = Long.parseLong(str.substring(7, 9), 16) << 24;
                } else {
                    w.f("MicroMsg.JsValueUtil", "hy: Unknown color, given string is %s", str);
                    throw new IllegalArgumentException("Unknown color");
                }
                return (int) (parseLong | parseLong2);
            }
            return Color.parseColor(str);
        }
        throw new IllegalArgumentException("colorString isEmpty");
    }

    public static int c(int i3) {
        return (int) Math.ceil(i3 / a());
    }

    public static int d(JSONArray jSONArray, int i3) {
        return d(null, jSONArray, i3);
    }

    public static int c(JSONObject jSONObject, String str) {
        return c((Context) null, jSONObject, str);
    }

    public static int d(Context context, JSONArray jSONArray, int i3) {
        return Math.round(a(context, (float) jSONArray.getDouble(i3)));
    }

    public static int c(Context context, JSONObject jSONObject, String str) {
        return Math.round(a(context, (float) jSONObject.getDouble(str)));
    }

    public static int c(JSONArray jSONArray, int i3) {
        return c((Context) null, jSONArray, i3);
    }

    public static int c(Context context, JSONArray jSONArray, int i3) {
        return a(context, jSONArray, i3, 0);
    }

    public static void c(float f16) {
        if (f16 > 0.0f) {
            f141496b = Float.valueOf(f16);
        }
    }

    public static int a(String str, int i3) {
        try {
            return b(str);
        } catch (Exception unused) {
            return i3;
        }
    }

    public static int a(String str) {
        return a(str, 0);
    }

    public static int a(Context context, int i3) {
        return (int) Math.ceil(i3 / a(context));
    }

    public static int a(int i3) {
        return Math.round(a() * i3);
    }

    public static float a(float f16) {
        return a() * f16;
    }

    public static float a(Context context, float f16) {
        return a(context) * f16;
    }

    public static int a(JSONObject jSONObject, String str, int i3) {
        return a((Context) null, jSONObject, str, i3);
    }

    public static int a(Context context, JSONObject jSONObject, String str, int i3) {
        if (jSONObject == null) {
            return i3;
        }
        try {
            return Math.round(a(context, (float) jSONObject.getDouble(str)));
        } catch (Exception unused) {
            return i3;
        }
    }

    public static float a(JSONObject jSONObject, String str) {
        return a((Context) null, jSONObject, str);
    }

    public static float a(Context context, JSONObject jSONObject, String str) {
        return a(context, jSONObject, str, 0.0f);
    }

    public static float a(JSONObject jSONObject, String str, float f16) {
        return a((Context) null, jSONObject, str, f16);
    }

    public static int b(int i3) {
        return (int) (i3 / a());
    }

    public static float a(Context context, JSONObject jSONObject, String str, float f16) {
        if (jSONObject == null) {
            return f16;
        }
        try {
            return a(context, (float) jSONObject.optDouble(str, f16));
        } catch (Exception unused) {
            return f16;
        }
    }

    public static float b(float f16) {
        return f16 / a();
    }

    public static float b(JSONObject jSONObject, String str) {
        return b((Context) null, jSONObject, str);
    }

    public static int a(Context context, JSONArray jSONArray, int i3, int i16) {
        if (jSONArray == null) {
            return i16;
        }
        try {
            return Math.round(a(context, (float) jSONArray.getDouble(i3)));
        } catch (Exception unused) {
            return i16;
        }
    }

    public static float b(Context context, JSONObject jSONObject, String str) {
        return a(context, (float) jSONObject.getDouble(str));
    }

    public static float a(JSONArray jSONArray, int i3) {
        return a((Context) null, jSONArray, i3);
    }

    public static float b(JSONArray jSONArray, int i3) {
        return b((Context) null, jSONArray, i3);
    }

    public static float a(Context context, JSONArray jSONArray, int i3) {
        return a(context, jSONArray, i3, 0.0f);
    }

    public static float b(Context context, JSONArray jSONArray, int i3) {
        return a(context, (float) jSONArray.getDouble(i3));
    }

    public static float a(Context context, JSONArray jSONArray, int i3, float f16) {
        if (jSONArray == null) {
            return f16;
        }
        try {
            return a(context, (float) jSONArray.getDouble(i3));
        } catch (Exception unused) {
            return f16;
        }
    }

    public static float a() {
        Float f16 = f141496b;
        if (f16 != null) {
            return f16.floatValue();
        }
        DisplayMetrics displayMetrics = f141495a;
        if (displayMetrics != null) {
            return displayMetrics.density;
        }
        return 1.0f;
    }

    public static float a(Context context) {
        if (context == null) {
            return a();
        }
        return context.getResources().getDisplayMetrics().density;
    }
}
