package com.tencent.hippykotlin.demo.pages.nearby.base.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AsyncTaskTracker<T> {
    public boolean isDone;
    public T result;
    public List<Function1<T, Unit>> waitingCbs = new ArrayList();

    @Deprecated(message = "use markDoneAndClearCbs(result: T?) instead")
    public final void markDone(T t16) {
        this.isDone = true;
        this.result = t16;
        Iterator it = this.waitingCbs.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(t16);
        }
    }

    public final void markDoneAndClearCbs(T t16) {
        this.isDone = true;
        this.result = t16;
        Iterator it = this.waitingCbs.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(t16);
        }
        this.waitingCbs.clear();
    }

    public final void reset(boolean z16) {
        this.isDone = false;
        this.result = null;
        if (z16) {
            this.waitingCbs.clear();
        }
    }

    public final void executeOnDone(boolean z16, Function1<? super T, Unit> function1) {
        if (z16) {
            this.waitingCbs.clear();
        }
        if (this.isDone) {
            function1.invoke(this.result);
        } else {
            this.waitingCbs.add(function1);
        }
    }
}
