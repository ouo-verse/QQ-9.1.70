package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes27.dex */
public class TuringPhoneService {
    static IPatchRedirector $redirector_;

    /* renamed from: com.tencent.turingfd.sdk.xq.TuringPhoneService$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public class Cdo implements PhoneResp {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Canesatici f383140a;

        public Cdo(Canesatici canesatici) {
            this.f383140a = canesatici;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) canesatici);
            }
        }

        @Override // com.tencent.turingfd.sdk.xq.PhoneResp
        public long getErrorCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return this.f383140a.f382619a;
        }

        @Override // com.tencent.turingfd.sdk.xq.PhoneResp
        public String getPhoneMask() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f383140a.f382622d;
        }

        @Override // com.tencent.turingfd.sdk.xq.PhoneResp
        public String getPhoneToken() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f383140a.f382621c;
        }
    }

    public TuringPhoneService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static PhoneResp reqPhoneToken(boolean z16) {
        return reqPhoneToken(z16, null);
    }

    public static PhoneResp reqPhoneToken(boolean z16, String str) {
        Context context;
        FutureTask<Canesatici> futureTask;
        Pitaya pitaya;
        Canesatici canesatici;
        Canesatici canesatici2;
        String jSONObject;
        Strawberry strawberry;
        int a16 = i.a();
        if (a16 != 0) {
            Log.i("TuringDebug", "init error : " + a16);
            canesatici2 = new Canesatici(a16);
        } else {
            Bootes b16 = Bootes.f382613b.b();
            b16.getClass();
            synchronized (Celse.class) {
                context = Celse.f383328a;
            }
            if (!Bennet.c(context)) {
                canesatici2 = new Canesatici(-10012);
            } else {
                String valueOf = String.valueOf(3);
                if (!TextUtils.isEmpty(str)) {
                    valueOf = valueOf + ":" + str;
                }
                synchronized (b16.f382614a) {
                    Iterator<Map.Entry<String, FutureTask<Canesatici>>> it = b16.f382614a.entrySet().iterator();
                    while (it.hasNext()) {
                        if (it.next().getValue().isDone()) {
                            it.remove();
                        }
                    }
                    futureTask = b16.f382614a.get(valueOf);
                    if (futureTask != null && !futureTask.isDone()) {
                        pitaya = null;
                    }
                    Pitaya pitaya2 = new Pitaya(UUID.randomUUID().toString());
                    futureTask = new FutureTask<>(new Auriga(3, z16, str, pitaya2));
                    long currentTimeMillis = System.currentTimeMillis();
                    pitaya2.f383022d = currentTimeMillis;
                    pitaya2.a("EId_UId_GT_Start", currentTimeMillis);
                    Cstrictfp.f383431a.submit(futureTask);
                    b16.f382614a.put(valueOf, futureTask);
                    pitaya = pitaya2;
                }
                try {
                    synchronized (Strawberry.class) {
                        strawberry = Strawberry.C;
                    }
                    canesatici = futureTask.get(strawberry.f383102x, TimeUnit.MILLISECONDS);
                } catch (TimeoutException unused) {
                    canesatici = new Canesatici(-10004);
                } catch (Throwable unused2) {
                    canesatici = new Canesatici(-50006);
                }
                if (pitaya != null) {
                    pitaya.a("EId_UId_GT_End", pitaya.f383022d, canesatici.f382619a, canesatici.f382620b);
                    synchronized (pitaya.f383021c) {
                        jSONObject = pitaya.f383019a.toString();
                    }
                    Cstrictfp.f383431a.submit(new Caelum(b16, jSONObject));
                }
                canesatici2 = canesatici;
            }
        }
        return new Cdo(canesatici2);
    }
}
