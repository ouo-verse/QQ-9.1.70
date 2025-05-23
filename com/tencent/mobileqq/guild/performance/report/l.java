package com.tencent.mobileqq.guild.performance.report;

import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.model.LiveChannelRoomInfo;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0007J4\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0007J:\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\f2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0007J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0007J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\fH\u0002J,\u0010\u0017\u001a\u00020\u00022\"\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0014j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0015H\u0002R\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/performance/report/l;", "", "", "l", "", "event", "eventAttributeKey", "eventAttributeValue", "", "errCode", "errMsg", "e", "", "extraInfo", "g", "changeSource", "newOrientation", "b", "j", "k", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "taskKey", "", "c", "J", "startTimestamp", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "d", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class l {

    /* renamed from: a */
    @NotNull
    public static final l f231027a = new l();

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private static String taskKey = "";

    /* renamed from: c, reason: from kotlin metadata */
    private static long startTimestamp = System.currentTimeMillis();

    /* renamed from: d, reason: from kotlin metadata */
    @Nullable
    private static IPerformanceReportTask reportTask;

    l() {
    }

    @JvmStatic
    public static final void b(int changeSource, int newOrientation) {
        HashMap hashMap = new HashMap();
        hashMap.put("orientation_change_source", String.valueOf(changeSource));
        hashMap.put("is_video_land", String.valueOf(newOrientation));
        i("live_room_orientation_status", hashMap, 0, null, 12, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void c(@NotNull String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        i(event, null, 0, null, 14, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void d(@NotNull String event, @NotNull String eventAttributeKey, @NotNull String eventAttributeValue) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(eventAttributeKey, "eventAttributeKey");
        Intrinsics.checkNotNullParameter(eventAttributeValue, "eventAttributeValue");
        h(event, eventAttributeKey, eventAttributeValue, 0, null, 24, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void e(@NotNull String event, @NotNull String eventAttributeKey, @NotNull String eventAttributeValue, int errCode, @NotNull String errMsg) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(eventAttributeKey, "eventAttributeKey");
        Intrinsics.checkNotNullParameter(eventAttributeValue, "eventAttributeValue");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        HashMap hashMap = new HashMap();
        hashMap.put(eventAttributeKey, eventAttributeValue);
        g(event, hashMap, errCode, errMsg);
    }

    @JvmStatic
    @JvmOverloads
    public static final void f(@NotNull String event, @NotNull Map<String, String> extraInfo) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        i(event, extraInfo, 0, null, 12, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void g(@NotNull String event, @NotNull Map<String, String> extraInfo, int errCode, @NotNull String errMsg) {
        boolean isBlank;
        IPerformanceReportTask iPerformanceReportTask;
        boolean isBlank2;
        IPerformanceReportTask iPerformanceReportTask2;
        IPerformanceReportTask duplicate;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        isBlank = StringsKt__StringsJVMKt.isBlank(taskKey);
        if (isBlank) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildLiveRoomPlayerReportTask", 2, "addTaskEvent (" + event + ") but taskKey is empty. return");
                return;
            }
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        l lVar = f231027a;
        hashMap.putAll(lVar.k());
        lVar.m(hashMap);
        hashMap.put("ret", String.valueOf(errCode));
        hashMap.put("msg", errMsg);
        hashMap.putAll(extraInfo);
        if (errCode != 0) {
            hashMap.put("stage", event);
        }
        hashMap.put("timestamp_from_start_on", String.valueOf(System.currentTimeMillis() - startTimestamp));
        IPerformanceReportTask iPerformanceReportTask3 = reportTask;
        if (iPerformanceReportTask3 != null && (duplicate = iPerformanceReportTask3.duplicate(new String[0])) != null) {
            iPerformanceReportTask = duplicate.setStageCode(event);
        } else {
            iPerformanceReportTask = null;
        }
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(entry.getKey());
            if ((!isBlank2) && (iPerformanceReportTask2 = reportTask) != null) {
                iPerformanceReportTask2.setExtra(entry.getKey(), entry.getValue());
            }
        }
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.setTimeCost(System.currentTimeMillis() - startTimestamp);
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("GuildLiveRoomPlayerReportTask", 2, "addTaskEvent eventName: " + event + ", code: " + errCode + ", msg: " + errMsg + ", params: " + hashMap);
        }
    }

    public static /* synthetic */ void h(String str, String str2, String str3, int i3, String str4, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            i3 = 0;
        }
        if ((i16 & 16) != 0) {
            str4 = "";
        }
        e(str, str2, str3, i3, str4);
    }

    public static /* synthetic */ void i(String str, Map map, int i3, String str2, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        if ((i16 & 8) != 0) {
            str2 = "";
        }
        g(str, map, i3, str2);
    }

    @JvmStatic
    public static final void j() {
        boolean isBlank;
        IPerformanceReportTask iPerformanceReportTask;
        boolean isBlank2;
        IPerformanceReportTask iPerformanceReportTask2;
        IPerformanceReportTask duplicate;
        isBlank = StringsKt__StringsJVMKt.isBlank(taskKey);
        if (isBlank) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildLiveRoomPlayerReportTask", 2, "endTask but taskKey is empty. return");
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("timestamp_from_start_on", String.valueOf(System.currentTimeMillis() - startTimestamp));
        IPerformanceReportTask iPerformanceReportTask3 = reportTask;
        if (iPerformanceReportTask3 != null && (duplicate = iPerformanceReportTask3.duplicate(new String[0])) != null) {
            iPerformanceReportTask = duplicate.setStageCode("end");
        } else {
            iPerformanceReportTask = null;
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank((CharSequence) entry.getKey());
            if ((!isBlank2) && (iPerformanceReportTask2 = reportTask) != null) {
                iPerformanceReportTask2.setExtra((String) entry.getKey(), entry.getValue());
            }
        }
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.setTimeCost(System.currentTimeMillis() - startTimestamp);
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("GuildLiveRoomPlayerReportTask", 2, "endTask, taskKey=" + taskKey);
        }
        taskKey = "";
    }

    private final Map<String, String> k() {
        String guildId;
        String channelId;
        String l3;
        IGProChannelInfo channelInfo = GLiveChannelCore.f226698a.s().getChannelInfo();
        String str = "";
        if (channelInfo == null) {
            guildId = "";
        } else {
            guildId = channelInfo.getGuildId();
        }
        if (channelInfo == null) {
            channelId = "";
        } else {
            channelId = channelInfo.getChannelUin();
        }
        if (channelInfo != null && (l3 = Long.valueOf(channelInfo.getLiveAnchorTinyId()).toString()) != null) {
            str = l3;
        }
        HashMap hashMap = new HashMap();
        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
        hashMap.put("guild_id", guildId);
        Intrinsics.checkNotNullExpressionValue(channelId, "channelId");
        hashMap.put("channel_id", channelId);
        hashMap.put("anchor_tinyid", str);
        return hashMap;
    }

    @JvmStatic
    public static final void l() {
        boolean isBlank;
        IPerformanceReportTask iPerformanceReportTask;
        startTimestamp = System.currentTimeMillis();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ret", "0");
        hashMap.put("msg", "");
        hashMap.put("stage", "");
        f231027a.m(hashMap);
        reportTask = Reporters.f231995a.b().a("gpro_quality#error_code#living_player").setStageCode("start");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            isBlank = StringsKt__StringsJVMKt.isBlank(entry.getKey());
            if ((!isBlank) && (iPerformanceReportTask = reportTask) != null) {
                iPerformanceReportTask.setExtra(entry.getKey(), entry.getValue());
            }
        }
        IPerformanceReportTask iPerformanceReportTask2 = reportTask;
        if (iPerformanceReportTask2 != null) {
            iPerformanceReportTask2.report();
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildLiveRoomPlayerReportTask", 2, "startTask, taskKey=" + taskKey + " ");
        }
    }

    private final void m(HashMap<String, String> hashMap) {
        String str;
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        hashMap.put(AudienceReportConst.ROOM_ID, String.valueOf(gLiveChannelCore.s().getRoomId()));
        hashMap.put("live_url", String.valueOf(gLiveChannelCore.s().getLiveUrl()));
        LiveChannelRoomInfo liveChannelRoomInfo = gLiveChannelCore.s().getLiveChannelRoomInfo();
        if (liveChannelRoomInfo != null) {
            str = liveChannelRoomInfo.getProgramId();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_PROGRAM_ID, str);
        hashMap.put("live_room_type", String.valueOf(gLiveChannelCore.s().getLiveType()));
    }
}
