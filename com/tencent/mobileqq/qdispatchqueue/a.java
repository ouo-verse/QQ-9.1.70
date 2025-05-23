package com.tencent.mobileqq.qdispatchqueue;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class a implements i {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    private static final ThreadLocal<a> f261864g;

    /* renamed from: h, reason: collision with root package name */
    private static final ConcurrentHashMap<a, a> f261865h;

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    protected final String f261866a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    protected final Executor f261867b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    protected final e f261868c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f261869d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicLong f261870e;

    /* renamed from: f, reason: collision with root package name */
    private final AtomicInteger f261871f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14248);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f261864g = new ThreadLocal<>();
            f261865h = new ConcurrentHashMap<>();
        }
    }

    public a(@NonNull String str, @NonNull Executor executor, @NonNull e eVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, executor, eVar, Boolean.valueOf(z16));
            return;
        }
        this.f261870e = new AtomicLong(1L);
        this.f261871f = new AtomicInteger(0);
        this.f261866a = str;
        this.f261867b = executor;
        this.f261868c = eVar;
        this.f261869d = z16;
    }

    private long a() {
        return this.f261870e.getAndAdd(1L);
    }

    private void d() {
        if (this.f261871f.getAndIncrement() == 0 && c()) {
            f261865h.put(this, this);
        }
    }

    private void f() {
        if (this.f261871f.decrementAndGet() == 0 && c()) {
            f261865h.remove(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Task b(Runnable runnable, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Task) iPatchRedirector.redirect((short) 4, this, runnable, Long.valueOf(j3), Boolean.valueOf(z16));
        }
        d();
        return new Task(a(), runnable, j3, z16);
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.f261869d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(Task task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) task);
            return;
        }
        ThreadLocal<a> threadLocal = f261864g;
        threadLocal.set(this);
        task.n();
        task.run();
        task.m();
        f();
        task.k();
        threadLocal.set(null);
    }
}
