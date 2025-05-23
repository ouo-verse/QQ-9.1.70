package com.tencent.mobileqq.qqguildsdk.tianjige;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000\"0\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0004j\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0002`\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0006\"0\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b0\u0004j\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b`\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildCounterNames;", "names", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildPublicSampleRate;", "a", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "counterPublicReportType", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildGraySampleRate;", "b", "counterGrayReportType", "qqguild-sdk-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final HashMap<GuildCounterNames, GuildPublicSampleRate> f268494a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final HashMap<GuildCounterNames, GuildGraySampleRate> f268495b;

    static {
        HashMap<GuildCounterNames, GuildPublicSampleRate> hashMap = new HashMap<>();
        GuildCounterNames guildCounterNames = GuildCounterNames.PIC_DOWNLOAD;
        GuildPublicSampleRate guildPublicSampleRate = GuildPublicSampleRate.PUBLIC_NONE;
        hashMap.put(guildCounterNames, guildPublicSampleRate);
        GuildCounterNames guildCounterNames2 = GuildCounterNames.GUILD_JOIN_SUCC_RATE;
        GuildPublicSampleRate guildPublicSampleRate2 = GuildPublicSampleRate.PUBLIC_FULL;
        hashMap.put(guildCounterNames2, guildPublicSampleRate2);
        GuildCounterNames guildCounterNames3 = GuildCounterNames.GUILD_JUMP_SUCC_RATE;
        hashMap.put(guildCounterNames3, guildPublicSampleRate2);
        GuildCounterNames guildCounterNames4 = GuildCounterNames.GUILD_IPC_SUCC_RATE;
        hashMap.put(guildCounterNames4, guildPublicSampleRate2);
        GuildCounterNames guildCounterNames5 = GuildCounterNames.NT_DB_OPEN;
        hashMap.put(guildCounterNames5, guildPublicSampleRate);
        GuildCounterNames guildCounterNames6 = GuildCounterNames.NT_SERVICE_CALL;
        hashMap.put(guildCounterNames6, guildPublicSampleRate);
        GuildCounterNames guildCounterNames7 = GuildCounterNames.NT_PUSH_COUNT;
        hashMap.put(guildCounterNames7, guildPublicSampleRate);
        GuildCounterNames guildCounterNames8 = GuildCounterNames.GUILD_LIVE_HTTPDNS_PLAY;
        hashMap.put(guildCounterNames8, guildPublicSampleRate2);
        GuildCounterNames guildCounterNames9 = GuildCounterNames.GUILD_LIVE_HTTPDNS_REQUEST;
        hashMap.put(guildCounterNames9, guildPublicSampleRate2);
        GuildCounterNames guildCounterNames10 = GuildCounterNames.GUILD_MINI_CONTAINER_WHITE_SCREEN;
        GuildPublicSampleRate guildPublicSampleRate3 = GuildPublicSampleRate.PUBLIC_MANAGE;
        hashMap.put(guildCounterNames10, guildPublicSampleRate3);
        GuildCounterNames guildCounterNames11 = GuildCounterNames.GUILD_MINI_CONTAINER_LOAD;
        hashMap.put(guildCounterNames11, guildPublicSampleRate3);
        GuildCounterNames guildCounterNames12 = GuildCounterNames.GUILD_URL_JUMP_INFO_DECODE_SUCC_RATE;
        hashMap.put(guildCounterNames12, guildPublicSampleRate2);
        GuildCounterNames guildCounterNames13 = GuildCounterNames.MEDIA_GUILD_PULL_WEB_VIEW;
        hashMap.put(guildCounterNames13, guildPublicSampleRate2);
        GuildCounterNames guildCounterNames14 = GuildCounterNames.MEDIA_GUILD_GET_AUTH_CODE;
        hashMap.put(guildCounterNames14, guildPublicSampleRate2);
        GuildCounterNames guildCounterNames15 = GuildCounterNames.MEDIA_GUILD_WEB_VIEW_FINISH;
        hashMap.put(guildCounterNames15, guildPublicSampleRate2);
        GuildCounterNames guildCounterNames16 = GuildCounterNames.MEDIA_GUILD_WEB_RENDER_START;
        hashMap.put(guildCounterNames16, guildPublicSampleRate2);
        GuildCounterNames guildCounterNames17 = GuildCounterNames.MEDIA_GUILD_WEB_RENDER_COMPLETE;
        hashMap.put(guildCounterNames17, guildPublicSampleRate2);
        GuildCounterNames guildCounterNames18 = GuildCounterNames.MEDIA_GUILD_SHOW_AUTH_PANEL;
        hashMap.put(guildCounterNames18, guildPublicSampleRate2);
        GuildCounterNames guildCounterNames19 = GuildCounterNames.GUILD_LISTEN;
        hashMap.put(guildCounterNames19, guildPublicSampleRate2);
        GuildCounterNames guildCounterNames20 = GuildCounterNames.MORE_BTN_CLICK;
        hashMap.put(guildCounterNames20, guildPublicSampleRate2);
        GuildCounterNames guildCounterNames21 = GuildCounterNames.MEDIA_GUILD_WEB_USE_OFFLINE;
        hashMap.put(guildCounterNames21, guildPublicSampleRate2);
        f268494a = hashMap;
        HashMap<GuildCounterNames, GuildGraySampleRate> hashMap2 = new HashMap<>();
        hashMap2.put(guildCounterNames, GuildGraySampleRate.GRAY_MANAGE);
        GuildGraySampleRate guildGraySampleRate = GuildGraySampleRate.GRAY_FULL;
        hashMap2.put(guildCounterNames2, guildGraySampleRate);
        hashMap2.put(guildCounterNames3, guildGraySampleRate);
        hashMap2.put(guildCounterNames4, guildGraySampleRate);
        hashMap2.put(guildCounterNames5, guildGraySampleRate);
        hashMap2.put(guildCounterNames6, guildGraySampleRate);
        hashMap2.put(guildCounterNames7, guildGraySampleRate);
        hashMap2.put(guildCounterNames8, guildGraySampleRate);
        hashMap2.put(guildCounterNames9, guildGraySampleRate);
        hashMap2.put(guildCounterNames10, guildGraySampleRate);
        hashMap2.put(guildCounterNames11, guildGraySampleRate);
        hashMap2.put(guildCounterNames12, guildGraySampleRate);
        hashMap2.put(guildCounterNames13, guildGraySampleRate);
        hashMap2.put(guildCounterNames14, guildGraySampleRate);
        hashMap2.put(guildCounterNames15, guildGraySampleRate);
        hashMap2.put(guildCounterNames16, guildGraySampleRate);
        hashMap2.put(guildCounterNames17, guildGraySampleRate);
        hashMap2.put(guildCounterNames18, guildGraySampleRate);
        hashMap2.put(guildCounterNames21, guildGraySampleRate);
        hashMap2.put(guildCounterNames19, guildGraySampleRate);
        hashMap2.put(guildCounterNames20, guildGraySampleRate);
        f268495b = hashMap2;
    }

    @Nullable
    public static final GuildPublicSampleRate a(@NotNull GuildCounterNames names) {
        Intrinsics.checkNotNullParameter(names, "names");
        return f268494a.get(names);
    }
}
