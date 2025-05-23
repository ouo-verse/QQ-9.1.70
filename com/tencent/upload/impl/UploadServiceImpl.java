package com.tencent.upload.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.PowerManager;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.network.route.DebugServerRoute;
import com.tencent.upload.network.route.RouteFactory;
import com.tencent.upload.network.route.ServerRouteTable;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadEnv;
import com.tencent.upload.uinterface.IUploadLog;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.IUploadSoLoader;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.UploadLog;
import com.tencent.upload.utils.pool.ThreadPool;
import com.tencent.upload.utils.pool.UploadThreadManager;
import com.tencent.upload.utils.watcher.UploadFlowTracker;
import cooperation.qzone.QZoneHelper;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UploadServiceImpl implements IUploadService {
    static IPatchRedirector $redirector_ = null;
    private static final int CLOSE_TIME = 120000;
    private static final String TAG = "UploadServiceImpl";
    private static volatile boolean mInit;
    private static volatile UploadServiceImpl sInstance;
    private ImageUploadService mImageUploadService;
    private OtherUploadService mLogUploadService;
    private OtherUploadService mOtherUploadService;
    private Timer mTimer;
    private PowerManager.WakeLock mWakeLock;
    private WifiManager.WifiLock mWifiLock;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class CloseServiceTask extends TimerTask {
        static IPatchRedirector $redirector_;

        CloseServiceTask() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UploadServiceImpl.this);
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                UploadServiceImpl.this.check2doClose();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    UploadServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mWifiLock = null;
        ThreadPool workThreadPool = UploadThreadManager.getInstance().getWorkThreadPool();
        this.mImageUploadService = new ImageUploadService(workThreadPool);
        this.mOtherUploadService = new OtherUploadService(workThreadPool);
        this.mLogUploadService = new OtherUploadService(workThreadPool);
        mInit = true;
    }

    @SuppressLint({"InlinedApi"})
    private void acquireWakeLockIfNot() {
        if (!UploadGlobalConfig.getConfig().canHoldSystemLock()) {
            return;
        }
        if (this.mWakeLock == null) {
            PowerManager.WakeLock newWakeLock = ((PowerManager) UploadGlobalConfig.getContext().getSystemService("power")).newWakeLock(1, TAG);
            this.mWakeLock = newWakeLock;
            newWakeLock.acquire();
            UploadLog.d(TAG, "acquireWakeLock()");
        }
        if (this.mWifiLock == null) {
            this.mWifiLock = ((WifiManager) UploadGlobalConfig.getContext().getApplicationContext().getSystemService("wifi")).createWifiLock(3, TAG);
            UploadLog.d(TAG, "acquireWifiLock()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void check2doClose() {
        if (isUploadIdle()) {
            doClose();
        }
    }

    public static UploadServiceImpl getInstance() {
        if (sInstance == null) {
            synchronized (UploadServiceImpl.class) {
                if (sInstance == null) {
                    sInstance = new UploadServiceImpl();
                }
            }
        }
        return sInstance;
    }

    private void releaseWakeLockIfExist() {
        if (!UploadGlobalConfig.getConfig().canHoldSystemLock()) {
            return;
        }
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.mWakeLock.release();
            this.mWakeLock = null;
            UploadLog.d(TAG, "releaseWakeLock()");
        }
        WifiManager.WifiLock wifiLock = this.mWifiLock;
        if (wifiLock != null && wifiLock.isHeld()) {
            this.mWifiLock.release();
            this.mWifiLock = null;
            UploadLog.d(TAG, "releaseWifiLock()");
        }
    }

    private void setCloseTimer() {
        UploadLog.v(TAG, "setCloseTimer()");
        if (this.mTimer == null) {
            UploadLog.v(TAG, " set real timer, tick tic t ...");
            this.mTimer = new BaseTimer(true);
            this.mTimer.schedule(new CloseServiceTask(), 120000L, 120000L);
        }
    }

    @Override // com.tencent.upload.uinterface.IUploadService
    public boolean cancel(AbstractUploadTask abstractUploadTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) abstractUploadTask)).booleanValue();
        }
        if (abstractUploadTask == null) {
            return false;
        }
        if (UploadTaskManager.getFileType(abstractUploadTask) == Const.FileType.Photo) {
            this.mImageUploadService.cancel(abstractUploadTask);
        } else if (UploadTaskManager.getFileType(abstractUploadTask) == Const.FileType.Log) {
            this.mLogUploadService.upload(abstractUploadTask);
        } else {
            this.mOtherUploadService.cancel(abstractUploadTask);
        }
        UploadFlowTracker.trackCancel(abstractUploadTask);
        return true;
    }

    @Override // com.tencent.upload.uinterface.IUploadService
    public boolean clearCacheWhenIdle(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) context)).booleanValue();
        }
        UploadLog.d(TAG, "clearCacheWhenIdle");
        FileUtils.clearUploadDir(context, 0L, 0L);
        return true;
    }

    @Override // com.tencent.upload.uinterface.IUploadService
    public boolean commit(AbstractUploadTask abstractUploadTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) abstractUploadTask)).booleanValue();
        }
        if (abstractUploadTask == null) {
            UploadLog.d(TAG, "commit() task==null");
            return false;
        }
        return true;
    }

    public void doClose() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        UploadLog.v(TAG, "doClose called.");
        if (!mInit) {
            return;
        }
        UploadLog.v(TAG, "doClose --- R.I.P");
        mInit = false;
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
        releaseWakeLockIfExist();
        this.mImageUploadService.close();
        this.mLogUploadService.close();
        this.mOtherUploadService.close();
        FileUtils.clearUploadDir(UploadGlobalConfig.getContext(), GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV, QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT);
    }

    @Override // com.tencent.upload.uinterface.IUploadService
    public void init(Context context, IUploadConfig iUploadConfig, IUploadLog iUploadLog, IUploadReport iUploadReport, IUploadEnv iUploadEnv, IUploadSoLoader iUploadSoLoader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, iUploadConfig, iUploadLog, iUploadReport, iUploadEnv, iUploadSoLoader);
        }
    }

    @Override // com.tencent.upload.uinterface.IUploadService
    public boolean isInitialized() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return mInit;
    }

    public boolean isUploadIdle() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (this.mImageUploadService.isUploadIdle() && this.mOtherUploadService.isUploadIdle() && this.mLogUploadService.isUploadIdle()) {
            z16 = true;
        } else {
            z16 = false;
        }
        UploadLog.d(TAG, "isUploadIdle... image: " + this.mImageUploadService.isUploadIdle() + " other:" + this.mOtherUploadService.isUploadIdle() + " log:" + this.mLogUploadService.isUploadIdle());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("UploadServiceImpl isUploadIdle: ");
        sb5.append(z16);
        UploadLog.d(TAG, sb5.toString());
        return z16;
    }

    @Override // com.tencent.upload.uinterface.IUploadService
    public void keepImageTmpFile(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        }
    }

    @Override // com.tencent.upload.uinterface.IUploadService
    public void pauseAllTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        UploadLog.v(TAG, "pauseAllTask");
        this.mImageUploadService.cancelAllTasks();
        this.mLogUploadService.cancelAllTasks();
        this.mOtherUploadService.cancelAllTasks();
    }

    @Override // com.tencent.upload.uinterface.IUploadService
    public void prepare(TaskTypeConfig taskTypeConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) taskTypeConfig);
            return;
        }
        ServerRouteTable serverRouteTable = taskTypeConfig.serverRouteTable;
        Const.FileType fileType = serverRouteTable.supportFileType;
        UploadLog.d(TAG, "prepare() type=" + fileType);
        if (fileType == Const.FileType.Photo) {
            this.mImageUploadService.prepare(serverRouteTable);
        } else if (fileType == Const.FileType.Log) {
            this.mLogUploadService.prepare(serverRouteTable);
        } else {
            this.mOtherUploadService.prepare(serverRouteTable);
        }
    }

    @Override // com.tencent.upload.uinterface.IUploadService
    public void setBackgroundMode(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        UploadLog.d(TAG, "setBackgroundMode:" + z16);
        if (mInit && z16) {
            setCloseTimer();
        }
    }

    @Override // com.tencent.upload.uinterface.IUploadService
    public void setDebugServerRoute(DebugServerRoute debugServerRoute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) debugServerRoute);
            return;
        }
        RouteFactory.setDebugRoute(debugServerRoute);
        UploadLog.d(TAG, "setDebugServerRoute -- " + debugServerRoute);
        this.mImageUploadService.reset();
        this.mLogUploadService.reset();
        this.mOtherUploadService.reset();
    }

    @Override // com.tencent.upload.uinterface.IUploadService
    public boolean upload(AbstractUploadTask abstractUploadTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) abstractUploadTask)).booleanValue();
        }
        acquireWakeLockIfNot();
        if (UploadTaskManager.getFileType(abstractUploadTask) == Const.FileType.Photo) {
            this.mImageUploadService.upload(abstractUploadTask);
        } else if (UploadTaskManager.getFileType(abstractUploadTask) == Const.FileType.Log) {
            this.mLogUploadService.upload(abstractUploadTask);
        } else {
            this.mOtherUploadService.upload(abstractUploadTask);
        }
        UploadFlowTracker.trackStart(abstractUploadTask);
        return true;
    }
}
