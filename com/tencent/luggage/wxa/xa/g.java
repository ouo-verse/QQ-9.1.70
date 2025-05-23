package com.tencent.luggage.wxa.xa;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static volatile int f144651a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f144652b = false;

    public static void a() {
    }

    public static c b(String str) {
        if (f144651a == 1) {
            return new k(str);
        }
        return new d(str);
    }

    public static JSONObject c(String str) {
        if (!f144652b) {
            a();
        }
        if (f144651a == 1) {
            return new h(str);
        }
        return new JSONObject(str);
    }

    public static c a(Map map) {
        if (f144651a == 1) {
            return new k(map);
        }
        return new d(map);
    }

    public static a b() {
        if (f144651a == 1) {
            return new j();
        }
        return new b();
    }

    public static a a(String str) {
        if (f144651a == 1) {
            return new j(str);
        }
        return new b(str);
    }

    public static c c() {
        if (f144651a == 1) {
            return new k();
        }
        return new d();
    }
}
