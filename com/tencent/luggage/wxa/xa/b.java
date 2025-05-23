package com.tencent.luggage.wxa.xa;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name */
    public JSONArray f144648a;

    public b() {
        this.f144648a = new JSONArray();
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: a */
    public a put(boolean z16) {
        this.f144648a.put(z16);
        return this;
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: b */
    public a put(int i3) {
        this.f144648a.put(i3);
        return this;
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: c */
    public a optJSONArray(int i3) {
        JSONArray optJSONArray = this.f144648a.optJSONArray(i3);
        if (optJSONArray == null) {
            return null;
        }
        return new b(optJSONArray);
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: d */
    public c optJSONObject(int i3) {
        JSONObject optJSONObject = this.f144648a.optJSONObject(i3);
        if (optJSONObject == null) {
            return null;
        }
        return new d(optJSONObject);
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: e */
    public c getJSONObject(int i3) {
        try {
            JSONObject jSONObject = this.f144648a.getJSONObject(i3);
            if (jSONObject == null) {
                return null;
            }
            return new d(jSONObject);
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public Object get(int i3) {
        try {
            Object obj = this.f144648a.get(i3);
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

    @Override // com.tencent.luggage.wxa.xa.a
    public boolean getBoolean(int i3) {
        try {
            return this.f144648a.getBoolean(i3);
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public double getDouble(int i3) {
        try {
            return this.f144648a.getDouble(i3);
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public int getInt(int i3) {
        try {
            return this.f144648a.getInt(i3);
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public long getLong(int i3) {
        try {
            return this.f144648a.getLong(i3);
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public String getString(int i3) {
        try {
            return this.f144648a.getString(i3);
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public boolean isNull(int i3) {
        return this.f144648a.isNull(i3);
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public int length() {
        return this.f144648a.length();
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public Object opt(int i3) {
        Object opt = this.f144648a.opt(i3);
        if (opt instanceof JSONObject) {
            return new d((JSONObject) opt);
        }
        if (opt instanceof JSONArray) {
            return new b((JSONArray) opt);
        }
        return opt;
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public boolean optBoolean(int i3) {
        return this.f144648a.optBoolean(i3);
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public double optDouble(int i3) {
        return this.f144648a.optDouble(i3);
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public int optInt(int i3) {
        return this.f144648a.optInt(i3);
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public long optLong(int i3) {
        return this.f144648a.optLong(i3);
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public String optString(int i3) {
        return this.f144648a.optString(i3);
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: put */
    public a mo162put(Object obj) {
        this.f144648a.mo162put(obj);
        return this;
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public Object remove(int i3) {
        Object remove = this.f144648a.remove(i3);
        if (remove instanceof JSONObject) {
            return new d((JSONObject) remove);
        }
        if (remove instanceof JSONArray) {
            return new b((JSONArray) remove);
        }
        return remove;
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public String toString() {
        return this.f144648a.toString();
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: a */
    public a put(double d16) {
        try {
            this.f144648a.put(d16);
            return this;
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public boolean optBoolean(int i3, boolean z16) {
        return this.f144648a.optBoolean(i3, z16);
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public double optDouble(int i3, double d16) {
        return this.f144648a.optDouble(i3, d16);
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public int optInt(int i3, int i16) {
        return this.f144648a.optInt(i3, i16);
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public long optLong(int i3, long j3) {
        return this.f144648a.optLong(i3, j3);
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public String optString(int i3, String str) {
        return this.f144648a.optString(i3, str);
    }

    @Override // com.tencent.luggage.wxa.xa.a
    public String toString(int i3) {
        try {
            return this.f144648a.toString(i3);
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    public b(String str) {
        try {
            this.f144648a = new JSONArray(str);
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: a */
    public a put(long j3) {
        this.f144648a.put(j3);
        return this;
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: a */
    public a put(int i3, boolean z16) {
        try {
            this.f144648a.put(i3, z16);
            return this;
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    public b(JSONArray jSONArray) {
        com.tencent.luggage.wxa.er.a.a(jSONArray);
        this.f144648a = jSONArray;
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: a */
    public a put(int i3, double d16) {
        try {
            this.f144648a.put(i3, d16);
            return this;
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: a */
    public a put(int i3, int i16) {
        try {
            this.f144648a.put(i3, i16);
            return this;
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: a */
    public a put(int i3, long j3) {
        try {
            this.f144648a.put(i3, j3);
            return this;
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: a */
    public a put(int i3, Object obj) {
        try {
            this.f144648a.put(i3, obj);
            return this;
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.xa.a
    /* renamed from: a */
    public a getJSONArray(int i3) {
        try {
            JSONArray jSONArray = this.f144648a.getJSONArray(i3);
            if (jSONArray == null) {
                return null;
            }
            return new b(jSONArray);
        } catch (JSONException e16) {
            throw new f(e16);
        }
    }
}
