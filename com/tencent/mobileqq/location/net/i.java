package com.tencent.mobileqq.location.net;

import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import tencent.im.oidb.location.qq_lbs_share$PushExtInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class i {
    static IPatchRedirector $redirector_;

    public static void a(com.tencent.mobileqq.location.data.b bVar) {
        long j3 = bVar.f241282b;
        e.c().f241361e.k(1, String.valueOf(j3));
        if (QLog.isColorLevel()) {
            QLog.d("TroopLocationPushDecoder", 2, "onPushRoomMemberChanged: invoked. ", " troopUin: ", Long.valueOf(j3));
        }
    }

    public static void b(com.tencent.mobileqq.location.data.b bVar, int i3) {
        long j3 = bVar.f241282b;
        long j16 = bVar.f241283c;
        LocationRoom.b bVar2 = new LocationRoom.b(1, String.valueOf(j3));
        e.c().f241361e.k(1, String.valueOf(j3));
        switch (i3) {
            case 101:
                f.b().c(bVar2, String.valueOf(j16));
                break;
            case 102:
                f.b().f(bVar2);
                break;
            case 103:
                f.b().e(bVar2);
                break;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopLocationPushDecoder", 2, "[venue] troop onPushRoomVenueChanged: invoked. roomKey: ", bVar2 + " opt: " + i3 + " optUin: " + j16);
        }
    }

    public static void c(AppRuntime appRuntime, com.tencent.mobileqq.location.data.b bVar) {
        long j3 = bVar.f241282b;
        int i3 = bVar.f241281a;
        int i16 = 4;
        if (i3 == 4) {
            LocationHandler.K2().notifyUI(5, true, new Object[]{1, String.valueOf(j3)});
            ((ILocationShareService) appRuntime.getRuntimeService(ILocationShareService.class, "")).notifyStateNormalClose(1, j3);
            com.tencent.mobileqq.location.util.b.f(appRuntime, 1, String.valueOf(j3), false);
        } else if (i3 != 1 && i3 != 2) {
            if (i3 == 5) {
                try {
                    byte[] bArr = bVar.f241284d;
                    qq_lbs_share$PushExtInfo qq_lbs_share_pushextinfo = new qq_lbs_share$PushExtInfo();
                    qq_lbs_share_pushextinfo.mergeFrom(bArr);
                    i16 = qq_lbs_share_pushextinfo.client_type.get();
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
                LocationHandler.K2().notifyUI(6, true, new Object[]{1, String.valueOf(j3), Integer.valueOf(i16)});
                ((ILocationShareService) appRuntime.getRuntimeService(ILocationShareService.class, "")).notifyUserSwitchPhone(1, j3);
            } else if (i3 == 3) {
                long j16 = bVar.f241283c;
                if (QLog.isColorLevel()) {
                    QLog.d("TroopLocationPushDecoder", 2, "onDecodeTroopLbsUserQuitRoom: invoked. ", " operateUin: ", Long.valueOf(j16), " sessionUin: ", Long.valueOf(j3));
                }
                if (j16 == appRuntime.getLongAccountUin()) {
                    LocationShareLocationManager.h().o(new LocationRoom.b(1, String.valueOf(j3)), false);
                }
            }
        } else {
            com.tencent.mobileqq.location.util.b.f(appRuntime, 1, String.valueOf(j3), true);
        }
        LocationHandler.K2().notifyUI(3, true, new Object[]{bVar});
    }
}
