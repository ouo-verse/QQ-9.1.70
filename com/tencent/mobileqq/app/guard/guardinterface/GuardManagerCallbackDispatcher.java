package com.tencent.mobileqq.app.guard.guardinterface;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GuardManagerCallbackDispatcher {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "GuardManager.GuardManagerCallbackDispatcher";
    static final ArrayList<IGuardInterface> sIGuardInterfaces;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37001);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        sIGuardInterfaces = new ArrayList<>();
        Iterator<Class<? extends IGuardInterface>> it = GuardManagerCallbackRegister.injectClassList.iterator();
        while (it.hasNext()) {
            try {
                sIGuardInterfaces.add(it.next().newInstance());
            } catch (IllegalAccessException e16) {
                QLog.e(TAG, 2, "GuardManagerCallbackDispatcher construct err: ", e16);
            } catch (InstantiationException e17) {
                QLog.e(TAG, 2, "GuardManagerCallbackDispatcher construct err: ", e17);
            }
        }
    }

    public GuardManagerCallbackDispatcher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static synchronized void dispatchAppBackground() {
        synchronized (GuardManagerCallbackDispatcher.class) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "dispatchAppBackground");
            }
            synchronized (GuardManagerCallbackDispatcher.class) {
                Iterator<IGuardInterface> it = sIGuardInterfaces.iterator();
                while (it.hasNext()) {
                    it.next().onApplicationBackground();
                }
            }
        }
    }

    public static synchronized void dispatchAppForeground() {
        synchronized (GuardManagerCallbackDispatcher.class) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "dispatcherAppForeground");
            }
            synchronized (GuardManagerCallbackDispatcher.class) {
                Iterator<IGuardInterface> it = sIGuardInterfaces.iterator();
                while (it.hasNext()) {
                    it.next().onApplicationForeground();
                }
            }
        }
    }

    public static void dispatchBackgroundTimeTick(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "dispatchBackgroundTimeTick: time: ", Long.valueOf(j3));
        }
        synchronized (GuardManagerCallbackDispatcher.class) {
            Iterator<IGuardInterface> it = sIGuardInterfaces.iterator();
            while (it.hasNext()) {
                it.next().onBackgroundTimeTick(j3);
            }
        }
    }

    public static void dispatchBackgroundUnguardTimeTick(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "dispatchBackgroundUnguardTimeTick: time: ", Long.valueOf(j3));
        }
        synchronized (GuardManagerCallbackDispatcher.class) {
            Iterator<IGuardInterface> it = sIGuardInterfaces.iterator();
            while (it.hasNext()) {
                it.next().onBackgroundUnguardTimeTick(j3);
            }
        }
    }

    public static void dispatchLiteTimeTick(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "dispatchAutoStartTimeTick: time: ", Long.valueOf(j3));
        }
        synchronized (GuardManagerCallbackDispatcher.class) {
            Iterator<IGuardInterface> it = sIGuardInterfaces.iterator();
            while (it.hasNext()) {
                it.next().onLiteTimeTick(j3);
            }
        }
    }

    public static void dispatchOnScreenChange(boolean z16) {
        QLog.d(TAG, 1, "dispatcherOnScreenChange: ", Boolean.valueOf(z16));
        synchronized (GuardManagerCallbackDispatcher.class) {
            Iterator<IGuardInterface> it = sIGuardInterfaces.iterator();
            while (it.hasNext()) {
                it.next().onScreensStateChanged(z16);
            }
        }
    }

    public static void registerCallBack(IGuardInterface iGuardInterface) {
        new Handler(ThreadManagerV2.getQQCommonThreadLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) IGuardInterface.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    synchronized (GuardManagerCallbackDispatcher.class) {
                        GuardManagerCallbackDispatcher.sIGuardInterfaces.add(IGuardInterface.this);
                    }
                }
            }
        });
    }

    public static void unregisterCallBack(IGuardInterface iGuardInterface) {
        new Handler(ThreadManagerV2.getQQCommonThreadLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) IGuardInterface.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    synchronized (GuardManagerCallbackDispatcher.class) {
                        GuardManagerCallbackDispatcher.sIGuardInterfaces.remove(IGuardInterface.this);
                    }
                }
            }
        });
    }
}
