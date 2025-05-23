package face.qqlogin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FaceSecureCheck$SecureCheckResponse extends MessageMicro<FaceSecureCheck$SecureCheckResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 50}, new String[]{"uint32_errcode", "str_err_msg", "uint32_seq", "bool_sec_pass", "str_openid", "str_tmpkey"}, new Object[]{0, "", 0, Boolean.FALSE, "", ""}, FaceSecureCheck$SecureCheckResponse.class);
    public final PBUInt32Field uint32_errcode = PBField.initUInt32(0);
    public final PBStringField str_err_msg = PBField.initString("");
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBBoolField bool_sec_pass = PBField.initBool(false);
    public final PBStringField str_openid = PBField.initString("");
    public final PBStringField str_tmpkey = PBField.initString("");
}
