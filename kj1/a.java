package kj1;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.service.message.ab;
import com.tencent.mobileqq.troop.data.c;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.group_pro_proto.msgpush.servtype$EventBody;
import tencent.im.group_pro_proto.msgpush.servtype$FeedEvent;
import tencent.im.msg.im_msg_body$CommonElem;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes13.dex */
public class a implements com.tencent.imcore.message.core.codec.a {

    /* renamed from: a, reason: collision with root package name */
    private static String f412555a = "GuildMsgFeedDecoder";

    private boolean d(servtype$FeedEvent servtype_feedevent, List<MessageRecord> list) {
        if (list != null && !list.isEmpty()) {
            if (!servtype_feedevent.str_feed_id.has()) {
                return false;
            }
            return true;
        }
        QLog.e(f412555a, 1, "decodeFeedEvent fail! msgRecords is empty!");
        return false;
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public boolean a(List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, List<MessageRecord> list2, StringBuilder sb5, boolean z16, boolean z17, c cVar, ab abVar, com.tencent.mobileqq.service.message.a aVar) {
        im_msg_body$CommonElem im_msg_body_commonelem;
        if (aVar.f286163r != 10014) {
            return false;
        }
        Iterator<im_msg_body$Elem> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                im_msg_body$Elem next = it.next();
                if (next.common_elem.has()) {
                    im_msg_body_commonelem = next.common_elem.get();
                    break;
                }
            } else {
                im_msg_body_commonelem = null;
                break;
            }
        }
        if (im_msg_body_commonelem == null || 500 != im_msg_body_commonelem.uint32_service_type.get()) {
            return false;
        }
        servtype$EventBody servtype_eventbody = new servtype$EventBody();
        try {
            servtype_eventbody.mergeFrom(im_msg_body_commonelem.bytes_pb_elem.get().toByteArray());
            if (!servtype_eventbody.feed_event.has()) {
                return false;
            }
            return d(servtype_eventbody.feed_event.get(), list2);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e(f412555a, 1, "decodePBMsgElem fail! " + e16.toString());
            return false;
        }
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public boolean b(im_msg_body$Elem im_msg_body_elem) {
        if (im_msg_body_elem.common_elem.has() && im_msg_body_elem.common_elem.get().uint32_service_type.get() == 500) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public int getPriority() {
        return -1000;
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public void c(List<com.tencent.imcore.message.core.codec.a> list) {
    }
}
