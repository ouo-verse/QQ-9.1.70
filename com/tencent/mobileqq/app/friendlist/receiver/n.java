package com.tencent.mobileqq.app.friendlist.receiver;

import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class n extends a {
    static IPatchRedirector $redirector_;

    public n(QQAppInterface qQAppInterface, FriendListHandler friendListHandler) {
        super(qQAppInterface, friendListHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) friendListHandler);
        }
    }

    private void e(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        boolean isSuccess = fromServiceMsg.isSuccess();
        boolean z18 = true;
        if (isSuccess && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    ByteBuffer wrap = ByteBuffer.wrap(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    wrap.getInt();
                    if (wrap.get() != 0) {
                        z18 = false;
                    }
                    this.f195646a.setVisibilityForNetWorkStatus(z18, false);
                }
                z16 = z17;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("handleGetShowNetworkToFriendResp", 2, e16.getMessage());
                }
                z16 = false;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("FriendListHandler.BaseHandlerReceiver", 2, "get network switch isSuccess = " + z16 + "; isShowedToFriends = " + z18);
        }
        if (!z16) {
            z18 = this.f195646a.getVisibilityForNetWorkStatus(false);
        }
        b(74, z16, Boolean.valueOf(z18));
    }

    private void f(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17 = true;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z18 = toServiceMsg.extraData.getBoolean("key_show_to_friends", true);
        if (QLog.isColorLevel()) {
            QLog.i("FriendListHandler.BaseHandlerReceiver", 2, "set network switch isSuccess = " + z16 + "; isShowedToFriends = " + z18);
        }
        if (z16) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.get() != 0) {
                    z17 = false;
                }
                if (z17) {
                    this.f195646a.setVisibilityForNetWorkStatus(z18, false);
                }
                z16 = z17;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("handleSetShowNetworkToFriendResp", 2, e16.getMessage());
                }
                z16 = false;
            }
        }
        if (!z16) {
            z18 = this.f195646a.getVisibilityForNetWorkStatus(false);
        }
        b(73, z16, Boolean.valueOf(z18));
    }

    @Override // com.tencent.mobileqq.app.friendlist.receiver.a
    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        if (!"OidbSvc.0x491_107".equals(str) && !"OidbSvc.0x490_107".equals(str)) {
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
        if ("OidbSvc.0x491_107".equals(serviceCmd)) {
            f(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0x490_107".equals(serviceCmd)) {
            e(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
