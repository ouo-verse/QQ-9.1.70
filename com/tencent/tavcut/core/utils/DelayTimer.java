package com.tencent.tavcut.core.utils;

import android.os.Handler;
import android.os.Looper;
import com.tencent.tavcut.core.dataprocessor.RenderDataDispatcher;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0018\u0010\u0018\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0014\u0012\u0004\u0012\u00020\u00150\u0013\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R&\u0010\u0018\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0014\u0012\u0004\u0012\u00020\u00150\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/tavcut/core/utils/DelayTimer;", "", "Ljava/lang/Runnable;", "a", "Ljava/lang/Runnable;", "delayTask", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "handler", "", "Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher$c;", "c", "Ljava/util/List;", "pendingCommands", "", "d", "J", "delayMs", "Lkotlin/Function1;", "", "", "e", "Lkotlin/jvm/functions/Function1;", "task", "<init>", "(JLkotlin/jvm/functions/Function1;)V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class DelayTimer {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Runnable delayTask;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Handler handler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final List<RenderDataDispatcher.c> pendingCommands;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long delayMs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function1<List<? extends RenderDataDispatcher.c>, Unit> task;

    /* JADX WARN: Multi-variable type inference failed */
    public DelayTimer(long j3, @NotNull Function1<? super List<? extends RenderDataDispatcher.c>, Unit> task) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        this.delayMs = j3;
        this.task = task;
        this.delayTask = new Runnable() { // from class: com.tencent.tavcut.core.utils.DelayTimer$delayTask$1
            @Override // java.lang.Runnable
            public final void run() {
                Function1 function1;
                List list;
                List list2;
                List list3;
                function1 = DelayTimer.this.task;
                list = DelayTimer.this.pendingCommands;
                list2 = CollectionsKt___CollectionsKt.toList(list);
                function1.invoke(list2);
                synchronized (DelayTimer.this) {
                    list3 = DelayTimer.this.pendingCommands;
                    list3.clear();
                    Unit unit = Unit.INSTANCE;
                }
            }
        };
        this.handler = new Handler(Looper.getMainLooper());
        this.pendingCommands = new ArrayList();
    }
}
