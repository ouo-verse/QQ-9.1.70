package msg.aio_doodle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes28.dex */
public final class DoodleMsgProto$DoodleHeader extends MessageMicro<DoodleMsgProto$DoodleHeader> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field uint32_Version = PBField.initUInt32(0);
    public final PBBytesField tytes_doodle_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_line_count = PBField.initUInt32(0);
    public final PBFloatField float_line_width_max = PBField.initFloat(0.0f);
    public final PBFloatField float_line_width_min = PBField.initFloat(0.0f);
    public final PBFloatField float_comp_factor_max = PBField.initFloat(0.0f);
    public final PBFloatField float_comp_factor_min = PBField.initFloat(0.0f);
    public final PBFloatField float_draw_area_width = PBField.initFloat(0.0f);
    public final PBFloatField float_draw_area_height = PBField.initFloat(0.0f);

    static {
        Float valueOf = Float.valueOf(0.0f);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 45, 53, 61, 69, 77, 85}, new String[]{"uint32_Version", "tytes_doodle_md5", "uint32_time", "uint32_line_count", "float_line_width_max", "float_line_width_min", "float_comp_factor_max", "float_comp_factor_min", "float_draw_area_width", "float_draw_area_height"}, new Object[]{0, ByteStringMicro.EMPTY, 0, 0, valueOf, valueOf, valueOf, valueOf, valueOf, valueOf}, DoodleMsgProto$DoodleHeader.class);
    }
}
