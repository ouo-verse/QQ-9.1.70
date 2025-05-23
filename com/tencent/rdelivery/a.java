package com.tencent.rdelivery;

import com.tencent.raft.standard.log.IRLog;
import com.tencent.raft.standard.net.IRNetwork;
import com.tencent.raft.standard.storage.IRStorage;
import com.tencent.raft.standard.task.IRTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\u0003\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/rdelivery/a;", "", "Lcom/tencent/raft/standard/net/IRNetwork;", "a", "Lcom/tencent/raft/standard/net/IRNetwork;", "b", "()Lcom/tencent/raft/standard/net/IRNetwork;", "netInterface", "Lcom/tencent/raft/standard/storage/IRStorage$IRStorageFactory;", "Lcom/tencent/raft/standard/storage/IRStorage$IRStorageFactory;", "c", "()Lcom/tencent/raft/standard/storage/IRStorage$IRStorageFactory;", "storageFactory", "Lcom/tencent/raft/standard/task/IRTask;", "Lcom/tencent/raft/standard/task/IRTask;", "d", "()Lcom/tencent/raft/standard/task/IRTask;", "taskInterface", "Lcom/tencent/raft/standard/log/IRLog;", "Lcom/tencent/raft/standard/log/IRLog;", "()Lcom/tencent/raft/standard/log/IRLog;", "logInterface", "<init>", "(Lcom/tencent/raft/standard/net/IRNetwork;Lcom/tencent/raft/standard/storage/IRStorage$IRStorageFactory;Lcom/tencent/raft/standard/task/IRTask;Lcom/tencent/raft/standard/log/IRLog;)V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IRNetwork netInterface;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IRStorage.IRStorageFactory storageFactory;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IRTask taskInterface;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IRLog logInterface;

    public a(@NotNull IRNetwork netInterface, @NotNull IRStorage.IRStorageFactory storageFactory, @NotNull IRTask taskInterface, @NotNull IRLog logInterface) {
        Intrinsics.checkParameterIsNotNull(netInterface, "netInterface");
        Intrinsics.checkParameterIsNotNull(storageFactory, "storageFactory");
        Intrinsics.checkParameterIsNotNull(taskInterface, "taskInterface");
        Intrinsics.checkParameterIsNotNull(logInterface, "logInterface");
        this.netInterface = netInterface;
        this.storageFactory = storageFactory;
        this.taskInterface = taskInterface;
        this.logInterface = logInterface;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final IRLog getLogInterface() {
        return this.logInterface;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final IRNetwork getNetInterface() {
        return this.netInterface;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final IRStorage.IRStorageFactory getStorageFactory() {
        return this.storageFactory;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final IRTask getTaskInterface() {
        return this.taskInterface;
    }
}
