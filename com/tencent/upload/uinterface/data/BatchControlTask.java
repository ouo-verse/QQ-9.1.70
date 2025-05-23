package com.tencent.upload.uinterface.data;

import SLICE_UPLOAD.AuthToken;
import SLICE_UPLOAD.CheckType;
import SLICE_UPLOAD.DumpBussinessReq;
import SLICE_UPLOAD.FileBatchControlRsp;
import SLICE_UPLOAD.FileControlReq;
import SLICE_UPLOAD.FileControlRsp;
import SLICE_UPLOAD.UploadModel;
import SLICE_UPLOAD.cnst.appid_video;
import SLICE_UPLOAD.stResult;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.impl.UploadTaskManager;
import com.tencent.upload.network.session.IUploadSession;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.upload.request.UploadRequest;
import com.tencent.upload.request.UploadResponse;
import com.tencent.upload.request.impl.BatchControlRequest;
import com.tencent.upload.request.impl.FileControlRequest;
import com.tencent.upload.task.TaskState;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.uinterface.token.TokenProvider;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.UploadLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class BatchControlTask extends AbstractUploadTask {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "BatchControlTask";
    long mEndTime;
    private List<String> mFilePaths;
    private BatchControlResult mResult;
    long mStartTime;
    UploadTaskManager mTaskManager;
    List<AbstractUploadTask> mTasks;

    public BatchControlTask(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mFilePaths = new ArrayList();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    public void addBatchFile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.mFilePaths.add(str);
        }
    }

    protected UploadRequest getBatchControlRequest() {
        HashMap hashMap;
        String str;
        AuthToken authToken;
        int i3;
        int i16;
        HashMap hashMap2;
        BatchControlTask batchControlTask = this;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (UploadRequest) iPatchRedirector.redirect((short) 7, (Object) batchControlTask);
        }
        String str2 = "taskId:" + getTaskId() + " ! ---------------getBatchControlRequest-------------- !";
        String str3 = TAG;
        UploadLog.i(TAG, str2);
        AuthToken authToken2 = TokenProvider.getAuthToken(batchControlTask.vLoginData, batchControlTask.vLoginKey);
        buildEnv();
        batchControlTask.mModel = UploadModel.MODEL_NORMAL;
        int i17 = 1;
        if (batchControlTask.preupload == 1) {
            batchControlTask.mModel = UploadModel.MODEL_PRE_UPLOAD;
        }
        HashMap hashMap3 = new HashMap();
        int i18 = 0;
        while (i18 < batchControlTask.mTasks.size()) {
            AbstractUploadTask abstractUploadTask = batchControlTask.mTasks.get(i18);
            String filePath = abstractUploadTask.getFilePath();
            if (!TextUtils.isEmpty(filePath)) {
                if (batchControlTask.mAppid.equalsIgnoreCase(appid_video.value)) {
                    batchControlTask.mCheckType = CheckType.TYPE_SHA1;
                    String fileSha1 = FileUtils.getFileSha1(new File(filePath));
                    batchControlTask.sha1 = fileSha1;
                    batchControlTask.mChecksum = fileSha1;
                } else {
                    batchControlTask.mCheckType = CheckType.TYPE_MD5;
                    String md5ByFile_REAL = FileUtils.getMd5ByFile_REAL(new File(filePath));
                    batchControlTask.md5 = md5ByFile_REAL;
                    batchControlTask.mChecksum = md5ByFile_REAL;
                }
            }
            if (TextUtils.isEmpty(batchControlTask.mChecksum)) {
                Const.UploadRetCode uploadRetCode = Const.UploadRetCode.FILE_NOT_EXIST;
                abstractUploadTask.onError(uploadRetCode.getCode(), uploadRetCode.getDesc());
                authToken = authToken2;
                str = str3;
                hashMap2 = hashMap3;
                i3 = i18;
                i16 = i17;
            } else {
                UploadLog.d(str3, "batchControlId:" + getTaskId() + ", index: " + i18 + ", taskId:" + abstractUploadTask.getTaskId() + ", path:" + filePath + ", mCheckType:" + batchControlTask.mCheckType + ", mChecksum:" + batchControlTask.mChecksum);
                long fileLength = FileUtils.getFileLength(filePath);
                if (abstractUploadTask.isSyncWeishi) {
                    HashMap hashMap4 = new HashMap();
                    DumpBussinessReq dumpBussinessReq = new DumpBussinessReq();
                    dumpBussinessReq.IMEI = abstractUploadTask.sDevIMEI;
                    hashMap4.put(Integer.valueOf(i17), dumpBussinessReq);
                    hashMap = hashMap4;
                } else {
                    hashMap = null;
                }
                str = str3;
                HashMap hashMap5 = hashMap3;
                authToken = authToken2;
                i3 = i18;
                i16 = 1;
                FileControlRequest fileControlRequest = new FileControlRequest(batchControlTask.iUin + "", batchControlTask.mAppid, authToken2, batchControlTask.mChecksum, batchControlTask.mCheckType, fileLength, batchControlTask.mStEnv, batchControlTask.mModel, "", batchControlTask.mNeedIpRedirect, true, abstractUploadTask.iSync, hashMap, abstractUploadTask.mExtend_info);
                byte[] buildExtra = abstractUploadTask.buildExtra();
                if (buildExtra == null) {
                    Const.UploadRetCode uploadRetCode2 = Const.UploadRetCode.DATA_ENCODE_EXCEPTION;
                    abstractUploadTask.onError(uploadRetCode2.getCode(), uploadRetCode2.getDesc());
                    hashMap2 = hashMap5;
                } else {
                    fileControlRequest.setExtraParam(buildExtra);
                    FileControlReq fileControlReq = (FileControlReq) fileControlRequest.createJceRequest();
                    StringBuilder sb5 = new StringBuilder();
                    int i19 = i3 + 1;
                    sb5.append(i19);
                    sb5.append("");
                    hashMap2 = hashMap5;
                    hashMap2.put(sb5.toString(), fileControlReq);
                    abstractUploadTask.uploadIndex = i19;
                }
            }
            i18 = i3 + 1;
            batchControlTask = this;
            hashMap3 = hashMap2;
            str3 = str;
            authToken2 = authToken;
            i17 = i16;
        }
        String str4 = str3;
        HashMap hashMap6 = hashMap3;
        if (hashMap6.size() == 0) {
            setTaskStatus(TaskState.CANCEL);
            onTaskFinished(0, "Damn shit, no file need to upload !");
            UploadLog.d(str4, "Damn shit, no file need to upload !");
            return null;
        }
        return new BatchControlRequest(hashMap6);
    }

    public int getBatchCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.mTasks.size();
    }

    public long getCostTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        return this.mEndTime - this.mStartTime;
    }

    public BatchControlResult getResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (BatchControlResult) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mResult;
    }

    @Override // com.tencent.upload.task.UploadTask
    /* renamed from: getUploadTaskType */
    public TaskTypeConfig getMTaskTypeConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TaskTypeConfig) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        List<AbstractUploadTask> list = this.mTasks;
        if (list != null && list.get(0) != null) {
            return this.mTasks.get(0).getMTaskTypeConfig();
        }
        return TaskTypeConfig.ImageUploadTaskType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.task.UploadTask
    public void onFileControlResponse(JceStruct jceStruct, UploadResponse uploadResponse) {
        Map<String, FileControlRsp> map;
        FileControlRsp fileControlRsp;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) jceStruct, (Object) uploadResponse);
            return;
        }
        FileBatchControlRsp fileBatchControlRsp = (FileBatchControlRsp) jceStruct;
        this.mEndTime = System.currentTimeMillis();
        UploadLog.d(TAG, "[speed] batch control pkg cost: " + getCostTime());
        if (fileBatchControlRsp != null && (map = fileBatchControlRsp.control_rsp) != null && map.size() > 0) {
            BatchControlResult batchControlResult = new BatchControlResult();
            for (int i3 = 1; i3 <= fileBatchControlRsp.control_rsp.size(); i3++) {
                batchControlResult.mMap.put(this.mFilePaths.get(i3 - 1), fileBatchControlRsp.control_rsp.get(i3 + ""));
            }
            this.mResult = batchControlResult;
            UploadLog.d(TAG, "Num:" + batchControlResult.mMap.size());
            long costTime = getCostTime();
            if (!this.mTasks.isEmpty()) {
                costTime /= this.mTasks.size();
            }
            for (AbstractUploadTask abstractUploadTask : this.mTasks) {
                if ("qevent_photo".equals(abstractUploadTask.getStringAppId())) {
                    fileControlRsp = fileBatchControlRsp.control_rsp.get(abstractUploadTask.uploadIndex + "");
                } else {
                    fileControlRsp = batchControlResult.mMap.get(abstractUploadTask.getFilePath());
                }
                if (fileControlRsp != null && fileControlRsp.result != null) {
                    UploadLog.d(TAG, "flowid:" + abstractUploadTask.flowId + " FileControlRsp rsp ret:" + fileControlRsp.result.ret + " flag:" + fileControlRsp.result.flag + " rsp.session:" + fileControlRsp.session + " path:" + abstractUploadTask.getFilePath());
                    stResult stresult = fileControlRsp.result;
                    if (stresult.ret == 0) {
                        int i16 = stresult.flag;
                        if (i16 == 1) {
                            abstractUploadTask.setSecondUpload(fileControlRsp);
                        } else if (i16 == 2) {
                        }
                        abstractUploadTask.setSessionId(fileControlRsp.session);
                        abstractUploadTask.setSliceSize((int) fileControlRsp.slice_size);
                    }
                    if (abstractUploadTask.getTaskState() != TaskState.CANCEL) {
                        this.mTaskManager.sendAsync(abstractUploadTask);
                    }
                }
                abstractUploadTask.getReportObj().batchCtrlCostAvg = costTime;
            }
            setTaskStatus(TaskState.SUCCEED);
            Const.UploadRetCode uploadRetCode = Const.UploadRetCode.SUCCEED;
            onTaskFinished(uploadRetCode.getCode(), uploadRetCode.getDesc());
        }
    }

    @Override // com.tencent.upload.task.UploadTask, com.tencent.upload.task.BaseTask
    public boolean onRun() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        UploadLog.d(TAG, "BatchControlTask onRun() is start !! taskId:" + getTaskId());
        this.mFinish = false;
        UploadRequest batchControlRequest = getBatchControlRequest();
        if (batchControlRequest == null) {
            UploadLog.e(TAG, " onRun(), req == null !! taskId:" + getTaskId());
            return false;
        }
        if (this.mFinish) {
            UploadLog.e(TAG, "BatchControlTask onRun(), task is finished already ! taskId:" + getTaskId());
            return false;
        }
        IUploadSession poll = this.mSessionPool.poll();
        if (poll == null) {
            UploadLog.e(TAG, "BatchControlTask onRun(), get session return null ! taskId:" + getTaskId());
            retryPollSession();
            return false;
        }
        UploadLog.d(TAG, "BatchControlTask onRun() session is not null. ready to send taskId:" + getTaskId() + " sessionId:" + poll.getSessionId());
        onSessionReport(new UploadQualityReportBuilder().setExt1(poll.getBaseSessionReportString()).setExt2(UploadQualityReportBuilder.STATE_SEND_BATCH_CONTROL_PKG));
        setState(TaskState.CONNECTING);
        this.mSavedSession = poll;
        this.mSession = poll;
        this.mStartTime = System.currentTimeMillis();
        this.mFlagError = false;
        return this.mSession.send(batchControlRequest, getMTaskTypeConfig(), this);
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask, com.tencent.upload.task.UploadTask
    protected void onUploadError(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) str);
            return;
        }
        List<AbstractUploadTask> list = this.mTasks;
        if (list != null && list.size() > 0) {
            Iterator<AbstractUploadTask> it = this.mTasks.iterator();
            while (it.hasNext()) {
                it.next().onError(i3, str);
            }
        }
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public boolean onVerifyUploadFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }

    public String printAllTaskInBatchControl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        List<AbstractUploadTask> list = this.mTasks;
        if (list != null && list.size() != 0) {
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < this.mTasks.size(); i3++) {
                AbstractUploadTask abstractUploadTask = this.mTasks.get(i3);
                sb5.append("index:");
                sb5.append(i3);
                sb5.append(" taskId:");
                sb5.append(abstractUploadTask.getTaskId());
                sb5.append("\n");
            }
            return sb5.toString();
        }
        return "no task in batchControlTask";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.uinterface.AbstractUploadTask, com.tencent.upload.task.UploadTask, com.tencent.upload.task.BaseTask
    public void report(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3, (Object) str);
        }
    }

    public BatchControlTask(List<AbstractUploadTask> list, UploadTaskManager uploadTaskManager) {
        super(new byte[0]);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list, (Object) uploadTaskManager);
            return;
        }
        this.flowId = this.mTaskId;
        this.mTaskManager = uploadTaskManager;
        this.mFilePaths = new ArrayList();
        ArrayList arrayList = new ArrayList(list);
        this.mTasks = arrayList;
        AbstractUploadTask abstractUploadTask = (AbstractUploadTask) arrayList.get(0);
        this.uploadEntrance = abstractUploadTask.uploadEntrance;
        this.sRefer = abstractUploadTask.sRefer;
        this.iUin = abstractUploadTask.iUin;
        this.mAppid = abstractUploadTask.getProtocolAppid();
        this.vLoginData = abstractUploadTask.vLoginData;
        this.vLoginKey = abstractUploadTask.vLoginKey;
        this.preupload = abstractUploadTask.preupload;
        Iterator<AbstractUploadTask> it = this.mTasks.iterator();
        while (it.hasNext()) {
            addBatchFile(it.next().getFilePath());
        }
    }
}
