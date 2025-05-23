package com.tencent.luggage.wxa.gl;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g implements c {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f126795a;

    /* renamed from: b, reason: collision with root package name */
    public TreeMap f126796b = new TreeMap(String.CASE_INSENSITIVE_ORDER);

    @Override // com.tencent.luggage.wxa.gl.c
    public void a(String str, String str2) {
        this.f126796b.put(str, str2);
    }

    @Override // com.tencent.luggage.wxa.gl.f
    public Iterator d() {
        return Collections.unmodifiableSet(this.f126796b.keySet()).iterator();
    }

    @Override // com.tencent.luggage.wxa.gl.f
    public byte[] getContent() {
        return this.f126795a;
    }

    @Override // com.tencent.luggage.wxa.gl.f
    public boolean a(String str) {
        return this.f126796b.containsKey(str);
    }

    @Override // com.tencent.luggage.wxa.gl.f
    public String d(String str) {
        String str2 = (String) this.f126796b.get(str);
        return str2 == null ? "" : str2;
    }
}
