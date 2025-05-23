package appoint.define;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class appoint_define$CommonLabel extends MessageMicro<appoint_define$CommonLabel> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_lable_msg_last;
    public final PBBytesField bytes_lable_msg_pre;
    public final PBRepeatField<ByteStringMicro> rpt_interst_name;
    public final PBRepeatField<Integer> rpt_interst_type;
    public final PBUInt32Field uint32_lable_id = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40}, new String[]{"uint32_lable_id", "bytes_lable_msg_pre", "bytes_lable_msg_last", "rpt_interst_name", "rpt_interst_type"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, 0}, appoint_define$CommonLabel.class);
    }

    public appoint_define$CommonLabel() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_lable_msg_pre = PBField.initBytes(byteStringMicro);
        this.bytes_lable_msg_last = PBField.initBytes(byteStringMicro);
        this.rpt_interst_name = PBField.initRepeat(PBBytesField.__repeatHelper__);
        this.rpt_interst_type = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    }
}
