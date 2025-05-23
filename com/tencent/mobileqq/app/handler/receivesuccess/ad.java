package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ad {
    static IPatchRedirector $redirector_;

    public static void a(QQAppInterface qQAppInterface, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if ("OidbSvc.0x4ff_42024".equals(fromServiceMsg.getServiceCmd())) {
            boolean z16 = false;
            if (fromServiceMsg.getResultCode() == 1000) {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                try {
                    oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom(fromServiceMsg.getWupBuffer());
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
                if (oidb_sso_oidbssopkg.uint32_result.has()) {
                    int i3 = oidb_sso_oidbssopkg.uint32_result.get();
                    if (QLog.isColorLevel()) {
                        QLog.i("Q.msg.MessageHandler", 2, "handle_oidb_0x4ff_42024 ret=" + i3);
                    }
                    if (i3 == 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                        byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                        if (4 <= byteArray.length && !String.valueOf(PkgTools.getLongData(byteArray, 0)).equals(qQAppInterface.getAccount())) {
                            if (QLog.isColorLevel()) {
                                QLog.w("Q.msg.MessageHandler", 2, "handle_oidb_0x4ff_42024 uin error");
                                return;
                            }
                            return;
                        }
                        z16 = true;
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("Q.msg.MessageHandler", 2, "handle_oidb_0x4ff_42024 suc=" + z16);
            }
        }
    }
}
