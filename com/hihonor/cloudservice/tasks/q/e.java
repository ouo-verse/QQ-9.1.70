package com.hihonor.cloudservice.tasks.q;

import com.hihonor.cloudservice.tasks.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class e<TResult> extends f<TResult> {

    /* renamed from: b, reason: collision with root package name */
    private boolean f36243b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f36244c;

    /* renamed from: d, reason: collision with root package name */
    private TResult f36245d;

    /* renamed from: e, reason: collision with root package name */
    private Exception f36246e;

    /* renamed from: a, reason: collision with root package name */
    private final Object f36242a = new Object();

    /* renamed from: f, reason: collision with root package name */
    private List<com.hihonor.cloudservice.tasks.a<TResult>> f36247f = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            synchronized (d.b(null)) {
                d.c(null);
            }
        }
    }

    private void f() {
        synchronized (this.f36242a) {
            Iterator<com.hihonor.cloudservice.tasks.a<TResult>> it = this.f36247f.iterator();
            while (it.hasNext()) {
                try {
                    it.next().a(this);
                } catch (RuntimeException e16) {
                    throw e16;
                } catch (Exception e17) {
                    throw new RuntimeException(e17);
                }
            }
            this.f36247f = null;
        }
    }

    @Override // com.hihonor.cloudservice.tasks.f
    public TResult a() {
        TResult tresult;
        synchronized (this.f36242a) {
            if (this.f36246e == null) {
                tresult = this.f36245d;
            } else {
                throw new RuntimeException(this.f36246e);
            }
        }
        return tresult;
    }

    @Override // com.hihonor.cloudservice.tasks.f
    public boolean b() {
        boolean z16;
        synchronized (this.f36242a) {
            if (this.f36243b && !g() && this.f36246e == null) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    public final void c(Exception exc) {
        synchronized (this.f36242a) {
            if (!this.f36243b) {
                this.f36243b = true;
                this.f36246e = exc;
                this.f36242a.notifyAll();
                f();
            }
        }
    }

    public final void d(TResult tresult) {
        synchronized (this.f36242a) {
            if (!this.f36243b) {
                this.f36243b = true;
                this.f36245d = tresult;
                this.f36242a.notifyAll();
                f();
            }
        }
    }

    public final boolean e() {
        synchronized (this.f36242a) {
            if (this.f36243b) {
                return false;
            }
            this.f36243b = true;
            this.f36244c = true;
            this.f36242a.notifyAll();
            f();
            return true;
        }
    }

    public boolean g() {
        return this.f36244c;
    }
}
