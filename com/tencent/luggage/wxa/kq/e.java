package com.tencent.luggage.wxa.kq;

import com.tencent.luggage.wxa.jq.h;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends h {
    public final com.tencent.luggage.wxa.kq.a I;
    public a J;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a(com.tencent.luggage.wxa.kq.a aVar, e eVar);

        void a(e eVar);
    }

    public e(Runnable runnable, long j3, String str, boolean z16) {
        super(runnable, j3, z16);
        this.I = com.tencent.luggage.wxa.kq.a.c(str);
    }

    public void a(a aVar) {
        this.J = aVar;
    }

    @Override // com.tencent.luggage.wxa.jq.h, java.util.concurrent.FutureTask, java.util.concurrent.Future
    public boolean cancel(boolean z16) {
        if (super.cancel(z16)) {
            a aVar = this.J;
            if (aVar != null) {
                aVar.a(this);
                return true;
            }
            return true;
        }
        return false;
    }

    public com.tencent.luggage.wxa.kq.a n() {
        return this.I;
    }

    @Override // com.tencent.luggage.wxa.jq.h, java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        try {
            com.tencent.luggage.wxa.kq.a.a(this.I);
            super.run();
        } finally {
            com.tencent.luggage.wxa.kq.a.a((com.tencent.luggage.wxa.kq.a) null);
            a aVar = this.J;
            if (aVar != null) {
                aVar.a(this.I, this);
            }
        }
    }

    public e(Callable callable, long j3, String str, boolean z16) {
        super(callable, j3, z16);
        this.I = com.tencent.luggage.wxa.kq.a.c(str);
    }
}
