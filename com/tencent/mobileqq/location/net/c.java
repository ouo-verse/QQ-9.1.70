package com.tencent.mobileqq.location.net;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.location.RoomOperate$UserData;
import tencent.im.oidb.location.qq_lbs_share$AssemblyPointData;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class c extends d {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private LocationRoom.Venue h(qq_lbs_share$AssemblyPointData qq_lbs_share_assemblypointdata) {
        int i3;
        String str;
        if (qq_lbs_share_assemblypointdata != null && (((i3 = qq_lbs_share_assemblypointdata.operation.get()) == 1 || i3 == 2) && qq_lbs_share_assemblypointdata.operator.get() > 0)) {
            LocationRoom.Venue venue = new LocationRoom.Venue();
            venue.f241270e = String.valueOf(qq_lbs_share_assemblypointdata.operator.get());
            venue.f241273i = new LatLng(qq_lbs_share_assemblypointdata.lat.get(), qq_lbs_share_assemblypointdata.lon.get());
            String str2 = "";
            if (!qq_lbs_share_assemblypointdata.poi_name.has()) {
                str = "";
            } else {
                str = qq_lbs_share_assemblypointdata.poi_name.get().toStringUtf8();
            }
            venue.f241271f = str;
            if (qq_lbs_share_assemblypointdata.poi_address.has()) {
                str2 = qq_lbs_share_assemblypointdata.poi_address.get().toStringUtf8();
            }
            venue.f241272h = str2;
            return venue;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.location.net.d
    protected void a(com.tencent.mobileqq.location.bean.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
            return;
        }
        int i3 = aVar.a().uint32_msg_type.get();
        if (QLog.isColorLevel()) {
            QLog.d("LocationObserver", 2, "decodeMsg: invoked. ", " optType: ", Integer.valueOf(i3));
        }
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            switch (i3) {
                case 101:
                case 102:
                case 103:
                    com.tencent.mobileqq.location.api.impl.b.d(aVar.a(), i3);
                    return;
                default:
                    return;
            }
        }
        com.tencent.mobileqq.location.api.impl.b.c(aVar.a());
    }

    @Override // com.tencent.mobileqq.location.net.d
    protected void b(com.tencent.mobileqq.location.bean.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        } else {
            LocationHandler.K2().L2(new LocationRoom.b(bVar.b(), bVar.c()), bVar.a());
        }
    }

    @Override // com.tencent.mobileqq.location.net.d
    protected void c(com.tencent.mobileqq.location.bean.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) cVar);
            return;
        }
        int i3 = 3;
        if (cVar.e()) {
            if (QLog.isColorLevel()) {
                QLog.d("LocationObserver", 2, "onOperateRoom: invoked. ", " uin: ", cVar.c(), " uinType: ", Integer.valueOf(cVar.d()), " optType: ", Integer.valueOf(cVar.b()));
            }
            e.c().f241361e.k(cVar.d(), cVar.c());
            e.c().f241361e.i(cVar.d(), cVar.c());
            if (QLog.isColorLevel()) {
                QLog.d("LocationObserver", 2, "onOperateRoom: invoked. real report invoked. ", " optType: ", Integer.valueOf(cVar.b()));
            }
            if (cVar.b() == 1) {
                LocationShareLocationManager.h().n(cVar.d(), cVar.c());
                ReportController.o(null, "CliOper", "", "", "0X800A764", "0X800A764", 0, 0, "", "0", "0", "");
            } else if (cVar.b() == 2) {
                LocationShareLocationManager.h().n(cVar.d(), cVar.c());
                if (e.c().d()) {
                    ReportController.o(null, "CliOper", "", "", "0X800A76B", "0X800A76B", LocationHandler.I2(LocationHandler.K2().H2()), 0, "", "0", "0", "");
                }
            }
            e.c().g(false);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationObserver", 2, "onOperateRoom: invoked. ", " errorCode: ", Integer.valueOf(cVar.a()));
        }
        LocationRoom.b bVar = new LocationRoom.b(cVar.d(), cVar.c());
        LocationShareLocationManager.h().o(bVar, true);
        LocationHandler.K2().M2(bVar, cVar.a(), cVar.b());
        if (cVar.a() != 10101) {
            if (cVar.a() != 10001 && cVar.a() != 10003 && cVar.a() != 10004 && cVar.a() != 10100) {
                i3 = 0;
            } else {
                i3 = 2;
            }
        }
        e.c().e(cVar.d(), cVar.c(), LocationHandler.K2().H2(), i3);
    }

    @Override // com.tencent.mobileqq.location.net.d
    @SuppressLint({"SimpleDateFormat"})
    protected void d(com.tencent.mobileqq.location.bean.d dVar) {
        ArrayList arrayList;
        String str;
        String str2;
        char c16;
        char c17;
        char c18;
        char c19;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
            return;
        }
        LocationRoom.Venue h16 = h(dVar.a().assembly_Point.get());
        List<RoomOperate$UserData> list = dVar.a().user_list.get();
        int i3 = dVar.a().room_state.get();
        String str3 = "LocationObserver";
        if (list.size() <= 0) {
            QLog.e("LocationObserver", 1, "[queryLocationRoom][error] onQueryRoom: invoked. sessionUin: ", dVar.c(), " roomState: ", Integer.valueOf(i3), " userDataList: ", Integer.valueOf(list.size()), " venue: ", h16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationObserver", 2, "[queryLocationRoom] onQueryRoom: invoked. sessionUin: ", dVar.c(), " userDataList: ", Integer.valueOf(list.size()), " venue: ", h16);
        }
        LocationRoom.b bVar = new LocationRoom.b(dVar.b(), dVar.c());
        LocationRoom J2 = LocationHandler.K2().J2(bVar);
        ArrayList arrayList2 = new ArrayList(20);
        for (RoomOperate$UserData roomOperate$UserData : list) {
            String valueOf = String.valueOf(roomOperate$UserData.uin.get());
            String str4 = str3;
            ArrayList arrayList3 = arrayList2;
            com.tencent.mobileqq.location.data.a aVar = new com.tencent.mobileqq.location.data.a(valueOf, new LatLng(roomOperate$UserData.lat.get(), roomOperate$UserData.lon.get()), roomOperate$UserData.direction.get());
            if (aVar.b().latitude == 0.0d && aVar.b().longitude == 0.0d) {
                com.tencent.mobileqq.location.data.a d16 = J2.d(valueOf);
                if (d16 != null) {
                    aVar.f(d16.b(), Double.valueOf(d16.c()));
                    arrayList = arrayList3;
                    arrayList.add(aVar);
                    str = "[filter]";
                } else {
                    arrayList = arrayList3;
                    str = "[killed]";
                }
            } else {
                arrayList = arrayList3;
                arrayList.add(aVar);
                str = "[data]";
            }
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[9];
                objArr[0] = "[queryLocationRoom]" + str + " onQueryRoom invoked  roomState == open: ";
                if (i3 == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                objArr[1] = Boolean.valueOf(z16);
                objArr[2] = " uin: ";
                c17 = 3;
                objArr[3] = valueOf;
                c18 = 4;
                objArr[4] = " locationItem: ";
                objArr[5] = aVar;
                c19 = 6;
                objArr[6] = " join: ";
                objArr[7] = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(roomOperate$UserData.join_time.get() * 1000));
                c16 = '\b';
                objArr[8] = " update: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(roomOperate$UserData.lbs_update_ts.get() * 1000));
                str2 = str4;
                QLog.d(str2, 2, objArr);
            } else {
                str2 = str4;
                c16 = '\b';
                c17 = 3;
                c18 = 4;
                c19 = 6;
            }
            str3 = str2;
            arrayList2 = arrayList;
        }
        LocationHandler.K2().P2(bVar, h16, arrayList2);
    }

    @Override // com.tencent.mobileqq.location.net.d
    protected void e(com.tencent.mobileqq.location.bean.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) eVar);
        } else {
            LocationHandler.K2().O2(new LocationRoom.b(eVar.a(), eVar.b()), -1);
        }
    }

    @Override // com.tencent.mobileqq.location.net.d
    protected void f(com.tencent.mobileqq.location.bean.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) fVar);
            return;
        }
        int i3 = fVar.a().f241281a;
        if (QLog.isColorLevel()) {
            QLog.d("LocationObserver", 2, "onTroopOptPush: invoked. ", " msgType: ", Integer.valueOf(i3));
        }
        if (i3 == 1) {
            i.a(fVar.a());
            return;
        }
        if (i3 == 2) {
            i.a(fVar.a());
            return;
        }
        if (i3 == 3) {
            i.a(fVar.a());
            return;
        }
        if (i3 == 101) {
            i.b(fVar.a(), i3);
        } else if (i3 == 102) {
            i.b(fVar.a(), i3);
        } else if (i3 == 103) {
            i.b(fVar.a(), i3);
        }
    }

    @Override // com.tencent.mobileqq.location.net.d
    protected void g(com.tencent.mobileqq.location.bean.g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) gVar);
            return;
        }
        f.b().d(new LocationRoom.b(gVar.d(), gVar.c()), gVar.e(), gVar.b(), gVar.f(), gVar.a());
        if (!gVar.f()) {
            if (QLog.isColorLevel()) {
                QLog.d("LocationObserver", 2, "[venue] onVenueOpt: invoked. failed ", " errorCode: ", Integer.valueOf(gVar.a()));
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("LocationObserver", 2, "[venue] onVenueOpt: invoked. success ", " uin: ", gVar.c(), " uinType: ", Integer.valueOf(gVar.d()), " optType: ", Integer.valueOf(gVar.b()));
            }
            e.c().f241361e.k(gVar.d(), gVar.c());
        }
    }

    @Override // com.tencent.mobileqq.location.net.d, com.tencent.mobileqq.app.BusinessObserver
    public /* bridge */ /* synthetic */ void onUpdate(int i3, boolean z16, Object obj) {
        super.onUpdate(i3, z16, obj);
    }
}
