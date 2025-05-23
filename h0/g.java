package h0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public class g<T, Y> {

    /* renamed from: a, reason: collision with root package name */
    private final Map<T, a<Y>> f403955a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b, reason: collision with root package name */
    private final long f403956b;

    /* renamed from: c, reason: collision with root package name */
    private long f403957c;

    /* renamed from: d, reason: collision with root package name */
    private long f403958d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class a<Y> {

        /* renamed from: a, reason: collision with root package name */
        final Y f403959a;

        /* renamed from: b, reason: collision with root package name */
        final int f403960b;

        a(Y y16, int i3) {
            this.f403959a = y16;
            this.f403960b = i3;
        }
    }

    public g(long j3) {
        this.f403956b = j3;
        this.f403957c = j3;
    }

    private void e() {
        l(this.f403957c);
    }

    public void a() {
        l(0L);
    }

    @Nullable
    public synchronized Y f(@NonNull T t16) {
        Y y16;
        a<Y> aVar = this.f403955a.get(t16);
        if (aVar != null) {
            y16 = aVar.f403959a;
        } else {
            y16 = null;
        }
        return y16;
    }

    public synchronized long g() {
        return this.f403957c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int h(@Nullable Y y16) {
        return 1;
    }

    @Nullable
    public synchronized Y j(@NonNull T t16, @Nullable Y y16) {
        a<Y> aVar;
        int h16 = h(y16);
        long j3 = h16;
        Y y17 = null;
        if (j3 >= this.f403957c) {
            i(t16, y16);
            return null;
        }
        if (y16 != null) {
            this.f403958d += j3;
        }
        Map<T, a<Y>> map = this.f403955a;
        if (y16 == null) {
            aVar = null;
        } else {
            aVar = new a<>(y16, h16);
        }
        a<Y> put = map.put(t16, aVar);
        if (put != null) {
            this.f403958d -= put.f403960b;
            if (!put.f403959a.equals(y16)) {
                i(t16, put.f403959a);
            }
        }
        e();
        if (put != null) {
            y17 = put.f403959a;
        }
        return y17;
    }

    @Nullable
    public synchronized Y k(@NonNull T t16) {
        a<Y> remove = this.f403955a.remove(t16);
        if (remove == null) {
            return null;
        }
        this.f403958d -= remove.f403960b;
        return remove.f403959a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void l(long j3) {
        while (this.f403958d > j3) {
            Iterator<Map.Entry<T, a<Y>>> it = this.f403955a.entrySet().iterator();
            Map.Entry<T, a<Y>> next = it.next();
            a<Y> value = next.getValue();
            this.f403958d -= value.f403960b;
            T key = next.getKey();
            it.remove();
            i(key, value.f403959a);
        }
    }

    protected void i(@NonNull T t16, @Nullable Y y16) {
    }
}
