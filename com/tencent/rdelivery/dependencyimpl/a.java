package com.tencent.rdelivery.dependencyimpl;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.raft.standard.task.IRTask;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0016\u0010\u000f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/rdelivery/dependencyimpl/a;", "Lcom/tencent/raft/standard/task/IRTask;", "Lcom/tencent/raft/standard/task/IRTask$TaskType;", "taskType", "Lcom/tencent/raft/standard/task/IRTask$Task;", "task", "", "startTask", "Landroid/os/HandlerThread;", "a", "Landroid/os/HandlerThread;", "ioHandlerThread", "b", "netHandlerThread", "c", "simpleHandlerThread", "Landroid/os/Handler;", "d", "Landroid/os/Handler;", "ioHandler", "e", "netHandler", "f", "simpleHandler", "", "g", "Z", "destroyed", "<init>", "()V", h.F, "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class a implements IRTask {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private HandlerThread ioHandlerThread = new BaseHandlerThread("io_thread");

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private HandlerThread netHandlerThread = new BaseHandlerThread("net_thread");

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private HandlerThread simpleHandlerThread = new BaseHandlerThread("simple_thread");

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Handler ioHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Handler netHandler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Handler simpleHandler;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private volatile boolean destroyed;

    public a() {
        this.ioHandlerThread.start();
        this.netHandlerThread.start();
        this.simpleHandlerThread.start();
        this.ioHandler = new Handler(this.ioHandlerThread.getLooper());
        this.netHandler = new Handler(this.netHandlerThread.getLooper());
        this.simpleHandler = new Handler(this.simpleHandlerThread.getLooper());
    }

    @Override // com.tencent.raft.standard.task.IRTask
    public void startTask(@NotNull IRTask.TaskType taskType, @NotNull IRTask.Task task) {
        Intrinsics.checkParameterIsNotNull(taskType, "taskType");
        Intrinsics.checkParameterIsNotNull(task, "task");
        if (this.destroyed) {
            return;
        }
        int i3 = b.f364233a[taskType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    this.ioHandler.post(task);
                    return;
                }
                return;
            }
            this.netHandler.post(task);
            return;
        }
        this.simpleHandler.post(task);
    }
}
