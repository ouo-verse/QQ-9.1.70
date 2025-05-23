package com.google.protobuf;

import com.google.protobuf.ad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class ai {

    /* renamed from: a, reason: collision with root package name */
    private static final ai f35658a;

    /* renamed from: b, reason: collision with root package name */
    private static final ai f35659b;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class b extends ai {

        /* renamed from: c, reason: collision with root package name */
        private static final Class<?> f35660c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        b() {
            super();
        }

        static <E> List<E> f(Object obj, long j3) {
            return (List) ch.E(obj, j3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static <L> List<L> g(Object obj, long j3, int i3) {
            ag agVar;
            List<L> arrayList;
            List<L> f16 = f(obj, j3);
            if (f16.isEmpty()) {
                if (f16 instanceof ah) {
                    arrayList = new ag(i3);
                } else if ((f16 instanceof bh) && (f16 instanceof ad.j)) {
                    arrayList = ((ad.j) f16).b2(i3);
                } else {
                    arrayList = new ArrayList<>(i3);
                }
                ch.U(obj, j3, arrayList);
                return arrayList;
            }
            if (f35660c.isAssignableFrom(f16.getClass())) {
                ArrayList arrayList2 = new ArrayList(f16.size() + i3);
                arrayList2.addAll(f16);
                ch.U(obj, j3, arrayList2);
                agVar = arrayList2;
            } else if (f16 instanceof cg) {
                ag agVar2 = new ag(f16.size() + i3);
                agVar2.addAll((cg) f16);
                ch.U(obj, j3, agVar2);
                agVar = agVar2;
            } else {
                if ((f16 instanceof bh) && (f16 instanceof ad.j)) {
                    ad.j jVar = (ad.j) f16;
                    if (!jVar.z()) {
                        ad.j b26 = jVar.b2(f16.size() + i3);
                        ch.U(obj, j3, b26);
                        return b26;
                    }
                    return f16;
                }
                return f16;
            }
            return agVar;
        }

        @Override // com.google.protobuf.ai
        void c(Object obj, long j3) {
            Object unmodifiableList;
            List list = (List) ch.E(obj, j3);
            if (list instanceof ah) {
                unmodifiableList = ((ah) list).getUnmodifiableView();
            } else {
                if (f35660c.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof bh) && (list instanceof ad.j)) {
                    ad.j jVar = (ad.j) list;
                    if (jVar.z()) {
                        jVar.y();
                        return;
                    }
                    return;
                }
                unmodifiableList = Collections.unmodifiableList(list);
            }
            ch.U(obj, j3, unmodifiableList);
        }

        @Override // com.google.protobuf.ai
        <E> void d(Object obj, Object obj2, long j3) {
            List f16 = f(obj2, j3);
            List g16 = g(obj, j3, f16.size());
            int size = g16.size();
            int size2 = f16.size();
            if (size > 0 && size2 > 0) {
                g16.addAll(f16);
            }
            if (size > 0) {
                f16 = g16;
            }
            ch.U(obj, j3, f16);
        }

        @Override // com.google.protobuf.ai
        <L> List<L> e(Object obj, long j3) {
            return g(obj, j3, 10);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class c extends ai {
        c() {
            super();
        }

        static <E> ad.j<E> f(Object obj, long j3) {
            return (ad.j) ch.E(obj, j3);
        }

        @Override // com.google.protobuf.ai
        void c(Object obj, long j3) {
            f(obj, j3).y();
        }

        @Override // com.google.protobuf.ai
        <E> void d(Object obj, Object obj2, long j3) {
            ad.j f16 = f(obj, j3);
            ad.j f17 = f(obj2, j3);
            int size = f16.size();
            int size2 = f17.size();
            if (size > 0 && size2 > 0) {
                if (!f16.z()) {
                    f16 = f16.b2(size2 + size);
                }
                f16.addAll(f17);
            }
            if (size > 0) {
                f17 = f16;
            }
            ch.U(obj, j3, f17);
        }

        @Override // com.google.protobuf.ai
        <L> List<L> e(Object obj, long j3) {
            int i3;
            ad.j f16 = f(obj, j3);
            if (!f16.z()) {
                int size = f16.size();
                if (size == 0) {
                    i3 = 10;
                } else {
                    i3 = size * 2;
                }
                ad.j b26 = f16.b2(i3);
                ch.U(obj, j3, b26);
                return b26;
            }
            return f16;
        }
    }

    static {
        f35658a = new b();
        f35659b = new c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ai a() {
        return f35658a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ai b() {
        return f35659b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c(Object obj, long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> void d(Object obj, Object obj2, long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> List<L> e(Object obj, long j3);

    ai() {
    }
}
