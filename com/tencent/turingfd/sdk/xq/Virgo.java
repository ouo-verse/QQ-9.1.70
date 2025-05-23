package com.tencent.turingfd.sdk.xq;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Virgo implements LocationListener {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static final Peach<Virgo> f383193c;

    /* renamed from: a, reason: collision with root package name */
    public final Cif[] f383194a;

    /* renamed from: b, reason: collision with root package name */
    public volatile int f383195b;

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.Virgo$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public class Cdo extends Peach<Virgo> {
        static IPatchRedirector $redirector_;

        public Cdo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, com.tencent.turingfd.sdk.xq.Virgo] */
        @Override // com.tencent.turingfd.sdk.xq.Peach
        public Virgo a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new Virgo();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.Virgo$if, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static class Cif {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f383196a;

        /* renamed from: b, reason: collision with root package name */
        public String f383197b;

        public Cif() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13321);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f383193c = new Cdo();
        }
    }

    public Virgo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f383194a = new Cif[3];
            this.f383195b = 0;
        }
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        synchronized (this.f383194a) {
            int i3 = this.f383195b;
            do {
                Cif cif = this.f383194a[this.f383195b];
                if (cif == null) {
                    break;
                }
                if (sb5.length() > 0) {
                    sb5.append(",");
                }
                sb5.append(cif.f383196a);
                sb5.append(":");
                sb5.append(cif.f383197b);
                i3 = (i3 + 1) % this.f383194a.length;
            } while (i3 != this.f383195b);
        }
        if (sb5.length() > 0) {
            return sb5.toString();
        }
        return null;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) location);
            return;
        }
        if (location == null || !location.isFromMockProvider()) {
            return;
        }
        synchronized (this.f383194a) {
            Cif cif = this.f383194a[this.f383195b];
            if (cif == null) {
                cif = new Cif();
                this.f383194a[this.f383195b] = cif;
            }
            this.f383195b = (this.f383195b + 1) % this.f383194a.length;
            cif.f383196a = System.currentTimeMillis();
            cif.f383197b = location.getProvider();
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), bundle);
        }
    }
}
