package com.tencent.thread.monitor.plugin.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\n\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00110\n\u00a2\u0006\u0002\u0010\u0012J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\u0015\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u00c6\u0003J\u0015\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\nH\u00c6\u0003J\u0015\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00110\nH\u00c6\u0003J\u0087\u0001\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\n2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00110\nH\u00c6\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010+\u001a\u00020\u0003H\u00d6\u0001J\t\u0010,\u001a\u00020\u000eH\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00110\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014\u00a8\u0006-"}, d2 = {"Lcom/tencent/thread/monitor/plugin/api/ReportResult;", "", "allThreadSize", "", "allActiveThreadSize", "recordThreadSize", "recordPoolSize", "resultThreadSize", "resultPoolSize", "resultThreadInfo", "", "", "Lcom/tencent/thread/monitor/plugin/api/IThreadInfo;", "resultPoolInfo", "", "Lcom/tencent/thread/monitor/plugin/api/IThreadPoolInfo;", "allThreadInfo", "Lcom/tencent/thread/monitor/plugin/api/DumpThreadInfo;", "(IIIIIILjava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getAllActiveThreadSize", "()I", "getAllThreadInfo", "()Ljava/util/Map;", "getAllThreadSize", "getRecordPoolSize", "getRecordThreadSize", "getResultPoolInfo", "getResultPoolSize", "getResultThreadInfo", "getResultThreadSize", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "plugincode_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final /* data */ class ReportResult {
    static IPatchRedirector $redirector_;
    private final int allActiveThreadSize;

    @NotNull
    private final Map<Long, DumpThreadInfo> allThreadInfo;
    private final int allThreadSize;
    private final int recordPoolSize;
    private final int recordThreadSize;

    @NotNull
    private final Map<String, IThreadPoolInfo> resultPoolInfo;
    private final int resultPoolSize;

    @NotNull
    private final Map<Long, IThreadInfo> resultThreadInfo;
    private final int resultThreadSize;

    public ReportResult(int i3, int i16, int i17, int i18, int i19, int i26, @NotNull Map<Long, ? extends IThreadInfo> resultThreadInfo, @NotNull Map<String, ? extends IThreadPoolInfo> resultPoolInfo, @NotNull Map<Long, DumpThreadInfo> allThreadInfo) {
        Intrinsics.checkNotNullParameter(resultThreadInfo, "resultThreadInfo");
        Intrinsics.checkNotNullParameter(resultPoolInfo, "resultPoolInfo");
        Intrinsics.checkNotNullParameter(allThreadInfo, "allThreadInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), resultThreadInfo, resultPoolInfo, allThreadInfo);
            return;
        }
        this.allThreadSize = i3;
        this.allActiveThreadSize = i16;
        this.recordThreadSize = i17;
        this.recordPoolSize = i18;
        this.resultThreadSize = i19;
        this.resultPoolSize = i26;
        this.resultThreadInfo = resultThreadInfo;
        this.resultPoolInfo = resultPoolInfo;
        this.allThreadInfo = allThreadInfo;
    }

    public static /* synthetic */ ReportResult copy$default(ReportResult reportResult, int i3, int i16, int i17, int i18, int i19, int i26, Map map, Map map2, Map map3, int i27, Object obj) {
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        Map map4;
        Map map5;
        Map map6;
        if ((i27 & 1) != 0) {
            i28 = reportResult.allThreadSize;
        } else {
            i28 = i3;
        }
        if ((i27 & 2) != 0) {
            i29 = reportResult.allActiveThreadSize;
        } else {
            i29 = i16;
        }
        if ((i27 & 4) != 0) {
            i36 = reportResult.recordThreadSize;
        } else {
            i36 = i17;
        }
        if ((i27 & 8) != 0) {
            i37 = reportResult.recordPoolSize;
        } else {
            i37 = i18;
        }
        if ((i27 & 16) != 0) {
            i38 = reportResult.resultThreadSize;
        } else {
            i38 = i19;
        }
        if ((i27 & 32) != 0) {
            i39 = reportResult.resultPoolSize;
        } else {
            i39 = i26;
        }
        if ((i27 & 64) != 0) {
            map4 = reportResult.resultThreadInfo;
        } else {
            map4 = map;
        }
        if ((i27 & 128) != 0) {
            map5 = reportResult.resultPoolInfo;
        } else {
            map5 = map2;
        }
        if ((i27 & 256) != 0) {
            map6 = reportResult.allThreadInfo;
        } else {
            map6 = map3;
        }
        return reportResult.copy(i28, i29, i36, i37, i38, i39, map4, map5, map6);
    }

    public final int component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.allThreadSize;
    }

    public final int component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.allActiveThreadSize;
    }

    public final int component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.recordThreadSize;
    }

    public final int component4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.recordPoolSize;
    }

    public final int component5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.resultThreadSize;
    }

    public final int component6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.resultPoolSize;
    }

    @NotNull
    public final Map<Long, IThreadInfo> component7() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Map) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.resultThreadInfo;
    }

    @NotNull
    public final Map<String, IThreadPoolInfo> component8() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Map) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.resultPoolInfo;
    }

    @NotNull
    public final Map<Long, DumpThreadInfo> component9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Map) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.allThreadInfo;
    }

    @NotNull
    public final ReportResult copy(int allThreadSize, int allActiveThreadSize, int recordThreadSize, int recordPoolSize, int resultThreadSize, int resultPoolSize, @NotNull Map<Long, ? extends IThreadInfo> resultThreadInfo, @NotNull Map<String, ? extends IThreadPoolInfo> resultPoolInfo, @NotNull Map<Long, DumpThreadInfo> allThreadInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (ReportResult) iPatchRedirector.redirect((short) 20, this, Integer.valueOf(allThreadSize), Integer.valueOf(allActiveThreadSize), Integer.valueOf(recordThreadSize), Integer.valueOf(recordPoolSize), Integer.valueOf(resultThreadSize), Integer.valueOf(resultPoolSize), resultThreadInfo, resultPoolInfo, allThreadInfo);
        }
        Intrinsics.checkNotNullParameter(resultThreadInfo, "resultThreadInfo");
        Intrinsics.checkNotNullParameter(resultPoolInfo, "resultPoolInfo");
        Intrinsics.checkNotNullParameter(allThreadInfo, "allThreadInfo");
        return new ReportResult(allThreadSize, allActiveThreadSize, recordThreadSize, recordPoolSize, resultThreadSize, resultPoolSize, resultThreadInfo, resultPoolInfo, allThreadInfo);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, other)).booleanValue();
        }
        if (this != other) {
            if (other instanceof ReportResult) {
                ReportResult reportResult = (ReportResult) other;
                if (this.allThreadSize != reportResult.allThreadSize || this.allActiveThreadSize != reportResult.allActiveThreadSize || this.recordThreadSize != reportResult.recordThreadSize || this.recordPoolSize != reportResult.recordPoolSize || this.resultThreadSize != reportResult.resultThreadSize || this.resultPoolSize != reportResult.resultPoolSize || !Intrinsics.areEqual(this.resultThreadInfo, reportResult.resultThreadInfo) || !Intrinsics.areEqual(this.resultPoolInfo, reportResult.resultPoolInfo) || !Intrinsics.areEqual(this.allThreadInfo, reportResult.allThreadInfo)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int getAllActiveThreadSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.allActiveThreadSize;
    }

    @NotNull
    public final Map<Long, DumpThreadInfo> getAllThreadInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Map) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.allThreadInfo;
    }

    public final int getAllThreadSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return this.allThreadSize;
    }

    public final int getRecordPoolSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.recordPoolSize;
    }

    public final int getRecordThreadSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.recordThreadSize;
    }

    @NotNull
    public final Map<String, IThreadPoolInfo> getResultPoolInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Map) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.resultPoolInfo;
    }

    public final int getResultPoolSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.resultPoolSize;
    }

    @NotNull
    public final Map<Long, IThreadInfo> getResultThreadInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Map) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.resultThreadInfo;
    }

    public final int getResultThreadSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.resultThreadSize;
    }

    public int hashCode() {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        int i17 = ((((((((((this.allThreadSize * 31) + this.allActiveThreadSize) * 31) + this.recordThreadSize) * 31) + this.recordPoolSize) * 31) + this.resultThreadSize) * 31) + this.resultPoolSize) * 31;
        Map<Long, IThreadInfo> map = this.resultThreadInfo;
        int i18 = 0;
        if (map != null) {
            i3 = map.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = (i17 + i3) * 31;
        Map<String, IThreadPoolInfo> map2 = this.resultPoolInfo;
        if (map2 != null) {
            i16 = map2.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        Map<Long, DumpThreadInfo> map3 = this.allThreadInfo;
        if (map3 != null) {
            i18 = map3.hashCode();
        }
        return i26 + i18;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return "ReportResult(allThreadSize=" + this.allThreadSize + ", allActiveThreadSize=" + this.allActiveThreadSize + ", recordThreadSize=" + this.recordThreadSize + ", recordPoolSize=" + this.recordPoolSize + ", resultThreadSize=" + this.resultThreadSize + ", resultPoolSize=" + this.resultPoolSize + ", resultThreadInfo=" + this.resultThreadInfo + ", resultPoolInfo=" + this.resultPoolInfo + ", allThreadInfo=" + this.allThreadInfo + ")";
    }
}
