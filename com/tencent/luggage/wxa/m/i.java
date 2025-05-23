package com.tencent.luggage.wxa.m;

import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final HashSet f133889a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public static String f133890b = "goog.exo.core";

    public static synchronized String a() {
        String str;
        synchronized (i.class) {
            str = f133890b;
        }
        return str;
    }

    public static synchronized void a(String str) {
        synchronized (i.class) {
            if (f133889a.add(str)) {
                f133890b += ", " + str;
            }
        }
    }
}
