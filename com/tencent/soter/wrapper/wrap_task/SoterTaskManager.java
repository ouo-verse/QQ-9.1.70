package com.tencent.soter.wrapper.wrap_task;

import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.model.SLogger;
import com.tencent.soter.core.model.SoterErrCode;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessResultBase;
import com.tencent.soter.wrapper.wrap_core.SoterProcessErrCode;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SoterTaskManager implements SoterProcessErrCode {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Soter.SoterTaskManager";
    private static volatile SoterTaskManager sInstance;
    private static volatile SparseArray<BaseSoterTask> sTaskPool;
    private final Object mTaskPoolLock;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18043);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            sInstance = null;
            sTaskPool = null;
        }
    }

    SoterTaskManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mTaskPoolLock = new Object();
            sTaskPool = new SparseArray<>(5);
        }
    }

    public static SoterTaskManager getInstance() {
        SoterTaskManager soterTaskManager;
        if (sInstance == null) {
            synchronized (SoterTaskManager.class) {
                if (sInstance == null) {
                    sInstance = new SoterTaskManager();
                }
                soterTaskManager = sInstance;
            }
            return soterTaskManager;
        }
        return sInstance;
    }

    public boolean addToTask(BaseSoterTask baseSoterTask, SoterProcessResultBase soterProcessResultBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseSoterTask, (Object) soterProcessResultBase)).booleanValue();
        }
        if (baseSoterTask == null) {
            SLogger.e(TAG, "soter: task is null. should not happen", new Object[0]);
            return false;
        }
        if (soterProcessResultBase == null) {
            SLogger.e(TAG, "soter: instanceOnError is null. should not happen", new Object[0]);
            return false;
        }
        if (!baseSoterTask.preExecute()) {
            int hashCode = baseSoterTask.hashCode();
            if (!baseSoterTask.isSingleInstance()) {
                SLogger.i(TAG, "soter: not single instance. directly execute", new Object[0]);
                synchronized (this.mTaskPoolLock) {
                    sTaskPool.put(hashCode, baseSoterTask);
                }
                SoterTaskThread.getInstance().postToWorker(new Runnable(baseSoterTask) { // from class: com.tencent.soter.wrapper.wrap_task.SoterTaskManager.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ BaseSoterTask val$task;

                    {
                        this.val$task = baseSoterTask;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SoterTaskManager.this, (Object) baseSoterTask);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            this.val$task.execute();
                        }
                    }
                });
                return true;
            }
            synchronized (this.mTaskPoolLock) {
                for (int i3 = 0; i3 < sTaskPool.size(); i3++) {
                    int keyAt = sTaskPool.keyAt(i3);
                    if (sTaskPool.get(keyAt) != null && sTaskPool.get(keyAt).getClass().getName().equals(baseSoterTask.getClass().getName())) {
                        SLogger.w(TAG, "soter: already such type of task. abandon add task", new Object[0]);
                        soterProcessResultBase.setErrCode(1023);
                        soterProcessResultBase.setErrMsg("add SOTER task to queue failed. check the logcat for further information");
                        baseSoterTask.callback(soterProcessResultBase);
                        return false;
                    }
                }
                sTaskPool.put(hashCode, baseSoterTask);
                SoterTaskThread.getInstance().postToWorker(new Runnable(baseSoterTask) { // from class: com.tencent.soter.wrapper.wrap_task.SoterTaskManager.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ BaseSoterTask val$task;

                    {
                        this.val$task = baseSoterTask;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SoterTaskManager.this, (Object) baseSoterTask);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            this.val$task.execute();
                        }
                    }
                });
                return true;
            }
        }
        SLogger.d(TAG, "soter: prepare eat execute.", new Object[0]);
        return false;
    }

    public void cancelAllTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        synchronized (this.mTaskPoolLock) {
            SLogger.i(TAG, "soter: request cancel all", new Object[0]);
            if (sTaskPool.size() != 0) {
                for (int i3 = 0; i3 < sTaskPool.size(); i3++) {
                    SoterTaskThread.getInstance().postToWorker(new Runnable(sTaskPool.keyAt(i3)) { // from class: com.tencent.soter.wrapper.wrap_task.SoterTaskManager.3
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ int val$key;

                        {
                            this.val$key = r5;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SoterTaskManager.this, r5);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                synchronized (SoterTaskManager.this.mTaskPoolLock) {
                                    BaseSoterTask baseSoterTask = (BaseSoterTask) SoterTaskManager.sTaskPool.get(this.val$key);
                                    if (baseSoterTask != null) {
                                        baseSoterTask.onRemovedFromTaskPoolActively();
                                    }
                                }
                                return;
                            }
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    });
                }
            }
            sTaskPool.clear();
        }
    }

    public void publishAuthCancellation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        synchronized (this.mTaskPoolLock) {
            SLogger.i(TAG, "soter: request publish cancellation", new Object[0]);
            if (sTaskPool.size() != 0) {
                for (int i3 = 0; i3 < sTaskPool.size(); i3++) {
                    SoterTaskThread.getInstance().postToWorker(new Runnable(sTaskPool.keyAt(i3)) { // from class: com.tencent.soter.wrapper.wrap_task.SoterTaskManager.4
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ int val$key;

                        {
                            this.val$key = r5;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SoterTaskManager.this, r5);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            SoterErrCode soterErrCode;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                synchronized (SoterTaskManager.this.mTaskPoolLock) {
                                    soterErrCode = (BaseSoterTask) SoterTaskManager.sTaskPool.get(this.val$key);
                                }
                                if (soterErrCode != null && (soterErrCode instanceof AuthCancellationCallable)) {
                                    AuthCancellationCallable authCancellationCallable = (AuthCancellationCallable) soterErrCode;
                                    if (!authCancellationCallable.isCancelled()) {
                                        authCancellationCallable.callCancellationInternal();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeFromTask(BaseSoterTask baseSoterTask) {
        Object obj;
        Object[] objArr = new Object[1];
        if (baseSoterTask != null) {
            obj = Integer.valueOf(baseSoterTask.hashCode());
        } else {
            obj = "null";
        }
        objArr[0] = obj;
        SLogger.i(TAG, "soter: removing task: %d", objArr);
        if (baseSoterTask == null) {
            SLogger.e(TAG, "soter: task is null", new Object[0]);
            return;
        }
        synchronized (this.mTaskPoolLock) {
            if (sTaskPool.get(baseSoterTask.hashCode()) == null) {
                SLogger.i(TAG, "soter: no such task: %d. maybe this task did not pass preExecute", Integer.valueOf(baseSoterTask.hashCode()));
            } else {
                sTaskPool.remove(baseSoterTask.hashCode());
            }
        }
    }
}
