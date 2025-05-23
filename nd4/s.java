package nd4;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
import nd4.n;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<n, r> f420023a;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final s f420024a = new s();
    }

    public static s c() {
        return b.f420024a;
    }

    @Nullable
    public synchronized r a(@NonNull t tVar, @NonNull m mVar) {
        if (tVar == null || mVar == null) {
            return null;
        }
        String a16 = tVar.a();
        if (TextUtils.isEmpty(a16)) {
            return null;
        }
        r b16 = b(a16);
        if (b16 != null) {
            return b16;
        }
        r rVar = new r(tVar, mVar);
        this.f420023a.put(new n.b().c(a16).b(), rVar);
        return rVar;
    }

    public r b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f420023a.get(new n.b().c(str).b());
    }

    s() {
        this.f420023a = new ConcurrentHashMap<>();
    }
}
