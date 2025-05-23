package gy4;

import com.tencent.luggage.wxa.c8.c;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u001c\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lgy4/b;", "", "", c.E, "", "a", "Ljava/lang/ThreadLocal;", "Ljava/lang/ThreadLocal;", "CHAR_ARRAY", "<init>", "()V", "zplan-tracing_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final b f403896b = new b();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final ThreadLocal<char[]> CHAR_ARRAY = new ThreadLocal<>();

    b() {
    }

    @JvmStatic
    @NotNull
    public static final char[] a(int len) {
        ThreadLocal<char[]> threadLocal = CHAR_ARRAY;
        char[] cArr = threadLocal.get();
        if (cArr == null) {
            char[] cArr2 = new char[len];
            threadLocal.set(cArr2);
            return cArr2;
        }
        if (cArr.length < len) {
            char[] cArr3 = new char[len];
            threadLocal.set(cArr3);
            return cArr3;
        }
        return cArr;
    }
}
