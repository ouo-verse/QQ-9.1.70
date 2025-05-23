package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;
import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001a\u0010'\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\u001a\u0010*\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010!\"\u0004\b,\u0010#R\u001a\u0010-\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\b\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/app/ThreadReportData;", "", "()V", "activePoolThreadCount", "", "getActivePoolThreadCount", "()I", "setActivePoolThreadCount", "(I)V", "activeThreadCount", "getActiveThreadCount", "setActiveThreadCount", "allThreadCount", "getAllThreadCount", "setAllThreadCount", "avgSubCostTime", "", "getAvgSubCostTime", "()J", "setAvgSubCostTime", "(J)V", "avgSubWaitTime", "getAvgSubWaitTime", "setAvgSubWaitTime", "avgTaskPoolCostTime", "getAvgTaskPoolCostTime", "setAvgTaskPoolCostTime", "avgTaskPoolWaitTime", "getAvgTaskPoolWaitTime", "setAvgTaskPoolWaitTime", "dbData", "", "getDbData", "()Ljava/lang/String;", "setDbData", "(Ljava/lang/String;)V", "fileData", "getFileData", "setFileData", "netData", "getNetData", "setNetData", "normalData", "getNormalData", "setNormalData", "poolThreadCount", "getPoolThreadCount", "setPoolThreadCount", "mqq_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class ThreadReportData {
    static IPatchRedirector $redirector_;
    private int activePoolThreadCount;
    private int activeThreadCount;
    private int allThreadCount;
    private long avgSubCostTime;
    private long avgSubWaitTime;
    private long avgTaskPoolCostTime;
    private long avgTaskPoolWaitTime;

    @NotNull
    private String dbData;

    @NotNull
    private String fileData;

    @NotNull
    private String netData;

    @NotNull
    private String normalData;
    private int poolThreadCount;

    public ThreadReportData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.avgSubWaitTime = -1L;
        this.avgSubCostTime = -1L;
        this.avgTaskPoolWaitTime = -1L;
        this.avgTaskPoolCostTime = -1L;
        ThreadMonitor threadMonitor = ThreadMonitor.INSTANCE;
        threadMonitor.getThreadCount();
        this.allThreadCount = threadMonitor.getAllThreadCount();
        this.activeThreadCount = threadMonitor.getActiveThreadCount();
        this.poolThreadCount = threadMonitor.getNormalPoolCount() + threadMonitor.getNetPoolCount() + threadMonitor.getFilePoolCount() + threadMonitor.getDbPoolCount();
        this.activePoolThreadCount = threadMonitor.getActiveNormalPoolCount() + threadMonitor.getActiveNetPoolCount() + threadMonitor.getActiveFilePoolCount() + threadMonitor.getActiveDBPoolCount();
        int normalTaskCount = threadMonitor.getNormalTaskCount() + threadMonitor.getNetTaskCount() + threadMonitor.getFileTaskCount() + threadMonitor.getDbTaskCount();
        if (normalTaskCount > 0) {
            long j3 = normalTaskCount;
            this.avgTaskPoolWaitTime = (((threadMonitor.getNormalTaskWaitTime() + threadMonitor.getNetTaskWaitTime()) + threadMonitor.getFileTaskWaitTime()) + threadMonitor.getDbTaskWaitTime()) / j3;
            this.avgTaskPoolCostTime = (((threadMonitor.getNormalTaskCostTime() + threadMonitor.getNetTaskCostTime()) + threadMonitor.getFileTaskCostTime()) + threadMonitor.getDbTaskCostTime()) / j3;
        }
        if (threadMonitor.getSubTaskCount() > 0) {
            this.avgSubWaitTime = threadMonitor.getSubTaskWaitTime() / threadMonitor.getSubTaskCount();
            this.avgSubCostTime = threadMonitor.getSubTaskCostTime() / threadMonitor.getSubTaskCount();
        }
        this.normalData = threadMonitor.getPoolReportData(QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, threadMonitor.getNormalPoolCount(), threadMonitor.getActiveNormalPoolCount(), threadMonitor.getNormalTaskWaitTime(), threadMonitor.getNormalTaskCostTime(), threadMonitor.getNormalTaskCount());
        this.dbData = threadMonitor.getPoolReportData(QZoneAppCtrlUploadFileLogic.DB_PATH, threadMonitor.getDbPoolCount(), threadMonitor.getActiveDBPoolCount(), threadMonitor.getDbTaskWaitTime(), threadMonitor.getDbTaskCostTime(), threadMonitor.getDbTaskCount());
        this.fileData = threadMonitor.getPoolReportData("FILE", threadMonitor.getFilePoolCount(), threadMonitor.getActiveFilePoolCount(), threadMonitor.getFileTaskWaitTime(), threadMonitor.getFileTaskCostTime(), threadMonitor.getFileTaskCount());
        this.netData = threadMonitor.getPoolReportData("NET", threadMonitor.getNetPoolCount(), threadMonitor.getActiveNetPoolCount(), threadMonitor.getNetTaskWaitTime(), threadMonitor.getNetTaskCostTime(), threadMonitor.getNetTaskCount());
        threadMonitor.taskDataClean();
    }

    public final int getActivePoolThreadCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.activePoolThreadCount;
    }

    public final int getActiveThreadCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.activeThreadCount;
    }

    public final int getAllThreadCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.allThreadCount;
    }

    public final long getAvgSubCostTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        return this.avgSubCostTime;
    }

    public final long getAvgSubWaitTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return this.avgSubWaitTime;
    }

    public final long getAvgTaskPoolCostTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this)).longValue();
        }
        return this.avgTaskPoolCostTime;
    }

    public final long getAvgTaskPoolWaitTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        return this.avgTaskPoolWaitTime;
    }

    @NotNull
    public final String getDbData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.dbData;
    }

    @NotNull
    public final String getFileData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.fileData;
    }

    @NotNull
    public final String getNetData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.netData;
    }

    @NotNull
    public final String getNormalData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.normalData;
    }

    public final int getPoolThreadCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.poolThreadCount;
    }

    public final void setActivePoolThreadCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.activePoolThreadCount = i3;
        }
    }

    public final void setActiveThreadCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.activeThreadCount = i3;
        }
    }

    public final void setAllThreadCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.allThreadCount = i3;
        }
    }

    public final void setAvgSubCostTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, j3);
        } else {
            this.avgSubCostTime = j3;
        }
    }

    public final void setAvgSubWaitTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, j3);
        } else {
            this.avgSubWaitTime = j3;
        }
    }

    public final void setAvgTaskPoolCostTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, j3);
        } else {
            this.avgTaskPoolCostTime = j3;
        }
    }

    public final void setAvgTaskPoolWaitTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, j3);
        } else {
            this.avgTaskPoolWaitTime = j3;
        }
    }

    public final void setDbData(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.dbData = str;
        }
    }

    public final void setFileData(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.fileData = str;
        }
    }

    public final void setNetData(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.netData = str;
        }
    }

    public final void setNormalData(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.normalData = str;
        }
    }

    public final void setPoolThreadCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.poolThreadCount = i3;
        }
    }
}
