package addcontacts;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class AccountSearchPb$Label extends MessageMicro<AccountSearchPb$Label> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 26, 34, 40, 48}, new String[]{"bytes_name", "text_color", "edging_color", "uint32_label_attr", "uint32_label_type"}, new Object[]{ByteStringMicro.EMPTY, null, null, 0, 0}, AccountSearchPb$Label.class);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public AccountSearchPb$Color text_color = new AccountSearchPb$Color();
    public AccountSearchPb$Color edging_color = new AccountSearchPb$Color();
    public final PBUInt32Field uint32_label_attr = PBField.initUInt32(0);
    public final PBUInt32Field uint32_label_type = PBField.initUInt32(0);
}
