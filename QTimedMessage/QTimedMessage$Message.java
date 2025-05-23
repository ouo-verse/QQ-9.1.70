package QTimedMessage;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QTimedMessage$Message extends MessageMicro<QTimedMessage$Message> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 58, 66}, new String[]{"uint64_appid", "bytes_msg_id", "msg_author", "uint32_main_type", "uint32_sub_type", "uint64_create_time", "msg_timer", "msg_content"}, new Object[]{0L, ByteStringMicro.EMPTY, null, 0, 0, 0L, null, null}, QTimedMessage$Message.class);
    public final PBUInt64Field uint64_appid = PBField.initUInt64(0);
    public final PBBytesField bytes_msg_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public QTimedMessage$User msg_author = new QTimedMessage$User();
    public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_create_time = PBField.initUInt64(0);
    public QTimedMessage$Timer msg_timer = new QTimedMessage$Timer();
    public QTimedMessage$Content msg_content = new QTimedMessage$Content();
}
