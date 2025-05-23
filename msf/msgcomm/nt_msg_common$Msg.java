package msf.msgcomm;

import com.tencent.mobileqq.pb.MessageMicro;
import tencent.im.msg.im_msg_body$MsgBody;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class nt_msg_common$Msg extends MessageMicro<nt_msg_common$Msg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"routing_head", "content_head", "body"}, new Object[]{null, null, null}, nt_msg_common$Msg.class);
    public nt_msg_common$RoutingHead routing_head = new nt_msg_common$RoutingHead();
    public nt_msg_common$ContentHead content_head = new nt_msg_common$ContentHead();
    public im_msg_body$MsgBody body = new im_msg_body$MsgBody();
}
