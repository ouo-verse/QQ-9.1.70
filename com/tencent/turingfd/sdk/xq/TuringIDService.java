package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuringIDService {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.TuringIDService$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public class Cdo implements GalacticCore {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ITuringDIDCallback f383139a;

        public Cdo(ITuringDIDCallback iTuringDIDCallback) {
            this.f383139a = iTuringDIDCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iTuringDIDCallback);
            }
        }
    }

    public TuringIDService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static ITuringDID getTuringDID(Context context) {
        return new White(i.a(context));
    }

    public static void getTuringDIDAsync(Context context, ITuringDIDCallback iTuringDIDCallback) {
        if (iTuringDIDCallback == null) {
            return;
        }
        Cdo cdo = new Cdo(iTuringDIDCallback);
        AtomicBoolean atomicBoolean = i.f383364a;
        if (context.getApplicationContext() == null) {
            iTuringDIDCallback.onResult(new White(Sultana.a(-10016)));
            return;
        }
        int a16 = i.a();
        if (a16 != 0) {
            iTuringDIDCallback.onResult(new White(Sultana.a(a16)));
        }
        new g(cdo, context).start();
    }

    public static ITuringDID getTuringDIDCached(Context context) {
        Sultana a16;
        int a17 = i.a();
        if (a17 != 0) {
            a16 = Sultana.a(a17);
        } else {
            Vermillion vermillion = Vermillion.f383180l;
            a16 = vermillion.a(context);
            if (vermillion.f383183a == null) {
                a16 = Sultana.a(-10002);
            } else {
                int a18 = vermillion.a(a16);
                if (a18 != 1) {
                    if (a18 == 2) {
                        vermillion.a();
                        a16 = Sultana.a(-10009);
                    } else if (a18 == 3) {
                        vermillion.a();
                    }
                }
            }
        }
        return new White(a16);
    }
}
