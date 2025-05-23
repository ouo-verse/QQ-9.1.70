package com.xingin.xhssharesdk.a;

import com.xingin.xhssharesdk.a.a;
import com.xingin.xhssharesdk.a.c0;
import com.xingin.xhssharesdk.a.d;
import com.xingin.xhssharesdk.a.k;
import com.xingin.xhssharesdk.a.k.a;
import com.xingin.xhssharesdk.a.l;
import com.xingin.xhssharesdk.a.p;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class k<MessageType extends k<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends com.xingin.xhssharesdk.a.a<MessageType, BuilderType> {

    /* renamed from: e, reason: collision with root package name */
    public nz4.i f389934e = nz4.i.f421649d;

    /* renamed from: f, reason: collision with root package name */
    public int f389935f = -1;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class a<MessageType extends k<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends a.AbstractC10092a<MessageType, BuilderType> {

        /* renamed from: d, reason: collision with root package name */
        public final MessageType f389936d;

        /* renamed from: e, reason: collision with root package name */
        public MessageType f389937e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f389938f = false;

        public a(MessageType messagetype) {
            this.f389936d = messagetype;
            this.f389937e = (MessageType) messagetype.b(h.f389949e);
        }

        public final BuilderType b(MessageType messagetype) {
            f();
            this.f389937e.e(g.f389944a, messagetype);
            return this;
        }

        @Override // nz4.f
        public final k c() {
            return this.f389936d;
        }

        public final Object clone() {
            a aVar = (a) this.f389936d.b(h.f389950f);
            if (!this.f389938f) {
                this.f389937e.g();
                this.f389938f = true;
            }
            aVar.b(this.f389937e);
            return aVar;
        }

        public final MessageType e() {
            if (!this.f389938f) {
                this.f389937e.g();
                this.f389938f = true;
            }
            MessageType messagetype = this.f389937e;
            if (messagetype.f()) {
                return messagetype;
            }
            throw new y();
        }

        public final void f() {
            if (this.f389938f) {
                MessageType messagetype = (MessageType) this.f389937e.b(h.f389949e);
                messagetype.e(g.f389944a, this.f389937e);
                this.f389937e = messagetype;
                this.f389938f = false;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class b<T extends k<T, ?>> extends com.xingin.xhssharesdk.a.b<T> {

        /* renamed from: a, reason: collision with root package name */
        public final T f389939a;

        public b(T t16) {
            this.f389939a = t16;
        }

        @Override // nz4.g
        public final k a(com.xingin.xhssharesdk.a.c cVar, nz4.e eVar) {
            k kVar = (k) this.f389939a.b(h.f389949e);
            try {
                kVar.c(h.f389947c, cVar, eVar);
                kVar.g();
                return kVar;
            } catch (RuntimeException e16) {
                if (e16.getCause() instanceof m) {
                    throw ((m) e16.getCause());
                }
                throw e16;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class c implements i {

        /* renamed from: a, reason: collision with root package name */
        public static final c f389940a = new c();

        /* renamed from: b, reason: collision with root package name */
        public static final a f389941b = new a();

        /* compiled from: P */
        /* loaded from: classes28.dex */
        public static final class a extends RuntimeException {
        }

        @Override // com.xingin.xhssharesdk.a.k.i
        public final com.xingin.xhssharesdk.a.d<e> a(com.xingin.xhssharesdk.a.d<e> dVar, com.xingin.xhssharesdk.a.d<e> dVar2) {
            if (dVar.equals(dVar2)) {
                return dVar;
            }
            throw f389941b;
        }

        @Override // com.xingin.xhssharesdk.a.k.i
        public final nz4.i b(nz4.i iVar, nz4.i iVar2) {
            if (iVar.equals(iVar2)) {
                return iVar;
            }
            throw f389941b;
        }

        @Override // com.xingin.xhssharesdk.a.k.i
        public final l c(k kVar, k kVar2) {
            if (kVar == null && kVar2 == null) {
                return null;
            }
            if (kVar != null && kVar2 != null) {
                if (kVar != kVar2 && ((k) kVar.b(h.f389951g)).getClass().isInstance(kVar2)) {
                    kVar.e(this, kVar2);
                }
                return kVar;
            }
            throw f389941b;
        }

        @Override // com.xingin.xhssharesdk.a.k.i
        public final int d(boolean z16, int i3, boolean z17, int i16) {
            if (z16 == z17 && i3 == i16) {
                return i3;
            }
            throw f389941b;
        }

        @Override // com.xingin.xhssharesdk.a.k.i
        public final String e(boolean z16, String str, boolean z17, String str2) {
            if (z16 == z17 && str.equals(str2)) {
                return str;
            }
            throw f389941b;
        }

        @Override // com.xingin.xhssharesdk.a.k.i
        public final <K, V> q<K, V> f(q<K, V> qVar, q<K, V> qVar2) {
            if (qVar.equals(qVar2)) {
                return qVar;
            }
            throw f389941b;
        }

        @Override // com.xingin.xhssharesdk.a.k.i
        public final long g(boolean z16, long j3, boolean z17, long j16) {
            if (z16 == z17 && j3 == j16) {
                return j3;
            }
            throw f389941b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class d<MessageType extends d<MessageType, BuilderType>, BuilderType> extends k<MessageType, BuilderType> implements nz4.f {

        /* renamed from: h, reason: collision with root package name */
        public com.xingin.xhssharesdk.a.d<e> f389942h = com.xingin.xhssharesdk.a.d.i();

        @Override // com.xingin.xhssharesdk.a.k, nz4.f
        public final k c() {
            return (k) b(h.f389951g);
        }

        @Override // com.xingin.xhssharesdk.a.k, com.xingin.xhssharesdk.a.l
        public final /* bridge */ /* synthetic */ a d() {
            return d();
        }

        @Override // com.xingin.xhssharesdk.a.k
        public final void e(i iVar, k kVar) {
            d dVar = (d) kVar;
            super.e(iVar, dVar);
            this.f389942h = iVar.a(this.f389942h, dVar.f389942h);
        }

        @Override // com.xingin.xhssharesdk.a.k
        public final void g() {
            super.g();
            this.f389942h.h();
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class e implements d.a<e> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.xingin.xhssharesdk.a.d.a
        public final a b(l.a aVar, l lVar) {
            return ((a) aVar).b((k) lVar);
        }

        @Override // com.xingin.xhssharesdk.a.d.a
        public final c0.b c() {
            throw null;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            ((e) obj).getClass();
            return 0;
        }

        @Override // com.xingin.xhssharesdk.a.d.a
        public final void b() {
        }

        @Override // com.xingin.xhssharesdk.a.d.a
        public final void a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class f implements i {

        /* renamed from: a, reason: collision with root package name */
        public int f389943a = 0;

        @Override // com.xingin.xhssharesdk.a.k.i
        public final com.xingin.xhssharesdk.a.d<e> a(com.xingin.xhssharesdk.a.d<e> dVar, com.xingin.xhssharesdk.a.d<e> dVar2) {
            this.f389943a = dVar.f389904a.hashCode() + (this.f389943a * 53);
            return dVar;
        }

        @Override // com.xingin.xhssharesdk.a.k.i
        public final nz4.i b(nz4.i iVar, nz4.i iVar2) {
            this.f389943a = iVar.hashCode() + (this.f389943a * 53);
            return iVar;
        }

        @Override // com.xingin.xhssharesdk.a.k.i
        public final l c(k kVar, k kVar2) {
            int i3;
            if (kVar != null) {
                if (kVar.f389875d == 0) {
                    int i16 = this.f389943a;
                    this.f389943a = 0;
                    kVar.e(this, kVar);
                    kVar.f389875d = this.f389943a;
                    this.f389943a = i16;
                }
                i3 = kVar.f389875d;
            } else {
                i3 = 37;
            }
            this.f389943a = (this.f389943a * 53) + i3;
            return kVar;
        }

        @Override // com.xingin.xhssharesdk.a.k.i
        public final int d(boolean z16, int i3, boolean z17, int i16) {
            this.f389943a = (this.f389943a * 53) + i3;
            return i3;
        }

        @Override // com.xingin.xhssharesdk.a.k.i
        public final String e(boolean z16, String str, boolean z17, String str2) {
            this.f389943a = str.hashCode() + (this.f389943a * 53);
            return str;
        }

        @Override // com.xingin.xhssharesdk.a.k.i
        public final <K, V> q<K, V> f(q<K, V> qVar, q<K, V> qVar2) {
            this.f389943a = qVar.hashCode() + (this.f389943a * 53);
            return qVar;
        }

        @Override // com.xingin.xhssharesdk.a.k.i
        public final long g(boolean z16, long j3, boolean z17, long j16) {
            int i3 = this.f389943a * 53;
            Charset charset = com.xingin.xhssharesdk.a.f.f389911a;
            this.f389943a = i3 + ((int) ((j3 >>> 32) ^ j3));
            return j3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class g implements i {

        /* renamed from: a, reason: collision with root package name */
        public static final g f389944a = new g();

        @Override // com.xingin.xhssharesdk.a.k.i
        public final com.xingin.xhssharesdk.a.d<e> a(com.xingin.xhssharesdk.a.d<e> dVar, com.xingin.xhssharesdk.a.d<e> dVar2) {
            Iterable entrySet;
            if (dVar.f389905b) {
                dVar = dVar.clone();
            }
            for (int i3 = 0; i3 < dVar2.f389904a.f389956e.size(); i3++) {
                dVar.g(dVar2.f389904a.f389956e.get(i3));
            }
            o oVar = dVar2.f389904a;
            if (oVar.f389957f.isEmpty()) {
                entrySet = p.a.f389961b;
            } else {
                entrySet = oVar.f389957f.entrySet();
            }
            Iterator it = entrySet.iterator();
            while (it.hasNext()) {
                dVar.g((Map.Entry) it.next());
            }
            return dVar;
        }

        @Override // com.xingin.xhssharesdk.a.k.i
        public final nz4.i b(nz4.i iVar, nz4.i iVar2) {
            if (iVar2 != nz4.i.f421649d) {
                return nz4.i.a(iVar, iVar2);
            }
            return iVar;
        }

        @Override // com.xingin.xhssharesdk.a.k.i
        public final l c(k kVar, k kVar2) {
            if (kVar != null && kVar2 != null) {
                a d16 = kVar.d();
                d16.getClass();
                if (d16.f389936d.getClass().isInstance(kVar2)) {
                    return d16.b(kVar2).e();
                }
                throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
            }
            if (kVar == null) {
                return kVar2;
            }
            return kVar;
        }

        @Override // com.xingin.xhssharesdk.a.k.i
        public final int d(boolean z16, int i3, boolean z17, int i16) {
            if (z17) {
                return i16;
            }
            return i3;
        }

        @Override // com.xingin.xhssharesdk.a.k.i
        public final String e(boolean z16, String str, boolean z17, String str2) {
            if (z17) {
                return str2;
            }
            return str;
        }

        @Override // com.xingin.xhssharesdk.a.k.i
        public final <K, V> q<K, V> f(q<K, V> qVar, q<K, V> qVar2) {
            if (!qVar2.isEmpty()) {
                if (!qVar.f389971a) {
                    if (qVar.isEmpty()) {
                        qVar = new q<>();
                    } else {
                        qVar = new q<>(qVar);
                    }
                }
                qVar.a(qVar2);
            }
            return qVar;
        }

        @Override // com.xingin.xhssharesdk.a.k.i
        public final long g(boolean z16, long j3, boolean z17, long j16) {
            if (z17) {
                return j16;
            }
            return j3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public enum h {
        f389945a,
        f389946b,
        f389947c,
        f389948d,
        f389949e,
        f389950f,
        f389951g,
        f389952h;

        h() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface i {
        com.xingin.xhssharesdk.a.d<e> a(com.xingin.xhssharesdk.a.d<e> dVar, com.xingin.xhssharesdk.a.d<e> dVar2);

        nz4.i b(nz4.i iVar, nz4.i iVar2);

        l c(k kVar, k kVar2);

        int d(boolean z16, int i3, boolean z17, int i16);

        String e(boolean z16, String str, boolean z17, String str2);

        <K, V> q<K, V> f(q<K, V> qVar, q<K, V> qVar2);

        long g(boolean z16, long j3, boolean z17, long j16);
    }

    public static Object d(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e16) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e16);
        } catch (InvocationTargetException e17) {
            Throwable cause = e17.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public final Object b(h hVar) {
        return c(hVar, null, null);
    }

    @Override // nz4.f
    public k c() {
        return (k) b(h.f389951g);
    }

    public abstract Object c(h hVar, Object obj, Object obj2);

    public void e(i iVar, MessageType messagetype) {
        c(h.f389946b, iVar, messagetype);
        this.f389934e = iVar.b(this.f389934e, messagetype.f389934e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((k) b(h.f389951g)).getClass().isInstance(obj)) {
            return false;
        }
        try {
            e(c.f389940a, (k) obj);
            return true;
        } catch (c.a unused) {
            return false;
        }
    }

    public final boolean f() {
        if (c(h.f389945a, Boolean.TRUE, null) != null) {
            return true;
        }
        return false;
    }

    public void g() {
        b(h.f389948d);
        this.f389934e.getClass();
    }

    @Override // com.xingin.xhssharesdk.a.l
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final BuilderType d() {
        BuilderType buildertype = (BuilderType) b(h.f389950f);
        buildertype.b(this);
        return buildertype;
    }

    public final int hashCode() {
        if (this.f389875d == 0) {
            f fVar = new f();
            e(fVar, this);
            this.f389875d = fVar.f389943a;
        }
        return this.f389875d;
    }

    public final String toString() {
        String obj = super.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("# ");
        sb5.append(obj);
        n.a(this, sb5, 0);
        return sb5.toString();
    }
}
