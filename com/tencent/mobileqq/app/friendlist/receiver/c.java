package com.tencent.mobileqq.app.friendlist.receiver;

import QQService.BindUinResult;
import QQService.SvcDevLoginInfo;
import QQService.SvcRespKikOut;
import QQService.SvcRspBindUin;
import QQService.SvcRspDelLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c extends a {
    static IPatchRedirector $redirector_;

    public c(QQAppInterface qQAppInterface, FriendListHandler friendListHandler) {
        super(qQAppInterface, friendListHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) friendListHandler);
        }
    }

    private void e(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, SvcRspBindUin svcRspBindUin) {
        ArrayList<BindUinResult> arrayList;
        if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "handlerBindUinStaus() success");
            }
            if (svcRspBindUin != null && (arrayList = svcRspBindUin.vecResult) != null) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    BindUinResult bindUinResult = arrayList.get(i3);
                    if (bindUinResult != null && QLog.isColorLevel()) {
                        QLog.d("SUB_ACCOUNT", 2, "result iResult = " + bindUinResult.iResult + "; lUin = " + bindUinResult.lUin + "; strResult = " + bindUinResult.strResult);
                    }
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerBindUinStaus res no success");
        }
    }

    private void f(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, SvcRspDelLoginInfo svcRspDelLoginInfo) {
        boolean z16;
        byte[] byteArray = toServiceMsg.extraData.getByteArray("devGuid");
        if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerDelMultiClient guid = " + byteArray);
        }
        if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            if (svcRspDelLoginInfo == null) {
                b(58, false, new Object[]{null, byteArray});
                return;
            }
            if (svcRspDelLoginInfo.iResult == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            b(58, z16, new Object[]{svcRspDelLoginInfo.strResult, byteArray});
            return;
        }
        if (svcRspDelLoginInfo == null) {
            b(58, false, new Object[]{null, byteArray});
        } else {
            b(58, false, new Object[]{svcRspDelLoginInfo.strResult, byteArray});
        }
    }

    private void g(ToServiceMsg toServiceMsg) {
        int i3 = toServiceMsg.extraData.getInt("index", -1);
        if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerDelMultiClient index = " + i3);
        }
    }

    private void h(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, SvcRespKikOut svcRespKikOut) {
        int i3 = toServiceMsg.extraData.getInt("index", -1);
        if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerKickOutDev index = " + i3);
        }
        if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            if (svcRespKikOut == null) {
                b(50, false, new Object[]{-1L, -1, Integer.valueOf(i3)});
                return;
            } else {
                b(50, true, new Object[]{Long.valueOf(svcRespKikOut.appid), Integer.valueOf(svcRespKikOut.result), Integer.valueOf(i3)});
                return;
            }
        }
        if (svcRespKikOut == null) {
            b(50, false, new Object[]{-1L, -1, Integer.valueOf(i3)});
        } else {
            b(50, false, new Object[]{-1L, -1, Integer.valueOf(i3)});
        }
    }

    private void i(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, SvcRspGetDevLoginInfo svcRspGetDevLoginInfo) {
        if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            if (svcRspGetDevLoginInfo == null) {
                b(56, false, null);
                return;
            }
            if (svcRspGetDevLoginInfo.iResult == 0) {
                ArrayList<SvcDevLoginInfo> arrayList = svcRspGetDevLoginInfo.vecCurrentLoginDevInfo;
                if (arrayList != null && arrayList.size() > 0) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= svcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size()) {
                            break;
                        }
                        SvcDevLoginInfo svcDevLoginInfo = svcRspGetDevLoginInfo.vecCurrentLoginDevInfo.get(i3);
                        if (svcDevLoginInfo != null) {
                            if (svcDevLoginInfo.vecGuid == null) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerLoginDevList info.vecGuid is null n =" + svcDevLoginInfo.strDeviceTypeInfo);
                                }
                            } else {
                                if (NetConnInfoCenter.GUID == null) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerLoginDevList NetConnInfoCenter.GUID is null");
                                    }
                                } else {
                                    try {
                                        if (QLog.isColorLevel()) {
                                            QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerLoginDevList NetConnInfoCenter.GUID =" + PkgTools.toHexStr(NetConnInfoCenter.GUID) + "; info.guid = " + PkgTools.toHexStr(svcDevLoginInfo.vecGuid));
                                        }
                                    } catch (Exception e16) {
                                        e16.printStackTrace();
                                    }
                                }
                                if (Arrays.equals(svcDevLoginInfo.vecGuid, NetConnInfoCenter.GUID)) {
                                    svcRspGetDevLoginInfo.vecCurrentLoginDevInfo.remove(i3);
                                    svcRspGetDevLoginInfo.vecCurrentLoginDevInfo.add(0, svcDevLoginInfo);
                                    if (QLog.isColorLevel()) {
                                        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerMultiClientList Arrays true");
                                    }
                                }
                            }
                        }
                        i3++;
                    }
                }
                b(56, true, svcRspGetDevLoginInfo);
                return;
            }
            b(56, false, null);
            return;
        }
        if (svcRspGetDevLoginInfo == null) {
            b(56, false, null);
        } else {
            b(56, false, null);
        }
    }

    private void j(FromServiceMsg fromServiceMsg, SvcRspGetDevLoginInfo svcRspGetDevLoginInfo) {
        if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            if (svcRspGetDevLoginInfo == null) {
                b(57, false, null);
                return;
            }
            if (svcRspGetDevLoginInfo.iResult == 0) {
                ArrayList<SvcDevLoginInfo> arrayList = svcRspGetDevLoginInfo.vecHistoryLoginDevInfo;
                if (arrayList != null && arrayList.size() > 0) {
                    boolean z16 = false;
                    for (int i3 = 0; i3 < svcRspGetDevLoginInfo.vecHistoryLoginDevInfo.size(); i3++) {
                        SvcDevLoginInfo svcDevLoginInfo = svcRspGetDevLoginInfo.vecHistoryLoginDevInfo.get(i3);
                        if (svcDevLoginInfo != null) {
                            if (svcDevLoginInfo.vecGuid == null) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerRecentLoginDevList info.vecGuid is null n =" + svcDevLoginInfo.strDeviceTypeInfo);
                                }
                            } else {
                                if (NetConnInfoCenter.GUID == null) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerRecentLoginDevList NetConnInfoCenter.GUID is null");
                                    }
                                } else {
                                    try {
                                        if (QLog.isColorLevel()) {
                                            QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerRecentLoginDevList NetConnInfoCenter.GUID =" + PkgTools.toHexStr(NetConnInfoCenter.GUID) + "; info.guid = " + PkgTools.toHexStr(svcDevLoginInfo.vecGuid));
                                        }
                                    } catch (Exception e16) {
                                        e16.printStackTrace();
                                    }
                                }
                                if ((System.currentTimeMillis() / 1000) - svcDevLoginInfo.iLoginTime < 2592000 && !z16 && svcDevLoginInfo.iTerType == 3) {
                                    b(98, true, null);
                                    z16 = true;
                                }
                            }
                        }
                    }
                }
                b(57, true, svcRspGetDevLoginInfo);
                return;
            }
            b(57, false, null);
            return;
        }
        if (svcRspGetDevLoginInfo == null) {
            b(57, false, null);
        } else {
            b(57, false, null);
        }
    }

    private boolean k(long j3) {
        if (j3 == 1) {
            return true;
        }
        return false;
    }

    private boolean l(long j3) {
        if (j3 == 3) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.friendlist.receiver.a
    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        if (!ProfileContants.CMD_REQ_RES_GET_DEVLOGININFO.equals(str) && !ProfileContants.CMD_REQ_RES_DEL_DEVLOGININFO.equals(str) && !ProfileContants.CMD_REQ_KICKOUT_DEV.equals(str) && !ProfileContants.CMD_REQ_BINDUIN_STATE.equals(str)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.friendlist.receiver.a
    public void c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (ProfileContants.CMD_REQ_RES_GET_DEVLOGININFO.equals(serviceCmd)) {
            long j3 = toServiceMsg.extraData.getLong("iGetDevListType");
            QLog.i("FriendListHandler.BaseHandlerReceiver", 1, "CMD_REQ_RES_GET_DEVLOGININFO=StatSvc.GetDevLoginInfo iGetDevListType=" + j3);
            if (k(j3)) {
                i(toServiceMsg, fromServiceMsg, (SvcRspGetDevLoginInfo) obj);
                return;
            }
            if (l(j3)) {
                j(fromServiceMsg, (SvcRspGetDevLoginInfo) obj);
                return;
            }
            QLog.e("FriendListHandler.BaseHandlerReceiver", 1, "error iGetDevListType=" + j3);
            return;
        }
        if (ProfileContants.CMD_REQ_RES_DEL_DEVLOGININFO.equals(serviceCmd)) {
            int i3 = toServiceMsg.extraData.getInt("iDelType");
            if (i3 == 1) {
                g(toServiceMsg);
                return;
            }
            if (i3 == 2) {
                f(toServiceMsg, fromServiceMsg, (SvcRspDelLoginInfo) obj);
                return;
            }
            QLog.e("FriendListHandler.BaseHandlerReceiver", 1, "error iDelType=" + i3);
            return;
        }
        if (ProfileContants.CMD_REQ_KICKOUT_DEV.equals(serviceCmd)) {
            h(toServiceMsg, fromServiceMsg, (SvcRespKikOut) obj);
        } else if (ProfileContants.CMD_REQ_BINDUIN_STATE.equals(serviceCmd)) {
            e(toServiceMsg, fromServiceMsg, (SvcRspBindUin) obj);
        }
    }
}
