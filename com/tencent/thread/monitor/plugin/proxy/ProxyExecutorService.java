package com.tencent.thread.monitor.plugin.proxy;

import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.api.ProxyController;
import com.tencent.thread.monitor.plugin.manager.ProxyManager;
import com.tencent.thread.monitor.plugin.manager.ProxyTask;
import com.tencent.thread.monitor.plugin.manager.ThreadPoolInfo;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes26.dex */
public class ProxyExecutorService implements InvocationHandler {
    static IPatchRedirector $redirector_;
    private final ExecutorService executor;
    private final String poolName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProxyExecutorService(ExecutorService executorService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) executorService);
            return;
        }
        ThreadPoolInfo threadPoolInfo = new ThreadPoolInfo(executorService);
        ProxyManager.putPoolInfo(threadPoolInfo);
        this.executor = executorService;
        String poolName = threadPoolInfo.getPoolName();
        this.poolName = poolName;
        if (executorService instanceof ThreadPoolExecutor) {
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
            threadPoolExecutor.setThreadFactory(new BaseThreadFactory(threadPoolExecutor.getThreadFactory(), poolName));
        }
    }

    private void updateProxyPoolInfo(String str) {
        ThreadPoolInfo poolInfo;
        if (!str.equals("shutdown") && !str.equals("shutdownNow")) {
            if ((str.startsWith("submit") || str.startsWith("invoke") || str.startsWith("schedule") || str.startsWith("execute")) && (poolInfo = ProxyManager.getPoolInfo(this.poolName)) != null) {
                poolInfo.setLastTaskCompleteTime(SystemClock.elapsedRealtime());
                return;
            }
            return;
        }
        ThreadPoolInfo poolInfo2 = ProxyManager.getPoolInfo(this.poolName);
        if (poolInfo2 != null) {
            poolInfo2.shutDown(str.equals("shutdownNow"));
        }
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
        updateProxyPoolInfo(method.getName());
        if (objArr != null) {
            String stackString = ProxyManager.getStackString(true);
            for (int i3 = 0; i3 < objArr.length; i3++) {
                Object obj2 = objArr[i3];
                if (!(obj2 instanceof Runnable) && !(obj2 instanceof Callable)) {
                    if (obj2 instanceof Collection) {
                        Collection<Object> collection = (Collection) obj2;
                        if (!collection.isEmpty()) {
                            objArr[i3] = ProxyTask.INSTANCE.proxyList(collection, this.poolName, stackString);
                        }
                    }
                } else {
                    objArr[i3] = ProxyTask.INSTANCE.proxy(obj2, this.poolName, stackString);
                }
            }
        }
        try {
            return method.invoke(this.executor, objArr);
        } catch (OutOfMemoryError e16) {
            ProxyController proxyController = ProxyController.INSTANCE;
            if (proxyController.getEnableOptimized()) {
                proxyController.trimThreads(true);
                Object invoke = method.invoke(this.executor, objArr);
                if (proxyController.getIReporter() != null) {
                    proxyController.getIReporter().reportFixOOM();
                }
                return invoke;
            }
            throw e16;
        }
    }
}
