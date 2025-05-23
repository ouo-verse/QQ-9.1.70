package com.tencent.qqlive.tvkplayer.vinfo.common;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKCGIExecutor {

    @NonNull
    ExecutorService mExecutorServiceProxy;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class ExecutorServiceInvocationHandler implements InvocationHandler {
        private final ExecutorService mExecutorService;

        public ExecutorServiceInvocationHandler(ExecutorService executorService) {
            this.mExecutorService = executorService;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            return method.invoke(this.mExecutorService, objArr);
        }
    }

    public TVKCGIExecutor(int i3) {
        ExecutorServiceInvocationHandler executorServiceInvocationHandler;
        if (i3 == 0) {
            executorServiceInvocationHandler = new ExecutorServiceInvocationHandler(TVKThreadPool.getInstance().generateExecutorServiceProxy(TVKThreadPool.getInstance().obtainHighPriorityExecutor(), TVKMediaPlayerConfig.PlayerConfig.tvk_thread_priority_after_modification));
        } else {
            executorServiceInvocationHandler = new ExecutorServiceInvocationHandler(TVKThreadPool.getInstance().obtainNormalPriorityExecutor());
        }
        this.mExecutorServiceProxy = (ExecutorService) Proxy.newProxyInstance(ExecutorService.class.getClassLoader(), new Class[]{ExecutorService.class}, executorServiceInvocationHandler);
    }

    public void execute(Runnable runnable) {
        this.mExecutorServiceProxy.execute(runnable);
    }
}
