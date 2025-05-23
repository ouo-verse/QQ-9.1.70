package com.tencent.paysdk.util;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ListenerMgr<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f342061b;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentLinkedQueue<WeakReference<T>> f342062a;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a<T> {
        void onNotify(T t16);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8255);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f342061b = false;
        }
    }

    public ListenerMgr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f342062a = new ConcurrentLinkedQueue<>();
        }
    }

    public void a(T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16);
            return;
        }
        if (t16 != null) {
            synchronized (this.f342062a) {
                Iterator<WeakReference<T>> it = this.f342062a.iterator();
                boolean z16 = false;
                while (it.hasNext()) {
                    T t17 = it.next().get();
                    if (t17 == null) {
                        it.remove();
                    } else if (t17 == t16) {
                        z16 = true;
                    }
                }
                if (!z16) {
                    this.f342062a.add(new WeakReference<>(t16));
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(a<T> aVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            return;
        }
        synchronized (this.f342062a) {
            if (this.f342062a.size() > 0) {
                concurrentLinkedQueue = new ConcurrentLinkedQueue(this.f342062a);
            } else {
                concurrentLinkedQueue = null;
            }
        }
        if (concurrentLinkedQueue != null) {
            try {
                Iterator it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    Object obj = ((WeakReference) it.next()).get();
                    if (obj != null) {
                        try {
                            aVar.onNotify(obj);
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                            Log.e("crash", th5.toString(), th5);
                            if (f342061b) {
                                new Handler(Looper.getMainLooper()).post(new Runnable(th5) { // from class: com.tencent.paysdk.util.ListenerMgr.1
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ Throwable f342063d;

                                    {
                                        this.f342063d = th5;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ListenerMgr.this, (Object) th5);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            iPatchRedirector2.redirect((short) 2, (Object) this);
                                            return;
                                        }
                                        throw new RuntimeException(this.f342063d);
                                    }
                                });
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void c(T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) t16);
            return;
        }
        if (t16 != null) {
            synchronized (this.f342062a) {
                Iterator<WeakReference<T>> it = this.f342062a.iterator();
                while (it.hasNext()) {
                    if (it.next().get() == t16) {
                        it.remove();
                        return;
                    }
                }
            }
        }
    }
}
