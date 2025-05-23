package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@GwtIncompatible
/* loaded from: classes2.dex */
public final class ListenerCallQueue<L> {

    /* renamed from: b, reason: collision with root package name */
    private static final Logger f35137b = Logger.getLogger(ListenerCallQueue.class.getName());

    /* renamed from: a, reason: collision with root package name */
    private final List<PerListenerQueue<L>> f35138a = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class PerListenerQueue<L> implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final L f35139d;

        /* renamed from: e, reason: collision with root package name */
        final Executor f35140e;

        /* renamed from: f, reason: collision with root package name */
        @GuardedBy("this")
        final Queue<a<L>> f35141f;

        /* renamed from: h, reason: collision with root package name */
        @GuardedBy("this")
        final Queue<Object> f35142h;

        /* renamed from: i, reason: collision with root package name */
        @GuardedBy("this")
        boolean f35143i;

        synchronized void a(a<L> aVar, Object obj) {
            this.f35141f.add(aVar);
            this.f35142h.add(obj);
        }

        void e() {
            boolean z16;
            synchronized (this) {
                if (!this.f35143i) {
                    z16 = true;
                    this.f35143i = true;
                } else {
                    z16 = false;
                }
            }
            if (z16) {
                try {
                    this.f35140e.execute(this);
                } catch (RuntimeException e16) {
                    synchronized (this) {
                        this.f35143i = false;
                        ListenerCallQueue.f35137b.log(Level.SEVERE, "Exception while running callbacks for " + this.f35139d + " on " + this.f35140e, (Throwable) e16);
                        throw e16;
                    }
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
        
            r2.call(r9.f35139d);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
        
            com.google.common.util.concurrent.ListenerCallQueue.f35137b.log(java.util.logging.Level.SEVERE, "Exception while executing callback: " + r9.f35139d + " " + r3, (java.lang.Throwable) r2);
         */
        /* JADX WARN: Removed duplicated region for block: B:35:0x005e  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z16;
            Throwable th5;
            while (true) {
                boolean z17 = true;
                try {
                    synchronized (this) {
                        try {
                            com.google.common.base.j.s(this.f35143i);
                            a<L> poll = this.f35141f.poll();
                            Object poll2 = this.f35142h.poll();
                            if (poll == null) {
                                this.f35143i = false;
                                try {
                                    return;
                                } catch (Throwable th6) {
                                    th5 = th6;
                                    z16 = false;
                                    while (true) {
                                        try {
                                            break;
                                        } catch (Throwable th7) {
                                            th5 = th7;
                                        }
                                    }
                                    throw th5;
                                }
                            }
                        } catch (Throwable th8) {
                            z16 = true;
                            th5 = th8;
                        }
                    }
                } catch (Throwable th9) {
                    th = th9;
                    if (z17) {
                    }
                    throw th;
                }
                try {
                    break;
                    throw th5;
                } catch (Throwable th10) {
                    boolean z18 = z16;
                    th = th10;
                    z17 = z18;
                    if (z17) {
                        synchronized (this) {
                            this.f35143i = false;
                        }
                    }
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface a<L> {
        void call(L l3);
    }

    private void d(a<L> aVar, Object obj) {
        com.google.common.base.j.n(aVar, "event");
        com.google.common.base.j.n(obj, "label");
        synchronized (this.f35138a) {
            Iterator<PerListenerQueue<L>> it = this.f35138a.iterator();
            while (it.hasNext()) {
                it.next().a(aVar, obj);
            }
        }
    }

    public void b() {
        for (int i3 = 0; i3 < this.f35138a.size(); i3++) {
            this.f35138a.get(i3).e();
        }
    }

    public void c(a<L> aVar) {
        d(aVar, aVar);
    }
}
