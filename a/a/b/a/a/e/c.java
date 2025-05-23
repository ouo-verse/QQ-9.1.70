package a.a.b.a.a.e;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class c implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final int f25203d = 0;

    /* renamed from: f, reason: collision with root package name */
    public static final int f25205f = 1;

    /* renamed from: h, reason: collision with root package name */
    public static final int f25207h = 2;

    /* renamed from: j, reason: collision with root package name */
    static final /* synthetic */ boolean f25209j = true;

    /* renamed from: a, reason: collision with root package name */
    private int f25211a;

    /* renamed from: b, reason: collision with root package name */
    private String f25212b;

    /* renamed from: m, reason: collision with root package name */
    private static c[] f25210m = new c[3];

    /* renamed from: e, reason: collision with root package name */
    public static final c f25204e = new c(0, 0, "GPS_WGS84");

    /* renamed from: g, reason: collision with root package name */
    public static final c f25206g = new c(1, 1, "GPS_MARS");

    /* renamed from: i, reason: collision with root package name */
    public static final c f25208i = new c(2, 2, "GPS_WGS_REAL");

    c(int i3, int i16, String str) {
        new String();
        this.f25212b = str;
        this.f25211a = i16;
        f25210m[i3] = this;
    }

    public static c a(int i3) {
        int i16 = 0;
        while (true) {
            c[] cVarArr = f25210m;
            if (i16 < cVarArr.length) {
                if (cVarArr[i16].a() == i3) {
                    return f25210m[i16];
                }
                i16++;
            } else {
                if (f25209j) {
                    return null;
                }
                throw new AssertionError();
            }
        }
    }

    public String toString() {
        return this.f25212b;
    }

    public static c a(String str) {
        int i3 = 0;
        while (true) {
            c[] cVarArr = f25210m;
            if (i3 < cVarArr.length) {
                if (cVarArr[i3].toString().equals(str)) {
                    return f25210m[i3];
                }
                i3++;
            } else {
                if (f25209j) {
                    return null;
                }
                throw new AssertionError();
            }
        }
    }

    public int a() {
        return this.f25211a;
    }
}
