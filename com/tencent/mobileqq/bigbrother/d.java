package com.tencent.mobileqq.bigbrother;

import android.support.v4.util.SparseArrayCompat;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static final d f200374c;

    /* renamed from: a, reason: collision with root package name */
    private final SparseArrayCompat<b> f200375a;

    /* renamed from: b, reason: collision with root package name */
    private int f200376b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44317);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f200374c = new d();
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f200375a = new SparseArrayCompat<>();
        }
    }

    public static d b() {
        return f200374c;
    }

    public int a(b bVar) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar)).intValue();
        }
        synchronized (this.f200375a) {
            while (true) {
                int i17 = this.f200376b + 1;
                this.f200376b = i17;
                if (this.f200375a.get(i17) == null && (i3 = this.f200376b) != 0) {
                    this.f200375a.put(i3, bVar);
                    i16 = this.f200376b;
                }
            }
        }
        return i16;
    }

    public void c(int i3, int i16) {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        synchronized (this.f200375a) {
            bVar = this.f200375a.get(i3);
        }
        if (bVar != null) {
            bVar.onJump(i3, i16);
        }
    }

    public void d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        synchronized (this.f200375a) {
            this.f200375a.delete(i3);
        }
    }
}
