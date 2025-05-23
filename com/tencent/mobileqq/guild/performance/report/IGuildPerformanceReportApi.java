package com.tencent.mobileqq.guild.performance.report;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H&J \u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH&J\b\u0010\u0014\u001a\u00020\u0002H&J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000fH&J$\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000b0\u0019H&J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000bH&J\u001c\u0010!\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u000bH&J\b\u0010\"\u001a\u00020\u0002H&J\b\u0010#\u001a\u00020\u0002H&J\b\u0010%\u001a\u00020$H&J\b\u0010&\u001a\u00020$H&J\b\u0010'\u001a\u00020$H&J\b\u0010(\u001a\u00020$H&J\b\u0010)\u001a\u00020$H&J\b\u0010*\u001a\u00020$H&J\b\u0010+\u001a\u00020$H&J\b\u0010,\u001a\u00020$H&J\b\u0010-\u001a\u00020$H&J\b\u0010.\u001a\u00020$H&J\b\u0010/\u001a\u00020\u000fH&\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/performance/report/IGuildPerformanceReportApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "endESportHallTask", "", "type", "startGuildTabInitTask", "Lcom/tencent/mobileqq/guild/performance/report/data/a;", "callback", "addCallback", "removeCallback", "", "scene", HippyTKDListViewAdapter.SCROLL_STATE, "handleScrollStateChanged", "", "timeIntervalMills", "methodName", "startTime", "startAutomatedTestMode", "stopAutomatedTestMode", "byteSize", "addMSFTraffic", "Lcom/tencent/mobileqq/guild/performance/report/GuildTelemetryTask;", "task", "", "Lcom/tencent/mobileqq/guild/performance/report/GuildTelemetryAttributes;", "params", "addDownloadTraffic", "taskName", "startAioOpenTimeCostTask", "guildId", "channleId", "endAioOpenTimeCostTask", "getTemperatureDiff", "sendTemperatureInfo", "", "getTraceEnable", "getJumpDebugLogEnable", "getEmptySubscribeGuildContentEnable", "isDisableSubscribeGuildContentPreloadSwitch", "isEnableStickyCardLiveVoice", "isEnableNewUserDiscover", "isEnableToastForTianshu", "isAioAndWebPreloadDisable", "isForceEnableMarkdownBreakSimple", "isEnableGuildTabMethodTrace", "getGuildTabPageMethodTraceDuration", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildPerformanceReportApi extends QRouteApi {
    void addCallback(@NotNull com.tencent.mobileqq.guild.performance.report.data.a callback);

    void addDownloadTraffic(@NotNull GuildTelemetryTask task, @NotNull Map<GuildTelemetryAttributes, String> params);

    void addMSFTraffic(long byteSize);

    void endAioOpenTimeCostTask(@Nullable String guildId, @Nullable String channleId);

    void endESportHallTask();

    boolean getEmptySubscribeGuildContentEnable();

    long getGuildTabPageMethodTraceDuration();

    boolean getJumpDebugLogEnable();

    void getTemperatureDiff();

    boolean getTraceEnable();

    void handleScrollStateChanged(@NotNull String scene, int scrollState);

    boolean isAioAndWebPreloadDisable();

    boolean isDisableSubscribeGuildContentPreloadSwitch();

    boolean isEnableGuildTabMethodTrace();

    boolean isEnableNewUserDiscover();

    boolean isEnableStickyCardLiveVoice();

    boolean isEnableToastForTianshu();

    boolean isForceEnableMarkdownBreakSimple();

    void removeCallback(@NotNull com.tencent.mobileqq.guild.performance.report.data.a callback);

    void sendTemperatureInfo();

    void startAioOpenTimeCostTask(@NotNull String taskName);

    void startAutomatedTestMode(long timeIntervalMills, @NotNull String methodName, @NotNull String startTime);

    void startGuildTabInitTask(int type);

    void stopAutomatedTestMode();
}
