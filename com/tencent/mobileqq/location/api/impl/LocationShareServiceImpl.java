package com.tencent.mobileqq.location.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.mobileqq.location.callback.e;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.h;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.location.net.LocationShareLocationManager;
import com.tencent.mobileqq.location.net.i;
import com.tencent.mobileqq.location.ui.LocationShareFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.location.qq_lbs_share$PushExtInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x125.submsgtype0x125$MsgBody;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LocationShareServiceImpl implements ILocationShareService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "LocationShareServiceImpl";
    private List<e> shareLocationCallbacks;

    public LocationShareServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void onDecodeC2cLbsUserQuitRoom(AppRuntime appRuntime, long j3, long j16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onDecodeC2cLbsUserQuitRoom: invoked. ", " operateUin = [" + j3 + "], sessionUin = [" + j16 + "]");
        }
        if (j3 == appRuntime.getLongAccountUin()) {
            LocationShareLocationManager.h().o(new LocationRoom.b(0, String.valueOf(j16)), false);
        }
    }

    @Override // com.tencent.mobileqq.location.api.ILocationShareService
    public synchronized void addErrorShareStateCallback(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) eVar);
        } else {
            if (!this.shareLocationCallbacks.contains(eVar)) {
                this.shareLocationCallbacks.add(eVar);
            }
        }
    }

    @Override // com.tencent.mobileqq.location.api.ILocationShareService
    public void addLocationUpdateListener(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) hVar);
        } else {
            LocationHandler.K2().G2(hVar);
        }
    }

    @Override // com.tencent.mobileqq.location.api.ILocationShareService
    public boolean isCurrentUserSharing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return LocationShareLocationManager.h().i();
    }

    @Override // com.tencent.mobileqq.location.api.ILocationShareService
    public boolean isSessionSharingLocation(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, i3, (Object) str)).booleanValue();
        }
        return com.tencent.mobileqq.location.util.b.d(i3, str);
    }

    @Override // com.tencent.mobileqq.location.api.ILocationShareService
    public void launchShareUi(Activity activity, int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, activity, Integer.valueOf(i3), str, Integer.valueOf(i16));
        } else {
            LocationShareFragment.yh(activity, i3, str, i16);
        }
    }

    @Override // com.tencent.mobileqq.location.api.ILocationShareService
    public synchronized void notifyStateError(int i3, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), str, Boolean.valueOf(z16));
            return;
        }
        for (e eVar : this.shareLocationCallbacks) {
            eVar.b(i3, str, z16);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[callback] notifyStateError: invoked. ", " callback: ", eVar.getClass());
            }
        }
    }

    @Override // com.tencent.mobileqq.location.api.ILocationShareService
    public synchronized void notifyStateNormalClose(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        for (e eVar : this.shareLocationCallbacks) {
            eVar.c(i3, j3);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[callback] notifyStateNormalClose: invoked. ", " callback: ", eVar.getClass());
            }
        }
    }

    @Override // com.tencent.mobileqq.location.api.ILocationShareService
    public synchronized void notifyUserSwitchPhone(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        for (e eVar : this.shareLocationCallbacks) {
            eVar.a(i3, j3);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[callback] notifyUserSwitchPhone: invoked. ", " callback: ", eVar.getClass());
            }
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.shareLocationCallbacks = new ArrayList();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.shareLocationCallbacks.clear();
        }
    }

    @Override // com.tencent.mobileqq.location.api.ILocationShareService
    public void processC2CPush(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr);
            return;
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        submsgtype0x125$MsgBody submsgtype0x125_msgbody = new submsgtype0x125$MsgBody();
        if (bArr != null) {
            try {
                submsgtype0x125_msgbody.mergeFrom(bArr);
                byte[] byteArray = submsgtype0x125_msgbody.bytes_ext_info.get().toByteArray();
                qq_lbs_share$PushExtInfo qq_lbs_share_pushextinfo = new qq_lbs_share$PushExtInfo();
                qq_lbs_share_pushextinfo.mergeFrom(byteArray);
                long j3 = qq_lbs_share_pushextinfo.peer_uin.get();
                int i3 = qq_lbs_share_pushextinfo.client_type.get();
                int i16 = submsgtype0x125_msgbody.uint32_msg_type.get();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "processC2C: invoked. ", " optType: ", Integer.valueOf(i16));
                }
                if (i16 == 4) {
                    LocationHandler.K2().notifyUI(5, true, new Object[]{0, String.valueOf(j3)});
                    ((ILocationShareService) waitAppRuntime.getRuntimeService(ILocationShareService.class, "")).notifyStateNormalClose(0, j3);
                    com.tencent.mobileqq.location.util.b.f(waitAppRuntime, 0, String.valueOf(j3), false);
                } else {
                    if (i16 != 1 && i16 != 2) {
                        if (i16 == 5) {
                            LocationHandler.K2().notifyUI(6, true, new Object[]{0, String.valueOf(j3), Integer.valueOf(i3)});
                            ((ILocationShareService) waitAppRuntime.getRuntimeService(ILocationShareService.class, "")).notifyUserSwitchPhone(0, j3);
                        } else if (i16 == 3) {
                            onDecodeC2cLbsUserQuitRoom(waitAppRuntime, submsgtype0x125_msgbody.uint64_oper_uin.get(), j3);
                        }
                    }
                    com.tencent.mobileqq.location.util.b.f(waitAppRuntime, 0, String.valueOf(j3), true);
                }
                LocationHandler.K2().notifyUI(4, true, new Object[]{submsgtype0x125_msgbody});
            } catch (Exception e16) {
                QLog.e(TAG, 1, "processC2C: failed. ", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.location.api.ILocationShareService
    public void processTroopPush(com.tencent.mobileqq.location.data.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar);
        } else {
            i.c(MobileQQ.sMobileQQ.waitAppRuntime(null), bVar);
        }
    }

    @Override // com.tencent.mobileqq.location.api.ILocationShareService
    public synchronized void removeErrorShareStateCallback(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) eVar);
        } else {
            this.shareLocationCallbacks.remove(eVar);
        }
    }

    @Override // com.tencent.mobileqq.location.api.ILocationShareService
    public void removeLocationUpdateListener(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) hVar);
        } else {
            LocationHandler.K2().Q2(hVar);
        }
    }

    @Override // com.tencent.mobileqq.location.api.ILocationShareService
    public void requestOperateRoom(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
        } else {
            com.tencent.mobileqq.location.net.e.c().f241360d.e(i3, i16, str);
        }
    }

    @Override // com.tencent.mobileqq.location.api.ILocationShareService
    public void requestQueryRoom(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) str);
        } else {
            com.tencent.mobileqq.location.net.e.c().f241361e.k(i3, str);
        }
    }

    @Override // com.tencent.mobileqq.location.api.ILocationShareService
    public void stopLocationSharing(int i3, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), str, Boolean.valueOf(z16));
        } else {
            LocationShareLocationManager.h().o(new LocationRoom.b(i3, str), z16);
        }
    }
}
