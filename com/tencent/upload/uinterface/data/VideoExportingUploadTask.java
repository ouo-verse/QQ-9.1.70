package com.tencent.upload.uinterface.data;

import SLICE_UPLOAD.AuthToken;
import SLICE_UPLOAD.CheckType;
import SLICE_UPLOAD.FileBatchCommitReq;
import SLICE_UPLOAD.FileBatchCommitRsp;
import SLICE_UPLOAD.FileCommitReq;
import SLICE_UPLOAD.FileCommitRsp;
import SLICE_UPLOAD.FileControlReq;
import SLICE_UPLOAD.FileUploadRsp;
import SLICE_UPLOAD.UploadModel;
import SLICE_UPLOAD.stOffset;
import SLICE_UPLOAD.stResult;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.network.session.IUploadSession;
import com.tencent.upload.network.session.UploadSession;
import com.tencent.upload.network.session.cache.CacheUtil;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.upload.request.UploadRequest;
import com.tencent.upload.request.UploadResponse;
import com.tencent.upload.request.impl.BatchCommitRequest;
import com.tencent.upload.request.impl.BatchControlRequest;
import com.tencent.upload.request.impl.FileControlRequest;
import com.tencent.upload.request.impl.FileUploadRequest;
import com.tencent.upload.request.impl.VideoExportingFileUploadRequest;
import com.tencent.upload.task.AtomFile;
import com.tencent.upload.task.TaskState;
import com.tencent.upload.task.UploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.uinterface.token.TokenProvider;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.UploadLog;
import com.tencent.upload.utils.pool.UploadThreadManager;
import com.tencent.upload.utils.watcher.UploadFlowTracker;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class VideoExportingUploadTask extends VideoUploadTask {
    static IPatchRedirector $redirector_ = null;
    private static final int NUM_1M = 1048576;
    public static final String TAG = "VideoExportingUploadTask";
    private HashMap<String, String> extendInfo;
    private boolean mHasFinishExport;
    private boolean mHasSendCommitReq;
    private long mServiceRecOffset;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class UploadWaitExportThread extends UploadTask.UploadThread {
        static IPatchRedirector $redirector_;

        public UploadWaitExportThread(AtomFile atomFile, IUploadSession iUploadSession, boolean z16) {
            super(atomFile, iUploadSession);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, VideoExportingUploadTask.this, atomFile, iUploadSession, Boolean.valueOf(z16));
            }
        }

        protected boolean isCheckFileCanUpload(AtomFile atomFile) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) atomFile)).booleanValue();
            }
            VideoExportingUploadTask videoExportingUploadTask = VideoExportingUploadTask.this;
            ((UploadTask) videoExportingUploadTask).mSliceSize = ((UploadTask) videoExportingUploadTask).mSliceSize > 0 ? ((UploadTask) VideoExportingUploadTask.this).mSliceSize : VideoExportingUploadTask.this.getBucketSize();
            long remainSizeByCheckFileSize = atomFile.getRemainSizeByCheckFileSize();
            boolean isFileHasExportingCompleted = atomFile.isFileHasExportingCompleted();
            UploadLog.w(VideoExportingUploadTask.TAG, this.tTAG + " isCheckFileCanUpload... hasFinishExporting:" + isFileHasExportingCompleted + " remain:" + remainSizeByCheckFileSize + " mSliceSize:" + ((UploadTask) VideoExportingUploadTask.this).mSliceSize);
            if (!isFileHasExportingCompleted && Math.min(remainSizeByCheckFileSize, ((UploadTask) VideoExportingUploadTask.this).mSliceSize) < ((UploadTask) VideoExportingUploadTask.this).mSliceSize) {
                return false;
            }
            return true;
        }

        public void notifyFinishReadFile() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            synchronized (this.tFile) {
                this.tFile.setFileHasExportingCompleted(true);
                this.tFile.notifyAll();
            }
        }

        public void notifyWakeReadFile() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            synchronized (this.tFile) {
                this.tFile.notifyAll();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:66:0x0087, code lost:
        
            com.tencent.upload.utils.UploadLog.w(com.tencent.upload.task.UploadTask.TRANSFER_TAG, r7.tTAG + " thread finish threadId=" + r7.tId + " tFile wait finish...");
         */
        @Override // com.tencent.upload.task.UploadTask.UploadThread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                VideoExportingUploadTask.this.setTaskStatus(TaskState.SENDING);
                while (true) {
                    synchronized (this.tFile) {
                        while (!this.tFile.isFileHasExportingCompleted() && !this.tFinish && !isCheckFileCanUpload(this.tFile)) {
                            try {
                                UploadLog.w(UploadTask.TRANSFER_TAG, this.tTAG + " wait tFile...");
                                LockMethodProxy.wait(this.tFile);
                                UploadLog.w(UploadTask.TRANSFER_TAG, this.tTAG + " wait tFile finish...");
                            } catch (Exception e16) {
                                UploadLog.e(VideoExportingUploadTask.TAG, this.tTAG + " isCheckFileCanUpload ", e16);
                            }
                        }
                        if (!this.tFinish) {
                            FileUploadRequest fileUploadRequest = VideoExportingUploadTask.this.getFileUploadRequest(this.tFile);
                            if (fileUploadRequest != null) {
                                ((UploadTask) VideoExportingUploadTask.this).mFileSendOffset = fileUploadRequest.mOffset + fileUploadRequest.getRealDataSize();
                                ((UploadTask) VideoExportingUploadTask.this).mLastSliceSize = fileUploadRequest.getRealDataSize();
                                ((UploadTask) VideoExportingUploadTask.this).mLastSendOffset = fileUploadRequest.mOffset;
                                ((UploadTask) VideoExportingUploadTask.this).mDataPkgEndTime = System.currentTimeMillis();
                                fileUploadRequest.setTag(this);
                            }
                            if (fileUploadRequest == null) {
                                UploadLog.d(VideoExportingUploadTask.TAG, this.tTAG + " request == null, send over!!");
                                break;
                            }
                            this.tWaitFlag = true;
                            boolean send = this.tSession.send(fileUploadRequest, VideoExportingUploadTask.this.getMTaskTypeConfig(), VideoExportingUploadTask.this);
                            UploadLog.d(UploadTask.TRANSFER_TAG, this.tTAG + " send result=" + send + " reqId=" + fileUploadRequest.getRequestId());
                            VideoExportingUploadTask.this.clearCompleteTimer(1001);
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
                            } catch (Exception e17) {
                                UploadLog.e(UploadTask.TRANSFER_TAG, this.tTAG + "run tFinish: " + this.tFinish + " mFinish: " + ((UploadTask) VideoExportingUploadTask.this).mFinish, e17);
                            }
                            if (this.tFinish || ((UploadTask) VideoExportingUploadTask.this).mFinish) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                UploadLog.d(UploadTask.TRANSFER_TAG, this.tTAG + " thread finish threadId=" + this.tId + " mFinish=" + ((UploadTask) VideoExportingUploadTask.this).mFinish);
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this);
        }

        @Override // com.tencent.upload.task.UploadTask.UploadThread
        protected synchronized void terminate() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            UploadLog.d(UploadTask.TRANSFER_TAG, this.tTAG + " terminate... threadId=" + this.tId + " tFinish=" + this.tFinish);
            if (this.tFinish) {
                return;
            }
            this.tFinish = true;
            notify();
            synchronized (this.tFile) {
                this.tFile.notifyAll();
            }
        }
    }

    public VideoExportingUploadTask(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.mHasFinishExport = false;
        this.mHasSendCommitReq = false;
        this.mServiceRecOffset = 0L;
        this.extendInfo = new HashMap<>();
    }

    private BatchCommitRequest getFileCommitRequest() {
        ArrayList<String> arrayList;
        int i3;
        long currentTimeMillis = System.currentTimeMillis();
        this.md5 = FileUtils.getMd5ByFile_REAL(this.mAtomFile.getFile());
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        long currentTimeMillis3 = System.currentTimeMillis();
        File file = this.mAtomFile.getFile();
        int i16 = this.mSliceSize;
        if (i16 <= 0) {
            i16 = getBucketSize();
        }
        ArrayList<String> md5BySize = FileUtils.getMd5BySize(file, i16);
        this.extend_info.putAll(this.extendInfo);
        String str = this.iUin + "";
        String str2 = this.mSessionId;
        byte[] buildExtra = buildExtra();
        String str3 = this.mAppid;
        HashMap hashMap = new HashMap();
        String str4 = this.md5;
        long length = this.mAtomFile.getFile().length();
        if (md5BySize != null) {
            arrayList = md5BySize;
        } else {
            arrayList = new ArrayList<>();
        }
        FileCommitReq fileCommitReq = new FileCommitReq(str, str2, buildExtra, str3, hashMap, str4, 0, length, arrayList);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[getFileCommitRequest] check slice md5 cost: ");
        sb5.append(System.currentTimeMillis() - currentTimeMillis3);
        sb5.append(" size:");
        if (md5BySize != null) {
            i3 = md5BySize.size();
        } else {
            i3 = 0;
        }
        sb5.append(i3);
        sb5.append(" check all File md5 cost:");
        sb5.append(currentTimeMillis2);
        sb5.append(" md5:");
        sb5.append(this.md5);
        UploadLog.d(UploadTask.TRANSFER_TAG, sb5.toString());
        HashMap hashMap2 = new HashMap();
        hashMap2.put(String.valueOf(this.flowId), fileCommitReq);
        return new BatchCommitRequest(new FileBatchCommitReq(hashMap2), this.flowId);
    }

    private FileUploadRequest getFileUploadRequestForNoOverwrite(AtomFile atomFile, FileUploadRequest fileUploadRequest) {
        int i3 = this.mSliceSize;
        if (i3 <= 0) {
            i3 = getBucketSize();
        }
        this.mSliceSize = i3;
        long remainSizeByCheckFileSize = atomFile.getRemainSizeByCheckFileSize();
        if (remainSizeByCheckFileSize <= 0) {
            UploadLog.w(UploadTask.TRANSFER_TAG, "[speed] [getFileUploadRequestForNoOverwrite] id:" + this.flowId + " --- no data to send !!");
            return fileUploadRequest;
        }
        long min = Math.min(remainSizeByCheckFileSize, this.mSliceSize);
        VideoExportingFileUploadRequest videoExportingFileUploadRequest = new VideoExportingFileUploadRequest(this.mDataSource, this.iUin + "", this.mAppid, this.mSessionId, atomFile.reduce(min), min, CheckType.TYPE_MD5, false);
        videoExportingFileUploadRequest.dataType = 1;
        videoExportingFileUploadRequest.setTaskId(this.flowId);
        UploadLog.d(UploadTask.TRANSFER_TAG, "[getFileUploadRequestForNoOverwrite] id:" + this.flowId + " dataType:" + videoExportingFileUploadRequest.dataType);
        return videoExportingFileUploadRequest;
    }

    @Override // com.tencent.upload.task.UploadTask
    protected void buildThread(IUploadSession[] iUploadSessionArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) iUploadSessionArr);
            return;
        }
        this.mAtomFile.setFileHasExportingCompleted(this.mHasFinishExport);
        UploadLog.d(UploadTask.TRANSFER_TAG, "taskId:" + this.mTaskId + ", filePkg, begin to wait available session ----> atomFile:" + this.mAtomFile.toString());
        if (!this.mAtomFile.isAvailable()) {
            CacheUtil.deleteSessionId(this, this.mSessionId);
            Const.UploadRetCode uploadRetCode = Const.UploadRetCode.UNMATCH_SIZE_EXCEPTION;
            onError(uploadRetCode.getCode(), uploadRetCode.getDesc());
            return;
        }
        for (IUploadSession iUploadSession : iUploadSessionArr) {
            if (iUploadSession != null) {
                onSessionReport(new UploadQualityReportBuilder().setExt1(iUploadSession.getBaseSessionReportString()).setExt2(UploadQualityReportBuilder.STATE_SEND_FILE_PKG).setAttachInfo(this.mAtomFile.toLogString()));
                UploadWaitExportThread uploadWaitExportThread = new UploadWaitExportThread(this.mAtomFile, iUploadSession, this.mHasFinishExport);
                this.mMultiThreads.add(uploadWaitExportThread);
                uploadWaitExportThread.tFuture = UploadThreadManager.getInstance().getDataThreadPool().submit(uploadWaitExportThread);
            }
        }
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask, com.tencent.upload.task.UploadTask
    protected UploadRequest getControlRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (UploadRequest) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        UploadLog.d(UploadTask.TRANSFER_TAG, "[getControlRequest] mDataLength:" + this.mDataLength);
        AuthToken authToken = TokenProvider.getAuthToken(this.vLoginData, this.vLoginKey);
        buildEnv();
        this.mModel = UploadModel.MODEL_COMPOSITE_UPLOAD;
        FileControlRequest fileControlRequest = new FileControlRequest(String.valueOf(this.iUin), this.mAppid, authToken, this.mChecksum, CheckType.TYPE_MD5, this.mDataLength, this.mStEnv, this.mModel, this.mSessionId, this.mNeedIpRedirect, true, this.iSync, new HashMap(), this.mExtend_info);
        fileControlRequest.setExtraParam(buildExtra());
        HashMap hashMap = new HashMap();
        hashMap.put("1", (FileControlReq) fileControlRequest.createJceRequest());
        BatchControlRequest batchControlRequest = new BatchControlRequest(hashMap);
        batchControlRequest.setTaskId(this.flowId);
        return batchControlRequest;
    }

    public long getDelayWaitExportTimeout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, (Object) this)).longValue();
        }
        return 35000L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.uinterface.AbstractUploadTask, com.tencent.upload.task.UploadTask
    public FileUploadRequest getFileUploadRequest(AtomFile atomFile) {
        FileUploadRequest fileUploadRequestForNoOverwrite;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (FileUploadRequest) iPatchRedirector.redirect((short) 4, (Object) this, (Object) atomFile);
        }
        synchronized (atomFile) {
            if (this.overwriteRangeEnd != 0) {
                fileUploadRequestForNoOverwrite = super.getFileUploadRequest(atomFile);
                fileUploadRequestForNoOverwrite.dataType = 2;
                fileUploadRequestForNoOverwrite.extendInfo = this.extendInfo;
                UploadLog.d(UploadTask.TRANSFER_TAG, "[getFileUploadRequest] id:" + this.flowId + " dataType:" + fileUploadRequestForNoOverwrite.dataType);
            } else {
                fileUploadRequestForNoOverwrite = getFileUploadRequestForNoOverwrite(atomFile, null);
            }
        }
        return fileUploadRequestForNoOverwrite;
    }

    @Override // com.tencent.upload.uinterface.data.VideoUploadTask, com.tencent.upload.task.UploadTask
    /* renamed from: getUploadTaskType */
    public TaskTypeConfig getMTaskTypeConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (TaskTypeConfig) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return TaskTypeConfig.QcircleVideoUploadTaskType;
    }

    @Override // com.tencent.upload.task.UploadTask
    protected boolean isFileUploadFinish(stResult stresult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) stresult)).booleanValue();
        }
        int i3 = stresult.flag;
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.task.UploadTask
    public void onFileControlResponse(JceStruct jceStruct, UploadResponse uploadResponse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jceStruct, (Object) uploadResponse);
            return;
        }
        this.mServiceRecOffset = 0L;
        this.overwriteSize = 0L;
        this.overwriteRangeBegin = 0L;
        this.overwriteRangeEnd = 0L;
        this.mHasSendCommitReq = false;
        this.mFileSendOffset = 0L;
        super.onFileControlResponse(jceStruct, uploadResponse);
    }

    @Override // com.tencent.upload.task.UploadTask
    protected void onFileUploadResponse(FileUploadRsp fileUploadRsp, UploadResponse uploadResponse) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) fileUploadRsp, (Object) uploadResponse);
            return;
        }
        if (fileUploadRsp != null && uploadResponse != null) {
            UploadLog.d(UploadTask.TRANSFER_TAG, "recv FileUploadResponse taskId=" + getTaskId() + " reqId=" + uploadResponse.getRequestSequence() + " mCurrControlReqId=" + this.mCurrControlReqId + " cmd=" + uploadResponse.getCmd() + " ret=" + fileUploadRsp.result.ret + " flag=" + fileUploadRsp.result.flag + " msg=" + fileUploadRsp.result.f25097msg + " sid=" + uploadResponse.getSid() + " retry=" + this.mRetryCount + " offset=" + fileUploadRsp.offset + " totalSize=" + this.mDataLength + " sendOffset=" + this.mFileSendOffset + " session=" + fileUploadRsp.session + " mFlagError=" + this.mFlagError + " data_type=" + fileUploadRsp.data_type + " mServiceRecOffset=" + this.mServiceRecOffset + " confirm_offset=" + fileUploadRsp.confirm_offset + " mHasFinishExport:" + this.mHasFinishExport + " mHasSendCommitReq:" + this.mHasSendCommitReq + " File size:" + this.mAtomFile.getFileSizeNoUpdate());
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
                if (fileUploadRsp.data_type == 1) {
                    long j3 = this.mServiceRecOffset;
                    long j16 = fileUploadRsp.confirm_offset;
                    if (j3 < j16) {
                        this.mServiceRecOffset = j16;
                    }
                    if (this.mHasSendCommitReq) {
                        return;
                    }
                    if (this.mHasFinishExport && this.mServiceRecOffset >= this.mAtomFile.getFileSize()) {
                        this.mHasSendCommitReq = true;
                        releaseSession();
                        postExecute(3, false);
                        return;
                    }
                }
                processFileUploadResponse(fileUploadRsp);
                return;
            }
            return;
        }
        if (("[onFileUploadResponse] " + fileUploadRsp) == null) {
            str = "rsp == null";
        } else {
            str = "response == null";
        }
        UploadLog.e(UploadTask.TRANSFER_TAG, str);
        Const.UploadRetCode uploadRetCode = Const.UploadRetCode.RESPONSE_IS_NULL;
        onError(uploadRetCode.getCode(), uploadRetCode.getDesc());
    }

    protected void processCommitResponse(stResult stresult, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) stresult, (Object) bArr);
            return;
        }
        if (isFileUploadFinish(stresult)) {
            uploadSessionReport(UploadQualityReportBuilder.STATE_UPLOAD_SUCCESS, 0, "");
            this.mFinish = true;
            long currentTimeMillis = System.currentTimeMillis();
            this.mEndTime = currentTimeMillis;
            this.mDataPkgEndTime = currentTimeMillis;
            long j3 = this.mDataLength;
            onUploadProgress(j3, j3);
            releaseSession();
            processFileUploadFinishRsp(bArr);
            printUploadCostLog();
            return;
        }
        startCompleteTimer(1001, UploadSession.getSendTimeout(0));
        UploadLog.w(TAG, "processCommitResponse... startCompleteTimer");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.task.UploadTask
    public void processFileBatchCommitResponse(FileBatchCommitRsp fileBatchCommitRsp, UploadResponse uploadResponse) {
        Map<String, FileCommitRsp> map;
        Object obj;
        String str;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) fileBatchCommitRsp, (Object) uploadResponse);
            return;
        }
        clearCompleteTimer(1003);
        if (fileBatchCommitRsp != null && (map = fileBatchCommitRsp.commit_rsp) != null && map.get(String.valueOf(this.flowId)) != null) {
            FileCommitRsp fileCommitRsp = fileBatchCommitRsp.commit_rsp.get(String.valueOf(this.flowId));
            StringBuilder sb5 = new StringBuilder();
            sb5.append("recv processFileBatchCommitResponse taskId=");
            sb5.append(getTaskId());
            sb5.append(" reqId=");
            sb5.append(uploadResponse.getRequestSequence());
            sb5.append(" cmd=");
            sb5.append(uploadResponse.getCmd());
            sb5.append(" ret=");
            sb5.append(fileCommitRsp.result.ret);
            sb5.append(" flag=");
            sb5.append(fileCommitRsp.result.flag);
            sb5.append(" msg=");
            sb5.append(fileCommitRsp.result.f25097msg);
            sb5.append(" retry=");
            sb5.append(this.mRetryCount);
            sb5.append(" overwrite_range.begin=");
            stOffset stoffset = fileCommitRsp.overwrite_range;
            Object obj2 = "";
            if (stoffset == null) {
                obj = "";
            } else {
                obj = Long.valueOf(stoffset.begin);
            }
            sb5.append(obj);
            sb5.append(" overwrite_range.end=");
            stOffset stoffset2 = fileCommitRsp.overwrite_range;
            if (stoffset2 != null) {
                obj2 = Long.valueOf(stoffset2.end);
            }
            sb5.append(obj2);
            sb5.append(" session=");
            sb5.append(fileCommitRsp.session);
            UploadLog.d(UploadTask.TRANSFER_TAG, sb5.toString());
            UploadQualityReportBuilder uploadQualityReportBuilder = new UploadQualityReportBuilder();
            IUploadSession iUploadSession = this.mSession;
            if (iUploadSession != null) {
                str = iUploadSession.getBaseSessionReportString();
            } else {
                str = null;
            }
            onSessionReport(uploadQualityReportBuilder.setExt1(str).setExt2(UploadQualityReportBuilder.STATE_RESPONSE_COMMIT_FILE_PKG).setAttachInfo(sb5.toString()));
            stResult stresult = fileCommitRsp.result;
            if (stresult.ret != 0) {
                if (this.mRetryCount < getMaxRetryTimes()) {
                    processByRspFlag(fileCommitRsp.result);
                    return;
                } else {
                    stResult stresult2 = fileCommitRsp.result;
                    onError(stresult2.ret, stresult2.f25097msg);
                    return;
                }
            }
            stOffset stoffset3 = fileCommitRsp.overwrite_range;
            if (stoffset3 == null) {
                UploadLog.d(TAG, "processFileBatchCommitResponse fileCommitRsp.overwrite_range == null " + hashCode());
                Const.UploadRetCode uploadRetCode = Const.UploadRetCode.RESPONSE_OVERWRITE_RANGE_IS_NULL;
                onError(uploadRetCode.getCode(), uploadRetCode.getDesc());
                return;
            }
            long j16 = stoffset3.begin;
            if (j16 < 0) {
                j3 = 0;
            } else {
                j3 = j16;
            }
            this.mFileSendOffset = j3;
            this.mFileRecvOffset = j3;
            this.overwriteRangeBegin = j16;
            long j17 = stoffset3.end;
            long j18 = 1 + j17;
            this.overwriteRangeEnd = j18;
            this.overwriteSize = j18 - j16;
            if (j17 == 0) {
                processCommitResponse(stresult, fileCommitRsp.biz_rsp);
                return;
            } else {
                postExecute(4, false);
                return;
            }
        }
        UploadLog.d(TAG, "processFileBatchCommitResponse rsp == null " + hashCode());
        Const.UploadRetCode uploadRetCode2 = Const.UploadRetCode.RESPONSE_IS_NULL;
        onError(uploadRetCode2.getCode(), uploadRetCode2.getDesc());
    }

    @Override // com.tencent.upload.task.UploadTask
    protected void processFileUploadResponse(FileUploadRsp fileUploadRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) fileUploadRsp);
            return;
        }
        if (isFileUploadFinish(fileUploadRsp.result)) {
            uploadSessionReport(UploadQualityReportBuilder.STATE_UPLOAD_SUCCESS, 0, "");
            this.mFinish = true;
            if (fileUploadRsp.data_type == 1) {
                this.mDataPkgEndTime = System.currentTimeMillis();
                long j3 = this.mDataLength;
                onUploadProgress(1048576 + j3, j3);
            } else {
                this.mEndTime = System.currentTimeMillis();
                long j16 = this.overwriteSize;
                onUploadProgress(j16, j16);
            }
            processFileUploadFinishRsp(fileUploadRsp.biz_rsp);
            printUploadCostLog();
            return;
        }
        if (fileUploadRsp.data_type != 1) {
            startCompleteTimer(1001, UploadSession.getSendTimeout(0));
        }
        long j17 = this.mFileRecvOffset;
        long j18 = fileUploadRsp.offset;
        if (j17 < j18) {
            this.mFileRecvOffset = j18;
            if (fileUploadRsp.data_type == 1) {
                onUploadProgress(this.mDataLength + 1048576, j18);
            } else {
                onUploadProgress(this.overwriteSize, j18);
            }
            UploadLog.d(TAG, "taskId:" + getTaskId() + ", UploadProgress: [" + fileUploadRsp.offset + "," + this.mDataLength + "]");
        }
    }

    @Override // com.tencent.upload.task.UploadTask
    protected boolean sendCommitFileReq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (getTaskState() != TaskState.PAUSE && getTaskState() != TaskState.CANCEL && getTaskState() != TaskState.SUCCEED) {
            if (!this.mHasFinishExport) {
                UploadFlowTracker.trackFlow(this, "\u5408\u6210\u672a\u5b8c\u6210");
                Const.UploadRetCode uploadRetCode = Const.UploadRetCode.EXPORTING_COMPLETE;
                onError(uploadRetCode.getCode(), uploadRetCode.getDesc());
                return false;
            }
            if (this.mDataSource.getDataLength() <= 0) {
                UploadFlowTracker.trackFlow(this, "\u4e0a\u4f20\u6587\u4ef6\u957f\u5ea6\u5f02\u5e38");
                Const.UploadRetCode uploadRetCode2 = Const.UploadRetCode.FILE_LENGTH_INVALID;
                onError(uploadRetCode2.getCode(), uploadRetCode2.getDesc());
                return false;
            }
            IUploadSession pollSessionWithRetry = pollSessionWithRetry(2);
            if (this.mFinish) {
                UploadLog.w(TAG, "[sendCommitFileReq] after poll task has been finished !");
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
            BatchCommitRequest fileCommitRequest = getFileCommitRequest();
            this.mCurrControlReqId = fileCommitRequest.getRequestId();
            this.mFlagError = false;
            boolean send = pollSessionWithRetry.send(fileCommitRequest, getMTaskTypeConfig(), this);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[sendCommitFileReq] taskId=");
            sb5.append(getTaskId());
            sb5.append(" reqId=");
            sb5.append(this.mCurrControlReqId);
            sb5.append(" retry=");
            sb5.append(this.mRetryCount);
            sb5.append(" route=");
            sb5.append(pollSessionWithRetry.getUploadRoute());
            sb5.append(" mDataLength=");
            sb5.append(this.mDataLength);
            sb5.append(" getIdleSession=");
            sb5.append(pollSessionWithRetry.hashCode());
            sb5.append(" sessionId=");
            sb5.append(this.mSessionId);
            sb5.append(" result=");
            sb5.append(send);
            UploadLog.d(UploadTask.TRANSFER_TAG, sb5.toString());
            onSessionReport(new UploadQualityReportBuilder().setExt1(pollSessionWithRetry.getBaseSessionReportString()).setExt2(UploadQualityReportBuilder.STATE_SEND_COMMIT_FILE_PKG).setAttachInfo(sb5.toString()));
            startCompleteTimer(1003, 60000L);
            return true;
        }
        UploadLog.w(UploadTask.TRANSFER_TAG, "[sendCommitFileReq] task state error");
        return false;
    }

    public void wakeFinishFile(HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) hashMap);
            return;
        }
        this.mHasFinishExport = true;
        this.extendInfo = hashMap;
        AtomFile atomFile = this.mAtomFile;
        if (atomFile != null) {
            this.mDataLength = atomFile.getFileSize();
            this.mReportObj.leaveSize = this.mAtomFile.getRemainSize();
        }
        UploadLog.w(TAG, "wakeFinishFile... datalength:" + this.mDataLength + " leaveSize:" + this.mReportObj.leaveSize);
        Iterator<UploadTask.UploadThread> it = this.mMultiThreads.iterator();
        while (it.hasNext()) {
            UploadTask.UploadThread next = it.next();
            if (next != null && (next instanceof UploadWaitExportThread)) {
                ((UploadWaitExportThread) next).notifyFinishReadFile();
                clearCompleteTimer(1002);
            }
        }
    }

    public void wakeReadFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        Iterator<UploadTask.UploadThread> it = this.mMultiThreads.iterator();
        while (it.hasNext()) {
            UploadTask.UploadThread next = it.next();
            if (next != null && (next instanceof UploadWaitExportThread)) {
                ((UploadWaitExportThread) next).notifyWakeReadFile();
                startCompleteTimer(1002, getDelayWaitExportTimeout());
            }
        }
    }
}
