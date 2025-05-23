package com.tencent.upload.utils.pool;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UploadThreadManager {
    static IPatchRedirector $redirector_;
    private static volatile UploadThreadManager sInstance;
    private ThreadPool mDataThreadPool;
    private ThreadPool mWorkThreadPool;

    UploadThreadManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mWorkThreadPool = new ThreadPool(4, 8, "UploadThread");
            this.mDataThreadPool = new ThreadPool(10, 64, "DataThread");
        }
    }

    private String getExecutorMessage(ThreadPoolExecutor threadPoolExecutor, String str) {
        int activeCount = threadPoolExecutor.getActiveCount();
        int maximumPoolSize = threadPoolExecutor.getMaximumPoolSize();
        int poolSize = threadPoolExecutor.getPoolSize();
        StringBuilder sb5 = new StringBuilder(" Thread pool " + str);
        sb5.append(" activeNum: " + activeCount);
        sb5.append(" maxNum: " + maximumPoolSize);
        sb5.append(" curNum: " + poolSize);
        return sb5.toString();
    }

    public static UploadThreadManager getInstance() {
        if (sInstance == null) {
            synchronized (UploadThreadManager.class) {
                if (sInstance == null) {
                    sInstance = new UploadThreadManager();
                }
            }
        }
        return sInstance;
    }

    public ThreadPool getDataThreadPool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ThreadPool) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mDataThreadPool;
    }

    public ThreadPool getWorkThreadPool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ThreadPool) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mWorkThreadPool;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return getExecutorMessage(this.mWorkThreadPool.getExecutor(), "UploadThread") + getExecutorMessage(this.mDataThreadPool.getExecutor(), "DataThread");
    }
}
