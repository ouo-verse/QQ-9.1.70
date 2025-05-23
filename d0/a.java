package d0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final List<C10150a<?>> f392573a = new ArrayList();

    /* compiled from: P */
    /* renamed from: d0.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static final class C10150a<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<T> f392574a;

        /* renamed from: b, reason: collision with root package name */
        final com.bumptech.glide.load.a<T> f392575b;

        C10150a(@NonNull Class<T> cls, @NonNull com.bumptech.glide.load.a<T> aVar) {
            this.f392574a = cls;
            this.f392575b = aVar;
        }

        boolean a(@NonNull Class<?> cls) {
            return this.f392574a.isAssignableFrom(cls);
        }
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull com.bumptech.glide.load.a<T> aVar) {
        this.f392573a.add(new C10150a<>(cls, aVar));
    }

    @Nullable
    public synchronized <T> com.bumptech.glide.load.a<T> b(@NonNull Class<T> cls) {
        for (C10150a<?> c10150a : this.f392573a) {
            if (c10150a.a(cls)) {
                return (com.bumptech.glide.load.a<T>) c10150a.f392575b;
            }
        }
        return null;
    }
}
