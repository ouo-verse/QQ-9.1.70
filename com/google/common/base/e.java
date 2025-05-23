package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final String f34680a;

    e(String str) {
        this.f34680a = (String) j.m(str);
    }

    public static e g(char c16) {
        return new e(String.valueOf(c16));
    }

    public static e h(String str) {
        return new e(str);
    }

    @CanIgnoreReturnValue
    public <A extends Appendable> A a(A a16, Iterator<?> it) throws IOException {
        j.m(a16);
        if (it.hasNext()) {
            a16.append(i(it.next()));
            while (it.hasNext()) {
                a16.append(this.f34680a);
                a16.append(i(it.next()));
            }
        }
        return a16;
    }

    @CanIgnoreReturnValue
    public final StringBuilder b(StringBuilder sb5, Iterable<?> iterable) {
        return c(sb5, iterable.iterator());
    }

    @CanIgnoreReturnValue
    public final StringBuilder c(StringBuilder sb5, Iterator<?> it) {
        try {
            a(sb5, it);
            return sb5;
        } catch (IOException e16) {
            throw new AssertionError(e16);
        }
    }

    public final String d(Iterable<?> iterable) {
        return e(iterable.iterator());
    }

    public final String e(Iterator<?> it) {
        return c(new StringBuilder(), it).toString();
    }

    public final String f(Object[] objArr) {
        return d(Arrays.asList(objArr));
    }

    CharSequence i(Object obj) {
        j.m(obj);
        if (obj instanceof CharSequence) {
            return (CharSequence) obj;
        }
        return obj.toString();
    }
}
