package com.tencent.thread.monitor.plugin.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.manager.ProxyManager;
import com.tencent.thread.monitor.plugin.manager.TaskInfo;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010'\u001a\u00020\u0006H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR*\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\f0!j\b\u0012\u0004\u0012\u00020\f`\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006("}, d2 = {"Lcom/tencent/thread/monitor/plugin/api/IThreadPoolInfo;", "", "executor", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Executor;)V", "createStack", "", "getCreateStack", "()Ljava/lang/String;", "setCreateStack", "(Ljava/lang/String;)V", "createThreadId", "", "getCreateThreadId", "()J", "setCreateThreadId", "(J)V", "poolName", "getPoolName", "setPoolName", "shutDown", "", "getShutDown", "()Z", "setShutDown", "(Z)V", "taskHashCodeToInfo", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/thread/monitor/plugin/manager/TaskInfo;", "getTaskHashCodeToInfo", "()Ljava/util/concurrent/ConcurrentHashMap;", "threadIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getThreadIds", "()Ljava/util/ArrayList;", "setThreadIds", "(Ljava/util/ArrayList;)V", "toString", "plugincode_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public class IThreadPoolInfo {
    static IPatchRedirector $redirector_;

    @NotNull
    private String createStack;
    private long createThreadId;

    @NotNull
    private String poolName;
    private boolean shutDown;

    @NotNull
    private final ConcurrentHashMap<Integer, TaskInfo> taskHashCodeToInfo;

    @NotNull
    private ArrayList<Long> threadIds;

    public IThreadPoolInfo(@Nullable Executor executor) {
        String producePoolName;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) executor);
            return;
        }
        this.poolName = (executor == null || (producePoolName = ProxyManager.producePoolName(executor)) == null) ? "" : producePoolName;
        this.threadIds = new ArrayList<>();
        this.taskHashCodeToInfo = new ConcurrentHashMap<>(100);
        this.createStack = ProxyManager.getStackString$default(false, 1, null);
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        this.createThreadId = currentThread.getId();
    }

    @NotNull
    public final String getCreateStack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.createStack;
    }

    public final long getCreateThreadId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return this.createThreadId;
    }

    @NotNull
    public final String getPoolName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.poolName;
    }

    public final boolean getShutDown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.shutDown;
    }

    @NotNull
    public final ConcurrentHashMap<Integer, TaskInfo> getTaskHashCodeToInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.taskHashCodeToInfo;
    }

    @NotNull
    public final ArrayList<Long> getThreadIds() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.threadIds;
    }

    public final void setCreateStack(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.createStack = str;
        }
    }

    public final void setCreateThreadId(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, j3);
        } else {
            this.createThreadId = j3;
        }
    }

    public final void setPoolName(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.poolName = str;
        }
    }

    public final void setShutDown(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.shutDown = z16;
        }
    }

    public final void setThreadIds(@NotNull ArrayList<Long> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) arrayList);
        } else {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.threadIds = arrayList;
        }
    }

    @NotNull
    public String toString() {
        String joinToString$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            CollectionsKt__MutableCollectionsJVMKt.sort(this.threadIds);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.poolName);
            sb5.append(", ");
            sb5.append(this.createThreadId);
            sb5.append(", threadIds: ");
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.threadIds, null, null, null, 0, null, null, 63, null);
            sb5.append(joinToString$default);
            sb5.append(", ");
            sb5.append("\ncreateStack:\n");
            sb5.append(this.createStack);
            return sb5.toString();
        }
        return (String) iPatchRedirector.redirect((short) 12, (Object) this);
    }
}
