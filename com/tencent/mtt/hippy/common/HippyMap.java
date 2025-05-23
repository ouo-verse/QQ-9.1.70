package com.tencent.mtt.hippy.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Deprecated
/* loaded from: classes20.dex */
public class HippyMap {
    private final HashMap<String, Object> mDatas = new HashMap<>();

    public void clear() {
        this.mDatas.clear();
    }

    public boolean containsKey(String str) {
        return this.mDatas.containsKey(str);
    }

    public HippyMap copy() {
        HippyMap hippyMap = new HippyMap();
        for (Map.Entry<String, Object> entry : this.mDatas.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof HippyMap) {
                value = ((HippyMap) value).copy();
            } else if (value instanceof HippyArray) {
                value = ((HippyArray) value).copy();
            }
            hippyMap.pushObject(entry.getKey(), value);
        }
        return hippyMap;
    }

    public Set<Map.Entry<String, Object>> entrySet() {
        return this.mDatas.entrySet();
    }

    public Object get(String str) {
        return this.mDatas.get(str);
    }

    public HippyArray getArray(String str) {
        Object obj = this.mDatas.get(str);
        if (obj instanceof HippyArray) {
            return (HippyArray) obj;
        }
        return null;
    }

    public boolean getBoolean(String str) {
        Object obj = this.mDatas.get(str);
        if (obj != null && ((Boolean) obj).booleanValue()) {
            return true;
        }
        return false;
    }

    public double getDouble(String str) {
        Object obj = this.mDatas.get(str);
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        return 0.0d;
    }

    public int getInt(String str) {
        Object obj = this.mDatas.get(str);
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        return 0;
    }

    public long getLong(String str) {
        Object obj = this.mDatas.get(str);
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        return 0L;
    }

    public HippyMap getMap(String str) {
        Object obj = this.mDatas.get(str);
        if (obj instanceof HippyMap) {
            return (HippyMap) obj;
        }
        return null;
    }

    public String getString(String str) {
        Object obj = this.mDatas.get(str);
        if (obj == null) {
            return null;
        }
        return String.valueOf(obj);
    }

    public boolean isNull(String str) {
        if (this.mDatas.get(str) == null) {
            return true;
        }
        return false;
    }

    public Set<String> keySet() {
        return this.mDatas.keySet();
    }

    public void pushAll(HippyMap hippyMap) {
        if (hippyMap != null) {
            this.mDatas.putAll(hippyMap.mDatas);
        }
    }

    public void pushArray(String str, HippyArray hippyArray) {
        this.mDatas.put(str, hippyArray);
    }

    public void pushBoolean(String str, boolean z16) {
        this.mDatas.put(str, Boolean.valueOf(z16));
    }

    public void pushDouble(String str, double d16) {
        this.mDatas.put(str, Double.valueOf(d16));
    }

    public void pushInt(String str, int i3) {
        this.mDatas.put(str, Integer.valueOf(i3));
    }

    public void pushJSONObject(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                Object opt = jSONObject.opt(obj);
                if (jSONObject.isNull(obj)) {
                    pushNull(obj);
                } else if (opt instanceof JSONObject) {
                    HippyMap hippyMap = new HippyMap();
                    hippyMap.pushJSONObject((JSONObject) opt);
                    pushMap(obj, hippyMap);
                } else if (opt instanceof JSONArray) {
                    HippyArray hippyArray = new HippyArray();
                    hippyArray.pushJSONArray((JSONArray) opt);
                    pushArray(obj, hippyArray);
                } else {
                    pushObject(obj, opt);
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void pushLong(String str, long j3) {
        this.mDatas.put(str, Long.valueOf(j3));
    }

    public void pushMap(String str, HippyMap hippyMap) {
        this.mDatas.put(str, hippyMap);
    }

    public void pushNull(String str) {
        this.mDatas.put(str, null);
    }

    public void pushObject(String str, Object obj) {
        int intValue;
        double doubleValue;
        if (obj == null) {
            pushNull(str);
            return;
        }
        if (obj instanceof String) {
            pushString(str, (String) obj);
            return;
        }
        if (obj instanceof HippyMap) {
            pushMap(str, (HippyMap) obj);
            return;
        }
        if (obj instanceof HippyArray) {
            pushArray(str, (HippyArray) obj);
            return;
        }
        if (!(obj instanceof Integer)) {
            if (!(obj instanceof Boolean)) {
                if (!(obj instanceof Double)) {
                    if (!(obj instanceof Float)) {
                        if (!(obj instanceof Long)) {
                            if (obj instanceof Byte) {
                                intValue = ((Byte) obj).intValue();
                                pushInt(str, intValue);
                            }
                            Class<?> cls = obj.getClass();
                            if (!cls.isAssignableFrom(Integer.TYPE)) {
                                if (!cls.isAssignableFrom(Boolean.TYPE)) {
                                    if (!cls.isAssignableFrom(Double.TYPE)) {
                                        if (!cls.isAssignableFrom(Float.TYPE)) {
                                            if (!cls.isAssignableFrom(Long.TYPE)) {
                                                throw new RuntimeException("push unsupported object into HippyMap");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        pushLong(str, ((Long) obj).longValue());
                        return;
                    }
                    doubleValue = ((Number) obj).doubleValue();
                    pushDouble(str, doubleValue);
                    return;
                }
                doubleValue = ((Double) obj).doubleValue();
                pushDouble(str, doubleValue);
                return;
            }
            pushBoolean(str, ((Boolean) obj).booleanValue());
            return;
        }
        intValue = ((Integer) obj).intValue();
        pushInt(str, intValue);
    }

    public void pushString(String str, String str2) {
        this.mDatas.put(str, str2);
    }

    public void remove(String str) {
        this.mDatas.remove(str);
    }

    public int size() {
        return this.mDatas.size();
    }

    public HippyArray toHippyArray() {
        if (size() == 0) {
            return null;
        }
        HippyArray hippyArray = new HippyArray();
        for (Map.Entry<String, Object> entry : entrySet()) {
            hippyArray.pushObject(entry.getKey());
            hippyArray.pushObject(entry.getValue());
        }
        return hippyArray;
    }

    public JSONObject toJSONObject() {
        Object value;
        JSONObject jSONObject = new JSONObject();
        if (size() <= 0) {
            return jSONObject;
        }
        for (Map.Entry<String, Object> entry : entrySet()) {
            try {
                String key = entry.getKey();
                if (entry.getValue() instanceof HippyMap) {
                    value = ((HippyMap) entry.getValue()).toJSONObject();
                } else if (entry.getValue() instanceof HippyArray) {
                    value = ((HippyArray) entry.getValue()).toJSONArray();
                } else {
                    value = entry.getValue();
                }
                jSONObject.put(key, value);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return jSONObject;
    }

    public String toString() {
        return this.mDatas.toString();
    }
}
