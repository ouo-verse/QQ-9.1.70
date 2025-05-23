package com.tencent.intervideo.nowproxy.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes7.dex */
public class NowThreadPool {
    static IPatchRedirector $redirector_;
    public static ThreadPoolProvider sThreadPoolProvider;

    /* loaded from: classes7.dex */
    public interface ThreadPoolProvider {
        ExecutorService getFixedThreadPool(int i3);

        ScheduledExecutorService getScheduledThreadPool(int i3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10735);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sThreadPoolProvider = new ThreadPoolProvider() { // from class: com.tencent.intervideo.nowproxy.common.NowThreadPool.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // com.tencent.intervideo.nowproxy.common.NowThreadPool.ThreadPoolProvider
                public ExecutorService getFixedThreadPool(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        return (ExecutorService) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                    }
                    return null;
                }

                @Override // com.tencent.intervideo.nowproxy.common.NowThreadPool.ThreadPoolProvider
                public ScheduledExecutorService getScheduledThreadPool(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (ScheduledExecutorService) iPatchRedirector.redirect((short) 2, (Object) this, i3);
                    }
                    return null;
                }
            };
        }
    }

    public NowThreadPool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void setThreadPoolProvider(ThreadPoolProvider threadPoolProvider) {
        sThreadPoolProvider = threadPoolProvider;
    }
}
