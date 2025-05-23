package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.fi;

/* compiled from: P */
/* loaded from: classes7.dex */
public class t implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IGPSService iGPSService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        if (afVar != null) {
            try {
                if (afVar.d() != null && (iGPSService = (IGPSService) afVar.d().getRuntimeService(IGPSService.class, "")) != null) {
                    fi fiVar = new fi("", "", "", "", "", 0);
                    if (bArr == null) {
                        bArr = new byte[0];
                    }
                    iGPSService.onSrvPushMsg(528, AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE, fiVar, bArr);
                    return null;
                }
                return null;
            } catch (Exception e16) {
                e16.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
