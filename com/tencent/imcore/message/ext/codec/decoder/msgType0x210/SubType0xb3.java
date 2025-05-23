package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.assistedchat.api.IPrologueApi;
import mqq.app.AppRuntime;
import msf.msgcomm.nt_msg_common$Msg;
import org.jetbrains.annotations.NotNull;
import tencent.im.s2c.msgtype0x210.submsgtype0xb3.SubMsgType0xb3$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xb3.SubMsgType0xb3$PushAddFrdNotify;

/* compiled from: P */
/* loaded from: classes7.dex */
public class SubType0xb3 implements a<com.tencent.imcore.message.af>, oz3.a {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "Q.msg.SubType0xb3";

    public SubType0xb3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String decodeC2CMsgPkgSubMsgType0xb3(QQAppInterface qQAppInterface, byte[] bArr) {
        SubMsgType0xb3$MsgBody subMsgType0xb3$MsgBody;
        long j3;
        String str;
        long j16;
        String str2;
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 parse start");
        }
        String str3 = null;
        try {
            subMsgType0xb3$MsgBody = new SubMsgType0xb3$MsgBody().mergeFrom(bArr);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 parse failed.", e16);
            }
            subMsgType0xb3$MsgBody = null;
        }
        if (subMsgType0xb3$MsgBody == null) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 | msgBody is null.");
            }
            return null;
        }
        if (!subMsgType0xb3$MsgBody.msg_add_frd_notify.has()) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 | msg_add_frd_notify is null.");
            }
            return null;
        }
        SubMsgType0xb3$PushAddFrdNotify subMsgType0xb3$PushAddFrdNotify = subMsgType0xb3$MsgBody.msg_add_frd_notify.get();
        int i3 = subMsgType0xb3$PushAddFrdNotify.uint32_source_id.get();
        int i16 = subMsgType0xb3$PushAddFrdNotify.uint32_subsource_id.get();
        if (subMsgType0xb3$PushAddFrdNotify.uint64_req_uin.has()) {
            j3 = subMsgType0xb3$PushAddFrdNotify.uint64_req_uin.get();
        } else {
            j3 = 0;
        }
        long j17 = j3;
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessorQ.nearby.follow", 2, "decodeC2CMsgPkgSubMsgType0xb3, sourceid:" + i3 + "|subSourceid:" + i16 + " |reqUin: " + j17);
        }
        if (i3 == 3076 || i3 == 3077 || i3 == 2076 || i3 == 2077 || i3 == 10012 || i3 == 10013) {
            return null;
        }
        boolean a16 = friendlist.a.a(i3);
        FriendListHandler friendListHandler = (FriendListHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if (a16) {
            if (subMsgType0xb3$PushAddFrdNotify.bytes_mobile.has()) {
                str2 = subMsgType0xb3$PushAddFrdNotify.bytes_mobile.get().toStringUtf8();
            } else {
                str2 = null;
            }
            str = str2;
        } else {
            str = null;
        }
        String valueOf = String.valueOf(subMsgType0xb3$PushAddFrdNotify.uint64_fuin.get());
        if (subMsgType0xb3$PushAddFrdNotify.uint64_fuin_bubble_id.has()) {
            j16 = subMsgType0xb3$PushAddFrdNotify.uint64_fuin_bubble_id.get();
        } else {
            j16 = -1;
        }
        long j18 = j16;
        if (subMsgType0xb3$PushAddFrdNotify.bytes_wording.has()) {
            str3 = subMsgType0xb3$PushAddFrdNotify.bytes_wording.get().toStringUtf8();
        }
        friendListHandler.addGreetingMsg(valueOf, str, j18, str3, subMsgType0xb3$PushAddFrdNotify.fixed32_timestamp.get(), i3, i16, j17);
        String valueOf2 = String.valueOf(subMsgType0xb3$PushAddFrdNotify.uint64_fuin.get());
        if (!TextUtils.isEmpty(valueOf2)) {
            ((IPrologueApi) QRoute.api(IPrologueApi.class)).setC2CNeedRequestPrologue(valueOf2, true);
        }
        return valueOf2;
    }

    public void processMsg(int i3, long j3, long j16, boolean z16, @NotNull nt_msg_common$Msg nt_msg_common_msg, @NotNull AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16), nt_msg_common_msg, appRuntime);
        } else {
            decodeC2CMsgPkgSubMsgType0xb3((QQAppInterface) appRuntime, nt_msg_common_msg.body.msg_content.get().toByteArray());
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        decodeC2CMsgPkgSubMsgType0xb3((QQAppInterface) afVar.d(), msgType0x210.vProtobuf);
        return null;
    }
}
