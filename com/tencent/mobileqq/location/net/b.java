package com.tencent.mobileqq.location.net;

import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final String f241353a;

    /* renamed from: b, reason: collision with root package name */
    final Map<LocationRoom.b, LocationRoom> f241354b;

    /* renamed from: c, reason: collision with root package name */
    final List<com.tencent.mobileqq.location.h> f241355c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f241354b = new LinkedHashMap();
        this.f241355c = new ArrayList();
        this.f241353a = str;
    }

    public void a(com.tencent.mobileqq.location.h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) hVar);
            return;
        }
        synchronized (this.f241355c) {
            if (!this.f241355c.contains(hVar)) {
                this.f241355c.add(hVar);
            }
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        synchronized (this.f241354b) {
            this.f241354b.clear();
        }
    }

    public LocationRoom c(LocationRoom.b bVar) {
        LocationRoom locationRoom;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LocationRoom) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        }
        synchronized (this.f241354b) {
            locationRoom = this.f241354b.get(bVar);
            if (locationRoom == null) {
                locationRoom = new LocationRoom(bVar, this.f241353a);
                this.f241354b.put(bVar, locationRoom);
            }
            if (QLog.isColorLevel()) {
                QLog.d("LocationDataHandler", 2, "getLocationRoom: invoked. mLocationRoomMap size: " + this.f241354b.size() + " locationRoom: " + locationRoom);
            }
        }
        return locationRoom;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(LocationRoom.b bVar, int i3) {
        synchronized (this.f241354b) {
            this.f241354b.remove(bVar);
        }
        Iterator<com.tencent.mobileqq.location.h> it = this.f241355c.iterator();
        while (it.hasNext()) {
            it.next().a(bVar, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(LocationRoom.b bVar, int i3, int i16) {
        Iterator<com.tencent.mobileqq.location.h> it = this.f241355c.iterator();
        while (it.hasNext()) {
            it.next().c(bVar, i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(LocationRoom.b bVar, int i3) {
        if (this.f241354b.containsKey(bVar)) {
            synchronized (this.f241354b) {
                this.f241354b.remove(bVar);
            }
            Iterator<com.tencent.mobileqq.location.h> it = this.f241355c.iterator();
            while (it.hasNext()) {
                it.next().b(bVar, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(LocationRoom.b bVar, LocationRoom.Venue venue, List<com.tencent.mobileqq.location.data.a> list) {
        LocationRoom c16 = c(bVar);
        c16.t(venue);
        c16.u(list);
        Iterator<com.tencent.mobileqq.location.h> it = this.f241355c.iterator();
        while (it.hasNext()) {
            it.next().d(bVar, venue, c16.e());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(LocationRoom.b bVar) {
        synchronized (this.f241354b) {
            LocationRoom locationRoom = this.f241354b.get(bVar);
            if (locationRoom != null && locationRoom.j() != null) {
                locationRoom.j().a();
            }
        }
    }

    public void i(com.tencent.mobileqq.location.h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) hVar);
            return;
        }
        synchronized (this.f241355c) {
            this.f241355c.remove(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(int i3, String str) {
        LocationRoom.b bVar = new LocationRoom.b(i3, str);
        LocationRoom c16 = c(bVar);
        if (c16 != null) {
            Iterator<com.tencent.mobileqq.location.h> it = this.f241355c.iterator();
            while (it.hasNext()) {
                it.next().d(bVar, c16.l(), c16.e());
            }
        }
    }
}
