package com.tencent.qqnt.aio.util;

import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0014\u0010\u0003\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000\u001a\u001c\u0010\u0006\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0007"}, d2 = {"Lkotlin/Function0;", "", "task", "c", "", "delayMillis", "e", "nt_util_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class d {
    public static final void c(@NotNull final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.util.b
            @Override // java.lang.Runnable
            public final void run() {
                d.d(Function0.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function0 task) {
        Intrinsics.checkNotNullParameter(task, "$task");
        task.invoke();
    }

    public static final void e(@NotNull final Function0<Unit> task, long j3) {
        Intrinsics.checkNotNullParameter(task, "task");
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.qqnt.aio.util.c
            @Override // java.lang.Runnable
            public final void run() {
                d.f(Function0.this);
            }
        }, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function0 task) {
        Intrinsics.checkNotNullParameter(task, "$task");
        task.invoke();
    }
}
