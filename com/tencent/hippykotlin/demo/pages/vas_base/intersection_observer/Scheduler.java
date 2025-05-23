package com.tencent.hippykotlin.demo.pages.vas_base.intersection_observer;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class Scheduler<T> {
    public final Set<T> container = new LinkedHashSet();
    public final Set<Function1<Set<T>, Unit>> tasks = new LinkedHashSet();
    public String timer;

    public final void subscribe(Function1<? super Set<T>, Unit> function1) {
        this.tasks.add(function1);
    }
}
