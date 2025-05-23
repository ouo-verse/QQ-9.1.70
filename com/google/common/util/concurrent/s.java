package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
final class s {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(@NullableDecl Throwable th5, Class<? extends Throwable> cls) {
        return cls.isInstance(th5);
    }
}
