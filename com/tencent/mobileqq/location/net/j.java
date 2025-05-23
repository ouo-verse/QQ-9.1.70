package com.tencent.mobileqq.location.net;

import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.location.RoomOperate$ReqAssemblyPointOperation;
import tencent.im.oidb.location.RoomOperate$RspAssemblyPointOperation;
import tencent.im.oidb.location.qq_lbs_share$ResultInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class j extends a<LocationHandler> {
    static IPatchRedirector $redirector_;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void d(int i3, String str, int i16, int i17, LocationRoom.Venue venue) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        com.tencent.mobileqq.location.util.b.f(waitAppRuntime, i3, str, false);
        ((ILocationShareService) waitAppRuntime.getRuntimeService(ILocationShareService.class, "")).notifyStateError(i3, str, false);
        c().notifyUI(7, false, new Object[]{Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i3), str, venue});
    }

    private void f(int i3, int i16, long j3, LocationRoom.Venue venue) {
        if (QLog.isColorLevel()) {
            QLog.d("VenueOperateHandler", 2, "[venue] requestVenueOperate: invoked. ", "operateType: " + i3 + " [R_OPT_ADD = 1; R_OPT_UPDATE = 2; R_OPT_DELETE = 3;]", ", uinType: " + i16 + ", sessionUin: " + j3 + ", venue: " + venue);
        }
        RoomOperate$ReqAssemblyPointOperation roomOperate$ReqAssemblyPointOperation = new RoomOperate$ReqAssemblyPointOperation();
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        roomOperate$ReqAssemblyPointOperation.room_key.set(com.tencent.mobileqq.location.util.b.a(waitAppRuntime, i16, j3));
        roomOperate$ReqAssemblyPointOperation.room_key.setHasFlag(true);
        roomOperate$ReqAssemblyPointOperation.point_operation.set(i3);
        roomOperate$ReqAssemblyPointOperation.poi_name.set(ByteStringMicro.copyFrom(venue.f241271f.getBytes()));
        roomOperate$ReqAssemblyPointOperation.poi_address.set(ByteStringMicro.copyFrom(venue.f241272h.getBytes()));
        roomOperate$ReqAssemblyPointOperation.lat.set(venue.f241273i.latitude);
        roomOperate$ReqAssemblyPointOperation.lon.set(venue.f241273i.longitude);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", waitAppRuntime.getAccount(), "QQLBSShareSvc.assembly_point_operation");
        toServiceMsg.extraData.putInt("OPT_VENUE_TYPE", i3);
        toServiceMsg.extraData.putInt("uintype", i16);
        toServiceMsg.extraData.putString("uin", String.valueOf(j3));
        toServiceMsg.extraData.putParcelable("key_location_venue", venue);
        toServiceMsg.putWupBuffer(roomOperate$ReqAssemblyPointOperation.toByteArray());
        c().sendPbReq(toServiceMsg);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(LocationRoom.b bVar, LocationRoom.Venue venue) {
        if (bVar != null && venue != null) {
            f(1, bVar.b(), Long.parseLong(bVar.c()), venue);
        }
    }

    protected LocationHandler c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LocationHandler) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return LocationHandler.K2();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(LocationRoom.b bVar, LocationRoom.Venue venue) {
        if (bVar != null && venue != null) {
            f(3, bVar.b(), Long.parseLong(bVar.c()), venue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (a(toServiceMsg, fromServiceMsg, obj)) {
            try {
                int i3 = toServiceMsg.extraData.getInt("OPT_VENUE_TYPE");
                int i16 = toServiceMsg.extraData.getInt("uintype", -1);
                String string = toServiceMsg.extraData.getString("uin");
                LocationRoom.Venue venue = (LocationRoom.Venue) toServiceMsg.extraData.getParcelable("key_location_venue");
                qq_lbs_share$ResultInfo qq_lbs_share_resultinfo = new RoomOperate$RspAssemblyPointOperation().mergeFrom((byte[]) obj).msg_result.get();
                if (com.tencent.mobileqq.location.util.b.e(qq_lbs_share_resultinfo)) {
                    c().notifyUI(7, true, new Object[]{0, Integer.valueOf(i3), Integer.valueOf(i16), string, venue});
                } else {
                    d(i16, string, qq_lbs_share_resultinfo.uint32_result.get(), i3, venue);
                }
                return;
            } catch (Exception e16) {
                QLog.e("VenueOperateHandler", 1, "[venue] requestOperateRoomResp: failed. ", e16);
                return;
            }
        }
        if (fromServiceMsg != null) {
            int resultCode = fromServiceMsg.getResultCode();
            if (QLog.isColorLevel()) {
                QLog.d("VenueOperateHandler", 2, "[venue] requestOperateRoomResp: invoked. ", " resultCode: ", Integer.valueOf(resultCode));
            }
        }
        d(-2, "", -10001, -1, (LocationRoom.Venue) toServiceMsg.extraData.getParcelable("key_location_venue"));
    }
}
