package com.tenpay.sdk.net.core.dispatcher;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tenpay.sdk.net.core.dispatcher.Executor;
import com.tenpay.sdk.net.core.dispatcher.TaskDispatcher;
import com.tenpay.sdk.net.core.log.DLog;
import com.tenpay.sdk.net.core.log.ILogAgent;
import com.tenpay.sdk.net.core.task.NetTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0012J\u0014\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002J\u0014\u0010\u0018\u001a\u00020\u00162\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002J\u0012\u0010\u0019\u001a\u00020\u00122\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u001c\u0010\u001c\u001a\u00020\u00122\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u001d\u001a\u00020\u0016H\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\u0006\u0010\u001f\u001a\u00020\u0006J\u0014\u0010 \u001a\u00020\u00062\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\fj\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002`\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\u000e\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/tenpay/sdk/net/core/dispatcher/TaskDispatcher;", "Lcom/tenpay/sdk/net/core/dispatcher/Executor$IExecuteCallback;", "Lcom/tenpay/sdk/net/core/task/NetTask;", "aliasName", "", "maxRequests", "", "maxRequestsPerHost", "executorService", "Ljava/util/concurrent/ThreadPoolExecutor;", "(Ljava/lang/String;IILjava/util/concurrent/ThreadPoolExecutor;)V", "pendingTasks", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "runningTasks", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tenpay/sdk/net/core/dispatcher/Executor;", "cancel", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "cancelAll", "checkTaskNotExists", "", "task", "checkTaskValid", "enqueue", "newTaskExecutor", "Lcom/tenpay/sdk/net/core/dispatcher/TaskExecutor;", "onExecuteFinish", "removeTask", "promoteAndExecute", "runningCallsCount", "runningTasksForHost", "netTask", "tag", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class TaskDispatcher implements Executor.IExecuteCallback<NetTask<?>> {

    @NotNull
    private final String aliasName;

    @NotNull
    private final ThreadPoolExecutor executorService;
    private int maxRequests;
    private int maxRequestsPerHost;

    @NotNull
    private final ArrayList<NetTask<?>> pendingTasks;

    @NotNull
    private final ConcurrentHashMap<NetTask<?>, Executor<NetTask<?>>> runningTasks;

    public TaskDispatcher(@NotNull String aliasName, int i3, int i16, @NotNull ThreadPoolExecutor executorService) {
        Intrinsics.checkNotNullParameter(aliasName, "aliasName");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        this.aliasName = aliasName;
        this.maxRequests = i3;
        this.maxRequestsPerHost = i16;
        this.executorService = executorService;
        this.pendingTasks = new ArrayList<>();
        this.runningTasks = new ConcurrentHashMap<>();
        ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, tag(), "init dispatcher, max=" + this.maxRequests + ", maxPerHost=" + this.maxRequestsPerHost, null, 4, null);
    }

    private final boolean checkTaskNotExists(NetTask<?> task) {
        synchronized (this) {
            if (this.pendingTasks.contains(task)) {
                return false;
            }
            return !this.runningTasks.containsKey(task);
        }
    }

    private final boolean checkTaskValid(NetTask<?> task) {
        if (task.id().length() > 0) {
            return true;
        }
        return false;
    }

    private final TaskExecutor newTaskExecutor() {
        return new TaskExecutor(this.executorService, this.aliasName, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onExecuteFinish$lambda$14(TaskDispatcher this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.promoteAndExecute();
    }

    private final boolean promoteAndExecute() {
        boolean z16;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        synchronized (this) {
            Iterator<NetTask<?>> it = this.pendingTasks.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "pendingTasks.iterator()");
            while (it.hasNext()) {
                NetTask<?> next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                NetTask<?> netTask = next;
                if (this.runningTasks.size() > this.maxRequests) {
                    break;
                }
                if (runningTasksForHost(netTask) < this.maxRequestsPerHost) {
                    it.remove();
                    TaskExecutor newTaskExecutor = newTaskExecutor();
                    linkedHashMap.put(netTask, newTaskExecutor);
                    this.runningTasks.put(netTask, newTaskExecutor);
                }
            }
            if (this.runningTasks.size() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Unit unit = Unit.INSTANCE;
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            NetTask<?> netTask2 = (NetTask) entry.getKey();
            TaskExecutor taskExecutor = (TaskExecutor) entry.getValue();
            ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, tag(), "execute task [" + netTask2.id() + "]", null, 4, null);
            taskExecutor.execute(netTask2);
        }
        return z16;
    }

    private final int runningTasksForHost(NetTask<?> netTask) {
        Iterator<Map.Entry<NetTask<?>, Executor<NetTask<?>>>> it = this.runningTasks.entrySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (Intrinsics.areEqual(netTask.getHost(), it.next().getKey().getHost())) {
                i3++;
            }
        }
        return i3;
    }

    private final String tag() {
        return "Dispatcher[" + this.aliasName + "]";
    }

    public final void cancel(@NotNull String taskId) {
        Set set;
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        synchronized (this) {
            ArrayList<NetTask<?>> arrayList = this.pendingTasks;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (Intrinsics.areEqual(((NetTask) obj).id(), taskId)) {
                    arrayList2.add(obj);
                }
            }
            if (!arrayList2.isEmpty()) {
                ILogAgent.DefaultImpls.i$default(DLog.INSTANCE, tag(), "cancel pending task [" + taskId + "]", null, 4, null);
                ArrayList<NetTask<?>> arrayList3 = this.pendingTasks;
                set = CollectionsKt___CollectionsKt.toSet(arrayList2);
                arrayList3.removeAll(set);
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((NetTask) it.next()).cancel();
                }
            }
            ConcurrentHashMap<NetTask<?>, Executor<NetTask<?>>> concurrentHashMap = this.runningTasks;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<NetTask<?>, Executor<NetTask<?>>> entry : concurrentHashMap.entrySet()) {
                if (Intrinsics.areEqual(entry.getKey().id(), taskId)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            Iterator it5 = linkedHashMap.keySet().iterator();
            while (it5.hasNext()) {
                ((NetTask) it5.next()).cancel();
            }
        }
    }

    public final void cancelAll() {
        synchronized (this) {
            this.pendingTasks.clear();
            Iterator<Map.Entry<NetTask<?>, Executor<NetTask<?>>>> it = this.runningTasks.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().cancel();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void enqueue(@NotNull NetTask<?> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        ILogAgent.DefaultImpls.i$default(DLog.INSTANCE, tag(), "enqueue task [" + task.id() + "][" + task.getCmd() + "]", null, 4, null);
        if (!checkTaskValid(task) || !checkTaskNotExists(task)) {
            return;
        }
        synchronized (this) {
            this.pendingTasks.add(task);
            CollectionsKt__MutableCollectionsJVMKt.sort(this.pendingTasks);
            Unit unit = Unit.INSTANCE;
        }
        promoteAndExecute();
    }

    public final synchronized int runningCallsCount() {
        return this.runningTasks.size();
    }

    @Override // com.tenpay.sdk.net.core.dispatcher.Executor.IExecuteCallback
    public void onExecuteFinish(@NotNull NetTask<?> task, boolean removeTask) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.runningTasks.remove(task);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: iy4.a
            @Override // java.lang.Runnable
            public final void run() {
                TaskDispatcher.onExecuteFinish$lambda$14(TaskDispatcher.this);
            }
        });
    }

    public /* synthetic */ TaskDispatcher(String str, int i3, int i16, ThreadPoolExecutor threadPoolExecutor, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i17 & 2) != 0 ? 64 : i3, (i17 & 4) != 0 ? 5 : i16, threadPoolExecutor);
    }
}
