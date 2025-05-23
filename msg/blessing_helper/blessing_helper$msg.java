package msg.blessing_helper;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class blessing_helper$msg extends MessageMicro<blessing_helper$msg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 56, 64}, new String[]{"version", "result", "uin", "time", "number", "text", "touin_count", "touin_list"}, new Object[]{0, 0, 0L, 0L, 0, ByteStringMicro.EMPTY, 0, 0L}, blessing_helper$msg.class);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field time = PBField.initUInt64(0);
    public final PBUInt32Field number = PBField.initUInt32(0);
    public final PBBytesField text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field touin_count = PBField.initUInt32(0);
    public final PBRepeatField<Long> touin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
