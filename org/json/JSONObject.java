package org.json;

import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.mobileqq.mini.cache.Entry;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONStringer;

/* compiled from: P */
/* loaded from: classes29.dex */
public class JSONObject {
    private static final Double NEGATIVE_ZERO = Double.valueOf(-0.0d);
    public static final Object NULL = new Object() { // from class: org.json.JSONObject.1
        public boolean equals(Object obj) {
            if (obj != this && obj != null) {
                return false;
            }
            return true;
        }

        public String toString() {
            return "null";
        }
    };
    private final Map<String, Object> nameValuePairs;

    public JSONObject() {
        this.nameValuePairs = new HashMap();
    }

    public static String numberToString(Number number) throws JSONException {
        if (number != null) {
            double doubleValue = number.doubleValue();
            JSON.checkDouble(doubleValue);
            if (number.equals(NEGATIVE_ZERO)) {
                return "-0";
            }
            long longValue = number.longValue();
            if (doubleValue == longValue) {
                return Long.toString(longValue);
            }
            return number.toString();
        }
        throw new JSONException("Number must be non-null");
    }

    public static String quote(String str) {
        if (str == null) {
            return "\"\"";
        }
        try {
            JSONStringer jSONStringer = new JSONStringer();
            JSONStringer.Scope scope = JSONStringer.Scope.NULL;
            jSONStringer.open(scope, "");
            jSONStringer.value(str);
            jSONStringer.close(scope, scope, "");
            return jSONStringer.toString();
        } catch (JSONException unused) {
            throw new AssertionError();
        }
    }

