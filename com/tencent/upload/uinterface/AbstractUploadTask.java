package com.tencent.upload.uinterface;

import SLICE_UPLOAD.AuthToken;
import SLICE_UPLOAD.CheckType;
import SLICE_UPLOAD.DumpBussinessReq;
import SLICE_UPLOAD.FileControlReq;
import SLICE_UPLOAD.UploadModel;
import SLICE_UPLOAD.cnst.appid_video;
import SLICE_UPLOAD.stEnvironment;
import android.os.Handler;
import android.os.Parcel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.network.session.cache.CacheUtil;
import com.tencent.upload.report.Report;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.upload.request.UploadRequest;
import com.tencent.upload.request.impl.BatchControlRequest;
import com.tencent.upload.request.impl.FileControlRequest;
import com.tencent.upload.request.impl.FileUploadRequest;
import com.tencent.upload.task.AtomFile;
import com.tencent.upload.task.TaskState;
import com.tencent.upload.task.UploadTask;
import com.tencent.upload.task.data.UploadDataSource;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.token.TokenProvider;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.UploadLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class AbstractUploadTask extends UploadTask {
    static IPatchRedirector $redirector_ = null;
    public static final String ENTRY_TYPE_ALBUM = "album";
    public static final String ENTRY_TYPE_SHUOSHUO = "shoushuo";
    protected static final String TAG = "AbstractUploadTask";
    public String entry;
    public Object extra;
    public int iSync;
    public long iUin;
    public long iUploadTime;
    public boolean isSyncWeishi;
    protected int lastState;
    protected int mBatchId;
    protected byte[] mBizReq;
    protected CheckType mCheckType;
    protected String mChecksum;
    public Map<String, String> mExtend_info;
    protected boolean mKeepFileAfterUpload;
    protected UploadModel mModel;
    protected boolean mNeedBatch;
    protected boolean mNeedIpRedirect;
    public String mOriginFilePath;
    protected stEnvironment mStEnv;
    public IUploadConfig.UploadImageSize mTargetSize;
    protected String mTmpUploadPath;
    public String md5;
    public boolean needCompress;
    public AbstractUploadTask origin;
    public int preupload;
    public String reportRefer;
    public String sDescMD5;
    public String sDevIMEI;
    public String sFileMD5;
    public String sRefer;
    public String sha1;
    public Map<String, String> transferData;
    public String uiRefer;
    public int uploadEntrance;
    public String uploadFilePath;
    public int uploadIndex;
    public IUploadTaskCallback uploadTaskCallback;
    public byte[] vLoginData;
    public byte[] vLoginKey;

    public AbstractUploadTask(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.uploadTaskCallback = null;
        this.md5 = null;
        this.sha1 = null;
        this.preupload = 0;
        this.reportRefer = "mqzone";
        this.entry = "";
        this.iUin = 0L;
        this.sRefer = "mqzone";
        this.iSync = 1;
        this.vLoginData = null;
        this.vLoginKey = new byte[0];
        this.uploadEntrance = 0;
        this.transferData = null;
        this.iUploadTime = 0L;
        this.mChecksum = "";
        this.mKeepFileAfterUpload = true;
        this.mNeedBatch = true;
        this.needCompress = true;
        this.lastState = -1;
        this.uploadIndex = 0;
        this.mOriginFilePath = str;
        this.uploadFilePath = str;
        init();
    }

    private void init() {
        this.mNeedIpRedirect = false;
        this.mDataLength = FileUtils.getFileLength(this.mFilePath);
    }

    private void resetPath(String str) {
        this.mFilePath = str;
        this.mDataSource = new UploadDataSource.FileDataSource(str);
        this.mDataLength = FileUtils.getFileLength(this.mFilePath);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void buildEnv() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        stEnvironment env = UploadGlobalConfig.getEnv();
        this.mStEnv = env;
        env.refer = this.sRefer;
        env.entrance = this.uploadEntrance;
    }

    public byte[] buildExtra() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (byte[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "null".getBytes();
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.flowId == ((AbstractUploadTask) obj).flowId) {
            return true;
        }
        return false;
    }

    public int getAppid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.iAppid;
    }

    public int getBatchId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        return this.mBatchId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.task.UploadTask
    public int getBucketSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return 16384;
    }

    @Override // com.tencent.upload.task.UploadTask
    protected UploadRequest getControlRequest() {
        HashMap hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (UploadRequest) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.mAppid.equalsIgnoreCase(appid_video.value)) {
            this.mCheckType = CheckType.TYPE_SHA1;
            String fileSha1 = FileUtils.getFileSha1(new File(this.mFilePath));
            this.sha1 = fileSha1;
            this.mChecksum = fileSha1;
        } else {
            this.mCheckType = CheckType.TYPE_MD5;
            String md5ByFile_REAL = FileUtils.getMd5ByFile_REAL(new File(this.mFilePath));
            this.md5 = md5ByFile_REAL;
            this.mChecksum = md5ByFile_REAL;
        }
        UploadLog.d(TAG, "mCheckType: " + this.mCheckType + "\nmChecksum: " + this.mChecksum);
        AuthToken authToken = TokenProvider.getAuthToken(this.vLoginData, this.vLoginKey);
        buildEnv();
        this.mModel = UploadModel.MODEL_NORMAL;
        if (this.preupload == 1) {
            this.mModel = UploadModel.MODEL_PRE_UPLOAD;
        }
        if (this.isSyncWeishi) {
            hashMap = new HashMap();
            DumpBussinessReq dumpBussinessReq = new DumpBussinessReq();
            dumpBussinessReq.IMEI = this.sDevIMEI;
            hashMap.put(1, dumpBussinessReq);
        } else {
            hashMap = null;
        }
        FileControlRequest fileControlRequest = new FileControlRequest(this.iUin + "", this.mAppid, authToken, this.mChecksum, this.mCheckType, this.mDataLength, this.mStEnv, this.mModel, this.mSessionId, this.mNeedIpRedirect, true, this.iSync, hashMap, this.mExtend_info);
        fileControlRequest.setExtraParam(buildExtra());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("1", (FileControlReq) fileControlRequest.createJceRequest());
        BatchControlRequest batchControlRequest = new BatchControlRequest(hashMap2);
        batchControlRequest.setTaskId(this.flowId);
        return batchControlRequest;
    }

    public long getFileLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return this.mDataLength;
    }

    @Override // com.tencent.upload.task.BaseTask
    public Const.FileType getFileType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Const.FileType) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return Const.FileType.Other;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.task.UploadTask
    public FileUploadRequest getFileUploadRequest(AtomFile atomFile) {
        FileUploadRequest fileUploadRequest;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (FileUploadRequest) iPatchRedirector.redirect((short) 5, (Object) this, (Object) atomFile);
        }
        int i3 = this.mSliceSize;
        if (i3 <= 0) {
            i3 = getBucketSize();
        }
        this.mSliceSize = i3;
        synchronized (atomFile) {
            long remainSize = atomFile.getRemainSize();
            if (remainSize <= 0) {
                UploadLog.w(TAG, "[speed] id:" + this.flowId + " --- no data to send !!");
                fileUploadRequest = null;
            } else {
                long min = Math.min(remainSize, this.mSliceSize);
                fileUploadRequest = new FileUploadRequest(this.mDataSource, this.iUin + "", this.mAppid, this.mSessionId, atomFile.reduce(min), min, this.mCheckType, false);
                fileUploadRequest.setTaskId(this.flowId);
            }
        }
        return fileUploadRequest;
    }

    public String getFlowMessage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (String) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return this.mFlowRecoder.toString();
    }

    public StringBuffer getFlowRecoder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (StringBuffer) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return this.mFlowRecoder;
    }

    public String getProtocolAppid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.mAppid;
    }

    public Report getReportObj() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (Report) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this.mReportObj;
    }

    public String getTableKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return getUploadTaskType().serverRouteTable.getSessionPoolKey();
    }

    protected boolean isNetworkAvailable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        return UploadConfiguration.isNetworkAvailable();
    }

    public boolean isUseNewTaskReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this)).booleanValue();
        }
        return false;
    }

    public void keepTmpFile(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
        } else {
            this.mKeepFileAfterUpload = z16;
        }
    }

    public boolean needWaitBatch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        return this.mNeedBatch;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.task.UploadTask
    public void onBatchControlRsp(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, obj);
            return;
        }
        IUploadTaskCallback iUploadTaskCallback = this.uploadTaskCallback;
        if (iUploadTaskCallback != null && (iUploadTaskCallback instanceof IUploadTaskExtendCallback)) {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable(obj) { // from class: com.tencent.upload.uinterface.AbstractUploadTask.5
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Object val$result;

                    {
                        this.val$result = obj;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AbstractUploadTask.this, obj);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        AbstractUploadTask abstractUploadTask = AbstractUploadTask.this;
                        IUploadTaskCallback iUploadTaskCallback2 = abstractUploadTask.uploadTaskCallback;
                        if (iUploadTaskCallback2 != null) {
                            ((IUploadTaskExtendCallback) iUploadTaskCallback2).onBatchControlRsp(abstractUploadTask, this.val$result);
                        }
                    }
                });
            } else {
                ((IUploadTaskExtendCallback) iUploadTaskCallback).onBatchControlRsp(this, obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        } else {
            CacheUtil.deleteSessionId(this, this.mSessionId);
        }
    }

    @Override // com.tencent.upload.task.UploadTask
    public void onSessionReport(UploadQualityReportBuilder uploadQualityReportBuilder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) uploadQualityReportBuilder);
        }
    }

    @Override // com.tencent.upload.task.UploadTask
    protected void onUploadError(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3, (Object) str);
            return;
        }
        UploadLog.w(TAG, "upload file failed! actionId=" + getTaskId() + " ret=" + i3 + " msg=" + str);
        IUploadTaskCallback iUploadTaskCallback = this.uploadTaskCallback;
        if (iUploadTaskCallback == null) {
            return;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable(i3, str) { // from class: com.tencent.upload.uinterface.AbstractUploadTask.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$errorCode;
                final /* synthetic */ String val$errorMsg;

                {
                    this.val$errorCode = i3;
                    this.val$errorMsg = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, AbstractUploadTask.this, Integer.valueOf(i3), str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AbstractUploadTask abstractUploadTask = AbstractUploadTask.this;
                    IUploadTaskCallback iUploadTaskCallback2 = abstractUploadTask.uploadTaskCallback;
                    if (iUploadTaskCallback2 != null) {
                        iUploadTaskCallback2.onUploadError(abstractUploadTask, this.val$errorCode, this.val$errorMsg);
                    }
                }
            });
        } else {
            iUploadTaskCallback.onUploadError(this, i3, str);
        }
    }

    public final void onUploadProcessStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            onUploadStateChange(TaskState.WAITING);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.task.UploadTask
    public void onUploadProgress(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (this.uploadTaskCallback == null || this.mFinish) {
            return;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable(j3, j16) { // from class: com.tencent.upload.uinterface.AbstractUploadTask.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long val$recvDataSize;
                final /* synthetic */ long val$totalSize;

                {
                    this.val$totalSize = j3;
                    this.val$recvDataSize = j16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, AbstractUploadTask.this, Long.valueOf(j3), Long.valueOf(j16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AbstractUploadTask abstractUploadTask = AbstractUploadTask.this;
                    IUploadTaskCallback iUploadTaskCallback = abstractUploadTask.uploadTaskCallback;
                    if (iUploadTaskCallback != null) {
                        iUploadTaskCallback.onUploadProgress(abstractUploadTask, this.val$totalSize, this.val$recvDataSize);
                    }
                }
            });
        } else {
            this.uploadTaskCallback.onUploadProgress(this, j3, j16);
        }
    }

    @Override // com.tencent.upload.task.UploadTask
    protected void onUploadStateChange(TaskState taskState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) taskState);
            return;
        }
        int outState = taskState.getOutState();
        if ((outState != 1 || this.lastState != outState) && outState != -1000 && outState != 0) {
            this.lastState = outState;
            IUploadTaskCallback iUploadTaskCallback = this.uploadTaskCallback;
            if (iUploadTaskCallback == null) {
                return;
            }
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable(outState) { // from class: com.tencent.upload.uinterface.AbstractUploadTask.4
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ int val$outState;

                    {
                        this.val$outState = outState;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AbstractUploadTask.this, outState);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        AbstractUploadTask abstractUploadTask = AbstractUploadTask.this;
                        IUploadTaskCallback iUploadTaskCallback2 = abstractUploadTask.uploadTaskCallback;
                        if (iUploadTaskCallback2 != null) {
                            iUploadTaskCallback2.onUploadStateChange(abstractUploadTask, this.val$outState);
                        }
                    }
                });
            } else {
                iUploadTaskCallback.onUploadStateChange(this, outState);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.task.UploadTask
    public void onUploadSucceed(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, obj);
            return;
        }
        IUploadTaskCallback iUploadTaskCallback = this.uploadTaskCallback;
        if (iUploadTaskCallback == null) {
            return;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable(obj) { // from class: com.tencent.upload.uinterface.AbstractUploadTask.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Object val$result;

                {
                    this.val$result = obj;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AbstractUploadTask.this, obj);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AbstractUploadTask abstractUploadTask = AbstractUploadTask.this;
                    IUploadTaskCallback iUploadTaskCallback2 = abstractUploadTask.uploadTaskCallback;
                    if (iUploadTaskCallback2 != null) {
                        iUploadTaskCallback2.onUploadSucceed(abstractUploadTask, this.val$result);
                    }
                }
            });
        } else {
            iUploadTaskCallback.onUploadSucceed(this, obj);
        }
    }

    public boolean onVerifyUploadFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        String filePath = getFilePath();
        if (!FileUtils.isFileExist(filePath)) {
            StringBuilder sb5 = new StringBuilder();
            Const.UploadRetCode uploadRetCode = Const.UploadRetCode.FILE_NOT_EXIST;
            sb5.append(uploadRetCode);
            sb5.append(" path:");
            sb5.append(filePath);
            UploadLog.e(TAG, sb5.toString());
            onError(uploadRetCode.getCode(), uploadRetCode.getDesc());
            return false;
        }
        if (!FileUtils.isValidTempFile(filePath)) {
            StringBuilder sb6 = new StringBuilder();
            Const.UploadRetCode uploadRetCode2 = Const.UploadRetCode.FILE_LENGTH_INVALID;
            sb6.append(uploadRetCode2);
            sb6.append(" path:");
            sb6.append(filePath);
            UploadLog.e(TAG, sb6.toString());
            onError(uploadRetCode2.getCode(), uploadRetCode2.getDesc());
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.task.UploadTask, com.tencent.upload.task.BaseTask
    public void report(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3, (Object) str);
            return;
        }
        Report report = this.mReportObj;
        report.refer = this.reportRefer;
        report.uploadType = getUploadTaskType();
        this.mReportObj.fileSize = getFileLength();
        Report report2 = this.mReportObj;
        report2.transfer = this.transferData;
        report2.entry = this.entry;
        super.report(i3, str);
        Report report3 = this.mReportObj;
        report3.elapse = report3.endTime - report3.startTime;
        report3.ctrlElapse = report3.ctrlEnd - report3.ctrlStart;
        report3.dataElapse = report3.dataEnd - report3.dataStart;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void retryPollSession() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (this.mRetryCount < getMaxRetryTimes() && isNetworkAvailable()) {
            this.mRetryCount++;
            postExecute(0, true);
        } else {
            Const.UploadRetCode uploadRetCode = Const.UploadRetCode.NO_SESSION;
            cancelForError(uploadRetCode.getCode(), uploadRetCode.getDesc());
        }
    }

    public void setBatchId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
        } else {
            this.mBatchId = i3;
        }
    }

    public void setTmpFilePath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
        } else {
            this.mTmpUploadPath = str;
            resetPath(str);
        }
    }

    public void taskReport(Report report) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) report);
        }
    }

    public AbstractUploadTask(byte[] bArr) {
        super(bArr);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
            return;
        }
        this.uploadFilePath = null;
        this.uploadTaskCallback = null;
        this.md5 = null;
        this.sha1 = null;
        this.preupload = 0;
        this.reportRefer = "mqzone";
        this.entry = "";
        this.iUin = 0L;
        this.sRefer = "mqzone";
        this.iSync = 1;
        this.vLoginData = null;
        this.vLoginKey = new byte[0];
        this.uploadEntrance = 0;
        this.transferData = null;
        this.iUploadTime = 0L;
        this.mChecksum = "";
        this.mKeepFileAfterUpload = true;
        this.mNeedBatch = true;
        this.needCompress = true;
        this.lastState = -1;
        this.uploadIndex = 0;
        init();
    }

    public AbstractUploadTask(Parcel parcel) {
        super(parcel);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            return;
        }
        this.uploadFilePath = null;
        this.uploadTaskCallback = null;
        this.md5 = null;
        this.sha1 = null;
        this.preupload = 0;
        this.reportRefer = "mqzone";
        this.entry = "";
        this.iUin = 0L;
        this.sRefer = "mqzone";
        this.iSync = 1;
        this.vLoginData = null;
        this.vLoginKey = new byte[0];
        this.uploadEntrance = 0;
        this.transferData = null;
        this.iUploadTime = 0L;
        this.mChecksum = "";
        this.mKeepFileAfterUpload = true;
        this.mNeedBatch = true;
        this.needCompress = true;
        this.lastState = -1;
        this.uploadIndex = 0;
        this.sFileMD5 = parcel.readString();
    }
}
