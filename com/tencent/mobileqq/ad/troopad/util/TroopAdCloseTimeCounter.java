package com.tencent.mobileqq.ad.troopad.util;

import android.os.Handler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TroopAdCloseTimeCounter {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ad.troopad.util.TroopAdCloseTimeCounter$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ TroopAdCloseTimeCounter this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            long a16 = TroopAdCloseTimeCounter.a(null) - TroopAdCloseTimeCounter.b(null);
            if (a16 < TroopAdCloseTimeCounter.d(null)) {
                a16 = 0;
            }
            TroopAdCloseTimeCounter.e(null);
            if (a16 <= 0) {
                return;
            }
            TroopAdCloseTimeCounter.c(null, TroopAdCloseTimeCounter.d(null));
            TroopAdCloseTimeCounter.f(null).postDelayed(this, TroopAdCloseTimeCounter.d(null));
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface a {
    }

    static /* synthetic */ long a(TroopAdCloseTimeCounter troopAdCloseTimeCounter) {
        throw null;
    }

    static /* synthetic */ long b(TroopAdCloseTimeCounter troopAdCloseTimeCounter) {
        throw null;
    }

    static /* synthetic */ long c(TroopAdCloseTimeCounter troopAdCloseTimeCounter, long j3) {
        throw null;
    }

    static /* synthetic */ long d(TroopAdCloseTimeCounter troopAdCloseTimeCounter) {
        throw null;
    }

    static /* synthetic */ a e(TroopAdCloseTimeCounter troopAdCloseTimeCounter) {
        throw null;
    }

    static /* synthetic */ Handler f(TroopAdCloseTimeCounter troopAdCloseTimeCounter) {
        throw null;
    }
}
