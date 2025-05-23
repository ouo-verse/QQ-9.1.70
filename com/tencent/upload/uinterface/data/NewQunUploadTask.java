package com.tencent.upload.uinterface.data;

import FileUpload.UploadPicInfoReq;
import SLICE_UPLOAD.cnst.appid_qun;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.uinterface.TaskTypeConfig;

/* compiled from: P */
/* loaded from: classes27.dex */
public class NewQunUploadTask extends ImageUploadTask {
    static IPatchRedirector $redirector_;
    public byte[] a2_key;
    public String appid;
    public String userid;

    public NewQunUploadTask(String str) {
        super(false, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.appid = "";
        this.userid = "";
        this.a2_key = null;
        this.mAppid = appid_qun.value;
    }

    @Override // com.tencent.upload.uinterface.data.ImageUploadTask
    public UploadPicInfoReq createUploadPicInfoReq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (UploadPicInfoReq) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        UploadPicInfoReq createUploadPicInfoReq = super.createUploadPicInfoReq();
        createUploadPicInfoReq.mapExt.put("userid", this.userid);
        createUploadPicInfoReq.mapExt.put("a2_key", new String(this.a2_key));
        return createUploadPicInfoReq;
    }

    @Override // com.tencent.upload.uinterface.data.ImageUploadTask, com.tencent.upload.task.UploadTask
    public TaskTypeConfig getUploadTaskType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TaskTypeConfig) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return TaskTypeConfig.NewQunUploadTaskType;
    }
}
