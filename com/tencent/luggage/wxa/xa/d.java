package com.tencent.luggage.wxa.xa;

import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class d implements c {

    /* renamed from: a, reason: collision with root package name */
    public JSONObject f144649a;

    public d() {
        this.f144649a = new JSONObject();
    }

    @Override // com.tencent.luggage.wxa.xa.c
    /* renamed from: a */
    public c put(String str, boolean z16) {
        try {
            this.f144649a.put(str, z16);
            return this;
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.c
    /* renamed from: b */
    public c putOpt(String str, Object obj) {
        try {
            if (obj instanceof d) {
                this.f144649a.putOpt(str, ((d) obj).f144649a);
            } else {
                this.f144649a.putOpt(str, obj);
            }
            return this;
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.c
    /* renamed from: c */
    public c optJSONObject(String str) {
        JSONObject optJSONObject = this.f144649a.optJSONObject(str);
        if (optJSONObject == null) {
            return null;
        }
        return new d(optJSONObject);
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
        try {
            JSONArray jSONArray = this.f144649a.getJSONArray(str);
            if (jSONArray == null) {
                return null;
            }
            return new b(jSONArray);
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public Object get(String str) {
        try {
            Object obj = this.f144649a.get(str);
            if (obj instanceof JSONObject) {
                return new d((JSONObject) obj);
            }
            if (obj instanceof JSONArray) {
                return new b((JSONArray) obj);
            }
            return obj;
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public boolean getBoolean(String str) {
        try {
            return this.f144649a.getBoolean(str);
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public double getDouble(String str) {
        try {
            return this.f144649a.getDouble(str);
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public int getInt(String str) {
        try {
            return this.f144649a.getInt(str);
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public long getLong(String str) {
        try {
            return this.f144649a.getLong(str);
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public String getString(String str) {
        try {
            return this.f144649a.getString(str);
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public boolean has(String str) {
        return this.f144649a.has(str);
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public boolean isNull(String str) {
        return this.f144649a.isNull(str);
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public Iterator keys() {
        return this.f144649a.keys();
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public int length() {
        return this.f144649a.length();
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public Object opt(String str) {
        try {
            Object obj = this.f144649a.get(str);
            if (obj instanceof JSONObject) {
                return new d((JSONObject) obj);
            }
            if (obj instanceof JSONArray) {
                return new b((JSONArray) obj);
            }
            return obj;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public boolean optBoolean(String str, boolean z16) {
        return this.f144649a.optBoolean(str, z16);
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public double optDouble(String str, double d16) {
        return this.f144649a.optDouble(str, d16);
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public int optInt(String str, int i3) {
        return this.f144649a.optInt(str, i3);
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public long optLong(String str, long j3) {
        return this.f144649a.optLong(str, j3);
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public String optString(String str, String str2) {
        return this.f144649a.optString(str, str2);
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public Object remove(String str) {
        return this.f144649a.remove(str);
    }

    public String toString() {
        return this.f144649a.toString();
    }

    public d(Map map) {
        this.f144649a = new JSONObject(map);
    }

    @Override // com.tencent.luggage.wxa.xa.c
    /* renamed from: a */
    public c put(String str, double d16) {
        try {
            this.f144649a.put(str, d16);
            return this;
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    public d(String str) {
        try {
            this.f144649a = new JSONObject(str);
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.c
    /* renamed from: a */
    public c put(String str, int i3) {
        try {
            this.f144649a.put(str, i3);
            return this;
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.c
    /* renamed from: b */
    public a optJSONArray(String str) {
        JSONArray optJSONArray = this.f144649a.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        return new b(optJSONArray);
    }

    @Override // com.tencent.luggage.wxa.xa.c
    /* renamed from: a */
    public c put(String str, long j3) {
        try {
            this.f144649a.put(str, j3);
            return this;
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    public d(JSONObject jSONObject) {
        com.tencent.luggage.wxa.er.a.a(jSONObject);
        this.f144649a = jSONObject;
    }

    @Override // com.tencent.luggage.wxa.xa.c
    /* renamed from: a */
    public c put(String str, Object obj) {
        try {
            if (obj instanceof d) {
                this.f144649a.put(str, ((d) obj).f144649a);
            } else {
                this.f144649a.put(str, obj);
            }
            return this;
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.c
    /* renamed from: a */
    public c getJSONObject(String str) {
        try {
            JSONObject jSONObject = this.f144649a.getJSONObject(str);
            if (jSONObject == null) {
                return null;
            }
            return new d(jSONObject);
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }
}
