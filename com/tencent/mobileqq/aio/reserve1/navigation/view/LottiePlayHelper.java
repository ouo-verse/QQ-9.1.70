package com.tencent.mobileqq.aio.reserve1.navigation.view;

import android.graphics.Bitmap;
import android.os.Handler;
import androidx.annotation.MainThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rlottie.AXrLottieDrawable;

/* loaded from: classes11.dex */
public class LottiePlayHelper implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private AXrLottieDrawable f193358d;

    /* renamed from: e, reason: collision with root package name */
    private int f193359e;

    /* renamed from: f, reason: collision with root package name */
    private final Handler f193360f;

    /* renamed from: h, reason: collision with root package name */
    private a f193361h;

    /* loaded from: classes11.dex */
    public interface a {
        void a(int i3, Bitmap bitmap);
    }

    public LottiePlayHelper(Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) handler);
        } else {
            this.f193360f = handler;
        }
    }

    private void i() {
        com.tencent.rlottie.c e16 = e();
        if (e16 == null) {
            return;
        }
        int i3 = this.f193359e;
        this.f193359e = (i3 + 1) % this.f193358d.e0();
        if (e16.b()) {
            Bitmap a16 = e16.a();
            a aVar = this.f193361h;
            if (aVar != null) {
                aVar.a(i3, a16);
            }
        }
        this.f193360f.removeCallbacks(this);
        this.f193360f.postDelayed(this, 16L);
    }

    public com.tencent.rlottie.c e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.rlottie.c) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        AXrLottieDrawable aXrLottieDrawable = this.f193358d;
        if (aXrLottieDrawable == null) {
            return null;
        }
        return this.f193358d.c0(this.f193359e % aXrLottieDrawable.e0());
    }

    public void f(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        } else {
            this.f193361h = aVar;
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            stop();
            this.f193360f.post(this);
        }
    }

    @MainThread
    public void h(AXrLottieDrawable aXrLottieDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aXrLottieDrawable);
            return;
        }
        this.f193359e = 0;
        this.f193358d = aXrLottieDrawable;
        this.f193360f.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            i();
        }
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f193360f.removeCallbacks(this);
        }
    }
}
