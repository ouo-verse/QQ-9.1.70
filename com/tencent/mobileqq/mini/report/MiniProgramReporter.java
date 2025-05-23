package com.tencent.mobileqq.mini.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER;
import NS_MINI_REPORT.REPORT$SingleDcData;
import NS_MINI_REPORT.REPORT$StDcReportReq;
import android.os.Handler;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppDcReportServlet;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class MiniProgramReporter {
    private static final int INTENT_EXTRA_LIMITATION_IN_BYTE = 262144;
    private static final int REPORT_COUNT_THRESHOLD = 64;
    private static final int REPORT_COUNT_THRESHOLD_FOR_GAME_CP_REPORT = 1;
    private static final int REPORT_COUNT_THRESHOLD_FOR_SUBSCRIBE_REPORT = 5;
    private static final int REPORT_COUNT_THRESHOLD_FOR_THIRD_PARTY = 1;
    private static final String TAG = "MiniProgramReporter";
    private static final boolean VERBOSE = false;
    private static final MiniProgramReporter ourInstance = new MiniProgramReporter();
    private Handler reportHandler;
    private long lastReportTimeMillis = System.currentTimeMillis();
    private long lastReportLaunchDcDataTime = System.currentTimeMillis();
    private boolean reportLaunchNeedflush = false;
    private List<APP_REPORT_TRANSFER.SingleDcData> singleDcDataListPool = new ArrayList();
    private List<APP_REPORT_TRANSFER.SingleDcData> launchDcDataList = new ArrayList();
    private long lastMiniApiReportTimeMillis = System.currentTimeMillis();
    private long lastSubscribeReportTimeMillis = System.currentTimeMillis();
    private List<REPORT$SingleDcData> apiReportDcDataListPool = new ArrayList();
    private List<REPORT$SingleDcData> thirdPartyDcDataListPool = new ArrayList();
    private List<REPORT$SingleDcData> subscribeDcDataListPool = new ArrayList();
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
        long currentTimeMillis = System.currentTimeMillis() - this.lastMiniApiReportTimeMillis;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        if (currentTimeMillis > timeUnit.toMillis(600L) || this.apiReportDcDataListPool.size() >= 64) {
            performReportApiReportToServer();
        }
        if (System.currentTimeMillis() - this.lastSubscribeReportTimeMillis > timeUnit.toMillis(180L) || this.subscribeDcDataListPool.size() >= 5) {
            performSubscribeReportToServer();
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
        return System.currentTimeMillis() - this.lastReportTimeMillis > TimeUnit.SECONDS.toMillis(600L);
    }

    private void performGameCPReportToServer() {
        if (this.gameCPReportDcDataListPool.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.gameCPReportDcDataListPool);
        this.gameCPReportDcDataListPool.clear();
        byte[] byteArray = MiniProgramReportHelper.newDataReportReq(arrayList).toByteArray();
        if (byteArray.length > 0) {
            performDataReportViaSSO(byteArray, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performReportApiReportToServer() {
        byte[] bArr;
        List<REPORT$SingleDcData> subList;
        REPORT$StDcReportReq newDcReportReq;
        this.lastMiniApiReportTimeMillis = System.currentTimeMillis();
        if (this.apiReportDcDataListPool.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.apiReportDcDataListPool);
        this.apiReportDcDataListPool.clear();
        REPORT$StDcReportReq newDcReportReq2 = MiniProgramReportHelper.newDcReportReq(arrayList);
        if (newDcReportReq2 != null) {
            try {
                bArr = newDcReportReq2.toByteArray();
            } catch (Exception e16) {
                QLog.e(TAG, 2, "performReportToServer", e16);
                bArr = null;
            }
            if (bArr == null) {
                return;
            }
            if (bArr.length <= 262144) {
                performReportViaSSO(bArr, arrayList, MiniAppDcReportServlet.CMD_STRING_MINI_LOG);
                return;
            }
            int length = (bArr.length / 262144) + 1;
            int size = arrayList.size() / length;
            QLog.d(TAG, 2, "performReportToServer: split into " + length + " count");
            int i3 = 0;
            int i16 = size;
            while (i16 <= arrayList.size()) {
                if (i3 < i16 && i3 >= 0 && i16 <= arrayList.size() && (newDcReportReq = MiniProgramReportHelper.newDcReportReq((subList = arrayList.subList(i3, i16)))) != null) {
                    performReportViaSSO(newDcReportReq.toByteArray(), subList, MiniAppDcReportServlet.CMD_STRING_MINI_LOG);
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

    private void performReportLaunchDcDataToServer() {
        byte[] bArr;
        List<APP_REPORT_TRANSFER.SingleDcData> subList;
        APP_REPORT_TRANSFER.StDataReportReq newDataReportReq;
        this.lastReportLaunchDcDataTime = System.currentTimeMillis();
        if (this.launchDcDataList.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.launchDcDataList);
        MiniAppReportManager.recordReportItemToDB(arrayList);
        this.launchDcDataList.clear();
        APP_REPORT_TRANSFER.StDataReportReq newDataReportReq2 = MiniProgramReportHelper.newDataReportReq(arrayList);
        if (newDataReportReq2 != null) {
            try {
                bArr = newDataReportReq2.toByteArray();
            } catch (Exception e16) {
                QLog.e(TAG, 2, "performReportLaunchDcDataToServer", e16);
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
            QLog.d(TAG, 2, "performReportLaunchDcDataToServer: split into " + length + " count");
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

    /* JADX INFO: Access modifiers changed from: private */
    public void performReportToServer() {
        byte[] bArr;
        List<APP_REPORT_TRANSFER.SingleDcData> subList;
        APP_REPORT_TRANSFER.StDataReportReq newDataReportReq;
        this.lastReportTimeMillis = System.currentTimeMillis();
        if (this.singleDcDataListPool.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.singleDcDataListPool);
        this.singleDcDataListPool.clear();
        APP_REPORT_TRANSFER.StDataReportReq newDataReportReq2 = MiniProgramReportHelper.newDataReportReq(arrayList);
        if (newDataReportReq2 != null) {
            try {
                bArr = newDataReportReq2.toByteArray();
            } catch (Exception e16) {
                QLog.e(TAG, 2, "performReportToServer", e16);
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
            QLog.d(TAG, 2, "performReportToServer: split into " + length + " count");
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

    private void performSubscribeReportToServer() {
        byte[] bArr;
        List<REPORT$SingleDcData> subList;
        REPORT$StDcReportReq newDcReportReq;
        this.lastSubscribeReportTimeMillis = System.currentTimeMillis();
        if (this.subscribeDcDataListPool.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.subscribeDcDataListPool);
        this.subscribeDcDataListPool.clear();
        REPORT$StDcReportReq newDcReportReq2 = MiniProgramReportHelper.newDcReportReq(arrayList);
        if (newDcReportReq2 != null) {
            try {
                bArr = newDcReportReq2.toByteArray();
            } catch (Exception e16) {
                QLog.e(TAG, 2, "performReportToServer", e16);
                bArr = null;
            }
            if (bArr == null) {
                return;
            }
            if (bArr.length <= 262144) {
                performReportViaSSO(bArr, arrayList, MiniAppDcReportServlet.CMD_STRING);
                QLog.d(TAG, 2, "performSubscribeReportToServer via SSO");
                return;
            }
            int length = (bArr.length / 262144) + 1;
            int size = arrayList.size() / length;
            QLog.d(TAG, 2, "performSubscribeReportToServer: split into " + length + " count");
            int i3 = 0;
            int i16 = size;
            while (i16 <= arrayList.size()) {
                if (i3 < i16 && i3 >= 0 && i16 <= arrayList.size() && (newDcReportReq = MiniProgramReportHelper.newDcReportReq((subList = arrayList.subList(i3, i16)))) != null) {
                    performReportViaSSO(newDcReportReq.toByteArray(), subList, MiniAppDcReportServlet.CMD_STRING);
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

    private void performThirdPartyReportToServer() {
        if (this.thirdPartyDcDataListPool.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.thirdPartyDcDataListPool);
        this.thirdPartyDcDataListPool.clear();
        byte[] byteArray = MiniProgramReportHelper.newThirdDcReportReq(arrayList).toByteArray();
        if (byteArray.length > 0) {
            performReportViaSSO(byteArray, arrayList, MiniAppDcReportServlet.CMD_STRING_THIRD_PARTY_REPORT);
        }
    }

    private static String prettyDataJSONString(APP_REPORT_TRANSFER.SingleDcData singleDcData) {
        StringBuilder sb5 = new StringBuilder();
        if (singleDcData != null) {
            sb5.append(JSONUtils.a(singleDcData));
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String prettyJSONString(REPORT$SingleDcData rEPORT$SingleDcData) {
        StringBuilder sb5 = new StringBuilder();
        if (rEPORT$SingleDcData != null) {
            sb5.append(JSONUtils.a(rEPORT$SingleDcData));
        }
        return sb5.toString();
    }

    public void add(final REPORT$SingleDcData rEPORT$SingleDcData) {
        this.reportHandler.post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramReporter.3
            @Override // java.lang.Runnable
            public void run() {
                if (rEPORT$SingleDcData.dcid.get() == 4) {
                    MiniProgramReporter.this.thirdPartyDcDataListPool.add(rEPORT$SingleDcData);
                } else if (rEPORT$SingleDcData.dcid.get() == 9) {
                    MiniProgramReporter.this.apiReportDcDataListPool.add(rEPORT$SingleDcData);
                } else if (rEPORT$SingleDcData.dcid.get() == 5) {
                    MiniProgramReporter.this.subscribeDcDataListPool.add(rEPORT$SingleDcData);
                } else {
                    QLog.e(MiniProgramReporter.TAG, 1, " should not report by dcReport " + MiniProgramReporter.prettyJSONString(rEPORT$SingleDcData));
                }
                MiniProgramReporter.this.checkShouldReportToServer();
            }
        });
    }

    public void addAll(final Collection<? extends REPORT$SingleDcData> collection) {
        this.reportHandler.post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramReporter.6
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
        this.reportHandler.post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramReporter.5
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
        this.reportHandler.post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramReporter.7
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

    public void batchAddAll(final List<APP_REPORT_TRANSFER.SingleDcData> list) {
        this.reportHandler.post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramReporter.4
            @Override // java.lang.Runnable
            public void run() {
                List list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    return;
                }
                if (((APP_REPORT_TRANSFER.SingleDcData) list.get(0)).dcid.get() == 7) {
                    MiniProgramReporter.this.gameCPReportDcDataListPool.addAll(list);
                } else {
                    MiniProgramReporter.this.singleDcDataListPool.addAll(list);
                }
                MiniProgramReporter.this.checkShouldReportToServer();
            }
        });
    }

    public void checkLaunchDcDataConditionAndReport() {
        int i3 = 10;
        int i16 = 64;
        try {
            i3 = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_report_time_threshold", 10);
            i16 = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_report_count_threshold", 64);
        } catch (Exception unused) {
        }
        if (System.currentTimeMillis() - this.lastReportLaunchDcDataTime > TimeUnit.SECONDS.toMillis(i3 * 60) || this.launchDcDataList.size() >= i16 || this.reportLaunchNeedflush) {
            reportImmediatelyLaunchDcData();
            this.reportLaunchNeedflush = false;
        }
    }

    public void flush() {
        this.reportHandler.post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramReporter.8
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

    private void performDataReportViaSSO(byte[] bArr, final List<APP_REPORT_TRANSFER.SingleDcData> list) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        MiniAppCmdUtil.getInstance().performDataReport(bArr, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.report.MiniProgramReporter.2
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                if (z16) {
                    QLog.d(MiniProgramReporter.TAG, 2, "performDataReportViaSSO  onDcReport() called with: isSuc = [true], ret = [" + jSONObject + "]");
                    return;
                }
                QLog.e(MiniProgramReporter.TAG, 1, "performDataReportViaSSO onDcReport: sso command failed, try again");
                MiniProgramReporter.this.addDataAll(list);
            }
        });
    }

    private void performReportViaSSO(byte[] bArr, final List<REPORT$SingleDcData> list, String str) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        MiniAppCmdUtil.getInstance().performReport(bArr, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.report.MiniProgramReporter.1
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                if (z16) {
                    return;
                }
                QLog.e(MiniProgramReporter.TAG, 1, "performReportViaSSO onDcReport: sso command failed, try again");
                MiniProgramReporter.this.addAll(list);
            }
        }, str);
    }
}
