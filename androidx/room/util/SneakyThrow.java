package androidx.room.util;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class SneakyThrow {
    SneakyThrow() {
    }

    public static void reThrow(@NonNull Exception exc) {
        sneakyThrow(exc);
    }

    private static <E extends Throwable> void sneakyThrow(@NonNull Throwable th5) throws Throwable {
        throw th5;
    }
}
