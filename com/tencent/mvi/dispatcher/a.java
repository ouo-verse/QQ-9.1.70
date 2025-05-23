package com.tencent.mvi.dispatcher;

import com.tencent.raft.codegenmeta.utils.Constants;
import java.util.List;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u0014\u0010\n\u001a\u00020\u00078&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mvi/dispatcher/a;", "", "", "Lcom/tencent/mvi/dispatcher/AIOTask;", Constants.Raft.TASKS, "", "a", "Ljava/util/concurrent/ExecutorService;", "b", "()Ljava/util/concurrent/ExecutorService;", "subExecutor", "mvi_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public interface a {
    void a(@NotNull List<? extends AIOTask> tasks);

    @NotNull
    ExecutorService b();
}
