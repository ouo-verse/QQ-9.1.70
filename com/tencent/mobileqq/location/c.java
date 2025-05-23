package com.tencent.mobileqq.location;

import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c extends com.tencent.mobileqq.mvvm.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private LocationPickViewModelV2 f241238a;

    /* renamed from: b, reason: collision with root package name */
    private final h f241239b;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements h {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mobileqq.location.h
        public void a(LocationRoom.b bVar, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar, i3);
                return;
            }
            if (com.tencent.mobileqq.location.util.d.a(MobileQQ.sMobileQQ.getApplicationContext())) {
                i16 = 5;
            }
            if (i16 == i3) {
                return;
            }
            c.this.f241238a.S1(bVar);
        }

        @Override // com.tencent.mobileqq.location.h
        public void b(LocationRoom.b bVar, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar, i3);
            } else {
                c.this.f241238a.T1(bVar, i3);
            }
        }

        @Override // com.tencent.mobileqq.location.h
        public void c(LocationRoom.b bVar, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, bVar, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                c.this.f241238a.U1(bVar, i3, i16);
            }
        }

        @Override // com.tencent.mobileqq.location.h
        public void d(LocationRoom.b bVar, LocationRoom.Venue venue, List<com.tencent.mobileqq.location.data.a> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, bVar, venue, list);
            } else {
                c.this.f241238a.W1(bVar, venue, list);
            }
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f241239b = new a();
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            LocationHandler.K2().G2(this.f241239b);
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            LocationHandler.K2().Q2(this.f241239b);
        }
    }

    public void m(LocationPickViewModelV2 locationPickViewModelV2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) locationPickViewModelV2);
        } else {
            this.f241238a = locationPickViewModelV2;
        }
    }
}
