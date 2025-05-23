package c.t.m.g;

import c.t.m.g.d;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: P */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public static int[] f29759a = {0, 8, 10, 33, 65535, 50594049, 268435455, Integer.MAX_VALUE};

    public static boolean a(long j3, int[] iArr) {
        for (int i3 : iArr) {
            if (j3 == i3) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(int i3, int i16, int i17, int i18, long j3) {
        if (i16 < 0 || i17 < 0 || i18 < 0 || j3 <= 0 || i16 == 535 || i17 == 535 || i18 == 65535 || j3 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            return false;
        }
        if (a(i3)) {
            return true;
        }
        return (i18 == 25840 || a(j3, f29759a)) ? false : true;
    }

    public static boolean a(int i3) {
        return i3 == d.a.CDMA.ordinal();
    }
}
