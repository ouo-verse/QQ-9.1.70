package com.tencent.imcore.message.msgproxy;

import com.tencent.imcore.message.MsgPool;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.Metadata;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a extends d {
    static IPatchRedirector $redirector_;

    @Metadata
    public a(AppRuntime appRuntime, BaseProxyManager baseProxyManager, MsgPool msgPool) {
        super(appRuntime, baseProxyManager, msgPool);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, baseProxyManager, msgPool);
        }
    }

    @Override // com.tencent.imcore.message.msgproxy.d, com.tencent.imcore.message.f
    public MessageRecord A0(String str, int i3, long j3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), Long.valueOf(j3), str2);
        }
        MessageRecord A0 = super.A0(str, i3, j3, str2);
        if (A0 instanceof ChatMessage) {
            ((ChatMessage) A0).reParse();
        }
        return A0;
    }

    @Override // com.tencent.imcore.message.msgproxy.d, com.tencent.imcore.message.f
    public MessageRecord B0(String str, int i3, long j3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), Long.valueOf(j3), bArr);
        }
        MessageRecord B0 = super.B0(str, i3, j3, bArr);
        if (B0 instanceof ChatMessage) {
            ((ChatMessage) B0).reParse();
        }
        return B0;
    }

    @Override // com.tencent.imcore.message.msgproxy.d, com.tencent.imcore.message.f
    public MessageRecord C0(String str, int i3, long j3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
        MessageRecord C0 = super.C0(str, i3, j3, i16, i17);
        if (C0 instanceof ChatMessage) {
            ((ChatMessage) C0).reParse();
        }
        return C0;
    }

    @Override // com.tencent.imcore.message.msgproxy.d, com.tencent.imcore.message.f
    public MessageRecord D0(String str, int i3, long j3, String str2, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Long.valueOf(j3), str2, obj);
        }
        MessageRecord D0 = super.D0(str, i3, j3, str2, obj);
        if (D0 instanceof ChatMessage) {
            ((ChatMessage) D0).reParse();
        }
        return D0;
    }

    @Override // com.tencent.imcore.message.msgproxy.d, com.tencent.imcore.message.f
    public MessageRecord t0(MessageRecord messageRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 6, this, messageRecord, Boolean.valueOf(z16));
        }
        MessageRecord t06 = super.t0(messageRecord, z16);
        if (t06 instanceof ChatMessage) {
            ((ChatMessage) t06).reParse();
        }
        return t06;
    }
}
