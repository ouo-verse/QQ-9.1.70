package com.xiaomi.push;

import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class am extends JSONObject implements ak {

    /* renamed from: c, reason: collision with root package name */
    private static final int f388184c = 2;

    /* renamed from: d, reason: collision with root package name */
    private static final int f388185d = 3;

    /* renamed from: b, reason: collision with root package name */
    private final LinkedHashMap<String, Integer> f388186b = new LinkedHashMap<>();

    @Override // com.xiaomi.push.ak
    public int a() {
        int i3 = f388184c;
        Iterator<Integer> it = this.f388186b.values().iterator();
        while (it.hasNext()) {
            i3 += it.next().intValue();
        }
        return i3 + (length() - 1);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, int i3) {
        if (!TextUtils.isEmpty(str)) {
            this.f388186b.put(str, Integer.valueOf(str.length() + String.valueOf(i3).length() + f388185d));
        }
        return super.put(str, i3);
    }

    @Override // org.json.JSONObject, com.tencent.luggage.wxa.xa.c
    public Object remove(String str) {
        this.f388186b.remove(str);
        return super.remove(str);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, long j3) {
        if (!TextUtils.isEmpty(str)) {
            this.f388186b.put(str, Integer.valueOf(str.length() + String.valueOf(j3).length() + f388185d));
        }
        return super.put(str, j3);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, double d16) {
        if (!TextUtils.isEmpty(str)) {
            this.f388186b.put(str, Integer.valueOf(str.length() + String.valueOf(d16).length() + f388185d));
        }
        return super.put(str, d16);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, Object obj) {
        JSONObject put = super.put(str, obj);
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (obj instanceof ak) {
                this.f388186b.put(str, Integer.valueOf(str.length() + ((ak) obj).a() + f388185d));
            } else {
                this.f388186b.put(str, Integer.valueOf(str.length() + String.valueOf(obj).getBytes(StandardCharsets.UTF_8).length + f388185d + f388184c));
            }
        }
        return put;
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, boolean z16) {
        if (!TextUtils.isEmpty(str)) {
            this.f388186b.put(str, Integer.valueOf(str.length() + String.valueOf(z16).length() + f388185d));
        }
        return super.put(str, z16);
    }
}
