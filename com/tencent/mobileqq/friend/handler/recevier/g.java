package com.tencent.mobileqq.friend.handler.recevier;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_0x5e1$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes12.dex */
public class g extends a<FriendHandler> {
    static IPatchRedirector $redirector_;

    public g(@NotNull AppInterface appInterface, @NotNull FriendHandler friendHandler) {
        super(appInterface, friendHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface, (Object) friendHandler);
        }
    }

    @Override // com.tencent.mobileqq.friend.handler.recevier.a
    @NotNull
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "OidbSvc.0x5e1_8";
    }

    @Override // com.tencent.mobileqq.friend.handler.recevier.a
    public void e(@NotNull ToServiceMsg toServiceMsg, @NotNull FromServiceMsg fromServiceMsg, @Nullable Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
        } else {
            f(toServiceMsg, fromServiceMsg, (byte[]) obj);
        }
    }

    protected void f(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, byte[] bArr) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, bArr);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleInfoOpenId ");
            sb5.append(fromServiceMsg.isSuccess());
            sb5.append(", ");
            if (bArr != null) {
                i3 = bArr.length;
            } else {
                i3 = -1;
            }
            sb5.append(i3);
            QLog.d("GetInfoWithOpenIdReceiver", 2, sb5.toString());
        }
        Bundle bundle = toServiceMsg.extraData;
        boolean z16 = false;
        if (fromServiceMsg.isSuccess()) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom(bArr);
                if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    oidb_0x5e1$RspBody oidb_0x5e1_rspbody = new oidb_0x5e1$RspBody();
                    oidb_0x5e1_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    if (oidb_0x5e1_rspbody.rpt_msg_uin_data.size() > 0) {
                        String str = new String(oidb_0x5e1_rspbody.rpt_msg_uin_data.get(0).bytes_nick.get().toByteArray());
                        bundle.putString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, str);
                        if (QLog.isColorLevel()) {
                            QLog.d("GetInfoWithOpenIdReceiver", 2, "handleInfoOpenId " + str);
                        }
                        z16 = true;
                    }
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("GetInfoWithOpenIdReceiver", 2, "", th5);
                }
            }
        }
        d().notifyUI(71, z16, bundle);
    }
}
