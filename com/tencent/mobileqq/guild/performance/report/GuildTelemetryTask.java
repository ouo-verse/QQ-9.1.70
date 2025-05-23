package com.tencent.mobileqq.guild.performance.report;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/performance/report/GuildTelemetryTask;", "", "taskName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTaskName", "()Ljava/lang/String;", "setTaskName", "(Ljava/lang/String;)V", "UPLOAD_PIC", "DOWNLOAD_PIC", "UPLOAD_VIDEO", "DOWNLOAD_VIDEO", "UPLOAD_FILE", "UPLOADSENDER_FILE", "DOWNLOAD_FILE", "OPEN_CHANNEL_AIO_TIME_COST", "SEND_CHANNEL_MSG", "DIRECT_MSG_C2C_TIME_COST", "YOLO_APP_TIME_COST", "MSG_PUSH_MONITOR_TASKSIZE", "PERF_MONITOR_TRAFFIC", "PERF_MONITOR_FPS", "PERF_MONITOR_MEMORY_CPU", "ERROR_CODE_GPRO_SQLITE", "POWER_MONITOR", "TEMP_MONITOR", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public enum GuildTelemetryTask {
    UPLOAD_PIC("gpro_quality#upload#pic"),
    DOWNLOAD_PIC("gpro_quality#download#pic"),
    UPLOAD_VIDEO("gpro_quality#upload#video"),
    DOWNLOAD_VIDEO("gpro_quality#download#video"),
    UPLOAD_FILE("gpro_quality#upload#file"),
    UPLOADSENDER_FILE("gpro_quality#uploadsender#file"),
    DOWNLOAD_FILE("gpro_quality#download#file"),
    OPEN_CHANNEL_AIO_TIME_COST("gpro_quality#time_cost#channel_aio"),
    SEND_CHANNEL_MSG("gpro_quality#sendmsg#channel_aio"),
    DIRECT_MSG_C2C_TIME_COST("gpro_quality#time_cost#direct_msg_c2c"),
    YOLO_APP_TIME_COST("gpro_quality#time_cost#youle_app"),
    MSG_PUSH_MONITOR_TASKSIZE("gpro_quality#msgpush#tasksize"),
    PERF_MONITOR_TRAFFIC("gpro_quality#perf_monitor#traffic_info"),
    PERF_MONITOR_FPS("gpro_quality#perf_monitor#fps_info"),
    PERF_MONITOR_MEMORY_CPU("gpro_quality#perf_monitor#memory_cpu_info"),
    ERROR_CODE_GPRO_SQLITE("gpro_quality#error_code#gprosdk_sqlite"),
    POWER_MONITOR("gpro_quality#power_monitor#power_info"),
    TEMP_MONITOR("gpro_quality#temp_monitor#temp_info");


    @NotNull
    private String taskName;

    GuildTelemetryTask(String str) {
        this.taskName = str;
    }

    @NotNull
    public final String getTaskName() {
        return this.taskName;
    }

    public final void setTaskName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.taskName = str;
    }
}
