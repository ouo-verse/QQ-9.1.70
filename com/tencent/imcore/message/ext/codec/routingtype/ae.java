package com.tencent.imcore.message.ext.codec.routingtype;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc$RoutingHead;
import msf.msgsvc.msg_svc$WPATmp;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ae implements com.tencent.imcore.message.core.codec.d<AppInterface> {
    static IPatchRedirector $redirector_;

    public ae() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.core.codec.d
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 7000;
    }

    @Override // com.tencent.imcore.message.core.codec.d
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.imcore.message.core.codec.d
    public boolean c(msg_svc$RoutingHead msg_svc_routinghead, MessageRecord messageRecord, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, msg_svc_routinghead, messageRecord, appInterface)).booleanValue();
        }
        byte[] g16 = ((QQAppInterface) appInterface).getMsgCache().g1(messageRecord.frienduin);
        msg_svc$WPATmp msg_svc_wpatmp = new msg_svc$WPATmp();
        msg_svc_wpatmp.to_uin.set(Long.valueOf(messageRecord.frienduin).longValue());
        if (g16 != null) {
            int length = g16.length - 2;
            byte[] bArr = new byte[length];
            PkgTools.copyData(bArr, 0, g16, 2, g16.length - 2);
            if (QLog.isColorLevel()) {
                QLog.d("WPARoutingType", 2, "wpa------>" + HexUtil.bytes2HexStr(bArr) + ",length:" + length);
            }
            msg_svc_wpatmp.sig.set(ByteStringMicro.copyFrom(bArr));
        }
        msg_svc_routinghead.wpa_tmp.set(msg_svc_wpatmp);
        return true;
    }

    @Override // com.tencent.imcore.message.core.codec.d
    public int getUinType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1005;
    }
}
