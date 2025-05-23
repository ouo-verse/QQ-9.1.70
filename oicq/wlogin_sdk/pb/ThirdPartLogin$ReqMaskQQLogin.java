package oicq.wlogin_sdk.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes28.dex */
public final class ThirdPartLogin$ReqMaskQQLogin extends MessageMicro<ThirdPartLogin$ReqMaskQQLogin> {
    public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_encrypt_uin_info"}, new Object[]{ByteStringMicro.EMPTY}, ThirdPartLogin$ReqMaskQQLogin.class);
    public final PBBytesField bytes_encrypt_uin_info = PBField.initBytes(ByteStringMicro.EMPTY);
}
