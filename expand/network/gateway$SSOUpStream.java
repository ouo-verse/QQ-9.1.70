package expand.network;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class gateway$SSOUpStream extends MessageMicro<gateway$SSOUpStream> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"head", "body"}, new Object[]{null, ByteStringMicro.EMPTY}, gateway$SSOUpStream.class);
    public gateway$SSOUpStreamHead head = new gateway$SSOUpStreamHead();
    public final PBBytesField body = PBField.initBytes(ByteStringMicro.EMPTY);
}
