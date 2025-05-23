package com.tencent.upload.uinterface.data;

import FileUpload.HeadDesc;
import FileUpload.UploadPicInfoRsp;
import SLICE_UPLOAD.UploadTouchuanReq;
import SLICE_UPLOAD.cnst.appid_touchuan;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.network.session.SessionPool;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.JceEncoder;
import com.tencent.upload.utils.ProtocolUtil;
import com.tencent.upload.utils.UploadLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class HeadUploadTask extends AbstractUploadTask {
    static IPatchRedirector $redirector_;

    public HeadUploadTask(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.mAppid = appid_touchuan.value;
            this.iSync = 0;
        }
    }

    private byte[] getHeadDesc() {
        HeadDesc headDesc = new HeadDesc();
        headDesc.portrait_type = 0L;
        headDesc.uc_platform_qzone_subid = 0L;
        byte[] bArr = new byte[0];
        try {
            return ProtocolUtil.pack(HeadDesc.class.getSimpleName(), headDesc);
        } catch (Exception e16) {
            e16.printStackTrace();
            return bArr;
        }
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public byte[] buildExtra() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        UploadTouchuanReq uploadTouchuanReq = new UploadTouchuanReq();
        uploadTouchuanReq.iUploadType = getUploadTaskType().uploadType;
        uploadTouchuanReq.vReqData = getHeadDesc();
        return JceEncoder.encode(uploadTouchuanReq);
    }

    @Override // com.tencent.upload.task.UploadTask
    public TaskTypeConfig getUploadTaskType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TaskTypeConfig) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return TaskTypeConfig.HeadUploadTaskType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.task.UploadTask
    public void processFileUploadFinishRsp(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr);
            return;
        }
        UploadLog.d("AbstractUploadTask", "ImageUploadTask put <" + this.mOriginFilePath + "," + this.mSessionId + ">");
        SessionPool.recordSessionId(this.mOriginFilePath, this.mSessionId);
        ImageUploadResult imageUploadResult = new ImageUploadResult(this.iUin, this.flowId, (long) getBatchId(), new UploadPicInfoRsp());
        imageUploadResult.sessionId = this.mSessionId;
        UploadLog.d("AbstractUploadTask", "onUploadSucceed flowid = " + this.flowId + " filepath = " + this.mFilePath);
        onUploadSucceed(imageUploadResult);
        super.processFileUploadFinishRsp(bArr);
        onDestroy();
    }
}
