package addcontacts;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class AccountSearchPb$Color extends MessageMicro<AccountSearchPb$Color> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_r", "uint32_g", "uint32_b"}, new Object[]{0, 0, 0}, AccountSearchPb$Color.class);
    public final PBUInt32Field uint32_r = PBField.initUInt32(0);
    public final PBUInt32Field uint32_g = PBField.initUInt32(0);
    public final PBUInt32Field uint32_b = PBField.initUInt32(0);
}
