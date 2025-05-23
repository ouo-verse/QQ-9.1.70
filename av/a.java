package av;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class a {

    /* renamed from: d, reason: collision with root package name */
    private final String f26963d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f26964e = b();

    /* renamed from: f, reason: collision with root package name */
    private long f26965f = e();

    public a(String str) {
        this.f26963d = str;
        QLog.d(str, 1, "init mNextAuthTimeMills:=" + this.f26965f + ", authCache:=" + this.f26964e);
    }

    private boolean b() {
        return vu.a.c().j(this.f26963d);
    }

    private synchronized boolean d() {
        return this.f26964e;
    }

    private long e() {
        return vu.a.c().a(this.f26963d);
    }

    private synchronized long f() {
        return this.f26965f;
    }

    private synchronized boolean g() {
        return f() < NetConnInfoCenter.getServerTimeMillis();
    }

    private void h(boolean z16) {
        QLog.d(this.f26963d, 1, "setAuthResultToCache auth:=" + z16);
        vu.a.c().q(this.f26963d, z16);
    }

    private void i(long j3) {
        QLog.d(this.f26963d, 1, "setLastAuthTimeMillsToCache mNextAuthTimeMills:=" + j3);
        vu.a.c().p(this.f26963d, j3);
    }

    public final int a() {
        if (g()) {
            return -1;
        }
        return !d() ? 1 : 0;
    }

    public abstract long c();

    public abstract void j();

    public final synchronized void k(boolean z16) {
        this.f26964e = z16;
        h(z16);
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() + c();
        this.f26965f = serverTimeMillis;
        i(serverTimeMillis);
    }
}
