package org.junit.runners.model;

import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes29.dex */
public class InitializationError extends Exception {
    private static final long serialVersionUID = 1;
    private final List<Throwable> fErrors;

    public InitializationError(List<Throwable> list) {
        this.fErrors = list;
    }

    public List<Throwable> getCauses() {
        return this.fErrors;
    }

    public InitializationError(Throwable th5) {
        this((List<Throwable>) Arrays.asList(th5));
    }

    public InitializationError(String str) {
        this(new Exception(str));
    }
}
