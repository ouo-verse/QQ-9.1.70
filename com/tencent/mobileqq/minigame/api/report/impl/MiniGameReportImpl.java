package com.tencent.mobileqq.minigame.api.report.impl;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.report.MiniGameHomeReportService;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.minigame.api.report.IMiniGameReport;
import com.tencent.mobileqq.minigame.api.report.impl.MiniGameReportImpl;
import com.tencent.mobileqq.minigame.report.MiniGameBeaconReport;
import com.tencent.mobileqq.minigame.report.MiniGameLebaReporter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J(\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010H\u0016J(\u0010\u0011\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/report/impl/MiniGameReportImpl;", "Lcom/tencent/mobileqq/minigame/api/report/IMiniGameReport;", "()V", "accountUpdateReport", "", "app", "Lmqq/app/AppRuntime;", "clickReportMiniGameFromLeba", "appInfo", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "exposeReportForHome", "exposeReportMiniGameFromLeba", "reportStartup", AdMetricTag.EVENT_NAME, "", "reportMap", "", "reportToBeacon", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameReportImpl implements IMiniGameReport {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportStartup$lambda$0(String str, Map map) {
        MiniGameBeaconReport.reportToBeacon(str, map);
        MiniGameBeaconReport.reportSync(str, map);
    }

    @Override // com.tencent.mobileqq.minigame.api.report.IMiniGameReport
    public void accountUpdateReport(AppRuntime app) {
        Intrinsics.checkNotNullParameter(app, "app");
        if (app instanceof QQAppInterface) {
            MiniGameHomeReportService.INSTANCE.recordAccountUpdate();
        } else {
            QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.NOTIFY_HOME_REPORT_ACCOUNT_CHANGE, null, null);
        }
    }

    @Override // com.tencent.mobileqq.minigame.api.report.IMiniGameReport
    public void clickReportMiniGameFromLeba(BusinessInfoCheckUpdate.AppInfo appInfo) {
        MiniGameLebaReporter.INSTANCE.reportFromLebaAsync(appInfo, true);
    }

    @Override // com.tencent.mobileqq.minigame.api.report.IMiniGameReport
    public void exposeReportForHome() {
        MiniGameHomeReportService.INSTANCE.reportHomeAppearEvent();
    }

    @Override // com.tencent.mobileqq.minigame.api.report.IMiniGameReport
    public void exposeReportMiniGameFromLeba(BusinessInfoCheckUpdate.AppInfo appInfo) {
        MiniGameLebaReporter.INSTANCE.reportFromLebaAsync(appInfo, false);
        MiniAppUtils.reportMiniGameCenterDC00087("1", "969", "9043", "904301", "209625", "8", "active");
    }

    @Override // com.tencent.mobileqq.minigame.api.report.IMiniGameReport
    public void reportStartup(final String eventName, final Map<String, String> reportMap) {
        if (eventName == null || reportMap == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: z82.b
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameReportImpl.reportStartup$lambda$0(eventName, reportMap);
            }
        }, 160, null, false);
    }

    @Override // com.tencent.mobileqq.minigame.api.report.IMiniGameReport
    public void reportToBeacon(final String eventName, final Map<String, String> reportMap) {
        if (eventName == null || reportMap == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: z82.a
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameBeaconReport.reportToBeacon(eventName, reportMap);
            }
        }, 160, null, false);
    }
}
