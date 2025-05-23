package org.tencwebrtc;

/* loaded from: classes29.dex */
public interface Predicate<T> {

    /* renamed from: org.tencwebrtc.Predicate$-CC, reason: invalid class name */
    /* loaded from: classes29.dex */
    public final /* synthetic */ class CC<T> {
        public static Predicate a(final Predicate predicate, final Predicate predicate2) {
            return new Predicate<T>() { // from class: org.tencwebrtc.Predicate.2
                @Override // org.tencwebrtc.Predicate
                public /* synthetic */ Predicate and(Predicate predicate3) {
                    return CC.a(this, predicate3);
                }

                @Override // org.tencwebrtc.Predicate
                public /* synthetic */ Predicate negate() {
                    return CC.b(this);
                }

                @Override // org.tencwebrtc.Predicate
                public /* synthetic */ Predicate or(Predicate predicate3) {
                    return CC.c(this, predicate3);
                }

                @Override // org.tencwebrtc.Predicate
                public boolean test(T t16) {
                    if (Predicate.this.test(t16) && predicate2.test(t16)) {
                        return true;
                    }
                    return false;
                }
            };
        }

        public static Predicate b(final Predicate predicate) {
            return new Predicate<T>() { // from class: org.tencwebrtc.Predicate.3
                @Override // org.tencwebrtc.Predicate
                public /* synthetic */ Predicate and(Predicate predicate2) {
                    return CC.a(this, predicate2);
                }

                @Override // org.tencwebrtc.Predicate
                public /* synthetic */ Predicate negate() {
                    return CC.b(this);
                }

                @Override // org.tencwebrtc.Predicate
                public /* synthetic */ Predicate or(Predicate predicate2) {
                    return CC.c(this, predicate2);
                }

                @Override // org.tencwebrtc.Predicate
                public boolean test(T t16) {
                    return !Predicate.this.test(t16);
                }
            };
        }

        public static Predicate c(final Predicate predicate, final Predicate predicate2) {
            return new Predicate<T>() { // from class: org.tencwebrtc.Predicate.1
                @Override // org.tencwebrtc.Predicate
                public /* synthetic */ Predicate and(Predicate predicate3) {
                    return CC.a(this, predicate3);
                }

                @Override // org.tencwebrtc.Predicate
                public /* synthetic */ Predicate negate() {
                    return CC.b(this);
                }

                @Override // org.tencwebrtc.Predicate
                public /* synthetic */ Predicate or(Predicate predicate3) {
                    return CC.c(this, predicate3);
                }

                @Override // org.tencwebrtc.Predicate
                public boolean test(T t16) {
                    if (!Predicate.this.test(t16) && !predicate2.test(t16)) {
                        return false;
                    }
                    return true;
                }
            };
        }
    }

    Predicate<T> and(Predicate<? super T> predicate);

    Predicate<T> negate();

    Predicate<T> or(Predicate<? super T> predicate);

    boolean test(T t16);
}
