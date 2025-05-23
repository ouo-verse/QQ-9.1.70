package com.tencent.gamecenter.wadl.sdk.dlapt;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameDualDownloadService;
import com.tencent.gamecenter.wadl.api.IQQGamePCDNApi;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.h;
import com.tencent.gamecenter.wadl.sdk.Agent;
import com.tencent.gamecenter.wadl.sdk.InitParam;
import com.tencent.gamecenter.wadl.sdk.WadlDownloadSpeedReporterImpl;
import com.tencent.gamecenter.wadl.sdk.WadlLogImpl;
import com.tencent.gamecenter.wadl.sdk.WadlReportImpl;
import com.tencent.gamecenter.wadl.sdk.WadlTaskImpl;
import com.tencent.gamecenter.wadl.sdk.app.WadlReportManager;
import com.tencent.gamecenter.wadl.sdk.dlcom.WadlUtils;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTaskV2;
import com.tencent.gamecenter.wadl.sdk.downloader.Downloader;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskAttr;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskCategory;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskPriority;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskStatus;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.k;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlAgentV2Adapter {
    private static WadlAgentV2Adapter INSTANCE = null;
    private static byte[] LOCK = new byte[0];
    protected static final String TAG = "Wadl_WadlAgentV2Adapter";
    private Downloader downloader;
    private int speedBuffer;
    private final int progressInterval = 800;
    private final int downloaderAppid = 10;
    private int maxTaskNum = 3;
    private int threadNum = 3;

    WadlAgentV2Adapter() {
        init(MobileQQ.sMobileQQ);
    }

    private DownloaderTaskAttr createTaskAttr(WadlTaskV2 wadlTaskV2) {
        DownloaderTaskAttr downloaderTaskAttr = new DownloaderTaskAttr();
        downloaderTaskAttr.taskCategory = DownloaderTaskCategory.CATE_CUSTOM_MASS_1;
        downloaderTaskAttr.priority = DownloaderTaskPriority.HIGH;
        downloaderTaskAttr.multiSection = true;
        boolean scheduleSwitchByDomain = getScheduleSwitchByDomain(wadlTaskV2.mWadlParams.apkUrl);
        downloaderTaskAttr.scheduleSwitch = scheduleSwitchByDomain;
        if (scheduleSwitchByDomain) {
            wadlTaskV2.mWadlParams.setFlags(8192);
        } else {
            wadlTaskV2.mWadlParams.setFlagDisable(8192);
        }
        return downloaderTaskAttr;
    }

    public static WadlAgentV2Adapter getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new WadlAgentV2Adapter();
                }
            }
        }
        return INSTANCE;
    }

    private boolean getScheduleSwitchByDomain(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String host = Uri.parse(str).getHost();
        if (TextUtils.isEmpty(host)) {
            return false;
        }
        String stringOutAccount = GameCenterSpUtils.getStringOutAccount(WadlProxyConsts.KEY_SCHEDULE_INFO);
        if (TextUtils.isEmpty(stringOutAccount)) {
            return false;
        }
        try {
            jSONObject = new JSONObject(stringOutAccount);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getScheduleSwitchByAppid exception", e16);
        }
        if (jSONObject.optBoolean("scheduleSwitch", false)) {
            return true;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("domain");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                if (host.equals(optJSONArray.getString(i3))) {
                    return true;
                }
            }
        }
        return false;
    }

    private void init(Context context) {
        InitParam initParam = new InitParam(context, 10);
        initParam.initDelegate(new WadlReportImpl(), new WadlLogImpl(), new WadlTaskImpl(), new k());
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(IGameCenterUnitedConfigApi.GAMECENTER_DOWNLOADER_CONF, "");
        QLog.w(TAG, 1, "initDownloader downloaderConfStr=" + loadAsString);
        int readFromSpInt = GameCenterSpUtils.readFromSpInt(WadlProxyConsts.KEY_THREAD_NUM);
        if (!TextUtils.isEmpty(loadAsString)) {
            try {
                JSONObject jSONObject = new JSONObject(loadAsString);
                initParam.ScheduleCorePoolNum = jSONObject.optInt("schedule_core_pool");
                int optInt = jSONObject.optInt("max_thread_num");
                if (optInt > 0) {
                    readFromSpInt = optInt;
                }
                int optInt2 = jSONObject.optInt("report_dwspeed", 1);
                QLog.i(TAG, 1, "reportDownloadSpeed:" + optInt2 + ",config_threadNum:" + optInt);
                if (optInt2 == 1) {
                    initParam.setFlowCallback(new WadlDownloadSpeedReporterImpl());
                }
                initParam.setPcdnInitParam(((IQQGamePCDNApi) QRoute.api(IQQGamePCDNApi.class)).getPCDNInitParams());
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "init exception", th5);
            }
        }
        Agent.init(initParam);
        Agent.enableLog(false);
        Downloader downloader = Agent.getDownloader(initParam);
        this.downloader = downloader;
        downloader.setProgressInterval(800);
        int readFromSpInt2 = GameCenterSpUtils.readFromSpInt(WadlProxyConsts.KEY_TASK_NUM);
        this.maxTaskNum = readFromSpInt2;
        this.downloader.setTaskNumForCategory(DownloaderTaskCategory.CATE_CUSTOM_MASS_1, readFromSpInt2);
        this.downloader.setEnhanceThreadNums(readFromSpInt);
        QLog.i(TAG, 1, "initDownloader maxTaskNum=" + this.maxTaskNum + ",threadNum=" + readFromSpInt);
    }

    private void optChangeThreadRate(WadlTaskV2 wadlTaskV2) {
        DownloaderTaskAttr downloaderTaskAttr;
        DownloaderTask downloaderTask = wadlTaskV2.downloaderTask;
        if (downloaderTask != null) {
            downloaderTaskAttr = downloaderTask.getAttribute();
        } else {
            downloaderTaskAttr = null;
        }
        if (downloaderTaskAttr != null) {
            downloaderTaskAttr.sectionDefPercent = (short) 90;
            downloaderTaskAttr.sectionMobilePercent = (short) 10;
            boolean z16 = false;
            downloaderTaskAttr.sectionP2PPercent = (short) 0;
            String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(IGameCenterUnitedConfigApi.GAMECENTER_DOWNLOADER_CONF, "");
            QLog.w(TAG, 1, "optChangeThreadRate downloaderConfStr=" + loadAsString);
            if (!TextUtils.isEmpty(loadAsString)) {
                try {
                    JSONObject optJSONObject = new JSONObject(loadAsString).optJSONObject("dual");
                    if (optJSONObject != null) {
                        downloaderTaskAttr.sectionDefPercent = (short) optJSONObject.optInt("def_rate", 0);
                        downloaderTaskAttr.sectionMobilePercent = (short) optJSONObject.optInt("mobile_rate", 0);
                        downloaderTaskAttr.sectionP2PPercent = (short) optJSONObject.optInt("p2p_rate", 0);
                        if (optJSONObject.optInt("use_dynamic_section", 0) == 1) {
                            z16 = true;
                        }
                        downloaderTaskAttr.useDynamicSection = z16;
                        QLog.i(TAG, 1, "optChangeThreadRate appId=" + wadlTaskV2.mWadlParams.appId + ",sectionDefPercent=" + ((int) downloaderTaskAttr.sectionDefPercent) + ",sectionMobilePercent=" + ((int) downloaderTaskAttr.sectionMobilePercent) + ",sectionP2PPercent=" + ((int) downloaderTaskAttr.sectionP2PPercent) + ",useDynamicSection=" + downloaderTaskAttr.useDynamicSection);
                    }
                } catch (JSONException e16) {
                    QLog.e(TAG, 1, "optChangeThreadRate exception", e16);
                }
            }
            wadlTaskV2.downloaderTask.setAttribute(downloaderTaskAttr);
            return;
        }
        QLog.w(TAG, 1, "optChangeThreadRate pass, attr is null");
    }

    private void optChangeThreadRateToPCDN(WadlTaskV2 wadlTaskV2, JSONObject jSONObject) {
        DownloaderTaskAttr downloaderTaskAttr;
        DownloaderTask downloaderTask = wadlTaskV2.downloaderTask;
        if (downloaderTask != null) {
            downloaderTaskAttr = downloaderTask.getAttribute();
        } else {
            downloaderTaskAttr = null;
        }
        boolean isPCDNSOReady = ((IQQGamePCDNApi) QRoute.api(IQQGamePCDNApi.class)).isPCDNSOReady();
        if (!isPCDNSOReady) {
            ((IQQGamePCDNApi) QRoute.api(IQQGamePCDNApi.class)).checkAndLoadSoAsync();
        }
        QLog.w(TAG, 1, "optChangeThreadRateToPCDN pcdnThreadConfigObj=" + jSONObject + ",isPCDNSOReady:" + isPCDNSOReady);
        if (downloaderTaskAttr != null && jSONObject != null && isPCDNSOReady) {
            try {
                downloaderTaskAttr.sectionDefPercent = (short) jSONObject.optInt("def_rate", 0);
                downloaderTaskAttr.sectionMobilePercent = (short) jSONObject.optInt("mobile_rate", 0);
                downloaderTaskAttr.sectionP2PPercent = (short) jSONObject.optInt("p2p_rate", 0);
                wadlTaskV2.downloaderTask.setAttribute(downloaderTaskAttr);
                QLog.w(TAG, 1, "optChangeThreadRateToPCDN appId=" + wadlTaskV2.mWadlParams.appId + ",sectionDefPercent=" + ((int) downloaderTaskAttr.sectionDefPercent) + ",sectionMobilePercent=" + ((int) downloaderTaskAttr.sectionMobilePercent) + ",sectionP2PPercent=" + ((int) downloaderTaskAttr.sectionP2PPercent));
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "optChangeThreadRate exception", th5);
            }
        }
    }

    public void deleteAllTask() {
        Downloader downloader = this.downloader;
        if (downloader != null) {
            downloader.deleteAllTask(true);
        }
    }

    public void deleteDownload(WadlTaskV2 wadlTaskV2) {
        if (wadlTaskV2.downloaderTask != null && this.downloader != null) {
            QLog.d(TAG, 1, "deleteDownload id=" + wadlTaskV2.mWadlParams.getResId());
            this.downloader.deleteTask(wadlTaskV2.downloaderTask, true);
            wadlTaskV2.downloaderTask.removeListener(wadlTaskV2);
            wadlTaskV2.downloaderTask = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DownloaderTask getDownloaderTask(WadlTaskV2 wadlTaskV2) {
        DownloaderTask genDownloadTask;
        DownloaderTaskAttr createTaskAttr = createTaskAttr(wadlTaskV2);
        QLog.d(TAG, 1, "getDownloaderTask attr" + createTaskAttr);
        Downloader downloader = this.downloader;
        if (downloader != null) {
            try {
                genDownloadTask = downloader.genDownloadTask(wadlTaskV2.mWadlParams.apkUrl, wadlTaskV2.saveDir, wadlTaskV2.saveName, wadlTaskV2, createTaskAttr);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getDownloaderTask exception", e16);
            }
            if (genDownloadTask != null) {
                genDownloadTask.setId(wadlTaskV2.appId);
            }
            return genDownloadTask;
        }
        genDownloadTask = null;
        if (genDownloadTask != null) {
        }
        return genDownloadTask;
    }

    public int getSpeedBuffer() {
        return this.speedBuffer;
    }

    public boolean pauseDownload(WadlTaskV2 wadlTaskV2) {
        DownloaderTask downloaderTask = wadlTaskV2.downloaderTask;
        if (downloaderTask != null) {
            DownloaderTaskStatus status = downloaderTask.getStatus();
            QLog.d(TAG, 1, "pauseDownload id=" + wadlTaskV2.mWadlParams.getResId() + ",currStatus=" + status.name());
            if (status == DownloaderTaskStatus.PENDING || status == DownloaderTaskStatus.STARTED || status == DownloaderTaskStatus.DOWNLOADING) {
                wadlTaskV2.downloaderTask.pause();
                return true;
            }
            return false;
        }
        return false;
    }

    public void setSpeedBuffer(int i3) {
        this.speedBuffer = i3;
        Downloader downloader = this.downloader;
        if (downloader != null) {
            downloader.updateGlobalSpeedBuffer(i3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007b A[Catch: Exception -> 0x0149, all -> 0x0177, TryCatch #0 {Exception -> 0x0149, blocks: (B:11:0x0016, B:13:0x001d, B:15:0x0021, B:19:0x0033, B:22:0x0048, B:26:0x005f, B:28:0x0068, B:31:0x0072, B:33:0x007b, B:34:0x009e, B:36:0x00a8, B:37:0x00b0, B:39:0x00f7, B:40:0x0133, B:42:0x013b, B:43:0x0141, B:48:0x0084, B:50:0x009b), top: B:10:0x0016, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a8 A[Catch: Exception -> 0x0149, all -> 0x0177, TryCatch #0 {Exception -> 0x0149, blocks: (B:11:0x0016, B:13:0x001d, B:15:0x0021, B:19:0x0033, B:22:0x0048, B:26:0x005f, B:28:0x0068, B:31:0x0072, B:33:0x007b, B:34:0x009e, B:36:0x00a8, B:37:0x00b0, B:39:0x00f7, B:40:0x0133, B:42:0x013b, B:43:0x0141, B:48:0x0084, B:50:0x009b), top: B:10:0x0016, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f7 A[Catch: Exception -> 0x0149, all -> 0x0177, TryCatch #0 {Exception -> 0x0149, blocks: (B:11:0x0016, B:13:0x001d, B:15:0x0021, B:19:0x0033, B:22:0x0048, B:26:0x005f, B:28:0x0068, B:31:0x0072, B:33:0x007b, B:34:0x009e, B:36:0x00a8, B:37:0x00b0, B:39:0x00f7, B:40:0x0133, B:42:0x013b, B:43:0x0141, B:48:0x0084, B:50:0x009b), top: B:10:0x0016, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x013b A[Catch: Exception -> 0x0149, all -> 0x0177, TryCatch #0 {Exception -> 0x0149, blocks: (B:11:0x0016, B:13:0x001d, B:15:0x0021, B:19:0x0033, B:22:0x0048, B:26:0x005f, B:28:0x0068, B:31:0x0072, B:33:0x007b, B:34:0x009e, B:36:0x00a8, B:37:0x00b0, B:39:0x00f7, B:40:0x0133, B:42:0x013b, B:43:0x0141, B:48:0x0084, B:50:0x009b), top: B:10:0x0016, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084 A[Catch: Exception -> 0x0149, all -> 0x0177, TryCatch #0 {Exception -> 0x0149, blocks: (B:11:0x0016, B:13:0x001d, B:15:0x0021, B:19:0x0033, B:22:0x0048, B:26:0x005f, B:28:0x0068, B:31:0x0072, B:33:0x007b, B:34:0x009e, B:36:0x00a8, B:37:0x00b0, B:39:0x00f7, B:40:0x0133, B:42:0x013b, B:43:0x0141, B:48:0x0084, B:50:0x009b), top: B:10:0x0016, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void startDownload(WadlTaskV2 wadlTaskV2) {
        WadlParams wadlParams;
        boolean z16;
        boolean z17;
        String str;
        String str2;
        String netType;
        String url;
        DownloaderTaskAttr attribute;
        if (!TextUtils.isEmpty(wadlTaskV2.mWadlParams.apkUrl) && wadlTaskV2.downloaderTask != null && this.downloader != null) {
            try {
                wadlParams = wadlTaskV2.mWadlParams;
                z16 = false;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "startDownload exception", e16);
                try {
                    wadlTaskV2.downloaderTask.resume();
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, "startDownload exception", th5);
                    wadlTaskV2.onTaskFailed(-1, th5.getMessage());
                }
            }
            if (wadlParams.isDirectUseDualWay != 1 && (!wadlParams.isDualDownload || !((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).isKingCard())) {
                z17 = false;
                if (!((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).hasSimCard()) {
                    str = "1";
                } else {
                    str = "0";
                }
                if (!((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).isFlowSwitchOn()) {
                    str2 = "1";
                } else {
                    str2 = "0";
                }
                if (z17 && "1".equals(str) && "1".equals(str2)) {
                    z16 = true;
                }
                this.downloader.setDualDownloadSwitch(z16);
                if (!z16) {
                    wadlTaskV2.mWadlParams.setFlags(65536);
                    optChangeThreadRate(wadlTaskV2);
                } else {
                    wadlTaskV2.mWadlParams.setFlagDisable(65536);
                    JSONObject pCDNThreadConfig = ((IQQGamePCDNApi) QRoute.api(IQQGamePCDNApi.class)).getPCDNThreadConfig(wadlTaskV2.mWadlParams.appId);
                    if (pCDNThreadConfig != null) {
                        optChangeThreadRateToPCDN(wadlTaskV2, pCDNThreadConfig);
                    }
                }
                netType = WadlUtils.getNetType();
                if (!TextUtils.isEmpty(netType)) {
                    wadlTaskV2.downloaderTask.addHeader(WadlUtils.HEADER_ACCESS_TYPE, netType);
                }
                url = wadlTaskV2.downloaderTask.getUrl();
                QLog.d(TAG, 1, "startDownload businessId=" + wadlTaskV2.businessId + ",taskStatus=" + wadlTaskV2.taskStatus + ",isDualSwitchOn=" + z17 + ",isAbleUseDualDownload:" + z16);
                if (!wadlTaskV2.mWadlParams.apkUrl.equals(url)) {
                    QLog.w(TAG, 1, "startDownload url different apkUrl=" + wadlTaskV2.mWadlParams.apkUrl + ",taskUrl=" + url);
                    h b16 = h.b();
                    WadlParams wadlParams2 = wadlTaskV2.mWadlParams;
                    b16.f106814a = wadlParams2;
                    b16.f106822i = url;
                    b16.f106823j = wadlParams2.apkUrl;
                    WadlReportManager.wadlReportDC(WadlProxyConsts.OPER_ID_URL_CHANGE, "21", b16);
                }
                attribute = wadlTaskV2.downloaderTask.getAttribute();
                if (attribute != null) {
                    wadlTaskV2.mWadlParams.channelNum = attribute.sectionMobilePercent;
                }
                this.downloader.startDownload(wadlTaskV2.downloaderTask);
                return;
            }
            z17 = true;
            if (!((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).hasSimCard()) {
            }
            if (!((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).isFlowSwitchOn()) {
            }
            if (z17) {
                z16 = true;
            }
            this.downloader.setDualDownloadSwitch(z16);
            if (!z16) {
            }
            netType = WadlUtils.getNetType();
            if (!TextUtils.isEmpty(netType)) {
            }
            url = wadlTaskV2.downloaderTask.getUrl();
            QLog.d(TAG, 1, "startDownload businessId=" + wadlTaskV2.businessId + ",taskStatus=" + wadlTaskV2.taskStatus + ",isDualSwitchOn=" + z17 + ",isAbleUseDualDownload:" + z16);
            if (!wadlTaskV2.mWadlParams.apkUrl.equals(url)) {
            }
            attribute = wadlTaskV2.downloaderTask.getAttribute();
            if (attribute != null) {
            }
            this.downloader.startDownload(wadlTaskV2.downloaderTask);
            return;
        }
        wadlTaskV2.onTaskFailed(1001, "check params fail");
    }
}
