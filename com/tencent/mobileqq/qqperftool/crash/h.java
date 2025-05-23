package com.tencent.mobileqq.qqperftool.crash;

import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes17.dex */
public class h extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private long f274264b;

    /* renamed from: c, reason: collision with root package name */
    private String f274265c;

    /* renamed from: d, reason: collision with root package name */
    private String f274266d;

    /* renamed from: e, reason: collision with root package name */
    private String f274267e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<Thread> f274268f;

    public h(@NonNull Thread thread, @NonNull Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) thread, (Object) th5);
            return;
        }
        this.f274264b = -1L;
        this.f274268f = null;
        this.f274264b = thread.getId();
        this.f274265c = th5.getClass().getName();
        this.f274266d = Log.getStackTraceString(th5);
        this.f274268f = new WeakReference<>(thread);
    }

    @Override // com.tencent.mobileqq.qqperftool.crash.b
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return super.a();
    }

    @Override // com.tencent.mobileqq.qqperftool.crash.b
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f274265c;
    }

    @Override // com.tencent.mobileqq.qqperftool.crash.b
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f274266d;
    }

    @Override // com.tencent.mobileqq.qqperftool.crash.b
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.qqperftool.crash.b
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f274267e;
    }

    @Override // com.tencent.mobileqq.qqperftool.crash.b
    public long h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.f274264b;
    }
}
