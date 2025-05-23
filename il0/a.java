package il0;

import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static a f407922b;

    /* renamed from: a, reason: collision with root package name */
    private ExecutorService f407923a = ProxyExecutors.newFixedThreadPool(5);

    public static a a() {
        if (f407922b == null) {
            f407922b = new a();
        }
        return f407922b;
    }

    public void b(Runnable runnable) {
        this.f407923a.submit(runnable);
    }
}
