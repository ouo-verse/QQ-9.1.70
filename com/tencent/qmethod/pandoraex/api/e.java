package com.tencent.qmethod.pandoraex.api;

import android.location.Location;
import android.telephony.CellLocation;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static String f343905a;

    /* renamed from: b, reason: collision with root package name */
    private static byte[] f343906b;

    /* renamed from: c, reason: collision with root package name */
    private static String f343907c;

    /* renamed from: d, reason: collision with root package name */
    private static String f343908d;

    /* renamed from: e, reason: collision with root package name */
    private static String f343909e;

    /* renamed from: f, reason: collision with root package name */
    private static String f343910f;

    /* renamed from: g, reason: collision with root package name */
    private static String f343911g;

    /* renamed from: h, reason: collision with root package name */
    private static String f343912h;

    /* renamed from: i, reason: collision with root package name */
    private static String f343913i;

    /* renamed from: j, reason: collision with root package name */
    private static String f343914j;

    /* renamed from: k, reason: collision with root package name */
    private static String f343915k;

    /* renamed from: l, reason: collision with root package name */
    private static Location f343916l;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f343917m;

    /* renamed from: n, reason: collision with root package name */
    private static CellLocation f343918n;

    /* renamed from: o, reason: collision with root package name */
    private static boolean f343919o;

    /* renamed from: p, reason: collision with root package name */
    private static final ConcurrentHashMap<String, h<?>> f343920p = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a extends CellLocation {
        a() {
        }
    }

    public static <T> T a(vr3.a<T> aVar, Object obj, Object... objArr) throws Throwable {
        h<?> hVar = f343920p.get(aVar.f443217b);
        if (hVar == null) {
            return null;
        }
        return (T) hVar.a(aVar.f443216a, obj, objArr);
    }

    public static String b() {
        return f343915k;
    }

    public static String c() {
        return f343911g;
    }

    public static CellLocation d() {
        if (f343919o) {
            return f343918n;
        }
        return new a();
    }

    public static String e() {
        return f343908d;
    }

    public static byte[] f() {
        return f343906b;
    }

    public static String g() {
        return f343907c;
    }

    public static String h() {
        return f343909e;
    }

    public static String i() {
        return f343912h;
    }

    public static Location j() {
        if (f343917m) {
            return f343916l;
        }
        return new Location("");
    }

    public static String k() {
        return f343905a;
    }

    public static String l() {
        return f343910f;
    }

    public static String m() {
        return f343914j;
    }

    public static String n() {
        return f343913i;
    }

    public static boolean o(vr3.a aVar) {
        return f343920p.containsKey(aVar.f443217b);
    }
}
