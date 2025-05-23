package com.tencent.mobileqq.service.message;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.e;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f implements e.b {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.service.message.e.b
    public String a(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) bArr);
        }
        return PkgTools.toHexStr(bArr);
    }

    @Override // com.tencent.mobileqq.service.message.e.b
    public List<MessageRecord> b(String str, int i3, e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), eVar);
        }
        return ((QQAppInterface) eVar.c0()).getMessageFacade().Q(str, i3);
    }

    @Override // com.tencent.mobileqq.service.message.e.b
    public String c(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bArr);
        }
        return HexUtil.bytes2HexStr(bArr);
    }

    @Override // com.tencent.mobileqq.service.message.e.b
    public byte[] d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (byte[]) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        return HexUtil.hexStr2Bytes(str);
    }

    @Override // com.tencent.mobileqq.service.message.e.b
    public byte[] e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (byte[]) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        return PkgTools.hexToBytes(str);
    }

    @Override // com.tencent.mobileqq.service.message.e.b
    public StringBuilder f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (StringBuilder) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return com.tencent.mobileqq.activity.aio.l.P();
    }
}
