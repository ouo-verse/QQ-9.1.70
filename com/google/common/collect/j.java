package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    private static final j f35025a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final j f35026b = new b(-1);

    /* renamed from: c, reason: collision with root package name */
    private static final j f35027c = new b(1);

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class a extends j {
        a() {
            super(null);
        }

        @Override // com.google.common.collect.j
        public j d(Comparable comparable, Comparable comparable2) {
            return g(comparable.compareTo(comparable2));
        }

        @Override // com.google.common.collect.j
        public int e() {
            return 0;
        }

        j g(int i3) {
            if (i3 < 0) {
                return j.f35026b;
            }
            return i3 > 0 ? j.f35027c : j.f35025a;
        }
    }

    /* synthetic */ j(a aVar) {
        this();
    }

    public static j f() {
        return f35025a;
    }

    public abstract j d(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract int e();

    j() {
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class b extends j {

        /* renamed from: d, reason: collision with root package name */
        final int f35028d;

        b(int i3) {
            super(null);
            this.f35028d = i3;
        }

        @Override // com.google.common.collect.j
        public int e() {
            return this.f35028d;
        }

        @Override // com.google.common.collect.j
        public j d(@NullableDecl Comparable comparable, @NullableDecl Comparable comparable2) {
            return this;
        }
    }
}
