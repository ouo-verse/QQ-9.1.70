package com.tencent.luggage.wxa.ej;

import com.tencent.luggage.wxa.ej.b;
import com.tencent.luggage.wxa.h6.f;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.xa.h;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final b.a f124910a;

    /* renamed from: b, reason: collision with root package name */
    public final l f124911b;

    /* renamed from: c, reason: collision with root package name */
    public final int f124912c;

    public c(l lVar) {
        this.f124911b = lVar;
        this.f124912c = -1;
        this.f124910a = null;
    }

    public l a() {
        return this.f124911b;
    }

    public String b(Map map) {
        if (map == null) {
            map = new HashMap();
        }
        map.put("ret", 0);
        return a(a(map));
    }

    public String a(int i3) {
        return a(i3, null);
    }

    public String a(int i3, Map map) {
        if (map == null) {
            map = new HashMap();
        }
        map.put("ret", Integer.valueOf(i3));
        return a(a(map));
    }

    public String b() {
        return a(1);
    }

    public c(l lVar, int i3, b.a aVar) {
        this.f124910a = aVar;
        this.f124911b = lVar;
        this.f124912c = i3;
    }

    public final String a(String str) {
        b.a aVar = this.f124910a;
        if (aVar == null) {
            return str;
        }
        aVar.a(this.f124912c, str);
        return null;
    }

    public static String a(Map map) {
        f.a(map);
        return new h(map).toString();
    }
}
