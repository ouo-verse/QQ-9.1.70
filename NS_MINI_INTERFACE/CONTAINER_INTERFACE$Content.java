package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CONTAINER_INTERFACE$Content extends MessageMicro<CONTAINER_INTERFACE$Content> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"type", "content"}, new Object[]{1, ByteStringMicro.EMPTY}, CONTAINER_INTERFACE$Content.class);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
}
