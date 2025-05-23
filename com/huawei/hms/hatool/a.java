package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static z0 f37056a;

    private static synchronized z0 a() {
        z0 z0Var;
        synchronized (a.class) {
            if (f37056a == null) {
                f37056a = q.c().b();
            }
            z0Var = f37056a;
        }
        return z0Var;
    }

    public static void b(int i3, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a() == null || !q1.b().a()) {
            return;
        }
        if (i3 == 1 || i3 == 0) {
            f37056a.b(i3, str, linkedHashMap);
            return;
        }
        v.d("hmsSdk", "Data type no longer collects range.type: " + i3);
    }

    public static void c() {
        if (a() != null && q1.b().a()) {
            f37056a.a(-1);
        }
    }

    public static void a(int i3, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a() == null || !q1.b().a()) {
            return;
        }
        if (i3 == 1 || i3 == 0) {
            f37056a.a(i3, str, linkedHashMap);
            return;
        }
        v.d("hmsSdk", "Data type no longer collects range.type: " + i3);
    }

    public static boolean b() {
        return q.c().a();
    }

    @Deprecated
    public static void a(Context context, String str, String str2) {
        if (a() != null) {
            f37056a.a(context, str, str2);
        }
    }
}
