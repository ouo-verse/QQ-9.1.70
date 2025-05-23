package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import mqq.inject.MqqInjectorManager;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ThreadManager extends ThreadManagerV2 {
    static IPatchRedirector $redirector_;
    private static volatile MqqHandler FILE_Mqq_HANDLER;
    private static volatile MqqHandler SUB_Mqq_HANDLER;
    private static volatile MqqHandler UI_Mqq_HANDLER;

    public ThreadManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static <T> FutureTask<T> execute(Callable<T> callable, int i3) {
        final FutureTask<T> futureTask = new FutureTask<>(callable);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.de
            @Override // java.lang.Runnable
            public final void run() {
                ThreadManager.lambda$execute$0(futureTask);
            }
        }, i3, null, false);
        return futureTask;
    }

    public static MqqHandler getFileThreadHandler() {
        if (FILE_Mqq_HANDLER == null) {
            synchronized (ThreadManagerV2.class) {
                if (FILE_Mqq_HANDLER == null) {
                    FILE_Mqq_HANDLER = new MqqHandler(ThreadManagerV2.getFileThreadLooper()) { // from class: com.tencent.mobileqq.app.ThreadManager.2
                        static IPatchRedirector $redirector_;

                        {
                            super(r4);
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4);
                            }
                        }

                        @Override // mqq.os.MqqHandler
                        public void removeCallbacksAndMessages(Object obj) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, obj);
                            } else {
                                if (obj == null) {
                                    if (MqqInjectorManager.instance().isPublicVersion()) {
                                        QLog.e(ThreadManagerV2.TAG, 1, "global fileHandler cannot excute removeCallbacksAndMessages");
                                        return;
                                    }
                                    throw new RuntimeException("global fileHandler cannot excute removeCallbacksAndMessages");
                                }
                                super.removeCallbacksAndMessages(obj);
                            }
                        }
                    };
                }
            }
        }
        return FILE_Mqq_HANDLER;
    }

    public static MqqHandler getSubThreadHandler() {
        if (SUB_Mqq_HANDLER == null) {
            synchronized (ThreadManagerV2.class) {
                if (SUB_Mqq_HANDLER == null) {
                    SUB_Mqq_HANDLER = new MqqHandler(ThreadManagerV2.getSubThreadLooper()) { // from class: com.tencent.mobileqq.app.ThreadManager.1
                        static IPatchRedirector $redirector_;

                        {
                            super(r4);
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4);
                            }
                        }

                        @Override // mqq.os.MqqHandler
                        public void removeCallbacksAndMessages(Object obj) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, obj);
                            } else {
                                if (obj == null) {
                                    if (MqqInjectorManager.instance().isPublicVersion()) {
                                        QLog.e(ThreadManagerV2.TAG, 1, "global SubHandler cannot excute removeCallbacksAndMessages");
                                        return;
                                    }
                                    throw new RuntimeException("global SubHandler cannot excute removeCallbacksAndMessages");
                                }
                                super.removeCallbacksAndMessages(obj);
                            }
                        }
                    };
                }
            }
        }
        return SUB_Mqq_HANDLER;
    }

    public static MqqHandler getUIHandler() {
        if (UI_Mqq_HANDLER == null) {
            synchronized (ThreadManagerV2.class) {
                if (UI_Mqq_HANDLER == null) {
                    UI_Mqq_HANDLER = new MqqHandler(Looper.getMainLooper(), null, true);
                }
            }
        }
        return UI_Mqq_HANDLER;
    }

    public static void initDPC(SharedPreferences sharedPreferences, boolean z16) {
        if (!MqqInjectorManager.instance().isPublicVersion() && z16) {
            boolean z17 = sharedPreferences.getBoolean("debug_threadMan", false);
            if (QLog.isColorLevel()) {
                QLog.e(ThreadManagerV2.TAG, 1, "initDPC debug_threadMan " + z17);
            }
            if (z17) {
                ThreadSetting.logcatBgTaskMonitor = true;
            } else {
                ThreadSetting.logcatBgTaskMonitor = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$execute$0(FutureTask futureTask) {
        try {
            futureTask.run();
        } catch (Exception e16) {
            throw new RuntimeException(e16);
        }
    }
}
