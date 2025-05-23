package com.tencent.luggage.wxa.xa;

import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes9.dex */
public class e extends JSONArray implements a {

    /* renamed from: a, reason: collision with root package name */
    public final a f144650a;

    public e() {
        this.f144650a = g.b();
    }

    @Override // org.json.JSONArray
    /* renamed from: f, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public e getJSONArray(int i3) {
        return new e(this.f144650a.getJSONArray(i3));
    }

    @Override // org.json.JSONArray
    /* renamed from: g, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public h getJSONObject(int i3) {
        return new h(this.f144650a.getJSONObject(i3));
    }

    @Override // org.json.JSONArray, com.tencent.luggage.wxa.xa.a
    public Object get(int i3) {
        return this.f144650a.get(i3);
    }

    @Override // org.json.JSONArray, com.tencent.luggage.wxa.xa.a
    public boolean getBoolean(int i3) {
        return this.f144650a.getBoolean(i3);
    }

    @Override // org.json.JSONArray, com.tencent.luggage.wxa.xa.a
    public double getDouble(int i3) {
        return this.f144650a.getDouble(i3);
    }

    @Override // org.json.JSONArray, com.tencent.luggage.wxa.xa.a
    public int getInt(int i3) {
        return this.f144650a.getInt(i3);
    }

    @Override // org.json.JSONArray, com.tencent.luggage.wxa.xa.a
    public long getLong(int i3) {
        return this.f144650a.getLong(i3);
    }

    @Override // org.json.JSONArray, com.tencent.luggage.wxa.xa.a
    public String getString(int i3) {
        return this.f144650a.getString(i3);
    }

    @Override // org.json.JSONArray
    /* renamed from: h, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public e optJSONArray(int i3) {
        return new e(this.f144650a.optJSONArray(i3));
    }

    @Override // org.json.JSONArray
    /* renamed from: i, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public h optJSONObject(int i3) {
        return new h(this.f144650a.optJSONObject(i3));
    }

    @Override // org.json.JSONArray, com.tencent.luggage.wxa.xa.a
    public boolean isNull(int i3) {
        return this.f144650a.isNull(i3);
    }

    @Override // org.json.JSONArray
    /* renamed from: j, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public e put(int i3) {
        this.f144650a.put(i3);
        return this;
    }

    @Override // org.json.JSONArray, com.tencent.luggage.wxa.xa.a
    public int length() {
        return this.f144650a.length();
    }

    @Override // org.json.JSONArray, com.tencent.luggage.wxa.xa.a
    public Object opt(int i3) {
        return this.f144650a.opt(i3);
    }

    @Override // org.json.JSONArray, com.tencent.luggage.wxa.xa.a
    public boolean optBoolean(int i3) {
        return this.f144650a.optBoolean(i3);
    }

    @Override // org.json.JSONArray, com.tencent.luggage.wxa.xa.a
    public double optDouble(int i3) {
        return this.f144650a.optDouble(i3);
    }

    @Override // org.json.JSONArray, com.tencent.luggage.wxa.xa.a
    public int optInt(int i3) {
        return this.f144650a.optInt(i3);
    }

    @Override // org.json.JSONArray, com.tencent.luggage.wxa.xa.a
    public long optLong(int i3) {
        return this.f144650a.optLong(i3);
    }

    @Override // org.json.JSONArray, com.tencent.luggage.wxa.xa.a
    public String optString(int i3) {
        return this.f144650a.optString(i3);
    }

    @Override // org.json.JSONArray, com.tencent.luggage.wxa.xa.a
    public Object remove(int i3) {
        return this.f144650a.remove(i3);
    }

    @Override // org.json.JSONArray, com.tencent.luggage.wxa.xa.a
    public String toString() {
        return this.f144650a.toString();
    }

    @Override // org.json.JSONArray
    /* renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public e put(boolean z16) {
        this.f144650a.put(z16);
        return this;
    }

    @Override // org.json.JSONArray, com.tencent.luggage.wxa.xa.a
    public boolean optBoolean(int i3, boolean z16) {
        return this.f144650a.optBoolean(i3, z16);
    }

    @Override // org.json.JSONArray, com.tencent.luggage.wxa.xa.a
    public double optDouble(int i3, double d16) {
        return this.f144650a.optDouble(i3, d16);
    }

    @Override // org.json.JSONArray, com.tencent.luggage.wxa.xa.a
    public int optInt(int i3, int i16) {
        return this.f144650a.optInt(i3, i16);
    }

    @Override // org.json.JSONArray, com.tencent.luggage.wxa.xa.a
    public long optLong(int i3, long j3) {
        return this.f144650a.optLong(i3, j3);
    }

    @Override // org.json.JSONArray, com.tencent.luggage.wxa.xa.a
    public String optString(int i3, String str) {
        return this.f144650a.optString(i3, str);
    }

    @Override // org.json.JSONArray, com.tencent.luggage.wxa.xa.a
    public String toString(int i3) {
        return this.f144650a.toString(i3);
    }

    public e(String str) {
        this.f144650a = g.a(str);
    }

    @Override // org.json.JSONArray
    /* renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public e put(double d16) {
        this.f144650a.put(d16);
        return this;
    }

    @Override // org.json.JSONArray
    /* renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public e put(long j3) {
        this.f144650a.put(j3);
        return this;
    }

    public e(a aVar) {
        com.tencent.luggage.wxa.er.a.a(aVar);
        this.f144650a = aVar;
    }

    @Override // org.json.JSONArray
    /* renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public e put(int i3, boolean z16) {
        this.f144650a.put(i3, z16);
        return this;
    }

    @Override // org.json.JSONArray
    /* renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public e put(int i3, double d16) {
        this.f144650a.put(i3, d16);
        return this;
    }

    @Override // org.json.JSONArray
    /* renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public e put(int i3, int i16) {
        this.f144650a.put(i3, i16);
        return this;
    }

    @Override // org.json.JSONArray
    /* renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public e put(int i3, long j3) {
        this.f144650a.put(i3, j3);
        return this;
    }

    @Override // org.json.JSONArray
    /* renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public e put(int i3, Object obj) {
        this.f144650a.put(i3, obj);
        return this;
    }

    @Override // org.json.JSONArray
    /* renamed from: a, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public e mo162put(Object obj) {
        this.f144650a.mo162put(obj);
        return this;
    }
}
