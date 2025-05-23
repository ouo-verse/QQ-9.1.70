package com.tencent.gamecenter.wadl.sdk.dlmgr;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.gamecenter.wadl.api.IQQGameDLReportService;
import com.tencent.gamecenter.wadl.api.impl.WadlProxyService;
import com.tencent.gamecenter.wadl.biz.entity.GameNoticeInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterReceiver;
import com.tencent.gamecenter.wadl.sdk.app.WadlReportManager;
import com.tencent.gamecenter.wadl.sdk.app.WadlSpaceNotEnoughActivity;
import com.tencent.gamecenter.wadl.sdk.db.WadlDBHelperFactory;
import com.tencent.gamecenter.wadl.sdk.db.WadlGameCenterDBHelper;
import com.tencent.gamecenter.wadl.sdk.dlcom.WadlUtils;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlGameCenterTaskMgr extends Observable implements IManager {
    protected static final String TAG = "Wadl_WadlGameCenterTaskMgr";
    private WadlGameCenterDBHelper dbHelper;
    private com.tencent.gamecenter.wadl.biz.db.b noticeDBHelper;
    private final List<WadlTask> taskList = new ArrayList();
    private final long oneDay = 86400000;
    private volatile AtomicBoolean mInit = new AtomicBoolean(false);
    private Map<String, ApkInfo> mApkInfoMap = new HashMap();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class ApkInfo {
        String appId = "";
        String filePath = "";
        int versionCode;

        public ApkInfo() {
        }

        public String toString() {
            return "ApkInfo{appId='" + this.appId + "', versionCode=" + this.versionCode + ", filePath='" + this.filePath + "'}";
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements Comparator<WadlTask> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(WadlTask wadlTask, WadlTask wadlTask2) {
            int i3 = wadlTask.taskStatus;
            int i16 = wadlTask2.taskStatus;
            if (i3 < i16) {
                return -1;
            }
            if (i3 == i16) {
                return 0;
            }
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static WadlGameCenterTaskMgr f107244a = new WadlGameCenterTaskMgr();
    }

    WadlGameCenterTaskMgr() {
        WadlGameCenterDBHelper wadlGameCenterDBHelper = (WadlGameCenterDBHelper) WadlDBHelperFactory.getDBHelper(1);
        this.dbHelper = wadlGameCenterDBHelper;
        addObserver(wadlGameCenterDBHelper);
        if (GameCenterUtil.isClearFileSwitchOn()) {
            try {
                deleteLowVersionApkFile();
            } catch (Throwable th5) {
                QLog.w(TAG, 1, "deleteLowVersionApkFile err:" + th5.getMessage());
            }
        }
    }

    private void checkApkUpdateFile(ApkInfo apkInfo) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "-->checkApkUpdateFile");
        }
        if (apkInfo != null && !TextUtils.isEmpty(apkInfo.appId) && apkInfo.versionCode != 0 && !TextUtils.isEmpty(apkInfo.filePath)) {
            ApkInfo apkInfo2 = this.mApkInfoMap.get(apkInfo.appId);
            if (apkInfo2 == null) {
                this.mApkInfoMap.put(apkInfo.appId, apkInfo);
                return;
            }
            if (apkInfo2.versionCode < apkInfo.versionCode) {
                this.mApkInfoMap.put(apkInfo.appId, apkInfo);
                str = apkInfo2.filePath;
            } else {
                str = apkInfo.filePath;
            }
            boolean deleteFile = WadlUtils.deleteFile(str);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "checkApkUpdateFile,deleteFile " + str + " " + deleteFile);
            }
        }
    }

    private ApkInfo decodeApkInfo(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.endsWith(".apk")) {
            String substring = str.substring(0, str.length() - 4);
            QLog.d(TAG, 4, "deleteInvalidApkFile,fileName is " + substring);
            String[] split = substring.split("_");
            if (split.length >= 3) {
                ApkInfo apkInfo = new ApkInfo();
                apkInfo.filePath = str2;
                apkInfo.appId = split[1];
                apkInfo.versionCode = Integer.parseInt(split[2]);
                QLog.d(TAG, 4, "deleteInvalidApkFile,apkInfo is " + apkInfo.toString());
                return apkInfo;
            }
        }
        return null;
    }

    public static WadlGameCenterTaskMgr getInstance() {
        return b.f107244a;
    }

    private boolean handleUninstalledFromOtherChannel(String str, String str2, String str3) {
        WadlProxyService c16;
        if (isInNotDeleteWhiteList(str2) && str3 != null && str3.equals(str)) {
            synchronized (this.taskList) {
                for (WadlTask wadlTask : this.taskList) {
                    if (wadlTask != null && str2.equals(wadlTask.appId) && str3.equals(wadlTask.pkgName)) {
                        wadlTask.fixStatus();
                        int eventByStatus = wadlTask.getEventByStatus();
                        if (eventByStatus != -1 && (c16 = WadlProxyService.c()) != null) {
                            c16.h(eventByStatus, wadlTask);
                        }
                        QLog.d(TAG, 1, "[appUninstalled] update event:" + eventByStatus + ",task:" + wadlTask.simplePrintInfo());
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    private synchronized void init() {
        if (this.mInit.get()) {
            return;
        }
        List<WadlTask> execQueryAllSQL = this.dbHelper.execQueryAllSQL();
        int size = execQueryAllSQL.size();
        QLog.i(TAG, 1, "init task from db size=" + size);
        if (size > 0) {
            synchronized (this.taskList) {
                for (WadlTask wadlTask : execQueryAllSQL) {
                    wadlTask.fixStatus();
                    if (!wadlTask.isValid()) {
                        QLog.w(TAG, 1, "init task, remove invalid task=" + wadlTask);
                        wadlTask.deleteDownload(false);
                    } else {
                        QLog.d(TAG, 1, "init task, add valid task=" + wadlTask);
                        this.taskList.add(wadlTask);
                    }
                }
            }
        }
        this.mInit.set(true);
    }

    private boolean isInNotDeleteWhiteList(String str) {
        JSONArray optJSONArray;
        try {
            if (!TextUtils.isEmpty(str) && (optJSONArray = ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfigJsonObj(IGameCenterUnitedConfigApi.GAMEPLAT_DOWNLOADER_NOT_DELETE).optJSONArray("appList")) != null && optJSONArray.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    if (str.equals(optJSONObject.optString("appId"))) {
                        long optLong = optJSONObject.optLong("startTime");
                        long optLong2 = optJSONObject.optLong("endTime");
                        long serverTime = NetConnInfoCenter.getServerTime();
                        if (optLong < serverTime && serverTime < optLong2) {
                            QLog.i(TAG, 1, "is not autoDelete,appId:" + str);
                            return true;
                        }
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        return false;
    }

    private boolean isNotAutoDelete(String str, String str2, String str3) {
        String fileChannel = GameCenterUtil.getFileChannel(GameCenterUtil.getApkSourceDir(str2));
        QLog.d(TAG, 1, "installedChannel:" + fileChannel + ",apkChannel:" + str3 + ",appId:" + str);
        if (!TextUtils.isEmpty(str3) && str3.equals(fileChannel)) {
            QLog.i(TAG, 1, "channel is valid,just delete");
            return false;
        }
        return isInNotDeleteWhiteList(str);
    }

    private void syncSaveDB(WadlTask wadlTask) {
        wadlTask.isFinish = true;
        wadlTask.isPausedByWifiDisconnected = false;
        wadlTask.errCode = 0;
        wadlTask.taskStatus = 5;
        this.dbHelper.updateWadlTask(wadlTask.getWadlResult(1006));
    }

    public void addWadlTask(WadlTask wadlTask) {
        QLog.d(TAG, 1, "addWadlTask task=" + wadlTask);
        init();
        synchronized (this.taskList) {
            if (!this.taskList.contains(wadlTask)) {
                this.taskList.add(wadlTask);
            }
        }
    }

    public void appInstalled(int i3, String str) {
        QLog.d(TAG, 1, "appInstalled actionFrom=" + i3 + ",packageName=" + str);
        init();
        ArrayList arrayList = new ArrayList();
        synchronized (this.taskList) {
            for (WadlTask wadlTask : this.taskList) {
                if (wadlTask.onForceInstalled(i3, str)) {
                    arrayList.add(wadlTask.appId);
                } else if (wadlTask.onPackageInstalled(str) && !isNotAutoDelete(wadlTask.appId, str, wadlTask.mWadlParams.apkChannel)) {
                    arrayList.add(wadlTask.appId);
                }
            }
        }
        if (arrayList.size() < 1) {
            QLog.d(TAG, 1, "appInstalled,no matching packageName task:" + str);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            deleteWadlTask((String) it.next(), false, WadlProxyConsts.DELETE_FROM_APP_INSTALLED);
        }
    }

    public void appUninstalled(String str) {
        String stringOutAccount = GameCenterSpUtils.getStringOutAccount(WadlProxyConsts.KEY_PKG_INFO_PRE + str);
        if (!TextUtils.isEmpty(stringOutAccount)) {
            String uninstallPkgName = GameCenterReceiver.getInstance().getUninstallPkgName();
            QLog.d(TAG, 1, "[appUninstalled]" + str + ",recordPkgName:" + uninstallPkgName);
            if (handleUninstalledFromOtherChannel(str, stringOutAccount, uninstallPkgName)) {
                return;
            }
            WadlTask wadlTask = new WadlTask(1, new WadlParams(stringOutAccount, str));
            wadlTask.taskStatus = 12;
            WadlProxyService c16 = WadlProxyService.c();
            if (c16 != null) {
                c16.h(1007, wadlTask);
                return;
            }
            return;
        }
        QLog.d(TAG, 1, "[appUninstalled] appId is null," + str);
    }

    public void deleteLowVersionApkFile() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "-->deleteInvalidApkFile");
        }
        String downloadApkDir = GameCenterUtil.getDownloadApkDir(1);
        QLog.d(TAG, 4, "-->downloadApkDir=" + downloadApkDir);
        File file = new File(downloadApkDir);
        if (file.exists() && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 4, "-->apkFile=" + file2.getPath());
                }
                checkApkUpdateFile(decodeApkInfo(file2.getName(), file2.getPath()));
            }
        }
        this.mApkInfoMap.clear();
    }

    public void deleteWadlTask(String str, boolean z16, String str2) {
        boolean z17;
        QLog.d(TAG, 1, "deleteWadlTask appId=" + str + ",isNotify=" + z16 + ",from:" + str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        init();
        synchronized (this.taskList) {
            Iterator<WadlTask> it = this.taskList.iterator();
            while (true) {
                if (it.hasNext()) {
                    WadlTask next = it.next();
                    if (str.equals(next.appId)) {
                        it.remove();
                        next.deleteDownload(z16);
                        z17 = true;
                        break;
                    }
                } else {
                    z17 = false;
                    break;
                }
            }
        }
        QLog.d(TAG, 1, "deleteWadlTask appId=" + str + ",result=" + z17);
    }

    public WadlTask findWadlTask(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        init();
        synchronized (this.taskList) {
            for (WadlTask wadlTask : this.taskList) {
                if (str.equals(wadlTask.appId)) {
                    return wadlTask;
                }
            }
            return null;
        }
    }

    public List<WadlTask> getAllWadlTask() {
        init();
        ArrayList arrayList = new ArrayList();
        synchronized (this.taskList) {
            arrayList.addAll(this.taskList);
        }
        return arrayList;
    }

    public WadlTask getWadlTaskByPackageName(String str) {
        init();
        synchronized (this.taskList) {
            for (WadlTask wadlTask : this.taskList) {
                WadlParams wadlParams = wadlTask.mWadlParams;
                if (wadlParams != null && TextUtils.equals(wadlParams.packageName, str)) {
                    return wadlTask;
                }
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0145  */
    @Override // com.tencent.gamecenter.wadl.sdk.dlmgr.IManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void notifyEventObserver(int i3, boolean z16, final WadlTask wadlTask) {
        GameNoticeInfo gameNoticeInfo;
        WadlProxyService c16;
        WadlResult wadlResult = wadlTask.getWadlResult(i3);
        if (i3 != 1004 && z16) {
            QLog.d(TAG, 1, "notifyEventObserver event=" + i3 + ",callback=" + z16 + ",wadlTask=" + wadlTask.simplePrintInfo());
            WadlReportManager.reportDC(i3, wadlTask);
            ((IQQGameDLReportService) QRoute.api(IQQGameDLReportService.class)).onDownloadStatusChange(i3, wadlResult);
        }
        if (z16) {
            WadlProxyService c17 = WadlProxyService.c();
            if (c17 != null) {
                c17.h(i3, wadlTask);
            }
            if (i3 == 1005 && wadlResult.errCode == 999) {
                ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.gamecenter.wadl.sdk.dlmgr.WadlGameCenterTaskMgr.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Intent intent = new Intent();
                        intent.putExtra(WadlProxyConsts.PARAM_DOWNLOAD_INFO, wadlTask.mWadlParams);
                        QPublicFragmentActivity.b.d(intent, QPublicTransFragmentActivity.class, WadlSpaceNotEnoughActivity.class);
                    }
                });
            }
        }
        if (i3 != 1008 && i3 != 1006) {
            if (i3 == 1007) {
                QLog.d(TAG, 1, "notifyEventObserver noticeDelete appId=" + wadlResult.wadlParams.appId);
                WadlProxyService c18 = WadlProxyService.c();
                if (c18 != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("appId", wadlResult.wadlParams.appId);
                    c18.f(WadlProxyConsts.REMOTE_REVERSE_ON_NOTICE_DELETE, bundle);
                }
            } else if (i3 == 1010) {
                QLog.d(TAG, 1, "notifyEventObserver onInstallStart appId=" + wadlResult.wadlParams.appId);
                WadlProxyService c19 = WadlProxyService.c();
                if (c19 != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable(WadlProxyConsts.PARAM_DOWNLOAD_RESULT, wadlResult);
                    c19.f(WadlProxyConsts.REMOTE_REVERSE_ON_INSTALL_START, bundle2);
                }
            }
        } else if (i3 == 1006) {
            WadlParams wadlParams = wadlResult.wadlParams;
            int i16 = wadlParams.noticeCount;
            if (i16 < 1) {
                wadlParams.noticeCount = i16 + 1;
                gameNoticeInfo = new GameNoticeInfo(wadlResult);
                if (gameNoticeInfo != null) {
                    if (this.noticeDBHelper == null) {
                        this.noticeDBHelper = new com.tencent.gamecenter.wadl.biz.db.b();
                    }
                    boolean e16 = this.noticeDBHelper.e(gameNoticeInfo);
                    QLog.d(TAG, 1, "notifyEventObserver noticeAdd replaceOrInsert=" + e16 + ",gameNoticeInfo=" + gameNoticeInfo);
                    if (e16 && (c16 = WadlProxyService.c()) != null) {
                        Bundle bundle3 = new Bundle();
                        bundle3.putParcelable(WadlProxyConsts.PARAM_NOTICE_INFO, gameNoticeInfo);
                        c16.f(WadlProxyConsts.REMOTE_REVERSE_ON_NOTICE_ADD, bundle3);
                    }
                }
            }
            gameNoticeInfo = null;
            if (gameNoticeInfo != null) {
            }
        } else {
            boolean isExistMiniApp = ((IQQGameCommApi) QRoute.api(IQQGameCommApi.class)).isExistMiniApp(wadlResult.wadlParams.packageName);
            QLog.i(TAG, 1, "notifyEventObserver EVENT_DOWNLOAD_COMPLETED, packageName=" + wadlResult.wadlParams.packageName + " isMiniApp=" + isExistMiniApp + ",noticeCount=" + wadlResult.wadlParams.noticeCount);
            if (!isExistMiniApp) {
                wadlResult.wadlParams.noticeCount++;
                gameNoticeInfo = new GameNoticeInfo(wadlResult);
                gameNoticeInfo.C = NetConnInfoCenter.getServerTimeMillis();
                if (gameNoticeInfo != null) {
                }
            }
            gameNoticeInfo = null;
            if (gameNoticeInfo != null) {
            }
        }
        sendMsgToObservers(wadlResult);
    }

    public void onDestroy() {
        pauseAllDownloadTask(false);
        deleteObservers();
    }

    public void pauseAllDownloadTask(boolean z16) {
        QLog.d(TAG, 1, "pauseAllDownloadTask isPausedByNet=" + z16);
        init();
        try {
            synchronized (this.taskList) {
                for (WadlTask wadlTask : this.taskList) {
                    if (WadlUtils.isRuningTask(wadlTask.taskStatus)) {
                        if (z16) {
                            if (wadlTask.isStartedUnderWifi || wadlTask.isRequireWifi()) {
                                wadlTask.isPausedByWifiDisconnected = true;
                            }
                        } else {
                            syncSaveDB(wadlTask);
                        }
                        wadlTask.pauseDownload("4");
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "pauseAllDownloadTask exception", th5);
        }
    }

    public ArrayList<WadlResult> queryAllWadlTask(boolean z16) {
        ArrayList<WadlResult> arrayList = new ArrayList<>();
        init();
        synchronized (this.taskList) {
            for (WadlTask wadlTask : this.taskList) {
                if (wadlTask.mWadlParams != null && (z16 || wadlTask.bCallback())) {
                    WadlResult wadlResult = wadlTask.getWadlResult(4000);
                    if (z16 || wadlResult.updateTaskStatus()) {
                        arrayList.add(wadlResult);
                    }
                }
            }
        }
        return arrayList;
    }

    public ArrayList<WadlResult> queryWadlTask(ArrayList<String> arrayList) {
        ArrayList<WadlResult> arrayList2 = new ArrayList<>();
        if (arrayList != null && arrayList.size() >= 1) {
            HashSet hashSet = new HashSet();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    hashSet.add(next);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            init();
            synchronized (this.taskList) {
                for (WadlTask wadlTask : this.taskList) {
                    if (hashSet.contains(wadlTask.appId) && wadlTask.bCallback()) {
                        arrayList3.add(wadlTask);
                    }
                }
            }
            if (arrayList3.size() > 0) {
                Collections.sort(arrayList3, new a());
            }
            Iterator it5 = arrayList3.iterator();
            while (it5.hasNext()) {
                WadlResult wadlResult = ((WadlTask) it5.next()).getWadlResult(4000);
                if (wadlResult.updateTaskStatus()) {
                    arrayList2.add(wadlResult);
                }
            }
            return arrayList2;
        }
        return arrayList2;
    }

    public ArrayList<WadlResult> queryWadlTaskByVia(String str) {
        ArrayList<WadlResult> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        init();
        synchronized (this.taskList) {
            for (WadlTask wadlTask : this.taskList) {
                WadlParams wadlParams = wadlTask.mWadlParams;
                if (wadlParams != null && TextUtils.equals(wadlParams.via, str) && wadlTask.bCallback()) {
                    WadlResult wadlResult = wadlTask.getWadlResult(4000);
                    if (wadlResult.updateTaskStatus()) {
                        arrayList.add(wadlResult);
                    }
                }
            }
        }
        return arrayList;
    }

    public void restartUnfinishedTask() {
        boolean isUnderWifiConnection = WadlUtils.isUnderWifiConnection();
        QLog.i(TAG, 1, "restartUnfinishedTask wifi=" + isUnderWifiConnection);
        init();
        synchronized (this.taskList) {
            for (WadlTask wadlTask : this.taskList) {
                if (wadlTask.interruptedFlag) {
                    wadlTask.interruptedFlag = false;
                    WadlParams wadlParams = wadlTask.mWadlParams;
                    if (wadlParams != null) {
                        wadlParams.fromWebUrl = "Recovery";
                    }
                    if (System.currentTimeMillis() - wadlTask.createTime > 86400000) {
                        QLog.d(TAG, 1, "restartUnfinishedTask but cost > 24hour appid=" + wadlTask.appId);
                    } else {
                        QLog.d(TAG, 1, "restartUnfinishedTask wadlParams=" + wadlTask.mWadlParams);
                        if (isUnderWifiConnection) {
                            wadlTask.onTaskStarted();
                            wadlTask.startDownload();
                        } else {
                            wadlTask.taskStatus = 5;
                            wadlTask.isPausedByWifiDisconnected = true;
                        }
                    }
                }
            }
        }
    }

    public void resumeAllTaskForReConn() {
        QLog.i(TAG, 1, "resumeAllTaskForReConn.,..");
        init();
        synchronized (this.taskList) {
            for (WadlTask wadlTask : this.taskList) {
                if (wadlTask.isPausedByWifiDisconnected) {
                    wadlTask.isPausedByWifiDisconnected = false;
                    WadlParams wadlParams = wadlTask.mWadlParams;
                    if (wadlParams != null) {
                        wadlParams.fromWebUrl = "Reconnection";
                    }
                    wadlTask.onTaskStarted();
                    wadlTask.startDownload();
                }
            }
        }
    }

    public void sendMsgToObservers(WadlResult wadlResult) {
        setChanged();
        notifyObservers(wadlResult);
    }

    public void syncTaskData(ArrayList<WadlResult> arrayList) {
        init();
        synchronized (this.taskList) {
            for (WadlTask wadlTask : this.taskList) {
                Iterator<WadlResult> it = arrayList.iterator();
                while (it.hasNext()) {
                    WadlResult next = it.next();
                    if (next.wadlParams.appId.equals(wadlTask.appId)) {
                        QLog.d(TAG, 1, "[syncTaskData] t.appId=" + wadlTask.appId);
                        wadlTask.onTaskUpdate(next);
                    }
                }
            }
        }
    }
}
