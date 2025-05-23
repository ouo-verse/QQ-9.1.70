package com.tencent.kuikly.core.timer;

import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.coroutines.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0002R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/kuikly/core/timer/Timer;", "", "", "g", "", "delay", "period", "Lkotlin/Function0;", "action", "f", "e", "", "a", "Z", "isRunning", "b", "Lkotlin/jvm/functions/Function0;", "c", "I", "d", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class Timer {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isRunning;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> action;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int delay;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int period;

    private final void g() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        BuildersKt.e(e.f117232d, null, null, new Timer$start$1(this, null), 3, null);
    }

    public final void f(int delay, int period, Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.delay = delay;
        this.period = period;
        this.action = action;
        g();
    }

    public final void e() {
        this.isRunning = false;
    }
}
