package com.tencent.mobileqq.apollo.view.opengl;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thumbplayer.libloader.TPFromApkLibraryLoader;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GLThreadManager {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    private static String f194414g;

    /* renamed from: h, reason: collision with root package name */
    private static volatile int f194415h;

    /* renamed from: i, reason: collision with root package name */
    private static volatile boolean f194416i;

    /* renamed from: a, reason: collision with root package name */
    private boolean f194417a;

    /* renamed from: b, reason: collision with root package name */
    private int f194418b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f194419c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f194420d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f194421e;

    /* renamed from: f, reason: collision with root package name */
    private GLThread f194422f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38120);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f194414g = "[ApolloGL][GLThreadManager]";
            f194416i = false;
        }
    }

    public GLThreadManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b() {
        if (!this.f194417a) {
            int i3 = f194415h;
            this.f194418b = i3;
            if (i3 >= 131072) {
                this.f194420d = true;
            }
            this.f194417a = true;
        }
    }

    public static synchronized void c(Context context) {
        synchronized (GLThreadManager.class) {
            if (f194416i) {
                return;
            }
            f194416i = true;
            new BaseThread(new Runnable(context) { // from class: com.tencent.mobileqq.apollo.view.opengl.GLThreadManager.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Context f194423d;

                {
                    this.f194423d = context;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        GLThreadManager.e(this.f194423d);
                    }
                }
            }).start();
        }
    }

    @SuppressLint({"UseValueOf"})
    private static Integer d(Context context, String str, int i3) throws IllegalArgumentException {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(TPFromApkLibraryLoader.ANDROID_OS_SYSTEM_PROPERTIES_CLASS_NAME);
            return (Integer) loadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(loadClass, new String(str), new Integer(i3));
        } catch (IllegalArgumentException e16) {
            throw e16;
        } catch (Exception unused) {
            return Integer.valueOf(i3);
        }
    }

    public static synchronized void e(Context context) {
        synchronized (GLThreadManager.class) {
            if (f194415h == 0) {
                f194415h = d(context, "ro.opengles.version", 0).intValue();
                QLog.i(f194414g, 1, "checkGLVersion sGLESVersion:" + f194415h);
            }
        }
    }

    public synchronized void a(GL10 gl10) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) gl10);
            return;
        }
        if (!this.f194419c) {
            b();
            String glGetString = gl10.glGetString(7937);
            boolean z17 = false;
            if (this.f194418b < 131072) {
                if (!glGetString.startsWith("Q3Dimension MSM7500 ")) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.f194420d = z16;
                notifyAll();
            }
            if (!this.f194420d) {
                z17 = true;
            }
            this.f194421e = z17;
            this.f194419c = true;
        }
    }

    public void f(GLThread gLThread) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) gLThread);
            return;
        }
        if (this.f194422f == gLThread) {
            this.f194422f = null;
        }
        notifyAll();
    }

    public synchronized boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.f194421e;
    }

    public synchronized boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        b();
        return !this.f194420d;
    }

    public synchronized void i(GLThread gLThread) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) gLThread);
            return;
        }
        gLThread.D = true;
        if (this.f194422f == gLThread) {
            this.f194422f = null;
        }
        notifyAll();
    }

    public boolean j(GLThread gLThread) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) gLThread)).booleanValue();
        }
        GLThread gLThread2 = this.f194422f;
        if (gLThread2 != gLThread && gLThread2 != null) {
            b();
            if (this.f194420d) {
                return true;
            }
            GLThread gLThread3 = this.f194422f;
            if (gLThread3 != null) {
                gLThread3.requestReleaseEglContextLocked();
                return false;
            }
            return false;
        }
        this.f194422f = gLThread;
        notifyAll();
        return true;
    }
}
