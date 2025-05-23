package com.tencent.mobileqq.guild.performance.report;

import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b<\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/guild/performance/report/GuildTelemetryAttributes;", "", "attrName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getAttrName", "()Ljava/lang/String;", "setAttrName", "(Ljava/lang/String;)V", "BIZ_TYPE", Global.TRACKING_URL, "SIZE", KeyPropertiesCompact.DIGEST_MD5, "TOTAL_TIME", "START_TIME", "COST_TIME", "RESULT", "ERROR_MSG", "DOWNLOAD_RATE", "FILE_SAVE_PATH", "FILE_NAME", "UPLOAD_RATE", "TASK_SIZE", IGuildMessageUtilsApi.GUILD_ID_EXT_STR, "CHANNEL_ID", "ERRORCODE", "TIME_COST", PreDownloadConstants.RPORT_KEY_FPS, "FLUENCY", "TOTAL_FLUENCY", "CPU_USAGE", "PROCESS_MEMORY_USAGE", "MEMORY_REMAIN", "HEAP_MEMORY", "CPU_CONSUMPTION", "NET_TX_CONSUMPTION", "NET_RX_CONSUMPTION", "SENSOR_TYPE_ACCELEROMETER_CONSUMPTION", "POWER_SCENE", "TRAFFIC_MSF", "TRAFFIC_IMG", "TRAFFIC_VIDEO", "TRAFFIC_FILE", "TRAFFIC_PUSH_COUNT", "TRAFFIC_PUSH", "TRAFFIC_ROAM_COUNT", "TRAFFIC_ROAM", "TRAFFIC_OFFLINE_COUNT", "TRAFFIC_OFFLINE", "TRAFFIC_PUSH_SEQ", "TRAFFIC_HUGE_SEQ", "TRAFFIC_HUGE_COUNT", "TRAFFIC_TOTAL", "GUILD_SCENE", "BRANCH_NAME", "IS_BACKGROUND", "IS_GUILDTAB", "GUILD_SIDE_SCENE", IGuildMainFrameApi.APP_VERSION, "AUTO_TASK_ID", "AUTO_TASK_TIME", "TEMP_DIFF", "TEMPERATURE", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public enum GuildTelemetryAttributes {
    BIZ_TYPE("biz_type"),
    URL("url"),
    SIZE("size"),
    MD5("md5"),
    TOTAL_TIME("total_time"),
    START_TIME("start_time"),
    COST_TIME("cost_time"),
    RESULT("ret"),
    ERROR_MSG("msg"),
    DOWNLOAD_RATE("download_rate"),
    FILE_SAVE_PATH("file_save_path"),
    FILE_NAME("file_name"),
    UPLOAD_RATE("upload_rate"),
    TASK_SIZE("task_size"),
    GUILD_ID("guild_id"),
    CHANNEL_ID("channel_id"),
    ERRORCODE("errorcode"),
    TIME_COST("time_cost"),
    FPS("fps"),
    FLUENCY("fluency"),
    TOTAL_FLUENCY("total_fluency"),
    CPU_USAGE("cpu_usage"),
    PROCESS_MEMORY_USAGE("process_memory_usage"),
    MEMORY_REMAIN("memory_remain"),
    HEAP_MEMORY("heap_memory"),
    CPU_CONSUMPTION("power_cpu_consumption"),
    NET_TX_CONSUMPTION("power_net_tx_consumption"),
    NET_RX_CONSUMPTION("power_net_rx_consumption"),
    SENSOR_TYPE_ACCELEROMETER_CONSUMPTION("power_sensor_accelerometer"),
    POWER_SCENE("power_scene"),
    TRAFFIC_MSF("traffic_msf"),
    TRAFFIC_IMG("traffic_img"),
    TRAFFIC_VIDEO("traffic_video"),
    TRAFFIC_FILE("traffic_file"),
    TRAFFIC_PUSH_COUNT("traffic_push_count"),
    TRAFFIC_PUSH("traffic_push"),
    TRAFFIC_ROAM_COUNT("traffic_roam_count"),
    TRAFFIC_ROAM("traffic_roam"),
    TRAFFIC_OFFLINE_COUNT("traffic_offline_count"),
    TRAFFIC_OFFLINE("traffic_offline"),
    TRAFFIC_PUSH_SEQ("traffic_push_seq"),
    TRAFFIC_HUGE_SEQ("traffic_huge_seq"),
    TRAFFIC_HUGE_COUNT("traffic_huge_count"),
    TRAFFIC_TOTAL("traffic_total"),
    GUILD_SCENE("scene"),
    BRANCH_NAME("branch_name"),
    IS_BACKGROUND("is_background"),
    IS_GUILDTAB("is_guildtab"),
    GUILD_SIDE_SCENE("side_scene"),
    APP_VERSION("app_version"),
    AUTO_TASK_ID("auto_task_id"),
    AUTO_TASK_TIME("auto_task_time"),
    TEMP_DIFF("temp_diff"),
    TEMPERATURE("temperature");


    @NotNull
    private String attrName;

    GuildTelemetryAttributes(String str) {
        this.attrName = str;
    }

    @NotNull
    public final String getAttrName() {
        return this.attrName;
    }

    public final void setAttrName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.attrName = str;
    }
}
