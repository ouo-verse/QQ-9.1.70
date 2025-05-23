package com.tencent.mobileqq.app.friendlist.receiver;

import com.tencent.ims.device_lock_recommend_auth$DeviceInfo;
import com.tencent.ims.device_lock_recommend_auth$RspBody;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b extends a {
    static IPatchRedirector $redirector_;

    public b(QQAppInterface qQAppInterface, FriendListHandler friendListHandler) {
        super(qQAppInterface, friendListHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) friendListHandler);
        }
    }

    @Override // com.tencent.mobileqq.app.friendlist.receiver.a
    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        if (!"DevLockAuthSvc.RecommendAuth".equals(str) && !"DevLockAuthSvc.ConfirmAuth".equals(str)) {
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
        if ("DevLockAuthSvc.RecommendAuth".equals(serviceCmd)) {
            e(fromServiceMsg, obj);
        } else {
            "DevLockAuthSvc.ConfirmAuth".equals(serviceCmd);
        }
    }

    public void e(FromServiceMsg fromServiceMsg, Object obj) {
        List<device_lock_recommend_auth$DeviceInfo> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "onReceive: onReceive handleRecommendDeviceList");
            }
            device_lock_recommend_auth$RspBody device_lock_recommend_auth_rspbody = new device_lock_recommend_auth$RspBody();
            try {
                device_lock_recommend_auth_rspbody.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "onReceive: onReceive sec_server package:sigResult parse fail");
                }
                e16.printStackTrace();
            }
            if (device_lock_recommend_auth_rspbody.uint64_uin.has()) {
                device_lock_recommend_auth_rspbody.uint64_uin.get();
            }
            if (device_lock_recommend_auth_rspbody.uint32_seq.has()) {
                device_lock_recommend_auth_rspbody.uint32_seq.get();
            }
            if (device_lock_recommend_auth_rspbody.uint32_ret.has()) {
                device_lock_recommend_auth_rspbody.uint32_ret.get();
            }
            if (device_lock_recommend_auth_rspbody.rpt_msg_devicelist.has()) {
                list = device_lock_recommend_auth_rspbody.rpt_msg_devicelist.get();
            } else {
                list = null;
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                try {
                    int size = list.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        device_lock_recommend_auth$DeviceInfo device_lock_recommend_auth_deviceinfo = list.get(i3);
                        if (device_lock_recommend_auth_deviceinfo != null) {
                            com.tencent.mobileqq.antiphing.b bVar = new com.tencent.mobileqq.antiphing.b();
                            if (device_lock_recommend_auth_deviceinfo.bytes_appname.has()) {
                                bVar.f194362d = new String(device_lock_recommend_auth_deviceinfo.bytes_appname.get().toByteArray(), "UTF-8");
                                if (device_lock_recommend_auth_deviceinfo.bytes_guid.has()) {
                                    bVar.f194361c = device_lock_recommend_auth_deviceinfo.bytes_guid.get().toByteArray();
                                    if (device_lock_recommend_auth_deviceinfo.bytes_device_typeinfo.has()) {
                                        bVar.f194360b = new String(device_lock_recommend_auth_deviceinfo.bytes_device_typeinfo.get().toByteArray(), "UTF-8");
                                        if (device_lock_recommend_auth_deviceinfo.bytes_device_name.has()) {
                                            bVar.f194359a = new String(device_lock_recommend_auth_deviceinfo.bytes_device_name.get().toByteArray(), "UTF-8");
                                            if (device_lock_recommend_auth_deviceinfo.uint32_auth_status.has()) {
                                                bVar.f194365g = device_lock_recommend_auth_deviceinfo.uint32_auth_status.get();
                                                if (device_lock_recommend_auth_deviceinfo.uint32_appid.has()) {
                                                    bVar.f194363e = device_lock_recommend_auth_deviceinfo.uint32_appid.get();
                                                    if (device_lock_recommend_auth_deviceinfo.uint32_subappid.has()) {
                                                        bVar.f194364f = device_lock_recommend_auth_deviceinfo.uint32_subappid.get();
                                                        arrayList.add(bVar);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
            if (arrayList.size() > 0) {
                this.f195647b.notifyUI(65, true, arrayList);
                return;
            }
        }
        this.f195647b.notifyUI(65, false, null);
    }
}
