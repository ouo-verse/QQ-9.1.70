package com.tencent.qqlive.tvkplayer.tools.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes23.dex */
public class TVKThreadPool {
    private static final String DEFAULT_THREAD_NAME = "TVKDefault";
    private static final int HIGH_PRIORITY_QUEUE_CAPACITY = 10;
    private static final int NORMAL_PRIORITY_QUEUE_CAPACITY = 20;
    public static final int NUM_OF_CPU_CORE;
    private static final int RUNTIME_AVAILABLE_PROCESSORS;
    private static final String SHARED_HANDLER_THREAD_NAME = "TVKShared";
    private static final String TAG = "TVKPlayer[TVKThreadPool]";
    private static volatile ExecutorService sHighPriorityExecutor;
    private static volatile TVKThreadPool sInstance;
    private static volatile boolean sIsSharedHandlerThreadStarted;
    private static volatile Handler sMainThreadHandler;
    private static volatile ExecutorService sNormalPriorityExecutor;
    private static volatile ScheduledExecutorService sScheduler;
    private static volatile ExecutorService sShareSingleExecutor;
    private static volatile HandlerThread sSharedHandlerThread;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        RUNTIME_AVAILABLE_PROCESSORS = availableProcessors;
        if (availableProcessors <= 0) {
            availableProcessors = 1;
        }
        NUM_OF_CPU_CORE = availableProcessors;
        sSharedHandlerThread = null;
        sIsSharedHandlerThreadStarted = false;
        sMainThreadHandler = null;
        sShareSingleExecutor = null;
        sNormalPriorityExecutor = null;
        sHighPriorityExecutor = null;
        sScheduler = null;
    }

    TVKThreadPool() {
    }

    public static TVKThreadPool getInstance() {
        if (sInstance == null) {
            synchronized (TVKThreadPool.class) {
                if (sInstance == null) {
                    sInstance = new TVKThreadPool();
                }
            }
        }
        return sInstance;
    }

    private static void initMainThreadHandler() {
        if (sMainThreadHandler != null) {
            return;
        }
        synchronized (TVKThreadPool.class) {
            if (sMainThreadHandler != null) {
                return;
            }
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                sMainThreadHandler = new Handler(mainLooper);
            } else {
                sMainThreadHandler = null;
                TVKLogUtil.e(TAG, "cannot get thread looper");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$generateExecutorServiceProxy$0(int i3, Runnable runnable) {
        TVKThreadPrioritySetter.set(i3);
        runnable.run();
        TVKThreadPrioritySetter.reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$generateExecutorServiceProxy$1(final int i3, ExecutorService executorService, Object obj, Method method, Object[] objArr) throws Throwable {
        if (method.getName().equals("execute") && objArr != null && objArr.length == 1) {
            Object obj2 = objArr[0];
            if (obj2 instanceof Runnable) {
                final Runnable runnable = (Runnable) obj2;
                objArr[0] = new Runnable() { // from class: com.tencent.qqlive.tvkplayer.tools.utils.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        TVKThreadPool.lambda$generateExecutorServiceProxy$0(i3, runnable);
                    }
                };
            }
        }
        return method.invoke(executorService, objArr);
    }

    public static synchronized void setCustomThread(HandlerThread handlerThread, Executor executor) {
        synchronized (TVKThreadPool.class) {
            if (handlerThread != null) {
                if (sSharedHandlerThread == null) {
                    sSharedHandlerThread = handlerThread;
                    sIsSharedHandlerThreadStarted = true;
                }
            }
            if ((executor instanceof ExecutorService) && sNormalPriorityExecutor == null) {
                sNormalPriorityExecutor = (ExecutorService) executor;
            }
        }
    }

    public ExecutorService generateExecutorServiceProxy(final ExecutorService executorService, final int i3) {
        return (ExecutorService) Proxy.newProxyInstance(ExecutorService.class.getClassLoader(), new Class[]{ExecutorService.class}, new InvocationHandler() { // from class: com.tencent.qqlive.tvkplayer.tools.utils.g
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                Object lambda$generateExecutorServiceProxy$1;
                lambda$generateExecutorServiceProxy$1 = TVKThreadPool.lambda$generateExecutorServiceProxy$1(i3, executorService, obj, method, objArr);
                return lambda$generateExecutorServiceProxy$1;
            }
        });
    }

    public HandlerThread obtainHandleThread(String str) {
        return obtainHandleThread(str, 0);
    }

    public ExecutorService obtainHighPriorityExecutor() {
        if (sHighPriorityExecutor == null) {
            synchronized (TVKThreadPool.class) {
                if (sHighPriorityExecutor == null) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("obtainHighPriorityExecutor, cpu core num:");
                    int i3 = NUM_OF_CPU_CORE;
                    sb5.append(i3);
                    TVKLogUtil.i(TAG, sb5.toString());
                    sHighPriorityExecutor = TVKThreadPoolExecutor.newHighPriorityThreadExecutor(3, Math.max(i3, 3), 10);
                }
            }
        }
        return sHighPriorityExecutor;
    }

    public ExecutorService obtainNormalPriorityExecutor() {
        if (sNormalPriorityExecutor == null) {
            synchronized (TVKThreadPool.class) {
                if (sNormalPriorityExecutor == null) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("obtainNormalPriorityExecutor, cpu core num:");
                    int i3 = NUM_OF_CPU_CORE;
                    sb5.append(i3);
                    TVKLogUtil.i(TAG, sb5.toString());
                    sNormalPriorityExecutor = TVKThreadPoolExecutor.newNormalPriorityThreadExecutor(0, i3 * 2, 20);
                }
            }
        }
        return sNormalPriorityExecutor;
    }

    public ScheduledExecutorService obtainScheduledExecutorService() {
        if (sScheduler == null) {
            synchronized (TVKThreadPool.class) {
                if (sScheduler == null) {
                    sScheduler = TVKThreadPoolExecutor.newScheduledThreadExecutor(2);
                }
            }
        }
        return sScheduler;
    }

    public HandlerThread obtainSharedHandlerThread() {
        if (sIsSharedHandlerThreadStarted) {
            return sSharedHandlerThread;
        }
        synchronized (TVKThreadPool.class) {
            if (sIsSharedHandlerThreadStarted) {
                return sSharedHandlerThread;
            }
            sSharedHandlerThread = new BaseHandlerThread(SHARED_HANDLER_THREAD_NAME);
            sSharedHandlerThread.start();
            sIsSharedHandlerThreadStarted = true;
            return sSharedHandlerThread;
        }
    }

    public ExecutorService obtainSingleThreadExecutor() {
        if (sShareSingleExecutor == null) {
            synchronized (TVKThreadPool.class) {
                if (sShareSingleExecutor == null) {
                    sShareSingleExecutor = TVKThreadPoolExecutor.newSingleThreadExecutor();
                }
            }
        }
        return sShareSingleExecutor;
    }

    public void postDelayRunnableOnMainThread(Runnable runnable, long j3) {
        initMainThreadHandler();
        if (sMainThreadHandler != null) {
            sMainThreadHandler.postDelayed(runnable, j3);
        }
    }

    public void postRunnableOnMainThread(Runnable runnable) {
        initMainThreadHandler();
        if (sMainThreadHandler != null) {
            sMainThreadHandler.post(runnable);
        }
    }

    public void postRunnableOnMainThreadFront(Runnable runnable) {
        initMainThreadHandler();
        if (sMainThreadHandler != null) {
            sMainThreadHandler.postAtFrontOfQueue(runnable);
        }
    }

    public void recycle(HandlerThread handlerThread, Handler handler) {
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (handlerThread != null && !handlerThread.equals(sSharedHandlerThread)) {
            handlerThread.quit();
        }
    }

    public HandlerThread obtainHandleThread(String str, int i3) {
        if (i3 >= 19 || i3 <= -19) {
            TVKLogUtil.i(TAG, "priority is invalid, setting default");
            i3 = 0;
        }
        if (TextUtils.isEmpty(str)) {
            str = DEFAULT_THREAD_NAME;
        }
        TVKHandlerThread tVKHandlerThread = new TVKHandlerThread(str, i3);
        tVKHandlerThread.start();
        return tVKHandlerThread;
    }
}
