package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public int f389862a;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, String> f389863b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public String f389864c;

    public String a() {
        return this.f389864c;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.f389862a), this.f389863b.toString(), this.f389864c);
    }
}
