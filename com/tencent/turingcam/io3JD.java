package com.tencent.turingcam;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class io3JD implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f382259a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f382260b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ T0QUa f382261c;

    public io3JD(T0QUa t0QUa, Context context, boolean z16, int i3) {
        this.f382261c = t0QUa;
        this.f382259a = context;
        this.f382260b = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, t0QUa, context, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        T0QUa t0QUa = this.f382261c;
        Context context = this.f382259a;
        int i16 = this.f382260b;
        t0QUa.f382056d.getClass();
        String b16 = XStYH.b(context, "403");
        if (!TextUtils.isEmpty(b16)) {
            z16 = Boolean.valueOf(b16).booleanValue();
            while (i3 < t0QUa.f382053a.f382234u) {
            }
            if (z16) {
            }
            synchronized (t0QUa.f382059g) {
            }
        } else {
            z16 = true;
            for (i3 = 0; i3 < t0QUa.f382053a.f382234u; i3++) {
                jfo8q a16 = t0QUa.a(context, true, z16, i16);
                t0QUa.a(a16, true);
                int i17 = a16.f382269c;
                if (i17 == 0 || i17 == -30014) {
                    break;
                }
            }
            if (z16) {
                XStYH xStYH = t0QUa.f382056d;
                xStYH.getClass();
                xStYH.a(context, "403", "false", true);
            }
            synchronized (t0QUa.f382059g) {
                t0QUa.f382059g.set(Boolean.FALSE);
                t0QUa.f382059g.notifyAll();
            }
        }
    }
}
