package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class msg_ctrl$ResvResvInfo extends MessageMicro<msg_ctrl$ResvResvInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48, 56, 64}, new String[]{"uint32_flag", "bytes_reserv1", "uint64_reserv2", "uint64_reserv3", "uint32_create_time", "uint32_pic_height", "uint32_pic_width", "uint32_resv_flag"}, new Object[]{0, ByteStringMicro.EMPTY, 0L, 0L, 0, 0, 0, 0}, msg_ctrl$ResvResvInfo.class);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBBytesField bytes_reserv1 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_reserv2 = PBField.initUInt64(0);
    public final PBUInt64Field uint64_reserv3 = PBField.initUInt64(0);
    public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_resv_flag = PBField.initUInt32(0);
}
