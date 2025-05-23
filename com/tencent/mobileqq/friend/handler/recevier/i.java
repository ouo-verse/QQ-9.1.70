package com.tencent.mobileqq.friend.handler.recevier;

import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_0x5e1$RspBody;
import tencent.im.oidb.oidb_0x5e1$UdcUinData;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes12.dex */
public class i extends g {
    static IPatchRedirector $redirector_;

    public i(@NonNull AppInterface appInterface, @NonNull FriendHandler friendHandler) {
        super(appInterface, friendHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface, (Object) friendHandler);
        }
    }

    @Override // com.tencent.mobileqq.friend.handler.recevier.g, com.tencent.mobileqq.friend.handler.recevier.a
    @NotNull
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "OidbSvc.0x5e1_414";
    }

    @Override // com.tencent.mobileqq.friend.handler.recevier.g, com.tencent.mobileqq.friend.handler.recevier.a
    public void e(@NotNull ToServiceMsg toServiceMsg, @NotNull FromServiceMsg fromServiceMsg, @Nullable Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
        } else {
            g(toServiceMsg, fromServiceMsg, (byte[]) obj);
        }
    }

    protected void g(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, byte[] bArr) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, bArr);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleResult ");
            sb5.append(fromServiceMsg.isSuccess());
            sb5.append(", ");
            if (bArr != null) {
                i3 = bArr.length;
            } else {
                i3 = -1;
            }
            sb5.append(i3);
            QLog.d("GetTroopMemberListReceiver", 2, sb5.toString());
        }
        HashSet hashSet = new HashSet();
        if (fromServiceMsg.isSuccess()) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom(bArr);
                QLog.d("GetTroopMemberListReceiver", 1, "[handleResult] has:" + oidb_sso_oidbssopkg.uint32_result.has() + ", result = " + oidb_sso_oidbssopkg.uint32_result.get());
                if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    oidb_0x5e1$RspBody oidb_0x5e1_rspbody = new oidb_0x5e1$RspBody();
                    oidb_0x5e1_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    for (oidb_0x5e1$UdcUinData oidb_0x5e1_udcuindata : oidb_0x5e1_rspbody.rpt_msg_uin_data.get()) {
                        if (oidb_0x5e1_udcuindata.uint32_allow.get() == 0 || oidb_0x5e1_udcuindata.uint32_allow.get() == 1) {
                            hashSet.add(Long.valueOf(oidb_0x5e1_udcuindata.uint64_uin.get()));
                        }
                    }
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("GetTroopMemberListReceiver", 2, "", th5);
                }
            }
        }
        d().notifyUI(129, false, hashSet);
    }
}
