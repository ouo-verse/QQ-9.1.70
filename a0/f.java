package a0;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final List<a<?, ?>> f25298a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class a<Z, R> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<Z> f25299a;

        /* renamed from: b, reason: collision with root package name */
        private final Class<R> f25300b;

        /* renamed from: c, reason: collision with root package name */
        final e<Z, R> f25301c;

        a(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull e<Z, R> eVar) {
            this.f25299a = cls;
            this.f25300b = cls2;
            this.f25301c = eVar;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            if (this.f25299a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f25300b)) {
                return true;
            }
            return false;
        }
    }

    @NonNull
    public synchronized <Z, R> e<Z, R> a(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return g.b();
        }
        for (a<?, ?> aVar : this.f25298a) {
            if (aVar.a(cls, cls2)) {
                return (e<Z, R>) aVar.f25301c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    @NonNull
    public synchronized <Z, R> List<Class<R>> b(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        Iterator<a<?, ?>> it = this.f25298a.iterator();
        while (it.hasNext()) {
            if (it.next().a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    public synchronized <Z, R> void c(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull e<Z, R> eVar) {
        this.f25298a.add(new a<>(cls, cls2, eVar));
    }
}
