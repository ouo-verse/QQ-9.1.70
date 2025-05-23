package com.tencent.magicbrush.handler;

import androidx.annotation.Keep;
import com.tencent.luggage.wxa.w8.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class MainThreadHandler {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f147457a;

        /* renamed from: b, reason: collision with root package name */
        public long f147458b;

        /* renamed from: c, reason: collision with root package name */
        public long f147459c;

        public /* synthetic */ b(int i3, long j3, long j16, a aVar) {
            this(i3, j3, j16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            int i3 = this.f147457a;
            if (i3 <= 1) {
                MainThreadHandler.nativeDoTask(this.f147458b, this.f147459c);
            } else {
                MainThreadHandler.post(this.f147458b, this.f147459c, i3 - 1);
            }
        }

        public b(int i3, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            this.f147457a = i3;
            this.f147458b = j3;
            this.f147459c = j16;
        }
    }

    public MainThreadHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeDoTask(long j3, long j16);

    @Keep
    public static void post(long j3, long j16, int i3) {
        g.a().post(new b(i3, j3, j16, null));
    }
}
