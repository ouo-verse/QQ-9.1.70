package com.tencent.luggage.wxa.ca;

import android.app.Application;
import android.content.Context;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ca.c[] f123443a = {null};

    /* renamed from: b, reason: collision with root package name */
    public static com.tencent.luggage.wxa.go.a f123444b;

    /* renamed from: c, reason: collision with root package name */
    public static Application f123445c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements d {

        /* renamed from: a, reason: collision with root package name */
        public final d f123446a;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ca.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6102a implements C6103b.a {
            public C6102a() {
            }

            @Override // com.tencent.luggage.wxa.ca.b.C6103b.a
            public boolean a(i iVar) {
                return b.b(b.f123445c, iVar);
            }
        }

        public a(d dVar) {
            this.f123446a = dVar;
        }

        @Override // com.tencent.luggage.wxa.ca.d
        public Iterable a() {
            return new C6103b(this.f123446a.a(), new C6102a());
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ca.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6103b implements Iterable {

        /* renamed from: a, reason: collision with root package name */
        public final Iterable f123448a;

        /* renamed from: b, reason: collision with root package name */
        public final a f123449b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ca.b$b$a */
        /* loaded from: classes8.dex */
        public interface a {
            boolean a(Object obj);
        }

        public C6103b(Iterable iterable, a aVar) {
            this.f123448a = iterable;
            this.f123449b = aVar;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new c(this.f123448a.iterator(), this.f123449b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        public final Iterator f123450a;

        /* renamed from: b, reason: collision with root package name */
        public final C6103b.a f123451b;

        /* renamed from: c, reason: collision with root package name */
        public Object f123452c = null;

        public c(Iterator it, C6103b.a aVar) {
            this.f123450a = it;
            this.f123451b = aVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f123452c != null) {
                return true;
            }
            while (this.f123450a.hasNext()) {
                Object next = this.f123450a.next();
                if (this.f123451b.a(next)) {
                    this.f123452c = next;
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (hasNext()) {
                Object obj = this.f123452c;
                this.f123452c = null;
                return obj;
            }
            throw new NoSuchElementException();
        }
    }

    public static boolean b() {
        com.tencent.luggage.wxa.go.a aVar = f123444b;
        return aVar != null && aVar.a();
    }

    public static boolean c(Context context, i iVar) {
        Object a16 = iVar.a("onProcess");
        if (a16 == null) {
            return true;
        }
        if (a16 instanceof com.tencent.luggage.wxa.z8.d) {
            if (((com.tencent.luggage.wxa.z8.d) a16).a(context)) {
                return true;
            }
            return false;
        }
        if (a16 instanceof List) {
            List list = (List) a16;
            if (list.isEmpty()) {
                return true;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((com.tencent.luggage.wxa.z8.d) it.next()).a(context)) {
                    return true;
                }
            }
            return false;
        }
        throw new IllegalStateException("Unexpected 'onProcess' value type '" + a16.getClass().getName() + "' of '" + iVar + "'");
    }

    public static boolean b(Context context, i iVar) {
        if (!c(context, iVar)) {
            return false;
        }
        Boolean bool = (Boolean) iVar.a("accountAware");
        return bool == null || !bool.booleanValue() || b();
    }

    public static void a(Application application, com.tencent.luggage.wxa.ca.c cVar, com.tencent.luggage.wxa.go.a aVar) {
        com.tencent.luggage.wxa.ca.c[] cVarArr = f123443a;
        if (cVarArr[0] == null) {
            synchronized (cVarArr) {
                if (cVarArr[0] == null) {
                    f123445c = application;
                    cVarArr[0] = cVar;
                    f123444b = aVar;
                }
            }
        }
    }

    public static d a(Class cls) {
        com.tencent.luggage.wxa.ca.c[] cVarArr = f123443a;
        if (cVarArr[0] == null) {
            synchronized (cVarArr) {
                if (cVarArr[0] == null) {
                    throw new IllegalStateException("Please call init(...) first.");
                }
            }
        }
        return new a(cVarArr[0].a(cls));
    }

    public static boolean a(Class cls, g gVar) {
        for (i iVar : a(cls).a()) {
            if (b(f123445c, iVar) && gVar.a((f) iVar.get())) {
                return true;
            }
        }
        return false;
    }
}
