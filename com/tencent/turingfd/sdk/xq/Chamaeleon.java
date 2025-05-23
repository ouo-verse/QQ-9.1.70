package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingfd.sdk.xq.ComaBerenices;
import com.tencent.turingfd.sdk.xq.Filbert;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Chamaeleon implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f382649a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ComaBerenices.Cdo f382650b;

    public Chamaeleon(ComaBerenices.Cdo cdo, int i3) {
        this.f382650b = cdo;
        this.f382649a = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cdo, i3);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        synchronized (Celse.class) {
            context = Celse.f383328a;
        }
        if (!Bennet.c(context)) {
            return;
        }
        int i3 = 0;
        while (true) {
            String[] strArr = this.f382650b.f382654a;
            if (i3 < strArr.length) {
                try {
                    Filbert.Cdo cdo = new Filbert.Cdo(strArr[i3]);
                    int i16 = this.f382649a;
                    if (i16 > 0) {
                        cdo.f382762f = i16;
                    }
                    if (i16 > 0) {
                        cdo.f382763g = i16;
                    }
                    Crux.a(new Filbert(cdo));
                    this.f382650b.f382655b = i3;
                    return;
                } catch (Throwable unused) {
                    i3++;
                }
            } else {
                return;
            }
        }
    }
}
