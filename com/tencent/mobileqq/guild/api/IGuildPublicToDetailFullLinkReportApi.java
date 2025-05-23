package com.tencent.mobileqq.guild.api;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H&J \u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildPublicToDetailFullLinkReportApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "end", "", "linkEndTime", "", "isColdStart", "", "logMethod", "to", "", "logTime", "isClear", "logMethodAndReport", AdMetricTag.EVENT_NAME, "start", "startTime", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildPublicToDetailFullLinkReportApi extends QRouteApi {
    void end(long linkEndTime, boolean isColdStart);

    void logMethod(@NotNull String to5, long logTime, boolean isClear);

    void logMethodAndReport(@NotNull String eventName, @NotNull String to5, long logTime);

    void start(long startTime);
}
