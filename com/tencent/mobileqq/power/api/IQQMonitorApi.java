package com.tencent.mobileqq.power.api;

import android.content.Context;
import com.tencent.mobileqq.power.a;
import com.tencent.mobileqq.power.b;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\b\u0010\u000f\u001a\u00020\u0004H&J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J&\u0010\u0015\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H&J\u0016\u0010\u0019\u001a\u00020\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/power/api/IQQMonitorApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "", "startVivoMonitor", "stopVivoMonitor", "startCpuMonitor", "stopCpuMonitor", "", "avgCpuUsage", "startFrontCpuMonitor", "Lcom/tencent/mobileqq/power/a;", "callback", "getCpuData", "stopFrontCpuMonitor", "reportCpuMonitor", "", "tag", "url", "path", "reportNetUrl", "", "Lcom/tencent/mobileqq/power/b;", "datas", "reportNetFlow", "power_monitor_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQMonitorApi extends QRouteApi {
    void getCpuData(@Nullable a callback);

    void reportCpuMonitor(@Nullable Context context);

    void reportNetFlow(@NotNull List<? extends b> datas);

    void reportNetUrl(@Nullable String tag, @Nullable String url, @Nullable String path);

    void startCpuMonitor(@Nullable Context context);

    void startFrontCpuMonitor(double avgCpuUsage);

    void startVivoMonitor(@Nullable Context context);

    void stopCpuMonitor(@Nullable Context context);

    void stopFrontCpuMonitor();

    void stopVivoMonitor();
}
