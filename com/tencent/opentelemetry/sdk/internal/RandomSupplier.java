package com.tencent.opentelemetry.sdk.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class RandomSupplier {
    static IPatchRedirector $redirector_;

    RandomSupplier() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Supplier<Random> platformDefault() {
        return new Supplier() { // from class: com.tencent.opentelemetry.sdk.internal.c
            @Override // java.util.function.Supplier
            public final Object get() {
                return ThreadLocalRandom.current();
            }
        };
    }
}
