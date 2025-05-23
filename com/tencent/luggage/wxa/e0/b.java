package com.tencent.luggage.wxa.e0;

import android.util.Log;
import com.tencent.luggage.wxa.k0.f;
import com.tencent.luggage.wxa.l0.q;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {
    public static boolean a(f fVar, int i3, Exception exc) {
        return a(fVar, i3, exc, 60000L);
    }

    public static boolean a(f fVar, int i3, Exception exc, long j3) {
        if (!a(exc)) {
            return false;
        }
        boolean a16 = fVar.a(i3, j3);
        int i16 = ((q.d) exc).f132834c;
        if (a16) {
            Log.w("ChunkedTrackBlacklist", "Blacklisted: duration=" + j3 + ", responseCode=" + i16 + ", format=" + fVar.a(i3));
        } else {
            Log.w("ChunkedTrackBlacklist", "Blacklisting failed (cannot blacklist last enabled track): responseCode=" + i16 + ", format=" + fVar.a(i3));
        }
        return a16;
    }

    public static boolean a(Exception exc) {
        if (!(exc instanceof q.d)) {
            return false;
        }
        int i3 = ((q.d) exc).f132834c;
        return i3 == 404 || i3 == 410;
    }
}
