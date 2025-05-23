package com.tencent.mobileqq.qqguildsdk.tianjige;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000\"0\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0004j\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0002`\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0006\"0\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b0\u0004j\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b`\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildGaugeNames;", "names", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildPublicSampleRate;", "a", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "gaugePublicReportType", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildGraySampleRate;", "b", "gaugeGrayReportType", "qqguild-sdk-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final HashMap<GuildGaugeNames, GuildPublicSampleRate> f268496a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final HashMap<GuildGaugeNames, GuildGraySampleRate> f268497b;

    static {
        HashMap<GuildGaugeNames, GuildPublicSampleRate> hashMap = new HashMap<>();
        GuildGaugeNames guildGaugeNames = GuildGaugeNames.CPU_TEMPERATURE_LOGIN_DIFF;
        GuildPublicSampleRate guildPublicSampleRate = GuildPublicSampleRate.PUBLIC_NONE;
        hashMap.put(guildGaugeNames, guildPublicSampleRate);
        GuildGaugeNames guildGaugeNames2 = GuildGaugeNames.CPU_TEMPERATURE_DIFF;
        hashMap.put(guildGaugeNames2, guildPublicSampleRate);
        GuildGaugeNames guildGaugeNames3 = GuildGaugeNames.CPU_TEMPERATURE;
        hashMap.put(guildGaugeNames3, guildPublicSampleRate);
        f268496a = hashMap;
        HashMap<GuildGaugeNames, GuildGraySampleRate> hashMap2 = new HashMap<>();
        GuildGraySampleRate guildGraySampleRate = GuildGraySampleRate.GRAY_MANAGE;
        hashMap2.put(guildGaugeNames, guildGraySampleRate);
        hashMap2.put(guildGaugeNames2, guildGraySampleRate);
        hashMap2.put(guildGaugeNames3, guildGraySampleRate);
        f268497b = hashMap2;
    }

    @Nullable
    public static final GuildPublicSampleRate a(@NotNull GuildGaugeNames names) {
        Intrinsics.checkNotNullParameter(names, "names");
        return f268496a.get(names);
    }
}
