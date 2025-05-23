package com.tencent.turingcam;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class o4LU5 implements LocationListener {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static final IyjbE<o4LU5> f382325c;

    /* renamed from: a, reason: collision with root package name */
    public final ShGzN[] f382326a;

    /* renamed from: b, reason: collision with root package name */
    public volatile int f382327b;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ShGzN {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f382328a;

        /* renamed from: b, reason: collision with root package name */
        public String f382329b;

        public ShGzN() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class spXPg extends IyjbE<o4LU5> {
        static IPatchRedirector $redirector_;

        public spXPg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.tencent.turingcam.o4LU5, java.lang.Object] */
        @Override // com.tencent.turingcam.IyjbE
        public o4LU5 a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new o4LU5();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17961);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f382325c = new spXPg();
        }
    }

    public o4LU5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f382326a = new ShGzN[3];
            this.f382327b = 0;
        }
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        synchronized (this.f382326a) {
            int i3 = this.f382327b;
            do {
                ShGzN shGzN = this.f382326a[i3];
                if (shGzN == null) {
                    break;
                }
                if (sb5.length() > 0) {
                    sb5.append(",");
                }
                sb5.append(shGzN.f382328a);
                sb5.append(":");
                sb5.append(shGzN.f382329b);
                i3--;
                if (i3 < 0) {
                    i3 = this.f382326a.length - 1;
                }
            } while (i3 != this.f382327b);
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
        synchronized (this.f382326a) {
            ShGzN shGzN = this.f382326a[this.f382327b];
            if (shGzN == null) {
                shGzN = new ShGzN();
                this.f382326a[this.f382327b] = shGzN;
            }
            this.f382327b = (this.f382327b + 1) % this.f382326a.length;
            shGzN.f382328a = System.currentTimeMillis();
            shGzN.f382329b = location.getProvider();
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
