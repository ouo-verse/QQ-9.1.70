package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class UnifyTabSearch$ProcessData extends MessageMicro<UnifyTabSearch$ProcessData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field group_mask = PBField.initUInt32(0);
    public final PBBytesField key;
    public final PBBytesField value;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"group_mask", "key", "value"}, new Object[]{0, byteStringMicro, byteStringMicro}, UnifyTabSearch$ProcessData.class);
    }

    public UnifyTabSearch$ProcessData() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.key = PBField.initBytes(byteStringMicro);
        this.value = PBField.initBytes(byteStringMicro);
    }
}
