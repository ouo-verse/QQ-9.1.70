package com.tencent.gamematrix.gmcg.base.utils;

import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGJsonUtil {
    public static final String defaultIcon = "http://a.hiphotos.baidu.com/image/pic/item/77094b36acaf2eddd3ef78ee8e1001e93901939e.jpg";
    public static final int defaultInt = 0;
    public static final String defaultNumber = "1";
    public static final String defaultString = "";
    private static final Gson sGson = new Gson();

    public static Boolean checkErrCode(JSONObject jSONObject) throws JSONException {
        return Boolean.valueOf(jSONObject.getString("errCode").equals("0"));
    }

    public static <T> T fromJson(String str, Class<?> cls) {
        try {
            return (T) sGson.fromJson(str, (Class) cls);
        } catch (Exception e16) {
            CGLog.e(CGStringUtil.format("CGJsonUtil.fromJson(%s, %s) failed: %s", str, cls.getSimpleName(), e16.getMessage()));
            return null;
        }
    }

    public static boolean getBoolFromJsonObject(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getBoolean(str);
        } catch (JSONException unused) {
            return false;
        }
    }

    public static double getDoubleFromJsonObject(JSONObject jSONObject, String str, double d16) {
        try {
            return jSONObject.getDouble(str);
        } catch (Exception unused) {
            return d16;
        }
    }

    public static int getIntFromJsonObject(JSONObject jSONObject, String str) {
        return getIntFromJsonObject(jSONObject, str, 0);
    }

    public static JSONArray getJSONArrayFromString(String str) {
        try {
            return (JSONArray) new JSONTokener(str).nextValue();
        } catch (Exception e16) {
            e16.printStackTrace();
            return new JSONArray();
        }
    }

    public static JSONArray getJsonArray(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getJSONArray(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            return new JSONArray();
        }
    }

    public static JSONArray getJsonArrayFromJsonArray(JSONArray jSONArray, int i3) {
        try {
            return jSONArray.getJSONArray(i3);
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONArray getJsonArrayFromJsonObject(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getJSONArray(str);
        } catch (Exception unused) {
            return new JSONArray();
        }
    }

    public static JSONObject getJsonObjectFromJsonArray(JSONArray jSONArray, int i3) {
        try {
            return jSONArray.getJSONObject(i3);
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject getJsonObjectFromJsonObject(JSONObject jSONObject, String str) {
        try {
            return (JSONObject) new JSONTokener(getStringFromJsonObject(jSONObject, str)).nextValue();
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject getJsonObjectFromString(String str) {
        try {
            return (JSONObject) new JSONTokener(str).nextValue();
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static long getLongFromJsonObject(JSONObject jSONObject, String str, long j3) {
        try {
            return jSONObject.getLong(str);
        } catch (Exception unused) {
            return j3;
        }
    }

    public static ArrayList<String> getPictureUrls(JSONObject jSONObject, String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        splitPictureUrls(getStringFromJsonObject(jSONObject, str, ""), arrayList);
        return arrayList;
    }

    public static String[] getStringArrayFromJsonObject(JSONObject jSONObject, String str) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            int length = jSONArray.length();
            if (length > 0) {
                String[] strArr = new String[length];
                for (int i3 = 0; i3 < length; i3++) {
                    strArr[i3] = jSONArray.getString(i3);
                }
                return strArr;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return new String[0];
    }

    public static String getStringFromJsonArray(JSONArray jSONArray, int i3) {
        try {
            return jSONArray.getString(i3);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getStringFromJsonObject(JSONObject jSONObject, String str, String str2) {
        try {
            String string = jSONObject.getString(str);
            return string.equals("null") ? "0" : string;
        } catch (Exception unused) {
            return str2;
        }
    }

    private static void splitPictureUrls(String str, ArrayList<String> arrayList) {
        String[] split = str.split("\\|");
        if (!split[0].equals("")) {
            arrayList.addAll(Arrays.asList(split));
        }
    }

    @Nullable
    public static JSONObject toJSONObject(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String toJson(Object obj) {
        try {
            return sGson.toJson(obj);
        } catch (Exception e16) {
            CGLog.e(CGStringUtil.format("CGJsonUtil.toJson failed: %s", e16.getMessage()));
            return "";
        }
    }

    public static boolean getBoolFromJsonObject(JSONObject jSONObject, String str, boolean z16) {
        try {
            return jSONObject.getBoolean(str);
        } catch (JSONException unused) {
            return z16;
        }
    }

    public static int getIntFromJsonObject(JSONObject jSONObject, String str, int i3) {
        try {
            return jSONObject.getInt(str);
        } catch (Exception unused) {
            return i3;
        }
    }

    public static <T> T fromJson(String str, Type type) {
        try {
            return (T) sGson.fromJson(str, type);
        } catch (Exception e16) {
            CGLog.e(CGStringUtil.format("CGJsonUtil.fromJson(%s, %s) failed: %s", str, type, e16.getMessage()));
            return null;
        }
    }

    public static String getStringFromJsonObject(JSONObject jSONObject, String str) {
        return getStringFromJsonObject(jSONObject, str, "");
    }
}
