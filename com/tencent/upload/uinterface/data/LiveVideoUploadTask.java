package com.tencent.upload.uinterface.data;

import SLICE_UPLOAD.cnst.appid_c2cvideo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.uinterface.TaskTypeConfig;

/* compiled from: P */
/* loaded from: classes27.dex */
public class LiveVideoUploadTask extends VideoUploadTask {
    static IPatchRedirector $redirector_;

    public LiveVideoUploadTask(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        setIsNew(109);
        this.mAppid = appid_c2cvideo.value;
        this.iSync = 0;
    }

    @Override // com.tencent.upload.uinterface.data.VideoUploadTask, com.tencent.upload.task.UploadTask
    public TaskTypeConfig getUploadTaskType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TaskTypeConfig) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return TaskTypeConfig.LiveVideoUploadTaskType;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public boolean onVerifyUploadFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return super.onVerifyUploadFile();
    }
}
