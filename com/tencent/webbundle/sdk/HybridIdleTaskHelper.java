package com.tencent.webbundle.sdk;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class HybridIdleTaskHelper {
    static IPatchRedirector $redirector_;
    private static volatile HybridIdleTaskHelper instance;
    private MessageQueue.IdleHandler sIdleHandler;
    private List<IdleTask> sIdleTasks;
    boolean sIsIdleHandlerInQueue;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    interface IIdleTask {
        public static final int RESULT_CONTINUE = 2;
        public static final int RESULT_DONE_OK = 1;
        public static final int RESULT_DONE_UNNECESSARY = 0;

        int run();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static abstract class IdleTask implements IIdleTask {
        static IPatchRedirector $redirector_;
        int taskId;

        IdleTask(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.taskId = i3;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    static class PreloadWebBundleTask extends IdleTask {
        static IPatchRedirector $redirector_;
        private String bizId;
        private Context context;

        public PreloadWebBundleTask(Context context, String str) {
            super(str.hashCode());
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
            } else {
                this.context = context;
                this.bizId = str;
            }
        }

        @Override // com.tencent.webbundle.sdk.HybridIdleTaskHelper.IIdleTask
        public int run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            WebBundleManager.getInstance(this.bizId).preload(this.context);
            return 1;
        }
    }

    public HybridIdleTaskHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.sIsIdleHandlerInQueue = false;
        this.sIdleTasks = new ArrayList(5);
        this.sIdleHandler = new MessageQueue.IdleHandler() { // from class: com.tencent.webbundle.sdk.HybridIdleTaskHelper.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HybridIdleTaskHelper.this);
                }
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this)).booleanValue();
                }
                while (true) {
                    if (HybridIdleTaskHelper.this.sIdleTasks.isEmpty()) {
                        break;
                    }
                    IdleTask idleTask = (IdleTask) HybridIdleTaskHelper.this.sIdleTasks.remove(0);
                    int run = idleTask.run();
                    if (2 == run) {
                        HybridIdleTaskHelper.this.sIdleTasks.add(idleTask);
                        break;
                    }
                    if (1 == run) {
                        break;
                    }
                }
                HybridIdleTaskHelper hybridIdleTaskHelper = HybridIdleTaskHelper.this;
                boolean z16 = !hybridIdleTaskHelper.sIdleTasks.isEmpty();
                hybridIdleTaskHelper.sIsIdleHandlerInQueue = z16;
                return z16;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAddIdleTask(IdleTask idleTask) {
        for (int i3 = 0; i3 < this.sIdleTasks.size(); i3++) {
            if (this.sIdleTasks.get(i3).taskId == idleTask.taskId) {
                return;
            }
        }
        this.sIdleTasks.add(idleTask);
        if (!this.sIdleTasks.isEmpty() && !this.sIsIdleHandlerInQueue) {
            this.sIsIdleHandlerInQueue = true;
            Looper.myQueue().addIdleHandler(this.sIdleHandler);
        }
    }

    public static HybridIdleTaskHelper getInstance() {
        if (instance == null) {
            synchronized (HybridIdleTaskHelper.class) {
                if (instance == null) {
                    instance = new HybridIdleTaskHelper();
                }
            }
        }
        return instance;
    }

    public void addIdleTask(IdleTask idleTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) idleTask);
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            doAddIdleTask(idleTask);
        } else {
            ThreadManager.getUiHandler().post(new Runnable(idleTask) { // from class: com.tencent.webbundle.sdk.HybridIdleTaskHelper.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ IdleTask val$newTask;

                {
                    this.val$newTask = idleTask;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HybridIdleTaskHelper.this, (Object) idleTask);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        HybridIdleTaskHelper.this.doAddIdleTask(this.val$newTask);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    public boolean removeIdleTask(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, i3)).booleanValue();
        }
        for (int i16 = 0; i16 < this.sIdleTasks.size(); i16++) {
            if (this.sIdleTasks.get(i16).taskId == i3) {
                this.sIdleTasks.remove(i16);
                return true;
            }
        }
        return false;
    }
}
