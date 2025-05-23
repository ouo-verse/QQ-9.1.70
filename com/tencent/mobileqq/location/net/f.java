package com.tencent.mobileqq.location.net;

import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static volatile f f241362c;

    /* renamed from: a, reason: collision with root package name */
    private j f241363a;

    /* renamed from: b, reason: collision with root package name */
    private a f241364b;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
        void a(LocationRoom.b bVar, LocationRoom.Venue venue, int i3, boolean z16, int i16);

        Pair<LocationRoom.b, LocationRoom.Venue> b();
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f241363a = new j();
        }
    }

    public static f b() {
        if (f241362c == null) {
            synchronized (f.class) {
                if (f241362c == null) {
                    f241362c = new f();
                }
            }
        }
        return f241362c;
    }

    public void a(LocationRoom.b bVar, LocationRoom.Venue venue, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, bVar, venue, aVar);
            return;
        }
        if ((bVar == null || venue == null) && aVar != null) {
            aVar.a(bVar, venue, 1, false, -1);
            return;
        }
        if (aVar != null) {
            this.f241364b = aVar;
        }
        this.f241363a.b(bVar, venue);
    }

    public void c(LocationRoom.b bVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar, (Object) str);
            return;
        }
        LocationRoom J2 = LocationHandler.K2().J2(bVar);
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (J2.n() && !appInterface.getAccount().equals(str)) {
            QQToast.makeText(BaseApplication.getContext(), R.string.hh9, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(LocationRoom.b bVar, LocationRoom.Venue venue, int i3, boolean z16, int i16) {
        Pair<LocationRoom.b, LocationRoom.Venue> b16;
        a aVar = this.f241364b;
        if (aVar != null && (b16 = aVar.b()) != null && bVar.equals(b16.first) && venue.equals(b16.second)) {
            this.f241364b.a(bVar, venue, i3, z16, i16);
            this.f241364b = null;
        }
    }

    public void e(LocationRoom.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bVar);
        } else if (LocationHandler.K2().J2(bVar).n()) {
            QQToast.makeText(BaseApplication.getContext(), R.string.hh_, 0).show();
        }
    }

    public void f(LocationRoom.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar);
        } else if (LocationHandler.K2().J2(bVar).n()) {
            QQToast.makeText(BaseApplication.getContext(), R.string.hha, 0).show();
        }
    }

    public void g(LocationRoom.b bVar, LocationRoom.Venue venue, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, bVar, venue, aVar);
            return;
        }
        if ((bVar == null || venue == null) && aVar != null) {
            aVar.a(bVar, venue, 3, false, -1);
            return;
        }
        if (aVar != null) {
            this.f241364b = aVar;
        }
        this.f241363a.e(bVar, venue);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        this.f241363a.g(toServiceMsg, fromServiceMsg, obj);
    }
}
