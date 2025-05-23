package com.tencent.mobileqq.guild.performance.report;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007Jh\u0010\u0011\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022,\b\u0002\u0010\f\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\nj\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0002H\u0007J\b\u0010\u0012\u001a\u00020\u0007H\u0007J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0005H\u0007J \u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0002H\u0007J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017H\u0007J \u0010\u001a\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0007R\u0016\u0010\u001d\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/performance/report/e;", "", "", "guildId", "channelId", "", "channelType", "", "i", AdMetricTag.EVENT_NAME, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extraInfo", ImageTaskConst.ERROR_TYPE, "errTypeMsg", "errCode", "errMsg", "a", "c", "d", "errRes", "g", tl.h.F, "", "costTime", "e", "f", "b", "J", "startTimestamp", "lastReportTimestamp", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f231005a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long startTimestamp;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long lastReportTimestamp;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static IPerformanceReportTask reportTask;

    static {
        long currentTimeMillis = System.currentTimeMillis();
        startTimestamp = currentTimeMillis;
        lastReportTimestamp = currentTimeMillis;
    }

    e() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x00a0, code lost:
    
        if ((!r5.isEmpty()) == true) goto L14;
     */
    @JvmStatic
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(@NotNull String eventName, @Nullable HashMap<String, String> extraInfo, int errType, @Nullable String errTypeMsg, int errCode, @NotNull String errMsg) {
        boolean z16;
        IPerformanceReportTask duplicate;
        IPerformanceReportTask extras;
        IPerformanceReportTask timeCost;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildAudioRoomReportTask", 2, "addTaskEvent event: " + eventName + ", code: " + errCode + ", msg: " + errMsg);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ret", String.valueOf(errCode));
        hashMap.put("msg", errMsg);
        hashMap.put("guild_id", com.tencent.mobileqq.guild.media.core.j.a().getGuildID());
        hashMap.put("channel_id", com.tencent.mobileqq.guild.media.core.j.a().E());
        hashMap.put("channel_type", com.tencent.mobileqq.guild.media.core.j.a().getChannelType());
        hashMap.put("err_type", String.valueOf(errType));
        if (errTypeMsg == null) {
            errTypeMsg = "";
        }
        hashMap.put("err_type_msg", errTypeMsg);
        if (extraInfo != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            for (Map.Entry<String, String> entry : extraInfo.entrySet()) {
                String value = entry.getValue();
                if (value != null) {
                    hashMap.put(entry.getKey(), value);
                }
            }
        }
        if (errCode != 0) {
            hashMap.put("stage", eventName);
        }
        hashMap.put("timestamp_from_start_on", String.valueOf(System.currentTimeMillis() - startTimestamp));
        IPerformanceReportTask iPerformanceReportTask = reportTask;
        if (iPerformanceReportTask != null && (duplicate = iPerformanceReportTask.duplicate(new String[0])) != null && (extras = duplicate.setExtras(hashMap)) != null && (timeCost = extras.setTimeCost(System.currentTimeMillis() - lastReportTimestamp)) != null) {
            timeCost.report();
        }
        lastReportTimestamp = System.currentTimeMillis();
    }

    public static /* synthetic */ void b(String str, HashMap hashMap, int i3, String str2, int i16, String str3, int i17, Object obj) {
        int i18;
        String str4;
        if ((i17 & 2) != 0) {
            hashMap = null;
        }
        int i19 = 0;
        if ((i17 & 4) != 0) {
            i18 = 0;
        } else {
            i18 = i3;
        }
        String str5 = "";
        if ((i17 & 8) != 0) {
            str4 = "";
        } else {
            str4 = str2;
        }
        if ((i17 & 16) == 0) {
            i19 = i16;
        }
        if ((i17 & 32) == 0) {
            str5 = str3;
        }
        a(str, hashMap, i18, str4, i19, str5);
    }

    @JvmStatic
    public static final void c() {
        IPerformanceReportTask duplicate;
        IPerformanceReportTask stageCode;
        IPerformanceReportTask extras;
        IPerformanceReportTask timeCost;
        HashMap hashMap = new HashMap();
        hashMap.put("timestamp_from_start_on", String.valueOf(System.currentTimeMillis() - startTimestamp));
        IPerformanceReportTask iPerformanceReportTask = reportTask;
        if (iPerformanceReportTask != null && (duplicate = iPerformanceReportTask.duplicate(new String[0])) != null && (stageCode = duplicate.setStageCode("end")) != null && (extras = stageCode.setExtras(hashMap)) != null && (timeCost = extras.setTimeCost(System.currentTimeMillis() - lastReportTimestamp)) != null) {
            timeCost.report();
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildAudioRoomReportTask", 2, "endTask");
        }
    }

    @JvmStatic
    public static final void d(int channelType) {
        HashMap hashMap = new HashMap();
        hashMap.put("audio_status", "start_enter");
        hashMap.put("channel_type", String.valueOf(channelType));
        j.a("gpro_quality#error_code#audio_enter_exit", hashMap);
    }

    @JvmStatic
    public static final void e(long costTime) {
        Map mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("audio_status", "entered"), TuplesKt.to("audio_cost_time", String.valueOf(costTime)), TuplesKt.to("channel_type", com.tencent.mobileqq.guild.media.core.j.a().getChannelType()));
        HashMap hashMap = new HashMap();
        hashMap.putAll(mapOf);
        j.a("gpro_quality#error_code#audio_enter_exit", hashMap);
    }

    @JvmStatic
    public static final void f(@NotNull String errType, int errCode, @NotNull String channelType) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(errType, "errType");
        Intrinsics.checkNotNullParameter(channelType, "channelType");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("audio_status", "exited"), TuplesKt.to("audio_exit_reason", errType), TuplesKt.to("audio_err_code", String.valueOf(errCode)), TuplesKt.to("channel_type", channelType));
        HashMap hashMap = new HashMap();
        hashMap.putAll(mapOf);
        j.a("gpro_quality#error_code#audio_enter_exit", hashMap);
    }

    @JvmStatic
    public static final void g(@NotNull String errRes, int errCode) {
        Intrinsics.checkNotNullParameter(errRes, "errRes");
        h(errRes, errCode, "");
    }

    @JvmStatic
    public static final void h(@NotNull String errRes, int errCode, @NotNull String errMsg) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(errRes, "errRes");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("audio_status", "failed_start"), TuplesKt.to("audio_enter_failed_reason", errRes), TuplesKt.to("audio_err_code", String.valueOf(errCode)), TuplesKt.to("err_type_msg", errMsg), TuplesKt.to("channel_type", com.tencent.mobileqq.guild.media.core.j.a().getChannelType()));
        HashMap hashMap = new HashMap();
        hashMap.putAll(mapOf);
        j.a("gpro_quality#error_code#audio_enter_exit", hashMap);
    }

    @JvmStatic
    public static final void i(@NotNull String guildId, @NotNull String channelId, int channelType) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        long currentTimeMillis = System.currentTimeMillis();
        startTimestamp = currentTimeMillis;
        lastReportTimestamp = currentTimeMillis;
        reportTask = Reporters.f231995a.b().a("gpro_quality#error_code#audio_in").setStageCode("start");
        HashMap hashMap = new HashMap();
        hashMap.put("ret", "0");
        hashMap.put("msg", "");
        hashMap.put("stage", "");
        hashMap.put("guild_id", guildId);
        hashMap.put("channel_id", channelId);
        hashMap.put("channel_type", String.valueOf(channelType));
        IPerformanceReportTask iPerformanceReportTask = reportTask;
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.setExtras(hashMap);
        }
        IPerformanceReportTask iPerformanceReportTask2 = reportTask;
        if (iPerformanceReportTask2 != null) {
            iPerformanceReportTask2.report();
        }
    }
}
