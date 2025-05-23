package com.tencent.imcore.message;

import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$GeneralFlags;
import tencent.im.msg.im_msg_body$SecretFileMsg;

/* compiled from: P */
/* loaded from: classes7.dex */
public class p {
    static IPatchRedirector $redirector_;

    public static int a(msg_comm$Msg msg_comm_msg) {
        im_msg_body$GeneralFlags m3 = com.tencent.mobileqq.service.message.w.m(msg_comm_msg);
        if (m3 != null && m3.uint32_bubble_diy_text_id.has()) {
            return m3.uint32_bubble_diy_text_id.get();
        }
        return 0;
    }

    public static int b(msg_comm$Msg msg_comm_msg) {
        im_msg_body$GeneralFlags m3 = com.tencent.mobileqq.service.message.w.m(msg_comm_msg);
        if (m3 != null && m3.uint32_bubble_sub_id.has()) {
            return m3.uint32_bubble_sub_id.get();
        }
        return 0;
    }

    public static long c(BaseMessageHandler baseMessageHandler, msg_comm$Msg msg_comm_msg, String str, String str2) {
        long j3;
        int i3;
        if (!msg_comm_msg.msg_body.has() || !msg_comm_msg.msg_body.get().rich_text.has()) {
            return 0L;
        }
        long j16 = -1;
        for (im_msg_body$Elem im_msg_body_elem : msg_comm_msg.msg_body.get().rich_text.get().elems.get()) {
            if (im_msg_body_elem.elem_flags2.has() && im_msg_body_elem.elem_flags2.get().uint32_color_text_id.has()) {
                i3 = im_msg_body_elem.elem_flags2.get().uint32_color_text_id.get();
            } else if (im_msg_body_elem.secret_file.has()) {
                im_msg_body$SecretFileMsg im_msg_body_secretfilemsg = im_msg_body_elem.secret_file;
                if (im_msg_body_secretfilemsg.elem_flags2.has() && im_msg_body_secretfilemsg.elem_flags2.uint32_color_text_id.has()) {
                    i3 = im_msg_body_secretfilemsg.elem_flags2.get().uint32_color_text_id.get();
                }
            }
            j16 = i3 & 4294967295L;
        }
        if (j16 == 4294967295L) {
            j3 = com.tencent.imcore.message.messageprocessor.a.a(baseMessageHandler.getApp(), str, str2);
        } else {
            j3 = -1;
        }
        if (j16 == 4294967295L) {
            j16 = j3;
        }
        if (j16 == -1) {
            return 0L;
        }
        return j16;
    }
}
