package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.c;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes2.dex */
public class CancellationTokenSource {
    private c impl = new c();

    public void cancel() {
        c cVar = this.impl;
        if (!cVar.f36544c) {
            synchronized (cVar.f36543b) {
                cVar.f36544c = true;
                Iterator<Runnable> it = cVar.f36542a.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
            }
        }
    }

    public CancellationToken getToken() {
        return this.impl;
    }
}
