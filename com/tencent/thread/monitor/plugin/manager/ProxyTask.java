package com.tencent.thread.monitor.plugin.manager;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u001aB\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u00020\u0003H\u0016J\u0011\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003H\u0096\u0002J\u0006\u0010\u0015\u001a\u00020\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0002R\u0014\u0010\b\u001a\u00020\u0007X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/thread/monitor/plugin/manager/ProxyTask;", "Ljava/lang/Runnable;", "Ljava/util/concurrent/Callable;", "", "", "task", "poolName", "", "callStack", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V", "getCallStack$plugincode_debug", "()Ljava/lang/String;", "callThreadId", "", "getCallThreadId$plugincode_debug", "()J", "getPoolName$plugincode_debug", "call", "compareTo", "", "other", "getReal", TencentLocation.RUN_MODE, "", "updateThreadInfo", "Lcom/tencent/thread/monitor/plugin/manager/ThreadInfo;", "Companion", "plugincode_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class ProxyTask implements Runnable, Callable<Object>, Comparable<Object> {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;

    @NotNull
    private final String callStack;
    private final long callThreadId;

    @Nullable
    private final String poolName;
    private final Object task;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007J,\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/thread/monitor/plugin/manager/ProxyTask$Companion;", "", "()V", "proxy", "Lcom/tencent/thread/monitor/plugin/manager/ProxyTask;", "task", "poolName", "", "callStack", "proxyList", "", Constants.Raft.TASKS, "plugincode_debug"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this);
        }

        public static /* synthetic */ ProxyTask proxy$default(Companion companion, Object obj, String str, String str2, int i3, Object obj2) {
            if ((i3 & 4) != 0) {
                str2 = null;
            }
            return companion.proxy(obj, str, str2);
        }

        @NotNull
        public final ProxyTask proxy(@NotNull Object task, @Nullable String poolName, @Nullable String callStack) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (ProxyTask) iPatchRedirector.redirect((short) 1, this, task, poolName, callStack);
            }
            Intrinsics.checkNotNullParameter(task, "task");
            if (task instanceof ProxyTask) {
                return (ProxyTask) task;
            }
            if (callStack == null) {
                callStack = ProxyManager.getStackString$default(false, 1, null);
            }
            return new ProxyTask(task, poolName, callStack);
        }

        @NotNull
        public final Collection<Object> proxyList(@NotNull Collection<Object> tasks, @Nullable String poolName, @NotNull String callStack) {
            boolean z16;
            int collectionSizeOrDefault;
            List mutableList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Collection) iPatchRedirector.redirect((short) 2, this, tasks, poolName, callStack);
            }
            Intrinsics.checkNotNullParameter(tasks, "tasks");
            Intrinsics.checkNotNullParameter(callStack, "callStack");
            try {
                Collection<Object> collection = tasks;
                boolean z17 = false;
                if (!collection.isEmpty()) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (!(next instanceof Runnable) && !(next instanceof Callable)) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            z17 = true;
                            break;
                        }
                    }
                }
                if (!z17) {
                    Collection<Object> collection2 = tasks;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(collection2, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it5 = collection2.iterator();
                    while (it5.hasNext()) {
                        arrayList.add(ProxyTask.INSTANCE.proxy(it5.next(), poolName, callStack));
                    }
                    mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
                    return mutableList;
                }
                return tasks;
            } catch (Throwable unused) {
                return tasks;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8240);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ProxyTask(@NotNull Object task, @Nullable String str, @NotNull String callStack) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(callStack, "callStack");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, task, str, callStack);
            return;
        }
        this.task = task;
        this.poolName = str;
        this.callStack = callStack;
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        this.callThreadId = currentThread.getId();
    }

    private final ThreadInfo updateThreadInfo() {
        Thread thread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(thread, "thread");
        ThreadInfo orPutThreadInfo = ProxyManager.getOrPutThreadInfo(thread.getId());
        orPutThreadInfo.updateFromPoolRun(thread, this);
        return orPutThreadInfo;
    }

    @Override // java.util.concurrent.Callable
    @NotNull
    public Object call() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ThreadInfo updateThreadInfo = updateThreadInfo();
        Object obj = this.task;
        if (obj != null) {
            Object v3 = ((Callable) obj).call();
            updateThreadInfo.setCallStack("");
            updateThreadInfo.setCallThreadId(-1L);
            Intrinsics.checkNotNullExpressionValue(v3, "v");
            return v3;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.concurrent.Callable<*>");
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, other)).intValue();
        }
        Intrinsics.checkNotNullParameter(other, "other");
        Object obj = this.task;
        if ((obj instanceof Comparable) && (other instanceof ProxyTask)) {
            if (obj != null) {
                return ((Comparable) obj).compareTo(((ProxyTask) other).getReal());
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Comparable<kotlin.Any>");
        }
        return 0;
    }

    @NotNull
    public final String getCallStack$plugincode_debug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.callStack;
    }

    public final long getCallThreadId$plugincode_debug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Long) iPatchRedirector.redirect((short) 1, (Object) this)).longValue();
        }
        return this.callThreadId;
    }

    @Nullable
    public final String getPoolName$plugincode_debug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.poolName;
    }

    @NotNull
    public final Object getReal() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.task;
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        ThreadInfo updateThreadInfo = updateThreadInfo();
        Object obj = this.task;
        if (obj != null) {
            ((Runnable) obj).run();
            updateThreadInfo.setCallStack("");
            updateThreadInfo.setCallThreadId(-1L);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Runnable");
    }
}
