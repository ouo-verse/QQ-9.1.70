package com.tencent.could.component.common.ai.net;

import com.tencent.could.component.common.ai.eventreport.entry.NetWorkParam;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ThreadManager {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static ThreadManager f99999f;

    /* renamed from: a, reason: collision with root package name */
    public LinkedBlockingQueue<Runnable> f100000a;

    /* renamed from: b, reason: collision with root package name */
    public ThreadPoolExecutor f100001b;

    /* renamed from: c, reason: collision with root package name */
    public DelayQueue<HttpTask> f100002c;

    /* renamed from: d, reason: collision with root package name */
    public HttpTask f100003d;

    /* renamed from: e, reason: collision with root package name */
    public Runnable f100004e;
    public Runnable failedRunnable;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13865);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f99999f = new ThreadManager();
        }
    }

    public ThreadManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f100000a = new LinkedBlockingQueue<>();
        this.f100002c = new DelayQueue<>();
        this.failedRunnable = new Runnable() { // from class: com.tencent.could.component.common.ai.net.ThreadManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ThreadManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int retryTimes;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                while (true) {
                    try {
                        HttpTask take = ThreadManager.this.f100002c.take();
                        ThreadManager.this.f100003d = take;
                        int failedNum = take.getFailedNum();
                        ThreadManager threadManager = ThreadManager.this;
                        ThreadManager threadManager2 = ThreadManager.f99999f;
                        threadManager.getClass();
                        NetWorkParam requestNetWorkParam = take.getRequestNetWorkParam();
                        if (requestNetWorkParam == null) {
                            retryTimes = 3;
                        } else {
                            retryTimes = requestNetWorkParam.getRetryTimes();
                        }
                        if (failedNum < retryTimes) {
                            take.setFailedNum(take.getFailedNum() + 1);
                            ThreadManager.this.f100001b.execute(take);
                            TxNetWorkHelper.getInstance().logDebug(ThreadManagerV2.TAG, "network test time: " + take.getFailedNum());
                        } else {
                            CallBackListener callBackListener = ((JsonHttpRequest) take.getIHttpRequest()).getCallBackListener();
                            if (callBackListener != null) {
                                callBackListener.onFailed(take.getTaskError());
                            }
                        }
                    } catch (InterruptedException e16) {
                        TxNetWorkHelper.getInstance().logError(ThreadManagerV2.TAG, "network error , message: " + e16.getMessage());
                    }
                }
            }
        };
        this.f100004e = new Runnable() { // from class: com.tencent.could.component.common.ai.net.ThreadManager.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ThreadManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                while (true) {
                    try {
                        Runnable take = ThreadManager.this.f100000a.take();
                        if (take instanceof HttpTask) {
                            ThreadManager.this.f100003d = (HttpTask) take;
                        }
                        ThreadManager.this.f100001b.execute(take);
                    } catch (InterruptedException e16) {
                        TxNetWorkHelper.getInstance().logError(ThreadManagerV2.TAG, "network error , message: " + e16.getMessage());
                    }
                }
            }
        };
        BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(3, 10, 15L, TimeUnit.SECONDS, new ArrayBlockingQueue(4), new RejectedExecutionHandler() { // from class: com.tencent.could.component.common.ai.net.ThreadManager.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ThreadManager.this);
                }
            }

            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) runnable, (Object) threadPoolExecutor);
                } else {
                    ThreadManager.this.addTask(runnable);
                }
            }
        });
        this.f100001b = baseThreadPoolExecutor;
        baseThreadPoolExecutor.execute(this.f100004e);
        this.f100001b.execute(this.failedRunnable);
    }

    public static ThreadManager getInstance() {
        return f99999f;
    }

    public void addFailedTask(HttpTask httpTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) httpTask);
        } else {
            if (httpTask == null) {
                return;
            }
            httpTask.setDelayTime(1000L);
            this.f100002c.offer((DelayQueue<HttpTask>) httpTask);
        }
    }

    public void addTask(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) runnable);
            return;
        }
        if (runnable == null) {
            return;
        }
        try {
            this.f100000a.put(runnable);
        } catch (InterruptedException e16) {
            TxNetWorkHelper.getInstance().logError(ThreadManagerV2.TAG, "add network task error , message: " + e16.getMessage());
        }
    }

    public synchronized void stopCurrentRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        HttpTask httpTask = this.f100003d;
        if (httpTask != null) {
            httpTask.cleanRequest();
        }
    }
}
