package com.tencent.luggage.wxa.xa;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonValue;
import com.eclipsesource.json.PrettyPrint;

/* compiled from: P */
/* loaded from: classes9.dex */
public class j implements a {

    /* renamed from: a, reason: collision with root package name */
    public JsonArray f144654a;

    public j() {
        this.f144654a = new JsonArray();
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: a */
    public a put(boolean z16) {
        this.f144654a.add(z16);
        return this;
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: b */
    public a put(int i3) {
        this.f144654a.add(i3);
        return this;
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: c */
    public a optJSONArray(int i3) {
        JsonValue jsonValue;
        int length = length();
        if (i3 < 0 || i3 >= length || (jsonValue = this.f144654a.get(i3)) == null) {
            return null;
        }
        return new j(jsonValue.asArray());
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: d */
    public c optJSONObject(int i3) {
        JsonValue jsonValue;
        int length = length();
        if (i3 < 0 || i3 >= length || (jsonValue = this.f144654a.get(i3)) == null) {
            return null;
        }
        return new k(jsonValue.asObject());
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: e */
    public c getJSONObject(int i3) {
        int length = length();
        if (i3 >= 0 && i3 < length) {
            JsonValue jsonValue = this.f144654a.get(i3);
            if (jsonValue != null) {
                return new k(jsonValue.asObject());
            }
            throw new f(String.format("getJSONObject(%d) return null.", Integer.valueOf(i3)));
        }
        throw new f(String.format("index(%d) out of range(0, %d).", Integer.valueOf(i3), Integer.valueOf(length)));
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public Object get(int i3) {
        int length = length();
        if (i3 >= 0 && i3 < length) {
            JsonValue jsonValue = this.f144654a.get(i3);
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
        throw new f(String.format("index(%d) out of range(0, %d).", Integer.valueOf(i3), Integer.valueOf(length)));
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public boolean getBoolean(int i3) {
        int length = length();
        if (i3 >= 0 && i3 < length) {
            JsonValue jsonValue = this.f144654a.get(i3);
            if (jsonValue != null) {
                if (jsonValue.isBoolean()) {
                    return jsonValue.asBoolean();
                }
                if (jsonValue.isString()) {
                    String asString = jsonValue.asString();
                    if ("true".equals(asString)) {
                        return true;
                    }
                    if ("false".equals(asString)) {
                        return false;
                    }
                }
                throw new f(String.format("getBoolean(%d) error, value : %s.", Integer.valueOf(i3), jsonValue));
            }
            throw new f(String.format("getBoolean(%d) return null.", Integer.valueOf(i3)));
        }
        throw new f(String.format("index(%d) out of range(0, %d).", Integer.valueOf(i3), Integer.valueOf(length)));
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public double getDouble(int i3) {
        int length = length();
        if (i3 >= 0 && i3 < length) {
            JsonValue jsonValue = this.f144654a.get(i3);
            if (jsonValue != null) {
                if (jsonValue.isNumber()) {
                    return jsonValue.asDouble();
                }
                if (jsonValue.isString()) {
                    return Double.parseDouble(jsonValue.asString());
                }
                throw new f(String.format("getDouble(%d) error, value : %s.", Integer.valueOf(i3), jsonValue));
            }
            throw new f(String.format("getDouble(%d) return null.", Integer.valueOf(i3)));
        }
        throw new f(String.format("index(%d) out of range(0, %d).", Integer.valueOf(i3), Integer.valueOf(length)));
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public int getInt(int i3) {
        int length = length();
        if (i3 >= 0 && i3 < length) {
            JsonValue jsonValue = this.f144654a.get(i3);
            if (jsonValue != null) {
                if (jsonValue.isNumber()) {
                    try {
                        i3 = jsonValue.asInt();
                        return i3;
                    } catch (Exception unused) {
                        return (int) jsonValue.asDouble();
                    }
                }
                if (jsonValue.isString()) {
                    return (int) Double.parseDouble(jsonValue.asString());
                }
                throw new f(String.format("getInt(%d) error, value : %s.", Integer.valueOf(i3), jsonValue));
            }
            throw new f(String.format("getInteger(%d) return null.", Integer.valueOf(i3)));
        }
        throw new f(String.format("index(%d) out of range(0, %d).", Integer.valueOf(i3), Integer.valueOf(length)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.eclipsesource.json.JsonValue] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v8, types: [long] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object[]] */
    @Override // com.tencent.luggage.wxa.xa.a
    public long getLong(int i3) {
        int length = length();
        if (i3 >= 0 && i3 < length) {
            ?? r06 = this.f144654a.get(i3);
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
                    return (long) Double.parseDouble(r06.asString());
                }
                throw new f(String.format("getLong(%d) error, value : %s.", new Object[]{Integer.valueOf(i3), r06}));
            }
            throw new f(String.format("getLong(%d) return null.", Integer.valueOf(i3)));
        }
        throw new f(String.format("index(%d) out of range(0, %d).", Integer.valueOf(i3), Integer.valueOf(length)));
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public String getString(int i3) {
        int length = length();
        if (i3 >= 0 && i3 < length) {
            JsonValue jsonValue = this.f144654a.get(i3);
            if (jsonValue != null) {
                if (jsonValue.isString()) {
                    return jsonValue.asString();
                }
                return jsonValue.toString();
            }
            throw new f(String.format("getString(%d) return null.", Integer.valueOf(i3)));
        }
        throw new f(String.format("index(%d) out of range(0, %d).", Integer.valueOf(i3), Integer.valueOf(length)));
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public boolean isNull(int i3) {
        if (i3 >= 0 && i3 < length() && this.f144654a.get(i3) != null) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public int length() {
        return this.f144654a.size();
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public Object opt(int i3) {
        JsonValue jsonValue;
        int length = length();
        if (i3 < 0 || i3 >= length || (jsonValue = this.f144654a.get(i3)) == null) {
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
        if (jsonValue.isString()) {
            return jsonValue.asString();
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public boolean optBoolean(int i3) {
        return optBoolean(i3, false);
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public double optDouble(int i3) {
        return optDouble(i3, 0.0d);
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public int optInt(int i3) {
        return optInt(i3, 0);
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public long optLong(int i3) {
        return optLong(i3, 0L);
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public String optString(int i3) {
        return optString(i3, null);
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: put */
    public a mo162put(Object obj) {
        i.a(this.f144654a, obj);
        return this;
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public Object remove(int i3) {
        JsonArray remove;
        int length = length();
        if (i3 < 0 || i3 >= length || (remove = this.f144654a.remove(i3)) == null) {
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
        if (remove.isString()) {
            return remove.asString();
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public String toString() {
        return this.f144654a.toString();
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: a */
    public a put(double d16) {
        this.f144654a.add(d16);
        return this;
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public boolean optBoolean(int i3, boolean z16) {
        JsonValue jsonValue;
        int length = length();
        if (i3 < 0 || i3 >= length || (jsonValue = this.f144654a.get(i3)) == null) {
            return z16;
        }
        if (jsonValue.isBoolean()) {
            return jsonValue.asBoolean();
        }
        if (jsonValue.isString()) {
            String asString = jsonValue.asString();
            if ("true".equals(asString)) {
                return true;
            }
            if ("false".equals(asString)) {
                return false;
            }
        }
        return z16;
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public double optDouble(int i3, double d16) {
        JsonValue jsonValue;
        int length = length();
        if (i3 < 0 || i3 >= length || (jsonValue = this.f144654a.get(i3)) == null) {
            return d16;
        }
        if (jsonValue.isNumber()) {
            return jsonValue.asDouble();
        }
        if (jsonValue.isString()) {
            return Double.parseDouble(jsonValue.asString());
        }
        return d16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0009, code lost:
    
        r2 = r1.f144654a.get(r2);
     */
    @Override // com.tencent.luggage.wxa.xa.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int optInt(int i3, int i16) {
        JsonValue jsonValue;
        int length = length();
        if (i3 < 0 || i3 >= length || jsonValue == null) {
            return i16;
        }
        if (jsonValue.isNumber()) {
            try {
                return jsonValue.asInt();
            } catch (Exception unused) {
                return (int) jsonValue.asDouble();
            }
        }
        if (jsonValue.isString()) {
            return (int) Double.parseDouble(jsonValue.asString());
        }
        return i16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0009, code lost:
    
        r2 = r1.f144654a.get(r2);
     */
    @Override // com.tencent.luggage.wxa.xa.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long optLong(int i3, long j3) {
        JsonValue jsonValue;
        int length = length();
        if (i3 < 0 || i3 >= length || jsonValue == null) {
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
            return (long) Double.parseDouble(jsonValue.asString());
        }
        return j3;
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public String optString(int i3, String str) {
        JsonValue jsonValue;
        int length = length();
        if (i3 < 0 || i3 >= length || (jsonValue = this.f144654a.get(i3)) == null) {
            return str;
        }
        if (jsonValue.isString()) {
            return jsonValue.asString();
        }
        return jsonValue.toString();
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public String toString(int i3) {
        try {
            return this.f144654a.toString(PrettyPrint.indentWithSpaces(i3));
        } catch (Throwable th5) {
            throw new f(th5);
        }
    }

    public j(String str) {
        JsonArray asArray = Json.parse(str).asArray();
        this.f144654a = asArray;
        if (asArray == null) {
            throw new f(String.format("JSONArray string(%s) parse error.", str));
        }
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: a */
    public a put(long j3) {
        this.f144654a.add(j3);
        return this;
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: a */
    public a put(int i3, boolean z16) {
        try {
            this.f144654a.set(i3, z16);
            return this;
        } catch (Exception e16) {
            throw new f(e16);
        }
    }

    public j(JsonArray jsonArray) {
        com.tencent.luggage.wxa.er.a.a(jsonArray);
        this.f144654a = jsonArray;
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: a */
    public a put(int i3, double d16) {
        try {
            this.f144654a.set(i3, d16);
            return this;
        } catch (Exception e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: a */
    public a put(int i3, int i16) {
        try {
            this.f144654a.set(i3, i16);
            return this;
        } catch (Exception e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: a */
    public a put(int i3, long j3) {
        try {
            this.f144654a.set(i3, j3);
            return this;
        } catch (Exception e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: a */
    public a put(int i3, Object obj) {
        try {
            i.a(this.f144654a, i3, obj);
            return this;
        } catch (Exception e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: a */
    public a getJSONArray(int i3) {
        int length = length();
        if (i3 >= 0 && i3 < length) {
            JsonValue jsonValue = this.f144654a.get(i3);
            if (jsonValue != null) {
                return new j(jsonValue.asArray());
            }
            throw new f(String.format("getJSONArray(%d) return null.", Integer.valueOf(i3)));
        }
        throw new f(String.format("index(%d) out of range(0, %d).", Integer.valueOf(i3), Integer.valueOf(length)));
    }
}
