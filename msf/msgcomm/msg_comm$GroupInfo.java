package msf.msgcomm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class msg_comm$GroupInfo extends MessageMicro<msg_comm$GroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField group_card;
    public final PBUInt32Field group_card_type;
    public final PBUInt32Field group_level;
    public final PBBytesField group_name;
    public final PBBytesField group_rank;
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt32Field group_type = PBField.initUInt32(0);
    public final PBUInt64Field group_info_seq = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 56, 66}, new String[]{"group_code", "group_type", "group_info_seq", "group_card", "group_rank", "group_level", "group_card_type", "group_name"}, new Object[]{0L, 0, 0L, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro}, msg_comm$GroupInfo.class);
    }

    public msg_comm$GroupInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.group_card = PBField.initBytes(byteStringMicro);
        this.group_rank = PBField.initBytes(byteStringMicro);
        this.group_level = PBField.initUInt32(0);
        this.group_card_type = PBField.initUInt32(0);
        this.group_name = PBField.initBytes(byteStringMicro);
    }
}
