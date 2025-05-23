package com.tencent.ad.tangram.analysis;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteEntry;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteUtil;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.config.AdConfigManager;
import com.tencent.ad.tangram.config.data.AdConfigForAnalysisReport;
import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.privacy.AdPrivacyPolicyManager;
import com.tencent.ad.tangram.protocol.gdt_analysis_request;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdUriUtil;
import com.tencent.ad.tangram.version.AdVersion;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdAnalysis {
    private static final String TAG = "AdAnalysis";
    private static volatile AdAnalysis sInstance;
    private volatile boolean reporting = false;

    AdAnalysis() {
    }

    private boolean canReportForAnalysisWithoutABTest() {
        return AdConfigManager.getInstance().canReportForAnalysisWithoutABTest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canReportWithABTest() {
        return AdConfigManager.getInstance().canReportForAnalysisWithABTest();
    }

    public static AdAnalysis getInstance() {
        if (sInstance == null) {
            synchronized (AdAnalysis.class) {
                if (sInstance == null) {
                    sInstance = new AdAnalysis();
                }
            }
        }
        return sInstance;
    }

    private int getLimit() {
        int i3;
        AdConfigForAnalysisReport.Batch batch;
        AdConfigForAnalysisReport configForAnalysisReport = AdConfigManager.getInstance().getConfigForAnalysisReport();
        if (configForAnalysisReport != null && (batch = configForAnalysisReport.batch) != null) {
            i3 = batch.limit;
        } else {
            i3 = 0;
        }
        AdLog.d(TAG, "[getLimit] limit:" + i3);
        return i3;
    }

    private String getUrl() {
        AdConfigForAnalysisReport configForAnalysisReport = AdConfigManager.getInstance().getConfigForAnalysisReport();
        if (configForAnalysisReport != null) {
            return configForAnalysisReport.urlForReport;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isEnabled() {
        return AdConfigManager.getInstance().isReportForAnalysisEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void report(@Nullable WeakReference<Context> weakReference) {
        if (this.reporting) {
            return;
        }
        synchronized (this) {
            if (this.reporting) {
                return;
            }
            this.reporting = true;
            reportInternal(weakReference);
            synchronized (this) {
                this.reporting = false;
            }
        }
    }

    private void reportInternal(@Nullable final WeakReference<Context> weakReference) {
        Context context;
        if (!isEnabled()) {
            AdLog.d(TAG, "[reportInternal] do nothing, not enabled");
            return;
        }
        boolean canReportWithABTest = canReportWithABTest();
        boolean canReportForAnalysisWithoutABTest = canReportForAnalysisWithoutABTest();
        AdLog.d(TAG, "[reportInternal] canReportWithABTest:" + canReportWithABTest + " canReportForAnalysisWithoutABTest:" + canReportForAnalysisWithoutABTest);
        if (!canReportWithABTest && !canReportForAnalysisWithoutABTest) {
            return;
        }
        if (weakReference != null) {
            context = weakReference.get();
        } else {
            context = null;
        }
        int limit = getLimit();
        List<AdAnalysisSQLiteEntry> query = AdAnalysisSQLiteUtil.query(context, limit);
        if (query != null && !query.isEmpty()) {
            if (query.get(0).strategy <= 101 || query.size() >= limit || System.currentTimeMillis() - query.get(query.size() - 1).timeMillis >= 1800000) {
                if (send(weakReference, getUrl(), query) && AdAnalysisSQLiteUtil.delete(context, query)) {
                    AdThreadManager.getInstance().postDelayed(new Runnable() { // from class: com.tencent.ad.tangram.analysis.AdAnalysis.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AdAnalysis.this.report(weakReference);
                        }
                    }, 4, 60000L);
                } else {
                    AdThreadManager.getInstance().postDelayed(new Runnable() { // from class: com.tencent.ad.tangram.analysis.AdAnalysis.3
                        @Override // java.lang.Runnable
                        public void run() {
                            AdAnalysis.this.report(weakReference);
                        }
                    }, 4, MiniBoxNoticeInfo.MIN_5);
                }
            }
        }
    }

    public void handleAsync(WeakReference<Context> weakReference, @Nullable AdAnalysisEvent adAnalysisEvent) {
        if (adAnalysisEvent != null && adAnalysisEvent.isValid()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(adAnalysisEvent);
            handleAsync(weakReference, arrayList);
            return;
        }
        AdLog.e(TAG, "handleAsync error");
    }

    public boolean send(@Nullable WeakReference<Context> weakReference, @Nullable String str, @Nullable List<AdAnalysisSQLiteEntry> list) {
        gdt_analysis_request createRequest;
        Object fromObject;
        byte[] bytes;
        if (!AdPrivacyPolicyManager.getInstance().isAllowed()) {
            AdLog.e(TAG, "send not allowed");
            return false;
        }
        String replaceHttpsWithHttpForVivoY67OnAndroidM = AdUriUtil.replaceHttpsWithHttpForVivoY67OnAndroidM(str);
        AdLog.i(TAG, String.format("send %s", replaceHttpsWithHttpForVivoY67OnAndroidM));
        if (weakReference != null) {
            try {
                if (!TextUtils.isEmpty(replaceHttpsWithHttpForVivoY67OnAndroidM) && (createRequest = AdAnalysisUtil.createRequest(weakReference.get(), AdAnalysisUtil.createBody(list), AdVersion.getInstance().getAppVersion())) != null && (fromObject = AdJSON.fromObject(createRequest)) != null) {
                    String obj = fromObject.toString();
                    if (!TextUtils.isEmpty(obj) && (bytes = obj.getBytes()) != null) {
                        AdHttp.Params params = new AdHttp.Params();
                        params.setUrl(replaceHttpsWithHttpForVivoY67OnAndroidM);
                        params.method = "POST";
                        params.contentType = "application/json";
                        params.requestData = bytes;
                        params.connectTimeoutMillis = 3000;
                        params.readTimeoutMillis = 3000;
                        if (params.canSend()) {
                            AdHttp.send(params);
                            if (params.responseCode == 200) {
                                return true;
                            }
                        }
                    }
                }
            } catch (Throwable th5) {
                AdLog.e(TAG, "send", th5);
            }
        }
        return false;
    }

    public void handleAsync(@Nullable WeakReference<Context> weakReference, @Nullable final List<AdAnalysisEvent> list) {
        Context context;
        Context applicationContext;
        if (list != null && !list.isEmpty()) {
            if (!AdPrivacyPolicyManager.getInstance().isAllowed()) {
                AdLog.e(TAG, "handleAsync not allowed");
                return;
            }
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(list.size());
            final WeakReference weakReference2 = null;
            objArr[1] = (list.size() != 1 || list.get(0) == null) ? null : list.get(0).getId();
            AdLog.d(TAG, String.format("handleAsync size:%d eventId:%s", objArr));
            if (weakReference != null && (context = weakReference.get()) != null && (applicationContext = context.getApplicationContext()) != null) {
                weakReference2 = new WeakReference(applicationContext);
            }
            if (weakReference2 == null) {
                AdLog.e(TAG, "handleAsync error");
                return;
            } else {
                AdThreadManager.getInstance().postDelayed(new Runnable() { // from class: com.tencent.ad.tangram.analysis.AdAnalysis.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AdAnalysis.this.isEnabled()) {
                            boolean canReportWithABTest = AdAnalysis.this.canReportWithABTest();
                            if (weakReference2.get() == null) {
                                return;
                            }
                            boolean z16 = false;
                            for (AdAnalysisEvent adAnalysisEvent : list) {
                                if (adAnalysisEvent != null && adAnalysisEvent.isValid()) {
                                    if (adAnalysisEvent.getStrategy() == 103 || canReportWithABTest) {
                                        AdAnalysisSQLiteUtil.insert((Context) weakReference2.get(), new AdAnalysisSQLiteEntry(adAnalysisEvent));
                                        z16 = true;
                                    }
                                } else {
                                    AdLog.e(AdAnalysis.TAG, "handleAsync error");
                                    break;
                                }
                            }
                            AdLog.d(AdAnalysis.TAG, "[handleAsync] canReportWithABTest:" + canReportWithABTest + " inserted:" + z16);
                            if (z16) {
                                AdAnalysis.this.report(weakReference2);
                                return;
                            }
                            return;
                        }
                        AdLog.d(AdAnalysis.TAG, "[handleAsync] do nothing, not enabled");
                    }
                }, 4, 3000L);
                return;
            }
        }
        AdLog.e(TAG, "handleAsync error");
    }
}
