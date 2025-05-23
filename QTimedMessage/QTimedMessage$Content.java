package QTimedMessage;

import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QTimedMessage$Content extends MessageMicro<QTimedMessage$Content> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"bytes_userdef", "msg_pc_tip", "msg_group_message", "msg_c2c_message"}, new Object[]{ByteStringMicro.EMPTY, null, null, null}, QTimedMessage$Content.class);
    public final PBBytesField bytes_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
    public QTimedMessage$PCTip msg_pc_tip = new MessageMicro<QTimedMessage$PCTip>() { // from class: QTimedMessage.QTimedMessage$PCTip
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_content;
        public final PBBytesField bytes_redirect_url;
        public final PBBytesField bytes_title;
        public QTimedMessage$User msg_from_user = new QTimedMessage$User();
        public QTimedMessage$User msg_to_user = new QTimedMessage$User();

        static {
            String[] strArr = {"msg_from_user", "msg_to_user", "bytes_title", MessageForUniteGrayTip.KEY_BYTES_CONTENT, "bytes_redirect_url"};
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, strArr, new Object[]{null, null, byteStringMicro, byteStringMicro, byteStringMicro}, QTimedMessage$PCTip.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_title = PBField.initBytes(byteStringMicro);
            this.bytes_content = PBField.initBytes(byteStringMicro);
            this.bytes_redirect_url = PBField.initBytes(byteStringMicro);
        }
    };
    public QTimedMessage$GroupMessage msg_group_message = new MessageMicro<QTimedMessage$GroupMessage>() { // from class: QTimedMessage.QTimedMessage$GroupMessage
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_from_user", "msg_to_user"}, new Object[]{null, null}, QTimedMessage$GroupMessage.class);
        public QTimedMessage$User msg_from_user = new QTimedMessage$User();
        public QTimedMessage$User msg_to_user = new QTimedMessage$User();
    };
    public QTimedMessage$C2CMessage msg_c2c_message = new QTimedMessage$C2CMessage();
}
