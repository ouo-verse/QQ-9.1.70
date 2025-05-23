package com.tencent.mobileqq.tritonaudio;

import android.os.Process;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/tritonaudio/TF;", "Ljava/util/concurrent/ThreadFactory;", "name", "", "priority", "", "(Ljava/lang/String;I)V", "id", "Ljava/util/concurrent/atomic/AtomicInteger;", "newThread", "Ljava/lang/Thread;", "runnable", "Ljava/lang/Runnable;", "TritonAudio_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
final class TF implements ThreadFactory {
    private final AtomicInteger id;
    private final String name;
    private final int priority;

    public TF(@NotNull String name, int i3) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        this.name = name;
        this.priority = i3;
        this.id = new AtomicInteger();
    }

    @Override // java.util.concurrent.ThreadFactory
    @NotNull
    public Thread newThread(@NotNull final Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        return new BaseThread(new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.TF$newThread$1
            @Override // java.lang.Runnable
            public final void run() {
                int i3;
                i3 = TF.this.priority;
                Process.setThreadPriority(i3);
                runnable.run();
            }
        }, this.name + '-' + this.id.getAndIncrement());
    }
}
