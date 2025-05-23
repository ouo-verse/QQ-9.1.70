package com.tencent.thread.monitor.plugin.proxy.async;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.api.ProxyController;
import com.tencent.thread.monitor.plugin.manager.ProxyManager;
import com.tencent.thread.monitor.plugin.manager.ProxyTask;
import com.tencent.thread.monitor.plugin.manager.ThreadPoolInfo;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/* loaded from: classes26.dex */
public class ProxyAsyncTaskExecutor implements InvocationHandler {
    static IPatchRedirector $redirector_ = null;
    static final int TYPE_SERIAL_EXECUTOR = 1;
    static final int TYPE_THREAD_POOL_EXECUTOR = 0;
    private final Executor executor;
    private final String poolName;
    private final int type;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProxyAsyncTaskExecutor(Executor executor, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) executor, i3);
            return;
        }
        ThreadPoolInfo threadPoolInfo = new ThreadPoolInfo(executor);
        ProxyManager.putPoolInfo(threadPoolInfo);
        this.executor = executor;
        this.type = i3;
        this.poolName = threadPoolInfo.getPoolName();
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, obj, method, objArr);
        }
        if (!ProxyController.INSTANCE.getEnabled()) {
            return method.invoke(this.executor, objArr);
        }
        if (method.getName().equals("execute") && objArr != null && objArr.length == 1 && (objArr[0] instanceof Runnable)) {
            String stackString = ProxyManager.getStackString(true);
            int i3 = this.type;
            if (i3 == 0) {
                if (!stackString.contains("AsyncTask$SerialExecutor.scheduleNext")) {
                    objArr[0] = new ProxyTask(objArr[0], this.poolName, stackString);
                }
            } else if (i3 == 1 && !(objArr[0] instanceof ProxyTask)) {
                objArr[0] = new ProxyTask(objArr[0], null, stackString);
            }
        }
        return method.invoke(this.executor, objArr);
    }
}
