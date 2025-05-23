package com.tencent.upload.uinterface.data;

import ClientRecordUpload.ClientRecordUploadReq;
import SLICE_UPLOAD.UploadTouchuanReq;
import SLICE_UPLOAD.cnst.appid_touchuan_outer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.JceEncoder;
import com.tencent.upload.utils.UploadLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ZipUploadTask extends AbstractUploadTask {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ZipUploadTask";
    public int appid;
    public int format;
    private ClientRecordUploadReq req;
    public int zip_length;

    public ZipUploadTask(String str, ClientRecordUploadReq clientRecordUploadReq) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) clientRecordUploadReq);
            return;
        }
        this.format = 0;
        this.appid = 0;
        this.zip_length = 0;
        this.mAppid = appid_touchuan_outer.value;
        this.iSync = 0;
        this.req = clientRecordUploadReq;
    }

    private byte[] getZipReq() {
        byte[] bArr = new byte[0];
        try {
            return JceEncoder.encode(this.req);
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
        uploadTouchuanReq.vReqData = getZipReq();
        try {
            return JceEncoder.encode(uploadTouchuanReq);
        } catch (Exception e16) {
            UploadLog.e(TAG, e16.toString());
            return null;
        }
    }

    @Override // com.tencent.upload.task.UploadTask
    public TaskTypeConfig getUploadTaskType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TaskTypeConfig) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return TaskTypeConfig.ZipUploadTaskType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.task.UploadTask
    public void processFileUploadFinishRsp(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr);
            return;
        }
        onUploadSucceed(new ZipUploadResult());
        super.processFileUploadFinishRsp(bArr);
        onDestroy();
    }
}
