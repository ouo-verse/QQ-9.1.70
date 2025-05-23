package QTimedMessage;

import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class QTimedMessage$UDPPacket extends MessageMicro<QTimedMessage$UDPPacket> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_to_host", MessageForUniteGrayTip.KEY_BYTES_CONTENT}, new Object[]{null, ByteStringMicro.EMPTY}, QTimedMessage$UDPPacket.class);
    public QTimedMessage$Host msg_to_host = new MessageMicro<QTimedMessage$Host>() { // from class: QTimedMessage.QTimedMessage$Host
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_cmlb_id", "bytes_ip", "uint32_port"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, QTimedMessage$Host.class);
        public final PBUInt32Field uint32_cmlb_id = PBField.initUInt32(0);
        public final PBBytesField bytes_ip = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_port = PBField.initUInt32(0);
    };
    public final PBBytesField bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
}
