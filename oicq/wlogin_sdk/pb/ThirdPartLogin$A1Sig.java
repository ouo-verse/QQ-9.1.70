package oicq.wlogin_sdk.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes28.dex */
public final class ThirdPartLogin$A1Sig extends MessageMicro<ThirdPartLogin$A1Sig> {
    public static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_a1_sig;
    public final PBBytesField bytes_encrypt_uin;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_encrypt_uin", "bytes_a1_sig"}, new Object[]{byteStringMicro, byteStringMicro}, ThirdPartLogin$A1Sig.class);
    }

    public ThirdPartLogin$A1Sig() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_encrypt_uin = PBField.initBytes(byteStringMicro);
        this.bytes_a1_sig = PBField.initBytes(byteStringMicro);
    }
}
