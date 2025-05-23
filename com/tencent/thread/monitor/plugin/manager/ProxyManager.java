package com.tencent.thread.monitor.plugin.manager;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.thread.monitor.plugin.api.DumpThreadInfo;
import com.tencent.thread.monitor.plugin.api.HitState;
import com.tencent.thread.monitor.plugin.api.ProxyController;
import com.tencent.thread.monitor.plugin.api.ReportResult;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\u0012\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007J\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0001H\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0007H\u0007J\"\u0010\u001d\u001a\u00020\u001b2\u0012\u0010\u001e\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001f2\u0006\u0010\u0011\u001a\u00020\u0004J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t\u00a8\u0006\""}, d2 = {"Lcom/tencent/thread/monitor/plugin/manager/ProxyManager;", "", "()V", "TAG", "", "poolNameToInfo", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/thread/monitor/plugin/manager/ThreadPoolInfo;", "getPoolNameToInfo", "()Ljava/util/concurrent/ConcurrentHashMap;", "threadIdToInfo", "", "Lcom/tencent/thread/monitor/plugin/manager/ThreadInfo;", "getThreadIdToInfo", "getOrPutThreadInfo", "threadId", "getPoolInfo", "poolName", "getStackString", "deleteProxy", "", "getThreadInfo", "produceAllThreadInfo", "Lcom/tencent/thread/monitor/plugin/api/ReportResult;", "producePoolName", SemanticAttributes.DbCassandraConsistencyLevelValues.ANY, "putPoolInfo", "", "pool", "putPoolTaskList", Constants.Raft.TASKS, "", "Ljava/util/concurrent/Callable;", "removeThreadInfo", "plugincode_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class ProxyManager {
    static IPatchRedirector $redirector_ = null;
    public static final ProxyManager INSTANCE;

    @NotNull
    public static final String TAG = "ThreadProxy_plugin";

    @NotNull
    private static final ConcurrentHashMap<String, ThreadPoolInfo> poolNameToInfo;

    @NotNull
    private static final ConcurrentHashMap<Long, ThreadInfo> threadIdToInfo;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8182);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        INSTANCE = new ProxyManager();
        threadIdToInfo = new ConcurrentHashMap<>();
        poolNameToInfo = new ConcurrentHashMap<>();
    }

    ProxyManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @JvmStatic
    @NotNull
    public static final ThreadInfo getOrPutThreadInfo(long threadId) {
        ThreadInfo putIfAbsent;
        ConcurrentHashMap<Long, ThreadInfo> concurrentHashMap = threadIdToInfo;
        Long valueOf = Long.valueOf(threadId);
        ThreadInfo threadInfo = concurrentHashMap.get(valueOf);
        if (threadInfo == null && (putIfAbsent = concurrentHashMap.putIfAbsent(valueOf, (threadInfo = new ThreadInfo()))) != null) {
            threadInfo = putIfAbsent;
        }
        Intrinsics.checkNotNullExpressionValue(threadInfo, "threadIdToInfo.getOrPut(threadId) { ThreadInfo() }");
        return threadInfo;
    }

    @JvmStatic
    @Nullable
    public static final ThreadPoolInfo getPoolInfo(@NotNull String poolName) {
        Intrinsics.checkNotNullParameter(poolName, "poolName");
        return poolNameToInfo.get(poolName);
    }

    @JvmStatic
    @NotNull
    public static final String getStackString(boolean deleteProxy) {
        boolean contains$default;
        boolean contains$default2;
        String str = "";
        if (!ProxyController.INSTANCE.getNeedRecordStack()) {
            return "";
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int length = stackTrace.length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            StackTraceElement stackTraceElement = stackTrace[i3];
            int i17 = i16 + 1;
            if (i16 >= ProxyController.INSTANCE.getStackDepth()) {
                return str;
            }
            if (deleteProxy && i17 <= 4) {
                String stackTraceElement2 = stackTraceElement.toString();
                Intrinsics.checkNotNullExpressionValue(stackTraceElement2, "stackElement.toString()");
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) stackTraceElement2, (CharSequence) "Proxy", false, 2, (Object) null);
                if (contains$default2) {
                    i3++;
                    i16 = i17;
                }
            }
            String stackTraceElement3 = stackTraceElement.toString();
            Intrinsics.checkNotNullExpressionValue(stackTraceElement3, "stackElement.toString()");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) stackTraceElement3, (CharSequence) "com.tencent.thread.monitor.plugin", false, 2, (Object) null);
            if (!contains$default) {
                str = str + stackTraceElement.toString();
                if (i17 != stackTrace.length) {
                    str = str + "\n";
                }
            }
            i3++;
            i16 = i17;
        }
        return str;
    }

    public static /* synthetic */ String getStackString$default(boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        return getStackString(z16);
    }

    @JvmStatic
    @Nullable
    public static final ThreadInfo getThreadInfo(long threadId) {
        return threadIdToInfo.get(Long.valueOf(threadId));
    }

    @JvmStatic
    @NotNull
    public static final String producePoolName(@NotNull Object any) {
        String str;
        Intrinsics.checkNotNullParameter(any, "any");
        String simpleName = any.getClass().getSimpleName();
        int hashCode = simpleName.hashCode();
        if (hashCode != -60004843) {
            if (hashCode == 2130540810 && simpleName.equals("BaseThreadPoolExecutor")) {
                Class<? super Object> superclass = any.getClass().getSuperclass();
                if (superclass != null) {
                    str = superclass.getName();
                } else {
                    str = "ThreadPoolExecutor";
                }
            }
            str = any.getClass().getName();
        } else {
            if (simpleName.equals("BaseScheduledThreadPoolExecutor")) {
                Class<? super Object> superclass2 = any.getClass().getSuperclass();
                if (superclass2 != null) {
                    str = superclass2.getName();
                } else {
                    str = "ScheduledThreadPoolExecutor";
                }
            }
            str = any.getClass().getName();
        }
        return str + "@" + Integer.toHexString(any.hashCode());
    }

    @JvmStatic
    public static final void putPoolInfo(@NotNull ThreadPoolInfo pool) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        poolNameToInfo.put(pool.getPoolName(), pool);
    }

    @JvmStatic
    public static final void removeThreadInfo(long threadId) {
        threadIdToInfo.remove(Long.valueOf(threadId));
    }

    @NotNull
    public final ConcurrentHashMap<String, ThreadPoolInfo> getPoolNameToInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return poolNameToInfo;
    }

    @NotNull
    public final ConcurrentHashMap<Long, ThreadInfo> getThreadIdToInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return threadIdToInfo;
    }

    @NotNull
    public final ReportResult produceAllThreadInfo() {
        int mapCapacity;
        int mapCapacity2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ReportResult) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        Iterator<Map.Entry<Long, ThreadInfo>> it = threadIdToInfo.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().setHit(HitState.No);
        }
        Iterator<Map.Entry<String, ThreadPoolInfo>> it5 = poolNameToInfo.entrySet().iterator();
        while (it5.hasNext()) {
            it5.next().getValue().getThreadIds().clear();
        }
        int size = threadIdToInfo.size();
        int size2 = poolNameToInfo.size();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        Intrinsics.checkNotNullExpressionValue(allStackTraces, "Thread.getAllStackTraces()");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(allStackTraces.size());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(mapCapacity);
        Iterator<T> it6 = allStackTraces.entrySet().iterator();
        while (it6.hasNext()) {
            Map.Entry entry = (Map.Entry) it6.next();
            Object key = entry.getKey();
            Object key2 = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key2, "it.key");
            Object value = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "it.value");
            linkedHashMap2.put(key, new DumpThreadInfo((Thread) key2, (StackTraceElement[]) value));
        }
        mapCapacity2 = MapsKt__MapsJVMKt.mapCapacity(linkedHashMap2.size());
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(mapCapacity2);
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            Object key3 = entry2.getKey();
            Intrinsics.checkNotNullExpressionValue(key3, "it.key");
            linkedHashMap3.put(Long.valueOf(((Thread) key3).getId()), entry2.getValue());
        }
        for (Map.Entry entry3 : linkedHashMap3.entrySet()) {
            ThreadInfo orPutThreadInfo = getOrPutThreadInfo(((Number) entry3.getKey()).longValue());
            orPutThreadInfo.updateFromRefresh((DumpThreadInfo) entry3.getValue());
            Long valueOf = Long.valueOf(orPutThreadInfo.getId());
            ThreadInfo copy = orPutThreadInfo.copy();
            copy.setRunningStack(ArraysKt.joinToString$default(((DumpThreadInfo) entry3.getValue()).getStack(), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
            Unit unit = Unit.INSTANCE;
            linkedHashMap.put(valueOf, copy);
        }
        Iterator<ThreadInfo> it7 = threadIdToInfo.values().iterator();
        while (it7.hasNext()) {
            ThreadInfo next = it7.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            if (next.getHit() == HitState.No) {
                it7.remove();
            }
        }
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        Iterator<ThreadPoolInfo> it8 = poolNameToInfo.values().iterator();
        while (it8.hasNext()) {
            ThreadPoolInfo next2 = it8.next();
            Intrinsics.checkNotNullExpressionValue(next2, "poolIterator.next()");
            ThreadPoolInfo threadPoolInfo = next2;
            if (threadPoolInfo.getThreadIds().isEmpty() && threadPoolInfo.getShutDown()) {
                it8.remove();
            } else {
                linkedHashMap4.put(threadPoolInfo.getPoolName(), threadPoolInfo.copy());
            }
        }
        return new ReportResult(linkedHashMap3.size(), Thread.activeCount(), size, size2, linkedHashMap.size(), linkedHashMap4.size(), linkedHashMap, linkedHashMap4, linkedHashMap3);
    }

    public final void putPoolTaskList(@NotNull Collection<? extends Callable<?>> tasks, @NotNull String poolName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) tasks, (Object) poolName);
            return;
        }
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        Intrinsics.checkNotNullParameter(poolName, "poolName");
        if (!ProxyController.INSTANCE.getEnabled()) {
            return;
        }
        try {
            ThreadPoolInfo threadPoolInfo = poolNameToInfo.get(poolName);
            if (threadPoolInfo != null) {
                Iterator<T> it = tasks.iterator();
                while (it.hasNext()) {
                    ThreadPoolInfo.putTask$default(threadPoolInfo, (Callable) it.next(), false, 2, null);
                }
            }
        } catch (Exception e16) {
            ProxyController.INSTANCE.getLogger().e(TAG, "putPoolTaskList fail", e16);
        }
    }
}
