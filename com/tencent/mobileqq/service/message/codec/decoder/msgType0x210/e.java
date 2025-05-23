package com.tencent.mobileqq.service.message.codec.decoder.msgType0x210;

import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.NotifyPCActiveActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.p;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.List;
import mqq.app.NewIntent;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgType0x210;
import tencent.im.s2c.msgtype0x210.submsgtype0x6b.SubMsgType0x6b$MsgBody;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e implements n {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.n
    public void c(msg_comm$MsgType0x210 msg_comm_msgtype0x210, msg_comm$Msg msg_comm_msg, List<MessageRecord> list, com.tencent.mobileqq.service.message.a aVar, MessageHandler messageHandler) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, msg_comm_msgtype0x210, msg_comm_msg, list, aVar, messageHandler);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Push_PCActive_Notice_Decode", 2, "get notice from decodeC2CMsgPkg_MsgType0x210");
        }
        byte[] byteArray = msg_comm_msgtype0x210.msg_content.get().toByteArray();
        try {
            SubMsgType0x6b$MsgBody subMsgType0x6b$MsgBody = new SubMsgType0x6b$MsgBody();
            subMsgType0x6b$MsgBody.mergeFrom(byteArray);
            long j3 = subMsgType0x6b$MsgBody.uint64_to_uin.get();
            String str3 = null;
            if (!SettingCloneUtil.readValue((Context) BaseApplicationImpl.getApplication(), Long.toString(j3), (String) null, AppConstants.QQSETTING_PCACTIVE_KEY, false)) {
                if (subMsgType0x6b$MsgBody.bytes_tips_content.has()) {
                    str = new String(subMsgType0x6b$MsgBody.bytes_tips_content.get().toByteArray(), "utf-8");
                } else {
                    str = null;
                }
                if (subMsgType0x6b$MsgBody.bytes_yes_text.has()) {
                    str2 = new String(subMsgType0x6b$MsgBody.bytes_yes_text.get().toByteArray(), "utf-8");
                } else {
                    str2 = null;
                }
                if (subMsgType0x6b$MsgBody.bytes_no_text.has()) {
                    str3 = new String(subMsgType0x6b$MsgBody.bytes_no_text.get().toByteArray(), "utf-8");
                }
                BaseApplicationImpl.getApplication().setPCActiveNotice(Long.toString(j3), str, str3, str2);
                Intent intent = new Intent(NewIntent.ACTION_PCACTIVE_TIPS);
                intent.putExtra("uin", Long.toString(j3));
                intent.putExtra("Message", str);
                intent.putExtra("lButton", str3);
                intent.putExtra("rButton", str2);
                if (NotifyPCActiveActivity.f176576d0 == null) {
                    BaseApplicationImpl.getApplication().startActivity(intent);
                }
            }
        } catch (InvalidProtocolBufferMicroException unused) {
            if (QLog.isColorLevel()) {
                QLog.d("Push_PCActive_Notice_Decode", 2, "failed to get msg0x210.SubMsgType0x6b");
            }
        } catch (UnsupportedEncodingException unused2) {
            if (QLog.isColorLevel()) {
                QLog.d("Push_PCActive_Notice_Decode", 2, "failed to parse msg0x210.SubMsgType0x6b");
            }
        }
        p.I(msg_comm_msg.msg_head.from_uin.get(), msg_comm_msg.msg_head.msg_seq.get(), msg_comm_msg.msg_head.msg_uid.get(), msg_comm_msg.msg_head.msg_type.get(), messageHandler.getApp());
    }
}
