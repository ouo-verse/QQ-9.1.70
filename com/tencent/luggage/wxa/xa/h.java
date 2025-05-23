package com.tencent.luggage.wxa.xa;

import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class h extends JSONObject implements c {

    /* renamed from: a, reason: collision with root package name */
    public final c f144653a;

    public h() {
        this.f144653a = g.c();
    }

    @Override // org.json.JSONObject
    /* renamed from: d, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public h putOpt(String str, Object obj) {
        this.f144653a.putOpt(str, obj);
        return this;
    }

    @Override // org.json.JSONObject
    /* renamed from: f, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public e getJSONArray(String str) {
        a jSONArray = this.f144653a.getJSONArray(str);
        if (jSONArray == null) {
            return null;
        }
        return new e(jSONArray);
    }

    @Override // org.json.JSONObject
    /* renamed from: g, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public h getJSONObject(String str) {
        c jSONObject = this.f144653a.getJSONObject(str);
        if (jSONObject == null) {
            return null;
        }
        return new h(jSONObject);
    }

    @Override // org.json.JSONObject, com.tencent.luggage.wxa.xa.c
    public Object get(String str) {
        return this.f144653a.get(str);
    }

    @Override // org.json.JSONObject, com.tencent.luggage.wxa.xa.c
    public boolean getBoolean(String str) {
        return this.f144653a.getBoolean(str);
    }

    @Override // org.json.JSONObject, com.tencent.luggage.wxa.xa.c
    public double getDouble(String str) {
        return this.f144653a.getDouble(str);
    }

    @Override // org.json.JSONObject
    public int getInt(String str) {
        return this.f144653a.getInt(str);
    }

    @Override // org.json.JSONObject, com.tencent.luggage.wxa.xa.c
    public long getLong(String str) {
        return this.f144653a.getLong(str);
    }

    @Override // org.json.JSONObject
    public String getString(String str) {
        return this.f144653a.getString(str);
    }

    @Override // org.json.JSONObject
    /* renamed from: h, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public e optJSONArray(String str) {
        a optJSONArray = this.f144653a.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        return new e(optJSONArray);
    }

    @Override // org.json.JSONObject, com.tencent.luggage.wxa.xa.c
    public boolean has(String str) {
        return this.f144653a.has(str);
    }

    @Override // org.json.JSONObject
    /* renamed from: i, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public h optJSONObject(String str) {
        c optJSONObject = this.f144653a.optJSONObject(str);
        if (optJSONObject == null) {
            return null;
        }
        return new h(optJSONObject);
    }

    @Override // org.json.JSONObject, com.tencent.luggage.wxa.xa.c
    public boolean isNull(String str) {
        return this.f144653a.isNull(str);
    }

    @Override // org.json.JSONObject, com.tencent.luggage.wxa.xa.c
    public Iterator keys() {
        return this.f144653a.keys();
    }

    @Override // org.json.JSONObject, com.tencent.luggage.wxa.xa.c
    public int length() {
        return this.f144653a.length();
    }

    @Override // org.json.JSONObject, com.tencent.luggage.wxa.xa.c
    public Object opt(String str) {
        return this.f144653a.opt(str);
    }

    @Override // org.json.JSONObject
    public boolean optBoolean(String str) {
        return this.f144653a.optBoolean(str, false);
    }

    @Override // org.json.JSONObject
    public double optDouble(String str) {
        return this.f144653a.optDouble(str, Double.NaN);
    }

    @Override // org.json.JSONObject
    public int optInt(String str) {
        return this.f144653a.optInt(str, 0);
    }

    @Override // org.json.JSONObject
    public long optLong(String str) {
        return this.f144653a.optLong(str, 0L);
    }

    @Override // org.json.JSONObject
    public String optString(String str) {
        return this.f144653a.optString(str, "");
    }

    @Override // org.json.JSONObject, com.tencent.luggage.wxa.xa.c
    public Object remove(String str) {
        return this.f144653a.remove(str);
    }

    @Override // org.json.JSONObject
    public String toString() {
        return this.f144653a.toString();
    }

    @Override // org.json.JSONObject
    /* renamed from: c, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public h put(String str, Object obj) {
        if (obj instanceof h) {
            return a(str, ((h) obj).f144653a);
        }
        this.f144653a.put(str, obj);
        return this;
    }

    @Override // com.tencent.luggage.wxa.xa.c
    public String d(String str) {
        return this.f144653a.d(str);
    }

    @Override // org.json.JSONObject, com.tencent.luggage.wxa.xa.c
    public boolean optBoolean(String str, boolean z16) {
        return this.f144653a.optBoolean(str, z16);
    }

    @Override // org.json.JSONObject, com.tencent.luggage.wxa.xa.c
    public double optDouble(String str, double d16) {
        return this.f144653a.optDouble(str, d16);
    }

    @Override // org.json.JSONObject, com.tencent.luggage.wxa.xa.c
    public int optInt(String str, int i3) {
        return this.f144653a.optInt(str, i3);
    }

    @Override // org.json.JSONObject, com.tencent.luggage.wxa.xa.c
    public long optLong(String str, long j3) {
        return this.f144653a.optLong(str, j3);
    }

    @Override // org.json.JSONObject, com.tencent.luggage.wxa.xa.c
    public String optString(String str, String str2) {
        return this.f144653a.optString(str, str2);
    }

    public h(c cVar) {
        com.tencent.luggage.wxa.er.a.a(cVar);
        this.f144653a = cVar;
    }

    @Override // org.json.JSONObject
    /* renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public h put(String str, boolean z16) {
        this.f144653a.put(str, z16);
        return this;
    }

    @Override // org.json.JSONObject
    /* renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public h put(String str, double d16) {
        this.f144653a.put(d(str), d16);
        return this;
    }

    @Override // org.json.JSONObject
    /* renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public h put(String str, int i3) {
        this.f144653a.put(d(str), i3);
        return this;
    }

    public h(Map map) {
        this.f144653a = g.a(map);
    }

    @Override // org.json.JSONObject
    /* renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public h put(String str, long j3) {
        this.f144653a.put(d(str), j3);
        return this;
    }

    public h(String str) {
        this.f144653a = g.b(str);
    }
}
