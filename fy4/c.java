package fy4;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lfy4/c;", "", "", "traceIdLongHighPart", "traceIdLongLowPart", "", "a", "<init>", "()V", "zplan-tracing_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f400953a = new c();

    c() {
    }

    @NotNull
    public final String a(long traceIdLongHighPart, long traceIdLongLowPart) {
        if (traceIdLongHighPart == 0 && traceIdLongLowPart == 0) {
            return "00000000000000000000000000000000";
        }
        char[] a16 = gy4.b.a(32);
        gy4.a.d(traceIdLongHighPart, a16, 0);
        gy4.a.d(traceIdLongLowPart, a16, 16);
        return new String(a16, 0, 32);
    }
}
