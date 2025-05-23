package org.junit.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.runners.model.MultipleFailureException;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ErrorCollector extends Verifier {
    private List<Throwable> errors = new ArrayList();

    public void addError(Throwable th5) {
        this.errors.add(th5);
    }

    public <T> T checkSucceeds(Callable<T> callable) {
        try {
            return callable.call();
        } catch (Throwable th5) {
            addError(th5);
            return null;
        }
    }

    public <T> void checkThat(T t16, Matcher<T> matcher) {
        checkThat("", t16, matcher);
    }

    @Override // org.junit.rules.Verifier
    protected void verify() throws Throwable {
        MultipleFailureException.assertEmpty(this.errors);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void checkThat(final String str, final T t16, final Matcher<T> matcher) {
        checkSucceeds(new Callable<Object>() { // from class: org.junit.rules.ErrorCollector.1
            @Override // java.util.concurrent.Callable
            public Object call() throws Exception {
                Assert.assertThat(str, t16, matcher);
                return t16;
            }
        });
    }
}
