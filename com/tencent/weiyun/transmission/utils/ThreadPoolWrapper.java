package com.tencent.weiyun.transmission.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes27.dex */
public class ThreadPoolWrapper {
    static IPatchRedirector $redirector_ = null;
    private static final int DEFAULT_SIZE = 6;
    private final String mName;
    private ThreadPool mThreadPool;

    public ThreadPoolWrapper(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.mName = str;
            this.mThreadPool = new ThreadPool(str, 6);
        }
    }

    public synchronized void submit(ThreadPool.Job<Void> job) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) job);
        } else {
            try {
                this.mThreadPool.submit(job);
            } catch (RejectedExecutionException unused) {
            }
        }
    }
}
