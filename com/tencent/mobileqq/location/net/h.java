package com.tencent.mobileqq.location.net;

import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.location.RoomOperate$ReqRoomOperation;
import tencent.im.oidb.location.RoomOperate$RspRoomOperation;
import tencent.im.oidb.location.qq_lbs_share$ResultInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h extends a<LocationHandler> {
    static IPatchRedirector $redirector_;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void c(int i3, String str, int i16, int i17) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        com.tencent.mobileqq.location.util.b.f(waitAppRuntime, i3, str, false);
        ((ILocationShareService) waitAppRuntime.getRuntimeService(ILocationShareService.class, "")).notifyStateError(i3, str, false);
        b().notifyUI(1, false, new Object[]{Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i3), str});
    }

    private void d(int i3, int i16, long j3) {
        LatLng g16 = LocationShareLocationManager.h().g();
        if (QLog.isColorLevel()) {
            QLog.d("RoomOperateHandler", 2, "requestOperateRoom: invoked. ", "operateType = [" + i3 + "] ", " R_OPT_CREATE = 1; //\u521b\u5efa\u623f\u95f4", " R_OPT_JOIN = 2; //\u52a0\u5165", " R_OPT_QUIT = 3; //\u9000\u51fa\n", ", uinType = [", Integer.valueOf(i16), "], sessionUin = [", Long.valueOf(j3), "], location = [", g16, "]");
        }
        if (g16 == null) {
            return;
        }
        RoomOperate$ReqRoomOperation roomOperate$ReqRoomOperation = new RoomOperate$ReqRoomOperation();
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        roomOperate$ReqRoomOperation.room_key.set(com.tencent.mobileqq.location.util.b.a(waitAppRuntime, i16, j3));
        roomOperate$ReqRoomOperation.room_key.setHasFlag(true);
        roomOperate$ReqRoomOperation.room_operation.set(i3);
        if (com.tencent.mobileqq.location.util.d.a(MobileQQ.sMobileQQ.getApplicationContext())) {
            roomOperate$ReqRoomOperation.client_type.set(5);
        } else {
            roomOperate$ReqRoomOperation.client_type.set(2);
        }
        roomOperate$ReqRoomOperation.lat.set(g16.latitude);
        roomOperate$ReqRoomOperation.lon.set(g16.longitude);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", waitAppRuntime.getAccount(), "QQLBSShareSvc.room_operation");
        toServiceMsg.extraData.putInt("OPT_ROOM_TYPE", i3);
        toServiceMsg.extraData.putInt("uintype", i16);
        toServiceMsg.extraData.putString("uin", String.valueOf(j3));
        toServiceMsg.putWupBuffer(roomOperate$ReqRoomOperation.toByteArray());
        b().sendPbReq(toServiceMsg);
    }

    protected LocationHandler b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LocationHandler) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return LocationHandler.K2();
    }

    public void e(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        try {
            d(i3, i16, Long.parseLong(str));
        } catch (NumberFormatException e16) {
            QLog.e("RoomOperateHandler", 1, "requestOperateRoom: failed. ", e16);
        }
    }

    public void f(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (a(toServiceMsg, fromServiceMsg, obj)) {
            try {
                int i3 = toServiceMsg.extraData.getInt("OPT_ROOM_TYPE");
                int i16 = toServiceMsg.extraData.getInt("uintype", -1);
                String string = toServiceMsg.extraData.getString("uin");
                qq_lbs_share$ResultInfo qq_lbs_share_resultinfo = new RoomOperate$RspRoomOperation().mergeFrom((byte[]) obj).msg_result.get();
                if (com.tencent.mobileqq.location.util.b.e(qq_lbs_share_resultinfo)) {
                    b().notifyUI(1, true, new Object[]{0, Integer.valueOf(i3), Integer.valueOf(i16), string});
                } else {
                    c(i16, string, qq_lbs_share_resultinfo.uint32_result.get(), i3);
                }
                return;
            } catch (Exception e16) {
                QLog.e("RoomOperateHandler", 1, "requestOperateRoomResp: failed. ", e16);
                return;
            }
        }
        if (fromServiceMsg != null) {
            int resultCode = fromServiceMsg.getResultCode();
            if (QLog.isColorLevel()) {
                QLog.d("RoomOperateHandler", 2, "requestOperateRoomResp: invoked. ", " resultCode: ", Integer.valueOf(resultCode));
            }
        }
        c(-2, "", -10001, -1);
    }
}
