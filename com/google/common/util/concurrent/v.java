package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class v {
    @CanIgnoreReturnValue
    public static <V> V a(Future<V> future) throws ExecutionException {
        V v3;
        boolean z16 = false;
        while (true) {
            try {
                v3 = future.get();
                break;
            } catch (InterruptedException unused) {
                z16 = true;
            } catch (Throwable th5) {
                if (z16) {
                    Thread.currentThread().interrupt();
                }
                throw th5;
            }
        }
        if (z16) {
            Thread.currentThread().interrupt();
        }
        return v3;
    }
}
