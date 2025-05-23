package com.tencent.ams.mosaic.jsengine.common.thread;

import android.content.Context;
import android.os.Looper;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MosaicThread implements IMosaicThread {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Context f70892a;

    /* renamed from: b, reason: collision with root package name */
    private final com.tencent.ams.mosaic.jsengine.a f70893b;

    public MosaicThread(Context context, com.tencent.ams.mosaic.jsengine.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) aVar);
        } else {
            this.f70892a = context;
            this.f70893b = aVar;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.thread.IMosaicThread
    public IMosaicCountDownLatch createCountDownLatch(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (IMosaicCountDownLatch) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        return new a(i3);
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.thread.IMosaicThread
    public boolean isMainThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.thread.IMosaicThread
    public void runOnAsyncThread(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) jSFunction);
        } else if (jSFunction != null && this.f70893b != null) {
            MosaicUtils.G(new Runnable(jSFunction) { // from class: com.tencent.ams.mosaic.jsengine.common.thread.MosaicThread.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ JSFunction f70897d;

                {
                    this.f70897d = jSFunction;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MosaicThread.this, (Object) jSFunction);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        MosaicThread.this.f70893b.m(this.f70897d, null, null);
                    }
                }
            }, true);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.thread.IMosaicThread
    public void runOnUIThread(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSFunction);
        } else if (jSFunction != null && this.f70893b != null) {
            MosaicUtils.I(new Runnable(jSFunction) { // from class: com.tencent.ams.mosaic.jsengine.common.thread.MosaicThread.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ JSFunction f70894d;

                {
                    this.f70894d = jSFunction;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MosaicThread.this, (Object) jSFunction);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        MosaicThread.this.f70893b.p(this.f70894d, null, null);
                    }
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.thread.IMosaicThread
    public void runOnUIThreadAtFrontOfQueue(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSFunction);
        } else if (jSFunction != null && this.f70893b != null) {
            MosaicUtils.H(new Runnable(jSFunction) { // from class: com.tencent.ams.mosaic.jsengine.common.thread.MosaicThread.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ JSFunction f70895d;

                {
                    this.f70895d = jSFunction;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MosaicThread.this, (Object) jSFunction);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        MosaicThread.this.f70893b.p(this.f70895d, null, null);
                    }
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.thread.IMosaicThread
    public void runOnUIThreadDelay(JSFunction jSFunction, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, jSFunction, Long.valueOf(j3));
        } else if (jSFunction != null && this.f70893b != null) {
            MosaicUtils.J(new Runnable(jSFunction) { // from class: com.tencent.ams.mosaic.jsengine.common.thread.MosaicThread.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ JSFunction f70896d;

                {
                    this.f70896d = jSFunction;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MosaicThread.this, (Object) jSFunction);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        MosaicThread.this.f70893b.p(this.f70896d, null, null);
                    }
                }
            }, j3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.thread.IMosaicThread
    public void sleep(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
        } else {
            try {
                LockMethodProxy.sleep(j3);
            } catch (Throwable unused) {
            }
        }
    }
}
