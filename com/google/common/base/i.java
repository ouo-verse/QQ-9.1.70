package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Locale;
import java.util.logging.Logger;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
final class i {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f34688a = Logger.getLogger(i.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private static final h f34689b = b();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class b implements h {
        b() {
        }
    }

    i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(double d16) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(d16));
    }

    private static h b() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long c() {
        return System.nanoTime();
    }
}
