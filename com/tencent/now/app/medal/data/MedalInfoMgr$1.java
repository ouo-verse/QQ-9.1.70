package com.tencent.now.app.medal.data;

import com.tencent.component.core.thread.ThreadCenter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
class MedalInfoMgr$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f337987d;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        if (a.b(null)) {
            ThreadCenter.postDelayedUITask(null, this, 20L);
            return;
        }
        if (a.c(null).size() < 20) {
            a.e(null, a.c(null), this.f337987d);
            synchronized (a.a(null)) {
                a.d(null, new ArrayList());
            }
            return;
        }
        List subList = a.c(null).subList(0, 20);
        List subList2 = a.c(null).subList(20, a.c(null).size());
        synchronized (a.a(null)) {
            a.d(null, subList2);
        }
        a.e(null, subList, this.f337987d);
        ThreadCenter.postDelayedUITask(null, this, 20L);
    }
}
