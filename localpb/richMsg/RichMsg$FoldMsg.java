package localpb.richMsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class RichMsg$FoldMsg extends MessageMicro<RichMsg$FoldMsg> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField msg_content;
    public final PBBytesField redbag_id;
    public final PBBytesField redbag_index;
    public final PBUInt32Field fold_flags = PBField.initUInt32(0);
    public final PBUInt64Field redbag_sender_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42}, new String[]{"fold_flags", "redbag_sender_uin", "redbag_id", "msg_content", "redbag_index"}, new Object[]{0, 0L, byteStringMicro, byteStringMicro, byteStringMicro}, RichMsg$FoldMsg.class);
    }

    public RichMsg$FoldMsg() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.redbag_id = PBField.initBytes(byteStringMicro);
        this.msg_content = PBField.initBytes(byteStringMicro);
        this.redbag_index = PBField.initBytes(byteStringMicro);
    }
}
