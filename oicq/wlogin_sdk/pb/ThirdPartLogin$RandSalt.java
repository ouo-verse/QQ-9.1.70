package oicq.wlogin_sdk.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class ThirdPartLogin$RandSalt extends MessageMicro<ThirdPartLogin$RandSalt> {
    public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_encrypt_uin", "uint64_salt"}, new Object[]{ByteStringMicro.EMPTY, 0L}, ThirdPartLogin$RandSalt.class);
    public final PBBytesField bytes_encrypt_uin = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_salt = PBField.initUInt64(0);
}
