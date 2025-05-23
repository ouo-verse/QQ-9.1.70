package com.tencent.tedger.outapi.jnishare;

import android.os.Handler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tedger.outapi.utils.a;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class TEdgeRSSharedBase {
    static IPatchRedirector $redirector_;
    private static final Handler gHandler;
    private final AtomicBoolean hasRelease;
    private long mNativePoint;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10267);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            gHandler = a.a("TEdgeRSSharedBase", -2, null, new a.C9901a());
        }
    }

    public TEdgeRSSharedBase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mNativePoint = 0L;
            this.hasRelease = new AtomicBoolean(false);
        }
    }

    private native long createNativePoint(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void releaseNativePoint(long j3);

    private void tryCreateNativePoint() {
        for (Class<?> cls = getClass(); this.mNativePoint == 0 && !cls.equals(TEdgeRSSharedBase.class); cls = cls.getSuperclass()) {
            this.mNativePoint = createNativePoint(cls.getSimpleName());
        }
        if (this.mNativePoint != 0) {
            return;
        }
        throw new RuntimeException("C++\u672a\u6ce8\u518cJava\u7c7b\uff1a" + getClass().getSimpleName());
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!this.hasRelease.get()) {
            long j3 = this.mNativePoint;
            if (j3 != 0) {
                Handler handler = gHandler;
                if (handler != null) {
                    handler.post(new Runnable(j3) { // from class: com.tencent.tedger.outapi.jnishare.TEdgeRSSharedBase.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ long f375276d;

                        {
                            this.f375276d = j3;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, TEdgeRSSharedBase.this, Long.valueOf(j3));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else if (TEdgeRSSharedBase.this.hasRelease.compareAndSet(false, true)) {
                                TEdgeRSSharedBase.releaseNativePoint(this.f375276d);
                            }
                        }
                    });
                    return;
                }
                return;
            }
        }
        super.finalize();
    }

    public long getNativePointAndCreateIfNecessary() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        synchronized (this) {
            long j3 = this.mNativePoint;
            if (j3 != 0) {
                return j3;
            }
            tryCreateNativePoint();
            return this.mNativePoint;
        }
    }

    public void releaseNativePoint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (this.mNativePoint != 0 && this.hasRelease.compareAndSet(false, true)) {
            releaseNativePoint(this.mNativePoint);
        }
    }

    protected TEdgeRSSharedBase(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
            return;
        }
        this.mNativePoint = 0L;
        this.hasRelease = new AtomicBoolean(false);
        this.mNativePoint = j3;
    }
}
