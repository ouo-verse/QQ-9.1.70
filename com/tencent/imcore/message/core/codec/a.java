package com.tencent.imcore.message.core.codec;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.ab;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface a {
    boolean a(List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, List<MessageRecord> list2, StringBuilder sb5, boolean z16, boolean z17, com.tencent.mobileqq.troop.data.c cVar, ab abVar, com.tencent.mobileqq.service.message.a aVar);

    boolean b(im_msg_body$Elem im_msg_body_elem);

    void c(List<a> list);

    int getPriority();
}
