package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TuringIDService {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.TuringIDService$do, reason: invalid class name */
    /* loaded from: classes26.dex */
    public class Cdo implements Ctransient {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ITuringDIDCallback f375710a;

        public Cdo(ITuringDIDCallback iTuringDIDCallback) {
            this.f375710a = iTuringDIDCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iTuringDIDCallback);
            }
        }

        public final void a(Cimplements cimplements) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cimplements);
            } else {
                this.f375710a.onResult(new Core(cimplements));
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
        Cantaloupe a16;
        int a17 = Filbert.a();
        if (a17 != 0) {
            a16 = Cantaloupe.a(a17);
        } else {
            a16 = Cherry.f375527h.a(context, true, 1);
        }
        return new Core(a16);
    }

    public static void getTuringDIDAsync(Context context, ITuringDIDCallback iTuringDIDCallback) {
        if (iTuringDIDCallback == null) {
            return;
        }
        Cdo cdo = new Cdo(iTuringDIDCallback);
        AtomicBoolean atomicBoolean = Filbert.f375609a;
        if (context.getApplicationContext() == null) {
            cdo.a(Cantaloupe.a(-10016));
            return;
        }
        int a16 = Filbert.a();
        if (a16 != 0) {
            cdo.a(Cantaloupe.a(a16));
        }
        new Fig(cdo, context).start();
    }

    public static ITuringDID getTuringDIDCached(Context context) {
        Cantaloupe a16;
        int a17 = Filbert.a();
        if (a17 != 0) {
            a16 = Cantaloupe.a(a17);
        } else {
            Cherry cherry = Cherry.f375527h;
            a16 = cherry.a(context);
            if (cherry.f375530a == null) {
                a16 = Cantaloupe.a(-10002);
            } else {
                int a18 = cherry.a(a16);
                if (a18 != 1) {
                    if (a18 == 2) {
                        cherry.a();
                        a16 = Cantaloupe.a(-10009);
                    } else if (a18 == 3) {
                        cherry.a();
                    }
                }
            }
        }
        return new Core(a16);
    }
}
