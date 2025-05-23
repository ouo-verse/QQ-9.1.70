package com.tencent.luggage.wxa.xa;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public class k implements c {

    /* renamed from: a, reason: collision with root package name */
    public JsonObject f144655a;

    public k() {
        this.f144655a = new JsonObject();
    }

    @Override // com.tencent.luggage.wxa.xa.c
    /* renamed from: a */
    public c put(String str, boolean z16) {
        this.f144655a.add(str, z16);
        return this;
    }

    @Override // com.tencent.luggage.wxa.xa.c
    /* renamed from: b */
    public c putOpt(String str, Object obj) {
        i.a(this.f144655a, str, obj);
        return this;
    }

    @Override // com.tencent.luggage.wxa.xa.c
    /* renamed from: c */
    public c optJSONObject(String str) {
        JsonValue jsonValue = this.f144655a.get(str);
        if (jsonValue == null) {
            return null;
        }
        return new k(jsonValue.asObject());
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public String d(String str) {
        if (str != null) {
            return str;
        }
        throw new f("Names must be non-null");
    }

    @Override // com.tencent.luggage.wxa.xa.c
    /* renamed from: e */
    public a getJSONArray(String str) {
        JsonValue jsonValue = this.f144655a.get(str);
        if (jsonValue != null) {
            return new j(jsonValue.asArray());
        }
        throw new f(String.format("key %s do not exist.", str));
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public Object get(String str) {
        return opt(str);
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public boolean getBoolean(String str) {
        JsonValue jsonValue = this.f144655a.get(str);
        if (jsonValue != null) {
            if (jsonValue.isBoolean()) {
                return jsonValue.asBoolean();
            }
            if (jsonValue.isString()) {
                String jsonValue2 = jsonValue.toString();
                if ("true".equals(jsonValue2)) {
                    return true;
                }
                if ("false".equals(jsonValue2)) {
                    return false;
                }
            }
            throw new f(String.format("getBoolean by key : %s error, value : %s", str, jsonValue));
        }
        throw new f(String.format("key %s do not exist.", str));
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public double getDouble(String str) {
        JsonValue jsonValue = this.f144655a.get(str);
        if (jsonValue != null) {
            if (jsonValue.isNumber()) {
                return jsonValue.asDouble();
            }
            if (jsonValue.isString()) {
                return Double.parseDouble(jsonValue.toString());
            }
            throw new f(String.format("getDouble by key : %s error, value : %s", str, jsonValue));
        }
        throw new f(String.format("key %s do not exist.", str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v6, types: [int] */
    @Override // com.tencent.luggage.wxa.xa.c
    public int getInt(String str) {
        JsonValue jsonValue = this.f144655a.get(str);
        if (jsonValue != null) {
            if (jsonValue.isNumber()) {
                try {
                    str = jsonValue.asInt();
                    return str;
                } catch (Exception unused) {
                    return (int) jsonValue.asDouble();
                }
            }
            if (jsonValue.isString()) {
                return (int) Double.parseDouble(jsonValue.toString());
            }
            throw new f(String.format("getInt by key : %s error, value : %s", new Object[]{str, jsonValue}));
        }
        throw new f(String.format("key %s do not exist.", str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.eclipsesource.json.JsonValue] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v7, types: [long] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[]] */
    @Override // com.tencent.luggage.wxa.xa.c
    public long getLong(String str) {
        ?? r06 = this.f144655a.get(str);
        if (r06 != 0) {
            if (r06.isNumber()) {
                try {
                    r06 = r06.asLong();
                    return r06;
                } catch (Exception unused) {
                    return (long) r06.asDouble();
                }
            }
            if (r06.isString()) {
                return (long) Double.parseDouble(r06.toString());
            }
            throw new f(String.format("getLong by key : %s error, value : %s", new Object[]{str, r06}));
        }
        throw new f(String.format("key %s do not exist.", str));
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public String getString(String str) {
        JsonValue jsonValue = this.f144655a.get(str);
        if (jsonValue != null) {
            if (jsonValue.isString()) {
                return jsonValue.asString();
            }
            return jsonValue.toString();
        }
        throw new f(String.format("key %s do not exist.", str));
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public boolean has(String str) {
        if (this.f144655a.get(str) != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public boolean isNull(String str) {
        if (this.f144655a.get(str) == null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public Iterator keys() {
        return this.f144655a.names().iterator();
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public int length() {
        return this.f144655a.size();
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public Object opt(String str) {
        JsonValue jsonValue = this.f144655a.get(str);
        if (jsonValue == null) {
            return null;
        }
        if (jsonValue.isNumber()) {
            return jsonValue.toString();
        }
        if (jsonValue.isBoolean()) {
            return Boolean.valueOf(jsonValue.asBoolean());
        }
        if (jsonValue.isArray()) {
            return new j(jsonValue.asArray());
        }
        if (jsonValue.isObject()) {
            return new k(jsonValue.asObject());
        }
        if (!jsonValue.isString()) {
            return null;
        }
        return jsonValue.asString();
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public boolean optBoolean(String str, boolean z16) {
        JsonValue jsonValue = this.f144655a.get(str);
        if (jsonValue == null) {
            return z16;
        }
        if (jsonValue.isBoolean()) {
            return jsonValue.asBoolean();
        }
        if (jsonValue.isString()) {
            String jsonValue2 = jsonValue.toString();
            if ("true".equals(jsonValue2)) {
                return true;
            }
            if ("false".equals(jsonValue2)) {
                return false;
            }
        }
        return z16;
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public double optDouble(String str, double d16) {
        JsonValue jsonValue = this.f144655a.get(str);
        if (jsonValue == null) {
            return d16;
        }
        if (jsonValue.isNumber()) {
            return jsonValue.asDouble();
        }
        if (jsonValue.isString()) {
            return Double.parseDouble(jsonValue.toString());
        }
        return d16;
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public int optInt(String str, int i3) {
        JsonValue jsonValue = this.f144655a.get(str);
        if (jsonValue == null) {
            return i3;
        }
        if (jsonValue.isNumber()) {
            try {
                return jsonValue.asInt();
            } catch (Exception unused) {
                return (int) jsonValue.asDouble();
            }
        }
        if (jsonValue.isString()) {
            return (int) Double.parseDouble(jsonValue.toString());
        }
        return i3;
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public long optLong(String str, long j3) {
        JsonValue jsonValue = this.f144655a.get(str);
        if (jsonValue == null) {
            return j3;
        }
        if (jsonValue.isNumber()) {
            try {
                return jsonValue.asLong();
            } catch (Exception unused) {
                return (long) jsonValue.asDouble();
            }
        }
        if (jsonValue.isString()) {
            return (long) Double.parseDouble(jsonValue.toString());
        }
        return j3;
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public String optString(String str, String str2) {
        JsonValue jsonValue = this.f144655a.get(str);
        if (jsonValue == null) {
            return null;
        }
        if (jsonValue.isString()) {
            return jsonValue.asString();
        }
        return jsonValue.toString();
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public Object remove(String str) {
        JsonObject remove = this.f144655a.remove(str);
        if (remove == null) {
            return null;
        }
        if (remove.isNumber()) {
            return remove.toString();
        }
        if (remove.isBoolean()) {
            return Boolean.valueOf(remove.asBoolean());
        }
        if (remove.isArray()) {
            return new j(remove.asArray());
        }
        if (remove.isObject()) {
            return new k(remove.asObject());
        }
        if (!remove.isString()) {
            return null;
        }
        return remove.asString();
    }

    public String toString() {
        return this.f144655a.toString();
    }

    @Override // com.tencent.luggage.wxa.xa.c
    /* renamed from: a */
    public c put(String str, double d16) {
        this.f144655a.add(str, d16);
        return this;
    }

    @Override // com.tencent.luggage.wxa.xa.c
    /* renamed from: b */
    public a optJSONArray(String str) {
        JsonValue jsonValue = this.f144655a.get(str);
        if (jsonValue == null) {
            return null;
        }
        return new j(jsonValue.asArray());
    }

    public k(JsonObject jsonObject) {
        this.f144655a = jsonObject == null ? new JsonObject() : jsonObject;
    }

    @Override // com.tencent.luggage.wxa.xa.c
    /* renamed from: a */
    public c put(String str, int i3) {
        this.f144655a.add(str, i3);
        return this;
    }

    @Override // com.tencent.luggage.wxa.xa.c
    /* renamed from: a */
    public c put(String str, long j3) {
        this.f144655a.add(str, j3);
        return this;
    }

    @Override // com.tencent.luggage.wxa.xa.c
    /* renamed from: a */
    public c put(String str, Object obj) {
        i.a(this.f144655a, str, obj);
        return this;
    }

    public k(Map map) {
        this.f144655a = i.a(map);
    }

    @Override // com.tencent.luggage.wxa.xa.c
    /* renamed from: a */
    public c getJSONObject(String str) {
        JsonValue jsonValue = this.f144655a.get(str);
        if (jsonValue != null) {
            return new k(jsonValue.asObject());
        }
        throw new f(String.format("key %s do not exist.", str));
    }

    public k(String str) {
        this.f144655a = Json.parse(str).asObject();
    }
}
