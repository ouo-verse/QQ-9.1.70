package com.tencent.gamecenter.wadl.sdk.dlmgr;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.impl.WadlProxyService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterReceiver;
import com.tencent.gamecenter.wadl.notification.j;
import com.tencent.gamecenter.wadl.sdk.app.WadlVMReportManager;
import com.tencent.gamecenter.wadl.sdk.db.WadlDBHelperFactory;
import com.tencent.gamecenter.wadl.sdk.db.WadlVMDBHelper;
import com.tencent.gamecenter.wadl.sdk.dlcom.WadlUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlVMTaskManager extends Observable implements IManager {
    protected static final String TAG = "VM_WadlVMTaskManager";
    private WadlVMDBHelper dbHelper;
    private j notification;
    private final List<WadlTask> taskList = new ArrayList();
    private final long oneDay = 86400000;
    private volatile AtomicBoolean mInit = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static WadlVMTaskManager f107256a = new WadlVMTaskManager();
    }

    WadlVMTaskManager() {
        long currentTimeMillis = System.currentTimeMillis();
        QLog.i(TAG, 1, "init begin");
        this.dbHelper = (WadlVMDBHelper) WadlDBHelperFactory.getDBHelper(3);
        this.notification = new j();
        addObserver(this.dbHelper);
        QLog.i(TAG, 1, "init end, cost=" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public static WadlVMTaskManager getInstance() {
        return a.f107256a;
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
                    if (WadlUtils.isRuningTask(wadlTask.taskStatus)) {
                        wadlTask.taskStatus = 5;
                        wadlTask.interruptedFlag = true;
                    } else {
                        int i3 = wadlTask.taskStatus;
                        if (i3 == 7) {
                            wadlTask.taskStatus = 5;
                        } else if (i3 == 9) {
                            wadlTask.taskStatus = 6;
                        }
                    }
                    if (wadlTask.taskStatus == 6 && !WadlUtils.fileExists(wadlTask.downloadFilePath)) {
                        wadlTask.taskStatus = 0;
                    }
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

    private void notifyTaskComplete(WadlResult wadlResult, int i3) {
        Intent intent = new Intent(WadlProxyConsts.ACTION_GAME_CENTER_DYNAMIC_ACTION);
        intent.setPackage(MobileQQ.sMobileQQ.getPackageName());
        intent.putExtra("key_event_id", 7);
        intent.putExtra(GameCenterReceiver.KEY_WADL_RESULT, wadlResult);
        intent.putExtra(GameCenterReceiver.KEY_BUSINESS_ID, i3);
        MobileQQ.sMobileQQ.sendBroadcast(intent);
    }

    private void notifyTaskDelete(String str, String str2, int i3) {
        Intent intent = new Intent(WadlProxyConsts.ACTION_GAME_CENTER_DYNAMIC_ACTION);
        intent.setPackage(MobileQQ.sMobileQQ.getPackageName());
        intent.putExtra("key_event_id", 2);
        intent.putExtra("key_appid", str);
        intent.putExtra(GameCenterReceiver.KEY_PKG_NAME, str2);
        intent.putExtra(GameCenterReceiver.KEY_BUSINESS_ID, i3);
        MobileQQ.sMobileQQ.sendBroadcast(intent);
    }

    private void notifyTaskInstall(WadlResult wadlResult, int i3) {
        Intent intent = new Intent(WadlProxyConsts.ACTION_GAME_CENTER_DYNAMIC_ACTION);
        intent.setPackage(MobileQQ.sMobileQQ.getPackageName());
        intent.putExtra("key_event_id", 8);
        intent.putExtra(GameCenterReceiver.KEY_WADL_RESULT, wadlResult);
        intent.putExtra(GameCenterReceiver.KEY_BUSINESS_ID, i3);
        MobileQQ.sMobileQQ.sendBroadcast(intent);
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

    public void appInstalled(String str) {
        QLog.d(TAG, 1, "appInstalled:" + str);
        init();
        ArrayList arrayList = new ArrayList();
        synchronized (this.taskList) {
            Iterator<WadlTask> it = this.taskList.iterator();
            while (it.hasNext()) {
                if (it.next().onPackageInstalled(str)) {
                    arrayList.add(str);
                }
            }
        }
        if (arrayList.size() < 1) {
            QLog.d(TAG, 1, "appInstalled,no matching packageName task:" + str);
            return;
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            deleteWadlTask((String) it5.next(), false);
        }
    }

    public void deleteWadlTask(String str, boolean z16) {
        boolean z17;
        QLog.d(TAG, 1, "deleteWadlTask pkgName=" + str + ",isNotify=" + z16);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        init();
        synchronized (this.taskList) {
            Iterator<WadlTask> it = this.taskList.iterator();
            while (true) {
                if (it.hasNext()) {
                    WadlTask next = it.next();
                    if (str.equals(next.mWadlParams.packageName)) {
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
        QLog.d(TAG, 1, "deleteWadlTask pkgName=" + str + ",result=" + z17);
    }

    public WadlTask findTaskByPkgName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
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

    public List<WadlTask> getAllWadlTask() {
        init();
        ArrayList arrayList = new ArrayList();
        synchronized (this.taskList) {
            arrayList.addAll(this.taskList);
        }
        return arrayList;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.dlmgr.IManager
    public void notifyEventObserver(int i3, boolean z16, WadlTask wadlTask) {
        QLog.d(TAG, 1, "notifyEventOberver event=" + i3 + ",callback=" + z16 + ",wadlTask=" + wadlTask.simplePrintInfo());
        WadlVMReportManager.reportDC(i3, wadlTask);
        WadlResult wadlResult = wadlTask.getWadlResult(i3);
        sendMsgToObservers(wadlResult);
        if (i3 == 2002) {
            notifyTaskInstall(wadlResult, 3);
        } else if (i3 == 1007) {
            WadlParams wadlParams = wadlResult.wadlParams;
            notifyTaskDelete(wadlParams.appId, wadlParams.packageName, 3);
        } else if (i3 == 1008) {
            notifyTaskComplete(wadlResult, 3);
        }
        if (!z16) {
            return;
        }
        this.notification.y(wadlResult);
        WadlProxyService c16 = WadlProxyService.c();
        if (c16 != null) {
            c16.h(i3, wadlTask);
        }
    }

    public void onDestroy() {
        pauseAllDownloadTask(false);
        deleteObservers();
        this.notification.x();
    }

    public void pauseAllDownloadTask(boolean z16) {
        QLog.d(TAG, 1, "pauseAllDownloadTask isPausedByNet=" + z16);
        init();
        if (!z16) {
            deleteObserver(this.dbHelper);
        }
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
                    wadlTask.pauseDownload("");
                }
            }
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

    public ArrayList<WadlResult> queryWadlTaskByBid(String str) {
        ArrayList<WadlResult> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        init();
        synchronized (this.taskList) {
            for (WadlTask wadlTask : this.taskList) {
                if (str.equals(Integer.valueOf(wadlTask.businessId)) && wadlTask.bCallback()) {
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
}
