package com.tencent.mobileqq.guild.report;

import com.tencent.sqshow.zootopia.avatar.EngineLoadingScene;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00002\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0000H\u0016J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u001a\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u0010\u0015\u001a\u00020\u00002\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00140\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u0010\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u0010\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0005H\u0016J\u0010\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0010\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u001dH\u0016\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "Ljava/io/Serializable;", "duplicate", "retainKeys", "", "", "([Ljava/lang/String;)Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "getTraceId", "hasReported", "", "report", "setAppChannel", "appChannel", "setEnterFrom", "source", "setEventCode", "eventCode", "setExtra", "key", "value", "", "setExtras", "extraInfo", "", "setParam", "setRealTime", "realTime", "setResultCode", QzoneIPCModule.RESULT_CODE, "", "setResultMsg", "resultMsg", "setStageCode", "stageCode", "setTimeCost", QCircleWeakNetReporter.KEY_COST, "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public interface IPerformanceReportTask extends Serializable {
    @NotNull
    IPerformanceReportTask duplicate(@NotNull String... retainKeys);

    @NotNull
    String getTraceId();

    boolean hasReported();

    @NotNull
    IPerformanceReportTask report();

    @NotNull
    IPerformanceReportTask setAppChannel(@NotNull String appChannel);

    @NotNull
    IPerformanceReportTask setEnterFrom(@NotNull String source);

    @NotNull
    IPerformanceReportTask setEventCode(@NotNull String eventCode);

    @NotNull
    IPerformanceReportTask setExtra(@NotNull String key, @Nullable Object value);

    @NotNull
    IPerformanceReportTask setExtras(@NotNull Map<String, ? extends Object> extraInfo);

    @NotNull
    IPerformanceReportTask setParam(@NotNull String key, @NotNull String value);

    @NotNull
    IPerformanceReportTask setRealTime(boolean realTime);

    @NotNull
    IPerformanceReportTask setResultCode(long resultCode);

    @NotNull
    IPerformanceReportTask setResultMsg(@NotNull String resultMsg);

    @NotNull
    IPerformanceReportTask setStageCode(@NotNull String stageCode);

    @NotNull
    IPerformanceReportTask setTimeCost(long cost);

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class a {
        @NotNull
        public static IPerformanceReportTask a(@NotNull IPerformanceReportTask iPerformanceReportTask, @NotNull String... retainKeys) {
            Intrinsics.checkNotNullParameter(retainKeys, "retainKeys");
            return iPerformanceReportTask;
        }

        @NotNull
        public static String b(@NotNull IPerformanceReportTask iPerformanceReportTask) {
            return EngineLoadingScene.UNDEFINE;
        }

        public static boolean c(@NotNull IPerformanceReportTask iPerformanceReportTask) {
            return false;
        }

        @NotNull
        public static IPerformanceReportTask d(@NotNull IPerformanceReportTask iPerformanceReportTask, @NotNull String appChannel) {
            Intrinsics.checkNotNullParameter(appChannel, "appChannel");
            return iPerformanceReportTask;
        }

        @NotNull
        public static IPerformanceReportTask e(@NotNull IPerformanceReportTask iPerformanceReportTask, @NotNull String source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return iPerformanceReportTask;
        }

        @NotNull
        public static IPerformanceReportTask f(@NotNull IPerformanceReportTask iPerformanceReportTask, @NotNull String eventCode) {
            Intrinsics.checkNotNullParameter(eventCode, "eventCode");
            return iPerformanceReportTask;
        }

        @NotNull
        public static IPerformanceReportTask g(@NotNull IPerformanceReportTask iPerformanceReportTask, @NotNull String key, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(key, "key");
            return iPerformanceReportTask;
        }

        @NotNull
        public static IPerformanceReportTask h(@NotNull IPerformanceReportTask iPerformanceReportTask, @NotNull Map<String, ? extends Object> extraInfo) {
            Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
            return iPerformanceReportTask;
        }

        @NotNull
        public static IPerformanceReportTask i(@NotNull IPerformanceReportTask iPerformanceReportTask, @NotNull String key, @NotNull String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            return iPerformanceReportTask;
        }

        @NotNull
        public static IPerformanceReportTask l(@NotNull IPerformanceReportTask iPerformanceReportTask, @NotNull String resultMsg) {
            Intrinsics.checkNotNullParameter(resultMsg, "resultMsg");
            return iPerformanceReportTask;
        }

        @NotNull
        public static IPerformanceReportTask m(@NotNull IPerformanceReportTask iPerformanceReportTask, @NotNull String stageCode) {
            Intrinsics.checkNotNullParameter(stageCode, "stageCode");
            return iPerformanceReportTask;
        }

        @NotNull
        public static IPerformanceReportTask j(@NotNull IPerformanceReportTask iPerformanceReportTask, boolean z16) {
            return iPerformanceReportTask;
        }

        @NotNull
        public static IPerformanceReportTask k(@NotNull IPerformanceReportTask iPerformanceReportTask, long j3) {
            return iPerformanceReportTask;
        }

        @NotNull
        public static IPerformanceReportTask n(@NotNull IPerformanceReportTask iPerformanceReportTask, long j3) {
            return iPerformanceReportTask;
        }
    }
}
