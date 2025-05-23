package d0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.g;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final List<a<?>> f392587a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class a<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<T> f392588a;

        /* renamed from: b, reason: collision with root package name */
        final g<T> f392589b;

        a(@NonNull Class<T> cls, @NonNull g<T> gVar) {
            this.f392588a = cls;
            this.f392589b = gVar;
        }

        boolean a(@NonNull Class<?> cls) {
            return this.f392588a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(@NonNull Class<Z> cls, @NonNull g<Z> gVar) {
        this.f392587a.add(new a<>(cls, gVar));
    }

    @Nullable
    public synchronized <Z> g<Z> b(@NonNull Class<Z> cls) {
        int size = this.f392587a.size();
        for (int i3 = 0; i3 < size; i3++) {
            a<?> aVar = this.f392587a.get(i3);
            if (aVar.a(cls)) {
                return (g<Z>) aVar.f392589b;
            }
        }
        return null;
    }
}
