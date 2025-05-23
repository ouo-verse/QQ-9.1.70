package com.tencent.mobileqq.qqguildsdk.tianjige;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildGaugeNames;", "", "gaugeName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getGaugeName", "()Ljava/lang/String;", "setGaugeName", "(Ljava/lang/String;)V", "CPU_TEMPERATURE_LOGIN_DIFF", "CPU_TEMPERATURE_DIFF", "CPU_TEMPERATURE", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public enum GuildGaugeNames {
    CPU_TEMPERATURE_LOGIN_DIFF("guild_pf_lg_cpu_temp_diff"),
    CPU_TEMPERATURE_DIFF("guild_pf_cpu_temp_diff"),
    CPU_TEMPERATURE("guild_pf_cpu_temperature");


    @NotNull
    private String gaugeName;

    GuildGaugeNames(String str) {
        this.gaugeName = str;
    }

    @NotNull
    public final String getGaugeName() {
        return this.gaugeName;
    }

    public final void setGaugeName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gaugeName = str;
    }
}
