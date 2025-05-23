package com.tencent.upload.uinterface.data;

import FileUpload.UploadUppInfoReq;
import FileUpload.UploadUppInfoRsp;
import SLICE_UPLOAD.cnst.appid_upp;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.JceEncoder;
import com.tencent.upload.utils.UploadLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UppUploadTask extends AbstractUploadTask {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "UppUploadTask";
    public static final String sfUppAppId = "diy";

    public UppUploadTask(byte[] bArr) {
        super(bArr);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) bArr);
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public byte[] buildExtra() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        UploadUppInfoReq uploadUppInfoReq = new UploadUppInfoReq();
        uploadUppInfoReq.appid = sfUppAppId;
        return JceEncoder.encode(uploadUppInfoReq);
    }

    @Override // com.tencent.upload.task.UploadTask
    public TaskTypeConfig getUploadTaskType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TaskTypeConfig) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return TaskTypeConfig.UppUploadTaskType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (!this.mKeepFileAfterUpload) {
            FileUtils.deleteTempFile(this.uploadFilePath);
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.task.UploadTask
    public void processFileUploadFinishRsp(byte[] bArr) {
        String stackTraceString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bArr);
            return;
        }
        UploadUppInfoRsp uploadUppInfoRsp = null;
        try {
            stackTraceString = null;
            uploadUppInfoRsp = (UploadUppInfoRsp) JceEncoder.decode(UploadUppInfoRsp.class, bArr);
        } catch (Exception e16) {
            stackTraceString = Log.getStackTraceString(e16);
            UploadLog.w(TAG, "get rsp ", e16);
        }
        if (uploadUppInfoRsp == null) {
            if (stackTraceString == null) {
                stackTraceString = "unpack uploadUppInfoRsp=null. " + bArr;
            }
            onError(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode(), stackTraceString);
            return;
        }
        UppUploadResult uppUploadResult = new UppUploadResult();
        uppUploadResult.flowId = this.flowId;
        uppUploadResult.sUrl = uploadUppInfoRsp.sUrl;
        onUploadSucceed(uppUploadResult);
        super.processFileUploadFinishRsp(bArr);
        onDestroy();
    }

    public UppUploadTask(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.mAppid = appid_upp.value;
            this.iSync = 0;
        }
    }
}
