package com.tencent.upload.uinterface.data;

import SLICE_UPLOAD.AuthToken;
import SLICE_UPLOAD.CheckType;
import SLICE_UPLOAD.FileControlRsp;
import SLICE_UPLOAD.UploadModel;
import SLICE_UPLOAD.cnst.appid_mobilelog;
import SLICE_UPLOAD.stResult;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.request.UploadRequest;
import com.tencent.upload.request.UploadResponse;
import com.tencent.upload.request.impl.FileControlRequest;
import com.tencent.upload.task.TaskState;
import com.tencent.upload.task.UploadTask;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.uinterface.token.TokenProvider;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.UploadLog;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public class MobileLogUploadTask extends AbstractUploadTask {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MobileLogUploadTask";

    public MobileLogUploadTask(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.mAppid = appid_mobilelog.value;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] buildExtra() {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        try {
            bArr = FileUtils.toByteArray(getFilePath());
        } catch (FileNotFoundException e16) {
            UploadLog.e(TAG, e16.toString() + "path:" + getFilePath());
            bArr = null;
            if (bArr == null) {
            }
        } catch (IOException e17) {
            UploadLog.e(TAG, e17.toString() + "path:" + getFilePath());
            bArr = null;
            if (bArr == null) {
            }
        }
        if (bArr == null) {
            return new byte[0];
        }
        return bArr;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask, com.tencent.upload.task.UploadTask
    protected UploadRequest getControlRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (UploadRequest) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        AuthToken authToken = TokenProvider.getAuthToken(this.vLoginData, this.vLoginKey);
        this.mCheckType = CheckType.TYPE_SHA1;
        this.mChecksum = "";
        buildEnv();
        this.mModel = UploadModel.MODEL_NORMAL;
        this.mStEnv = UploadGlobalConfig.getEnv();
        FileControlRequest fileControlRequest = new FileControlRequest(this.iUin + "", this.mAppid, authToken, this.mChecksum, this.mCheckType, this.mDataLength, this.mStEnv, this.mModel, this.mSessionId, this.mNeedIpRedirect, true, this.iSync, null, this.mExtend_info);
        fileControlRequest.setExtraParam(buildExtra());
        return fileControlRequest;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask, com.tencent.upload.task.BaseTask
    public Const.FileType getFileType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Const.FileType) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return Const.FileType.Log;
    }

    @Override // com.tencent.upload.task.UploadTask
    /* renamed from: getUploadTaskType */
    public TaskTypeConfig getMTaskTypeConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TaskTypeConfig) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return TaskTypeConfig.MobileLogUploadTaskType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else if (!this.mKeepFileAfterUpload) {
            FileUtils.deleteTempFile(this.mFilePath);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.task.UploadTask
    public void onFileControlResponse(JceStruct jceStruct, UploadResponse uploadResponse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) jceStruct, (Object) uploadResponse);
            return;
        }
        if (jceStruct == null) {
            UploadLog.d(TAG, "onFileControlResponse rsp == null " + hashCode());
            Const.UploadRetCode uploadRetCode = Const.UploadRetCode.RESPONSE_IS_NULL;
            onError(uploadRetCode.getCode(), uploadRetCode.getDesc());
            return;
        }
        FileControlRsp fileControlRsp = (FileControlRsp) jceStruct;
        UploadLog.d(UploadTask.TRANSFER_TAG, "recv Response taskId=" + getTaskId() + " reqId=" + uploadResponse.getRequestSequence() + " cmd=" + uploadResponse.getCmd() + " ret=" + fileControlRsp.result.ret + " flag=" + fileControlRsp.result.flag + " msg=" + fileControlRsp.result.f25097msg + " retry=" + this.mRetryCount + " offset=" + fileControlRsp.offset + " slice_size=" + fileControlRsp.slice_size + " session=" + fileControlRsp.session);
        stResult stresult = fileControlRsp.result;
        int i3 = stresult.ret;
        if (i3 == 0) {
            MobileLogUploadResult mobileLogUploadResult = new MobileLogUploadResult(this.iUin, this.flowId);
            if (this.uploadTaskCallback != null) {
                UploadLog.d(TAG, "onUploadSucceed flowid = " + this.flowId + " filepath = " + getFilePath());
                this.uploadTaskCallback.onUploadSucceed(this, mobileLogUploadResult);
            }
        } else {
            IUploadTaskCallback iUploadTaskCallback = this.uploadTaskCallback;
            if (iUploadTaskCallback != null) {
                iUploadTaskCallback.onUploadError(this, i3, stresult.f25097msg);
            }
        }
        processUploadLogRsp();
    }

    protected void processUploadLogRsp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        setTaskStatus(TaskState.SUCCEED);
        Const.UploadRetCode uploadRetCode = Const.UploadRetCode.SUCCEED;
        onTaskFinished(uploadRetCode.getCode(), uploadRetCode.getDesc());
    }
}
