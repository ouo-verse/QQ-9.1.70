package org.junit.experimental.results;

import java.util.Iterator;
import java.util.List;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/* compiled from: P */
/* loaded from: classes29.dex */
class FailureList {
    private final List<Failure> failures;

    public FailureList(List<Failure> list) {
        this.failures = list;
    }

    public Result result() {
        Result result = new Result();
        RunListener createListener = result.createListener();
        Iterator<Failure> it = this.failures.iterator();
        while (it.hasNext()) {
            try {
                createListener.testFailure(it.next());
            } catch (Exception unused) {
                throw new RuntimeException("I can't believe this happened");
            }
        }
        return result;
    }
}
