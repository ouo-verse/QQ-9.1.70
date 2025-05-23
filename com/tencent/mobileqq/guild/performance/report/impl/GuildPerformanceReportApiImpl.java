package com.tencent.mobileqq.guild.performance.report.impl;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.performance.report.GuildTelemetryAttributes;
import com.tencent.mobileqq.guild.performance.report.GuildTelemetryTask;
import com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi;
import com.tencent.mobileqq.guild.performance.report.c;
import com.tencent.mobileqq.guild.performance.report.data.a;
import com.tencent.mobileqq.guild.performance.report.g;
import com.tencent.mobileqq.guild.performance.report.y;
import com.tencent.mobileqq.guild.util.performance.h;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qphone.base.util.QLog;
import f12.b;
import f12.d;
import f12.m;
import f12.o;
import java.util.Map;
import kotlin.C11734b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0007\u0018\u0000 22\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016J \u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J$\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000b0\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J\u001c\u0010!\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\"\u001a\u00020\u0002H\u0016J\b\u0010#\u001a\u00020\u0002H\u0016J\b\u0010%\u001a\u00020$H\u0016J\b\u0010&\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020$H\u0016J\b\u0010(\u001a\u00020$H\u0016J\b\u0010)\u001a\u00020$H\u0016J\b\u0010*\u001a\u00020$H\u0016J\b\u0010+\u001a\u00020$H\u0016J\b\u0010,\u001a\u00020$H\u0016J\b\u0010-\u001a\u00020$H\u0016J\b\u0010.\u001a\u00020$H\u0016J\b\u0010/\u001a\u00020\u000fH\u0016\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/guild/performance/report/impl/GuildPerformanceReportApiImpl;", "Lcom/tencent/mobileqq/guild/performance/report/IGuildPerformanceReportApi;", "", "endESportHallTask", "", "type", "startGuildTabInitTask", "Lcom/tencent/mobileqq/guild/performance/report/data/a;", "callback", "addCallback", "removeCallback", "", "scene", HippyTKDListViewAdapter.SCROLL_STATE, "handleScrollStateChanged", "", "timeIntervalMills", "methodName", "startTime", "startAutomatedTestMode", "stopAutomatedTestMode", "byteSize", "addMSFTraffic", "Lcom/tencent/mobileqq/guild/performance/report/GuildTelemetryTask;", "task", "", "Lcom/tencent/mobileqq/guild/performance/report/GuildTelemetryAttributes;", "params", "addDownloadTraffic", "taskName", "startAioOpenTimeCostTask", "guildId", "channleId", "endAioOpenTimeCostTask", "getTemperatureDiff", "sendTemperatureInfo", "", "getTraceEnable", "getJumpDebugLogEnable", "getEmptySubscribeGuildContentEnable", "isDisableSubscribeGuildContentPreloadSwitch", "isEnableStickyCardLiveVoice", "isEnableNewUserDiscover", "isEnableToastForTianshu", "isAioAndWebPreloadDisable", "isForceEnableMarkdownBreakSimple", "isEnableGuildTabMethodTrace", "getGuildTabPageMethodTraceDuration", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes14.dex */
public final class GuildPerformanceReportApiImpl implements IGuildPerformanceReportApi {

    @NotNull
    private static final String TAG = "GuildPerformanceReportApiImpl";

    @Override // com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi
    public void addCallback(@NotNull a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        d.f397604d.c(callback);
        b.f397591a.c(callback);
    }

    @Override // com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi
    public void addDownloadTraffic(@NotNull GuildTelemetryTask task, @NotNull Map<GuildTelemetryAttributes, String> params) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(params, "params");
        m.f397667a.c(task, params);
    }

    @Override // com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi
    public void addMSFTraffic(long byteSize) {
        m.f397667a.d(byteSize);
    }

    @Override // com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi
    public void endAioOpenTimeCostTask(@Nullable String guildId, @Nullable String channleId) {
        c.b(guildId, channleId);
    }

    @Override // com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi
    public void endESportHallTask() {
        g.f231013a.a();
    }

    @Override // com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi
    public boolean getEmptySubscribeGuildContentEnable() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi
    public long getGuildTabPageMethodTraceDuration() {
        return 1000L;
    }

    @Override // com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi
    public boolean getJumpDebugLogEnable() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi
    public void getTemperatureDiff() {
        h.f235590a.c();
    }

    @Override // com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi
    public boolean getTraceEnable() {
        C11734b c11734b = C11734b.f433780a;
        QLog.i("Guild.component." + TAG, 1, "getTraceEnable result in AppSetting config=true, env=false", null);
        return false;
    }

    @Override // com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi
    public void handleScrollStateChanged(@NotNull String scene, int scrollState) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        d.f397604d.i(scene, scrollState);
    }

    @Override // com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi
    public boolean isAioAndWebPreloadDisable() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi
    public boolean isDisableSubscribeGuildContentPreloadSwitch() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi
    public boolean isEnableGuildTabMethodTrace() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi
    public boolean isEnableNewUserDiscover() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi
    public boolean isEnableStickyCardLiveVoice() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi
    public boolean isEnableToastForTianshu() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi
    public boolean isForceEnableMarkdownBreakSimple() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi
    public void removeCallback(@NotNull a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        d.f397604d.l(callback);
        b.f397591a.h(callback);
    }

    @Override // com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi
    public void sendTemperatureInfo() {
        h.f235590a.h();
    }

    @Override // com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi
    public void startAioOpenTimeCostTask(@NotNull String taskName) {
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        c.c(taskName);
    }

    @Override // com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi
    public void startAutomatedTestMode(long timeIntervalMills, @NotNull String methodName, @NotNull String startTime) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        b.f397591a.k(timeIntervalMills);
        o.f397685a.r(methodName, startTime);
    }

    @Override // com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi
    public void startGuildTabInitTask(int type) {
        y.f231068a.f(type);
    }

    @Override // com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi
    public void stopAutomatedTestMode() {
        b.f397591a.l();
        o.f397685a.a();
    }
}
