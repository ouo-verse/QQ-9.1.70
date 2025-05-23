package d14;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.tencent.bugly.common.utils.RecyclablePool;
import com.tencent.rmonitor.looper.provider.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes25.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final Class<? extends RecyclablePool.Recyclable> f392654a;

    /* renamed from: b, reason: collision with root package name */
    private final int f392655b;

    /* renamed from: c, reason: collision with root package name */
    private volatile RecyclablePool f392656c = null;

    /* renamed from: d, reason: collision with root package name */
    private volatile RecyclablePool f392657d = null;

    public a(Class<? extends RecyclablePool.Recyclable> cls, int i3) {
        this.f392654a = cls;
        this.f392655b = i3;
    }

    private RecyclablePool a() {
        if (this.f392656c == null) {
            this.f392656c = new RecyclablePool(this.f392654a, this.f392655b);
        }
        return this.f392656c;
    }

    private RecyclablePool b() {
        if (this.f392657d == null) {
            this.f392657d = new RecyclablePool(this.f392654a, this.f392655b);
        }
        return this.f392657d;
    }

    private boolean d() {
        Thread thread = Looper.getMainLooper().getThread();
        Thread currentThread = Thread.currentThread();
        if (currentThread == thread || e.a(thread).getThread() == currentThread) {
            return true;
        }
        return false;
    }

    @NonNull
    public RecyclablePool c() {
        if (d()) {
            return a();
        }
        return b();
    }
}
