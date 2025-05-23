package d0;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final List<String> f392582a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, List<a<?, ?>>> f392583b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class a<T, R> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<T> f392584a;

        /* renamed from: b, reason: collision with root package name */
        final Class<R> f392585b;

        /* renamed from: c, reason: collision with root package name */
        final com.bumptech.glide.load.f<T, R> f392586c;

        public a(@NonNull Class<T> cls, @NonNull Class<R> cls2, com.bumptech.glide.load.f<T, R> fVar) {
            this.f392584a = cls;
            this.f392585b = cls2;
            this.f392586c = fVar;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            if (this.f392584a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f392585b)) {
                return true;
            }
            return false;
        }
    }

    @NonNull
    private synchronized List<a<?, ?>> c(@NonNull String str) {
        List<a<?, ?>> list;
        if (!this.f392582a.contains(str)) {
            this.f392582a.add(str);
        }
        list = this.f392583b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f392583b.put(str, list);
        }
        return list;
    }

    public synchronized <T, R> void a(@NonNull String str, @NonNull com.bumptech.glide.load.f<T, R> fVar, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        c(str).add(new a<>(cls, cls2, fVar));
    }

    @NonNull
    public synchronized <T, R> List<com.bumptech.glide.load.f<T, R>> b(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f392582a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.f392583b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f392586c);
                    }
                }
            }
        }
        return arrayList;
    }

    @NonNull
    public synchronized <T, R> List<Class<R>> d(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f392582a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.f392583b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f392585b)) {
                        arrayList.add(aVar.f392585b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized void e(@NonNull List<String> list) {
        ArrayList<String> arrayList = new ArrayList(this.f392582a);
        this.f392582a.clear();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.f392582a.add(it.next());
        }
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f392582a.add(str);
            }
        }
    }
}
