package com.tencent.thread.monitor.plugin.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.thread.monitor.plugin.manager.ProxyManager;
import com.tencent.thread.monitor.plugin.manager.ThreadPoolInfo;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThreadHelper;
import com.tencent.thread.monitor.plugin.proxy.async.AsyncTaskHook;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u000205\u0012\u0006\b\u0001\u0012\u00020604J\u0010\u00103\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u000205J\u0006\u00108\u001a\u000209J\u0014\u0010:\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0006\b\u0001\u0012\u00020;04J\u0010\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020+J\u0006\u0010=\u001a\u00020>J\u000e\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020AJ\u000e\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)\u00a8\u0006D"}, d2 = {"Lcom/tencent/thread/monitor/plugin/api/ProxyController;", "", "()V", "debugMode", "", "getDebugMode", "()Z", "setDebugMode", "(Z)V", "enableOptimized", "getEnableOptimized", "setEnableOptimized", NodeProps.ENABLED, "getEnabled", "setEnabled", "iExecutor", "Lcom/tencent/thread/monitor/plugin/api/IExecutor;", "getIExecutor", "()Lcom/tencent/thread/monitor/plugin/api/IExecutor;", "setIExecutor", "(Lcom/tencent/thread/monitor/plugin/api/IExecutor;)V", "iReporter", "Lcom/tencent/thread/monitor/plugin/api/IReporter;", "getIReporter", "()Lcom/tencent/thread/monitor/plugin/api/IReporter;", "setIReporter", "(Lcom/tencent/thread/monitor/plugin/api/IReporter;)V", "logger", "Lcom/tencent/thread/monitor/plugin/api/ILog;", "getLogger", "()Lcom/tencent/thread/monitor/plugin/api/ILog;", "setLogger", "(Lcom/tencent/thread/monitor/plugin/api/ILog;)V", "needRecordStack", "getNeedRecordStack", "setNeedRecordStack", "stackDepth", "", "getStackDepth", "()I", "setStackDepth", "(I)V", "timeThreadWaitTime", "", "getTimeThreadWaitTime", "()J", "setTimeThreadWaitTime", "(J)V", "trimThreadCountOnce", "getTrimThreadCountOnce", "setTrimThreadCountOnce", "getPoolInfo", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/thread/monitor/plugin/api/IThreadPoolInfo;", "poolName", "getReportResult", "Lcom/tencent/thread/monitor/plugin/api/ReportResult;", "getThreadInfo", "Lcom/tencent/thread/monitor/plugin/api/IThreadInfo;", "threadId", "resetAsyncTask", "", "setBaseHandlerThreadListener", "lis", "Lcom/tencent/thread/monitor/plugin/proxy/BaseHandlerThreadHelper$IBaseHandlerThreadListener;", "trimThreads", "fromOOM", "plugincode_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class ProxyController {
    static IPatchRedirector $redirector_;
    public static final ProxyController INSTANCE;
    private static boolean debugMode;
    private static boolean enableOptimized;
    private static boolean enabled;

    @Nullable
    private static IExecutor iExecutor;

    @Nullable
    private static IReporter iReporter;

    @NotNull
    private static ILog logger;
    private static boolean needRecordStack;
    private static int stackDepth;
    private static long timeThreadWaitTime;
    private static int trimThreadCountOnce;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8065);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 30)) {
            redirector.redirect((short) 30);
            return;
        }
        INSTANCE = new ProxyController();
        trimThreadCountOnce = 40;
        timeThreadWaitTime = 100L;
        stackDepth = 20;
        logger = ILogKt.getDefaultLogger();
    }

    ProxyController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
        }
    }

    public final boolean getDebugMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return debugMode;
    }

    public final boolean getEnableOptimized() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return enableOptimized;
    }

    public final boolean getEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
        }
        return enabled;
    }

    @Nullable
    public final IExecutor getIExecutor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (IExecutor) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return iExecutor;
    }

    @Nullable
    public final IReporter getIReporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (IReporter) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return iReporter;
    }

    @NotNull
    public final ILog getLogger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (ILog) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return logger;
    }

    public final boolean getNeedRecordStack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return needRecordStack;
    }

    @NotNull
    public final ConcurrentHashMap<String, ? extends IThreadPoolInfo> getPoolInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) ? ProxyManager.INSTANCE.getPoolNameToInfo() : (ConcurrentHashMap) iPatchRedirector.redirect((short) 23, (Object) this);
    }

    @NotNull
    public final ReportResult getReportResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (ReportResult) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return ProxyManager.INSTANCE.produceAllThreadInfo();
    }

    public final int getStackDepth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return stackDepth;
    }

    @NotNull
    public final ConcurrentHashMap<Long, ? extends IThreadInfo> getThreadInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) ? ProxyManager.INSTANCE.getThreadIdToInfo() : (ConcurrentHashMap) iPatchRedirector.redirect((short) 21, (Object) this);
    }

    public final long getTimeThreadWaitTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, (Object) this)).longValue();
        }
        return timeThreadWaitTime;
    }

    public final int getTrimThreadCountOnce() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return trimThreadCountOnce;
    }

    public final void resetAsyncTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            AsyncTaskHook.INSTANCE.init();
        }
    }

    public final void setBaseHandlerThreadListener(@NotNull BaseHandlerThreadHelper.IBaseHandlerThreadListener lis) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) lis);
        } else {
            Intrinsics.checkNotNullParameter(lis, "lis");
            BaseHandlerThreadHelper.INSTANCE.setListener(lis);
        }
    }

    public final void setDebugMode(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            debugMode = z16;
        }
    }

    public final void setEnableOptimized(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            enableOptimized = z16;
        }
    }

    public final void setEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            enabled = z16;
        }
    }

    public final void setIExecutor(@Nullable IExecutor iExecutor2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) iExecutor2);
        } else {
            iExecutor = iExecutor2;
        }
    }

    public final void setIReporter(@Nullable IReporter iReporter2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) iReporter2);
        } else {
            iReporter = iReporter2;
        }
    }

    public final void setLogger(@NotNull ILog iLog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) iLog);
        } else {
            Intrinsics.checkNotNullParameter(iLog, "<set-?>");
            logger = iLog;
        }
    }

    public final void setNeedRecordStack(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            needRecordStack = z16;
        }
    }

    public final void setStackDepth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else {
            stackDepth = i3;
        }
    }

    public final void setTimeThreadWaitTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, j3);
        } else {
            timeThreadWaitTime = j3;
        }
    }

    public final void setTrimThreadCountOnce(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            trimThreadCountOnce = i3;
        }
    }

    public final int trimThreads(boolean fromOOM) {
        List list;
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        List<Map.Entry> sortedWith;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this, fromOOM)).intValue();
        }
        if (enableOptimized && iExecutor != null && trimThreadCountOnce > 0) {
            logger.i(ProxyManager.TAG, "trimThreads, fromOOM: " + fromOOM);
            int i3 = trimThreadCountOnce;
            Collection<ThreadPoolInfo> values = ProxyManager.INSTANCE.getPoolNameToInfo().values();
            Intrinsics.checkNotNullExpressionValue(values, "ProxyManager.poolNameToInfo.values");
            list = CollectionsKt___CollectionsKt.toList(values);
            List list2 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
            for (Object obj : list2) {
                linkedHashMap.put(obj, Long.valueOf(((ThreadPoolInfo) obj).getLastTaskCompleteTime()));
            }
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(linkedHashMap.entrySet(), new Comparator<T>() { // from class: com.tencent.thread.monitor.plugin.api.ProxyController$trimThreads$$inlined$sortedBy$1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                    }
                }

                @Override // java.util.Comparator
                public final int compare(T t16, T t17) {
                    int compareValues;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        compareValues = ComparisonsKt__ComparisonsKt.compareValues((Long) ((Map.Entry) t16).getValue(), (Long) ((Map.Entry) t17).getValue());
                        return compareValues;
                    }
                    return ((Integer) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
                }
            });
            for (Map.Entry entry : sortedWith) {
                i3 -= ((ThreadPoolInfo) entry.getKey()).getIdleCoreThreadSize();
                ((ThreadPoolInfo) entry.getKey()).trimThread(fromOOM);
                if (i3 <= 0) {
                    return trimThreadCountOnce;
                }
            }
            return trimThreadCountOnce - i3;
        }
        return 0;
    }

    @Nullable
    public final IThreadPoolInfo getPoolInfo(@NotNull String poolName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (IThreadPoolInfo) iPatchRedirector.redirect((short) 24, (Object) this, (Object) poolName);
        }
        Intrinsics.checkNotNullParameter(poolName, "poolName");
        return ProxyManager.getPoolInfo(poolName);
    }

    @Nullable
    public final IThreadInfo getThreadInfo(long threadId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) ? ProxyManager.getThreadInfo(threadId) : (IThreadInfo) iPatchRedirector.redirect((short) 22, (Object) this, threadId);
    }
}
