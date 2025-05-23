package hw.sso;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class hw_sso$HwSSOReq extends MessageMicro<hw_sso$HwSSOReq> {
    public static final int BODY_FIELD_NUMBER = 2;
    public static final int CMD_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"cmd", "body"}, new Object[]{"", ByteStringMicro.EMPTY}, hw_sso$HwSSOReq.class);
    public final PBStringField cmd = PBField.initString("");
    public final PBBytesField body = PBField.initBytes(ByteStringMicro.EMPTY);
}
