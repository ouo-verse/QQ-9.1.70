package com.google.common.util.concurrent;

import com.google.common.util.concurrent.a;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: P */
/* loaded from: classes2.dex */
class AbstractExecutionThreadService$1$2 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ a.C0247a f35074d;

    @Override // java.lang.Runnable
    public void run() {
        Logger logger;
        try {
            a.this.e();
            this.f35074d.i();
            if (this.f35074d.g()) {
                try {
                    a.this.b();
                } catch (Throwable th5) {
                    try {
                        a.this.d();
                    } catch (Exception e16) {
                        logger = a.f35161b;
                        logger.log(Level.WARNING, "Error while attempting to shut down the service after failure.", (Throwable) e16);
                    }
                    this.f35074d.h(th5);
                    return;
                }
            }
            a.this.d();
            this.f35074d.j();
        } catch (Throwable th6) {
            this.f35074d.h(th6);
        }
    }
}
