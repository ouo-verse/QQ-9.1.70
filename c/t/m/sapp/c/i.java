package c.t.m.sapp.c;

import com.tencent.map.geolocation.sapp.internal.LocationLogCallback;

/* compiled from: P */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public static String f30173a = "TencentLocTag";

    /* renamed from: b, reason: collision with root package name */
    public static LocationLogCallback f30174b;

    public static void a(LocationLogCallback locationLogCallback) {
        f30174b = locationLogCallback;
    }

    public static void a(int i3, String str, Throwable th5) {
        LocationLogCallback locationLogCallback = f30174b;
        if (locationLogCallback != null) {
            locationLogCallback.onLog(i3, "TencentLocationComp_sapp", str, th5);
        }
    }

    public static void a(String str) {
        a(4, str, null);
    }

    public static void a(String str, Throwable th5) {
        a(6, str, th5);
    }
}
