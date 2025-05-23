package org.junit.rules;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;
import org.junit.Assert;
import org.junit.internal.matchers.ThrowableCauseMatcher;
import org.junit.internal.matchers.ThrowableMessageMatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ExpectedException implements TestRule {
    private final ExpectedExceptionMatcherBuilder matcherBuilder = new ExpectedExceptionMatcherBuilder();
    private String missingExceptionMessage = "Expected test to throw %s";

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private class ExpectedExceptionStatement extends Statement {
        private final Statement next;

        public ExpectedExceptionStatement(Statement statement) {
            this.next = statement;
        }

        @Override // org.junit.runners.model.Statement
        public void evaluate() throws Throwable {
            try {
                this.next.evaluate();
                if (ExpectedException.this.isAnyExceptionExpected()) {
                    ExpectedException.this.failDueToMissingException();
                }
            } catch (Throwable th5) {
                ExpectedException.this.handleException(th5);
            }
        }
    }

    ExpectedException() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failDueToMissingException() throws AssertionError {
        Assert.fail(missingExceptionMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleException(Throwable th5) throws Throwable {
        if (isAnyExceptionExpected()) {
            Assert.assertThat(th5, this.matcherBuilder.build());
            return;
        }
        throw th5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAnyExceptionExpected() {
        return this.matcherBuilder.expectsThrowable();
    }

    private String missingExceptionMessage() {
        return String.format(this.missingExceptionMessage, StringDescription.toString(this.matcherBuilder.build()));
    }

    public static ExpectedException none() {
        return new ExpectedException();
    }

    @Override // org.junit.rules.TestRule
    public Statement apply(Statement statement, Description description) {
        return new ExpectedExceptionStatement(statement);
    }

    public void expect(Matcher<?> matcher) {
        this.matcherBuilder.add(matcher);
    }

    public void expectCause(Matcher<? extends Throwable> matcher) {
        expect(ThrowableCauseMatcher.hasCause(matcher));
    }

    public void expectMessage(String str) {
        expectMessage(CoreMatchers.containsString(str));
    }

    public ExpectedException reportMissingExceptionWithMessage(String str) {
        this.missingExceptionMessage = str;
        return this;
    }

    public void expect(Class<? extends Throwable> cls) {
        expect(CoreMatchers.instanceOf(cls));
    }

    public void expectMessage(Matcher<String> matcher) {
        expect(ThrowableMessageMatcher.hasMessage(matcher));
    }

    @Deprecated
    public ExpectedException handleAssertionErrors() {
        return this;
    }

    @Deprecated
    public ExpectedException handleAssumptionViolatedExceptions() {
        return this;
    }
}
