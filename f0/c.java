package f0;

import com.bumptech.glide.load.DataSource;
import f0.d;

/* compiled from: P */
/* loaded from: classes.dex */
public class c<R> implements d<R> {

    /* renamed from: a, reason: collision with root package name */
    static final c<?> f397484a = new c<>();

    /* renamed from: b, reason: collision with root package name */
    private static final e<?> f397485b = new a();

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class a<R> implements e<R> {
        @Override // f0.e
        public d<R> a(DataSource dataSource, boolean z16) {
            return c.f397484a;
        }
    }

    public static <R> d<R> b() {
        return f397484a;
    }

    public static <R> e<R> c() {
        return (e<R>) f397485b;
    }

    @Override // f0.d
    public boolean a(Object obj, d.a aVar) {
        return false;
    }
}
