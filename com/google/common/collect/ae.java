package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
final class ae<T> {

    /* renamed from: a, reason: collision with root package name */
    private final int f35009a;

    /* renamed from: b, reason: collision with root package name */
    private final Comparator<? super T> f35010b;

    /* renamed from: c, reason: collision with root package name */
    private final T[] f35011c;

    /* renamed from: d, reason: collision with root package name */
    private int f35012d;

    /* renamed from: e, reason: collision with root package name */
    @NullableDecl
    private T f35013e;

    ae(Comparator<? super T> comparator, int i3) {
        boolean z16;
        this.f35010b = (Comparator) com.google.common.base.j.n(comparator, "comparator");
        this.f35009a = i3;
        if (i3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.f(z16, "k must be nonnegative, was %s", i3);
        this.f35011c = (T[]) new Object[i3 * 2];
        this.f35012d = 0;
        this.f35013e = null;
    }

    public static <T> ae<T> a(int i3, Comparator<? super T> comparator) {
        return new ae<>(comparator, i3);
    }

    private int d(int i3, int i16, int i17) {
        T[] tArr = this.f35011c;
        T t16 = tArr[i17];
        tArr[i17] = tArr[i16];
        int i18 = i3;
        while (i3 < i16) {
            if (this.f35010b.compare(this.f35011c[i3], t16) < 0) {
                e(i18, i3);
                i18++;
            }
            i3++;
        }
        T[] tArr2 = this.f35011c;
        tArr2[i16] = tArr2[i18];
        tArr2[i18] = t16;
        return i18;
    }

    private void e(int i3, int i16) {
        T[] tArr = this.f35011c;
        T t16 = tArr[i3];
        tArr[i3] = tArr[i16];
        tArr[i16] = t16;
    }

    private void g() {
        int i3 = (this.f35009a * 2) - 1;
        int c16 = r1.a.c(i3 + 0, RoundingMode.CEILING) * 3;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (true) {
            if (i16 >= i3) {
                break;
            }
            int d16 = d(i16, i3, ((i16 + i3) + 1) >>> 1);
            int i19 = this.f35009a;
            if (d16 > i19) {
                i3 = d16 - 1;
            } else {
                if (d16 >= i19) {
                    break;
                }
                i16 = Math.max(d16, i16 + 1);
                i18 = d16;
            }
            i17++;
            if (i17 >= c16) {
                Arrays.sort(this.f35011c, i16, i3, this.f35010b);
                break;
            }
        }
        this.f35012d = this.f35009a;
        this.f35013e = this.f35011c[i18];
        while (true) {
            i18++;
            if (i18 < this.f35009a) {
                if (this.f35010b.compare(this.f35011c[i18], this.f35013e) > 0) {
                    this.f35013e = this.f35011c[i18];
                }
            } else {
                return;
            }
        }
    }

    public void b(@NullableDecl T t16) {
        int i3 = this.f35009a;
        if (i3 == 0) {
            return;
        }
        int i16 = this.f35012d;
        if (i16 == 0) {
            this.f35011c[0] = t16;
            this.f35013e = t16;
            this.f35012d = 1;
            return;
        }
        if (i16 < i3) {
            T[] tArr = this.f35011c;
            this.f35012d = i16 + 1;
            tArr[i16] = t16;
            if (this.f35010b.compare(t16, this.f35013e) > 0) {
                this.f35013e = t16;
                return;
            }
            return;
        }
        if (this.f35010b.compare(t16, this.f35013e) < 0) {
            T[] tArr2 = this.f35011c;
            int i17 = this.f35012d;
            int i18 = i17 + 1;
            this.f35012d = i18;
            tArr2[i17] = t16;
            if (i18 == this.f35009a * 2) {
                g();
            }
        }
    }

    public void c(Iterator<? extends T> it) {
        while (it.hasNext()) {
            b(it.next());
        }
    }

    public List<T> f() {
        Arrays.sort(this.f35011c, 0, this.f35012d, this.f35010b);
        int i3 = this.f35012d;
        int i16 = this.f35009a;
        if (i3 > i16) {
            T[] tArr = this.f35011c;
            Arrays.fill(tArr, i16, tArr.length, (Object) null);
            int i17 = this.f35009a;
            this.f35012d = i17;
            this.f35013e = this.f35011c[i17 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.f35011c, this.f35012d)));
    }
}
