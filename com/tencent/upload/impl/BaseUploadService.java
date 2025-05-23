package com.tencent.upload.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.network.route.ServerRouteTable;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.utils.pool.ThreadPool;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class BaseUploadService {
    static IPatchRedirector $redirector_;
    UploadTaskManager mTaskManager;
    ThreadPool mThreadPool;

    public BaseUploadService(ThreadPool threadPool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) threadPool);
        } else {
            this.mThreadPool = threadPool;
        }
    }

    public static int getBatchControlNumber() {
        return UploadGlobalConfig.getUploadEnv().getBatchControlCount();
    }

    public static int getFileSocketNumber() {
        return Math.max(1, UploadGlobalConfig.getUploadEnv().getSocketCount());
    }

    public static int getMaxSessionNum() {
        return getParallelFileNumber() * getFileSocketNumber();
    }

    public static int getParallelFileNumber() {
        return UploadGlobalConfig.getUploadEnv().getFileConcurrentCount();
    }

    abstract boolean cancel(AbstractUploadTask abstractUploadTask);

    abstract void cancelAllTasks();

    abstract void close();

    abstract boolean isUploadIdle();

    /* JADX INFO: Access modifiers changed from: protected */
    public void prepare(ServerRouteTable serverRouteTable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) serverRouteTable);
        } else {
            this.mTaskManager.prepare(serverRouteTable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.mTaskManager.reset();
        }
    }

    abstract boolean upload(AbstractUploadTask abstractUploadTask);
}
