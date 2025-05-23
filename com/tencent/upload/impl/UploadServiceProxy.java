package com.tencent.upload.impl;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.network.route.DebugServerRoute;
import com.tencent.upload.report.ReportManager;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadEnv;
import com.tencent.upload.uinterface.IUploadLog;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.IUploadSoLoader;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.UploadLog;

/* loaded from: classes27.dex */
public class UploadServiceProxy implements IUploadService {
    static IPatchRedirector $redirector_ = null;
    private static final int MSG_INNER_TIMEOUT_CLOSE = 8;
    private static final int MSG_UI_CANCEL_TASK = 3;
    private static final int MSG_UI_COMMIT_TASK = 4;
    private static final int MSG_UI_PAUSE_ALL_TASK = 5;
    private static final int MSG_UI_PREPARE = 1;
    private static final int MSG_UI_SET_BACKGROUND_MODE = 6;
    private static final int MSG_UI_SET_TEST_SERVER = 7;
    private static final int MSG_UI_UPLOAD_TASK = 2;
    private static volatile boolean mInit = false;
    private static volatile UploadServiceProxy sInstance = null;
    public static final String tag = "UploadServiceProxy";
    boolean mIsDebug;
    private UploadServiceImpl mServiceImpl;
    private Handler mWorkerHandler;
    private HandlerThread mWorkerThread;

    UploadServiceProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mIsDebug = false;
        }
    }

    private boolean checkStatus() {
        if (!mInit) {
            UploadLog.d(tag, "checkStatus mInit: " + mInit);
            return false;
        }
        HandlerThread handlerThread = this.mWorkerThread;
        if (handlerThread != null && handlerThread.isAlive()) {
            if (this.mWorkerHandler == null) {
                UploadLog.d(tag, "checkStatus mWorkerHandler == null");
                return false;
            }
            return true;
        }
        UploadLog.d(tag, "checkStatus work thread is not ready !");
        return false;
    }

    public static IUploadService getInstance() {
        if (sInstance == null) {
            synchronized (UploadServiceProxy.class) {
                if (sInstance == null) {
                    sInstance = new UploadServiceProxy();
                }
            }
        }
        return sInstance;
    }

    private synchronized void initWorkerThread() {
        HandlerThread handlerThread = this.mWorkerThread;
        if (handlerThread != null && handlerThread.isAlive() && this.mWorkerHandler != null) {
            return;
        }
        UploadLog.v(tag, "initWorkerThread()");
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(IUploadService.UPLOAD_HANDLE_THREAD_NAME);
        this.mWorkerThread = baseHandlerThread;
        baseHandlerThread.start();
        this.mWorkerHandler = new Handler(this.mWorkerThread.getLooper()) { // from class: com.tencent.upload.impl.UploadServiceProxy.1
            static IPatchRedirector $redirector_;

            {
                super(r5);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) UploadServiceProxy.this, (Object) r5);
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                AbstractUploadTask abstractUploadTask;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                    return;
                }
                Object obj = message.obj;
                if (obj instanceof AbstractUploadTask) {
                    abstractUploadTask = (AbstractUploadTask) obj;
                } else {
                    abstractUploadTask = null;
                }
                if (UploadServiceProxy.this.mServiceImpl == null) {
                    UploadLog.v(UploadServiceProxy.tag, "handleMessage mServiceImpl == null !");
                    UploadServiceProxy.this.mServiceImpl = UploadServiceImpl.getInstance();
                }
                switch (message.what) {
                    case 1:
                        UploadLog.d(UploadServiceProxy.tag, "receive MSG_UI_PREPARE");
                        UploadServiceProxy.this.mServiceImpl.prepare((TaskTypeConfig) message.obj);
                        return;
                    case 2:
                        if (abstractUploadTask != null) {
                            UploadLog.v(UploadServiceProxy.tag, "receive MSG_UI_UPLOAD_TASK type: " + abstractUploadTask.getClass().getSimpleName() + " flowId:" + abstractUploadTask.flowId);
                            UploadServiceProxy.this.mServiceImpl.upload(abstractUploadTask);
                            return;
                        }
                        return;
                    case 3:
                        UploadLog.v(UploadServiceProxy.tag, "receive MSG_UI_CANCEL_TASK");
                        UploadServiceProxy.this.mServiceImpl.cancel(abstractUploadTask);
                        return;
                    case 4:
                        UploadLog.v(UploadServiceProxy.tag, "receive MSG_UI_COMMIT_TASK");
                        UploadServiceProxy.this.mServiceImpl.commit(abstractUploadTask);
                        return;
                    case 5:
                        UploadLog.v(UploadServiceProxy.tag, "receive MSG_UI_PAUSE_ALL_TASK");
                        UploadServiceProxy.this.mServiceImpl.pauseAllTask();
                        return;
                    case 6:
                        UploadLog.d(UploadServiceProxy.tag, "receive MSG_UI_SET_BACKGROUND_MODE=" + message.arg1);
                        UploadServiceImpl uploadServiceImpl = UploadServiceProxy.this.mServiceImpl;
                        boolean z16 = true;
                        if (message.arg1 != 1) {
                            z16 = false;
                        }
                        uploadServiceImpl.setBackgroundMode(z16);
                        UploadGlobalConfig.getUploadReport().batchComplete();
                        return;
                    case 7:
                        DebugServerRoute debugServerRoute = (DebugServerRoute) message.obj;
                        UploadLog.d(UploadServiceProxy.tag, "receive MSG_UI_SET_TEST_SERVER=" + debugServerRoute);
                        UploadServiceProxy.this.mServiceImpl.setDebugServerRoute(debugServerRoute);
                        return;
                    case 8:
                        UploadLog.v(UploadServiceProxy.tag, "receive MSG_INNER_TIMEOUT_CLOSE");
                        UploadServiceProxy.this.mServiceImpl.doClose();
                        return;
                    default:
                        return;
                }
            }
        };
        if (this.mServiceImpl == null) {
            this.mServiceImpl = UploadServiceImpl.getInstance();
        }
    }

    @Override // com.tencent.upload.uinterface.IUploadService
    public boolean cancel(AbstractUploadTask abstractUploadTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) abstractUploadTask)).booleanValue();
        }
        UploadLog.d(tag, "UI operation >>> cancel");
        if (!checkStatus()) {
            return false;
        }
        if (abstractUploadTask == null) {
            UploadLog.d(tag, "task == null");
            return false;
        }
        UploadLog.d(tag, "cancel --> flowId:" + abstractUploadTask.flowId);
        this.mWorkerHandler.obtainMessage(3, abstractUploadTask).sendToTarget();
        return true;
    }

    @Override // com.tencent.upload.uinterface.IUploadService
    public boolean clearCacheWhenIdle(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) context)).booleanValue();
        }
        UploadLog.d(tag, "UI operation >>> clearCacheWhenIdle");
        FileUtils.clearUploadDir(context, 0L, 0L);
        return true;
    }

    @Override // com.tencent.upload.uinterface.IUploadService
    public boolean commit(AbstractUploadTask abstractUploadTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) abstractUploadTask)).booleanValue();
        }
        UploadLog.d(tag, "UI operation >>> commit");
        if (!checkStatus()) {
            return false;
        }
        if (abstractUploadTask == null) {
            UploadLog.d(tag, "task == null");
            return false;
        }
        UploadLog.d(tag, "commit --> flowId:" + abstractUploadTask.flowId);
        this.mWorkerHandler.obtainMessage(4, abstractUploadTask).sendToTarget();
        return true;
    }

    @Override // com.tencent.upload.uinterface.IUploadService
    public void init(Context context, IUploadConfig iUploadConfig, IUploadLog iUploadLog, IUploadReport iUploadReport, IUploadEnv iUploadEnv, IUploadSoLoader iUploadSoLoader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, iUploadConfig, iUploadLog, iUploadReport, iUploadEnv, iUploadSoLoader);
            return;
        }
        UploadLog.d(tag, "init() --- env: " + iUploadEnv);
        UploadGlobalConfig.init(context, iUploadConfig, iUploadLog, iUploadReport, iUploadEnv, iUploadSoLoader);
        mInit = true;
    }

    @Override // com.tencent.upload.uinterface.IUploadService
    public boolean isInitialized() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return mInit;
    }

    @Override // com.tencent.upload.uinterface.IUploadService
    public void keepImageTmpFile(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            UploadGlobalConfig.keepImageTmpFile(z16);
        }
    }

    @Override // com.tencent.upload.uinterface.IUploadService
    public void pauseAllTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        UploadLog.d(tag, "UI operation >>> pauseAllTask");
        if (!checkStatus()) {
            return;
        }
        this.mWorkerHandler.obtainMessage(5).sendToTarget();
    }

    @Override // com.tencent.upload.uinterface.IUploadService
    public void prepare(TaskTypeConfig taskTypeConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) taskTypeConfig);
            return;
        }
        UploadLog.d(tag, "UI operation >>> prepare");
        if (taskTypeConfig == null) {
            return;
        }
        if (!mInit) {
            UploadLog.d(tag, "prepare !mInit");
        } else {
            initWorkerThread();
            this.mWorkerHandler.obtainMessage(1, taskTypeConfig).sendToTarget();
        }
    }

    @Override // com.tencent.upload.uinterface.IUploadService
    public void setBackgroundMode(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        UploadLog.d(tag, "UI operation >>> setBackgroundMode backgroundMode:" + z16);
        if (!checkStatus()) {
            return;
        }
        this.mWorkerHandler.obtainMessage(6, z16 ? 1 : 0, 0).sendToTarget();
    }

    @Override // com.tencent.upload.uinterface.IUploadService
    public void setDebugServerRoute(DebugServerRoute debugServerRoute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) debugServerRoute);
            return;
        }
        UploadLog.d(tag, "UI operation >>> setDebugServerRoute : mInit:" + mInit);
        if (!mInit) {
            return;
        }
        this.mIsDebug = true;
        initWorkerThread();
        this.mWorkerHandler.obtainMessage(7, 0, 0, debugServerRoute).sendToTarget();
    }

    @Override // com.tencent.upload.uinterface.IUploadService
    public boolean upload(AbstractUploadTask abstractUploadTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) abstractUploadTask)).booleanValue();
        }
        UploadLog.d(tag, "UI operation >>> upload");
        if (!mInit) {
            UploadLog.d(tag, "upload !mInit");
            return false;
        }
        ReportManager.getInstance().reportTaskStart(abstractUploadTask);
        initWorkerThread();
        this.mWorkerHandler.obtainMessage(2, abstractUploadTask).sendToTarget();
        return true;
    }
}
