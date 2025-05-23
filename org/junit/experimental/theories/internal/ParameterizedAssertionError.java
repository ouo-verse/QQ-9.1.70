package org.junit.experimental.theories.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes29.dex */
public class ParameterizedAssertionError extends AssertionError {
    private static final long serialVersionUID = 1;

    public ParameterizedAssertionError(Throwable th5, String str, Object... objArr) {
        super(String.format("%s(%s)", str, join(", ", objArr)));
        initCause(th5);
    }

    public static String join(String str, Object... objArr) {
        return join(str, Arrays.asList(objArr));
    }

    private static String stringValueOf(Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Throwable unused) {
            return "[toString failed]";
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof ParameterizedAssertionError) && toString().equals(obj.toString())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public static String join(String str, Collection<Object> collection) {
        StringBuilder sb5 = new StringBuilder();
        Iterator<Object> it = collection.iterator();
        while (it.hasNext()) {
            sb5.append(stringValueOf(it.next()));
            if (it.hasNext()) {
                sb5.append(str);
            }
        }
        return sb5.toString();
    }
}
