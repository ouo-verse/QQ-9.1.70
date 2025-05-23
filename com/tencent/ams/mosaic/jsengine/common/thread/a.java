package com.tencent.ams.mosaic.jsengine.common.thread;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements IMosaicCountDownLatch {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private CountDownLatch f70898a;

    public a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.f70898a = new CountDownLatch(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.thread.IMosaicCountDownLatch
    public void await() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            try {
                this.f70898a.await();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.thread.IMosaicCountDownLatch
    public boolean awaitUntil(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, j3)).booleanValue();
        }
        try {
            return !this.f70898a.await(j3, TimeUnit.MILLISECONDS);
        } catch (Throwable unused) {
            return true;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.thread.IMosaicCountDownLatch
    public void countDown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f70898a.countDown();
        }
    }
}
