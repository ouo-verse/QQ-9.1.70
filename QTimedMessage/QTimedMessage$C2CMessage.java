package QTimedMessage;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QTimedMessage$C2CMessage extends MessageMicro<QTimedMessage$C2CMessage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56}, new String[]{"msg_from_user", "msg_to_user", "msg_recv_client", "bytes_text", "msg_rich_text", "uint32_send_text_standalone", "uint32_send_rich_text_standalone"}, new Object[]{null, null, null, ByteStringMicro.EMPTY, null, 0, 0}, QTimedMessage$C2CMessage.class);
    public QTimedMessage$User msg_from_user = new QTimedMessage$User();
    public QTimedMessage$User msg_to_user = new QTimedMessage$User();
    public QTimedMessage$Client msg_recv_client = new QTimedMessage$Client();
    public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public RichText msg_rich_text = new RichText();
    public final PBUInt32Field uint32_send_text_standalone = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_rich_text_standalone = PBField.initUInt32(0);

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class RichText extends MessageMicro<RichText> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"bytes_template_1", "uint32_service_id", "uint32_gift_id"}, new Object[]{ByteStringMicro.EMPTY, 0, 0}, RichText.class);
        public final PBBytesField bytes_template_1 = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_service_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_gift_id = PBField.initUInt32(0);
    }
}
