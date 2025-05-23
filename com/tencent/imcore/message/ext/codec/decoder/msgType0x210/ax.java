package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x6b.SubMsgType0x6b$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ax implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public ax() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(com.tencent.imcore.message.af afVar, MsgInfo msgInfo, MsgType0x210 msgType0x210) {
        String str;
        String str2;
        if (QLog.isColorLevel()) {
            QLog.d("Push_PCActive_Notice", 2, "get notice from handleC2COnlinePushMsg0x210Resp");
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.d("PCActive", 2, "recv pcactive notice push");
            }
            SubMsgType0x6b$MsgBody subMsgType0x6b$MsgBody = new SubMsgType0x6b$MsgBody();
            subMsgType0x6b$MsgBody.mergeFrom(msgType0x210.vProtobuf);
            long j3 = subMsgType0x6b$MsgBody.uint64_to_uin.get();
            String account = afVar.d().getAccount();
            String str3 = null;
            if (!SettingCloneUtil.readValue((Context) BaseApplicationImpl.getApplication(), Long.toString(j3), (String) null, AppConstants.QQSETTING_PCACTIVE_KEY, false) && Long.toString(j3).equals(account)) {
                try {
                    if (subMsgType0x6b$MsgBody.bytes_tips_content.has()) {
                        str = new String(subMsgType0x6b$MsgBody.bytes_tips_content.get().toByteArray(), "utf-8");
                    } else {
                        str = null;
                    }
                    try {
                        if (subMsgType0x6b$MsgBody.bytes_yes_text.has()) {
                            str2 = new String(subMsgType0x6b$MsgBody.bytes_yes_text.get().toByteArray(), "utf-8");
                        } else {
                            str2 = null;
                        }
                    } catch (Exception unused) {
                        str2 = null;
                    }
                } catch (Exception unused2) {
                    str = null;
                    str2 = null;
                }
                try {
                    if (subMsgType0x6b$MsgBody.bytes_no_text.has()) {
                        str3 = new String(subMsgType0x6b$MsgBody.bytes_no_text.get().toByteArray(), "utf-8");
                    }
                } catch (Exception unused3) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Push_PCActive_Notice", 2, "failed to parse msg0x210.SubMsgType0x6b");
                    }
                    BaseApplicationImpl.getApplication().setPCActiveNotice(Long.toString(j3), str, str3, str2);
                    afVar.l(MessageHandlerConstants.NOTIFY_TYPE_PC_ACTIVE_NOTIFY, true, new Object[]{Long.toString(j3), str, str3, str2});
                    com.tencent.mobileqq.service.message.p.I(msgInfo.lFromUin, msgInfo.shMsgSeq, msgInfo.lMsgUid, msgInfo.shMsgType, afVar.d());
                }
                BaseApplicationImpl.getApplication().setPCActiveNotice(Long.toString(j3), str, str3, str2);
                afVar.l(MessageHandlerConstants.NOTIFY_TYPE_PC_ACTIVE_NOTIFY, true, new Object[]{Long.toString(j3), str, str3, str2});
            } else if (QLog.isColorLevel()) {
                QLog.d("Push_PCActive_Notice", 2, "swtich closed or uin cannot be matched");
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
            afVar.l(MessageHandlerConstants.NOTIFY_TYPE_PC_ACTIVE_NOTIFY, false, new Object[]{"", "", "", ""});
        }
        com.tencent.mobileqq.service.message.p.I(msgInfo.lFromUin, msgInfo.shMsgSeq, msgInfo.lMsgUid, msgInfo.shMsgType, afVar.d());
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        b(afVar, msgInfo, msgType0x210);
        return null;
    }
}
