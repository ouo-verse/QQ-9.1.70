package com.tencent.qqmini.sdk.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER;
import NS_MINI_REPORT.REPORT$SingleDcData;
import NS_MINI_REPORT.REPORT$StDcReportReq;
import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.RequestServer;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.JSONUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class MiniProgramReporter {
    private static final int INTENT_EXTRA_LIMITATION_IN_BYTE = 262144;
    private static final int REPORT_COUNT_THRESHOLD = 64;
    private static final int REPORT_COUNT_THRESHOLD_FOR_GAME_CP_REPORT = 1;
    private static final int REPORT_COUNT_THRESHOLD_FOR_THIRD_PARTY = 1;
    private static final String TAG = "MiniProgramReporter";
    private static final MiniProgramReporter ourInstance = new MiniProgramReporter();
    private Handler reportHandler;
    private long lastReportTimeMillis = System.currentTimeMillis();
    private long lastReportLaunchDcDataTime = System.currentTimeMillis();
    private boolean reportLaunchNeedflush = false;
    private List<APP_REPORT_TRANSFER.SingleDcData> singleDcDataListPool = new ArrayList();
    private List<APP_REPORT_TRANSFER.SingleDcData> launchDcDataList = new ArrayList();
    private long lastMiniApiReportTimeMillis = System.currentTimeMillis();
    private List<REPORT$SingleDcData> apiReportDcDataListPool = new ArrayList();
    private List<REPORT$SingleDcData> thirdPartyDcDataListPool = new ArrayList();
    private List<APP_REPORT_TRANSFER.SingleDcData> gameCPReportDcDataListPool = new ArrayList();
    private Map<String, String> launchedMiniAppMap = new HashMap();

    MiniProgramReporter() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("mini_program_report");
        baseHandlerThread.setPriority(10);
        baseHandlerThread.start();
        this.reportHandler = new Handler(baseHandlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkShouldReportToServer() {
        if (intervalBetweenNowAndLastReportTimeGreaterThan10Minutes() || this.singleDcDataListPool.size() >= 64) {
            performReportToServer();
        }
        if (System.currentTimeMillis() - this.lastMiniApiReportTimeMillis > TimeUnit.SECONDS.toMillis(600L) || this.apiReportDcDataListPool.size() >= 64) {
            performReportApiReportToServer();
        }
        if (this.thirdPartyDcDataListPool.size() >= 1) {
            performThirdPartyReportToServer();
        }
        if (this.gameCPReportDcDataListPool.size() >= 1) {
            performGameCPReportToServer();
        }
    }

    public static MiniProgramReporter getInstance() {
        return ourInstance;
    }

    private boolean intervalBetweenNowAndLastReportTimeGreaterThan10Minutes() {
        if (System.currentTimeMillis() - this.lastReportTimeMillis > TimeUnit.SECONDS.toMillis(600L)) {
            return true;
        }
        return false;
    }

    private void performDataReportViaSSO(byte[] bArr, List<APP_REPORT_TRANSFER.SingleDcData> list) {
        if (bArr != null && bArr.length > 0) {
            RequestServer.getInstance().dataReport(bArr, null);
        }
    }

    private void performGameCPReportToServer() {
        if (!this.gameCPReportDcDataListPool.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.gameCPReportDcDataListPool);
            this.gameCPReportDcDataListPool.clear();
            byte[] byteArray = MiniProgramReportHelper.newDataReportReq(arrayList).toByteArray();
            if (byteArray.length > 0) {
                performDataReportViaSSO(byteArray, arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performReportApiReportToServer() {
        byte[] bArr;
        List<REPORT$SingleDcData> subList;
        REPORT$StDcReportReq newDcReportReq;
        this.lastMiniApiReportTimeMillis = System.currentTimeMillis();
        if (!this.apiReportDcDataListPool.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.apiReportDcDataListPool);
            this.apiReportDcDataListPool.clear();
            REPORT$StDcReportReq newDcReportReq2 = MiniProgramReportHelper.newDcReportReq(arrayList);
            if (newDcReportReq2 != null) {
                try {
                    bArr = newDcReportReq2.toByteArray();
                } catch (Exception e16) {
                    QMLog.e(TAG, "performReportToServer", e16);
                    bArr = null;
                }
                if (bArr == null) {
                    return;
                }
                if (bArr.length <= 262144) {
                    performReportViaSSO(bArr, arrayList, "mini_app_apireport", "DcReport");
                    return;
                }
                int length = (bArr.length / 262144) + 1;
                int size = arrayList.size() / length;
                QMLog.d(TAG, "performReportToServer: split into " + length + " count");
                int i3 = 0;
                int i16 = size;
                while (i16 <= arrayList.size()) {
                    if (i3 < i16 && i3 >= 0 && i16 <= arrayList.size() && (newDcReportReq = MiniProgramReportHelper.newDcReportReq((subList = arrayList.subList(i3, i16)))) != null) {
                        performReportViaSSO(newDcReportReq.toByteArray(), subList, "mini_app_apireport", "DcReport");
                    }
                    int i17 = i16 + size;
                    if (i17 > arrayList.size()) {
                        i17 = arrayList.size();
                    }
                    int i18 = i17;
                    i3 = i16;
                    i16 = i18;
                }
            }
        }
    }

    private void performReportLaunchDcDataToServer() {
        byte[] bArr;
        List<APP_REPORT_TRANSFER.SingleDcData> subList;
        APP_REPORT_TRANSFER.StDataReportReq newDataReportReq;
        this.lastReportLaunchDcDataTime = System.currentTimeMillis();
        if (!this.launchDcDataList.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.launchDcDataList);
            this.launchDcDataList.clear();
            APP_REPORT_TRANSFER.StDataReportReq newDataReportReq2 = MiniProgramReportHelper.newDataReportReq(arrayList);
            if (newDataReportReq2 != null) {
                try {
                    bArr = newDataReportReq2.toByteArray();
                } catch (Exception e16) {
                    QMLog.e(TAG, "performReportLaunchDcDataToServer", e16);
                    bArr = null;
                }
                if (bArr == null) {
                    return;
                }
                if (bArr.length <= 262144) {
                    performDataReportViaSSO(bArr, arrayList);
                    return;
                }
                int length = (bArr.length / 262144) + 1;
                int size = arrayList.size() / length;
                QMLog.d(TAG, "performReportLaunchDcDataToServer: split into " + length + " count");
                int i3 = 0;
                int i16 = size;
                while (i16 <= arrayList.size()) {
                    if (i3 < i16 && i3 >= 0 && i16 <= arrayList.size() && (newDataReportReq = MiniProgramReportHelper.newDataReportReq((subList = arrayList.subList(i3, i16)))) != null) {
                        performDataReportViaSSO(newDataReportReq.toByteArray(), subList);
                    }
                    int i17 = i16 + size;
                    if (i17 > arrayList.size()) {
                        i17 = arrayList.size();
                    }
                    int i18 = i17;
                    i3 = i16;
                    i16 = i18;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performReportToServer() {
        byte[] bArr;
        List<APP_REPORT_TRANSFER.SingleDcData> subList;
        APP_REPORT_TRANSFER.StDataReportReq newDataReportReq;
        this.lastReportTimeMillis = System.currentTimeMillis();
        if (!this.singleDcDataListPool.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.singleDcDataListPool);
            this.singleDcDataListPool.clear();
            APP_REPORT_TRANSFER.StDataReportReq newDataReportReq2 = MiniProgramReportHelper.newDataReportReq(arrayList);
            if (newDataReportReq2 != null) {
                try {
                    bArr = newDataReportReq2.toByteArray();
                } catch (Exception e16) {
                    QMLog.e(TAG, "performReportToServer", e16);
                    bArr = null;
                }
                if (bArr == null) {
                    return;
                }
                if (bArr.length <= 262144) {
                    performDataReportViaSSO(bArr, arrayList);
                    return;
                }
                int length = (bArr.length / 262144) + 1;
                int size = arrayList.size() / length;
                QMLog.d(TAG, "performReportToServer: split into " + length + " count");
                int i3 = 0;
                int i16 = size;
                while (i16 <= arrayList.size()) {
                    if (i3 < i16 && i3 >= 0 && i16 <= arrayList.size() && (newDataReportReq = MiniProgramReportHelper.newDataReportReq((subList = arrayList.subList(i3, i16)))) != null) {
                        performDataReportViaSSO(newDataReportReq.toByteArray(), subList);
                    }
                    int i17 = i16 + size;
                    if (i17 > arrayList.size()) {
                        i17 = arrayList.size();
                    }
                    int i18 = i17;
                    i3 = i16;
                    i16 = i18;
                }
            }
        }
    }

    private void performReportViaSSO(byte[] bArr, final List<REPORT$SingleDcData> list, String str, String str2) {
        if (bArr != null && bArr.length > 0) {
            ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).report(bArr, str, str2, new AsyncResult() { // from class: com.tencent.qqmini.sdk.report.MiniProgramReporter.1
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                    if (z16) {
                        QMLog.d(MiniProgramReporter.TAG, "onDcReport() called with: isSuc = [true], ret = [" + jSONObject + "]");
                        return;
                    }
                    QMLog.e(MiniProgramReporter.TAG, "performReportViaSSO onDcReport: sso command failed, try again");
                    MiniProgramReporter.this.addAll(list);
                }
            });
        }
    }

    private void performThirdPartyReportToServer() {
        if (!this.thirdPartyDcDataListPool.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.thirdPartyDcDataListPool);
            this.thirdPartyDcDataListPool.clear();
            byte[] byteArray = MiniProgramReportHelper.newThirdDcReportReq(arrayList).toByteArray();
            if (byteArray.length > 0) {
                performReportViaSSO(byteArray, arrayList, "mini_app_dcreport", "ThirdDcReport");
            }
        }
    }

    private static String prettyDataJSONString(APP_REPORT_TRANSFER.SingleDcData singleDcData) {
        StringBuilder sb5 = new StringBuilder();
        if (singleDcData != null) {
            sb5.append(JSONUtils.convert2JSON(singleDcData));
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String prettyJSONString(REPORT$SingleDcData rEPORT$SingleDcData) {
        StringBuilder sb5 = new StringBuilder();
        if (rEPORT$SingleDcData != null) {
            sb5.append(JSONUtils.convert2JSON(rEPORT$SingleDcData));
        }
        return sb5.toString();
    }

    public void add(final REPORT$SingleDcData rEPORT$SingleDcData) {
        this.reportHandler.post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.MiniProgramReporter.2
            @Override // java.lang.Runnable
            public void run() {
                if (rEPORT$SingleDcData.dcid.get() == 4) {
                    MiniProgramReporter.this.thirdPartyDcDataListPool.add(rEPORT$SingleDcData);
                } else if (rEPORT$SingleDcData.dcid.get() == 9) {
                    MiniProgramReporter.this.apiReportDcDataListPool.add(rEPORT$SingleDcData);
                } else {
                    QMLog.e(MiniProgramReporter.TAG, " should not report by dcReport " + MiniProgramReporter.prettyJSONString(rEPORT$SingleDcData));
                }
                MiniProgramReporter.this.checkShouldReportToServer();
            }
        });
    }

    public void addAll(final Collection<? extends REPORT$SingleDcData> collection) {
        this.reportHandler.post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.MiniProgramReporter.4
            @Override // java.lang.Runnable
            public void run() {
                Collection collection2 = collection;
                if (collection2 != null) {
                    Iterator it = collection2.iterator();
                    while (it.hasNext()) {
                        MiniProgramReporter.this.add((REPORT$SingleDcData) it.next());
                    }
                }
                MiniProgramReporter.this.checkShouldReportToServer();
            }
        });
    }

    public void addData(final APP_REPORT_TRANSFER.SingleDcData singleDcData) {
        this.reportHandler.post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.MiniProgramReporter.3
            @Override // java.lang.Runnable
            public void run() {
                if (singleDcData.dcid.get() == 7) {
                    MiniProgramReporter.this.gameCPReportDcDataListPool.add(singleDcData);
                } else {
                    MiniProgramReporter.this.singleDcDataListPool.add(singleDcData);
                }
                MiniProgramReporter.this.checkShouldReportToServer();
            }
        });
    }

    public void addDataAll(final Collection<? extends APP_REPORT_TRANSFER.SingleDcData> collection) {
        this.reportHandler.post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.MiniProgramReporter.5
            @Override // java.lang.Runnable
            public void run() {
                Collection collection2 = collection;
                if (collection2 != null) {
                    Iterator it = collection2.iterator();
                    while (it.hasNext()) {
                        MiniProgramReporter.this.addData((APP_REPORT_TRANSFER.SingleDcData) it.next());
                    }
                }
                MiniProgramReporter.this.checkShouldReportToServer();
            }
        });
    }

    public synchronized void addDcData(APP_REPORT_TRANSFER.SingleDcData singleDcData) {
        this.launchDcDataList.add(singleDcData);
        checkLaunchDcDataConditionAndReport();
    }

    public void addLaunchMiniAppRecord(String str, String str2) {
        this.launchedMiniAppMap.put(str, str2);
    }

    public void checkLaunchDcDataConditionAndReport() {
        int i3 = 10;
        int i16 = 64;
        try {
            i3 = WnsConfig.getConfig("qqminiapp", "mini_app_report_time_threshold", 10);
            i16 = WnsConfig.getConfig("qqminiapp", "mini_app_report_count_threshold", 64);
        } catch (Exception unused) {
        }
        if (System.currentTimeMillis() - this.lastReportLaunchDcDataTime > TimeUnit.SECONDS.toMillis(i3 * 60) || this.launchDcDataList.size() >= i16 || this.reportLaunchNeedflush) {
            reportImmediatelyLaunchDcData();
            this.reportLaunchNeedflush = false;
        }
    }

    public void flush() {
        this.reportHandler.post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.MiniProgramReporter.6
            @Override // java.lang.Runnable
            public void run() {
                MiniProgramReporter.this.performReportToServer();
                MiniProgramReporter.this.performReportApiReportToServer();
            }
        });
    }

    public String getLaunchMiniAppRecord(String str) {
        return this.launchedMiniAppMap.get(str);
    }

    public Handler getReportHandler() {
        return this.reportHandler;
    }

    public void removeLaunchMiniAppRecord(String str) {
        this.launchedMiniAppMap.remove(str);
    }

    public void reportImmediatelyLaunchDcData() {
        performReportLaunchDcDataToServer();
    }

    public void setReportLaunchNeedflush(boolean z16) {
        this.reportLaunchNeedflush = z16;
    }
}
