package com.tencent.turingfd.sdk.xq;

import android.app.Activity;
import android.content.Context;
import android.location.LocationListener;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuringRiskService {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.TuringRiskService$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public class Cdo implements RiskDetectResp {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Haw f383141a;

        public Cdo(Haw haw) {
            this.f383141a = haw;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) haw);
            }
        }

        @Override // com.tencent.turingfd.sdk.xq.RiskDetectResp
        public String getDeviceToken() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f383141a.f382808b;
        }

        @Override // com.tencent.turingfd.sdk.xq.RiskDetectResp
        public long getErrorCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return this.f383141a.f382807a;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.TuringRiskService$if, reason: invalid class name */
    /* loaded from: classes27.dex */
    public class Cif implements RiskDetectResp {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Haw f383142a;

        public Cif(Haw haw) {
            this.f383142a = haw;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) haw);
            }
        }

        @Override // com.tencent.turingfd.sdk.xq.RiskDetectResp
        public String getDeviceToken() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f383142a.f382808b;
        }

        @Override // com.tencent.turingfd.sdk.xq.RiskDetectResp
        public long getErrorCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return this.f383142a.f382807a;
        }
    }

    public TuringRiskService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static LocationListener getLocationListener() {
        return Virgo.f383193c.b();
    }

    public static RiskDetectResp reqRiskDetectV2(Context context) {
        return reqRiskDetectV2(context, true);
    }

    public static RiskDetectResp reqRiskDetectWithParam(Context context, Map<Integer, String> map) {
        Haw a16;
        int a17 = i.a();
        if (a17 != 0) {
            Log.i("TuringDebug", "init error : " + a17);
            a16 = new Haw(a17);
        } else {
            a16 = Guava.a(context, map, 0, 0L);
        }
        return new Cif(a16);
    }

    public static boolean screenProtect(Activity activity) {
        try {
            activity.getWindow().addFlags(8192);
            return true;
        } catch (Throwable th5) {
            Log.e("", "screenProtect fail", th5);
            return false;
        }
    }

    public static boolean screenUnProtect(Activity activity) {
        try {
            activity.getWindow().clearFlags(8192);
            return true;
        } catch (Throwable th5) {
            Log.e("", "screenUnProtect fail", th5);
            return false;
        }
    }

    public static RiskDetectResp reqRiskDetectV2(Context context, boolean z16) {
        return new Cdo(i.a(context, z16));
    }
}
