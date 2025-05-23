package com.tencent.mobileqq.location.api.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.net.e;
import com.tencent.mobileqq.location.net.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.location.qq_lbs_share$PushExtInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x125.submsgtype0x125$MsgBody;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(long j3) {
        e.c().f241361e.k(0, String.valueOf(j3));
    }

    public static void c(submsgtype0x125$MsgBody submsgtype0x125_msgbody) {
        byte[] byteArray = submsgtype0x125_msgbody.bytes_ext_info.get().toByteArray();
        qq_lbs_share$PushExtInfo qq_lbs_share_pushextinfo = new qq_lbs_share$PushExtInfo();
        try {
            qq_lbs_share_pushextinfo.mergeFrom(byteArray);
            final long j3 = qq_lbs_share_pushextinfo.peer_uin.get();
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("location_push_room_member_9070_125029853", true)) {
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.location.api.impl.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.b(j3);
                    }
                }, 2000L);
            } else {
                e.c().f241361e.k(0, String.valueOf(j3));
            }
        } catch (Exception e16) {
            QLog.e("C2CLocationPushDecoder", 1, "onPushRoomMemberChanged: failed. ", e16);
        }
    }

    public static void d(submsgtype0x125$MsgBody submsgtype0x125_msgbody, int i3) {
        long j3 = submsgtype0x125_msgbody.uint64_oper_uin.get();
        byte[] byteArray = submsgtype0x125_msgbody.bytes_ext_info.get().toByteArray();
        qq_lbs_share$PushExtInfo qq_lbs_share_pushextinfo = new qq_lbs_share$PushExtInfo();
        try {
            qq_lbs_share_pushextinfo.mergeFrom(byteArray);
            long j16 = qq_lbs_share_pushextinfo.peer_uin.get();
            LocationRoom.b bVar = new LocationRoom.b(0, String.valueOf(j16));
            e.c().f241361e.k(0, String.valueOf(j16));
            switch (i3) {
                case 101:
                    f.b().c(bVar, String.valueOf(j3));
                    break;
                case 102:
                    f.b().f(bVar);
                    break;
                case 103:
                    f.b().e(bVar);
                    break;
            }
            if (QLog.isColorLevel()) {
                QLog.d("C2CLocationPushDecoder", 2, "[venue] c2c onPushRoomVenueChanged: invoked. roomKey: ", bVar + " opt: " + i3 + " optUin: " + j3);
            }
        } catch (Exception e16) {
            QLog.e("C2CLocationPushDecoder", 1, "[venue] c2c onPushRoomVenueChanged: failed. opt: " + i3 + " optUin: " + j3, e16);
        }
    }
}
