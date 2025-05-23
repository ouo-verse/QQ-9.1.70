package com.tencent.mobileqq.guild.performance.report;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J \u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007JX\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0007J\b\u0010\u0014\u001a\u00020\u0005H\u0007J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0007H\u0007R\u0016\u0010\u0015\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/performance/report/k;", "", "", "guildId", "channelId", "", "e", "", "hasCome", "d", "", "roomId", "isAnchor", "isFlvUrl", "isUseLocalDns", "isEnableDownloadProxy", "isUseQuicFlv", "firstFrameCost", "page2ShowFirstFrameTimeCost", "b", "c", "firstFrameHasCome", "a", "Z", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f231025a = new k();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean firstFrameHasCome;

    k() {
    }

    @JvmStatic
    @NotNull
    public static final String a(boolean firstFrameHasCome2) {
        if (firstFrameHasCome2) {
            return "1";
        }
        return "0";
    }

    @JvmStatic
    public static final void b(@NotNull String guildId, @NotNull String channelId, long roomId, boolean isAnchor, boolean isFlvUrl, boolean isUseLocalDns, boolean isEnableDownloadProxy, boolean isUseQuicFlv, long firstFrameCost, long page2ShowFirstFrameTimeCost) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        HashMap hashMap = new HashMap();
        hashMap.put("first_frame_has_come", a(firstFrameHasCome));
        String str = "1";
        if (isFlvUrl) {
            if (isUseQuicFlv) {
                obj3 = "1";
            } else {
                obj3 = "0";
            }
            hashMap.put("live_is_use_quic_flv_url", obj3);
            if (isEnableDownloadProxy) {
                obj4 = "1";
            } else {
                obj4 = "0";
            }
            hashMap.put("live_is_enable_downloadproxy", obj4);
        } else {
            hashMap.put("live_is_use_quic_flv_url", "0");
            hashMap.put("live_is_enable_downloadproxy", "0");
        }
        if (isUseLocalDns) {
            obj = "1";
        } else {
            obj = "0";
        }
        hashMap.put("live_is_use_local_dns", obj);
        if (com.tencent.mobileqq.guild.config.z.f216289a.e()) {
            obj2 = "1";
        } else {
            obj2 = "0";
        }
        hashMap.put("live_is_support_quic_flv", obj2);
        hashMap.put("time_cost", String.valueOf(firstFrameCost));
        hashMap.put("page_to_show_first_frame_time_cost", String.valueOf(page2ShowFirstFrameTimeCost));
        if (!isAnchor) {
            str = "0";
        }
        hashMap.put("role", str);
        hashMap.put("guild_id", guildId);
        hashMap.put("channel_id", channelId);
        hashMap.put(AudienceReportConst.ROOM_ID, String.valueOf(roomId));
        j.a("gpro_quality#time_cost#living_first_frame", hashMap);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("FirstFrameReportTask", 2, "endTask, channelId=" + channelId);
        }
    }

    @JvmStatic
    public static final void c() {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("FirstFrameReportTask", 2, "endTaskUnexpected.");
        }
        HashMap hashMap = new HashMap();
        hashMap.put("first_frame_has_come", a(firstFrameHasCome));
        j.a("gpro_quality#time_cost#living_first_frame", hashMap);
    }

    @JvmStatic
    public static final void d(boolean hasCome) {
        firstFrameHasCome = hasCome;
    }

    @JvmStatic
    public static final void e(@Nullable String guildId, @Nullable String channelId) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("FirstFrameReportTask", 2, "startTask, channelId=" + channelId);
        }
    }
}
