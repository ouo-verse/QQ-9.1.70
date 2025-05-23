package nm0;

import com.tencent.gdtad.log.GdtLog;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes6.dex */
final class c {

    /* renamed from: b, reason: collision with root package name */
    private static volatile c f420453b;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f420454a = new AtomicInteger();

    c() {
    }

    public static c a() {
        if (f420453b == null) {
            synchronized (c.class) {
                if (f420453b == null) {
                    f420453b = new c();
                }
            }
        }
        return f420453b;
    }

    public void b() {
        this.f420454a.incrementAndGet();
    }

    public boolean c() {
        GdtLog.i("GdtPreDownloadLimiter ", "[isEnablePreDownload]");
        if (this.f420454a.get() < 1) {
            GdtLog.i("GdtPreDownloadLimiter ", "[isEnablePreDownload] do preDownload");
            return true;
        }
        return false;
    }
}
