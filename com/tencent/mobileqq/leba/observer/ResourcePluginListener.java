package com.tencent.mobileqq.leba.observer;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

/* loaded from: classes15.dex */
public class ResourcePluginListener {
    static IPatchRedirector $redirector_;

    /* loaded from: classes15.dex */
    public static class CallbackRunner implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private SoftReference<ResourcePluginListener> f240723d;

        /* renamed from: e, reason: collision with root package name */
        private byte f240724e;

        /* renamed from: f, reason: collision with root package name */
        private int f240725f;

        public CallbackRunner(ResourcePluginListener resourcePluginListener, byte b16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, resourcePluginListener, Byte.valueOf(b16), Integer.valueOf(i3));
                return;
            }
            this.f240723d = new SoftReference<>(resourcePluginListener);
            this.f240724e = b16;
            this.f240725f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            ResourcePluginListener resourcePluginListener = this.f240723d.get();
            if (resourcePluginListener == null && QLog.isColorLevel()) {
                QLog.d("ResourcePluginListener", 1, "ResourcePluginListener is null");
            }
            if (resourcePluginListener != null) {
                int i3 = this.f240725f;
                if (i3 == 2) {
                    resourcePluginListener.b(this.f240724e);
                } else if (i3 == 1) {
                    resourcePluginListener.c(this.f240724e);
                }
            }
        }
    }

    public ResourcePluginListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(ResourcePluginListener resourcePluginListener, byte b16, int i3) {
        ThreadManagerV2.getUIHandlerV2().post(new CallbackRunner(resourcePluginListener, b16, i3));
    }

    public void b(byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Byte.valueOf(b16));
        }
    }

    public void c(byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Byte.valueOf(b16));
        }
    }
}
