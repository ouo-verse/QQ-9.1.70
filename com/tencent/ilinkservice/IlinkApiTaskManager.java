package com.tencent.ilinkservice;

import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final class IlinkApiTaskManager {
    private static final String TAG = "IlinkServiceApiTask";
    private volatile boolean m_ilinkservice_available_;
    private volatile boolean m_stop_running;
    private ArrayBlockingQueue<TaskInfo> m_task_queue_;
    private IlinkApiTaskThread m_task_thread_;
    private final Boolean m_thread_sleep_;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class IlinkApiTaskThread extends BaseThread {
        IlinkApiTaskThread() {
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            TaskInfo taskInfo;
            super.run();
            Thread.currentThread().setName("ApiTaskThread");
            while (!IlinkApiTaskManager.this.m_stop_running) {
                synchronized (IlinkApiTaskManager.this.m_thread_sleep_) {
                    try {
                        if (!IlinkApiTaskManager.this.m_ilinkservice_available_) {
                            IlinkServiceLogImpl.getInstance().d(IlinkApiTaskManager.TAG, "Thread stop running wait service available 20s", new Object[0]);
                            IlinkApiTaskManager.this.m_thread_sleep_.wait(20000L);
                            IlinkServiceLogImpl.getInstance().d(IlinkApiTaskManager.TAG, "wake up from wait signal", new Object[0]);
                        }
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                }
                while (true) {
                    if (IlinkApiTaskManager.this.m_ilinkservice_available_) {
                        try {
                            taskInfo = (TaskInfo) IlinkApiTaskManager.this.m_task_queue_.take();
                        } catch (IllegalAccessException e17) {
                            StringWriter stringWriter = new StringWriter();
                            e17.printStackTrace(new PrintWriter((Writer) stringWriter, true));
                            IlinkServiceLogImpl.getInstance().e(IlinkApiTaskManager.TAG, "method.invoke IllegalAccessException:" + stringWriter.toString(), new Object[0]);
                        } catch (InterruptedException e18) {
                            StringWriter stringWriter2 = new StringWriter();
                            e18.printStackTrace(new PrintWriter((Writer) stringWriter2, true));
                            IlinkServiceLogImpl.getInstance().e(IlinkApiTaskManager.TAG, "method.invoke InterruptedException:" + stringWriter2.toString(), new Object[0]);
                        } catch (NoSuchMethodException e19) {
                            StringWriter stringWriter3 = new StringWriter();
                            e19.printStackTrace(new PrintWriter((Writer) stringWriter3, true));
                            IlinkServiceLogImpl.getInstance().e(IlinkApiTaskManager.TAG, "could not found function:" + stringWriter3.toString(), new Object[0]);
                        } catch (InvocationTargetException e26) {
                            StringWriter stringWriter4 = new StringWriter();
                            e26.printStackTrace(new PrintWriter((Writer) stringWriter4, true));
                            IlinkServiceLogImpl.getInstance().e(IlinkApiTaskManager.TAG, "method.invoke InvocationTargetException:" + stringWriter4.toString(), new Object[0]);
                        }
                        if (!IlinkApiTaskManager.this.m_ilinkservice_available_) {
                            IlinkApiTaskManager.this.m_task_queue_.offer(taskInfo);
                            break;
                        }
                        IlinkServiceLogImpl.getInstance().d(IlinkApiTaskManager.TAG, "get task from queue:" + taskInfo.m_funcname, new Object[0]);
                        taskInfo.m_protocol.getMethod(taskInfo.m_funcname, taskInfo.m_paramTypes).invoke(taskInfo.m_obj_, taskInfo.m_params);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class SingletonLoader {
        private static IlinkApiTaskManager singletonStatic = new IlinkApiTaskManager();

        SingletonLoader() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class TaskInfo {
        String m_funcname;
        Object m_obj_;
        Class[] m_paramTypes;
        Object[] m_params;
        Class m_protocol;

        public TaskInfo(Object obj, Class cls, String str, Class[] clsArr, Object[] objArr) {
            this.m_obj_ = obj;
            this.m_protocol = cls;
            this.m_funcname = str;
            this.m_paramTypes = clsArr;
            this.m_params = objArr;
        }
    }

    public static IlinkApiTaskManager getInstance() {
        return SingletonLoader.singletonStatic;
    }

    public void addTask(Object obj, Class cls, String str, Class[] clsArr, Object... objArr) {
        try {
            if (!this.m_task_queue_.offer(new TaskInfo(obj, cls, str, clsArr, objArr), 200L, TimeUnit.MILLISECONDS)) {
                IlinkServiceLogImpl.getInstance().e(TAG, "task queue is full!", new Object[0]);
            } else {
                IlinkServiceLogImpl.getInstance().d(TAG, "add task to queue:" + str, new Object[0]);
            }
        } catch (InterruptedException e16) {
            IlinkServiceLogImpl.getInstance().d(TAG, "add task to queue InterruptedException:" + str, new Object[0]);
            e16.printStackTrace();
        }
    }

    public void clearTask() {
        this.m_task_queue_.clear();
    }

    public void setIlinkServiceAvailable(boolean z16) {
        synchronized (this.m_thread_sleep_) {
            this.m_ilinkservice_available_ = z16;
            this.m_thread_sleep_.notify();
        }
    }

    public void startTaskManager() {
        this.m_stop_running = false;
        if (this.m_task_thread_ == null) {
            IlinkApiTaskThread ilinkApiTaskThread = new IlinkApiTaskThread();
            this.m_task_thread_ = ilinkApiTaskThread;
            ilinkApiTaskThread.start();
        }
    }

    public void stopTaskManager() {
        this.m_stop_running = true;
        IlinkApiTaskThread ilinkApiTaskThread = this.m_task_thread_;
        if (ilinkApiTaskThread != null && ilinkApiTaskThread.isAlive()) {
            this.m_task_thread_.interrupt();
            this.m_task_thread_ = null;
            this.m_task_queue_.clear();
        }
    }

    public void writeLogToService(int i3, String str, String str2) {
        try {
            if (!this.m_task_queue_.offer(new TaskInfo(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "writeLogToService", new Class[]{Integer.TYPE, String.class, String.class}, new Object[]{Integer.valueOf(i3), str, str2}), 200L, TimeUnit.MILLISECONDS)) {
                IlinkServiceLogImpl.getInstance().e(TAG, "task queue is full!", new Object[0]);
            } else {
                IlinkServiceLogImpl.getInstance().d(TAG, "add task to queue!", new Object[0]);
            }
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
    }

    IlinkApiTaskManager() {
        this.m_task_queue_ = new ArrayBlockingQueue<>(80);
        this.m_stop_running = false;
        this.m_task_thread_ = null;
        this.m_ilinkservice_available_ = false;
        this.m_thread_sleep_ = new Boolean(true);
        IlinkServiceLogImpl.getInstance().d(TAG, "Create IlinkApiTaskManager", new Object[0]);
    }
}
