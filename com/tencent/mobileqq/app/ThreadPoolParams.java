package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes11.dex */
public class ThreadPoolParams {
    static IPatchRedirector $redirector_ = null;
    public static final String DEFAULT_THREAD_NAME = "default_name";
    public int corePoolsize;
    public int keepAliveTime;
    public int maxPooolSize;
    public String poolThreadName;
    public int priority;
    public BlockingQueue queue;
    public ThreadFactory threadFactory;

    public ThreadPoolParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.poolThreadName = DEFAULT_THREAD_NAME;
        this.priority = 5;
        this.corePoolsize = 3;
        this.maxPooolSize = 5;
        this.keepAliveTime = 1;
        this.queue = new LinkedBlockingQueue(128);
        this.threadFactory = null;
    }
}
