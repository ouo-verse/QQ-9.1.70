package com.tencent.mobileqq.guild.media.core.logic;

import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.guild.live.helper.GuildTimeRecHelper;
import com.tencent.mobileqq.guild.util.timerecord.GuildAudioTimeEvent;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005Jt\u0010\u0011\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00022(\b\u0002\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u000fH\u0007J>\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u000f2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u0007\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/a;", "", "", "guildId", "channelId", "", "channelType", "", "f", "event", ImageTaskConst.ERROR_TYPE, "errTypeMsg", "errCode", "errMsg", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extParams", "a", "code", "", "enterRoomStep2Ts", "enterRoomStep3Ts", "d", "c", "e", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {
    public static /* synthetic */ void b(a aVar, String str, String str2, String str3, int i3, String str4, int i16, String str5, HashMap hashMap, int i17, Object obj) {
        int i18;
        String str6;
        int i19;
        String str7;
        HashMap hashMap2;
        if ((i17 & 8) != 0) {
            i18 = 0;
        } else {
            i18 = i3;
        }
        if ((i17 & 16) != 0) {
            str6 = null;
        } else {
            str6 = str4;
        }
        if ((i17 & 32) != 0) {
            i19 = 0;
        } else {
            i19 = i16;
        }
        if ((i17 & 64) != 0) {
            str7 = "";
        } else {
            str7 = str5;
        }
        if ((i17 & 128) != 0) {
            hashMap2 = null;
        } else {
            hashMap2 = hashMap;
        }
        aVar.a(str, str2, str3, i18, str6, i19, str7, hashMap2);
    }

    @JvmOverloads
    public final void a(@NotNull String event, @NotNull String guildId, @NotNull String channelId, int errType, @Nullable String errTypeMsg, int errCode, @NotNull String errMsg, @Nullable HashMap<String, String> extParams) {
        String str;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        HashMap hashMap = new HashMap();
        hashMap.put("guild_id", guildId);
        hashMap.put("channel_id", channelId);
        hashMap.put(AudienceReportConst.ROOM_ID, channelId);
        hashMap.put("err_type", String.valueOf(errType));
        if (errTypeMsg == null) {
            str = "";
        } else {
            str = errTypeMsg;
        }
        hashMap.put("err_type_msg", str);
        hashMap.put("ret", String.valueOf(errCode));
        hashMap.put("msg", errMsg);
        if (extParams != null) {
            hashMap.putAll(extParams);
        }
        com.tencent.mobileqq.guild.performance.report.e.a(event, hashMap, errType, errTypeMsg, errCode, errMsg);
    }

    public final void c() {
        com.tencent.mobileqq.guild.performance.report.e.c();
    }

    @Nullable
    public final HashMap<String, String> d(int code, long enterRoomStep2Ts, long enterRoomStep3Ts) {
        if (code != 0) {
            return null;
        }
        long j3 = enterRoomStep3Ts - enterRoomStep2Ts;
        long currentTimeMillis = System.currentTimeMillis() - enterRoomStep3Ts;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("audio_enter_step2_time_cost", String.valueOf(j3));
        hashMap.put("audio_enter_step3_time_cost", String.valueOf(currentTimeMillis));
        hashMap.put("audio_enter_total_time_cost", String.valueOf(j3 + currentTimeMillis));
        return hashMap;
    }

    public final void e() {
        GuildTimeRecHelper.Companion companion = GuildTimeRecHelper.INSTANCE;
        GuildAudioTimeEvent guildAudioTimeEvent = GuildAudioTimeEvent.AUDIO_MIC_ON_TIME_SUM;
        companion.a(guildAudioTimeEvent, GuildAudioTimeEvent.AUDIO_MIC_ON_TIME_SPAN);
        companion.l(guildAudioTimeEvent, 0);
    }

    public final void f(@NotNull String guildId, @NotNull String channelId, int channelType) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        com.tencent.mobileqq.guild.performance.report.e.i(guildId, channelId, channelType);
    }
}
