package com.tencent.mobileqq.app.friendlist.receiver;

import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class o extends a {
    static IPatchRedirector $redirector_;

    public o(QQAppInterface qQAppInterface, FriendListHandler friendListHandler) {
        super(qQAppInterface, friendListHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) friendListHandler);
        }
    }

    private int e(ToServiceMsg toServiceMsg) {
        try {
            byte[] bArr = new byte[r3.getInt() - 4];
            ByteBuffer.wrap(toServiceMsg.getWupBuffer()).get(bArr);
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.mergeFrom(bArr);
            return oidb_sso_oidbssopkg.uint32_service_type.get();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "getServiceTypeFromToServiceMsg error:" + e16.getMessage());
            }
            return 0;
        }
    }

    private void f(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        e(toServiceMsg);
        Bundle bundle = new Bundle();
        bundle.putLong("uin", toServiceMsg.extraData.getLong("uin"));
        if (obj != null && fromServiceMsg.isSuccess()) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    ByteBuffer wrap = ByteBuffer.wrap(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    wrap.getInt();
                    wrap.getShort();
                    byte[] bArr = new byte[4];
                    wrap.get(bArr);
                    long d16 = Utils.d(bArr, 0);
                    int i3 = wrap.get() & 31;
                    bundle.putLong("uin", d16);
                    bundle.putInt(FriendListHandler.KEY_SAFETY_FLAG, i3);
                    b(67, true, bundle);
                    return;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handle_oidb_0x476 error:" + e16.getMessage());
                }
            }
            b(67, false, bundle);
            return;
        }
        b(67, false, bundle);
    }

    @Override // com.tencent.mobileqq.app.friendlist.receiver.a
    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        return "OidbSvc.0x476_146".equals(str);
    }

    @Override // com.tencent.mobileqq.app.friendlist.receiver.a
    public void c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
        } else {
            f(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
