package org.json;

import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.mobileqq.mini.cache.Entry;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONStringer;

/* compiled from: P */
/* loaded from: classes29.dex */
public class JSONArray {
    private final List<Object> values;

    public JSONArray() {
        this.values = new ArrayList();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof JSONArray) && ((JSONArray) obj).values.equals(this.values)) {
            return true;
        }
        return false;
    }

    public Object get(int i3) throws JSONException {
        try {
            Object obj = this.values.get(i3);
            if (obj != null) {
                return obj;
            }
            throw new JSONException("Value at " + i3 + " is null.");
        } catch (IndexOutOfBoundsException unused) {
            throw new JSONException("Index " + i3 + " out of range [0.." + this.values.size() + ")");
        }
    }

    public boolean getBoolean(int i3) throws JSONException {
        Object obj = get(i3);
        Boolean bool = JSON.toBoolean(obj);
        if (bool != null) {
            return bool.booleanValue();
        }
        throw JSON.typeMismatch(Integer.valueOf(i3), obj, HippyControllerProps.BOOLEAN);
    }

    public double getDouble(int i3) throws JSONException {
        Object obj = get(i3);
        Double d16 = JSON.toDouble(obj);
        if (d16 != null) {
            return d16.doubleValue();
        }
        throw JSON.typeMismatch(Integer.valueOf(i3), obj, "double");
    }

    public int getInt(int i3) throws JSONException {
        Object obj = get(i3);
        Integer integer = JSON.toInteger(obj);
        if (integer != null) {
            return integer.intValue();
        }
        throw JSON.typeMismatch(Integer.valueOf(i3), obj, PoiListCacheRecord.WEIGHT_TYPE);
    }

    public JSONArray getJSONArray(int i3) throws JSONException {
        Object obj = get(i3);
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        throw JSON.typeMismatch(Integer.valueOf(i3), obj, "JSONArray");
    }

    public JSONObject getJSONObject(int i3) throws JSONException {
        Object obj = get(i3);
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        throw JSON.typeMismatch(Integer.valueOf(i3), obj, "JSONObject");
    }

    public long getLong(int i3) throws JSONException {
        Object obj = get(i3);
        Long l3 = JSON.toLong(obj);
        if (l3 != null) {
            return l3.longValue();
        }
        throw JSON.typeMismatch(Integer.valueOf(i3), obj, PoiListCacheRecord.TIMESTAMP_TYPE);
    }

    public String getString(int i3) throws JSONException {
        Object obj = get(i3);
        String json = JSON.toString(obj);
        if (json != null) {
            return json;
        }
        throw JSON.typeMismatch(Integer.valueOf(i3), obj, Entry.DATA_TYPE_STRING);
    }

    public int hashCode() {
        return this.values.hashCode();
    }

    public boolean isNull(int i3) {
        Object opt = opt(i3);
        if (opt != null && opt != JSONObject.NULL) {
            return false;
        }
        return true;
    }

    public String join(String str) throws JSONException {
        JSONStringer jSONStringer = new JSONStringer();
        jSONStringer.open(JSONStringer.Scope.NULL, "");
        int size = this.values.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 > 0) {
                jSONStringer.out.append(str);
            }
            jSONStringer.value(this.values.get(i3));
        }
        JSONStringer.Scope scope = JSONStringer.Scope.NULL;
        jSONStringer.close(scope, scope, "");
        return jSONStringer.out.toString();
    }

    public int length() {
        return this.values.size();
    }

    public Object opt(int i3) {
        if (i3 >= 0 && i3 < this.values.size()) {
            return this.values.get(i3);
        }
        return null;
    }

    public boolean optBoolean(int i3) {
        return optBoolean(i3, false);
    }

    public double optDouble(int i3) {
        return optDouble(i3, Double.NaN);
    }

    public int optInt(int i3) {
        return optInt(i3, 0);
    }

    public JSONArray optJSONArray(int i3) {
        Object opt = opt(i3);
        if (opt instanceof JSONArray) {
            return (JSONArray) opt;
        }
        return null;
    }

    public JSONObject optJSONObject(int i3) {
        Object opt = opt(i3);
        if (opt instanceof JSONObject) {
            return (JSONObject) opt;
        }
        return null;
    }

    public long optLong(int i3) {
        return optLong(i3, 0L);
    }

    public String optString(int i3) {
        return optString(i3, "");
    }

    public JSONArray put(boolean z16) {
        this.values.add(Boolean.valueOf(z16));
        return this;
    }

    public Object remove(int i3) {
        if (i3 >= 0 && i3 < this.values.size()) {
            return this.values.remove(i3);
        }
        return null;
    }

    public JSONObject toJSONObject(JSONArray jSONArray) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        int min = Math.min(jSONArray.length(), this.values.size());
        if (min == 0) {
            return null;
        }
        for (int i3 = 0; i3 < min; i3++) {
            jSONObject.put(JSON.toString(jSONArray.opt(i3)), opt(i3));
        }
        return jSONObject;
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
        jSONStringer.array();
        Iterator<Object> it = this.values.iterator();
        while (it.hasNext()) {
            jSONStringer.value(it.next());
        }
        jSONStringer.endArray();
    }

    public boolean optBoolean(int i3, boolean z16) {
        Boolean bool = JSON.toBoolean(opt(i3));
        return bool != null ? bool.booleanValue() : z16;
    }

    public double optDouble(int i3, double d16) {
        Double d17 = JSON.toDouble(opt(i3));
        return d17 != null ? d17.doubleValue() : d16;
    }

    public int optInt(int i3, int i16) {
        Integer integer = JSON.toInteger(opt(i3));
        return integer != null ? integer.intValue() : i16;
    }

    public long optLong(int i3, long j3) {
        Long l3 = JSON.toLong(opt(i3));
        return l3 != null ? l3.longValue() : j3;
    }

    public String optString(int i3, String str) {
        String json = JSON.toString(opt(i3));
        return json != null ? json : str;
    }

    public JSONArray put(double d16) throws JSONException {
        this.values.add(Double.valueOf(JSON.checkDouble(d16)));
        return this;
    }

    public JSONArray(Collection collection) {
        this();
        if (collection != null) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                mo162put(JSONObject.wrap(it.next()));
            }
        }
    }

    public JSONArray put(int i3) {
        this.values.add(Integer.valueOf(i3));
        return this;
    }

    public JSONArray put(long j3) {
        this.values.add(Long.valueOf(j3));
        return this;
    }

    public String toString(int i3) throws JSONException {
        JSONStringer jSONStringer = new JSONStringer(i3);
        writeTo(jSONStringer);
        return jSONStringer.toString();
    }

    /* renamed from: put */
    public JSONArray mo162put(Object obj) {
        this.values.add(obj);
        return this;
    }

    public JSONArray(JSONTokener jSONTokener) throws JSONException {
        Object nextValue = jSONTokener.nextValue();
        if (nextValue instanceof JSONArray) {
            this.values = ((JSONArray) nextValue).values;
            return;
        }
        throw JSON.typeMismatch(nextValue, "JSONArray");
    }

    public JSONArray put(int i3, boolean z16) throws JSONException {
        return put(i3, Boolean.valueOf(z16));
    }

    public JSONArray put(int i3, double d16) throws JSONException {
        return put(i3, Double.valueOf(d16));
    }

    public JSONArray put(int i3, int i16) throws JSONException {
        return put(i3, Integer.valueOf(i16));
    }

    public JSONArray put(int i3, long j3) throws JSONException {
        return put(i3, Long.valueOf(j3));
    }

    public JSONArray put(int i3, Object obj) throws JSONException {
        if (obj instanceof Number) {
            JSON.checkDouble(((Number) obj).doubleValue());
        }
        while (this.values.size() <= i3) {
            this.values.add(null);
        }
        this.values.set(i3, obj);
        return this;
    }

    public JSONArray(String str) throws JSONException {
        this(new JSONTokener(str));
    }

    public JSONArray(Object obj) throws JSONException {
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            this.values = new ArrayList(length);
            for (int i3 = 0; i3 < length; i3++) {
                mo162put(JSONObject.wrap(Array.get(obj, i3)));
            }
            return;
        }
        throw new JSONException("Not a primitive array: " + obj.getClass());
    }
}
