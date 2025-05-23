package face.qqlogin;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class faceproto$ForwardRequest extends MessageMicro<faceproto$ForwardRequest> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField client_ip;
    public faceproto$Request face_request;
    public final PBBytesField guid;
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField client_platform = PBField.initString("");
    public final PBStringField client_version = PBField.initString("");

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"uin", "client_platform", "client_version", "guid", "client_ip", "face_request"}, new Object[]{0L, "", "", byteStringMicro, byteStringMicro, null}, faceproto$ForwardRequest.class);
    }

    public faceproto$ForwardRequest() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.guid = PBField.initBytes(byteStringMicro);
        this.client_ip = PBField.initBytes(byteStringMicro);
        this.face_request = new faceproto$Request();
    }
}
