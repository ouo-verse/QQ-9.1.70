package com.tencent.mobileqq.app;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b2\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J6\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020\u00042\u0006\u0010c\u001a\u00020\u00042\u0006\u0010d\u001a\u00020\u001c2\u0006\u0010e\u001a\u00020\u001c2\u0006\u0010f\u001a\u00020\u0004J\u0006\u0010g\u001a\u00020hJ\u0006\u0010i\u001a\u00020hJ\u001e\u0010j\u001a\u00020h2\u0006\u0010k\u001a\u00020\u00042\u0006\u0010l\u001a\u00020\u001c2\u0006\u0010m\u001a\u00020\u001cR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001a\u0010'\u001a\u00020(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001a\u00100\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001e\"\u0004\b2\u0010 R\u001a\u00103\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u001a\u00106\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001e\"\u0004\b8\u0010 R\u001a\u00109\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\u001a\u0010<\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001e\"\u0004\b>\u0010 R\u001a\u0010?\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR\u001a\u0010B\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001e\"\u0004\bD\u0010 R\u001a\u0010E\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR\u001a\u0010H\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u001e\"\u0004\bJ\u0010 R\u001a\u0010K\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0006\"\u0004\bM\u0010\bR\u001a\u0010N\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u001e\"\u0004\bP\u0010 R\u001a\u0010Q\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u001e\"\u0004\bS\u0010 R\u001a\u0010T\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u001e\"\u0004\bV\u0010 R\u001a\u0010W\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u001e\"\u0004\bY\u0010 R\u0017\u0010Z\u001a\b\u0012\u0004\u0012\u00020\\0[\u00a2\u0006\b\n\u0000\u001a\u0004\b]\u0010^\u00a8\u0006n"}, d2 = {"Lcom/tencent/mobileqq/app/ThreadMonitor;", "", "()V", "activeDBPoolCount", "", "getActiveDBPoolCount", "()I", "setActiveDBPoolCount", "(I)V", "activeFilePoolCount", "getActiveFilePoolCount", "setActiveFilePoolCount", "activeNetPoolCount", "getActiveNetPoolCount", "setActiveNetPoolCount", "activeNormalPoolCount", "getActiveNormalPoolCount", "setActiveNormalPoolCount", "activeThreadCount", "getActiveThreadCount", "setActiveThreadCount", "allThreadCount", "getAllThreadCount", "setAllThreadCount", "dbPoolCount", "getDbPoolCount", "setDbPoolCount", "dbTaskCostTime", "", "getDbTaskCostTime", "()J", "setDbTaskCostTime", "(J)V", "dbTaskCount", "getDbTaskCount", "setDbTaskCount", "dbTaskWaitTime", "getDbTaskWaitTime", "setDbTaskWaitTime", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "filePoolCount", "getFilePoolCount", "setFilePoolCount", "fileTaskCostTime", "getFileTaskCostTime", "setFileTaskCostTime", "fileTaskCount", "getFileTaskCount", "setFileTaskCount", "fileTaskWaitTime", "getFileTaskWaitTime", "setFileTaskWaitTime", "netPoolCount", "getNetPoolCount", "setNetPoolCount", "netTaskCostTime", "getNetTaskCostTime", "setNetTaskCostTime", "netTaskCount", "getNetTaskCount", "setNetTaskCount", "netTaskWaitTime", "getNetTaskWaitTime", "setNetTaskWaitTime", "normalPoolCount", "getNormalPoolCount", "setNormalPoolCount", "normalTaskCostTime", "getNormalTaskCostTime", "setNormalTaskCostTime", "normalTaskCount", "getNormalTaskCount", "setNormalTaskCount", "normalTaskWaitTime", "getNormalTaskWaitTime", "setNormalTaskWaitTime", "subTaskCostTime", "getSubTaskCostTime", "setSubTaskCostTime", "subTaskCount", "getSubTaskCount", "setSubTaskCount", "subTaskWaitTime", "getSubTaskWaitTime", "setSubTaskWaitTime", "threadDatas", "", "Lcom/tencent/mobileqq/app/ThreadData;", "getThreadDatas", "()Ljava/util/List;", "getPoolReportData", "", "type", "poolCount", "activePoolCount", HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, "costTime", "count", "getThreadCount", "", "taskDataClean", "upDataTask", "poolNum", "wait", QCircleWeakNetReporter.KEY_COST, "mqq_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class ThreadMonitor {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final ThreadMonitor INSTANCE;
    private static int activeDBPoolCount;
    private static int activeFilePoolCount;
    private static int activeNetPoolCount;
    private static int activeNormalPoolCount;
    private static int activeThreadCount;
    private static int allThreadCount;
    private static int dbPoolCount;
    private static long dbTaskCostTime;
    private static int dbTaskCount;
    private static long dbTaskWaitTime;
    private static boolean enable;
    private static int filePoolCount;
    private static long fileTaskCostTime;
    private static int fileTaskCount;
    private static long fileTaskWaitTime;
    private static int netPoolCount;
    private static long netTaskCostTime;
    private static int netTaskCount;
    private static long netTaskWaitTime;
    private static int normalPoolCount;
    private static long normalTaskCostTime;
    private static int normalTaskCount;
    private static long normalTaskWaitTime;
    private static long subTaskCostTime;
    private static long subTaskCount;
    private static long subTaskWaitTime;

    @NotNull
    private static final List<ThreadData> threadDatas;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39896);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 59)) {
            redirector.redirect((short) 59);
        } else {
            INSTANCE = new ThreadMonitor();
            threadDatas = new ArrayList();
        }
    }

    ThreadMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final int getActiveDBPoolCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        return activeDBPoolCount;
    }

    public final int getActiveFilePoolCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return activeFilePoolCount;
    }

    public final int getActiveNetPoolCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this)).intValue();
        }
        return activeNetPoolCount;
    }

    public final int getActiveNormalPoolCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return activeNormalPoolCount;
    }

    public final int getActiveThreadCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return activeThreadCount;
    }

    public final int getAllThreadCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return allThreadCount;
    }

    public final int getDbPoolCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return dbPoolCount;
    }

    public final long getDbTaskCostTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Long) iPatchRedirector.redirect((short) 44, (Object) this)).longValue();
        }
        return dbTaskCostTime;
    }

    public final int getDbTaskCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Integer) iPatchRedirector.redirect((short) 46, (Object) this)).intValue();
        }
        return dbTaskCount;
    }

    public final long getDbTaskWaitTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Long) iPatchRedirector.redirect((short) 42, (Object) this)).longValue();
        }
        return dbTaskWaitTime;
    }

    public final boolean getEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return enable;
    }

    public final int getFilePoolCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return filePoolCount;
    }

    public final long getFileTaskCostTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Long) iPatchRedirector.redirect((short) 38, (Object) this)).longValue();
        }
        return fileTaskCostTime;
    }

    public final int getFileTaskCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Integer) iPatchRedirector.redirect((short) 40, (Object) this)).intValue();
        }
        return fileTaskCount;
    }

    public final long getFileTaskWaitTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Long) iPatchRedirector.redirect((short) 36, (Object) this)).longValue();
        }
        return fileTaskWaitTime;
    }

    public final int getNetPoolCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        return netPoolCount;
    }

    public final long getNetTaskCostTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Long) iPatchRedirector.redirect((short) 32, (Object) this)).longValue();
        }
        return netTaskCostTime;
    }

    public final int getNetTaskCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, (Object) this)).intValue();
        }
        return netTaskCount;
    }

    public final long getNetTaskWaitTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Long) iPatchRedirector.redirect((short) 30, (Object) this)).longValue();
        }
        return netTaskWaitTime;
    }

    public final int getNormalPoolCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return normalPoolCount;
    }

    public final long getNormalTaskCostTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Long) iPatchRedirector.redirect((short) 50, (Object) this)).longValue();
        }
        return normalTaskCostTime;
    }

    public final int getNormalTaskCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Integer) iPatchRedirector.redirect((short) 52, (Object) this)).intValue();
        }
        return normalTaskCount;
    }

    public final long getNormalTaskWaitTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Long) iPatchRedirector.redirect((short) 48, (Object) this)).longValue();
        }
        return normalTaskWaitTime;
    }

    @NotNull
    public final String getPoolReportData(@NotNull String type, int poolCount, int activePoolCount, long waitTime, long costTime, int count) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return (String) iPatchRedirector.redirect((short) 58, this, type, Integer.valueOf(poolCount), Integer.valueOf(activePoolCount), Long.valueOf(waitTime), Long.valueOf(costTime), Integer.valueOf(count));
        }
        Intrinsics.checkNotNullParameter(type, "type");
        String str3 = "-";
        if (count <= 0) {
            str = "-";
        } else {
            str = String.valueOf((waitTime + costTime) / count);
        }
        if (count <= 0) {
            str2 = "-";
        } else {
            str2 = String.valueOf(waitTime / count);
        }
        if (count > 0) {
            str3 = String.valueOf(costTime / count);
        }
        return type + util.base64_pad_url + poolCount + util.base64_pad_url + activePoolCount + util.base64_pad_url + str + util.base64_pad_url + str2 + util.base64_pad_url + str3;
    }

    public final long getSubTaskCostTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return subTaskCostTime;
    }

    public final long getSubTaskCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        return subTaskCount;
    }

    public final long getSubTaskWaitTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        return subTaskWaitTime;
    }

    public final void getThreadCount() {
        boolean z16;
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        boolean contains$default4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this);
            return;
        }
        threadDatas.clear();
        allThreadCount = 0;
        activeThreadCount = 0;
        normalPoolCount = 0;
        activeNormalPoolCount = 0;
        filePoolCount = 0;
        activeFilePoolCount = 0;
        dbPoolCount = 0;
        activeDBPoolCount = 0;
        netPoolCount = 0;
        activeNetPoolCount = 0;
        Map<Thread, StackTraceElement[]> allThreads = Thread.getAllStackTraces();
        Intrinsics.checkNotNullExpressionValue(allThreads, "allThreads");
        Iterator<Map.Entry<Thread, StackTraceElement[]>> it = allThreads.entrySet().iterator();
        while (it.hasNext()) {
            Thread key = it.next().getKey();
            List<ThreadData> list = threadDatas;
            String name = key.getName();
            Intrinsics.checkNotNullExpressionValue(name, "key.name");
            Thread.State state = key.getState();
            Intrinsics.checkNotNullExpressionValue(state, "key.state");
            list.add(new ThreadData(name, state));
            allThreadCount++;
            if (key.getState() == Thread.State.RUNNABLE) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                activeThreadCount++;
            }
            String name2 = key.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "key.name");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) name2, (CharSequence) ThreadNormalPool.TAG, false, 2, (Object) null);
            if (contains$default) {
                normalPoolCount++;
                if (z16) {
                    activeNormalPoolCount++;
                }
            } else {
                String name3 = key.getName();
                Intrinsics.checkNotNullExpressionValue(name3, "key.name");
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) name3, (CharSequence) ThreadFilePool.TAG, false, 2, (Object) null);
                if (contains$default2) {
                    filePoolCount++;
                    if (z16) {
                        activeFilePoolCount++;
                    }
                } else {
                    String name4 = key.getName();
                    Intrinsics.checkNotNullExpressionValue(name4, "key.name");
                    contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) name4, (CharSequence) ThreadDBPool.TAG, false, 2, (Object) null);
                    if (contains$default3) {
                        dbPoolCount++;
                        if (z16) {
                            activeDBPoolCount++;
                        }
                    } else {
                        String name5 = key.getName();
                        Intrinsics.checkNotNullExpressionValue(name5, "key.name");
                        contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) name5, (CharSequence) ThreadNetWorkPool.TAG, false, 2, (Object) null);
                        if (contains$default4) {
                            netPoolCount++;
                            if (z16) {
                                activeNetPoolCount++;
                            }
                        }
                    }
                }
            }
        }
    }

    @NotNull
    public final List<ThreadData> getThreadDatas() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return (List) iPatchRedirector.redirect((short) 54, (Object) this);
        }
        return threadDatas;
    }

    public final void setActiveDBPoolCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
        } else {
            activeDBPoolCount = i3;
        }
    }

    public final void setActiveFilePoolCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            activeFilePoolCount = i3;
        }
    }

    public final void setActiveNetPoolCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
        } else {
            activeNetPoolCount = i3;
        }
    }

    public final void setActiveNormalPoolCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        } else {
            activeNormalPoolCount = i3;
        }
    }

    public final void setActiveThreadCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            activeThreadCount = i3;
        }
    }

    public final void setAllThreadCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            allThreadCount = i3;
        }
    }

    public final void setDbPoolCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
        } else {
            dbPoolCount = i3;
        }
    }

    public final void setDbTaskCostTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, j3);
        } else {
            dbTaskCostTime = j3;
        }
    }

    public final void setDbTaskCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, i3);
        } else {
            dbTaskCount = i3;
        }
    }

    public final void setDbTaskWaitTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, j3);
        } else {
            dbTaskWaitTime = j3;
        }
    }

    public final void setEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            enable = z16;
        }
    }

    public final void setFilePoolCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            filePoolCount = i3;
        }
    }

    public final void setFileTaskCostTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, j3);
        } else {
            fileTaskCostTime = j3;
        }
    }

    public final void setFileTaskCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, i3);
        } else {
            fileTaskCount = i3;
        }
    }

    public final void setFileTaskWaitTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, j3);
        } else {
            fileTaskWaitTime = j3;
        }
    }

    public final void setNetPoolCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
        } else {
            netPoolCount = i3;
        }
    }

    public final void setNetTaskCostTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, j3);
        } else {
            netTaskCostTime = j3;
        }
    }

    public final void setNetTaskCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, i3);
        } else {
            netTaskCount = i3;
        }
    }

    public final void setNetTaskWaitTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, j3);
        } else {
            netTaskWaitTime = j3;
        }
    }

    public final void setNormalPoolCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            normalPoolCount = i3;
        }
    }

    public final void setNormalTaskCostTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, j3);
        } else {
            normalTaskCostTime = j3;
        }
    }

    public final void setNormalTaskCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, i3);
        } else {
            normalTaskCount = i3;
        }
    }

    public final void setNormalTaskWaitTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, j3);
        } else {
            normalTaskWaitTime = j3;
        }
    }

    public final void setSubTaskCostTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, j3);
        } else {
            subTaskCostTime = j3;
        }
    }

    public final void setSubTaskCount(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, j3);
        } else {
            subTaskCount = j3;
        }
    }

    public final void setSubTaskWaitTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, j3);
        } else {
            subTaskWaitTime = j3;
        }
    }

    public final void taskDataClean() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this);
            return;
        }
        subTaskWaitTime = 0L;
        subTaskCostTime = 0L;
        subTaskCount = 0L;
        netTaskWaitTime = 0L;
        netTaskCostTime = 0L;
        netTaskCount = 0;
        fileTaskWaitTime = 0L;
        fileTaskCostTime = 0L;
        fileTaskCount = 0;
        dbTaskWaitTime = 0L;
        dbTaskCostTime = 0L;
        dbTaskCount = 0;
        normalTaskWaitTime = 0L;
        normalTaskCostTime = 0L;
        normalTaskCount = 0;
    }

    public final void upDataTask(int poolNum, long wait, long cost) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, this, Integer.valueOf(poolNum), Long.valueOf(wait), Long.valueOf(cost));
            return;
        }
        if (!enable) {
            return;
        }
        if (poolNum != 99) {
            switch (poolNum) {
                case 6:
                    normalTaskWaitTime += wait;
                    normalTaskCostTime += cost;
                    normalTaskCount++;
                    return;
                case 7:
                    dbTaskWaitTime += wait;
                    dbTaskCostTime += cost;
                    dbTaskCount++;
                    return;
                case 8:
                    fileTaskWaitTime += wait;
                    fileTaskCostTime += cost;
                    fileTaskCount++;
                    return;
                case 9:
                    netTaskWaitTime += wait;
                    netTaskCostTime += cost;
                    netTaskCount++;
                    return;
                default:
                    return;
            }
        }
        subTaskWaitTime += wait;
        subTaskCostTime += cost;
        subTaskCount++;
    }
}
