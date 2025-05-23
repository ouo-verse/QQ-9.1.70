package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.common.base.b f34696a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f34697b;

    /* renamed from: c, reason: collision with root package name */
    private final d f34698c;

    /* renamed from: d, reason: collision with root package name */
    private final int f34699d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.common.base.b f34700a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.google.common.base.l$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0244a extends c {
            C0244a(l lVar, CharSequence charSequence) {
                super(lVar, charSequence);
            }

            @Override // com.google.common.base.l.c
            int e(int i3) {
                return i3 + 1;
            }

            @Override // com.google.common.base.l.c
            int f(int i3) {
                return a.this.f34700a.c(this.f34703f, i3);
            }
        }

        a(com.google.common.base.b bVar) {
            this.f34700a = bVar;
        }

        @Override // com.google.common.base.l.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c a(l lVar, CharSequence charSequence) {
            return new C0244a(lVar, charSequence);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class b implements Iterable<String> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CharSequence f34701d;

        b(CharSequence charSequence) {
            this.f34701d = charSequence;
        }

        @Override // java.lang.Iterable
        public Iterator<String> iterator() {
            return l.this.h(this.f34701d);
        }

        public String toString() {
            e h16 = e.h(", ");
            StringBuilder sb5 = new StringBuilder();
            sb5.append('[');
            StringBuilder b16 = h16.b(sb5, this);
            b16.append(']');
            return b16.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static abstract class c extends AbstractIterator<String> {
        int C;

        /* renamed from: f, reason: collision with root package name */
        final CharSequence f34703f;

        /* renamed from: h, reason: collision with root package name */
        final com.google.common.base.b f34704h;

        /* renamed from: i, reason: collision with root package name */
        final boolean f34705i;

        /* renamed from: m, reason: collision with root package name */
        int f34706m = 0;

        protected c(l lVar, CharSequence charSequence) {
            this.f34704h = lVar.f34696a;
            this.f34705i = lVar.f34697b;
            this.C = lVar.f34699d;
            this.f34703f = charSequence;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.AbstractIterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a() {
            int f16;
            int i3 = this.f34706m;
            while (true) {
                int i16 = this.f34706m;
                if (i16 != -1) {
                    f16 = f(i16);
                    if (f16 == -1) {
                        f16 = this.f34703f.length();
                        this.f34706m = -1;
                    } else {
                        this.f34706m = e(f16);
                    }
                    int i17 = this.f34706m;
                    if (i17 == i3) {
                        int i18 = i17 + 1;
                        this.f34706m = i18;
                        if (i18 > this.f34703f.length()) {
                            this.f34706m = -1;
                        }
                    } else {
                        while (i3 < f16 && this.f34704h.e(this.f34703f.charAt(i3))) {
                            i3++;
                        }
                        while (f16 > i3 && this.f34704h.e(this.f34703f.charAt(f16 - 1))) {
                            f16--;
                        }
                        if (!this.f34705i || i3 != f16) {
                            break;
                        }
                        i3 = this.f34706m;
                    }
                } else {
                    return b();
                }
            }
            int i19 = this.C;
            if (i19 == 1) {
                f16 = this.f34703f.length();
                this.f34706m = -1;
                while (f16 > i3 && this.f34704h.e(this.f34703f.charAt(f16 - 1))) {
                    f16--;
                }
            } else {
                this.C = i19 - 1;
            }
            return this.f34703f.subSequence(i3, f16).toString();
        }

        abstract int e(int i3);

        abstract int f(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface d {
        Iterator<String> a(l lVar, CharSequence charSequence);
    }

    l(d dVar) {
        this(dVar, false, com.google.common.base.b.f(), Integer.MAX_VALUE);
    }

    public static l e(char c16) {
        return f(com.google.common.base.b.d(c16));
    }

    public static l f(com.google.common.base.b bVar) {
        j.m(bVar);
        return new l(new a(bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Iterator<String> h(CharSequence charSequence) {
        return this.f34698c.a(this, charSequence);
    }

    public Iterable<String> g(CharSequence charSequence) {
        j.m(charSequence);
        return new b(charSequence);
    }

    l(d dVar, boolean z16, com.google.common.base.b bVar, int i3) {
        this.f34698c = dVar;
        this.f34697b = z16;
        this.f34696a = bVar;
        this.f34699d = i3;
    }
}
