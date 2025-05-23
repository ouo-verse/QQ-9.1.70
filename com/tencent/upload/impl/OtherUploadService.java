package com.tencent.upload.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.utils.UploadLog;
import com.tencent.upload.utils.pool.ThreadPool;

/* compiled from: P */
/* loaded from: classes27.dex */
public class OtherUploadService extends BaseUploadService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "OtherUploadService";

    public OtherUploadService(ThreadPool threadPool) {
        super(threadPool);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) threadPool);
        } else {
            this.mTaskManager = new UploadTaskManager(threadPool, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.impl.BaseUploadService
    public boolean cancel(AbstractUploadTask abstractUploadTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) abstractUploadTask)).booleanValue();
        }
        if (abstractUploadTask == null) {
            return false;
        }
        UploadLog.w(TAG, "cancel AbstractUploadTask flowId: " + abstractUploadTask.flowId);
        this.mTaskManager.cancelTask(abstractUploadTask);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.impl.BaseUploadService
    public void cancelAllTasks() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mTaskManager.cancelAllTasks();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.impl.BaseUploadService
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.mTaskManager.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.impl.BaseUploadService
    public boolean isUploadIdle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.mTaskManager.getRemainTaskSize() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.impl.BaseUploadService
    public boolean upload(AbstractUploadTask abstractUploadTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) abstractUploadTask)).booleanValue();
        }
        UploadLog.w(TAG, "upload task flowId: " + abstractUploadTask.flowId + " type:" + abstractUploadTask.getClass().getSimpleName());
        this.mTaskManager.sendAsync(abstractUploadTask);
        return true;
    }
}
