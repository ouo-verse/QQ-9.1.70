package com.tencent.tdf.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TDFListUtils {
    static IPatchRedirector $redirector_;

    public TDFListUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static List<Object> fromJsonArray(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() != 0) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    Object opt = jSONArray.opt(i3);
                    if (opt == null) {
                        arrayList.add(null);
                    } else if (opt instanceof JSONObject) {
                        arrayList.add(TDFMapUtils.fromJsonObject((JSONObject) opt));
                    } else if (opt instanceof JSONArray) {
                        arrayList.add(fromJsonArray((JSONArray) opt));
                    } else {
                        arrayList.add(opt);
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public static List<Object> fromJsonStr(String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            try {
                return fromJsonArray(new JSONArray(str));
            } catch (JSONException e16) {
                e16.printStackTrace();
                return arrayList;
            }
        }
        return arrayList;
    }

    public static List<Object> getArray(List<Object> list, int i3) {
        if (list.size() <= i3) {
            return null;
        }
        Object obj = list.get(i3);
        if (!(obj instanceof List)) {
            return null;
        }
        return (List) obj;
    }

    public static boolean getBoolean(List<Object> list, int i3) {
        if (list.size() <= i3) {
            return false;
        }
        Object obj = list.get(i3);
        if (!(obj instanceof Boolean) || !((Boolean) obj).booleanValue()) {
            return false;
        }
        return true;
    }

    public static double getDouble(List<Object> list, int i3) {
        if (list.size() <= i3) {
            return 0.0d;
        }
        Object obj = list.get(i3);
        if (!(obj instanceof Number)) {
            return 0.0d;
        }
        return ((Number) obj).doubleValue();
    }

    public static float getFloat(List<Object> list, int i3) {
        if (list.size() <= i3) {
            return 0.0f;
        }
        Object obj = list.get(i3);
        if (!(obj instanceof Number)) {
            return 0.0f;
        }
        return ((Number) obj).floatValue();
    }

    public static int getInt(List<Object> list, int i3) {
        if (list.size() <= i3) {
            return 0;
        }
        Object obj = list.get(i3);
        if (!(obj instanceof Number)) {
            return 0;
        }
        return ((Number) obj).intValue();
    }

    public static long getLong(List<Object> list, int i3) {
        if (list.size() <= i3) {
            return 0L;
        }
        Object obj = list.get(i3);
        if (!(obj instanceof Number)) {
            return 0L;
        }
        return ((Number) obj).longValue();
    }

    public static Map<String, Object> getMap(List<Object> list, int i3) {
        try {
            if (list.size() > i3) {
                Object obj = list.get(i3);
                if (!(obj instanceof Map)) {
                    return null;
                }
                return (Map) obj;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return null;
    }

    public static Object getObject(List<Object> list, int i3) {
        if (list.size() > i3) {
            return list.get(i3);
        }
        return null;
    }

    public static String getString(List<Object> list, int i3) {
        Object obj;
        if (list.size() > i3 && (obj = list.get(i3)) != null) {
            return String.valueOf(obj);
        }
        return null;
    }

    public static JSONArray toJSONArray(List<Object> list) {
        JSONArray jSONArray = new JSONArray();
        if (list.size() == 0) {
            return jSONArray;
        }
        try {
            for (Object obj : list) {
                if (obj instanceof Map) {
                    jSONArray.mo162put(TDFMapUtils.toJSONObject((Map) obj));
                } else if (obj instanceof List) {
                    jSONArray.mo162put(toJSONArray((List) obj));
                } else {
                    jSONArray.mo162put(obj);
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return jSONArray;
    }
}
