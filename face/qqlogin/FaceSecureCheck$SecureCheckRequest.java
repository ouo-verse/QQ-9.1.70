package face.qqlogin;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FaceSecureCheck$SecureCheckRequest extends MessageMicro<FaceSecureCheck$SecureCheckRequest> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_client_addr;
    public final PBBytesField bytes_guid;
    public final PBUInt32Field uint32_version;
    public final PBUInt64Field uint64_appid;
    public final PBUInt64Field uint64_nonce;
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_addr = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 50, 56, 64}, new String[]{"uint32_timestamp", "uint32_seq", "uint32_client_addr", "bytes_client_addr", "uint32_version", "bytes_guid", "uint64_appid", "uint64_nonce"}, new Object[]{0, 0, 0, byteStringMicro, 0, byteStringMicro, 0L, 0L}, FaceSecureCheck$SecureCheckRequest.class);
    }

    public FaceSecureCheck$SecureCheckRequest() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_client_addr = PBField.initBytes(byteStringMicro);
        this.uint32_version = PBField.initUInt32(0);
        this.bytes_guid = PBField.initBytes(byteStringMicro);
        this.uint64_appid = PBField.initUInt64(0L);
        this.uint64_nonce = PBField.initUInt64(0L);
    }
}
