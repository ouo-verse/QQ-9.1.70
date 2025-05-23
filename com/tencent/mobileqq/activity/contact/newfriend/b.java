package com.tencent.mobileqq.activity.contact.newfriend;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.managers.PushNoticeManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgHead;
import tencent.im.pushsvr.pushsvrExt$ExtData;
import tencent.im.s2c.msgtype0x210.submsgtype0x101.SubMsgType0x27$ClientReport;
import tencent.im.s2c.msgtype0x210.submsgtype0x101.SubMsgType0x27$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x101.SubMsgType0x27$PushPlatform;
import tencent.mobileim.structmsg.structmsg$StructMsg;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f181278a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67924);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f181278a = new AtomicInteger(1);
        }
    }

    public static int a(MessageRecord messageRecord) {
        structmsg$StructMsg parseStructMsg = MessageForSystemMsg.parseStructMsg(messageRecord.msgData);
        if (parseStructMsg.msg_type.get() == 1) {
            return parseStructMsg.f436065msg.sub_type.get();
        }
        return -1;
    }

    public static final void b(AppInterface appInterface, long j3, long j16, short s16, msg_comm$Msg msg_comm_msg, int i3) {
        String str;
        String str2;
        if (s16 != 188 && s16 != 189) {
            return;
        }
        msg_comm$MsgHead msg_comm_msghead = msg_comm_msg.msg_head.get();
        if (msg_comm_msghead != null) {
            str = "" + msg_comm_msghead.auth_uin.get();
            String str3 = msg_comm_msghead.auth_nick.get();
            String str4 = msg_comm_msghead.auth_remark.get();
            boolean isEmpty = TextUtils.isEmpty(str);
            boolean isEmpty2 = TextUtils.isEmpty(str3);
            if (!TextUtils.isEmpty(str4)) {
                str = str4;
            } else if (!isEmpty2) {
                str = str3;
            } else if (isEmpty) {
                str = String.valueOf(j16);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
        } else {
            str = null;
        }
        if (QLog.isColorLevel()) {
            QLog.i("NewFriendPushUtil", 2, cq.w(String.format(Locale.getDefault(), "handleNewFrdSystemPush [0x%x,%d,%s,%d]", Short.valueOf(s16), Long.valueOf(j16), str, Integer.valueOf(i3)), 2));
        }
        SubMsgType0x27$MsgBody subMsgType0x27$MsgBody = new SubMsgType0x27$MsgBody();
        SubMsgType0x27$PushPlatform subMsgType0x27$PushPlatform = new SubMsgType0x27$PushPlatform();
        SubMsgType0x27$ClientReport subMsgType0x27$ClientReport = new SubMsgType0x27$ClientReport();
        subMsgType0x27$ClientReport.uint32_service_id.set(1005);
        PBStringField pBStringField = subMsgType0x27$ClientReport.str_content_id;
        if (s16 == 188) {
            str2 = "0xbc";
        } else {
            str2 = "0xbd";
        }
        pBStringField.set(str2);
        subMsgType0x27$MsgBody.msg_client_report.set(subMsgType0x27$ClientReport);
        subMsgType0x27$PushPlatform.uint32_forward_type.set(1);
        subMsgType0x27$PushPlatform.uint64_from_uin.set(j16);
        subMsgType0x27$PushPlatform.str_desc.set(String.format(HardCodeUtil.qqStr(R.string.f172237op1), str));
        subMsgType0x27$PushPlatform.str_target_url.set(Base64.encodeToString("newfrd_add".getBytes(), 0));
        subMsgType0x27$PushPlatform.str_title.set(HardCodeUtil.qqStr(R.string.f172238op3));
        pushsvrExt$ExtData pushsvrext_extdata = new pushsvrExt$ExtData();
        pushsvrext_extdata.uint64_to_uin.set(j16);
        pushsvrext_extdata.str_remark.set(ByteStringMicro.copyFromUtf8(str));
        subMsgType0x27$PushPlatform.bytes_ext_data.set(ByteStringMicro.copyFrom(pushsvrext_extdata.toByteArray()));
        subMsgType0x27$MsgBody.msg_push_platform.set(subMsgType0x27$PushPlatform);
        ((PushNoticeManager) appInterface.getManager(QQManagerFactory.PUSH_NOTICE_MANAGER)).g(subMsgType0x27$MsgBody, (short) (f181278a.getAndIncrement() % 32767), i3);
    }
}
