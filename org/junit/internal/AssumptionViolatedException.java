package org.junit.internal;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.SelfDescribing;
import org.hamcrest.StringDescription;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AssumptionViolatedException extends RuntimeException implements SelfDescribing {
    private static final long serialVersionUID = 2;
    private final String fAssumption;
    private final Matcher<?> fMatcher;
    private final Object fValue;
    private final boolean fValueMatcher;

    @Deprecated
    public AssumptionViolatedException(String str, boolean z16, Object obj, Matcher<?> matcher) {
        this.fAssumption = str;
        this.fValue = obj;
        this.fMatcher = matcher;
        this.fValueMatcher = z16;
        if (obj instanceof Throwable) {
            initCause((Throwable) obj);
        }
    }

    public void describeTo(Description description) {
        String str = this.fAssumption;
        if (str != null) {
            description.appendText(str);
        }
        if (this.fValueMatcher) {
            if (this.fAssumption != null) {
                description.appendText(MsgSummary.STR_COLON);
            }
            description.appendText("got: ");
            description.appendValue(this.fValue);
            if (this.fMatcher != null) {
                description.appendText(", expected: ");
                description.appendDescriptionOf(this.fMatcher);
            }
        }
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return StringDescription.asString(this);
    }

    @Deprecated
    public AssumptionViolatedException(Object obj, Matcher<?> matcher) {
        this(null, true, obj, matcher);
    }

    @Deprecated
    public AssumptionViolatedException(String str, Object obj, Matcher<?> matcher) {
        this(str, true, obj, matcher);
    }

    @Deprecated
    public AssumptionViolatedException(String str) {
        this(str, false, null, null);
    }

    @Deprecated
    public AssumptionViolatedException(String str, Throwable th5) {
        this(str, false, null, null);
        initCause(th5);
    }
}
