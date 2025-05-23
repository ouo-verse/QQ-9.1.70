package com.tencent.mobileqq.qqperftool.crashdefend;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqperftool.crash.h;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.qqperftool.crash.g f274286a;

    public e(@NonNull com.tencent.mobileqq.qqperftool.crash.g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) gVar);
        } else {
            this.f274286a = gVar;
        }
    }

    public void a(Thread thread, com.tencent.mobileqq.qqperftool.crash.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) thread, (Object) bVar);
            return;
        }
        if (Looper.myLooper() == null) {
            try {
                thread.run();
                return;
            } catch (Throwable th5) {
                this.f274286a.b().b(new h(thread, th5));
                try {
                    thread.interrupt();
                    return;
                } catch (Throwable th6) {
                    this.f274286a.b().b(new h(thread, th6));
                    return;
                }
            }
        }
        while (true) {
            try {
                Looper.loop();
            } catch (Throwable th7) {
                if (!this.f274286a.a(thread, new h(thread, th7))) {
                    return;
                }
            }
        }
    }
}
