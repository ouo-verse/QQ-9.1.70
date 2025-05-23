package msf.registerproxy;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class register_proxy$SvcResponsePbPullGroupMsgProxy extends MessageMicro<register_proxy$SvcResponsePbPullGroupMsgProxy> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"member_seq", "msg_content"}, new Object[]{0L, ByteStringMicro.EMPTY}, register_proxy$SvcResponsePbPullGroupMsgProxy.class);
    public final PBUInt64Field member_seq = PBField.initUInt64(0);
    public final PBBytesField msg_content = PBField.initBytes(ByteStringMicro.EMPTY);
}
