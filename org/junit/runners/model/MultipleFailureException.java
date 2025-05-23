package org.junit.runners.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.internal.Throwables;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MultipleFailureException extends Exception {
    private static final long serialVersionUID = 1;
    private final List<Throwable> fErrors;

    public MultipleFailureException(List<Throwable> list) {
        this.fErrors = new ArrayList(list);
    }

    public static void assertEmpty(List<Throwable> list) throws Exception {
        if (list.isEmpty()) {
            return;
        }
        if (list.size() == 1) {
            throw Throwables.rethrowAsException(list.get(0));
        }
        throw new org.junit.internal.runners.model.MultipleFailureException(list);
    }

    public List<Throwable> getFailures() {
        return Collections.unmodifiableList(this.fErrors);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb5 = new StringBuilder(String.format("There were %d errors:", Integer.valueOf(this.fErrors.size())));
        for (Throwable th5 : this.fErrors) {
            sb5.append(String.format("\n  %s(%s)", th5.getClass().getName(), th5.getMessage()));
        }
        return sb5.toString();
    }
}
