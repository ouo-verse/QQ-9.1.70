package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingcam.eh5ma;
import com.tencent.turingcam.fenkF;
import com.tencent.turingcam.kWj12;
import com.tencent.turingface.sdk.mfa.i;

/* compiled from: P */
/* loaded from: classes27.dex */
public class l implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f382538a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f382539b;

    public l(h hVar, int i3) {
        this.f382539b = hVar;
        this.f382538a = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hVar, i3);
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
        synchronized (eh5ma.class) {
            context = eh5ma.f382207a;
        }
        if (!kWj12.c(context)) {
            return;
        }
        int i3 = 0;
        while (true) {
            String[] strArr = this.f382539b.f382513a;
            if (i3 < strArr.length) {
                try {
                    i.a aVar = new i.a(strArr[i3]);
                    int i16 = this.f382538a;
                    if (i16 > 0) {
                        aVar.f382524d = i16;
                    }
                    if (i16 > 0) {
                        aVar.f382525e = i16;
                    }
                    i iVar = new i(aVar);
                    fenkF.a(iVar, iVar.f382515a, iVar.f382517c);
                    this.f382539b.f382514b = i3;
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
