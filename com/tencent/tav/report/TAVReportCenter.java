package com.tencent.tav.report;

import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.beacon.event.open.BeaconConfig;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventResult;
import com.tencent.qimei.sdk.IAsyncQimeiListener;
import com.tencent.qimei.sdk.Qimei;
import com.tencent.tav.BuildConfig;
import com.tencent.tav.decoder.logger.Logger;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVReportCenter {
    private static final String APP_KEY = "0DOU0EN8HI4QHFFX";
    public static final String REPORT_VERSION = "3.4.5.130";
    private static final String TAG = "TAVReportCenter";
    private static boolean beaconEnable = true;

    @Nullable
    private static IReportDelegate reportDelegate;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface IReportDelegate {
        boolean onReport(String str, String str2, HashMap<String, String> hashMap);
    }

    public static void commit(ReportBean reportBean) {
        IReportDelegate iReportDelegate = reportDelegate;
        if (iReportDelegate != null && iReportDelegate.onReport(APP_KEY, reportBean.event, reportBean.extractReportData())) {
            return;
        }
        if (!beaconEnable) {
            Logger.w(TAG, "commit: beaconEnable is false");
            return;
        }
        try {
            doCommit(reportBean);
        } catch (Throwable th5) {
            Logger.e(TAG, "commit: ", th5);
        }
    }

    public static void disableBeaconReport() {
        beaconEnable = false;
    }

    private static void doCommit(ReportBean reportBean) throws Throwable {
        Logger.d(TAG, "doCommit() called with: avf version = 3.4.5.130, bean = [" + reportBean + "]");
        EventResult report = BeaconReport.getInstance().report(BeaconEvent.builder().withCode(reportBean.event).withParams(reportBean.extractReportData()).withAppKey(APP_KEY).build());
        if (!report.isSuccess()) {
            Logger.e(TAG, "commit: fail, code = " + report.errorCode, new RuntimeException(report.errMsg));
        }
    }

    private static void doInitBeaconReport(Context context) throws Throwable {
        BeaconReport beaconReport = BeaconReport.getInstance();
        beaconReport.setAppVersion("3.4.5.130");
        beaconReport.setLogAble(BuildConfig.DEBUG);
        beaconReport.start(context, APP_KEY, BeaconConfig.builder().build());
        beaconReport.getQimei(new IAsyncQimeiListener() { // from class: com.tencent.tav.report.TAVReportCenter.1
            @Override // com.tencent.qimei.sdk.IAsyncQimeiListener
            public void onQimeiDispatch(Qimei qimei) {
                Logger.i(TAVReportCenter.TAG, "getQimei36: " + qimei.getQimei36() + ", getQimei36: " + qimei.getQimei16());
            }
        });
    }

    public static void initBeaconReport(Context context) {
        if (!beaconEnable) {
            Logger.w(TAG, "initBeaconReport: beaconEnable is false");
            return;
        }
        Logger.i(TAG, "initBeaconReport() called with: context = [" + context + "]");
        try {
            doInitBeaconReport(context);
        } catch (Throwable th5) {
            Logger.e(TAG, "doInitBeaconReport: ", th5);
        }
    }

    public static void setReportDelegate(@Nullable IReportDelegate iReportDelegate) {
        reportDelegate = iReportDelegate;
    }

    @Deprecated
    public static void init(Context context) {
    }
}
