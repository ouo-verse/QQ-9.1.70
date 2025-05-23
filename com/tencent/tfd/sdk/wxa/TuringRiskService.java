package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tfd.sdk.wxa.Solar;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TuringRiskService {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.TuringRiskService$do, reason: invalid class name */
    /* loaded from: classes26.dex */
    public class Cdo implements RiskDetectResp {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Taurus f375711a;

        public Cdo(Taurus taurus) {
            this.f375711a = taurus;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) taurus);
            }
        }

        @Override // com.tencent.tfd.sdk.wxa.RiskDetectResp
        public final String getDeviceToken() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f375711a.f375701b;
        }

        @Override // com.tencent.tfd.sdk.wxa.RiskDetectResp
        public final long getErrorCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return this.f375711a.f375700a;
        }
    }

    public TuringRiskService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static RiskDetectResp reqRiskDetectV2(Context context) {
        return reqRiskDetectV2(context, true);
    }

    public static RiskDetectResp reqRiskDetectV2(Context context, boolean z16) {
        Taurus taurus;
        Context context2;
        int a16 = Filbert.a();
        if (a16 != 0) {
            Log.i("TuringDebug", "init error : " + a16);
            taurus = new Taurus(a16);
        } else {
            Bryony bryony = Solar.f375694a;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                taurus = new Taurus(-10008);
            } else {
                Taurus a17 = Solar.a(context);
                if (!z16 && a17 != null && (a17.f375704e & 1) > 0) {
                    z16 = true;
                }
                if (!z16 || a17 == null) {
                    if (GalacticCore.b(context)) {
                        Solar.Cdo cdo = new Solar.Cdo(z16);
                        cdo.a();
                        long j3 = Solar.f375694a.f375482y;
                        AtomicReference<AtomicReference<Taurus>> atomicReference = Solar.Cdo.f375697d;
                        synchronized (atomicReference) {
                            AtomicReference<Taurus> atomicReference2 = cdo.f375699b;
                            if (atomicReference2 != null && atomicReference2.get() == null) {
                                try {
                                    atomicReference.wait(j3);
                                } catch (InterruptedException unused) {
                                }
                            }
                        }
                        AtomicReference<Taurus> atomicReference3 = cdo.f375699b;
                        taurus = atomicReference3 != null ? atomicReference3.get() : null;
                        if (taurus == null) {
                            synchronized (Cgoto.class) {
                                context2 = Cgoto.f375756a;
                            }
                            taurus = Solar.a(context2);
                            if (taurus == null) {
                                taurus = new Taurus(-10004);
                            }
                        }
                    } else if (a17 == null) {
                        taurus = new Taurus(-10012);
                    }
                } else if (Math.abs(System.currentTimeMillis() - a17.f375702c) >= a17.f375703d) {
                    new Solar.Cdo(true).a();
                }
                taurus = a17;
            }
        }
        return new Cdo(taurus);
    }
}
