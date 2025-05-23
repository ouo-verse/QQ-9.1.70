package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0082\bJ\u001a\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0007J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0007R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/VasLogReportProxy;", "", "reportTag", "", "(Ljava/lang/String;)V", "isHit", "", "getReportTag", "()Ljava/lang/String;", "printLog", "", "logString", "report", "logLevel", "Lcom/tencent/mobileqq/vas/VasLogReportProxy$LEVEL;", "reportDebug", "reportHighest", "reportLow", "LEVEL", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasLogReportProxy {

    @JvmField
    public final boolean isHit;

    @NotNull
    private final String reportTag;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/vas/VasLogReportProxy$LEVEL;", "", "(Ljava/lang/String;I)V", "LOW", QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, "HIGH", "HIGHEST", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public enum LEVEL {
        LOW,
        NORMAL,
        HIGH,
        HIGHEST
    }

    public VasLogReportProxy(@NotNull String reportTag) {
        int roundToInt;
        boolean z16;
        Intrinsics.checkNotNullParameter(reportTag, "reportTag");
        this.reportTag = reportTag;
        roundToInt = MathKt__MathJVMKt.roundToInt(Math.floor(1000 * Math.random()));
        if (roundToInt == 500) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isHit = z16;
    }

    private final void printLog(String logString) {
        QLog.i(this.reportTag, 1, logString);
    }

    public static /* synthetic */ void report$default(VasLogReportProxy vasLogReportProxy, String str, LEVEL level, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            level = LEVEL.HIGH;
        }
        vasLogReportProxy.report(str, level);
    }

    @NotNull
    public final String getReportTag() {
        return this.reportTag;
    }

    @JvmOverloads
    public final void report(@NotNull String logString) {
        Intrinsics.checkNotNullParameter(logString, "logString");
        report$default(this, logString, null, 2, null);
    }

    public final void reportDebug(@NotNull String logString) {
        Intrinsics.checkNotNullParameter(logString, "logString");
        if (QLog.isDebugVersion()) {
            QLog.i(this.reportTag, 1, logString);
        }
    }

    @JvmOverloads
    public final void reportHighest(@NotNull String logString) {
        Intrinsics.checkNotNullParameter(logString, "logString");
        report(logString, LEVEL.HIGHEST);
    }

    @JvmOverloads
    public final void reportLow(@NotNull String logString) {
        Intrinsics.checkNotNullParameter(logString, "logString");
        report(logString, LEVEL.LOW);
    }

    @JvmOverloads
    public final void report(@NotNull String logString, @NotNull LEVEL logLevel) {
        Intrinsics.checkNotNullParameter(logString, "logString");
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        QLog.i(this.reportTag, 1, logString);
        if (logLevel == LEVEL.LOW) {
            return;
        }
        if ((logLevel != LEVEL.NORMAL || this.isHit) && logLevel == LEVEL.HIGHEST) {
            com.tencent.mobileqq.vas.unilog.a.f311145a.a("other", logString);
        }
    }
}
