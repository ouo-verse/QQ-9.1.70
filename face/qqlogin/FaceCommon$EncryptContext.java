package face.qqlogin;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FaceCommon$EncryptContext extends MessageMicro<FaceCommon$EncryptContext> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField EncryptKey;
    public final PBBytesField IV;
    public final PBEnumField Method = PBField.initEnum(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"Method", "EncryptKey", "IV"}, new Object[]{0, byteStringMicro, byteStringMicro}, FaceCommon$EncryptContext.class);
    }

    public FaceCommon$EncryptContext() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.EncryptKey = PBField.initBytes(byteStringMicro);
        this.IV = PBField.initBytes(byteStringMicro);
    }
}
