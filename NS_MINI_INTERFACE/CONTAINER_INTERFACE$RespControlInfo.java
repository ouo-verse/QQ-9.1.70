package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CONTAINER_INTERFACE$RespControlInfo extends MessageMicro<CONTAINER_INTERFACE$RespControlInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"cookies", "interval_reconnect"}, new Object[]{ByteStringMicro.EMPTY, 0}, CONTAINER_INTERFACE$RespControlInfo.class);
    public final PBBytesField cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field interval_reconnect = PBField.initUInt32(0);
}
