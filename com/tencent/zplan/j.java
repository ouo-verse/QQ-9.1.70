package com.tencent.zplan;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\"\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/zplan/j;", "", "Lkotlin/Function0;", "", "runnable", "b", "", "a", "J", "()J", "c", "(J)V", "costTime", "<init>", "()V", "mp4_encoder_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes38.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long costTime;

    /* renamed from: a, reason: from getter */
    public final long getCostTime() {
        return this.costTime;
    }

    public final void b(Function0<Unit> runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        long nanoTime = System.nanoTime();
        runnable.invoke();
        this.costTime += System.nanoTime() - nanoTime;
    }

    public final void c(long j3) {
        this.costTime = j3;
    }
}
