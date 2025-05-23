package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.co;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class cj implements cl {

    /* renamed from: a, reason: collision with root package name */
    String f148047a;

    /* renamed from: f, reason: collision with root package name */
    private final Set<a> f148049f = new ConcurrentSkipListSet(new Comparator<a>() { // from class: com.tencent.mapsdk.internal.cj.1
        private static int a(a aVar, a aVar2) {
            return aVar.f148051a.compareTo(aVar2.f148051a);
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(a aVar, a aVar2) {
            return aVar.f148051a.compareTo(aVar2.f148051a);
        }
    });

    /* renamed from: b, reason: collision with root package name */
    public final cu f148048b = new cu();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a<S extends cp> {

        /* renamed from: a, reason: collision with root package name */
        String f148051a;

        /* renamed from: b, reason: collision with root package name */
        Class<S> f148052b;

        /* renamed from: c, reason: collision with root package name */
        Method f148053c;

        /* renamed from: d, reason: collision with root package name */
        Map<String, String> f148054d;

        /* renamed from: e, reason: collision with root package name */
        S f148055e;

        a(String str, Class cls, Method method) {
            this.f148051a = str;
            this.f148052b = cls;
            this.f148053c = method;
        }
    }

    private cu c() {
        return this.f148048b;
    }

    private a d(String str) {
        for (a aVar : this.f148049f) {
            if (aVar.f148051a.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    private <S extends cp> S e(Class<S> cls) {
        Iterator<a> it = this.f148049f.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a next = it.next();
            if (next.f148052b == cls) {
                Method method = next.f148053c;
                if (method != null) {
                    try {
                        method.setAccessible(true);
                        Object invoke = method.invoke(this, next.f148052b);
                        if (invoke != null && invoke.getClass() == cls) {
                            S s16 = (S) invoke;
                            s16.a(next.f148054d);
                            next.f148055e = s16;
                            return s16;
                        }
                    } catch (IllegalAccessException e16) {
                        e16.printStackTrace();
                    } catch (InvocationTargetException e17) {
                        e17.printStackTrace();
                    }
                }
            }
        }
        return (S) b(cls);
    }

    @Override // com.tencent.mapsdk.internal.cl
    public final String a() {
        return this.f148047a;
    }

    abstract <S extends cp> S b(Class<S> cls);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <S extends cp> S b(String str) {
        a d16 = d(str);
        if (d16 == null) {
            return null;
        }
        S s16 = d16.f148055e;
        return s16 != null ? s16 : (S) e(d16.f148052b);
    }

    private void c(String str) {
        this.f148047a = str;
    }

    @Override // com.tencent.mapsdk.internal.co
    public final co.a a(String str) {
        return b(str);
    }

    private a d(Class cls) {
        for (a aVar : this.f148049f) {
            if (aVar.f148052b.equals(cls)) {
                return aVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(cn cnVar) {
        Iterator<Class<? extends p>> it = cnVar.b().iterator();
        while (it.hasNext()) {
            o.a(it.next());
        }
        Map<String, Class<? extends co.a>> a16 = cnVar.a();
        this.f148049f.clear();
        for (Map.Entry<String, Class<? extends co.a>> entry : a16.entrySet()) {
            try {
                this.f148049f.add(new a(entry.getKey(), entry.getValue(), cj.class.getDeclaredMethod("b", Class.class)));
            } catch (NoSuchMethodException e16) {
                throw new IllegalStateException(e16);
            }
        }
        Map<String, String> a_ = cnVar.a_();
        if (a_ == null || a_.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry2 : a_.entrySet()) {
            a(entry2.getKey(), entry2.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <S extends cp> S c(Class<S> cls) {
        a aVar;
        Iterator<a> it = this.f148049f.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            aVar = it.next();
            if (aVar.f148052b.equals(cls)) {
                break;
            }
        }
        if (aVar != null) {
            S s16 = aVar.f148055e;
            return s16 != null ? s16 : (S) e(aVar.f148052b);
        }
        return (S) b(cls);
    }

    @Override // com.tencent.mapsdk.internal.cm
    public final /* bridge */ /* synthetic */ ct b() {
        return this.f148048b;
    }

    private void a(String str, String str2) {
        for (a aVar : this.f148049f) {
            if (aVar.f148054d == null) {
                aVar.f148054d = new HashMap();
            }
            aVar.f148054d.put(str, str2);
            S s16 = aVar.f148055e;
            if (s16 != 0) {
                s16.a(aVar.f148054d);
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.co
    public final <T extends co.a> void a(String str, Class<T> cls) {
        try {
            this.f148049f.add(new a(str, cls, cj.class.getDeclaredMethod("b", Class.class)));
        } catch (NoSuchMethodException e16) {
            throw new IllegalStateException(e16);
        }
    }

    @Override // com.tencent.mapsdk.internal.co
    public final <T extends p> void a(Class<T> cls) {
        o.a(cls);
    }
}
