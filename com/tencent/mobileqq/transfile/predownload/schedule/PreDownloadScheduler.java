package com.tencent.mobileqq.transfile.predownload.schedule;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.automator.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqperf.api.IDeviceOptSwitch;
import com.tencent.mobileqq.qqperf.api.IProcessStats;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.FPSCalculator;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* loaded from: classes19.dex */
public class PreDownloadScheduler implements Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    private static final String KEY_DOWNLOAD_FILE_PATH = "filePath";
    private static final String KEY_DOWNLOAD_SIZE = "size";
    private static final String KEY_DOWNLOAD_URL = "downloadUrl";
    private static final int MSG_CANCEL_PRE_DOWNLOAD = 1003;
    private static final int MSG_DOWNLOAD_ON_APP_BACKGROUD = 1009;
    private static final int MSG_DOWNLOAD_ON_APP_FOREROUD = 1008;
    private static final int MSG_DOWNLOAD_PAUSE_BY_FPS_CPU = 1007;
    private static final int MSG_ON_TASK_END = 1006;
    private static final int MSG_PRE_DOWNLOAD_SUCCESS = 1004;
    private static final int MSG_REQUEST_PRE_DOWNLOAD = 1002;
    private static final int MSG_START_PRE_DOWNLOAD = 1001;
    private static final int MSG_UPDATE_FPS_CPU = 1005;
    private static final String TAG = "PreDownloadScheduler";
    private boolean mAppBackground;
    private boolean mAppLiteStart;
    private boolean mBeReady;
    private boolean mCPUReady;
    private long mCPUReadyCount;
    private double mCPUThreshold;
    private MyComparator mComparator;
    private double mCurCPU;
    private double mCurFPS;
    private long mCurFPSTime;
    private long mCurSuccesSize;
    private String mCurSuccessUrl;
    private PreDownloadItem mCurrentTask;
    private ArrayList<PreDownloadItem> mDownloadList;
    private boolean mEnable;
    private boolean mEnableFPSAndCPU;
    private long mEnableTime;
    private FPSCalculator.a mFPSListener;
    private boolean mFPSReady;
    private long mFPSReadyCount;
    private double mFPSThreshold;
    private Handler mHandler;
    private String mInnerPath;
    private Object mLock;
    private boolean mNeedReport;
    private ArrayList<PreDownloadItem> mPendingList;
    private final PreDownloadConfigHelper mPreDownloadConfigHelper;
    private String mSdcardPath;
    private long mStartTime;
    private long mSysVolatilityCount;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public static class MyComparator implements Comparator {
        static IPatchRedirector $redirector_;

        MyComparator() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, obj, obj2)).intValue();
            }
            PreDownloadItem preDownloadItem = (PreDownloadItem) obj;
            PreDownloadItem preDownloadItem2 = (PreDownloadItem) obj2;
            int i3 = preDownloadItem.businessPriority;
            int i16 = preDownloadItem2.businessPriority;
            if (i3 > i16) {
                return -1;
            }
            if (i3 < i16) {
                return 1;
            }
            int i17 = preDownloadItem.innerPriority;
            int i18 = preDownloadItem2.innerPriority;
            if (i17 > i18) {
                return -1;
            }
            if (i17 < i18) {
                return 1;
            }
            return 0;
        }
    }

    public PreDownloadScheduler(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
            return;
        }
        this.mCurFPSTime = 0L;
        this.mCurFPS = 0.0d;
        this.mCurCPU = 0.0d;
        this.mFPSReadyCount = 0L;
        this.mCPUReadyCount = 0L;
        this.mNeedReport = false;
        this.mAppBackground = false;
        this.mAppLiteStart = false;
        this.mPendingList = new ArrayList<>(10);
        this.mDownloadList = new ArrayList<>(10);
        this.mCurrentTask = null;
        this.mBeReady = false;
        this.mFPSReady = false;
        this.mCPUReady = false;
        this.mHandler = null;
        this.mComparator = new MyComparator();
        this.mEnable = true;
        this.mStartTime = 0L;
        this.mEnableTime = 0L;
        this.mSysVolatilityCount = 6L;
        this.mFPSThreshold = 30.0d;
        this.mCPUThreshold = 50.0d;
        this.mLock = new Object();
        this.mEnableFPSAndCPU = false;
        this.mPreDownloadConfigHelper = new PreDownloadConfigHelper();
        this.mFPSListener = new FPSCalculator.a() { // from class: com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduler.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreDownloadScheduler.this);
                }
            }

            @Override // com.tencent.mobileqq.util.FPSCalculator.a
            public void onInfo(long j3, double d16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Long.valueOf(j3), Double.valueOf(d16));
                    return;
                }
                if (!PreDownloadScheduler.this.mBeReady) {
                    return;
                }
                if (!PreDownloadScheduler.this.mAppBackground) {
                    PreDownloadScheduler.this.mCurFPSTime = j3;
                    PreDownloadScheduler.this.mCurFPS = d16;
                    PreDownloadScheduler.this.mCurCPU = ((IProcessStats) QRoute.api(IProcessStats.class)).getCpuUsage();
                    if (PreDownloadScheduler.this.mCurFPS > PreDownloadScheduler.this.mFPSThreshold) {
                        if (!PreDownloadScheduler.this.mFPSReady) {
                            PreDownloadScheduler.this.mFPSReadyCount++;
                            if (PreDownloadScheduler.this.mFPSReadyCount >= PreDownloadScheduler.this.mSysVolatilityCount) {
                                PreDownloadScheduler.this.mFPSReady = true;
                                PreDownloadScheduler.this.mFPSReadyCount = 0L;
                            }
                        }
                    } else {
                        if (PreDownloadScheduler.this.mCPUReady && PreDownloadScheduler.this.mFPSReady) {
                            Message message = new Message();
                            message.what = 1007;
                            Bundle bundle = new Bundle();
                            bundle.putDouble(PreDownloadConstants.RPORT_KEY_FPS, PreDownloadScheduler.this.mCurFPS);
                            bundle.putDouble(PreDownloadConstants.RPORT_KEY_CPU, PreDownloadScheduler.this.mCurCPU);
                            message.obj = bundle;
                            PreDownloadScheduler.this.mHandler.sendMessage(message);
                        }
                        PreDownloadScheduler.this.mFPSReady = false;
                        PreDownloadScheduler.this.mFPSReadyCount = 0L;
                    }
                    if (PreDownloadScheduler.this.mCurCPU < PreDownloadScheduler.this.mCPUThreshold) {
                        if (!PreDownloadScheduler.this.mCPUReady) {
                            PreDownloadScheduler.this.mCPUReadyCount++;
                            if (PreDownloadScheduler.this.mCPUReadyCount >= PreDownloadScheduler.this.mSysVolatilityCount) {
                                PreDownloadScheduler.this.mCPUReady = true;
                                PreDownloadScheduler.this.mCPUReadyCount = 0L;
                            }
                        }
                    } else {
                        if (PreDownloadScheduler.this.mCPUReady && PreDownloadScheduler.this.mFPSReady) {
                            Message message2 = new Message();
                            message2.what = 1007;
                            Bundle bundle2 = new Bundle();
                            bundle2.putDouble(PreDownloadConstants.RPORT_KEY_FPS, PreDownloadScheduler.this.mCurFPS);
                            bundle2.putDouble(PreDownloadConstants.RPORT_KEY_CPU, PreDownloadScheduler.this.mCurCPU);
                            message2.obj = bundle2;
                            PreDownloadScheduler.this.mHandler.sendMessage(message2);
                        }
                        PreDownloadScheduler.this.mCPUReady = false;
                        PreDownloadScheduler.this.mCPUReadyCount = 0L;
                    }
                } else {
                    PreDownloadScheduler.this.mCPUReady = true;
                    PreDownloadScheduler.this.mFPSReady = true;
                }
                if ((!PreDownloadScheduler.this.mCPUReady || !PreDownloadScheduler.this.mFPSReady) && QLog.isColorLevel()) {
                    QLog.d(PreDownloadScheduler.TAG, 2, "[system info]:,mCurFPSTime=" + PreDownloadScheduler.this.mCurFPSTime + ",mCurFPS=" + PreDownloadScheduler.this.mCurFPS + ",mCurCPU=" + PreDownloadScheduler.this.mCurCPU + ",mFPSReadyCount=" + PreDownloadScheduler.this.mFPSReadyCount + ",mCPUReadyCount=" + PreDownloadScheduler.this.mCPUReadyCount + ",mFPSReady=" + PreDownloadScheduler.this.mFPSReady + ",mCPUReady=" + PreDownloadScheduler.this.mCPUReady);
                }
                PreDownloadScheduler.this.mHandler.sendEmptyMessage(1005);
            }
        };
        init(baseQQAppInterface);
    }

    private void checkStateToStart() {
        int i3;
        int i16;
        if (this.mCurrentTask != null && Math.abs(System.currentTimeMillis() - this.mCurrentTask.startTime) >= 60000) {
            this.mCurrentTask = null;
        }
        synchronized (this.mLock) {
            if (checkState() && this.mCurrentTask == null && this.mPendingList.size() > 0) {
                Collections.sort(this.mPendingList, this.mComparator);
                int startUpCondition = getStartUpCondition();
                int networkType = PreDownloadScheduleUtil.getNetworkType(MobileQQ.sMobileQQ.getApplicationContext());
                if (networkType == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, " [no network] donot start any task! ");
                    }
                    return;
                }
                printDownloadTaskInfo();
                Iterator<PreDownloadItem> it = this.mPendingList.iterator();
                while (it.hasNext()) {
                    PreDownloadItem next = it.next();
                    if (next != null && next.reqCondition == 1 && startUpCondition == 1) {
                        printRemoveTaskInfo(next);
                        it.remove();
                        return;
                    }
                    if (next != null && (((i3 = next.reqCondition) == 2 && !this.mAppBackground) || (((i16 = next.reqNetWork) == 1 && networkType > 1) || ((networkType > 1 && networkType < i16) || (i3 == 3 && !this.mAppLiteStart))))) {
                        printIgnoreTaskInfo(networkType, next);
                    } else {
                        this.mCurrentTask = next;
                        it.remove();
                        break;
                    }
                }
                PreDownloadItem preDownloadItem = this.mCurrentTask;
                if (preDownloadItem != null && preDownloadItem.task != null) {
                    if (this.mStartTime == 0) {
                        this.mStartTime = System.currentTimeMillis();
                    }
                    PreDownloadItem preDownloadItem2 = this.mCurrentTask;
                    preDownloadItem2.startCondition = startUpCondition;
                    preDownloadItem2.startTime = System.currentTimeMillis();
                    this.mCurrentTask.downNetWork = PreDownloadScheduleUtil.getNetworkName(MobileQQ.sMobileQQ.getApplicationContext());
                    PreDownloadItem preDownloadItem3 = this.mCurrentTask;
                    preDownloadItem3.state = 1;
                    preDownloadItem3.task.start();
                    this.mDownloadList.add(this.mCurrentTask);
                    printStartTaskInfo("[start downloading] begin task :", this.mCurrentTask);
                } else {
                    this.mCurrentTask = null;
                }
            }
        }
    }

    private void checkTaskToStopFPSCallback() {
        if (this.mEnableFPSAndCPU) {
            if (this.mPendingList.size() <= 0) {
                FPSCalculator.p().r(this.mFPSListener);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "[fps callback disabled],there is no pending task!");
                }
            }
            if (this.mPendingList.size() > 0) {
                FPSCalculator.p().l(this.mFPSListener);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "[fps callback enabled],there is pending tasks!");
                }
            }
        }
    }

    private void directDownloadItem(PreDownloadItem preDownloadItem) {
        int networkType = PreDownloadScheduleUtil.getNetworkType(MobileQQ.sMobileQQ.getApplicationContext());
        if (networkType <= 1 || networkType >= preDownloadItem.reqNetWork) {
            preDownloadItem.startCondition = getStartUpCondition();
            preDownloadItem.startTime = System.currentTimeMillis();
            preDownloadItem.downNetWork = PreDownloadScheduleUtil.getNetworkName(MobileQQ.sMobileQQ.getApplicationContext());
            preDownloadItem.state = 1;
            preDownloadItem.task.start();
            synchronized (this.mLock) {
                this.mDownloadList.add(preDownloadItem);
            }
            printStartTaskInfo("[start downloading direct without contrl] begin task :", preDownloadItem);
            report(preDownloadItem);
        }
    }

    private int getStartUpCondition() {
        int i3;
        if (a.f199910a) {
            i3 = 1;
        } else if (a.f199911b) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, " getStartUpCondition  condition = " + i3);
        }
        return i3;
    }

    private void handleMessageForCancelPreDownload(Message message) {
        String str = (String) message.obj;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.mLock) {
                Iterator<PreDownloadItem> it = this.mPendingList.iterator();
                while (it.hasNext()) {
                    PreDownloadItem next = it.next();
                    if (str.equals(next.downloadUrl)) {
                        it.remove();
                        next.state = 3;
                        report(next);
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 1, "[ msg cancel] task.url = " + next.downloadUrl);
                        }
                        if (next == this.mCurrentTask) {
                            this.mCurrentTask = null;
                        }
                        checkTaskToStopFPSCallback();
                    }
                }
            }
        }
        checkStateToStart();
    }

    private void handleMessageForDownloadSuccess(Message message) {
        if (message == null) {
            return;
        }
        Bundle data = message.getData();
        String string = data.getString("downloadUrl", "");
        int i3 = data.getInt("size", -1);
        if (!TextUtils.isEmpty(string)) {
            synchronized (this.mLock) {
                Iterator<PreDownloadItem> it = this.mDownloadList.iterator();
                while (it.hasNext()) {
                    PreDownloadItem next = it.next();
                    if (string.equals(next.downloadUrl)) {
                        next.downloadSize = i3;
                        next.downloadTime = System.currentTimeMillis() - next.startTime;
                        next.state = 2;
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 1, "[msg download sucess] task.url = " + next.downloadUrl);
                        }
                        report(next);
                        it.remove();
                        if (next == this.mCurrentTask) {
                            this.mCurrentTask = null;
                        }
                    }
                }
            }
        }
        checkStateToStart();
    }

    private void handleMessageForOnTaskEnd(Message message) {
        AbsPreDownloadTask absPreDownloadTask;
        AbsPreDownloadTask absPreDownloadTask2 = (AbsPreDownloadTask) message.obj;
        PreDownloadItem preDownloadItem = this.mCurrentTask;
        if (preDownloadItem != null && (absPreDownloadTask = preDownloadItem.task) != null && absPreDownloadTask2 != null && absPreDownloadTask == absPreDownloadTask2) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, " pre download onTaskEnd task key = " + this.mCurrentTask.task.key);
            }
            this.mCurrentTask = null;
        }
        checkStateToStart();
    }

    private void handleMessageForRequestPreDownload(Message message) {
        boolean z16;
        String str;
        String str2;
        PreDownloadItem preDownloadItem = (PreDownloadItem) message.obj;
        if (this.mEnable) {
            synchronized (this.mLock) {
                for (int i3 = 0; i3 < this.mPendingList.size(); i3++) {
                    PreDownloadItem preDownloadItem2 = this.mPendingList.get(i3);
                    if (preDownloadItem.downloadUrl.equals(preDownloadItem2.downloadUrl)) {
                        if (preDownloadItem.downloadUrl.contains("doodle") && (str2 = preDownloadItem.filePath) != null && !str2.equals(preDownloadItem2.filePath)) {
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "mPendingList, same url, filePath diff, ", preDownloadItem.downloadUrl);
                            }
                        } else {
                            z16 = true;
                            break;
                        }
                    }
                }
                z16 = false;
                for (int i16 = 0; i16 < this.mDownloadList.size(); i16++) {
                    PreDownloadItem preDownloadItem3 = this.mDownloadList.get(i16);
                    if (preDownloadItem.downloadUrl.equals(preDownloadItem3.downloadUrl)) {
                        if (preDownloadItem.downloadUrl.contains("doodle") && (str = preDownloadItem.filePath) != null && !str.equals(preDownloadItem3.filePath)) {
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "downloadUrl, same url, filePath diff, ", preDownloadItem.downloadUrl);
                            }
                        } else {
                            z16 = true;
                            break;
                        }
                    }
                }
                if (!z16) {
                    this.mPendingList.add(preDownloadItem);
                }
            }
        } else {
            directDownloadItem(preDownloadItem);
        }
        checkStateToStart();
        checkTaskToStopFPSCallback();
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 1, " [msg request add to list]  mPendingList size = " + this.mPendingList.size());
        }
    }

    private void handleMessageForStartPreDownload() {
        this.mBeReady = true;
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 1, "startPreDownload mBeReady set true, all pre download will start ");
        }
        SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences(PreDownloadConstants.SP_PRE_DOWNLOAD, 0);
        int i3 = sharedPreferences.getInt(PreDownloadConstants.SP_KEY_PRE_DOWNLOAD_VERSION, 0);
        if (i3 != this.mPreDownloadConfigHelper.getVersion()) {
            PreDownloadConfigHelper preDownloadConfigHelper = this.mPreDownloadConfigHelper;
            List<String> cleanOnVersionUpdate = preDownloadConfigHelper.cleanOnVersionUpdate(i3, preDownloadConfigHelper.getVersion());
            if (cleanOnVersionUpdate != null && !cleanOnVersionUpdate.isEmpty()) {
                for (int i16 = 0; i16 < cleanOnVersionUpdate.size(); i16++) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 1, "[onVersionUpdate PreDownloadScheduler]  delete file: " + cleanOnVersionUpdate.get(i16));
                    }
                    FileUtils.delete(cleanOnVersionUpdate.get(i16), false);
                }
            }
        }
        sharedPreferences.edit().putInt(PreDownloadConstants.SP_KEY_PRE_DOWNLOAD_VERSION, this.mPreDownloadConfigHelper.getVersion()).apply();
        checkStateToStart();
        checkTaskToStopFPSCallback();
    }

    private void printDownloadTaskInfo() {
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder("pending task id:");
            synchronized (this.mLock) {
                for (int i3 = 0; i3 < this.mPendingList.size(); i3++) {
                    PreDownloadItem preDownloadItem = this.mPendingList.get(i3);
                    if (preDownloadItem != null) {
                        sb5.append(preDownloadItem.businessID);
                        sb5.append(",");
                    }
                }
            }
            QLog.d(TAG, 2, sb5.toString());
        }
    }

    private void printIgnoreTaskInfo(int i3, PreDownloadItem preDownloadItem) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[network or reqconditon not fit] donot download task :\n,businessID=" + preDownloadItem.businessID + ",businessName=" + preDownloadItem.businessName + ",downloadUrl=" + preDownloadItem.downloadUrl + ",reqCondition=" + preDownloadItem.reqCondition + ",current appBackground=" + this.mAppBackground + ",reqNetWork=" + preDownloadItem.reqNetWork + ",current netWorkType=" + i3);
        }
    }

    private void printRemoveTaskInfo(PreDownloadItem preDownloadItem) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[forbidden on first start] remove task :\n,businessID=" + preDownloadItem.businessID + ",businessName=" + preDownloadItem.businessName + ",downloadUrl=" + preDownloadItem.downloadUrl + ",reqCondition=" + preDownloadItem.reqCondition);
        }
    }

    private void printStartTaskInfo(String str, PreDownloadItem preDownloadItem) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, str + ",businessID=" + preDownloadItem.businessID + ",businessName=" + preDownloadItem.businessName + ",downloadUrl=" + preDownloadItem.downloadUrl + ",fileKey=" + preDownloadItem.fileKey);
        }
    }

    private void report(PreDownloadItem preDownloadItem) {
        HashMap<String, String> hashMap;
        if (!this.mNeedReport) {
            return;
        }
        HashMap<String, String> hashMap2 = new HashMap<>(20);
        hashMap2.put(PreDownloadConstants.RPORT_KEY_BUSINESS_ID, String.valueOf(preDownloadItem.businessID));
        hashMap2.put(PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, preDownloadItem.businessName);
        hashMap2.put(PreDownloadConstants.RPORT_KEY_BUSINESS_ENG_NAME, preDownloadItem.businessEngName);
        hashMap2.put(PreDownloadConstants.RPORT_KEY_BUSINESS_DEPARTMENT, preDownloadItem.department);
        hashMap2.put(PreDownloadConstants.RPORT_KEY_FILE_KEY, preDownloadItem.fileKey);
        hashMap2.put("downloadUrl", preDownloadItem.downloadUrl);
        hashMap2.put("filePath", preDownloadItem.filePath);
        hashMap2.put(PreDownloadConstants.RPORT_KEY_REQ_TIME, String.valueOf(preDownloadItem.reqTime));
        hashMap2.put(PreDownloadConstants.RPORT_KEY_REQ_NETWORK, String.valueOf(preDownloadItem.reqNetWork));
        hashMap2.put(PreDownloadConstants.RPORT_KEY_DOWNLOAD_NETWORK, String.valueOf(preDownloadItem.downNetWork));
        hashMap2.put("startTime", String.valueOf(preDownloadItem.startTime));
        hashMap2.put(PreDownloadConstants.RPORT_KEY_DOWNLOAD_TIME, String.valueOf(preDownloadItem.downloadTime));
        hashMap2.put("downloadSize", String.valueOf(preDownloadItem.downloadSize));
        hashMap2.put(PreDownloadConstants.RPORT_KEY_BUSINESS_PRIORITY, String.valueOf(preDownloadItem.businessPriority));
        hashMap2.put(PreDownloadConstants.RPORT_KEY_INNER_PRIORITY, String.valueOf(preDownloadItem.innerPriority));
        hashMap2.put("state", String.valueOf(preDownloadItem.state));
        hashMap2.put(PreDownloadConstants.RPORT_KEY_REQ_CONDITION, String.valueOf(preDownloadItem.reqCondition));
        hashMap2.put(PreDownloadConstants.RPORT_KEY_START_CONDITION, String.valueOf(preDownloadItem.startCondition));
        hashMap2.put(PreDownloadConstants.RPORT_KEY_SAVE_ON_SD, String.valueOf(preDownloadItem.saveOnSD));
        if (QLog.isColorLevel()) {
            hashMap = hashMap2;
            QLog.d(TAG, 2, "[report item]:, " + PreDownloadConstants.RPORT_KEY_BUSINESS_ID + ContainerUtils.KEY_VALUE_DELIMITER + preDownloadItem.businessID + ", " + PreDownloadConstants.RPORT_KEY_BUSINESS_NAME + ContainerUtils.KEY_VALUE_DELIMITER + preDownloadItem.businessName + ", " + PreDownloadConstants.RPORT_KEY_BUSINESS_ENG_NAME + ContainerUtils.KEY_VALUE_DELIMITER + preDownloadItem.businessEngName + ", " + PreDownloadConstants.RPORT_KEY_BUSINESS_DEPARTMENT + ContainerUtils.KEY_VALUE_DELIMITER + preDownloadItem.department + ", " + PreDownloadConstants.RPORT_KEY_FILE_KEY + ContainerUtils.KEY_VALUE_DELIMITER + preDownloadItem.fileKey + ", downloadUrl" + ContainerUtils.KEY_VALUE_DELIMITER + preDownloadItem.downloadUrl + ", filePath" + ContainerUtils.KEY_VALUE_DELIMITER + preDownloadItem.filePath + ", " + PreDownloadConstants.RPORT_KEY_REQ_TIME + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(preDownloadItem.reqTime) + ", " + PreDownloadConstants.RPORT_KEY_REQ_NETWORK + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(preDownloadItem.reqNetWork) + ", " + PreDownloadConstants.RPORT_KEY_DOWNLOAD_NETWORK + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(preDownloadItem.downNetWork) + ", startTime" + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(preDownloadItem.startTime) + ", " + PreDownloadConstants.RPORT_KEY_DOWNLOAD_TIME + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(preDownloadItem.downloadTime) + ", downloadSize" + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(preDownloadItem.downloadSize) + ", " + PreDownloadConstants.RPORT_KEY_BUSINESS_PRIORITY + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(preDownloadItem.businessPriority) + ", " + PreDownloadConstants.RPORT_KEY_INNER_PRIORITY + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(preDownloadItem.innerPriority) + ", state" + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(preDownloadItem.state) + ", " + PreDownloadConstants.RPORT_KEY_REQ_CONDITION + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(preDownloadItem.reqCondition) + ", " + PreDownloadConstants.RPORT_KEY_START_CONDITION + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(preDownloadItem.startCondition) + ", " + PreDownloadConstants.RPORT_KEY_SAVE_ON_SD + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(preDownloadItem.saveOnSD));
        } else {
            hashMap = hashMap2;
        }
        StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(null, PreDownloadConstants.REPORT_TAG, true, 0L, 0L, hashMap, null);
    }

    private void reportPauseInfo(double d16, double d17, String str, long j3) {
        if (!this.mNeedReport) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>(4);
        hashMap.put("downloadUrl", str);
        hashMap.put("downloadSize", String.valueOf(j3));
        hashMap.put(PreDownloadConstants.RPORT_KEY_CPU, String.valueOf(d17));
        hashMap.put(PreDownloadConstants.RPORT_KEY_FPS, String.valueOf(d16));
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[report puse info]:, downloadUrl" + ContainerUtils.KEY_VALUE_DELIMITER + str + ", downloadSize" + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(j3) + ", " + PreDownloadConstants.RPORT_KEY_CPU + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(d17) + ", " + PreDownloadConstants.RPORT_KEY_FPS + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(d16));
        }
        StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(null, PreDownloadConstants.REPORT_TAG_PASUE, true, 0L, 0L, hashMap, null);
    }

    public AbsPreDownloadTask cancelPreDownload(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AbsPreDownloadTask) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 1, "[ cancelPreDownload ] downloadUrl = " + str);
        }
        AbsPreDownloadTask absPreDownloadTask = null;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.mLock) {
                for (int i3 = 0; i3 < this.mPendingList.size(); i3++) {
                    PreDownloadItem preDownloadItem = this.mPendingList.get(i3);
                    if (str.equals(preDownloadItem.downloadUrl)) {
                        absPreDownloadTask = preDownloadItem.task;
                    }
                }
            }
            Message message = new Message();
            message.what = 1003;
            message.obj = str;
            this.mHandler.sendMessage(message);
        }
        return absPreDownloadTask;
    }

    public boolean checkState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (!this.mEnable || this.mBeReady) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[System busy] dowload not ready!");
        }
        if (this.mPendingList.size() > 0 && Math.abs(System.currentTimeMillis() - this.mEnableTime) >= 60000 && this.mStartTime == 0) {
            this.mSysVolatilityCount -= 2;
            this.mCPUThreshold += 10.0d;
            this.mFPSThreshold -= 10.0d;
            this.mFPSReady = true;
            this.mCPUReady = true;
            this.mBeReady = true;
            QLog.d(TAG, 2, "[System busy] for 60 seconds after pull msg, set download enable");
            QLog.d(TAG, 2, "mCPUThreshold = " + this.mCPUThreshold + ",mFPSThreshold=" + this.mFPSThreshold);
            return true;
        }
        return false;
    }

    public String getPreDownloadPath(int i3, String str, boolean z16) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), str, Boolean.valueOf(z16));
        }
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "department should not be empty");
            }
            return null;
        }
        String str3 = this.mPreDownloadConfigHelper.getBusinessNameEng().get(Integer.valueOf(i3));
        if (TextUtils.isEmpty(str3)) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "Should define english name in PreDownloadConstants.BUSINESS_NAME_ENG for business");
            }
            return null;
        }
        if (z16) {
            str2 = this.mSdcardPath;
        } else {
            str2 = this.mInnerPath;
        }
        String str4 = str2 + str + "/" + str3;
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 1, "[getPreDownloadPath] path = " + str4);
        }
        return str4;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) message)).booleanValue();
        }
        switch (message.what) {
            case 1001:
                handleMessageForStartPreDownload();
                return true;
            case 1002:
                handleMessageForRequestPreDownload(message);
                return true;
            case 1003:
                handleMessageForCancelPreDownload(message);
                return true;
            case 1004:
                handleMessageForDownloadSuccess(message);
                return true;
            case 1005:
                checkStateToStart();
                checkTaskToStopFPSCallback();
                return true;
            case 1006:
                handleMessageForOnTaskEnd(message);
                return true;
            case 1007:
                Bundle bundle = (Bundle) message.obj;
                reportPauseInfo(bundle.getDouble(PreDownloadConstants.RPORT_KEY_FPS), bundle.getDouble(PreDownloadConstants.RPORT_KEY_CPU), this.mCurSuccessUrl, this.mCurSuccesSize);
                return true;
            case 1008:
            case 1009:
                checkStateToStart();
                return true;
            default:
                return true;
        }
    }

    public void init(BaseQQAppInterface baseQQAppInterface) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseQQAppInterface);
            return;
        }
        this.mHandler = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
        this.mInnerPath = MobileQQ.sMobileQQ.getFilesDir() + PreDownloadConstants.INNER_DIR;
        File file = new File(this.mInnerPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + PreDownloadConstants.SDCRAD_DIR;
        this.mSdcardPath = str;
        this.mSdcardPath = VFSAssistantUtils.getSDKPrivatePath(str);
        File file2 = new File(this.mSdcardPath);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        this.mSysVolatilityCount = 6L;
        this.mFPSThreshold = 30.0d;
        this.mCPUThreshold = 50.0d;
        SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences(PreDownloadConstants.SP_PRE_DOWNLOAD, 0);
        boolean z17 = sharedPreferences.getBoolean(PreDownloadConstants.SP_KEY_PRE_SAMPLE_MARK, false);
        QLog.e(TAG, 1, " pre download bSampledLastTime = " + z17);
        double random = Math.random();
        if (9.999999747378752E-6d >= random) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mNeedReport = z16;
        QLog.e(TAG, 1, " pre download random = " + random);
        if (z17) {
            this.mNeedReport = true;
            sharedPreferences.edit().putBoolean(PreDownloadConstants.SP_KEY_PRE_SAMPLE_MARK, false).commit();
            QLog.e(TAG, 1, " pre download last time sampled, also sampled this time");
        } else {
            sharedPreferences.edit().putBoolean(PreDownloadConstants.SP_KEY_PRE_SAMPLE_MARK, this.mNeedReport).commit();
        }
        QLog.e(TAG, 1, " pre download set mNeedReport = " + this.mNeedReport);
    }

    public void onAppBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.mAppBackground = true;
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 1, "[ onAppBackground ] mAppBackground = " + this.mAppBackground);
        }
        Message message = new Message();
        message.what = 1009;
        this.mHandler.sendMessage(message);
    }

    public void onAppForground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.mCPUReady = false;
        this.mFPSReady = false;
        this.mAppBackground = false;
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 1, "[ onAppForground ] mAppBackground = " + this.mAppBackground);
        }
        Message message = new Message();
        message.what = 1008;
        this.mHandler.sendMessage(message);
    }

    public void onAppLiteStart(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.mAppLiteStart = z16;
        }
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (this.mEnableFPSAndCPU) {
            FPSCalculator.p().r(this.mFPSListener);
        }
        this.mHandler.removeCallbacksAndMessages(Boolean.TRUE);
        synchronized (this.mLock) {
            ArrayList<PreDownloadItem> arrayList = this.mPendingList;
            arrayList.removeAll(arrayList);
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("task_cancel_when_destroy", true);
            ArrayList arrayList2 = new ArrayList(this.mDownloadList);
            if (isSwitchOn) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    PreDownloadItem preDownloadItem = (PreDownloadItem) it.next();
                    if (preDownloadItem != null) {
                        QLog.d(TAG, 1, "cancel task when destroy: ", preDownloadItem.downloadUrl);
                        preDownloadItem.task.cancel();
                    }
                }
            }
            ArrayList<PreDownloadItem> arrayList3 = this.mDownloadList;
            arrayList3.removeAll(arrayList3);
        }
    }

    public void onTaskEnd(AbsPreDownloadTask absPreDownloadTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) absPreDownloadTask);
            return;
        }
        Message message = new Message();
        message.what = 1006;
        message.obj = absPreDownloadTask;
        this.mHandler.sendMessage(message);
    }

    public void preDownloadSuccess(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Long.valueOf(j3));
            return;
        }
        QLog.e(TAG, 2, "[ preDownloadSuccess ] downloadUrl = " + str + ",size = " + j3);
        preDownloadSuccess(str, new ArrayList<>(), j3);
    }

    public boolean requestPreDownload(int i3, String str, String str2, int i16, String str3, String str4, int i17, int i18, boolean z16, AbsPreDownloadTask absPreDownloadTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, str2, Integer.valueOf(i16), str3, str4, Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16), absPreDownloadTask)).booleanValue();
        }
        if (((IDeviceOptSwitch) QRoute.api(IDeviceOptSwitch.class)).isDisablePreDownload() && !((IDeviceOptSwitch) QRoute.api(IDeviceOptSwitch.class)).getPreDownloadWhiteList().contains(Integer.valueOf(i3)) && !this.mPreDownloadConfigHelper.getPreDownloadWhiteList().contains(Integer.valueOf(i3))) {
            if (QLog.isColorLevel()) {
                QLog.d("Perf", 2, "delay pre_download,busindessID:" + i3);
            }
            ((IDeviceOptSwitch) QRoute.api(IDeviceOptSwitch.class)).setDisablePreDownloadTime(System.currentTimeMillis());
            return false;
        }
        if (i3 != 0 && !TextUtils.isEmpty(str3) && absPreDownloadTask != null) {
            String str5 = this.mPreDownloadConfigHelper.getBusinessName().get(Integer.valueOf(i3));
            if (TextUtils.isEmpty(str5)) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 1, "Should define name in PreDownloadConstants.BUSINESS_NAME for business");
                }
                return false;
            }
            String str6 = this.mPreDownloadConfigHelper.getBusinessNameEng().get(Integer.valueOf(i3));
            if (TextUtils.isEmpty(str6)) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 1, "Should define english name in PreDownloadConstants.BUSINESS_NAME_ENG for business");
                }
                return false;
            }
            Integer num = this.mPreDownloadConfigHelper.getBusinessPriority().get(Integer.valueOf(i3));
            if (num == null) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 1, "Should define priority in PreDownloadConstants.BUSINESS_PRIORITY for business");
                }
                return false;
            }
            int intValue = num.intValue();
            if (intValue >= 0 && intValue <= 4) {
                PreDownloadItem preDownloadItem = new PreDownloadItem();
                preDownloadItem.businessID = i3;
                preDownloadItem.businessName = str5;
                preDownloadItem.businessEngName = str6;
                preDownloadItem.department = str;
                preDownloadItem.fileKey = str2;
                preDownloadItem.downloadUrl = str3;
                preDownloadItem.reqNetWork = i17;
                preDownloadItem.innerPriority = i16;
                preDownloadItem.filePath = str4;
                preDownloadItem.state = 0;
                preDownloadItem.reqTime = System.currentTimeMillis();
                preDownloadItem.businessPriority = intValue;
                preDownloadItem.reqCondition = i18;
                preDownloadItem.saveOnSD = z16;
                preDownloadItem.task = absPreDownloadTask;
                Message message = new Message();
                message.what = 1002;
                message.obj = preDownloadItem;
                this.mHandler.sendMessage(message);
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 1, "[ requestPreDownload ]  downloadUrl = " + str3);
                }
                return checkState();
            }
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, " requestPreDownload param priority error,priority value should be in[0,1,2,3,4]!");
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 1, "requestPreDownload param error! busindessID=0 or downloadUrl is empty or task is empty\n");
        }
        return false;
    }

    public void setEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
            return;
        }
        this.mEnable = z16;
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 1, "[setEnable] enable = " + this.mEnable);
        }
    }

    public void startPreDownload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.mEnableTime = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 1, "[ startPreDownload ] enable time = " + this.mEnableTime);
        }
        if (this.mEnable) {
            this.mHandler.sendEmptyMessageDelayed(1001, 10000L);
        } else {
            this.mHandler.sendEmptyMessage(1001);
        }
    }

    public void preDownloadSuccess(String str, ArrayList<String> arrayList, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, arrayList, Long.valueOf(j3));
            return;
        }
        QLog.d(TAG, 2, "[ preDownloadSuccess ] downloadUrl = " + str + ",downloadFinalPaths = " + arrayList + ",size = " + j3);
        this.mCurSuccessUrl = str;
        this.mCurSuccesSize = j3;
        Message message = new Message();
        message.what = 1004;
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("filePath", arrayList);
        bundle.putString("downloadUrl", str);
        bundle.putInt("size", (int) j3);
        message.setData(bundle);
        this.mHandler.sendMessage(message);
    }
}
