package com.tencent.mobileqq.qdispatchqueue;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class h extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    static final /* synthetic */ boolean f261881m;

    /* renamed from: i, reason: collision with root package name */
    private final Object f261882i;

    /* renamed from: j, reason: collision with root package name */
    private final LinkedList<Task> f261883j;

    /* renamed from: k, reason: collision with root package name */
    private final PriorityQueue<Task> f261884k;

    /* renamed from: l, reason: collision with root package name */
    private final AtomicBoolean f261885l;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14439);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f261881m = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(@NonNull String str, @NonNull Executor executor, @NonNull e eVar, boolean z16) {
        super(str, executor, eVar, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, executor, eVar, Boolean.valueOf(z16));
            return;
        }
        this.f261882i = new Object();
        this.f261883j = new LinkedList<>();
        this.f261884k = new PriorityQueue<>();
        this.f261885l = new AtomicBoolean(false);
    }

    private Task j(@NonNull Runnable runnable, long j3, boolean z16) {
        Task b16 = b(runnable, j3, z16);
        g(b16);
        n(i());
        return b16;
    }

    void g(Task task) {
        synchronized (this.f261882i) {
            if (!task.i()) {
                this.f261883j.add(task);
            } else {
                this.f261884k.add(task);
            }
        }
    }

    Task h(long j3) {
        synchronized (this.f261882i) {
            if (!this.f261883j.isEmpty()) {
                return this.f261883j.remove();
            }
            if (!this.f261884k.isEmpty()) {
                Task peek = this.f261884k.peek();
                if (!f261881m && peek == null) {
                    throw new AssertionError();
                }
                if (j3 >= peek.h()) {
                    return this.f261884k.remove();
                }
            }
            return null;
        }
    }

    Task i() {
        synchronized (this.f261882i) {
            if (!this.f261883j.isEmpty()) {
                Task task = this.f261883j.get(0);
                if (task.j()) {
                    return null;
                }
                return task;
            }
            if (this.f261884k.isEmpty()) {
                return null;
            }
            Task peek = this.f261884k.peek();
            if (!f261881m && peek == null) {
                throw new AssertionError();
            }
            if (peek.j()) {
                return null;
            }
            return peek;
        }
    }

    public void k(@NonNull Runnable runnable, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, runnable, Long.valueOf(j3));
        } else {
            j(runnable, j3, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        while (true) {
            Task h16 = h(System.currentTimeMillis());
            if (h16 == null) {
                this.f261885l.set(false);
                n(i());
                return;
            }
            e(h16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        if (!this.f261885l.compareAndSet(false, true)) {
            return;
        }
        this.f261867b.execute(new Runnable() { // from class: com.tencent.mobileqq.qdispatchqueue.g
            @Override // java.lang.Runnable
            public final void run() {
                h.this.l();
            }
        });
    }

    void n(Task task) {
        if (task == null) {
            return;
        }
        task.l();
        this.f261868c.a(new Runnable() { // from class: com.tencent.mobileqq.qdispatchqueue.f
            @Override // java.lang.Runnable
            public final void run() {
                h.this.m();
            }
        }, Math.max(0L, System.currentTimeMillis() - task.h()));
    }

    @Override // com.tencent.mobileqq.qdispatchqueue.i
    public void post(@NonNull Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
        } else {
            k(runnable, 0L);
        }
    }
}