    public static Object wrap(Object obj) {
        if (obj == null) {
            return NULL;
        }
        if (!(obj instanceof JSONArray) && !(obj instanceof JSONObject)) {
            if (obj.equals(NULL)) {
                return obj;
            }
            if (obj instanceof Collection) {
                return new JSONArray((Collection) obj);
            }
            if (obj.getClass().isArray()) {
                return new JSONArray(obj);
            }
            if (obj instanceof Map) {
                return new JSONObject((Map) obj);
            }
            if (!(obj instanceof Boolean) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short) && !(obj instanceof String)) {
                if (obj.getClass().getPackage().getName().startsWith("java.")) {
                    return obj.toString();
                }
                return null;
            }
            return obj;
        }
        return obj;
    }

    public JSONObject accumulate(String str, Object obj) throws JSONException {
        Object obj2 = this.nameValuePairs.get(checkName(str));
        if (obj2 == null) {
            return put(str, obj);
        }
        if (obj instanceof Number) {
            JSON.checkDouble(((Number) obj).doubleValue());
        }
        if (obj2 instanceof JSONArray) {
            ((JSONArray) obj2).mo162put(obj);
        } else {
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put(obj2);
            jSONArray.mo162put(obj);
            this.nameValuePairs.put(str, jSONArray);
        }
        return this;
    }

    String checkName(String str) throws JSONException {
        if (str != null) {
            return str;
        }
        throw new JSONException("Names must be non-null");
    }

    public Object get(String str) throws JSONException {
        Object obj = this.nameValuePairs.get(str);
        if (obj != null) {
            return obj;
        }
        throw new JSONException("No value for " + str);
    }

    public boolean getBoolean(String str) throws JSONException {
        Object obj = get(str);
        Boolean bool = JSON.toBoolean(obj);
        if (bool != null) {
            return bool.booleanValue();
        }
        throw JSON.typeMismatch(str, obj, HippyControllerProps.BOOLEAN);
    }

    public double getDouble(String str) throws JSONException {
        Object obj = get(str);
        Double d16 = JSON.toDouble(obj);
        if (d16 != null) {
            return d16.doubleValue();
        }
        throw JSON.typeMismatch(str, obj, "double");
    }

    public int getInt(String str) throws JSONException {
        Object obj = get(str);
        Integer integer = JSON.toInteger(obj);
        if (integer != null) {
            return integer.intValue();
        }
        throw JSON.typeMismatch(str, obj, PoiListCacheRecord.WEIGHT_TYPE);
    }

    public JSONArray getJSONArray(String str) throws JSONException {
        Object obj = get(str);
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        throw JSON.typeMismatch(str, obj, "JSONArray");
    }

    public JSONObject getJSONObject(String str) throws JSONException {
        Object obj = get(str);
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        throw JSON.typeMismatch(str, obj, "JSONObject");
    }

    public long getLong(String str) throws JSONException {
        Object obj = get(str);
        Long l3 = JSON.toLong(obj);
        if (l3 != null) {
            return l3.longValue();
        }
        throw JSON.typeMismatch(str, obj, PoiListCacheRecord.TIMESTAMP_TYPE);
    }

    public String getString(String str) throws JSONException {
        Object obj = get(str);
        String json = JSON.toString(obj);
        if (json != null) {
            return json;
        }
        throw JSON.typeMismatch(str, obj, Entry.DATA_TYPE_STRING);
    }

    public boolean has(String str) {
        return this.nameValuePairs.containsKey(str);
    }

    public boolean isNull(String str) {
        Object obj = this.nameValuePairs.get(str);
        if (obj != null && obj != NULL) {
            return false;
        }
        return true;
    }

    public Iterator keys() {
        return this.nameValuePairs.keySet().iterator();
    }

    public int length() {
        return this.nameValuePairs.size();
    }

    public JSONArray names() {
        if (this.nameValuePairs.isEmpty()) {
            return null;
        }
        return new JSONArray((Collection) new ArrayList(this.nameValuePairs.keySet()));
    }

    public Object opt(String str) {
        return this.nameValuePairs.get(str);
    }

    public boolean optBoolean(String str) {
        return optBoolean(str, false);
    }

    public double optDouble(String str) {
        return optDouble(str, Double.NaN);
    }

    public int optInt(String str) {
        return optInt(str, 0);
    }

    public JSONArray optJSONArray(String str) {
        Object opt = opt(str);
        if (opt instanceof JSONArray) {
            return (JSONArray) opt;
        }
        return null;
    }

    public JSONObject optJSONObject(String str) {
        Object opt = opt(str);
        if (opt instanceof JSONObject) {
            return (JSONObject) opt;
        }
        return null;
    }

    public long optLong(String str) {
        return optLong(str, 0L);
    }

    public String optString(String str) {
        return optString(str, "");
    }

    public JSONObject put(String str, boolean z16) throws JSONException {
        this.nameValuePairs.put(checkName(str), Boolean.valueOf(z16));
        return this;
    }

    public JSONObject putOpt(String str, Object obj) throws JSONException {
        if (str != null && obj != null) {
            return put(str, obj);
        }
        return this;
    }

    public Object remove(String str) {
        return this.nameValuePairs.remove(str);
    }

    public JSONArray toJSONArray(JSONArray jSONArray) throws JSONException {
        int length;
        JSONArray jSONArray2 = new JSONArray();
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return null;
        }
        for (int i3 = 0; i3 < length; i3++) {
            jSONArray2.mo162put(opt(JSON.toString(jSONArray.opt(i3))));
        }
        return jSONArray2;
    }

    public String toString() {
        try {
            JSONStringer jSONStringer = new JSONStringer();
            writeTo(jSONStringer);
            return jSONStringer.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeTo(JSONStringer jSONStringer) throws JSONException {
        jSONStringer.object();
        for (Map.Entry<String, Object> entry : this.nameValuePairs.entrySet()) {
            jSONStringer.key(entry.getKey()).value(entry.getValue());
        }
        jSONStringer.endObject();
    }

    public boolean optBoolean(String str, boolean z16) {
        Boolean bool = JSON.toBoolean(opt(str));
        return bool != null ? bool.booleanValue() : z16;
    }

    public double optDouble(String str, double d16) {
        Double d17 = JSON.toDouble(opt(str));
        return d17 != null ? d17.doubleValue() : d16;
    }

    public int optInt(String str, int i3) {
        Integer integer = JSON.toInteger(opt(str));
        return integer != null ? integer.intValue() : i3;
    }

    public long optLong(String str, long j3) {
        Long l3 = JSON.toLong(opt(str));
        return l3 != null ? l3.longValue() : j3;
    }

    public String optString(String str, String str2) {
        String json = JSON.toString(opt(str));
        return json != null ? json : str2;
    }

    public JSONObject put(String str, double d16) throws JSONException {
        this.nameValuePairs.put(checkName(str), Double.valueOf(JSON.checkDouble(d16)));
        return this;
    }

    public JSONObject(Map map) {
        this();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str != null) {
                this.nameValuePairs.put(str, wrap(entry.getValue()));
            } else {
                throw new NullPointerException("key == null");
            }
        }
    }

    public JSONObject put(String str, int i3) throws JSONException {
        this.nameValuePairs.put(checkName(str), Integer.valueOf(i3));
        return this;
    }

    public JSONObject put(String str, long j3) throws JSONException {
        this.nameValuePairs.put(checkName(str), Long.valueOf(j3));
        return this;
    }

    public String toString(int i3) throws JSONException {
        JSONStringer jSONStringer = new JSONStringer(i3);
        writeTo(jSONStringer);
        return jSONStringer.toString();
    }

    public JSONObject put(String str, Object obj) throws JSONException {
        if (obj == null) {
            this.nameValuePairs.remove(str);
            return this;
        }
        if (obj instanceof Number) {
            JSON.checkDouble(((Number) obj).doubleValue());
        }
        this.nameValuePairs.put(checkName(str), obj);
        return this;
    }

    public JSONObject(JSONTokener jSONTokener) throws JSONException {
        Object nextValue = jSONTokener.nextValue();
        if (nextValue instanceof JSONObject) {
            this.nameValuePairs = ((JSONObject) nextValue).nameValuePairs;
            return;
        }
        throw JSON.typeMismatch(nextValue, "JSONObject");
    }

    public JSONObject(String str) throws JSONException {
        this(new JSONTokener(str));
    }

    public JSONObject(JSONObject jSONObject, String[] strArr) throws JSONException {
        this();
        for (String str : strArr) {
            Object opt = jSONObject.opt(str);
            if (opt != null) {
                this.nameValuePairs.put(str, opt);
            }
        }
    }
}
