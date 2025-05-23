package com.tencent.upload.task;

import SLICE_UPLOAD.FileBatchCommitRsp;
import SLICE_UPLOAD.FileBatchControlRsp;
import SLICE_UPLOAD.FileControlRsp;
import SLICE_UPLOAD.FileUploadRsp;
import SLICE_UPLOAD.cnst.appid_mobilelog;
import SLICE_UPLOAD.stResult;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.impl.BaseUploadService;
import com.tencent.upload.network.route.IUploadRouteStrategy;
import com.tencent.upload.network.route.UploadRoute;
import com.tencent.upload.network.session.IUploadSession;
import com.tencent.upload.network.session.SessionPool;
import com.tencent.upload.network.session.UploadSession;
import com.tencent.upload.network.session.cache.CacheUtil;
import com.tencent.upload.report.Report;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.upload.request.IActionRequest;
import com.tencent.upload.request.UploadRequest;
import com.tencent.upload.request.UploadResponse;
import com.tencent.upload.request.impl.FileControlRequest;
import com.tencent.upload.request.impl.FileUploadRequest;
import com.tencent.upload.task.data.UploadDataSource;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.JceEncoder;
import com.tencent.upload.utils.StringUtils;
import com.tencent.upload.utils.UploadLog;
import com.tencent.upload.utils.pool.UploadThreadManager;
import com.tencent.upload.utils.watcher.UploadFlowTracker;
import cooperation.qzone.util.WiFiDash;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Future;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class UploadTask extends BaseTask implements IUploadSession.RequestListener {
    static IPatchRedirector $redirector_ = null;
    protected static final String BATCH_CONTROL_MAP_KEY = "1";
    protected static final int DEFAULT_MAX_NETWORK_RETRY_TIMES = 8;
    protected static final int DEFAULT_MAX_RETRY_TIMES = 3;
    protected static final long DELAY_WAIT_COMMIT_REQ_TIMEOUT = 60000;
    protected static final long DELAY_WAIT_EXPORT_TIMEOUT = 35000;
    protected static final int POLLSESSION_RETRYTIME = 2;
    public static final String REPORT_MSG_DIVIDER = " || ";
    protected static final String SPEED_TAG = "[speed] ";
    protected static final int STEP_SECONDS_UPLOAD = 2;
    protected static final int STEP_SEND_CONTROL_REQ = 0;
    protected static final int STEP_SEND_FILESLICE_RANGE_REQ = 4;
    protected static final int STEP_SEND_FILESLICE_REQ = 1;
    protected static final int STEP_SEND_FILE_COMMIT_REQ = 3;
    protected static final String TAG = "UploadTask";
    public static final String TRANSFER_TAG = "[transfer] UploadTask";
    protected static final int WHAT_COMPLETE_TIME_OUT = 1001;
    protected static final int WHAT_CONTROL_COMPLETE_TIME_OUT = 1004;
    protected static final int WHAT_WAIT_COMMIT_REQ_COMPLETE_TIME_OUT = 1003;
    protected static final int WHAT_WAIT_EXPORT_COMPLETE_TIME_OUT = 1002;
    public int flowId;
    public int iAppid;
    private final Object lock;
    protected String mAppid;
    protected AtomFile mAtomFile;
    protected String mClientIp;
    protected String mConnectedIp;
    protected int mConnectedPort;
    protected long mControlPkgEndTime;
    protected long mControlPkgStartTime;
    protected int mCurrControlReqId;
    public long mDataLength;
    protected long mDataPkgEndTime;
    protected long mDataPkgStartTime;
    protected long mDataRangePkgEndTime;
    protected long mDataRangePkgStartTime;
    protected UploadDataSource mDataSource;
    protected long mEndTime;
    protected String mFilePath;
    protected long mFileRecvOffset;
    protected long mFileSendOffset;
    protected volatile boolean mFinish;
    protected boolean mFlagError;
    protected Handler mHandler;
    protected boolean mIsFastUpload;
    protected long mLastSendOffset;
    protected long mLastSliceSize;
    protected String mMd5;
    protected IUploadSession[] mMultiSession;
    protected ArrayList<UploadThread> mMultiThreads;
    protected boolean mNeedReset;
    protected int mNetworkRetryCount;
    protected Report mReportObj;
    protected volatile boolean mReported;
    protected int mRetryCount;
    protected IUploadSession mSavedSession;
    protected boolean mSecondUpload;
    protected FileControlRsp mSecondUploadRsp;
    protected IUploadSession mSession;
    protected String mSessionId;
    protected SessionPool mSessionPool;
    protected String mSha1;
    protected int mSliceSize;
    protected long mStartTime;
    protected volatile int mStep;
    protected TaskStateListener mTaskStateListener;
    protected UploadRoute mUploadRoute;
    protected long overwriteRangeBegin;
    protected long overwriteRangeEnd;
    protected long overwriteSize;

    /* compiled from: P */
    /* renamed from: com.tencent.upload.task.UploadTask$2, reason: invalid class name */
    /* loaded from: classes27.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$upload$task$TaskState;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13079);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[TaskState.values().length];
            $SwitchMap$com$tencent$upload$task$TaskState = iArr;
            try {
                iArr[TaskState.SENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class UploadThread implements Runnable {
        static IPatchRedirector $redirector_;
        protected AtomFile tFile;
        protected boolean tFinish;
        public Future tFuture;
        protected long tId;
        protected IUploadSession tSession;
        protected String tTAG;
        protected boolean tWaitFlag;

        public UploadThread(AtomFile atomFile, IUploadSession iUploadSession) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, UploadTask.this, atomFile, iUploadSession);
                return;
            }
            this.tWaitFlag = true;
            this.tFile = atomFile;
            this.tSession = iUploadSession;
            this.tId = hashCode();
            this.tTAG = "[UploadThread-" + this.tId + "-" + iUploadSession.getUploadRoute() + "-" + iUploadSession.hashCode() + "]";
        }

        void notifySendend() {
            synchronized (this) {
                this.tWaitFlag = false;
                notify();
            }
        }

        public void quit() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                terminate();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x00f0, code lost:
        
            com.tencent.upload.utils.UploadLog.d(com.tencent.upload.task.UploadTask.TRANSFER_TAG, r7.tTAG + " thread finish threadId=" + r7.tId + " mFinish=" + r7.this$0.mFinish);
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x011c, code lost:
        
            return;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            FileUploadRequest fileUploadRequest;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            UploadTask.this.setTaskStatus(TaskState.SENDING);
            while (true) {
                synchronized (this.tFile) {
                    fileUploadRequest = UploadTask.this.getFileUploadRequest(this.tFile);
                    if (fileUploadRequest != null) {
                        UploadTask.this.mFileSendOffset = fileUploadRequest.mOffset + fileUploadRequest.getRealDataSize();
                        UploadTask.this.mLastSliceSize = fileUploadRequest.getRealDataSize();
                        UploadTask uploadTask = UploadTask.this;
                        uploadTask.mLastSendOffset = fileUploadRequest.mOffset;
                        uploadTask.mDataPkgEndTime = System.currentTimeMillis();
                        fileUploadRequest.setTag(this);
                    }
                }
                if (fileUploadRequest == null) {
                    UploadLog.d(UploadTask.TAG, this.tTAG + " request == null, send over!!");
                    break;
                }
                this.tWaitFlag = true;
                boolean send = this.tSession.send(fileUploadRequest, UploadTask.this.getUploadTaskType(), UploadTask.this);
                UploadLog.d(UploadTask.TRANSFER_TAG, this.tTAG + " send result=" + send + " reqId=" + fileUploadRequest.getRequestId());
                UploadTask.this.clearCompleteTimer(1001);
                if (!send) {
                    terminateWithRetry();
                    break;
                }
                try {
                    synchronized (this) {
                        if (this.tWaitFlag) {
                            LockMethodProxy.wait(this);
                        }
                    }
                } catch (Exception e16) {
                    UploadLog.e(UploadTask.TRANSFER_TAG, this.tTAG + "run tFinish: " + this.tFinish + " mFinish: " + UploadTask.this.mFinish, e16);
                }
                if (this.tFinish || UploadTask.this.mFinish) {
                    break;
                }
            }
        }

        protected synchronized void terminate() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                if (this.tFinish) {
                    return;
                }
                this.tFinish = true;
                notify();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public synchronized void terminateWithRetry() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            UploadLog.w(UploadTask.TAG, this.tTAG + "terminateWithRetry --- ");
            terminate();
            UploadTask uploadTask = UploadTask.this;
            uploadTask.mNetworkRetryCount = uploadTask.mNetworkRetryCount + 1;
            uploadTask.postExecute(0, true);
        }
    }

    public UploadTask(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.mIsFastUpload = false;
        this.mStep = 0;
        this.mRetryCount = 0;
        this.mNetworkRetryCount = 0;
        this.mConnectedIp = "";
        this.mConnectedPort = 0;
        this.mCurrControlReqId = 0;
        this.mFlagError = false;
        this.mMultiThreads = new ArrayList<>(5);
        this.mReportObj = new Report();
        this.mReported = false;
        this.overwriteRangeBegin = 0L;
        this.overwriteRangeEnd = 0L;
        this.overwriteSize = 0L;
        this.lock = new Object();
        this.mFilePath = str;
        this.mDataSource = new UploadDataSource.FileDataSource(str);
    }

    private void onTaskInfoChanged() {
        TaskStateListener taskStateListener = this.mTaskStateListener;
        if (taskStateListener != null) {
            taskStateListener.onTaskInfoChanged(this);
        }
    }

    private boolean sendControlPkg() {
        if (getTaskState() == TaskState.PAUSE || getTaskState() == TaskState.CANCEL || getTaskState() == TaskState.SUCCEED) {
            return false;
        }
        if (!this.mDataSource.exists()) {
            UploadFlowTracker.trackFlow(this, "\u4e0a\u4f20\u6587\u4ef6\u4e0d\u5b58\u5728");
            Const.UploadRetCode uploadRetCode = Const.UploadRetCode.FILE_NOT_EXIST;
            onError(uploadRetCode.getCode(), uploadRetCode.getDesc());
            return false;
        }
        if (this.mDataSource.getDataLength() <= 0) {
            UploadFlowTracker.trackFlow(this, "\u4e0a\u4f20\u6587\u4ef6\u957f\u5ea6\u5f02\u5e38");
            Const.UploadRetCode uploadRetCode2 = Const.UploadRetCode.FILE_LENGTH_INVALID;
            onError(uploadRetCode2.getCode(), uploadRetCode2.getDesc());
            return false;
        }
        setState(TaskState.CONNECTING);
        IUploadSession pollSessionWithRetry = pollSessionWithRetry(2);
        if (this.mFinish) {
            UploadLog.w(TAG, "after poll task has been finished !");
            return false;
        }
        if (pollSessionWithRetry == null) {
            UploadFlowTracker.trackFlow(this, "\u83b7\u53d6session\u5931\u8d25");
            Const.UploadRetCode uploadRetCode3 = Const.UploadRetCode.NO_SESSION;
            onError(uploadRetCode3.getCode(), uploadRetCode3.getDesc());
            return false;
        }
        this.mSession = pollSessionWithRetry;
        this.mSavedSession = pollSessionWithRetry;
        UploadRequest controlRequest = getControlRequest();
        this.mCurrControlReqId = controlRequest.getRequestId();
        this.mFlagError = false;
        long currentTimeMillis = System.currentTimeMillis();
        this.mControlPkgStartTime = currentTimeMillis;
        this.mStartTime = currentTimeMillis;
        onSessionReport(new UploadQualityReportBuilder().setExt1(pollSessionWithRetry.getBaseSessionReportString()).setExt2(UploadQualityReportBuilder.STATE_SEND_CONTROL_PKG));
        UploadFlowTracker.trackFlow(this, "\u5f00\u59cb\u53d1\u9001\u63a7\u5236\u5305");
        this.mReportObj.clearRttList();
        boolean send = pollSessionWithRetry.send(controlRequest, getUploadTaskType(), this);
        if (send) {
            setTaskStatus(TaskState.SENDING);
        }
        UploadLog.d(TRANSFER_TAG, "sendControlPkg taskId=" + getTaskId() + " reqId=" + this.mCurrControlReqId + " retry=" + this.mRetryCount + " route=" + pollSessionWithRetry.getUploadRoute() + " mDataLength=" + this.mDataLength + ", getIdleSession=" + pollSessionWithRetry.hashCode() + ", sessionId=" + this.mSessionId + ", sendControlPkg result=" + send);
        startCompleteTimer(1004, (long) UploadSession.getSendTimeout(0));
        return true;
    }

    protected void abortSession(IUploadSession iUploadSession) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, (Object) iUploadSession);
            return;
        }
        synchronized (this.lock) {
            UploadLog.i(TAG, "abort session:" + iUploadSession.hashCode());
            IUploadSession iUploadSession2 = this.mSession;
            if (iUploadSession2 != null && iUploadSession2.equals(iUploadSession)) {
                this.mSession.close();
                this.mSession = null;
            }
            if (this.mMultiSession != null) {
                int i3 = 0;
                while (true) {
                    IUploadSession[] iUploadSessionArr = this.mMultiSession;
                    if (i3 >= iUploadSessionArr.length) {
                        break;
                    }
                    IUploadSession iUploadSession3 = iUploadSessionArr[i3];
                    if (iUploadSession3 != null && iUploadSession3.equals(iUploadSession)) {
                        UploadLog.i(TAG, "abort i:" + i3 + " session:" + this.mMultiSession[i3].hashCode());
                        this.mMultiSession[i3] = null;
                    }
                    i3++;
                }
            }
        }
    }

    public void bindHandler(Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) handler);
        } else {
            this.mHandler = handler;
        }
    }

    public void bindSessionPool(SessionPool sessionPool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) sessionPool);
        } else {
            this.mSessionPool = sessionPool;
        }
    }

    protected void buildThread(IUploadSession[] iUploadSessionArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) iUploadSessionArr);
            return;
        }
        UploadLog.d(TRANSFER_TAG, "taskId:" + this.mTaskId + ", filePkg, begin to wait available session ----> atomFile:" + this.mAtomFile.toString());
        for (IUploadSession iUploadSession : iUploadSessionArr) {
            if (iUploadSession != null) {
                onSessionReport(new UploadQualityReportBuilder().setExt1(iUploadSession.getBaseSessionReportString()).setExt2(UploadQualityReportBuilder.STATE_SEND_FILE_PKG).setAttachInfo(this.mAtomFile.toLogString()));
                UploadThread uploadThread = new UploadThread(this.mAtomFile, iUploadSession);
                this.mMultiThreads.add(uploadThread);
                uploadThread.tFuture = UploadThreadManager.getInstance().getDataThreadPool().submit(uploadThread);
            }
        }
    }

    @Override // com.tencent.upload.task.BaseTask
    public boolean cancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Boolean) iPatchRedirector.redirect((short) 49, (Object) this)).booleanValue();
        }
        UploadLog.w(TRANSFER_TAG, "task canceled by user, taskId:" + getTaskId());
        if (getTaskState() == TaskState.SUCCEED) {
            return false;
        }
        super.cancel();
        resetTask();
        setTaskStatus(TaskState.CANCEL);
        this.mRetryCount = 0;
        this.mFinish = true;
        Const.UploadRetCode uploadRetCode = Const.UploadRetCode.CANCELED;
        onTaskFinished(uploadRetCode.getCode(), uploadRetCode.getDesc());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void cancelForError(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, i3, (Object) str);
            return;
        }
        UploadLog.w(TRANSFER_TAG, "cancelForError taskId:" + getTaskId() + " errorCode=" + i3 + " retryCount:" + this.mRetryCount + " mNetworkRetryCount:" + this.mNetworkRetryCount + " errorMsg=" + str + " mFinish=" + this.mFinish);
        if (i3 != 0 && !this.mFinish) {
            super.cancel();
            uploadSessionReport(UploadQualityReportBuilder.STATE_UPLOAD_FAIL, i3, str);
            this.mFinish = true;
            this.mSliceSize = 0;
            onUploadError(i3, str);
            setTaskStatus(TaskState.FAILED);
            onTaskFinished(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clearCompleteTimer(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this, i3);
            return;
        }
        UploadLog.v(TAG, "clearCompleteTimer... what:" + i3 + " flowId:" + this.flowId);
        this.mHandler.removeMessages(i3 + this.flowId);
    }

    protected abstract int getBucketSize();

    protected int getConnectionNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Integer) iPatchRedirector.redirect((short) 43, (Object) this)).intValue();
        }
        return BaseUploadService.getFileSocketNumber();
    }

    protected abstract UploadRequest getControlRequest();

    public UploadDataSource getDataSource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (UploadDataSource) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mDataSource;
    }

    public String getFilePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mFilePath;
    }

    protected FileUploadRequest getFileUploadRequest(AtomFile atomFile) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (FileUploadRequest) iPatchRedirector.redirect((short) 26, (Object) this, (Object) atomFile);
        }
        return null;
    }

    protected int getMaxNetworkRetryTimes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return ((Integer) iPatchRedirector.redirect((short) 59, (Object) this)).intValue();
        }
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getMaxRetryTimes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return ((Integer) iPatchRedirector.redirect((short) 58, (Object) this)).intValue();
        }
        return 3;
    }

    public String getMd5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.mMd5;
    }

    public UploadRoute getRoute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (UploadRoute) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.mUploadRoute;
    }

    public String getSessionId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mSessionId;
    }

    public String getSha1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.mSha1;
    }

    public int getSliceSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.mSliceSize;
    }

    public String getStringAppId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mAppid;
    }

    public float getUploadProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Float) iPatchRedirector.redirect((short) 19, (Object) this)).floatValue();
        }
        if (this.mDataLength <= 0) {
            this.mDataLength = this.mDataSource.getDataLength();
        }
        long j3 = this.mFileSendOffset;
        long j16 = this.mDataLength;
        if (j3 >= j16 || j16 <= 0 || getTaskState() == TaskState.SUCCEED) {
            return 100.0f;
        }
        return (((float) this.mFileSendOffset) * 100.0f) / ((float) this.mDataLength);
    }

    public abstract TaskTypeConfig getUploadTaskType();

    public boolean isDataSourceValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        UploadDataSource uploadDataSource = this.mDataSource;
        if (uploadDataSource != null) {
            return uploadDataSource.isValid();
        }
        return false;
    }

    protected boolean isFileUploadFinish(stResult stresult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this, (Object) stresult)).booleanValue();
        }
        int i3 = stresult.flag;
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            return true;
        }
        return false;
    }

    protected boolean multiThreadSendFilePkg() {
        IUploadSession iUploadSession;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Boolean) iPatchRedirector.redirect((short) 44, (Object) this)).booleanValue();
        }
        if (getTaskState() != TaskState.PAUSE && getTaskState() != TaskState.CANCEL) {
            AtomFile atomFile = new AtomFile(this.mFilePath);
            this.mAtomFile = atomFile;
            atomFile.setSliceSize(this.mSliceSize).setSessionId(this.mSessionId).setOffset(this.mFileSendOffset).setStartTime(System.currentTimeMillis());
            int connectionNum = getConnectionNum();
            IUploadSession[] iUploadSessionArr = new IUploadSession[connectionNum];
            for (int i3 = 0; i3 < connectionNum; i3++) {
                if (i3 == 0 && (iUploadSession = this.mSession) != null) {
                    iUploadSessionArr[i3] = iUploadSession;
                } else {
                    iUploadSessionArr[i3] = pollSessionWithRetry(2);
                }
            }
            if (this.mFinish) {
                UploadLog.w(TAG, "taskId:" + this.mTaskId + ", filePkg, after poll task has been finished !");
                return false;
            }
            this.mMultiSession = iUploadSessionArr;
            this.mSavedSession = iUploadSessionArr[0];
            if (connectionNum > 0 && sessionsValidCheck(iUploadSessionArr)) {
                long currentTimeMillis = System.currentTimeMillis();
                this.mStartTime = currentTimeMillis;
                this.mDataPkgStartTime = currentTimeMillis;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("taskId:");
                stringBuffer.append(this.mTaskId);
                stringBuffer.append(", sendFilePkg, mDataLength:");
                stringBuffer.append(this.mDataLength);
                stringBuffer.append(", use sessions size:");
                stringBuffer.append(connectionNum);
                stringBuffer.append(", sessions detail:");
                for (int i16 = 0; i16 < connectionNum; i16++) {
                    IUploadSession iUploadSession2 = iUploadSessionArr[i16];
                    if (iUploadSession2 != null) {
                        stringBuffer.append(iUploadSession2.getUploadRoute().toString() + "," + iUploadSession2.hashCode());
                    }
                }
                UploadLog.d(TRANSFER_TAG, stringBuffer.toString());
                UploadFlowTracker.trackFlow(this, "\u6570\u636e\u5305\u5f00\u59cb\u53d1\u9001");
                this.mMultiThreads.clear();
                buildThread(iUploadSessionArr);
                return true;
            }
            UploadLog.e(TAG, "taskId:" + this.mTaskId + ", filePkg, multi session == null! no session to upload");
            UploadFlowTracker.trackFlow(this, "\u65e0\u53ef\u7528session");
            Const.UploadRetCode uploadRetCode = Const.UploadRetCode.NO_SESSION;
            onError(uploadRetCode.getCode(), uploadRetCode.getDesc());
        }
        return false;
    }

    protected boolean multiThreadSendFileRangePkg() {
        IUploadSession iUploadSession;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        if (getTaskState() != TaskState.PAUSE && getTaskState() != TaskState.CANCEL) {
            AtomFile atomFile = new AtomFile(this.mFilePath, this.overwriteRangeBegin, this.overwriteRangeEnd);
            this.mAtomFile = atomFile;
            atomFile.setSliceSize(this.mSliceSize).setSessionId(this.mSessionId).setOffset(this.mFileSendOffset).setStartTime(System.currentTimeMillis());
            UploadLog.d(TAG, "taskId:" + this.mTaskId + ", filePkg, begin to wait available session ----> ");
            int connectionNum = getConnectionNum();
            IUploadSession[] iUploadSessionArr = new IUploadSession[connectionNum];
            for (int i3 = 0; i3 < connectionNum; i3++) {
                if (i3 == 0 && (iUploadSession = this.mSession) != null) {
                    iUploadSessionArr[i3] = iUploadSession;
                } else {
                    iUploadSessionArr[i3] = pollSessionWithRetry(2);
                }
            }
            if (this.mFinish) {
                UploadLog.w(TAG, "taskId:" + this.mTaskId + ", filePkg, after poll task has been finished !");
                return false;
            }
            this.mMultiSession = iUploadSessionArr;
            this.mSavedSession = iUploadSessionArr[0];
            if (connectionNum > 0 && sessionsValidCheck(iUploadSessionArr)) {
                this.mDataRangePkgStartTime = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("taskId:");
                stringBuffer.append(this.mTaskId);
                stringBuffer.append(", sendFilePkg, mDataLength:");
                stringBuffer.append(this.mDataLength);
                stringBuffer.append(", use sessions size:");
                stringBuffer.append(connectionNum);
                stringBuffer.append(", sessions detail:");
                for (int i16 = 0; i16 < connectionNum; i16++) {
                    IUploadSession iUploadSession2 = iUploadSessionArr[i16];
                    if (iUploadSession2 != null) {
                        stringBuffer.append(iUploadSession2.getUploadRoute().toString() + "," + iUploadSession2.hashCode());
                    }
                }
                UploadLog.d("[iplist] UploadTask", stringBuffer.toString());
                UploadFlowTracker.trackFlow(this, "\u6570\u636e\u5305\u5f00\u59cb\u53d1\u9001");
                this.mMultiThreads.clear();
                for (int i17 = 0; i17 < connectionNum; i17++) {
                    IUploadSession iUploadSession3 = iUploadSessionArr[i17];
                    if (iUploadSession3 != null) {
                        onSessionReport(new UploadQualityReportBuilder().setExt1(iUploadSession3.getBaseSessionReportString()).setExt2(UploadQualityReportBuilder.STATE_SEND_FILE_RANGE_PKG));
                        UploadThread uploadThread = new UploadThread(this.mAtomFile, iUploadSession3);
                        this.mMultiThreads.add(uploadThread);
                        uploadThread.tFuture = UploadThreadManager.getInstance().getDataThreadPool().submit(uploadThread);
                    }
                }
                return true;
            }
            UploadLog.e(TAG, "taskId:" + this.mTaskId + ", filePkg, multi session == null! no session to upload");
            UploadFlowTracker.trackFlow(this, "\u65e0\u53ef\u7528session");
            Const.UploadRetCode uploadRetCode = Const.UploadRetCode.NO_SESSION;
            onError(uploadRetCode.getCode(), uploadRetCode.getDesc());
        }
        return false;
    }

    protected abstract void onBatchControlRsp(Object obj);

    @Override // com.tencent.upload.task.BaseTask
    public void onError(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, i3, (Object) str);
            return;
        }
        UploadLog.e(TAG, "taskId:" + getTaskId() + " onError errCode:" + i3 + " desc:" + str);
        cancelForError(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onFileControlResponse(JceStruct jceStruct, UploadResponse uploadResponse) {
        String str;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) jceStruct, (Object) uploadResponse);
            return;
        }
        if (jceStruct == null) {
            UploadLog.d(TRANSFER_TAG, "onFileControlResponse rsp == null " + hashCode());
            Const.UploadRetCode uploadRetCode = Const.UploadRetCode.RESPONSE_IS_NULL;
            onError(uploadRetCode.getCode(), uploadRetCode.getDesc());
            return;
        }
        if (jceStruct instanceof FileBatchControlRsp) {
            onFileControlResponse(((FileBatchControlRsp) jceStruct).control_rsp.get("1"), uploadResponse);
            return;
        }
        clearCompleteTimer(1004);
        FileControlRsp fileControlRsp = (FileControlRsp) jceStruct;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("recv FileControlResponse taskId=");
        sb5.append(getTaskId());
        sb5.append(" reqId=");
        sb5.append(uploadResponse.getRequestSequence());
        sb5.append(" cmd=");
        sb5.append(uploadResponse.getCmd());
        sb5.append(" ret=");
        sb5.append(fileControlRsp.result.ret);
        sb5.append(" flag=");
        sb5.append(fileControlRsp.result.flag);
        sb5.append(" msg=");
        sb5.append(fileControlRsp.result.f25097msg);
        sb5.append(" retry=");
        sb5.append(this.mRetryCount);
        sb5.append(" offset=");
        sb5.append(fileControlRsp.offset);
        sb5.append(" slice_size=");
        sb5.append(fileControlRsp.slice_size);
        sb5.append(" session=");
        sb5.append(fileControlRsp.session);
        UploadLog.d(TRANSFER_TAG, sb5.toString());
        UploadQualityReportBuilder uploadQualityReportBuilder = new UploadQualityReportBuilder();
        IUploadSession iUploadSession = this.mSession;
        if (iUploadSession == null) {
            str = "";
        } else {
            str = iUploadSession.getBaseSessionReportString();
        }
        onSessionReport(uploadQualityReportBuilder.setExt1(str).setExt2(UploadQualityReportBuilder.STATE_RESPONSE_CONTROL_PKG).setAttachInfo(sb5.toString()));
        this.mControlPkgEndTime = System.currentTimeMillis();
        stResult stresult = fileControlRsp.result;
        if (stresult.ret != 0) {
            if (this.mRetryCount < getMaxRetryTimes()) {
                processByRspFlag(fileControlRsp.result);
                return;
            } else {
                stResult stresult2 = fileControlRsp.result;
                onError(stresult2.ret, stresult2.f25097msg);
                return;
            }
        }
        if (stresult.flag != 0) {
            if (isFileUploadFinish(stresult)) {
                UploadLog.d(TAG, "taskId=" + getTaskId() + "rsp.result.flag=" + fileControlRsp.result.flag + " upload success !");
                long currentTimeMillis = System.currentTimeMillis();
                this.mEndTime = currentTimeMillis;
                this.mDataPkgEndTime = currentTimeMillis;
                long j3 = this.mDataLength;
                onUploadProgress(j3, j3);
                this.mIsFastUpload = true;
                processFileUploadFinishRsp(fileControlRsp.biz_rsp);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(fileControlRsp.redirect_ip)) {
            this.mSessionId = "";
            String str2 = fileControlRsp.redirect_ip;
            UploadRoute uploadRoute = this.mUploadRoute;
            if (uploadRoute != null) {
                i3 = uploadRoute.getPort();
            } else {
                i3 = WebSocketImpl.DEFAULT_WSS_PORT;
            }
            resetSessionPool(str2, i3);
            return;
        }
        processBatchControlRsp(fileControlRsp.biz_rsp);
        this.mSliceSize = (int) fileControlRsp.slice_size;
        this.mSessionId = fileControlRsp.session;
        UploadLog.d(TAG, "cacheSessionId :" + this.mSessionId + "slicesize=" + fileControlRsp.slice_size);
        CacheUtil.cacheSessionId(this, this.mSessionId);
        long j16 = fileControlRsp.offset;
        if (j16 < 0) {
            j16 = 0;
        }
        this.mFileSendOffset = j16;
        this.mFileRecvOffset = j16;
        this.mDataPkgStartTime = System.currentTimeMillis();
        postExecute(1, false);
    }

    protected void onFileUploadResponse(FileUploadRsp fileUploadRsp, UploadResponse uploadResponse) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) fileUploadRsp, (Object) uploadResponse);
            return;
        }
        if (fileUploadRsp != null && uploadResponse != null) {
            UploadLog.d(TRANSFER_TAG, "recv FileUploadResponse taskId=" + getTaskId() + " reqId=" + uploadResponse.getRequestSequence() + " cmd=" + uploadResponse.getCmd() + " ret=" + fileUploadRsp.result.ret + " flag=" + fileUploadRsp.result.flag + " msg=" + fileUploadRsp.result.f25097msg + " sid=" + uploadResponse.getSid() + " retry=" + this.mRetryCount + " offset=" + fileUploadRsp.offset + " totalSize=" + this.mDataLength + " sendOffset=" + this.mFileSendOffset + " session=" + fileUploadRsp.session + " mFlagError=" + this.mFlagError + " type:" + getClass().getSimpleName());
            if (uploadResponse.getRequestSequence() >= this.mCurrControlReqId && !this.mFlagError) {
                clearCompleteTimer(1001);
                if (fileUploadRsp.result.ret != 0) {
                    this.mFlagError = true;
                    if (this.mRetryCount < getMaxRetryTimes()) {
                        processByRspFlag(fileUploadRsp.result);
                        return;
                    } else {
                        stResult stresult = fileUploadRsp.result;
                        onError(stresult.ret, stresult.f25097msg);
                        return;
                    }
                }
                processFileUploadResponse(fileUploadRsp);
                return;
            }
            return;
        }
        if (("onFileUploadResponse " + fileUploadRsp) == null) {
            str = "rsp == null";
        } else {
            str = "response == null";
        }
        UploadLog.e(TAG, str);
        Const.UploadRetCode uploadRetCode = Const.UploadRetCode.RESPONSE_IS_NULL;
        onError(uploadRetCode.getCode(), uploadRetCode.getDesc());
    }

    @Override // com.tencent.upload.network.session.IUploadSession.RequestListener
    public void onRequestError(IActionRequest iActionRequest, Const.UploadRetCode uploadRetCode, IUploadSession iUploadSession) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, iActionRequest, uploadRetCode, iUploadSession);
            return;
        }
        boolean z16 = iActionRequest.getTag() instanceof UploadThread;
        if (z16) {
            str = ((UploadThread) iActionRequest.getTag()).tTAG;
        } else {
            str = "";
        }
        UploadLog.d(TRANSFER_TAG, str + "onRequestError taskId=" + getTaskId() + " reqId=" + iActionRequest.getRequestId() + " CMD=" + iActionRequest.getCmdId() + " mNetworkRetryCount=" + this.mNetworkRetryCount + " session=" + iUploadSession.hashCode() + " code: " + uploadRetCode + " mCurrControlReqId=" + this.mCurrControlReqId + " mFlagError:" + this.mFlagError + " mFinish:" + this.mFinish);
        abortSession(iUploadSession);
        if (iActionRequest.getRequestId() >= this.mCurrControlReqId && !this.mFlagError && !this.mFinish) {
            this.mFlagError = true;
            if (z16) {
                quitMultiThreadUpload();
            }
            if (uploadRetCode != Const.UploadRetCode.OOM && uploadRetCode != Const.UploadRetCode.SESSION_REQUEST_ENCODE_ERROR && uploadRetCode != Const.UploadRetCode.SESSION_CONN_SEND_FAILED) {
                Const.UploadRetCode uploadRetCode2 = Const.UploadRetCode.NETWORK_NOT_AVAILABLE;
                if (uploadRetCode == uploadRetCode2) {
                    cancelForError(uploadRetCode2.getCode(), uploadRetCode2.getDesc());
                    return;
                } else if (this.mNetworkRetryCount < getMaxNetworkRetryTimes()) {
                    this.mNetworkRetryCount++;
                    postExecute(0, true);
                    return;
                } else {
                    cancelForError(uploadRetCode.getCode(), uploadRetCode.getDesc());
                    return;
                }
            }
            cancelForError(uploadRetCode.getCode(), uploadRetCode.getDesc());
            return;
        }
        UploadLog.d(TAG, "onRequestError return");
    }

    @Override // com.tencent.upload.network.session.IUploadSession.RequestListener
    public void onRequestSended(IActionRequest iActionRequest) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) iActionRequest);
            return;
        }
        if (getTaskState() == TaskState.CANCEL) {
            return;
        }
        boolean z16 = iActionRequest.getTag() instanceof UploadThread;
        if (z16) {
            str = ((UploadThread) iActionRequest.getTag()).tTAG;
        } else {
            str = "";
        }
        UploadLog.d(TRANSFER_TAG, str + " onRequestSended taskId=" + getTaskId() + ", reqId=" + iActionRequest.getRequestId());
        if (z16) {
            ((UploadThread) iActionRequest.getTag()).notifySendend();
            return;
        }
        if (iActionRequest.getRequestId() >= this.mCurrControlReqId && AnonymousClass2.$SwitchMap$com$tencent$upload$task$TaskState[getTaskState().ordinal()] == 1) {
            if (iActionRequest instanceof FileUploadRequest) {
                UploadLog.d(TRANSFER_TAG, "send over reqId=" + iActionRequest.getRequestId() + " offset=" + this.mLastSendOffset + " slice=" + this.mLastSliceSize + " total=" + this.mDataLength);
                this.mDataPkgEndTime = System.currentTimeMillis();
                postExecute(1, false);
                return;
            }
            if (iActionRequest instanceof FileControlRequest) {
                FileControlRequest fileControlRequest = (FileControlRequest) iActionRequest;
                if (fileControlRequest.getFileDataLength() > 0) {
                    onUploadProgress(this.mDataLength, fileControlRequest.getFileDataLength());
                    this.mFileSendOffset = fileControlRequest.getFileDataLength();
                }
            }
        }
    }

    @Override // com.tencent.upload.network.session.IUploadSession.RequestListener
    public void onRequestSessionReport(UploadQualityReportBuilder uploadQualityReportBuilder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) uploadQualityReportBuilder);
        } else {
            onSessionReport(uploadQualityReportBuilder);
        }
    }

    @Override // com.tencent.upload.network.session.IUploadSession.RequestListener
    public void onRequestTimeout(IActionRequest iActionRequest, IUploadSession iUploadSession) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) iActionRequest, (Object) iUploadSession);
            return;
        }
        boolean z16 = iActionRequest.getTag() instanceof UploadThread;
        if (z16) {
            str = ((UploadThread) iActionRequest.getTag()).tTAG;
        } else {
            str = "";
        }
        UploadLog.d(TAG, str + "onRequestTimeout taskId=" + getTaskId() + " reqId=" + iActionRequest.getRequestId() + " CMD=" + iActionRequest.getCmdId() + " mNetworkRetryCount=" + this.mNetworkRetryCount + " session=" + iUploadSession.hashCode() + " mCurrControlReqId=" + this.mCurrControlReqId + " mFlagError:" + this.mFlagError);
        UploadFlowTracker.trackFlow(this, "\u56de\u5305\u8d85\u65f6");
        abortSession(iUploadSession);
        if (iActionRequest.getRequestId() >= this.mCurrControlReqId && !this.mFlagError && !this.mFinish) {
            this.mFlagError = true;
            if (z16) {
                quitMultiThreadUpload();
            }
            if (this.mNetworkRetryCount < getMaxNetworkRetryTimes()) {
                this.mNetworkRetryCount++;
                UploadFlowTracker.trackFlow(this, "\u91cd\u8bd5\u53d1\u63a7\u5236\u5305\uff0c\u91cd\u8bd5\u6b21\u6570" + this.mNetworkRetryCount);
                quitMultiThreadUpload();
                postExecute(0, true);
                return;
            }
            Const.UploadRetCode uploadRetCode = Const.UploadRetCode.REQUEST_TIMEOUT;
            cancelForError(uploadRetCode.getCode(), uploadRetCode.getDesc());
        }
    }

    @Override // com.tencent.upload.network.session.IUploadSession.RequestListener
    public void onResponse(IActionRequest iActionRequest, UploadResponse uploadResponse) {
        String str;
        JceStruct decode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) iActionRequest, (Object) uploadResponse);
            return;
        }
        if (iActionRequest.getTag() instanceof UploadThread) {
            str = ((UploadThread) iActionRequest.getTag()).tTAG;
        } else {
            str = "";
        }
        UploadLog.d(TRANSFER_TAG, str + "recv --- taskId=" + this.mTaskId + ", reqId=" + iActionRequest.getRequestId());
        this.mReportObj.addRtt(iActionRequest.endRecord());
        if (getTaskState() == TaskState.SUCCEED || getTaskState() == TaskState.FAILED || getTaskState() == TaskState.CANCEL || uploadResponse.getRequestSequence() < this.mCurrControlReqId) {
            return;
        }
        int cmd = uploadResponse.getCmd();
        if (cmd != 1) {
            if (cmd != 2) {
                if (cmd == 3) {
                    processFileBatchCommitResponse((FileBatchCommitRsp) JceEncoder.decode(FileBatchCommitRsp.class, uploadResponse.getReponseData()), uploadResponse);
                    return;
                }
                return;
            }
            onFileUploadResponse((FileUploadRsp) JceEncoder.decode(FileUploadRsp.class, uploadResponse.getReponseData()), uploadResponse);
            return;
        }
        if (this.mAppid.equalsIgnoreCase(appid_mobilelog.value)) {
            decode = JceEncoder.decode((Class<JceStruct>) FileControlRsp.class, uploadResponse.getReponseData());
        } else {
            decode = JceEncoder.decode((Class<JceStruct>) FileBatchControlRsp.class, uploadResponse.getReponseData());
        }
        onFileControlResponse(decode, uploadResponse);
    }

    @Override // com.tencent.upload.task.BaseTask
    public boolean onRun() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        this.mFinish = false;
        if (this.mStep != 3 && this.mStep != 4) {
            this.mStep = 0;
            if (this.mSecondUpload) {
                this.mStep = 2;
            } else if (!TextUtils.isEmpty(this.mSessionId) && this.mSliceSize != 0 && !this.mNeedReset) {
                this.mStep = 1;
            } else if (this.mNeedReset) {
                this.mNeedReset = false;
            }
        } else if (this.mNeedReset) {
            this.mStep = 0;
            this.mNeedReset = false;
        }
        UploadLog.d(TAG, "onRun --- step: " + this.mStep + " taskId:" + getTaskId());
        int i3 = this.mStep;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return true;
                        }
                        UploadFlowTracker.trackFlow(this, "\u51c6\u5907\u53d1\u9001\u6570\u636e\u5305");
                        return multiThreadSendFileRangePkg();
                    }
                    return sendCommitFileReq();
                }
                onFileControlResponse(this.mSecondUploadRsp, new UploadResponse());
                return true;
            }
            UploadFlowTracker.trackFlow(this, "\u51c6\u5907\u53d1\u9001\u6570\u636e\u5305");
            return multiThreadSendFilePkg();
        }
        UploadFlowTracker.trackFlow(this, "\u51c6\u5907\u53d1\u9001\u63a7\u5236\u5305");
        return sendControlPkg();
    }

    public abstract void onSessionReport(UploadQualityReportBuilder uploadQualityReportBuilder);

    /* JADX INFO: Access modifiers changed from: protected */
    public void onTaskFinished(int i3, String str) {
        UploadRoute uploadRoute;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, i3, (Object) str);
            return;
        }
        releaseSession();
        IUploadSession iUploadSession = this.mSavedSession;
        if (iUploadSession != null) {
            this.mUploadRoute = iUploadSession.getUploadRoute();
            this.mConnectedIp = this.mSavedSession.getConnectedIp();
            UploadRoute uploadRoute2 = this.mUploadRoute;
            if (uploadRoute2 != null) {
                this.mConnectedPort = uploadRoute2.getPort();
            }
        }
        Const.UploadRetCode uploadRetCode = Const.UploadRetCode.SUCCEED;
        if (i3 == uploadRetCode.getCode()) {
            SessionPool sessionPool = this.mSessionPool;
            if (sessionPool != null && (uploadRoute = this.mUploadRoute) != null) {
                sessionPool.saveRoute(uploadRoute);
            }
        } else if (i3 == Const.UploadRetCode.FAST_SUCCEED.getCode()) {
            i3 = uploadRetCode.getCode();
        }
        if (getTaskState() != TaskState.CANCEL && getTaskState() != TaskState.PAUSE) {
            report(i3, str);
        }
        TaskStateListener taskStateListener = this.mTaskStateListener;
        if (taskStateListener != null) {
            taskStateListener.onTaskFinished(this, i3, str);
        }
    }

    protected abstract void onUploadError(int i3, String str);

    protected abstract void onUploadProgress(long j3, long j16);

    protected abstract void onUploadStateChange(TaskState taskState);

    protected abstract void onUploadSucceed(Object obj);

    public void onWaitCompleteTimeOut(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, i3);
            return;
        }
        UploadLog.d(TAG, "onWaitCompleteTimeOut what:" + i3);
        UploadFlowTracker.trackFlow(this, "\u56de\u5305\u5b8c\u6574\u786e\u8ba4\u8d85\u65f6");
        if (!this.mFlagError && !this.mFinish) {
            this.mFlagError = true;
            uploadSessionReport(UploadQualityReportBuilder.STATE_WAIT_TIMEOUT, 0, "timeout:" + i3 + " step:" + this.mStep);
            if (this.mRetryCount < getMaxRetryTimes()) {
                UploadFlowTracker.trackFlow(this, "\u91cd\u8bd5\u53d1\u53d1\u5b8c\u6574\u6587\u4ef6");
                UploadLog.d(TAG, "retry to send all file data");
                this.mRetryCount++;
                resetWaitState();
                quitMultiThreadUpload();
                resetSessionPool(true);
                this.mSessionId = "";
                return;
            }
            Const.UploadRetCode uploadRetCode = Const.UploadRetCode.DATA_COMPLETE_TIMEOUT;
            cancelForError(uploadRetCode.getCode(), uploadRetCode.getDesc());
        }
    }

    @Override // com.tencent.upload.task.BaseTask
    public boolean pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Boolean) iPatchRedirector.redirect((short) 48, (Object) this)).booleanValue();
        }
        if (getTaskState() != TaskState.SUCCEED && getTaskState() != TaskState.FAILED) {
            TaskState taskState = getTaskState();
            TaskState taskState2 = TaskState.PAUSE;
            if (taskState != taskState2 && getTaskState() != TaskState.CANCEL) {
                if (getTaskState() == TaskState.SENDING && this.mFileSendOffset >= this.mDataLength) {
                    return false;
                }
                super.pause();
                setTaskStatus(taskState2);
                Const.UploadRetCode uploadRetCode = Const.UploadRetCode.PAUSED;
                onTaskFinished(uploadRetCode.getCode(), uploadRetCode.getDesc());
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IUploadSession pollSessionWithRetry(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return (IUploadSession) iPatchRedirector.redirect((short) 62, (Object) this, i3);
        }
        SessionPool sessionPool = this.mSessionPool;
        if (sessionPool == null) {
            return null;
        }
        IUploadSession poll = sessionPool.poll();
        if (poll == null && i3 > 0) {
            UploadLog.e(TAG, "pollSessionWithRetry session == null ! retry poll session. retryTime:" + i3);
            do {
                poll = this.mSessionPool.poll();
                i3--;
                if (poll != null || i3 <= 0) {
                    break;
                }
            } while (!this.mFinish);
        }
        UploadFlowTracker.trackRoute(this, poll);
        return poll;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void postExecute(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        UploadLog.i(TAG, "postExecute taskId:" + getTaskId() + ", postExecute newStep:" + i3 + " needReset:" + z16);
        synchronized (this) {
            if (this.mStep != i3) {
                this.mStep = i3;
            }
        }
        this.mNeedReset = z16;
        if (z16) {
            quitMultiThreadUpload();
            super.cancel();
        }
        start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void printUploadCostLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        String str = (((((float) this.mDataLength) * 1.0f) * 1000.0f) / ((float) ((this.mEndTime - this.mStartTime) * 1024))) + "KB/s";
        UploadLog.d(TAG, "[speed] taskId:" + getTaskId() + ", control pkg cost: " + (this.mControlPkgEndTime - this.mControlPkgStartTime));
        UploadLog.d(TAG, "[speed] taskId:" + getTaskId() + ", data pkg cost: " + (this.mDataPkgEndTime - this.mDataPkgStartTime));
        UploadLog.d(TAG, "[speed] taskId:" + getTaskId() + ", overwrite data pkg cost: " + (this.mDataRangePkgEndTime - this.mDataRangePkgStartTime));
        UploadLog.d(TAG, "[speed] taskId:" + getTaskId() + ", task:" + getClass().getSimpleName() + ", finish -- speed: " + str + " length: " + (this.mDataLength / 1024) + "K");
        this.mFileRecvOffset = this.mDataLength;
    }

    protected void processBatchControlRsp(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void processByRspFlag(stResult stresult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) stresult);
            return;
        }
        switch (stresult.flag) {
            case 11:
            case 12:
                this.mRetryCount++;
                quitMultiThreadUpload();
                postExecute(0, true);
                return;
            case 13:
                this.mRetryCount++;
                this.mSessionId = "";
                quitMultiThreadUpload();
                postExecute(0, true);
                return;
            case 14:
            case 16:
                this.mRetryCount++;
                resetWaitState();
                quitMultiThreadUpload();
                resetSessionPool(true);
                this.mSessionId = "";
                return;
            case 15:
                this.mRetryCount++;
                quitMultiThreadUpload();
                postExecute(3, true);
                return;
            default:
                onError(stresult.ret, stresult.f25097msg);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void processFileBatchCommitResponse(FileBatchCommitRsp fileBatchCommitRsp, UploadResponse uploadResponse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) fileBatchCommitRsp, (Object) uploadResponse);
            return;
        }
        releaseSession();
        setTaskStatus(TaskState.SUCCEED);
        Const.UploadRetCode uploadRetCode = Const.UploadRetCode.SUCCEED;
        onTaskFinished(uploadRetCode.getCode(), uploadRetCode.getDesc());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void processFileUploadFinishRsp(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) bArr);
            return;
        }
        setTaskStatus(TaskState.SUCCEED);
        Const.UploadRetCode uploadRetCode = Const.UploadRetCode.SUCCEED;
        onTaskFinished(uploadRetCode.getCode(), uploadRetCode.getDesc());
    }

    protected void processFileUploadResponse(FileUploadRsp fileUploadRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) fileUploadRsp);
            return;
        }
        if (isFileUploadFinish(fileUploadRsp.result)) {
            uploadSessionReport(UploadQualityReportBuilder.STATE_UPLOAD_SUCCESS, 0, "");
            this.mFinish = true;
            long currentTimeMillis = System.currentTimeMillis();
            this.mEndTime = currentTimeMillis;
            this.mDataPkgEndTime = currentTimeMillis;
            long j3 = this.mDataLength;
            onUploadProgress(j3, j3);
            processFileUploadFinishRsp(fileUploadRsp.biz_rsp);
            printUploadCostLog();
            return;
        }
        startCompleteTimer(1001, UploadSession.getSendTimeout(0));
        long j16 = this.mFileRecvOffset;
        long j17 = fileUploadRsp.offset;
        if (j16 < j17) {
            this.mFileRecvOffset = j17;
            onUploadProgress(this.mDataLength, j17);
            UploadLog.d(TAG, "taskId:" + getTaskId() + ", UploadProgress: [" + fileUploadRsp.offset + "," + this.mDataLength + "]");
        }
    }

    protected void quitMultiThreadUpload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this);
            return;
        }
        synchronized (this.mMultiThreads) {
            Iterator<UploadThread> it = this.mMultiThreads.iterator();
            while (it.hasNext()) {
                UploadThread next = it.next();
                next.quit();
                Future future = next.tFuture;
                if (future != null) {
                    future.cancel(true);
                }
            }
            this.mMultiThreads.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void releaseSession() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this);
            return;
        }
        if (this.mSessionPool == null) {
            UploadLog.w(TAG, "releaseSession mSessionPool == null");
            return;
        }
        synchronized (this.lock) {
            UploadLog.d(TAG, "releaseSession session id:" + this.mSessionId);
            IUploadSession iUploadSession = this.mSession;
            if (iUploadSession != null) {
                this.mSessionPool.offer(iUploadSession);
                this.mSession = null;
            }
            IUploadSession[] iUploadSessionArr = this.mMultiSession;
            if (iUploadSessionArr != null) {
                for (IUploadSession iUploadSession2 : iUploadSessionArr) {
                    if (iUploadSession2 != null) {
                        this.mSessionPool.offer(iUploadSession2);
                    }
                }
                this.mMultiSession = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.task.BaseTask
    public void report(int i3, String str) {
        String ip5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, i3, (Object) str);
            return;
        }
        if (this.mReported) {
            return;
        }
        if (i3 != Const.UploadRetCode.NO_SESSION.getCode() && i3 != Const.UploadRetCode.ALL_IP_FAILED.getCode()) {
            if (i3 == Const.UploadRetCode.FILE_LENGTH_INVALID.getCode()) {
                i3 = Const.UploadRetCode.FILE_NOT_EXIST.getCode();
            }
            Report report = this.mReportObj;
            report.retCode = i3;
            report.errMsg = str;
            if (i3 != Const.UploadRetCode.SUCCEED.getCode()) {
                StringBuilder sb5 = new StringBuilder(50);
                sb5.append(str);
                sb5.append(REPORT_MSG_DIVIDER);
                sb5.append(" clientIp=");
                String str2 = this.mClientIp;
                if (str2 == null) {
                    str2 = "";
                }
                sb5.append(str2);
                sb5.append(" mState=");
                sb5.append(getTaskState().getDesc());
                sb5.append(" mProgressTotalLen=");
                sb5.append(this.mFileSendOffset);
                sb5.append(" mProgressRecvDataLen=");
                sb5.append(this.mFileRecvOffset);
                sb5.append(REPORT_MSG_DIVIDER);
                if (i3 == Const.UploadRetCode.FILE_NOT_EXIST.getCode() || i3 == Const.UploadRetCode.IO_ERROR_RETCODE.getCode() || i3 == 30700 || i3 == 31500) {
                    boolean equals = Environment.getExternalStorageState().equals("mounted");
                    long sdCardAvailableSize = FileUtils.getSdCardAvailableSize();
                    String deviceInfo = UploadGlobalConfig.getConfig().getDeviceInfo();
                    sb5.append(REPORT_MSG_DIVIDER);
                    sb5.append(" sdExist=");
                    sb5.append(equals);
                    sb5.append(" sdCardAvailableSize=");
                    sb5.append(sdCardAvailableSize);
                    sb5.append(" M deviceInfo=");
                    sb5.append(deviceInfo);
                }
                sb5.append(REPORT_MSG_DIVIDER);
                sb5.append("controlPackTimeCost=");
                sb5.append(this.mControlPkgEndTime - this.mControlPkgStartTime);
                this.mReportObj.errMsg = sb5.toString();
            }
            Report report2 = this.mReportObj;
            report2.flowId = this.flowId;
            report2.filePath = this.mFilePath;
            long j3 = this.mStartTime;
            if (j3 > this.mEndTime) {
                this.mEndTime = j3;
            }
            if (j3 != 0) {
                report2.startTime = j3;
                report2.endTime = this.mEndTime;
            }
            long j16 = this.mControlPkgStartTime;
            if (j16 != 0) {
                report2.ctrlStart = j16;
                report2.ctrlEnd = this.mControlPkgEndTime;
            }
            long j17 = this.mDataPkgStartTime;
            if (j17 != 0) {
                report2.dataStart = j17;
                report2.dataEnd = this.mDataPkgEndTime;
            }
            UploadRoute uploadRoute = this.mUploadRoute;
            if (uploadRoute == null) {
                ip5 = WiFiDash.NOT_AVALIBLE;
            } else {
                ip5 = uploadRoute.getIp();
            }
            report2.serverIp = ip5;
            UploadRoute uploadRoute2 = this.mUploadRoute;
            int i16 = 0;
            if (uploadRoute2 == null) {
                this.mReportObj.isIPV6 = false;
            } else if (StringUtils.isIpv6String(uploadRoute2.getIp())) {
                this.mReportObj.isIPV6 = true;
            } else if (this.mSessionPool.getmRouteStrategy() != null && this.mSessionPool.getmRouteStrategy().getServerRouteTable() != null && this.mUploadRoute.getIp().equals(this.mSessionPool.getmRouteStrategy().getServerRouteTable().getV6HostString())) {
                this.mReportObj.isIPV6 = true;
            }
            Report report3 = this.mReportObj;
            UploadRoute uploadRoute3 = this.mUploadRoute;
            if (uploadRoute3 != null && uploadRoute3.getRouteCategory() != null) {
                i16 = this.mUploadRoute.getRouteCategory().getType();
            }
            report3.ipsrctype = i16;
            this.mReportObj.networkType = UploadConfiguration.getCurrentNetworkCategory();
            Report report4 = this.mReportObj;
            report4.retry = this.mRetryCount;
            report4.content_type = "slice_upload";
            report4.concurrent = BaseUploadService.getFileSocketNumber();
            this.mReportObj.num = BaseUploadService.getBatchControlNumber();
            Report report5 = this.mReportObj;
            long j18 = report5.endTime - report5.startTime;
            long j19 = report5.fileSize;
            if (j19 < 0) {
                this.mReported = true;
                return;
            } else {
                if (j19 < j18 && report5.networkType != 3) {
                    this.mReported = true;
                    return;
                }
                return;
            }
        }
        this.mReported = true;
    }

    protected void resetSessionPool(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, z16);
            return;
        }
        UploadLog.d(TAG, "resetSessionPool taskId=" + getTaskId() + " delete:" + z16 + " mSessionId:" + this.mSessionId);
        if (z16) {
            CacheUtil.deleteSessionId(this, this.mSessionId);
        }
        SessionPool sessionPool = this.mSessionPool;
        if (sessionPool != null) {
            sessionPool.reset();
        }
    }

    public void resetTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this);
        } else {
            this.mNeedReset = true;
            quitMultiThreadUpload();
        }
    }

    protected boolean sendCommitFileReq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return true;
    }

    protected boolean sessionsValidCheck(IUploadSession[] iUploadSessionArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return ((Boolean) iPatchRedirector.redirect((short) 61, (Object) this, (Object) iUploadSessionArr)).booleanValue();
        }
        if (iUploadSessionArr == null || iUploadSessionArr.length == 0) {
            return false;
        }
        for (IUploadSession iUploadSession : iUploadSessionArr) {
            if (iUploadSession != null) {
                return true;
            }
        }
        return false;
    }

    public void setFilePath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            this.mFilePath = str;
        }
    }

    public void setInnerAppid(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        } else {
            this.mAppid = str;
        }
    }

    public void setSecondUpload(FileControlRsp fileControlRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) fileControlRsp);
        } else {
            this.mSecondUpload = true;
            this.mSecondUploadRsp = fileControlRsp;
        }
    }

    public void setSessionId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            this.mSessionId = str;
        }
    }

    public void setSliceSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.mSliceSize = i3;
        }
    }

    public void setTaskStateListener(TaskStateListener taskStateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) taskStateListener);
        } else {
            this.mTaskStateListener = taskStateListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.task.BaseTask
    public boolean setTaskStatus(TaskState taskState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Boolean) iPatchRedirector.redirect((short) 51, (Object) this, (Object) taskState)).booleanValue();
        }
        boolean taskStatus = super.setTaskStatus(taskState);
        onTaskInfoChanged();
        if (taskStatus) {
            onUploadStateChange(taskState);
        }
        return taskStatus;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startCompleteTimer(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, this, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        UploadLog.v(TAG, "startCompleteTimer... what:" + i3 + " delay:" + j3);
        this.mHandler.removeMessages(this.flowId + i3);
        Message obtain = Message.obtain(this.mHandler, new Runnable(i3) { // from class: com.tencent.upload.task.UploadTask.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int val$what;

            {
                this.val$what = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UploadTask.this, i3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    UploadTask.this.onWaitCompleteTimeOut(this.val$what);
                }
            }
        });
        obtain.what = i3 + this.flowId;
        this.mHandler.sendMessageDelayed(obtain, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uploadSessionReport(String str, int i3, String str2) {
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, str, Integer.valueOf(i3), str2);
            return;
        }
        if (this.mMultiSession == null) {
            UploadLog.w(TAG, "uploadSessionReport... mMultiSession == null");
            return;
        }
        while (true) {
            IUploadSession[] iUploadSessionArr = this.mMultiSession;
            if (iUploadSessionArr != null && i16 < iUploadSessionArr.length) {
                IUploadSession iUploadSession = iUploadSessionArr[i16];
                if (iUploadSession != null) {
                    try {
                        str3 = iUploadSession.getBaseSessionReportString();
                    } catch (Exception e16) {
                        UploadLog.w(TAG, e16);
                        str3 = "";
                    }
                    onSessionReport(new UploadQualityReportBuilder().setExt1(str3).setExt2(str).setKeyRetCode(String.valueOf(i3)).setDesc(str2).setAttachInfo(this.mSessionId));
                }
                i16++;
            } else {
                return;
            }
        }
    }

    protected void resetSessionPool(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, (Object) str, i3);
            return;
        }
        UploadLog.d(TAG, "resetSessionPool taskId=" + getTaskId() + " delete mSessionId:" + this.mSessionId);
        CacheUtil.deleteSessionId(this, this.mSessionId);
        this.mSessionPool.reset(new UploadRoute(str, i3, IUploadRouteStrategy.RouteCategoryType.REDIRECT));
    }

    public UploadTask(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
            return;
        }
        this.mIsFastUpload = false;
        this.mStep = 0;
        this.mRetryCount = 0;
        this.mNetworkRetryCount = 0;
        this.mConnectedIp = "";
        this.mConnectedPort = 0;
        this.mCurrControlReqId = 0;
        this.mFlagError = false;
        this.mMultiThreads = new ArrayList<>(5);
        this.mReportObj = new Report();
        this.mReported = false;
        this.overwriteRangeBegin = 0L;
        this.overwriteRangeEnd = 0L;
        this.overwriteSize = 0L;
        this.lock = new Object();
        this.mDataSource = new UploadDataSource.ByteDataSource(bArr);
    }

    public UploadTask(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) parcel);
            return;
        }
        this.mIsFastUpload = false;
        this.mStep = 0;
        this.mRetryCount = 0;
        this.mNetworkRetryCount = 0;
        this.mConnectedIp = "";
        this.mConnectedPort = 0;
        this.mCurrControlReqId = 0;
        this.mFlagError = false;
        this.mMultiThreads = new ArrayList<>(5);
        this.mReportObj = new Report();
        this.mReported = false;
        this.overwriteRangeBegin = 0L;
        this.overwriteRangeEnd = 0L;
        this.overwriteSize = 0L;
        this.lock = new Object();
        this.mTaskId = parcel.readInt();
        this.mDataSource = (UploadDataSource) parcel.readParcelable(UploadDataSource.class.getClassLoader());
        this.mSessionId = parcel.readString();
        TaskState stateFromCode = TaskState.getStateFromCode(parcel.readInt());
        setTaskStatus((stateFromCode == TaskState.CONNECTING || stateFromCode == TaskState.SENDING) ? TaskState.WAITING : stateFromCode);
    }
}
