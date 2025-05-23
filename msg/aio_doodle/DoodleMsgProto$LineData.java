package msg.aio_doodle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class DoodleMsgProto$LineData extends MessageMicro<DoodleMsgProto$LineData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBFloatField float_X = PBField.initFloat(0.0f);
    public final PBFloatField float_Y = PBField.initFloat(0.0f);
    public final PBUInt64Field uint64_tickcount = PBField.initUInt64(0);

    static {
        Float valueOf = Float.valueOf(0.0f);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 21, 24}, new String[]{"float_X", "float_Y", "uint64_tickcount"}, new Object[]{valueOf, valueOf, 0L}, DoodleMsgProto$LineData.class);
    }
}
