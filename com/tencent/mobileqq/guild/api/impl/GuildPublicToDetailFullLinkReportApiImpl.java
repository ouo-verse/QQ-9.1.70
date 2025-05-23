package com.tencent.mobileqq.guild.api.impl;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.guild.api.IGuildPublicToDetailFullLinkReportApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bH\u0016J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildPublicToDetailFullLinkReportApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildPublicToDetailFullLinkReportApi;", "()V", "end", "", "linkEndTime", "", "isColdStart", "", "logMethod", "to", "", "logTime", "isClear", "logMethodAndReport", AdMetricTag.EVENT_NAME, "start", "startTime", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class GuildPublicToDetailFullLinkReportApiImpl implements IGuildPublicToDetailFullLinkReportApi {
    @Override // com.tencent.mobileqq.guild.api.IGuildPublicToDetailFullLinkReportApi
    public void end(long linkEndTime, boolean isColdStart) {
        com.tencent.mobileqq.guild.performance.report.w.f231064i.j(linkEndTime, isColdStart);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildPublicToDetailFullLinkReportApi
    public void logMethod(@NotNull String to5, long logTime, boolean isClear) {
        Intrinsics.checkNotNullParameter(to5, "to");
        if (isClear) {
            com.tencent.mobileqq.guild.performance.report.w.f231064i.i();
        }
        com.tencent.mobileqq.guild.performance.report.w.f231064i.k(to5, logTime);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildPublicToDetailFullLinkReportApi
    public void logMethodAndReport(@NotNull String eventName, @NotNull String to5, long logTime) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(to5, "to");
        com.tencent.mobileqq.guild.performance.report.w.f231064i.l(eventName, to5, logTime);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildPublicToDetailFullLinkReportApi
    public void start(long startTime) {
        com.tencent.mobileqq.guild.performance.report.w.f231064i.o(startTime);
    }
}
