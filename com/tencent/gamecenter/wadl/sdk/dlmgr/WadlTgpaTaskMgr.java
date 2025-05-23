package com.tencent.gamecenter.wadl.sdk.dlmgr;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.impl.WadlProxyService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.sdk.app.WadlReportManager;
import com.tencent.gamecenter.wadl.sdk.app.WadlSpaceNotEnoughActivity;
import com.tencent.gamecenter.wadl.sdk.db.WadlDBHelperFactory;
import com.tencent.gamecenter.wadl.sdk.db.WadlTgpaDBHelper;
import com.tencent.gamecenter.wadl.sdk.dlcom.WadlUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlTgpaTaskMgr extends Observable implements IManager {
    private static final long EXPIRE_INTERVAL = 889032704;
    private static final long ONE_DAY = 86400000;
    public static final String TAG = "Wadl_WadlTgpaTaskMgr";
    private WadlTgpaDBHelper dbHelper;
    private Map<String, WadlTask> mWadlTasks = new HashMap();
    private volatile AtomicBoolean mInit = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static WadlTgpaTaskMgr f107255a = new WadlTgpaTaskMgr();
    }

    WadlTgpaTaskMgr() {
        WadlTgpaDBHelper wadlTgpaDBHelper = (WadlTgpaDBHelper) WadlDBHelperFactory.getDBHelper(2);
        this.dbHelper = wadlTgpaDBHelper;
        addObserver(wadlTgpaDBHelper);
    }

    private boolean compStr(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return str.equals(str2);
    }

    public static WadlTgpaTaskMgr getInstance() {
        return a.f107255a;
    }

    private synchronized void init() {
        if (this.mInit.get()) {
            return;
        }
        Map<String, WadlTask> allWadlTasks = this.dbHelper.getAllWadlTasks();
        long resAvilTime = GameCenterUtil.getResAvilTime();
        if (resAvilTime <= 0) {
            resAvilTime = EXPIRE_INTERVAL;
        }
        HashMap hashMap = new HashMap();
        synchronized (this.mWadlTasks) {
            for (Map.Entry<String, WadlTask> entry : allWadlTasks.entrySet()) {
                WadlTask value = entry.getValue();
                boolean isValid = value.isValid();
                if (isValid) {
                    if (NetConnInfoCenter.getServerTimeMillis() - value.createTime > resAvilTime || GameCenterUtil.isInvalidResType(value.mWadlParams.resType)) {
                        isValid = false;
                    }
                    if (isValid && GameCenterUtil.isClearFileSwitchOn() && !isInvalidResFile(value, hashMap)) {
                        isValid = false;
                    }
                }
                if (!isValid) {
                    QLog.w(TAG, 1, "init task, remove invalid task=" + value);
                    value.deleteDownload(false);
                } else {
                    if (WadlUtils.isRuningTask(value.taskStatus)) {
                        value.taskStatus = 5;
                        value.interruptedFlag = true;
                    } else {
                        int i3 = value.taskStatus;
                        if (i3 == 7) {
                            value.taskStatus = 5;
                        } else if (i3 == 6 && !WadlUtils.fileExists(value.downloadFilePath)) {
                            value.taskStatus = 0;
                        }
                    }
                    this.mWadlTasks.put(entry.getKey(), value);
                    QLog.d(TAG, 1, "init task, add valid task=" + value);
                }
            }
        }
        this.mInit.set(true);
    }

    private boolean isInvalidResFile(WadlTask wadlTask, Map<String, WadlTask> map) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "isInvalidResFile");
        }
        try {
            String str = wadlTask.appId + "_" + wadlTask.mWadlParams.resType + "_" + wadlTask.mWadlParams.resIndex;
            WadlTask wadlTask2 = map.get(str);
            if (wadlTask2 != null) {
                if (wadlTask2.mWadlParams.versionCode >= wadlTask.mWadlParams.versionCode) {
                    return true;
                }
                wadlTask2.deleteDownload(false);
                map.put(str, wadlTask);
            } else {
                map.put(str, wadlTask);
            }
        } catch (Throwable th5) {
            QLog.w(TAG, 1, "clear low version resfile err:" + th5.getMessage());
        }
        return false;
    }

    private void syncSaveDB(WadlTask wadlTask) {
        wadlTask.isFinish = true;
        wadlTask.isPausedByWifiDisconnected = false;
        wadlTask.errCode = 0;
        wadlTask.taskStatus = 5;
        this.dbHelper.updateTask(wadlTask.getWadlResult(5006));
    }

    public void addWadlTask(WadlTask wadlTask) {
        init();
        synchronized (this.mWadlTasks) {
            this.mWadlTasks.put(wadlTask.mWadlParams.getResId(), wadlTask);
        }
    }

    public void delRes(boolean z16, int i3, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        init();
        try {
            synchronized (this.mWadlTasks) {
                Iterator<Map.Entry<String, WadlTask>> it = this.mWadlTasks.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    WadlTask value = it.next().getValue();
                    if (compStr(str, value.pkgName) && compStr(str2, value.mWadlParams.resName) && compStr(str3, value.mWadlParams.getResId()) && value.mWadlParams.resType == i3) {
                        value.pauseDownload("");
                        value.deleteDownload(z16);
                        it.remove();
                        break;
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "delResByPkgName exception pkgName=" + str + ",fileName=" + str2, th5);
        }
    }

    public void delResForResId(boolean z16, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        init();
        try {
            synchronized (this.mWadlTasks) {
                Iterator<Map.Entry<String, WadlTask>> it = this.mWadlTasks.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    WadlTask value = it.next().getValue();
                    WadlParams wadlParams = value.mWadlParams;
                    if (wadlParams != null && str.equals(wadlParams.getResId())) {
                        value.pauseDownload("");
                        value.deleteDownload(z16);
                        it.remove();
                        QLog.d(TAG, 1, "delResForResId resId=" + str + ",findTask = " + value);
                        break;
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "delResForResId exception", th5);
        }
    }

    public WadlTask getWadlTask(String str) {
        WadlTask wadlTask;
        init();
        synchronized (this.mWadlTasks) {
            wadlTask = this.mWadlTasks.get(str);
        }
        return wadlTask;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.dlmgr.IManager
    public void notifyEventObserver(int i3, boolean z16, final WadlTask wadlTask) {
        QLog.d(TAG, 1, "notifyEventOberver event=" + i3 + ",callback=" + z16 + ",wadlTask=" + wadlTask.simplePrintInfo());
        WadlReportManager.reportDC(i3, wadlTask);
        WadlResult wadlResult = wadlTask.getWadlResult(i3);
        sendMsgToObservers(wadlResult);
        if (!z16) {
            return;
        }
        WadlProxyService c16 = WadlProxyService.c();
        if (c16 != null) {
            c16.h(i3, wadlTask);
        }
        if (i3 == 5005 && wadlResult.errCode == 999) {
            ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTgpaTaskMgr.1
                @Override // java.lang.Runnable
                public void run() {
                    Intent intent = new Intent();
                    intent.putExtra(WadlProxyConsts.PARAM_DOWNLOAD_INFO, wadlTask.mWadlParams);
                    QPublicFragmentActivity.b.d(intent, QPublicTransFragmentActivity.class, WadlSpaceNotEnoughActivity.class);
                }
            });
        }
    }

    public void onDestroy() {
        pauseAllDownloadTask(false);
        deleteObservers();
    }

    public void pauseAllDownloadTask(boolean z16) {
        QLog.d(TAG, 1, "pauseAllDownloadTask isPausedByNet=" + z16);
        init();
        synchronized (this.mWadlTasks) {
            Iterator<Map.Entry<String, WadlTask>> it = this.mWadlTasks.entrySet().iterator();
            while (it.hasNext()) {
                WadlTask value = it.next().getValue();
                if (WadlUtils.isRuningTask(value.taskStatus)) {
                    if (z16) {
                        if (value.isStartedUnderWifi || value.isRequireWifi()) {
                            value.isPausedByWifiDisconnected = true;
                        }
                    } else {
                        syncSaveDB(value);
                    }
                    value.pauseDownload("");
                }
            }
        }
    }

    public void pauseResByAppid(String str) {
        int i3;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        init();
        synchronized (this.mWadlTasks) {
            Iterator<Map.Entry<String, WadlTask>> it = this.mWadlTasks.entrySet().iterator();
            while (it.hasNext()) {
                WadlTask value = it.next().getValue();
                WadlParams wadlParams = value.mWadlParams;
                if (wadlParams != null) {
                    i3 = wadlParams.from;
                } else {
                    i3 = -1;
                }
                if (str.equals(value.appId) && i3 == 3) {
                    value.pauseDownload("");
                    QLog.d(TAG, 1, "pauseResByAppid appId=" + str + " resName=" + value.mWadlParams.resName);
                }
            }
        }
    }

    public ArrayList<WadlResult> queryAllWadlTask(boolean z16) {
        ArrayList<WadlResult> arrayList = new ArrayList<>();
        init();
        synchronized (this.mWadlTasks) {
            for (WadlTask wadlTask : this.mWadlTasks.values()) {
                if (z16 || wadlTask.bCallback()) {
                    WadlResult wadlResult = wadlTask.getWadlResult(4000);
                    if (z16 || wadlResult.updateTaskStatus()) {
                        arrayList.add(wadlResult);
                    }
                }
            }
        }
        return arrayList;
    }

    public void restartUnfinishedTask() {
        boolean isUnderWifiConnection = WadlUtils.isUnderWifiConnection();
        QLog.d(TAG, 1, "restartUnfinishedTask wifi=" + isUnderWifiConnection);
        init();
        synchronized (this.mWadlTasks) {
            Iterator<Map.Entry<String, WadlTask>> it = this.mWadlTasks.entrySet().iterator();
            while (it.hasNext()) {
                WadlTask value = it.next().getValue();
                WadlParams wadlParams = value.mWadlParams;
                if (value.interruptedFlag) {
                    value.interruptedFlag = false;
                    if (System.currentTimeMillis() - value.createTime > 86400000) {
                        QLog.d(TAG, 1, "restartUnfinishedTask but cost > 24hour appId=" + value.appId);
                    } else {
                        QLog.d(TAG, 1, "restartUnfinishedTask wadlParams=" + wadlParams);
                        if (isUnderWifiConnection) {
                            value.startDownload();
                        } else {
                            value.taskStatus = 5;
                            value.isPausedByWifiDisconnected = true;
                        }
                    }
                }
            }
        }
    }

    public void resumeAllTaskForReConn() {
        init();
        synchronized (this.mWadlTasks) {
            Iterator<Map.Entry<String, WadlTask>> it = this.mWadlTasks.entrySet().iterator();
            while (it.hasNext()) {
                WadlTask value = it.next().getValue();
                QLog.d(TAG, 1, "resumeAllTaskForReConn " + value.simplePrintInfo());
                if (value.isPausedByWifiDisconnected) {
                    value.isPausedByWifiDisconnected = false;
                    value.startDownload();
                }
            }
        }
    }

    public void sendMsgToObservers(WadlResult wadlResult) {
        setChanged();
        notifyObservers(wadlResult);
    }
}
