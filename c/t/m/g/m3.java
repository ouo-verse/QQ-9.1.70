package c.t.m.g;

import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes.dex */
public class m3 {

    /* renamed from: a, reason: collision with root package name */
    public final String f29872a;

    public m3(String str) {
        this.f29872a = a(str);
    }

    public static m3 b(String str) {
        return new m3(str);
    }

    public final String a(String str) {
        str.getClass();
        return str;
    }

    public final String a(Iterable<?> iterable) {
        return a(iterable.iterator());
    }

    public final String a(Iterator<?> it) {
        return a(new StringBuilder(), it).toString();
    }

    public final StringBuilder a(StringBuilder sb5, Iterator<?> it) {
        Object next;
        if (it.hasNext() && (next = it.next()) != null) {
            sb5.append(next.toString());
        }
        while (it.hasNext()) {
            Object next2 = it.next();
            if (next2 != null) {
                sb5.append(this.f29872a);
                sb5.append(next2.toString());
            }
        }
        return sb5;
    }
}
