package com.tencent.upload.uinterface.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.uinterface.TaskTypeConfig;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AirVideoUploadTask extends VideoUploadTask {
    static IPatchRedirector $redirector_;

    public AirVideoUploadTask(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.iIsNew = 109;
        }
    }

    @Override // com.tencent.upload.uinterface.data.VideoUploadTask, com.tencent.upload.task.UploadTask
    public TaskTypeConfig getUploadTaskType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TaskTypeConfig) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return TaskTypeConfig.AirVideoUploadTaskType;
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
