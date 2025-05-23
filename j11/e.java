package j11;

import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface e {

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface a<T extends a, S extends e> {
        T a(int i3);

        T b(InetAddress inetAddress);

        S build();

        T c(int i3, TimeUnit timeUnit);

        T d(b bVar);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface b {
        void onException(Exception exc);

        void onStarted();

        void onStopped();
    }

    void a();

    boolean isRunning();
}
