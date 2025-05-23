package com.tencent.luggage.wxa.w8;

import android.os.SystemClock;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f144128a = new h();

    public static final long a() {
        return SystemClock.elapsedRealtime();
    }

    public static final boolean b(String str) {
        if (str != null && !Intrinsics.areEqual("", str)) {
            return false;
        }
        return true;
    }

    public static final long a(long j3) {
        return SystemClock.elapsedRealtime() - j3;
    }

    public static final void a(String libName, ClassLoader classLoader) {
        Intrinsics.checkNotNullParameter(libName, "libName");
        com.tencent.luggage.wxa.h.b.a("MagicBrush.Util", "System.loadLibrary " + libName + TokenParser.SP + classLoader, new Object[0]);
        System.loadLibrary(libName);
    }

    public static final String a(String libName) {
        Intrinsics.checkNotNullParameter(libName, "libName");
        com.tencent.luggage.wxa.h.b.a("MagicBrush.Util", "hy: try find lib path " + libName + " with dummy imp", new Object[0]);
        return "";
    }
}
