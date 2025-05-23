package com.tencent.upload.uinterface.data;

import FileUpload.UploadPicInfoRsp;
import SLICE_UPLOAD.FileBatchCommitReq;
import SLICE_UPLOAD.FileBatchCommitRsp;
import SLICE_UPLOAD.FileCommitReq;
import SLICE_UPLOAD.FileCommitRsp;
import SLICE_UPLOAD.cnst.appid_photo;
import SLICE_UPLOAD.stResult;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.network.session.IUploadSession;
import com.tencent.upload.network.session.SessionPool;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.upload.request.UploadResponse;
import com.tencent.upload.request.impl.BatchCommitRequest;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.JceEncoder;
import com.tencent.upload.utils.UploadLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class BatchCommitUploadTask extends AbstractUploadTask {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "BatchCommitUploadTask";
    public List<ImageUploadTask> commitImageTasks;

    public BatchCommitUploadTask(byte[] bArr) {
        super(bArr);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bArr);
        } else {
            this.commitImageTasks = null;
            this.mAppid = appid_photo.value;
        }
    }

    private FileBatchCommitReq buildReq() {
        FileBatchCommitReq fileBatchCommitReq = new FileBatchCommitReq();
        fileBatchCommitReq.commit_req = new HashMap();
        if (this.commitImageTasks == null) {
            return fileBatchCommitReq;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("preupload{");
        for (ImageUploadTask imageUploadTask : this.commitImageTasks) {
            byte[] encode = JceEncoder.encode(imageUploadTask.createUploadPicInfoReq());
            String sessionIdByPath = SessionPool.getSessionIdByPath(imageUploadTask.getFilePath());
            if (!TextUtils.isEmpty(sessionIdByPath)) {
                FileCommitReq fileCommitReq = new FileCommitReq(this.iUin + "", sessionIdByPath, encode, this.mAppid, null, null, 0, 0L, null);
                fileBatchCommitReq.commit_req.put(imageUploadTask.flowId + "", fileCommitReq);
                sb5.append("[path:");
                sb5.append(imageUploadTask.getFilePath());
                sb5.append(", flowId:" + imageUploadTask.flowId);
                sb5.append(", sessionId:" + sessionIdByPath);
                sb5.append("]");
            }
        }
        sb5.append("}");
        UploadLog.d(TAG, "buildReq preupload.size: " + this.commitImageTasks.size() + " " + sb5.toString());
        return fileBatchCommitReq;
    }

    @Override // com.tencent.upload.task.UploadTask
    /* renamed from: getUploadTaskType */
    public TaskTypeConfig getMTaskTypeConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TaskTypeConfig) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return TaskTypeConfig.BatchCommitUploadType;
    }

    @Override // com.tencent.upload.task.UploadTask, com.tencent.upload.task.BaseTask
    public boolean onRun() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        BatchCommitRequest batchCommitRequest = new BatchCommitRequest(buildReq(), this.flowId);
        IUploadSession poll = this.mSessionPool.poll();
        if (poll == null) {
            UploadLog.e(TAG, "BatchCommitUploadTask onRun(), get session return null !");
            retryPollSession();
            return false;
        }
        onSessionReport(new UploadQualityReportBuilder().setExt1(poll.getBaseSessionReportString()).setExt2(UploadQualityReportBuilder.STATE_SEND_COMMIT_UPLOAD_PKG));
        this.mSavedSession = poll;
        this.mSession = poll;
        return poll.send(batchCommitRequest, getMTaskTypeConfig(), this);
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public boolean onVerifyUploadFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.task.UploadTask
    public void processFileBatchCommitResponse(FileBatchCommitRsp fileBatchCommitRsp, UploadResponse uploadResponse) {
        int size;
        String str;
        byte[] bArr;
        FileBatchCommitRsp fileBatchCommitRsp2 = fileBatchCommitRsp;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) fileBatchCommitRsp2, (Object) uploadResponse);
            return;
        }
        if (fileBatchCommitRsp2 != null && fileBatchCommitRsp2.commit_rsp != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("processBatchCommitRsp commit size:");
            Map<String, FileCommitRsp> map = fileBatchCommitRsp2.commit_rsp;
            if (map == null) {
                size = 0;
            } else {
                size = map.size();
            }
            sb5.append(size);
            String str2 = " flowId:";
            sb5.append(" flowId:");
            sb5.append(this.flowId);
            UploadLog.d(TAG, sb5.toString());
            HashMap hashMap = new HashMap();
            for (ImageUploadTask imageUploadTask : this.commitImageTasks) {
                String num = Integer.toString(imageUploadTask.flowId);
                FileCommitRsp fileCommitRsp = fileBatchCommitRsp2.commit_rsp.get(num);
                if (fileCommitRsp != null && (bArr = fileCommitRsp.biz_rsp) != null) {
                    stResult stresult = fileCommitRsp.result;
                    if (stresult == null) {
                        UploadLog.e(TAG, "fcp.result == null flowId:" + num);
                    } else if (stresult.ret < 0) {
                        UploadLog.e(TAG, "fcp.result.ret:" + fileCommitRsp.result.ret + " flag:" + fileCommitRsp.result.flag + str2 + num);
                    } else {
                        UploadPicInfoRsp uploadPicInfoRsp = (UploadPicInfoRsp) JceEncoder.decode(UploadPicInfoRsp.class, bArr);
                        if (uploadPicInfoRsp == null) {
                            UploadLog.e(TAG, "uploadPicInfoRsp == null");
                        } else {
                            IUploadTaskCallback iUploadTaskCallback = this.uploadTaskCallback;
                            if (iUploadTaskCallback != null) {
                                str = str2;
                                iUploadTaskCallback.onUploadSucceed(imageUploadTask, new ImageUploadResult(imageUploadTask.iUin, imageUploadTask.flowId, imageUploadTask.iBatchID, uploadPicInfoRsp));
                            } else {
                                str = str2;
                            }
                            hashMap.put(imageUploadTask.flowId + "", uploadPicInfoRsp);
                            UploadLog.d(TAG, "processBatchCommitRsp commit flow:" + imageUploadTask.flowId);
                            report(Const.UploadRetCode.ERROR_PRE_UPLOAD_HIT.getCode(), null);
                        }
                    }
                } else {
                    str = str2;
                    UploadLog.e(TAG, "fcp == null flowId:" + num);
                }
                fileBatchCommitRsp2 = fileBatchCommitRsp;
                str2 = str;
            }
            if (this.uploadTaskCallback != null) {
                BatchCommitUploadResult batchCommitUploadResult = new BatchCommitUploadResult();
                batchCommitUploadResult.flowId = this.flowId;
                batchCommitUploadResult.mapPicInfoRsp = hashMap;
                this.uploadTaskCallback.onUploadSucceed(this, batchCommitUploadResult);
            }
            UploadLog.d(TAG, "processBatchCommitRsp cancel self");
            super.processFileBatchCommitResponse(fileBatchCommitRsp, uploadResponse);
            return;
        }
        onError(Const.UploadRetCode.ERROR_BATCH_COMMIT.getCode(), "rsp invalid");
        UploadLog.w(TAG, "rsp == null");
    }

    public void processUploadTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        for (ImageUploadTask imageUploadTask : this.commitImageTasks) {
            Context context = UploadGlobalConfig.getContext();
            String filePathByPrefix = FileUtils.getFilePathByPrefix(context, imageUploadTask.uploadFilePath, imageUploadTask.md5);
            if (!TextUtils.isEmpty(filePathByPrefix)) {
                String tempFilePath = FileUtils.getTempFilePath(context, imageUploadTask.uploadFilePath, imageUploadTask.md5, imageUploadTask.flowId);
                if (FileUtils.copyFile(filePathByPrefix, tempFilePath)) {
                    imageUploadTask.uploadFilePath = tempFilePath;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.uinterface.AbstractUploadTask, com.tencent.upload.task.UploadTask, com.tencent.upload.task.BaseTask
    public void report(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) str);
        }
    }

    public BatchCommitUploadTask() {
        super(new byte[0]);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.commitImageTasks = null;
            this.mAppid = appid_photo.value;
        }
    }
}
