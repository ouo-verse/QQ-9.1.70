package com.sina.weibo.sdk.b;

import com.sina.weibo.sdk.b.c;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class b {
    private com.sina.weibo.sdk.b.a P;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {
        private static b Q = new b(0);
    }

    /* synthetic */ b(byte b16) {
        this();
    }

    public final void a(c cVar) {
        ThreadPoolExecutor threadPoolExecutor = this.P.N;
        if (cVar.R != c.b.f61230aa) {
            int i3 = c.AnonymousClass4.X[cVar.R - 1];
            if (i3 != 1) {
                if (i3 == 2) {
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                }
            } else {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            }
        }
        cVar.R = c.b.f61231ab;
        c.d<Params, Result> dVar = cVar.S;
        dVar.f61234ae = cVar.V;
        dVar.priority = cVar.U;
        threadPoolExecutor.execute(cVar.T);
    }

    b() {
        this.P = null;
        this.P = new com.sina.weibo.sdk.b.a();
    }
}
