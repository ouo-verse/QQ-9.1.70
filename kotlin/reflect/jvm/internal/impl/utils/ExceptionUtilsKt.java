package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ExceptionUtilsKt {
    public static final boolean isProcessCanceledException(@NotNull Throwable th5) {
        Intrinsics.checkNotNullParameter(th5, "<this>");
        Class<?> cls = th5.getClass();
        while (!Intrinsics.areEqual(cls.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            cls = cls.getSuperclass();
            if (cls == null) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final RuntimeException rethrow(@NotNull Throwable e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
        throw e16;
    }
}
